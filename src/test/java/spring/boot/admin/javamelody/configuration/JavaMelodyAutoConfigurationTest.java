package spring.boot.admin.javamelody.configuration;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.servlet.ServletContext;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

public class JavaMelodyAutoConfigurationTest {

	private JavaMelodyAutoConfiguration javaMelodyConfiguration;

	@Before
	public void setUp() throws Exception {
		javaMelodyConfiguration = new JavaMelodyAutoConfiguration();
	}

	@Test
	public void shouldRunAsServer() {
		final JavaMelodyConfigurationProperties javaMelodyConfigurationProperties = new JavaMelodyConfigurationProperties();
		final ServletContext servletContext = Mockito.mock(ServletContext.class);
		final ServletRegistrationBean servletRegistrationBean = javaMelodyConfiguration
				.collectorServletBean(javaMelodyConfigurationProperties, servletContext);
		assertThat(servletRegistrationBean.getUrlMappings().size(), is(1));
		assertThat(servletRegistrationBean.getUrlMappings().iterator().next(), is("/javamelody"));
	}

}
