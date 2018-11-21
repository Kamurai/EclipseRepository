package division2.section5;

public class Layout extends main.Layout {
	public Layout(Custom vCustom) {
		super(vCustom);
	}

	private String getNavigation(int vLevel) {
		String vResult = "";

		vResult += "<a class=\"navlinkA\" href='" + vUniversal.getPath(vLevel) + "Division2/Section1/Index'>Gynowars</a><br/><br/>";
		vResult += "<a class=\"navlinkA\" href='" + vUniversal.getPath(vLevel) + "Division2/Project2'>Assault</a><br/><br/>";
		vResult += "<a class=\"navlinkA\" href='" + vUniversal.getPath(vLevel) + "Division2/Project3'>Mars</a><br/><br/>";
		vResult += "<a class=\"navlinkA\" href='" + vUniversal.getPath(vLevel) + "Division2/Section4/Index'>Renley</a><br/><br/>";
		vResult += "<a class=\"navlinkA\" href='" + vUniversal.getPath(vLevel) + "Division2/Section5/Index'>Antarrea</a><br/><br/>";
			vResult += "<a class=\"navlinkB\" href='" + vUniversal.getPath(vLevel) + "Division2/Section5/Section1/Index'>Global</a><br/><br/>";
			vResult += "<a class=\"navlinkB\" href='" + vUniversal.getPath(vLevel) + "Division2/Section5/Section2/Index'>Grendol</a><br/><br/>";
			vResult += "<a class=\"navlinkB\" href='" + vUniversal.getPath(vLevel) + "Division2/Section5/Section3/Index'>Utopia</a><br/><br/>";
			vResult += "<a class=\"navlinkB\" href='" + vUniversal.getPath(vLevel) + "Division2/Section5/Section4/Index'>Elvia</a><br/><br/>";
		vResult += "<a class=\"navlinkA\" href='" + vUniversal.getPath(vLevel) + "Division2/Project6'>Truth</a><br/><br/>";
		vResult += "<a class=\"navlinkA\" href='" + vUniversal.getPath(vLevel) + "Division2/Project7'>Kingdoms</a><br/><br/>";
		vResult += "<a class=\"navlinkA\" href='" + vUniversal.getPath(vLevel) + "Division2/Project8'>Terminal World</a><br/><br/>";
		vResult += "<a class=\"navlinkA\" href='" + vUniversal.getPath(vLevel) + "Division2/Project9'>Monster Office Workplace</a><br/><br/>";
		vResult += "<a class=\"navlinkA\" href='" + vUniversal.getPath(vLevel) + "Division2/Project10'>Battle Princesses</a><br/><br/>";
		vResult += "<a class=\"navlinkA\" href='" + vUniversal.getPath(vLevel) + "Division2/Project11'>Sacred Offerings</a><br/><br/>";
		vResult += "<a class=\"navlinkA\" href='" + vUniversal.getPath(vLevel) + "Division2/Project12'>The Way</a><br/><br/>";
		vResult += "<a class=\"navlinkA\" href='" + vUniversal.getPath(vLevel) + "Division2/Project13'>Conspiratorium</a><br/><br/>";
		vResult += "<a class=\"navlinkA\" href='" + vUniversal.getPath(vLevel) + "Division2/Project14'>Conversion</a><br/><br/>";

		return vResult;
	}

	public String getBody(int vPage, int vLevel) {
		String vResult = "";

		vResult += "<body>";
            vResult += "<div id=\"idGeneralLayout\">";
                vResult += "<Header id=\"idHeaderRow\">";
                    vResult += "<div id=\"idHeaderRowCenter\" colspan=\"3\">";
                        vResult += vUniversal.getLogo(vLevel);
                    vResult += "</div>";
                vResult += "</Header>";
                vResult += "<Nav id=\"idNavigationRow\">";
                    vResult += "<div id=\"idNavigationBar\" colspan=\"3\">";
                        vResult += vUniversal.getNavBar(vLevel);
                    vResult += "</div>";
                vResult += "</Nav>";
                vResult += "<div id=\"idCenterRow\">";
                    vResult += "<div id=\"idCenterRowLeft\">";
                        vResult += vUniversal.getNavigationHeader();
                        vResult += getNavigation(vLevel);
                    vResult += "</div>";
                    vResult += "<div id=\"idCenterRowMain\">";
                        vResult += vCustom.getTitle(vPage);
                        vResult += vCustom.getContentHeader(vPage);
                        vResult += vCustom.getContent(vPage);
                    vResult += "</div>";
                    vResult += "<div id=\"idCenterRowRight\">";
	                    vResult += vUniversal.getInformationHeader();
	                    vResult += vUniversal.getInformation();
                        vResult += vCustom.getVersions(vPage);
                    vResult += "</div>";
                vResult += "</div>";
                vResult += "<Footer id=\"idFooterRow\">";
                    vResult += "<div id=\"idFooterMain\" colspan=\"3\">";
                    	vResult += vUniversal.getFooter();
                        vResult += vUniversal.getWebMaster();
                    vResult += "</div>";
                vResult += "</Footer>";
            vResult += "</div>";
        vResult += "</body>";
        
		return vResult;
	}
}
