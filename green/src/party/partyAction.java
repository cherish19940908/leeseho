package party; //������������ ���񽺷� ����


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import party.PartyDTO;
import party.ApplyDTO;
import party.Preview;
import mybatis.SqlMapConfig;

public class partyAction {
	static partyAction model = new partyAction();

	public static partyAction instance() {
		return model;
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	

	public void insertParty(PartyDTO PartyDTO) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.insert("insertParty", PartyDTO);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public List<PartyDTO> selectlistParty(String cate) {
		List<PartyDTO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectlistParty",cate);
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	public List<PartyDTO> selectParty(int pnum) {
		List<PartyDTO> sic = null;
		SqlSession sqlSession = factory.openSession();
		sic = sqlSession.selectList("selectParty",pnum);
		sqlSession.close();
		return sic;
	}
	
	public List<PartyDTO> selectlistPartyre(String cate) {
		List<PartyDTO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("selectlistPartyre",cate);
		sqlSession.close();
		if(list!=null) {
		return list;
		}
		return null;
	}
	
	public List<PartyDTO> selectPartyre(int pnum) {
		List<PartyDTO> sic = null;
		SqlSession sqlSession = factory.openSession();
		sic = sqlSession.selectList("selectPartyre",pnum);
		sqlSession.close();
		return sic;
	}
	
	
	public void insertPreview(Preview preview) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.insert("insertPreview", preview);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public List<Preview> selectlistPreview(int pnum) {
		List<Preview> sic = null;
		SqlSession sqlSession = factory.openSession();
		sic = sqlSession.selectList("selectlistPreview",pnum);
		sqlSession.close();
		if(sic.size()!=0) {
			return sic;
			}
			return null;
	}
	
	public void insertApply(ApplyDTO ApplyDTO) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.insert("insertApply", ApplyDTO);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public boolean selectApply(ApplyDTO adto) {
		String psnum = null;
		SqlSession sqlSession = factory.openSession();
		psnum = sqlSession.selectOne("selectApply",adto);
		sqlSession.close();
		if(psnum !=null) {
			return true;
			}
			return false;
	}
	
	




}
