package com.lec.Quiz_array;
//76,45,34,89,100,50,90,92  
//8���� ���� 1���� �迭�� �ʱ�ȭ �ϰ� �̵� ������ ũ�� ������ ��Ÿ���� ���α׷��� �ۼ� �Ͻÿ�.
public class Quiz4 {
	public static void main(String[] args) {
		int [] num = {76, 45, 34, 89, 100, 50, 90, 93};
		int i, j;
		int temp;
		for(i=0 ; i<num.length ; i++) {
			for(j=i+1 ; j<num.length ; j++) {
				if(num[i] > num[j]) {
				temp = num[i];
				num[i] = num[j];
				num[j] = temp;
				}
			}//for-j
		}//for-i
		for (int k : num) {
			System.out.print(k + " ");
		}//Ȯ��for
	}//main
}
