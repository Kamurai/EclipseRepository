package division2.section1;

public class Layout extends main.Layout
{
    public Layout(Custom vCustom)
    {
        super(vCustom);
    }

    private String getNavigation(int vLevel)
    {
        String vResult = "";
		
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"Division2/Section1/Index'>Gynowars</a><br/><br/>";
            vResult += "<a class=\"navlinkB\" href='"+vUniversal.getPath(vLevel)+"Division2/Section1/Project1'>Gynowars RPG</a><br/><br/>";
            vResult += "<a class=\"navlinkB\" href='"+vUniversal.getPath(vLevel)+"Division2/Section1/Project2'>Gynowars: Battle Arena CCG</a><br/><br/>";
            vResult += "<a class=\"navlinkB\" href='"+vUniversal.getPath(vLevel)+"Division2/Section1/Project3'>Gynowars: Crash Ball</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"Division2/Project2'>Assault</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"Division2/Project3'>Mars</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"Division2/Section4/Index'>Renley</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"Division2/Section5/Index'>Antarrea</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"Division2/Project6'>Truth</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"Division2/Project7'>Kingdoms</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"Division2/Project8'>Terminal World</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"Division2/Project9'>Monster Office Workplace</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"Division2/Project10'>Battle Princesses</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"Division2/Project11'>Sacred Offerings</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"Division2/Project12'>The Way</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"Division2/Project13'>Conspiratorium</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"Division2/Project14'>Conversion</a><br/><br/>";
        
		return vResult;
    }

    public String getBody(int vPage, int vLevel)
    {
        String vResult = "";
		
        vResult += "<body id=\"idBody\">";
            vResult += "<table id=\"idTableMain\">";
                vResult += "<tr id=\"idHeaderRow\">";
                    vResult += "<td id=\"idHeaderRowCenter\" colspan=\"3\">";
                        vResult += vUniversal.getLogo(vLevel);
                    vResult += "</td>";
                vResult += "</tr>";
                vResult += "<tr id=\"idNavigationRow\">";
                    vResult += "<td id=\"idNavigationBar\" colspan=\"3\">";
                        vResult += vUniversal.getNavBar(vLevel);
                    vResult += "</td>";
                vResult += "</tr>";
                vResult += "<tr id=\"idCenterRow\">";
                    vResult += "<td id=\"idCenterRowLeft\">";
                    	vResult += vUniversal.getNavigationHeader();
                        vResult += getNavigation(vLevel);
                    vResult += "</td>";
                    vResult += "<td id=\"idCenterRowMain\">";
                        vResult += vCustom.getTitle(vPage);
                        vResult += vCustom.getContentHeader(vPage);
                        vResult += vCustom.getContent(vPage);
                    vResult += "</td>";
                    vResult += "<td id=\"idCenterRowRight\">";
                    	vResult += vUniversal.getInformationHeader();
                        vResult += vUniversal.getInformation();
                        vResult += vCustom.getVersions(vPage);
                    vResult += "</td>";
                vResult += "</tr>";
                vResult += "<tr id=\"idFooterRow\">";
                    vResult += "<td id=\"idFooterMain\" colspan=\"3\">";
		                vResult += vUniversal.getFooter();
		                vResult += vUniversal.getWebMaster();
                    vResult += "</td>";
                vResult += "</tr>";
            vResult += "</table>";
        vResult += "</body>";
		
        return vResult;
    }
}
