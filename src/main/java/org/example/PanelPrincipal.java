package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CompletableFuture;

/**
 * Crea el panel que contendra al panel comprador y panel expendedor en su interior, se encarga de juntar ambos
 * paneles para mostrarse en uno solo para la Ventana
 */
public class PanelPrincipal extends JPanel implements ActionListener{
    private JComboBox origen,destino;
    private JButton busqueda,ConfirmarPago;
    private JLabel textAsientos,textHorarios;
    private String[] ciudadOrigen,ciudadDestino;
    private String auxrec;
    private Icon a;
    /**
     * Metodo constructor que crea instancias del panel comprador y panel expendedor
     * Ademas define los limites del panel
     */
    public PanelPrincipal(){
        this.setLayout(null);
        this.setBackground(new Color(188,227,255));
        this.setVisible(true);

        ciudadOrigen = new String[] {String.valueOf(Recorridos.SANTIAGO),String.valueOf(Recorridos.CONCEPCION),String.valueOf(Recorridos.CHILLAN)};
        ciudadDestino = new String[] {String.valueOf(Recorridos.SANTIAGO),String.valueOf(Recorridos.CONCEPCION),String.valueOf(Recorridos.CHILLAN)};
        origen = new JComboBox(ciudadOrigen);
        origen.addActionListener(this);
        origen.setBounds(100,50,300,50);
        origen.setFocusable(false);
        this.add(origen);
        destino = new JComboBox(ciudadDestino);
        destino.addActionListener(this);
        destino.setBounds(450,50,300,50);
        destino.setFocusable(false);
        this.add(destino);

        a = new ImageIcon("lupa.png");
        busqueda = new JButton(a);
        busqueda.setBounds(800,50,50,50);
        busqueda.setIcon(a);
        busqueda.addActionListener(this);
        this.add(busqueda);

        ConfirmarPago = new JButton("Confirmar Pago");
        ConfirmarPago.setBounds(1000,750,200,50);
        ConfirmarPago.setFocusable(false);
        this.add(ConfirmarPago);

        textAsientos = new JLabel("Asientos");
        textAsientos.setBounds(800,324,100,50);
        this.add(textAsientos);

        textHorarios = new JLabel("Horarios");
        textHorarios.setBounds(175,324,100,50);
        this.add(textHorarios);
    }

    /**
     * Metodo que se encarga de la parte visual del panel
     * @param g  the <code>Graphics</code> context in which to paint
     */
    public void paint (Graphics g){
        super.paint(g);
        g.setColor(Color.white);
        g.fillRect(500,374, 700, 350);                               //Panel Asientos
        g.setColor(Color.black);
        g.drawRect(500,324, 700, 400);                               //Panel asientos Borde
        g.drawLine(500,374,1200,374);
        g.setColor(Color.white);
        g.fillRect(50,374, 300, 350);                               //Panel Horarios
        g.setColor(Color.black);
        g.drawRect(50,324, 300, 400);                               //Panel Horarios Borde
        g.drawLine(50,374,350,374);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==origen){
            if (auxrec!=null){
                destino.addItem(auxrec);
            }
            auxrec = origen.getSelectedItem().toString();
            destino.removeItem(origen.getSelectedItem());
        }
    }
}
