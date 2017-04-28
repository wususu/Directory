package tools;

/**
 * 分页器
 * @author janke
 *
 */
public class PageGenerator {

	// 每页条数
	private int numPerPage;
	// 总页数
	private int totalPage;
	// 总条目
	private int totalNum;

	
	public PageGenerator(int numPerPage, int totalNum) {
		// TODO Auto-generated constructor stub
		setTotalPage(totalPage);
		setTotalNum(totalNum);
		
	}
	
	public void setNumPerPage(int numPerPage){
		this.numPerPage = numPerPage;
	}
	
	public int getNumPerPage(){
		return numPerPage;
	}
	
	public void setTotalPage(int totalPage){
		this.totalPage = totalPage;
	}
	
	public int getTotalPage(){
		return totalPage;
	}
	
	public void setTotalPage(int numPerPage, int totalNum){
		long pageNum = Math.round((double)totalNum/(double)numPerPage);
		this.totalPage = (int)pageNum; 
	}
	
	public void setTotalNum(int totalNum){
		this.totalNum = totalNum;
	}
	
	public int getTotalNum(){
		return totalNum;
	}
	
	public int getStartIndex(int page){
		if (page <= totalPage) {
			int start = (page - 1) * numPerPage + 1;
			return start;
		}else {
			return (totalPage - 1) * numPerPage + 1;
		}
	}
	
	public int getEndIndex(int page){
		int end = page * numPerPage;
		if (end > totalNum) {
			end = totalNum;
		}
		return end;
	}
}
