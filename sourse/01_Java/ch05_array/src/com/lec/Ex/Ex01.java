package com.lec.Ex;

public class Ex01 {
	public static void main(String[] args) {
		int i = 10;     //���� ����, �ʱ�ȭ
		//1. �迭 ���� ����, �ʱ�ȭ �ϱ�
		int[] iArr = {10, 20, 30, 40, 50};    //[] �� �迭�� �ǹ�, �迭�̹Ƿ� �������� �� ����, �ʱ�ȭ
		iArr[2] = 300;  //�迭�� index�� ����(0���� ����)
		for(int idx=0 ; idx<iArr.length ; idx++) {      //length�� �迭 ���� ����
		System.out.println(iArr[idx]);
		}
		
		//2.�迭����� �迭 ����(�޸� �Ҵ�)
		int[] iArr2 = new int[5];	//iArr2 �� �迭 ���� 5�� ����
		iArr2[0] = 10;
		for(int idx=0 ; idx<iArr2.length ; idx++) {
			System.out.printf("iArr2[%d] = %d\n", idx, iArr2[idx]);
		}
		
		//3.�迭 ���� ����
		int[] iArr3;   //���� ����
		iArr3 = new int[3];		//��� �޸� �Ҵ�
		
		//4.Ȯ�� for��
		for(int temp : iArr3) {
			System.out.println(temp);
		}
		//�迭 ���� �� ���� - �Ϲ�for��
		for(int idx=0 ; idx<iArr3.length ; idx++) {
			iArr3[idx] = 999;
		}
		for(int idx=0; idx<iArr3.length ; idx++) {
			System.out.println(idx + "��° : " + iArr3[idx]);
		}
		//�迭 ���� �� ���� - Ȯ��for��
		for(int ia : iArr3) {
			ia = 111;
		}
		for(int ia : iArr3) {
			System.out.println(ia);
		}
	}
}
