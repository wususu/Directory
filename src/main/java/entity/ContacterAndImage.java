package entity;

import java.io.Serializable;

public class ContacterAndImage implements Serializable{

	private static final long serialVersionUID = 1223124L;
	
	private Contacter contacter;
	
	private Image image;
	
	public Contacter getContacter() {
		return contacter;
	}
			
	public void  setContacter(Contacter contacter) {
		this.contacter = contacter;
	}
	
	public Image getImage() {
		return image;
	}
	
	public  void setImage(Image image) {
		this.image = image;
	}
}
