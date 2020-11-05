package division4;

public class Layout extends main.Layout {
	public Layout(Custom vCustom) {
		super(vCustom);
	}

	private String getNavigation(int vLevel) {
		String vResult = "";

		vResult += "<ul class=\"navigationUl\">";
			vResult += "<li><a class=\"navlinkA\" href=\"./Index\">Downloadables</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project1\">Cube World Downloads</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project2\">Minecraft Downloads</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project3\">Game Maker Downloads</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project4\">Java# Downloads</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project5\">C# Downloads</a></li>";
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
