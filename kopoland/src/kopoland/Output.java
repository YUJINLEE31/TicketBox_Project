package kopoland;

public class Output {
	static String str_ticketType = "";
	
	public void totalPricePrint(dataClass dc) {
		System.out.println("가격은 " + dc.totalPrice + "원 입니다.\n감사합니다.\n");
	}

	
	public void ordrPrint(dataClass dc) {
		System.out.println("티켓 발권을 종료합니다. 감사합니다.\n");	
	
		System.out.println("==========================폴리랜드==========================");
		
		for (int i = 0; i < dc.list_totalPrice.size(); i++) {
			System.out.printf("%9.9s%8.8s %3s %3s %8.8s %s %8.8s %s\n", 
					dc.list_ticketType.get(i), dc.list_ageGroup.get(i), "X", 
					dc.list_ticketCount.get(i), dc.list_totalPrice.get(i), "원",
					"*우대사항 :", dc.list_ticketAdvantage.get(i));
			
			dc.PriceSum += dc.list_totalPrice.get(i);
		}	
		System.out.printf("\n---------------------------------------------------------\n");
        System.out.printf("입장료 총액은 %d 원 입니다.\n", dc.PriceSum );
        System.out.println("==========================================================");
        
    	dc.list_ticketType.clear(); //배열 초기화
        dc.list_ageGroup.clear();
        dc.list_ticketCount.clear();
        dc.list_totalPrice.clear();
        dc.list_ticketAdvantage.clear();
        dc.PriceSum = 0;
	}
}

	