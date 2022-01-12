import java.io.*;

public class Main
{
    private String ResultString;
    public static void main(String [] args) throws IOException
    {
        //
        int TAdderCurrent = 0;
        int VAdderCurrent = 0;
        int LAdderCurrent = 0;
        int XAdderCurrent = 0;
        int YAdderCurrent = 0;
        int ZAdderCurrent = 0;
        SixDigFuncClass InitialSixDigString = new SixDigFuncClass("000000");
        //BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true));
        Printer Print = new Printer(0);
        for (int i = -1; i < 999999; i++)
        {
            writer.append("/* z = " + ZAdderCurrent + " */\n{\n\t\"" + ResultString + "\"\n},\n");
            if (ZAdderCurrent == 9)
            {
                writer.append("\n");
            }
            ZAdder.doLevelPlusPlus();
            ZAdder.doZIntToStringToInt();
            ZAdder.CheckFor9();
            ZAdderCurrent = ZAdder.SetTo0();
        }
        writer.close();
    }

    public String doCoordInc()
    {
        //
        SixDigFuncClass InitialSixDigString = new SixDigFuncClass("000000");
        InitialSixDigString.toString();
        InitialSixDigString.PosOfFirstZero();
        InitialSixDigString.getLeadingZeros();
        InitialSixDigString.doTruncateLeadingZeros();
        InitialSixDigString.doIntSixDigStringPlusPlus();
        InitialSixDigString.doIntToString();
        InitialSixDigString.doSixDigStringPlusPlus();
        InitialSixDigString.FinalStringLength();
        InitialSixDigString.CheckStringLength();
        ResultString = InitialSixDigString.FinalStringSixDigString();
        return ResultString;
    }
}

/*
/* z = 0 *//*
{
    "000010"
},
*/

class SixDigFuncClass
{
    private String DynamicSixDigString;
    private String LeadingZeros;
    private int PosOfFirstZero;
    private int IntSixDigString = -1;
    private int CorrectStringFinalLength = 6;
    private int FinalStringLength = 0;
    private boolean HighestPlaceValueChanged;
    private int StringLengthDiference;

    public SixDigFuncClass(String StaticSixDigString)
    {
        DynamicSixDigString = StaticSixDigString;
    }

    @Override
    public String toString()
    {
        return DynamicSixDigString;
    }

    public int PosOfFirstZero()
    {
        PosOfFirstZero = DynamicSixDigString.indexOf("0");
        return PosOfFirstZero;
    }

    public String getLeadingZeros()
    {
        if (PosOfFirstZero == 0)
        {
            LeadingZeros = "00000";
        }
        else if (PosOfFirstZero == 1)
        {
            LeadingZeros = "0000";
        }
        else if (PosOfFirstZero == 2)
        {
            LeadingZeros = "000"; 
        }
        else if (PosOfFirstZero == 3)
        {
            LeadingZeros = "00";
        }
        else if (PosOfFirstZero == 4)
        {
            LeadingZeros = "0";
        }
        else if (PosOfFirstZero == 5)
        {
            LeadingZeros = "0";
        }
        else
        {
            return "Error";
        }
        return LeadingZeros;
    }

    public String doTruncateLeadingZeros()
    {
        DynamicSixDigString = DynamicSixDigString.substring(PosOfFirstZero + 1);
        return DynamicSixDigString;
    }

    public int doStringToInt()
    {
        IntSixDigString = Integer.parseInt(DynamicSixDigString);
        return IntSixDigString;
    }

    public int doIntSixDigStringPlusPlus()
    {
        IntSixDigString++;
        return IntSixDigString;
    }

    public String doIntToString()
    {
        DynamicSixDigString = String.valueOf(IntSixDigString);
        return DynamicSixDigString;
    }

    public String doSixDigStringPlusPlus()
    {
        DynamicSixDigString = LeadingZeros + DynamicSixDigString;
        return DynamicSixDigString;
    }

    public int FinalStringLength()
    {
        FinalStringLength = DynamicSixDigString.length();
        return FinalStringLength;
    }

    public Boolean CheckStringLength()
    {
        if (FinalStringLength != CorrectStringFinalLength)
        {
            HighestPlaceValueChanged = true;
        }
        else if (FinalStringLength == CorrectStringFinalLength)
        {
            HighestPlaceValueChanged = false;
        }
        return HighestPlaceValueChanged;
    }

    public String FinalStringSixDigString()
    {
        if (HighestPlaceValueChanged == true)
        {
            StringLengthDiference = FinalStringLength - CorrectStringFinalLength;
            DynamicSixDigString = DynamicSixDigString.substring(StringLengthDiference);
        }
        return DynamicSixDigString;
    }
}

class ZLevel
{
    private int ZDynamicLevelInt = 0;
    private String ZDynamicLevelString = null;
    private boolean ZEquals9 = false;
    public ZLevel(int ZLevelInitial)
    {
        //
        ZDynamicLevelInt = ZLevelInitial;
    }
    
    public int doLevelPlusPlus()
    {
        //
        ZDynamicLevelInt++;
        
        return ZDynamicLevelInt;
    }

    public int doZIntToStringToInt()
    {
        ZDynamicLevelString = String.valueOf(ZDynamicLevelInt);
        ZDynamicLevelInt = Integer.parseInt(ZDynamicLevelString);
        return ZDynamicLevelInt;
    }

    public boolean CheckFor9()
    {
        if (ZDynamicLevelInt > 9)
        {
            ZEquals9 = true;
        }
        else if (ZDynamicLevelInt < 9)
        {
            ZEquals9 = false;
        }
        return ZEquals9;
    }

    public int SetTo0()
    {
        if (ZEquals9 == true)
        {
            ZDynamicLevelInt = 0;
        }
        return ZDynamicLevelInt;
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
    private String DynamicResultString;
    private String PrintOutput;
    BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true));
    
    public Printer(String ResultString)
    {
        //
        DynamicResultString = ResultString;
    }

    public String Print()
    {
        for (TLevel = 0; TLevel <= 9; TLevel++)
        {
            writer.append("/* t = " + TLevel + " */");
            for (VLevel = 0; VLevel <=9; VLevel++)
            {
                writer.append("/* v = " + VLevel + " */");
                for (LLevel = 0; LLevel <= 9; LLevel++)
                {
                    writer.append("/* l = " + LLevel + " */");
                    for (XLevel = 0; XLevel <= 9; XLevel++)
                    {
                        writer.append("/* x = " + XLevel + " */");
                        for (YLevel = 0; YLevel <= 9; YLevel++)
                        {
                            writer.append("/* y = " + YLevel + " */");
                            for (ZLevel = 0; ZLevel <= 9; ZLevel++)
                            {
                                writer.append("/* z = " + ZLevel + " */ \n{\n\t\"" + DynamicResultString + "\"");
                                if (ZLevel == 9)
                                {
                                    writer.append("\n}");
                                }
                                else
                                {
                                    writer.append("\n},");
                                }
                            }
                            if (YLevel == 9)
                            {
                                writer.append("\n}");
                            }
                            else
                            {
                                writer.append("\n},");
                            }
                        }
                        if (XLevel == 9)
                        {
                            writer.append("\n}");
                        }
                        else
                        {
                            writer.append("\n},");
                        }
                    }
                    if (LLevel == 9)
                    {
                        writer.append("\n}");
                    }
                    else
                    {
                        writer.append("\n},");
                    }
                }
                if (VLevel == 9)
                {
                writer.append("\n}");
                }
                else
                {
                    writer.append("\n},");
                }
            }
            if (TLevel == 9)
            {
                writer.append("\n}");
            }
            else
            {
                writer.append("\n},");
            }
        }
        return PrintOutput;
    }
}
/*
class YLevel
{
    
}
*/