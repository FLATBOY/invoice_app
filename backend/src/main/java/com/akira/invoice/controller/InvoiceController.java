package com.akira.invoice.controller;

import com.akira.invoice.model.Invoice;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
		private final List<Invoice> invoices = new ArrayList<>();

		@PostMapping
		public void addInvoice(@RequestBody Invoice invoice) {
				System.out.println("Received invoice: " + invoice);
				invoices.add(invoice);
		}

		// @PostMapping
		// public ResponseEntity<?> addInvoice(@RequestBody Invoice invoice) {
		//		try {
		//				invoice.add(invoice);
		//				return ResponseEntity.ok().build();
		//		} catch (Exception e) {
		//				return ResponseEntity.status(500).body("Failed to create invoice: " + e.getMessage());
		//		} 
		// }

		@GetMapping
		public List<Invoice> getAllInvoices() {
				return invoices;
		}

		@GetMapping("/total")
		public double getTotalSpending() {
				return invoices.stream()
						.mapToDouble(inv -> inv.getPrice())
						.sum();
		}
}
