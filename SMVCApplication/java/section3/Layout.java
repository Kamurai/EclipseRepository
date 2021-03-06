package section3;

public class Layout extends master.Layout
{
    public Layout(Custom custom)
    {
        super(custom);
    }

    public String Navigation(int level, int extension)
    {
        String Result = "";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section3/Project1'>Online Experience Downloads</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section3/Project2'>Game Maker Downloads</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section3/Project3'>Java Downloads</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section3/Project4'>C# Downloads</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section3/Project5'>C++ Downloads</a><br/><br/>";
        return Result;
    }

    public String WriteWebpage(int input, int level, int extension)
    {
        String Result = "";
        Result += "<body id=\"idBody\">";
            Result += "<table id=\"idTableMain\">";
                Result += "<tr id=\"idHeaderRow\">";
                    Result += "<td id=\"idHeaderRowCenter\" colspan=\"3\">";
                        Result += universal.TitlePicture(level);
                    Result += "</td>";
                Result += "</tr>";
                Result += "<tr id=\"idNavigationRow\">";
                    Result += "<td id=\"idNavigationBar\" colspan=\"3\">";
                        Result += universal.NavBar(level, extension);
                    Result += "</td>";
                Result += "</tr>";
                Result += "<tr id=\"idCenterRow\">";
                    Result += "<td id=\"idCenterRowLeft\">";
                        Result += "<h4>";
                            Result += "Navigation";
                        Result += "</h4>";
                        Result += Navigation(level, extension);
                    Result += "</td>";
                    Result += "<td id=\"idCenterRowMain\">";
                        Result += custom.Title(input);
                        Result += custom.Header(input);
                        Result += custom.Content(input);
                    Result += "</td>";
                    Result += "<td id=\"idCenterRowRight\">";
                        Result += "<h4>";
                            Result += "Information";
                        Result += "</h4>";
                        Result += universal.Information();
                        Result += custom.Versions(input);
                    Result += "</td>";
                Result += "</tr>";
                Result += "<tr id=\"idFooterRow\">";
                    Result += "<td id=\"idFooterMain\" colspan=\"3\">";
                            Result += "<p id=\"idFooterContent\">";
                                Result += universal.Footer();
                            Result += "</p>";
                            Result += "<p id=\"idFooterContent\">";
                                    Result += universal.WebMaster();
                            Result += "</p>";
                    Result += "</td>";
                Result += "</tr>";
            Result += "</table>";
        Result += "</body>";
        return Result;
    }
}
