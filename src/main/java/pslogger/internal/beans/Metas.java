package pslogger.internal.beans;

import java.util.List;

public class Metas {
		
	private List error;
	
	public Metas(List error) {
		this.error = error;
	}

	public List getError() {
		return error;
	}

	public void setError(List error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "metas [error=" + error + "]";
	}
	
	
}
