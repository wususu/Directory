package service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.GroupsDao;
import entity.Contacter;
import entity.Groups;

@Service
@Transactional
public class GroupsServiceImpl implements GroupsService{

	@Autowired
	@Qualifier("groupsDaoImpl")
	GroupsDao groupsDao;
	
	@Autowired
	@Qualifier("contacterServiceImpl")
	ContacterService contacterService;
	
	public Groups get(int id){
		return groupsDao.get(Groups.class, id);
	}
	
	public Groups get(String name) {
		return groupsDao.get(Groups.class, name);
	}
	
	public List<Groups> getAll() {
		return groupsDao.getAll(Groups.class);
	}
	
	public void save(Groups groups) {
		groupsDao.save(groups);
	}
	
	public void update(Groups groups) {
		groupsDao.update(groups);
	}
	
	public void delete(Groups groups) {
		groupsDao.delete(groups);
	}
	
	public 	Set<Contacter> getContacters(Groups groups){
		Set<Contacter> contacterSet = groups.getContacterList();
		return contacterSet;
	}
	
	public void deleteContacter(Groups groups, Contacter contacter){
		contacterService.deleteGroups(contacter, groups);
	}
	
	public void deleteContacters(Groups groups, Set<Contacter> contactersList){
		for (Contacter contacter : contactersList) {
			contacterService.deleteGroups(contacter, groups);
		}
	}
	
	public void addContacter(Groups groups, Contacter contacter){
		contacterService.addGroups(contacter, groups);
	}
	
	public void addContacters(Groups groups, Set<Contacter> contactersList){
		for (Contacter contacter : contactersList) {
			contacterService.addGroups(contacter, groups);
		}
	}
	
	public List<Contacter> getByPage(Groups group,  int start, int max){
		return groupsDao.getByPage(Contacter.class, group, start, max);
	}
}
