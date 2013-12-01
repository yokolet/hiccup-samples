(ns hiccup-templating.core
  (:require [compojure.core :refer [defroutes GET ANY]]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.adapter.jetty :as jetty]
            [hiccup-templating.views.layout :as layout]
            [hiccup-templating.views.contents :as contents]))

(defroutes routes
  (GET "/" [] (layout/application "Home" (contents/index)))
  (GET "/hello" [] (layout/application "Hello ???" (contents/hello)))
  (GET "/subscribe" [] (layout/application "Subscrition" (contents/subscribe)))
  (GET "/pagination" [] (layout/application "Pagination" (contents/pagination)))
  (GET "/pages/:id" [id]  (contents/page id))
  (route/resources "/")
  (ANY "*" [] (route/not-found (layout/application "Page Not Found" (contents/not-found)))))

(def application (handler/site routes))

(defn -main []
  (let [port (Integer/parseInt (or (System/getenv "PORT") "8080"))]
    (jetty/run-jetty application {:port port :join? false})))
