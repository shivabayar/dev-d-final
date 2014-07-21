google.load("visualization", "1", {packages:["corechart"]});
google.setOnLoadCallback(drawChart);
      function drawChart() {
        $.ajax({url:"commit.txt",
        	headers: { 'ACCEPT': 'application/json' },
        	success:function(result){
      
        console.log(result);
//      jsonData = $.parseJSON(result);
//      console.log (jsonData);
//      console.log (jsonData.jan);
        var data = google.visualization.arrayToDataTable([
          ['Day', 'Commits'],
          ['sun',parseInt(result.sun)],
          ['mon',  parseInt(result.mon)],
          ['tue',  parseInt(result.tue)],
          ['wed',  parseInt(result.wed)],
          ['thu',  parseInt(result.thu)],
          ['fri',  parseInt(result.fri)],
          ['sat',  parseInt(result.sat)]
        ]);

        var options = {
          title: 'Your Commit trend'
        };

        var chart = new google.visualization.LineChart(document.getElementById('commit_trend'));
        chart.draw(data, options);

  }});
}