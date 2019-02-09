/***/
public class Address {
    private int    _id;

    private String _city;
    private String _country;
    private String _province;
    private String _postalCode;
    private String _addressType;
    private String _addressLine;
    private String _lastUpdate;

    //private long   _postalCode;
    //last update

    public Address(int id, String addressType, String addressLine, String province, String city, String country, String postalCode, String lastUpdate) {
        this._id = id;
        this._city = city;
        this._country = country;
        this._province = province;
        this._postalCode = postalCode;
        this._lastUpdate = lastUpdate;
        this._addressType = addressType;
        this._addressLine = addressLine;
    }

    public String getAddressType() {
        return this._addressType;
    }

    public String getAddressLine() {
        return this._addressLine;
    }

    public String getProvince() {
        return this._province;
    }

    public String getCity() {
        return this._city;
    }

    public String getCountry() {
        return this._country;
    }

    public String getPostalCode() {
        return this._postalCode;
    }

//    public Address getAddressOfType() {
//
//    }
}
