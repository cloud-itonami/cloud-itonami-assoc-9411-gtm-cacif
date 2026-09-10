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

  SOURCING, and how it changed. This catalog was seeded on 2026-07-18
  with two entries and no primary source: cacif.org.gt answered HTTP 403
  to every direct fetch that day, so the association's own history could
  not be read and two independent secondary documents were used instead.
  On 2026-09-10 cacif.org.gt answered 200, and every page named by a
  `:official-cacif-org-gt` entry below was read directly. The two
  secondary entries were NOT dropped when the primary source opened --
  an independent document that agrees with an association's own history
  is worth more than either alone, and they are the reason the 1957 and
  1961 dates were never taken on the association's word alone.

  Provenance tiers, in the order `provenance-tier` tests them:

    :conflicting   `official-cacif-org-gt-conflicting` -- CACIF's own
                   site says two different things. Tested FIRST, because
                   this string also starts with `official-`.
    :corroborated  an independent secondary document.
    :official      read directly from cacif.org.gt.

  One entry is on the :conflicting tier. CACIF's history page dates the
  directorio's approval of the 2009 statutory reform to October 2009,
  while its fundamental-principles page dates the reform that ratified
  the three principles to November 2009. Both readings are recorded
  rather than one being silently chosen.

  A claim of a '16 January 1957' first meeting was deliberately EXCLUDED
  at seeding time, because it appeared only in aggregated search
  summaries and never in a page that tick could read. It is in the
  catalog now for the opposite reason: CACIF's own history page states
  it, and that page was read directly.

  An association not in `catalog` has NO spec-basis, full stop; never
  fabricate one.")

(def catalog
  "association-slug -> vector of association-rule entries."
  {"cacif"
   [{:association-rule/id "cacif.founding-1957"
     :association-rule/title "CACIF's first meeting was held on 16 January 1957 at the head office of the Camara de Industria de Guatemala, led by Enrique C. Novella, Enrique Matheu, Julio Briz, Virgilio Garcia Valle and Gabriel Fernandez"
     :association-rule/association "cacif"
     :association-rule/isic "9411"
     :association-rule/country "GTM"
     :association-rule/kind :constitutive-instrument
     :association-rule/url "https://cacif.org.gt/quienes-somos/nuestra-historia/"
     :association-rule/url-provenance :official-cacif-org-gt
     :association-rule/established-date "1957-01-16"
     :association-rule/retrieved-at "2026-09-10"
     :association-rule/topic #{:governance :history}}
    {:association-rule/id "cacif.founding-1957-scribd-corroboration"
     :association-rule/title "Independent corroboration of the 1957 founding year: a 'Historia de CACIF' document states CACIF was established in 1957 (year-only precision)"
     :association-rule/association "cacif"
     :association-rule/isic "9411"
     :association-rule/country "GTM"
     :association-rule/kind :constitutive-instrument
     :association-rule/url "https://www.scribd.com/document/265490718/Historia-de-CACIF"
     :association-rule/url-provenance :scribd-corroborated
     :association-rule/established-date "1957"
     :association-rule/retrieved-at "2026-07-18"
     :association-rule/topic #{:history}}
    {:association-rule/id "cacif.constituted-1959"
     :association-rule/title "CACIF was definitively constituted from 1959, when it was installed in the Camara de Industria de Guatemala building at 3a Avenida 12-22, zona 1"
     :association-rule/association "cacif"
     :association-rule/isic "9411"
     :association-rule/country "GTM"
     :association-rule/kind :constitutive-instrument
     :association-rule/url "https://cacif.org.gt/quienes-somos/nuestra-historia/"
     :association-rule/url-provenance :official-cacif-org-gt
     :association-rule/established-date "1959"
     :association-rule/retrieved-at "2026-09-10"
     :association-rule/topic #{:governance :history}}
    {:association-rule/id "cacif.estatutos-approved-1961-04-24"
     :association-rule/title "CACIF's statutes (estatutos) were approved by Acuerdo Gubernativo dated 24 April 1961"
     :association-rule/association "cacif"
     :association-rule/isic "9411"
     :association-rule/country "GTM"
     :association-rule/kind :statute
     :association-rule/url "https://cacif.org.gt/quienes-somos/nuestra-historia/"
     :association-rule/url-provenance :official-cacif-org-gt
     :association-rule/established-date "1961-04-24"
     :association-rule/retrieved-at "2026-09-10"
     :association-rule/topic #{:governance :statute}}
    {:association-rule/id "cacif.estatutos-1961-04-24-almanac-corroboration"
     :association-rule/title "Independent corroboration of the 1961 statutes: a Guatemalan historical almanac records that the statutes were approved by Acuerdo Gubernativo on 24 April 1961"
     :association-rule/association "cacif"
     :association-rule/isic "9411"
     :association-rule/country "GTM"
     :association-rule/kind :statute
     :association-rule/url "http://biogt.blogspot.com/2014/04/efemerides-guatemala-abril.html"
     :association-rule/url-provenance :independent-almanac-corroborated
     :association-rule/established-date "1961-04-24"
     :association-rule/retrieved-at "2026-07-18"
     :association-rule/topic #{:statute}}
    {:association-rule/id "cacif.president-habie-assassinated-1980-05-23"
     :association-rule/title "Alberto Habie Mishaan, CACIF's sitting president, was assassinated on 23 May 1980; former presidents Roberto Castaneda and Jose Villaverde were also killed that decade"
     :association-rule/association "cacif"
     :association-rule/isic "9411"
     :association-rule/country "GTM"
     :association-rule/kind :governance-program
     :association-rule/url "https://cacif.org.gt/quienes-somos/nuestra-historia/"
     :association-rule/url-provenance :official-cacif-org-gt
     :association-rule/established-date "1980-05-23"
     :association-rule/retrieved-at "2026-09-10"
     :association-rule/topic #{:governance :history}}
    {:association-rule/id "cacif.paro-nacional-2001-08-01"
     :association-rule/title "CACIF coordinated the 1 August 2001 national strike known as 'El Dia de la Dignidad', which it reports closed more than 90% of productive activity and out of which Foro Guatemala was founded"
     :association-rule/association "cacif"
     :association-rule/isic "9411"
     :association-rule/country "GTM"
     :association-rule/kind :governance-program
     :association-rule/url "https://cacif.org.gt/quienes-somos/nuestra-historia/"
     :association-rule/url-provenance :official-cacif-org-gt
     :association-rule/established-date "2001-08-01"
     :association-rule/retrieved-at "2026-09-10"
     :association-rule/topic #{:governance :history}}
    {:association-rule/id "cacif.reforma-estatutaria-2009"
     :association-rule/title "CACIF's own site dates its 2009 statutory reform two ways: the history page puts the directorio's approval in October 2009, the fundamental-principles page dates the reform that ratified the three principles to November 2009"
     :association-rule/association "cacif"
     :association-rule/isic "9411"
     :association-rule/country "GTM"
     :association-rule/kind :statute
     :association-rule/url "https://cacif.org.gt/quienes-somos/nuestra-historia/"
     :association-rule/url-provenance :official-cacif-org-gt-conflicting
     :association-rule/established-date "2009"
     :association-rule/last-revised-date "2009-10"
     :association-rule/retrieved-at "2026-09-10"
     :association-rule/topic #{:governance :statute}}
    {:association-rule/id "cacif.principios-fundamentales"
     :association-rule/title "The three fundamental principles CACIF was founded on in 1957 -- the general interest prevails over the particular; free enterprise is the best means to national economic and social progress; harmony of interests rests on strict observance of legal and constitutional norms -- ratified in the November 2009 statutory reform"
     :association-rule/association "cacif"
     :association-rule/isic "9411"
     :association-rule/country "GTM"
     :association-rule/kind :governance-program
     :association-rule/url "https://cacif.org.gt/quienes-somos/principios-fundamentales/"
     :association-rule/url-provenance :official-cacif-org-gt
     :association-rule/established-date "1957"
     :association-rule/last-revised-date "2009-11"
     :association-rule/retrieved-at "2026-09-10"
     :association-rule/topic #{:governance :statute}}
    {:association-rule/id "cacif.mision-vision"
     :association-rule/title "Mission and vision: CACIF represents the organised private sector and coordinates proposals for free enterprise, private property and the rule of law; its stated vision is that Guatemala reach the top 60 of the Global Competitiveness Index within ten years"
     :association-rule/association "cacif"
     :association-rule/isic "9411"
     :association-rule/country "GTM"
     :association-rule/kind :governance-program
     :association-rule/url "https://cacif.org.gt/quienes-somos/"
     :association-rule/url-provenance :official-cacif-org-gt
     :association-rule/retrieved-at "2026-09-10"
     :association-rule/topic #{:governance}}
    {:association-rule/id "cacif.cle-mandated-2020-12"
     :association-rule/title "The Centro de Liderazgo Empresarial (CLE) was mandated by the Plan Estrategico signed by CACIF's Directorio in December 2020, to train national trade-association leadership"
     :association-rule/association "cacif"
     :association-rule/isic "9411"
     :association-rule/country "GTM"
     :association-rule/kind :governance-program
     :association-rule/url "https://cacif.org.gt/cle/"
     :association-rule/url-provenance :official-cacif-org-gt
     :association-rule/established-date "2020-12"
     :association-rule/retrieved-at "2026-09-10"
     :association-rule/topic #{:governance}}
    {:association-rule/id "cacif.gan-guatemala-2018"
     :association-rule/title "CACIF leads GAN Guatemala, the national chapter of the Global Apprenticeship Network; the public-private initiative was formed in 2018"
     :association-rule/association "cacif"
     :association-rule/isic "9411"
     :association-rule/country "GTM"
     :association-rule/kind :international-affiliation
     :association-rule/url "https://cacif.org.gt/gan-guatemala/"
     :association-rule/url-provenance :official-cacif-org-gt
     :association-rule/established-date "2018"
     :association-rule/retrieved-at "2026-09-10"
     :association-rule/topic #{:governance :labor}}
    {:association-rule/id "cacif.proe-since-2003"
     :association-rule/title "The Programa de Observacion Electoral (PROE) is CACIF's electoral-observation programme; its first participation was the 2003 electoral process and the page reports experience across 5 general elections and one popular consultation"
     :association-rule/association "cacif"
     :association-rule/isic "9411"
     :association-rule/country "GTM"
     :association-rule/kind :governance-program
     :association-rule/url "https://cacif.org.gt/programa-de-observacion-electoral-proe-cacif/"
     :association-rule/url-provenance :official-cacif-org-gt
     :association-rule/established-date "2003"
     :association-rule/retrieved-at "2026-09-10"
     :association-rule/topic #{:governance}}
    {:association-rule/id "cacif.joven-2017"
     :association-rule/title "CACIF Joven is a technical commission created in 2017, made up of business people beginning their trade-association careers; its three projects are legal certainty, GAN Guatemala and Generando Futuro"
     :association-rule/association "cacif"
     :association-rule/isic "9411"
     :association-rule/country "GTM"
     :association-rule/kind :membership
     :association-rule/url "https://cacif.org.gt/quienes-somos/cacif-joven/"
     :association-rule/url-provenance :official-cacif-org-gt
     :association-rule/established-date "2017"
     :association-rule/retrieved-at "2026-09-10"
     :association-rule/topic #{:governance :membership}}
    {:association-rule/id "cacif.mujer-2017"
     :association-rule/title "CACIF Mujer is a commission of businesswomen from across the productive sectors, created in 2017 to drive entrepreneurship support, training, mentoring and business-leadership networks"
     :association-rule/association "cacif"
     :association-rule/isic "9411"
     :association-rule/country "GTM"
     :association-rule/kind :membership
     :association-rule/url "https://cacif.org.gt/quienes-somos/cacif-mujer/"
     :association-rule/url-provenance :official-cacif-org-gt
     :association-rule/established-date "2017"
     :association-rule/retrieved-at "2026-09-10"
     :association-rule/topic #{:governance :membership}}
    {:association-rule/id "cacif.presidency-2026-2027"
     :association-rule/title "Carlos Arias Bouscayrol was elected by CACIF's member chambers to the presidency for the 2026-2027 term, nominated by the Camara Guatemalteca de la Industria de la Construccion (announced 13 April 2026)"
     :association-rule/association "cacif"
     :association-rule/isic "9411"
     :association-rule/country "GTM"
     :association-rule/kind :governance-program
     :association-rule/url "https://cacif.org.gt/nueva-presidencia-en-cacif/"
     :association-rule/url-provenance :official-cacif-org-gt
     :association-rule/established-date "2026-04-13"
     :association-rule/retrieved-at "2026-09-10"
     :association-rule/topic #{:governance :board}}
    {:association-rule/id "cacif.oficinas-ruta-6"
     :association-rule/title "CACIF's offices are on level 9 of the Camara de Industria de Guatemala building, Ruta 6 9-21 zona 4, Guatemala City 01004; telephone (502) 2201-0000"
     :association-rule/association "cacif"
     :association-rule/isic "9411"
     :association-rule/country "GTM"
     :association-rule/kind :governance-program
     :association-rule/url "https://cacif.org.gt/contacto/"
     :association-rule/url-provenance :official-cacif-org-gt
     :association-rule/retrieved-at "2026-09-10"
     :association-rule/topic #{:contact}}]})

(defn spec-basis [association] (get catalog association))

(defn- provenance-tier
  "Which of the tiers in the namespace docstring this entry sits on.

  `:conflicting` is tested BEFORE `^official-`, because the conflicting entry's
  provenance also starts with `official-`. Ordering it the other way would count
  a contradiction as a clean official citation -- which is the one thing the
  tier is here to prevent."
  [entry]
  (let [p (name (:association-rule/url-provenance entry))]
    (cond (re-find #"conflicting$" p)   :conflicting
          (re-find #"corroborated$" p)  :corroborated
          (re-find #"^official-" p)     :official
          :else                         :unknown)))

(defn note-for
  "The coverage note, COMPUTED from the catalog rather than written beside it.

  Written notes drift: a hand-written count stays at the number it was written
  with while entries are added around it. Deriving the counts means adding an
  entry changes this string, and the parity test then requires the port to be
  regenerated with it."
  [association]
  (let [entries (get catalog association)
        n       (count entries)
        tally   (frequencies (map provenance-tier entries))
        cnt     #(get tally % 0)]
    (str "cloud-itonami-assoc-9411-gtm-cacif Wave 0 (ADR-2607141700): "
         n " CACIF entries -- "
         (cnt :official) " read directly from cacif.org.gt, "
         (cnt :corroborated) " from an independent secondary document, "
         (cnt :conflicting) " where cacif.org.gt contradicts itself. "
         "Extend `association.facts/catalog`, never fabricate an id/url.")))

(defn coverage
  ([] (coverage (keys catalog)))
  ([associations]
   (let [have (filter catalog associations)
         missing (remove catalog associations)]
     {:requested (count associations)
      :covered (count have)
      :covered-associations (vec (sort have))
      :missing-associations (vec (sort missing))
      :note (note-for "cacif")})))

(defn by-topic [association topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis association)))
