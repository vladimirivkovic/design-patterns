package designpattern.creational.abstractfactory.example1;

public class EmberToolkit extends AbstractFactory {

	@Override
	public CPU makeCPU() {
		return new EmberCPU();
	}

	@Override
	public MMU makeMMU() {
		return new EmberMMU();
	}

}
