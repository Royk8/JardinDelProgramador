
package Persistencia;

import Model.Actores.Ninno;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfVersion;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.WriterProperties;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;

/**
 *
 * @author Royk
 */
public class Printer {
    private String path;
    private Ninno ninno;
    
    public Printer(Ninno ninno, String reporte){
        path = "Reporte " + reporte + " de " +ninno.getNombreCompleto() + ".pdf";
    }
    public void print (){
        try{
            PdfWriter writer = new PdfWriter("prueba.pdf", new WriterProperties().setPdfVersion(PdfVersion.PDF_2_0));
            PdfDocument pdfDocument = new PdfDocument(writer);
            pdfDocument.setTagged();
            Document document = new Document(pdfDocument);
            document.add(new Paragraph("Lo importante es que emociones vivi!\nEn este mundo se vive con el muerto por delante!"));
            document.add(printInformacionPersonal());
            document.close();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("PDF Ready");
    }
    
    public Table printInformacionPersonal(){
        Table table = new Table(UnitValue.createPercentArray(8)).useAllAvailableWidth();
        
        for(int i = 0; i < 16; i++){
            table.addCell(Integer.toString(i));
        }
        
        return table;
    }
}
