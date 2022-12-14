//������ : ���, �̸�,
//�μ�(COMPUTER, PLANNING, DESIGN, ACCOUNTING, HUMANRESOURCES), �Ի���.
package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class QuizSawon2 {
	private String sawonNo;
	private String name;
	private Dept depart;
	private Date hireday;

	public QuizSawon2(String sawonNo, String name, Dept depart) {
		this.sawonNo = sawonNo;
		this.name = name;
		this.depart = depart;
		hireday = new Date();
	}
	public QuizSawon2(String sawonNo, String name, Dept depart, int y, int M, int d) {
		this.sawonNo = sawonNo;
		this.name = name;
		this.depart = depart;
		hireday = new Date(new GregorianCalendar(y, M-1, d).getTimeInMillis());
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy, MM, dd");
		return "[���]" + sawonNo + "\t[�̸�]" + name + "\t[�μ�]" + depart + "\t[�Ի���]" + sdf.format(hireday);
	}
}