package com.lec.ex04_actor;

public class Actor implements Chef, FireFighter, PoliceMan {
	private String name;

	public Actor(String name) {
		this.name = name;
	}

	@Override
	public void canCatchCriminal() {
		// TODO Auto-generated method stub
		System.out.println(name + "�� �������Դϴ�. ������ ����ϴ�");
	}

	@Override
	public void canSearch() {
		// TODO Auto-generated method stub
		System.out.println(name + "�� �������Դϴ�. ������ ã���ϴ�");
	}

	@Override
	public void outFire() {
		// TODO Auto-generated method stub
		System.out.println(name + "�� �ҹ���Դϴ�. ���� ���ϴ�");
	}

	@Override
	public void saveMan() {
		// TODO Auto-generated method stub
		System.out.println(name + "�� �ҹ���Դϴ�. ����� ���մϴ�");
	}

	@Override
	public void makePizza() {
		// TODO Auto-generated method stub
		System.out.println(name + "�� �丮���Դϴ�. ���ڸ� ����ϴ�");
	}

	@Override
	public void makeSpaghetti() {
		// TODO Auto-generated method stub
		System.out.println(name + "�� �丮���Դϴ�. ���İ�Ƽ�� ����ϴ�");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
