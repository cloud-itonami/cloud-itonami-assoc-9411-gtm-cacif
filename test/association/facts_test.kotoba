(ns association.facts-test
  (:require [kotoba.lang.text :as str]
            [clojure.test :refer [deftest is testing]]
            [association.facts :as facts]))

(def ^:private entries (facts/spec-basis "cacif"))

(deftest cacif-has-spec-basis
  (is (= 17 (count entries)))
  (is (every? #(str/starts-with? (:association-rule/url %) "http") entries))
  (is (every? #(= "9411" (:association-rule/isic %)) entries))
  (is (every? #(= "GTM" (:association-rule/country %)) entries)))

(deftest every-entry-is-individually-identified-and-cited
  ;; A catalog whose ids collide silently loses an entry the moment anything
  ;; indexes it by id; a catalog that reuses one url for everything is one
  ;; citation wearing seventeen hats.
  (is (= (count entries) (count (distinct (map :association-rule/id entries)))))
  (is (every? #(str/starts-with? (:association-rule/id %) "cacif.") entries))
  (is (every? :association-rule/retrieved-at entries))
  (is (every? :association-rule/title entries))
  (is (every? #(seq (:association-rule/topic %)) entries))
  (is (= 12 (count (distinct (map :association-rule/url entries))))))

(deftest an-official-citation-names-the-site-it-claims
  ;; `:official-cacif-org-gt` is a claim about WHERE the fact was read. An entry
  ;; carrying that provenance while pointing somewhere else is the failure the
  ;; provenance field exists to make impossible, and it reads as clean.
  (doseq [e entries]
    (when (str/starts-with? (name (:association-rule/url-provenance e)) "official-cacif-org-gt")
      (testing (:association-rule/id e)
        (is (str/starts-with? (:association-rule/url e) "https://cacif.org.gt/")))))
  ;; and the converse: nothing on cacif.org.gt may be filed as third-party
  ;; corroboration, which would let the association corroborate itself.
  (doseq [e entries]
    (when (str/includes? (:association-rule/url e) "cacif.org.gt")
      (testing (:association-rule/id e)
        (is (str/starts-with? (name (:association-rule/url-provenance e)) "official-"))))))

(deftest the-two-secondary-sources-were-kept-when-the-primary-site-opened
  ;; This catalog was seeded on 2026-07-18 from two independent documents,
  ;; because cacif.org.gt answered 403 that day. On 2026-09-10 it answered 200.
  ;; Replacing the secondary sources with the association's own page would raise
  ;; the provenance tier of every claim and quietly destroy the only reason the
  ;; 1957 and 1961 dates are not held on CACIF's word alone.
  (let [by-id (into {} (map (juxt :association-rule/id identity) entries))
        scribd (by-id "cacif.founding-1957-scribd-corroboration")
        almanac (by-id "cacif.estatutos-1961-04-24-almanac-corroboration")]
    (is (some? scribd))
    (is (some? almanac))
    (is (= "2026-07-18" (:association-rule/retrieved-at scribd)))
    (is (= "2026-07-18" (:association-rule/retrieved-at almanac)))
    (is (not (str/includes? (:association-rule/url scribd) "cacif.org.gt")))
    (is (not (str/includes? (:association-rule/url almanac) "cacif.org.gt")))
    ;; each corroborates a claim the official catalog also makes, at its own date
    ;; precision -- the almanac is day-precise, the Scribd document year-only.
    (is (= "1961-04-24" (:association-rule/established-date almanac)))
    (is (= "1961-04-24" (:association-rule/established-date
                         (by-id "cacif.estatutos-approved-1961-04-24"))))
    (is (= "1957" (:association-rule/established-date scribd)))
    (is (= "1957-01-16" (:association-rule/established-date
                         (by-id "cacif.founding-1957")))
        "the official page is day-precise where the secondary document is not")))

(deftest the-2009-reform-keeps-both-months-cacif-publishes
  ;; CACIF's history page dates the directorio's approval of the 2009 statutory
  ;; reform to October 2009; its fundamental-principles page dates the reform
  ;; that ratified the three principles to November 2009. Recording one month
  ;; and dropping the other would look tidier and would be a fabricated
  ;; agreement between two pages that do not agree.
  (let [by-id (into {} (map (juxt :association-rule/id identity) entries))
        hist (by-id "cacif.reforma-estatutaria-2009")
        prin (by-id "cacif.principios-fundamentales")]
    (is (= "2009-10" (:association-rule/last-revised-date hist)))
    (is (= "2009-11" (:association-rule/last-revised-date prin)))
    (is (not= (:association-rule/url hist) (:association-rule/url prin))
        "the disagreement is only evidence if the two pages are cited separately")
    (is (= :official-cacif-org-gt-conflicting (:association-rule/url-provenance hist))
        "and the conflicting page must not be filed as a clean official citation")))

(deftest unknown-association-has-no-spec-basis
  (is (nil? (facts/spec-basis "aggg")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["cacif" "aggg"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["aggg"] (:missing-associations c)))))

(deftest the-note-counts-what-the-catalog-actually-holds
  ;; The note is computed, so it moves when the catalog does. Asserting the
  ;; numbers rather than the sentence keeps this from being a spellcheck.
  (let [note (facts/note-for "cacif")]
    (is (str/includes? note (str (count entries) " CACIF entries")))
    (is (str/includes? note "14 read directly from cacif.org.gt"))
    (is (str/includes? note "2 from an independent secondary document"))
    (is (str/includes? note "1 where cacif.org.gt contradicts itself"))))

(deftest by-topic-filters
  (doseq [[topic n] {:governance 14 :history 5 :statute 4 :membership 2
                     :labor 1 :board 1 :contact 1}]
    (testing (name topic)
      (is (= n (count (facts/by-topic "cacif" topic))))))
  (is (empty? (facts/by-topic "cacif" :no-such-topic)))
  (is (empty? (facts/by-topic "aggg" :governance))))
