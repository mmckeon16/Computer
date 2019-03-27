import java.util.*;

public class Computer {
	public ComputerPartsFactory computerPartsFactory;
	public CPU cpu;
	public Keyboard keyboard;
	public Monitor monitor;
	
	public Computer(ComputerPartsFactory computerPartsFactory) {
		this.computerPartsFactory = computerPartsFactory;
		cpu = computerPartsFactory.createCPU();
		keyboard = computerPartsFactory.createKeyboard();
		monitor = computerPartsFactory.createMonitor();
		
	}
	
	public int getTotalPrice() {
		return cpu.getPrice()+keyboard.getPrice()+monitor.getPrice();
	}
	
	public String getCompiledNames() {
		return cpu.getName() + ", " + keyboard.getName() + ", "+ monitor.getName();
	}
	
	public static void main(String[] args) {
		while (true) {
			System.out.println("hello there, we will be calculating the pricing of your custom computer. Type \"standard\" or \"advanced\" for each question.");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Would you like the standard or advanced computer?");
			Boolean isStandard;
			while(true) {
				String compResponse = scanner.nextLine();
				if(compResponse.equalsIgnoreCase("standard")) {
					isStandard = true;
					break;
				} else if(compResponse.equalsIgnoreCase("advanced")) {
					isStandard = false;
					break;
				} else {
					System.out.println("Not valid response. Please type standard or advanced to continue");
				}
			}
			
			Computer computer;
			if(isStandard) {
				computer = new Computer(new StandardComputerPartsFactory());
			} else {
				computer = new Computer(new AdvancedComputerPartsFactory());
			}
			
			System.out.println("Results for a computer with "+ computer.getCompiledNames());
			System.out.println("Total price: " + computer.getTotalPrice());	
			
			System.out.println("Would you like to make another computer");
			String response = scanner.nextLine();
			
			if(!response.equalsIgnoreCase("yes")) 
				break;
		}
		System.out.println("Thanks for shopping!");
	}
}
