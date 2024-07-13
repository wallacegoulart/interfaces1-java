package model.entities;

public class Invoice {
	
	private Double basicPayment; 
	private Double tax;
	
	
	public Invoice() {	
	}


	public Invoice(Double basciPayment, Double tax) {
		this.basicPayment = basciPayment;
		this.tax = tax;
	}


	public Double getBasicPayment() {
		return basicPayment;
	}


	public void setBasciPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}


	public Double getTax() {
		return tax;
	}


	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	public Double getTotalPayment() {
		return getBasicPayment() + getTax();
	}
	

}
