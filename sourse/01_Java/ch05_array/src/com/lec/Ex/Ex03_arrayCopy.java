package com.lec.Ex;

public class Ex03_arrayCopy {
	public static void main(String[] args) {
		int [] score = {10, 20, 30, 40, 50};
		int [] s = new int[score.length];         //s�� score�� ����
//		for(int idx=0 ; idx<s.length ; idx++) {
//			s[idx] = score[idx];
//		}
		System.arraycopy(score, 0, s, 0, score.length);
		//(�����迭��ü, int ����������ġ, ���纻�迭��ü, int ���纻������ġ, int �������)
		s[0] = 999;
		for(int idx=0 ; idx<s.length ; idx++) {
			System.out.printf("score[%d] = %d\t s[%d] = %d\n", idx, score[idx], idx, s[idx]);
		}
	}
}
