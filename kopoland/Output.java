package kopoland;

public class Output {
	static String str_ticketType = "";
	
	public void totalPricePrint(dataClass dc) {
		System.out.println("������ " + dc.totalPrice + "�� �Դϴ�.\n�����մϴ�.\n");
	}

	
	public void ordrPrint(dataClass dc) {
		System.out.println("Ƽ�� �߱��� �����մϴ�. �����մϴ�.\n");	
	
		System.out.println("=====================��������======================");
		
		for (int i = 0; i < dc.list_totalPrice.size(); i++) {
			System.out.printf("%9.9s%8.8s %3s %3s %8.8s %s %8.8s %s\n", 
					dc.list_ticketType.get(i), dc.list_ageGroup.get(i), "X", 
					dc.list_ticketCount.get(i), dc.list_totalPrice.get(i), "��","*������ :", dc.list_ticketAdvantage.get(i));
			dc.PriceSum += dc.list_totalPrice.get(i);
		}	
		System.out.printf("\n--------------------------------------------------\n");
        System.out.printf("����� �Ѿ��� %d �� �Դϴ�.\n", dc.PriceSum );
        System.out.println("=================================================");
	}
}

	