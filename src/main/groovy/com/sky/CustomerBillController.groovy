package com.sky

import groovy.json.JsonSlurper

import java.text.SimpleDateFormat

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class CustomerBillController {

	String endpoint = 'http://safe-plains-5453.herokuapp.com/bill.json'

	@RequestMapping("/customerBill")
	String displayBill(Model model) {

		String jsonTxt = endpoint.toURL().text
		def json = new JsonSlurper().parseText(jsonTxt)

		model.addAttribute("dueDate", convertToDisplayDate(json.statement.due) )
		model.addAttribute("totalDue", json.total)
		
		"customerBill"
	}

	private String convertToDisplayDate(String inputDate){
		Date.parse("yyyy-MM-dd", inputDate).format("dd/MM/yyyy")
	}
}
