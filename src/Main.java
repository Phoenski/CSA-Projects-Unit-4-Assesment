import java.io.*;

public class Main
{
    public static void main(String [] args) throws IOException
    {
        String ResultString;
        int adderTemp = 0;
        SixDigFuncClass InitialSixDigString = new SixDigFuncClass("000000");
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true));
        ZLevel adder = new ZLevel(0);
        for (int i = -1; i < 999999; i++)
        {
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
            writer.append("/* z = " + adderTemp + " */\n{\n\"" + ResultString + "\"\n},\n");
            adder.doLevelPlusPlus();
            adder.doZIntToStringToInt();
            adder.CheckFor9();
            adderTemp = adder.SetTo0();
            if (adderTemp == 9)
            {
                writer.append("\n");
            }
            
        }
        writer.close();
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
    private int DynamicLevelInt = 0;
    private String DynamicLevelString = null;
    private boolean Equals9 = false;
    public ZLevel(int Level)
    {
        //
        DynamicLevelInt = Level;
    }
    
    public int doLevelPlusPlus()
    {
        //
        DynamicLevelInt++;
        
        return DynamicLevelInt;
    }

    public int doZIntToStringToInt()
    {
        DynamicLevelString = String.valueOf(DynamicLevelInt);
        DynamicLevelInt = Integer.parseInt(DynamicLevelString);
        return DynamicLevelInt;
    }

    public boolean CheckFor9()
    {
        if (DynamicLevelInt > 9)
        {
            Equals9 = true;
        }
        else if (DynamicLevelInt < 9)
        {
            Equals9 = false;
        }
        return Equals9;
    }

    public int SetTo0()
    {
        if (Equals9 == true)
        {
            DynamicLevelInt = 0;
        }
        return DynamicLevelInt;
    }
}