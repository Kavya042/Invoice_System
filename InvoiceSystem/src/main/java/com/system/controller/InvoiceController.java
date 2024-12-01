package com.system.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.dto.InvoiceRequest;
import com.system.dto.InvoiceResponse;
import com.system.dto.PaymentRequest;
import com.system.dto.ProcessOverDueResponse;
import com.system.dto.ProcessOverdueRequest;
import com.system.model.Invoice;
import com.system.service.InoviceService;

@RestController
public class InvoiceController {

	@Autowired
	InoviceService invoiceService;

	@PostMapping("/invoices")
	public ResponseEntity<?> createInvoice(@RequestBody InvoiceRequest request) {
		Invoice invoice = invoiceService.createInvoice(request.getAmount(), request.getDue_date());
		System.out.println("due date is"+request.getDue_date());
		return new ResponseEntity<>(new InvoiceResponse(invoice.getId()), HttpStatus.CREATED);
	}

	@GetMapping("/invoices")
	public List<Invoice> getInvoice(){
		System.out.println("getting invoices");
		return invoiceService.getInvoice();
	}

	@PostMapping(value="/invoices/{id}/payments")
	public ResponseEntity<?> makePayment(@PathVariable Long id, @RequestBody PaymentRequest request){
		Invoice invoice = invoiceService.makePayment(id, request.getAmount());
		if(invoice == null) {
			return new ResponseEntity<>("Invoice not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(invoice, HttpStatus.OK);
	}

	@PostMapping(value="/invoices/process-overdue")
	public ResponseEntity<?> processOverDue(@RequestBody ProcessOverdueRequest request){
		Invoice invoice = invoiceService.processOverDue(request.getLate_fee(), request.getOverdue_days());
		return new ResponseEntity<>(new ProcessOverDueResponse(invoice.getAmount(), invoice.getDue_date(), invoice.getStatus()), HttpStatus.OK);
	}

}
