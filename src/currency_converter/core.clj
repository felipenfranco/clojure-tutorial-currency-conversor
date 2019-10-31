(ns currency-converter.core
  (:require
   [currency-converter.formatter :refer [format-currency]]
   [currency-converter.options-parser :refer [parse-options]]
   [currency-converter.rate-converter :refer [get-currency-rate]])
  (:gen-class))

(defn -main
  "Currency converter entry point"
  [& args]
  (let [{:keys [from to]} (parse-options args)]
    (-> (get-currency-rate from to)
        (format-currency from to)
        (prn))))
