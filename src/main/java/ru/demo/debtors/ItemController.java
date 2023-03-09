package ru.demo.debtors;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ru.demo.debtors.soap.bindings.DebtorCodeType;
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

@RestController
public class ItemController {
	static final Logger log = LoggerFactory.getLogger(ItemController.class);
	
	@Autowired
	SoapClient soapClient;

	@GetMapping("/item/{id}")
	public GetDebtorByIdBankruptResponse item(@PathVariable String id) {
		log.info("GetDebtorByIdBankruptResponse item=" + id);
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

	@GetMapping("/snils/{snils}")
	public SearchDebtorByCodeResponse snils(@PathVariable String snils) {
		log.info("SearchDebtorByCode snils=" + snils);
		SearchDebtorByCode request = new SearchDebtorByCode();
		request.setCodeType(DebtorCodeType.SNILS);
		request.setCodeValue(snils);
		SearchDebtorByCodeResponse searchDebtorByCode = soapClient.searchDebtorByCode(request);
		return searchDebtorByCode;
	}
	
	/* GetDebtorMessagesContentForPeriodByIdBankrupt
GetDebtorReportsContentForPeriodByIdBankrupt
GetSroRegister
GetArbitrManagerRegister */

	@GetMapping("/content/{id}/{startDate}")
	public GetDebtorMessagesContentForPeriodByIdBankruptResponse content(@PathVariable Integer id, @PathVariable String startDate) throws DatatypeConfigurationException {
		log.info("GetDebtorMessagesContentForPeriodByIdBankrupt IdBankrupt=" + id + ", StartDate=" + startDate);
		XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(startDate);
		log.info("date=" + date);
		GetDebtorMessagesContentForPeriodByIdBankrupt request = new GetDebtorMessagesContentForPeriodByIdBankrupt();
		request.setIdBankrupt(id);
		request.setStartDate(date);
		log.info("request=" + request);
		GetDebtorMessagesContentForPeriodByIdBankruptResponse response = soapClient.getDebtorMessagesContentForPeriodByIdBankrupt(request);
		log.info("GetDebtorMessagesContentForPeriodByIdBankruptResponse=" + response);
		return response;
	}
	
	@GetMapping("/report/{id}/{startDate}")
	public GetDebtorReportsContentForPeriodByIdBankruptResponse report(@PathVariable Integer id, @PathVariable String startDate) throws DatatypeConfigurationException {
		log.info("GetDebtorReportsContentForPeriodByIdBankrupt IdBankrupt=" + id + ", StartDate=" + startDate);
		XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(startDate);
		log.info("date=" + date);
		GetDebtorReportsContentForPeriodByIdBankrupt request = new GetDebtorReportsContentForPeriodByIdBankrupt();
		request.setIdBankrupt(id);
		request.setStartDate(date);
		log.info("request=" + request);
		GetDebtorReportsContentForPeriodByIdBankruptResponse response = soapClient.getDebtorReportsContentForPeriodByIdBankrupt(request);
		log.info("GetDebtorReportsContentForPeriodByIdBankruptResponse=" + response);
		return response;
	}
	
	@GetMapping("/register/{startDate}")
	public GetSroRegisterResponse register(@PathVariable String startDate) throws DatatypeConfigurationException {
		log.info("GetSroRegister Date=" + startDate);
		XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(startDate);
		log.info("date=" + date);
		GetSroRegister request = new GetSroRegister();
		request.setDate(date);
		log.info("request=" + request);
		GetSroRegisterResponse response = soapClient.getSroRegister(request);
		log.info("GetSroRegisterResponse=" + response);
		return response;
	}
	
	@GetMapping("/arbitr/{startDate}")
	public GetArbitrManagerRegisterResponse arbitr(@PathVariable String startDate) throws DatatypeConfigurationException {
		log.info("GetArbitrManagerRegister Date=" + startDate);
		XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(startDate);
		log.info("date=" + date);
		GetArbitrManagerRegister request = new GetArbitrManagerRegister();
		request.setDate(date);
		log.info("request=" + request);
		GetArbitrManagerRegisterResponse response = soapClient.getArbitrManagerRegister(request);
		log.info("GetArbitrManagerRegisterResponse=" + response);
		return response;
	}
	
}
