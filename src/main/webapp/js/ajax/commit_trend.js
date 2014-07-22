google.load("visualization", "1", {packages:["corechart"]});
google.setOnLoadCallback(drawChart);
      function drawChart() {
        $.ajax({url:"commit.txt",
        	headers: { 'ACCEPT': 'application/json' },
        	success:function(result){
      
      jsonData = $.parseJSON(result);
      console.log (jsonData);
      console.log (jsonData.jan);
        var data = google.visualization.arrayToDataTable([
          ['Day', 'Commits'],
          ['sun',parseInt(jsonData.sun)],
          ['mon',  parseInt(jsonData.mon)],
          ['tue',  parseInt(jsonData.tue)],
          ['wed',  parseInt(jsonData.wed)],
          ['thu',  parseInt(jsonData.thu)],
          ['fri',  parseInt(jsonData.fri)],
          ['sat',  parseInt(jsonData.sat)]
        ]);

        var options = {
          title: 'Your Commit trend'
        };

        var chart = new google.visualization.LineChart(document.getElementById('commit_trend'));
        chart.draw(data, options);

  }});
}