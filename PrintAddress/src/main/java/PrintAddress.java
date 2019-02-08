
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

public class PrintAddress {

    public String prettyPrintAddress(Address address) {
        return  "lebo";
    }

    public static void main(String[] args) throws Exception {
        try {
            System.out.println("life" +
                    "");
            //Parsing file "addresses.json"
            Object obj = new JSONParser().parse(new FileReader("addresses.json"));

            //typecasting obj to JSONArray
            JSONArray jArrary = (JSONArray) obj;

            System.out.println(jArrary.get(0));

            Iterator itr2 = jArrary.iterator();

            while (itr2.hasNext()) {
               Iterator<Map.Entry> itr1 = ((Map) itr2.next()).entrySet().iterator();
               while (itr1.hasNext()) {
                   Map.Entry pair = itr1.next();
                   //System.out.println(pair.getKey() + " : " + pair.getValue());
               }
            }

            //getting some infor to see if it works
//            Map type = ((Map)jObj.get("type"));
//
//            //interate
//            Iterator<Map.Entry> itr1 = type.entrySet().iterator();
//            while (itr1.hasNext()) {
//                Map.Entry pair = itr1.next();
//                System.out.println(pair.getKey() + " : " + pair.getValue());
//            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
