package com.sky

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class CustomerBillController {
	@RequestMapping("/customerBill")
	String displayBill() {
		"customerBill"
	}
}
