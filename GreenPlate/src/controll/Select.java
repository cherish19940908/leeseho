package controll; //db�������� ó�� -> �������� ����

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;
import model.DTO;
import vo.PageInfo_party;

public class Select implements CommandInter {
	static Select impl = new Select();
	public static Select instance() {
		return impl;

	}
	
	

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("1�� select.java ����");
		String cate = request.getParameter("cate");
		int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("page")==null){
			page=1;
		}
		
		Action model = Action.instance();
		Integer listCount = model.Listcount();
		System.out.println("3��.listcount ���Ϲ��� ��=" +listCount);
		ArrayList<DTO> list = (ArrayList<DTO>)model.select(cate);
		System.out.println("5��. select ���Ϲ�����="+list.get(0).getName());
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
		request.setAttribute("data", list);
		System.out.println("bb"+list.size());
		return "hanparty_list.jsp";
	}
	




}
