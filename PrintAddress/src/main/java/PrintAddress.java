/**
 * The different print functions to print address in the different ways and validate if address valid
 * */
import java.util.ArrayList;
import java.util.List;

public class PrintAddress {
    private static List<Address> addresses = new ArrayList<Address>();

    public String prettyPrintAddress(Address address) {
        String toPrint = String.format("%-18.18s: %-18.18s - %-18.18s - %-16.16s - %-8.8s - %-18.18s",
                address.getAddressType(), address.getAddressLine(), address.getCity(), address.getProvince(),
                address.getPostalCode(), address.getCountry());

        return toPrint;
    }

    public void prettyPrintAll(List<Address> addresses) {
        int i = 1;
        System.out.println(String.format("   # %-18.18s  %-18.18s   %-18.18s   %-16.16s   %-8.8s   %-18.18s", "TYPE",
                "ADDRESS DETAILS", "CITY", "PROVINCE", "CODE", "COUNTRY"));

        for (Address address: addresses) {
            System.out.println(String.format("%4d %s", i, prettyPrintAddress(address)));
            validateAddress(address);
            i++;
        }
    }

    public void prettyPrintType(List<Address> addresses , String type) {
        int i = 1;
        System.out.println(String.format("   # %-18.18s  %-18.18s   %-18.18s   %-16.16s   %-8.8s   %-18.18s", "TYPE",
                "ADDRESS DETAILS", "CITY", "PROVINCE", "CODE", "COUNTRY"));

        if (type.equalsIgnoreCase("postal")) {
            for (Address postAddrss: addresses) {
                if (postAddrss.getAddressType().equalsIgnoreCase("Postal Address")) {
                    System.out.println(String.format("%4d %s", i, prettyPrintAddress(postAddrss)));
                    i++;
                }
            }
        }
        else if (type.equalsIgnoreCase("physical")) {
            for (Address physcAddrss: addresses) {
                if (physcAddrss.getAddressType().equalsIgnoreCase("Physical Address")) {
                    System.out.println(String.format("%4d %s", i, prettyPrintAddress(physcAddrss)));
                    i++;
                }
            }
        }
        else if (type.equalsIgnoreCase("business")) {
            for (Address busnssAddrss: addresses) {
                if (busnssAddrss.getAddressType().equalsIgnoreCase("Business Address")) {
                    System.out.println(String.format("%4d %s", i, prettyPrintAddress(busnssAddrss)));
                    i++;
                }
            }
        }
    }

    public void validateAddress(Address address) {
        if (address.getPostalCode().length() != 4) {  //change to int type
            System.out.println(Messages.INVALID_CODE);
        }
        else{
            try{
                Integer.parseInt(address.getPostalCode());
            }catch (Exception exc){
                System.out.println(Messages.INVALID_CODE);
            }
        }
        if (address.getAddressLine() == null || address.getAddressLine() == "") {
            System.out.println(Messages.INVALID_ADDRESSLN);
        }
        if (address.getCountry() != null || address.getCountry() != "") {
            if (address.getCountry().equalsIgnoreCase("South Africa")) {
                if (address.getProvince() == null || address.getProvince() == "") {
                    System.out.println(Messages.INVALID_PROV);
                }
            }
        }
        else {
            System.out.println(Messages.INVALID_COUNTRY);
        }
    }
}
