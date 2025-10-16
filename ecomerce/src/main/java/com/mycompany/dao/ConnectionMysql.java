/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import java.sql.Connection;

/**
 *
 * @author gustavo.nferreira
 */
public class ConnectionMysql implements ConnectionBD {
    
    private static final String URL = "jdbc:mysql://localhost:3307/ecomerce";
    private static final String USUARIO = "root";
    private static final String SENHA = "catolica";
    

    @Override
    public Connection obterDados() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void fecharConexao(Connection conexao) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
    
}
