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
		
		RestaurantWriteProService reviewWriteProService = new RestaurantWriteProService();
		boolean isWriteSuccess = reviewWriteProService.registArticle(dto);
		System.out.println(isWriteSuccess);
		if(!isWriteSuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
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