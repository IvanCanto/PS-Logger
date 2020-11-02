package pslogger.internal;

import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.param.Parameter;


@Operations(PSLoggerOperations.class)
@ConnectionProviders(PSLoggerConnectionProvider.class)
public class PSLoggerConfiguration {


}
