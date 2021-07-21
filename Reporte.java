// Programa en Java de la clase "Reporte"
// Proyecto Final de Programación Avanzada
// Alicia Estefany Gallegos Orozco 3E 19310379
// Ventana Reporte general
// En esta ventana se mostrará todos los artículos registrados, 
// cantidad en existencia y la fecha última en que ingresó mercancía

import javax.swing.*; //Se necesita para diseño de ventanas
import javax.swing.event.*; //Se necesita para eventos de Check box y Radio button
import java.awt.event.*; //Se necesita para disparar eventos
import java.awt.*; //Se necesita para darle formato a la letra de los componentes

public class Reporte extends JFrame implements ActionListener{
	final int poscx = 800;
	final int poscy = 250;
	private JMenuBar menubar;
	private JMenu menuOpcs, menuApariencia;
	private JMenuItem menuiPrincipal, menuiBlanco, menuiNegro, menuiOriginal;
	private JLabel etiqTitulo, etiqArticulo, etiqExistencia, etiqFechaI;
	private JTextArea areaReporte;
	private JButton botonActualizar;
	private JScrollPane scrollArea;

	public String fechaIng[] = new String[6];
	private int colorVentana;
	public static String articulosRep[] = new String[6];
	public static int cantidadRep[] = new int[6],cant[] = new int[6],canting[] = new int[6];
	public static String fechaIRep[] = new String[6];
	public String report = "";

public void Color(){
	if(colorVentana==0){
		getContentPane().setBackground(new Color(76,228,255));
		etiqTitulo.setForeground(new Color(255,56,56));
		etiqArticulo.setForeground(Color.BLACK);
		etiqExistencia.setForeground(Color.BLACK); 
		etiqFechaI.setForeground(Color.BLACK); 
	}
	if(colorVentana==1){
		getContentPane().setBackground(Color.WHITE);
		etiqTitulo.setForeground(new Color(255,56,56));
		etiqArticulo.setForeground(Color.BLACK); 
		etiqExistencia.setForeground(Color.BLACK); 
		etiqFechaI.setForeground(Color.BLACK); 
	}
	if(colorVentana==2){
		getContentPane().setBackground(Color.BLACK);
		etiqTitulo.setForeground(Color.WHITE);
		etiqArticulo.setForeground(Color.WHITE);
		etiqExistencia.setForeground(Color.WHITE);
		etiqFechaI.setForeground(Color.WHITE);
	}
}

//Constructor
	public Reporte(){
	setLayout(null);
	setTitle("Reporte general");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());

	Inventarios ventanaRep = new Inventarios();
	for(int z=0;z<=5;z++){
		articulosRep[z] = ventanaRep.articuloss[z];
		fechaIRep[z] = ventanaRep.fechaIs[z];
		cantidadRep[z] = ventanaRep.cantidads[z];
		
		if(articulosRep[z]==null){
			Datos ventanaD1 = new Datos();
			articulosRep[z] = ventanaD1.articulosD[z];
			fechaIRep[z] = ventanaD1.fechaID[z];
			cantidadRep[z] = ventanaD1.cantidadD[z];
		}
		Retiro ventanaR1 = new Retiro();
		cant[z]= ventanaR1.exist[z];
		if(cant[z]!=0){
			cantidadRep[z] = cant[z];
		}
		Ingreso ventanaI1 = new Ingreso();
		canting[z]= ventanaI1.existi[z];
		fechaIng[z]= ventanaI1.fechaIngN[z];
		if(canting[z]!=0){
			cantidadRep[z] = canting[z];
			fechaIRep[z]= fechaIng[z];
		}
	}

//Scroll en el TextArea
	areaReporte = new JTextArea("\n           ...\t                    ...\t                               ... ");
	areaReporte.setFont(new Font("arial",Font.BOLD,21)); 
	areaReporte.setEditable(false);
	scrollArea = new JScrollPane(areaReporte);
	scrollArea.setBounds(30,200,620,300);
	scrollArea.getVerticalScrollBar().setUnitIncrement(16); 
	add(scrollArea);

//Etiquetas
	etiqTitulo = new JLabel("REPORTE GENERAL");
	etiqTitulo.setBounds(60,30,600,70); //x, y, ancho, alto
	etiqTitulo.setFont(new Font("monotype corsiva",Font.BOLD,60)); 
	add(etiqTitulo);

	etiqArticulo = new JLabel("Articulo");
	etiqArticulo.setBounds(70,130,200,40); //x, y, ancho, alto
	etiqArticulo.setFont(new Font("arial",Font.BOLD,21)); 
	add(etiqArticulo);
	
	etiqExistencia = new JLabel("Existencia");
	etiqExistencia.setBounds(260,130,200,35); //x, y, ancho, alto
	etiqExistencia.setFont(new Font("arial",Font.BOLD,21)); 
	add(etiqExistencia);
	
	etiqFechaI = new JLabel("Fecha de ingreso");
	etiqFechaI.setBounds(450,130,220,35); //x, y, ancho, alto
	etiqFechaI.setFont(new Font("arial",Font.BOLD,21)); 
	add(etiqFechaI);

	Inventarios ventanaAnterior = new Inventarios();
	colorVentana = ventanaAnterior.color;
	Color();

//Menú Bar
	menubar = new JMenuBar();
	setJMenuBar(menubar);

//Menús y Submenús
	menuOpcs = new JMenu("Opciones");
	menuOpcs.setFont(new Font("arial",Font.BOLD,17)); 
	menuApariencia = new JMenu("Color ventana");
	menuApariencia.setFont(new Font("arial",Font.BOLD,14)); 
	
	menubar.add(menuOpcs);
	
//Item de los menús
	menuiPrincipal = new JMenuItem("Ventana principal");
	menuiPrincipal.setFont(new Font("arial",Font.PLAIN,14)); 
	menuiBlanco = new JMenuItem("Diurno");
	menuiBlanco.setFont(new Font("arial",Font.PLAIN,14)); 
	menuiNegro = new JMenuItem("Nocturno");
	menuiNegro.setFont(new Font("arial",Font.PLAIN,14)); 
	menuiOriginal = new JMenuItem("Original");
	menuiOriginal.setFont(new Font("arial",Font.PLAIN,14));

	menuOpcs.add(menuiPrincipal);
	menuOpcs.add(menuApariencia);
	menuApariencia.add(menuiBlanco);
	menuApariencia.add(menuiNegro);
	menuApariencia.add(menuiOriginal);

	menuiPrincipal.addActionListener(this);
	menuiBlanco.addActionListener(this);
	menuiNegro.addActionListener(this);
	menuiOriginal.addActionListener(this);

//Botones
	botonActualizar = new JButton("Actualizar");
	botonActualizar.setBounds(215,530,250,50);
	botonActualizar.setForeground(Color.WHITE);
	botonActualizar.setBackground(new Color(255,56,56));
	botonActualizar.setFont(new Font("arial",Font.BOLD,23)); 
	add(botonActualizar);
	botonActualizar.addActionListener(this);
	}//Fin del Constructor de la clase Reporte

	public void actionPerformed(ActionEvent accion3){
		if(accion3.getSource() == menuiPrincipal){
			Inventarios ventana = new Inventarios();
			ventana.setBounds(poscx,poscy,700,700); //x, y, ancho, alto
			ventana.setVisible(true);
			ventana.setResizable(false); //Para que no se modifique el tamaño de la ventana*/
			dispose();
		} //Fin del if
		if(accion3.getSource() == menuiBlanco){
			colorVentana=1;
			Color();
		} //Fin del if
		if(accion3.getSource() == menuiNegro){
			colorVentana=2;
			Color();
		} //Fin del if
		if(accion3.getSource() == menuiOriginal){
			colorVentana=0;
			Color();
		} //Fin del if
		if(accion3.getSource() == botonActualizar){
			areaReporte.setText("");
			report ="";
			for(int r=0;r<=5;r++){
				if(!articulosRep[r].equals("")){
					report = report + "\n      " + articulosRep[r]+ "\t\t"+ cantidadRep[r] +"\t"+fechaIRep[r];
					areaReporte.setText(report);
				}
			}
		} //Fin del if
	}//Fin del método actionPerformed

} //Fin de la clase Reporte