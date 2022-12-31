//Ex05 �����ϱ�
package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import com.lec.ex4_object.Friend;

//���� ������ ģ���� ���
public class Ex08_FriendBirth {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("ȫ�浿", "010-9999-9999", "12-14", "���� ���빮"),
							 new Friend("��浿", "010-9999-3333", "12-14", "���� ����"),
							 new Friend("���ȯ", "010-9999-1111", "02-17", "���� ���"),
							 new Friend("�ź���", "010-6666-6666", "12-24", "��õ �۵�")};
		GregorianCalendar now = new GregorianCalendar();
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd");
		String today = sdf1.format(now.getTime());
		boolean none = true;
		System.out.println("���� ������ ģ�� ����� �˻��մϴ�");
		for(Friend friend : friends) {
			if(today.equals(friend.getBirth())) {
				System.out.println(friend);
				none = false;
			}
		}//for
//		for(int idx=0 ; idx<friends.length ; idx++) {
//			String birth = friends[idx].getBirth();
//			if(today.equals(birth)) {
//				System.out.println(friends[idx]);
//				none = false;         //�Ѹ� �̻� ��� �� none = false
//			}//if
//		}//for
		if(none) {
			System.out.println("���� ������ ģ���� �����ϴ�");
		}
	}//main
}//class
