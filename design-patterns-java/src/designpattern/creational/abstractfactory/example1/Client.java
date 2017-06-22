package designpattern.creational.abstractfactory.example1;

public class Client {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		AbstractFactory factory = AbstractFactory.getAbstractFactory(Architecture.EMBER);
		CPU cpu = factory.makeCPU();
	}

}
