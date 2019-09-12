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

public abstract class SNMPv1v2 extends SNMP
{
    private OctetString communityName;
    
    public SNMPv1v2(IpAddress ipAddress, Integer retries, Integer timeout, SnmpConstants version, OctetString communityName)
    {
        super(ipAddress, retries, timeout, version);
        this.communityName = communityName;
    }
    
    protected OctetString GetCommunityName()
    {
        return communityName;
    }
    
    protected void GetCommunityName(OctetString communityName)
    {
        this.communityName = communityName;
    }
}
