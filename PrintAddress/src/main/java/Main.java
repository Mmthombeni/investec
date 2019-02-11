/**
 * Java program that reads addresses from a json file and then pretty Prints them according to ethier; all the listed
 * addresses, types of addresses(postal, business, physical) and also validates if the address given is valied
 * */
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Address> addresses = new ArrayList<Address>();

    /**
     * 
     * Reads the addresses.json file, iterates through it's objects to retrive the addresses then creates a new Address
     * to be printed by the TYPE of address and without filter(all the addresses given)  
     * @throws Exception if json file cannot be read
     */
    public static void main(String[] args) throws Exception {
        PrintAddress print = new PrintAddress();
        int id;
        String city;
        String country;
        String province;
        String postalCode;
        String addressType;
        String addressLine;
        String date;
        Address address = null;

        try {
            //Parsing file "addresses.json"
            Object obj = new JSONParser().parse(new FileReader("addresses.json"));

            //typecasting obj to JSONArray
            JSONArray jArrary = (JSONArray) obj;

            Iterator itr2 = jArrary.iterator();

            while (itr2.hasNext()) {
                Iterator<Map.Entry> itr1 = ((Map) itr2.next()).entrySet().iterator();
                id = 0;
                city = "";
                date = "";
                country = "";
                province = "";
                postalCode = "";
                addressType = "";
                addressLine = "";

                while (itr1.hasNext()) {
                    Map.Entry pair = itr1.next();
                    try {
                        JSONObject ob = (JSONObject) pair.getValue();
                        if (pair.getKey().toString().equalsIgnoreCase("type")) {
                            addressType = (String) ob.get("name");
                        } else if (pair.getKey().toString().equalsIgnoreCase("addressLineDetail")) {
                            addressLine = (String) ob.get("line1") + " " + (String) ob.get("line2");
                        } else if (pair.getKey().toString().equalsIgnoreCase("provinceOrState")) {
                            province = (String) ob.get("name");
                        } else if (pair.getKey().toString().equalsIgnoreCase("country")) {
                            country = (String) ob.get("name");
                        }

                    } catch (Exception exc) {
                    }
                    if (pair.getKey().toString().equalsIgnoreCase("cityOrTown")) {
                        city = pair.getValue().toString();
                    } else if (pair.getKey().toString().equalsIgnoreCase("postalCode")) {
                        postalCode = pair.getValue().toString();
                    } else if (pair.getKey().toString().equalsIgnoreCase("lastUpdated")) {
                        date = pair.getValue().toString();
                    } else if (pair.getKey().toString().equalsIgnoreCase("id")) {
                        id = Integer.parseInt(pair.getValue().toString());
                    }
                }
                address = new Address(id, addressType, addressLine, province, city, country, postalCode, date);
                if (address != null) {
                    addresses.add(address);
                }
            }
            System.out.println("PRINT OF ALL THE GIVEN ADDRESSES");
            print.prettyPrintAll(addresses);

            System.out.println("\nPRINT OF POSTAL ADDRESS");
            print.prettyPrintType(addresses, "postal");

            System.out.println("\nPRINT OF PHYSICAL ADDRESS");
            print.prettyPrintType(addresses, "physical");

            System.out.println("\nPRINT OF BUSINESS ADDRESS");
            print.prettyPrintType(addresses, "business");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
