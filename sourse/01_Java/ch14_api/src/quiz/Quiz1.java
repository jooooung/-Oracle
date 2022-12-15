package quiz;

import java.util.Random;
import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int u, com;
		final int SCISSOR = 0;
		final int ROCK = 1;
		final int PAPER = 2;
		final int NOTHING = 3;

		do {
			com = random.nextInt(3);
			System.out.println("����, ����, �� �� �ϳ��� �Է��ϼ���(����ڰ� �̱�� ����)");
			String uStr = sc.next().trim();
			if (uStr.equals("����")) {
				u = SCISSOR;
			} else if (uStr.equals("����")) {
				u = ROCK;
			} else if (uStr.equals("��")) {
				u = PAPER;
			} else {
				u = NOTHING;
				continue;
			}
			if ((u + 2) % 3 == com) {
				printResult(u, com);
				System.out.println("�̰���ϴ�");
			} else if (u == com) {
				printResult(u, com);
				System.out.println("�����ϴ�");
			} else {
				printResult(u, com);
				System.out.println("�����ϴ�");
			}

		} while (u==NOTHING || (u + 2) % 3 != com);
		System.out.println("��");
		sc.close();
	}

	private static void printResult(int u, int com) {
		System.out.println("����� : " + ((u == 0) ? "����" : (u == 1) ? "����" : "��"));
		System.out.println("��ǻ�� : " + ((com == 0) ? "����" : (com == 1) ? "����" : "��"));
	}
}

//trim() space ���ִ� �޼ҵ�