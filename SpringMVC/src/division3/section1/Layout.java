package division3.section1;

public class Layout extends main.Layout {
	public Layout(Custom vCustom) {
		super(vCustom);
	}

	private String getNavigation(int vLevel) {
		String vResult = "";

		vResult += "<ul class=\"navigationUl\">";
			vResult += "<li><a class=\"navlinkA\" href=\"../Index\">Video Games</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"../Project1\">Truth</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"../Project2\">The Wrong Ninja</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"../Project3\">Gynowars</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"../Project4\">Terminal World</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"../Project5\">Mars: Opposition</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"../Section1/Index\">Antarrea</a></li>";
				vResult += "<li><a class=\"navlinkB\" href=\"./Project1\">Revolutions: Invading Nations</a></li>";
				vResult += "<li><a class=\"navlinkB\" href=\"./Project2\">Revolutions: Rebellion Against the Fist</a></li>";
				vResult += "<li><a class=\"navlinkB\" href=\"./Project3\">Revolutions: Return to Arms</a></li>";
				vResult += "<li><a class=\"navlinkB\" href=\"./Project4\">Revolutions: Post Wars</a></li>";
				vResult += "<li><a class=\"navlinkB\" href=\"./Project5\">Avia: Elemental Angels</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"../Section2/Index\">Renley</a></li>";
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
