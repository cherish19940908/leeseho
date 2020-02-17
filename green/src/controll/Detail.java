package controll; //db구문연결 처리 -> 웹페이지 연결

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;
import model.DTO;


public class Detail implements CommandInter {
	static Detail impl = new Detail();
	public static Detail instance() {
		return impl;

	}
	
	

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		Action model = Action.instance();
		Integer pnum = (Integer.parseInt(request.getParameter("pnum")));
		ArrayList<DTO> list = (ArrayList<DTO>)model.select_detail(pnum);
		request.setAttribute("data", list);
		System.out.println("bb"+list.size());
		return "party_info.jsp";
	

	}


}
