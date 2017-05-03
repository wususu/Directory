package service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import entity.BaseEntity;
import entity.Contacter;
import entity.Groups;
import tools.DataFormat;

@Service
@Transactional
public class JSONFormatService {
	
	@Autowired
	DataFormat<Contacter, HashMap<String,Object>> contacterFormatService;
	
	@Autowired
	DataFormat<Groups, HashMap<String,Object>> groupsFormatService;
	

	
	/**
	 * 联系人详细信息
	 * @param contacter
	 * @return
	 */
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
	
	/**
	 * 小组详细信息
	 * @param groups
	 * @return
	 */
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
	
	/**
	 * 获取JSON格式的联系人列表
	 * @param contactersList
	 * @return HashMap<"contacter_list", List<HashMap<contacter, HashMap<String, String>>>>
	 */
	public HashMap<String, Object> formatContactersListToJSON(List<Contacter> contactersList){
		HashMap<String, Object> response = new HashMap<String, Object>();
		List<HashMap<String, Object>> contactersJSONList =  contacterFormatService.entitysToJSONList( contactersList);
		response.put("contacter_list", contactersJSONList);
		return response;
	}
	
	public HashMap<String, Object> getErrorMessage(String errorInfo) {
			HashMap<String, Object> errorMsg = new HashMap<String, Object>();
			errorMsg.put("error_info", errorInfo);
			return errorMsg;
	}
	
}
