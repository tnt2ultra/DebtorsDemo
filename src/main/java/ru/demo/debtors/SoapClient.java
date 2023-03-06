package ru.demo.debtors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import ru.demo.debtors.soap.bindings.GetDebtorByIdBankrupt;
import ru.demo.debtors.soap.bindings.GetDebtorByIdBankruptResponse;
import ru.demo.debtors.soap.bindings.SearchDebtorByCode;
import ru.demo.debtors.soap.bindings.SearchDebtorByCodeResponse;

@Service
@Component
public class SoapClient {

	@Autowired
	private Jaxb2Marshaller jaxb2Marshaller;

	@Autowired
	private HttpComponentsMessageSender httpComponentsMessageSender;

	public GetDebtorByIdBankruptResponse getItemInfo(GetDebtorByIdBankrupt itemRequest) {
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		webServiceTemplate.setMessageSender(httpComponentsMessageSender);
		return (GetDebtorByIdBankruptResponse) webServiceTemplate.marshalSendAndReceive(
				"https://services.fedresurs.ru/Bankruptcy/MessageServiceDemo/WebService.svc", itemRequest,
				 new SoapActionCallback("http://tempuri.org/IMessageService/GetDebtorByIdBankrupt"));
	}

	public SearchDebtorByCodeResponse searchDebtorByCode(SearchDebtorByCode itemRequest) {
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		webServiceTemplate.setMessageSender(httpComponentsMessageSender);
		return (SearchDebtorByCodeResponse) webServiceTemplate.marshalSendAndReceive(
				"https://services.fedresurs.ru/Bankruptcy/MessageServiceDemo/WebService.svc", itemRequest,
				 new SoapActionCallback("http://tempuri.org/IMessageService/SearchDebtorByCode"));
	}

}
