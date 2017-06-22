package designpattern.creational.abstractfactory.example1;

enum Architecture {
    ENGINOLA, EMBER
}

public abstract class AbstractFactory {
	private static final EmberToolkit EMBER_TOOLKIT = new EmberToolkit();
	private static final EnginolaToolkit ENGINOLA_TOOLKIT = new EnginolaToolkit();
	
	static AbstractFactory getAbstractFactory(Architecture architecture) {
		AbstractFactory factory = null;
		switch (architecture) {
		case EMBER:
			factory = EMBER_TOOLKIT;
			break;
		case ENGINOLA:
			factory = ENGINOLA_TOOLKIT;
			break;
		}
		
		return factory;
	}
	
	
	public abstract CPU makeCPU();
	
	public abstract MMU makeMMU();

}
