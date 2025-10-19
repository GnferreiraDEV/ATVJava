/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.ecommerce;

import com.mycompany.dao.ProdutoDAO;
import com.mycompany.modell.Produto;
import java.util.List;

public class AppEcommerce {

    public static void main(String[] args) {

        ProdutoDAO dao = new ProdutoDAO();

        System.out.println("=== Sistema de Loja Virtual ===\n");

        try {
            System.out.println("Carregando produtos cadastrados...\n");

            List<Produto> lista = dao.buscarTodos();
            mostrarProdutos(lista);

        } catch (Exception erro) {
            System.out.println("\n>>> Erro durante a execução do sistema <<<");
            System.out.println("Detalhes: " + erro.getMessage());
        }

        System.out.println("\nEncerrando o sistema...");
    }

    private static void mostrarProdutos(List<Produto> lista) {
        if (lista == null || lista.isEmpty()) {
            System.out.println("⚠️  Nenhum produto disponível no momento.");
            return;
        }

        System.out.println("Produtos disponíveis para venda:\n");
        System.out.printf("%-6s | %-25s | %-12s | %s%n", "ID", "Nome", "Preço", "Estoque");
        System.out.println("---------------------------------------------------------------");

        for (Produto p : lista) {
            System.out.printf("%-6d | %-25s | R$ %-10.2f | %d unidades%n",
                    p.getId(),
                    p.getNome(),
                    p.getPreco(),
                    p.getQuantidadeEstoque());
        }
    }
}
