package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

public interface ReportCreator {

	ReportBody createReportBody();

	ReportFooter createReportFooter();

	ReportHeader createReportHeader();

}
