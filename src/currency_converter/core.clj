(ns currency-converter.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clj-http.client :as http-client]
            [cheshire.core :refer [parse-string]])
  (:gen-class))

(def cli-options
  [["-t" "--to currency" "Currency to convert to"]
   ["-f" "--from currency" "Base currency to convert from"]])

(def api-key (System/getenv "API_KEY"))
(def api-url "https://free.currencyconverterapi.com/api/v6/convert")

(defn- to-currency-param [from to]
  (let [from (clojure.string/upper-case from)
        to (clojure.string/upper-case to)]
    (str from "_" to)))

(defn- get-currency-json [currency-conversion-key]
  (parse-string (:body (http-client/get api-url
                                        {:query-params
                                         {"q" currency-conversion-key
                                          "apiKey" api-key}}))))

(defn- get-currency-rate [from to]
  (let [currency-conversion-key (to-currency-param from to)]
    (-> (get-currency-json currency-conversion-key)
        (get-in ["results" currency-conversion-key "val"]))))

(defn -main
  "Currency converter entry point"
  [& args]
  (let [{:keys [from to]} (:options (parse-opts args cli-options))]
    (prn (get-currency-rate from to))))
