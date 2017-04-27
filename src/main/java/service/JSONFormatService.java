package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Contacter;
import entity.Groups;
import tools.DataFormat;

@Service
public class JSONFormatService {
	
	@Autowired
	DataFormat<Contacter, HashMap<String,Object>> contacterFormatService;
	
	@Autowired
	DataFormat<Groups, HashMap<String,Object>> groupsFormatService;
	
		
	public HashMap<String , Object> getContacterDetails(Contacter contacter){
		Set<Groups> groupsSet = contacter.getGroupList();
		List<Groups> groupList = new ArrayList<Groups>(groupsSet);
		HashMap<String, Object> contacterJsonMap = contacterFormatService.entityToJSONMap(contacter);
		List<HashMap<String, Object>> groupsJsonList = groupsFormatService.entitysToJSONList(groupList);
		contacterJsonMap.put(Groups.class.getSimpleName().toLowerCase(), groupsJsonList);
		HashMap<String, Object> response = new HashMap<String, Object>();
		response.put(Contacter.class.getSimpleName().toLowerCase(), contacterJsonMap);
		return response;
	}
	
	public HashMap<String , Object> getGroupDetails(Groups groups){
		Set<Contacter> contacterSet = groups.getContacterList();
		List<Contacter> contacterList = new ArrayList<Contacter>(contacterSet);
		HashMap<String, Object> groupsJsonMap = groupsFormatService.entityToJSONMap(groups);
		List<HashMap<String, Object>> contacterJsonList = contacterFormatService.entitysToJSONList(contacterList);
		groupsJsonMap.put(Contacter.class.getSimpleName(), contacterJsonList);
		HashMap<String, Object> response = new HashMap<String, Object>();
		response.put(Groups.class.getSimpleName().toLowerCase(), groupsJsonMap);
		return response;
	}
	
}
