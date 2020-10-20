package pslogger.internal;

import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;



@Xml(prefix = "PS-Logger")
@Extension(name = "PS-Logger")
@Configurations(PSLoggerConfiguration.class)
public class PSLoggerExtension {

}
