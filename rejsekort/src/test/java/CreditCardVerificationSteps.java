import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

import com.creditcard.validation.CreditCard;
import com.travelcard.core.Constants;
import com.travelcard.core.Kiosk;
import com.travelcard.core.ResponseObject;

public class CreditCardVerificationSteps {

	
	CreditCard creditCard;
	
	
	Kiosk kiosk;
	
	
	ResponseObject response;
	

	@Given("^a kiosk at station \"([^\"]*)\"$")
	public void a_kiosk_at_station(String stationName) {
		kiosk = new Kiosk(stationName);

	}

	
	
	
	
	@Given("^a credit card with number \"([^\"]*)\"$")
	public void a_credit_card_with_number(String ccnumber) {
		creditCard = new CreditCard(ccnumber);
	}
	
	
	
	
	
	@When("^the kiosk verifies the credit card$")
	public void the_kiosk_verifies_the_credit_card() {
		response = kiosk.verify(creditCard);

	}
	
	
	
	

	@Then("^the kiosk informs the user that the provided credit card is valid$")
	public void the_kiosk_informs_the_user_that_the_provided_credit_card_is_valid() {
		assertEquals(response.getMessage(), Constants.VALID_CC);

	}
	
	
	
	

	@Then("^the kiosk informs the user that the provided credit card is invalid because it contains characters$")
	public void the_kiosk_informs_the_user_that_the_provided_credit_card_is_invalid_because_it_contains_characters() {
		assertEquals(response.getMessage(), Constants.INVALID_CC_LETTERS);
	}
	
	
	
	

	@Then("^the kiosk informs the user that the provided credit card is invalid because it has too few digits$")
	public void the_kiosk_informs_the_user_that_the_provided_credit_card_is_invalid_because_it_has_too_few_digits() {
		assertEquals(response.getMessage(), Constants.INVALID_CC_LENGTH);
	}

	
	
	
	
	@Then("^the kiosk informs the user that the provided credit card because it does not belong to a company provider$")
	public void the_kiosk_informs_the_user_that_the_provided_credit_card_because_it_does_not_belong_to_a_company_provider() {
		assertEquals(response.getMessage(), Constants.INVALID_CC_COMPANY);
	}
	

}
