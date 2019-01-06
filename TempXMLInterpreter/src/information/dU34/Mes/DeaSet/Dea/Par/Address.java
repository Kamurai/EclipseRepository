package information.dU34.Mes.DeaSet.Dea.Par;

public class Address extends information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Res.Address{
//	String addressLineText;
//	String cityName;
//	String postalCode;
//	String stateCode;
//	String addressUnitIdentifier;
//	String CountryCode;
	String addressType; //Enumeration
	
	public Address(){super();}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
}
