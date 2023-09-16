package calculator;

import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println(
				"=".repeat(45) + "\n"
				+ "======== Welcome to java calculator! ========" + 
				"\n" + "=".repeat(45) + "\n");
	
		//	controller
		String c = "yes";
		do {
			try {
				System.out.print("Type +, -, * or / to make a calc: ");
				String operation = sc.next();
			
				System.out.println("Type 2 or 1 number for calc, exemple: 25 53.");
				
				sc.nextLine();
				String pair = sc.nextLine();
				
				String[] numbers = pair.split(" ");
				
				switch (operation) {
				case "+": 
					calc.set(numbers.length > 1 ? 
								calc.add(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1])) 
							:
								calc.add(Double.parseDouble(numbers[0])));
					break;
				case "-":
					calc.set(
							numbers.length > 1 ? 
								calc.sub(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1])) 
							:
								calc.sub(Double.parseDouble(numbers[0])));
					break;
				case "*":
					calc.set(
							numbers.length > 1 ? 
								calc.mult(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1])) 
							:
								calc.mult(Double.parseDouble(numbers[0])));
					break;
				case "/":
					calc.set(
							numbers.length > 1 ? 
								calc.div(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1])) 
							:
								calc.div(Double.parseDouble(numbers[0])));
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + operation);
				}
				
				System.out.println("Result: " + calc.get());
				System.out.println("=".repeat(45));
			}catch (Exception e){
				System.out.println("Erro: " + e.getMessage());		
			}
			
			System.out.print("Are you want to make a calc? ");
			c = sc.next();
		}while(c.equals("yes"));
		
		sc.close();

	}

}
