
package Persistencia;

import Controller.JardinController;
import Model.Actores.Ninno;
import Model.Actores.Profesor;
import Model.Logro;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfVersion;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.WriterProperties;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import java.io.IOException;

/**
 *
 * @author Royk
 */
public class ReportPrinter {
    private String path;
    private Ninno ninno;
    
    public ReportPrinter(Ninno ninno, String reporte){
        path = "Reporte " + reporte + " de " +ninno.getNombreCompleto() + ".pdf";
        this.ninno = ninno;
    }
    public void imprimirPDF (){
        try{
            PdfWriter writer = new PdfWriter(path, new WriterProperties().setPdfVersion(PdfVersion.PDF_2_0));
            PdfDocument pdfDocument = new PdfDocument(writer);
            pdfDocument.setTagged();
            Document document = new Document(pdfDocument);
            document.add(new Paragraph("Jardin Infantil").setTextAlignment(TextAlignment.CENTER).setFontSize(13f));
            document.add(new Paragraph("El Programador Del Futuro").setTextAlignment(TextAlignment.CENTER).setFontSize(16f).setFont(fontConfig()));
            document.add(new Paragraph("Reporte de Logros").setTextAlignment(TextAlignment.CENTER).setFontSize(12f));
            document.add(printInformacionPersonal());
            document.add(new Paragraph("\nLista de logros").setTextAlignment(TextAlignment.CENTER).setFontSize(12f));
            document.add(printLogros());
            document.close();
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
        System.out.println("PDF Ready");
    }

    
    public Table printInformacionPersonal(){
        Table table = new Table(UnitValue.createPercentArray(2)).useAllAvailableWidth();
        
        Profesor profesor = JardinController.getProfesor(ninno.getProfesor());
        
        table.addCell(crearCelda("Nombre: ", ninno.getNombreCompleto()));
        
        table.addCell(crearCelda(ninno.getIdType() + ": ", ninno.getId()));
        
        table.addCell(crearCelda("Acudiente: ", ninno.getAcudiente().getNombreCompleto()));
        
        table.addCell(crearCelda("De " + ninno.getLogros().size() + " logro" + ((ninno.getLogros().size() == 1)? " ":"s "), ninno.logrosCompletos()));
        
        table.addCell(crearCelda("Nivel " + ninno.getEdad(), "Grupo " + ninno.getGrupo()));
        
        table.addCell(crearCelda("Profesor: ", profesor.getNombreCompleto()));

        return table;
    }
    
    public Table printLogros(){
        Table table = new Table(UnitValue.createPercentArray(3)).useAllAvailableWidth();
        
        Color grisesito = new DeviceRgb(176,163,160);
        Cell cellColumna1 = new Cell().add(new Paragraph("Bimestre").setTextAlignment(TextAlignment.CENTER));
        table.addCell(cellColumna1.setBackgroundColor(grisesito));
        Cell cellColumna2 = new Cell().add(new Paragraph("Logro").setTextAlignment(TextAlignment.CENTER));
        table.addCell(cellColumna2.setBackgroundColor(grisesito));
        Cell cellColumna3 = new Cell().add(new Paragraph("Estado").setTextAlignment(TextAlignment.CENTER));
        table.addCell(cellColumna3.setBackgroundColor(grisesito));
        
        for(Logro logro: ninno.getLogros()){
            Cell cellBimestre = new Cell().add(new Paragraph(logro.getBimestreString()).setTextAlignment(TextAlignment.CENTER));
            table.addCell(cellBimestre);
            Cell cellTitulo = new Cell().add(new Paragraph(logro.getTitulo()).setTextAlignment(TextAlignment.CENTER));
            table.addCell(cellTitulo);
            Cell cellAvance = new Cell().add(new Paragraph(logro.getEstado()).setTextAlignment(TextAlignment.CENTER));
            table.addCell(cellAvance);
        }
        
        return table;
    }
    
    public Cell crearCelda(String rotulo, String informacion){
        Cell cell = new Cell().add(new Paragraph(rotulo).setTextAlignment(TextAlignment.LEFT));
        cell.setFontSize(8f);
        cell.add(new Paragraph(informacion).setTextAlignment(TextAlignment.CENTER).setFontSize(12f));
        
        return cell;
    }
    
    public PdfFont fontConfig(){
        PdfFont font = null;
        try{
            font = PdfFontFactory.createFont(StandardFonts.COURIER_BOLD);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return font;
    }
}
