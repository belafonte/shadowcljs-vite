(ns client.routes.posts.page
  (:require
   [uix.core :as uix :refer [defui $]]
   [uix.dom]
   ["react-router-dom" :as router]
   ["@@/button" :refer [Button]]
   ["@tanstack/react-query" :as react-query :refer [useQuery useMutation ReactQueryDevtools]]))

(defn fetch []
  (.then (js/fetch "http://localhost:3000/posts")
         #(.json %)))

(defn add [postData]
  (js/console.debug "HELLLLOOO")
  (.then (js/fetch "http://localhost:3000/posts"
                   (clj->js {:method "POST"
                             :headers #js {"Content-Type" "application/json"}
                             :body (js/JSON.stringify postData)}))
         #(.json %))
  (js/console.debug "Post added"))

(defui main []
  (let [location (router/useLocation)
        queryClient (react-query/useQueryClient)
        query (useQuery (clj->js {:queryKey ["posts"]
                                  :queryFn fetch}))
        mutation (useMutation (clj->js {:mutationFn add}))]
                                        ;; :onSuccess #(.invalidateQueries queryClient ["posts"])}))]

    ;; (js/console.debug ((-> mutation .-mutate)))

    ($ :div
       ($ :h1 "Posts")
       ($ :p (str "Current Path: " (.-pathname location)))
       ($ :ul
          (for [post (.-data query)]
            ($ :li {:key (.-id post)} (.-title post))))
       ($ Button {:on-click #((-> mutation .-mutate) {:title "hello"})} "Add"))))
       ;; ($ ReactQueryDevtools {:initial-is-open true}))))
