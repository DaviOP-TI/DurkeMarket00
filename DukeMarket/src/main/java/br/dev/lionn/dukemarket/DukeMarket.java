/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.dev.lionn.dukemarket;

import br.dev.lionn.dukemarket.bean.Produto;
import br.dev.lionn.dukemarket.dao.ProdutoDAO;

/**
 *
 * @author sesi2dia
 */
public class DukeMarket {

    public static void main(String[] args) {

        ProdutoDAO pDAO = new ProdutoDAO();
        Produto pAux;

        System.out.println("=== FASE 1: INCLUSÃO DE PRODUTOS ===");
        
        pAux = new Produto();
        pAux.setCodBarras("111111111");
        pAux.setDescricao("Mouse Logitech Bluetooth");
        pAux.setQtd(50);
        pAux.setValorCompra(80.00);
        pAux.setValorVenda(167.00);
        pDAO.create(pAux);

        pAux = new Produto();
        pAux.setCodBarras("222222222");
        pAux.setDescricao("Teclado USB Gamer");
        pAux.setQtd(80);
        pAux.setValorCompra(104.00);
        pAux.setValorVenda(220.00);
        pDAO.create(pAux);

        pAux = new Produto();
        pAux.setCodBarras("333333333");
        pAux.setDescricao("Microcomputador Dell");
        pAux.setQtd(110);
        pAux.setValorCompra(2400.00);
        pAux.setValorVenda(3290.00);
        pDAO.create(pAux);

        System.out.println("\n--- Lista de Produtos Cadastrados ---");
        pDAO.getResults().forEach(p -> System.out.println(p.toString()));
       
        // Teste de exclusão de produto
        pDAO.delete(3);

        //Lista geral
        pDAO.getResults().forEach(p -> {
            System.out.println(p.toString());
        });

        //Teste de alteração de produto
        pAux = pDAO.getResultById(1);
        pAux.setQtd(100);
        pDAO.update(pAux);

        //Lista Geral
        pDAO.getResults().forEach(p -> {
            System.out.println(p.toString());
        });
        
        
    }

}
