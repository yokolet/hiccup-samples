(ns hiccup-templating.views.contents
  (:use [hiccup.form :only (label text-field)]
        [hiccup.element :only (link-to)]))

(defn index []
  [:div {:id "content"}
   [:h1 {:class "text-success"} "Hello Hiccup"]])

(defn hello []
  [:div
   [:h1 {:class "text-info"} "Hello Hiccup and Angular"]
   [:div {:class "row"}
    [:div {:class "col-md-2 text-right"}
     (label "name" "Name:")]
    [:div {:class "col-md-4"}
     (text-field {:class "form-control" :ng-model "yourName" :placeholder "Enter a name here"} "your-name")]]
   [:hr]
   [:h1 {:class "text-success"} "Hello {{yourName}}!"]])

(defn not-found []
  [:div
   [:h1 {:class "info-worning"} "Page Not Found"]
   [:p "There's no requested page. "]
   (link-to {:class "btn btn-primary"} "/" "Take me to Home")])

