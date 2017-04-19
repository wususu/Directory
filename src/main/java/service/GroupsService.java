package service;

import java.util.List;

import entity.Groups;

public interface GroupsService {
	
	Groups get(int id);
	List<Groups> getAll();
	void save(Groups entity);
	void update(Groups entity);
	void delete(Groups entity);
}
