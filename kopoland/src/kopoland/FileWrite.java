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
						
			if(file.exists() == false) { //���� �ش� ������ �������� ������
				isFileExist = false; //���� isFileExist�� false
			} else { //�ش� ������ �����ϸ�
				isFileExist = true; //���� isFileExist�� true
			}
			
			fw = new FileWriter("Record the result of issuance.csv", true);				
			//FileWriter fw�� �����ϰ� ������ ������ ����, �ɼ� true�� ������ ������ �̾��, false�� �����	 
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fileClose() { //�Ҹ���(close�� ���ϸ� ��� ������ �����־ ���� �Ұ�)		
		try {
			fw.close(); //FileWriter ����
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void headerWrite() throws IOException { 		
		if(isFileExist == false) { //�ش� ������ �������� ������, ������ �� ù �ٿ� �Ʒ� �׸���� ���ش�
			String head = "��¥,����,���ɱ���,����,����,������\n";
			fw.write(head); //���Ͽ� �� �� ����
		
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
		fw.write(result); //���Ͽ� �� �� ����
		
	}	
}

