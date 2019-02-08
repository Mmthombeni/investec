
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class PrintAddress {

    public String prettyPrintAddress(Address address) {
        return  "lebo";
    }

    public static void main(String[] args) throws Exception {
        try {
            Object obj = new JSONParser().parse(new FileReader("addresses.json"));

            JSONObject jObj = (JSONObject) obj;
            
        } catch (Exception e) {

        }
    }
}
