(ns client.routes.page
  (:require
   ["@@/card" :refer [Card CardContent CardDescription CardHeader CardTitle]]
   ["react-router-dom" :as router]
   ["react-intl" :refer [FormattedMessage]]
   [uix.core :as uix :refer [$ defui]]
   [uix.dom]))

(defui main []
  (let [location (router/useLocation)]
    ($ Card {:className "w-[380px] mt-12"}
       ($ CardHeader
          ($ CardTitle "Page")
          ($ CardDescription "Sample app"))
       ($ CardContent
          ($ :p (str "Current Path: " (.-pathname location)))
          ($ FormattedMessage {:id "app.test" :defaultMessage "Test" :description "Test Translation"})))))
