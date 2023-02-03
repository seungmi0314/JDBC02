package edu.kh.jdbc.common;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class CreateXMLFile {

	public static void main(String[] args) {
		
	
		// XML (eXtensible Markup Language) : 단순화된 데이터 기술 형식
		// 자바에서 만드는거 아니고 외부에서 만드는 거
		// 공공데이터 기관에서 정보 (날씨같은거)(외부파일) 얻어 올 때 XML 파일로 주는 경우 많음
		
		// XML에 저장되는 데이터 형식은 Map : <K:V> 형식
		// Key 와 Value가 전부 String으로 제한되어 있음
		// Map<String, String>
		
		// 컬렉션 객체중에 map이라는게 있는데 그 후손중에 어쩌고가 있는데 그게 xml파일을 읽는데 특화됨
		
		// * Properties 컬렉션 객체 * 이게 위에 그 어쩌고
		// - Map의 후손 클래스
		// - Key, Value 모두 String(문자열)형식
		// - XML 파일을 읽고, 쓰는데 특화된 메서드 제공
		
		
		try {
			Scanner sc = new Scanner(System.in);
			
			// Properties 객체 생성
			Properties prop = new Properties();
			
			System.out.print("생성할 파일 이름 : ");
			String fileName = sc.nextLine();

			// 입력 한 명칭으로 파일을 만들어내겠다
			// FileOutPutStream 생성
			// 파일명.xml
			
			FileOutputStream fos = new FileOutputStream(fileName + ".xml");
			
			// Properties 객체를 이용해서 XML 파일 생성
			prop.storeToXML(fos, fileName + ".xml file");
		
			System.out.println(fileName + ".xml 파일 생성 완료");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		
		
	} //
} ///
