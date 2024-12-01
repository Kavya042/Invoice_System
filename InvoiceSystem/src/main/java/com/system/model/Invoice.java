package com.system.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Invoice")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "amount")
	private double amount;

	@Column(name = "paid_amount")
	private double paid_amount;

	@Column(name = "due_date")
	private LocalDate due_date;

	@Column(name = "status")
	private String status = "pending";

	public Invoice(double amount, LocalDate due_date) {
		super();
		this.amount = amount;
		this.due_date = due_date;
	}

}
