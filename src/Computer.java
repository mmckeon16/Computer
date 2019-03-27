import java.util.*;

public class Computer {
	public ComputerPartsFactory compPartsFactory;
	public CPU cpu;
	public Keyboard keyboard;
	public Monitor monitor;
	
	public Computer(CPU cpu, Keyboard keyboard, Monitor monitor) {
		this.cpu = cpu;
		this.keyboard = keyboard;
		this.monitor = monitor;
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
			System.out.println("Would you like the standard or advanced CPU?");
			Boolean isCPUStandard;
			while(true) {
				String cpuResponse = scanner.nextLine();
				if(cpuResponse.equalsIgnoreCase("standard")) {
					isCPUStandard = true;
					break;
				} else if(cpuResponse.equalsIgnoreCase("advanced")) {
					isCPUStandard = false;
					break;
				} else {
					System.out.println("Not valid response. Please type standard or advanced to continue");
				}
			}
			System.out.println("Would you like the standard or advanced Keyboard?");
			Boolean isKeyboardStandard;
			while(true) {
				String keyboardResponse = scanner.nextLine();
				if(keyboardResponse.equalsIgnoreCase("standard")) {
					isKeyboardStandard = true;
					break;
				} else if(keyboardResponse.equalsIgnoreCase("advanced")) {
					isKeyboardStandard = false;
					break;
				} else {
					System.out.println("Not valid response. Please type standard or advanced to continue");
				}
			}
			System.out.println("Would you like the standard or advanced Monitor?");
			Boolean isMonitorStandard;
			while(true) {
				String monitorResponse = scanner.nextLine();
				
				if(monitorResponse.equalsIgnoreCase("standard")) {
					isMonitorStandard = true;
					break;
				} else if(monitorResponse.equalsIgnoreCase("advanced")) {
					isMonitorStandard = false;
					break;
				} else {
					System.out.println("Not valid response. Please type standard or advanced to continue");
				}
			}
			
			Monitor monitor;
			Keyboard keyboard;
			CPU cpu;
			//assign monitor
			if(isMonitorStandard) {
				monitor = new StandardMonitor();
			} else {
				monitor = new AdvancedMonitor();
			}
			
			//assign keyboard 
			if(isKeyboardStandard) {
				keyboard = new StandardKeyboard();
			} else {
				keyboard = new AdvancedKeyboard();
			}
			
			//assign cpu 
			if(isCPUStandard) {
				cpu = new StandardCPU();
			} else {
				cpu = new AdvancedCPU();
			}
			
			Computer computer = new Computer(cpu, keyboard, monitor);
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
