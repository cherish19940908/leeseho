package controll; //db�������� ó�� -> �������� ����

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;
import party.Preview;
import restaurant_svc.ReviewListService;
import vo.DTO_AD;
import vo.PageInfo;


public class NavSearch implements partyCommandInter {
	static NavSearch impl = new NavSearch();

	public static NavSearch instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("navsearch시작");
        String [] navloca = request.getParameterValues("location");
        String [] navtype = request.getParameterValues("type");
        String [] navprice = request.getParameterValues("price");
       
       DTO_AD dtoad = new DTO_AD();
       dtoad.setNavloca(navloca);
       dtoad.setNavtype(navtype);
       dtoad.setNavprice(navprice);
    
       String [] t1 = dtoad.getNavloca();
       for (int i = 0; i < t1.length; i++) {
		System.out.println(t1[i]);
	}
       
       int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("page")==null){
			page=1;
		}
		
		ReviewListService reviewListService = new ReviewListService();
		int listCount=reviewListService.getListCount();
       
		int maxPage=(int)((double)listCount/limit+0.95); //0.95�� ���ؼ� �ø� ó��.
   		//���� �������� ������ ���� ������ ��(1, 11, 21 ��...)
   		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//���� �������� ������ ������ ������ ��.(10, 20, 30 ��...)
   	        int endPage = startPage+10-1;

   		if (endPage> maxPage) endPage= maxPage;

   		PageInfo pageInfo = new PageInfo();
   		pageInfo.setEndPage(endPage);
   		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);	
		request.setAttribute("pageInfo", pageInfo);
		
		
		Action model = Action.instance();
		ArrayList<DTO_AD> list = (ArrayList<DTO_AD>) model.navsearch(dtoad);
		request.setAttribute("articleList", list);
		System.out.println("bb" + list.size());
		System.out.println("navsearch끝");
		return "searchpage.jsp";
	}

	@Override
	public String inseParty(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String seleParty(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selelistParty(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selePartyre(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selelistPartyre(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Preview> selelistPreview(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insePreview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String inseApply(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean seleApply(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String license(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String search(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
