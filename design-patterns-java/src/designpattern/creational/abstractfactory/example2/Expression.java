package designpattern.creational.abstractfactory.example2;

public class Expression implements Cloneable {
	public String str;
	
	public Expression(String str) {
		this.str = str;
	}

	@Override
	protected Expression clone() {
		Expression clone = null;
		
		try {
			clone = (Expression) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return clone;
	}
	
	@Override
	public String toString() {
		return str;
	}

}
