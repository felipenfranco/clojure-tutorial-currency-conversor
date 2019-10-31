(ns currency-converter.options-parser
  (:require [clojure.tools.cli :refer [parse-opts]]))

(def cli-options
  [["-t" "--to currency" "Currency to convert to"]
   ["-f" "--from currency" "Base currency to convert from"]])

(defn parse-options [args]
  (:options (parse-opts args cli-options)))
