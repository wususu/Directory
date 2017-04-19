package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Table(name = "user")
@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 123L;
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "username", unique = true)
	private String userName;
	
	@Column(name = "password")
	private String passWord;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassWord() {
		return passWord;
	}
	
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
