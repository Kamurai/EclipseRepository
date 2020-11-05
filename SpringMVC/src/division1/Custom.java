package division1;

public class Custom extends main.Custom {
	public Custom() {
		super();
	}

	public String getTitle(int vPage) {
		String vResult = "";
		String vDefault = "";

		vDefault += "Board Games";

		vResult += "<title>";
			if(vPage == 0){
				vResult += vDefault;
			}else if(vPage == 1){
				vResult += "The Way";
			}else if(vPage == 2){
				vResult += "Sacred Offerings";
			}else if(vPage == 3){
				vResult += "Conversion";
			}else if(vPage == 4){
				vResult += "Conspiratorium";
			}else if(vPage == 5){
				vResult += "Monster Office Workplace";
			}else if(vPage == 6){
				vResult += "MacCreedy's Mansion";
			}else if(vPage == 7){
				vResult += "Dundered Acre Wood";
			}else if(vPage == 8){
				vResult += "Conquer";
			}else if(vPage == 9){
				vResult += "Assault";
			}else if(vPage == 10){
				vResult += "Battle Princesses";
			}else if(vPage == 11){
				vResult += "Armor Up";
			}else if(vPage == 12){
				vResult += "Gynowars: Battle Arena";
			}else if(vPage == 13){
				vResult += "Land of the Orcish Empire: Age of Magic";
			}else if(vPage == 14){
				vResult += "Coliseum: Arena";
			}else if(vPage == 15){
				vResult += "Nine Card";
			}else if(vPage == 16){
				vResult += "Wars of Antarrea";
			}else if(vPage == 17){
				vResult += "Antarrea RPG";
			}else if(vPage == 18){
				vResult += "Super Dungeon Adventure";
			}else{
				vResult += vDefault;
			}
		vResult += "</title>";

		return vResult;
	}

	public String getContentHeader(int vPage) {
		String vResult = "";
		String vDefault = "";

		vDefault += "Board Games";

		vResult += "<h2>";
			if(vPage == 0){
				vResult += vDefault;
			}else if(vPage == 1){
				vResult += "The Way";
			}else if(vPage == 2){
				vResult += "Sacred Offerings";
			}else if(vPage == 3){
				vResult += "Conversion";
			}else if(vPage == 4){
				vResult += "Conspiratorium";
			}else if(vPage == 5){
				vResult += "Monster Office Workplace";
			}else if(vPage == 6){
				vResult += "MacCreedy's Mansion";
			}else if(vPage == 7){
				vResult += "Dundered Acre Wood";
			}else if(vPage == 8){
				vResult += "Conquer";
			}else if(vPage == 9){
				vResult += "Assault";
			}else if(vPage == 10){
				vResult += "Battle Princesses";
			}else if(vPage == 11){
				vResult += "Armor Up";
			}else if(vPage == 12){
				vResult += "Gynowars: Battle Arena";
			}else if(vPage == 13){
				vResult += "Land of the Orcish Empire: Age of Magic";
			}else if(vPage == 14){
				vResult += "Coliseum: Arena";
			}else if(vPage == 15){
				vResult += "Nine Card";
			}else if(vPage == 16){
				vResult += "Wars of Antarrea";
			}else if(vPage == 17){
				vResult += "Antarrea RPG";
			}else if(vPage == 18){
				vResult += "Super Dungeon Adventure";
			}else{
				vResult += vDefault;
			}
		vResult += "</h2>";

		return vResult;
	}

	public String getContent(int vPage) {
		String vResult = "";
		String vDefault = "";

		vDefault += "This section is dedicated to board game projects.";

		vResult += "<div id=\"idCenterContent\">";
			if(vPage == 0){
				vResult += vDefault;
			}else if(vPage == 1){
				vResult += "This section is dedicated to the card game project \"The Way\".<br/>";
				vResult += "You seek to find enlightment by contemplating the elements.<br/>";
				vResult += "Escape the binds of the world and the board to reach enlightment and win.<br/>";
				vResult += "<br/>";
				vResult += "You can download the Tabletop Simulator mod here:";
				vResult += "<a href=\"http://steamcommunity.com/sharedfiles/filedetails/?id=652925835\">Steam Workshop</a>";
				vResult += "<br/>";
				vResult += "<br/>";
				vResult += "The Way Ruleset v0.1<br/>";
				vResult += "<a href=\"http://htkb.dyndns.org/Downloads/Game_Rules/HTKB_SGS/The_Way_Game_Ruleset.pdf\">Download here.</a>";
			}else if(vPage == 2){
				vResult += "This section is dedicated to the board game project \"Sacred Offerings\".<br/>";
				vResult += "Being a god is hard, you have to eat, but don\"t want to fall out favor with the people more than the other deities.<br/>";
				vResult += "Draw people to worship you, but be discerning about who is sacrificed.<br/>";
				vResult += "<br/>";
				vResult += "You can download the Tabletop Simulator mod here:";
				vResult += "<a href=\"http://steamcommunity.com/sharedfiles/filedetails/?id=652957007\">Steam Workshop</a>";
				vResult += "<br/>";
				vResult += "<br/>";
				vResult += "Sacred Offerings Ruleset v0.1<br/>";
				vResult += "<a href=\"http://htkb.dyndns.org/Downloads/Game_Rules/HTKB_SGS/Sacred_Offerings_Game_Ruleset.pdf\">Download here.</a>";
			}else if(vPage == 3){
				vResult += "This section is dedicated to the board game project \"Conversion\".<br/>";
				vResult += "Compete on the elemental market by processing elements and becoming the elemental kingpin.<br/>";
				vResult += "<br/>";
				vResult += "You can download the Tabletop Simulator mod here:";
				vResult += "<a href=\"http://steamcommunity.com/sharedfiles/filedetails/?id=658966981\">Steam Workshop</a>";
				vResult += "<br/>";
				vResult += "<br/>";
				vResult += "Conversion Ruleset v0.1<br/>";
				vResult += "<a href=\"http://htkb.dyndns.org/Downloads/Game_Rules/HTKB_SGS/Conversion_Game_Ruleset.pdf\">Download here.</a>";
			}else if(vPage == 4){
				vResult += "This section is dedicated to the board game project \"Conspiratorium\".<br/>";
				vResult += "A game of assassins and CIA, you must remember who is friend and who is not.<br/>";
				vResult += "<br/>";
				vResult += "You can download the Tabletop Simulator mod here:";
				vResult += "<a href=\"http://steamcommunity.com/sharedfiles/filedetails/?id=656617895\">Steam Workshop</a>";
				vResult += "<br/>";
				vResult += "<br/>";
				vResult += "Conspiratorium Ruleset v0.1<br/>";
				vResult += "<a href=\"http://htkb.dyndns.org/Downloads/Game_Rules/HTKB_SGS/Conspiratorium_Game_Ruleset.pdf\">Download here.</a>";
			}else if(vPage == 5){
				vResult += "This section is dedicated to the card and board game project \"Monster Office Workplace\".<br/>";
				vResult += "These monsters mean serious business.<br/>";
				vResult += "Can you earn the most credit and smooze your way into a promotion?<br/>";
				vResult += "<br/>";
				vResult += "You can download the Tabletop Simulator mod here:<br/>";
				vResult += "<a href=\"http://steamcommunity.com/sharedfiles/filedetails/?id=691344800\">Steam Workshop</a><br/>";
				vResult += "<br/>";
				vResult += "<br/>";
				vResult += "Monster Office Ruleset v0.1<br/>";
				vResult += "<a href=\"http://htkb.dyndns.org/Downloads/Game_Rules/HTKB_SGS/Monster_Office_Workplace_Game_Ruleset.pdf\">Download here.</a>";
			}else if(vPage == 6){
				vResult += "This section is dedicated to the board game project \"MacCreedy's Mansion\".<br />";
				vResult += "Players compete in this worker placement to restore the great MacCreedy Mansion.<br />";
			}else if(vPage == 7){
				vResult += "This section is dedicated to the board game project \"Dundered Acre Woods\".<br />";
				vResult += "Animals prepare for the next Winter despite distractions in this dice draft and placement game.<br />";
			}else if(vPage == 8){
				vResult += "This section is dedicated to the board game project \"Conquer\".<br/>";
				vResult += "Battle other Kaiju for the right to rule over the ruins of a kingdom.";
			}else if(vPage == 9){
				vResult += "This section is dedicated CCG project \"Assault\".";
			}else if(vPage == 10){
				vResult += "This section is dedicated to the card game project \"Battle Princesses\".<br/>";
				vResult += "Ever wanted to see your favorite princess battle for the kingdom?<br/>";
				vResult += "These princess aren\"t your helpless maidens, but valiant warriors themselves.<br/>";
				vResult += "<br/>";
				vResult += "You can download the Tabletop Simulator mod here:";
				vResult += "<a href=\"http://steamcommunity.com/sharedfiles/filedetails/?id=1206167982\">Steam Workshop</a>";
				vResult += "<br/>";
				vResult += "<br/>";
				vResult += "Battle Princesses Ruleset v0.1<br/>";
				vResult += "<a href=\"http://htkb.dyndns.org/Downloads/Game_Rules/HTKB_SGS/Battle_Princesses_Game_Ruleset.pdf\">Download here.</a>";
			}else if(vPage == 11){
				vResult += "This section is dedicated to the board game project \"Armor Up\".<br/>";
				vResult += "Armor up your princess to battle the other princesses for the throne.";
			}else if(vPage == 12){
				vResult += "\"Gynowars: Battle Arena\" is a CCG that pits teams of creatures against each other"; 
				vResult += "in an arena-like environment.  There are several scenarios to run, to include:<br />";
				vResult += "\"Death Match\", \"Ring the Bell\", and \"Head Hunt\".";
			}else if(vPage == 13){
				vResult += "\"Land of the Orcish Empire: Age of Magic\" is a CCG based on the different factions that"; 
				vResult += "comprise the Grendol Empire.<br />";
			}else if(vPage == 14){
				vResult += "\"Coliseum: Arena\" is a CCG representing the gladitorial arenas of Grendol.";
			}else if(vPage == 15){
				vResult += "\"Nine Card\" is a Tactical card game played through the Elvia Empire.";
			}else if(vPage == 16){
				vResult += "\"Wars of Antarrea\" is a table-top game where two or more armies battle for supremacy.";
			}else if(vPage == 17){
				vResult += "This section is dedicated to the Antarrea RPG project.";
			}else if(vPage == 18){
				vResult += "This section is dedicated to the \"Super Dungeon Adventure\" RPG project.";
			}else{
				vResult += vDefault;
			}
		vResult += "</div>";

		return vResult;
	}

	public String getVersions(int vPage) {
		String vResult = "";
		String vDefault = "";

		vDefault += "<li><a href=\"http://htkb.dyndns.org/Division1/Index.html\">HTML</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/Division1/Index.php\">PHP</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/Division1/Index.shtml\">Perl</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/SSI/Division1/Index.html\">Apache SSI</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division1/Index.html\">HTML Javascript</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division1/Index.html\">JQuery</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division1/Index.html\">Angular JS</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/JSX/Division1/Index.html\">JSX</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org/XLST/Division1/Index.xml\">XSLT</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division1/Index.xhtml\">JSF</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division1/Index.jsp\">JSP</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division1/Index\">JSP Spring MVC</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division1/Index.aspx\">ASP.NET Javascript</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division1/Index.asp\">ASP VBscript</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division1/Index.cshtml\">ASP.NET Web App</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division1/Index.aspx\">ASP.NET Webform</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division1/Index\">ASP.NET MVC App</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:82/Division1/Index\">Python Web.py</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:83/Division1/Index\">Ruby on Rails</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:84/Division1/Index\">Node JS</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:85/Division1/Index\">Angular 2+</a></li>";
		vDefault += "<li><a href=\"http://htkb.dyndns.org:86/Division1/Index\">ReactJS</a></li>";

		vResult += "<ul class=\"versionsUl\">";
        
        if(vPage == 0){
			vResult += vDefault;
		}else if(vPage == 1){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project1.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project1.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project1.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division1/Project1.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division1/Project1.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division1/Project1.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division1/Project1.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division1/Project1.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division1/Project1.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division1/Project1.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division1/Project1.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division1/Project1\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division1/Project1.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division1/Project1.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division1/Project1.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division1/Project1.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division1/Project1\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division1/Project1\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division1/Project1\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division1/Project1\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division1/Project1\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division1/Project1\">ReactJS</a></li>";
		}else if(vPage == 2){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project2.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project2.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project2.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division1/Project2.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division1/Project2.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division1/Project2.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division1/Project2.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division1/Project2.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division1/Project2.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division1/Project2.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division1/Project2.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division1/Project2\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division1/Project2.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division1/Project2.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division1/Project2.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division1/Project2.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division1/Project2\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division1/Project2\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division1/Project2\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division1/Project2\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division1/Project2\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division1/Project2\">ReactJS</a></li>";
		}else if(vPage == 3){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project3.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project3.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project3.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division1/Project3.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division1/Project3.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division1/Project3.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division1/Project3.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division1/Project3.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division1/Project3.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division1/Project3.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division1/Project3.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division1/Project3\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division1/Project3.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division1/Project3.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division1/Project3.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division1/Project3.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division1/Project3\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division1/Project3\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division1/Project3\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division1/Project3\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division1/Project3\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division1/Project3\">ReactJS</a></li>";
		}else if(vPage == 4){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project4.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project4.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project4.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division1/Project4.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division1/Project4.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division1/Project4.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division1/Project4.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division1/Project4.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division1/Project4.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division1/Project4.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division1/Project4.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division1/Project4\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division1/Project4.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division1/Project4.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division1/Project4.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division1/Project4.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division1/Project4\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division1/Project4\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division1/Project4\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division1/Project4\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division1/Project4\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division1/Project4\">ReactJS</a></li>";
		}else if(vPage == 5){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project5.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project5.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project5.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division1/Project5.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division1/Project5.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division1/Project5.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division1/Project5.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division1/Project5.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division1/Project5.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division1/Project5.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division1/Project5.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division1/Project5\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division1/Project5.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division1/Project5.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division1/Project5.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division1/Project5.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division1/Project5\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division1/Project5\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division1/Project5\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division1/Project5\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division1/Project5\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division1/Project5\">ReactJS</a></li>";
		}else if(vPage == 6){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project6.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project6.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project6.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division1/Project6.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division1/Project6.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division1/Project6.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division1/Project6.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division1/Project6.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division1/Project6.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division1/Project6.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division1/Project6.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division1/Project6\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division1/Project6.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division1/Project6.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division1/Project6.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division1/Project6.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division1/Project6\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division1/Project6\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division1/Project6\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division1/Project6\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division1/Project6\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division1/Project6\">ReactJS</a></li>";
		}else if(vPage == 7){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project7.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project7.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project7.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division1/Project7.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division1/Project7.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division1/Project7.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division1/Project7.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division1/Project7.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division1/Project7.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division1/Project7.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division1/Project7.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division1/Project7\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division1/Project7.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division1/Project7.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division1/Project7.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division1/Project7.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division1/Project7\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division1/Project7\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division1/Project7\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division1/Project7\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division1/Project7\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division1/Project7\">ReactJS</a></li>";
		}else if(vPage == 8){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project8.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project8.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project8.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division1/Project8.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division1/Project8.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division1/Project8.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division1/Project8.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division1/Project8.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division1/Project8.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division1/Project8.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division1/Project8.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division1/Project8\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division1/Project8.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division1/Project8.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division1/Project8.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division1/Project8.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division1/Project8\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division1/Project8\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division1/Project8\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division1/Project8\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division1/Project8\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division1/Project8\">ReactJS</a></li>";
		}else if(vPage == 9){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project9.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project9.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project9.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division1/Project9.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division1/Project9.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division1/Project9.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division1/Project9.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division1/Project9.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division1/Project9.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division1/Project9.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division1/Project9.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division1/Project9\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division1/Project9.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division1/Project9.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division1/Project9.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division1/Project9.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division1/Project9\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division1/Project9\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division1/Project9\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division1/Project9\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division1/Project9\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division1/Project9\">ReactJS</a></li>";
		}else if(vPage == 10){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project10.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project10.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project10.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division1/Project10.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division1/Project10.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division1/Project10.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division1/Project10.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division1/Project10.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division1/Project10.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division1/Project10.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division1/Project10.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division1/Project10\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division1/Project10.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division1/Project10.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division1/Project10.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division1/Project10.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division1/Project10\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division1/Project10\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division1/Project10\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division1/Project10\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division1/Project10\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division1/Project10\">ReactJS</a></li>";
		}else if(vPage == 11){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project11.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project11.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project11.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division1/Project11.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division1/Project11.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division1/Project11.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division1/Project11.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division1/Project11.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division1/Project11.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division1/Project11.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division1/Project11.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division1/Project11\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division1/Project11.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division1/Project11.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division1/Project11.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division1/Project11.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division1/Project11\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division1/Project11\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division1/Project11\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division1/Project11\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division1/Project11\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division1/Project11\">ReactJS</a></li>";
		}else if(vPage == 12){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project12.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project12.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project12.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division1/Project12.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division1/Project12.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division1/Project12.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division1/Project12.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division1/Project12.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division1/Project12.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division1/Project12.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division1/Project12.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division1/Project12\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division1/Project12.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division1/Project12.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division1/Project12.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division1/Project12.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division1/Project12\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division1/Project12\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division1/Project12\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division1/Project12\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division1/Project12\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division1/Project12\">ReactJS</a></li>";
		}else if(vPage == 13){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project13.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project13.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project13.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division1/Project13.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division1/Project13.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division1/Project13.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division1/Project13.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division1/Project13.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division1/Project13.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division1/Project13.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division1/Project13.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division1/Project13\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division1/Project13.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division1/Project13.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division1/Project13.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division1/Project13.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division1/Project13\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division1/Project13\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division1/Project13\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division1/Project13\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division1/Project13\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division1/Project13\">ReactJS</a></li>";
		}else if(vPage == 14){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project14.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project14.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project14.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division1/Project14.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division1/Project14.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division1/Project14.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division1/Project14.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division1/Project14.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division1/Project14.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division1/Project14.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division1/Project14.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division1/Project14\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division1/Project14.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division1/Project14.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division1/Project14.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division1/Project14.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division1/Project14\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division1/Project14\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division1/Project14\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division1/Project14\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division1/Project14\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division1/Project14\">ReactJS</a></li>";
		}else if(vPage == 15){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project15.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project15.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project15.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division1/Project15.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division1/Project15.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division1/Project15.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division1/Project15.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division1/Project15.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division1/Project15.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division1/Project15.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division1/Project15.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division1/Project15\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division1/Project15.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division1/Project15.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division1/Project15.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division1/Project15.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division1/Project15\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division1/Project15\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division1/Project15\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division1/Project15\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division1/Project15\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division1/Project15\">ReactJS</a></li>";
		}else if(vPage == 16){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project16.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project16.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project16.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division1/Project16.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division1/Project16.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division1/Project16.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division1/Project16.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division1/Project16.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division1/Project16.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division1/Project16.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division1/Project16.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division1/Project16\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division1/Project16.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division1/Project16.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division1/Project16.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division1/Project16.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division1/Project16\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division1/Project16\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division1/Project16\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division1/Project16\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division1/Project16\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division1/Project16\">ReactJS</a></li>";
		}else if(vPage == 17){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project17.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project17.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project17.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division1/Project17.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division1/Project17.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division1/Project17.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division1/Project17.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division1/Project17.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division1/Project17.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division1/Project17.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division1/Project17.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division1/Project17\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division1/Project17.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division1/Project17.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division1/Project17.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division1/Project17.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division1/Project17\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division1/Project17\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division1/Project17\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division1/Project17\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division1/Project17\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division1/Project17\">ReactJS</a></li>";
		}else if(vPage == 18){
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project18.html\">HTML</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project18.php\">PHP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Division1/Project18.shtml\">Perl</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/SSI/Division1/Project18.html\">Apache SSI</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/Javascript/Division1/Project18.html\">HTML Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JQuery/Division1/Project18.html\">JQuery</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/AngularJS/Division1/Project18.html\">Angular JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/JSX/Division1/Project18.html\">JSX</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org/XLST/Division1/Project18.xml\">XSLT</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSFApplication/Division1/Project18.xhtml\">JSF</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/JSPApplication/Division1/Project18.jsp\">JSP</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:8080/SpringMVC/Division1/Project18\">JSP Spring MVC</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASPNET/Division1/Project18.aspx\">ASP.NET Javascript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/ASP/Division1/Project18.asp\">ASP VBscript</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebApplication/Division1/Project18.cshtml\">ASP.NET Web App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/WebForm/Division1/Project18.aspx\">ASP.NET Webform</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:81/MVC/Division1/Project18\">ASP.NET MVC App</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:82/Division1/Project18\">Python Web.py</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:83/Division1/Project18\">Ruby on Rails</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:84/Division1/Project18\">Node JS</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:85/Division1/Project18\">Angular 2+</a></li>";
			vResult += "<li><a href=\"http://htkb.dyndns.org:86/Division1/Project18\">ReactJS</a></li>";
		}else{
			vResult += vDefault;
		}

        vResult += "</ul>";
        
        return vResult;
	}
}
