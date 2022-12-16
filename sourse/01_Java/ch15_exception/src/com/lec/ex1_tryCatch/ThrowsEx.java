package com.lec.ex1_tryCatch;

public class ThrowsEx {
	public ThrowsEx() throws Exception{
		actionC();
	}

	private void actionC() throws IndexOutOfBoundsException{
		System.out.println("actionC ���ݺ�");
		actionB();
		System.out.println("actionC �Ĺݺ�");
	}

	private void actionB() throws IndexOutOfBoundsException{
		System.out.println("actionB ���ݺ�");
		try {
			actionA();
		} catch(IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("actionB �Ĺݺ�");
	}

	private void actionA() throws ArrayIndexOutOfBoundsException{  //���ܰ� �߻��Ǹ� �ߴ�
		System.out.println("actionA ���ݺ�");
		int[] arr = { 0, 1, 2 };
			System.out.println(arr[3]);			//�� �κп��� ���ܰ� �߻��Ͽ�
		System.out.println("actionA �Ĺݺ�");    // �� ������ ���� x
	}
}
