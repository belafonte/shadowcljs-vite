(ns app.main
  (:require [reagent.core :as r]
            ["react-dom/client" :refer [createRoot]]))

(defonce root (createRoot (js/document.getElementById "app")))

(defn app-view []
  [:div
   [:h1.text-2xl "Tailwind heading"]])

(defn ^:dev/after-load render []
  (.render root (r/as-element [app-view])))

(defn ^:export init []
  (render))
