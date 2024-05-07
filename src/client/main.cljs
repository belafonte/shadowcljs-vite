(ns client.main
  (:require
   ["@tanstack/react-query" :refer [QueryClient QueryClientProvider]]
   ["@/i18n.js"]
   [client.routes]
   [uix.core :as uix :refer [$ defui]]
   [uix.dom]))

(defonce query-client (new QueryClient))

(defui app []
  ($ QueryClientProvider {:client query-client}
     ($ client.routes/main)))

(defonce root
  (uix.dom/create-root (js/document.getElementById "app")))

(defn render []
  (uix.dom/render-root ($ app) root))

(defn ^:export init []
  (render))
