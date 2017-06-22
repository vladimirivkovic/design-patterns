package designpattern.creational.abstractfactory.example2;

public class NotPCPhase extends Expression {
	private static int next = 0;
    private static final String[] list = {"\"pet\"", "\"short\"", "\"lie\"", "\"old\""};

	public NotPCPhase() {
		super(list[next]);
		next = (next + 1) % list.length;
	}
	
	@Override
	protected Expression clone() {
		return new NotPCPhase();
	}

}
