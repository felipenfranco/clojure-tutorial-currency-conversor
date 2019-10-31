# currency-converter

CLI tool made in Clojure to get the current conversion rate between two currencies.
Uses https://free.currencyconverterapi.com/ to fetch the currency rates.

## Instalation
You need clojure and leiningen installed to run this project

## Usage

First you need an API KEY to access the API.
You can get one for free at: https://free.currencyconverterapi.com/free-api-key

With the API KEY at hand, usage is very simple.

On the root of the project:

    >$ API_KEY=<enter your key here> lein run --from=USD --to=BRL

This will give you the factor you need to multiply the amount in USD to get the respective amount in BRL.
