package com.lec.loopQuiz;
//��ǻ�Ϳ� ���������� ������ ����� �� ������ ���ѹݺ��ϴ� ������ �ۼ��Ͻÿ�.(��, ������� 0, ������� 1, ����� 2)
import java.util.Scanner;

public class Quiz6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int u, com;
		do {
			System.out.print("����(0)����(1)��(2)�� �ϳ��� �Է��ϼ��� : ");
			u = sc.nextInt();
			com = (int)(Math.random()*3);
			String comStr = (com==0) ? "����" : (com==1)?"����":"���ڱ�"; 
			String uStr = (u==0) ? "����" : (u==1)?"����":"���ڱ�"; 
			if(u<-1 || u>2) {
				System.out.println("�߸� �Է��߽��ϴ�");
			}else {
				if( (u+2)%3 == com ) {
					System.out.printf("����� %s, ��ǻ�ʹ� %s. ����� �̰��� ^.^\n", uStr, comStr);
				}else if((u+1)%3 == com){
					System.out.printf("����� %s, ��ǻ�ʹ� %s. ��ǻ�Ͱ� �̰��� ��.��\n", uStr, comStr);
				}else {
					System.out.printf("����� %s, ��ǻ�ʹ� %s. �����\n",  uStr, comStr);
				}
			}
		}while((u+2)%3 == com || u==com);	//����  u �� 1���� �̶��   ���� == com  ||   ����== com
		sc.close();
		System.out.println("end");
	}
}
