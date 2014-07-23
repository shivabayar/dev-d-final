google.load("visualization", "1", {packages:["corechart"]});
google.setOnLoadCallback(drawChart);
function drawChart() {
	$.ajax({
		url : "/api/gitcommittrendgraph/" + USER_NAME,
		headers : {
			'ACCEPT' : 'application/json'
		},
		success : function(result) {
			var data = google.visualization.arrayToDataTable([
					[ 'Day', 'Commits' ], [ '0', parseInt(result.zero) ],
					[ '1', parseInt(result.one) ],
					[ '2', parseInt(result.two) ],
					[ '3', parseInt(result.three) ],
					[ '4', parseInt(result.four) ],
					[ '5', parseInt(result.five) ],
					[ '6', parseInt(result.six) ] ]);
			var options = {
				title : 'Your Commit trend'
			};

        var options = {
          title: 'Your Commit trend'
        };

        var chart = new google.visualization.LineChart(document.getElementById('commit_trend'));
        chart.draw(data, options);

  }});
}
