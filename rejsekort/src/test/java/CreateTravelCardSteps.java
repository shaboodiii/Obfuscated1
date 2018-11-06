import static org.junit.Assert.assertEquals;

import com.creditcard.validation.CreditCard;
import com.travelcard.core.Constants;
import com.travelcard.core.Kiosk;
import com.travelcard.core.ResponseObject;
import com.travelcard.core.TravelCard;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateTravelCardSteps {
	
	
	TravelCard currentUser_tc;
	
	
	CreditCard ccInUse;
	
	
	Kiosk registrationKiosk;

	
	ResponseObject response;

	
	@Given("^a customer at a registration kiosk at station \"([^\"]*)\"$")
	public void a_customer_at_a_registration_kiosk_at_station(String stationName) {
		registrationKiosk = new Kiosk(stationName);
	}
	
	
	
	

	@Given("^his credit card \"([^\"]*)\" was successfully verified by the registration kiosk$")
	public void his_credit_card_was_successfully_verified_by_the_registration_kiosk(String ccNumber) {
		ccInUse = new CreditCard(ccNumber);
		ccInUse.setValid(true);
		registrationKiosk.setCC(ccInUse);
	}
	
	
	
	

	@Given("^his credit card accepts to charge the amount of (\\d+)$")
	public void his_credit_card_accepts_to_charge_the_amount_of(int amount) {
		ccInUse.setBalance(amount);

	}
	
	
	
	

	@Given("^his credit card declines to charge the amount of (\\d+)$")
	public void his_credit_card_declines_to_charge_the_amount_of(int amount) {
		ccInUse.setBalance(Constants.notEnoughBalance - amount);
	}
	
	
	
	

	@Given("^a userID number \"([^\"]*)\" is not registered in the system$")
	public void a_userID_number_is_not_registered_in_the_system(String userIDnumber) {
		currentUser_tc = new TravelCard(userIDnumber);
	}

	
	
	
	
	@When("^issue a travel card$")
	public void issue_a_travel_card() {
		response = registrationKiosk.createTC(currentUser_tc);
	}

	
	
	
	
	@Then("^a travel card user is registered$")
	public void a_travel_card_user_is_registered() {

		assertEquals(registrationKiosk.getUsers().contains(currentUser_tc), true);

	}
	
	
	
	

	@Then("^the registration kiosk displays a message that a travel card is issued$")
	public void the_registration_kiosk_displays_a_message_that_a_travel_card_is_issued() {
		assertEquals(response.getMessage(), Constants.TRAVEL_CARD_CREATION_SUCCESS);
	}

	
	
	
	
	@Given("^a userID number \"([^\"]*)\" is registered in the system$")
	public void a_userID_number_is_registered_in_the_system(String userIDnumber) {
		currentUser_tc = new TravelCard(userIDnumber);
		registrationKiosk.getUsers().add(currentUser_tc);
	}
	
	
	
	

	@Then("^the registration kiosk displays a message that a travel card not issued because user already registered in the system$")
	public void the_registration_kiosk_displays_a_message_that_a_travel_card_not_issued_because_user_already_registered_in_the_system() {
		assertEquals(response.getMessage(), Constants.TRAVEL_CARD_CREATION_FAILURE);
	}

	
	
	
	
	@Then("^the registration kiosk displays a message that a travel card not issued because credit card was declined$")
	public void the_registration_kiosk_displays_a_message_that_a_travel_card_not_issued_because_credit_card_was_declined() {
		assertEquals(response.getMessage(), Constants.INVALID_CC_LOW_BALANCE);
	}
	
	
	
	

	@Then("^the registration kiosk posts that message on the system log$")
	public void the_registration_kiosk_posts_that_message_on_the_system_log() {
		registrationKiosk.cRegistered();
	}

}