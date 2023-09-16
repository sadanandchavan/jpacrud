/**
 * 
 */
package com.sada.jpacrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author sadanand chavan
 *
 * Nov 14, 2022 11:23:35 PM
 */
@Entity
public class Role {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

	@Enumerated(EnumType.STRING)
    @Column
    private RoleEnum name;

    @Column
    private String description;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	enum RoleEnum {
	    RED,
	    GREEN,
	    BLUE;
	}

	/**
	 * @return the name
	 */
	public RoleEnum getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(RoleEnum name) {
		this.name = name;
	}
}
