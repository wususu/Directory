package dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.Contacter;

@Repository
public class ContacterDaoImpl extends BaseDaoHibernate5<Contacter> implements ContacterDao{
	
	
}
