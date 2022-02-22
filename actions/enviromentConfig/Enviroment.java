package enviromentConfig;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;


//@Sources({"file:~/.dev.properties"})

@Sources({"classpath:${env}.properties"})
public interface Enviroment extends Config {

	 String osName();
	
	
	
	@Key("app.url")
	String applicationUrl();

	@Key("app.username")
	String appUsername();

	@Key("app.password")
	String appPassword();

}
