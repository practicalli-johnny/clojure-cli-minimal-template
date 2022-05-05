# clojure-cli-minimal-template

A minimal Clojure CLI template for REPL driven development from scratch, using practicalli/clojure-deps-edn user level configuration for additional community tools.


## Getting started

`clojure` or `cli` runs a minimal terminal UI REPL in a terminal window.

Start the REPL with one or more of these aliases to provide a rich set of tooling

| Alias            | Description                                                                                                                                                             |
|:-----------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `:env/dev`       | add `dev` directory to class path to include a custom `user` namespace via `dev/user.clj`                                                                               |
| `:env/test`      | add `test` directory to run unit tests in REPL                                                                                                                          |
| `:lib/reloaded`  | [hotload Libraries into a running REPL](https://practical.li/clojure/alternative-tools/clojure-cli/hotload-libraries.html), use `refresh` to remove vars from namespace |
| `inspect/portal` | navigate larger data structures returned as results of function calls                                                                                                   |
| `repl/rebel`     | rich terminal UI REPL client (function args prompt, docs, multi-line editing)                                                                                           |

Put all these aliases together to have a rich set of tools for REPL driven development

```bash
clojure -M:env/dev:lib/reloaded:inpect/portal:repl/rebel
```


## Hotload libraries

Add a rich comment that required the `clojure.tools.deps.alpha.repl` namespace and hotload one or more libraries specified in a hash-map.  Replace http-kit with the name(s) and version(s) of the library to load.

```clojure
(comment
  (require '[clojure.tools.deps.alpha.Repl :refer [add-libs]])
  (add-libs '{http-kit/http-kit {:mvn/version "2.5.1"}})
#_())
```

> `rich-comment-hotload` snippet from Clojure-LSP will create the above code


## Searching for libraries

Fuzzy search Clojars and Maven Central for one or more libraries using the [find-deps tool](https://github.com/hagmonk/find-deps)

`clojure -M:search/libraries name-of-library another-library`


## Inspecting data




## CIDER support

Emacs will read the project `.dir-locals.el` configuration that includes the `:env/test` and `:lib/hotload` as Clojure CLI aliases.  Those aliases will be included when calling `cider-jack-in-clj` automatically.

```elisp
((clojure-mode . ((cider-repl-display-help-banner . nil)
                  (cider-preferred-build-tool     . clojure-cli)
                  (cider-clojure-cli-aliases      . ":env/dev:env/test:lib/reloaded:inpect/portal"))))
```



## deps.edn configuration overview

A minimal `deps.edn` file only needs to include an empty hash-map, `{}`.  The version of Clojure (`org.clojure/clojure dependency`) will be taken from the Clojure CLI installation (or user `deps.edn` if added to its `:deps` key).

Project specific configuration can be added to the `deps.edn`

* `:paths` defines the class path for the project, e.g. `["src" "resources"]`
* `:deps` defines the libraries that are dependencies for the project, e.g. `{org.clojure/clojure {:mvn/version "1.11.1"}}`
* `:aliases` defines aliases that can include paths, dependencies and tools for use during development or continuous integration
* `mvn/repos` defines Maven style package repositories that contain libraries required for the project.  [Maven Central and Clojars are defined in the Clojure CLI install](https://github.com/clojure/tools.deps.alpha/blob/master/src/main/resources/clojure/tools/deps/deps.edn), so do not need to be defined.
