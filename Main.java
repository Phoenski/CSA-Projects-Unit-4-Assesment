class Main
{
    public static void main(String [] args)
    {
        //
        String n;
        SixDigFuncClass InitialSixDigString = new SixDigFuncClass();
        for (int i = 0; i < 1000000; i++)
        {
            //
            System.out.println(InitialSixDigString);
        }
    }
}
class SixDigFuncClass
{
    //
    public String SixDigFunc(String SixDigString)
    {
        //
        SixDigString = "000000";
        String ZerosToAddBack;
        int SixDigInt;
        if (SixDigString.charAt(0) == 0) // 1 (0)00000
        {
            //
            SixDigString.substring(1);
            SixDigInt = Integer.parseInt(SixDigString);
            SixDigInt++;
            SixDigString = String.valueOf(SixDigInt);
            ZerosToAddBack = "0";
            SixDigString = ZerosToAddBack + SixDigString;
        }
        else if (SixDigString.charAt(1) == 0) // 2 0(0)0000
        {
            //
            SixDigString.substring(2);
            SixDigInt = Integer.parseInt(SixDigString);
            SixDigInt++;
            SixDigString = String.valueOf(SixDigInt);
            ZerosToAddBack = "00";
            SixDigString = ZerosToAddBack + SixDigString;
        }
        else if (SixDigString.charAt(2) == 0) // 3 00(0)000
        {
            //
            SixDigString.substring(3);
            SixDigInt = Integer.parseInt(SixDigString);
            SixDigInt++;
            SixDigString = String.valueOf(SixDigInt);
            ZerosToAddBack = "000";
            SixDigString = ZerosToAddBack + SixDigString;
        }
        else if (SixDigString.charAt(3) == 0) // 4 000(0)00
        {
            //
            SixDigString.substring(4);
            SixDigInt = Integer.parseInt(SixDigString);
            SixDigInt++;
            SixDigString = String.valueOf(SixDigInt);
            ZerosToAddBack = "0000";
            SixDigString = ZerosToAddBack + SixDigString;
        }            
        else if (SixDigString.charAt(4) == 0) // 5 0000(0)0
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
        }
        return SixDigString;
    }  
}