package eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportCreator;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportHeader;

public class XMLReportFactory implements ReportCreator {

	@Override
	public ReportBody createReportBody() {
		ReportBody body = new XMLReportBody();
		body.getType();
		return body;

	}

	@Override
	public ReportFooter createReportFooter() {
		ReportFooter footer = new XMLReportFooter();
		footer.getType();
		return footer;
	}

	@Override
	public ReportHeader createReportHeader() {
		ReportHeader header = new XMLReportHeader();
		header.getType();
		return header;
	}

}
