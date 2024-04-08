(ns client.main
  (:require
   [uix.core :as uix :refer [defui $]]
   [uix.dom]
   ["@@/button" :refer [Button]]
   ["@@/calendar" :refer [Calendar]]))

(defui app []
  ($ :div
     ($ Button {:on-click #(js/alert "You Clicked")} "Click Me")
     ($ Calendar)))

(defonce root
  (uix.dom/create-root (js/document.getElementById "app")))

(defn render []
  (uix.dom/render-root ($ app) root))

(defn ^:export init []
  (render))
