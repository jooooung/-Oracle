package com.lec.loopQuiz;
//1~10���� ���� �� ¦�� �Ǵ� Ȧ���� ���� ���غ���
public class Quiz2 {
	public static void main(String[] args) {
		int even = 0;
		int odd = 0;
		for(int i=1 ; i<=10 ; i++) {
			if(i%2==0) {
				even = even+i;
			}else {
				odd = odd+i;
			}
		}
		System.out.println("¦���� �� = " + even);
		System.out.println("Ȧ���� �� = " + odd);
	}
}
