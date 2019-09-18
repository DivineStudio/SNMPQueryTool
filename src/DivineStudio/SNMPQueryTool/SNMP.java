package DivineStudio.SNMPQueryTool;

import org.snmp4j.smi.OID;

public abstract class SNMP
{
    private OID[] oids;
    private String ipAddress;
    private Integer retries;
    private Integer timeout;
    private int version;
    
    public static final class Ports
    {
        public static final int port161 = 161;
        public static final int port162 = 162;
    }
    
    public static final class CommunicationProtocols
    {
        public static final String udp = "udp";
        public static final String tcp = "tcp";
    }
    
    public static final class SNMPGetOIDs
    {
        public static final OID[] Oids = new OID[]{
                new OID("1.3.6.1.2.1.1.1.0"),  //sysDescr
                new OID("1.3.6.1.2.1.1.2.0"),  //sysObjectID
                new OID("1.3.6.1.2.1.1.3.0"), //sysUpTime
                new OID("1.3.6.1.2.1.1.4.0"),  //sysContact
                new OID("1.3.6.1.2.1.1.5.0"),  //sysName
                new OID("1.3.6.1.2.1.25.3.2.1.4.1") //productID
        };
    }
    
    protected SNMP(OID[] oids, String ipAddress, Integer retries, Integer timeout, int version)
    {
        this.oids = oids;
        this.ipAddress = ipAddress;
        this.retries = retries;
        this.timeout = timeout;
        this.version = version;
    }
    
    public OID[] GetOids()
    {
        return oids;
    }
    
    protected String GetIpAddress()
    {
        return ipAddress;
    }
    
    protected int GetRetries()
    {
        return retries;
    }
    
    protected int GetTimeout()
    {
        return timeout;
    }
    
    protected int GetVersion()
    {
        return version;
    }
    
    protected abstract void SNMPGet();
}
