// Programa en Java de la clase "Inventarios"
// Proyecto Final de Programación Avanzada
// Alicia Estefany Gallegos Orozco 3E 19310379
// Primer Avance: Todas las pantallas, Menús, Submenús (sin funcionalidad)
// Ventana principal
/*
DESCRIPCIÓN DEL PROYECTO:
➢ Artículo
➢ Descripción
➢ Unidad de medida (litros, gramos, paquetes, bultos, cubetas, etc.)
➢ Ingresó de mercancías
➢ Retiro de mercancías
➢ Fecha de ingreso de mercancías
➢ Fecha de retiro de mercancías 
➢ Existencia (= existencia anterior + ingresó – retiro)
➢ Reporte de artículos y su existencia

TODAS LAS APLICACIONES DEBEN:
	➢ Utilizar todos los elementos aprendidos en el semestre
		Menús/Submenús
		TextFields
		TextAreas
		Etiquetas
		Scroll Bars
		Color
		Font
		Ventana Emergente
		Botón
		ComboBox
		CheckBox/RadioButton
		Mouse
		Key
		Focus
	➢ Realizar altas, bajas, modificaciones y consultas de la información capturada
	➢ Manejar excepciones
*/

import javax.swing.*; //Se necesita para diseño de ventanas
import javax.swing.event.*; //Se necesita para eventos de Check box y Radio button
import java.awt.event.*; //Se necesita para disparar eventos
import java.awt.*; //Se necesita para darle formato a la letra de los componentes


public class Inventarios extends JFrame implements ActionListener{
	final int poscx = 800;
	final int poscy = 250;

	private JMenuBar menubar;
	private JMenu menuEmpresa, menuArticulos, menuApariencia;
	private JMenuItem menuiLogo, menuiEslogan, menuiBlanco, menuiNegro, menuiOriginal;
	private JMenuItem menuiReporte, menuiBuscar;
	private JLabel etiqGeneral, etiqTitulo, etiqLogo;
	private JButton botonIngreso, botonRetiro, botonNuevo;

	public boolean eslogan = false;
	public static int color = 0, nuevo = 0;	

	public static int cant[] = new int[6], canting[] = new int[6];
	public static String articuloss[] = new String[6];
	public static String colorss[][] = new String[6][5];
	public static String unidads[] = new String[6];
	public static int cantidads[] = new int[6];
	public static String fechaIs[] = new String[6];
	public static String fechaRs[] = new String[6];


//Constructor
	public Inventarios(){
	setLayout(null);
	setTitle("Inventarios");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	getContentPane().setBackground(new Color(76,228,255));
	setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());

//Etiquetas
	etiqGeneral = new JLabel("        Bienvenido a");
	etiqGeneral.setBounds(120,100,450,100); //x, y, ancho, alto
	etiqGeneral.setFont(new Font("arial",Font.BOLD,40)); 
	add(etiqGeneral);

	etiqTitulo = new JLabel("La Tiendita");
	etiqTitulo.setBounds(142,280,500,100); //x, y, ancho, alto
	etiqTitulo.setFont(new Font("monotype corsiva",Font.BOLD,80));
	etiqTitulo.setForeground(new Color(63,19,71)); 
	add(etiqTitulo);

	ImageIcon logo = new ImageIcon("Logo.png");
	etiqLogo = new JLabel(logo);
	etiqLogo.setBounds(165,40,360,400); //x, y, ancho, alto
	Icon icono = new ImageIcon(logo.getImage().getScaledInstance(etiqLogo.getWidth(),etiqLogo.getHeight(),Image.SCALE_DEFAULT));
	etiqLogo.setIcon(icono);
	etiqLogo.setVisible(false);
	add(etiqLogo);

//Menú Bar
	menubar = new JMenuBar();
	setJMenuBar(menubar);

//Menús y Submenús
	menuEmpresa = new JMenu("Empresa");
	menuEmpresa.setFont(new Font("arial",Font.BOLD,17)); 
	menuArticulos = new JMenu("Articulos");
	menuArticulos.setFont(new Font("arial",Font.BOLD,17)); 
	menuApariencia = new JMenu("Color ventana");
	menuApariencia.setFont(new Font("arial",Font.BOLD,14)); 
	
	menubar.add(menuEmpresa);
	menubar.add(menuArticulos);
	
//Item de los menús
	menuiLogo = new JMenuItem("Logo");
	menuiLogo.setFont(new Font("arial",Font.PLAIN,14)); 
	menuiEslogan = new JMenuItem("Eslogan");
	menuiEslogan.setFont(new Font("arial",Font.PLAIN,14)); 
	menuiBlanco = new JMenuItem("Diurno");
	menuiBlanco.setFont(new Font("arial",Font.PLAIN,14)); 
	menuiNegro = new JMenuItem("Nocturno");
	menuiNegro.setFont(new Font("arial",Font.PLAIN,14)); 
	menuiOriginal = new JMenuItem("Original");
	menuiOriginal.setFont(new Font("arial",Font.PLAIN,14));
	menuiReporte = new JMenuItem("Reporte general");
	menuiReporte.setFont(new Font("arial",Font.PLAIN,14)); 
	menuiBuscar = new JMenuItem("Busqueda");
	menuiBuscar.setFont(new Font("arial",Font.PLAIN,14));  

	menuEmpresa.add(menuiLogo);
	menuEmpresa.add(menuiEslogan);
	menuEmpresa.add(menuApariencia);
	menuApariencia.add(menuiBlanco);
	menuApariencia.add(menuiNegro);
	menuApariencia.add(menuiOriginal);
	menuArticulos.add(menuiReporte); 
	menuArticulos.add(menuiBuscar);

	menuiLogo.addActionListener(this);
	menuiEslogan.addActionListener(this);
	menuiBlanco.addActionListener(this);
	menuiNegro.addActionListener(this);
	menuiOriginal.addActionListener(this);
	menuiReporte.addActionListener(this);
	menuiBuscar.addActionListener(this);

//Botones
	botonIngreso = new JButton("Ingresar mercancia");
	botonIngreso.setBounds(60,460,250,50);
	botonIngreso.setForeground(Color.WHITE);
	botonIngreso.setBackground(new Color(255,56,56));
	botonIngreso.setFont(new Font("arial",Font.BOLD,23)); 
	add(botonIngreso);

	botonRetiro = new JButton("Retirar mercancia");
	botonRetiro.setBounds(365,460,250,50);
	botonRetiro.setForeground(Color.WHITE);
	botonRetiro.setBackground(new Color(255,56,56));
	botonRetiro.setFont(new Font("arial",Font.BOLD,23)); 
	add(botonRetiro);

	botonNuevo = new JButton("Nuevo articulo");
	botonNuevo.setBounds(215,530,250,50);
	botonNuevo.setForeground(Color.WHITE);
	botonNuevo.setBackground(new Color(255,56,56));
	botonNuevo.setFont(new Font("arial",Font.BOLD,23)); 
	add(botonNuevo);

	botonIngreso.addActionListener(this);
	botonRetiro.addActionListener(this);
	botonNuevo.addActionListener(this);

	} //Fin del Constructor de la clase Inventarios

	public void actionPerformed(ActionEvent accion){
		
		Nuevo ventanaN1 = new Nuevo();
		for(int z=0;z<=5;z++){
			articuloss[z] = ventanaN1.articulos[z];
			unidads[z] = ventanaN1.unidad[z];
			cantidads[z] = ventanaN1.cantidad[z];
			fechaIs[z]= ventanaN1.fechaI[z];
			fechaRs[z]= ventanaN1.fechaR[z];
			for(int a=0;a<=4;a++){
				colorss[z][a] = ventanaN1.color[z][a];
			}
			Retiro ventanaR1 = new Retiro();
			cant[z]= ventanaR1.exist[z];
			if(cant[z]!=0){
				cantidads[z] = cant[z];
			}

			Ingreso ventanaI1 = new Ingreso();
			canting[z]= ventanaI1.existi[z];
			if(canting[z]!=0){
				cantidads[z] = canting[z];
			}
		}
	
		if(accion.getSource() == botonIngreso){
			Ingreso ventana4 = new Ingreso();
			ventana4.setBounds(poscx,poscy,700,720); //x, y, ancho, alto
			ventana4.setVisible(true);
			ventana4.setResizable(false); //Para que no se modifique el tamaño de la ventana
			dispose();
		} //Fin del if
		if(accion.getSource() == botonRetiro){
			Retiro ventana5 = new Retiro();
			ventana5.setBounds(poscx,poscy,700,700); //x, y, ancho, alto
			ventana5.setVisible(true);
			ventana5.setResizable(false); //Para que no se modifique el tamaño de la ventana
			dispose();
		} //Fin del if
		if(accion.getSource() == botonNuevo){
			Nuevo ventana6 = new Nuevo();
			ventana6.setBounds(poscx,poscy,700,720); //x, y, ancho, alto
			ventana6.setVisible(true);
			ventana6.setResizable(false); //Para que no se modifique el tamaño de la ventana
			nuevo++;
			dispose();
		} //Fin del if
		if(accion.getSource() == menuiLogo){
			etiqGeneral.setVisible(false);
			etiqGeneral.setOpaque(false);
			etiqTitulo.setVisible(false);
			etiqLogo.setVisible(true);
			
		} //Fin del if
		if(accion.getSource() == menuiEslogan){
			etiqGeneral.setVisible(true);
			etiqGeneral.setFont(new Font("gabriola",Font.ITALIC,45)); 
			etiqGeneral.setText("Chiquita pero con cosas bonitas");
			etiqGeneral.setForeground(Color.WHITE);
			etiqGeneral.setOpaque(true);
			etiqGeneral.setBackground(new Color(68,19,71));
			etiqLogo.setVisible(false);
			etiqTitulo.setVisible(true);
			eslogan = true;
		} //Fin del if
		if(accion.getSource() == menuiBlanco){
			etiqTitulo.setForeground(new Color(63,19,71)); 
			if(eslogan==false){etiqGeneral.setForeground(Color.BLACK);}
			getContentPane().setBackground(Color.WHITE);
			color = 1;
		} //Fin del if
		if(accion.getSource() == menuiNegro){
			etiqTitulo.setForeground(Color.WHITE);
			if(eslogan==false){etiqGeneral.setForeground(Color.WHITE);}
			getContentPane().setBackground(Color.BLACK);
			color = 2;
		} //Fin del if
		if(accion.getSource() == menuiOriginal){
			etiqTitulo.setForeground(new Color(63,19,71)); 
			if(eslogan==false){etiqGeneral.setForeground(Color.BLACK);}
			getContentPane().setBackground(new Color(76,228,255));
			color = 0;
		} //Fin del if
		if(accion.getSource() == menuiReporte){
			Reporte ventana3 = new Reporte();
			ventana3.setBounds(poscx,poscy,700,700); //x, y, ancho, alto
			ventana3.setVisible(true);
			ventana3.setResizable(false); //Para que no se modifique el tamaño de la ventana
			dispose();
		} //Fin del if
		if(accion.getSource() == menuiBuscar){
			Buscar ventana2 = new Buscar();
			ventana2.setBounds(poscx,poscy,700,700); //x, y, ancho, alto
			ventana2.setVisible(true);
			ventana2.setResizable(false); //Para que no se modifique el tamaño de la ventana
			dispose();	
		} //Fin del if
	}//Fin del método actionPerformed

	public static void main(String args[]){
		Inventarios inventario= new Inventarios();
		inventario.setBounds(800,250,700,700); //x, y, ancho, alto
		inventario.setVisible(true);
		inventario.setResizable(false); //Para que no se modifique el tamaño de la ventana
	} // Fin del método main

} //Fin de la clase Inventarios