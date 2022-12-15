package com.lec.ex8_decimal;

//DecimalFormat����. ���� �ڸ��� : #(������ ��� ������ ���x), 0(�ݵ�� ���)
import java.text.DecimalFormat;

public class Ex01 {
	public static void main(String[] args) {
		double number = 1234567.8787;
		DecimalFormat df = new DecimalFormat("########.####"); // 1234567.8787 �ִ� ���ڸ� ���
		System.out.println("########.####" + df.format(number));
		DecimalFormat df2 = new DecimalFormat("00000000.00000"); // 01234567.87870 ���� �ڸ��� 0���� ���
		System.out.println("00000000.00000" + df2.format(number));
		DecimalFormat df3 = new DecimalFormat("0,000.00"); 
		System.out.println("0.000.00" + df3.format(number));
		DecimalFormat df4 = new DecimalFormat("##.##%");       //%�ڸ����� �ݿø�
		System.out.println("##.##% : " + df4.format(0.78457));
		DecimalFormat df5 = new DecimalFormat("#.####E0");  //E�ڿ��� 0�� ����
		System.out.println("#.####E0 : " + df5.format(number));
	}
}
