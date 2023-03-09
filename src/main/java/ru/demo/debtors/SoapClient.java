package ru.demo.debtors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import ru.demo.debtors.soap.bindings.GetArbitrManagerRegister;
import ru.demo.debtors.soap.bindings.GetArbitrManagerRegisterResponse;
import ru.demo.debtors.soap.bindings.GetDebtorByIdBankrupt;
import ru.demo.debtors.soap.bindings.GetDebtorByIdBankruptResponse;
import ru.demo.debtors.soap.bindings.GetDebtorMessagesContentForPeriodByIdBankrupt;
import ru.demo.debtors.soap.bindings.GetDebtorMessagesContentForPeriodByIdBankruptResponse;
import ru.demo.debtors.soap.bindings.GetDebtorReportsContentForPeriodByIdBankrupt;
import ru.demo.debtors.soap.bindings.GetDebtorReportsContentForPeriodByIdBankruptResponse;
import ru.demo.debtors.soap.bindings.GetSroRegister;
import ru.demo.debtors.soap.bindings.GetSroRegisterResponse;
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

	public GetDebtorMessagesContentForPeriodByIdBankruptResponse getDebtorMessagesContentForPeriodByIdBankrupt(GetDebtorMessagesContentForPeriodByIdBankrupt itemRequest) {
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		webServiceTemplate.setMessageSender(httpComponentsMessageSender);
		return (GetDebtorMessagesContentForPeriodByIdBankruptResponse) webServiceTemplate.marshalSendAndReceive(
				"https://services.fedresurs.ru/Bankruptcy/MessageServiceDemo/WebService.svc", itemRequest,
				 new SoapActionCallback("http://tempuri.org/IMessageService/GetDebtorMessagesContentForPeriodByIdBankrupt"));
	}

	public GetDebtorReportsContentForPeriodByIdBankruptResponse getDebtorReportsContentForPeriodByIdBankrupt(GetDebtorReportsContentForPeriodByIdBankrupt itemRequest) {
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		webServiceTemplate.setMessageSender(httpComponentsMessageSender);
		return (GetDebtorReportsContentForPeriodByIdBankruptResponse) webServiceTemplate.marshalSendAndReceive(
				"https://services.fedresurs.ru/Bankruptcy/MessageServiceDemo/WebService.svc", itemRequest,
				 new SoapActionCallback("http://tempuri.org/IMessageService/GetDebtorReportsContentForPeriodByIdBankrupt"));
	}

	public GetSroRegisterResponse getSroRegister(GetSroRegister itemRequest) {
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		webServiceTemplate.setMessageSender(httpComponentsMessageSender);
		return (GetSroRegisterResponse) webServiceTemplate.marshalSendAndReceive(
				"https://services.fedresurs.ru/Bankruptcy/MessageServiceDemo/WebService.svc", itemRequest,
				 new SoapActionCallback("http://tempuri.org/IMessageService/GetSroRegister"));
	}

	public GetArbitrManagerRegisterResponse getArbitrManagerRegister(GetArbitrManagerRegister itemRequest) {
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		webServiceTemplate.setMessageSender(httpComponentsMessageSender);
		return (GetArbitrManagerRegisterResponse) webServiceTemplate.marshalSendAndReceive(
				"https://services.fedresurs.ru/Bankruptcy/MessageServiceDemo/WebService.svc", itemRequest,
				 new SoapActionCallback("http://tempuri.org/IMessageService/GetArbitrManagerRegister"));
	}

}
