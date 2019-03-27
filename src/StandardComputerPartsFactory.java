
public class StandardComputerPartsFactory implements ComputerPartsFactory {

	@Override
	public Monitor createMonitor() {
		return new StandardMonitor();
	}

	@Override
	public Keyboard createKeyBoard() {
		return new StandardKeyboard();
	}

	@Override
	public CPU createCPU() {
		return new StandardCPU();
	}

}
