package com.lec.ex2_parking;

public class ParkingMain {
	public static void main(String[] args) {
		Parking car1 = new Parking("111��1111", 6);
		Parking car2 = new Parking("222��2222", 8);
		car1.setOutTime(8);
		car2.setOutTime(9);
		System.out.println(car1.inTimeString());
		System.out.println(car1.outTimeString());
		System.out.println(car2.inTimeString());
		System.out.println(car2.outTimeString());

		Parking car3 = new Parking("333��3333", 9);
		car3.setOutTime(11);
		System.out.println(car3.inTimeString());
		System.out.println(car3.outTimeString());
	}
}
