package cl.fapp.restapi.controller.impresoras;

import java.awt.*;
import java.awt.print.*;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.apache.pdfbox.printing.PDFPrintable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Print implements Printable {
    private static final double WIDTH_IN_POINTS = 2.8 * 72.0; // 8 centímetros en puntos
    private static final double HEIGHT_IN_POINTS = 11.0 * 72.0; // Altura predeterminada (11 pulgadas en puntos)
    private String filePath; // Ruta del archivo PDF
    // Constructor sin parámetros
    @Autowired
    public Print() {
    }
    // Constructor que acepta la ruta del archivo PDF
    public Print(String filePath) {
        this.filePath = filePath;
    }

    // Método para establecer la ruta del archivo PDF
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        try {
            PDDocument document = PDDocument.load(new File(filePath));
            PDFPrintable printable = new PDFPrintable(document);

            // Configurar el ancho de la zona imprimible al 100% del papel sin márgenes
            Paper paper = pf.getPaper();

            pf.setOrientation(PageFormat.PORTRAIT); // Puedes cambiar a PageFormat.LANDSCAPE si es necesario
            paper.setSize(WIDTH_IN_POINTS, HEIGHT_IN_POINTS);
            paper.setImageableArea(0, 0, WIDTH_IN_POINTS, HEIGHT_IN_POINTS);
            pf.setPaper(paper);

            printable.print(g, pf, pageIndex);

            document.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return PAGE_EXISTS;
    }

    public void print() {
        try {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(this);
            if (filePath == null || filePath.isEmpty()) {
                log.error("La ruta del archivo PDF no está especificada.");
                return;
            }
    
            File pdfFile = new File(filePath);
            if (!pdfFile.exists()) {
                log.error("El archivo PDF no existe en la ruta especificada: {}", filePath);
                return;
            }
            PDDocument document = PDDocument.load(new File(filePath));

            PDFPageable pageable = new PDFPageable(document);

            Book book = new Book();

            PageFormat pageFormat = job.defaultPage();
            Paper paper = new Paper();
            paper.setSize(WIDTH_IN_POINTS, HEIGHT_IN_POINTS);
            paper.setImageableArea(0, 0, WIDTH_IN_POINTS, HEIGHT_IN_POINTS);
            pageFormat.setPaper(paper);

            book.append(new PDFPrintable(document), pageFormat);
            job.setPageable(book);

            // Obtener la impresora predeterminada y establecerla en PrinterJob
            PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
            if (defaultPrintService != null) {
                job.setPrintService(defaultPrintService);
                job.print();
            } else {
                log.error("No se encontró la impresora predeterminada.");
            }

            document.close();
        } catch (IOException | PrinterException ex) {
            ex.printStackTrace();
        }
    }
/* 
    public static void main(String[] args) {
        // Ejemplo de uso
        Print printableService = new Print("c:/borrame/a.pdf");
        printableService.print();
    }
*/
}