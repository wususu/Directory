package dao;


import java.io.Serializable;
import java.util.List;

import entity.Groups;


public interface BaseDao <T>{
	
	T get(Class<T> entity,int id);
	List<T> getAll(Class<T> entity);
	Serializable save(T entity);
	void update(T entity);
	void delete(T entity);
	
}
