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
    
    public void SetResults(String oid, String value)
    {
        this.results.put(oid, value);
    }
    
    public void PrintResults()
    {
        if (!results.isEmpty())
        {
            for (Map.Entry<String, String> r : this.results.entrySet())
            {
                System.out.println("OID: " + r.getKey() + " | Value: " + r.getValue());
            }
        }
        else
            System.out.println("Device not found. No results to display.");
    }
}
