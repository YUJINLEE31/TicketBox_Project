package kopoland;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Processing {

	//나이 계산
	int calcAge (String resiNum) {
		int OLD_GEN =190000000, NEW_GEN =200000000,
				MALE_OLD =1, FEMALE_OLD =2, MALE_NEW =3, FEMALE =4,
				BEFORE_BIRTH = 2, AFTER_BIRTH = 1;
		
		String bookingDate = "" , currentDate ="";
		
		int customerYear = 0, customerMonth = 0, customerDay = 0, customerType = 0,
				bookingYear = 0, bookingMonth = 0, bookingDay = 0;
		int iresiNum = 0, ibookingDate = 0, icurrentDate = 0, customerID9 = 0, koreanAge= 0, age = 0;
				
		
		iresiNum = Integer.parseInt(resiNum);
		
		if (iresiNum % 10 == MALE_OLD || iresiNum % 10 == FEMALE_OLD) {
			customerID9 = iresiNum + OLD_GEN;
		} else {
			customerID9 = iresiNum + NEW_GEN;
		}
	
		customerType = customerID9 % 10;
		customerID9 /= 10;
		customerDay = customerID9 % 100; 
		customerID9 /= 100;
		customerMonth = customerID9 % 100; 
		customerID9 /= 100;
		customerYear = customerID9; 
		
		//예약일
//		ibookingDate = Integer.parseInt(bookingDate);
		Calendar c = Calendar.getInstance(); 
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd"); 
		currentDate = sdf.format(c.getTime());
		icurrentDate = Integer.parseInt(currentDate);
		bookingDay = icurrentDate % 100; 
		icurrentDate /= 100;
		bookingMonth = icurrentDate % 100; 
		icurrentDate /= 100;
		bookingYear = icurrentDate; 
		
		//만나이 계산
		koreanAge = bookingYear - customerYear + 1;
		if ( (customerMonth < bookingMonth) || 
				customerMonth == bookingMonth && customerDay <= bookingDay ) {
			age = koreanAge - AFTER_BIRTH;
		} else {
			age = koreanAge - BEFORE_BIRTH;
		}
		
		
		return age;		
		
	}
	
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
	
	int calcTotalPrice(dataClass dc) {
		int totalPrice = 0;
		
		totalPrice = ( dc.DC_Price * dc.ticketCount );
				
		dc.list_totalPrice.add(totalPrice);
		return totalPrice;
	}

	
	
}