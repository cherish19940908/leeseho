package member;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import review_svc.ReviewModifyProService;
import vo.ActionForward;
import action.Action;

public class License_action implements Action {
//���̵� ���޹޾Ƽ� License_service.java �������� ������ ���̵� ��� ����� �Ǿ����� �Ĵ��� �������� �̵��ϰ� �ƴϸ� ����ڵ���� �ȵ� �ִٰ� ������ ������
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("2��"+request.getParameter("id"));
		ActionForward forward = null;
		boolean isModifySuccess = false;
		License_service License_service = new License_service();
		boolean isRightUser = License_service.isArticleWriter(request.getParameter("id"));

		if (!isRightUser) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('사업자등록번호가 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else {

		
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("advertisement.jsp");

		}

		return forward;
	}

}