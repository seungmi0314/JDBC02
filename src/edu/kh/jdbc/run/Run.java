package edu.kh.jdbc.run;

import edu.kh.jdbc.model.service.TestService;
import edu.kh.jdbc.model.vo.TestVo;

public class Run {

	public static void main(String[] args) {

		TestService service = new TestService();
		
		// TB_TEST 테이블에 INSERT 수행하겠다라고하면
		// 어떤 값을 넣을까?
		TestVo vo1 = new TestVo(1, "제목1", "내용1");
		// 원래는 얘네도 런에서 하는 일은 아님
		
		// TB_TEST 테이블에 insert를 수행하는 서비스 메서드를
		// 호출 후 결과 반환받기
	
		try {
			
		
			int result = service.insert(vo1); // 1 아님 0
		
			if(result > 0) {
				System.out.println("insert 성공");
			
			} else {
			System.out.println("insert 실패");
			}
		} catch(Exception e) {
			System.out.println("SQL 수행 중 오류 발생");
			e.printStackTrace();
		}
	
	}

}
