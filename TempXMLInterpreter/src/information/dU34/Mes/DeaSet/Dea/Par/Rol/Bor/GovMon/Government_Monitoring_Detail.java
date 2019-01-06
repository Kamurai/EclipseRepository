package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon;

import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.GovMon.GovMonDet.Extension;

public class Government_Monitoring_Detail {
	Extension extension;
	Boolean hMDAEthnicityCollectedBasedOnVisualObservationOrSurnameIndicator;
	Boolean hMDAEthnicityRefusalIndicator;
	Boolean hMDAGenderCollectedBasedOnVisualObservationOrNameIndicator;
	Boolean hMDAGenderRefusalIndicator;
	Boolean hMDARaceCollectedBasedOnVisualObservationOrSurnameIndicator;
	Boolean hMDARaceRefusalIndicator;
	
	public Government_Monitoring_Detail(){
		extension = new Extension();
	}

	public Extension getExtension() {
		return extension;
	}

	public void setExtension(Extension extension) {
		this.extension = extension;
	}

	public Boolean getHMDAEthnicityCollectedBasedOnVisualObservationOrSurnameIndicator() {
		return hMDAEthnicityCollectedBasedOnVisualObservationOrSurnameIndicator;
	}

	public void setHMDAEthnicityCollectedBasedOnVisualObservationOrSurnameIndicator(
			Boolean hMDAEthnicityCollectedBasedOnVisualObservationOrSurnameIndicator) {
		this.hMDAEthnicityCollectedBasedOnVisualObservationOrSurnameIndicator = hMDAEthnicityCollectedBasedOnVisualObservationOrSurnameIndicator;
	}

	public Boolean getHMDAEthnicityRefusalIndicator() {
		return hMDAEthnicityRefusalIndicator;
	}

	public void setHMDAEthnicityRefusalIndicator(Boolean hMDAEthnicityRefusalIndicator) {
		this.hMDAEthnicityRefusalIndicator = hMDAEthnicityRefusalIndicator;
	}

	public Boolean getHMDAGenderCollectedBasedOnVisualObservationOrNameIndicator() {
		return hMDAGenderCollectedBasedOnVisualObservationOrNameIndicator;
	}

	public void setHMDAGenderCollectedBasedOnVisualObservationOrNameIndicator(
			Boolean hMDAGenderCollectedBasedOnVisualObservationOrNameIndicator) {
		this.hMDAGenderCollectedBasedOnVisualObservationOrNameIndicator = hMDAGenderCollectedBasedOnVisualObservationOrNameIndicator;
	}

	public Boolean getHMDAGenderRefusalIndicator() {
		return hMDAGenderRefusalIndicator;
	}

	public void setHMDAGenderRefusalIndicator(Boolean hMDAGenderRefusalIndicator) {
		this.hMDAGenderRefusalIndicator = hMDAGenderRefusalIndicator;
	}

	public Boolean getHMDARaceCollectedBasedOnVisualObservationOrSurnameIndicator() {
		return hMDARaceCollectedBasedOnVisualObservationOrSurnameIndicator;
	}

	public void setHMDARaceCollectedBasedOnVisualObservationOrSurnameIndicator(
			Boolean hMDARaceCollectedBasedOnVisualObservationOrSurnameIndicator) {
		this.hMDARaceCollectedBasedOnVisualObservationOrSurnameIndicator = hMDARaceCollectedBasedOnVisualObservationOrSurnameIndicator;
	}

	public Boolean getHMDARaceRefusalIndicator() {
		return hMDARaceRefusalIndicator;
	}

	public void setHMDARaceRefusalIndicator(Boolean hMDARaceRefusalIndicator) {
		this.hMDARaceRefusalIndicator = hMDARaceRefusalIndicator;
	}
	
	
	
}
