package DivineStudio.SNMPQueryTool;

import org.snmp4j.smi.OID;
import org.snmp4j.mp.SnmpConstants;

public class Application
{
    // TODO Add object definition for initialization in the constructor
    
    Application()
    {

    }

    public static void main(String[] args) throws Exception
    {
        InitializeInterface();
    }

    // TODO Add the correct OIDs to perform SNMPGet
    // TODO Ensure that if the device does not return a value that it is not found
    private static void InitializeInterface()
    {
        System.out.println("Test: Performing SNMPGet on 10.6.0.40 with \"public\" community name.\n\n");

        OID[] oids = new OID[]{new OID(".1.1.0.2.5.1.0")};
        SNMPv1 snmpv1 = new SNMPv1(oids, "10.6.0.40", 5, 1000, SnmpConstants.version1, "public");
    }
}
