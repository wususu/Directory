package service;

import java.util.List;

import org.springframework.stereotype.Service;

import entity.Contacter;
import entity.User;

@Service
public interface ContacterService {
	
	Contacter get(int id);
	List<Contacter> getAll();
	void save(Contacter entity);
	void update(Contacter entity);
	void delete(Contacter entity);
	
}
