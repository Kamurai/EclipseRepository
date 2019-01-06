package information.uCD33.common;

public class Address extends information.uLDD30.common.Address{
	String addressUnitDesignatorType; //Enumeration
	String addressUnitIdentifier;
	
	public Address(){super();}

	public String getAddressUnitDesignatorType() {
		return addressUnitDesignatorType;
	}

	public void setAddressUnitDesignatorType(String addressUnitDesignatorType) {
		this.addressUnitDesignatorType = addressUnitDesignatorType;
	}

	public String getAddressUnitIdentifier() {
		return addressUnitIdentifier;
	}

	public void setAddressUnitIdentifier(String addressUnitIdentifier) {
		this.addressUnitIdentifier = addressUnitIdentifier;
	}
}
