(ns client.routes.page
  (:require
   ["@@/card" :refer [Card CardContent CardDescription CardHeader CardTitle]]
   ["react-router-dom" :as router]
   ["react-i18next" :as i18next :refer [useTranslation]]
   [uix.core :as uix :refer [$ defui]]
   [uix.dom]))

(defui main []
  (let [location (router/useLocation)
        [t  i18n] (useTranslation)]
    ($ Card {:className "w-[380px] mt-12"}
       ($ CardHeader
          ($ CardTitle "Page")
          ($ CardDescription "Sample app"))
       ($ CardContent
          ($ :p (str "Translation: " (t "title")))
          ($ :p (str "Current Path: " (.-pathname location)))))))
