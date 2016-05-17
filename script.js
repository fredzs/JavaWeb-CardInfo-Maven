&lt;script&gt;
var list=document.getElementsByTagName(&quot;tbody&quot;)[1];
var length = list.getElementsByTagName(&quot;tr&quot;).length - 3;
var startLine = 2;
var i = 0;

var buildId = ${ENV:BUILD_ID};
var buildIdInt = parseInt(buildId);
function callServer() {	
	var xmlHttp;
	if(window.ActiveXObject)
        xmlHttp =new ActiveXObject(&quot;Microsoft.XMLHTTP&quot;);
    else if(window.XMLHttpRequest)   
        xmlHttp=new XMLHttpRequest();   
	var url = document.URL + buildIdInt + &quot;/api/xml?pretty=true&amp;tree=actions[parameters[*],causes[*]]&quot;;
	
	xmlHttp.open(&quot;GET&quot;,url,true);   
	xmlHttp.onreadystatechange = function(){
		if(xmlHttp.readyState==4 &amp;&amp; xmlHttp.status==200 &amp;&amp; i &lt; length) {
			var branch_name = xmlHttp.responseXML.getElementsByTagName(&quot;parameter&quot;)[1].getElementsByTagName(&quot;value&quot;)[0].firstChild.nodeValue;
			var user_name = xmlHttp.responseXML.getElementsByTagName(&quot;cause&quot;)[0].getElementsByTagName(&quot;userName&quot;)[0].firstChild.nodeValue;
			var lineContent;
			if(branch_name==&quot;trunk&quot;)
				lineContent = &quot;trunk发布&quot;;
			else
				lineContent = &quot;branch_name=&quot; + branch_name + &quot;      btag=b_&quot; + buildIdInt + &quot;_&quot; + user_name;
			buildIdInt--;
			var textnode=document.createTextNode(lineContent);
			var newDiv=document.createElement(&quot;DIV&quot;);
			newDiv.appendChild(textnode);
			var newTd=document.createElement(&quot;TD&quot;);
			newTd.appendChild(newDiv);
			var newTr=document.createElement(&quot;TR&quot;);
			newTr.appendChild(newTd);

			list.insertBefore(newTr,list.children[i*2 + startLine]);
			i++;
			callServer();
		}
	};
	xmlHttp.send(null);   
}
callServer();

&lt;/script&gt;