package division2.section5.section3;

public class Layout extends main.Layout
{
    public Layout(Custom vCustom)
    {
        super(vCustom);
    }

    public String Navigation(int vLevel)
    {
        String vResult = "";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Division2/Section1/Index'>Gynowars</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Division2/Project2'>Assault</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Division2/Project3'>Mars</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Division2/Section4/Index'>Renley</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Division2/Section5/Index'>Antarrea</a><br/><br/>";
            vResult += "<a class=\"navlinkB\" href='"+vUniversal.GetPath(vLevel)+"Division2/Section5/Section1/Index'>Global</a><br/><br/>";
            vResult += "<a class=\"navlinkB\" href='"+vUniversal.GetPath(vLevel)+"Division2/Section5/Section2/Index'>Grendol</a><br/><br/>";
            vResult += "<a class=\"navlinkB\" href='"+vUniversal.GetPath(vLevel)+"Division2/Section5/Section3/Index'>Utopia</a><br/><br/>";
                vResult += "<a class=\"navlinkC\" href='"+vUniversal.GetPath(vLevel)+"Division2/Section5/Section3/Project1'>Avia:Elemental Angels</a><br/><br/>";
            vResult += "<a class=\"navlinkB\" href='"+vUniversal.GetPath(vLevel)+"Division2/Section5/Section4/Index'>Elvia</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Division2/Project6'>Truth</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Division2/Project7'>Kingdoms</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Division2/Project8'>Terminal World</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Division2/Project9'>Monster Office Workplace</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Division2/Project10'>Battle Princesses</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Division2/Project11'>Sacred Offerings</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Division2/Project12'>The Way</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Division2/Project13'>Conspiratorium</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Division2/Project14'>Conversion</a><br/><br/>";
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
