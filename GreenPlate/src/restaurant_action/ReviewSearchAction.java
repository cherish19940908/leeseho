package restaurant_action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import review_svc.ReviewListService;
import vo.ActionForward;
import vo.ReviewBean;
import vo.PageInfo;
import action.Action;

 public class ReviewSearchAction implements Action {
	  
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		  System.out.println("2번 ReviewSearchAction 페이지 ");
		  
		    ReviewBean reviewBean = new ReviewBean();
		    String search = (String) request.getParameter("searchvalues");
			String keyword = (String) request.getParameter("keyword");
			
		  System.out.println(search);
		   reviewBean.setSearch(search);
		   reviewBean.setKeyword(keyword);
 
		ArrayList<ReviewBean> articleList=new ArrayList<ReviewBean>();
		ReviewListService reviewListService = new ReviewListService();
	
		
		if(search.equals("title")) {
		System.out.println("tite 확인");
		articleList = reviewListService.getTitleList(reviewBean);
		System.out.println("reviewsearchaction페이지에서 리턴받은 값 확인="+articleList.get(0).getRtitle());
		}
		else{
		articleList = reviewListService.getidList(reviewBean);
			
			
		}

		request.setAttribute("searchList", articleList);
		ActionForward forward= new ActionForward();
   		forward.setPath("/board1.jsp");
   		return forward;
   		
	 }
	 
 }