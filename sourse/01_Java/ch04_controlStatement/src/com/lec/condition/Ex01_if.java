package com.lec.condition;

public class Ex01_if {
	public static void main(String[] args) {
		int score = 65;
		if(score>= 90) {
			System.out.println("�� �߽��ϴ�");
		}else if(score>=70){
			System.out.println("���� �ƽ��׿�");
		}else if(score>= 60){
			System.out.println("�й��ϼ���");
		}else {
			System.out.println("������Դϴ�");
		}//if
		System.out.println("DONE");
	}
}
