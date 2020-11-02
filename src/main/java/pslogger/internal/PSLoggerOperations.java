package pslogger.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import java.util.Arrays;
import java.util.List;

import org.mule.runtime.extension.api.annotation.param.MediaType;

import com.google.gson.Gson;

import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;

import pslogger.internal.beans.Record;
import pslogger.internal.beans.Metas;
import pslogger.internal.utils.Severity;


public class PSLoggerOperations {

	@MediaType(value = ANY, strict = false)
	public String Logger(
			@Config PSLoggerConfiguration configuration, 
			@Connection PSLoggerConnection connection,
			String host, 
			String source, 
			String eventName, 
			Severity severity, 
			String time, 
			String transactionId,
			String sourceSystem, 
			String targetSystem, 
			String statusCode,
			String type,
			String detail) {
			
		List metaList = Arrays.asList(new Metas(Arrays.asList("statusCode: " + statusCode, "type: " + type, "detail: " + detail)));
		String jmetas = new Gson().toJson(metaList);
		
		String message="";
		Record record=new Record(host, source, eventName, severity, time, transactionId, sourceSystem, targetSystem, jmetas);
		
		if (connection.connect()) {
			if (connection.insertRecord(record)) {
				connection.disconnect();
				message=record.toString();
				System.out.println(message);
			} else {
				message="There was a problem trying to save " + record.toString();
				System.out.println(message);
			}
		} else {
			message="There was a problem trying to connect to " + connection.toString();
			System.out.println(message);
		}
		return message;
	}
	
 
}
