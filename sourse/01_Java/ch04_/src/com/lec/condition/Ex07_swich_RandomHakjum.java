package com.lec.condition;
// �����Ҷ����� ��ǻ�Ͱ� ����(Random)�����߻��Ͽ� ���� ���
public class Ex07_swich_RandomHakjum {
	 public static void main(String[] args) {
		//Math.random �� 0<= x <1 : �Ǽ�
		//0 <=(int)(Math.random()*3) < 3 : �Ǽ�      (������ ����ϱ� ���� (int)�� ����)
		//0 <= score <101 ������ ���� ����
		//System.out.println((int)(Math.random()*101));
//		int temp = score==100 ? score-1 : score;       // 100���� A������ �����Բ� �� ��
//		switch(temp/10){
//			case 9:
//				System.out.println("A����");break;
//			case 8:
//				System.out.println("B����");break;
//			case 7:
//				System.out.println("C����");break;
//			case 6:
//				System.out.println("D����");break;
//			case 5: case 4: case 3: case 2: case 1:
//				System.out.println("F����");break;
//			default:
//				System.out.println("��ȿ���� ���� �����Դϴ�");
//		}
//		sc.close();
	int score = (int)(Math.random()*101);
	int temp = (score==100) ? score-1 : score;       
	switch(temp/10){
	case 9:
		System.out.println(score + ", A����");break;
	case 8:
		System.out.println(score + ", B����");break;
	case 7:
		System.out.println(score + ", C����");break;
	case 6:
		System.out.println(score + ", D����");break;
	case 5: case 4: case 3: case 2: case 1: case 0:
		System.out.println(score + ", F����");break;
	default:
		System.out.println(score + "��ȿ���� ���� �����Դϴ�");
		}
	 }
}

