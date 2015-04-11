package com.sky.test
import geb.spock.GebSpec

import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.test.context.ContextConfiguration

import com.sky.Application

/**
 * Spock Specification for the Customer bill page. 
 * 
 * @author whamondg
 *
 */
@ContextConfiguration(loader = SpringApplicationContextLoader, classes=Application)
@WebIntegrationTest
class CustomerBillSpec extends GebSpec {

	def setup() {
		to CustomerBillPage		
		at CustomerBillPage
	}
	
	def "Customer bill has correct page heading"() {
		expect: "The customer bill page is displayed"
		assert billTitle.text() == "Current Bill"
	}
		
	def "Customer bill contains a total"() {
		expect: "The bill contains a total"
		assert totalDue.text() == "Total due on 25/01/2015: £136.03"
	}
	
	def "Customer bill contains statement dates"(){
		expect: "The bill contains a generated date"
		assert statementDates.text() == "Generated on 11/01/2015 for bill period: 26/01/2015 - 25/02/2015"
	}
}