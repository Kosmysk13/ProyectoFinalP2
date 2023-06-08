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
    private JButton busqueda,ConfirmarPago;
    private JButton asiento1,asiento2,asiento3,asiento4;
    private JButton[] asientos;
    private JRadioButton[] horarios;
    private ButtonGroup horariosG;
    private JLabel textAsientos,textHorarios;
    private String[] ciudadOrigen,ciudadDestino;
    private String auxrec;
    private Icon a;
    private Icon asientoIcon;
    private boolean auxBus=true;
    private int hora=12;
    /**
     * Metodo constructor que crea instancias del panel comprador y panel expendedor
     * Ademas define los limites del panel
     */
    public PanelPrincipal(){
        this.setLayout(null);
        this.setBackground(new Color(188,227,255));
        this.setVisible(true);

        ciudadOrigen = new String[] {String.valueOf(Recorridos.SANTIAGO),String.valueOf(Recorridos.CONCEPCION),String.valueOf(Recorridos.CHILLAN),String.valueOf(Recorridos.LOS_ANGELES)};
        ciudadDestino = new String[] {String.valueOf(Recorridos.SANTIAGO),String.valueOf(Recorridos.CONCEPCION),String.valueOf(Recorridos.CHILLAN),String.valueOf(Recorridos.LOS_ANGELES)};
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

        a = new ImageIcon("src/main/lupa.png");
        busqueda = new JButton(a);
        busqueda.setBounds(800,50,50,50);
        busqueda.setIcon(a);
        busqueda.addActionListener(this);
        busqueda.setFocusable(false);
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

        horarios = new JRadioButton[6];
        horariosG = new ButtonGroup();

        asientoIcon = new ImageIcon("src/main/asientoHLibre.png");

        asiento1 = new JButton();
        asiento1.setBounds(598,410,50,50);
        asiento1.setBackground(Color.white);
        asiento1.addActionListener(this);
        asiento1.setFocusable(false);
        asiento1.setIcon(asientoIcon);

        asiento2 = new JButton();
        asiento2.setBounds(598,470,50,50);
        asiento2.setBackground(Color.white);
        asiento2.addActionListener(this);
        asiento2.setFocusable(false);
        asiento2.setIcon(new ImageIcon("src/main/asientoHOcupado.png"));

        asiento3 = new JButton();
        asiento3.setBounds(598,570,50,50);
        asiento3.setBackground(Color.white);
        asiento3.addActionListener(this);
        asiento3.setFocusable(false);
        asiento3.setIcon(new ImageIcon("src/main/asientoHOcupado.png"));

        asiento4 = new JButton();
        asiento4.setBounds(598,630,50,50);
        asiento4.setBackground(Color.white);
        asiento4.addActionListener(this);
        asiento4.setFocusable(false);
        asiento4.setIcon(new ImageIcon("src/main/asientoHOcupado.png"));

        this.add(asiento1);
        this.add(asiento2);
        this.add(asiento3);
        this.add(asiento4);
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
        g.drawRect(599,409,51,51);
        g.drawRect(599,469,51,51);
        g.drawRect(599,569,51,51);
        g.drawRect(599,629,51,51);
        g.setColor(Color.white);
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
        if (e.getSource()==busqueda){
            for (int i=0;i<6;i++){
                horarios[i] = new JRadioButton("SALIDA: "+(hora+i)+":00 - LLEGADA: "+(hora+i+2)+":00");
                horarios[i].setBounds(100,392+(50*i),250,50);
                horarios[i].setBackground(Color.white);
                horarios[i].setVisible(auxBus);
                horarios[i].setFocusable(false);
                horarios[i].addActionListener(this);
                horariosG.add(horarios[i]);
                this.add(horarios[i]);
            }
            repaint();
        }
        if (e.getSource()==asiento1){
            asientoIcon = new ImageIcon("src/main/asientoHOcupado.png");
            repaint();
        }

    }
}
