package br.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DespesaUI {
    public static void listarTodasDespesas() throws SQLException {
        Connection conexao = ConexaoBanco.getConexao();
        System.out.println("TODAS AS DESPESAS");
        System.out.println();

        List<Registro> lista = Despesas();

        for (Registro r : lista) {
            System.out.println(r.getDescricaoRegistro() + " ...... " + r.getValorRegistro());
        }

    }

    public static void adicionarDespesas() throws SQLException {
        Connection conexao = ConexaoBanco.getConexao();
        Scanner value = new Scanner(System.in);
        
        System.out.println("Adicione uma descrição para a despesa: ");
        String desc = value.nextLine();

        System.out.println("Adicione um valor: ");
        double valor = value.nextDouble();

        if (valor<0){
            System.out.println("ATENÇÃO O VALOR DEVE SER POSITIVO!");
            System.out.println("Adicione um valor: ");
            valor = value.nextDouble();

        }
        
        String sql = "INSERT INTO despesa (descricao, valor) VALUES (?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, desc);
        stmt.setDouble(2, valor);
        stmt.execute();

        System.out.println("Operação realizada com sucesso.");


    }

    public static void deletarDespesas() throws SQLException {
        Connection conexao = ConexaoBanco.getConexao();
        List<Registro> lista = Despesas();

        for (Registro r : lista) {
            System.out.println(r.getIdRegistro() + " | " + r.getDescricaoRegistro() + " ...... " + r.getValorRegistro());
        }

        Scanner value = new Scanner(System.in);
        System.out.println("selecione o ID do item desejado");
        String id = value.nextLine();

        
        String sql = "DELETE FROM despesa WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, id);

        int contador = stmt.executeUpdate();
        if (contador > 0) {
            System.out.println("Exclusão efetuada com sucesso!");
        } else {
            System.out.println("Nada feito!");
        }

        conexao.close();
    }

    private static ArrayList Despesas() throws SQLException {

        Connection conexao = ConexaoBanco.getConexao();

        String sql = "SELECT * FROM despesa";

        java.sql.Statement stmt = conexao.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        List<Registro> despesa = new ArrayList<>();

        while (resultado.next()) {
            int id = resultado.getInt("id");
            String descricao = resultado.getString("descricao");
            double valor = resultado.getDouble("valor");
            despesa.add(new Registro(id, descricao, valor));

        }

        stmt.close();
        conexao.close();

        return (ArrayList) despesa;
    }
}
