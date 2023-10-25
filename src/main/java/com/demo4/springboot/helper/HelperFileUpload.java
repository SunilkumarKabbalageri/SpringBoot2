package com.demo4.springboot.helper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class HelperFileUpload {

	// this is a static path we are using this for fixed means with in the locahost
	// public final String upload_directory =
	// "C:\\Users\\kabba\\Documents\\workspace-spring-tool-suite-4-4.19.1.RELEASE\\demo-4\\src\\main\\resources\\static\\images";

	// if we want to use dynamic we can use
	public final String upload_directory = new ClassPathResource("/static/images/").getFile().getAbsolutePath();

	// ClassPathResource will provide the path upto resources, to get absolute path
	// we use getAbsolutePath()F
	public HelperFileUpload() throws IOException {

	}

	public boolean uploadFile(MultipartFile file) {

		boolean f = false;
		try {
			// 1st we should read file
			InputStream inputStream = file.getInputStream();// it will store the inputstream of th eimage
			byte[] bs = new byte[inputStream.available()];// it will convert the image into byto code with available
															// amount of array size
			inputStream.read();// it will read the file

			// once we read the file next step is to store i,e write for write

			FileOutputStream fileOutputStream = new FileOutputStream(
					upload_directory + "\\" + file.getOriginalFilename());
			fileOutputStream.write(bs);
			fileOutputStream.flush();
			fileOutputStream.close();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
