/**
 * The different print functions to print address in the different ways and validate if address valid
 * */
import java.util.List;

public class PrintAddress {
    /**
     * Gets the information of a given address and sets it to a format of how it will print
     * @param address the address to be printed
     * @return the string of the format of how the address should look
     */
    public String prettyPrintAddress(Address address) {
        String toPrint = String.format("%-18.18s: %-18.18s - %-18.18s - %-16.16s - %-8.8s - %-18.18s",
                address.getAddressType(), address.getAddressLine(), address.getCity(), address.getProvince(),
                address.getPostalCode(), address.getCountry());

        return toPrint;
    }

    /**
     * Loops through each address in the list of addresses and prints ALL the given address then validates if 
     * address if correct
     * @param addresses the list of the addresses read from the json file
     */
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

    /**
     * Checks which type of address you want to print, loops through the addresses looking for the TYPE of address you
     * specified to print, then prints that address 
     * @param addresses the list of addresses read from the json file
     * @param type the address TYPE you like to print out
     */
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
        else {
            System.out.println(Messages.INVALID_TYPE + type);
        }
    }

    /**
     * Validates if the given addresses are in a valid, if not it indicates what is invalid with the address that was given
     * @param address an address to validate and check if it's correct
     */
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
