package DivineStudio.SNMPQueryTool;

import org.snmp4j.CommunityTarget;
import org.snmp4j.Snmp;
import org.snmp4j.Target;
import org.snmp4j.TransportMapping;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.util.DefaultPDUFactory;
import org.snmp4j.util.TreeEvent;
import org.snmp4j.util.TreeUtils;

public abstract class SNMP
{
    private IpAddress ipAddress;
    private Integer retries;
    private Integer timeout;
    private SnmpConstants version;
    
    public SNMP(IpAddress ipAddress, Integer retries, Integer timeout, SnmpConstants version)
    {
        this.ipAddress = ipAddress;
        this.retries = retries;
        this.timeout = timeout;
        this.version = version;
    }
    
    protected IpAddress GetIpAddress()
    {
        return ipAddress;
    }
    
    protected void SetIpAddress(IpAddress ipAddress)
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
    
    protected SnmpConstants GetVersion()
    {
        return version;
    }
    
    protected void SetVersion(SnmpConstants version)
    {
        this.version = version;
    }
    
    protected abstract void SNMPGet();
}
