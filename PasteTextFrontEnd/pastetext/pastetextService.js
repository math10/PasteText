var myApp = angular.module("pastetext");

myApp.factory('PasteTextService', function (PasteText, $http) {
    return {
        postTextThroughAPI: function (pastedUserName, title, text) {
			var data = new PasteText(null,pastedUserName,title,text);
			console.log(PasteText.build(data));
            return $http.post("http://localhost:8080/Spring4MVCCRUDRestService/text/", data);
        }		
    }
});