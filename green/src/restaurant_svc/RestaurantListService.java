package restaurant_svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import member.License_DAO;
import restaurantDAO.RestaurantDAO;
import vo.DTO_AD;


public class RestaurantListService {
	
	//���ǰ˻� ��� �ִ��� ���� ���� Ȯ���� ������ ����� ������ ���� �۾�
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
		listCount = boardDAO.selectListCount();
		close(con);
		return listCount;
		
	}

	public ArrayList<DTO_AD> getArticleList(int page, int limit,DTO_AD dto) throws Exception{
	    System.out.println("getArticlea�޼ҵ� ���");
		ArrayList<DTO_AD> articleList = null;
		Connection con = getConnection();
		RestaurantDAO restaurantDAO = RestaurantDAO.getInstance();
		restaurantDAO.setConnection(con);
		articleList = restaurantDAO.selectArticleList(page,limit,dto);
		System.out.println("���Ϲ��� readcount"+articleList.get(0).getReadcount());
		close(con);
		return articleList;
		
	}

}
