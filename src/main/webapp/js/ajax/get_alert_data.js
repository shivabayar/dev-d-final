
function loadDataAlerts(url1){
  $.ajax({url:url1,
	  headers: { 'ACCEPT': 'application/json' },
	  success:function(response){
		  var result = "";       
//      console.log (response.brokeBuild);
      $.each(response, function(i, item) {
    	  
          if(item.brokeBuild === true){
        	  console.log (item.lastCommitedAt+"fre");  
        	  result += "<font color=red><span><h4>You Broke a build</h4></span></font><a href="+item.url+">click here to navigate</a>";
          }
          if(item.frequentCommits === true && item.lastCommitedAt <= 2){
        	  result += '</br><strong><font color=green>Frequent Commits <span style="font-size:18px;">&#10003;</span></font></strong>';
          }
      });
      $("#alerts-info").html(result);    
  }});
  
}

loadDataAlerts("/api/alerts/" + USER_NAME);

