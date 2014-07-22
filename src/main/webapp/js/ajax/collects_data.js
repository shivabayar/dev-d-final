$.ajax({
		url : "/api/collects/" + USER_NAME,
		headers : {
			'ACCEPT' : 'application/json'
		},
		success : function(result) {
			console.log(USER_NAME);}
});