package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import dao.ContacterDao;
import entity.Contacter;
import entity.Groups;
import tools.PageGenerator;

@Service
@Transactional
public class ContacterServiceImpl implements ContacterService{
	
	final public static int numPerPage = 6;

	@Autowired
	@Qualifier("contacterDaoImpl")
	ContacterDao contacterDao;
	
	public  Contacter get(int id){
		return contacterDao.get(Contacter.class, id);
	}
	
	public Contacter get(String name){
		return contacterDao.get(Contacter.class, name);
	}
	
	public List<Contacter> getAll(){
		return contacterDao.getAll(Contacter.class);
	}
	
	public void save(Contacter contacter){
		contacterDao.save(contacter);
	}
	
	public void update(Contacter contacter) {
		contacterDao.update(contacter);
	}
	
	public void delete(Contacter contacter) {
		contacterDao.delete(contacter);
	}
	
	public List<Contacter> findByName(String name){
		return contacterDao.findByColumn(Contacter.class, "name",  name);
	}
	
	public List<Contacter> findByHomeTel(Integer homeTel){
		return contacterDao.findByColumn(Contacter.class, "home_tel", homeTel );
	}
	
	public List<Contacter> findByCellphone(Integer cellphone){
		return contacterDao.findByColumn(Contacter.class, "cellphone", cellphone);
	}
	
	public Set<Groups> getGroups(Contacter contacter){
		Set<Groups> groupsSet =  contacter.getGroupList();
		System.out.println(groupsSet);
		return groupsSet;
	}
	
	@Transactional
	public void addGroups(Contacter contacter, Set<Groups> groupsList){
		for (Groups groups : groupsList) {
			addGroups(contacter, groups);
		}
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void addGroups(Contacter contacter, Groups groups){
		if (contacter.getGroupList().add(groups)) {
			groups.incContacterCount();
		}
	}
	
	public Long count(){
		return contacterDao.count(Contacter.class);
	}
	
	public Boolean findGroups(Contacter contacter, Groups groups){
		Set<Groups> groupsSet =  contacter.getGroupList();
		return groupsSet.contains(groups);
	}
	
	public void deleteGroups(Contacter contacter, Set<Groups> groupsList){
		for (Groups groups : groupsList) {
			deleteGroups(contacter, groups);
		}
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void deleteGroups(Contacter contacter, Groups groups){
		Set<Groups> groupsSet = contacter.getGroupList();
		if (groupsSet.remove(groups)) {
			groups.decContacterCout();
		}
	}	
	
	public Map<String, Object> getContacterDetailsJSON(Integer contacterId){
		Map<String, Object> MapData = new HashMap<String, Object>();
		ArrayList<Map<String, Object>> groupsArray = new ArrayList<Map<String, Object>>();
		final Contacter contacter = get(contacterId);
		Set<Groups> groupsList = contacter.getGroupList();
		for (Groups groups : groupsList) {
			groupsArray.add(groups.toMap());
		}
		MapData.put("contacter", contacter.toMap());
		MapData.put("groups", groupsArray);
		return MapData;
	}
	
	public List<Contacter> getContacterByPage(int page){
		PageGenerator generator = new PageGenerator(numPerPage);
		System.out.println(generator.getStartIndex(page) + "  " + generator.getNumPerPage() );
		List<Contacter> contacterList =  (List<Contacter>)contacterDao.getByPage(Contacter.class, generator.getStartIndex(page), generator.getNumPerPage());
		for (Contacter contacter : contacterList) {
			System.out.println(contacter.getId() + " " + contacter.getName());
		}
		return contacterList;
	}
}
