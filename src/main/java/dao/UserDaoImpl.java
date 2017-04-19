package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.User;

@Repository
public class UserDaoImpl extends BaseDaoHibernate5<User> implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
//	根据用户名查找用户
	@Override
	public User get(String userName) throws IndexOutOfBoundsException{
		Session session =sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("userName", userName));
		List<?>  list = criteria.list(); list.get(0);
		return (User)list.get(0);
	}
}
