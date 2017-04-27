package service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import entity.Contacter;
import entity.Groups;

@Service
public interface ContacterService {
	
	Contacter get(int id);
	
	Contacter get(String name);
	
	List<Contacter> getAll();
	
	void save(Contacter contacter);
	
	void update(Contacter contacter);
	
	void delete(Contacter contacter);
	
	List<Contacter> findByName(String name);
	
	List<Contacter> findByHomeTel(Integer homeTel);
	
	List<Contacter> findByCellphone(Integer cellphone);
	
	Set<Groups> getGroups(Contacter contacter);
	
	void addGroups(Contacter contacter, Set<Groups> groupsList);
	
	void addGroups(Contacter contacter, Groups groups);
	
	void deleteGroups(Contacter contacter, Set<Groups> groupsList);
	
	void deleteGroups(Contacter contacter, Groups groups);
	
	Boolean findGroups(Contacter contacter, Groups groups);
	
	/**
	 * 获取所有联系人信息(不包括分组情况)
	 * @return
	 */
	List<Map<String,Object>> getAllContacters();
	
	/**
	 * 根据id获取一个联系人详细信息(包括分组情况)
	 * @param contacterId
	 * @return
	 */
	Map<String, Object> getContacterData(Integer contacterId);

	
}
