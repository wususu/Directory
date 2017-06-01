package controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Contacter;
import service.ContacterService;

@Controller
public class imageController {
	
	private static final String contacterDefaultPicPath = "/home/janke/workspace/Demo/image/funny.jpg";
	
	@Autowired
	@Qualifier("contacterServiceImpl")
	ContacterService contacterService;
	
	@RequestMapping(value="/image/{id}")
	public void getImage(@PathVariable Integer id,
			HttpServletRequest request,
			HttpServletResponse response){
			Contacter contacter = contacterService.get((Integer)id);
			String imagePath = contacter.getPic();
			if (imagePath == null) {
				imagePath = contacterDefaultPicPath;
			}
			
			File imageFile = new File(imagePath);
			if (imageFile.exists()) {
					response.setContentType("image/jpg");
					byte[] buffer = new byte[1024];
					FileInputStream fileInputStream = null;
					BufferedInputStream bufferedInputStream = null;
					try{
						fileInputStream = new FileInputStream(imageFile);
						bufferedInputStream = new BufferedInputStream(fileInputStream);
						OutputStream outputStream = response.getOutputStream();
						int i = bufferedInputStream.read(buffer);
						while (i != -1){
							outputStream.write(buffer, 0, i);
							i = bufferedInputStream.read(buffer);
						}
					}catch (IOException e) {
						// TODO: handle exception
						System.out.println(e.toString());
					}finally{
						if (fileInputStream != null){
							try{
								fileInputStream.close();
							}catch (Exception e) {
								// TODO: handle exception
							}
						}
						if (bufferedInputStream != null) {
							try{
								bufferedInputStream.close();
							}catch (Exception e) {
								// TODO: handle exception
							}
						}
					}
				}
	}
}
