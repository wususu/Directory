package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Contacter;
import entity.Groups;

@Repository
public class ContacterDaoImpl extends BaseDaoHibernate5<Contacter> implements ContacterDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Contacter get(Class<Contacter> entity, String name) throws IndexOutOfBoundsException{
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(entity).add(Restrictions.eq("name", name));
		List<?>  list = criteria.list(); 
		return (Contacter)list.get(0);
	}
	
	@Override
	public List<Contacter> findByColumn(Class<Contacter> entity,String property, String matchValue){
		return findLike(entity, property, matchValue);
	}
	
	@Override
	public List<Contacter> findByColumn(Class<Contacter> entity,String property, Integer matchValue){
		return findLike(entity, property, matchValue);
	}

	@Override
	@Transactional
	public void addGroups(Contacter contacter, Groups groups){
		contacter.getGroupList().add(groups);
	}



	
}
