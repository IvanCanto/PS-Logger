package pslogger.internal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pslogger.internal.beans.Record;


public final class PSLoggerConnection {

	 private String host;
	 private String port;
	 private String user;
	 private String password;
	 private String database;
	 
	 private Connection connection;
	 private PreparedStatement preparedStmt;
	 
	public PSLoggerConnection(String host, String port, String user, String password, String database) {
		super();
		this.host = host;
		this.port = port;
		this.user = user;
		this.password = password;
		this.database = database;
	}
	
	
	public boolean connect() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);
				return true;
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			return false;
	}
	
	public boolean insertRecord(Record record){
		try {
			String query = "insert into record (host, source, event_name, severity, time, transaction_id, source_system, target_system, metas) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, record.getHost());
			preparedStmt.setString(2, record.getSource());
			preparedStmt.setString(3, record.getEventName());
			preparedStmt.setString(4, record.getSeverity().toString());
			preparedStmt.setString(5, record.getTime());
			preparedStmt.setString(6, record.getTransactionId());
			preparedStmt.setString(7, record.getSourceSystem());
			preparedStmt.setString(8, record.getTargetSystem());
			preparedStmt.setString(9, record.getMetas());
			preparedStmt.execute();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	public void disconnect(){
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}


	@Override
	public String toString() {
		return "PSLoggerConnection [host=" + host + ", port=" + port + ", user=" + user + ", database=" + database + "]";
	}
}
		