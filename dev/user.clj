(ns user)

;; Namespace summary title
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

#_{:clj-kondo/ignore [:redefined-var]}
(comment
  ;; Add-lib library for hot-loading
  (require '[clojure.tools.deps.alpha.repl :refer [add-libs]])
  (add-libs '{domain/library-name {:mvn/version "1.0.0"}})

  #_())


;; Hotload libraries
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(comment
  ;; Add-lib library for hot-loading
  (require '[clojure.tools.deps.alpha.repl :refer [add-libs]])
  (add-libs '{domain/library-name {:mvn/version "1.0.0"}})

  )


;; Portal helpers
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(comment
  (require '[portal.api :as inspect])

  ;; Open Portal with nord theme (default) or specify the theme
  (inspect/open)
  (inspect/open {:portal.colors/theme :portal.colors/solarized-dark})
  (inspect/open {:portal.colors/theme :portal.colors/solarized-light})

  ;; Add portal as a tap> target to send evaluation result
  (inspect/tap)

  ;; Clear all values in the portal inspector window
  (inspect/clear)

  ;; Close the portal window
  (inspect/close)

  ;; NOTE: example of just in time loading of requires at
  ;; https://lambdaisland.com/blog/2019-12-11-advent-of-parens-11-integrant-in-practice

  #_()) ;; End of rich comment block
