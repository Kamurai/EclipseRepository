package section1.section5;

public class Layout extends main.Layout
{
    public Layout(Custom vCustom)
    {
    	super(vCustom);
    }

    public String Navigation(int vLevel)
    {
        String Result = "";
        Result += "<a class=\"navlinkA\" href='http://htkb.dyndns.org/Section1/Index.html'>Basic HTML</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='http://htkb.dyndns.org/Section1/Index.php'>PHP</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Section1/Section2/Index'>Javascript</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='http://htkb.dyndns.org/Section1/Index.shtml'>Perl</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Section1/Section4/Index'>Java</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Section1/Section5/Index'>ASP.Net</a><br/><br/>";
            Result += "<a class=\"navlinkB\" href='http://htkb.dyndns.org:81/WebApplication/Section1/Section5/Index.cshtml'>Webpage Application</a><br/><br/>";
            Result += "<a class=\"navlinkB\" href='http://htkb.dyndns.org:81/WebForm/Section1/Section5/Index.aspx'>Webform Application</a><br/><br/>";
            Result += "<a class=\"navlinkB\" href='http://htkb.dyndns.org:81/MVC/Section1_5/Index'>MVC Application</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Section1/Section6/Index'>Databases</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href=\"http://htkb.dyndns.org/SSI/Section1/Index.html\">Apache SSI</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href=\"http://htkb.dyndns.org:82/Section1/Index\">Python Web.py</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href=\"http://htkb.dyndns.org:83/Section1/Index\">Ruby on Rails</a><br/><br/>";
        return Result;
    }

    public String WriteWebpage(int vPage, int vLevel)
    {
        String Result = "";
        Result += "<body id=\"idBody\">";
            Result += "<table id=\"idTableMain\">";
                Result += "<tr id=\"idHeaderRow\">";
                    Result += "<td id=\"idHeaderRowCenter\" colspan=\"3\">";
                        Result += vUniversal.TitlePicture(vLevel);
                    Result += "</td>";
                Result += "</tr>";
                Result += "<tr id=\"idNavigationRow\">";
                    Result += "<td id=\"idNavigationBar\" colspan=\"3\">";
                        Result += vUniversal.NavBar(vLevel);
                    Result += "</td>";
                Result += "</tr>";
                Result += "<tr id=\"idCenterRow\">";
                    Result += "<td id=\"idCenterRowLeft\">";
                        Result += "<h4>";
                            Result += "Navigation";
                        Result += "</h4>";
                        Result += Navigation(vLevel);
                    Result += "</td>";
                    Result += "<td id=\"idCenterRowMain\">";
                        Result += vCustom.Title(vPage);
                        Result += vCustom.Header(vPage);
                        Result += vCustom.Content(vPage);
                    Result += "</td>";
                    Result += "<td id=\"idCenterRowRight\">";
                        Result += "<h4>";
                            Result += "Information";
                        Result += "</h4>";
                        Result += vUniversal.Information();
                        Result += vCustom.Versions(vPage);
                    Result += "</td>";
                Result += "</tr>";
                Result += "<tr id=\"idFooterRow\">";
                    Result += "<td id=\"idFooterMain\" colspan=\"3\">";
                            Result += "<p id=\"idFooterContent\">";
                                Result += vUniversal.Footer();
                            Result += "</p>";
                            Result += "<p id=\"idFooterContent\">";
                                    Result += vUniversal.WebMaster();
                            Result += "</p>";
                    Result += "</td>";
                Result += "</tr>";
            Result += "</table>";
        Result += "</body>";
        return Result;
    }
}
