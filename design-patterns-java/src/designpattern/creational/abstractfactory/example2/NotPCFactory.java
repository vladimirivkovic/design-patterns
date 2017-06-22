package designpattern.creational.abstractfactory.example2;

public class NotPCFactory extends AbstractFactory {
	
	public NotPCFactory() {
		prototype = new NotPCPhase();
	}
	
	@Override
	public Expression makeCompromise() {
		return new Expression("\"take test, deal with the results\"");
	}
	
	@Override
	public Expression makeGrade() {
		return new Expression("\"my way, or the highway\"");
	}

}
