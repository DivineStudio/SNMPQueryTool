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
    
    public SNMP(OID[] oids, String ipAddress, Integer retries, Integer timeout, int version)
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
    
    public void SetOids(OID[] oids)
    {
        this.oids = oids;
    }
    
    protected String GetIpAddress()
    {
        return ipAddress;
    }
    
    protected void SetIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }
    
    protected int GetRetries()
    {
        return retries;
    }
    
    protected void SetRetries(int retries)
    {
        this.retries = retries;
    }
    
    protected int GetTimeout()
    {
        return timeout;
    }
    
    protected void SetTimeout(int timeout)
    {
        this.timeout = timeout;
    }
    
    protected int GetVersion()
    {
        return version;
    }
    
    protected void SetVersion(int version)
    {
        this.version = version;
    }
    
    protected abstract void SNMPGet();
}
