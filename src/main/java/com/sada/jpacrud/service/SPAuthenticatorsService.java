/**
 * 
 */
package com.sada.jpacrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sada.jpacrud.model.SPAuthenticators;
import com.sada.jpacrud.repository.SPAuthenticatorsRepository;

/**
 * @author sadanand chavan
 *
 * Nov 10, 2022 7:28:55 PM
 */
@Service
public class SPAuthenticatorsService {
	@Autowired
	private SPAuthenticatorsRepository spAuthenticatorsRepository;

	/**
	 * @param spId
	 * @return
	 */
	public List <SPAuthenticators> getAuths(String spId) {
			return spAuthenticatorsRepository.findBySpId(spId);
	
	}
}
