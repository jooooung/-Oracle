//�� ���� ���
package com.lec.ex2_date;

import java.util.Date;
import java.util.GregorianCalendar;

public class Ex03_term {
	public static void main(String[] args) {
		Date now = new Date();  //����
		Date checkOut = new Date(new GregorianCalendar(2022, 10, 28).getTimeInMillis());  //������� 
		long nowMillis = now.getTime();    // 1970.1.1 ~ now������ �и�����
		long checkMillis = checkOut.getTime(); //1970. 1. 1 ~ checkOut ������ �и�����
		
//		GregorianCalendar now = new GregorianCalendar();  // ����
//		long nowMillis =now.getTimeInMillis();   //now.getTimeInMillis()�� 1970�� 1�� 1�� ���� now ������ �и�����
//		GregorianCalendar checkOut = new GregorianCalendar(2022, 10, 28, 9, 30);  // �������
//		long checkMillis = checkOut.getTimeInMillis(); //checkOut.getTimeInMillis(); ��   1970�� 1�� 1�� ���� checkOut ������ �и�����
		
		int day = (int)((nowMillis - checkMillis)/(1000*60*60*24));    //(1000*60*60*24)  �и�����->��->��->��   
//		//nowMillis, checkMillis �� 8byte �̱⿡ int�� ����ȯ
		System.out.println("���� ������ : " + day);
	}
}


//(now - checkOut) ����� �� �Ǿ� -> 1970�� 1�� 1�� ���� now ������ �и����� - 1970�� 1�� 1�� ���� check ������ �и��������� ���