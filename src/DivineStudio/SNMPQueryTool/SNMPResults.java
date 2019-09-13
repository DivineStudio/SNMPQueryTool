package DivineStudio.SNMPQueryTool;

import java.util.Map;
import java.util.TreeMap;

public class SNMPResults
{
    private Map<String, String> results;
    
    public SNMPResults()
    {
        results = new TreeMap<>();
    }
    
    public Map<String, String> GetResults()
    {
        return results;
    }
    
    public boolean IsEmpty()
    {
        return results.isEmpty();
    }
    
    public void SetResults(String oid, String value)
    {
        this.results.put(oid, value);
    }
    
    public void PrintResults()
    {
        if (!results.isEmpty())
        {
            String str = "";
            for (Map.Entry<String, String> r : this.results.entrySet())
            {
                str += "OID: " + r.getKey() + " | Value: " + r.getValue() + "\n";
            }
            
            System.out.println(str);
        }
        else
            System.out.println("Device not found!");
    }
}
