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
    private JButton busqueda,ConfirmarPago,ElegirHorario;
    private JButton[] asientos;
    private JRadioButton[] horarios;
    private ButtonGroup horariosG;
    private JLabel textAsientos,textHorarios;
    private String[] ciudadOrigen,ciudadDestino;
    private String auxrec;
    private boolean auxBus=true,auxAsientos;
    private boolean[] ocupado;
    private int hora=12,auxHorarios;
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
        origen.setBounds(200,50,300,50);
        origen.setFocusable(false);
        this.add(origen);
        destino = new JComboBox(ciudadDestino);
        destino.addActionListener(this);
        destino.setBounds(550,50,300,50);
        destino.setFocusable(false);
        this.add(destino);

        busqueda = new JButton("   BUSCAR");
        busqueda.setBounds(900,50,120,50);
        busqueda.setIcon(new ImageIcon("src/main/lupa.png"));
        busqueda.addActionListener(this);
        busqueda.setFocusable(false);
        this.add(busqueda);

        ConfirmarPago = new JButton("Confirmar Pago");
        ConfirmarPago.setBounds(1000,750,200,50);
        ConfirmarPago.setFocusable(false);
        this.add(ConfirmarPago);

        ElegirHorario = new JButton("Elegir Horario");
        ElegirHorario.setBounds(50,750,300,50);
        ElegirHorario.setFocusable(false);
        ElegirHorario.addActionListener(this);
        this.add(ElegirHorario);

        textAsientos = new JLabel("Asientos");
        textAsientos.setBounds(800,324,100,50);
        this.add(textAsientos);

        textHorarios = new JLabel("Horarios");
        textHorarios.setBounds(175,254,100,50);
        this.add(textHorarios);

        horarios = new JRadioButton[8];
        horariosG = new ButtonGroup();

        asientos = new JButton[36];
        ocupado = new boolean[36];
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
        g.fillRect(50,304, 300, 420);                               //Panel Horarios
        g.setColor(Color.black);
        g.drawRect(50,254, 300, 470);                               //Panel Horarios Borde
        g.drawLine(50,304,350,304);
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
            for (int i=0;i<8;i++){
                horarios[i] = new JRadioButton("SALIDA: "+(hora+i)+":00 - LLEGADA: "+(hora+i+2)+":00");
                horarios[i].setBounds(100,315+(50*i),250,50);
                horarios[i].setBackground(Color.white);
                horarios[i].setVisible(auxBus);
                horarios[i].setFocusable(false);
                horarios[i].addActionListener(this);
                horariosG.add(horarios[i]);
                this.add(horarios[i]);
            }
        }
        for (int i=0;i<8;i++){
            if (e.getSource()==horarios[i]){
                auxHorarios=i;
                if (asientos[0]!=null){
                    for (int k=0;k<36;k=k+4){
                        for (int j=0;j<2;j++){
                            this.remove(asientos[k+j]);
                            this.remove(asientos[k+j+2]);
                            ocupado[k+j]=true;
                            ocupado[k+j+2]=true;
                            repaint();
                        }
                    }
                }
            }
        }
        if (e.getSource()==ElegirHorario){
            if (auxHorarios<4){
                auxAsientos = false;
                for (int k=0;k<36;k=k+4){
                    for (int j=0;j<2;j++){
                        asientos[k+j] = new JButton();
                        asientos[k+j].setBounds(598+(65*(k/4)),410+(60*j),50,50);
                        asientos[k+j].setBackground(Color.white);
                        asientos[k+j].addActionListener(this);
                        asientos[k+j].setFocusable(false);
                        asientos[k+j].setIcon(new ImageIcon("src/main/asientoSCLibre.png"));
                        this.add(asientos[k+j]);

                        asientos[k+j+2] = new JButton();
                        asientos[k+j+2].setBounds(598+(65*(k/4)),570+(60*j),50,50);
                        asientos[k+j+2].setBackground(Color.white);
                        asientos[k+j+2].addActionListener(this);
                        asientos[k+j+2].setFocusable(false);
                        asientos[k+j+2].setIcon(new ImageIcon("src/main/asientoSCLibre.png"));
                        this.add(asientos[k+j+2]);

                        ocupado[k+j]=false;
                        ocupado[k+j+2]=false;
                    }
                }
            }else{
                auxAsientos = true;
                for (int k=0;k<36;k=k+4){
                    for (int j=0;j<2;j++){
                        asientos[k+j] = new JButton();                                            //Asiento Premium
                        asientos[k+j].setBounds(598+(118*(k/8)),410,103,50);
                        asientos[k+j].setBackground(Color.white);
                        asientos[k+j].addActionListener(this);
                        asientos[k+j].setFocusable(false);
                        asientos[k+j].setIcon(new ImageIcon("src/main/asientoPLibre.png"));
                        this.add(asientos[k+j]);

                        asientos[k+j+2] = new JButton();                                          //Asiento Cama
                        asientos[k+j+2].setBounds(598+(96*(k/6)),570+(60*j),81,50);
                        asientos[k+j+2].setBackground(Color.white);
                        asientos[k+j+2].addActionListener(this);
                        asientos[k+j+2].setFocusable(false);
                        asientos[k+j+2].setIcon(new ImageIcon("src/main/asientoCLibre.png"));
                        this.add(asientos[k+j+2]);

                        ocupado[k+j]=false;
                        ocupado[k+j+2]=false;
                    }
                }
            }
        }
        for (int i=0;i<36;i++){
            if (auxAsientos==false){
                if (e.getSource()==asientos[i]){
                    if (ocupado[i]==false){
                        asientos[i].setIcon(new ImageIcon("src/main/asientoSCOcupado.png"));
                        ocupado[i]=true;
                    }else{
                        asientos[i].setIcon(new ImageIcon("src/main/asientoSCLibre.png"));
                        ocupado[i]=false;
                    }
                }
            }else{
                if (e.getSource()==asientos[i]){
                    if (i%8==0){
                        if (ocupado[i]==false){
                            asientos[i].setIcon(new ImageIcon("src/main/asientoPOcupado.png"));
                            ocupado[i]=true;
                        }else{
                            asientos[i].setIcon(new ImageIcon("src/main/asientoPLibre.png"));
                            ocupado[i]=false;
                        }
                    }else{
                        if (ocupado[i]==false){
                            asientos[i].setIcon(new ImageIcon("src/main/asientoCOcupado.png"));
                            ocupado[i]=true;
                        }else{
                            asientos[i].setIcon(new ImageIcon("src/main/asientoCLibre.png"));
                            ocupado[i]=false;
                        }
                    }
                }
            }

        }
    }
}
