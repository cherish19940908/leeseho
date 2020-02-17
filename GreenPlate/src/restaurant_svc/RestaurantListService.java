package restaurant_svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import restaurantDAO.RestaurantDAO;
import vo.DTO_AD;


public class RestaurantListService {

	public int getListCount(DTO_AD dto) throws Exception{
		
		int listCount = 0;
		Connection con = getConnection();
		RestaurantDAO boardDAO = RestaurantDAO.getInstance();
		boardDAO.setConnection(con);
		listCount = boardDAO.selectListCount(dto);
		close(con);
		return listCount;
		
	}

	public ArrayList<DTO_AD> getArticleList(int page, int limit,DTO_AD dto) throws Exception{
		ArrayList<DTO_AD> articleList = null;
		Connection con = getConnection();
		RestaurantDAO restaurantDAO = RestaurantDAO.getInstance();
		restaurantDAO.setConnection(con);
		articleList = restaurantDAO.selectArticleList(page,limit,dto);
		
		close(con);
		return articleList;
		
	}

}
