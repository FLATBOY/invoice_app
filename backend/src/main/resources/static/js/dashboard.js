 
window.addEventListener('DOMContentLoaded', () => {
  // Auth check
 /*  fetch('/api/me')
    .then(res => res.text())
    .then(username => {
      if (username === "anonymous") {
        window.location.href = 'index.html';
      }
    });
*/
  // Fetch total spending
  fetch('/api/invoice/total')
    .then(res => res.text())
    .then(amount => {
      const el = document.getElementById('total-spending');
      if (el) {
        el.textContent = parseFloat(amount).toFixed(2);
      }
    });

  // Fetch invoice list
  fetch('/api/invoice')
		.then(res => res.json())
		.then(data => {
				console.log('Fetched invoice data: ', data);
			const table = document.getElementById('invoice-table');
			if (!table) {
				console.error("invoice-table not found in DOM");
				return;
			}

			data.forEach(invoice => {
			const row = document.createElement('tr');
				row.innerHTML = `
					<td>${invoice.itemName}</td>      
					<td>${invoice.quantity}</td>
					<td> ${invoice.unit || ''}</td>
					<td>${parseFloat(invoice.price).toFixed(2)}</td>
					<td>${invoice.date}</td>
				`;
				table.appendChild(row);
			});
			calculateTotal();
		})
		.catch(err => {
			console.error("failed to fetch invoices", err);
			alert('Error loading invoice');
		});
});

function calculateTotal() {
		const rows = document.querySelectorAll('#invoice-table tr');
		let total = 0;

		rows.forEach(row => {
				const priceCell = row.querySelector('td:nth-child(3)');
				const qtyCell = row.querySelector('td:nth-child(2)');

				if (priceCell && qtyCell) {
						const price = parseFloat(priceCell.textContent);
						const qty = parseInt(qtyCell.textContent);
						total += price * qty;
				}
		});

		const totalEl = document.getElementById('total-spending');
		if (totalEl) {
				totalEl.textContent = total.toFixed(2);
		}
}


