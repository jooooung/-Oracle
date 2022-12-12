package strategy2.modularization;

import strategy2.interfaces.EngineHigh;
import strategy2.interfaces.FuelGosoline;
import strategy2.interfaces.Km20;

public class Genesis extends Car {
	
	public Genesis() {
		setEngine(new EngineHigh());
		setKm(new Km20());
		setFuel(new FuelGosoline());
	}
	@Override
	public void shape() {
		System.out.println("�����׽ý� ������ ��, ��Ʈ, �ڵ�� �̷���� �ֽ��ϴ�");
	}
}
