package ru.demo.debtors;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.demo.debtors.soap.bindings.GetDebtorByIdBankrupt;
import ru.demo.debtors.soap.bindings.GetDebtorByIdBankruptResponse;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void testWebService() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapConfig.class);
		SoapClient client = context.getBean(SoapClient.class);
		
		int item = 138895;
		GetDebtorByIdBankrupt data = new GetDebtorByIdBankrupt();
		data.setIdBankrupt(item);
		
		GetDebtorByIdBankruptResponse response = client.getItemInfo(data);
		printResponse(response);
		context.close();
	}	
	
	public void printResponse(GetDebtorByIdBankruptResponse response) {
		System.out.println("GetDebtorByIdBankruptResponse [getDebtorByIdBankruptResult="
				+ response.getGetDebtorByIdBankruptResult() + "]");
	}
	
}
