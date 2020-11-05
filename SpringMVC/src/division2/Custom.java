package division2;

public class Custom extends main.Custom {
	public Custom() {
		super();
	}

	public String getTitle(int vPage) {
		String vResult = "";
		String vDefault = "";

		vDefault += "Digital Board Games";

		vResult += "<title>";
			if(vPage == 0){
				vResult += vDefault;
			}else if (vPage == 1){
				vResult += "Kingdoms";
			}else if (vPage == 2){
				vResult += "Goblins and Guardians";
			}else if (vPage == 3){
				vResult += "Mega Fleets";
			}else{
				vResult += vDefault;
			}
		vResult += "</title>";

		return vResult;
	}

	public String getContentHeader(int vPage) {
		String vResult = "";
		String vDefault = "";

		vDefault += "Digital Board Games";

		vResult += "<h2>";
		if(vPage == 0){
			vResult += vDefault;
		}else if (vPage == 1){
			vResult += "Kingdoms";
		}else if (vPage == 2){
			vResult += "Goblins and Guardians";
		}else if (vPage == 3){
			vResult += "Mega Fleets";
		}else{
			vResult += vDefault;
		}
		vResult += "</h2>";

		return vResult;
	}

	public String getContent(int vPage) {
		String vResult = "";
		String vDefault = "";

		vDefault += "This section is dedicated to digital board game projects.";

		vResult += "<div id=\"idCenterContent\">";
			if (vPage == 0){
				vResult += vDefault;
			}else if (vPage == 1){
				vResult += "This section is dedicated to the digital board game project Kingdoms.<br>";
				vResult += "Explore the world\\\"s Kingdoms, get rich, get strong and conquer.";
			}else if (vPage == 2){
				vResult += "This section is dedicated to the board game project \"Goblins and Guardians\".<br/>";
				vResult += "Goblins and Guardians battle it out in a labrynth of a building.";
			}else if (vPage == 3){
				vResult += "This section is dedicated to the board game project \"Mega Fleets\".";
			}else{
				vResult += vDefault;
			}
		vResult += "</div>";

		return vResult;
	}

	public String getVersions(int vPage){
		String vResult = "";
		String vDefault = "";

		vDefault += "<li><a href=\"http://htkb.dyndns.org/Division2/Index.html\">HTML</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/Division2/Index.php\">PHP</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/Division2/Index.shtml\">Perl</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/SSI/Division2/Index.html\">Apache SSI</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division2/Index.html\">HTML Javascript</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division2/Index.html\">JQuery</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division2/Index.html\">Angular JS</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/JSX/Division2/Index.html\">JSX</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/XLST/Division2/Index.xml\">XSLT</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division2/Index.xhtml\">JSF</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division2/Index.jsp\">JSP</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division2/Index\">JSP Spring MVC</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division2/Index.aspx\">ASP.NET Javascript</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division2/Index.asp\">ASP VBscript</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division2/Index.cshtml\">ASP.NET Web App</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division2/Index.aspx\">ASP.NET Webform</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division2/Index\">ASP.NET MVC App</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:82/Division2/Index\">Python Web.py</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:83/Division2/Index\">Ruby on Rails</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:84/Division2/Index\">Node JS</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:85/Division2/Index\">Angular 2+</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:86/Division2/Index\">ReactJS</a></li>";

		vResult += "<ul class=\"versionsUl\">";
        
        if (vPage == 0){
			vResult += vDefault;
		}else if (vPage == 1){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division2/Project1.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division2/Project1.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division2/Project1.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division2/Project1.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division2/Project1.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division2/Project1.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division2/Project1.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division2/Project1.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division2/Project1.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division2/Project1.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division2/Project1.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division2/Project1\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division2/Project1.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division2/Project1.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division2/Project1.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division2/Project1.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division2/Project1\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division2/Project1\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division2/Project1\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division2/Project1\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division2/Project1\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division2/Project1\">ReactJS</a></li>";
		}else if (vPage == 2){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division2/Project2.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division2/Project2.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division2/Project2.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division2/Project2.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division2/Project2.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division2/Project2.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division2/Project2.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division2/Project2.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division2/Project2.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division2/Project2.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division2/Project2.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division2/Project2\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division2/Project2.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division2/Project2.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division2/Project2.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division2/Project2.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division2/Project2\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division2/Project2\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division2/Project2\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division2/Project2\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division2/Project2\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division2/Project2\">ReactJS</a></li>";
		}else if (vPage == 3){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division2/Project3.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division2/Project3.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division2/Project3.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division2/Project3.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division2/Project3.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division2/Project3.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division2/Project3.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division2/Project3.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division2/Project3.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division2/Project3.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division2/Project3.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division2/Project3\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division2/Project3.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division2/Project3.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division2/Project3.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division2/Project3.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division2/Project3\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division2/Project3\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division2/Project3\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division2/Project3\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division2/Project3\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division2/Project3\">ReactJS</a></li>";
		}else{
			vResult += vDefault;
		}

        vResult += "</ul>";
        
        return vResult;
	}
}
