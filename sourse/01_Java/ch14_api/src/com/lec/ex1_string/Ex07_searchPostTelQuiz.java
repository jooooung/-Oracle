//<���� ��ȭ��ȣ ���ڸ��� �˻��ϰ� ������ ��ȭ��ȣ ��ü�� ����ϱ�, ���� ��ȣ�̸� ���� ��ȣ��� ����ϱ�>
package com.lec.ex1_string;

import java.util.Scanner;

public class Ex07_searchPostTelQuiz {
	public static void main(String[] args) {
		String[] tels = {"010-9999-9999", "010-8888-8888", "010-7777-8888", "010-6666-8888"};
		Scanner scanner = new Scanner(System.in);
		while(true) {
			boolean searchOk = false;    //�˻��� ����� ������ true
			System.out.print("�˻��ϰ��� �ϴ� ��ȭ��ȣ ���ڸ��� ?(����� x)");
			String searchTel = scanner.next();
			if(searchTel.equalsIgnoreCase("x"))
				break;
			for(int i=0 ; i<tels.length ; i++) {
	//			int idx = tels[i].lastIndexOf("-");
	//			String postTel = tels[0].substring(idx+1;)
	//					System.out.println(i+"��° ���ڸ� : " + postTel);
				String postTel = tels[i].substring(tels[i].lastIndexOf("-")+1);
				if(postTel.equals(searchTel)) {
					System.out.println("�˻��Ͻ� ��ȭ��ȣ�� " + tels[i]);
					searchOk = true; // ��ȭ��ȣ ��¿���
				}//if
			}//for
			if(! searchOk) {
				System.out.println("�˻��Ͻ� ��ȭ��ȣ ���ڸ��� �����ϴ�");
			}//if
		}//while
	}///main
}//class
