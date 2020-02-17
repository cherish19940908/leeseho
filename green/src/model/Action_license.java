package model; //웹페이지에서 서비스로 연결

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class Action_license {
	
	static Action_license model = new Action_license();
	public static Action_license instance(){
		return model;
	}


	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public List<DTO> select(String cate){
		
		System.out.println("4번 select메소드 실행"+cate);
		List<DTO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("select",cate);
		System.out.println("aa"+list.size());
		sqlSession.close();
		return list;
	}
   public List<DTO> select_detail(Integer pnum){
		
	
		List<DTO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("select_detail",pnum);
		System.out.println("aa"+list.size());
		sqlSession.close();
		return list;
	}
	
	public void insert(LicenseDTO dto){
		System.out.println("4");
		System.out.println(dto.getId());
		System.out.println(dto.getLicense());
		SqlSession sqlSession = factory.openSession();
		sqlSession.selectList("insert_license",dto);
		sqlSession.commit();	
		sqlSession.close();
		
		
	}
	
	public void DeleteSangpum(DTO dto){
		SqlSession sqlSession = factory.openSession();
		sqlSession.selectList("delete",dto);
		sqlSession.commit();	
		sqlSession.close();
		
	}
	
	public void UpdateSangpum(DTO dto){
		SqlSession sqlSession = factory.openSession();
		sqlSession.selectList("update",dto);
		sqlSession.commit();	
		sqlSession.close();
		
	}
	public Integer Listcount(){
	    System.out.println("2번 action.java파일 listcount 메소드 실행");
		SqlSession sqlSession = factory.openSession();
		Integer i =sqlSession.selectOne("listcount");
		sqlSession.commit();	
		sqlSession.close();	    
		return i;
	}

}
