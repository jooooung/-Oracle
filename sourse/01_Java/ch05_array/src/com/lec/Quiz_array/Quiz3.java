package com.lec.Quiz_array;
//�Ž����� 2680�� 500, 100, 50, 10¥�� �������� �� ��, ��� �־�� �ϳ�?
//��Ʈ :  coinUnit[i] + ���� ; �� + money/coinUnit[i]      
//money = money%coinUnit[i];
public class Quiz3 {
	public static void main(String[] args) {
		int money = 2680;
		int [] coinUnit = {500, 100, 50, 10};
		System.out.println(money+"����");
		for(int i=0 ; i<coinUnit.length ; i++) {
			System.out.println(coinUnit[i] + "�� = " + money/coinUnit[i] + "��");
			money %= coinUnit[i];
		}
	}
}
