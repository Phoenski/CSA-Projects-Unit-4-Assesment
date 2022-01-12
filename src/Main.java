import java.io.*;

public class Main
{
    public static void main(String [] args) throws IOException
    {
        String ResultString;
        SixDigFuncClass InitialSixDigString = new SixDigFuncClass("000000");
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true));
        for (int i = -1; i < 999999; i++)
        {
            InitialSixDigString.toString();
            InitialSixDigString.PosOfFirstZero();
            InitialSixDigString.getLeadingZeros();
            InitialSixDigString.truncateLeadingZeros();
            InitialSixDigString.IntSixDigStringPlusPlus();
            InitialSixDigString.IntToString();
            InitialSixDigString.SixDigStringPlusPlus();
            InitialSixDigString.FinalStringLength();
            InitialSixDigString.CheckStringLength();
            ResultString = InitialSixDigString.FinalStringSixDigString();
            writer.append('\n');
            writer.append(ResultString);
        }
        writer.close();
    }
}

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

    public String truncateLeadingZeros()
    {
        DynamicSixDigString = DynamicSixDigString.substring(PosOfFirstZero + 1);
        return DynamicSixDigString;
    }

    public int doStringToInt()
    {
        IntSixDigString = Integer.parseInt(DynamicSixDigString);
        return IntSixDigString;
    }

    public int IntSixDigStringPlusPlus()
    {
        IntSixDigString++;
        return IntSixDigString;
    }

    public String IntToString()
    {
        DynamicSixDigString = String.valueOf(IntSixDigString);
        return DynamicSixDigString;
    }

    public String SixDigStringPlusPlus()
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