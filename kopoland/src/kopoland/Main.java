package kopoland;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// String bookingDate;
		
		InputFromConsole input = new InputFromConsole(); 
		Processing pc = new Processing(); 
		dataClass dc = new dataClass();   
		Output oc = new Output();
		FileWrite fwc =new FileWrite();
		fwc.headerWrite();
		do {
			do {			
				dc.ticketType = input.getTicketType();
				dc.resiNum = input.getResidentNum();
				dc.ticketCount = input.getTicketCount();
				dc.list_ticketCount.add(dc.ticketCount);
				dc.ticketAdvantage = input.getTicketAdvantage();
				
				dc.age = pc.calcAge(dc.resiNum);	
				dc.ageGroup = pc.ageGroup(dc);					
				dc.ticketPrice = pc.ticketPrice(dc); //낱장가격	
				dc.DC_Price = pc.calcDiscout(dc); //낱장할인가격
				dc.totalPrice = pc.calcTotalPrice(dc); //낱장할인가격*주문량
						
				oc.totalPricePrint(dc);
				fwc.dataWrite(dc);
			
				dc.menuContinue= input.getContinue();
			} while (dc.menuContinue != ConstValue.EXIT);
					
			oc.ordrPrint(dc);
			dc.finalContinue = input.finalgetContinue();
		
		} while (dc.finalContinue != ConstValue.EXIT);
		fwc.fileClose();
		System.out.println("프로그램 종료. 감사합니다.");
		
	}
}
