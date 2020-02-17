package controll; //db�������� ó�� -> �������� ����

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;
import vo.ReviewBean;
import vo.PageInfo_party;

public class LocaSearch implements CommandInter {
	static LocaSearch impl = new LocaSearch();
	public static LocaSearch instance() {
		return impl;

	}
	
	

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("locasearch_start");
		String local = request.getParameter("local");
		System.out.println(local);
		int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("page")==null){
			page=1;
		}
		
		Action model = Action.instance();
		Integer listCount = model.boardListcount();
		ArrayList<ReviewBean> list = (ArrayList<ReviewBean>)model.locasearch(local);
		int maxPage=(int)((double)listCount/limit+0.95); //0.95�� ���ؼ� �ø� ó��.
   		//���� �������� ������ ���� ������ ��(1, 11, 21 ��...)
   		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//���� �������� ������ ������ ������ ��.(10, 20, 30 ��...)
   	        int endPage = startPage+10-1;

   		if (endPage> maxPage) endPage= maxPage;

   		PageInfo_party pageInfo = new PageInfo_party();
   		pageInfo.setEndPage(endPage);
   		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);	
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("searchList", list);
		System.out.println("bb"+list.size());
		return "board1.jsp";
	}
	




}
