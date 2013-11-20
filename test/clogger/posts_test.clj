
(ns clogger.posts-test
  (:require [bond.james :as bond :refer [with-spy]])
  (:use clojure.test
        clogger.posts))

(deftest hi-test
  (testing "that hi gets the output expected"
    (is (= "yeah! hi FROM POSTS!" (hi)))))

