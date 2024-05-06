(ns client.main
  (:require
   ["@tanstack/react-query" :refer [QueryClient QueryClientProvider]]
   ["react-intl" :refer [IntlProvider]]
   ["@/lang/de.json" :as de]
   [client.routes]
   [uix.core :as uix :refer [$ defui]]
   [uix.dom]))

(defonce query-client (new QueryClient))

(defui app []
  ($ IntlProvider {:locale "de" :defaultLocale "en" :messages de}
     ($ QueryClientProvider {:client query-client}
        ($ client.routes/main))))

(defonce root
  (uix.dom/create-root (js/document.getElementById "app")))

(defn render []
  (uix.dom/render-root ($ app) root))

(defn ^:export init []
  (render))
