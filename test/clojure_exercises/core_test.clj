(ns clojure-exercises.core-test
  (:require [clojure.test :refer :all]
            [clojure-exercises.core :refer :all]))



(deftest acceptance-mapset
  (testing "mapset returns a map"
    (is (= (mapset identity [1 2 2]) #{1 2}))
    (is (= (mapset inc [1 2 2]) #{2 3}))
    )
  )

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])


(def asym-alien-body-parts [{:name "head" :size 3}
                            {:name "0-eye" :size 1}
                            {:name "0-ear" :size 1}
                            ])

(deftest acceptance-two-symmetrizer
  (testing "adds one part"
    (is (= (two-symmetrize-body-parts [{:name "left-eye" :size 1}])
           [{:name "left-eye" :size 1} {:name "right-eye" :size 1}])
        )
    )
  (testing "adds all parts"
    (is (= (two-symmetrize-body-parts asym-hobbit-body-parts)
           [{:name "head" :size 3}
            {:name "left-eye" :size 1}
            {:name "right-eye" :size 1}
            {:name "left-ear" :size 1}
            {:name "right-ear" :size 1}
            {:name "mouth" :size 1}
            {:name "nose" :size 1}
            {:name "neck" :size 2}
            {:name "left-shoulder" :size 3}
            {:name "right-shoulder" :size 3}
            {:name "right-upper-arm" :size 3}
            {:name "left-upper-arm" :size 3}
            {:name "chest" :size 10}
            {:name "back" :size 10}
            {:name "left-forearm" :size 3}
            {:name "right-forearm" :size 3}
            {:name "abdomen" :size 6}
            {:name "left-kidney" :size 1}
            {:name "right-kidney" :size 1}
            {:name "left-hand" :size 2}
            {:name "right-hand" :size 2}
            {:name "right-knee" :size 2}
            {:name "left-knee" :size 2}
            {:name "right-thigh" :size 4}
            {:name "left-thigh" :size 4}
            {:name "right-lower-leg" :size 3}
            {:name "left-lower-leg" :size 3}
            {:name "right-achilles" :size 1}
            {:name "left-achilles" :size 1}
            {:name "right-foot" :size 2}
            {:name "left-foot" :size 2}])
        )
    )
  )

(deftest symmetrizer
  (testing " adds 4 parts"
    (is (= (sort-by :name (five-symmetrizer [{:name "0-eye" :size 1}]))
           (sort-by :name [{:name "0-eye" :size 1}
                           {:name "72-eye" :size 1}
                           {:name "144-eye" :size 1}
                           {:name "216-eye" :size 1}
                           {:name "288-eye" :size 1}
                           ]
                    )
           )
        )
    )
  (testing "does not change singles"
    (is (= (sort-by :name (five-symmetrizer [{:name "eye" :size 1}]))
           (sort-by :name [{:name "eye" :size 1}]
                    )
           )
        )
    )
  (testing "does not change singles but adds 4 parts"
    (is (= (sort-by :name (five-symmetrizer [{:name "eye" :size 2}, {:name "0-eye" :size 1}]))
           (sort-by :name [{:name "eye" :size 2}
                           {:name "0-eye" :size 1}
                           {:name "72-eye" :size 1}
                           {:name "144-eye" :size 1}
                           {:name "216-eye" :size 1}
                           {:name "288-eye" :size 1}]
                    )
           )
        )
    )
  )


