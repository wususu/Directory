package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseDaoHibernate5<T> implements BaseDao<T>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
    @SuppressWarnings("unchecked")
	public T get(Class<T > entity, int id){
		Session session =sessionFactory.getCurrentSession();
		Serializable object = (Serializable) session.get(entity, id);
		return (T) object;
	}
	
    @Override
    @SuppressWarnings("unchecked")
	public List<T> getAll(Class<T> entity){
		Session session = sessionFactory.getCurrentSession();
		String hql = "from " +  entity.getSimpleName();
		Query query = session.createQuery(hql);
		return (List<T>)query.list();
	}
    
    @Override
    public List<T> findLike(Class<T> entity, String property, String value){
    		Session session =  sessionFactory.getCurrentSession();
    		Criteria criteria = session.createCriteria(entity).add(Restrictions.ilike(property, "%" + value + "%"));
    		@SuppressWarnings("unchecked")	
    		List<T> list = criteria.list();
    	return list;
    }
    
    @Override
    public List<T> findLike(Class<T> entity, String property, Integer value){
    		Session session =  sessionFactory.getCurrentSession();
    		Criteria criteria = session.createCriteria(entity).add(Restrictions.sqlRestriction(property.toLowerCase() + " LIKE '%" + value +  "%'"));
    		@SuppressWarnings("unchecked")	
    		List<T> list = criteria.list();
    	return list;
    }
	
    @Override
	public Serializable save(T entity) {
		Session session = sessionFactory.getCurrentSession();
		Serializable serializable = session.save(entity);
		return serializable;
	}
    
    @Override
	public void update(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.update(entity);
	}
	
    @Override
	public void delete(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(entity);
	}
}
