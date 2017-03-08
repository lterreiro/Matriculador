/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nls.formacao.matriculador.descarregador;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import nls.formacao.matriculador.Menu;
import nls.formacao.matriculador.Registo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Formação
 */
public class DesCarregadorExcel implements DesCarregador {

    private final SecureRandom random = new SecureRandom();

    private static final Log LOG = LogFactory.getLog(DesCarregadorExcel.class);

    @Override
    public void escrever(String info) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void escrever(Registo[] info) {

        String filename = Utils.obtemNomeFicheiro("xls");
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Matriculas");

            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell(0).setCellValue("Matricula");
            rowhead.createCell(1).setCellValue("Nome");
            rowhead.createCell(2).setCellValue("Data Nascimento");
            rowhead.createCell(3).setCellValue("Endereco");
            rowhead.createCell(4).setCellValue("Email");

            for (int i = 0; i < info.length; i++) {
                Registo registo = info[i];
                if(registo != null){
                    HSSFRow row = sheet.createRow((short) 1);
                    row.createCell(0).setCellValue(registo.getMatricula().matriculaCompleta());
                    row.createCell(1).setCellValue(registo.getNome().nomeCompleto());
                    row.createCell(2).setCellValue(registo.getDataNascimentoStr());
                    row.createCell(3).setCellValue(registo.getEndereco().enderecoCompleto());
                    row.createCell(4).setCellValue(registo.getEmail());

                    try (FileOutputStream fileOut = new FileOutputStream(filename)) {
                        workbook.write(fileOut);
                    }
                }
            }
        } catch (IOException ex) {
            LOG.error("Erro a criar ficheiro excel.", ex);
            System.err.println("Erro a criar ficheiro excel.");
        }
        LOG.info(String.format("Informação descarregada com sucesso para o ficheiro '%s'", filename));
        System.out.println(String.format("Informação descarregada com sucesso para o ficheiro '%s'", filename));
    }

    @Override
    public void ler(String meio) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
