(ns advent-of-code-2022.day-04
  (:require
   [clojure.java.io :as io]
   [clojure.set :as set]
   [clojure.string :as str]))

;; Day 4: Camp Cleanup
(def input
  (slurp (io/resource "inputs/day_04")))

(def section-sets-by-pair
  (->>
   (str/split-lines input)
   (map
    (fn [line]
      (let [[[p1start p1end] [p2start p2end]]
            (->>
             (str/split line #",")
             (map
              (fn [pair]
                (->>
                 (str/split pair #"-")
                 (map #(Integer/parseInt %))))))]
        [(set (range p1start (+ p1end 1)))
         (set (range p2start (+ p2end 1)))])))))

(->>
 (map
  (fn [[p1 p2]]
    (if
     (or (set/subset? p1 p2)
         (set/superset? p1 p2))
      1 0))
  section-sets-by-pair)
 (reduce +))

;; Day 4: Camp Cleanup; Part Two
(->>
 (map
  (fn [[p1 p2]]
    (if
     (not-empty (set/intersection p1 p2))
      1 0))
  section-sets-by-pair)
 (reduce +))
