package controll; //db�������� ó�� -> �������� ����

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;
import model.DTO;
import party.Preview;


public class Detail implements partyCommandInter {
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
