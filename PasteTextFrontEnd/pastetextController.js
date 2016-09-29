var myApp = angular.module("pastetext");

var controllers = {};

controllers.pasteTextController = function ($scope, PasteTextService) {
	$scope.userNameOFPastedText = "";
	$scope.contentOfPastedText = "";
	$scope.inputPage = false;
	$scope.showedPage = true;
	$scope.saveText = function(){
		PasteTextService.postTextThroughAPI($scope.userName, $scope.title ,$scope.pastedText).then(function(response) {
				console.log(response.data);
				$scope.result = response.data;
				$scope.inputPage = !$scope.inputPage;
				$scope.showedPage = !$scope.showedPage;
			});
	}

	$scope.backToPaste = function(){
		$scope.inputPage = !$scope.inputPage;
		$scope.showedPage = !$scope.showedPage;
	}

}
myApp.controller(controllers);