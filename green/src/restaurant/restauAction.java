package restaurant; //������������ ���񽺷� ����


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import mybatis.SqlMapConfig;
import vo.DTO_AD;
import resdat.resdatDTO;

public class restauAction {
	static restauAction model = new restauAction();

	public static restauAction instance() {
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	
	
	public List<resdatDTO>  selectlistmasjip() { // 평점 베스트 10으로 평점과 식당번호(rnum)을 들고오기 위함
		List<resdatDTO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectmasjip");
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	
	public List<resdatDTO>  selectlistmasjipkor() { // 한식 평점 베스트 10으로 평점과 식당번호(rnum)을 들고오기 위함
		List<resdatDTO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectmasjipkor");
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	public List<resdatDTO>  selectlistmasjipchn() { // 한식 평점 베스트 10으로 평점과 식당번호(rnum)을 들고오기 위함
		List<resdatDTO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectmasjipchn");
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	public DTO_AD  selectRestau(int rnum) {  // 평점 베스트10에서 식당정보 들고 오기 위한 메소드 rnum으로 식당정보
		DTO_AD list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectOne("selectRestau",rnum);
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}

	
	
	public resdatDTO  selectResdat(int rnum) {  // 평점 베스트10에서 식당정보 들고 오기 위한 메소드 rnum으로 식당정보
		resdatDTO list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectOne("selectResdat",rnum);
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	




}
