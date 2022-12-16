package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ex05_FriendArrayList2 {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("ȫ�浿", "010-9999-9999"));
		friends.add(new Friend("�̱浿", "010-1111-9999", new Date(new GregorianCalendar(1998, 0, 1).getTimeInMillis())));
		friends.add(new Friend("���浿", "02-222-9999"));
		for (int i=0 ; i<friends.size() ; i++) {
			System.out.println(friends.get(i));
		}
		Scanner sc = new Scanner(System.in);
		while(true) {
			boolean searchOk = false;
			System.out.println("�˻��ϰ��� �ϴ� ��ȭ��ȣ ���ڸ�(���� : x)");
			String searchTel = sc.next();
			if (searchTel.equalsIgnoreCase("x")) 
				break;
			for(Friend friend : friends) {
				String tel = friend.getTel();
				String postTel = tel.substring(tel.lastIndexOf("-")+1);
				if(searchTel.equals(postTel)) {
					System.out.println(friend);
					searchOk = true;
				}
			}//for
			if(! searchOk) {
				System.out.println("�˻��Ͻ� ��ȭ��ȣ ���ڸ��� �����ϴ�");
			}
		}
	}
}
