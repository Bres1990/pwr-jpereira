package eu.jpereira.trainings.designpatterns.creational.builder.model;


public interface RaportBuilder {

	ReportBody getRaportBody();

	void buildSaleEntry(SaleEntry saleEntry);

}
