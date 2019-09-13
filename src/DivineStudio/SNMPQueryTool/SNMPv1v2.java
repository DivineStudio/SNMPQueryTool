package DivineStudio.SNMPQueryTool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.snmp4j.CommunityTarget;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.PDU;

public abstract class SNMPv1v2 extends SNMP
{
    private String communityName;
    
    public SNMPv1v2(OID[] oids, String ipAddress, Integer retries, Integer timeout, int version, String communityName)
    {
        super(oids, ipAddress, retries, timeout, version);
        this.communityName = communityName;
    }
    
    protected String GetCommunityName()
    {
        return communityName;
    }
    
    protected void GetCommunityName(String communityName)
    {
        this.communityName = communityName;
    }
    
    @Override
    protected void SNMPGet()
    {
        CommunityTarget target = new CommunityTarget();
            target.setCommunity(new OctetString(GetCommunityName()));
            target.setAddress(GenericAddress.parse(CommunicationProtocols.udp + ":" + GetIpAddress() + "/" + Ports.port161));
            target.setRetries(GetRetries());
            target.setTimeout(GetTimeout());
            target.setVersion(GetVersion());
    
        GetHelpers helper = new GetHelpers(target);
        helper.StartGet();
    }
    
    private class GetHelpers
    {
        private Snmp snmp;
        private CommunityTarget target;
        
        public GetHelpers(CommunityTarget target)
        {
            this.target = target;
        }
        
        public void StartGet()
        {
            SNMPResults results = new SNMPResults();
    
            int index = 0;
            
            try
            {
                Start();
                
                for (OID oid : GetOids())
                {
                    results.SetResults(oid.toString(), GetAsString(oid));
                    index++;
                }
                
                results.PrintResults();

            }
            catch (Throwable ex)
            {
                System.out.println("IOException:\n" + ex.getMessage() + "\n");
                ex.printStackTrace();
            }
        }
        
        private void Start() throws IOException
        {
            TransportMapping<? extends Address> transport = new DefaultUdpTransportMapping();
            snmp = new Snmp(transport);
            transport.listen();
        }
    
        private String GetAsString(OID oid) throws IOException
        {
            try
            {
                ResponseEvent event = Get(new OID[]{oid});
                return event.getResponse().get(0).getVariable().toString();
            }
            catch(NullPointerException ex)
            {
                System.out.println("No Device Found | Retrying...");
                return "";
            }
            
        }
    
        private ResponseEvent Get(OID oids[]) throws IOException
        {
            PDU pdu = new PDU();
            
            for (OID oid : oids)
            {
                pdu.add(new VariableBinding(oid));
            }
            
            pdu.setType(PDU.GET);
            
            ResponseEvent event = snmp.send(pdu, target, null);
            
            if (event != null)
            {
                return event;
            }
            
            throw new RuntimeException("GET timed out");
        }
    }
}
