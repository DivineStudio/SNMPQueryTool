package DivineStudio.SNMPQueryTool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.snmp4j.mp.SnmpConstants;

public class Application
{
    Application() { }

    public static void main(String[] args) throws Exception
    {
        InitializeInterface();
    }
    
    private static void InitializeInterface() throws IOException
    {
        String SnmpVersion = "";
        boolean isProcessCorrect = true;
        boolean performAgain = true;
    
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            System.out.println();
            System.out.println();
            
            do
            {
                do
                {
                    System.out.print("Select which process to perform:\n\nSNMPGet\n1: SNMPv1/v2c\n2: SNMPv3 (Not Yet Available)\n\nEnter Selection: ");
                    SnmpVersion = reader.readLine();
        
                    System.out.println();
        
                    switch (SnmpVersion)
                    {
                        case "1":
                            String ip = "";
                            String community = "";
                
                            try
                            {
                                boolean isIP = false;
                    
                                do
                                {
                                    System.out.print("Please enter IP address of the device: ");
                                    ip = reader.readLine();
                                    
                                    if (ValidateIPv4.IsValidIPv4(ip) != false)
                                        isIP = true;
                                    else
                                    {
                                        isIP = false;
                                        System.out.println("\n===============\n\nNot an IP address. Ensure that the IP address is entered in IPv4 format. Try again.\n");
                                    }
                                } while (!isIP);
                    
                                System.out.print("Please enter community name of the device (if \"public\", you can leave blank): ");
                                community = reader.readLine();
                    
                                System.out.println("\nRetries: 5 | Timeout: 1000 ms\n");
                    
                                SNMPv1 snmpv1 = new SNMPv1(SNMP.SNMPGetOIDs.Oids, ip, 5, 1000, SnmpConstants.version1, community);
                                snmpv1.SNMPGet();
                            } catch (IOException ex)
                            {
                                ExceptionHandler.Print(ex);
                            }
                
                            isProcessCorrect = true;
                
                            break;
                        case "2": // TODO Until this is built out, fall through.
                            // break;
                        default:
                            isProcessCorrect = false;
                            System.out.println("===============\n\nIncorrect input. Try again.\n");
                    }
        
                    boolean inputFlag = false;
                    String yn = "n";
        
                    do
                    {
                        System.out.print("Would you like to use this tool again? (y)es or (n)o: ");
                        yn = reader.readLine();
                        
                        switch (yn)
                        {
                            case "y":
                                inputFlag = true;
                                performAgain = true;
                                break;
                            case "n":
                                inputFlag = true;
                                performAgain = false;
                                break;
                            default:
                                inputFlag = false;
                                System.out.println("\n===============\n\nIncorrect input. Try again");
                        }
                        System.out.println();
                    } while (!inputFlag);
                } while (!isProcessCorrect);
            } while (performAgain);
        }
        catch(IOException ex)
        {
            ExceptionHandler.Print(ex);
        }
    }
}
