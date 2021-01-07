package com.exemple.highcharts.OpenPdfClass;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.exemple.highcharts.model.Maroc_cas;
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

public class CovidPDFExporter3 {
	
	private List<Maroc_cas> ListCovidModel3;
	
	public CovidPDFExporter3(List<Maroc_cas> listCovidModel3) {
		super();
		ListCovidModel3 = listCovidModel3;
	}

	public void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.lightGray);
		cell.setPadding(5);
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.white);
		
		cell.setPhrase(new Phrase("Lieu",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Les cas",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Guérison",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Décès",font));
		table.addCell(cell);
		
	}
	
	public void writeTableData(PdfPTable table) {
		for(Maroc_cas cm : ListCovidModel3) {
			table.addCell(cm.getLieu());
			table.addCell(String.valueOf(cm.getCas()));
			table.addCell(String.valueOf(cm.getGuerisons()));
			table.addCell(String.valueOf(cm.getDeces()));
		}
		
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		
		document.add(new Paragraph("Liste Covid-19 au Maroc"));
		
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100);
		table.setSpacingBefore(15);
		
		writeTableHeader(table);
		writeTableData(table);
		
		document.add(table);
			
		document.close();
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	



}

