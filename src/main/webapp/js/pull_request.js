google.load("visualization", "1", {packages:["corechart"]});
google.setOnLoadCallback(drawChart);
      function drawChart() {
        $.ajax({url:"commit.txt",success:function(result){
      
      jsonData = $.parseJSON(result);
      console.log (jsonData);
      console.log (jsonData.jan);
        var data = google.visualization.arrayToDataTable([
          ['Month', 'Pull Request'],
          ['Jan',parseInt(jsonData.jan)],
          ['Feb',  parseInt(jsonData.feb)],
          ['March',  parseInt(jsonData.march)],
          ['April',  parseInt(jsonData.april)],
          ['May',  parseInt(jsonData.may)],
          ['June',  parseInt(jsonData.june)],
          ['July',  parseInt(jsonData.july)],
          ['Aug',  parseInt(jsonData.aug)],
          ['Sept',  parseInt(jsonData.sept)],
          ['Oct',  parseInt(jsonData.oct)],
          ['Nov',  parseInt(jsonData.nov)],
          ['Dec',  parseInt(jsonData.dec)]
        ]);

        var options = {
          title: 'Pull Request Summary'
        };

        var chart = new google.visualization.BarChart(document.getElementById('pull_request'));
        chart.draw(data, options);

  }});
}