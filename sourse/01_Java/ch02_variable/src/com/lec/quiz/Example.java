package com.lec.quiz;

public class Example {
	public static void main(String[] args) {
		//����, ����, ���� ���� �Ҵ�
		int kor = 100;
		int eng = 90;
		int mat = 88;
		//����, ���
		int tot = kor + eng + mat;
		double avg = tot / 3. ;   
		//double�� ���� ���� : ����� �Ҽ����� �����Ƿ� 8byte�� ������ double �� ��� 
		//������ ���
		System.out.println("���� : "+kor+"\t���� : "+eng+"\t���� : "+mat);
		System.out.printf("���� : %d\t��� : %.2f\n", tot, avg);	
	}
}


/*����, ����, ���� ������ ������ �Ҵ��ϰ� �� ������ ����ϰ� 
����, ��� ����ϴ� ���α׷��� ���� �Ͻÿ�
(com.lec.ex��Ű������ �ۼ��� Example.java�� yisy0703@naver.com���� ���� �߼� �Ͻÿ�).*/


