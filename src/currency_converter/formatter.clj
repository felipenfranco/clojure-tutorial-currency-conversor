(ns currency-converter.formatter)

(defn format-currency [rate from_currency to_currency]
  (str "1 " from_currency " is " rate " " to_currency))
