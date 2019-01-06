package information.uLDD30.Mes.DeaSets.DeaSet.Dea.Par;

public class Address extends information.uLDD30.common.Address
{
	enum AddressType
	{
		Mailing
	};
	AddressType addressType;
	String countryCode;
	
	public Address()
	{
		super();
	}
}
