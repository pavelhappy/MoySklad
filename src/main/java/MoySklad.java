import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class MoySklad {
    public static void main(String[] args) throws Exception
    {
        System.out.println("Enter full path to file:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        try
        {
        InputStream inStream = new FileInputStream(fileName);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        InputStreamReader isr = new InputStreamReader(inStream, Charset.forName("UTF-8"));
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] s = line.split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            map.put(a,b);
        }
        isr.close();
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> me : set) {
            if (map.get(me.getValue()) == me.getKey())
            {
                System.out.println(me.getKey() + " " + me.getValue() + " " + map.get(me.getValue()));
            }
        }
        }
        catch (Exception e)
        {
            System.out.println("An error occurred while trying to open the file. Please check the file path.");
        }
    }
}
