package com.lec.loop;
//i�� 1�� �� �������� 1�̴�
//i��10�� �� �������� 55�̴�
public class Ex08_while {
	public static void main(String[] args) {
		int tot = 0; //������ ����
		int i=1;
		while(i<=10) {
			tot += 1;
			System.out.printf("i�� %d�� �� �������� %d�̴�\n", i, tot);
			i++;
		//while�� ���� ������
		
		/*for(int i=1; i<=10 ; i++) {
			tot +=i;	//tot = tot + i;
			System.out.printf("i�� %d�� �� �������� %d�̴�\n", i, tot);
			for�� ���� ������*/
		}
	}
}
