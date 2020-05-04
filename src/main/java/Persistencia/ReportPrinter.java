
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
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import java.io.IOException;

/**
 * Clase auxiliar que ayuda a imprimir la informacion de un ninno y sus logros
 * Contiene un atributo String con la ruta del archivo a crear y un Objeto de la clase ninno
 * @author Royk
 */
public class ReportPrinter {
    private String path;
    private Ninno ninno;
    
    /**
     * Constructor que define el nombre del archivo a crear y recibe un ninno
     * @param ninno del cual se creara el reporte
     * @param reporte nombre del reporte
     */
    public ReportPrinter(Ninno ninno, String reporte){
        path = "Reporte " + reporte + " de " +ninno.getNombreCompleto() + ".pdf";
        this.ninno = ninno;
    }
    /**
     * Metodo que imprime un archivo pdf con la informacion del ninno
     */
    public void imprimirPDF (){
        try{
            //Creamos "Escritor[
            PdfWriter writer = new PdfWriter(path, new WriterProperties().setPdfVersion(PdfVersion.PDF_2_0));
            //Creamos el documento
            PdfDocument pdfDocument = new PdfDocument(writer);
            pdfDocument.setTagged();
            Document document = new Document(pdfDocument);
            //Añadimos los diferentes parrafos al documento
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

    /**
     * Pone la informacion personal del ninno en una tabla para imprimirla
     * @return Objeto de la clase tabla de la libreria Itext para poner en el pdf
     */
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
    
    /**
     * Crea una tabla con los logros del ninno
     * @return Objeto de la clase tabla de la libreria Itext para poner en el pdf
     */
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
    
    /**
     * Crea una celda con un rotulo y una informacion definida por el rotulo
     * @param rotulo o titulo de la informacion a dar
     * @param informacion informacion a poner en la celda
     * @return Objeto de la clase Cell de la libreria Itext que se pondra en una tabla
     */
    public Cell crearCelda(String rotulo, String informacion){
        Cell cell = new Cell().add(new Paragraph(rotulo).setTextAlignment(TextAlignment.LEFT));
        cell.setFontSize(8f);
        cell.add(new Paragraph(informacion).setTextAlignment(TextAlignment.CENTER).setFontSize(12f));
        
        return cell;
    }
    
    /**
     * Metodo que crea una fuente nueva para el texto
     * @return Objeto de la clase Font de la libreria Itext que contiene la fuente de una letra
     */
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
