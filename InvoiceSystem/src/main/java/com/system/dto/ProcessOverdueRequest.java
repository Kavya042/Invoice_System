package com.system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcessOverdueRequest {
	private double late_fee;
	private int overdue_days;
}
