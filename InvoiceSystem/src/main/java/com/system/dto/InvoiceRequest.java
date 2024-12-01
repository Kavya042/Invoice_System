package com.system.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceRequest {
	private double amount;
	private LocalDate due_date;
}
