package information.dU34.Mes.DocSet.Doc.Sig;

import information.dU34.Mes.DocSet.Doc.Sig.Exe.Execution_Detail;

public class Execution {
	Execution_Detail execution_Detail;
	
	public Execution(){
		execution_Detail = new Execution_Detail();
	}

	public Execution_Detail getExecution_Detail() {
		return execution_Detail;
	}

	public void setExecution_Detail(Execution_Detail execution_Detail) {
		this.execution_Detail = execution_Detail;
	}
}
