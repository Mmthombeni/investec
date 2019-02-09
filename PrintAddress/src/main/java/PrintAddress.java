
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

    public String prettyPrintAll(Address address) {
        return prettyPrintAddress(address);
    }

    public String prettyPrintType(List<Address> addresses , String type) {
        if (type.equalsIgnoreCase("postal")) {
            for (Address postAddrss: addresses) {
                if (postAddrss.getAddressType().equalsIgnoreCase("Postal Address")) {
                    return prettyPrintAddress(postAddrss);
                }
            }
        }
        else if (type.equalsIgnoreCase("physical")) {
            for (Address physcAddrss: addresses) {
                if (physcAddrss.getAddressType().equalsIgnoreCase("Physical Address")) {
                    return prettyPrintAddress(physcAddrss);
                }
            }
        }
        else if (type.equalsIgnoreCase("business")) {
            for (Address busnssAddrss: addresses) {
                if (busnssAddrss.getAddressType().equalsIgnoreCase("Business Address")) {
                    return prettyPrintAddress(busnssAddrss);
                }
            }
        }

        return "Address type not found";
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

            // new Array<Address>
            while (itr2.hasNext()) {
                Iterator<Map.Entry> itr1 = ((Map) itr2.next()).entrySet().iterator();
                id = 0;
                city = null;
                country = null;
                province = null;
                postalCode = null;  //for
                addressType = null;
                addressLine = null;
                date = null;

                while (itr1.hasNext()) {
                    Map.Entry pair = itr1.next();
                    try {
                        JSONObject ob = (JSONObject) pair.getValue();
                        if (pair.getKey().toString().equalsIgnoreCase("type")) {
                            addressType = (String) ob.get("name");
                            //System.out.println(addressType);
                        } else if (pair.getKey().toString().equalsIgnoreCase("addressLineDetail")) {
                            addressLine = (String) ob.get("line1") + " " + (String) ob.get("line2");
                            //System.out.println("AddressLine>>>" + addressLine);
                        } else if (pair.getKey().toString().equalsIgnoreCase("provinceOrState")) {
                            province = (String) ob.get("name");
                            // System.out.println(province);
                        } else if (pair.getKey().toString().equalsIgnoreCase("country")) {
                            country = (String) ob.get("name");
                            //System.out.println(country);
                        }

                    } catch (Exception exc) {
                    }
                    if (pair.getKey().toString().equalsIgnoreCase("cityOrTown")) {
                        city = pair.getValue().toString();
                        //System.out.println("CT Value -> " + city);
                    } else if (pair.getKey().toString().equalsIgnoreCase("postalCode")) {
                        postalCode = pair.getValue().toString();
                        //System.out.println("PC Value -> " + postalCode);
                    } else if (pair.getKey().toString().equalsIgnoreCase("lastUpdated")) {
                        date = pair.getValue().toString();
                        //System.out.println("LU Value -> " + date);
                    } else if (pair.getKey().toString().equalsIgnoreCase("id")) {
                        id = Integer.parseInt(pair.getValue().toString());
                        //System.out.println("Id Value -> " +id);
                    }
                }
                address = new Address(id, addressType, addressLine, province, city, country, postalCode, date);
                if (address != null) {
                    addresses.add(address);
                }
            }
            System.out.println(new PrintAddress().prettyPrintType(addresses, "physical"));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
