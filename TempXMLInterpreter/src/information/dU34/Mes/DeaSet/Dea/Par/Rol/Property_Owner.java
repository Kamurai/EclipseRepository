package information.dU34.Mes.DeaSet.Dea.Par.Rol;

public class Property_Owner {
	String propertyOwnerStatusType; //Enumeration
	String relationshipVestingType; //Enumeration
	String relationshipVestingTypeOtherDescription;

	public Property_Owner(){}

	public String getPropertyOwnerStatusType() {
		return propertyOwnerStatusType;
	}

	public void setPropertyOwnerStatusType(String propertyOwnerStatusType) {
		this.propertyOwnerStatusType = propertyOwnerStatusType;
	}

	public String getRelationshipVestingType() {
		return relationshipVestingType;
	}

	public void setRelationshipVestingType(String relationshipVestingType) {
		this.relationshipVestingType = relationshipVestingType;
	}

	public String getRelationshipVestingTypeOtherDescription() {
		return relationshipVestingTypeOtherDescription;
	}

	public void setRelationshipVestingTypeOtherDescription(String relationshipVestingTypeOtherDescription) {
		this.relationshipVestingTypeOtherDescription = relationshipVestingTypeOtherDescription;
	}
}
