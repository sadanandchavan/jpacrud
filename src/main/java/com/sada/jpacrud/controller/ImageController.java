/**
 * 
 */
package com.sada.jpacrud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sada.jpacrud.model.ImageModel;
import com.sada.jpacrud.service.ImageService;

/**
 * @author sadanand chavan
 *
 * Nov 12, 2022 5:42:12 PM
 */
@RestController
@RequestMapping("/api/v1")
//@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.OPTIONS}, allowedHeaders = {"Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers"}, exposedHeaders = {"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"})
@CrossOrigin(origins = "*")
public class ImageController {

	Logger logger   = LoggerFactory.getLogger(ServiceProviderController.class);

	@Autowired
	private ImageService imageService;

	@PostMapping("/image/uploadImage/{spdId}")
	public ImageModel uploadFile(Model model , @RequestParam("imageFile") MultipartFile  imageFile, @PathVariable(value = "spdId") long spdId) throws Exception {
		logger.info("Request for upload Image called for spdId"+spdId);
		String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
		ImageModel image  = new ImageModel();
		image.setSpdId(spdId);
		image.setImageName(fileName);
		ImageModel savedImage = imageService.addImage(image, imageFile);
		logger.info("Image saved success");
		return savedImage;
	}

}
