package review_action;

import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import review_svc.ReviewWriteProService;
import vo.ActionForward;
import vo.ReviewBean;
import action.Action;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewWriteProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{

		ActionForward forward=null;
		ReviewBean boardBean = null;
		String realFolder="";
		String saveFolder="/boardUpload";
		int fileSize=5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder=context.getRealPath(saveFolder);   		
		MultipartRequest multi=new MultipartRequest(request,
				realFolder,
				fileSize,
				"UTF-8",
				new DefaultFileRenamePolicy());
	
		boardBean = new ReviewBean();
		boardBean.setId(multi.getParameter("id"));	
		boardBean.setNick(multi.getParameter("nick"));		
		boardBean.setRpass(multi.getParameter("rpass"));
		boardBean.setRtitle(multi.getParameter("rtitle"));
		boardBean.setRcontent(multi.getParameter("rcontent"));
		boardBean.setLocation(multi.getParameter("location"));
		boardBean.setRfile(
		multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
        ReviewWriteProService reviewWriteProService = new ReviewWriteProService();
		boolean isWriteSuccess = reviewWriteProService.registArticle(boardBean);
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
			forward.setPath("reviewList.bo");
		}

		return forward;
		
	}  	
	
}