package com.system.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.system.model.Invoice;
import com.system.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InoviceService{

	@Autowired
	InvoiceRepository invoiceRepository;

	@Override
	public Invoice createInvoice(double amount, LocalDate due_date) {
		Invoice invoice = new Invoice(amount, due_date);
		return invoiceRepository.save(invoice);
	}

	@Override
	public List<Invoice> getInvoice() {
		return invoiceRepository.findAll();
	}

	@Override
	public Invoice makePayment(Long id, double paymentAmount) {
		Optional<Invoice> foundInvoice = invoiceRepository.findById(id);
		if(foundInvoice.isPresent()) {
			Invoice invoice = foundInvoice.get();
			invoice.setPaid_amount(invoice.getPaid_amount() + paymentAmount);
			if(invoice.getPaid_amount() == 0.0) {
				invoice.setStatus("void");
			} else {
				invoice.setStatus("paid");
			}
			return invoiceRepository.save(invoice);
		}
		return null;
	}

	@Override
	public Invoice processOverDue(double late_fee, int overdue_days) {
		List<Invoice> overdueInvoices = invoiceRepository.findByStatus("paid");

		for(Invoice invoice : overdueInvoices) {
			double newAmount = (invoice.getAmount() - invoice.getPaid_amount()) + late_fee;
			invoice.setAmount(newAmount);
			invoice.setPaid_amount(0.0);
			invoice.setDue_date(invoice.getDue_date().plusDays(overdue_days));
			return invoiceRepository.save(invoice);
		}
		return null;
	}

}
