package com.lec.ex;
//�Ҵ�(����)������ : =, +=, -=, *=, /=, %=
public class EX06 {
	public static void main(String[] args) {
	int n1 = 10;
	n1 += 10;  //n1 = n1+10
	System.out.println("n1=" +n1);
	n1 *= 10;  //n1 = n1*10
	System.out.println("n1=" +n1);       
	int n2, n3;
	n1 = n2 = n3 = 10;            //�����ʿ��� �������� ����
	System.out.println(n1 +"\t" + n2 + "\t" + n3);
	}
}
