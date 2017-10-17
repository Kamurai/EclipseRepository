package main;

public class Universal
{
    public Universal()
    {

    }

    public String WriteHeader(int vLevel, int vDivision)
    {
    	String vResult = "";
    	String vDefault = "";
    	
    	vResult += "<link rel='shortcut icon' href='./Pictures/favicon.ico' type='image/x-icon' />";
        vResult += "<link rel='icon' href='./Pictures/favicon.ico' type='image/x-icon' />";
        
        vDefault = "Main.css";
        
        vResult += "<link href='"+GetPath(vLevel)+"Styles/";
        if(vDivision == 0)
        {
            vResult += vDefault;
        }
        else if(vDivision == 1)
        {
            vResult += "Division1.css";
        }
        else if(vDivision == 2)
        {
            vResult += "Division2.css";
        }
        else if(vDivision == 3)
        {
            vResult += "Division3.css";
        }
        else
        {
            vResult += vDefault;
        }
        vResult += "' rel='stylesheet' type='text/css'>";
        
        
        return vResult;
    }

    public String TitlePicture(int vLevel)
    {
        String vResult = "";
        vResult += "<img  id=\"idLogo\" src='"+GetPath(vLevel)+"Pictures/logoHTKB.jpg'><br>";

        return vResult;
    }

    public String NavBar(int vLevel)
    {
        String vResult = "";
        vResult += "<a class=\"navBar\" href='"+GetPath(vLevel)+"Index'>Home</a>";
        vResult += "<a class=\"navBar\" href='"+GetPath(vLevel)+"Division1/Index'>Web Programming</a>";
        vResult += "<a class=\"navBar\" href='"+GetPath(vLevel)+"Division2/Index'>Private Projects</a>";
        vResult += "<a class=\"navBar\" href='"+GetPath(vLevel)+"Division3/Index'>Downloadable Projects</a>";
        return vResult;
    }
    
    public String NavigationHeader()
    {
    	String vResult = "";
    	
    	vResult += "<h4>";
    	vResult += "Navigation";
    	vResult += "</h4>";
    	return vResult;
    }
    
    public String InformationHeader()
    {
    	String vResult = "";
    	
    	vResult += "<h4>";
    	vResult += "Information";
    	vResult += "</h4>";
    	return vResult;
    }
    
    public String Information()
    {
        String vResult = "";
        vResult += "This is written using JSP.<br><br>";
        vResult += "Other versions of this page are here:<br>";
        return vResult;
    }

    public String GDR()
    {
        String vResult = "";
        vResult += "<a href='http://htkb.dyndns.org/Section3/downloads/GDR.zip'>You can download my Games Development Report here.</a></br>";
        return vResult;
    }

    public String WinRAR()
    {
        String vResult = "";
        vResult += "<a href='http://htkb.dyndns.org/Section3/downloads/wrar371.exe'>You may need WinRar to open zip files from this site.</a></br>";
        return vResult;
    }

    public String Footer()
    {
        String vResult = "";
        vResult += "© Copyright 2012 All rights reserved<br>";
        vResult += "House That Kamurai Built<br>";
        return vResult;
    }

    public String WebMaster()
    {
        String vResult = "";
            vResult += "Website managed by Kamurai.";
        return vResult;
    }

    public String GetPath(int vLevel)
    {
        if(vLevel <= 0)
        {
            return "./";
        }
        else if(vLevel == 1)
        {
            return "../";
        }
        else if(vLevel == 2)
        {
            return "../../";
        }
        else if(vLevel == 3)
        {
            return "../../../";
        }
        else if(vLevel == 4)
        {
            return "../../../../";
        }
        else if(vLevel == 5)
        {
            return "../../../../../";
        }
        else if(vLevel == 6)
        {
            return "../../../../../../";
        }
        else if(vLevel == 7)
        {
            return "../../../../../../../";
        }
        else
        {
            return "./";
        }
    }
}
