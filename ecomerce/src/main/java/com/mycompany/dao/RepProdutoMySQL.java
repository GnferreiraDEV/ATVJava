/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.Produto;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private final ConexaoBD banco;

    public ProdutoDAO() {
        this.banco = new ConexaoMySQL();
    }

    public List<Produto> buscarTodos() throws Exception {
        List<Produto> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = banco.obterConexao();
            String query = "SELECT id, nome, descricao, preco, quantidade_estoque, data_cadastro FROM produtos";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getBigDecimal("preco"));
                p.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
                p.setDataCadastro(rs.getTimestamp("data_cadastro"));
                lista.add(p);
            }
        } catch (SQLException erro) {
            System.out.println("Problema ao buscar produtos: " + erro.getMessage());
            throw new Exception("Erro ao acessar o banco de dados de produtos.", erro);
        } finally {
            liberarRecursos(conn, ps, rs);
        }

        return lista;
    }

    private void liberarRecursos(Connection c, PreparedStatement s, ResultSet r) {
        try {
            if (r != null) r.close();
        } catch (SQLException e) {
            System.out.println("Falha ao fechar ResultSet: " + e.getMessage());
        }

        try {
            if (s != null) s.close();
        } catch (SQLException e) {
            System.out.println("Falha ao fechar PreparedStatement: " + e.getMessage());
        }

        if (c != null) {
            banco.fecharConexao(c);
        }
    }
}
