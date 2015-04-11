package com.sky.test
import geb.Page

/**
 * Page Object representation of the customer bill page.
 *
 * @author whamondg
 */
class CustomerBillPage extends Page {

    static url = "/myBill"
    
    static at = { title == "My Bill" }
   
}