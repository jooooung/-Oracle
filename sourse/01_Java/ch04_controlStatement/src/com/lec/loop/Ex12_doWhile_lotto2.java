package com.lec.loop;

import java.util.Scanner;

//��ǻ�Ͱ� �߻��ϴ� �ζ� ���� ���߱�
public class Ex12_doWhile_lotto2 {   
	public static void main(String[] args) {
		int lotto, su;  //��ǻ�� �ζ� ��ȣ�� ����ڷκ��� �Է¹��� ��
		int min=1, max=45;   //�ּڰ� �ִ밪 
		Scanner sc = new Scanner(System.in);
		lotto = (int)(Math.random()*45+1);   //�ζǹ�ȣ
		do {
			System.out.printf("�ζ� ��ȣ �� ���� ���纸����(%d~%d) : ", min, max);
			su = sc.nextInt();       //�ζ� ��ȣ�� ���ߴ� �Է�ĭ
			if(su < min || su>max) {
				System.out.println("�־��� ������ �����ϼ���");         //���� ���� ���� �Է� ��
			}else if(su>lotto) {           
				max = su-1;                //�Է��� ���� 1 ���� ���� ���� �˷��ֱ�
				//System.out.println("�Է��� ������ �۽��ϴ�");
			} else if(su<lotto) {
				min = su+1;      //�Է��� ���� 1 ū ���� ���� �˷��ֱ�
				System.out.println("�Է��� ������ Ů�ϴ�");
			}
		}while(su != lotto);                //su �� lotto �� �ٸ��� �ٽ� �Ͽ���
		System.out.println("���������ϴ�");
		sc.close();
	}
}

// || : �Ǵ�
