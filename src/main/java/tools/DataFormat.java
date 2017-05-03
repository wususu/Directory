package tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


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
public class DataFormat<T extends BaseEntity, M1 extends HashMap<String, Object>>{
	
	public  String getKeyName(T entity) {
		return entity.getClass().getSimpleName().toLowerCase();
	}
	
	/**
	 * 对象装化为json字符串
	 * @param entity
	 * @return HashMap<String, JSONString>
	 */
	public   M1  entityToJSONMap(T entity){
		@SuppressWarnings("unchecked")
		M1 entityMap = (M1) entity.toMap();
    	return entityMap;
	}
	
	/**
	 * 一组对象转化为json字符串
	 * @param entityList
	 * @return List<HashMap<String, JSONString>>
	 */
	public  List<M1> entitysToJSONList(List<T> entityList){
		List<M1>  tMapList = new ArrayList<>();
		for (T t : entityList) {
			M1 tMap = (M1)entityToJSONMap(t);
			tMapList.add(tMap);
		}
		return tMapList;
	}
	
	
	
}