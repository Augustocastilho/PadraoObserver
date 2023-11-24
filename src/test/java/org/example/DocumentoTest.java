package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DocumentoTest {

    @Test
    void deveNotificarDocumento() {
        Sistema sistema = new Sistema("Contabilidade");
        Documento documento = new Documento("Notas Fiscais");
        documento.addDocumentoNoSistema(sistema);
        sistema.lancarDocumento();
        assertEquals("O documento Notas Fiscais foi inserido no sistema Contabilidade.", documento.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarDocumento() {
        Sistema sistema = new Sistema("Contabilidade");
        Documento documento = new Documento("Notas Fiscais");
        sistema.lancarDocumento();
        assertEquals(null, documento.getUltimaNotificacao());
    }

    @Test
    void deveNotificarDocumentoSistemaContabilidade() {
        Sistema sistemaContabilidade = new Sistema("Contabilidade");
        Sistema sistemaRH = new Sistema("RH");
        Documento documento1 = new Documento("Notas Fiscais");
        Documento documento2 = new Documento("Funcionários");
        documento1.addDocumentoNoSistema(sistemaContabilidade);
        documento2.addDocumentoNoSistema(sistemaRH);
        sistemaContabilidade.lancarDocumento();
        assertEquals("O documento Notas Fiscais foi inserido no sistema Contabilidade.", documento1.getUltimaNotificacao());
        assertEquals(null, documento2.getUltimaNotificacao());
    }

}