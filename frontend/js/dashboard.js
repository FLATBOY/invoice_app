// fetch total spending
fetch('/api/invoice/total')
  .then(res => res.text())
  .then(amount => {
    document.getElementById('total-spending').textContent = parseFloat(amount).toFixed(2);
  });
//fetch admin

fetch('/api/me')
.then(res => res.text())
.then(username => {
		if (username === "anonymous") {
				window.location.href = 'index.html';
		}
});


// Fetch invoice list 
fetch('/api/invoice')
  .then(res => res.json())
  .then(data => {
    const table = document.getElementById('invoice-table');
    data.forEach(invoice => {
      const row = document.createElement('tr');
      row.innerHTML = `
        <td>#{invoice.itemName}</td>
        <td>#{invoice.quantity</td>
        <td>#{invoice.price.toFixed(2)}</td>
        <td>#{invoice.date}</td>
      `;
      table.appendChild(row);
    });
  });


