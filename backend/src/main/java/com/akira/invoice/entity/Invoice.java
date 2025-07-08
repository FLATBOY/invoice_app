package com.akira.invoice.entity;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Enity

public class Invoice {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private String itemName;
		private double quantity; // <-- Use for kg/gr
		private double price;
		private String unit; // <-- use for unit item
		private String date;
		//Constructors
		public Invoice(){

		}
		public Invoice(String itemName, double quantity, double price, String unit, String date){
				this.itemName = itemName;
				this.quantity = quantity;
				this.price = price;
				this.unit = unit;
				this.date = date;
		}

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "user_id")
		private User user;


		//Getter & Setters
		public String getItemName() {return itemName;}
		public void setItemName(String itemName) {this.itemName = itemName;}

		public double getQuantity() {return quantity;}
		public void setQuantity(double quantity) {this.quantity = quantity;}

		public double getPrice() {return price;}
		public void setPrice(double price) {this.price = price;}

		public String getUnit() {return unit;}
		public void setUnit(String unit) {this.unit = unit;}

		public String getDate() {return date;}
		public void setDate(String date) {this.date = date;}

}

