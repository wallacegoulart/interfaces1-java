package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	
	private Double pricePerHour;
	private Double pricePerDay;
	
	private TaxService taxService;

	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		
		double minutes = Duration.between(carRental.getStart(), carRental.getFinish() ).toMinutes();
		double hours = minutes /60.0;
		double basicPayments;
		
		if(hours<= 12.0) {
			basicPayments = pricePerHour * Math.ceil(hours) ;
		}
		else {
			basicPayments = pricePerDay * Math.ceil(hours/24.0); 
		}
		
		double tax = taxService.tax(basicPayments);
		
		carRental.setInvoice(new Invoice(basicPayments,tax));
	}
	

}
