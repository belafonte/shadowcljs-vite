(ns app.page
  (:require [reagent.core :as r]
            ["react-dom/client" :refer [createRoot]]
            [react :as react]
            ["@tanstack/react-query" :as react-query]
            ["../components/ui/button.js" :as button]))
            ;; [app.routes :as routes]))

(defonce root (createRoot (js/document.getElementById "app")))
(defonce query-client (new react-query/QueryClient))

;; This is used with :f> so both Hooks and RAtoms work here
(defn example []
  (let [[count set-count] (react/useState 0)]
        ;; [result (react-query/useQuery #js {:queryKey (into-array "todo")
        ;;                                    :queryFn (fn [] (js/Promise.resolve #js [{:id 1 :title "Do the thing"}]))})]]

    [:div
     [:p "You clicked " count " times"]
     [:button
      {:on-click #(set-count inc)}
      "Click"]]))

(defn app-view []
  [:> react-query/QueryClientProvider {:client query-client}
   [:div
    [:h1.text-2xl.text-amber-500 "Tailwind heading"]
    [:> button/Button {:on-click #(js/alert "Hello")} "Hello Button"]]
   [:f> example]])

(defn ^:dev/after-load render []
  (.render root (r/as-element [app-view])))

(defn ^:export init []
  (render))
