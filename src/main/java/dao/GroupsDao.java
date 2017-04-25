package dao;

import entity.Groups;

public interface GroupsDao extends BaseDao<Groups>{

	Groups get(Class<Groups> entity, String name);
}
