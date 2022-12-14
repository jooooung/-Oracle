package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex06_SimpleDateFormat {
	public static void main(String[] args) {
		Date nowDate = new Date();
		Calendar nowCal = Calendar.getInstance();
		GregorianCalendar nowGc = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��(E) a hh�� m��");
		System.out.println(sdf.format(nowDate));
		String dateStr = sdf.format(nowDate);
		String calStr = sdf.format(nowCal.getTime());    
		//nowCal�� ������ format�� Date���� �;ߵǱ⿡ nowCal.getTime()�̿��Ͽ� Calendar�� Date������ ��ȯ
		String gcStr = sdf.format(nowGc.getTime());
		System.out.println(dateStr);
		System.out.println(calStr);
		System.out.println(gcStr);
	}
}

/* yyyy(�⵵ 4�ڸ�), yy(�⵵ 2�ڸ�), MM(��,02), M(��, 2), dd(�� 07), d(�� 7)
	E(����), a(����/����), H(24��), h(12��). m(��), s(��)
	w(�̹��⵵�� ���° ������) W(�̹� ���� ���° ������) D(������ ���° ��) */