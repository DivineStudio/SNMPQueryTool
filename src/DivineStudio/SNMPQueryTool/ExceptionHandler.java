package DivineStudio.SNMPQueryTool;

public class ExceptionHandler
{
    public static void Print(Exception ex)
    {
        System.out.println("=========================" + ex.getMessage() + "\n\n" );
        ex.printStackTrace();
        System.out.println("\n\n=========================\n\n");
    }
    
    public static void Print(Throwable th)
    {
        System.out.println("=========================" + th.getMessage() + "\n\n" );
        th.printStackTrace();
        System.out.println("\n\n=========================\n\n");
    }
    
    public static void Print(String message)
    {
        System.out.println("\n" + message);
    }
}