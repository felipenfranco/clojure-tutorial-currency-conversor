(ns currency-converter.core
  (:require [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(def cli-options
  [["-t" "--to currency" "Currency to convert to"]
   ["-f" "--from currency" "Base currency to convert from"]])

(defn -main
      "Currency converter entry point"
      [& args]
      (println (:options (parse-opts args cli-options))))