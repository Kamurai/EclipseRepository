package information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor;

import java.util.ArrayList;
import java.util.List;

import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Dec.Declaration_Detail;
import information.dU34.Mes.DeaSet.Dea.Par.Rol.Bor.Dec.Declaration_Explanation;

public class Declaration {
	Declaration_Detail declaration_Detail;
	List<Declaration_Explanation> declaration_Explanations;
	
	public Declaration(){
		declaration_Detail = new Declaration_Detail();
		declaration_Explanations = new ArrayList<Declaration_Explanation>();
	}

	public Declaration_Detail getDeclaration_Detail() {
		return declaration_Detail;
	}

	public void setDeclaration_Detail(Declaration_Detail declaration_Detail) {
		this.declaration_Detail = declaration_Detail;
	}

	public List<Declaration_Explanation> getDeclaration_Explanations() {
		return declaration_Explanations;
	}

	public void setDeclaration_Explanations(List<Declaration_Explanation> declaration_Explanations) {
		this.declaration_Explanations = declaration_Explanations;
	}
	
	public Object getLast(String objectType){
		Object result = null;
		
		if(objectType.equals("Declaration_Explanation")){
			result = declaration_Explanations.get(declaration_Explanations.size()-1);
		}
		
		return result;
	}
}
