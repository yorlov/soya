# Bamboo Soy for IntelliJ 🏮🍣🏮

The smartest Intellij plugin for the [Soy templating language](https://github.com/google/closure-templates).

![output](https://user-images.githubusercontent.com/16721021/28110334-f51cae42-66e9-11e7-9ae2-211d3acf12fd.gif)

Adds syntax highlighting, autocompletion and static analysis for your closure template files.

## Feature Summary

Bamboo Soy aims to provide super-fast, no-compromise language support for Soy in IntelliJ.

 * Syntax highlighting with complete HTML support,
 * References, go-to definition, find usage,
 * Structure view,
 * Auto-formatting,
 * Documentation lookup,
 * YCM-style autocompletion (just press <kbd>Ctrl</kbd>-<kbd>Space</kbd> anywhere to get the suggestions)
   * Template and namespace identifiers,
   * Identifiers in scope,
   * Parameters and types,
   * Keywords and literals,
 * Live templates (snippets) for `xid`, `css`, `if-else`, `call`, `delcall`, ...
 * Static analysis inspections for
   * Missing required or invalid parameters,
   * Unused parameters or variables,
   * Wrong usage of double quotes for Soy strings,
 * Understands and preserves doc comment structure on enter,
 * Latest syntax support (`@inject`, `xid` and `css` function expressions, ...),

As a bonus, the parser was designed to support incomplete code constructs &
unbalanced tags (things don’t break when you type).
