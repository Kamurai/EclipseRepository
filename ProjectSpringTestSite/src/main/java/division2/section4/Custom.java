package division2.section4;

import division2.*;

public class Custom extends main.Custom
{
    main.Universal vUniversal;

    public Custom()
    {
        super();
    }

    public String getTitle(int vPage)
    {
        String vResult = "";
		String vDefault = "";
		
		vDefault += "Renley";
		
        vResult += "<title>";
            if(vPage == 0)
            {
                vResult += vDefault;
            }
            else if(vPage == 1)
            {
                vResult += "Warring Nations";
            }
            else if(vPage == 2)
            {
                vResult += "Psychodom: The One Empire";
            }
			else
			{
				vResult += vDefault;
			}
        vResult += "</title>";
		
        return vResult;
    }

    public String getContentHeader(int vPage)
    {
        String vResult = "";
		String vDefault = "";
		
		vDefault += "Renley";
		
        vResult += "<h2>";
			if(vPage == 0)
			{
				vResult += vDefault;
			}
			else if(vPage == 1)
			{
				vResult += "Warring Nations";
			}
			else if(vPage == 2)
			{
				vResult += "Psychodom: The One Empire";
			}
			else
			{
				vResult += vDefault;
			}
        vResult += "</h2>";
        
        return vResult;
    }

    public String getContent(int vPage)
    {
        String vResult = "";
		String vDefault = "";
		
		vDefault += "This section is dedicated to projects centered in the Renley universe.";
		
        vResult += "<p id=\"idCenterContent\">";
            if(vPage == 0)
            {
                vResult += vDefault;
            }
            else if(vPage == 1)
            {
                vResult += "Warring Nations is a Tactical RPG involving squad based battles.";
                vResult += "Characters advance classes based on their weapon proficiencies and/or currently equipped weapons.";
            }
            else if(vPage == 2)
            {
                vResult += "Psychodom: The One Empire is a 3rd person perspective Adventure / RPG.";
                vResult += "The protagonist is tasked with investigating various situations leading ";
                vResult += "to a conspiracy about who is really ruling the continent.";
            }
			else
			{
				vResult += vDefault;
			}
        vResult += "</p>";
		
        return vResult;
    }
    
    public String getVersions(int vPage)
    {
        String vResult = "";
		String vDefault = "";
		
		vDefault += "<a href=\"http://htkb.dyndns.org/Section2/Section4/Index.html\">HTML</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org/Section2/Section4/Index.php\">PHP</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org/Javascript/Section2/Section4/Index.html\">HTML Javascript</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org/JQuery/Section2/Section4/Index.html\">JQuery</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org:81/ASP/Section2/Section4/Index.asp\">ASP Javascript</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org:81/ASPNET/Section2/Section4/Index.aspx\">ASP.NET Javascript</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section2/Section4/Index.aspx\">ASP.NET Webform</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org:84/Section2/Section4/Index\">Node JS</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org/Section2/Section4/Index.shtml\">Perl</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org:8080/JSPApplication/Section2/Section4/Index.jsp\">JSP</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org:8080/JSFApplication/Section2/Section4/Index.xhtml\">JSF</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org:81/WebApplication/Section2/Section4/Index.cshtml\">ASP.NET Web App</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section2/Section4/Index.aspx\">ASP.NET Webform</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org:81/MVC/Section2/Section4/Index\">ASP.NET MVC App</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org/SSI/Section2/Section4/Index.html\">Apache SSI</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org:82/Section2/Section4/Index\">Python Web.py</a><br/>";
		vDefault += "<a href=\"http://htkb.dyndns.org:83/Section2/Section4/Index\">Ruby on Rails</a><br/>";
			
        if(vPage == 0)
        {
            vResult += vDefault;
        }
        else if(vPage == 1)
        {
            vResult += "<a href=\"http://htkb.dyndns.org/Section2/Section4/Project1.html\">HTML</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org/Section2/Section4/Project1.php\">PHP</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org/Javascript/Section2/Section4/Project1.html\">HTML Javascript</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org/JQuery/Section2/Section4/Project1.html\">JQuery</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org:81/ASP/Section2/Section4/Project1.asp\">ASP Javascript</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org:81/ASPNET/Section2/Section4/Project1.aspx\">ASP.NET Javascript</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section2/Section4/Project1.aspx\">ASP.NET Webform</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org:84/Section2/Section4/Project1\">Node JS</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org/Section2/Section4/Project1.shtml\">Perl</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org:8080/JSPApplication/Section2/Section4/Section2/Section4/Project1.jsp\">JSP</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org:8080/JSFApplication/Section2/Section4/Project1.xhtml\">JSF</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org:81/WebApplication/Section2/Section4/Project1.cshtml\">ASP.NET Web App</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section2/Section4/Project1.aspx\">ASP.NET Webform</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org:81/MVC/Section2/Section4/Project1\">ASP.NET MVC App</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org/SSI/Section2/Section4/Project1.html\">Apache SSI</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org:82/Section2/Section4/Project1\">Python Web.py</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org:83/Section2/Section4/Project1\">Ruby on Rails</a><br/>";
        }
        else if(vPage == 2)
        {
            vResult += "<a href=\"http://htkb.dyndns.org/Section2/Section4/Project2.html\">HTML</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org/Section2/Section4/Project2.php\">PHP</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org/Javascript/Section2/Section4/Project2.html\">HTML Javascript</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org/JQuery/Section2/Section4/Project2.html\">JQuery</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org:81/ASP/Section2/Section4/Project2.asp\">ASP Javascript</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org:81/ASPNET/Section2/Section4/Project2.aspx\">ASP.NET Javascript</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org:84/Section2/Section4/Project2\">Node JS</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org/Section2/Section4/Project2.shtml\">Perl</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org:8080/JSFApplication/Section2/Section4/Project2.xhtml\">JSF</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org:81/WebApplication/Section2/Section4/Project2.cshtml\">ASP.NET Web App</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section2/Section4/Project2.aspx\">ASP.NET Webform</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org:81/MVC/Main/Section2/Section4/Project2\">ASP.NET MVC App</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org/SSI/Section2/Section4/Project2.html\">Apache SSI</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org:82/Section2/Section4/Project2\">Python Web.py</a><br/>";
            vResult += "<a href=\"http://htkb.dyndns.org:83/Section2/Section4/Project2\">Ruby on Rails</a><br/>";
        }
		else
		{
			vResult += vDefault;
		}
		
        return vResult;
    }
}
