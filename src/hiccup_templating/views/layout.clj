(ns hiccup-templating.views.layout
  (:use [hiccup.page :only (html5 include-css include-js)]))

(defn application [title & content]
  (html5 {:ng-app "myApp" :lang "en"}
         [:head
          [:title title]
          (include-css "//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css")
          (include-js "http://code.angularjs.org/1.2.3/angular.min.js")
          (include-js "js/ui-bootstrap-tpls-0.7.0.min.js")
          (include-js "js/script.js")

          [:body
           [:div {:class "container"} content ]]]))