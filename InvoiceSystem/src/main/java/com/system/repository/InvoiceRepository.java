package com.system.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.system.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
	List<Invoice> findByStatus(String status);
}
