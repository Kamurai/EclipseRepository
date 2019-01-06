package information.dU34.Mes.DeaSet.Dea.Col.SubPro;

import information.dU34.Mes.DeaSet.Dea.Col.SubPro.Pro.Project_Detail;

public class Project {
	Project_Detail project_Detail;
	
	public Project(){
		project_Detail = new Project_Detail();		
	}

	public Project_Detail getProject_Detail() {
		return project_Detail;
	}

	public void setProject_Detail(Project_Detail project_Detail) {
		this.project_Detail = project_Detail;
	}
	
}
