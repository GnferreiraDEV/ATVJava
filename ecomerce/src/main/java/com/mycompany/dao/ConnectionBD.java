/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dao;

import java.sql.Connection;

/**
 *
 * @author gustavo.nferreira
 */
public interface ConnectionBD {
    
    Connection obterDados() throws Exception;
    
    void fecharConexao( Connection conexao);
    
}
