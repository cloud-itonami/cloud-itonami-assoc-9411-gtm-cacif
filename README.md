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

## Sourcing

**17 entries, 12 distinct sources.** 14 were read directly from
`cacif.org.gt` on 2026-09-10; 2 are independent secondary documents; 1
records a place where `cacif.org.gt` contradicts itself.

The interesting part is that this used to read differently. When this
catalog was seeded on 2026-07-18, **`cacif.org.gt` answered HTTP 403 to
every direct fetch**, so CACIF's own history page could not be read and
the catalog held two entries, both resting on independent secondary
documents. On 2026-09-10 the same host answered **200**, every page
below was read directly, and the catalog grew to 17.

Two consequences worth stating plainly:

- **A claim that was correctly excluded is now correctly included.** The
  seeding tick refused a widely repeated "16 January 1957" first-meeting
  date because it appeared only in aggregated search summaries and never
  in a page that tick could read. CACIF's own history page states it, so
  it is in the catalog now — admitted for the same reason it was
  refused, which is that somebody read the page.
- **The two secondary sources were kept, not replaced.** Upgrading every
  claim to the association's own page would have read as a tidier
  catalog and would have thrown away the only reason the 1957 and 1961
  dates are not held on CACIF's word alone. `association.facts-test`
  asserts they are still there.

### Where cacif.org.gt disagrees with itself

The [history page](https://cacif.org.gt/quienes-somos/nuestra-historia/)
dates the directorio's approval of the 2009 statutory reform to
**October 2009**. The [fundamental-principles
page](https://cacif.org.gt/quienes-somos/principios-fundamentales/)
dates the reform that ratified the three principles to **November
2009**. Both are recorded, each against the page that says it, and the
first carries `:url-provenance :official-cacif-org-gt-conflicting` so it
is never counted as a clean official citation.

### Checking the citations are still alive

Nothing in the offline suite can tell a live citation from a dead one —
both are strings starting with `http`. That check is a separate tool,
kept out of the test suite so the suite does not fail for reasons
unrelated to the change under test:

```bash
nbb tools/verify_urls.cljs     # 0 = all 2xx, 1 = a dead url, 2 = REFUSED
```

Exit **2** is the point of it: an empty catalog, or a url that could not
be measured at all, must not return the same value as a catalog whose
citations were checked and were fine.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on CACIF's behalf.

Coverage is reported honestly (see `association.facts/note-for`, which
is computed from the catalog rather than written beside it): an
association not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/association/facts.cljc` — the catalog, hand-authored, source of truth.
- `data/datascript-tx.edn` — the same catalog as DataScript tx-data (query it
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).
- `src/association_facts.kotoba` — **generated** by `tools/gen_kotoba.cljs` from
  the `.edn`; reaches the Kotoba oracle, wasm and both native ISAs. Do not edit
  by hand, regenerate: `nbb tools/gen_kotoba.cljs`.
- `schema/association-rule.edn` — DataScript schema.

`test/association_facts_kotoba_parity_test.clj` compares every field of every
entry across the hand-authored `.cljc` and the generated `.kotoba`. That the two
are produced independently is the only reason comparing them means anything —
do not "simplify" it by generating both from one source.

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention).
