package com.lec.loopQuiz;
//��ǻ�Ϳ� ���������� ������ -1�� �Է��Ҷ����� ���ѹݺ��ϴ� ������ �ۼ��Ͻÿ�.
//(��, ������� 0, ������� 1, ����� 2, ���Ḧ ���ϸ� -1�� �Է��մϴ�)
import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int u, com;
		while(true) {
			System.out.print("����(0)����(1)��(2)�� �ϳ��� �Է��ϼ���(����:-1) : ");
			u = sc.nextInt();
			if(u == -1)break;
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
		}
		sc.close();
		System.out.println("end");
	}
}
