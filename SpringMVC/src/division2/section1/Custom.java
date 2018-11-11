package division2.section1;

public class Custom extends division2.Custom {
	public Custom() {
		super();
	}

	public String getTitle(int vPage) {
		String vResult = "";
		String vDefault = "";

		vDefault += "Gynowars";

		vResult += "<title>";
			if (vPage == 0) {
				vResult += vDefault;
			} else if (vPage == 1) {
				vResult += "Gynowars RPG";
			} else if (vPage == 2) {
				vResult += "Gynowars: Battle Arena CCG";
			} else if (vPage == 3) {
				vResult += "Gynowars: Crash Ball";
			} else {
				vResult += vDefault;
			}
		vResult += "</title>";

		return vResult;
	}

	public String getContentHeader(int vPage) {
		String vResult = "";
		String vDefault = "";

		vDefault += "Gynowars";

		vResult += "<h2>";
			if (vPage == 0) {
				vResult += vDefault;
			} else if (vPage == 1) {
				vResult += "Gynowars RPG";
			} else if (vPage == 2) {
				vResult += "Gynowars: Battle Arena CCG";
			} else if (vPage == 3) {
				vResult += "Gynowars: Crash Ball";
			} else {
				vResult += vDefault;
			}
		vResult += "</h2>";

		return vResult;
	}

	public String getContent(int vPage) {
		String vResult = "";
		String vDefault = "";

		vDefault += "This section is dedicated to projects centered in the Gynowars universe.";

		vResult += "<div id=\"idCenterContent\">";
			if (vPage == 0) {
				vResult += vDefault;
			} else if (vPage == 1) {
				vResult += "The Gynowars RPG is a 'pokemon-like' tactical RPG.";
				vResult += "The protagonist uses creatures to fight battles against other creatures to progress through the storyline.";
			} else if (vPage == 2) {
				vResult += "Gynowars: Battle Arena is a CCG that pits teams of creatures against each other ";
				vResult += "in an arena-like environment.  There are several scenarios to run, to include:";
				vResult += "</br>";
				vResult += "'Death Match', 'Ring the Bell', and 'Head Hunt'.";
			} else if (vPage == 3) {
				vResult += "Gynowars: Crash Ball is a turn based strategy board game.  Basically it's gridiron with Gynos.";
			} else {
				vResult += vDefault;
			}
		vResult += "</div>";

		return vResult;
	}

	public String getVersions(int vPage) {
		String vResult = "";
		String vDefault = "";

		vDefault += "<a href=\"http://htkb.dyndns.org/Division2/Section1/Index.html\">HTML</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org/Division2/Section1/Index.php\">PHP</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org/Division2/Section1/Index.shtml\">Perl</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org/SSI/Division2/Section1/Index.html\">Apache SSI</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org/Javascript/Division2/Section1/Index.html\">HTML Javascript</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org/JQuery/Division2/Section1/Index.html\">JQuery</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org/AngularJS/Division2/Section1/Index.html\">Angular JS</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division2/Section1/Index.xhtml\">JSF</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division2/Section1/Index.jsp\">JSP</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org:81/ASPNET/Division2/Section1/Index.aspx\">ASP.NET Javascript</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org:81/ASP/Division2/Section1/Index.asp\">ASP VBscript</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org:81/WebApplication/Division2/Section1/Index.cshtml\">ASP.NET Web App</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org:81/WebForm/Division2/Section1/Index.aspx\">ASP.NET Webform</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org:81/MVC/Division2/Section1/Index\">ASP.NET MVC App</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org:82/Division2/Section1/Index\">Python Web.py</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org:83/Division2/Section1/Index\">Ruby on Rails</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org:84/Division2/Section1/Index\">Node JS</a><br/>";

		if (vPage == 0) {
			vResult += vDefault;
		} else if (vPage == 1) {
			vResult += "<a href=\"http://htkb.dyndns.org/Division2/Section1/Project1.html\">HTML</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org/Division2/Section1/Project1.php\">PHP</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org/Division2/Section1/Project1.shtml\">Perl</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org/SSI/Division2/Section1/Project1.html\">Apache SSI</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org/Javascript/Division2/Section1/Project1.html\">HTML Javascript</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org/JQuery/Division2/Section1/Project1.html\">JQuery</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org/AngularJS/Division2/Section1/Project1.html\">Angular JS</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division2/Section1/Project1.xhtml\">JSF</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division2/Section1/Project1.jsp\">JSP</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:81/ASPNET/Division2/Section1/Project1.aspx\">ASP.NET Javascript</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:81/ASP/Division2/Section1/Project1.asp\">ASP VBscript</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:81/WebApplication/Division2/Section1/Project1.cshtml\">ASP.NET Web App</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:81/WebForm/Division2/Section1/Project1.aspx\">ASP.NET Webform</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:81/MVC/Division2/Section1/Project1\">ASP.NET MVC App</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:82/Division2/Section1/Project1\">Python Web.py</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:83/Division2/Section1/Project1\">Ruby on Rails</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:84/Division2/Section1/Project1\">Node JS</a><br/>";
		} else if (vPage == 2) {
			vResult += "<a href=\"http://htkb.dyndns.org/Division2/Section1/Project2.html\">HTML</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org/Division2/Section1/Project2.php\">PHP</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org/Division2/Section1/Project2.shtml\">Perl</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org/SSI/Division2/Section1/Project2.html\">Apache SSI</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org/Javascript/Division2/Section1/Project2.html\">HTML Javascript</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org/JQuery/Division2/Section1/Project2.html\">JQuery</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org/AngularJS/Division2/Section1/Project2.html\">Angular JS</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division2/Section1/Project2.xhtml\">JSF</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division2/Section1/Project2.jsp\">JSP</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:81/ASPNET/Division2/Section1/Project2.aspx\">ASP.NET Javascript</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:81/ASP/Division2/Section1/Project2.asp\">ASP VBscript</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:81/WebApplication/Division2/Section1/Project2.cshtml\">ASP.NET Web App</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:81/WebForm/Division2/Section1/Project2.aspx\">ASP.NET Webform</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:81/MVC/Division2/Section1/Project2\">ASP.NET MVC App</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:82/Division2/Section1/Project2\">Python Web.py</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:83/Division2/Section1/Project2\">Ruby on Rails</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:84/Division2/Section1/Project2\">Node JS</a><br/>";
		} else if (vPage == 3) {
			vResult += "<a href=\"http://htkb.dyndns.org/Division2/Section1/Project3.html\">HTML</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org/Division2/Section1/Project3.php\">PHP</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org/Division2/Section1/Project3.shtml\">Perl</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org/SSI/Division2/Section1/Project3.html\">Apache SSI</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org/Javascript/Division2/Section1/Project3.html\">HTML Javascript</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org/JQuery/Division2/Section1/Project3.html\">JQuery</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org/AngularJS/Division2/Section1/Project3.html\">Angular JS</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division2/Section1/Project3.xhtml\">JSF</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division2/Section1/Project3.jsp\">JSP</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:81/ASPNET/Division2/Section1/Project3.aspx\">ASP.NET Javascript</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:81/ASP/Division2/Section1/Project3.asp\">ASP VBscript</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:81/WebApplication/Division2/Section1/Project3.cshtml\">ASP.NET Web App</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:81/WebForm/Division2/Section1/Project3.aspx\">ASP.NET Webform</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:81/MVC/Division2/Section1/Project3\">ASP.NET MVC App</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:82/Division2/Section1/Project3\">Python Web.py</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:83/Division2/Section1/Project3\">Ruby on Rails</a><br/>";
			vResult += "<a href=\"http://htkb.dyndns.org:84/Division2/Section1/Project3\">Node JS</a><br/>";
		} else {
			vResult += vDefault;
		}

		return vResult;
	}
}
