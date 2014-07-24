function loadDataAlerts(url1) {
	$.ajax({url : url1,
		headers : {'ACCEPT' : 'application/json'},
		success : function(response) {
		var result = "";
		$.each(response,function(i, item) {
			if (item.frequentCommits === true
					&& item.lastCommitedAt <= 2) {
				result += '</br><strong><font color=green>Frequent Commits <span style="font-size:18px;">&#10003;</span></font></strong>';
			}
			if (item.frequentCommits === true
					&& item.lastCommitedAt > 2) {
				result += '</br><strong><font color=red>Frequent Commit <span style="font-size:18px;">&#10008;</span><br/>'
				+ 'Commited '+ item.lastCommitedAt+ ' Days ago</font></strong>';
			}
		});
		$("#alerts-info").html(result);
	}
});}

loadDataAlerts("/api/alerts/" + USER_NAME);
