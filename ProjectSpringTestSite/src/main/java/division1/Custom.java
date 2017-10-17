package division1;

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
                Result += "Web Programming";
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
            Result += "Web Programming";
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
                Result += "This section is dedicated to web-based programming.";
            }
        Result += "</p>";
        return Result;
    }
    
    public String Versions(int vPage)
    {
        String Result = "";
        if(vPage == 0)
        {
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Index.html\">HTML</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Index.php\">PHP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Javascript/Section1/Index.html\">HTML Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/JQuery/Section1/Index.html\">JQuery</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASP/Section1/Index.asp\">ASP Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASPNET/Section1/Index.aspx\">ASP.NET Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section1/Index.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:84/Section1/Index\">Node JS</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Index.shtml\">Perl</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSPApplication/Section1/Index.jsp\">JSP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSFApplication/Section1/Index.xhtml\">JSF</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebApplication/Section1/Index.cshtml\">ASP.NET Web App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section1/Index.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/MVC/Section1/Index\">ASP.NET MVC App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/SSI/Section1/Index.html\">Apache SSI</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:82/Section1/Index\">Python Web.py</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:83/Section1/Index\">Ruby on Rails</a><br/>";
        }
        return Result;
    }
}