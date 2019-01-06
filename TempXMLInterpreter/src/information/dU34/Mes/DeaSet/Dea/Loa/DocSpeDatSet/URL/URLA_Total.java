package information.dU34.Mes.DeaSet.Dea.Loa.DocSpeDatSet.URL;

import java.math.BigDecimal;

import information.dU34.Mes.DeaSet.Dea.Loa.DocSpeDatSet.URL.URLTot.Extension;

public class URLA_Total {
	Extension extension;
	
	public URLA_Total(){
		extension = new Extension();
	}

	public Extension getExtension() {
		return extension;
	}

	public void setExtension(Extension extension) {
		this.extension = extension;
	}
}
