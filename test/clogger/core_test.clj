(ns clogger.core-test
  (:require [bond.james :as bond :refer [with-spy]])
  (:use clojure.test
        clogger.core))

(deftest respond-to-show-get-test
  (testing "that calls with 'show' in the uri are routed to the show function" 
    (with-spy [show-post]
      (respond-to-get "/show/foo" "more")
    (is (= 1 (-> show-post bond/calls count)))))
  (testing "that calls starting with 'foo' in the uri are routed to the respond-to-other function" 
    (with-spy [respond-to-other]
      (respond-to-get "/foo/show" "more")
    (is (= 1 (-> respond-to-other bond/calls count)))))
  (testing "that calls starting with non matching patterns in the uri are routed to the respond-to-other function" 
    (with-spy [respond-to-other]
      (respond-to-get "/blerg" "more")
    (is (= 1 (-> respond-to-other bond/calls count))))))
(deftest hi-test
  (testing "that hi gets the output expected"
    (is (= "yeah! hi FROM POSTS!" (hi)))))

