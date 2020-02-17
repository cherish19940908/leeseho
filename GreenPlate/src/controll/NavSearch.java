package controll; //db�������� ó�� -> �������� ����

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;
import vo.DTO_AD;


public class NavSearch implements CommandInter {
	static NavSearch impl = new NavSearch();

	public static NavSearch instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("navsearch시작");
        String [] navloca = request.getParameterValues("locaion");
        String [] navtype = request.getParameterValues("type");
        String [] navprice = request.getParameterValues("price");
       DTO_AD dtoad = new DTO_AD();
       dtoad.setNavloca(navloca);
       dtoad.setNavtype(navtype);
       dtoad.setNavprice(navprice);
		Action model = Action.instance();
		ArrayList<DTO_AD> list = (ArrayList<DTO_AD>) model.navsearch(dtoad);
		request.setAttribute("articleList", list);
		System.out.println("bb" + list.size());
		System.out.println("navsearch끝");
		return "searchpage.jsp";
	}

}
