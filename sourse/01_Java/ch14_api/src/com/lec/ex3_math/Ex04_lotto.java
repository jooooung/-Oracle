package com.lec.ex3_math;

import java.util.Random;

//0<= Math.random() < 1 : �Ǽ� 
//0<= Math.random()*45 <45 : �Ǽ�
//1<= (int)(Math.random()*45+1) <46 : 1~45������ ����
public class Ex04_lotto {
	public static void main(String[] args) {
		int[] lotto = new int[6];      //lotto 6�ڸ� �� �����
		int i, j;
		int temp;    //���� ����
		Random random = new Random();
		for(i=0 ; i<lotto.length ; i++) {
			do { //�߻��� ������ �ߺ��Ǿ����� üũ
				temp = random.nextInt(45)+1;	//temp = (int)(Math.random()*45+1); 
				for(j=0 ; j<i ; j++) {    
					if(lotto[j] == temp) {
						break;
					} // if - temp�� ���� ��ȣ�� ������ for���� ��������.
				}
			}while(i != j);
			lotto[i] = temp;
		}
		//�߻��� �ζ� ��ȣ ��� (20.33�� 20.45�� �Ȱ��� 20���� �ߺ�)
		for(int l : lotto) {
			System.out.print(l + "\t");
		}
		System.out.println("\n��������");
		//lotto �迭 ���� sort(���� ������ ���ʴ��)
		for(i=0 ; i<lotto.length-1 ; i++) {
			for(j=i+1 ; j<lotto.length ; j++) {
			 if(lotto[i] > lotto[j]) {
				 temp = lotto[i];
				 lotto[i] = lotto[j];
				 lotto[j] = temp;
			 		}//if i>j
			 	}//for-j
			}//for-i
		for(int l : lotto) {
			System.out.print(l + "\t");
		}
	}//main
}//class
