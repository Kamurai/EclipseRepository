package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Res;

public class Address extends information.dU34.common.Address{
//	String addressLineText;
//	String cityName;
//	String postalCode;
//	String stateCode;
//	String addressUnitIdentifier;
	String countryCode;
	
	public Address(){super();}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}
