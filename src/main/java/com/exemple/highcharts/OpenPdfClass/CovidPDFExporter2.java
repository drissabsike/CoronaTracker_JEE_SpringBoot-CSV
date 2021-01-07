package com.exemple.highcharts.OpenPdfClass;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.exemple.highcharts.model.World_Covid;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class CovidPDFExporter2 {
	
	private List<World_Covid> ListCovidModel2;

	
	public CovidPDFExporter2(List<World_Covid> listCovidModel2) {
		super();
		ListCovidModel2 = listCovidModel2;
	}

	public void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.lightGray);
		cell.setPadding(5);
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.white);
		
		cell.setPhrase(new Phrase("Pays",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Total_Cases",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("New_Cases",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Total_Deaths",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("News_Deaths",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Total_Recovered",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Actives_Cases",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Critical",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Tests",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Population",font));
		table.addCell(cell);
		
	}
	
	public void writeTableData(PdfPTable table) {
		for(World_Covid cm : ListCovidModel2) {
			table.addCell(cm.getPlace());
			table.addCell(cm.getTotal_Cases());
			table.addCell(cm.getNew_Cases());
			table.addCell(cm.getTotal_Deaths());
			table.addCell(cm.getNews_Deaths());
			table.addCell(cm.getTotal_Recovered());
			table.addCell(cm.getActives_Cases());
			table.addCell(cm.getCritical());
			table.addCell(cm.getTests());
			table.addCell(cm.getPopulation());
		}
		
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		
		document.add(new Paragraph("Liste Covid-19"));
		
		PdfPTable table = new PdfPTable(10);
		table.setWidthPercentage(100);
		table.setSpacingBefore(15);
		
		writeTableHeader(table);
		writeTableData(table);
		
		document.add(table);
			
		document.close();
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	



}

