package com.lec.ex2_date;

import java.util.Calendar;
import java.util.GregorianCalendar;
import com.lec.ex4_object.Friend;

//���� ������ ģ���� ���
public class Ex05_FriendBirth {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("ȫ�浿", "010-9999-9999", "12-14", "���� ���빮"),
							 new Friend("��浿", "010-9999-3333", "12-26", "���� ����"),
							 new Friend("���ȯ", "010-9999-1111", "02-17", "���� ���"),
							 new Friend("�ź���", "010-6666-6666", "03-03", "��õ �۵�")};
		GregorianCalendar now = new GregorianCalendar();
		int month = now.get(Calendar.MONTH) + 1;  // �ý��ۻ� ���� 0���� �����ϱ⿡ +1�� ���ش�
		int day = now.get(Calendar.DAY_OF_MONTH);
		String monthStr = month<10 ? "0"+month : ""+month;   //�� ��Ʈ���� ���ؼ� month�� int���� string ���� ����ȯ
		String dayStr = day<10 ? "0"+day : ""+day;
		String today = monthStr + "-" + dayStr;
		System.out.println(today);
		boolean none = true;
		System.out.println("���� ������ ģ�� ����� �˻��մϴ�");
		for(int idx=0 ; idx<friends.length ; idx++) {
			String birth = friends[idx].getBirth();
			if(today.equals(birth)) {
				System.out.println(friends[idx]);
				none = false;         //�Ѹ� �̻� ��� �� none = false
			}//if
		}//for
		if(none) {
			System.out.println("���� ������ ģ���� �����ϴ�");
		}
	}//main
}//class
