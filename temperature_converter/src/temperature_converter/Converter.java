package temperature_converter;


public class Converter {
	
	private double temperature;
	
	public Converter(double temperature) {
		this.temperature = temperature;
	}
	
	public void converter(String pair) {
		switch (pair.toUpperCase()) {
		case "KC":
			this.temperature = this.temperature - 273;
			break;
		case "KF":
			this.temperature = (this.temperature - 273) * 1.8 + 32;
			break;
		case "CK":
			this.temperature = this.temperature + 273;
			break;
		case "CF":
			this.temperature = this.temperature * 1.8 + 32;
			break;
		case "FC":
			this.temperature = (this.temperature - 32) / 1.8;
			break;
		case "FK":
			this.temperature = (this.temperature - 32) * 5/9 + 273;
			break;
		default:
			System.out.println("non-existent conversion code");
			break;
		}		
	}
	
	
	public double getTemperature() {
		return this.temperature;
				
	}
	
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
}
