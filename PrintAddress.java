/**
 * PrintAddress
 */

 import java.io.FileReader;
 import org.json.simple.*;

//import jdk.nashorn.api.scripting.JSObject;

public class PrintAddress {

    public String prettyPrintAddress(Address address) {

    }
    public static void main(String[] args) throws Exception {
        try {
            //parsing file "addresses.jason"
            Object obj = new JSONParser().parse(new FileReader("addresses.json"));

            //typecast obj to JSONObject
            JSONObject jObj = (JSONObject) obj;

            

        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }
    
}