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
        asientos = new JButton[40];
        for (int i=0;i<36;i=i+4){
            for (int j=0;j<2;j++){
                asientos[i+j] = new JButton();
                asientos[i+j].setBounds(598+(65*(i/4)),410+(60*j),50,50);
                asientos[i+j].setBackground(Color.white);
                asientos[i+j].addActionListener(this);
                asientos[i+j].setFocusable(false);
                asientos[i+j].setIcon(asientoIcon);
                this.add(asientos[i+j]);

                asientos[i+j+2] = new JButton();
                asientos[i+j+2].setBounds(598+(65*(i/4)),570+(60*j),50,50);
                asientos[i+j+2].setBackground(Color.white);
                asientos[i+j+2].addActionListener(this);
                asientos[i+j+2].setFocusable(false);
                asientos[i+j+2].setIcon(asientoIcon);
                this.add(asientos[i+j+2]);
            }
        }
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
