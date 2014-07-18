function loadXMLDoc(url)
{
var xmlhttp;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200){

      console.log (innerHTML=xmlhttp.status);
      data = $.parseJSON(xmlhttp.responseText);
      $.each(data, function(i, item) {
          console.log (item);
      document.getElementById('alerts-info').innerHTML += "<span><h4>"+item.alertMessage+"</h4></span><a href="+item.link+">link</a>";
      });
    }
  }
xmlhttp.open("GET",url,true);
xmlhttp.send();
}

loadXMLDoc("alert.txt");