
(ns clogger.posts-test
  (:require [bond.james :as bond :refer [with-spy]])
  (:require [conjure.core])
  (:use clj-time.core)
  (:use clojure.test
        clogger.posts))

(deftest mk-new-filename-test
  (testing "that calls to mk-new-filename get date_title strings" 
    (conjure.core/stubbing  [ clj-time.core/now (date-time 1991 6 15 18 21 00) ]
    (is (= "19910615182100_got_married" (mk-new-filename "Got Married"))))))

(deftest hi-test
  (testing "that hi gets the output expected"
    (is (= "yeah! hi FROM POSTS!" (hi)))))

(deftest snake-and-lower-case-test
  (testing "that snake-and-lower-case calls get downcased and snakecase"
    (is (= "got_married" (snake-and-lower-case "Got Married")))))

(deftest snake-case-test
  (testing "that snake-case calls get snakecased"
    (is (= "Got_Married" (snake-case "Got Married"))))
  (testing "that snake-case calls with multiple spaces get multiple underscores"
    (is (= "Got__Married" (snake-case "Got  Married")))))
