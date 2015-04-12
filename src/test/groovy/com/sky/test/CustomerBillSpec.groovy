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

	def 'Customer bill has correct page heading'() {
		expect: 'The customer bill has the correct page heading'
		assert billTitle.text() == 'Current Bill'
	}

	def 'Customer bill contains a total'() {
		expect: 'The bill contains a total'
		assert totalDue.text() == 'Total due on 25/01/2015: £136.03'
	}

	def 'Customer bill contains statement dates'(){
		expect: 'The bill contains a generated date'
		assert statementDates.text() == 'Generated on 11/01/2015 for bill period: 26/01/2015 - 25/02/2015'
	}

	def 'Customer bill contains Sky package details'(){
		expect: 'The Sky package section has the correct title'
		assert packageSectionTitle.text() == 'Your Sky Package'

		and: 'Package details are displayed'
		assert packageDetails.size() == 3

		verifyPackageDetails( packageDetails[0], [ 'Variety with Movies HD','tv', '£50.00'] )
		verifyPackageDetails( packageDetails[1], ['Sky Talk Anytime', 'talk','£5.00'] )
		verifyPackageDetails( packageDetails[2], ['Fibre Unlimited', 'broadband', '£16.40'] )

		and: 'The package cost is displayed'
		assert packageCost.text() == 'Sky package total: £71.40'
	}
	
	def 'Customer bill contains call charges'(){
		expect: 'The call charges section has the correct title'
		assert callChargesSectionTitle.text() == 'Call Charges'

		and: 'Call details are displayed'
		assert callCharges.size() == 28

		verifyCallDetails( callCharges[0], ['07716393769', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[1], ['07716393769', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[2], ['07716393769', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[3], ['07716393769', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[4], ['07716393769', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[5], ['07716393769', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[6], ['07716393769', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[7], ['07716393769', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[8], ['07716393769', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[9], ['07716393769', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[10], ['07716393769', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[11], ['07716393769', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[12], ['07716393769', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[13], ['07716393769', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[14], ['07716393769', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[15], ['07716393769', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[16], ['07716393769', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[17], ['07716393769', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[18], ['02074351359', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[19], ['02074351359', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[20], ['02074351359', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[21], ['02074351359', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[22], ['02074351359', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[23], ['02074351359', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[24], ['02074351359', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[25], ['02074351359', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[26], ['02074351359', '00:23:03', '£2.13'] )
		verifyCallDetails( callCharges[27], ['02074351359', '00:23:03', '£2.13'] )
		
		and: 'The total call cost is displayed'
		assert callCost.text() == 'Call charges total: £59.64'
	}

	private void verifyPackageDetails( packageDetails, expectedDetails ) {
		assert packageDetails.name == expectedDetails[0]
		assert packageDetails.type == expectedDetails[1]
		assert packageDetails.cost == expectedDetails[2]
	}
	
	private void verifyCallDetails( callDetails, expectedDetails ){
		assert callDetails.called == expectedDetails[0]
		assert callDetails.duration == expectedDetails[1]
		assert callDetails.cost == expectedDetails[2]
	}
}