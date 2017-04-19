package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "groups")
public class Groups implements Serializable{

	private static final long serialVersionUID = 5234L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private int id;
	
	@Column(name = "name", unique = true)
	private String name;
	
	@ManyToMany(mappedBy = "groupList", targetEntity=Contacter.class, cascade = CascadeType.ALL)
	private Set<Contacter> contacterLIst;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int  getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Groups() {
		// TODO Auto-generated constructor stub
	}
	
	public Groups(String name){
		this.name = name;
	}
	
	public Set<Contacter> getContacterList() {
		return contacterLIst;
	}
	
	public void setContacters(Set<Contacter> contacterList) {
		this.contacterLIst = contacterList;
	}
}
