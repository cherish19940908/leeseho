package controll; //db구문연결 처리 -> 웹페이지 연결

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.Action_license;
import model.LicenseDTO;

public class License_insert implements CommandInter {
	
	static License_insert impl = new License_insert();
	public static License_insert instance() {
		return impl;

	}
	
	

	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("2");
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("license"));
		request.setCharacterEncoding("utf-8");		
		Action_license model = Action_license.instance();
		LicenseDTO dto=new LicenseDTO();	
		dto.setId(request.getParameter("id"));
		dto.setLicense(request.getParameter("license"));
		
		model.insert(dto);
		
		
		return "gpindex.jsp";
	}
	




}
