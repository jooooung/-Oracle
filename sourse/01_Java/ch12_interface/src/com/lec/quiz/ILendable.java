package com.lec.quiz;

public interface ILendable {
	public byte STATE_BOOROWED = 1; //������
	public byte STATE_NORMAL = 0;   //���Ⱑ��
	public void checkOut(String borrower, String checkOutDate); //����
	public void checkIn();		// �ݳ�
	public void printState(); 	// "å��ȣ å�̸�(����) ���Ⱑ�ɿ���"  ���
}
