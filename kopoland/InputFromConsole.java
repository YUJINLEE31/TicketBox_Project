package kopoland;

import java.util.Scanner;

public class InputFromConsole {
	
	Scanner scanner = null; //Scanner �����ϰ� �ʱ�ȭ
	
	InputFromConsole() { //������(��ü�� ������ �� ȣ��Ǵ� �޼ҵ�)
		scanner = new Scanner(System.in); //Scanner ����
	}
	
	protected void finalize() { //�Ҹ���
		scanner.close(); //Scanner �Ҹ�(����)
	}
/*
	public String getBookingdate() {
		String bookingDate;
		System.out.print("�������� �Է��ϼ���.(����: 20210505)\n");
		bookingDate = scanner.nextLine();
	
		return bookingDate;
	}
*/	
	public int getTicketType() {
		int ticketType;
		do {
			System.out.print("������ �����ϼ���.\n1.�ְ���\n2.�߰���(16��~)\n");
			ticketType = scanner.nextInt();
		     
		} while(  !(ticketType == ConstValue.DAY_PRICE || ticketType == ConstValue.NIGHT_PRICE));
		return ticketType;
	}
	
	public String getResidentNum() {
		String resiNum = "";
		
		do {
			System.out.print("�ֹε�Ϲ�ȣ �� 7�ڸ��� �Է��ϼ��� (����: 9012301)\n");
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
			System.out.print("�� ���� �ֹ��Ͻðڽ��ϱ�? (�ִ� 10��)\n");
	        ticketCount = scanner.nextInt();
		} while( ticketCount < ConstValue.MIN_COUNT || ticketCount > ConstValue.MAX_COUNT );
		
		return ticketCount;
	}
	
	public int getTicketAdvantage() {
		int ticketAdvantage;
		do {
			System.out.print("�������� �����ϼ���.\n1.�ش����\n2.�����\n3.����������\n4.���ڳడ��\n5.�ӻ��\n");
	        ticketAdvantage = scanner.nextInt();
		} while ( ticketAdvantage < ConstValue.No_DC || ticketAdvantage > ConstValue.PREGNANT_DC );
		
		return ticketAdvantage;
	}
		
	public int getContinue() {
		int menuContinue;
		do {
	        System.out.print("��� �߱��Ͻðڽ��ϱ�?\n1.��� Ƽ�� �߱�\n2.����\n");
	        menuContinue = scanner.nextInt();
		} while ( !(menuContinue == ConstValue.CONTINUE || menuContinue == ConstValue.EXIT) );
		return menuContinue;
	}
/*	
	public int finalgetContinue() {
		int menuContinue;
		do {
	        System.out.print("��� �����ұ��? \n1.���ο� �ֹ�\n2.���α׷� ����\n");
	        menuContinue = scanner.nextInt();
		} while ( !(menuContinue == ConstValue.CONTINUE || menuContinue == ConstValue.EXIT) );
		return menuContinue;
	}
*/
}


	
