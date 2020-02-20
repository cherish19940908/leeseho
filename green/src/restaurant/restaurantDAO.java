package restaurant;

import java.sql.*;
import java.util.ArrayList;

import restaurant.restaurantDTO;

public class restaurantDAO {
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost/gpteam?useSSL=false&useUnicode=true&characterEncoding=utf8";

	private final String USER_NAME = "root";
	private final String PASSWORD = "12345";

	Connection conn = null;
	Statement state = null;

	public restaurantDAO() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			System.out.println("오류가 떴어요");
		}

	}

	public void entdb() {

		try {
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("오류가 떴어요");

		}
	}



	public int write(int rnum, String id, String name, String cell, String email, String store, String postnum, String home, String dethome, String content, String type, String price, String file) {
		try {
			state = conn.createStatement(); //
			String s = "insert into restaurant(rnum,id,name,cell,email,store,postnum,home,dethome,content,type,price,file) values('"+ rnum + "','" + id + "','" + name + "','" + cell + "','" + email + "','" + store + "','" + postnum + "','" + home + "','" + dethome + "','" + content + "','" + type + "','" + price + "','" + file+"');";
			state.executeUpdate(s);
			return 0; // 입력될때
		} catch (Exception e) {
			System.out.println(e);
		}
		return -1; // 오류가 발생했을 때
	}

	public restaurantDTO getRestaurant(int rnum) {
		entdb();
		restaurantDTO rdto = null;
		try {
			state = conn.createStatement(); //
			String s = "select * from restaurant where rnum = "+ rnum +";";
			ResultSet aa = state.executeQuery(s);

			while (aa.next()) {
				rdto = new restaurantDTO();
				rdto.setRnum(aa.getInt("rnum"));
				rdto.setId(aa.getString("id"));
				rdto.setName(aa.getString("name"));
				rdto.setCell(aa.getString("cell"));
				rdto.setEmail(aa.getString("email"));
				rdto.setStore(aa.getString("store"));
				rdto.setPostnum(aa.getString("postnum"));
				rdto.setHome(aa.getString("home"));
				rdto.setDethome(aa.getString("dethome"));
				rdto.setContent(aa.getString("content"));
				rdto.setType(aa.getString("type"));
				rdto.setPrice(aa.getString("price"));
				rdto.setFile(aa.getString("file"));
				
				
			}
		} catch (Exception e) {
			System.out.println("이상이 있3");
		}

		return rdto;
	}

	public void clodb() {
		if (state != null) {
			try {
				state.close();
			} catch (Exception e) {
				System.out.println("state 파일에 이상이 있습니다.");
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("conn 파일 닫기 이상이 있습니다.");
			}

		}
	}

}
