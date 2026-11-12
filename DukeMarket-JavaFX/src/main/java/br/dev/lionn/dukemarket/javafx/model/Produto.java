package br.dev.lionn.dukemarket.javafx.model;

/**
 *
 * @author sesi2dia
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Produto {

    // Atributos privados
    private int id;
    private String codBarras;
    private String descricao;
    private int qtd;
    private double valorCompra;
    private double valorVenda;
    private Calendar dataCadastro;

    // Construtor vazio
    public Produto() {
    }

    // Construtor cheio
    public Produto(int id, String codBarras, String descricao, int qtd, double valorCompra, double valorVenda, Calendar dataCadastro) {
        this.id = id;
        this.codBarras = codBarras;
        this.descricao = descricao;
        this.qtd = qtd;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.dataCadastro = dataCadastro;
    }

    // Getters e Setters convencionais
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    // 4.4.1 Ajuste do setDataCadastro (para receber String)
    public void setDataCadastro(String strDataCadastro) {
        try {
            this.dataCadastro = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.dataCadastro.setTime(sdf.parse(strDataCadastro));
        } catch (ParseException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // 4.4.2 Ajuste do getDataCadastro (para retornar String formatada)
    public String getDataCadastroFormatada() { // ou podes manter getStrDataCadastro / getFormattedDataCadastro
        if (this.dataCadastro != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return sdf.format(this.dataCadastro.getTime());
        } else {
            return "";
        }
    }

    // 4.4.3 Método toString()
    @Override
    public String toString() {
        return String.format("%3d | %15s | %-30s | %10.2f | %10.2f | %10.2f | %10s", 
                this.id, 
                this.codBarras, 
                this.descricao, 
                (double) this.qtd, 
                this.valorCompra, 
                this.valorVenda, 
                this.getDataCadastroFormatada());
    }
}
