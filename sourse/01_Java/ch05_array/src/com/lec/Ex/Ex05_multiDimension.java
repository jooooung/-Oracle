package com.lec.Ex;
//�迭�� ��κ� 1����, cf.������ �迭
public class Ex05_multiDimension {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3}; ///1���� �迭
		System.out.println(arr[0]);
		int[][] test = {{1, 2, 3}, {4, 5, 6}} ;  //2���� �迭 
		test[0][1] = 200;     //0�� 1���� ���� 200���� ����
		//������ �迭�� ���
		for(int i=0 ; i<test.length ; i++) {  //��(i)
			for(int j=0 ; j<test[i].length ; j++) {  //��(j)
				System.out.printf("test[%d][%d] = %d\n", i, j, test[i][j]);
			}//for-j
		}//for-i
	}//main
}//class