package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.Contacter;
import entity.Groups;

@Repository
public class GroupsDaoImpl extends BaseDaoHibernate5< Groups> implements GroupsDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Contacter> getByPage(Class<Contacter> entity,Groups group,  int start, int max){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(entity);
		criteria.createAlias("groupList", "gl").add(Restrictions.eq("gl.id", group.getId()));
		criteria.setMaxResults(max);
		criteria.setFirstResult(start);
		return (List<Contacter>)criteria.list();
	}
	
	public Groups get(Class<Groups> entity, String name) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(entity).add((Restrictions.eq("name", name)));
		List<?> list = criteria.list();
		try{
			return (Groups)list.get(0);
		}catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			return null;
		}
	}
}
