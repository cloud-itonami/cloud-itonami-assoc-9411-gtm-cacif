# cloud-itonami-assoc-9411-gtm-cacif

Industry rule/history catalog for **CACIF** (Comité Coordinador de
Asociaciones Agrícolas, Comerciales, Industriales y Financieras,
Guatemala) — the THIRTY-FIRST entry aligned to **ISIC 9411** (activities
of business, employers, and professional membership organizations),
alongside
[`-9411-pan-conep`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-pan-conep)
(Panama),
[`-9411-prt-cip`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-prt-cip)
(Portugal), and 29 other national industry/employers associations.
Part of the [`cloud-itonami`](https://github.com/cloud-itonami)
compliance-fact family (ADR-2607141700,
`cloud-itonami-compliance-fact-federation`, in `com-junkawasaki/root`).

Fills the **last** of the 5 countries (GTM/HND/PAN/POL/PRT) that
closed their municipality-axis gap in ticks 163-167 to reach
association-only-missing status. Guatemala now has real, individually
verified facts across **all three axes** (country, municipality,
association).

## Sourcing limitation (documented honestly)

`cacif.org.gt` itself returned **HTTP 403 Forbidden** on every direct
fetch attempt this tick (both `/quienes-somos/` and
`/quienes-somos/nuestra-historia/`), so its own official history page
could not be directly read. Instead, two independent secondary
sources were directly read: a Scribd document ("Historia de CACIF")
confirms a 1957 founding (year-only precision), and an independent
Guatemalan historical-almanac blog confirms CACIF's statutes were
approved by Governmental Agreement on 24 April 1961 (day-precise). A
commonly-repeated claim of a "16 January 1957" first-meeting date
surfaced only in aggregated web-search summaries, never in a page
this tick could directly read, so that specific claim is deliberately
excluded from this catalog.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on CACIF's behalf.

Coverage is reported honestly (see `association.facts/coverage`): an
association not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/association/facts.cljc` — the catalog, source of truth.
- `schema/association-rule.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention).
