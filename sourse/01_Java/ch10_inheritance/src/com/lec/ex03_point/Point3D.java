//x, y /infoPrint(��ǥ x=2, y=1�� �ֿܼ� ���)
package com.lec.ex03_point;

public class Point3D extends Point {
	private int z;  // 3�����̱⿡ z �߰�
	public Point3D(int x, int y, int z) {
//		setX(x);
//		setY(y);
		super(x, y);       //����Ŭ������ �Ű����� 2���� ������ �Լ� ȣ��
		System.out.println("�Ű����� �ִ� Point3D ������ �Լ� - x, y, z �� �ʱ�ȭ");
		this.z = z;
	}
//	public void infoPrint3D() {
//		System.out.println("��ǥ x=" + getX() + ", y=" + getY() + ", z=" + z);
//	}
	@Override
	public String infoPrint(){	 //	infoPrint�� override : ��ǥ x:2, y:1, z:1 (super.infoPrint�̿�)
		return super.infoPrint() + ", z= " + z;   	
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
}
