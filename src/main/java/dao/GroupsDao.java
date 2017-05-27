package dao;

import java.util.List;

import entity.Contacter;
import entity.Groups;

public interface GroupsDao extends BaseDao<Groups>{

	Groups get(Class<Groups> entity, String name);
	
	List<Contacter> getByPage(Class<Contacter> entity,Groups group,  int start, int max);

}
