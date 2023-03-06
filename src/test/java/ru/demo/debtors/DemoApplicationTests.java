package ru.demo.debtors;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.demo.debtors.soap.bindings.DebtorCodeType;
import ru.demo.debtors.soap.bindings.GetDebtorByIdBankrupt;
import ru.demo.debtors.soap.bindings.GetDebtorByIdBankruptResponse;
import ru.demo.debtors.soap.bindings.SearchDebtorByCode;
import ru.demo.debtors.soap.bindings.SearchDebtorByCodeResponse;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void testWebService() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapConfig.class);
		SoapClient client = context.getBean(SoapClient.class);

		ItemController controllerToTest = context.getBean(ItemController.class);
		System.out.println("ItemController item " + controllerToTest.item("138895")); // http://127.0.0.1:8081/item/138895
		System.out.println("ItemController snils " + controllerToTest.snils("42603540444")); // http://127.0.0.1:8081/snils/01214167892

		int item = 138895;
		GetDebtorByIdBankrupt data = new GetDebtorByIdBankrupt();
		data.setIdBankrupt(item);

		GetDebtorByIdBankruptResponse response = client.getItemInfo(data);
		printResponse(response);

		SearchDebtorByCode request = new SearchDebtorByCode();
		request.setCodeType(DebtorCodeType.SNILS);
		request.setCodeValue("42603540444");
		SearchDebtorByCodeResponse searchDebtorByCode = client.searchDebtorByCode(request);
		System.out.println("SearchDebtorByCodeResponse " + searchDebtorByCode.toString());

		context.close();
	}

	public void printResponse(GetDebtorByIdBankruptResponse response) {
		System.out.println("GetDebtorByIdBankruptResponse [getDebtorByIdBankruptResult="
				+ response.getGetDebtorByIdBankruptResult() + "]");
	}

}
