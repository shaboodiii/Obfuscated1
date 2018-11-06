import static org.junit.Assert.assertEquals;

import com.travelcard.core.Station;
import com.travelcard.core.StationList;
import com.travelcard.core.TravelCardUserList;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateAdminReportsSteps {
	
	
	StationList lstation;
	
	
	Station testStation;
	
	
	String stName;
	
	
	TravelCardUserList ltcuser;
	

	@Given("^the manager wants to know the number of travel cards being checked-in and checked-out in all stations$")
	public void the_manager_wants_to_know_the_number_of_travel_cards_being_checked_in_and_checked_out_in_all_stations() {
		lstation = new StationList();
	}
	
	
	
	

	@When("^he generates a station statistics report$")
	public void he_generates_a_station_statistics_report() {

		lstation.generateStationStatisticsReport();
	}
	
	
	
	

	@Then("^the system produces a pdf report named as \"([^\"]*)\"$")
	public void the_system_produces_a_pdf_report_named_as(String reportName) {
		assertEquals(lstation.reportExists(reportName), true);
	}
	
	
	
	

	@Given("^the manager wants to see a list with the names of users registered in the system$")
	public void the_manager_wants_to_see_a_list_with_the_names_of_users_registered_in_the_system() {
		ltcuser = new TravelCardUserList();
	}
	
	
	
	

	@When("^he generates a name list$")
	public void he_generates_a_name_list() {
		ltcuser.generateNameList();
	}
	
	
	
	

	@Then("^the system produces a text file named as \"([^\"]*)\" which contains the name list$")
	public void the_system_produces_a_text_file_named_as_which_contains_the_name_list(String reportName) {
		assertEquals(ltcuser.reportExists(reportName), true);
	}

}
