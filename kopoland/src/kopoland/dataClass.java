package kopoland;

import java.util.ArrayList;

public class dataClass {
	int ticketType; //����
	String resiNum; //�ֹε�Ϲ�ȣ �� 7�ڸ�
	int ticketCount; //����(�ֹ���)
	int ticketAdvantage; //������
	int menuContinue; //��� �߱� or ����
	int finalContinue; //���ο� �ֹ� or ���α׷� ����
	int age; //����(������)
	int ageGroup; //���ɱ���
	int ticketPrice; //Ƽ�� ����
	int DC_Price; //������� ���밡
	int totalPrice; //������� ���밡 * �ֹ���
	int PriceSum; //����� �Ѿ�
	
	String str_ticketType;
	String str_ageGroup;
	String str_ticketAdvantage;
		
	ArrayList<String> list_ticketType = new ArrayList<String>() ; 
	ArrayList<String> list_ageGroup = new ArrayList<String>() ; 
	ArrayList<Integer> list_ticketPrice = new ArrayList<Integer>() ;    
	ArrayList<String> list_ticketAdvantage = new ArrayList<String>() ;
	ArrayList<Integer> list_DC_Price = new ArrayList<Integer>() ;  
	ArrayList<Integer> list_ticketCount = new ArrayList<Integer>() ;
	ArrayList<Integer> list_totalPrice = new ArrayList<Integer>() ;
	

}
