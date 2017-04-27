package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import entity.BaseEntity;

/**
 * 数据格式化类(JSON)
 * @author janke
 *
 * @param <T>
 * @param <M1>
 * @param <M2>
 */
@Service
public class DataFormatService<T extends BaseEntity, M1 extends HashMap<String, Object>, M2 extends HashMap<String, HashMap<String, Object>>>{
	
	public static  <T> String getEntityName(T entity) {
		return entity.getClass().getSimpleName().toLowerCase();
	}
	
	public   Map<String, M1>  entityToMap(T entity){
		Map<String, M1> entityMap = new HashMap<String, M1>();
		String entityName = DataFormatService.getEntityName(entity);
		@SuppressWarnings("unchecked")
		M1 propertyMap = (M1) entity.toMap();
    		entityMap.put(entityName, propertyMap);
    	return entityMap;
	}
	
	public  List<M2> entityMapToList(Set<T> entitySet){
		List<M2>  entityMapList = new ArrayList<>();
		for (T entity : entitySet) {
			@SuppressWarnings("unchecked")
			M2 entityMap = (M2)entityToMap(entity);
			entityMapList.add(entityMap);
		}
		return entityMapList;
	}
	
	
	
}