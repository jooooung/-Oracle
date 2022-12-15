//new Card('��', 6)   ��  ��   ��   ��
package com.lec.ex4_object;

public class Card {
	private char kind; // �� �� �� ��
	private int num; // 1~13
	
	public Card() {}

	public Card(char kind, int num) {  
		this.kind = kind;
		this.num = num;
	}
	@Override
	public String toString() {
		return "ī�� : " + kind + " " + num;  //��� ex) ī�� : �� 3 
	}
	@Override
	public boolean equals(Object obj) {
		//card.equals(comCard) => card �� this.   comCard�� obj�� �ȴ�
		//obj�� null�� �ƴϰ� obj�� CardŸ�� ��ü���� Ȯ���� kind��num �� ��� return
		if(obj!=null && obj instanceof Card) {   //(getClass()==obj.getClass()
			Card other = (Card)obj;        // other��� Card 
			boolean kindChk = kind == other.kind;  //boolean �̿� true/false ����
			boolean numChk = num == other.num;
			return kindChk && numChk;
		}
		return super.equals(obj);
	}
}
