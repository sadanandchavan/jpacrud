/**
 * 
 */
package com.sada.jpacrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author sadanand chavan
 *
 * Nov 12, 2022 5:22:48 PM
 */

@Entity
@Table(name= "ImageDetails")
public class ImageModel {
	
	private long imageId;
	
	private long spdId;
	private String imageName;
	
	@Lob
	private byte[] image;

	/**
	 * @return the imageId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getImageId() {
		return imageId;
	}

	/**
	 * @param imageId the imageId to set
	 */
	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	/**
	 * @return the spdId
	 */
	public long getSpdId() {
		return spdId;
	}

	/**
	 * @param spdId the spdId to set
	 */
	public void setSpdId(long spdId) {
		this.spdId = spdId;
	}

	/**
	 * @return the imageName
	 */
	public String getImageName() {
		return imageName;
	}

	/**
	 * @param imageName the imageName to set
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}
	
}
