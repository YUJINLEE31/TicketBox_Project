package kopoland;

public class ConstValue {
	
	//������ ���� �з�
	final static int DAY_PRICE = 1, NIGHT_PRICE =2;
	//������ ����
	final static int BABY_PRICE = 0, 
					CHILD_ONEDAY_PRICE = 44000, CHILD_AFTER4_PRICE = 37000,
					TEEN_ONEDAY_PRICE = 47000, TEEN_AFTER4_PRICE = 40000, 
					ADULT_ONEDAY_PRICE = 56000, ADULT_AFTER4_PRICE = 46000, 
					OLD_ONEDAY_PRICE = 44000, OLD_AFTER4_PRICE = 37000; 
	
	//�ֹε�Ϲ�ȣ �Ǿ��ڸ� ����
	final static int OLD_GEN =190000000, NEW_GEN =200000000;
	//�ֹε�Ϲ�ȣ 7��° ����
	final static int MALE_OLD =1, FEMALE_OLD =2, MALE_NEW =3, FEMALE =4;	
	//������ ���(���� ���� ���̸� 1�� ����)
	final static int BEFORE_BIRTH = 1;
	
	//���̿� ���� �з�
	final static int BABY = 1, CHILD = 2, TEEN = 3, ADULT = 4, OLD = 5;
	//���̿� ���� ����
	final static int MIN_BABY = 1, MAX_BABY = 2, 
					MIN_CHILD = 3, MAX_CHILD = 12, 
					MIN_TEEN = 13, MAX_TEEN = 18, 
					MIN_ADULT = 19, MAX_ADULT = 64,
					MIN_OLD = 65;
			
	//�����׿� ���� �з�
	final static int No_DC = 1, 
					DISABLE_DC = 2, 
					MERIT_DC = 3, 
					MULTICHILD_DC = 4, 
					PREGNANT_DC = 5;

	//�����׿� ���� ������
	final static double DISABLE_DC_RATE = 0.6, 
						MERIT_DC_RATE = 0.5, 
						MULTICHILD_DC_RATE = 0.8, 
						PREGNANT_DC_RATE = 0.85;

	//�ֹ��� 
	final static int MIN_COUNT = 1, MAX_COUNT = 10;
			
	//�ֹ� ��� ����
	final static int CONTINUE = 1, EXIT =2;
		

}
