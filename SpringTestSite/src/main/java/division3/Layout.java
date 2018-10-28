package division3;

public class Layout extends main.Layout
{
    public Layout(Custom vCustom)
    {
        super(vCustom);
    }

    private String getNavigation(int vLevel)
    {
        String vResult = "";
        
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"Division3/Project1'>Online Experience Downloads</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"Division3/Project2'>Game Maker Downloads</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"Division3/Project3'>Java Downloads</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"Division3/Project4'>C# Downloads</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"Division3/Project5'>C++ Downloads</a><br/><br/>";
        
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
