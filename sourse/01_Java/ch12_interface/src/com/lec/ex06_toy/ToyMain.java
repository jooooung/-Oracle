package com.lec.ex06_toy;

public class ToyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PoohToy pooh = new PoohToy();
		MazingerToy mazinger = new MazingerToy();
		AirPlaneToy airplane = new AirPlaneToy();
		IToy[] toy = {pooh, mazinger, airplane};
		for(IToy t : toy) {
			//��ü�� Ŭ���� �̸� ���
			System.out.println(t.getClass().getName());
		}
	}
}
