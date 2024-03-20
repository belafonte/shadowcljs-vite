(ns app.page
  (:require [reagent.core :as r]
            ["react-dom/client" :refer [createRoot]]
            [react :as react]
            ["@tanstack/react-query" :as react-query]
            [app.routes :as routes]
            [flowbite-react :as fb :refer [Button]]))

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
   [:div {:className "flex flex-col items-center justify-center h-screen"}
    [:h1.text-2xl.text-amber-500.mb-5 "Tailwind heading"]
    [:div {:className "w-1/2"}
     [:p.mb-2 "Flowbite Components"]
     [:> fb/Datepicker {:className "mb-12"}]
     [:form {:className "flex max-w-md flex-col gap-4 bg-gray-200 p-2 rounded-md"}
      [:div
       [:div {:className "mb-2 block"}
        [:> fb/Label {:html-for "email1"
                      :value "Your Mail"}]
        [:> fb/TextInput {:className "mb-2"
                          :id "email1"
                          :type "email"
                          :placeholder "sample@sample.com"
                          :required true}]
        [:> fb/Button {:type "submit"} "Submit"]]]]]]

   [:f> example]])

(defn ^:dev/after-load render []
  (.render root (r/as-element [app-view])))

(defn ^:export init []
  (render))
