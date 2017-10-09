package section1.section4;

public class Layout extends master.Layout
{
    public Layout(Custom custom)
    {
    	super(custom);
    }

    public String Navigation(int level, int extension)
    {
        String Result = "";
        Result += "<a class=\"navlinkA\" href='http://htkb.dyndns.org/Section1/Index.html'>Basic HTML</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='http://htkb.dyndns.org/Section1/Index.php'>PHP</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section1/Section2/Index'>Javascript</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='http://htkb.dyndns.org/Section1/Index.shtml'>Perl</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section1/Section4/Index'>Java</a><br/><br/>";
            Result += "<a class=\"navlinkB\" href='"+universal.GetPath(level)+"Section1/Section4/Index'>JSP Spring MVC</a><br/><br/>";
            Result += "<a class=\"navlinkB\" href='http://htkb.dyndns.org:8080/JSPApplication/Section1/Section4/Index.jsp'>JSF</a><br/><br/>";
            Result += "<a class=\"navlinkB\" href='http://htkb.dyndns.org:8080/JSFApplication/Section1/Section4/Index.xhtml'>JSF</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section1/Section5/Index'>ASP.Net</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section1/Section6/Index'>Databases</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href=\"http://htkb.dyndns.org/SSI/Section1/Index.html\">Apache SSI</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href=\"http://htkb.dyndns.org:82/Section1/Index\">Python Web.py</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href=\"http://htkb.dyndns.org:83/Section1/Index\">Ruby on Rails</a><br/><br/>";
        return Result;
    }

    public String WriteWebpage(int input, int level, int extension)
    {
        String Result = "";
        Result += "<body id=\"idBody\">";
            Result += "<table id=\"idTableMain\">";
                Result += "<tr id=\"idHeaderRow\">";
                    Result += "<td id=\"idHeaderRowCenter\" colspan=\"3\">";
                        Result += universal.TitlePicture(level);
                    Result += "</td>";
                Result += "</tr>";
                Result += "<tr id=\"idNavigationRow\">";
                    Result += "<td id=\"idNavigationBar\" colspan=\"3\">";
                        Result += universal.NavBar(level, extension);
                    Result += "</td>";
                Result += "</tr>";
                Result += "<tr id=\"idCenterRow\">";
                    Result += "<td id=\"idCenterRowLeft\">";
                        Result += "<h4>";
                            Result += "Navigation";
                        Result += "</h4>";
                        Result += Navigation(level, extension);
                    Result += "</td>";
                    Result += "<td id=\"idCenterRowMain\">";
                        Result += custom.Title(input);
                        Result += custom.Header(input);
                        Result += custom.Content(input);
                    Result += "</td>";
                    Result += "<td id=\"idCenterRowRight\">";
                        Result += "<h4>";
                            Result += "Information";
                        Result += "</h4>";
                        Result += universal.Information();
                        Result += custom.Versions(input);
                    Result += "</td>";
                Result += "</tr>";
                Result += "<tr id=\"idFooterRow\">";
                    Result += "<td id=\"idFooterMain\" colspan=\"3\">";
                            Result += "<p id=\"idFooterContent\">";
                                Result += universal.Footer();
                            Result += "</p>";
                            Result += "<p id=\"idFooterContent\">";
                                    Result += universal.WebMaster();
                            Result += "</p>";
                    Result += "</td>";
                Result += "</tr>";
            Result += "</table>";
        Result += "</body>";
        return Result;
    }
}
