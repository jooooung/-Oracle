package com.lec.ConditionQuiz;
//�� �� �� �ִ밪 ���ϱ�
public class Quiz2 {
	public static void main(String[] args) {
		int num1 = 27;         				 //ù��° �� �Է�
		int num2 = 27;     					 //�ι�° �� �Է�
		int max;							 //�� �� �� �ִ밪�� max��� ����
		if(num1 > num2) {					 //if, else�� num1�� Ŭ ��, num2�� Ŭ �� �ΰ��� ��� ����
			max = num1;
		}else {
			max = num2;
			System.out.println("�ִ밪��" + max);   //����� max�� ���
			if(num1 == num2) {
			System.out.println("�� ���� ����");
			}
		}		
	}
}
