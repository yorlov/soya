import org.jetbrains.intellij.platform.gradle.TestFrameworkType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_1
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.intellij.platform") version "2.9.0"
    id("org.jetbrains.kotlin.jvm") version "2.2.20"
    id("org.jetbrains.grammarkit") version "2022.3.2.2"
}

repositories {
    mavenCentral()

    intellijPlatform {
        defaultRepositories()
    }
}

intellijPlatform {
    pluginConfiguration {
        ideaVersion {
            sinceBuild.set("252")
            untilBuild.set("253.*")
        }
    }

    pluginVerification {
        ides {
            ides(listOf("IU-2025.2"))
        }
    }
}

kotlin {
    jvmToolchain(21)
    compilerOptions {
        jvmTarget = JVM_21
        apiVersion = KOTLIN_2_1
    }
}

sourceSets {
    main {
        java.srcDir("gen")
        kotlin.srcDir("gen")
    }
    test {
        java.srcDir("src/test/java")
    }
}

tasks {
    buildSearchableOptions {
        enabled = false
    }

    generateLexer {
        sourceFile.set(file("src/main/grammars/Soy.flex"))
        targetOutputDir.set(file("gen/com/google/bamboo/soy/lexer"))
        purgeOldFiles.set(true)
    }
    generateParser {
        sourceFile.set(file("src/main/grammars/Soy.bnf"))
        targetRootOutputDir.set(file("gen"))
        pathToParser.set("com/google/bamboo/soy/parser/SoyParser.java")
        pathToPsiRoot.set("com/google/bamboo/soy/parser")
        purgeOldFiles.set(true)
    }
    withType<KotlinCompile> {
        dependsOn(generateLexer, generateParser)
    }
}

dependencies {
    intellijPlatform {
        intellijIdeaUltimate("LATEST-EAP-SNAPSHOT", false)
        testFramework(TestFrameworkType.Platform)
        pluginVerifier()
    }
    testImplementation("junit:junit:4.13.2")
}
