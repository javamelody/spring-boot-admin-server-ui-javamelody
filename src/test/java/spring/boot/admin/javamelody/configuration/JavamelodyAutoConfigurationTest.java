package spring.boot.admin.javamelody.configuration;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

public class JavamelodyAutoConfigurationTest {

	private JavamelodyAutoConfiguration javaMelodyConfiguration;

	@Before
	public void setUp() throws Exception {
		javaMelodyConfiguration = new JavamelodyAutoConfiguration();
	}

	@Test
	public void shouldRunAsServer() {
		final ServletRegistrationBean servletRegistrationBean = javaMelodyConfiguration.collectorServletBean();
		assertThat(servletRegistrationBean.getUrlMappings().size(), is(1));
		assertThat(servletRegistrationBean.getUrlMappings().iterator().next(), is("/javamelody"));
	}

}
