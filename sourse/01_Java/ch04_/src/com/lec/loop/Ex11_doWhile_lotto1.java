package com.lec.loop;

import java.util.Scanner;

//��ǻ�Ͱ� �߻��ϴ� �ζ� ���� ���߱�
public class Ex11_doWhile_lotto1 {   
	public static void main(String[] args) {
		int lotto, su;  //��ǻ�� �ζ� ��ȣ�� ����ڷκ��� �Է¹��� ��
		Scanner sc = new Scanner(System.in);
		//0 <= Math.random()*45 < 45    : 0~45�� �Ǽ� �� ������ ���� ���
		//1 <= Math.random()*45+1 < 46       :�Ǽ�
		//1 <=(int)(Math.random()*45+1) < 46    :����
		//System.out.println((int)(Math.random()*45+1));
		lotto = (int)(Math.random()*45+1);   //�ζǹ�ȣ
		do {
			System.out.print("�ζ� ��ȣ �� ���� ���纸����(1~45) : ");
			su = sc.nextInt();       //�ζ� ��ȣ�� ���ߴ� �Է�ĭ
			if(su>lotto) {           
				System.out.println("�Է��� ������ �۽��ϴ�");
			} else if(su<lotto) {
				System.out.println("�Է��� ������ Ů�ϴ�");
			}
		}while(su != lotto);     //su �� lotto �� �ٸ��� �ٽ� �Ͽ���
		System.out.println("���������ϴ�");
		sc.close();
	}
}
