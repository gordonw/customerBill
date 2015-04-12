package com.sky.test
import geb.Module
import geb.Page

/**
 * Page Object representation of the customer bill page.
 *
 * @author whamondg
 */
class CustomerBillPage extends Page {

	static url = "/customerBill"

	static at = { title == "My Bill" }

	static content = {
		billTitle { $("h1", id:"billTitle") }
		statementDates { $("p", id:"statementDates") }
		totalDue { $("div", id:"totalDue") }
					
		packageSectionTitle { $("h3", id:"packageSectionTitle") }
		packageDetails {
			$("table#packageDetails tbody tr").collect{  module SkyPackageElement, it  }
		}
		packageCost { $("div", id:"packageCost") }
		
		callChargesSectionTitle { $("h3", id:"callChargesTitle") }
		callCharges {
			$("table#callCharges tbody tr").collect{  module CallChargesElement, it  }
		}
		callCost{ $("div", id:"callCost") }

		storeSectionTitle{ $("h3", id:"storeTitle") }
		rentalsTitle{ $("h4", id:"rentalsTitle") }
		rentalsItems {
			$("table#rentals tbody tr").collect{  module StoreElement, it  }
		}
		buyTitle{ $("h4", id:"buyTitle") }
		buyAndKeepItems {
			$("table#buyAndKeep tbody tr").collect{  module StoreElement, it  }
		}
		storeCost{ $("div", id:"storeCost") }
	}

}

class CallChargesElement extends Module {
	static content = {
		cell { i -> $("td", i) }
		called { cell(0).text() }
		duration { cell(1).text() }
		cost { cell(2).text() }
	}
}

class SkyPackageElement extends Module {
	static content = {
		cell { i -> $("td", i) }
		name { cell(0).text() }
		type { cell(1).text() }
		cost { cell(2).text() }
	}
}

class StoreElement extends Module {
	static content = {
		cell { i -> $("td", i) }
		title { cell(0).text() }
		cost { cell(1).text() }
	}
}

