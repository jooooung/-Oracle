package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Ex02_lottoNo {
	public static void main(String[] args) {
//		HashSet<Integer> lotto = new HashSet<Integer>();
		TreeSet<Integer> lotto = new TreeSet<Integer>();   // TreeSet : �����͸� ������������ ����
		Random random = new Random();
		int i=0;
		while(lotto.size()<6) {
			lotto.add(random.nextInt(45)+1);
			i++;
		}
		System.out.println(i + "�� ���� �ζ� ��ȣ : " + lotto);
	}
}
