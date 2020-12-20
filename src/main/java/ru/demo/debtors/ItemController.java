package ru.demo.debtors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ru.demo.debtors.soap.bindings.GetDebtorByIdBankrupt;
import ru.demo.debtors.soap.bindings.GetDebtorByIdBankruptResponse;

@RestController
public class ItemController {
	@Autowired
	SoapClient soapClient;

	@GetMapping("/item/{id}")
	public GetDebtorByIdBankruptResponse item(@PathVariable String id) {
		System.out.println("GetDebtorByIdBankruptResponse item=" + id);
		int intId = 0;
		try {
			intId = Integer.parseInt(id);
		} catch (Exception e) {
			intId = 138895;
		}
		GetDebtorByIdBankrupt data = new GetDebtorByIdBankrupt();
		data.setIdBankrupt(intId);
		GetDebtorByIdBankruptResponse response = soapClient.getItemInfo(data);
		return response;
	}

}
