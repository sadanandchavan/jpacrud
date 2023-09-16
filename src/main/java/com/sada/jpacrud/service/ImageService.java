/**
 * 
 */
package com.sada.jpacrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sada.jpacrud.model.ImageModel;
import com.sada.jpacrud.repository.ImageRepository;

/**
 * @author sadanand chavan
 *
 * Nov 12, 2022 5:40:17 PM
 */
@Service
public class ImageService {
	
	@Autowired
	private ImageRepository imageRepository;

	/**
	 * @param imageFile
	 * @return
	 * @throws Exception 
	 */
	public ImageModel addImage(ImageModel imageModel,MultipartFile  multipartFile) throws Exception {
		imageModel.setImage(multipartFile.getBytes());
		ImageModel savedImgModel =imageRepository.save(imageModel);
		return savedImgModel;
	}

}
