package information.uLDD30.common;

public abstract class Address 
{
	String addressLineText;
	String cityName;
	String postalCode;
	String stateCode;
	
	public Address(){}

	public String getAddressLineText() {
		return addressLineText;
	}

	public void setAddressLineText(String addressLineText) {
		this.addressLineText = addressLineText;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
}

