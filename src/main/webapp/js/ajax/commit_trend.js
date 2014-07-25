google.load("visualization", "1", {packages:["corechart"]});
google.setOnLoadCallback(drawChart);

function generateMonth(month){
	switch(month){
	case 0: return 'Jan';
	break;
	case 1: return 'Feb';
	break;
	case 2: return 'Mar';
	break;
	case 3: return 'April';
	break;
	case 4: return 'May';
	break;
	case 5: return 'June';
	break;
	case 6: return 'July';
	break;
	case 7: return 'Aug';
	break;
	case 8: return 'Sept';
	break;
	case 9: return 'Oct';
	break;
	case 10: return 'Nov';
	break;
	case 11: return 'Dec';
	break;
	default: 
		return -1;
	
	}
}

function drawChart() {
	$.ajax({
		url : "/api/gitcommittrendgraph/" + USER_NAME,
		headers : {
			'ACCEPT' : 'application/json'
		},
		success : function(result) {
			zero = new Date();
			console.log(zero.getDate() +' '+zero.getMonth());
			zero_ = ""+generateMonth(zero.getMonth())+"'"+zero.getDate();
			console.log(zero_);
			one = new Date(zero);
			one.setDate(zero.getDate() - 1);
			one_ = ""+generateMonth(one.getMonth())+"'"+one.getDate();
			console.log(one.getDate() +' '+one.getMonth());
			
			two = new Date(one);
			two.setDate(one.getDate() - 1);
			two_ = ""+generateMonth(two.getMonth())+"'"+two.getDate();
			
			three = new Date(two);
			three.setDate(two.getDate() - 1);
			three_ = ""+generateMonth(three.getMonth())+"'"+three.getDate();
			
			four = new Date(three);
			four.setDate(three.getDate() - 1);
			four_ = ""+generateMonth(four.getMonth())+"'"+four.getDate();
			
			five = new Date(four);
			five.setDate(four.getDate() - 1);
			five_ = ""+generateMonth(five.getMonth())+"'"+five.getDate();
			
			six = new Date(five);
			six.setDate(five.getDate() - 1);
			six_ = ""+generateMonth(six.getMonth())+"'"+six.getDate();
			
			var data = google.visualization.arrayToDataTable([
					[ 'Day', 'Commits' ], 
					[ zero_, parseInt(result.zero) ],
					[ one_, parseInt(result.one) ],
					[ two_, parseInt(result.two) ],
					[ three_, parseInt(result.three) ],
					[ four_, parseInt(result.four) ],
					[ five_, parseInt(result.five) ],
					[ six_, parseInt(result.six) ] ]);
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
