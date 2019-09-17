package DivineStudio.SNMPQueryTool;

import org.snmp4j.smi.OID;

public class SNMPv1 extends SNMPv1v2
{
    public SNMPv1(OID[] oids, String ipAddress, Integer retries, Integer timeout, int version, String communityName)
    {
        super(oids, ipAddress, retries, timeout, version, communityName);
    }
}
