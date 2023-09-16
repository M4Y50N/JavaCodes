package calculator;

//	*** interfaces ***
interface addition {
	//	add
	default void add() {
		System.out.println("add your custom implementation for addition operations");
	}
}

interface subtraction{
	//	sub
	default void sub() {
		System.out.println("add your custom implementation for subtration operations");
	}
}

interface multiplication{
	//	mult
	default void mult() {
		System.out.println("add your custom implementation for mutiplication operations");
	}
}

interface division{
	//	div
	default void div() {
		System.out.println("add your custom implementation for division operations");
	}
}
//	*** end interfaces ***

public class Calculator implements addition, subtraction, multiplication, division {
	
	private double result;
	
	
	//	add
	public double add(double x, double y) {
		return this.result = x + y;
	}
	public double add(double x) {
		return this.result += x;
	}
	//	end add
	
	//	sub
	public double sub(double x, double y) {
		return this.result = x - y;
	}
	public double sub(double x) {
		return this.result -= x;
	}
	//	end sub
	
	//	mult
	public double mult(double x, double y) {
		return this.result = x * y;
	}
	public double mult(double x) {
		return this.result *= x;
	}
	//	end mult
	
	//	div
	public double div(double x, double y) {
		if (y == 0) {
	        throw new ArithmeticException("Cannot divide by 0");
	    }
	    return this.result = x / y;
	}
	public double div(double x) {
		if (x == 0) {
	        throw new ArithmeticException("Cannot divide by 0");
	    }
		return this.result /= x;
	}
	//	end div
	
	//	get&set
	public double get() {
		return this.result;
	}
	public void set(double result) {
		this.result = result;
	}
	//	end get&set
}
