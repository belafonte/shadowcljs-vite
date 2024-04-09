(ns client.routes.posts.page
  (:require
   ["@@/button" :refer [Button]]
   ["@@/card" :refer [Card CardContent CardDescription CardHeader CardTitle]]
   ["@@/input" :refer [Input]]
   ["@@/table" :refer [Table TableBody TableCell TableHead TableHeader
                       TableRow]]
   ["@tanstack/react-query" :as react-query :refer [useMutation useQuery]]
   ["lucide-react" :refer [X]]
   ["react-router-dom" :as router]
   [uix.core :as uix :refer [$ defui]]
   [uix.dom]))

(defn fetch []
  (.then (js/fetch "http://localhost:3000/posts")
         #(.json %)))

(defn add [postData]
  (.then (js/fetch "http://localhost:3000/posts"
                   (clj->js {:method "POST"
                             :headers #js {"Content-Type" "application/json"}
                             :body (js/JSON.stringify postData)}))
         #(.json %)))

(defn remove-post [id]
  (.then (js/fetch (str "http://localhost:3000/posts/" id)
                   (clj->js {:method "DELETE"}))
         #(.json %)))

(defui main []
  (let [[value set-value!] (uix.core/use-state "")
        location (router/useLocation)
        queryClient (react-query/useQueryClient)
        query (useQuery (clj->js {:queryKey ["posts"]
                                  :queryFn fetch}))
        mutation (useMutation (clj->js {:mutationFn add
                                        :onSuccess #(.invalidateQueries queryClient ["posts"])}))
        remove-mutation (useMutation (clj->js {:mutationFn remove-post
                                               :onSuccess #(.invalidateQueries queryClient ["posts"])}))]
    ($ Card {:className "w-[500px] mt-12"}
       ($ CardHeader
          ($ CardTitle "Posts")
          ($ CardDescription (str "Current Path: " (.-pathname location))))
       ($ CardContent
          ($ Table
             ($ TableHeader
                ($ TableRow
                   ($ TableHead {:className "w-[100px]"} "ID")
                   ($ TableHead "Title")
                   ($ TableHead {:className "text-right"} "")))
             ($ TableBody
                (for [post (.-data query)]
                  ($ TableRow
                     ($ TableCell (.-id post))
                     ($ TableCell (.-title post))
                     ($ TableCell {:className "text-right"}
                        ($ Button {:on-click #((-> remove-mutation .-mutate) (.-id post))
                                   :variant "destructive"}
                           ($ X {:className "h-4 w-4"}))))))))
       ($ :div {:className "flex w-full items-center space-x-2 p-4"}
          ($ Input {:type "text"
                    :placeholder "Title"
                    :value value
                    :on-change #(set-value! (.. % -target -value))})
          ($ Button {:on-click #((-> mutation .-mutate) (clj->js {:title value}))} "Add")))))
       ;; ($ ReactQueryDevtools {:initial-is-open true}))))
