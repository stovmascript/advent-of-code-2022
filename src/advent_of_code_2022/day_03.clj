(ns advent-of-code-2022.day-03
  (:require
   [clojure.java.io :as io]
   [clojure.set :as set]
   [clojure.string :as str]))

;; Day 3: Rucksack Reorganization
(def input
  (slurp (io/resource "inputs/day_03")))

(def priorities
  (->>
   (concat (range 97 123) (range 65 91))
   (map char)
   (apply str)))

(->>
 (str/split-lines input)
 (map
  (fn [line]
    (let [c (count line)
          h (/ c 2)]
      (->>
       (set/intersection
        (set (subs line 0 h))
        (set (subs line h c)))
       (apply str)
       (str/index-of priorities)
       (+ 1)))))
 (reduce +))

;; Day 3: Rucksack Reorganization; Part Two
(->>
 (str/split-lines input)
 (partition 3)
 (map
  (fn [elf-group]
    (->>
     (apply
      set/intersection
      (map #(set %) elf-group))
     (apply str)
     (str/index-of priorities)
     (+ 1))))
 (reduce +))
