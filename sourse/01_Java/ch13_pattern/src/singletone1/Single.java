// �޸� ���� ������ ����  |  heap ����
// Ŭ���� &static     |  �Ϲݺ���
package singletone1;

public class Single {
	private int i;
	private Single() {}
	private static Single INSTANCE = new Single();
	public static Single getInstance() {
		//������ ��ü �ּҸ� return
		return INSTANCE;
	}
//	private static Single INSTANCE;
//	public static Single getInstance() {
//		//��ü���������� �� ��ü �ּҸ� ����
//		//��ü���� �� ������ ��ü�����ϰ� �� �ּҸ� ����
//		if(INSTANCE==null) {
//			INSTANCE = new Single();
//		}
//		return INSTANCE;
//	}
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}
