(ns client.routes.components.header
  (:require [uix.core :as uix :refer [defui $]]
            [uix.dom]))

(defui main []
  ($ :header {:className "sticky top-0 flex h-12 items-center gap-4 px-4 md:px-6 rounded-lg border"}
     ($ :nav {:className "hidden flex-col gap-6 text-lg font-medium md:flex md:flex-row md:items-center md:gap-5 md:text-sm lg:gap-6"}
        ($ :a {:href "/"} "Home")
        ($ :a {:href "/posts"} "Posts")
        ($ :a {:href "#"} "Settings"))))

;; (defui main []
;;   [:header
;;    {:className "sticky top-0 flex h-16 items-center gap-4 border-b bg-background px-4 md:px-6"}
;;    [:nav
;;     {:className "hidden flex-col gap-6 text-lg font-medium md:flex md:flex-row md:items-center md:gap-5 md:text-sm lg:gap-6"}
;;     [:a
;;      {:href "#"
;;       :className "flex items-center gap-2 text-lg font-semibold md:text-base"}
;;      [:Package2 {:className "h-6 w-6"}]
;;      [:span {:className "sr-only"} "Acme Inc"]]
;;     (for [link ["Home" "Posts"]]
;;       [:a
;;        {:key link
;;         :href "#"
;;         :className "text-muted-foreground transition-colors hover:text-foreground"}
;;        link])
;;     [:a
;;      {:href "#"
;;       :className "text-foreground transition-colors hover:text-foreground"}
;;      "Settings"]]])

