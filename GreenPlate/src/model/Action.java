package model; //������������ ���񽺷� ����

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.DTO_AD;
import vo.ReviewBean;
import mybatis.SqlMapConfig;

public class Action {
	
	static Action model = new Action();
	public static Action instance(){
		return model;
	}


	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public List<DTO> select(String cate){
		
		System.out.println("4�� select�޼ҵ� ����"+cate);
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
	
	public void insert(DTO dto){
		System.out.println(dto.getAddr1());
		SqlSession sqlSession = factory.openSession();
		sqlSession.selectList("insert",dto);
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
	    System.out.println("2�� action.java���� listcount �޼ҵ� ����");
		SqlSession sqlSession = factory.openSession();
		Integer i =sqlSession.selectOne("listcount");
		sqlSession.commit();	
		sqlSession.close();	    
		return i;
	}
	public Integer boardListcount(){
	    System.out.println("boardListcount");
		SqlSession sqlSession = factory.openSession();
		Integer i =sqlSession.selectOne("boardlistcount");
		sqlSession.commit();	
		sqlSession.close();	    
		return i;
	}
public List<ReviewBean> locasearch(String local){
		
		System.out.println("locasearch_middle"+local);
		List<ReviewBean> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("locasearch",local);
		System.out.println("aa"+list.size());
		sqlSession.close();
		return list;
	}
public List<DTO_AD> toplist(String type){
	
	System.out.println("action도착");
	List<DTO_AD> list = null;
	SqlSession sqlSession = factory.openSession();
	list = sqlSession.selectList("topsearch",type);
	System.out.println("aa"+list.size());
	System.out.println("action끝");
	sqlSession.close();
	return list;
}
public List<DTO_AD> navsearch(DTO_AD dtoad){
	System.out.println("action도착");
	List<DTO_AD> list = null;
	SqlSession sqlSession = factory.openSession();
	list = sqlSession.selectList("navsearch",dtoad);
	System.out.println("aa"+list.size());
	System.out.println("action끝");
	sqlSession.close();
	return list;
}

}
