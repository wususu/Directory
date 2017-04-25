package entity;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class Image implements Serializable{
	
	private static final long serialVersionUID = 1213123L;
	
	private MultipartFile picture;
	
	public MultipartFile getPicture(){
		return picture;
	}
	
	public void setPicture(MultipartFile picture){
		this.picture = picture;
	}
	
}
