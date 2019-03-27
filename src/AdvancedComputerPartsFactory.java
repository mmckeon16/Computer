
/**
 * Advanced Computer Parts Factory method
 * @author Mary
 *
 */
public class AdvancedComputerPartsFactory implements ComputerPartsFactory{

	@Override
	public Monitor createMonitor() {
		return new AdvancedMonitor();
	}

	@Override
	public Keyboard createKeyBoard() {
		return new AdvancedKeyboard();
	}

	@Override
	public CPU createCPU() {
		return new AdvancedCPU();
	}
	
}
