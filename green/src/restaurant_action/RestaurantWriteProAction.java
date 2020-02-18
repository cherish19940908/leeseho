package restaurant_action;

import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import restaurant_svc.RestaurantWriteProService;
import vo.ActionForward;
import vo.DTO_AD;
import action.Action;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class RestaurantWriteProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{

		ActionForward forward=null;
		DTO_AD dto = null;
		String realFolder="";
		String saveFolder="/restaurantUpload";
		int fileSize=5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder=context.getRealPath(saveFolder);   		
		MultipartRequest multi=new MultipartRequest(request,
				realFolder,
				fileSize,
				"UTF-8",
				new DefaultFileRenamePolicy());
	
		dto = new DTO_AD();
		dto.setId(multi.getParameter("id"));
		dto.setName(multi.getParameter("name"));
		dto.setEmail(multi.getParameter("email"));
		dto.setCell(multi.getParameter("cell"));
		dto.setType(multi.getParameter("type"));
		dto.setStore(multi.getParameter("store_name"));
		dto.setPrice(multi.getParameter("price"));
		dto.setHome(multi.getParameter("home"));
		dto.setContent(multi.getParameter("content"));
		dto.setPostnum(multi.getParameter("postnum"));
		dto.setDethome(multi.getParameter("dethome"));	
		dto.setReadcount(0);
		dto.setFile(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		String local = multi.getParameter("home");
		System.out.println(local);
		if (local.contains("서울")==true) {
			local="서울";
			dto.setLocation(local);
		}else if (local.contains("경기")==true) {
			local="경기";
			dto.setLocation(local);
		}else if (local.contains("인천")==true) {
			local="인천";
			dto.setLocation(local);
		}else if (local.contains("강원")==true) {
			local="강원";
			dto.setLocation(local);
		}else if (local.contains("대전")==true) {
			local="대전";
			dto.setLocation(local);
		}else if (local.contains("세종특별자치시")==true) {
			local="세종";
			dto.setLocation(local);
		}else if (local.contains("충남")==true) {
			local="충남";
			dto.setLocation(local);
		}else if (local.contains("충북")==true) {
			local="충북";
			dto.setLocation(local);
		}else if (local.contains("부산")==true) {
			local="부산";
			dto.setLocation(local);
		}else if (local.contains("울산")==true) {
			local="울산";
			dto.setLocation(local);
		}else if (local.contains("경남")==true) {
			local="경남";
			dto.setLocation(local);
		}else if (local.contains("경북")==true) {
			local="경북";
			dto.setLocation(local);
		}else if (local.contains("대구")==true) {
			local="대구";
			dto.setLocation(local);
		}else if (local.contains("광주")==true) {
			local="광주";
			dto.setLocation(local);
		}else if (local.contains("전남")==true) {
			local="전남";
			dto.setLocation(local);
		}else if (local.contains("전북")==true) {
			local="전북";
			dto.setLocation(local);
		}else if (local.contains("제주특별자치도")==true) {
			local="제주";
			dto.setLocation(local);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		RestaurantWriteProService reviewWriteProService = new RestaurantWriteProService();
		boolean isWriteSuccess = reviewWriteProService.registArticle(dto);
		System.out.println(isWriteSuccess);
		if(!isWriteSuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('��Ͻ���')");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("gpindex.jsp");
		}

		return forward;
		
	}  	
	
}