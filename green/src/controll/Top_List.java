package controll; //db�������� ó�� -> �������� ����

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;
import model.DTO;
import vo.DTO_AD;
import vo.PageInfo_party;

public class Top_List implements CommandInter {
	static Top_List impl = new Top_List();

	public static Top_List instance() {
		return impl;

	}

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("toplist시작");
        String type = request.getParameter("type");
        System.out.println(type);
		Action model = Action.instance();
		ArrayList<DTO_AD> list = (ArrayList<DTO_AD>) model.toplist(type);
		request.setAttribute("articleList", list);
		System.out.println("bb" + list.size());
		System.out.println("toplist끝");
		return "searchpage.jsp";
	}

}
