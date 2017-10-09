package master;

import main.Universal;

public class Custom
{
	protected Universal universal;

    public Custom()
    {
    	this.universal = new Universal();
    }

    public String Title(int input)
    {
        String Result = "";
        Result += "<title>";
            if(input == 0)
            {
                Result += "HTKB Home Page";
            }
            else if(input == 1)
            {
                Result += "About Us";
            }
            else if(input == 2)
            {
                Result += "Media";
            }
            else if(input == 3)
            {
                Result += "Minecraft!";
            }
        Result += "</title>";
        return Result;
    }

    public String Header(int input)
    {
        String Result = "";
        Result += "<h2>";
            if(input == 0)
            {
                Result += "Welcome to the House That Kamurai Built!";
            }
            else if(input == 1)
            {
                Result += "About Us";
            }
            else if(input == 2)
            {
                Result += "Media";
            }
            else if(input == 3)
            {
                Result += "Minecraft!";
            }
        Result += "</h2>";
        return Result;
    }

    public String Content(int input)
    {
        String Result = "";
        Result += "<p id=\"idCenterContent\">";
            if(input == 0)
            {
                Result += "The House That Kamurai Built is an entertainment company with the primary focus ";
                Result += "of increasing awesome by stimulating intelligent conversation and entertainment via discussion and ";
                Result += "game design.<br>";
                Result += "Increase the Awesome with us!<br>";
            }
            else if(input == 1)
            {
                Result += "We are working to build this into a better place.</br>";
                Result += "If you found this, then you must be at least (Awesome/2).</br>";
                Result += "Stay tuned, right now it's all about laying foundation for the future.</br>";
            }
            else if(input == 2)
            {
                    Result += "You can find us at all these different places:</br>";
                Result += "<br/>";
                Result += "<br/>";
                            Result += "#WeAreMovieClub:";
                Result += "<br/>";
                Result += "<br/>";
                        Result += "<a href='http://www.youtube.com/WeAreMovieClub'>Youtube.com/WeAreMovieClub:  A place for movie discussion.</a></br>";
                        Result += "<a href='http://WeAreMovieClub.tumblr.com'>WeAreMovieClub.tumblr.com: We have a tumblr!</a></br>";
                        Result += "<a href='http://www.twitter.com/WeAreMovieClub'>@WeArMovieClub on Twitter: Let us know about your movie thoughts.</a></br>";
                        Result += "<a href='http://www.facebook.com/WeAreMovieClub'>facebook.com/WeAreMovieClub: Talk about movie with us.</a></br>";
                Result += "<br/>";
                Result += "<br/>";
                            Result += "HTKB Productions";
                Result += "<br/>";
                Result += "<br/>";
                        Result += "<a href='http://www.youtube.com/GamingDivision528'>Gaming Division:  A Youtube Channel for game stuff.</a></br>";
                        Result += "<a href='http://www.youtube.com/JamOnToast528'>Jam On Toast:  A Youtube Channel for media stuff.</a></br>";
                        Result += "<a href='http://www.ustream.tv/HTKB'>UStream:  Streams show up here too.</a></br>";
                        Result += "<a href='http://www.firetalk.com/HTKB'>FireTalk:  Streams show up here too.</a></br>";
                        Result += "<a href='http://www.younow.com/HTKB'>YouNow:  Streams show up here too.</a></br>";
                        Result += "<a href='http://www.soundcloud.com/HTKB'>Sound Cloud:  Listen to our podcasts.</a></br>";
                        Result += "<a href='http://HTKB.podbean.com/'>Pod Bean:  Listen to our podcasts.</a></br>";
                        Result += "<a href='http://www.youtube.com/HTKB'>Youtube:  Thoughts and life discussions.</a></br>";
                        Result += "<a href='http://www.patreon.com/HTKBProductions'>Patreon:  You can help make our dreams reality.</a></br>";
                        Result += "<a href='http://www.facebook.com/HouseThatKamuraiBuilt'>Facebook: Talk about movie with us.</a></br>";
                        Result += "<a href='http://HouseThatKamuraiBuilt.tumblr.com'>HouseThatKamuraiBuilt.tumblr.com: We have a tumblr!</a></br>";
                        Result += "<a href='http://myspace.com/HouseThatKamuraiBuilt'>Myspace: Wow, there's even a MySpace!</a></br>";
                Result += "<br/>";
                Result += "<br/>";
                    Result += "Here are some of our member's pages:</br>";
                Result += "<br/>";
                Result += "<br/>";
                        Result += "Kamurai:";
                Result += "<br/>";
                Result += "<br/>";
                    Result += "<a href='http://twitter.com/#!/Kamurai25'>Kamurai's Twitter.</a></br>";
                    Result += "<a href='http://Instagram.com/Kamurai25'>Kamurai's Instagram.</a></br>";
                    Result += "<a href='./.'>Kamurai's Snapchat: Kamurai</a></br>";
                    Result += "<a href='http://www.facebook.com/cris.kamurai'>Kamurai's Facebook.</a></br>";
                    Result += "<a href='https://www.gplus.com/Members/Cris-Kamurai'>Kamurai's Google Plus.</a></br>";
                    Result += "<a href='http://www.yoyogames.com/users/Kamurai'>Kamurai's YoYo Games page:  See some of the games he's posted.</a></br>";
            }
            else if(input == 3)
            {
                    Result += "If you would like to play Minecraft with us, we have several different servers:</br>";
                    Result += "Mo Creatures Server: (1.7.10) htkb.dyndns.org:25565</br>";
                    Result += "Creative Server:     (1.7.10) htkb.dyndns.org:25567</br>";
                        Result += "This is a list of mods that we are using on the server, compatible with 1.7.10.</br>";
                            Result += "<a href='./Downloads/Minecraft/forge-1.7.10-10.13.3.1401-1710ls-installer.jar'>Forge 1.7.10</a></br>";
                            Result += "<a href='./Downloads/Minecraft/DrZharks MoCreatures Mod v6.3.1.zip'>Dr Zhark's Mo Creatures</a></br>";
                            Result += "<a href='./Downloads/Minecraft/CustomMobSpawner 3.3.0.zip'>Custom Mob Spawner</a></br>";
                            Result += "<a href='./Downloads/Minecraft/[1.7.10]Gender-1.0.2.jar'>iPixeli's Gender Mod</a></br>";
                            Result += "<a href='./Downloads/Minecraft/BspkrsCore-1.7.10.jar'>Bspkrs Core</a></br>";
                            Result += "<a href='./Downloads/Minecraft/[1.7.10]Treecapitator-universal-2.0.4.jar'>Tree Capitator</a></br>";
                            Result += "<a href='./Downloads/Minecraft/MoarFood-5.8.0.jar'>Moar Food</a></br>";
                            Result += "<a href='./Downloads/Minecraft/MoarOres-2.4.5.jar'>Moar Ores</a></br>";
                            Result += "<a href='./Downloads/Minecraft/BiblioCraft[v1.10.4][MC1.7.10].jar'>Biblio Craft</a></br>";
                            Result += "<a href='./Downloads/Minecraft/Fossils_Archeology_Revival-1.7.10_Build-6.4b.jar'>Fossils and Archaeology</a></br>";
                            Result += "<a href='./Downloads/Minecraft/Reis-Minimap-Mod-1.7.10.jar'>Rei's Minimap</a></br>";
                            Result += "<a href='./Downloads/Minecraft/Xaeros_Minimap_1.10.8_Forge_1.7.10.jar'>Xaero's Minimap</a></br>";
                    Result += "Vanilla Server:      htkb.dyndns.org:25566</br>";
                    Result += "Here is a skin template to make custom skins:</br>";
                    Result += "<a href='./Downloads/Minecraft/skin_template.png'>Steve skin template</a></br>";
            Result += "<br/>";
            Result += "<br/>";
                    Result += "For first time setups, please follow these steps to make your client compatible with the server:</br>";
                    Result += " 0) If you don't have Minecraft, go to Minecraft.net and download the latest version of the launcher.</br>";
                    Result += " 1) From the launcher create a new profile and change its version to the relevant version (e.g. 1.7.10).</br>";
                    Result += " 2) Save the Profile, select the new profile and click play.</br>";
                    Result += " 3) Exit the program.</br>";
                    Result += " 4) Install Forge.  If it is not automatically selected, then browse to your .minecraft folder.</br>";
                    Result += "    Windows: It is in a hidden folder: c:\\Users\\*Username*\\Appdata\\Roaming\\.minecraft</br>";
                    Result += "    Mac: \"Go to\" ~/Library/Application Support/minecraft</br>";
                    Result += " 5) If you are managing multiple non-compatible mods, then you man have to make folders like:</br>";
                    Result += "    \\\"..\\Roaming\\MoCreatures\\\"</br>";
                    Result += " 6) If your folder doesn't have a /Mods folder, create one. Place the files from the mod list into the /mods folder.</br>";
                    Result += "    Even if it works, don't put two minimap mods in the same folder.</br>";
                    Result += " 7) Open the Minecraft Launcher, edit your version (e.g. 1.7.10) profile to use the forge version of the same.</br>";
                    Result += " 8) If you are using a different folder, then remember to change the Game Directory in the profile.</br>";
                    Result += " 9) Save the Profile, select the new profile and click play.</br>";
                    Result += "10) You should see the mods listed on the side of the Minecraft window.</br>";
                    Result += "11) Go to multiplayer and click add server.</br>";
                    Result += "12) Name the server something distinct and put \"htkb.dyndns.org:2556x\" in the address bar where \"x\" is the relevant port.</br>";
                    Result += "13) Save the server entry.  You should see a connection to the server.  Double click to join.</br>";
        }
        Result += "</p>";
        return Result;
    }
    
    public String Versions(int input)
    {
        String Result = "";
        if(input == 0)
        {
            Result += "<a href=\"http://htkb.dyndns.org/Index.html\">HTML</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Index.php\">PHP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Javascript/Index.html\">HTML Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/JQuery/Index.html\">JQuery</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASP/Index.asp\">ASP Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASPNET/Index.aspx\">ASP.NET Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Index.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:84/Index\">Node JS</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Index.shtml\">Perl</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSPApplication/Index.jsp\">JSP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSFApplication/Index.xhtml\">JSF</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebApplication/Index.cshtml\">ASP.NET Web App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Index.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/MVC/Index\">ASP.NET MVC App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/SSI/Index.html\">Apache SSI</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:82/Index\">Python Web.py</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:83/Index\">Ruby on Rails</a><br/>";
        }
        else if(input == 1)
        {
            Result += "<a href=\"http://htkb.dyndns.org/AboutUs.html\">HTML</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/AboutUs.php\">PHP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Javascript/AboutUs.html\">HTML Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/JQuery/AboutUs.html\">JQuery</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASP/AboutUs.asp\">ASP Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASPNET/AboutUs.aspx\">ASP.NET Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/AboutUs.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:84/AboutUs\">Node JS</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/AboutUs.shtml\">Perl</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSPApplication/AboutUs.jsp\">JSP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSFApplication/AboutUs.xhtml\">JSF</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebApplication/AboutUs.cshtml\">ASP.NET Web App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/AboutUs.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/MVC/AboutUs\">ASP.NET MVC App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/SSI/AboutUs.html\">Apache SSI</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:82/AboutUs\">Python Web.py</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:83/AboutUs\">Ruby on Rails</a><br/>";
        }
        else if(input == 2)
        {
            Result += "<a href=\"http://htkb.dyndns.org/Media.html\">HTML</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Media.php\">PHP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Javascript/Media.html\">HTML Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/JQuery/Media.html\">JQuery</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASP/Media.asp\">ASP Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASPNET/Media.aspx\">ASP.NET Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Media.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:84/Media\">Node JS</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Media.shtml\">Perl</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSPApplication/Media.jsp\">JSP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSFApplication/Media.xhtml\">JSF</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebApplication/Media.cshtml\">ASP.NET Web App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Media.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/MVC/Media\">ASP.NET MVC App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/SSI/Media.html\">Apache SSI</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:82/Media\">Python Web.py</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:83/Media\">Ruby on Rails</a><br/>";
        }
        else if(input == 3)
        {
            Result += "<a href=\"http://htkb.dyndns.org/Minecraft.html\">HTML</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Minecraft.php\">PHP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Javascript/Minecraft.html\">HTML Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/JQuery/Minecraft.html\">JQuery</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASP/Minecraft.asp\">ASP Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASPNET/Minecraft.aspx\">ASP.NET Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Minecraft.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:84/Minecraft\">Node JS</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Minecraft.shtml\">Perl</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSPApplication/Minecraft.jsp\">JSP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSFApplication/Minecraft.xhtml\">JSF</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebApplication/Minecraft.cshtml\">ASP.NET Web App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Minecraft.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/MVC/Minecraft\">ASP.NET MVC App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/SSI/Minecraft.html\">Apache SSI</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:82/Minecraft\">Python Web.py</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:83/Minecraft\">Ruby on Rails</a><br/>";
        }
        return Result;
    }
}
