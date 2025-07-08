document.addEventListener('DOMContentLoaded', function () {
const form = document.getElementById('invoice-form');
	if (!form) {
		console.error("Form not found");
		return;
	}

form.addEventListener('submit', function (e) {
		e.preventDefault();

  const invoice = {
    itemName: document.getElementById('itemName').value,
    quantity: document.getElementById('quantity').value,
unit: document.getElementById('unit')?.value || '',
    price: document.getElementById('price').value,
    date: new Date().toISOString().split('T')[0]
  };

  fetch('api/invoice', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json'},
    body: JSON.stringify(invoice)
  })
	.then(res => {
      if(res.ok) {
        alert('Invoice created');
        window.location.href = 'dashboard.html';
      } else {
        throw new Error('Failed to create invoice.');
      }
    })
	.catch(err => {
		console.error(err);
		alert('Try again');
	});
});
});


//fetch admin
/* 
fetch('/api/me')
.then(res => res.text())
.then(username => {
		if (username === "anonymous") {
				window.location.href = 'index.html';
		}
});
*/
