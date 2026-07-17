(ns association.facts
  "Industry rule/history catalog for CACIF (Comité Coordinador de
  Asociaciones Agrícolas, Comerciales, Industriales y Financieras,
  Guatemala) -- a 73rd industry-association-level source (see
  cloud-itonami-assoc-9411-sau-fsc, -9411-aut-wko, -9411-irl-ibec,
  -9411-nzl-businessnz, -9411-cze-spcr, -9411-ind-cii, -9411-zaf-busa,
  -9411-bra-cni, -9411-ken-kam, -9411-can-chamber, -9411-mex-coparmex,
  -9411-ita-confindustria, -9411-nld-vnoncw, -9411-kor-kcci,
  -9411-arg-uia, -9411-bel-feb, -9411-dnk-di, -9411-swe-sn, -9411-fin-ek,
  -9411-tha-fti, -9411-chl-sofofa, -9411-col-andi, -9411-cri-uccaep,
  -9411-ecu-cip, -9411-egy-fei, -9411-pry-uip, -9411-ury-ciu,
  -9411-pol-lewiatan, -9411-prt-cip, -9411-pan-conep for the first
  thirty) per ADR-2607141700 (cloud-itonami-compliance-fact-
  federation). The THIRTY-FIRST entry aligned to ISIC 9411 (activities
  of business, employers, and professional membership organizations).
  Fills Guatemala's previously-open association-axis gap -- the LAST
  of the 5 countries (GTM/HND/PAN/POL/PRT) that closed their
  municipality-axis gap in ticks 163-167 to reach association-only-
  missing status. Guatemala now has real, individually verified facts
  across ALL THREE axes (country: cloud-itonami-iso3166-gtm
  statute.facts, pre-existing; municipality:
  cloud-itonami-municipality-gtm-guatemala-city, added tick 166;
  association: this entry).

  IMPORTANT SOURCING LIMITATION, documented honestly: cacif.org.gt
  itself returned HTTP 403 Forbidden on every direct WebFetch attempt
  this tick (both '/quienes-somos/' and '/quienes-somos/nuestra-
  historia/'), so its own official history page could NOT be directly
  read. Instead, two INDEPENDENT secondary sources were directly read:
  a Scribd document ('Historia de CACIF') states verbatim 'El CACIF se
  estableció en 1957 como el Comité Coordinador de Asociaciones
  Agrícolas, Comerciales, Industriales y Financieras' (year-only
  precision); and an independent Guatemalan historical-almanac blog
  (biogt.blogspot.com, 'Efemérides Guatemala, Abril') states verbatim
  '24 de Abril de 1961. Fueron aprobados los estatutos del Comité
  Coordinador de Asociaciones Agrícolas, Comerciales, Industriales y
  Financieras (CACIF)' (day-precise). A commonly-repeated claim of a
  '16 January 1957' first-meeting date surfaced only in aggregated
  web-search summaries, never in a page this tick could directly read
  (hoyhistoriagt.org redirected to unrelated content about a New
  Mexico magazine; cacif.org.gt itself is blocked) -- so that specific
  day-level claim is deliberately NOT used in this catalog, matching
  the discipline already applied for Panama's CONEP at tick 170 (only
  independently, directly-read facts are promoted to catalog entries).

  An association not in `catalog` has NO spec-basis, full stop; never
  fabricate one.")

(def catalog
  "association-slug -> vector of association-rule entries."
  {"cacif"
   [{:association-rule/id "cacif.founding-1957"
     :association-rule/title "CACIF (Comité Coordinador de Asociaciones Agrícolas, Comerciales, Industriales y Financieras) established 1957 (cacif.org.gt itself returned HTTP 403; independently corroborated via a Scribd 'Historia de CACIF' document)"
     :association-rule/association "cacif"
     :association-rule/isic "9411"
     :association-rule/country "GTM"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.scribd.com/document/265490718/Historia-de-CACIF"
     :association-rule/url-provenance :scribd-corroborated
     :association-rule/established-date "1957"
     :association-rule/retrieved-at "2026-07-18"
     :association-rule/topic #{:governance}}
    {:association-rule/id "cacif.estatutos-approved-1961-04-24"
     :association-rule/title "CACIF's statutes (estatutos) approved by Governmental Agreement on 24 April 1961"
     :association-rule/association "cacif"
     :association-rule/isic "9411"
     :association-rule/country "GTM"
     :association-rule/kind :governance-program
     :association-rule/url "http://biogt.blogspot.com/2014/04/efemerides-guatemala-abril.html"
     :association-rule/url-provenance :independent-almanac-corroborated
     :association-rule/established-date "1961-04-24"
     :association-rule/retrieved-at "2026-07-18"
     :association-rule/topic #{:governance}}]})

(defn spec-basis [association] (get catalog association))

(defn coverage
  ([] (coverage (keys catalog)))
  ([associations]
   (let [have (filter catalog associations)
         missing (remove catalog associations)]
     {:requested (count associations)
      :covered (count have)
      :covered-associations (vec (sort have))
      :missing-associations (vec (sort missing))
      :note (str "cloud-itonami-assoc-9411-gtm-cacif Wave 0 (ADR-2607141700): "
                 (count (get catalog "cacif")) " CACIF entries seeded "
                 "with independent secondary-source corroboration (cacif.org.gt itself returned "
                 "HTTP 403 on every direct fetch attempt). "
                 "Extend `association.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [association topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis association)))
