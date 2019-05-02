package ChattingProgramming;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import mybatis.MySqlSession;

public class registorDAO {
	public String first_id, second_id, third_id, forth_id;
	public String first_score, second_score, third_score, forth_score;
	SqlSession session;

	public registorDAO() {
		session = MySqlSession.getSqlSession();
	}

	public boolean insert(RegistorVO vo) {
		// session.insert("���ӽ����̽���.���̵��", Object parameter);
		session.insert("registor.insert", vo);
		session.commit();
		return true;
	}
	
//	public List<RegistorVO> select() {
//		
//		RowBounds bounds = new RowBounds(0, 4);
//	
//		return session.selectList("registor.select",null, bounds);
//	
//	}
}
