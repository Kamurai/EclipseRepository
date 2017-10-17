package division1.section4;

public class Custom extends main.Custom
{
    public Custom()
    {
        super();
    }

    public String Title(int vPage)
    {
        String Result = "";
        Result += "<title>";
            if(vPage == 0)
            {
                Result += "Java Programming";
            }
            else if(vPage == 1)
            {
                Result += "JSP Programming";
            }
        Result += "</title>";
        return Result;
    }

    public String Header(int vPage)
    {
        String Result = "";
        Result += "<h2>";
        if(vPage == 0)
        {
            Result += "Java Programming";
        }
        else if(vPage == 1)
        {
            Result += "JSP Programming";
        }
        Result += "</h2>";
        
        return Result;
    }

    public String Content(int vPage)
    {
        String Result = "";
        Result += "<p id=\"idCenterContent\">";
            if(vPage == 0)
            {
                Result += "This section is dedicated to Java based programming.";
            }
            else if(vPage == 1)
            {
                Result += "This section is dedicated to JSP based programming.";
            }
        Result += "</p>";
        return Result;
    }
    
    public String Versions(int vPage)
    {
        String Result = "";
        if(vPage == 0)
        {
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section4/Index.html\">HTML</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section4/Index.php\">PHP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Javascript/Section1/Section4/Index.html\">HTML Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/JQuery/Section1/Section4/Index.html\">JQuery</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASP/Section1/Section4/Index.asp\">ASP Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASPNET/Section1/Section4/Index.aspx\">ASP.NET Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section1/Section4/Index.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:84/Section1/Section4/Index\">Node JS</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section4/Index.shtml\">Perl</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSPApplication/Section1/Section4/Index.jsp\">JSP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSFApplication/Section1/Section4/Index.xhtml\">JSF</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebApplication/Section1/Section4/Index.cshtml\">ASP.NET Web App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section1/Section4/Index.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/MVC/Section1/Section4/Index\">ASP.NET MVC App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/SSI/Section1/Section4/Index.html\">Apache SSI</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:82/Section1/Section4/Index\">Python Web.py</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:83/Section1/Section4/Index\">Ruby on Rails</a><br/>";
        }
        else if(vPage == 1)
        {
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section4/Project1.html\">HTML</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section4/Project1.php\">PHP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Javascript/Section1/Section4/Project1.html\">HTML Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/JQuery/Section1/Section4/Project1.html\">JQuery</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASP/Section1/Section4/Project1.asp\">ASP Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASPNET/Section1/Section4/Project1.aspx\">ASP.NET Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section1/Section4/Project1.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:84/Section1/Section4/Project1\">Node JS</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section4/Project1.shtml\">Perl</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSPApplication/Section1/Section4/Project1.jsp\">JSP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSFApplication/Section1/Section4/Project1.xhtml\">JSF</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebApplication/Section1/Section4/Project1.cshtml\">ASP.NET Web App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section1/Section4/Project1.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/MVC/Section1/Section4/Project1\">ASP.NET MVC App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/SSI/Section1/Section4/Project1.html\">Apache SSI</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:82/Section1/Section4/Project1\">Python Web.py</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:83/Section1/Section4/Project1\">Ruby on Rails</a><br/>";
        }
        return Result;
    }
}
