function loadDataActivity(url1){
  $.ajax({url:"/api/activity"+USER_NAME
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