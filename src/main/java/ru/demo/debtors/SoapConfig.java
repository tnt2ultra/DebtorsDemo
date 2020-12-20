package ru.demo.debtors;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

@Configuration
@ComponentScan(basePackages = { "ru.demo.debtors" }, basePackageClasses = SoapClient.class)
public class SoapConfig {

	@Bean
	public HttpComponentsMessageSender defaultHttpComponentsMessageSender() {
		System.out.println("defaultHttpComponentsMessageSender started");
		HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();
		messageSender.setAuthScope(AuthScope.ANY);
		messageSender.setCredentials(new UsernamePasswordCredentials("demowebuser", "Ax!761BN"));
		return messageSender;
	}

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setPackagesToScan("ru.demo.debtors.soap.bindings");
		return jaxb2Marshaller;
	}

}
