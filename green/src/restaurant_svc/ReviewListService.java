package restaurant_svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import restaurantDAO.RestaurantDAO;
import review_dao.ReviewDAO;
import vo.ReviewBean;

public class ReviewListService {

	public int getListCount() throws Exception{
		
		int listCount = 0;
		Connection con = getConnection();
		RestaurantDAO restaurantDAO = RestaurantDAO.getInstance();
		restaurantDAO.setConnection(con);
		listCount = restaurantDAO.selectListCount();
		System.out.println("1�� ����Ʈī��Ʈ �۵�"+listCount);
		close(con);
		return listCount;
		
	}

	public ArrayList<ReviewBean> getArticleList(int page, int limit) throws Exception{
		System.out.println("��ü��¹� �޼ҵ� �۵�");
		ArrayList<ReviewBean> articleList = null;
		Connection con = getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(con);
		articleList = reviewDAO.selectArticleList(page,limit);
		
		close(con);
		return articleList;
		
	}
	public ArrayList<ReviewBean> getTitleList( ReviewBean reviewbean) throws Exception{
		System.out.println("gettitlelist Ȯ��");
		ArrayList<ReviewBean> articleList = null;
		Connection con = getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(con);
		articleList = reviewDAO.selectTitleList(reviewbean);
		System.out.println("�޼ҵ忡�� ���Ϲ����� Ȯ��="+articleList.get(0).getRtitle());
		close(con);
		return articleList;
		
	}
public ArrayList<ReviewBean> getidList(ReviewBean reviewbean) throws Exception{
		
		ArrayList<ReviewBean> articleList = null;
		Connection con = getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(con);
		articleList = reviewDAO.selectIdList(reviewbean);
		
		close(con);
		return articleList;
		
	}

}
