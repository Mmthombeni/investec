
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PrintAddress {
    private static List<Address> addresses = new ArrayList<Address>();

    public String prettyPrintAddress(Address address) {
        String toPrint = String.format("%-18.18s: %-18.18s - %-18.18s - %-16.16s - %-8.8s - %-18.18s",
                address.getAddressType(), address.getAddressLine(), address.getCity(), address.getProvince(), address.getPostalCode(), address.getCountry());

        return toPrint;
    }

    public void prettyPrintAll(List<Address> addresses) {
        //System.out.println(addresses.size() + "<< size");
        for (Address addrss: addresses) {
            System.out.println(prettyPrintAddress(addrss));
        }
    }

    public void prettyPrintType(List<Address> addresses , String type) {
        System.out.println("Type size>> " + addresses.size());
        if (type.equalsIgnoreCase("postal")) {
            for (Address postAddrss: addresses) {
                if (postAddrss.getAddressType().equalsIgnoreCase("Postal Address")) {
                    System.out.println(prettyPrintAddress(postAddrss));
                }
            }
        }
        else if (type.equalsIgnoreCase("physical")) {
            for (Address physcAddrss: addresses) {
                if (physcAddrss.getAddressType().equalsIgnoreCase("Physical Address")) {
                    System.out.println(prettyPrintAddress(physcAddrss));
                }
            }
        }
        else if (type.equalsIgnoreCase("business")) {
            for (Address busnssAddrss: addresses) {
                if (busnssAddrss.getAddressType().equalsIgnoreCase("Business Address")) {
                    System.out.println(prettyPrintAddress(busnssAddrss));
                }
            }
        }
        System.out.println("address type not valid");
    }

    public String validateAddress(List<Address> addresses) {

        return "not valid";
    }

    public static void main(String[] args) throws Exception {
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
            //System.out.println(new PrintAddress().prettyPrintType(addresses, "phlk"));
            new PrintAddress().prettyPrintAll(addresses);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
