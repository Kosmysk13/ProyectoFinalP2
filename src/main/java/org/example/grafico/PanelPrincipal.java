package org.example.grafico;

import org.example.excepciones.*;
import org.example.logica.*;

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
    private Reservador com;
    private PanelRecorridos pr;
    private Bus[][] bus;
    private JComboBox origen,destino,pisoBus;
    private JButton busqueda,ConfirmarPago,ElegirHorario,asientos[][][];
    private JRadioButton[][] horarios;
    private ButtonGroup horariosG;
    private JPanel PanelRecorridos;
    private Asiento asAux;
    private String ciudadOrigen[],ciudadDestino[],pisosB[],auxRecOrigen,auxRecDestino;
    private int[][][] ocupado;
    private int hora=12,auxCualHorario,auxCualRec,auxElegirH=0,PrecioTotal;
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

        ciudadOrigen = new String[] {"",String.valueOf(Recorridos.CHILLAN), String.valueOf(Recorridos.CONCEPCION),String.valueOf(Recorridos.LOS_ANGELES)};
        ciudadDestino = new String[] {"",String.valueOf(Recorridos.CONCEPCION),String.valueOf(Recorridos.CHILLAN),String.valueOf(Recorridos.LOS_ANGELES)};
        pisosB = new String[] {"PRIMER   PISO","SEGUNDO   PISO"};
        asientos = new JButton[6][6][53];
        ocupado = new int[6][6][53];

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
        busqueda.setIcon(new ImageIcon("src/main/java/org/example/elementosPanel/lupa.png"));
        busqueda.addActionListener(this);
        busqueda.setFocusable(false);
        this.add(busqueda);

        pisoBus = new JComboBox(pisosB);
        pisoBus.addActionListener(this);
        pisoBus.setBounds(500,274,700,75);
        pisoBus.setFocusable(false);
        this.add(pisoBus);

        ConfirmarPago = new JButton("Confirmar Reserva");
        ConfirmarPago.setBounds(1000,750,200,50);
        ConfirmarPago.setFocusable(false);
        ConfirmarPago.addActionListener(this);
        this.add(ConfirmarPago);

        ElegirHorario = new JButton("Elegir Horario");
        ElegirHorario.setBounds(50,750,300,50);
        ElegirHorario.setFocusable(false);
        ElegirHorario.addActionListener(this);
        this.add(ElegirHorario);

        PanelRecorridos = new JPanel();
        PanelRecorridos.setBounds(50,25, 1150, 150);
        PanelRecorridos.setBackground(new Color(99, 132, 180));
        PanelRecorridos.setVisible(true);
        this.add(PanelRecorridos);

        horarios = new JRadioButton[6][6];
        horariosG = new ButtonGroup();
        bus = new Bus[6][6];
        for (int i=0;i<6;i++){
            try {
                bus[0][i] = new Bus(Recorridos.CHILLANCONCEPCION);
                bus[1][i] = new Bus(Recorridos.CHILLANLOS_ANGELES);
                bus[2][i] = new Bus(Recorridos.CONCEPCIONLOS_ANGELES);
                bus[3][i] = new Bus(Recorridos.CONCEPCIONCHILLAN);
                bus[4][i] = new Bus(Recorridos.LOS_ANGELESCONCEPCION);
                bus[5][i] = new Bus(Recorridos.LOS_ANGELESCHILLAN);
            } catch (TipodeAsientoInvalidoException | AsientoInvalidoException | RecorridoIncorrectoException e) {
                throw new RuntimeException(e);
            }
        }


        for (int i=0;i<6;i++){
            for (int j=0;j<6;j++){
                horarios[i][j] = new JRadioButton("SALIDA: "+(hora+j)+":00 - LLEGADA: "+(hora+j+2)+":00");
                horarios[i][j].setBounds(100,285+(75*j),250,50);
                horarios[i][j].setBackground(new Color(188,227,255));
                horarios[i][j].setFocusable(false);
                horarios[i][j].addActionListener(this);
                horariosG.add(horarios[i][j]);
                this.add(horarios[i][j]);
                horarios[i][j].setVisible(false);
                repaint();
            }
        }

        for (int i=0;i<6;i++){
            for (int j=0;j<6;j++){
                for (int k=0;k<53;k++){
                    if (k<5){
                        asientos[i][j][k] = new JButton();
                        asientos[i][j][k].setBounds(598+(118*k),410,103,50);
                        asientos[i][j][k].setIcon(new ImageIcon("src/main/java/org/example/elementosPanel/asientoPLibre.png"));
                        asientos[i][j][k].setBackground(Color.white);
                        asientos[i][j][k].addActionListener(this);
                        asientos[i][j][k].setFocusable(false);
                        this.add(asientos[i][j][k]);
                        asientos[i][j][k].setVisible(false);
                    }else if (k<11){
                        asientos[i][j][k] = new JButton();
                        asientos[i][j][k].setBounds(598+((k-5)*96),570,81,50);
                        asientos[i][j][k].setIcon(new ImageIcon("src/main/java/org/example/elementosPanel/asientoCLibre.png"));
                        asientos[i][j][k].setBackground(Color.white);
                        asientos[i][j][k].addActionListener(this);
                        asientos[i][j][k].setFocusable(false);
                        this.add(asientos[i][j][k]);
                        asientos[i][j][k].setVisible(false);
                    }else if (k<17){
                        asientos[i][j][k] = new JButton();
                        asientos[i][j][k].setBounds(598+((k-11)*96),630,81,50);
                        asientos[i][j][k].setIcon(new ImageIcon("src/main/java/org/example/elementosPanel/asientoCLibre.png"));
                        asientos[i][j][k].setBackground(Color.white);
                        asientos[i][j][k].addActionListener(this);
                        asientos[i][j][k].setFocusable(false);
                        this.add(asientos[i][j][k]);
                        asientos[i][j][k].setVisible(false);
                    }else if (k<26){
                        asientos[i][j][k] = new JButton();
                        asientos[i][j][k].setBounds(598+((k-17)*65),410,50,50);
                        asientos[i][j][k].setBackground(Color.white);
                        asientos[i][j][k].addActionListener(this);
                        asientos[i][j][k].setFocusable(false);
                        asientos[i][j][k].setIcon(new ImageIcon("src/main/java/org/example/elementosPanel/asientoSCLibre.png"));
                        this.add(asientos[i][j][k]);
                        asientos[i][j][k].setVisible(false);
                    }else if (k<35){
                        asientos[i][j][k] = new JButton();
                        asientos[i][j][k].setBounds(598+((k-26)*65),470,50,50);
                        asientos[i][j][k].setBackground(Color.white);
                        asientos[i][j][k].addActionListener(this);
                        asientos[i][j][k].setFocusable(false);
                        asientos[i][j][k].setIcon(new ImageIcon("src/main/java/org/example/elementosPanel/asientoSCLibre.png"));
                        this.add(asientos[i][j][k]);
                        asientos[i][j][k].setVisible(false);
                    }else if (k<44){
                        asientos[i][j][k] = new JButton();
                        asientos[i][j][k].setBounds(598+((k-35)*65),570,50,50);
                        asientos[i][j][k].setBackground(Color.white);
                        asientos[i][j][k].addActionListener(this);
                        asientos[i][j][k].setFocusable(false);
                        asientos[i][j][k].setIcon(new ImageIcon("src/main/java/org/example/elementosPanel/asientoSCLibre.png"));
                        this.add(asientos[i][j][k]);
                        asientos[i][j][k].setVisible(false);
                    }else{
                        asientos[i][j][k] = new JButton();
                        asientos[i][j][k].setBounds(598+((k-44)*65),630,50,50);
                        asientos[i][j][k].setBackground(Color.white);
                        asientos[i][j][k].addActionListener(this);
                        asientos[i][j][k].setFocusable(false);
                        asientos[i][j][k].setIcon(new ImageIcon("src/main/java/org/example/elementosPanel/asientoSCLibre.png"));
                        this.add(asientos[i][j][k]);
                        asientos[i][j][k].setVisible(false);
                    }
                }
            }
        }
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
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==origen){
            if (origen.getSelectedItem().toString()!=""){
                if (auxRecOrigen!=null){
                    destino.addItem(auxRecOrigen);
                    for (int k=0;k<53;k++){
                        asientos[auxCualRec][auxCualHorario][k].setVisible(false);
                        repaint();
                    }
                }
                auxRecOrigen = origen.getSelectedItem().toString();
                destino.removeItem(origen.getSelectedItem());
            }
        }
        if (e.getSource()==destino){
            for (int k=0;k<53;k++){
                asientos[auxCualRec][auxCualHorario][k].setVisible(false);
                repaint();
            }
            auxRecDestino = destino.getSelectedItem().toString();
        }
        if (e.getSource()==busqueda){
            if (origen.getSelectedItem()==null||origen.getSelectedItem().toString()==""){
                try {
                    throw new RecorridoIncorrectoException("Recorrido invalido, origen y/o destino incorrecto");
                } catch (RecorridoIncorrectoException ex) {
                    throw new RuntimeException(ex);
                }
            }else if(destino.getSelectedItem()==null||destino.getSelectedItem().toString()==""){
                try {
                    throw new RecorridoIncorrectoException("Recorrido invalido, destino incorrecto");
                } catch (RecorridoIncorrectoException ex) {
                    throw new RuntimeException(ex);
                }
            }else {
                if (auxRecOrigen=="CHILLAN"&&auxRecDestino=="CONCEPCION"){
                    auxCualRec = 0;
                }else if (auxRecOrigen=="CHILLAN"&&auxRecDestino=="LOS_ANGELES"){
                    auxCualRec = 1;
                }else if (auxRecOrigen=="CONCEPCION"&&auxRecDestino=="LOS_ANGELES"){
                    auxCualRec = 2;
                }else if (auxRecOrigen=="CONCEPCION"&&auxRecDestino=="CHILLAN"){
                    auxCualRec = 3;
                }else if (auxRecOrigen=="LOS_ANGELES"&&auxRecDestino=="CONCEPCION"){
                    auxCualRec = 4;
                }else if (auxRecOrigen=="LOS_ANGELES"&&auxRecDestino=="CHILLAN"){
                    auxCualRec = 5;
                }
                for (int j=0;j<6;j++){
                    horarios[auxCualRec][j].setVisible(true);
                    repaint();
                }
                System.out.println("Se ha elegido recorrido desde: "+auxRecOrigen+" hasta: "+auxRecDestino);
            }
        }
        for (int i=0;i<6;i++){
            for (int j=0;j<6;j++){
                if (e.getSource()==horarios[i][j]){
                    for (int k=0;k<53;k++){
                        asientos[auxCualRec][auxCualHorario][k].setVisible(false);
                    }
                    auxCualHorario=j;
                    auxElegirH=1;
                }
            }
        }
        if (e.getSource()==ElegirHorario){
            if (auxElegirH!=1){
                try {
                    throw new HorarioInvalidoException("No se ha elegido un horario");
                } catch (HorarioInvalidoException ex) {
                    throw new RuntimeException(ex);
                }
            }else if(auxElegirH==1){
                for (int k=0;k<17;k++){
                    asientos[auxCualRec][auxCualHorario][k].setVisible(true);
                }
                auxElegirH=2;
            }
            repaint();
        }
        if (e.getSource()==pisoBus){
            if ((pisoBus.getSelectedItem()=="PRIMER   PISO")&&(auxElegirH==2)){
                for (int k=17;k<53;k++){
                    asientos[auxCualRec][auxCualHorario][k].setVisible(false);
                }
                for (int k=0;k<17;k++){
                    asientos[auxCualRec][auxCualHorario][k].setVisible(true);
                }
            }else if ((pisoBus.getSelectedItem()=="SEGUNDO   PISO")&&(auxElegirH==2)){
                for (int k=0;k<17;k++){
                    asientos[auxCualRec][auxCualHorario][k].setVisible(false);
                }
                for (int k=17;k<53;k++){
                    asientos[auxCualRec][auxCualHorario][k].setVisible(true);
                }
            }
            repaint();
        }
        for (int k=0;k<53;k++){
            if (e.getSource()==asientos[auxCualRec][auxCualHorario][k]){
                if (k<5){
                    if (ocupado[auxCualRec][auxCualHorario][k]==0){
                        asientos[auxCualRec][auxCualHorario][k].setIcon(new ImageIcon("src/main/java/org/example/elementosPanel/asientoPOcupado.png"));
                        ocupado[auxCualRec][auxCualHorario][k]=1;
                        System.out.println("Se ha seleccionado el asiento numero: "+bus[auxCualRec][auxCualHorario].asSelec(k).getNumAsiento());
                    }else if (ocupado[auxCualRec][auxCualHorario][k]==1){
                        asientos[auxCualRec][auxCualHorario][k].setIcon(new ImageIcon("src/main/java/org/example/elementosPanel/asientoPLibre.png"));
                        ocupado[auxCualRec][auxCualHorario][k]=0;
                        System.out.println("Se ha deseleccionado el asiento numero: "+bus[auxCualRec][auxCualHorario].asSelec(k).getNumAsiento());
                    }else{
                        try {
                            throw new AsientoOcupadoException("No se puede seleccionar, el asiento numero:"+bus[auxCualRec][auxCualHorario].asSelec(k).getNumAsiento()+" ya esta reservado");
                        } catch (AsientoOcupadoException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }else if (k<17){
                    if (ocupado[auxCualRec][auxCualHorario][k]==0){
                        asientos[auxCualRec][auxCualHorario][k].setIcon(new ImageIcon("src/main/java/org/example/elementosPanel/asientoCOcupado.png"));
                        ocupado[auxCualRec][auxCualHorario][k]=1;
                        System.out.println("Se ha seleccionado el asiento numero: "+bus[auxCualRec][auxCualHorario].asSelec(k).getNumAsiento());
                    }else if(ocupado[auxCualRec][auxCualHorario][k]==1){
                        asientos[auxCualRec][auxCualHorario][k].setIcon(new ImageIcon("src/main/java/org/example/elementosPanel/asientoCLibre.png"));
                        ocupado[auxCualRec][auxCualHorario][k]=0;
                        System.out.println("Se ha deseleccionado el asiento numero: "+bus[auxCualRec][auxCualHorario].asSelec(k).getNumAsiento());
                    }else{
                        try {
                            throw new AsientoOcupadoException("No se puede seleccionar, el asiento numero:"+bus[auxCualRec][auxCualHorario].asSelec(k).getNumAsiento()+" ya esta reservado");
                        } catch (AsientoOcupadoException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }else{
                    if (ocupado[auxCualRec][auxCualHorario][k]==0){
                        asientos[auxCualRec][auxCualHorario][k].setIcon(new ImageIcon("src/main/java/org/example/elementosPanel/asientoSCOcupado.png"));
                        ocupado[auxCualRec][auxCualHorario][k]=1;
                        System.out.println("Se ha seleccionado el asiento numero: "+bus[auxCualRec][auxCualHorario].asSelec(k).getNumAsiento());
                    }else if(ocupado[auxCualRec][auxCualHorario][k]==1){
                        asientos[auxCualRec][auxCualHorario][k].setIcon(new ImageIcon("src/main/java/org/example/elementosPanel/asientoSCLibre.png"));
                        ocupado[auxCualRec][auxCualHorario][k]=0;
                        System.out.println("Se ha deseleccionado el asiento numero: "+bus[auxCualRec][auxCualHorario].asSelec(k).getNumAsiento());

                    }else{
                        try {
                            throw new AsientoOcupadoException("No se puede seleccionar, el asiento numero:"+bus[auxCualRec][auxCualHorario].asSelec(k).getNumAsiento()+" ya esta reservado");
                        } catch (AsientoOcupadoException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        }
        if (e.getSource()==ConfirmarPago){
            for (int k=0;k<53;k++){
                if (ocupado[auxCualRec][auxCualHorario][k]==1){
                    try {
                        com = new Reservador(bus[auxCualRec][auxCualHorario],k);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    com.infoAsiento();
                    asAux = bus[auxCualRec][auxCualHorario].asSelec(k);
                    PrecioTotal = PrecioTotal+asAux.getPrecio();
                    ocupado[auxCualRec][auxCualHorario][k]=2;
                }
            }
            if (PrecioTotal==0){
                try {
                    throw new NoHayAsientoSeleccionadoException("No hay asientos seleccionados para reservar");
                } catch (NoHayAsientoSeleccionadoException ex) {
                    throw new RuntimeException(ex);
                }
            }else{
                System.out.println("El precio total es: $"+PrecioTotal+"\n");
            }
            PrecioTotal = 0;
        }
    }
}
