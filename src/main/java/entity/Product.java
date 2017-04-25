package entity;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class Product implements Serializable{
	
	private static final long serialVersionUID = 345241L;
	
	@NotNull
	private String name;
	
	private String description;
	private Float price;
	private List<MultipartFile> images;
	
	public String getName(){
		return name;
	}
	
	public void serName(String name) {
		this.name = name;
	}
	
	public String getName(String description){
		return description;
	}
	
	public String getDescription(){
		return description ;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Float getPrice() {
		return price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public List<MultipartFile> getImages(){
		return images;
	}
	
	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}
}
