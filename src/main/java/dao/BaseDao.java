package dao;


import java.io.Serializable;
import java.util.List;



public interface BaseDao <T>{
	
	Long count(Class<T> entity);
	T get(Class<T> entity,int id);
	List<T> getAll(Class<T> entity);
	List<T> getByPage(Class<T> entity, int start, int max);
	Serializable save(T entity);
	void update(T entity);
	void delete(T entity);
	List<T> findLike(Class<T> entity, String property, String value);
	 List<T> findLike(Class<T> entity, String property, Integer value);
}
