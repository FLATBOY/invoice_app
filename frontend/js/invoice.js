document.getElementById('invoce-form').addEventListener('submit', function (e) {
  e.preventDefault();

  const invoice = {
    itemName: document.getElementById('itemName').value,
    quantity: document.getElementById('quantity').value,
    price: document.getElementById('price').value,
    date: new Date().toISOString().split('T')[0]
  };

  fetch('api/invoices', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json'},
    body: JSON.stringify(invoce)
  })
  .then( res => {
      if (res.ok) {
        alert('Invoice created');
        windown.location.href = 'dashboard.html';
      } else {
        alert('Failed to create invoice.');
      }
    });
});


//fetch admin

fetch('/api/me')
.then(res => res.text())
.then(username => {
		if (username === "anonymous") {
				window.location.href = 'index.html';
		}
});
