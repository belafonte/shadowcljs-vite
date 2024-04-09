(ns client.routes
  (:require
   [uix.core :as uix :refer [defui $]]
   [uix.dom]
   ["react-router-dom" :as router :refer [BrowserRouter Routes Route]]
   [client.routes.page]
   [client.routes.layout]
   [client.routes.posts.page]))

(defui main []
  ($ BrowserRouter
     ($ Routes
        ($ Route {:element ($ client.routes.layout/main)}
           ($ Route {:path "/" :element ($ client.routes.page/main)})
           ($ Route {:path "/posts" :element ($ client.routes.posts.page/main)})))))
