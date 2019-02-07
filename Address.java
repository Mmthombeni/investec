/**
 * Address
 */
public class Address {
    private String _addressType;
    private String _addressLine;
    private String _province;
    private String _city;
    private String _country;
    private long   _postalCode;

    public Address(String addressType, String addressLine, String province, String city, String country, long postalCode) {
        this._addressType = addressType;
        this._addressLine = addressLine;
        this._province = province;
        this._city = city;
        this._country = country;
        this._postalCode = postalCode;
    }
}