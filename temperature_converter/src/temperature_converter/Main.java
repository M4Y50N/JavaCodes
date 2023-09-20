package temperature_converter;

public class Main {

	public static void main(String[] args) {
		Converter converter = new Converter(700);
		
		converter.converter("ck");
		
		System.out.println(converter.getTemperature());
	}

}
