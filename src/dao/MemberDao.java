package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.MemberDTO;
import mybatis.config.DBService;

public class MemberDao {

	private SqlSessionFactory factory;
	
	private static MemberDao instance;
	private MemberDao() {
		factory = DBService.getInstance().getFactory();
	}
	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	
	// 1. 학생 목록
	public List<MemberDTO> selectAllMeber() {
		SqlSession ss = factory.openSession();
		List<MemberDTO> list = ss.selectList("dao.member.selectAllMember");  // mapper's namespace + id
		ss.close();
		return list;
	}
	
	// 2. 전체 학생 수
	public int getTotalCount() {
		SqlSession ss = factory.openSession();
		int totalCount = ss.selectOne("dao.member.getTotalCount");
		ss.close();
		return totalCount;
	}
	
	// 3. 전체 학생 평균
	public double getAverage() {
		SqlSession ss = factory.openSession();
		double average = ss.selectOne("dao.member.getAverage");
		ss.close();
		return average;
	}
	
	// 4. 학생 등록
	public int insertMember(MemberDTO member) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.member.insertMember", member);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	// 5. 학생 삭제
	public int deleteMember(String no) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.member.deleteMember", no);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	// 6. 학생 정보 조회
	public MemberDTO selectMemberByno(String no) {
		SqlSession ss = factory.openSession();
		MemberDTO member = ss.selectOne("dao.member.selectMemberByno", no);
		ss.close();
		return member;
	}
	
	// 7. 학생 수정
	public int updateMember(MemberDTO member) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.member.updateMember", member);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	// 8. Top3 목록 반환
	public List<MemberDTO> selectTop3List() {
		SqlSession ss = factory.openSession();
		List<MemberDTO> top3List = ss.selectList("dao.member.selectTop3List");
		ss.close();
		return top3List;
	}
	
}