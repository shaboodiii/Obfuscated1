import static org.junit.Assert.assertEquals;
import com.travelcard.core.SystemLogger;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class ASystemInitializationSteps {

	SystemLogger init;
	
	
	String logname; 
	

	@Given("^a manager wants to setup the system with the log file \"([^\"]*)\"$")
	public void a_manager_wants_to_setup_the_system_with_the_log_file(String filename) {
		logname = filename;
	}
	
	
	

	@When("^setup$")
	public void setup() {
		init = new SystemLogger(logname);
	}

	
	
	
	
	@When("^the log file \"([^\"]*)\" recording system actions is generated$")
	public void the_log_file_recording_system_actions_is_generated(String filename) {
		assertEquals(init.exists(filename), true);

	}
	
	
	
	

}
