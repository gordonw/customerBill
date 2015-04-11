package com.sky.test
import geb.spock.GebSpec

/**
 * Spock Specification for the Customer bill page. 
 * 
 * @author whamondg
 *
 */
class CustomerBillSpec extends GebSpec {

	def "The customer bill page can be viewed"() {
		when: "A customer views their bill"
		to CustomerBillPage

		then: "The customer bill page is displayed"
		at CustomerBillPage
	}
}