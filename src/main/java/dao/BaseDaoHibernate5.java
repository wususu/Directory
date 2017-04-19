package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseDaoHibernate5<T> implements BaseDao<T>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
    @Override
	public T get(Class<T > entity, int id){
		Session session =sessionFactory.getCurrentSession();
		Serializable object = (Serializable) session.get(entity, id);
		return (T) object;
	}
	
    @Override
	public List<T> getAll(Class<T> entity){
		Session session = sessionFactory.getCurrentSession();
		String hql = "from " +  entity.getSimpleName();
		Query query = session.createQuery(hql);
		return query.list();
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
