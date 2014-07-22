function loadDataActivity(url1){
  $.ajax({url:"activity.txt"
	  ,success:function(result){
      var data = $.parseJSON(result);
      var res = "";
      $.each(data, function(i, item) {
          console.log (item);
      res += "<span><h4>"+item.activityMessage+"</h4></span><a href="+item.link+">link</a>";
      });
    $("#activity-info").html(res);
  }});
}

loadDataActivity("activity.txt");