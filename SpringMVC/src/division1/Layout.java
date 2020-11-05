package division1;

public class Layout extends main.Layout {
	public Layout(Custom vCustom) {
		super(vCustom);
	}

	private String getNavigation(int vLevel) {
		String vResult = "";

		vResult += "<ul class=\"navigationUl\">";
			vResult += "<li><a class=\"navlinkA\" href=\"./Index\">Board Games</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project1\">The Way</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project2\">Sacred Offerings</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project3\">Conversion</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project4\">Conspiratorium</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project5\">Monster Office Workplace</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project6\">MacCreedy's Mansion</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project7\">Dundered Acre Wood</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project8\">Conquer</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project9\">Assault</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project10\">Battle Princesses</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project11\">Armor Up</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project12\">Gynowars: Battle Arena</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project13\">Land of the Orcish Empire: Age of Magic</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project14\">Coliseum Arena</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project15\">Nine Card</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project16\">Wars of Antarrea</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project17\">Antarrea RPG</a></li>";
			vResult += "<li><a class=\"navlinkA\" href=\"./Project18\">Super Dungeon Adventure</a></li>";
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
