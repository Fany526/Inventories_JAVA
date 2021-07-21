// Programa en Java de la clase "Buscar"
// Proyecto Final de Programación Avanzada
// Alicia Estefany Gallegos Orozco 3E 19310379
// Ventana Búsqueda
// En esta ventana se podrá buscar las características de un artículo en específico

import javax.swing.*; //Se necesita para diseño de ventanas
import javax.swing.event.*; //Se necesita para eventos de Check box y Radio button
import java.awt.event.*; //Se necesita para disparar eventos
import java.awt.*; //Se necesita para darle formato a la letra de los componentes

public class Buscar extends JFrame implements ActionListener, KeyListener{
	final int poscx = 800;
	final int poscy = 250;
	private JMenuBar menubar;
	private JMenu menuOpcs, menuApariencia;
	private JMenuItem menuiPrincipal, menuiBlanco, menuiNegro, menuiOriginal;
	private JLabel etiqArticulo, etiqFechaI, etiqFechaR, etiqTFechaI, etiqTFechaR;
	private JTextField campoArticulo;
	private JTextArea areaDescripcion;
	private JScrollPane scrollArea;
	private JButton botonBuscar;
	
	public int colorVentana,cant[] = new int[6], canting[] = new int[6];
	public String articulo = "", cad="",descrip = "";
	public String fechaRet[] = new String[6];
	public String fechaIng[] = new String[6];

	public static String articulosB[] = new String[6];
	public static String colorB[][] = new String[6][5];
	public static String unidadB[] = new String[6];
	public static int cantidadB[] = new int[6];
	public static String fechaIB[] = new String[6];
	public static String fechaRB[] = new String[6];

public void Color(){
	if(colorVentana==0){
		getContentPane().setBackground(new Color(76,228,255));
		etiqArticulo.setForeground(Color.BLACK); 
		etiqFechaI.setForeground(Color.BLACK); 
		etiqFechaR.setForeground(Color.BLACK); 
	}
	if(colorVentana==1){
		getContentPane().setBackground(Color.WHITE);
		etiqArticulo.setForeground(Color.BLACK); 
		etiqFechaI.setForeground(Color.BLACK); 
		etiqFechaR.setForeground(Color.BLACK); 
	}
	if(colorVentana==2){
		getContentPane().setBackground(Color.BLACK);
		etiqArticulo.setForeground(Color.WHITE);
		etiqFechaI.setForeground(Color.WHITE);
		etiqFechaR.setForeground(Color.WHITE);
	}
}

//Constructor
	public Buscar(){
	setLayout(null);
	setTitle("Busqueda");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());

Inventarios ventanaB = new Inventarios();
	for(int z=0;z<=5;z++){
		articulosB[z] = ventanaB.articuloss[z];
		unidadB[z] = ventanaB.unidads[z];
		cantidadB[z] = ventanaB.cantidads[z];
		fechaIB[z] = ventanaB.fechaIs[z];
		fechaRB[z] = ventanaB.fechaRs[z];
		for(int a=0;a<=4;a++){
			colorB[z][a] = ventanaB.colorss[z][a];
		}//Fin del for "a"
		if(articulosB[z]==null){
			Datos ventanaD1 = new Datos();
			articulosB[z] = ventanaD1.articulosD[z];
			unidadB[z] = ventanaD1.unidadD[z];
			cantidadB[z] = ventanaD1.cantidadD[z];
			fechaIB[z] = ventanaD1.fechaID[z];
			fechaRB[z] = ventanaD1.fechaRD[z];
			for(int b=0;b<=4;b++){
				colorB[z][b] = ventanaD1.coloresD[z][b];
			}//Fin del for "b"
		}//Fin del if null

		Retiro ventanaR1 = new Retiro();
		cant[z]= ventanaR1.exist[z];
		fechaRet[z]= ventanaR1.fechaRetN[z];
		if(cant[z]!=0){
			cantidadB[z] = cant[z];
			fechaRB[z]= fechaRet[z];
		}

		Ingreso ventanaI1 = new Ingreso();
		canting[z]= ventanaI1.existi[z];
		fechaIng[z]= ventanaI1.fechaIngN[z];
		if(canting[z]!=0){
			cantidadB[z] = canting[z];
			fechaIB[z]= fechaIng[z];
		}
	}//Fin del for "z"

//Scroll en el TextArea
	areaDescripcion = new JTextArea("\n  Descripcion del articulo");
	areaDescripcion.setFont(new Font("arial",Font.BOLD,21)); 
	areaDescripcion.setEditable(false);
	scrollArea = new JScrollPane(areaDescripcion);
	scrollArea.setBounds(290,130,350,370);
	scrollArea.getVerticalScrollBar().setUnitIncrement(16); 
	add(scrollArea);

//Text Field
	campoArticulo = new JTextField();
	campoArticulo.setBounds(290,45,350,40);
	campoArticulo.setFont(new Font("arial",Font.PLAIN,28)); 
	add(campoArticulo);

//Etiquetas
	etiqArticulo = new JLabel("Articulo a buscar");
	etiqArticulo.setBounds(35,45,250,40); //x, y, ancho, alto
	etiqArticulo.setFont(new Font("arial",Font.BOLD,25)); 
	add(etiqArticulo);
	
	etiqTFechaI = new JLabel("Fecha de ingreso: ");
	etiqTFechaI.setBounds(35,400,220,35); //x, y, ancho, alto
	etiqTFechaI.setFont(new Font("arial",Font.BOLD,21)); 
	add(etiqTFechaI);

	etiqFechaI = new JLabel("");
	etiqFechaI.setBounds(35,440,220,35); //x, y, ancho, alto
	etiqFechaI.setFont(new Font("arial",Font.BOLD,21)); 
	add(etiqFechaI);

	etiqTFechaR = new JLabel("Fecha de retiro: ");
	etiqTFechaR.setBounds(35,490,220,35); //x, y, ancho, alto
	etiqTFechaR.setFont(new Font("arial",Font.BOLD,21)); 
	add(etiqTFechaR);
	
	etiqFechaR = new JLabel("");
	etiqFechaR.setBounds(35,530,220,35); //x, y, ancho, alto
	etiqFechaR.setFont(new Font("arial",Font.BOLD,21)); 
	add(etiqFechaR);

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
	botonBuscar = new JButton("Buscar");
	botonBuscar.setBounds(380,537,170,45);
	botonBuscar.setForeground(Color.WHITE);
	botonBuscar.setBackground(new Color(255,56,56));
	botonBuscar.setFont(new Font("arial",Font.BOLD,21)); 
	add(botonBuscar);
	botonBuscar.addActionListener(this);

	campoArticulo.addKeyListener(this);
	}//Fin del Constructor de la clase Buscar

	public void actionPerformed(ActionEvent accion2){
		if(accion2.getSource() == menuiPrincipal){
			Inventarios ventana = new Inventarios();
			ventana.setBounds(poscx,poscy,700,700); //x, y, ancho, alto
			ventana.setVisible(true);
			ventana.setResizable(false); //Para que no se modifique el tamaño de la ventana
			dispose();
		} //Fin del if
		if(accion2.getSource() == menuiBlanco){
			colorVentana=1;
			Color();
		} //Fin del if
		if(accion2.getSource() == menuiNegro){
			colorVentana=2;
			Color();
		} //Fin del if
		if(accion2.getSource() == menuiOriginal){
			colorVentana=0;
			Color();
		} //Fin del if
		if(accion2.getSource() == botonBuscar){
			if(!campoArticulo.getText().equals("")){
				articulo = campoArticulo.getText();
				for(int x=0;x<=5;x++){
					if(articulo.equals(articulosB[x])){
						descrip = "    Colores disponibles: ";
						for(int y = 0;y<=4;y++){						
							if(colorB[x][y]!=null&&!colorB[x][y].equals("")){
								descrip = descrip + "\n\t   " + colorB[x][y];
							}//Fin del if colores
						} //Fin del for y
						descrip = descrip + "\n\n    Unidad: \n\t   " + unidadB[x] + "\n\n";
						String cant= String.valueOf(cantidadB[x]);
						descrip = descrip + "    En existencia: \n\t   "+ cant + "\n\n";
						etiqFechaI.setText(fechaIB[x]);
						if(fechaRB[x]==null){
							etiqFechaR.setText("Sin fecha");
						}else{etiqFechaR.setText(fechaRB[x]);}
					}  //Fin del if articulo
				} //Fin del for x
				if(!descrip.equals("")){
					areaDescripcion.setText("\n DESCRIPCION\n\n\n" + descrip);
					areaDescripcion.setCaretPosition(1); 
					descrip ="";
				} //Fin del if descrip
				else{
					areaDescripcion.setText("\n\n No se encontro el articulo");
					etiqFechaI.setText("");
					etiqFechaR.setText("");	
				}
			} //Fin del if campoArticulo
			else{
				JOptionPane.showMessageDialog(this,"Escribe un articulo en el campo");
			}
		} //Fin del if botonBuscar
	}//Fin del método actionPerformed

	public void keyPressed(KeyEvent t) {

	} //Fin del "keyPressed"

	public void keyReleased(KeyEvent t) {
		if(campoArticulo.isFocusOwner()){
			String cadena = campoArticulo.getText();// En esta variable se guarda el texto a validar
  			int longCadena = cadena.length(); //Regresa la longitud de la cadena
		   
			for (int c=0; c<longCadena; c++){
         			char caracter = cadena.charAt(c);  //Va tomando caracter por caracter  
       				int  caracterCode = (int) caracter; //Casting: "Convierte" a entero un char  
  				if (caracterCode>=65&&caracterCode<=90||caracterCode>=97&&caracterCode<=122||caracterCode==32){
					cad = cad + caracter;
	 			}else{
					JOptionPane.showMessageDialog(this,"Los nombres de los articulos solo deben contener letras");
					campoArticulo.setText(cad);
				}
				if(t.getKeyCode() == KeyEvent.VK_ENTER){
              				articulo = campoArticulo.getText();
					for(int x=0;x<=5;x++){
						if(articulo.equals(articulosB[x])){
							descrip = "    Colores disponibles: ";
							for(int y = 0;y<=4;y++){
								if(colorB[x][y]!=null&&!colorB[x][y].equals("")){
									descrip = descrip + "\n\t   " + colorB[x][y];
								}//Fin del if colores
							} //Fin del for y
							descrip = descrip + "\n\n    Unidad: \n\t   " + unidadB[x] + "\n\n";
							String cant= String.valueOf(cantidadB[x]);
							descrip = descrip + "    En existencia: \n\t   "+ cant + "\n\n";
							etiqFechaI.setText(fechaIB[x]);
							if(fechaRB[x]==null){
								etiqFechaR.setText("Sin fecha");
							}else{etiqFechaR.setText(fechaRB[x]);}
						}  //Fin del if articulo
					} //Fin del for x
					if(!descrip.equals("")){
						areaDescripcion.setText("\n DESCRIPCION\n\n\n" + descrip);
						areaDescripcion.setCaretPosition(1); 
						descrip ="";
					} //Fin del if descrip
					else{
						areaDescripcion.setText("\n\n No se encontro el articulo");
						etiqFechaI.setText("");
						etiqFechaR.setText("");
					}
  				} //Fin del if enter
			} //Fin del for longCadena
			articulo = cad;
			cad = "";
		}
	} //Fin del "keyReleased"
	
	public void keyTyped(KeyEvent t){	

	} //Fin del "keyTyped"

} //Fin de la clase Buscar