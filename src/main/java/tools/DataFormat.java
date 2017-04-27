package tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
public class DataFormat<T extends BaseEntity, M1 extends HashMap<String, Object>>{
	
	public static  <T> String getKeyName(T entity) {
		return entity.getClass().getSimpleName().toLowerCase();
	}
	
	public static  <T> String getKeyName(Class<T> entity) {
		return entity.getSimpleName().toLowerCase() + "_list";
	}
	
	public   M1  entityToJSONMap(T entity){
		@SuppressWarnings("unchecked")
		M1 entityMap = (M1) entity.toMap();
    	return entityMap;
	}
	
	public  List<M1> entitysToJSONList(List<T> tList){
		List<M1>  tMapList = new ArrayList<>();
		for (T t : tList) {
			M1 tMap = (M1)entityToJSONMap(t);
			tMapList.add(tMap);
		}
		return tMapList;
	}
	
	
	
}