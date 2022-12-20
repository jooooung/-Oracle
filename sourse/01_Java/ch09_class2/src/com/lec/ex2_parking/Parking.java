//���� ��ȣ, �����ð�, �����ð�, ���

package com.lec.ex2_parking;

import com.lec.constant.Constant;

public class Parking {
	private String no;
	private int inTime;
	private int outTime;
	private int fee;
//	private final int HOURLYPARKINGRATE = 2000; //final ������ ���� �Ұ����� ���� ����
	public Parking() {}
	public Parking(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
	}
	public Parking(String no, int inTime, int outTime, int fee) {
		this.no = no;
		this.inTime = inTime;
		this.outTime = outTime;
		this.fee = (outTime-inTime)*1000;
	}
	public String inTimeString() {
		return String.format("%s�� �������\n �����ð� :%d��", no, inTime);
	}
	public String outTimeString() {
		return String.format("%s�� �ȳ��� ������\n �����ð� :%d��\n �����ð�:%d��\n ������� :%d��\n", no, inTime, outTime, (outTime-inTime)*Constant.HOURLYPARKINGRATE);
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public int getInTime() {
		return inTime;
	}
	public void setInTime(int inTime) {
		this.inTime = inTime;
	}
	public int getOutTime() {
		return outTime;
	}
	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
}
