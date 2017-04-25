package service;

import java.util.List;

import entity.Contacter;
import entity.Groups;

public interface GroupsService {
	
	Groups get(int id);
	
	List<Groups> getAll();
	
	void save(Groups entity);
	
	void update(Groups entity);
	
	void delete(Groups entity);
	
	List<Contacter> getContacters(Groups entity);
	
	void deleteContacter(Contacter entity);
	
	void deleteContacters(List<Contacter> entityList);
	
	void addContacter(Contacter entity);
	
	void addContacters(List<Contacter> entityList);
	
}
