function DialogTest() {
	BootstrapDialog.show({
	    title: '提醒',
	    message: '請輸入留言',
	    size: BootstrapDialog.SIZE_LARGE, // <-- Default value is
	    type: BootstrapDialog.TYPE_DANGER, // <-- Default value is
	    closable: true,
	    closeByBackdrop: false,
	    closeByKeyboard: true,
	
	    buttons: [{
	        icon: 'glyphicon glyphicon-ok',
	        label: '確認',
	        cssClass: 'btn-danger',
	        autospin: true,
	        action: function(dialogItself) {
	            dialogItself.close();
	        }
	    }]
	});
}