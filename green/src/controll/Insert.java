package controll; //db�������� ó�� -> �������� ����

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.Action;
import model.DTO;

public class Insert implements CommandInter {
	static Insert impl = new Insert();
	public static Insert instance() {
		return impl;

	}
	
	

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		Action model = Action.instance();
		DTO dto=new DTO();
		
		String realFolder="";
		String saveFolder="/partyupload";
		int fileSize=5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder=context.getRealPath(saveFolder);   		
		MultipartRequest multi=new MultipartRequest(request,
				realFolder,
				fileSize,
				"UTF-8",
				new DefaultFileRenamePolicy());
		
		dto.setName(multi.getParameter("name"));
		dto.setEmail(multi.getParameter("email"));
		dto.setPhone(multi.getParameter("phone"));
		dto.setRname(multi.getParameter("rname"));
		dto.setAddno(multi.getParameter("addno"));
		dto.setAddr(multi.getParameter("addr"));
		dto.setAddr1(multi.getParameter("addr1"));
		dto.setAddr2(multi.getParameter("addr2"));
		dto.setPdate(multi.getParameter("pdate"));
		dto.setPno(multi.getParameter("pno"));
		dto.setPreprice(multi.getParameter("preprice"));
		dto.setPtalk(multi.getParameter("ptalk"));
		dto.setCate(multi.getParameter("cate"));
		dto.setTitle(multi.getParameter("title"));
		dto.setPtime(multi.getParameter("hour")+"��"+multi.getParameter("minu")+"��");
		
		dto.setFilename(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
				
		model.insert(dto);
		
		
		return "party.jsp";
	}
	




}
