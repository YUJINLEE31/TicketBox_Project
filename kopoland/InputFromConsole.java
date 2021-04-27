package kopoland;

import java.util.Scanner;

public class InputFromConsole {
	
	Scanner scanner = null; //Scanner 선언하고 초기화
	
	InputFromConsole() { //생성자(객체가 생성될 때 호출되는 메소드)
		scanner = new Scanner(System.in); //Scanner 생성
	}
	
	protected void finalize() { //소멸자
		scanner.close(); //Scanner 소멸(종료)
	}
/*
	public String getBookingdate() {
		String bookingDate;
		System.out.print("예약일을 입력하세요.(예시: 20210505)\n");
		bookingDate = scanner.nextLine();
	
		return bookingDate;
	}
*/	
	public int getTicketType() {
		int ticketType;
		do {
			System.out.print("권종을 선택하세요.\n1.주간권\n2.야간권(16시~)\n");
			ticketType = scanner.nextInt();
		     
		} while(  !(ticketType == ConstValue.DAY_PRICE || ticketType == ConstValue.NIGHT_PRICE));
		return ticketType;
	}
	
	public String getResidentNum() {
		String resiNum = "";
		
		do {
			System.out.print("주민등록번호 앞 7자리를 입력하세요 (예시: 9012301)\n");
			resiNum = scanner.next();
						
		} while ( resiNum.length() != 7 || resiNum.contains("-") || resiNum.contains(".") 
				|| Integer.parseInt(resiNum.substring(2, 4)) > 12 ||
				Integer.parseInt(resiNum.substring(4, 6)) > 31 ||
				Integer.parseInt(resiNum.substring(6,7)) > 4 ||
				Integer.parseInt(resiNum.substring(6,7)) == 0); 
					
		return resiNum;
	}

	public int getTicketCount() {
		int ticketCount;
		do {
			System.out.print("몇 개를 주문하시겠습니까? (최대 10개)\n");
	        ticketCount = scanner.nextInt();
		} while( ticketCount < ConstValue.MIN_COUNT || ticketCount > ConstValue.MAX_COUNT );
		
		return ticketCount;
	}
	
	public int getTicketAdvantage() {
		int ticketAdvantage;
		do {
			System.out.print("우대사항을 선택하세요.\n1.해당없음\n2.장애인\n3.국가유공자\n4.다자녀가정\n5.임산부\n");
	        ticketAdvantage = scanner.nextInt();
		} while ( ticketAdvantage < ConstValue.No_DC || ticketAdvantage > ConstValue.PREGNANT_DC );
		
		return ticketAdvantage;
	}
		
	public int getContinue() {
		int menuContinue;
		do {
	        System.out.print("계속 발권하시겠습니까?\n1.계속 티켓 발권\n2.종료\n");
	        menuContinue = scanner.nextInt();
		} while ( !(menuContinue == ConstValue.CONTINUE || menuContinue == ConstValue.EXIT) );
		return menuContinue;
	}
/*	
	public int finalgetContinue() {
		int menuContinue;
		do {
	        System.out.print("계속 진행할까요? \n1.새로운 주문\n2.프로그램 종료\n");
	        menuContinue = scanner.nextInt();
		} while ( !(menuContinue == ConstValue.CONTINUE || menuContinue == ConstValue.EXIT) );
		return menuContinue;
	}
*/
}


	
