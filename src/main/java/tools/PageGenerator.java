package tools;

/**
 * 分页器
 * @author janke
 *
 */
public class PageGenerator {

	// 每页条数
	private int numPerPage;
	// 到达页
	private int currentPage;

	public PageGenerator(int numPerPage){
		setNumPerPage(numPerPage);
	}

	public void setNumPerPage(int numPerPage){
		this.numPerPage = numPerPage;
	}
	
	public int getNumPerPage(){
		return numPerPage;
	}

	
	public void setCurrentPage(int currentPage){
		this.currentPage = currentPage;
	}
	
	public int getCurrentPage(){
		return currentPage;
	}
	
	public int getStartIndex(int page){
			int start = (page - 1) * numPerPage;
			return start;
	}
}
