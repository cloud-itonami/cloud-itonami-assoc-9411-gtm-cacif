(ns association.facts-test
  (:require [kotoba.lang.text :as str]
            [clojure.test :refer [deftest is]]
            [association.facts :as facts]))

(deftest cacif-has-spec-basis
  (let [sb (facts/spec-basis "cacif")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:association-rule/url %) "http") sb))
    (is (every? #(= "9411" (:association-rule/isic %)) sb))
    (is (every? #(= "GTM" (:association-rule/country %)) sb))))

(deftest unknown-association-has-no-spec-basis
  (is (nil? (facts/spec-basis "aggg")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["cacif" "aggg"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["aggg"] (:missing-associations c)))))

(deftest by-topic-filters
  (is (= 2 (count (facts/by-topic "cacif" :governance))))
  (is (empty? (facts/by-topic "cacif" :labor)))
  (is (empty? (facts/by-topic "aggg" :governance))))
