package section3;

public class Layout extends main.Layout
{
    public Layout(Custom vCustom)
    {
        super(vCustom);
    }

    public String Navigation(int vLevel)
    {
        String Result = "";
        Result += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Section3/Project1'>Online Experience Downloads</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Section3/Project2'>Game Maker Downloads</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Section3/Project3'>Java Downloads</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Section3/Project4'>C# Downloads</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+vUniversal.GetPath(vLevel)+"Section3/Project5'>C++ Downloads</a><br/><br/>";
        return Result;
    }

    public String WriteWebpage(int vPage, int vLevel)
    {
        String Result = "";
        Result += "<body id=\"idBody\">";
            Result += "<table id=\"idTableMain\">";
                Result += "<tr id=\"idHeaderRow\">";
                    Result += "<td id=\"idHeaderRowCenter\" colspan=\"3\">";
                        Result += vUniversal.TitlePicture(vLevel);
                    Result += "</td>";
                Result += "</tr>";
                Result += "<tr id=\"idNavigationRow\">";
                    Result += "<td id=\"idNavigationBar\" colspan=\"3\">";
                        Result += vUniversal.NavBar(vLevel);
                    Result += "</td>";
                Result += "</tr>";
                Result += "<tr id=\"idCenterRow\">";
                    Result += "<td id=\"idCenterRowLeft\">";
                        Result += "<h4>";
                            Result += "Navigation";
                        Result += "</h4>";
                        Result += Navigation(vLevel);
                    Result += "</td>";
                    Result += "<td id=\"idCenterRowMain\">";
                        Result += vCustom.Title(vPage);
                        Result += vCustom.Header(vPage);
                        Result += vCustom.Content(vPage);
                    Result += "</td>";
                    Result += "<td id=\"idCenterRowRight\">";
                        Result += "<h4>";
                            Result += "Information";
                        Result += "</h4>";
                        Result += vUniversal.Information();
                        Result += vCustom.Versions(vPage);
                    Result += "</td>";
                Result += "</tr>";
                Result += "<tr id=\"idFooterRow\">";
                    Result += "<td id=\"idFooterMain\" colspan=\"3\">";
                            Result += "<p id=\"idFooterContent\">";
                                Result += vUniversal.Footer();
                            Result += "</p>";
                            Result += "<p id=\"idFooterContent\">";
                                    Result += vUniversal.WebMaster();
                            Result += "</p>";
                    Result += "</td>";
                Result += "</tr>";
            Result += "</table>";
        Result += "</body>";
        return Result;
    }
}
