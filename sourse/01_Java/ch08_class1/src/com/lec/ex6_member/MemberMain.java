/*Member member = new Member(��aaa��, ��xxx��, ��ȫ�浿��, ��hong@company.com��,
                                        ������ ��������, ��2000-01-01��, ��M��);
                   System.out.println(member.infoString() );
*/
package com.lec.ex6_member;

public class MemberMain {
	public static void main(String[] args) {
		Member member = new Member("aaa", "***", "ȫ�浿", "hong@company.com",
                "���� ������", "01-01", '��');
			System.out.println(member.infoString() );
	}
}
