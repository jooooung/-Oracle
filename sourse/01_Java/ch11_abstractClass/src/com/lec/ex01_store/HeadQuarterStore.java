//�߻�Ŭ���� : �ϳ� �̻��� �߻�޼ҵ带 ���� ������ �߻�Ŭ����
package com.lec.ex01_store;

public abstract class HeadQuarterStore {
	public String storeName;

	public HeadQuarterStore(String storeName) {
		this.storeName = storeName;
	}
	public abstract void kimchi(); 
	// �߻�޼ҵ� : ���� ����� Ŭ�������� �ݵ�� override �ض�
	//          �޼ҵ��� ���� ���� ��, ������ ����
	public abstract void bude();
	public abstract void bibim();
	public abstract void sunde();
	public abstract void gonggibab();
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
}
