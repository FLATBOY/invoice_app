package com.akira.invoice.repositoy;

import com.akira.invoice.entity.User;
import com.akira.invoice.entity.Invoice;
import org.springframework.data.jpa.reposioty.JpaRepository;
import java.util.List;

public interface InvoiceReposioty extends JpaReposioty<Invoice, Long> {
		List<Invoice> findByUser(User user);
}
