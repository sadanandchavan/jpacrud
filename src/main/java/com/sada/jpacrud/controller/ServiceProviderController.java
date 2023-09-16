/**
 * 
 */
package com.sada.jpacrud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sada.jpacrud.exception.ResourceNotFoundException;
import com.sada.jpacrud.model.SPAuthenticators;
import com.sada.jpacrud.model.SPDetailsModel;
import com.sada.jpacrud.model.ServiceProviderModel;
import com.sada.jpacrud.service.SPAuthenticatorsService;
import com.sada.jpacrud.service.ServiceProviderService;
import com.sada.jpacrud.util.JwtUtil;


/**
 * @author sadanand chavan
 *
 * Nov 5, 2022 7:59:26 PM
 */

@RestController
@RequestMapping("/api/v1/sp")
@CrossOrigin(origins="*")
public class ServiceProviderController {
	
    Logger logger   = LoggerFactory.getLogger(ServiceProviderController.class);
    String CLASSNAME =this.getClass().getName();

	@Autowired
	private ServiceProviderService serviceProviderService;
	@Autowired
	private SPAuthenticatorsService spAuthService;
	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/sp")
	public ServiceProviderModel createServiceProvider(@Validated @RequestBody ServiceProviderModel serviceProviderModel) {
		//return serviceProviderService.save(serviceProviderModel);
		ServiceProviderModel sp = serviceProviderService.save(serviceProviderModel);
		logger.info("Service provider saved "+sp.getFirstName());
		return sp;
	}

	@GetMapping("/sp/{id}")
	public List<ServiceProviderModel> getServiceProviderById(@PathVariable(value = "id") Long serviceProviderId)
			throws ResourceNotFoundException {
		logger.info(CLASSNAME+ "getServiceProvoder called for id="+serviceProviderId);
		ServiceProviderModel sp = serviceProviderService.findById(serviceProviderId);
		List<ServiceProviderModel> list = new ArrayList<ServiceProviderModel>();
		list.add(sp);
		return list;
		//return ResponseEntity.ok().body(employee);
	}
	//http://localhost:8080/springboot-crud-rest/api/v1/serviceprovider
	@GetMapping("/sp")
	public List<ServiceProviderModel> getAllServiceProvider()  {
		logger.info("getAllServiceProvider called for ");
		return serviceProviderService.findAll();
	}

	@PutMapping("/sp/{id}")
	public ResponseEntity<ServiceProviderModel> updateserviceProvider(@PathVariable(value = "id") Long serviceProviderId,
			@Validated @RequestBody ServiceProviderModel serviceProviderModel) throws ResourceNotFoundException {
		logger.info(CLASSNAME+ "updateserviceProvider called for "+serviceProviderId);
		ServiceProviderModel updatedserviceProviderModel =serviceProviderService.updateserviceProvider(serviceProviderId, serviceProviderModel);
		return ResponseEntity.ok(updatedserviceProviderModel);	

	}

	@DeleteMapping("/serviceprovider/{id}")
	public Map<String, Boolean> deleteServiceProvider(@PathVariable(value = "id") Long serviceProviderId) throws ResourceNotFoundException{
		logger.info("deleteServiceProvider called for "+serviceProviderId);
		return serviceProviderService.deleteServiceProvider(serviceProviderId);
	}
	
	@GetMapping("/spLogin")
	public List<ServiceProviderModel> loginServiceProvider(@RequestParam String mobileNo, @RequestParam String password)
			throws ResourceNotFoundException {
		logger.info("loginServiceProvider called for =["+mobileNo+"] Password=["+password+"]");
		ServiceProviderModel spModel = new ServiceProviderModel();
		spModel.setMobileNo(mobileNo);
		spModel.setPassword(password);
		ServiceProviderModel sp = serviceProviderService.loginServiceProvider(spModel);
		List<ServiceProviderModel> list = new ArrayList<ServiceProviderModel>();
		sp.setToken(jwtUtil.generateToken(spModel.getMobileNo()));
		list.add(sp);
		return list;
		//return ResponseEntity.ok().body(employee);
	}
	
	@GetMapping("/auths/{spId}")
	public List<SPAuthenticators> getSPAuths(@PathVariable(value = "spId") String spId)
			throws ResourceNotFoundException {
		logger.info("getSPAuths called for id="+spId);
		List<SPAuthenticators> authsList = spAuthService.getAuths(spId);
		return authsList;
	}
	
	@PostMapping("/spDetails")
	public SPDetailsModel addServiceProviderDetails(@RequestBody SPDetailsModel spdModel) {
		//return serviceProviderService.save(serviceProviderModel);
		SPDetailsModel spd = serviceProviderService.addSPDetails(spdModel);
		logger.info("Service provider details saved "+spd.getSpdId());
		return spd;
	}
	
	@GetMapping("/spDetails/{spdId}")
	public List<SPDetailsModel> getSPDetailsById(@PathVariable(value = "spdId") long spdId)
			throws ResourceNotFoundException {
		logger.info("getSPDetailsById called for id="+spdId);
		List<SPDetailsModel>  spdList = serviceProviderService.findSPDById(spdId);
		logger.info("getSPDetailsById called for id="+spdId +" list "+spdList.toString());
		return spdList;
	}

}
