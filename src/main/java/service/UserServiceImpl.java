package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	@Qualifier("userDaoImpl")
	UserDao userDao;
	
	public User get(Integer id){
		return userDao.get(User.class, id);
	}
	
	public User get(String userName) {
		return userDao.get(userName);
	}
	
	public void update(User entity) {
		userDao.update(entity);
	}
	
	public void save(User entity) {
		userDao.save(entity);
	}
	
	public void delete(User entity) {
		userDao.delete(entity);
	}
	
	public Boolean checkUser(String userName, String passWord) {
		try{
			User user = 	userDao.get(userName);
		if (user.getPassWord().equals(passWord)) {
			return true;
		}
		}catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			return false;
		}
		return false;
	}
}
