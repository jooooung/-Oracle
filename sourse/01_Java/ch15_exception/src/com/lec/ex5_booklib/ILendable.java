package com.lec.ex5_booklib;

public interface ILendable {
	public byte STATE_BOOROWED = 1; //������
	public byte STATE_NORMAL = 0;   //���Ⱑ��
	public void checkOut(String borrower); //���� 
	public void checkIn() throws Exception;		// �ݳ�
	
}
