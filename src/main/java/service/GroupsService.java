package service;

import java.util.List;
import java.util.Set;

import entity.Contacter;
import entity.Groups;

public interface GroupsService {
	
	/**
	 * 根据id获取分组对象
	 * @param id
	 * @return
	 */
	Groups get(int id);
	
	/**
	 * 	根据组名获取分组对象
	 * @param name
	 * @return
	 */
	Groups get(String name);
	
	/**
	 * 获取所有分组对象
	 * @return
	 */
	List<Groups> getAll();
	
	/**
	 * 保存一个分组对象
	 * @param entity
	 */
	void save(Groups entity);
	
	/**
	 * 更新一个分组对象信息
	 * @param entity
	 */
	void update(Groups entity);
	
	/**
	 * 删除一个分组对象
	 * @param entity
	 */
	void delete(Groups entity);
	
	/**
	 * 获取分组对象里所有联系人对象
	 * @param entity
	 * @return
	 */
	Set<Contacter> getContacters(Groups entity);
	
	/**
	 * 删除分组对象中一个联系人对象
	 * @param groups
	 * @param entity
	 */
	void deleteContacter(Groups groups, Contacter entity);
	
	/**
	 * 删除分组对象中一组联系人对象
	 * @param groups
	 * @param entityList
	 */
	void deleteContacters(Groups groups, Set<Contacter> entityList);
	
	/**
	 * 在分组对象中增加一个联系人对象
	 * @param groups
	 * @param entity
	 */
	void addContacter(Groups  groups,Contacter entity);
	
	/**
	 * 在分组对象中增加一组联系人对象
	 * @param groups
	 * @param entityList
	 */
	void addContacters(Groups groups, Set<Contacter> entityList);
	
	List<Contacter> getByPage(Groups group,  int start, int max);
	
}
