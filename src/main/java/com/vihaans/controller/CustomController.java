package com.vihaans.controller;
import java.io.ByteArrayInputStream;
import java.awt.image.BufferedImage;
//import java.awt.Image;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.io.ByteArrayOutputStream;
import org.apache.commons.io.FileUtils;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfCopy;

import java.net.URL;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.Image;
import com.google.gson.reflect.TypeToken;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.json.*;
import com.vihaans.core.dao.service.*;
import com.vihaans.core.config.FileConfig;
import com.vihaans.core.util.ResponseData;
import com.vihaans.core.dao.model.*;
import com.vihaans.core.dao.model.dto.UserDto;

@RestController
public class CustomController {
	
	@Autowired
	FileConfig _fileConfig;
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	FilingTaxYearService filingTaxYearService;
	
	@Autowired
	IndustryMemberService memberService;
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	StateService stateService;
	
	@Autowired
	FormDetailsService formDetailsService;
	
	@Autowired
	FormListService formListService;
	
	@Autowired
	IndustryAddressService industryAddressService;
	
	@Autowired
	FormColumnMappingService formColMapService;
	
	@Autowired
	TaxRatesService taxRatesService;
	
	@Autowired
	TransmissionHeaderService transmissionHeaderService;
	
	@Autowired
	TtbPaymentService ttbPaymentService;
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET , produces = "application/json")
	public List<Employee> getEmployee() {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String companyCode = ((UserDetail)principal).getCompanyCode();
		List<Employee> empl = empService.getEmployee(companyCode);
		return empl;
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE , produces = "application/json")
	public Employee deleteEmployee(@PathVariable("id") String id) {
		Employee emp = empService.getEmployeeById(Long.parseLong(id+""));
		empService.delete(Long.parseLong(id+""));
		return emp;
	}

	@RequestMapping(value = "/employees", method = RequestMethod.POST , produces = "application/json")
	public Employee createEmployee(@RequestBody Employee employee) {
		empService.add(employee);
		System.out.println(employee);
		return employee;
	}
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET , produces = "application/json")
	public User getUserByUserId(@PathVariable("userId") String userId) {
		User user = userService.getUser(userId);
		return user;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST , produces = "application/json")
	public User registerUser(@RequestBody UserDto userdto) {
		User userChk = userService.getUser(userdto.getUserId());
		User user = new User();
		if(userChk == null) 
		{	
			user.setUserId(userdto.getUserId());
			user.setActive(true);
			user.setEmail(userdto.getEmail());
			user.setFirstName(userdto.getFirstName());
			user.setLastName(userdto.getLastName());
			user.setPassword(userdto.getPassword());
			String companyCode = UUID.randomUUID().toString();
			user.setCompanyCode(companyCode);
			user.setUserRole(3l);
			userService.add(user);
			System.out.println(user);
		}
		return user;
	}
	
	@RequestMapping(value = "/dashBoardData", method = RequestMethod.GET , produces = "application/json")
	public List<Object> getDashBoardMember() {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String companyCode = ((UserDetail)principal).getCompanyCode();
		
		List<Object> returnObj = new ArrayList<Object>();
		HashMap<String,Object> responseMap = new HashMap<String,Object>();
		
	    List<IndustryMember> industryMember = memberService.getIndustryMember(companyCode);
		responseMap.put("businessListData", industryMember);
		
		List<TransmissionHeader> transmissionHeader = transmissionHeaderService.getAllTransmissionHeader(companyCode);
		responseMap.put("submissionListData", transmissionHeader);
		
		//List<FormDetails> submittedForms = formDetailsService.findByStatus("S");
		//responseMap.put("submittedForms", submittedForms);
		
		//List<FormDetails> pendingForms = formDetailsService.findByStatus("P");
		//responseMap.put("pendingForms", pendingForms);
		
		List<FormDetails> listForms = formDetailsService.getFormDetails(companyCode);
		
		List<Object> sLine = new ArrayList<Object>();
		List<Object> pLine = new ArrayList<Object>();
		
		for(FormDetails formDetails:listForms)
		{
			if(formDetails.getStatus().equalsIgnoreCase("S"))
			{
				sLine.add(formDetails);
			}
			else if(formDetails.getStatus().equalsIgnoreCase("P"))
			{
				pLine.add(formDetails);
			}
		}
		
		responseMap.put("submittedForms", sLine);
		responseMap.put("pendingForms", pLine);
		
		returnObj.add(responseMap);
		
		return returnObj;
	}
	
	@RequestMapping(value = "/industryMemDet", method = RequestMethod.GET , produces = "application/json")
	public List<Object> getAllIndustryMember() 
	{
		List<Object> FinalReturnList = new ArrayList<Object>();
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String companyCode = ((UserDetail)principal).getCompanyCode();
		List<IndustryMember> industryMemberList = memberService.getIndustryMember(companyCode);
		
		for(IndustryMember industryMember:industryMemberList)
		{
			ResponseData CreateRow = new ResponseData();
			CreateRow.setData(industryMember);
			List<Object> ACALine = new ArrayList<Object>();
			List<IndustryAddress> industryAddressList = industryAddressService.getIndustryAddress(industryMember.getId());
			for(IndustryAddress industryAddress:industryAddressList)
			{
				ACALine.add(industryAddress);
			}
			CreateRow.setChildList(ACALine);
			FinalReturnList.add(CreateRow);
		}
		
		return FinalReturnList;
	}
	
	@RequestMapping(value = "/getIndustryMembers", method = RequestMethod.GET , produces = "application/json")
	public List<IndustryMember> getIndustryMembers() 
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String companyCode = ((UserDetail)principal).getCompanyCode();
		List<IndustryMember> industryMemberList = memberService.getIndustryMember(companyCode);
		
		return industryMemberList;
	}
	
	@RequestMapping(value = "/industryMemDet/{id}", method = RequestMethod.GET , produces = "application/json")
	public List<Object> getIndustryMember(@PathVariable("id") String id) 
	{
		List<Object> ReturnList = new ArrayList<Object>();
		
		IndustryMember industryMember = memberService.getIndustryMemberById(Long.parseLong(id+""));
		ReturnList.add(industryMember);
		
		List<IndustryAddress> industryAddress = industryAddressService.getIndustryAddress(Long.parseLong(id+""));
		ReturnList.add(industryAddress);
		
		return ReturnList;
	}
	
	@RequestMapping(value = "/getIndustryMemberById/{id}", method = RequestMethod.GET , produces = "application/json")
	public List<Object> getIndustryMemberById(@PathVariable("id") String id) 
	{
		List<Object> ReturnList = new ArrayList<Object>();
		
		IndustryMember industryMember = memberService.getIndustryMemberById(Long.parseLong(id+""));
		ReturnList.add(industryMember);
		
		List<FormDetails> pendingForms = formDetailsService.getFormDetailsByMember(Long.parseLong(id+""));
		ReturnList.add(pendingForms);
		
		return ReturnList;
	}
	
	@RequestMapping(value = "/industryMember/{id}", method = RequestMethod.GET , produces = "application/json")
	public List<Object> getIndustryMemberView(@PathVariable("id") String id) 
	{
		List<Object> ReturnList = new ArrayList<Object>();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		IndustryMember industryMember = memberService.getIndustryMemberById(Long.parseLong(id+""));
		ReturnList.add(industryMember);
		
		List<Object> FinalReturnList = new ArrayList<Object>();
		
		List<IndustryAddress> industryAddressList = industryAddressService.getIndustryAddress(Long.parseLong(id+""));
		for(IndustryAddress industryAddress:industryAddressList)
		{
			ResponseData CreateRow = new ResponseData();
			CreateRow.setData(industryAddress);
			List<Object> ACALine = new ArrayList<Object>();
			List<FormDetails> formDetailsList = formDetailsService.getFormDetailsByAddress(industryAddress.getId());
			for(FormDetails formDetails:formDetailsList)
			{
				if(formDetails.getTaxYear().equalsIgnoreCase(Integer.toString(year)) && formDetails.getStatus().equalsIgnoreCase("S"))
				{
					ACALine.add(formDetails);
				}
			}
			CreateRow.setChildList(ACALine);
			FinalReturnList.add(CreateRow);
		}
		
		ReturnList.add(FinalReturnList);
		
		List<FilingTaxYear> taxYearList = filingTaxYearService.getFilingTaxYearList();
		ReturnList.add(taxYearList);
		
		return ReturnList;
	}
	
	@RequestMapping(value = "/getListByYear/{id}", method = RequestMethod.POST , produces = "application/json")
	public List<FormDetails> getListByYear(@PathVariable("id") String id, @RequestBody String year) 
	{
		IndustryAddress industryAddress = industryAddressService.getIndustryAddressById(Long.parseLong(id+""));
		List<FormDetails> ACALine = new ArrayList<FormDetails>();
		List<FormDetails> formDetailsList = formDetailsService.getFormDetailsByAddress(industryAddress.getId());
		for(FormDetails formDetails:formDetailsList)
		{
			if(formDetails.getTaxYear().equalsIgnoreCase(year) && formDetails.getStatus().equalsIgnoreCase("S"))
			{
					ACALine.add(formDetails);
			}
		}
		
		return ACALine;
	}

	@RequestMapping(value = "/industryMemDet/{id}", method = RequestMethod.DELETE , produces = "application/json")
	public String deleteIndustryMember(@PathVariable("id") String id) 
	{
		String msg = "";
		
		List<FormDetails> form = formDetailsService.getFormDetailsByMember(Long.parseLong(id+""));
		if(form.size()==0)
		{
			memberService.delete(Long.parseLong(id+""));
			msg = "Business deleted successfully.";
		}
		else
		{
			msg = "Form has been filed, so can not delete this record.";
		}
		
		return msg;
	}

	@RequestMapping(value = "/industryMemDet", method = RequestMethod.POST , produces = "application/json")
	public IndustryMember createIndustryMember(@RequestBody IndustryMember industryMember) 
	{
		memberService.add(industryMember);
		System.out.println(industryMember);
		return industryMember;
	}
	
	@RequestMapping(value = "/industryMemDet", method = RequestMethod.PUT , produces = "application/json")
	public IndustryMember updateIndustryMember(@RequestBody IndustryMember industryMember) 
	{
		memberService.edit(industryMember);
		System.out.println(industryMember);
		return industryMember;
	}
	
	@RequestMapping(value = "/countrys", method = RequestMethod.GET , produces = "application/json")
	public List<Country> getAllCountry() 
	{
		List<Country> country = countryService.getCountryState();
		return country;
	}
	
	@RequestMapping(value = "/states", method = RequestMethod.POST , produces = "application/json")
	public List<State> getStateByCountryCode(@RequestBody String countryCode) 
	{
		List<State> state = stateService.getStateByCountryCode(countryCode);
		return state;
	}
	
	@RequestMapping(value = "/formList/{id}", method = RequestMethod.GET , produces = "application/json")
	public List<Object> getAllFormList(@PathVariable("id") String id) 
	{
		List<Object> returnObj = new ArrayList<Object>();
		
		List<FormList> formList = formListService.getFormList();
		returnObj.add(formList);
		
		List<FilingTaxYear> taxYearList = filingTaxYearService.getFilingTaxYearList();
		returnObj.add(taxYearList);
		
		IndustryAddress industryAddress = industryAddressService.getIndustryAddressById(Long.parseLong(id+""));
		returnObj.add(industryAddress);
		
		IndustryMember industryMember = memberService.getIndustryMemberById(industryAddress.getIndustryId());
		returnObj.add(industryMember);
		
		return returnObj;
	}
	
	@RequestMapping(value = "/formDetails", method = RequestMethod.POST , produces = "application/json")
	public FormDetails createFormDetails(@RequestBody Object obj) 
	{
		boolean valid = false;
		Gson gson = new Gson(); String json = gson.toJson(obj); 
		JSONObject jsonObject= new JSONObject(json); 
		Map<String,String> map = new HashMap<String,String>();
		Iterator iter = jsonObject.keys();
		map = new Gson().fromJson(jsonObject.toString(), new TypeToken<HashMap<String, String>>(){}.getType());
		
		String formId = map.get("formId").toString(); 
		Long formListId = Long.valueOf(formId);
		
		String industryMemberId = map.get("industryMemberId").toString(); 
		Long memberId = Long.valueOf(industryMemberId);
		
		String industryAddressId = map.get("industryAddressId").toString(); 
		Long addressId = Long.valueOf(industryAddressId);
		
		String taxYear = map.get("taxYear").toString(); 
		
		FormDetails formDetails = new FormDetails();
		
		formDetails.setFormId(formListId);
		formDetails.setUserId(1l);
		formDetails.setIndustryMemberId(memberId);
		formDetails.setIndustryAddressId(addressId);
		formDetails.setCurrentPosition(1l);
		formDetails.setHighestPosition(1l);
		formDetails.setStatus("P");
		formDetails.setTaxYear(taxYear);
		
        formDetailsService.add(formDetails);
		return formDetails;
	}
	
	@RequestMapping(value = "/formDetails/{id}", method = RequestMethod.GET , produces = "application/json")
	public List<Object> getFormDetails(@PathVariable("id") String id) 
	{
		List<Object> returnObj = new ArrayList<Object>();
		HashMap<String,Object> res = new HashMap<String,Object>();
		
		FormDetails formDetails = formDetailsService.getFormDetailsById(Long.parseLong(id+""));
		returnObj.add(formDetails);
		
		IndustryMember industryMember = memberService.getIndustryMemberById(formDetails.getIndustryMemberId());
		returnObj.add(industryMember);
		
		IndustryAddress industryAddress = industryAddressService.getIndustryAddressById(formDetails.getIndustryAddressId());
		returnObj.add(industryAddress);
		
		List<FormColumnMapping> formColumnList = formColMapService.getFormColumnMapping(formDetails.getFormId());
		
		for(FormColumnMapping formColumnMapping : formColumnList)
		{
			Object val = formDetails.getField(formColumnMapping.getFlexColumnName());
			if(val == null)
			{
				res.put(formColumnMapping.getColumnName(), "");
			}
			else
			{
				if(val.toString().equals("Y"))
				{
					res.put(formColumnMapping.getColumnName(), true);
				}
				else if(val.toString().equals("N"))
				{
					res.put(formColumnMapping.getColumnName(), false);
				}
				else
				{
					res.put(formColumnMapping.getColumnName(), val);
				}
			}
		}
		
		returnObj.add(res);
		
		return returnObj;
	}
	
	@RequestMapping(value = "/formDetails", method = RequestMethod.PUT , produces = "application/json")
	public Object updateFormDetails(@RequestBody Object obj) 
	{
		boolean valid = false;
		Gson gson = new Gson(); String json = gson.toJson(obj); 
		JSONObject jsonObject= new JSONObject(json); 
		Map<String,String> map = new HashMap<String,String>();
		map = new Gson().fromJson(jsonObject.toString(), new TypeToken<HashMap<String, String>>(){}.getType());
		
		String currentPosition = map.get("currentPosition").toString(); 
		Long currentPos = Long.valueOf(currentPosition);
		
		String callType = map.get("callType").toString(); 
		 
		String id = map.get("id").toString(); 
		Long formId = Long.valueOf(id);
		
		FormDetails formDetails = formDetailsService.getFormDetailsById(formId);
		
		String formlstId = map.get("formId").toString(); 
		Long formListId = Long.valueOf(formlstId);
		
		String paymentFlag = "";
		
		List<FormColumnMapping> formColumnList = formColMapService.getFormColumnMapping(formListId);
		
		for(FormColumnMapping formColumnObj: formColumnList)
		{
			Object val= map.get(formColumnObj.getColumnName()) != null ? map.get(formColumnObj.getColumnName()) : "";
			
			if(!val.equals("") && formColumnObj.getFlexColumnName().contains("attribute"))
			{
  				if(val.toString().equalsIgnoreCase("true"))
  				{
  					val = "Y";
  				}
  				else if(val.toString().equalsIgnoreCase("false"))
  				{
  					val = "N";
  				}
  				
  				if(val.toString().equalsIgnoreCase("PP") || val.toString().equalsIgnoreCase("P"))
  				{
  					paymentFlag = val.toString();
  				}
  	
  				formDetails.setField(formColumnObj.getFlexColumnName(), val);
  				valid = true;
  			}
			else if(val.equals("") && formColumnObj.getFlexColumnName().contains("attribute"))
			{
  				formDetails.setField(formColumnObj.getFlexColumnName(), val);
  			}
		}
		
		if(!valid) {
			return formDetails;
		}
		else
		{
			
			if(currentPos == 6)
			{
				if(formDetails.getPaymentId()== null) 
				{
					String formOFPayment = map.get("formOFPayment").toString();
					TtbPayment paymentObj = new TtbPayment();
					paymentObj.setPayMode(formOFPayment);
					
					if(formOFPayment.equalsIgnoreCase("C"))
					{
						String consentCheck = map.get("consentCheck").toString();
						
						if(consentCheck.toString().equalsIgnoreCase("true"))
		  				{
							consentCheck = "Y";
		  				}
		  				else if(consentCheck.toString().equalsIgnoreCase("false"))
		  				{
		  					consentCheck = "N";
		  				}
						paymentObj.setConsentCheck(consentCheck);
					}
					else if(formOFPayment.equalsIgnoreCase("M"))
					{
						String consentMo = map.get("consentMo").toString();

						if(consentMo.toString().equalsIgnoreCase("true"))
		  				{
							consentMo = "Y";
		  				}
		  				else if(consentMo.toString().equalsIgnoreCase("false"))
		  				{
		  					consentMo = "N";
		  				}
						paymentObj.setConsentMo(consentMo);
						
					}
					else if(formOFPayment.equalsIgnoreCase("E"))
					{
						String accountType = map.get("accountType").toString();
						String accountNo = map.get("accountNo").toString();
						String routingNo = map.get("routingNo").toString();
						String taxpayerPhone = map.get("taxpayerPhone").toString();
						String consentEFT = map.get("consentEFT").toString();
						if(consentEFT.toString().equalsIgnoreCase("true"))
		  				{
							consentEFT = "Y";
		  				}
		  				else if(consentEFT.toString().equalsIgnoreCase("false"))
		  				{
		  					consentEFT = "N";
		  				}
						
						paymentObj.setAccountType(accountType);
						paymentObj.setConsentEFT(consentEFT);
						paymentObj.setAccountNo(accountNo);
						paymentObj.setTaxpayerPhone(taxpayerPhone);
						paymentObj.setRoutingNo(routingNo);
					}
					else if(formOFPayment.equalsIgnoreCase("O"))
					{
						String other = map.get("other").toString();
						
						paymentObj.setOther(other);
					}
					ttbPaymentService.add(paymentObj);
					
					formDetails.setPaymentId(paymentObj.getId());
				}
				else {
					TtbPayment ttbPaymentObj = ttbPaymentService.getTtbPaymentById(formDetails.getPaymentId());
					String formOFPayment = map.get("formOFPayment").toString();
					ttbPaymentObj.setPayMode(formOFPayment);
					
					if(formOFPayment.equalsIgnoreCase("C"))
					{
						String consentCheck = map.get("consentCheck").toString();
						
						if(consentCheck.toString().equalsIgnoreCase("true"))
		  				{
							consentCheck = "Y";
		  				}
		  				else if(consentCheck.toString().equalsIgnoreCase("false"))
		  				{
		  					consentCheck = "N";
		  				}
						if(consentCheck.toString().equalsIgnoreCase("Y")) {
							ttbPaymentObj.setConsentCheck(consentCheck);
							
						}
						ttbPaymentObj.setAccountNo(null);
						ttbPaymentObj.setAccountType(null);
						ttbPaymentObj.setConsentEFT(null);
						ttbPaymentObj.setTaxpayerPhone(null);
						ttbPaymentObj.setRoutingNo(null);
						ttbPaymentObj.setConsentMo(null);
						ttbPaymentObj.setOther(null);
					}
					else if(formOFPayment.equalsIgnoreCase("M"))
					{
						String consentMo = map.get("consentMo").toString();

						if(consentMo.toString().equalsIgnoreCase("true"))
		  				{
							consentMo = "Y";
		  				}
		  				else if(consentMo.toString().equalsIgnoreCase("false"))
		  				{
		  					consentMo = "N";
		  				}
						if(consentMo.toString().equalsIgnoreCase("Y")) {
							ttbPaymentObj.setConsentMo(consentMo);
							
						}
						ttbPaymentObj.setAccountNo(null);
						ttbPaymentObj.setAccountType(null);
						ttbPaymentObj.setConsentEFT(null);
						ttbPaymentObj.setTaxpayerPhone(null);
						ttbPaymentObj.setRoutingNo(null);
						ttbPaymentObj.setConsentCheck(null);
						ttbPaymentObj.setOther(null);
					}
					else if(formOFPayment.equalsIgnoreCase("E"))
					{
						
							String accountType = map.get("accountType").toString();
							String accountNo = map.get("accountNo").toString();
							String routingNo = map.get("routingNo").toString();
							String taxpayerPhone = map.get("taxpayerPhone").toString();
							String consentEFT = map.get("consentEFT").toString();
							if(consentEFT.toString().equalsIgnoreCase("true"))
			  				{
								consentEFT = "Y";
			  				}
			  				else if(consentEFT.toString().equalsIgnoreCase("false"))
			  				{
			  					consentEFT = "N";
			  				}
							
							if(consentEFT.toString().equalsIgnoreCase("Y")) {
								ttbPaymentObj.setAccountType(accountType);
								ttbPaymentObj.setConsentEFT(consentEFT);
								ttbPaymentObj.setAccountNo(accountNo);
								ttbPaymentObj.setTaxpayerPhone(taxpayerPhone);
								ttbPaymentObj.setRoutingNo(routingNo);
							}
							ttbPaymentObj.setConsentCheck(null);
							ttbPaymentObj.setConsentMo(null);
							ttbPaymentObj.setOther(null);
						
					}
					else if(formOFPayment.equalsIgnoreCase("O"))
					{
						
							String other = map.get("other").toString();
							
							ttbPaymentObj.setOther(other);
							
							ttbPaymentObj.setAccountNo(null);
							ttbPaymentObj.setAccountType(null);
							ttbPaymentObj.setConsentEFT(null);
							ttbPaymentObj.setTaxpayerPhone(null);
							ttbPaymentObj.setRoutingNo(null);
							ttbPaymentObj.setConsentCheck(null);
							ttbPaymentObj.setConsentMo(null);
						
					}
                      ttbPaymentService.update(ttbPaymentObj);
					
					formDetails.setPaymentId(ttbPaymentObj.getId());
					
				}
				
			}
			
			if(paymentFlag.equalsIgnoreCase("PP"))
			{
				formDetails.setAttribute76(null);
				formDetails.setAttribute77(null);
			}
			else if(paymentFlag.equalsIgnoreCase("P"))
			{
				formDetails.setAttribute78(null);
			}
			
			if(callType.equalsIgnoreCase("next"))
			{
				currentPos = currentPos+1;
				formDetails.setCurrentPosition(currentPos);
				if(formDetails.getHighestPosition() < currentPos)
				{
					formDetails.setHighestPosition(currentPos);
				}
			}
			else if(callType.equalsIgnoreCase("prev"))
			{
				formDetails.setCurrentPosition(currentPos-1);
			}
			
		
			
			if(map.get("signName")!=null)
			{
				formDetails.setSignName(map.get("signName").toString());
			}
			
			if(map.get("signPhone")!=null)
			{
				formDetails.setSignPhone(map.get("signPhone").toString());
			}
			
			formDetailsService.edit(formDetails);
			System.out.println(formDetails);
			
			if(formDetails.getCurrentPosition()==8)
			{
				String pdfName = generate500_24smPDF(formDetails.getId());
				String xmlName = Generate500024XML(formDetails.getId());
				formDetails.setPreviewPdf(pdfName);
				formDetails.setXmlFile(xmlName);
				if(formDetails.getStatus().equalsIgnoreCase("P"))
				{
					formDetails.setStatus("C");
				}
				formDetailsService.edit(formDetails);
			}
			
			return formDetails;
		}
	}
	
	@RequestMapping(value = "/formDetails/{id}", method = RequestMethod.DELETE , produces = "application/json")
	public String deleteFormDetails(@PathVariable("id") String id) 
	{
		String msg = "FormDetails deleted successfully.";
		formDetailsService.delete(Long.parseLong(id+""));
		return msg;
	}
	
	@RequestMapping(value = "/industryAddress/{id}", method = RequestMethod.GET , produces = "application/json")
	public IndustryAddress getIndustryAddress(@PathVariable("id") String id) 
	{
		IndustryAddress industryAddress = industryAddressService.getIndustryAddressById(Long.parseLong(id+""));
		return industryAddress;
	}

	@RequestMapping(value = "/industryAddress/{id}", method = RequestMethod.DELETE , produces = "application/json")
	public String deleteIndustryAddress(@PathVariable("id") String id) 
	{
		String msg = "";
		
		List<FormDetails> form = formDetailsService.getFormDetailsByAddress(Long.parseLong(id+""));
		if(form.size()==0)
		{
			industryAddressService.delete(Long.parseLong(id+""));
			msg = "Premises deleted successfully.";
		}
		else
		{
			msg = "Form has been filed, so can not delete this record.";
		}
		
		return msg;
	}

	@RequestMapping(value = "/industryAddress", method = RequestMethod.POST , produces = "application/json")
	public IndustryAddress createIndustryAddress(@RequestBody IndustryAddress industryAddress) 
	{
		industryAddressService.add(industryAddress);
		System.out.println(industryAddress);

		IndustryMember industryMember = memberService.getIndustryMemberById(industryAddress.getIndustryId());
		industryMember.setStatus("C");
		memberService.edit(industryMember);
		System.out.println(industryMember);
		
		return industryAddress;
	}
	
	@RequestMapping(value = "/industryAddress", method = RequestMethod.PUT , produces = "application/json")
	public IndustryAddress updateIndustryAddress(@RequestBody IndustryAddress industryAddress) 
	{
		industryAddressService.edit(industryAddress);
		System.out.println(industryAddress);
		
		IndustryMember industryMember = memberService.getIndustryMemberById(industryAddress.getIndustryId());
		industryMember.setStatus("C");
		memberService.edit(industryMember);
		System.out.println(industryMember);
		
		return industryAddress;
	}
		
	@RequestMapping(value = "/getForm5000.24smPdf/{name}", method = RequestMethod.GET , produces = "application/json")
	public byte[] getfrom5000Pdf(@PathVariable("name") String pdfName) 
	{
		byte[] bytes = null;
		
		Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal(); String
		companyCode = ((UserDetail)principal).getCompanyCode();
		  
		//File file = new File(_fileConfig.getFolder(companyCode, "PDF")+getForm5000Pdf);
		 
		Path path = Paths.get(_fileConfig.getFolder(companyCode, "PDF") + pdfName);
		
		try 
		{
			 bytes = Files.readAllBytes(path);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bytes;
	}
	
	public String generate500_24smPDF(long recordID) 
	{
		String fileName = "";
		String dest = "";
		String out1="";
		String remarks = "";
		PdfReader reader = null;
	    PdfStamper stamper = null;
	    
	    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String companyCode = ((UserDetail)principal).getCompanyCode();
	    try
		{  
			String src = _fileConfig.getEditableform5000sm();
			
			String genUniqueId =  UUID.randomUUID().toString(); 
			fileName = genUniqueId.substring(0, 13);
			
			fileName += "-P.pdf";
			
			dest = _fileConfig.getFolder(companyCode, "PDF") + fileName;
			out1 = _fileConfig.getFolder(companyCode, "TempPDF") + fileName;
			
		    reader = new PdfReader(src);
		    stamper = new PdfStamper(reader, new FileOutputStream(out1));
		    AcroFields form = stamper.getAcroFields();
		    
		    FormDetails formDetails = formDetailsService.getFormDetailsById(recordID);
	    	List<FormColumnMapping> mappings = formColMapService.getFormColumnMapping(formDetails.getFormId());
	    	
	    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	    	Double amt = 0.0; 
	    	
	    	for(FormColumnMapping mapping : mappings)
	    	{
	    		String flexColName = mapping.getFlexColumnName();
	    		Object val = formDetails.getField(flexColName);
	    		String  formate="";
	    		
	    		if(val instanceof Double)
 				{
 				   DecimalFormat df=new DecimalFormat("0.00");	
 				   formate = df.format(val); 
				}
	    		
	    		if(val != null)
	    		{
	    			if(val instanceof Double)
	    			{
		  				form.setField(mapping.getColumnName(),formate.toString());
		  				form.setFieldProperty(mapping.getColumnName(), "setfflags", PdfFormField.FF_READ_ONLY, null);
		  			}
	    			else
	    			{
	    				form.setField(mapping.getColumnName(), val.toString());
			    		form.setFieldProperty(mapping.getColumnName(), "setfflags", PdfFormField.FF_READ_ONLY, null);
	    			}
		    		
		    		if(mapping.getColumnName().equalsIgnoreCase("tax21"))
		    		{
		    			amt = (Double) val;
		    		}
		    		
		    		if(mapping.getColumnName().equalsIgnoreCase("beginning") || mapping.getColumnName().equalsIgnoreCase("ending") 
		    				|| mapping.getColumnName().equalsIgnoreCase("productRemovalDate") || mapping.getColumnName().equalsIgnoreCase("dateOnForm"))
		    		{
		    			Date date = (Date) val;
		    			String dateString = formatter.format(date);
		    			
		    			form.setField(mapping.getColumnName(), dateString);
			    		form.setFieldProperty(mapping.getColumnName(), "setfflags", PdfFormField.FF_READ_ONLY, null);
		    		}
		    		
		    		if(mapping.getColumnName().equalsIgnoreCase("additionalRemarks"))
		    		{
		    			remarks = (String) val;
		    		}
		    	}
	    	}
		    
	    	DecimalFormat df=new DecimalFormat("0.00");	
			String formate = df.format(amt); 
	    	
		    form.setField("paymentAmount", formate.toString());
		    form.setFieldProperty("paymentAmount", "setfflags", PdfFormField.FF_READ_ONLY, null);
		    
		    IndustryMember industryMember = formDetails.getIndustryMember();
		    
		    IndustryAddress industryAddress = formDetails.getIndustryAddress();
		    		    
		    form.setField("employerId", industryMember.getEinNo().substring(0, 2) + "-" + industryMember.getEinNo().substring(2));
		    form.setFieldProperty("employerId", "setfflags", PdfFormField.FF_READ_ONLY, null);
		    
		    form.setField("plantNo", industryAddress.getPermitNo()+"-"+industryAddress.getRegistryNo());
		    form.setFieldProperty("plantNo", "setfflags", PdfFormField.FF_READ_ONLY, null);
		    
		    String name = industryMember.getIndustryName().trim();
		    String address = industryAddress.getAddress1();
		    address += (industryAddress.getAddress2() == null ? "" : (" " + industryAddress.getAddress2().trim()));
		    address += (" " + industryAddress.getCity().trim());
		    address += (" " + industryAddress.getStateCode());
		    		
		    form.setField("taxpayerAddress", StringUtils.join(name.toUpperCase(), "\n", address.toUpperCase()));
		    form.setFieldProperty("taxpayerAddress", "setfflags", PdfFormField.FF_READ_ONLY, null);
		    

		    ColumnText column = new ColumnText(stamper.getOverContent(1));
		    int status = column.go();
			    
			String sign = (formDetails.getDigitalSignature() == null ? "" : formDetails.getDigitalSignature());
				 
			if(sign.equals("")||sign.equals(null)){
					  	    
			}else{
				File logo = new File(_fileConfig.getFolder(formDetails.getCompanyCode(), "Signature") +sign);
				URL myUrl = logo.toURI().toURL();
				com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance(myUrl);
				img.scaleAbsolute(img.getHeight()*2.5f, img.getWidth()*3f); 
						  	    
				column = new ColumnText(stamper.getOverContent(1));
				column.setSimpleColumn(175, 225, 550, 286);
				column.addElement(img);
				status = column.go();
		    
			}
		    
		    stamper.setFormFlattening(true);
			return fileName;
		}
	    catch(Exception ie) 
	    {
			ie.printStackTrace();
		}
	    finally
	    {
	    	try 
	    	{
				stamper.close();
				String out2 = _fileConfig.getFolder(companyCode, "TempPDF") + "remark"+fileName;
				
				if(!remarks.equalsIgnoreCase(""))
				{
					com.itextpdf.text.Document document = new com.itextpdf.text.Document();
					PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream(out2));
					document.open();
					
					Font tfont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
					Paragraph paragraph = new Paragraph(remarks,tfont);
					paragraph.setIndentationLeft(50);
					document.add(paragraph);
					document.close();
				}
				
				com.itextpdf.text.Document document1 = new com.itextpdf.text.Document();
				PdfCopy copy = new PdfCopy(document1, new FileOutputStream(dest));
				document1.open();
				PdfReader readerOne = new PdfReader(out1);
				copy.addDocument(readerOne);
				
				if(!remarks.equalsIgnoreCase(""))
				{
					PdfReader readerTwo = new PdfReader(out2);
					copy.addDocument(readerTwo);
				}
			
				document1.close();
			}
	    	catch (Exception e) 
	    	{
				e.printStackTrace();
			}
		    reader.close();
	    }
	    return fileName;
	}
	
	@RequestMapping(value = "/formDetailList/{id}", method = RequestMethod.GET , produces = "application/json")
	public List<Object> getAllFormDetails(@PathVariable("id") String id) 
	{
		List<Object> returnObj = new ArrayList<Object>();
		HashMap<String,Object> responseMap = new HashMap<String,Object>();
		
		List<FormDetails> formDetails = formDetailsService.getFormDetailsByMember(Long.parseLong(id+""));
		
		List<Object> subLine = new ArrayList<Object>();
		List<Object> penLine = new ArrayList<Object>();
		
		for(FormDetails formDet:formDetails)
		{
			if(formDet.getStatus().equalsIgnoreCase("S"))
			{
				subLine.add(formDet);
			}
			else if(formDet.getStatus().equalsIgnoreCase("P") || formDet.getStatus().equalsIgnoreCase("C"))
			{
				penLine.add(formDet);
			}
		}
		
		responseMap.put("submittedForms", subLine);
		responseMap.put("pendingForms", penLine);
		
		returnObj.add(responseMap);
		
		return returnObj;
	}
	
	@RequestMapping(value = "/gettaxrates/{gallonRange}", method = RequestMethod.GET , produces = "application/json")
	public List<TaxRates> getTaxRates(@PathVariable("gallonRange") String gallonRange) 
	{
		String gallonRangeLow = "";
		String gallonRangeHigh = "";
		
		String[] gallonRangeArr = gallonRange.split("-");
		if(gallonRangeArr.length == 1)
		{
			if(gallonRangeArr[0].equals("30,000"))
			{
				gallonRangeLow = "1";
				gallonRangeHigh = gallonRangeArr[0];
			}
			else
			{
				gallonRangeLow = gallonRangeArr[0];
				gallonRangeHigh = "";
			}
		}
		else if(gallonRangeArr.length == 2)
		{
			gallonRangeLow = gallonRangeArr[0];
			gallonRangeHigh = gallonRangeArr[1];
		}
		
		final String low = gallonRangeLow;
		final String high = gallonRangeHigh;
		
		List<TaxRates> taxRates = taxRatesService.findByProductName("WINE");
		
		List<TaxRates> filteredTaxRates = taxRates.stream().parallel().filter(tr -> tr.getQtyRangeLow().equals(low) && tr.getQtyRangeHigh().equals(high)).collect(Collectors.toList());
		
		return filteredTaxRates;
	}
	
	@RequestMapping(value = "/formWizard/{id}", method = RequestMethod.GET , produces = "application/json")
	public FormDetails saveFormWizard(@PathVariable("id") String id) 
	{
		Calendar calendarObj = Calendar.getInstance();
		int curr_year = calendarObj.get(Calendar.YEAR);
		
        Random random = new Random(); 
        String value = String.format("%04d", random.nextInt(10000));
        String Set_Tax_Year =  (curr_year)+(value);
		
		FormDetails formDetails = formDetailsService.getFormDetailsById(Long.parseLong(id+""));
		formDetails.setStatus("S");
		formDetails.setRefNo(Set_Tax_Year);
		formDetailsService.edit(formDetails);
		
		TransmissionHeader transmissionHeader = new TransmissionHeader();
		transmissionHeader.setReferenceNo(Set_Tax_Year);
		transmissionHeader.setFormDetailId(Long.parseLong(id+""));
		transmissionHeader.setIndustryAddressId(formDetails.getIndustryAddressId());
		transmissionHeader.setIndustryMemberId(formDetails.getIndustryMemberId());
		transmissionHeader.setStatus("P");
		transmissionHeader.setSubmittedDate(formDetails.getCreatedDate());;
		transmissionHeaderService.add(transmissionHeader);
		
		return formDetails;
	}
	
	public String Generate500024XML(long id)
	{
		try 
		{
			HashMap<String,Object> res = new HashMap<String,Object>();
			
			FormDetails formDetails = formDetailsService.getFormDetailsById(id);
			
			IndustryMember industryMember = memberService.getIndustryMemberById(formDetails.getIndustryMemberId());
			
			IndustryAddress industryAddress = industryAddressService.getIndustryAddressById(formDetails.getIndustryAddressId());
			
			List<FormColumnMapping> formColumnList = formColMapService.getFormColumnMapping(formDetails.getFormId());
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			for(FormColumnMapping formColumnMapping : formColumnList)
			{
				Object val = formDetails.getField(formColumnMapping.getFlexColumnName());
				if(val != null)
				{
					if(val.toString().equals("Y"))
					{
						res.put(formColumnMapping.getColumnName(), true);
					}
					else if(val.toString().equals("N"))
					{
						res.put(formColumnMapping.getColumnName(), false);
					}
					else
					{
						res.put(formColumnMapping.getColumnName(), val);
					}
				}
			}
			
	         Document document = DocumentHelper.createDocument();
	         Element root = document.addElement( "Report" );
	         Element reportHeaderElement = root.addElement("ReportHeader").addAttribute("binaryAttachmentCnt", "0");

	         reportHeaderElement.addElement("ReturnTs").addText(formatter.format(GregorianCalendar.getInstance().getTime()));
	         reportHeaderElement.addElement("ReturnTypeCd").addText("5000.23");
	         reportHeaderElement.addElement("PermitNo").addText(industryAddress.getPermitNo() + "-" + industryAddress.getRegistryNo());
	         reportHeaderElement.addElement("SerialNo").addText(res.get("serialNumber").toString());
	         if(res.get("returnCovers").toString().equals("PP"))//returnCovers
	         {
	        	 reportHeaderElement.addElement("ReturnCover").addText("Prepayment");
	        	 Element returnCover = reportHeaderElement.addElement("Prepayment");
	        	 returnCover.addElement("RemovalDate").addText(formatter.format(res.get("productRemovalDate"))); 
	         }
	         else
	         {
	        	 reportHeaderElement.addElement("ReturnCover").addText("Period");
	        	 Element returnCover = reportHeaderElement.addElement("Period");
	        	 returnCover.addElement("PeriodStart").addText(formatter.format(res.get("beginning")));
	        	 returnCover.addElement("PeriodEnd").addText(formatter.format(res.get("ending")));
	         }
	         
	         reportHeaderElement.addElement("PaymentAmount").addText(res.get("tax21").toString());
	         
	         Element taxPayer = reportHeaderElement.addElement("TaxPayer");
	         taxPayer.addElement("EIN").addText(industryMember.getEinNo());
	         taxPayer.addElement("TaxPayerName").addText(industryMember.getIndustryName());
	         Element premiseAdd = taxPayer.addElement("PremiseAddress");
	         premiseAdd.addElement("AddressLine1").addText(industryAddress.getAddress1());
	         if(industryAddress.getAddress2() != null && industryAddress.getAddress2() != "")
	         {
	        	 premiseAdd.addElement("AddressLine2").addText(industryAddress.getAddress2());
	         }
	         
	         premiseAdd.addElement("City").addText(industryAddress.getCity());
	         premiseAdd.addElement("State").addText(industryAddress.getStateCode());
	         premiseAdd.addElement("Zip").addText(industryAddress.getZipCode());
	         
	         Element sa = reportHeaderElement.addElement("SigningAuthority");
	         sa.addElement("Name").addText(formDetails.getSignName());
	         sa.addElement("Title").addText(res.get("title").toString());
	         if(formDetails.getSignPhone() != null && !formDetails.getSignPhone().equals(""))
	        	 sa.addElement("PhoneNo").addText(formDetails.getSignPhone());
	         sa.addElement("EmailAddressTxt").addText(industryMember.getEmail());
	         sa.addElement("SignatureDt").addText(formatter.format(res.get("dateOnForm")));
	         
	         reportHeaderElement.addElement("TaxYear").addText("2019");
	         
	         
	         Element reportDataElement = root.addElement("ReportData").addAttribute("documentCnt", "5");
	         
	         Element tTB500024 = reportDataElement.addElement("TTB500024");
	         tTB500024.addElement("TotalTaxAmt").addText(res.get("tax17").toString());
	         if(res.get("tax20") != null && !res.get("tax20").toString().equals(""))
	        	 tTB500024.addElement("TaxCreditsAmt").addText(res.get("tax20").toString());
	         if(res.get("tax18") != null && !res.get("tax18").toString().equals(""))
	        	 tTB500024.addElement("TaxExtraAmt").addText(res.get("tax18").toString());
	         tTB500024.addElement("BalanceDueAmt").addText(res.get("tax21").toString());
	         if(res.get("formOFPayment") != null && res.get("formOFPayment").equals("E"))
	         {
	        	 tTB500024.addElement("PaymentMethod").addText("EFT");
	         }
	         else if(res.get("formOFPayment") != null && res.get("formOFPayment").equals("M"))
	         {
	        	 tTB500024.addElement("PaymentMethod").addText("Money Order");
	         }
	         else if(res.get("formOFPayment") != null && res.get("formOFPayment").equals("C"))
	         {
	        	 tTB500024.addElement("PaymentMethod").addText("Cheque");
	         }
	         else if(res.get("formOFPayment") != null && res.get("formOFPayment").equals("O"))
	         {
	        	 tTB500024.addElement("PaymentMethod").addText("Others");
	         }
	         
	         if(res.get("tax9") != null && !res.get("tax9").toString().equals(""))
	        	 tTB500024.addElement("Line9").addText(res.get("tax9").toString());
	         if(res.get("tax10") != null && !res.get("tax10").toString().equals(""))
	        	 tTB500024.addElement("Line10").addText(res.get("tax10").toString());
	         if(res.get("tax11") != null && !res.get("tax11").toString().equals(""))
	        	 tTB500024.addElement("Line11").addText(res.get("tax11").toString());
	         if(res.get("tax12") != null && !res.get("tax12").toString().equals(""))
	        	 tTB500024.addElement("Line12").addText(res.get("tax12").toString());
	         if(res.get("tax13") != null && !res.get("tax13").toString().equals(""))
	        	 tTB500024.addElement("Line13").addText(res.get("tax13").toString());
	         if(res.get("tax14") != null && !res.get("tax14").toString().equals(""))
	        	 tTB500024.addElement("Line14").addText(res.get("tax14").toString());
	         if(res.get("tax15") != null && !res.get("tax15").toString().equals(""))
	        	 tTB500024.addElement("Line15").addText(res.get("tax15").toString());
	         if(res.get("tax16") != null && !res.get("tax16").toString().equals(""))
	        	 tTB500024.addElement("Line16").addText(res.get("tax16").toString());
	         
	         Element scheduleA = null;
	         if(res.get("item28b") != null && !res.get("item28b").toString().equals(""))
	        	 scheduleA = reportDataElement.addElement("TTB500024ScheduleA");
	         if(res.get("item25a") != null && !res.get("item25a").toString().equals(""))
	         {
		         Element scheduleAItem = scheduleA.addElement("ScheduleAItem");
		         scheduleAItem.addElement("Explanation").addText(res.get("item25a").toString());
		         scheduleAItem.addElement("Tax").addText(res.get("item25b").toString());
		         if(res.get("item25c") != null && !res.get("item25c").toString().equals(""))
		        	 scheduleAItem.addElement("Interest").addText(res.get("item25c").toString());
		         if(res.get("item25d") != null && !res.get("item25d").toString().equals(""))
		        	 scheduleAItem.addElement("Penalty").addText(res.get("item25d").toString());
	         }
	         if(res.get("item26a") != null && !res.get("item26a").toString().equals(""))
	         {
		         Element scheduleAItem = scheduleA.addElement("ScheduleAItem");
		         scheduleAItem.addElement("Explanation").addText(res.get("item26a").toString());
		         scheduleAItem.addElement("Tax").addText(res.get("item26b").toString());
		         if(res.get("item26c") != null && !res.get("item26c").toString().equals(""))
		        	 scheduleAItem.addElement("Interest").addText(res.get("item26c").toString());
		         if(res.get("item26d") != null && !res.get("item26d").toString().equals(""))
		        	 scheduleAItem.addElement("Penalty").addText(res.get("item26d").toString());
	         }
	         if(res.get("item27a") != null && !res.get("item27a").toString().equals(""))
	         {
		         Element scheduleAItem = scheduleA.addElement("ScheduleAItem");
		         scheduleAItem.addElement("Explanation").addText(res.get("item27a").toString());
		         scheduleAItem.addElement("Tax").addText(res.get("item27b").toString());
		         if(res.get("item27c") != null && !res.get("item27c").toString().equals(""))
		        	 scheduleAItem.addElement("Interest").addText(res.get("item27c").toString());
		         if(res.get("item27d") != null && !res.get("item27d").toString().equals(""))
		        	 scheduleAItem.addElement("Penalty").addText(res.get("item27d").toString());
	         }
	         if(res.get("item28b") != null && !res.get("item28b").toString().equals(""))
	        	 scheduleA.addElement("TotalTax").addText(res.get("item28b").toString());
	         if(res.get("item28c") != null && !res.get("item28c").toString().equals(""))
	        	 scheduleA.addElement("TotalInterest").addText(res.get("item28c").toString());
	         if(res.get("item28d") != null && !res.get("item28d").toString().equals(""))
	        	 scheduleA.addElement("TotalPenalty").addText(res.get("item28d").toString());
	         if(res.get("item29") != null && !res.get("item29").toString().equals(""))
	        	 scheduleA.addElement("TotalIncreasingAdjustment").addText(res.get("item29").toString());
	         
	         Element scheduleB = null;
	         if(res.get("item33b") != null && !res.get("item33b").toString().equals(""))
	        	 scheduleB = reportDataElement.addElement("TTB500024ScheduleB");
	         if(res.get("item30a") != null && !res.get("item30a").toString().equals(""))
	         {
		         Element scheduleBItem = scheduleB.addElement("ScheduleBItem");
		         scheduleBItem.addElement("Explanation").addText(res.get("item30a").toString());
		         scheduleBItem.addElement("Tax").addText(res.get("item30b").toString());
		         if(res.get("item30c") != null && !res.get("item30c").toString().equals(""))
		        	 scheduleBItem.addElement("Interest").addText(res.get("item30c").toString());
	         }
	         if(res.get("item31a") != null && !res.get("item31a").toString().equals(""))
	         {
		         Element scheduleBItem = scheduleB.addElement("ScheduleBItem");
		         scheduleBItem.addElement("Explanation").addText(res.get("item31a").toString());
		         scheduleBItem.addElement("Tax").addText(res.get("item31b").toString());
		         if(res.get("item31c") != null && !res.get("item31c").toString().equals(""))
		        	 scheduleBItem.addElement("Interest").addText(res.get("item31c").toString());
	         }
	         if(res.get("item32a") != null && !res.get("item32a").toString().equals(""))
	         {
		         Element scheduleBItem = scheduleB.addElement("ScheduleBItem");
		         scheduleBItem.addElement("Explanation").addText(res.get("item32a").toString());
		         scheduleBItem.addElement("Tax").addText(res.get("item32b").toString());
		         if(res.get("item32c") != null && !res.get("item32c").toString().equals(""))
		        	 scheduleBItem.addElement("Interest").addText(res.get("item32c").toString());
	         }
	         
	         if(res.get("item33b") != null && !res.get("item33b").toString().equals(""))
	        	 scheduleB.addElement("TotalTax").addText(res.get("item33b").toString());
	         if(res.get("item33c") != null && !res.get("item33c").toString().equals(""))
	        	 scheduleB.addElement("TotalInterest").addText(res.get("item33c").toString());
	         if(res.get("item34") != null && !res.get("item34").toString().equals(""))
	        	 scheduleB.addElement("TotalDecreasingAdjustment").addText(res.get("item34").toString());
	         
	         if(res.get("additionalRemarks") != null && !res.get("additionalRemarks").toString().equals(""))
	        	 reportDataElement.addElement("AdjustmentRemarks").addText(res.get("additionalRemarks").toString());
	         
	         if(res.get("formOFPayment") != null && res.get("formOFPayment").equals("E"))
	         {
	        	 TtbPayment ttbPayment = ttbPaymentService.getTtbPaymentById(formDetails.getPaymentId());
		         Element paymentDetails = reportDataElement.addElement("PaymentDetails");//formOFPayment
		         paymentDetails.addElement("AccountNumber").addText(ttbPayment.getAccountNo());
		         paymentDetails.addElement("RoutingNo").addText(ttbPayment.getRoutingNo());
		         paymentDetails.addElement("PhoneNo").addText(ttbPayment.getTaxpayerPhone());
		         paymentDetails.addElement("WithdrawalDate").addText(formatter.format(GregorianCalendar.getInstance().getTime()));
	         }
	         else if(res.get("formOFPayment") != null && res.get("formOFPayment").equals("O"))
	         {
		         Element paymentDetails = reportDataElement.addElement("OtherPaymentDetails");//formOFPayment
		         paymentDetails.addElement("Explaination").addText(res.get("Other").toString());
		         
	         }
	         Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			 String companyCode = ((UserDetail)principal).getCompanyCode();
			 String genUniqueId =  UUID.randomUUID().toString(); 
			 String fileName = genUniqueId.substring(0, 13);
				
			 fileName += "-P.xml";
				
			 String dest = _fileConfig.getFolder(companyCode, "XML") + fileName;

	         
	         // Pretty print the document to System.out
	         OutputFormat format = OutputFormat.createPrettyPrint();
	         XMLWriter writer;
	         FileOutputStream fout=new FileOutputStream(dest);
	         writer = new XMLWriter(fout, format);
	         writer.write(document);
	         
	         fout.close();
	         writer.close();
	         return fileName;
	    } 
		catch (Exception e)
		{
			e.printStackTrace();
			return "";
	    }
		
	}
	
	@RequestMapping(value = "/getF500024XML/{name}", method = RequestMethod.GET , produces = "application/xml")
	public String getF500024XML(@PathVariable("name") String xmlName) 
	{
		String xml = null;
		
		Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal(); String
		companyCode = ((UserDetail)principal).getCompanyCode();
		Path path = Paths.get(_fileConfig.getFolder(companyCode, "XML") + xmlName);
		try 
		{
			byte[] bytes = Files.readAllBytes(path);
			xml = new String(bytes);
			 
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return xml;
	}
	
	@RequestMapping(value = "/updateSignAuthority/{id}", method = RequestMethod.POST , produces = "application/json")
	public FormDetails  updateSignAuthority(@PathVariable("id") String id, @RequestBody String imgFileUri) 
	{
		String data = imgFileUri;
		FormDetails formDetails = formDetailsService.getFormDetailsById(Long.parseLong(id+""));
		
		String base64Image = data.split(",")[1];
		byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
		
		SimpleDateFormat formatterDttm = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date newDate = new Date();
		String newFileName="dp"+formatterDttm.format(newDate);
		
		newFileName += (".JPG");
		
		ByteArrayInputStream in = new ByteArrayInputStream(imageBytes);
        BufferedImage img;
		try {
			img = ImageIO.read(in);
			java.awt.Image scaledImage = img.getScaledInstance(150, 30, java.awt.Image.SCALE_SMOOTH);
		        BufferedImage imageBuff = new BufferedImage(150, 30, BufferedImage.TYPE_INT_RGB);
		        imageBuff.getGraphics().drawImage(scaledImage, 0, 0, new Color(255,255,255), null);
		        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
				ImageIO.write(imageBuff, "jpg", buffer);
				byte[] imageInByte = buffer.toByteArray();
				
				UserDetail principal = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				  
				  FileUtils.writeByteArrayToFile(new File(_fileConfig.getFolder(principal.getCompanyCode(), "Signature")+newFileName), imageInByte);
				  
				  formDetails.setDigitalSignature(newFileName);
				  formDetailsService.edit(formDetails);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return formDetails;
	}
	
	
	@RequestMapping(value = "/getSignAuthorityData/{name}", method = RequestMethod.GET , produces = "application/json")
	public byte[] getSignAuthorityData(@PathVariable("name") String pdfName) 
	{
		byte[] bytes = null;
		
		Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal(); String
		companyCode = ((UserDetail)principal).getCompanyCode();
		  
		
		 
		Path path = Paths.get(_fileConfig.getFolder(companyCode, "Signature") + pdfName);
		
		try 
		{
			 bytes = Files.readAllBytes(path);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bytes;
	}
	
	
	

	@RequestMapping(value = "/getSubmission/{id}", method = RequestMethod.GET , produces = "application/json")
	public List<TransmissionHeader> getSubmissionList(@PathVariable("id") String id) 
	{
		List<TransmissionHeader> TransmissionHeaderList = transmissionHeaderService.getTransmissionHeaderById(Long.parseLong(id+""));
		
		return TransmissionHeaderList;
		
		
	}
	
	@RequestMapping(value = "/payment/{id}", method = RequestMethod.GET , produces = "application/json")
	public TtbPayment getpaymentList(@PathVariable("id") String id) 
	{
		TtbPayment ttbpayment = ttbPaymentService.getTtbPaymentById(Long.parseLong(id+""));
	
		return ttbpayment;
		
		
	}
	
	
}