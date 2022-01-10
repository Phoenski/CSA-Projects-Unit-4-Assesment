import java.util.*;

class Main
{
    public static void main(String [] args)
    {
        //
        SixDigFuncClass InitialSixDigString = new SixDigFuncClass("000000");
        for (int i = 0; i < 10; i++)
        {
            //
            System.out.println(InitialSixDigString);
            InitialSixDigString.toString();
            InitialSixDigString.getLeadingZeros();
            InitialSixDigString.truncateLeadingZeros();
            InitialSixDigString.recordStringLengthBeforeIncrease();
            InitialSixDigString.IntSixDigStringPlusPlus();
            InitialSixDigString.toString();
            InitialSixDigString.checkHighestPlaceValueChanged();
        }
    }
}

class SixDigFuncClass
{
    //
    private String DynamicSixDigString;
    private String LeadingZeros;
    private int PosOfFirstZero;
    private int IntSixDigString;
    private int StringLengthBeforeIncrease;
    private int StringLengthAfterIncrease;
    private boolean HighestPlaceValueChanged;
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

    public int PosOfFirstZero(int PosOfFirstZero)
    {
        PosOfFirstZero = DynamicSixDigString.indexOf("0");
        return PosOfFirstZero;
    }

    public String getLeadingZeros()
    {
        if (PosOfFirstZero == 0)
        {
            LeadingZeros = "0";
        }
        else if (PosOfFirstZero == 1)
        {
            LeadingZeros = "00";
        }
        else if (PosOfFirstZero == 2)
        {
            LeadingZeros = "000"; 
        }
        else if (PosOfFirstZero == 3)
        {
            LeadingZeros = "0000";
        }
        else if (PosOfFirstZero == 4)
        {
            LeadingZeros = "00000";
        }
        else if (PosOfFirstZero == 5)
        {
            LeadingZeros = "00000";
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
        DynamicSixDigString = DynamicSixDigString.substring(PosOfFirstZero);
        return DynamicSixDigString;
    }

    public int recordStringLengthBeforeIncrease()
    {
        StringLengthBeforeIncrease = DynamicSixDigString.length();
        return StringLengthBeforeIncrease;
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

    public int recordStringLengthAfterIncrease()
    {
        StringLengthAfterIncrease =  Integer.parseInt(DynamicSixDigString);
        return StringLengthAfterIncrease;
    }

    public Boolean checkHighestPlaceValueChanged()
    {
        if (StringLengthBeforeIncrease != StringLengthAfterIncrease)
        {
            HighestPlaceValueChanged = true;
        }
        else if (StringLengthBeforeIncrease == StringLengthAfterIncrease)
        {
            HighestPlaceValueChanged = false;
        }
        return HighestPlaceValueChanged;
    }

}

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