/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import javax.swing.JPanel;

/**
 *
 * @author luisponce
 */
public class ContenedorPrincipal {
    private JPanel principal = new JPanel();

    public JPanel getPrincipal() {
        return principal;
    }

    public void setPrincipal(JPanel nuevo) {
        this.getPrincipal().removeAll();
        this.getPrincipal().repaint();
        this.getPrincipal().add(nuevo);
        this.getPrincipal().revalidate();
        this.getPrincipal().repaint();
    }
    
    
}
