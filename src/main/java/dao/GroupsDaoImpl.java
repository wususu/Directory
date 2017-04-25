package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.Groups;

@Repository
public class GroupsDaoImpl extends BaseDaoHibernate5< Groups> implements GroupsDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Groups get(Class<Groups> entity, String name) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(entity).add((Restrictions.eq("name", name)));
		List<?> list = criteria.list();
		return (Groups)list.get(0);
	}
}
