package com.system.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcessOverDueResponse {
	private double amount;
	private LocalDate due_date;
	private String status;

	public ProcessOverDueResponse(double amount, LocalDate due_date, String status) {
		super();
		this.amount = amount;
		this.due_date = due_date;
		this.status = status;
	}
}
