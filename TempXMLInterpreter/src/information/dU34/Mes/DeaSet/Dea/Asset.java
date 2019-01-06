package information.dU34.Mes.DeaSet.Dea;

import information.dU34.Mes.DeaSet.Dea.Ass.Asset_Detail;
import information.dU34.Mes.DeaSet.Dea.Ass.Asset_Holder;
import information.dU34.Mes.DeaSet.Dea.Ass.Owned_Property;

public class Asset {
	//Attributes
	String sequenceNumber;
	String xlinklabel;
	
	//Elements
	Asset_Detail asset_Detail;
	Asset_Holder asset_Holder;
	Owned_Property owned_Property;
	
	public Asset(){
		asset_Detail = new Asset_Detail();
		asset_Holder = new Asset_Holder();
		owned_Property = new Owned_Property();
	}
	
	public Asset_Detail getAsset_Detail() {
		return asset_Detail;
	}

	public void setAsset_Detail(Asset_Detail asset_Detail) {
		this.asset_Detail = asset_Detail;
	}

	public Asset_Holder getAsset_Holder() {
		return asset_Holder;
	}

	public void setAsset_Holder(Asset_Holder asset_Holder) {
		this.asset_Holder = asset_Holder;
	}

	public Owned_Property getOwned_Property() {
		return owned_Property;
	}

	public void setOwned_Property(Owned_Property owned_Property) {
		this.owned_Property = owned_Property;
	}

	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getXlinklabel() {
		return xlinklabel;
	}

	public void setXlinklabel(String xlinklabel) {
		this.xlinklabel = xlinklabel;
	}

}
