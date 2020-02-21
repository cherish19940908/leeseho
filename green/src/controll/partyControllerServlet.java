package controll; //����-> url ����

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class partyControllerServlet extends HttpServlet {

	@Override

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println(command);
		partyCommandInter inter = null;
		String viewName = "";
		try {
			request.setCharacterEncoding("UTF-8");
			String RequestURI = request.getRequestURI();
			String contextPath = request.getContextPath();
			String rung = RequestURI.substring(contextPath.length());

			if (rung.equals("/partyregi.do")) {

				partyService service = new partyService();
				String index = service.inseParty(request, response);
				request.getRequestDispatcher(index).forward(request, response);
			} else if (rung.equals("/partycate.do")) {
				partyService service = new partyService();
				String index = service.selelistParty(request, response);
				request.getRequestDispatcher(index).forward(request, response);

			} else if (rung.equals("/partyinfo.do")) {
				partyService service = new partyService();

				String index = service.seleParty(request, response);
				request.getRequestDispatcher(index).forward(request, response);

			}

			else if (rung.equals("/partycatere.do")) {
				partyService service = new partyService();
				String index = service.selelistPartyre(request, response);
				request.getRequestDispatcher(index).forward(request, response);

			} else if (rung.equals("/partyinfore.do")) {
				partyService service = new partyService();
				String index = service.selePartyre(request, response);
				request.getRequestDispatcher(index).forward(request, response);

			} else if (rung.equals("/partyapply.do")) {
				partyService service = new partyService();

				String index = service.inseApply(request, response);
				request.getRequestDispatcher(index).forward(request, response);

			} else if (rung.equals("/search.do")) {
				partyService service = new partyService();
				String index = service.search(request, response);
				request.getRequestDispatcher(index).forward(request, response);
			} else if (rung.equals("/license.do")) {
				partyService service = new partyService();
				String index = service.license(request, response);
				request.getRequestDispatcher(index).forward(request, response);
			} else if (command.equals("detail")) {
				inter = Detail.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			} else if (command.equals("top")) {
				System.out.println("top");
				inter = Top_List.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			} else if (command.equals("navsearch")) {
				System.out.println("navsearch");
				inter = NavSearch.instance();
				viewName = inter.showData(request, response);
				request.getRequestDispatcher(viewName).forward(request, response);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
