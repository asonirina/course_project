$(function(){
	
	$("#form").validate({
		rules: {
            firstName: {
				required: true
			},
            secondName: {
				required: true
			},
            login: {
				required: true
			},
            form: {
				required: true
			},
            password: {
				required: true
			}
		},
		messages: {
            firstName: {
                required: 'Обязательное поле'
			},
            secondName: {
                required: 'Обязательное поле'
			},
            login: {
				required: 'Обязательное поле'
			},
            form: {
                required: 'Обязательное поле'
            },
            password: {
                required: 'Обязательное поле'
			}
		},
		success: function(label) {
			label.html('OK').removeClass('error').addClass('ok');
			setTimeout(function(){
				label.fadeOut(500);
			}, 2000)
		}
	});
	
});