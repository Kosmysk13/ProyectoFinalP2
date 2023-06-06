package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Crea el panel que contendra al panel comprador y panel expendedor en su interior, se encarga de juntar ambos
 * paneles para mostrarse en uno solo para la Ventana
 */
public class PanelPrincipal extends JPanel implements ActionListener{
    private JComboBox origen,destino;
    private JButton busqueda;
    private String[] ciudadOrigen,ciudadDestino;
    /**
     * Metodo constructor que crea instancias del panel comprador y panel expendedor
     * Ademas define los limites del panel
     */
    public PanelPrincipal(){
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(188,227,255));
        this.setVisible(true);

        ciudadOrigen = new String[] {String.valueOf(Recorridos.SANTIAGO),String.valueOf(Recorridos.CONCEPCION),String.valueOf(Recorridos.CHILLAN)};
        ciudadDestino = new String[] {String.valueOf(Recorridos.SANTIAGO),String.valueOf(Recorridos.CONCEPCION),String.valueOf(Recorridos.CHILLAN)};
        origen = new JComboBox(ciudadOrigen);
        origen.addActionListener(this);
        this.add(origen);
        destino = new JComboBox(ciudadDestino);
        destino.addActionListener(this);
        this.add(destino);

        busqueda = new JButton();
        busqueda.setBounds(700,10,25,25);
        busqueda.addActionListener(this);
        busqueda.setFocusable(false);
        busqueda.setIcon(new ImageIcon("lupa.png"));
        this.add(busqueda);
    }

    /**
     * Metodo que se encarga de la parte visual del panel
     * @param g  the <code>Graphics</code> context in which to paint
     */
    public void paint (Graphics g){
        super.paint(g);
        g.setColor(Color.white);
        g.fillRect(500,324, 700, 600);                               //Panel Asientos
        g.setColor(Color.black);
        g.drawRect(500,324, 700, 600);                               //Panel asientos Borde
        g.setColor(Color.white);
        g.fillRect(50,324, 300, 600);                               //Panel Horarios
        g.setColor(Color.black);
        g.drawRect(50,324, 300, 600);                               //Panel Horarios Borde
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==origen){
            destino.removeItem(origen.getSelectedItem());
        }
    }
}
