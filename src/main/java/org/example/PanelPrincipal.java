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
    private PanelAsientos pa;
    private PanelHorarios ph;
    private PanelRecorridos pr;
    private JComboBox origen,destino,pisoBus;
    private JButton busqueda,ConfirmarPago,ElegirHorario,asientos[];
    private JRadioButton[] horarios;
    private ButtonGroup horariosG;
    private JLabel textAsientos,textHorarios;
    private JPanel PanelRecorridos,PanelAsientos,PanelHorarios;
    private String[] ciudadOrigen,ciudadDestino,pisosB;
    private String auxrec;
    private boolean[] ocupado;
    private int hora=12,auxHorarios,auxPiso=1,auxElegirH=0;
    /**
     * Metodo constructor que crea instancias del panel comprador y panel expendedor
     * Ademas define los limites del panel
     */
    public PanelPrincipal(){
        this.setLayout(null);
        this.setBackground(new Color(188,227,255));
        this.setVisible(true);

        pa = new PanelAsientos();
        this.add(pa);
        ph = new PanelHorarios();
        this.add(ph);
        pr = new PanelRecorridos();
        this.add(pr);

        ciudadOrigen = new String[] {String.valueOf(Recorridos.SANTIAGO),String.valueOf(Recorridos.CONCEPCION),String.valueOf(Recorridos.CHILLAN),String.valueOf(Recorridos.LOS_ANGELES)};
        ciudadDestino = new String[] {String.valueOf(Recorridos.CONCEPCION),String.valueOf(Recorridos.SANTIAGO),String.valueOf(Recorridos.CHILLAN),String.valueOf(Recorridos.LOS_ANGELES)};
        pisosB = new String[] {"PRIMER   PISO","SEGUNDO   PISO"};
        asientos = new JButton[36];
        ocupado = new boolean[36];

        origen = new JComboBox(ciudadOrigen);
        origen.addActionListener(this);
        origen.setBounds(120,70,400,50);
        origen.setFocusable(false);
        this.add(origen);
        destino = new JComboBox(ciudadDestino);
        destino.addActionListener(this);
        destino.setBounds(570,70,400,50);
        destino.setFocusable(false);
        this.add(destino);
        busqueda = new JButton("   BUSCAR");
        busqueda.setBounds(1020,70,120,50);
        busqueda.setIcon(new ImageIcon("src/main/lupa.png"));
        busqueda.addActionListener(this);
        busqueda.setFocusable(false);
        this.add(busqueda);

        pisoBus = new JComboBox(pisosB);
        pisoBus.addActionListener(this);
        pisoBus.setBounds(500,274,700,75);
        pisoBus.setFocusable(false);
        this.add(pisoBus);

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
        textAsientos.setBounds(800,224,100,50);
        this.add(textAsientos);
        textHorarios = new JLabel("Horarios");
        textHorarios.setBounds(175,224,100,50);
        this.add(textHorarios);

        PanelRecorridos = new JPanel();
        PanelRecorridos.setBounds(50,25, 1150, 150);
        PanelRecorridos.setBackground(new Color(99, 132, 180));
        PanelRecorridos.setVisible(true);
        this.add(PanelRecorridos);
        PanelAsientos = new JPanel();
        PanelAsientos.setBounds(500,224, 700, 50);
        PanelAsientos.setBackground(new Color(99, 132, 180));
        PanelAsientos.setVisible(true);
        this.add(PanelAsientos);
        PanelHorarios = new JPanel();
        PanelHorarios.setBounds(50,224, 300, 50);
        PanelHorarios.setBackground(new Color(99, 132, 180));
        this.add(PanelHorarios);
        PanelHorarios.setVisible(true);

        horarios = new JRadioButton[8];
        horariosG = new ButtonGroup();
    }

    /**
     * Metodo que se encarga de la parte visual del panel
     * @param g  the <code>Graphics</code> context in which to paint
     */
    public void paint (Graphics g){
        super.paint(g);
        pa.paint(g);
        ph.paint(g);
        pr.paint(g);
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
                horarios[i].setBounds(100,285+(75*i),250,50);
                horarios[i].setBackground(new Color(188,227,255));
                horarios[i].setFocusable(false);
                horarios[i].addActionListener(this);
                horariosG.add(horarios[i]);
                this.add(horarios[i]);
                repaint();
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
                        }
                    }
                }
                auxElegirH=1;
            }
        }
        if (e.getSource()==ElegirHorario){
            if (auxElegirH==1){
                for (int k=0;k<36;k=k+4){
                    for (int j=0;j<2;j++){
                        asientos[k+j] = new JButton();                                            //Asiento Premium
                        asientos[k+j].setBounds(598+(118*(k/8)),410,103,50);
                        asientos[k+j].setIcon(new ImageIcon("src/main/asientoPLibre.png"));
                        asientos[k+j].setBackground(Color.white);
                        asientos[k+j].addActionListener(this);
                        asientos[k+j].setFocusable(false);
                        this.add(asientos[k+j]);
                        asientos[k+j].setVisible(true);

                        asientos[k+j+2] = new JButton();                                          //Asiento Cama
                        asientos[k+j+2].setBounds(598+(96*(k/6)),570+(60*j),81,50);
                        asientos[k+j+2].setIcon(new ImageIcon("src/main/asientoCLibre.png"));
                        asientos[k+j+2].setBackground(Color.white);
                        asientos[k+j+2].addActionListener(this);
                        asientos[k+j+2].setFocusable(false);
                        this.add(asientos[k+j+2]);
                        asientos[k+j+2].setVisible(true);

                        ocupado[k+j]=false;
                        ocupado[k+j+2]=false;
                    }
                }
                auxElegirH=2;
            }
            repaint();
        }
        if (e.getSource()==pisoBus){
            if ((pisoBus.getSelectedItem()=="PRIMER   PISO")&&(auxPiso==2)&&(auxElegirH==2)){
                for (int k=0;k<36;k=k+4){
                    for (int j=0;j<2;j++){
                        this.remove(asientos[k+j]);
                        this.remove(asientos[k+j+2]);
                        ocupado[k+j]=true;
                        ocupado[k+j+2]=true;
                        //repaint();
                    }
                }
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
                auxPiso=1;
            }else if ((pisoBus.getSelectedItem()=="SEGUNDO   PISO")&&(auxPiso==1)&&(auxElegirH==2)){
                if (asientos[0]!=null){
                    for (int k=0;k<36;k=k+4){
                        for (int j=0;j<2;j++){
                            this.remove(asientos[k+j]);
                            this.remove(asientos[k+j+2]);
                            ocupado[k+j]=true;
                            ocupado[k+j+2]=true;
                            //repaint();
                        }
                    }
                }
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
                auxPiso=2;
            }
            repaint();
        }
        for (int i=0;i<36;i++){
            if (auxPiso==2){
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
