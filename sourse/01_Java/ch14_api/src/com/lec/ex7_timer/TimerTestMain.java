package com.lec.ex7_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTestMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("����");
		Timer timer = new Timer(true);  //timer ��ü �����, ���α׷� ���� �� timer�� �޸𸮿� ���� X 
		//true�� �� ������ ���α׷� ���� �� timer�� �޸𸮿� ����
		TimerTask task1 = new TimerTaskEx1();  //2�� �� �� �� ����
		TimerTask task2 = new TimerTaskEx2();
		timer.schedule(task1, 2000);  //2000�� �и����� (2��) 2�� �� �ѹ� task1.run() ����
		timer.schedule(task2, 1000, 500);  //1���Ŀ� 0.5�ʸ��� task2.run()����
		Thread.sleep(11000);  //11�� �Ŀ� ����
		System.out.println("��");
	}
}
