package com.lec.ex4_object;

import java.util.Random;

public class Ex03_CardMain { // �� �� �� ��
	public static void main(String[] args) {
		Card[] cards = { new Card('��', 1), new Card('��', 2), new Card('��', 3),  //�迭�� ī�� ����
						 new Card('��', 4), new Card('��', 5), new Card('��', 6), 
						 new Card('��', 7), new Card('��', 8), new Card('��', 9), 
						 new Card('��', 10), new Card('��', 11), new Card('��', 12), };
		for(Card card : cards) {
			System.out.println(card);	//Ȯ�� for�� �̿��Ͽ� ī�� ���
		} //for
		//���Ƿ� ���� ī��� �迭���� ī�� ��
		Random random = new Random();
		char[] kinds = {'��', '��', '��', '��'};   // ������ kind�� ����ϱ� ���� ���� �迭
		Card randomCard = new Card(kinds[random.nextInt(4)], random.nextInt(13)+1);  //ī�� �׸��� ���� ������
		System.out.println("���Ƿ� ���� ī�� : " + randomCard);
		int i;
		for(i=0 ; i<cards.length ; i++) {   //���� ī�� ã�� for��
			if(cards[i].equals(randomCard)) {
				System.out.println(i + "��° ī��� ��ġ");
				break;
			} 
		} //for
		if(i == cards.length) {
			System.out.println("��ġ�ϴ� ī�尡 �����ϴ�");
		}
	} //main
}


/*
 * kinds[random.nextInt(4)] : kinds�迭�� 4��° �պ��� �����ϰ� ��� 
 * random.nextInt(13)+1 : random�迭�� 13��°���� ���
 * �迭�� �ߺ��� ī�尡 ���� ��  for���� i������ for�� �ۿ��� ����
 * i==cards.length : ��ġ�ϴ� ī�尡 ���� ��
 * i!=cards.length : ��ġ�ϴ� ī�尡 �ִ� ��
 */