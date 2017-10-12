package section1.section6;

import main.*;
import dataMethods.*;

public class Custom extends master.Custom
{
    DerbyMethod dMethod;
    MySQLMethod mMethod;
    OracleMethod oMethod;
    PostgresMethod pMethod;
    SQLServerExpressMethod eMethod;
    SQLServerMethod sMethod;

    public Custom()
    {
        super();
    
        dMethod = new DerbyMethod();
        mMethod = new MySQLMethod();
        oMethod = new OracleMethod();
        pMethod = new PostgresMethod();
        eMethod = new SQLServerExpressMethod();
        sMethod = new SQLServerMethod();
    }

    public String Title(int input)
    {
        String Result = "";
        Result += "<title>";
            if(input == 0)
            {
                Result += "Database Programming";
            }
            else if(input == 1)
            {
                Result += "Oracle Programming";
            }
            else if(input == 2)
            {
                Result += "Derby Programming";
            }
            else if(input == 3)
            {
                Result += "MySQL Programming";
            }
            else if(input == 4)
            {
                Result += "SQL Server Programming";
            }
            else if(input == 5)
            {
                Result += "Postgres Programming";
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
            Result += "Database Programming";
        }
        else if(input == 1)
        {
            Result += "Oracle Programming";
        }
        else if(input == 2)
        {
            Result += "Derby Programming";
        }
        else if(input == 3)
        {
            Result += "MySQL Programming";
        }
        else if(input == 4)
        {
            Result += "SQL Server Programming";
        }
        else if(input == 5)
        {
            Result += "Postgres Programming";
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
                Result += "This section is dedicated to database based programming.";
            }
            else if(input == 1)
            {
                Result += "This section is dedicated to Oracle based programming.";
                Result += "<table>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += "Index";
                        Result += "</td>";
                        Result += "<td>";
                            Result += "Color";
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += oMethod.getColorData("0",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += oMethod.getColorData("Oracle 11g",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += oMethod.getColorData("1",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += oMethod.getColorData("Red",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += oMethod.getColorData("2",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += oMethod.getColorData("Orange",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += oMethod.getColorData("3",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += oMethod.getColorData("Yellow",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += oMethod.getColorData("4",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += oMethod.getColorData("Green",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += oMethod.getColorData("5",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += oMethod.getColorData("Blue",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += oMethod.getColorData("6",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += oMethod.getColorData("Indigo",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += oMethod.getColorData("7",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += oMethod.getColorData("Violet",1);
                        Result += "</td>";
                    Result += "</tr>";
                Result += "</table>";
            }
            else if(input == 2)
            {
                Result += "This section is dedicated to Derby based programming.";
                Result += "<table>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += "Index";
                        Result += "</td>";
                        Result += "<td>";
                            Result += "Color";
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += dMethod.getColorData("0",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += dMethod.getColorData("Derby",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += dMethod.getColorData("1",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += dMethod.getColorData("Red",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += dMethod.getColorData("2",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += dMethod.getColorData("Orange",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += dMethod.getColorData("3",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += dMethod.getColorData("Yellow",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += dMethod.getColorData("4",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += dMethod.getColorData("Green",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += dMethod.getColorData("5",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += dMethod.getColorData("Blue",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += dMethod.getColorData("6",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += dMethod.getColorData("Indigo",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += dMethod.getColorData("7",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += dMethod.getColorData("Violet",1);
                        Result += "</td>";
                    Result += "</tr>";
                    
                Result += "</table>";
            }
            else if(input == 3)
            {
                Result += "This section is dedicated to MySQL based programming.";
                Result += "<table>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += "Index";
                        Result += "</td>";
                        Result += "<td>";
                            Result += "Color";
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += mMethod.getColorData("0",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += mMethod.getColorData("MySQL",1);
                        Result += "</td>";
                    Result += "</tr>";Result += "<tr>";
                        Result += "<td>";
                            Result += mMethod.getColorData("1",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += mMethod.getColorData("Red",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += mMethod.getColorData("2",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += mMethod.getColorData("Orange",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += mMethod.getColorData("3",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += mMethod.getColorData("Yellow",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += mMethod.getColorData("4",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += mMethod.getColorData("Green",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += mMethod.getColorData("5",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += mMethod.getColorData("Blue",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += mMethod.getColorData("6",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += mMethod.getColorData("Indigo",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += mMethod.getColorData("7",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += mMethod.getColorData("Violet",1);
                        Result += "</td>";
                    Result += "</tr>";
                    
                Result += "</table>";
            }
            else if(input == 4)
            {
                Result += "This section is dedicated to SQL Server based programming.";
                Result += "<table>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += "SQL Server Instance";
                        Result += "</td>";
                        Result += "<td>";
                            Result += "";
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += "Index";
                        Result += "</td>";
                        Result += "<td>";
                            Result += "Color";
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += sMethod.getColorData("0",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += sMethod.getColorData("SQLSERVER",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += sMethod.getColorData("1",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += sMethod.getColorData("Red",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += sMethod.getColorData("2",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += sMethod.getColorData("Orange",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += sMethod.getColorData("3",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += sMethod.getColorData("Yellow",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += sMethod.getColorData("4",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += sMethod.getColorData("Green",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += sMethod.getColorData("5",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += sMethod.getColorData("Blue",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += sMethod.getColorData("6",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += sMethod.getColorData("Indigo",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += sMethod.getColorData("7",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += sMethod.getColorData("Violet",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr></tr>";
                    Result += "<tr></tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += "SQL Server Express Instance";
                        Result += "</td>";
                        Result += "<td>";
                            Result += "";
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += "Index";
                        Result += "</td>";
                        Result += "<td>";
                            Result += "Color";
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += eMethod.getColorData("0",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += eMethod.getColorData("SQLEXPRESS",1);
                        Result += "</td>";
                    Result += "</tr>";Result += "<tr>";
                        Result += "<td>";
                            Result += eMethod.getColorData("1",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += eMethod.getColorData("Red",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += eMethod.getColorData("2",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += eMethod.getColorData("Orange",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += eMethod.getColorData("3",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += eMethod.getColorData("Yellow",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += eMethod.getColorData("4",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += eMethod.getColorData("Green",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += eMethod.getColorData("5",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += eMethod.getColorData("Blue",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += eMethod.getColorData("6",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += eMethod.getColorData("Indigo",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += eMethod.getColorData("7",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += eMethod.getColorData("Violet",1);
                        Result += "</td>";
                    Result += "</tr>";
                    
                Result += "</table>";
            }
            else if(input == 5)
            {
                Result += "This section is dedicated to Postgres based programming.";
                Result += "<table>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += "Index";
                        Result += "</td>";
                        Result += "<td>";
                            Result += "Color";
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += pMethod.getColorData("0",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += pMethod.getColorData("PostgreSQL",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += pMethod.getColorData("1",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += pMethod.getColorData("Red",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += pMethod.getColorData("2",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += pMethod.getColorData("Orange",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += pMethod.getColorData("3",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += pMethod.getColorData("Yellow",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += pMethod.getColorData("4",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += pMethod.getColorData("Green",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += pMethod.getColorData("5",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += pMethod.getColorData("Blue",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += pMethod.getColorData("6",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += pMethod.getColorData("Indigo",1);
                        Result += "</td>";
                    Result += "</tr>";
                    Result += "<tr>";
                        Result += "<td>";
                            Result += pMethod.getColorData("7",0);
                        Result += "</td>";
                        Result += "<td>";
                            Result += pMethod.getColorData("Violet",1);
                        Result += "</td>";
                    Result += "</tr>";
                    
                Result += "</table>";
            }

        Result += "</p>";
        return Result;
    }
    
    public String Versions(int input)
    {
        String Result = "";
        if(input == 0)
        {
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section6/Index.html\">HTML</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section6/Index.php\">PHP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Javascript/Section1/Section6/Index.html\">HTML Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/JQuery/Section1/Section6/Index.html\">JQuery</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASP/Section1/Section6/Index.asp\">ASP Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASPNET/Section1/Section6/Index.aspx\">ASP.NET Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section1/Section6/Index.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:84/Section1/Section6/Index\">Node JS</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section6/Index.shtml\">Perl</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSPApplication/Section1/Section6/Index.jsp\">JSP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSFApplication/Section1/Section6/Index.xhtml\">JSF</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebApplication/Section1/Section6/Index.cshtml\">ASP.NET Web App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section1/Section6/Index.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/MVC/Section1/Section6/Index\">ASP.NET MVC App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/SSI/Section1/Section6/Index.html\">Apache SSI</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:82/Section1/Section6/Index\">Python Web.py</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:83/Section1/Section6/Index\">Ruby on Rails</a><br/>";
        }
        else if(input == 1)
        {
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section6/Project1.html\">HTML</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section6/Project1.php\">PHP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Javascript/Section1/Section6/Project1.html\">HTML Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/JQuery/Section1/Section6/Project1.html\">JQuery</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASP/Section1/Section6/Project1.asp\">ASP Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASPNET/Section1/Section6/Project1.aspx\">ASP.NET Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section1/Section6/Project1.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:84/Section1/Section6/Project1\">Node JS</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section6/Project1.shtml\">Perl</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSPApplication/Section1/Section6/Project1.jsp\">JSP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSFApplication/Section1/Section6/Project1.xhtml\">JSF</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebApplication/Section1/Section6/Project1.cshtml\">ASP.NET Web App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section1/Section6/Project1.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/MVC/Section1/Section6/Project1\">ASP.NET MVC App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/SSI/Section1/Section6/Project1.html\">Apache SSI</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:82/Section1/Section6/Project1\">Python Web.py</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:83/Section1/Section6/Project1\">Ruby on Rails</a><br/>";
        }
        else if(input == 2)
        {
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section6/Project2.html\">HTML</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section6/Project2.php\">PHP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Javascript/Section1/Section6/Project2.html\">HTML Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/JQuery/Section1/Section6/Project2.html\">JQuery</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASP/Section1/Section6/Project2.asp\">ASP Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASPNET/Section1/Section6/Project2.aspx\">ASP.NET Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section1/Section6/Project2.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:84/Section1/Section6/Project2\">Node JS</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section6/Project2.shtml\">Perl</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSPApplication/Section1/Section6/Project2.jsp\">JSP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSFApplication/Section1/Section6/Project2.xhtml\">JSF</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebApplication/Section1/Section6/Project2.cshtml\">ASP.NET Web App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section1/Section6/Project2.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/MVC/Section1/Section6/Project2\">ASP.NET MVC App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/SSI/Section1/Section6/Project2.html\">Apache SSI</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:82/Section1/Section6/Project2\">Python Web.py</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:83/Section1/Section6/Project2\">Ruby on Rails</a><br/>";
        }
        else if(input == 3)
        {
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section6/Project3.html\">HTML</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section6/Project3.php\">PHP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Javascript/Section1/Section6/Project3.html\">HTML Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/JQuery/Section1/Section6/Project3.html\">JQuery</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASP/Section1/Section6/Project3.asp\">ASP Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASPNET/Section1/Section6/Project3.aspx\">ASP.NET Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section1/Section6/Project3.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:84/Section1/Section6/Project3\">Node JS</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section6/Project3.shtml\">Perl</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSPApplication/Section1/Section6/Project3.jsp\">JSP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSFApplication/Section1/Section6/Project3.xhtml\">JSF</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebApplication/Section1/Section6/Project3.cshtml\">ASP.NET Web App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section1/Section6/Project3.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/MVC/Section1/Section6/Project3\">ASP.NET MVC App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/SSI/Section1/Section6/Project3.html\">Apache SSI</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:82/Section1/Section6/Project3\">Python Web.py</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:83/Section1/Section6/Project3\">Ruby on Rails</a><br/>";
        }
        else if(input == 4)
        {
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section6/Project4.html\">HTML</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section6/Project4.php\">PHP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Javascript/Section1/Section6/Project4.html\">HTML Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/JQuery/Section1/Section6/Project4.html\">JQuery</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASP/Section1/Section6/Project4.asp\">ASP Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASPNET/Section1/Section6/Project4.aspx\">ASP.NET Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section1/Section6/Project4.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:84/Section1/Section6/Project4\">Node JS</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section6/Project4.shtml\">Perl</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSPApplication/Section1/Section6/Project4.jsp\">JSP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSFApplication/Section1/Section6/Project4.xhtml\">JSF</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebApplication/Section1/Section6/Project4.cshtml\">ASP.NET Web App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section1/Section6/Project4.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/MVC/Section1/Section6/Project4\">ASP.NET MVC App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/SSI/Section1/Section6/Project4.html\">Apache SSI</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:82/Section1/Section6/Project4\">Python Web.py</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:83/Section1/Section6/Project4\">Ruby on Rails</a><br/>";
        }
        else if(input == 5)
        {
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section6/Project5.html\">HTML</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section6/Project5.php\">PHP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Javascript/Section1/Section6/Project5.html\">HTML Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/JQuery/Section1/Section6/Project5.html\">JQuery</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASP/Section1/Section6/Project5.asp\">ASP Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/ASPNET/Section1/Section6/Project5.aspx\">ASP.NET Javascript</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section1/Section6/Project5.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:84/Section1/Section6/Project5\">Node JS</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/Section1/Section6/Project5.shtml\">Perl</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSPApplication/Section1/Section6/Project5.jsp\">JSP</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:8080/JSFApplication/Section1/Section6/Project5.xhtml\">JSF</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebApplication/Section1/Section6/Project5.cshtml\">ASP.NET Web App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/WebForm/Section1/Section6/Project5.aspx\">ASP.NET Webform</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:81/MVC/Section1/Section6/Project5\">ASP.NET MVC App</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org/SSI/Section1/Section6/Project5.html\">Apache SSI</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:82/Section1/Section6/Project5\">Python Web.py</a><br/>";
            Result += "<a href=\"http://htkb.dyndns.org:83/Section1/Section6/Project5\">Ruby on Rails</a><br/>";
        }
        return Result;
    }
}
