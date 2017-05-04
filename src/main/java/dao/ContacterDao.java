package dao;

import java.util.List;

import entity.Contacter;
import entity.Groups;

public interface ContacterDao extends BaseDao<Contacter>{
	
	// 通过用户名查找联系人
	Contacter get(Class<Contacter> entity, String name);
	// 通过column查找联系人
	List<Contacter> findByColumn(Class<Contacter> entity,String property, String matchValue);
	List<Contacter> findByColumn(Class<Contacter> entity,String property, Integer matchValue);
	void addGroups(Contacter contacter, Groups groups);
}
