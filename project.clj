(defproject clogger "0.1.0-SNAPSHOT"
  :description "Blogging platform using clojure and markdown"
  :url "https://github.com/bikeonastick/clogger"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [ring "1.2.1"] 
                 [org.clojars.runa/conjure "2.1.3" :scope "test"]
                 [clj-time "0.6.0"]
                 [bond "0.2.5" :scope "test"]]
  :uberjar-name "clogger-mine.jar"
  :main clogger.core)
