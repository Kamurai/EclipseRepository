package division2.section1;

public class Layout extends main.Layout {
	public Layout(Custom vCustom) {
		super(vCustom);
	}

	private String getNavigation(int vLevel) {
		String vResult = "";

		vResult += "<ul class=\"navigationUl\">";
			vResult += "<li><a class=\"navlinkA\" href=\"../Index\">Digital Board Games</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"../Project1\">Kingdoms</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"../Project2\">Goblins and Guardians</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"../Project3\">Mega Fleets</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"../Section1/Index\">Crash Ball</a></li>";
				vResult += "<li><a class=\"navlinkA\" href=\"./Project1\">Antarrea: Crash Ball</a></li>";
				vResult += "<li><a class=\"navlinkA\" href=\"./Project2\">Gynowars: Crash Ball</a></li>";
		vResult += "</ul>";

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
