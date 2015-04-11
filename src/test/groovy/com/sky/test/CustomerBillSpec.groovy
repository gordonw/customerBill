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

	def "Customer bill can be viewed"() {
		when: "A customer views their bill"
		to CustomerBillPage

		then: "The customer bill is displayed"
		at CustomerBillPage
	}
		
	def "Customer bill contains a total"() {
		when: "A customer views their bill"
		to CustomerBillPage

		then: "The customer bill is displayed"
		at CustomerBillPage
		
		and: "The bill contains a total"
		assert totalDue.text() == "Total due on 25/01/2015: £136.03"
	}
}