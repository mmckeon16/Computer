
public class StandardCPU implements CPU{
	
	@Override
	public int getPrice() {
		return 500;
	}

	@Override
	public String getName() {
		return "BasicCPU";
	}
}
