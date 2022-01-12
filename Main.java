import java.util.*;
import java.io.*;
import java.lang.*;
//import Logger.java;

class Main
{
    public static void main(String [] args)
    {
        //
        String ResultString;
        SixDigFuncClass InitialSixDigString = new SixDigFuncClass("000000");
        for (int i = -1; i < 999999; i++)
        {
            //
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
            System.out.println(ResultString);

        }
        /*PrintStream out = new PrintStream(
        new FileOutputStream("output.txt", append), autoFlush);
        System.setOut(out);*/

    }
}

class SixDigFuncClass
{
    //
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
        //
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
        //
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
        //
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
        //
        if (HighestPlaceValueChanged == false)
        {
            DynamicSixDigString = DynamicSixDigString;
        }

        else if (HighestPlaceValueChanged == true)
        {
            StringLengthDiference = FinalStringLength - CorrectStringFinalLength;
            DynamicSixDigString = DynamicSixDigString.substring(StringLengthDiference);
        }
        return DynamicSixDigString;
    }

}

/*
class StoreStringValues
{
    ArrayList<StringList> StringList
}


PrintStream out = new PrintStream(new FileOutputStream("output.txt", append), autoFlush);
System.setOut(out);*/

/*

    if (SixDigString.charAt(0) == 0 && SixDigString.charAt(1) != 0) // 1 (0)00000
        {
            //
            SixDigString.substring(1);
            SixDigInt = Integer.parseInt(SixDigString);
            SixDigInt++;
            SixDigString = String.valueOf(SixDigInt);
            ZerosToAddBack = "0";
            SixDigString = ZerosToAddBack + SixDigString;
        }
        else if (SixDigString.charAt(1) == 0 && SixDigString.charAt(2) != 0) // 2 0(0)0000
        {
            //
            SixDigString.substring(2);
            SixDigInt = Integer.parseInt(SixDigString);
            SixDigInt++;
            SixDigString = String.valueOf(SixDigInt);
            ZerosToAddBack = "00";
            SixDigString = ZerosToAddBack + SixDigString;
        }
        else if (SixDigString.charAt(2) == 0 && SixDigString.charAt(3) != 0) // 3 00(0)000
        {
            //
            SixDigString.substring(3);
            SixDigInt = Integer.parseInt(SixDigString);
            SixDigInt++;
            SixDigString = String.valueOf(SixDigInt);
            ZerosToAddBack = "000";
            SixDigString = ZerosToAddBack + SixDigString;
        }
        else if (SixDigString.charAt(3) == 0 && SixDigString.charAt(4) != 0) // 4 000(0)00
        {
            //
            SixDigString.substring(4);
            SixDigInt = Integer.parseInt(SixDigString);
            SixDigInt++;
            SixDigString = String.valueOf(SixDigInt);
            ZerosToAddBack = "0000";
            SixDigString = ZerosToAddBack + SixDigString;
        }            
        else if (SixDigString.charAt(4) == 0 && SixDigString.charAt(5) != 0) // 5 0000(0)0
        {
            //
            SixDigString.substring(5);
            SixDigInt = Integer.parseInt(SixDigString);
            SixDigInt++;
            SixDigString = String.valueOf(SixDigInt);
            ZerosToAddBack = "00000";
            SixDigString = ZerosToAddBack + SixDigString;
        }                
        else if (SixDigString.charAt(5) == 0) // 6 00000(0)
        {
            //
            SixDigInt = Integer.parseInt(SixDigString);
            SixDigInt++;
            SixDigString = String.valueOf(SixDigInt);
            System.out.println(SixDigString);
        }
        return SixDigString;
        */