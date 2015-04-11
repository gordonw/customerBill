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
		expect: "The customer bill has the correct page heading"
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
	
	def "Customer bill contains Sky package breakdown"(){
		expect: "The Sky package section has the correct title"
		assert packageBreakdownTitle.text() == "Your Sky Package"
	
		and: "The subscription breakdown is displayed"
		assert packageBreakdown.size() == 3
		assert packageBreakdown[0].name == 'Variety with Movies HD'
		assert packageBreakdown[0].type == 'tv'
		assert packageBreakdown[0].cost == '£50.00'

		assert packageBreakdown[1].name == 'Sky Talk Anytime'
		assert packageBreakdown[1].type == 'talk'
		assert packageBreakdown[1].cost == '£5.00'

		assert packageBreakdown[2].name == 'Fibre Unlimited'
		assert packageBreakdown[2].type == 'broadband'
		assert packageBreakdown[2].cost == '£16.40'

				
    	and: "The package breakdown contains the cost of the package"	
		assert packageTotal.text() == "Sky package total: £71.40"
	}

			
	
	
	
}