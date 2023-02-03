package edu.kh.jdbc.model.vo;

public class TestVo {
	private int testNo;
	private String testTitle;
	private String testContent;
	
	// 기본 생성자
	public TestVo() {}
		// ctrl + space

	// 매개변수 생성자(모든 필드 초기화)
	public TestVo(int testNo, String testTitle, String testContent) {
		super();
		this.testNo = testNo;
		this.testTitle = testTitle;
		this.testContent = testContent;
	} // alt + shift + s + o

	
	
	
	// alt + shift + s + r
	public int getTestNo() {
		return testNo;
	}

	public void setTestNo(int testNo) {
		this.testNo = testNo;
	}

	public String getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	public String getTestContent() {
		return testContent;
	}

	public void setTestContent(String testContent) {
		this.testContent = testContent;
	}

	@Override
	public String toString() {
		return "TestVo [testNo=" + testNo + ", testTitle=" + testTitle + ", testContent=" + testContent + "]";
	}
		
	
	
	
}
