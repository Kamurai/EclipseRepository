package division1.section2;

public class Layout extends main.Layout
{
    public Layout(Custom vCustom)
    {
        super(vCustom);
    }

    public String Navigation(int vLevel)
    {
        String vResult = "";
        vResult += "<a class=\"navlinkA\" href='http://htkb.dyndns.org/Division1/Index.html'>Basic HTML</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='http://htkb.dyndns.org/Division1/Index.php'>PHP</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Division1/Section2/Index'>Javascript</a><br/><br/>";
            vResult += "<a class=\"navlinkB\" href='http://htkb.dyndns.org/Javascript/Division1/Section2/Index.html'>HTML Javascript</a><br/><br/>";
            vResult += "<a class=\"navlinkB\" href='http://htkb.dyndns.org/JQuery/Division1/Section2/Index.html'>JQuery</a><br/><br/>";
            vResult += "<a class=\"navlinkB\" href='http://htkb.dyndns.org:81/ASP/Division1/Section2/Index.asp'>ASP Javascript</a><br/><br/>";
            vResult += "<a class=\"navlinkB\" href='http://htkb.dyndns.org:81/ASPNET/Division1/Section2/Index.aspx'>ASP.NET Javascript</a><br/><br/>";
            vResult += "<a class=\"navlinkB\" href=\"http://htkb.dyndns.org:84/Division1/Index\">Node JS</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='http://htkb.dyndns.org/Division1/Index.shtml'>Perl</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Division1/Section4/Index'>Java</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Division1/Section5/Index'>ASP.Net</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Division1/Section6/Index'>Databases</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href=\"http://htkb.dyndns.org/SSI/Division1/Index.html\">Apache SSI</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href=\"http://htkb.dyndns.org:82/Division1/Index\">Python Web.py</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href=\"http://htkb.dyndns.org:83/Division1/Index\">Ruby on Rails</a><br/><br/>";
        return vResult;
    }

    public String WriteWebpage(int vPage, int vLevel)
    {
        String vResult = "";
        vResult += "<body id=\"idBody\">";
            vResult += "<table id=\"idTableMain\">";
                vResult += "<tr id=\"idHeaderRow\">";
                    vResult += "<td id=\"idHeaderRowCenter\" colspan=\"3\">";
                        vResult += vUniversal.TitlePicture(vLevel);
                    vResult += "</td>";
                vResult += "</tr>";
                vResult += "<tr id=\"idNavigationRow\">";
                    vResult += "<td id=\"idNavigationBar\" colspan=\"3\">";
                        vResult += vUniversal.NavBar(vLevel);
                    vResult += "</td>";
                vResult += "</tr>";
                vResult += "<tr id=\"idCenterRow\">";
                    vResult += "<td id=\"idCenterRowLeft\">";
                    	vResult += vUniversal.NavigationHeader();
                    	vResult += Navigation(vLevel);
                    vResult += "</td>";
                    vResult += "<td id=\"idCenterRowMain\">";
                        vResult += vCustom.Title(vPage);
                        vResult += vCustom.Header(vPage);
                        vResult += vCustom.Content(vPage);
                    vResult += "</td>";
                    vResult += "<td id=\"idCenterRowRight\">";
                    	vResult += vUniversal.InformationHeader();
                        vResult += vUniversal.Information();
                        vResult += vCustom.Versions(vPage);
                    vResult += "</td>";
                vResult += "</tr>";
                vResult += "<tr id=\"idFooterRow\">";
                    vResult += "<td id=\"idFooterMain\" colspan=\"3\">";
                            vResult += "<p id=\"idFooterContent\">";
                                vResult += vUniversal.Footer();
                            vResult += "</p>";
                            vResult += "<p id=\"idFooterContent\">";
                                    vResult += vUniversal.WebMaster();
                            vResult += "</p>";
                    vResult += "</td>";
                vResult += "</tr>";
            vResult += "</table>";
        vResult += "</body>";
        return vResult;
    }
}
