(ns clojure-exercises.core)

(defn mapset [f coll]
  (set (map f coll))
  )

(defn make-symmetrizer [original replacements]
  (fn [part]
    (reduce (fn [symmetrized-parts
                 replacement]
              ;adds the new part taken from the replacements to the symmetrized parts
              (conj symmetrized-parts {:name (clojure.string/replace (:name part)
                                                                     (re-pattern (apply str [original "-"]))
                                                                     (apply str [replacement "-"]))
                                       :size (:size part)})
              )
            ;initial return value of the returned anonymous function, is filled with reduce
            []
            replacements
            )
    )
  )

(defn any-symmetrize-body-parts [asym-body-parts symmetrizer]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set (conj (symmetrizer part) part))))
          []
          asym-body-parts))
(defn two-symmetrize-body-parts [asym-body-parts]
  (any-symmetrize-body-parts asym-body-parts (make-symmetrizer "left" ["right"]))
  )

(defn five-symmetrizer [asym-body-parts]
  (any-symmetrize-body-parts asym-body-parts (make-symmetrizer "0" ["72" "144" "216" "288"])))


