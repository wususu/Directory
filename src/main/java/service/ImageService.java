package service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ImageService {
	
	Boolean saveImage(MultipartFile image, String picPath);
	String getContacterPicName(Integer id, String name);
}
