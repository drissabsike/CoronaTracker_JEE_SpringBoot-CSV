package com.exemple.highcharts.OpenPdfClass;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.exemple.highcharts.model.CovidModel;
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

public class CovidPDFExporter1 {
	
	private List<CovidModel> ListCovidModel;

	public CovidPDFExporter1(List<CovidModel> listCovidModel) {
		super();
		ListCovidModel = listCovidModel;
	}
	
	public void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.lightGray);
		cell.setPadding(5);
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.white);
		
		cell.setPhrase(new Phrase("Pays",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Total des cas",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Mort totale",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Récupération totale",font));
		table.addCell(cell);
		
	}
	
	public void writeTableData(PdfPTable table) {
		for(CovidModel cm : ListCovidModel) {
			table.addCell(cm.getPlace());
			table.addCell(String.valueOf(cm.getPTotal_Cases()+"%"));
			table.addCell(String.valueOf(cm.getPTotal_Death()+"%"));
			table.addCell(String.valueOf(cm.getTotal_recupere()+"%"));
		}
		
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		
		document.add(new Paragraph("Liste Covid-19"));
		
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100);
		table.setSpacingBefore(15);
		
		writeTableHeader(table);
		writeTableData(table);
		
		document.add(table);
			
		document.close();
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	



}

