(ns client.routes.posts.page
  (:require
   [uix.core :as uix :refer [defui $]]
   [uix.dom]
   ["react-router-dom" :as router]
   ["@@/button" :refer [Button]]
   ["@tanstack/react-query" :as react-query]))

(defn fetch []
  (.then (js/fetch "http://localhost:3000/posts")
         #(.json %)))

(defui main []
  (let [location (router/useLocation)
        queryClient (react-query/useQueryClient)
        query (react-query/useQuery (clj->js {:queryKey ["posts"]
                                              :queryFn fetch}))]

    (js/console.debug (.-data query))
    ($ :div
       ($ :h1 "Posts")
       ($ :p (str "Current Path: " (.-pathname location)))
       ($ :ul
          (for [post (.-data query)]
            ($ :li {:key (.-id post)} (.-title post))))
       ($ Button "Click Me"))))
