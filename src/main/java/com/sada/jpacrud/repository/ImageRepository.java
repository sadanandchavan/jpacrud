/**
 * 
 */
package com.sada.jpacrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sada.jpacrud.model.ImageModel;

/**
 * @author sadanand chavan
 *
 * Nov 12, 2022 5:39:31 PM
 */

public interface ImageRepository extends JpaRepository<ImageModel, Long> {

}
