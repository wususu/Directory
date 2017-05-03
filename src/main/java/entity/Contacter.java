package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.json.JSONObject;

import tools.StringUtils;

@Entity
@Table(name = "contacter")
public class Contacter extends BaseEntity  implements Serializable{
	
	private static final long serialVersionUID = 3124L;
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "id")
	private int id;
	
	@Column(name = "name", unique = true)
	private String name;
	
	@Column(name = "home_tel")
	private Integer homeTel;
	
	@Column(name = "cellphone")
	private Integer cellphone;
	
	@Column(name = "wechat")
	private String wechat;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "birthday")
	private String birthDay;
	
	@Column(name = "pic")
	private String pic;
	
	@Column(name = "work")
	private String work;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "zip_code")
	private Integer zipCode;
	
	@Column(name = "remarks")
	private String  remarks;
	
	@ManyToMany(cascade = CascadeType.ALL, targetEntity = Groups.class)
	@JoinTable(
			name = "contacter_in_groups",
			joinColumns = @JoinColumn(name = "contacter_id"),
			inverseJoinColumns = @JoinColumn(name = "group_id")
			)
	private Set<Groups> groupList;
	
	public Contacter() {
		// TODO Auto-generated constructor stub
	}
	
	public Contacter(String name){
		this.name = name;
	}
	
	public Set<Groups> getGroupList(){
		return groupList;
	}
	
	public void setGroups(Set<Groups> groupList){
		this.groupList = groupList;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setHomeTel(Integer homeTel) {
		this.homeTel = homeTel;
	}
	
	public Integer  getHomeTel() {
		return homeTel;
	}
	
	public void setCellphone(Integer cellphone) {
		this.cellphone = cellphone;
	}
	
	public Integer  getCellphone() {
		return cellphone;
	}
	
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	
	public String getWechat() {
		return wechat;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String  getMail() {
		return mail;
	}
	
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	
	public String getBirthDay() {
		return birthDay;
	}
	
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	public String getPic() {
		return pic;
	}
	
	public void setWork(String work) {
		this.work = work;
	}
	
	public String getWork() {
		return work;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	
	public Integer getZipCode() {
		return zipCode;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getRemarks() {
		return remarks;
	}
	
	public Map<String, Object> toMap(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", name);
		map.put("pic", pic);
		map.put("birthday", birthDay);
		map.put("remarks", remarks);
		map.put("homeTel", homeTel);
		map.put("cellphone", cellphone);
		map.put("wechat", wechat);
		map.put("work", work);
		map.put("mail", mail);
		map.put("address", address);
		map.put("zip_code", zipCode);
		return map;
	}
	
}
