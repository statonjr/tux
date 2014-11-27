(ns leiningen.new.tux
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "tux"))

(defn tux
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' tux project.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["src/{{sanitized}}/core.cljs" (render "core.cljs" data)]
             ["index.html" (render "index.html" data)]
             [".gitignore" (render "gitignore" data)]
             ["README.md" (render "README.md" data)])))
