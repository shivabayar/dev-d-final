google.load("visualization", "1", {packages:["corechart"]});
google.setOnLoadCallback(drawChartPullRequestChart);
      function drawChartPullRequestChart() {
        $.ajax({url:"commit.txt",success:function(result){
      
      jsonData = $.parseJSON(result);
      console.log (jsonData);
      console.log (jsonData.jan);
        var data = google.visualization.arrayToDataTable([
          ['Day', 'Pull Request'],
          ['Sunday',parseInt(jsonData.sun)],
          ['Monday',  parseInt(jsonData.mon)],
          ['Tuesday',  parseInt(jsonData.tue)],
          ['Wednesday',  parseInt(jsonData.wed)],
          ['Thursday',  parseInt(jsonData.thu)],
          ['Friday',  parseInt(jsonData.fri)],
          ['Saturday',  parseInt(jsonData.sat)]
        ]);

        var options = {
          title: 'Pull Request Summary'
        };

        var chart = new google.visualization.BarChart(document.getElementById('pull_request'));
        chart.draw(data, options);

  }});
}