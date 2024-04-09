(ns client.routes.page
  (:require
   [uix.core :as uix :refer [defui $]]
   [uix.dom]
   ["react-router-dom" :as router]))

(defui main []
  (let [location (router/useLocation)]
    ($ :div
       ($ :h1 "Home")
       ($ :p (str "Current Path: " (.-pathname location))))))
