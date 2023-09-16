/**
 * 
 */
package com.sada.jpacrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sada.jpacrud.model.ServiceProviderModel;

/**
 * @author sadanand chavan
 *
 * Nov 5, 2022 7:49:49 PM
 */

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProviderModel, Long>{
	
	List<ServiceProviderModel> findByMobileNoAndPassword(String mobileNo, String password);

	/**
	 * @param mobileNo
	 * @return
	 */
	ServiceProviderModel findByMobileNo(String mobileNo);
	
}
