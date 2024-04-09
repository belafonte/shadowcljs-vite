(ns client.routes.components.aside
  (:require [uix.core :as uix :refer [defui $]]
            [uix.dom]
            ["react-router-dom" :as router :refer [Link]]
            ["lucide-react" :refer [Home Inbox]]))

(defui main []
  ($ :aside {:className "fixed inset-y-0 left-0 z-10 hidden w-14 flex-col border-r bg-background sm:flex"}
     ($ :nav {:className "flex flex-col items-center gap-4 px-2 sm:py-5"}
        ($ Link {:to "/"
                 :unstable_viewTransition true
                 :className "flex h-9 w-9 items-center justify-center rounded-lg text-muted-foreground transition-colors hover:text-foreground md:h-8 md:w-8"}
           ($ Home {:className "h-4 w-4 transition-all group-hover:scale-110"}))
        ($ Link {:to "/posts"
                 :unstable_viewTransition true
                 :className "flex h-9 w-9 items-center justify-center rounded-lg text-muted-foreground transition-colors hover:text-foreground md:h-8 md:w-8"}
           ($ Inbox {:className "h-4 w-4 transition-all group-hover:scale-110"})))))

