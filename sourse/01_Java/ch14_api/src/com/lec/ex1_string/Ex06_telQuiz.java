//<����. �ݺ������� ��ȭ��ȣ�� �Է¹޾� ������ ���� ������ ����ϴ� �ݺ������� �����Ͻÿ�. ��ȭ��ȣ ��� x�� �Է��ϸ� �����մϴ�>
/*String tel;
while(){
  // ��ȣ(031-234-5678)�Է� �ϸ� (sc.next())
	"�Է��� ��ȭ��ȣ : 031-234-5678
	 ¦����° ���ڿ�  : 0 1 2 4 5 7
	���ڸ� ���ٷ�    : 8765-432-130
	��ȭ��ȣ �Ǿ��ڸ���: 031
	��ȭ��ȣ ���ڸ���: 5678"�� sysout
  // x(X)�� �Է��ϸ� ���α׷� ��
}*/
package com.lec.ex1_string;

import java.util.Scanner;

public class Ex06_telQuiz {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("��ȭ��ȣ�� �Է����ּ���(����� x)");
			String tel = scanner.next();
			if(tel.equalsIgnoreCase("x"))
				break;
			System.out.println("�Է��� ��ȭ��ȣ : " +tel);
			for(int i=0 ; i<tel.length() ; i++) {
				tel.charAt(i)
				System.out.println("¦����° ���ڿ� : " +)
			}
			System.out.println("���ڸ� ���ٷ� : " +
			
			System.out.println("��ȭ��ȣ �� �� �ڸ��� : " +
			System.out.println("��ȭ��ȣ ���ڸ��� : " +
			
			
		}
	}
}
