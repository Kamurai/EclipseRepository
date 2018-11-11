package main;

import main.Custom;

public class Layout
{
    protected Universal vUniversal;
    protected Custom vCustom;

    public Layout(Custom vCustom)
    {
    	this.vUniversal = new Universal();
        this.vCustom = vCustom;
    }
    
    private String getNavigation(int vLevel)
    {
        String vResult = "";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"AboutUs'>About Us</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"Media'>Media</a><br/><br/>";
        vResult += "<a class=\"navlinkA\" href='"+vUniversal.getPath(vLevel)+"Minecraft'>Minecraft!</a><br/><br/>";
        return vResult;
    }
    
	public String getBody(int vPage, int vLevel)
    {
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

