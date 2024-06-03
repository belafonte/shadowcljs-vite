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

;; maybe a better approach by the dude
;; https://github.com/babashka/nbb/blob/main/examples/axios/example.cljs#L5C3-L6C51
(defn fetch-posts []
  (-> (js/fetch "http://localhost:3000/posts")
      (.then #(.json %))))

(defn add-post [postData]
  (try
    (.. (js/fetch "http://localhost:3000/postsasdf"
                  (clj->js {:method "POST"
                            :headers #js {"Content-Type" "application/json"}
                            :body (js/JSON.stringify postData)}))
        (then (fn [response]
                (if (.. response -ok)
                  (.. response json)
                  (throw (js/Error. (str "HTTP error: " (.. response -status))))))))
    (catch :default e
      (js/console.debug (str "An error occurred: " (.. e -message))))))

(defn remove-post [id]
  (-> (js/fetch (str "http://localhost:3000/posts/" id)
                (clj->js {:method "DELETE"}))
      (.then #(.json %))))

(defui main []
  (let [[value set-value!] (uix.core/use-state "")
        location (router/useLocation)
        qc (react-query/useQueryClient)
        get (useQuery (clj->js {:queryKey ["posts"]
                                :queryFn fetch-posts}))
        add (useMutation
             (clj->js {:mutationFn add-post
                       :onError (fn [error] (js/console.debug "mutation failed" error))
                       :onSettled #(js/console.debug "settled")
                       :onSuccess #(.invalidateQueries qc ["posts"])}))
        remove (useMutation
                (clj->js {:mutationFn remove-post
                          :onSuccess #(.invalidateQueries qc ["posts"])}))]

    (cond
      (.. get -isLoading)
      ($ :div "Loading...") ;; or a spinner

      (.. get -isError)
      ($ :div "Error!") ;; or an error message

      (.. get -isSuccess)
      ($ Card {:className "w-[500px] mt-12"}
         ($ CardHeader
            ($ CardTitle "Posts")
            ($ CardDescription (str "Current Path: " (-> location .-pathname))))
         ($ CardContent
            ($ Table
               ($ TableHeader
                  ($ TableRow
                     ($ TableHead {:className "w-[100px]"} "ID")
                     ($ TableHead "Title")
                     ($ TableHead {:className "text-right"} "")))
               ($ TableBody
                  (for [post (-> get .-data)]
                    ($ TableRow {:key (-> post .-id)}
                       ($ TableCell {:className "w-[100px]"} (-> post .-id))
                       ($ TableCell (-> post .-title))
                       ($ TableCell {:className "text-right"}
                          ($ Button {:on-click #((-> remove .-mutate) (.-id post))
                                     :variant "destructive"}
                             ($ X {:className "h-4 w-4"}))))))))

         (cond
           (.. add -isPending)
           ($ :div "Pending")

           (.. add -isSuccess)
           ($ :div "Post added!")

           (.. add -isError)
           ($ :div "Error adding post!"))
         ($ :div {:className "flex w-full items-center space-x-2 p-4"}
            ($ Input {:type "text"
                      :placeholder "Title"
                      :value value
                      :on-change #(set-value! (.. % -target -value))})
            ($ Button {:on-click #(.. add (mutate (clj->js {:title value})))}
               "Add"))))))
         ;; ($ ReactQueryDevtools {:initial-is-open true}))))
