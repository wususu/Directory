package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ContacterDao;
import entity.Contacter;
import entity.Groups;

@Service
@Transactional
public class ContacterServiceImpl implements ContacterService{

	@Autowired
	@Qualifier("contacterDaoImpl")
	ContacterDao contacterDao;
	
	@Override
	public  Contacter get(int id){
		return contacterDao.get(Contacter.class, id);
	}
	
	@Override
	public List<Contacter> getAll(){
		return contacterDao.getAll(Contacter.class);
	}
	
	@Override
	public void save(Contacter entity){
		contacterDao.save(entity);
	}
	
	@Override
	public void update(Contacter entity) {
		contacterDao.update(entity);
	}
	
	@Override
	public void delete(Contacter entity) {
		contacterDao.delete(entity);
	}
}
