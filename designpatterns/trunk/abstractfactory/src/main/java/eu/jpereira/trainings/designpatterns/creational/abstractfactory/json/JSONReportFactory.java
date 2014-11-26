package eu.jpereira.trainings.designpatterns.creational.abstractfactory.json;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportCreator;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportHeader;

public class JSONReportFactory implements ReportCreator {

	@Override
	public ReportBody createReportBody() {

		ReportBody body = new JSONReportBody();
		body.getType();
		return body;


	}

	@Override
	public ReportFooter createReportFooter() {
		ReportFooter footer = new JSONReportFooter();
		footer.getType();
		return footer;
	}

	@Override
	public ReportHeader createReportHeader() {
		ReportHeader header = new JSONReportHeader();
		header.getType();
		return header;
	}

}
