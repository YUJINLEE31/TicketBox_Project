package kopoland;

import java.util.Calendar;

public class Processing {

	//나이 계산
	int calcAge (String resiNum) {
				
		int customerYear = 0, customerMonth = 0, customerDay = 0,
			currentYear = 0, currentMonth = 0, currentDay = 0;
		int customerID7 = 0, //주민등록번호 앞 7자리
			customerID9 = 0, //9자리로 변형
			age = 0; //만나이
				
		//주민등록번호로 생년월일 추출
		customerID7 = Integer.parseInt(resiNum);
		
		if (customerID7 % 10 == ConstValue.MALE_OLD || customerID7 % 10 == ConstValue.FEMALE_OLD) {
			customerID9 = customerID7 + ConstValue.OLD_GEN;
		} else {
			customerID9 = customerID7 + ConstValue.NEW_GEN;
		}
	
		customerID9 /= 10;
		customerDay = customerID9 % 100; 
		customerID9 /= 100;
		customerMonth = customerID9 % 100; 
		customerID9 /= 100;
		customerYear = customerID9; 
		
		//현재 년월일 추출
		Calendar c = Calendar.getInstance();
		currentYear = c.get(Calendar.YEAR);
		currentMonth = c.get(Calendar.MONTH) + 1; //Calendar.MONTH는 1월이 0, 2월이 1이기 때문에 +1
		currentDay = c.get(Calendar.DATE);
		
		//만나이 계산
		if ( (customerMonth < currentMonth) || 
				(customerMonth == currentMonth && customerDay <= currentDay) ) {
			age = currentYear - customerYear;  //발권일이 생일 이후(생일포함)라면 그대로
		} else {  
			age = currentYear - customerYear - ConstValue.BEFORE_BIRTH; //생일 도래 전이면 1세를 감산
		}
		
		
		return age;				
	}
	
	//연령구분
	int ageGroup(dataClass dc) {
		int ageGroup = 0;
		if (dc.age <= ConstValue.MAX_BABY) {
			ageGroup = ConstValue.BABY;
			
		} else if (dc.age <= ConstValue.MAX_CHILD) {
			ageGroup = ConstValue.CHILD;
			
		} else if (dc.age <= ConstValue.MAX_TEEN) {
			ageGroup = ConstValue.TEEN;
			
		} else if (dc.age <= ConstValue.MAX_ADULT) {
			ageGroup = ConstValue.ADULT;
			
		} else { 
			ageGroup = ConstValue.OLD;			
		}		
		
		return ageGroup;
	}
	
	//티켓 원가
	int ticketPrice(dataClass dc) {
		int ticketPrice = 0;
		if (dc.ageGroup == ConstValue.BABY) {
			ticketPrice = ConstValue.BABY_PRICE;
			dc.str_ageGroup = "유아";
			dc.str_ticketType = "유아(무료)";			
		}
		else if (dc.ageGroup == ConstValue.CHILD && dc.ticketType == ConstValue.DAY_PRICE ) {
			ticketPrice = ConstValue.CHILD_ONEDAY_PRICE;
			dc.str_ageGroup = "소인";
			dc.str_ticketType = "주간권";
		}
		else if (dc.ageGroup == ConstValue.CHILD && dc.ticketType ==  ConstValue.NIGHT_PRICE ) {
			ticketPrice = ConstValue.CHILD_AFTER4_PRICE;
			dc.str_ageGroup = "소인";
			dc.str_ticketType = "야간권(16시~)";
		} 
		else if (dc.ageGroup == ConstValue.TEEN && dc.ticketType == ConstValue.DAY_PRICE ) {
			ticketPrice = ConstValue.TEEN_ONEDAY_PRICE;
			dc.str_ageGroup = "청소년";
			dc.str_ticketType = "주간권";
		}
		else if (dc.ageGroup == ConstValue.TEEN && dc.ticketType ==  ConstValue.NIGHT_PRICE ) {
			ticketPrice = ConstValue.TEEN_AFTER4_PRICE;
			dc.str_ageGroup = "청소년";
			dc.str_ticketType = "야간권(16시~)";
		}
		else if (dc.ageGroup == ConstValue.ADULT && dc.ticketType == ConstValue.DAY_PRICE ) {
			ticketPrice = ConstValue.ADULT_ONEDAY_PRICE;
			dc.str_ageGroup = "대인";
			dc.str_ticketType = "주간권";
		}
		else if (dc.ageGroup == ConstValue.ADULT && dc.ticketType ==  ConstValue.NIGHT_PRICE ) {
			ticketPrice = ConstValue.ADULT_AFTER4_PRICE;
			dc.str_ageGroup = "대인";
			dc.str_ticketType = "야간권(16시~)";
		} 
		else if (dc.ageGroup == ConstValue.OLD && dc.ticketType == ConstValue.DAY_PRICE ) {
			ticketPrice = ConstValue.OLD_ONEDAY_PRICE;
			dc.str_ageGroup = "경로";
			dc.str_ticketType = "주간권";
		}
		else if (dc.ageGroup == ConstValue.OLD && dc.ticketType ==  ConstValue.NIGHT_PRICE ) {
			ticketPrice = ConstValue.OLD_AFTER4_PRICE;
			dc.str_ageGroup = "경로";
			dc.str_ticketType = "야간권(16시~)";
		}		
		
		dc.list_ageGroup.add(dc.str_ageGroup);
		dc.list_ticketType.add(dc.str_ticketType);
		dc.list_ticketPrice.add(ticketPrice);
		return ticketPrice;
	}

	//우대할인 적용가
	int calcDiscout(dataClass dc) {
		int DC_Price = 0;
		if ( dc.ticketAdvantage == ConstValue.No_DC ) {
			DC_Price =  dc.ticketPrice;
			dc.str_ticketAdvantage = "해당없음";
			
		} else if (  dc.ticketAdvantage == ConstValue.DISABLE_DC ) {
			DC_Price = (int)( dc.ticketPrice * ConstValue.DISABLE_DC_RATE);
			dc.str_ticketAdvantage = "장애인";
			
		} else if (  dc.ticketAdvantage == ConstValue.MERIT_DC ) {
			DC_Price = (int)( dc.ticketPrice * ConstValue.MERIT_DC_RATE);
			dc.str_ticketAdvantage = "국가유공자";
			
		} else if (  dc.ticketAdvantage == ConstValue.MULTICHILD_DC ) {
			DC_Price = (int)( dc.ticketPrice * ConstValue.MULTICHILD_DC_RATE);
			dc.str_ticketAdvantage = "다자녀가정";
			
		} else if (  dc.ticketAdvantage == ConstValue.PREGNANT_DC ) {
			DC_Price = (int)( dc.ticketPrice * ConstValue.PREGNANT_DC_RATE);
			dc.str_ticketAdvantage = "임산부";
			
		}
		
		dc.list_ticketAdvantage.add(dc.str_ticketAdvantage);
		dc.list_DC_Price.add(DC_Price);
		return DC_Price;
	}
	
	//우대할인 적용가 * 주문량
	int calcTotalPrice(dataClass dc) {
		int totalPrice = 0;
		
		totalPrice = ( dc.DC_Price * dc.ticketCount );
				
		dc.list_totalPrice.add(totalPrice);
		return totalPrice;
	}

	
	
}