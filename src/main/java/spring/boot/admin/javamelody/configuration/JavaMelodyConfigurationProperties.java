package spring.boot.admin.javamelody.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for JavaMelody. <br/>
 * This class is used for binding the configuration values in "application.yml"
 * or "application.properties".
 */
@ConfigurationProperties(prefix = JavaMelodyConfigurationProperties.PREFIX)
public class JavaMelodyConfigurationProperties {
	/**
	 * Prefix of properties names.
	 */
	public static final String PREFIX = "javamelody";

	/**
	 * Map of initialization parameters to be passed to the JavaMelody collector
	 * server. The available parameters are: resolution-seconds, storage-directory,
	 * log, warning-threshold-millis, severe-threshold-millis, allowed-addr-pattern,
	 * authorized-users, graphite-address, influxdb-url, cloudwatch-namespace,
	 * datadog-api-key, admin-emails, mail-session, mail-periods. See
	 * https://github.com/javamelody/javamelody/wiki/UserGuideAdvanced#optional-centralization-server-setup
	 */
	private Map<String, String> initParameters = new HashMap<>();

	public Map<String, String> getInitParameters() {
		return initParameters;
	}

	public void setInitParameters(Map<String, String> initParameters) {
		this.initParameters = initParameters;
	}
}
