/**
 * 
 */
package com.sada.jpacrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sada.jpacrud.model.SPAuthenticators;

/**
 * @author sadanand chavan
 *
 * Nov 10, 2022 7:27:53 PM
 */
@Repository
public interface SPAuthenticatorsRepository extends JpaRepository<SPAuthenticators, Long> {
	
	List <SPAuthenticators> findBySpId(String spId);

}
