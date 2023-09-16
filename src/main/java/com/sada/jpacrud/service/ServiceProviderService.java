/**
 * 
 */
package com.sada.jpacrud.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sada.jpacrud.exception.ResourceNotFoundException;
import com.sada.jpacrud.model.SPDetailsModel;
import com.sada.jpacrud.model.ServiceProviderModel;
import com.sada.jpacrud.repository.ServiceProviderDetailsRepository;
import com.sada.jpacrud.repository.ServiceProviderRepository;

/**
 * @author sadanand chavan
 *
 * Nov 5, 2022 7:51:38 PM
 */

@Service
public class ServiceProviderService{

	@Autowired
	private ServiceProviderRepository serviceProviderRepository;
	@Autowired
	private ServiceProviderDetailsRepository spDetailsRepository;

	/**
	 * @param serviceProviderModel
	 * @return
	 */
	public ServiceProviderModel save(ServiceProviderModel serviceProviderModel) {
		return serviceProviderRepository.save(serviceProviderModel);
	}

	/**
	 * @param serviceProviserId
	 * @return
	 * @throws ResourceNotFoundException 
	 */
	public ServiceProviderModel findById(Long serviceProviserId) throws ResourceNotFoundException {
		ServiceProviderModel sp= serviceProviderRepository.findById(serviceProviserId).orElseThrow(() -> new ResourceNotFoundException("Service Provider not found for this id :: " + serviceProviserId));
		return sp;
	}

	/**
	 * @return
	 */
	public List<ServiceProviderModel> findAll() {
		return (List<ServiceProviderModel>) serviceProviderRepository.findAll();
	}

	/**
	 * @param serviceProviserId
	 * @param serviceProviderModel
	 * @throws ResourceNotFoundException 
	 */
	public ServiceProviderModel updateserviceProvider(Long serviceProviserId, ServiceProviderModel serviceProviderModel) throws ResourceNotFoundException {
		ServiceProviderModel serviceProviderFromDb = serviceProviderRepository.findById(serviceProviserId)
				.orElseThrow(() -> new ResourceNotFoundException("Service provider not found for this id :: " + serviceProviserId));

		serviceProviderFromDb.setEmailId(serviceProviderModel.getEmailId());
		serviceProviderFromDb.setLastName(serviceProviderModel.getLastName());
		serviceProviderFromDb.setFirstName(serviceProviderModel.getFirstName());
		return  serviceProviderRepository.save(serviceProviderFromDb);

	}

	/**
	 * @param serviceProviderId
	 * @throws ResourceNotFoundException 
	 */
	public Map<String, Boolean> deleteServiceProvider(Long serviceProviderId) throws ResourceNotFoundException {
		ServiceProviderModel employee = serviceProviderRepository.findById(serviceProviderId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + serviceProviderId));

		serviceProviderRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;

	}

	/**
	 * @param serviceProviderModel
	 * @return
	 */
	public ServiceProviderModel loginServiceProvider(ServiceProviderModel serviceProviderModel) {
		List <ServiceProviderModel> sp= serviceProviderRepository.findByMobileNoAndPassword(serviceProviderModel.getMobileNo(),serviceProviderModel.getPassword());
		return sp.get(0);
	}

	/**
	 * @param spdModel
	 * @return
	 */
	public SPDetailsModel addSPDetails(SPDetailsModel spdModel) {
		return spDetailsRepository.save(spdModel);
	}

	/**
	 * @param spdId
	 * @return
	 */
	public List<SPDetailsModel> findSPDById(long spdId) {
		return spDetailsRepository.findBySpId(spdId);
	}
	
	/**
	 * @param spdId
	 * @return
	 */
	public List<ServiceProviderModel> findSPByMobileNo(String mobileNo) {
		return null;
		//return serviceProviderRepository.findByMobileNo(mobileNo);
	}
	
	/*
	@Override
	public UserDetails loadUserByUsername(String mobileNo) throws UsernameNotFoundException {
		ServiceProviderModel user = serviceProviderRepository.findByMobileNo(mobileNo);
        //return new org.springframework.security.core.userdetails.User(user.getMobileNo(), user.getPassword(), new ArrayList<>());
		return new org.springframework.security.core.userdetails.User(user.getMobileNo(), user.getPassword(), getAuthority(user));
	}
	
	private Set getAuthority(ServiceProviderModel user) {
		return null;
		
        Set authorities = new HashSet()<>();
		user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		});
		return authorities;
		
		
	}
	*/
}
