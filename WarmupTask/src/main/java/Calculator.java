public class Calculator {
	
	
	private long state = 0;
	
	
	private boolean turnOnCalculator = false;

	
	
	
	
	public Calculator() {
		this.setTurnOnCalculator(true);
	}

	
	
	
	
	public void add(long val) {
		state += val;
	}

	
	
	
	
	public long getState() {
		return state;
	}
	
	
	
	

	public void set(long val) {
		state = val;
	}

	
	
	
	
	public void multiplyBy(long val) {
		state *= val;
	}

	
	
	
	
	public void power(long val) {
		state = new Double(Math.pow(state, val)).longValue();
	}
	
	
	
	
	
	
	public boolean getTurnOnCalculator() {
		return turnOnCalculator;
	}

	
	
	
	
	public void setTurnOnCalculator(boolean b) {
		this.turnOnCalculator = b;
	}

	
	
	
	
	public void reset(){
		
	}
}

