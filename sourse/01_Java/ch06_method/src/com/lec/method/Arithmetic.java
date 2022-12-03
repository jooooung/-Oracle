package com.lec.method;
// sum(int, int)  �Ű����� 2���� ����� �ݵ�� ȣ��ÿ��� 2�� ex sum(1, 2)
// sum(int)   �Լ��� �����ε� : �Ȱ��� ������ ���� �� ����(�Ű� ������ �ٸ���)
// evenOdd(n)  ¦�� Ȧ�� �Ǵ�
// abs(n)   ���밪
public class Arithmetic {
	public int sum(int from, int to) { //from~to���� ���� ���� ��(return)
		int result = 0; //��������
		for(int i=from ; i<=to ; i++) {
			result +=i;
		}
		return result;
	}//�Ű����� 2���� sum
	public int sum(int to) {
		int result = 0;
		for(int i=1 ; i<=to ; i++) {
			result += i;
		}
		return result;
	}//�Ű� ���� 1���� sum
	public String evenOdd(int value) {  //evenOdd�� ¦ Ȧ�� ����ؾ� �ϴ� String ���
		return value%2==0 ? "¦���Դϴ�" : "Ȧ���Դϴ�";  
	}//¦�� Ȧ�� �Ǵ�
	public static int abs(int value) { //���밪�� return. 
	//����������(public ��) ������ ��� ���� ��Ű�������� ��� ���� 
		int result = value>=0? value : -value;
		return result;
	}//���밪
}
