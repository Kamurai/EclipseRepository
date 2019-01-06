package information.dU34.Mes;

import java.util.ArrayList;
import java.util.List;

import common.ArrayListOwner;
import information.dU34.Mes.DocSet.Document;

public class Document_Set implements ArrayListOwner {
	List<Document> documents;
	
	public Document_Set(){
		documents = new ArrayList<Document>();
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(ArrayList<Document> documents) {
		this.documents = documents;
	}
	
	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Document")){
			result = documents.get(documents.size()-1);
		}
		
		return result;
	}
}
