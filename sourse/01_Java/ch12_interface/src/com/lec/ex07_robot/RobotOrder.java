// RobotOrder order = new RobotOrder();
// order.action(robot);
package com.lec.ex07_robot;

public class RobotOrder {
	public void action(Robot robot) {
		if (robot instanceof DanceRobot) {
			DanceRobot tempRobot = (DanceRobot) robot;
			tempRobot.dance();
		} else if (robot instanceof DrawRobot) {
			DrawRobot tempRobot = (DrawRobot) robot;
			tempRobot.draw();
		} else if (robot instanceof SingRobot) {
			SingRobot tempRobot = (SingRobot) robot;
			tempRobot.sing();
		} else {
			System.out.println("Ȯ��� �κ� ������ �ʿ��մϴ�");
		}
	}
}
