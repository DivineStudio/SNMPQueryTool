package DivineStudio.SNMPQueryTool;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidateIPv4
{
    private static final String IPv4_REGEX =
        "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    
    private static final Pattern IPv4_PATTERN = Pattern.compile(IPv4_REGEX);
    
    public static boolean IsValidIPv4(String ip)
    {
        if (ip == null)
            return false;
        
        Matcher matcher = IPv4_PATTERN.matcher(ip);
        
        return matcher.matches();
    }
}
