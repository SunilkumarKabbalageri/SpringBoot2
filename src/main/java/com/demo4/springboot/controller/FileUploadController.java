package com.demo4.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo4.springboot.helper.HelperFileUpload;

@RestController
public class FileUploadController {
	@Autowired
	public HelperFileUpload fileUpload;

	@PostMapping("/upload_file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//		System.out.println();
//		System.out.println("fileName"+file.getSize()+" fileSize"+file.getName()+" fileOriginalName"+file.getOriginalFilename());
//		System.out.println();
		try {

			// validation
			if (file.isEmpty()) {
				ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request should contain a file");
			}
			if (!file.getContentType().equals("image/jpeg")) {
				ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request should contain a file");

			}
			// Take some helper class to upload file and do the operations
			boolean b = fileUpload.uploadFile(file);
			if (b) {
				// it will print string
				// return ResponseEntity.ok("File_Uploaded Sucessfully");

				// if we want to print the url
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/")
						.path(file.getOriginalFilename()).toUriString());
				// (it will provide location url upto localhost:8080)
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("File not uploaded sucessfully..!! try again");

		// the MultiPartFile is a class which handles the file rrelated works that is
		// uploading and all

	}
}
