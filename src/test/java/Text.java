import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import entity.Contacter;
import entity.Groups;
import service.GroupsServiceImpl;
import tools.PageGenerator;

public class Text {

	@Autowired
	PageGenerator pageGenerator;
	
	
	public static void main(String[] args) {
		GroupsServiceImpl groupsServiceImpl = new GroupsServiceImpl();
		Groups group = groupsServiceImpl.get(1);

		List<Contacter> contacterList =  groupsServiceImpl.getByPage(group, 1, 5);
		for (Contacter contacter : contacterList) {
			System.out.println(contacter.getName());
		}
	}
}
