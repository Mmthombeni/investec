
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

            //System.out.println(jArrary.get(0));

            Iterator itr2 = jArrary.iterator();

            // new Array<Address>
            while (itr2.hasNext()) {
               Iterator<Map.Entry> itr1 = ((Map) itr2.next()).entrySet().iterator();

               // new Address()
               while (itr1.hasNext()) {
                   Map.Entry pair = itr1.next();

                   if (pair.getKey().toString().equalsIgnoreCase("type") || pair.getKey().toString().equalsIgnoreCase("addressLineDetail") || pair.getKey().toString().equalsIgnoreCase("provinceOrState")
                           || pair.getKey().toString().equalsIgnoreCase("cityOrTown") || pair.getKey().toString().equalsIgnoreCase("country")){
                       System.out.println("I am TYPE and an OBJ!");
                       try{
                           JSONObject ob  = (JSONObject) pair.getValue();
                           ob.get("name");
                           //ob.get("line");

                           String lebo = String.format("1. I alo hjave name.... %-10.10s - %-10.10s", ob.get("name").toString(), ob.get("name").toString());
                           System.out.println(lebo);
                       }catch (Exception exc){}
                   } else {
                       System.out.println(pair.getKey() + " : " + pair.getValue());
                   }

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
