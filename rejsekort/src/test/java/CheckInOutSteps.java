import static org.junit.Assert.assertEquals;

import com.travelcard.core.CheckInAutomaton;
import com.travelcard.core.CheckOutAutomaton;
import com.travelcard.core.ResponseObject;
import com.travelcard.core.TravelCard;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheckInOutSteps {

	TravelCard card = new TravelCard();
	
	
	CheckInAutomaton inAuto;
	
	
	CheckOutAutomaton outAuto;
	
	
	ResponseObject responseCInAuto;
	

	ResponseObject responseCOutAuto;
	

	@Given("^a travel card with a balance of (\\d+)$")
	public void a_travel_card_with_a_balance_of(int b) {
		card.setBalance(b);
	}

	
	
	
	
	@Given("^a check-in automaton at \"([^\"]*)\"$")
	public void a_check_in_automaton_at(String sName) {
		inAuto = new CheckInAutomaton(sName);
	}
	
	
	
	

	@Given("^a travel card with check-in status is (true|false)$")
	public void a_travel_card_with_check_in_status_is_false(boolean isCIn) {
		card.setCheckedInStatus(isCIn);
	}
	
	
	
	

	@When("^Check-in$")
	public void check_in() {
		responseCInAuto = inAuto.cIn(card);
	}

	
	
	
	
	@Given("^a check-out automaton at \"([^\"]*)\"$")
	public void a_check_out_automaton_at(String sName) {
		outAuto = new CheckOutAutomaton(sName);
	}
	
	
	
	

	@When("^a travel card check-out$")
	public void a_travel_card_check_out() {
		responseCOutAuto = outAuto.cOut(card);
	}

	
	
	
	
	@Then("^the travel card after check-out has a new balance (\\d+)$")
	public void the_travel_card_after_check_out_has_a_new_balance(int newB) {
		assertEquals(card.getBalance(), newB);

	}

	
	
	
	
	@Then("^the check-in automaton displays a message that \"([^\"]*)\"$")
	public void the_check_in_automaton_displays_a_message_that(String msg) {
		assertEquals(responseCInAuto.getMessage(), msg);

	}
	
	
	
	

	@Then("^the check-out automaton displays a message that \"([^\"]*)\"$")
	public void the_check_out_automaton_displays_a_message_that(String msg) {
		assertEquals(responseCOutAuto.getMessage(), msg);

	}
	
	
	
	

	@Then("^the check-in automaton posts that message in the system log$")
	public void the_check_in_automaton_posts_that_message_in_the_system_log() {
		inAuto.inLog();
	}
	
	
	
	

	@Then("^the check-out automaton posts a successful message on the system log$")
	public void the_check_out_automaton_posts_a_successful_message_on_the_system_log(){
		outAuto.outLog();
	}


}
