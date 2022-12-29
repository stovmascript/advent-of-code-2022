(ns advent-of-code-2022.day-02
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str]))

;; Day 2: Rock Paper Scissors
(def input
  (slurp (io/resource "inputs/day_02")))

(def shapes-to-outcome
  {"A X" 4
   "A Y" 8
   "A Z" 3
   "B X" 1
   "B Y" 5
   "B Z" 9
   "C X" 7
   "C Y" 2
   "C Z" 6})

(defn score
  ([] (score input))
  ([input]
   (->>
    (str/split-lines input)
    (map
     (fn [round]
       (let [shapes round]
         (shapes-to-outcome (str shapes)))))
    (reduce +))))

(score)

;; Day 2: Rock Paper Scissors, part 2
(def shape-to-outcome
  {"A" 1 "B" 2 "C" 3
   "X" 0 ; loss
   "Y" 3 ; draw
   "Z" 6 ; win
   })

(def strategy
  {"A" {"X" "C"
        "Y" "A"
        "Z" "B"}
   "B" {"X" "A"
        "Y" "B"
        "Z" "C"}
   "C" {"X" "B"
        "Y" "C"
        "Z" "A"}})

(->>
 (str/split-lines input)
 (map
  (fn [round]
    (let [[p1 p2] (str/split round #" ")
          o2 ((strategy (str p1)) (str p2))]
      (+
       (shape-to-outcome (str p2))
       (shape-to-outcome (str o2))))))
 (reduce +))
