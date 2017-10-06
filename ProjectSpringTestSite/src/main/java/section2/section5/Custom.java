package section2.section5;

public class Custom extends master.Custom
{
    public Custom()
    {
        super();
    }

    public String Title(int input)
    {
        String Result = "";
        Result += "<title>";
            if(input == 0)
            {
                Result += "Antarrea Projects";
            }

        Result += "</title>";
        return Result;
    }

    public String Header(int input)
    {
        String Result = "";
        Result += "<h2>";
        if(input == 0)
        {
            Result += "Antarrea Projects";
        }
        Result += "</h2>";
        
        return Result;
    }

    public String Content(int input)
    {
        String Result = "";
        Result += "<p id=\"idCenterContent\">";
            if(input == 0)
            {
                                Result += "Global:";
                Result += "<br/>";
                Result += "<br/>";
                        Result += "Here are projects based in the Antarrea universe:</br>";
                        Result += "</br>";
                        Result += "Team Tactical: Crash Ball:               Tactical board game centered on a battle version of football.</br>";
                        Result += "Wars of Antarrea:                        Table-top game where two or more armies battle for supremacy.</br>";
                        Result += "Revolutions: Invading Nations:           Tactical RPG, 1st story arc.</br>";
                        Result += "Revolutions: Rebellion Against the Fist: Tactical RPG, 2nd story arc.</br>";
                        Result += "Revolutions: Return to Arms:             Tactical RPG, 3rd story arc.</br>";
                        Result += "Revoultions: Post Wars:                  Tactical RPG, 4th story arc.</br>";
                Result += "<br/>";
                Result += "<br/>";
                                Result += "Grendol:";
                Result += "<br/>";
                Result += "<br/>";
                        Result += "Here are projects based in the Grendol universe:</br>";
                        Result += "</br>";
                        Result += "Grendol: Land of the Orcish Empire: Age of Magic: CCG.</br>";
                        Result += "Grendol: Coliseum: Arena:                         CCG.</br>";
                Result += "<br/>";
                Result += "<br/>";
                                Result += "Utopia:";
                Result += "<br/>";
                Result += "<br/>";
                        Result += "Here are projects based in the Utopia universe:</br>";
                        Result += "</br>";
                        Result += "Avia: Elemental Angels: Adventure game with RPG elements.</br>";
                Result += "<br/>";
                Result += "<br/>";
                                Result += "Elvia:";
                Result += "<br/>";
                Result += "<br/>";
                        Result += "Here are projects based in the Elvia universe:</br>";
                        Result += "</br>";
                        Result += "Nine Card: Tactical card game.</br>";
            }
        Result += "</p>";
        return Result;
    }
    
    public String Versions(int input)
    {
        String Result = "";
        if(input == 0)
        {
            Result += "<a href=\"http://htkb.dyndns.org/Section2/Section5/Index.html\">HTML</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Section2/Section5/Index.php\">PHP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Javascript/Section2/Section5/Index.html\">HTML Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASP/Section2/Section5/Index.asp\">ASP Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASPNET/Section2/Section5/Index.aspx\">ASP.NET Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Section2/Section5/Index.shtml\">Perl</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSPApplication/Section2/Section5/Index.jsp\">JSP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSFApplication/Section2/Section5/Index.xhtml\">JSF</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebApplication/Section2/Section5/Index.cshtml\">ASP.NET Web App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section2/Section5/Index.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/MVC/Section2/Section5/Index\">ASP.NET MVC App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/SSI/Section2/Section5/Index.html\">Apache SSI</a><br/>";
        }
        return Result;
    }
}
