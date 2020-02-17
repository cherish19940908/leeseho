package member;

import static db.JdbcUtil.*;
import java.sql.Connection;
import member.License_DAO;

public class License_service {
//사업자 테이블에 전달받은 아이디가 있는지 확인하기위해 License_DAO페이지로 보내주는 페이지
	public boolean isArticleWriter(String id) throws Exception {
		boolean isArticleWriter = false;
		Connection con = getConnection();
		License_DAO reviewDAO = License_DAO.getInstance();
		reviewDAO.setConnection(con);
		isArticleWriter = reviewDAO.isArticleBoardWriter(id);
		close(con);
		return isArticleWriter;

	}

}
