package information.dU34.Mes.DeaSet.Dea.Ass;

import java.math.BigDecimal;

import information.dU34.Mes.DeaSet.Dea.Ass.AssDet.Extension;

public class Asset_Detail {
	String assetAccountIdentifier; //free form?
	BigDecimal AssetCashOrMarketValueAmount;
	String assetType; //Enumeration
	String assetTypeOtherDescription; //Enumeration
	String fundsSourceType; //Enumeration
	String fundsSourceTypeOtherDescription; //Enumeration
	Extension extension;

	public String getAssetAccountIdentifier() {
		return assetAccountIdentifier;
	}

	public void setAssetAccountIdentifier(String assetAccountIdentifier) {
		this.assetAccountIdentifier = assetAccountIdentifier;
	}

	public BigDecimal getAssetCashOrMarketValueAmount() {
		return AssetCashOrMarketValueAmount;
	}

	public void setAssetCashOrMarketValueAmount(String assetCashOrMarketValueAmount) {
		AssetCashOrMarketValueAmount = new BigDecimal(assetCashOrMarketValueAmount);
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public String getAssetTypeOtherDescription() {
		return assetTypeOtherDescription;
	}

	public void setAssetTypeOtherDescription(String assetTypeOtherDescription) {
		this.assetTypeOtherDescription = assetTypeOtherDescription;
	}

	public String getFundsSourceType() {
		return fundsSourceType;
	}

	public void setFundsSourceType(String fundsSourceType) {
		this.fundsSourceType = fundsSourceType;
	}

	public String getFundsSourceTypeOtherDescription() {
		return fundsSourceTypeOtherDescription;
	}

	public void setFundsSourceTypeOtherDescription(String fundsSourceTypeOtherDescription) {
		this.fundsSourceTypeOtherDescription = fundsSourceTypeOtherDescription;
	}

	public Extension getExtension() {
		return extension;
	}

	public void setExtension(Extension extension) {
		this.extension = extension;
	}

	public Asset_Detail(){}
}
