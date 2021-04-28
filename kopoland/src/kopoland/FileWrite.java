package kopoland;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileWrite {
		
	private FileWriter fw; 
	private boolean isFileExist; 
	
	public FileWrite() { 	
		try {
			File file = new File("Record the result of issuance.csv"); 
						
			if(file.exists() == false) { //만약 해당 파일이 존재하지 않으면
				isFileExist = false; //변수 isFileExist는 false
			} else { //해당 파일이 존재하면
				isFileExist = true; //변수 isFileExist는 true
			}
			
			fw = new FileWriter("Record the result of issuance.csv", true);				
			//FileWriter fw를 생성하고 오픈한 파일을 연결, 옵션 true는 실행할 때마다 이어쓰기, false는 덮어쓰기	 
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fileClose() { //소멸자(close를 안하면 계속 파일이 열려있어서 제어 불가)		
		try {
			fw.close(); //FileWriter 종료
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void headerWrite() throws IOException { 		
		if(isFileExist == false) { //해당 파일이 존재하지 않으면, 생성될 때 첫 줄에 아래 항목들을 써준다
			String head = "날짜,권종,연령구분,수량,가격,우대사항\n";
			fw.write(head); //파일에 한 줄 쓰기
		
		}		
	}
	
	public void dataWrite(dataClass dc) throws IOException { 
				
		Calendar c = Calendar.getInstance(); 
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); 
		
		String result = sdf.format(c.getTime()) + "," 
				+ dc.str_ticketType + ","  
				+ dc.str_ageGroup + "," 
				+ dc.ticketCount + ","
				+ dc.totalPrice + ","
				+ dc.str_ticketAdvantage + "\n";
		fw.write(result); //파일에 한 줄 쓰기
		
	}	
}

