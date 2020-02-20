package restaurant_svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import member.License_DAO;
import restaurantDAO.RestaurantDAO;
import vo.DTO_AD;


public class RestaurantListService {
	
	//조건검색 결과 있는지 없는 먼저 확인후 없으면 경고문구 보내기 위한 작업
	public boolean findcondition(DTO_AD dto) throws Exception {
		boolean findResult = false;
		Connection con = getConnection();
		RestaurantDAO restaurantDAO = RestaurantDAO.getInstance();
		restaurantDAO.setConnection(con);
		findResult = restaurantDAO.findcondition(dto);
		close(con);
		return findResult;

	}


	public int getListCount(DTO_AD dto) throws Exception{
		System.out.println("1");
		System.out.println("getListCount"+dto.getRnum());
		int listCount = 0;
		Connection con = getConnection();
		RestaurantDAO boardDAO = RestaurantDAO.getInstance();
		boardDAO.setConnection(con);
		listCount = boardDAO.selectListCount(dto);
		close(con);
		return listCount;
		
	}

	public ArrayList<DTO_AD> getArticleList(int page, int limit,DTO_AD dto) throws Exception{
	    System.out.println("getArticlea메소드 출력");
		ArrayList<DTO_AD> articleList = null;
		Connection con = getConnection();
		RestaurantDAO restaurantDAO = RestaurantDAO.getInstance();
		restaurantDAO.setConnection(con);
		articleList = restaurantDAO.selectArticleList(page,limit,dto);
		System.out.println("리턴받은 readcount"+articleList.get(0).getReadcount());
		close(con);
		return articleList;
		
	}

}
