(defproject clogger "0.1.0-SNAPSHOT"
  :description "Blogging platform using clojure and markdown"
  :url "https://github.com/bikeonastick/clogger"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [ring "1.2.1"] 
                 [bond "0.2.5"]]
  :uberjar-name "clogger-mine.jar"
  :main clogger.core)
