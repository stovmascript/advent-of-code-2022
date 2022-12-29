(ns advent-of-code-2022.day-01
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str]))

;; Day 1: Calorie Counting
(defn sum-calories-by-food [food]
  (reduce + (map #(Integer/parseInt %) food)))

(def calories-by-elf
  (->>
   (slurp (io/resource "inputs/day_01"))
   (str/split-lines)
   (partition-by #(= "" %))
   (remove
    (fn [items]
      (and
       (= (count items) 1)
       (= "" (apply str items)))))
   (map sum-calories-by-food)))

(apply max calories-by-elf)

;; Day 1: Calorie Counting, part 2
(reduce + (take-last 3 (sort calories-by-elf)))
