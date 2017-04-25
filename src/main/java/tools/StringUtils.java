package tools;


public class StringUtils {

	public static String reBuildJSONString(String JSONString) {
		System.out.println(JSONString);
			String JSONString_2 = JSONString.replaceAll("\\\\", "");
			System.out.println(JSONString_2);
			return JSONString_2;
	
	}
}
