/** Array Writer 
 * By: Aidan Waeltz
 * Expected output: 4,333,332 lines
 * CamelCase is not used.
 * Do not run without first clearing file "output.txt"
*/

import java.io.*;

public class Main
{
    public static void main(String [] args) throws IOException
    {
        Printer print = new Printer();
        print.doPrint();
        while (CoordUpdater.FinalCoord.equals("999999"))
        {
            System.exit(0);
        }
    }
}

/* Updates the value of the coordinate via converting the current value of the number of iterations completed for each for loop into a single string*/
class CoordUpdater
{
    private String TLevelString;
    private String VLevelString;
    private String LLevelString;
    private String XLevelString;
    private String YLevelString;
    private String ZLevelString;
    public static String FinalCoord;

    public CoordUpdater()
    {
        //
    }

    public String doCoordUpdate(int TLevel, int VLevel, int LLevel, int XLevel, int YLevel, int ZLevel)
    {
        TLevelString = String.valueOf(TLevel);
        VLevelString = String.valueOf(VLevel);
        LLevelString = String.valueOf(LLevel);
        XLevelString = String.valueOf(XLevel);
        YLevelString = String.valueOf(YLevel);
        ZLevelString = String.valueOf(ZLevel);

        FinalCoord = TLevelString + VLevelString + LLevelString + XLevelString + YLevelString + ZLevelString;
        return FinalCoord;
    }
}

class Printer
{
    private int TLevel = 0;
    private int VLevel = 0;
    private int LLevel = 0;
    private int XLevel = 0;
    private int YLevel = 0;
    private int ZLevel = 0;
    private String PrintOutput;
    public CoordUpdater NextString = new CoordUpdater();
    
    public Printer()
    {
        //
    }

    public String doPrint() throws IOException
    {
        BufferedWriter Writer = new BufferedWriter(new FileWriter("output.txt", true));
        try
        {  
            Writer.append("{\n");
            for (TLevel = 0; TLevel <= 9; TLevel++)
            {
                Writer.append("\t/* t = " + TLevel + " */\n\t{\n");
                for (VLevel = 0; VLevel <=9; VLevel++)
                {
                    Writer.append("\t\t/* v = " + VLevel + " */\n\t\t{\n");
                    for (LLevel = 0; LLevel <= 9; LLevel++)
                    {
                        Writer.append("\t\t\t/* l = " + LLevel + " */\n\t\t\t{\n");
                        for (XLevel = 0; XLevel <= 9; XLevel++)
                        {
                            Writer.append("\t\t\t\t/* x = " + XLevel + " */\n\t\t\t\t{\n");
                            for (YLevel = 0; YLevel <= 9; YLevel++)
                            {
                                Writer.append("\t\t\t\t\t/* y = " + YLevel + " */\n\t\t\t\t\t{\n");
                                for (ZLevel = 0; ZLevel <= 9; ZLevel++)
                                {
                                    /* Asks for the value of CurrentString to be updated using doCoordUpdate method. */
                                    String CurrentString = NextString.doCoordUpdate(TLevel, VLevel, LLevel, XLevel, YLevel, ZLevel);
                                    Writer.append("\t\t\t\t\t\t/* z = " + ZLevel + " */ \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"" + CurrentString + "\"\n");
                                    if (ZLevel == 9)
                                    {
                                        Writer.append("\t\t\t\t\t\t}\n");
                                    }
                                    else
                                    {
                                        Writer.append("\t\t\t\t\t\t},\n");
                                    }
                                }
                                if (YLevel == 9)
                                {
                                    Writer.append("\t\t\t\t\t}\n");
                                }
                                else
                                {
                                    Writer.append("\t\t\t\t\t},\n");
                                }
                            }
                            if (XLevel == 9)
                            {
                                Writer.append("\t\t\t\t}\n");
                            }
                            else
                            {
                                Writer.append("\t\t\t\t},\n");
                            }
                        }
                        if (LLevel == 9)
                        {
                            Writer.append("\t\t\t}\n");
                        }
                        else
                        {
                            Writer.append("\t\t\t},\n");
                        }
                    }
                    if (VLevel == 9)
                    {
                    Writer.append("\t\t}\n");
                    }
                    else
                    {
                        Writer.append("\t\t},\n");
                    }
                }
                if (TLevel == 9)
                {
                    Writer.append("\t}\n");
                }
                else
                {
                    Writer.append("\t},\n");
                }
            }
        } catch (IOException ErrorReport) {
            ErrorReport.printStackTrace();
        } finally {
            Writer.append("");
            Writer.close();
        }
        return PrintOutput;
    }
}