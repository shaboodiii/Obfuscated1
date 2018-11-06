import cucumber.api.java.en.Given;

import cucumber.api.java.en.Then;

import cucumber.api.java.en.When;

import static org.fest.assertions.Assertions.assertThat;

import static org.junit.Assert.assertEquals;

public class CalculatorSteps {
	
	Calculator calculator;
	long expected_result = 0;

	@Given("^a calculator I just turned on$")
	public void a_calculator_I_just_turned_on() throws Throwable {
		calculator = new Calculator();
	}
	
	
	
	

	@When("^I add (\\d+)$")
	public void I_add(long number) throws Throwable {
		calculator.add(number);
	}
	

	@When("^I multiply (\\d+)$")
	public void I_multiply(long number){
		calculator.multiplyBy(number);
	}

	
	

	@Then("^the result displayed is (\\d+)$")
	public void the_result_displayed_is(long result) throws Throwable {
		assertThat(calculator.getState()).isEqualTo(result);
		expected_result = result;
		calculator.reset();
	}
	
	
	
	

	
}
