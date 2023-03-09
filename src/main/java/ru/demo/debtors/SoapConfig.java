package ru.demo.debtors;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

@Configuration
@ComponentScan(basePackages = { "ru.demo.debtors" }, basePackageClasses = SoapClient.class)
public class SoapConfig {
	static final Logger log = LoggerFactory.getLogger(SoapConfig.class);

	@Bean
	public HttpComponentsMessageSender defaultHttpComponentsMessageSender() {
		log.info("defaultHttpComponentsMessageSender started");
		HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();
		messageSender.setAuthScope(AuthScope.ANY);
		messageSender.setCredentials(new UsernamePasswordCredentials("demowebuser", "Ax!761BN"));
		return messageSender;
	}

	@Bean
	public Jaxb2Marshaller marshaller() {
		log.info("marshaller started");
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setPackagesToScan("ru.demo.debtors.soap.bindings");
		return jaxb2Marshaller;
	}

}
