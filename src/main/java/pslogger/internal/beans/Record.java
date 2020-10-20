package pslogger.internal.beans;

import pslogger.internal.utils.Severity;;

public class Record {
	
	private String host;
	private String source;
	private String eventName;
	private Severity severity;
	private String time;
	private String transactionId;
	private String sourceSystem;
	private String targetSystem;
	private String metas;
	
	
	public Record(String host, String source, String eventName, Severity severity, String time, String transactionId,
			String sourceSystem, String targetSystem, String metas) {
		super();
		this.host = host;
		this.source = source;
		this.eventName = eventName;
		this.severity = severity;
		this.time = time;
		this.transactionId = transactionId;
		this.sourceSystem = sourceSystem;
		this.targetSystem = targetSystem;
		this.metas = metas;
	}
	
	
	public String getHost() {
		return host;
	}
	public String getSource() {
		return source;
	}
	public String getEventName() {
		return eventName;
	}
	public Severity getSeverity() {
		return severity;
	}
	public String getTime() {
		return time;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public String getSourceSystem() {
		return sourceSystem;
	}
	public String getTargetSystem() {
		return targetSystem;
	}
	public String getMetas() {
		return metas;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public void setSeverity(Severity severity) {
		this.severity = severity;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	public void setTargetSystem(String targetSystem) {
		this.targetSystem = targetSystem;
	}
	public void setMetas(String metas) {
		this.metas = metas;
	}


	@Override
	public String toString() {
		return "Record [host=" + host + ", source=" + source + ", eventName=" + eventName + ", severity=" + severity
				+ ", time=" + time + ", transactionId=" + transactionId + ", sourceSystem=" + sourceSystem
				+ ", targetSystem=" + targetSystem + ", metas=" + metas + "]";
	}
	
	
}
