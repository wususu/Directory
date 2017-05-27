package entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "groups")
public class Groups extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 5234L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private int id;
	
	@Column(name = "name", unique = true)
	private String name;
	
	@Column(name = "count")
	private Integer contacterCount;
	
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
	
	public Integer getContacterCount(){
		return contacterCount;
	}
	
	public void setContatcerCount(Integer contacterCount){
		this.contacterCount = contacterCount;
	}
	
	public Groups() {
		// TODO Auto-generated constructor stub
	}
	
	public Groups(String name){
		this.name = name;
		this.contacterCount = 0;
	}
	
	public Set<Contacter> getContacterList() {
		return contacterLIst;
	}
	
	public void setContacters(Set<Contacter> contacterList) {
		this.contacterLIst = contacterList;
	}
	
	public void incContacterCount(){
		contacterCount += 1;
	}
	
	public void decContacterCout(){
		if (contacterCount > 0) {
			contacterCount -= 1;
		}
	}
	
	public Map<String, Object> toMap(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", name);
		map.put("count", contacterCount);
		return map;
	}
}
