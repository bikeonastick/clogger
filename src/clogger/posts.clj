(ns clogger.posts
  (use clj-time.core)
  (use clj-time.format)
  (use clojure.string))

(def post-date-formatter (formatter "yyyyMMddHHmmss"))

(defn hi []
  "yeah! hi FROM POSTS!")

(defn snake-case [to-fix]
  (replace to-fix #"\s" "_"))

(defn snake-and-lower-case [to-fix]
  (snake-case (lower-case to-fix)))

(defn mk-new-filename [title]
 (join "_"[(unparse post-date-formatter(now)) (snake-and-lower-case title)]))
