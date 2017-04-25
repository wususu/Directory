package service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageService{

		public Boolean saveImage(MultipartFile image, String picPath){
			File imageFile = new File(picPath);
			try{
				image.transferTo(imageFile);
				System.out.println("ok");
				return true;
			}catch (IOException e) {
				System.out.println("文件写入错误");
				// TODO: handle exception
				e.printStackTrace();
			}
			return false;
		}
		
		public String getContacterPicName(Integer id, String name) {
			return id +"."+ name + ".png";
	}
}
