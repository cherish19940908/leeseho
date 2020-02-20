package restaurant_action;

import java.io.PrintWriter;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import restaurant_svc.RestaurantListService;
import vo.ActionForward;
import vo.DTO_AD;
import vo.PageInfo;
import action.Action;

 public class RestaurantListAction implements Action {
	  
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 ActionForward forward= new ActionForward();
	
        DTO_AD dto = new DTO_AD();
        dto.setPrice(request.getParameter("price"));
        dto.setType(request.getParameter("type"));
        dto.setLocation(request.getParameter("location"));
		ArrayList<DTO_AD> articleList=new ArrayList<DTO_AD>();
	  	int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("page")==null){
			page=1;
		}
		RestaurantListService restaurantListService = new RestaurantListService();
		boolean isRightUser = restaurantListService.findcondition(dto);
		
		//리턴받은 값이 false면 경고문구를 띄우고 true면 정상적으로 조건검색 결과를 보여주도록 하기위한 작업
		if (!isRightUser) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('검색결과가 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		else {
		int listCount=restaurantListService.getListCount(dto);
	
			articleList = restaurantListService.getArticleList(page,limit,dto);
			System.out.println(articleList.get(0).getReadcount());
		//총 페이지 수.
   		int maxPage=(int)((double)listCount/limit+0.95); //0.95를 더해서 올림 처리.
   		//현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
   		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//현재 페이지에 보여줄 마지막 페이지 수.(10, 20, 30 등...)
   	        int endPage = startPage+10-1;

   		if (endPage> maxPage) endPage= maxPage;

   		PageInfo pageInfo = new PageInfo();
   		pageInfo.setEndPage(endPage);
   		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);	
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
   		forward.setPath("/searchpage.jsp");
   		
		}return forward;
	 }
	 
 }