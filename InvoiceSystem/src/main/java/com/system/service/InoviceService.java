package com.system.service;

import java.time.LocalDate;
import java.util.List;
import com.system.model.Invoice;

public interface InoviceService {
	
	public Invoice createInvoice(double amount, LocalDate due_date);
	
	public List<Invoice> getInvoice();
	
	public Invoice makePayment(Long id, double amount);
	
	public Invoice processOverDue(double late_fee,int overdue_days);
	
}
