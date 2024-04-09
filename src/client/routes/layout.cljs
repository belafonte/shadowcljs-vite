(ns client.routes.layout
  (:require
   [uix.core :as uix :refer [defui $]]
   [uix.dom]
   [client.routes.components.aside :as aside]
   ["react-router-dom" :as router]))

(defui main []
  ($ :div {:className "flex min-h-screen w-full flex-col bg-muted/40"}
     ($ aside/main)
     ($ :div {:className "flex flex-col sm:gap-4 sm:py-4 sm:pl-14"}
        ($ :main {:className "grid flex-1 items-start gap-4 p-4 sm:px-6 sm:py-0 md:gap-8 lg:grid-cols-3 xl:grid-cols-3"}
           ($ router/Outlet)))))
