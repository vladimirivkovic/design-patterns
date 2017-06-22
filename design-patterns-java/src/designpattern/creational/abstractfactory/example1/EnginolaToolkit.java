package designpattern.creational.abstractfactory.example1;

public class EnginolaToolkit extends AbstractFactory {

	@Override
	public CPU makeCPU() {
		return new EnginolaCPU();
	}

	@Override
	public MMU makeMMU() {
		return new EnginolaMMU();
	}

}
