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
        String [] navloca = request.getParameterValues("location");
        String [] navtype = request.getParameterValues("type");
        String [] navprice = request.getParameterValues("price");
        for (int i = 0; i < navloca.length; i++) {
			System.out.println(navloca[i]);
		}
        for (int i = 0; i < navtype.length; i++) {
			System.out.println(navtype[i]);
		}
        for (int i = 0; i < navprice.length; i++) {
			System.out.println(navprice[i]);
		}
       DTO_AD dtoad = new DTO_AD();
       dtoad.setNavloca(navloca);
       dtoad.setNavtype(navtype);
       dtoad.setNavprice(navprice);
       String [] t1=dtoad.getNavloca();
       String [] t2=dtoad.getNavtype();
       String [] t3=dtoad.getNavprice();
       
       for (int i = 0; i < t1.length; i++) {
			System.out.println(t1[i]);
		}
       for (int i = 0; i < t2.length; i++) {
			System.out.println(t2[i]);
		}
       for (int i = 0; i < t3.length; i++) {
			System.out.println(t3[i]);
		}
		Action model = Action.instance();
		ArrayList<DTO_AD> list = (ArrayList<DTO_AD>) model.navsearch(dtoad);
		request.setAttribute("articleList", list);
		System.out.println("bb" + list.size());
		System.out.println("navsearch끝");
		return "searchpage.jsp";
	}

}
