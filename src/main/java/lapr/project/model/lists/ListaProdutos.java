/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Produto;

/**
 *
 * @author zero_
 */
public class ListaProdutos {
    
    private List<Produto> listaProdutos;
    
    public ListaProdutos(){
        listaProdutos = new ArrayList<>();
    }
    
    public boolean addProduto(Produto produto){
        if (!this.listaProdutos.stream().noneMatch((p) -> (p.equals(produto)))) {
            return false;
        }
        return this.listaProdutos.add(produto);
    }
    
    public List<Produto> getListaProdutos() {
        return this.listaProdutos;
    }
    
}
