package information.dU34.Mes.DocSet.Doc;

import information.dU34.Mes.DocSet.Doc.Sig.Execution;

public class Signatory {
	Execution execution;
	
	public Signatory(){
		execution = new Execution();
	}

	public Execution getExecution() {
		return execution;
	}

	public void setExecution(Execution execution) {
		this.execution = execution;
	}
}
