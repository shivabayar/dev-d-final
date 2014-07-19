      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChartPieChart);
    function drawChartPieChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Open',     11],
          ['Closed',      2],
          ['Re-opened',  2],
          ['Resolved', 2],
          ['Inprogress',    7]
        ]);

        var options = {
          title: 'Jira tasks by status'
        };

        var chart = new google.visualization.PieChart(document.getElementById('jira_status_pie_chart'));
        chart.draw(data, options);
      }