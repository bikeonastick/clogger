(ns clogger.core
  (:require [ring.adapter.jetty :as jetty])
  (:use ring.middleware.reload)
  (:require [clogger.posts :as posts]))

(defn hi []
  (posts/hi))

(defn respond-to-other []
  {:status 404})

(defn show-post [uri]
  {:status 200 
   :headers {"Content-Type" "text/plain"} 
   :body (str "here's teh postz for ->" uri)})

(defn test-on-regex [tst]
  (def action  (re-matches #"/([a-z][a-z_]*)/.*" tst) )
  (condp = (action 1)
    "foo" (println "you said foo")
    "show" (println "you said show"))
  )

(defn respond-to-get [uri & more] 
  (def action  (re-matches #"/([a-z][a-z_]*)/.*" uri) )
  (condp = (if (= nil action) "" (action 1))
    "show" (show-post uri)
    (respond-to-other))
  )

(defn handler [request]
  (condp = (:request-method request)
         :get (respond-to-get (:uri request) (:query-string request))
         :head (respond-to-get (:uri request) (:query-string request))
         (respond-to-other)))

(def app
    (wrap-reload #'handler '(clogger.core)))

(defn -main [port]
    (jetty/run-jetty app {:port (Integer. port) :join? false}))
