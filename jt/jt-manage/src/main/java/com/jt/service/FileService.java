package com.jt.service;
import org.springframework.web.multipart.MultipartFile;
import com.jt.vo.FileImage;
public interface FileService {
	
	public FileImage upload(MultipartFile uploadFile);
}
