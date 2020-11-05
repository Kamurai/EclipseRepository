package division3;

public class Custom extends main.Custom {
	public Custom() {
		super();
	}

	public String getTitle(int vPage) {
		String vResult = "";
		String vDefault = "";

		vDefault += "Video Games";

		vResult += "<title>";
			if(vPage == 0){
				vResult += vDefault;
			}else if (vPage == 1){
				vResult += "Truth";
			}else if (vPage == 2){
				vResult += "The Wrong Ninja";
			}else if (vPage == 3){
				vResult += "Gynowars";
			}else if (vPage == 4){
				vResult += "Terminal World";
			}else if (vPage == 5){
				vResult += "Mars: Opposition";
			}else{
				vResult += vDefault;
			}
		vResult += "</title>";

		return vResult;
	}

	public String getContentHeader(int vPage) {
		String vResult = "";
		String vDefault = "";

		vDefault += "Private Projects";

		vResult += "<h2>";
		if(vPage == 0){
			vResult += vDefault;
		}else if (vPage == 1){
			vResult += "Truth";
		}else if (vPage == 2){
			vResult += "The Wrong Ninja";
		}else if (vPage == 3){
			vResult += "Gynowars";
		}else if (vPage == 4){
			vResult += "Terminal World";
		}else if (vPage == 5){
			vResult += "Mars: Opposition";
		}else{
			vResult += vDefault;
		}
		vResult += "</h2>";

		return vResult;
	}

	public String getContent(int vPage) {
		String vResult = "";
		String vDefault = "";

		vDefault += "This section is dedicated to video game projects.";

		vResult += "<div id=\"idCenterContent\">";
			if (vPage == 0){
				vResult += vDefault;
			}else if (vPage == 1){
				vResult += "This section is dedicated to the MMO RTS project \"Truth\".<br>";
				vResult += "Explore the galaxy, smuggle goods, steal from your friends and battle your adversaries.";
			}else if (vPage == 2){
				vResult += "This section is dedicated to the 2D platformer project \"The Wrong Ninja\".<br>";
				vResult += "Explore the galaxy, smuggle goods, steal from your friends and battle your adversaries.";
			}else if (vPage == 3){
				vResult += "The Gynowars RPG is a \"pokemon-like\" tactical RPG.<br>";
				vResult += "The protagonist uses creatures to fight battles against other creatures to progress through the storyline.";
			}else if (vPage == 4){
				vResult += "This section is dedicated to the simulation MMO centered project \"Terminal World\".<br>";
				vResult += "This is a virtual environment where a zombie outbreak is about to happen.";
				vResult += "Can you beat the zombies?  Can you survive?";
			}else if (vPage == 5){
				vResult += "This section is dedicated to the Mars centered project \"Opposition\".";
			}else{
				vResult += vDefault;
			}
		vResult += "</div>";

		return vResult;
	}

	public String getVersions(int vPage){
		String vResult = "";
		String vDefault = "";

		vDefault += "<li><a href=\"http://htkb.dyndns.org/Division3/Index.html\">HTML</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/Division3/Index.php\">PHP</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/Division3/Index.shtml\">Perl</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/SSI/Division3/Index.html\">Apache SSI</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division3/Index.html\">HTML Javascript</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division3/Index.html\">JQuery</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division3/Index.html\">Angular JS</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/JSX/Division3/Index.html\">JSX</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/XLST/Division3/Index.xml\">XSLT</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division3/Index.xhtml\">JSF</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division3/Index.jsp\">JSP</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division3/Index\">JSP Spring MVC</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division3/Index.aspx\">ASP.NET Javascript</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division3/Index.asp\">ASP VBscript</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division3/Index.cshtml\">ASP.NET Web App</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division3/Index.aspx\">ASP.NET Webform</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division3/Index\">ASP.NET MVC App</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:82/Division3/Index\">Python Web.py</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:83/Division3/Index\">Ruby on Rails</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:84/Division3/Index\">Node JS</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:85/Division3/Index\">Angular 2+</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:86/Division3/Index\">ReactJS</a></li>";

		vResult += "<ul class=\"versionsUl\">";
        
        if (vPage == 0){
			vResult += vDefault;
		}else if (vPage == 1){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division3/Project1.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division3/Project1.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division3/Project1.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division3/Project1.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division3/Project1.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division3/Project1.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division3/Project1.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division3/Project1.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division3/Project1.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division3/Project1.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division3/Project1.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division3/Project1\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division3/Project1.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division3/Project1.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division3/Project1.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division3/Project1.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division3/Project1\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division3/Project1\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division3/Project1\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division3/Project1\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division3/Project1\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division3/Project1\">ReactJS</a></li>";
		}else if (vPage == 2){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division3/Project2.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division3/Project2.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division3/Project2.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division3/Project2.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division3/Project2.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division3/Project2.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division3/Project2.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division3/Project2.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division3/Project2.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division3/Project2.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division3/Project2.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division3/Project2\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division3/Project2.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division3/Project2.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division3/Project2.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division3/Project2.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division3/Project2\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division3/Project2\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division3/Project2\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division3/Project2\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division3/Project2\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division3/Project2\">ReactJS</a></li>";
		}else if (vPage == 3){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division3/Project3.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division3/Project3.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division3/Project3.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division3/Project3.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division3/Project3.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division3/Project3.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division3/Project3.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division3/Project3.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division3/Project3.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division3/Project3.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division3/Project3.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division3/Project3\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division3/Project3.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division3/Project3.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division3/Project3.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division3/Project3.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division3/Project3\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division3/Project3\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division3/Project3\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division3/Project3\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division3/Project3\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division3/Project3\">ReactJS</a></li>";
		}else if (vPage == 4){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division3/Project4.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division3/Project4.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division3/Project4.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division3/Project4.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division3/Project4.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division3/Project4.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division3/Project4.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division3/Project4.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division3/Project4.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division3/Project4.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division3/Project4.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division3/Project4\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division3/Project4.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division3/Project4.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division3/Project4.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division3/Project4.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division3/Project4\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division3/Project4\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division3/Project4\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division3/Project4\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division3/Project4\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division3/Project4\">ReactJS</a></li>";
		}else if (vPage == 5){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division3/Project5.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division3/Project5.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division3/Project5.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division3/Project5.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division3/Project5.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division3/Project5.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division3/Project5.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division3/Project5.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division3/Project5.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division3/Project5.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division3/Project5.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division3/Project5\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division3/Project5.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division3/Project5.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division3/Project5.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division3/Project5.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division3/Project5\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division3/Project5\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division3/Project5\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division3/Project5\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division3/Project5\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division3/Project5\">ReactJS</a></li>";
		}else{
			vResult += vDefault;
		}

        vResult += "</ul>";
        
        return vResult;
	}
}
