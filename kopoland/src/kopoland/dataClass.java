package kopoland;

import java.util.ArrayList;

public class dataClass {
	int ticketType; //권종
	String resiNum; //주민등록번호 앞 7자리
	int ticketCount; //수량(주문량)
	int ticketAdvantage; //우대사항
	int menuContinue; //계속 발권 or 종료
	int finalContinue; //새로운 주문 or 프로그램 종료
	int age; //연령(만나이)
	int ageGroup; //연령구분
	int ticketPrice; //티켓 원가
	int DC_Price; //우대할인 적용가
	int totalPrice; //우대할인 적용가 * 주문량
	int PriceSum; //입장료 총액
	
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
