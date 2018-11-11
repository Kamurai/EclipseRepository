package main;

public class Universal
{
    public Universal()
    {

    }

    public String getHead(int vLevel, int vDivision)
    {
    	String vResult = "";
    	
		vResult += "<head>";
			vResult += "<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>";
			vResult += "<link rel='shortcut icon' href='./Pictures/favicon.ico' type='image/x-icon' />";
			vResult += "<link rel='icon' href='./Pictures/favicon.ico' type='image/x-icon' />";
			vResult += getStyle(vLevel, vDivision);
        vResult += "</head>";
        
        return vResult;
    }
	
	private String getStyle(int vLevel, int vDivision)
	{
		String vResult = "";
		
		vResult += "<link href='http://htkb.dyndns.org/Styles/";
		vResult += getStyleFile(vDivision);
		vResult += "' rel='stylesheet' type='text/CSS'>";

		return vResult;
	}

	private String getStyleFile(int vDivision)
	{
		String vResult = "";
		String vDefault = "";
		
		vDefault = "Main.css";
		
		if(vDivision == 0)
		{
			vResult = vDefault;
		}
		else if(vDivision == 1)
		{
			vResult = "Division1.css";
		}
		else if(vDivision == 2)
		{
			vResult = "Division2.css";
		}
		else if(vDivision == 3)
		{
			vResult = "Division3.css";
		}
		else
		{
			vResult = vDefault;
		}
		
		return vResult;
	}

    public String getLogo(int vLevel)
    {
        String vResult = "";
		
		vResult += "<img  id=\"idLogo\" src='http://htkb.dyndns.org/Pictures/logoHTKB.jpg'><br>";

        return vResult;
    }

    public String getNavBar(int vLevel)
    {
        String vResult = "";
		
		vResult += "<a class=\"navBar\" href='"+getPath(vLevel)+"Index'>Home</a>";
		vResult += "<a class=\"navBar\" href='"+getPath(vLevel)+"Division1/Index'>Web Programming</a>";
		vResult += "<a class=\"navBar\" href='"+getPath(vLevel)+"Division2/Index'>Private Projects</a>";
		vResult += "<a class=\"navBar\" href='"+getPath(vLevel)+"Division3/Index'>Downloadable Projects</a>";
        
		return vResult;
    }
    
    public String getNavigationHeader()
    {
    	String vResult = "";
    	
    	vResult += "<h4>";
			vResult += "Navigation";
    	vResult += "</h4>";
		
    	return vResult;
    }
    
    public String getInformationHeader()
    {
    	String vResult = "";
    	
    	vResult += "<h4>";
			vResult += "Information";
    	vResult += "</h4>";
		
    	return vResult;
    }
    
    public String getInformation()
    {
        String vResult = "";
		
        vResult += "This is written using JSP.<br><br>";
        vResult += "Other versions of this page are here:<br>";
        
		return vResult;
    }

    public String getGDR()
    {
        String vResult = "";
		
        vResult += "<a href='http://htkb.dyndns.org/Section3/downloads/GDR.zip'>You can download my Games Development Report here.</a></br>";
        
		return vResult;
    }

    public String getWinRar()
    {
        String vResult = "";
		
        vResult += "<a href='http://htkb.dyndns.org/Section3/downloads/wrar371.exe'>You may need WinRar to open zip files from this site.</a></br>";
        
		return vResult;
    }

    public String getFooter()
    {
        String vResult = "";
        
        vResult += "<div id=\"idFooterContent\">";
            vResult += "© Copyright 2012 All rights reserved<br>";
            vResult += "House That Kamurai Built<br>";
		vResult += "</div>";
    
        return vResult;
    }

    public String getWebMaster()
    {
        String vResult = "";
       
	    vResult += "<div id=\"idFooterManagement\">";
	    	vResult += "Website managed by Kamurai.";
	    vResult += "</div>";        
			
        return vResult;
    }

    public String getPath(int vLevel)
    {
		String vResult = "";
		
        if(vLevel <= 0)
        {
            vResult += "./";
        }
        else if(vLevel == 1)
        {
            vResult += "../";
        }
        else if(vLevel == 2)
        {
            vResult += "../../";
        }
        else if(vLevel == 3)
        {
            vResult += "../../../";
        }
        else if(vLevel == 4)
        {
            vResult += "../../../../";
        }
        else if(vLevel == 5)
        {
            vResult += "../../../../../";
        }
        else if(vLevel == 6)
        {
            vResult += "../../../../../../";
        }
        else if(vLevel == 7)
        {
            vResult += "../../../../../../../";
        }
        else
        {
            vResult += "./";
        }
		
		return vResult;
    }
}
