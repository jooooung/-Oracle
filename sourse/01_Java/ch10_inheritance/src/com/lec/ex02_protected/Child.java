package com.lec.ex02_protected;
//private i, j //public setI(), getI(), setJ(), getJ()  ��ӹ���
public class Child extends SuperIJ{
	private int total;
	public Child() {
		super();
		System.out.println("�Ű����� ���� child ������ �Լ�");
	}
	public Child(int i, int j) {  // ���� ���� : super �̿�
		super(i, j); //���� Ŭ������ �Ű����� �ִ� ������ ȣ��
		System.out.println("�Ű����� �ִ� child ������ �Լ� - i, j �ʱ�ȭ");
//		setI(i); 
//		this.i = i; //�����̺��̸� ��� �Ұ�, ������Ƽ��� ��� ����
//		setJ(j); 
//		this.j = j; //�����̺��̸� ��� �Ұ�, ������Ƽ��� ��� ����
	}
	public void sum() {
//		total = getI() + getJ();
		total = i + j;
		System.out.println("i = "+ getI() + ", j= " + getJ() + ", total =" + total);
	}
}
