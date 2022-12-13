(ns advent-of-code-2022.core
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str]))

(defn sum-calories-by-food [food]
  (reduce + (map #(Integer/parseInt %) food)))

(def calories-by-elf
  (->>
   (io/resource "inputs/day_01")
   (slurp)
   (str/split-lines)
   (partition-by #(= "" %))
   (remove
    (fn [items]
      (and
       (= (count items) 1)
       (= "" (apply str items)))))
   (map sum-calories-by-food)))

;; day 1, part 1
(apply max calories-by-elf)

;; day 1, part 2
(reduce + (take-last 3 (sort calories-by-elf)))
