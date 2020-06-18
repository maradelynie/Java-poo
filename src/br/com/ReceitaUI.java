package br.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReceitaUI {
    public static void listarTodasReceitas() throws SQLException {
        System.out.println();
        System.out.println("TODAS AS RECEITAS");
        System.out.println("-----------------");
        System.out.println();

        List<Registro> lista = Receitas();

        for (Registro r : lista) {
            System.out.println(r.getDescricaoRegistro() + " ...... " + r.getValorRegistro());
        }

    }
    
    public static void adicionarReceitas() throws SQLException {
        
        Scanner value = new Scanner(System.in);

        System.out.println("Adicione uma descrição para a receita: ");
        String desc = value.nextLine();

        System.out.println("Adicione o valor: ");
        double valor = value.nextDouble();

        if (valor<0){
            System.out.println("ATENÇÃO O VALOR DEVE SER POSITIVO!");
            System.out.println("Adicione um valor: ");
            valor = value.nextDouble();

        }

        Connection conexao = ConexaoBanco.getConexao();
        String sql = "INSERT INTO receita (descricao, valor) VALUES (?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, desc);
        stmt.setDouble(2, valor);
        stmt.execute();

        System.out.println("Operação realizada com sucesso.");

    }

    public static void deletarReceitas() throws SQLException {
        Connection conexao = ConexaoBanco.getConexao();

        List<Registro> lista = Receitas();

        for (Registro r : lista) {
            System.out.println(r.getIdRegistro() + " | " + r.getDescricaoRegistro() + " ...... " + r.getValorRegistro());
        }

        Scanner value = new Scanner(System.in);

        System.out.println("selecione o ID do item desejado");
        String id = value.nextLine();

        String sql = "DELETE FROM receita WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, id);

        int contador = stmt.executeUpdate();

        if (contador > 0) {
            System.out.println("Exclusão efetuada com sucesso!");
        } else {
            System.out.println("Erro.");
        }

        conexao.close();

    }

    private static ArrayList Receitas() throws SQLException {

        Connection conexao = ConexaoBanco.getConexao();

        String sql = "SELECT * FROM receita";

        java.sql.Statement stmt = conexao.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        List<Registro> receita = new ArrayList<>();

        while (resultado.next()) {
            int id = resultado.getInt("id");
            String descricao = resultado.getString("descricao");
            double valor = resultado.getDouble("valor");
            receita.add(new Registro(id, descricao, valor));

        }

        stmt.close();
        conexao.close();

        return (ArrayList) receita;
    }
}
