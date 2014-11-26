/**
 * Copyright 2011 Joao Miguel Pereira
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package eu.jpereira.trainings.designpatterns.creational.factorymethod;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class ReportGeneratorTest extends AbstractReportingTest{

	AbstractReport raport = null;
	
	@Test
	public void testCreateJSONReport() {
		ReportData reportData = createDummyReportData();
		ReportGenerator generator = new ReportGenerator();
		JSONReportFactory jsonraport = new JSONReportFactory(reportData);
		Report generatedReport = generator.generateReport(reportData, jsonraport);
		assertEquals("JSON Report. Name: " + reportData.getName(), generatedReport.getReportContent());
	}
	
	
	@Test
	public void testCreateXMLReport() {
		ReportData reportData = createDummyReportData();
		ReportGenerator generator = new ReportGenerator();
		XMLReportFactory xmlraport = new XMLReportFactory(reportData);
		Report generatedReport = generator.generateReport(reportData, xmlraport);
		assertEquals("XML Report. Name: "+reportData.getName(), generatedReport.getReportContent());
	}
	
	@Test
	public void testCreateHTMLReport() {
		ReportData reportData = createDummyReportData();
		ReportGenerator generator = new ReportGenerator();
		HTMLReportFactory htmlraport = new HTMLReportFactory(reportData);
		Report generatedReport = generator.generateReport(reportData, htmlraport);
		assertEquals("HTML Report. Name: "+reportData.getName(), generatedReport.getReportContent());
	}
	
	@Test
	public void testCreatePDFReport() {
		ReportData reportData = createDummyReportData();
		ReportGenerator generator = new ReportGenerator();
		PDFReportFactory pdfraport = new PDFReportFactory(reportData);
		Report generatedReport = generator.generateReport(reportData, pdfraport);
		assertEquals("PDF Report. Name: "+reportData.getName(), generatedReport.getReportContent());
	}
	

	
	
}
