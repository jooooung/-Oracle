import java.util.Random;
import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int u, com;
		final int SCISSOR = 0;
		final int ���� = Integer.parseInt("1");
		final int �� = Integer.parseInt("2");
		
		do {
			System.out.println("����, ����, �� �� �ϳ��� �Է��ϼ���");
			String uStr = sc.next().trim();
			if(uStr.equals("����")) {
				u = ����;
			}
			com = random.nextInt(3);
			if(u<-1 || u>2) {
				System.out.println();
			}
			
			
			
			
			
		} while ((u+2)%3 != com || u == com);
	}
}

//trim() space ���ִ� �޼ҵ�