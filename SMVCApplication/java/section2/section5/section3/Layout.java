package section2.section5.section3;

public class Layout extends master.Layout
{
    public Layout(Custom custom)
    {
        super(custom);
    }

    public String Navigation(int level, int extension)
    {
        String Result = "";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section2/Section1/Index'>Gynowars</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section2/Project2'>Assault</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section2/Project3'>Mars</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section2/Section4/Index'>Renley</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section2/Section5/Index'>Antarrea</a><br/><br/>";
            Result += "<a class=\"navlinkB\" href='"+universal.GetPath(level)+"Section2/Section5/Section1/Index'>Global</a><br/><br/>";
            Result += "<a class=\"navlinkB\" href='"+universal.GetPath(level)+"Section2/Section5/Section2/Index'>Grendol</a><br/><br/>";
            Result += "<a class=\"navlinkB\" href='"+universal.GetPath(level)+"Section2/Section5/Section3/Index'>Utopia</a><br/><br/>";
                Result += "<a class=\"navlinkC\" href='"+universal.GetPath(level)+"Section2/Section5/Section3/Project1'>Avia:Elemental Angels</a><br/><br/>";
            Result += "<a class=\"navlinkB\" href='"+universal.GetPath(level)+"Section2/Section5/Section4/Index'>Elvia</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section2/Project6'>Truth</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section2/Project7'>Kingdoms</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section2/Project8'>Terminal World</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section2/Project9'>Monster Office Workplace</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section2/Project10'>Battle Princesses</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section2/Project11'>Sacred Offerings</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section2/Project12'>The Way</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section2/Project13'>Conspiratorium</a><br/><br/>";
        Result += "<a class=\"navlinkA\" href='"+universal.GetPath(level)+"Section2/Project14'>Conversion</a><br/><br/>";
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
