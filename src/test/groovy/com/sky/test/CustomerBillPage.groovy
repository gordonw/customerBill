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
		totalDue { $("div", id:"totalDue") }
		billTitle { $("h1", id:"billTitle") }
		statementDates { $("p", id:"statementDates") }
		packageBreakdownTitle { $("h3", id:"packageBreakdownTitle") }
		packageBreakdown {
			$("table#skyPackage tbody tr").collect{  module SkyPackageElement, it  }
		}
		packageTotal { $("div", id:"packageTotal") }
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