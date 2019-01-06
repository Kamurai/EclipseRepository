package information.dU34.common;

public class Address extends information.uLDD30.common.Address {
//	String addressLineText;
//	String cityName;
//	String postalCode;
//	String stateCode;
	String addressUnitIdentifier;
	
	public Address(){super();}

	public String getAddressUnitIdentifier() {
		return addressUnitIdentifier;
	}

	public void setAddressUnitIdentifier(String addressUnitIdentifier) {
		this.addressUnitIdentifier = addressUnitIdentifier;
	}
}
