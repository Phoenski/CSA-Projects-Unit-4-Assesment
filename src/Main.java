/** Array Writer 
 * By: Aidan Waeltz
*/

import java.io.*;

public class Main
{
    public static void main(String [] args) throws IOException
    {
        Printer print = new Printer();
        print.Print();
    }
}

class CoordInc
{
    private String TLevelString;
    private String VLevelString;
    private String LLevelString;
    private String XLevelString;
    private String YLevelString;
    private String ZLevelString;
    private String FinalCoord;

    public CoordInc()
    {
        //
    }

    public String CoordUpdate(int TLevel, int VLevel, int LLevel, int XLevel, int YLevel, int ZLevel)
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
    public CoordInc NextString = new CoordInc();
    
    public Printer()
    {
        //
    }

    public String Print() throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true));
        writer.append("{\n");
        for (TLevel = 0; TLevel <= 9; TLevel++)
        {
            writer.append("\t/* t = " + TLevel + " */\n\t{\n");
            for (VLevel = 0; VLevel <=9; VLevel++)
            {
                writer.append("\t\t/* v = " + VLevel + " */\n\t\t{\n");
                for (LLevel = 0; LLevel <= 9; LLevel++)
                {
                    writer.append("\t\t\t/* l = " + LLevel + " */\n\t\t\t{\n");
                    for (XLevel = 0; XLevel <= 9; XLevel++)
                    {
                        writer.append("\t\t\t\t/* x = " + XLevel + " */\n\t\t\t\t{\n");
                        for (YLevel = 0; YLevel <= 9; YLevel++)
                        {
                            writer.append("\t\t\t\t\t/* y = " + YLevel + " */\n\t\t\t\t\t{\n");
                            for (ZLevel = 0; ZLevel <= 9; ZLevel++)
                            {
                                String CurrentString = NextString.CoordUpdate(TLevel, VLevel, LLevel, XLevel, YLevel, ZLevel);
                                writer.append("\t\t\t\t\t\t/* z = " + ZLevel + " */ \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\"" + CurrentString + "\"\n");
                                if (ZLevel == 9)
                                {
                                    writer.append("\t\t\t\t\t\t}\n");
                                }
                                else
                                {
                                    writer.append("\t\t\t\t\t\t},\n");
                                }
                            }
                            if (YLevel == 9)
                            {
                                writer.append("\t\t\t\t\t}\n");
                            }
                            else
                            {
                                writer.append("\t\t\t\t\t},\n");
                            }
                        }
                        if (XLevel == 9)
                        {
                            writer.append("\t\t\t\t}\n");
                        }
                        else
                        {
                            writer.append("\t\t\t\t},\n");
                        }
                    }
                    if (LLevel == 9)
                    {
                        writer.append("\t\t\t}\n");
                    }
                    else
                    {
                        writer.append("\t\t\t},\n");
                    }
                }
                if (VLevel == 9)
                {
                writer.append("\t\t}\n");
                }
                else
                {
                    writer.append("\t\t},\n");
                }
            }
            if (TLevel == 9)
            {
                writer.append("\t}\n");
            }
            else
            {
                writer.append("\t},\n");
            }
        }
        writer.append("}");
        writer.close();
        return PrintOutput;
    }
}