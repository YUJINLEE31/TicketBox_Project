package kopoland;

import java.util.Calendar;

public class Processing {

	//���� ���
	int calcAge (String resiNum) {
				
		int customerYear = 0, customerMonth = 0, customerDay = 0,
			currentYear = 0, currentMonth = 0, currentDay = 0;
		int customerID7 = 0, //�ֹε�Ϲ�ȣ �� 7�ڸ�
			customerID9 = 0, //9�ڸ��� ����
			age = 0; //������
				
		//�ֹε�Ϲ�ȣ�� ������� ����
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
		
		//���� ����� ����
		Calendar c = Calendar.getInstance();
		currentYear = c.get(Calendar.YEAR);
		currentMonth = c.get(Calendar.MONTH) + 1; //Calendar.MONTH�� 1���� 0, 2���� 1�̱� ������ +1
		currentDay = c.get(Calendar.DATE);
		
		//������ ���
		if ( (customerMonth < currentMonth) || 
				(customerMonth == currentMonth && customerDay <= currentDay) ) {
			age = currentYear - customerYear;  //�߱����� ���� ����(��������)��� �״��
		} else {  
			age = currentYear - customerYear - ConstValue.BEFORE_BIRTH; //���� ���� ���̸� 1���� ����
		}
		
		
		return age;				
	}
	
	//���ɱ���
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
	
	//Ƽ�� ����
	int ticketPrice(dataClass dc) {
		int ticketPrice = 0;
		if (dc.ageGroup == ConstValue.BABY) {
			ticketPrice = ConstValue.BABY_PRICE;
			dc.str_ageGroup = "����";
			dc.str_ticketType = "����(����)";			
		}
		else if (dc.ageGroup == ConstValue.CHILD && dc.ticketType == ConstValue.DAY_PRICE ) {
			ticketPrice = ConstValue.CHILD_ONEDAY_PRICE;
			dc.str_ageGroup = "����";
			dc.str_ticketType = "�ְ���";
		}
		else if (dc.ageGroup == ConstValue.CHILD && dc.ticketType ==  ConstValue.NIGHT_PRICE ) {
			ticketPrice = ConstValue.CHILD_AFTER4_PRICE;
			dc.str_ageGroup = "����";
			dc.str_ticketType = "�߰���(16��~)";
		} 
		else if (dc.ageGroup == ConstValue.TEEN && dc.ticketType == ConstValue.DAY_PRICE ) {
			ticketPrice = ConstValue.TEEN_ONEDAY_PRICE;
			dc.str_ageGroup = "û�ҳ�";
			dc.str_ticketType = "�ְ���";
		}
		else if (dc.ageGroup == ConstValue.TEEN && dc.ticketType ==  ConstValue.NIGHT_PRICE ) {
			ticketPrice = ConstValue.TEEN_AFTER4_PRICE;
			dc.str_ageGroup = "û�ҳ�";
			dc.str_ticketType = "�߰���(16��~)";
		}
		else if (dc.ageGroup == ConstValue.ADULT && dc.ticketType == ConstValue.DAY_PRICE ) {
			ticketPrice = ConstValue.ADULT_ONEDAY_PRICE;
			dc.str_ageGroup = "����";
			dc.str_ticketType = "�ְ���";
		}
		else if (dc.ageGroup == ConstValue.ADULT && dc.ticketType ==  ConstValue.NIGHT_PRICE ) {
			ticketPrice = ConstValue.ADULT_AFTER4_PRICE;
			dc.str_ageGroup = "����";
			dc.str_ticketType = "�߰���(16��~)";
		} 
		else if (dc.ageGroup == ConstValue.OLD && dc.ticketType == ConstValue.DAY_PRICE ) {
			ticketPrice = ConstValue.OLD_ONEDAY_PRICE;
			dc.str_ageGroup = "���";
			dc.str_ticketType = "�ְ���";
		}
		else if (dc.ageGroup == ConstValue.OLD && dc.ticketType ==  ConstValue.NIGHT_PRICE ) {
			ticketPrice = ConstValue.OLD_AFTER4_PRICE;
			dc.str_ageGroup = "���";
			dc.str_ticketType = "�߰���(16��~)";
		}		
		
		dc.list_ageGroup.add(dc.str_ageGroup);
		dc.list_ticketType.add(dc.str_ticketType);
		dc.list_ticketPrice.add(ticketPrice);
		return ticketPrice;
	}

	//������� ���밡
	int calcDiscout(dataClass dc) {
		int DC_Price = 0;
		if ( dc.ticketAdvantage == ConstValue.No_DC ) {
			DC_Price =  dc.ticketPrice;
			dc.str_ticketAdvantage = "�ش����";
			
		} else if (  dc.ticketAdvantage == ConstValue.DISABLE_DC ) {
			DC_Price = (int)( dc.ticketPrice * ConstValue.DISABLE_DC_RATE);
			dc.str_ticketAdvantage = "�����";
			
		} else if (  dc.ticketAdvantage == ConstValue.MERIT_DC ) {
			DC_Price = (int)( dc.ticketPrice * ConstValue.MERIT_DC_RATE);
			dc.str_ticketAdvantage = "����������";
			
		} else if (  dc.ticketAdvantage == ConstValue.MULTICHILD_DC ) {
			DC_Price = (int)( dc.ticketPrice * ConstValue.MULTICHILD_DC_RATE);
			dc.str_ticketAdvantage = "���ڳడ��";
			
		} else if (  dc.ticketAdvantage == ConstValue.PREGNANT_DC ) {
			DC_Price = (int)( dc.ticketPrice * ConstValue.PREGNANT_DC_RATE);
			dc.str_ticketAdvantage = "�ӻ��";
			
		}
		
		dc.list_ticketAdvantage.add(dc.str_ticketAdvantage);
		dc.list_DC_Price.add(DC_Price);
		return DC_Price;
	}
	
	//������� ���밡 * �ֹ���
	int calcTotalPrice(dataClass dc) {
		int totalPrice = 0;
		
		totalPrice = ( dc.DC_Price * dc.ticketCount );
				
		dc.list_totalPrice.add(totalPrice);
		return totalPrice;
	}

	
	
}