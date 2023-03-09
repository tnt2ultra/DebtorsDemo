package ru.demo.debtors;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.demo.debtors.soap.bindings.DebtorCodeType;
import ru.demo.debtors.soap.bindings.GetDebtorByIdBankrupt;
import ru.demo.debtors.soap.bindings.GetDebtorByIdBankruptResponse;
import ru.demo.debtors.soap.bindings.SearchDebtorByCode;
import ru.demo.debtors.soap.bindings.SearchDebtorByCodeResponse;

@SpringBootTest
class DemoApplicationTests {
	static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);

	@Test
	void testWebService() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapConfig.class);
		SoapClient client = context.getBean(SoapClient.class);

		ItemController controllerToTest = context.getBean(ItemController.class);
		log.info("ItemController item " + controllerToTest.item("138895")); // http://127.0.0.1:8081/item/138895
		log.info("ItemController snils " + controllerToTest.snils("42603540444")); // http://127.0.0.1:8081/snils/42603540444

		int item = 138895;
		GetDebtorByIdBankrupt data = new GetDebtorByIdBankrupt();
		data.setIdBankrupt(item);

		GetDebtorByIdBankruptResponse response = client.getItemInfo(data);
		printResponse(response);

		SearchDebtorByCode request = new SearchDebtorByCode();
		request.setCodeType(DebtorCodeType.SNILS);
		request.setCodeValue("42603540444");
		SearchDebtorByCodeResponse searchDebtorByCode = client.searchDebtorByCode(request);
		log.info("SearchDebtorByCodeResponse " + searchDebtorByCode.toString());

		context.close();
	}

	public void printResponse(GetDebtorByIdBankruptResponse response) {
		log.info("GetDebtorByIdBankruptResponse [getDebtorByIdBankruptResult="
				+ response.getGetDebtorByIdBankruptResult() + "]");
	}

}
