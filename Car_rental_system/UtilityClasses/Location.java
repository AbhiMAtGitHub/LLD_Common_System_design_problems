package UtilityClasses;

public class Location {
	private String address;
    private String city;
    private String state;
    private String zipCode;
    
    public Location(String address, String city, String state, String zipCode) {
        this.setAddress(address);
        this.setCity(city);
        this.setState(state);
        this.setZipCode(zipCode);
    }

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
