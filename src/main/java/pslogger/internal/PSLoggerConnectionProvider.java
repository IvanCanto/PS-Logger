package pslogger.internal;

import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.api.connection.ConnectionValidationResult;
import org.mule.runtime.api.connection.PoolingConnectionProvider;
import org.mule.runtime.api.connection.ConnectionProvider;
import org.mule.runtime.api.connection.CachedConnectionProvider;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PSLoggerConnectionProvider implements PoolingConnectionProvider<PSLoggerConnection> {

  private final Logger LOGGER = LoggerFactory.getLogger(PSLoggerConnectionProvider.class);


	@DisplayName("MySQL Host")
	@Parameter
	private String host;

	@DisplayName("MySQL Port")
	@Parameter
	private String port;

	@DisplayName("MySQL Username")
	@Parameter
	private String user;

	@DisplayName("MySQL Password")
	@Parameter
	private String password;

	@DisplayName("MySQL Database Name")
	@Parameter
	private String database;

  @Override
  public PSLoggerConnection connect() throws ConnectionException {
    return new PSLoggerConnection(host, port, user, password, database 	);
  }

  @Override
  public void disconnect(PSLoggerConnection connection) {
   
  }

  @Override
  public ConnectionValidationResult validate(PSLoggerConnection connection) {
    return ConnectionValidationResult.success();
  }
}
