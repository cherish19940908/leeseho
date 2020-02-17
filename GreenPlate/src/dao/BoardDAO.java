package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import vo.BoardBean;
import vo.ReviewBean;

public class BoardDAO {

	DataSource ds;
	Connection con;
	private static BoardDAO boardDAO;

	private BoardDAO() {
		// TODO Auto-generated constructor stub
	}

	public static BoardDAO getInstance(){
		if(boardDAO == null){
			boardDAO = new BoardDAO();
		}
		return boardDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}

	//글의 개수 구하기.
	public int selectListCount() {
         System.out.println("DAO에 selectlistcount 작동 ");
		int listCount= 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			System.out.println("getConnection");
			pstmt=con.prepareStatement("select count(*) from qnaboard");
			rs = pstmt.executeQuery();

			if(rs.next()){
				listCount=rs.getInt(1);
			}
		}catch(Exception ex){

		}finally{
			close(rs);
			close(pstmt);
		}

		return listCount;

	}

	//글 목록 보기.	
	public ArrayList<BoardBean> selectArticleList(int page,int limit){
         System.out.println("DAO selctArticleList 작동");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_list_sql="select * from qnaboard order by qref desc,qseq asc limit ?,10";
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		BoardBean board = null;
		int startrow=(page-1)*10; //읽기 시작할 row 번호..	
	
		try{
			pstmt = con.prepareStatement(board_list_sql);
		pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println("1");
				board = new BoardBean();
				board.setQnum(rs.getInt("qnum"));
				board.setNick(rs.getString("nick"));
				board.setQpass(rs.getString("qpass"));
				board.setQtitle(rs.getString("qtitle"));
				board.setQcontent(rs.getString("qcontent"));
				board.setQfile(rs.getString("qfile"));
				board.setQref(rs.getInt("qref"));
	            board.setQlev(rs.getInt("qlev"));
				board.setQseq(rs.getInt("qseq"));
				board.setReadcount(rs.getInt("readcount"));
				board.setDate(rs.getDate("date"));
				articleList.add(board);
			}
			System.out.println("ll"+ articleList.size());
			

		}catch(Exception ex){
			System.out.println(ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return articleList;

	}
	
	public ArrayList<BoardBean> selectTitleList(BoardBean reviewbean){
        System.out.println("selectTtitleList 메소드 작동");
        System.out.println(reviewbean.getKeyword());
        String key = reviewbean.getKeyword();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_list_sql="select * from qnaboard where qtitle = ?";
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		BoardBean board = null;	
		
		try{
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setString(1,key);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				System.out.println("1");
				board = new BoardBean();
				board.setQnum(rs.getInt("qnum"));
				board.setNick(rs.getString("nick"));
				board.setQtitle(rs.getString("qtitle"));
				board.setQcontent(rs.getString("qcontent"));
				board.setQfile(rs.getString("qfile"));
				board.setQref(rs.getInt("qref"));
	            board.setQlev(rs.getInt("qlev"));
				board.setQseq(rs.getInt("qseq"));
				board.setReadcount(rs.getInt("readcount"));
				board.setDate(rs.getDate("date"));
				articleList.add(board);
			}
			
			

		}catch(Exception ex){
			System.out.println(ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return articleList;

	}

public ArrayList<BoardBean> selectIdList(BoardBean reviewbean){
	 String key = reviewbean.getKeyword();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String board_list_sql="select * from qnaboard where nick= ?";
	ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
	BoardBean board = null;
	

	try{
		pstmt = con.prepareStatement(board_list_sql);
		pstmt.setString(1,key);
		rs = pstmt.executeQuery();
        
		while(rs.next()){
			
			System.out.println("1");
			board = new BoardBean();
			board.setQnum(rs.getInt("qnum"));
			board.setNick(rs.getString("nick"));
			board.setQtitle(rs.getString("qtitle"));
			board.setQcontent(rs.getString("qcontent"));
			board.setQfile(rs.getString("qfile"));
			board.setQref(rs.getInt("qref"));
            board.setQlev(rs.getInt("qlev"));
			board.setQseq(rs.getInt("qseq"));
			board.setReadcount(rs.getInt("readcount"));
			board.setDate(rs.getDate("date"));
			articleList.add(board);
		}
		
		

	}catch(Exception ex){
		System.out.println(ex);
	}finally{
		close(rs);
		close(pstmt);
	}

	return articleList;

}

	//글 내용 보기.
	public BoardBean selectArticle(int board_num){
        System.out.println("selectArticle작동");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardBean boardBean = null;

		try{
			pstmt = con.prepareStatement(
					"select * from qnaboard where qnum = ?");
			pstmt.setInt(1, board_num);
			rs= pstmt.executeQuery();
			System.out.println(pstmt);

			if(rs.next()){
				System.out.println("작동");
				boardBean = new BoardBean();
				boardBean.setQnum(rs.getInt("qnum"));
				boardBean.setNick(rs.getString("nick"));
				boardBean.setQtitle(rs.getString("qtitle"));
				boardBean.setQcontent(rs.getString("qcontent"));
				boardBean.setQfile(rs.getString("qfile"));
				boardBean.setQref(rs.getInt("qref"));
				boardBean.setQlev(rs.getInt("qlev"));
				boardBean.setQseq(rs.getInt("qseq"));
				boardBean.setReadcount(rs.getInt("readcount"));
				boardBean.setDate(rs.getDate("date"));
			}
		}catch(Exception ex){
		}finally{
			close(rs);
			close(pstmt);
		}

		return boardBean;

	}

	//글 등록.
	public int insertArticle(BoardBean article){		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num =0;
		String sql="";
		int insertCount=0;

		try{
			pstmt=con.prepareStatement("select max(qnum) from qnaboard");
			rs = pstmt.executeQuery();
			System.out.println("insertArticle 안에 있는 try문 실행");

			if(rs.next())
				num =rs.getInt(1)+1;
			else
				num=1;

			sql="insert into qnaboard (qnum,nick,qpass,qtitle,";
			sql+="qcontent, qfile, qref,"+
					"qlev,qseq,readcount,"+
					"date,id) values(?,?,?,?,?,?,?,?,?,?,now(),?)";
			System.out.println("dfsdf");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getNick());
			pstmt.setString(3, article.getQpass());
			pstmt.setString(4, article.getQtitle());
			pstmt.setString(5, article.getQcontent());
			pstmt.setString(6, article.getQfile());
			pstmt.setInt(7, num);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);
			pstmt.setString(11, article.getId());
			insertCount=pstmt.executeUpdate();

		}catch(Exception ex){
			System.out.println(ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}

	//글 답변.
	public int insertReplyArticle(BoardBean article){
        System.out.println("insertReplyArticle 작동");
 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_max_sql="select max(qnum) from qnaboard";
		String sql="";
		int num=0;
		int insertCount=0;
		int re_ref=article.getQref();
		int re_lev=article.getQlev();
		int re_seq=article.getQseq();

		try{
			System.out.println(board_max_sql);
			pstmt=con.prepareStatement(board_max_sql);
			rs = pstmt.executeQuery();
			if(rs.next())num =rs.getInt(1)+1;
			else num=1;
			sql="update qnaboard set qseq=qseq+1 where qref=? ";
			sql+="and qseq>?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,re_ref);
			pstmt.setInt(2,re_seq);
			int updateCount=pstmt.executeUpdate();

			if(updateCount > 0){
				commit(con);
			}

			re_seq = re_seq + 1;
			re_lev = re_lev+1;
			sql="insert into qnaboard (qnum,nick,qpass,qtitle,";
			sql+="qcontent,qref,qlev,qseq,";
			sql+="readcount,date) values(?,?,?,?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getNick());
			pstmt.setString(3, article.getQpass());
			pstmt.setString(4, article.getQtitle());
			pstmt.setString(5, article.getQcontent());
			pstmt.setInt(6, re_ref);
			pstmt.setInt(7, re_lev);
			pstmt.setInt(8, re_seq);
			pstmt.setInt(9, 0);
			insertCount = pstmt.executeUpdate();
		}catch(SQLException ex){
			System.out.println(ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}

	//글 수정.
	public int updateArticle(BoardBean article){
      System.out.println(article.getQtitle());
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql="update qnaboard set qtitle=?,qcontent=? where qnum=?";

		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getQtitle());
			pstmt.setString(2, article.getQcontent());
			pstmt.setInt(3, article.getQnum());
			updateCount = pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println(ex);
		}finally{
			close(pstmt);
		}

		return updateCount;

	}

	//글 삭제.
	public int deleteArticle(int board_num){

		PreparedStatement pstmt = null;
		String board_delete_sql="delete from qnaboard where qnum=?";
		int deleteCount=0;

		try{
			pstmt=con.prepareStatement(board_delete_sql);
			pstmt.setInt(1, board_num);
			deleteCount=pstmt.executeUpdate();
		}catch(Exception ex){
		}	finally{
			close(pstmt);
		}

		return deleteCount;

	}

	//조회수 업데이트.
	public int updateReadCount(int board_num){
           System.out.println("updateReadCount작동");
           
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql="update qnaboard set readcount = "+
				"readcount+1 where qnum = "+board_num;

		try{
			pstmt=con.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
		}catch(SQLException ex){
		}
		finally{
			close(pstmt);

		}

		return updateCount;

	}

	//글쓴이인지 확인.
	public boolean isArticleBoardWriter(int board_num,String pass){
        System.out.println(board_num+pass);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_sql="select * from qnaboard where qnum=?";
		boolean isWriter = false;

		try{
			pstmt=con.prepareStatement(board_sql);
			pstmt.setInt(1, board_num);
			rs=pstmt.executeQuery();
			rs.next();

			if(pass.equals(rs.getString("qpass"))){
				isWriter = true;
			}
		}catch(SQLException ex){
			System.out.println(ex);
		}
		finally{
			close(pstmt);
		}

		return isWriter;

	}

}
