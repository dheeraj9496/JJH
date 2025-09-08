package com.JeevanJyotiHospital.Controller;



import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class fileUpload {
	@PostMapping("/fileupload")
	public ResponseEntity<String> uploadFile(@RequestParam("fileuploads")MultipartFile fileupload){
		System.out.println(fileupload.getOriginalFilename());
		System.out.println(fileupload.getSize());
	
		return  ResponseEntity.ok("upload success");
	}
 
}
