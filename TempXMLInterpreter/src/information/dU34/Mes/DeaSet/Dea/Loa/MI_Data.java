package information.dU34.Mes.DeaSet.Dea.Loa;

import information.dU34.Mes.DeaSet.Dea.Loa.MIDat.MI_Data_Detail;

public class MI_Data {
	MI_Data_Detail mI_Data_Detail;

	public MI_Data(){
		mI_Data_Detail = new MI_Data_Detail();
	}

	public MI_Data_Detail getMI_Data_Detail() {
		return mI_Data_Detail;
	}

	public void setMI_Data_Detail(MI_Data_Detail mI_Data_Detail) {
		this.mI_Data_Detail = mI_Data_Detail;
	}
}
