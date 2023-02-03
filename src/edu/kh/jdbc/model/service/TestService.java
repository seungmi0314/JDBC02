package edu.kh.jdbc.model.service;

import java.sql.Connection;
import java.sql.SQLException;

// import static 구문
// -> static이 붙은 필드, 메서드를 호출할 때
// 클래스명을 생략할 수 있게하는 구문
// import static ... .*
import static edu.kh.jdbc.common.JDBCTemplate.*;
import edu.kh.jdbc.model.dao.TestDAO;
import edu.kh.jdbc.model.vo.TestVo;

//Service : 비즈니스 로직(데이터 가공, 트랜잭션 제어) 처리
// -> 실제 프로그램이 제공하는 기능을 모아놓은 클래스

// 하나의 Service 메서드에서 n개의 DAO 메서드(지정된 SQL 수행)를 호출하여
// 이를 하나의 트랜잭션 단위로 취급하여
// 한번에 commit, rollback을 수행할 수 있다.
// 하나라도 잘못하면 롤백 해야한다는 뜻

// * 여러 DML을 수행하지 않는 경우 (단일 DML, SELECT 등)라도
// 코드의 통일성을 지키기 위해서 Service에 작성
// -> Connection 객체 생성

public class TestService {

	private TestDAO dao = new TestDAO();

	/**
	 * 1행 삽입 서비스
	 * 
	 * @param vo1
	 * @return result
	 */
	public int insert(TestVo vo1) throws SQLException {
		// 커넥션 생성
		// Connection conn = JDBCTemplate.getConnection();
		// 클래스명.메서드명 (JDBCTemplate에서 만든 것
		Connection conn = getConnection();
		// -> 위에 static 붙여서 줄일 수 있음

		// INSERT DAO 메서드를 호출하여 수행 후 결과 반환 받기
		int result = dao.insert(conn, vo1); // 반환 값 = 행의 개수
		// result == SQL 수행 후 반영된 결과 행의 개수

		// 트랜잭션 제어
		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		// 커넥션 반환
		close(conn);

		// 결과반환
		return result;
	}

	/**
	 * 3행 삽입 서비스
	 * 
	 * @param vo1
	 * @return result
	 */
	public int insert(TestVo vo1, TestVo vo2, TestVo vo3) throws Exception {
		// 1. Connection 생성
		Connection conn = getConnection();

		int result = 0; // 1 or 0
		try {

			int result1 = dao.insert(conn, vo1);
			int result2 = dao.insert(conn, vo2);
			int result3 = dao.insert(conn, vo3);

			// 트랜잭션 제어
			if (result1 + result2 + result3 == 3) { // 모두 insert 성공 시
				commit(conn);
				result = 1;
			} else {
				rollback(conn);
				// result = 0;
			}
		} catch (SQLException e) { // dao 수행중에 예외가 발생했을때
			rollback(conn);

			// -> 실패된 데이터를 DB에 삽입하지 않음
			// -> DB에는 성공된 데이터만 저장이 된다
			// == DB에 저장된 데이터의 신뢰도가 상승~!

			// Run2 클래스로 예외 전달 할 수 있도록 예외 강제 발생
			throw new Exception("DAO 수행 중 예외 발생");

		} finally { // 무조건 conn 반환하기
			close(conn);

		}

		return 0;
	}

	/**
	 * 번호가 일치하는 행 제목, 내용 수정 서비스
	 * 
	 * @param vo
	 * @return
	 * @throws SQLException
	 */
	public int update(TestVo vo) throws SQLException {

		Connection conn = getConnection();

		int result;
		try {
			result = dao.update(conn, vo);

			if (result > 0)
				commit(conn);
			else
				rollback(conn);

		} finally { 
			close(conn);

		}

		
		return result;

	}
}
