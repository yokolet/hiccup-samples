(ns hiccup-templating.views.layout
  (:use [hiccup.page :only (html5 include-css include-js)]))

(defn application [title & content]
  (html5 {:ng-app "" :lang "en"}
         [:head
          [:title title]
          (include-css "/css/bootstrap.min.css")
          (include-js "/js/jquery-1.10.2.min.js")
          (include-js "/js/bootstrap.min.js")
          (include-js "https://ajax.googleapis.com/ajax/libs/angularjs/1.2.2/angular.min.js")
          [:body
           [:div {:class "container"} content]]]))