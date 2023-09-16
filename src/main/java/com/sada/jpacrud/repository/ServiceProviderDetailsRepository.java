/**
 * 
 */
package com.sada.jpacrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sada.jpacrud.model.SPDetailsModel;

/**
 * @author sadanand chavan
 *
 * Nov 10, 2022 11:07:23 PM
 */
public interface ServiceProviderDetailsRepository extends JpaRepository<SPDetailsModel, Long> {
	
	List<SPDetailsModel> findBySpId(long spId);
}
