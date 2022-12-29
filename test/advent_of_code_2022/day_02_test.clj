(ns advent-of-code-2022.day-02-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2022.day-02 :refer :all]))

(deftest test-score
  (is
   (= (score "A X")
      (shapes-to-outcome (str "A X"))))
  (is
   (= (score "A Y")
      (shapes-to-outcome (str "A Y"))))
  (is
   (= (score "A Z")
      (shapes-to-outcome (str "A Z"))))
  (is
   (= (score "B X")
      (shapes-to-outcome (str "B X"))))
  (is
   (= (score "B Y")
      (shapes-to-outcome (str "B Y"))))
  (is
   (= (score "B Z")
      (shapes-to-outcome (str "B Z"))))
  (is
   (= (score "C X")
      (shapes-to-outcome (str "C X"))))
  (is
   (= (score "C Y")
      (shapes-to-outcome (str "C Y"))))
  (is
   (= (score "C Z")
      (shapes-to-outcome (str "C Z")))))

(test-score)
