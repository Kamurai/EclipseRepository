package information.dU34.Mes.DeaSet.Dea.Par;

import information.dU34.Mes.DeaSet.Dea.Par.Lan.Extension;

public class Language {
	String languageCode;
	Extension extension;
	
	public Language(){
		extension = new Extension();
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public Extension getExtension() {
		return extension;
	}

	public void setExtension(Extension extension) {
		this.extension = extension;
	}
}
