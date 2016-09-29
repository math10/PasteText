angular.module("pastetext").factory('PasteText', function () {

    'use strict';

    function PasteText(id, userName, title, text) {
        this.id = id;
        this.userName = userName;
        this.title = title;
        this.text = text;
    }

    PasteText.build = function (data) {
        return new PasteText(
            data.id,
            data.userName,
            data.title,
            data.text
        );
    };

    return PasteText;
});