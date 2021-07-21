// Programa en Java de la clase "Nuevo"
// Proyecto Final de Programación Avanzada
// Alicia Estefany Gallegos Orozco 3E 19310379
// Ventana Ingresar nueva mercancía
// En esta ventana se podrá registrar un nuevo artículo 
// con sus respectivas características y cantidad de mercancía ingresada del mismo

import javax.swing.*; //Se necesita para diseño de ventanas
import javax.swing.event.*; //Se necesita para eventos de Check box y Radio button
import java.awt.event.*; //Se necesita para disparar eventos
import java.awt.*; //Se necesita para darle formato a la letra de los componentes

public class Nuevo extends JFrame implements ActionListener, ChangeListener, KeyListener{
	final int poscx = 800;
	final int poscy = 250;

	private JMenuBar menubar;
	private JMenu menuOpcs, menuApariencia;
	private JMenuItem menuiPrincipal, menuiBlanco, menuiNegro, menuiOriginal;
	private JLabel etiqArticulo, etiqColor, etiqMedida, etiqCant, etiqFechaI;
	private JTextField campoArticulo, campoCant, campoFechaI;
	private JCheckBox checkAzul, checkAmarillo, checkRojo, checkBlanco, checkNegro;
	private JRadioButton radioLts, radioGrs, radioPaq, radioBul, radioCub, radioUnid;
	private ButtonGroup grupoMedidas;
	private JButton botonAgregar;
	
	public int colorVentana, nuev, cant[] = new int[6], canting[] = new int[6];
	public String cad = "", artic = "", cadcant = "", canti, cadf = "", fech, resguardo = "", inven;
	public String resMedida = "", unite = "";
	public String resColores="", colors[] = new String[5];
	public String fechaRet[] = new String[6];
	public String fechaIng[] = new String[6];

	public static String articulosN[] = new String[6];
	public static String colorN[][] = new String[6][5];
	public static String unidadN[] = new String[6];
	public static int cantidadN[] = new int[6];
	public static String fechaIN[] = new String[6];
	public static String fechaRN[] = new String[6];

	public static String articulosI[] = new String[6];
	public static String colorI[][] = new String[6][5];
	public static String unidadI[] = new String[6];
	public static int cantidadI[] = new int[6];
	public static String fechaII[] = new String[6];
	public static String fechaRI[] = new String[6];

	public static String articulos[] = new String[6];
	public static String color[][] = new String[6][5];
	public static String unidad[] = new String[6];
	public static int cantidad[] = new int[6];
	public static String fechaI[] = new String[6];
	public static String fechaR[] = new String[6];

public void Color(){
	if(colorVentana==0){
		getContentPane().setBackground(new Color(76,228,255));
		etiqArticulo.setForeground(Color.BLACK); 
		etiqColor.setForeground(Color.BLACK); 
		etiqMedida.setForeground(Color.BLACK); 
		etiqCant.setForeground(Color.BLACK); 
		etiqFechaI.setForeground(Color.BLACK);  
	}
	if(colorVentana==1){
		getContentPane().setBackground(Color.WHITE);
		etiqArticulo.setForeground(Color.BLACK); 
		etiqColor.setForeground(Color.BLACK); 
		etiqMedida.setForeground(Color.BLACK); 
		etiqCant.setForeground(Color.BLACK); 
		etiqFechaI.setForeground(Color.BLACK); 
	}
	if(colorVentana==2){
		getContentPane().setBackground(Color.BLACK);
		etiqArticulo.setForeground(Color.WHITE);
		etiqColor.setForeground(Color.WHITE);
		etiqMedida.setForeground(Color.WHITE);
		etiqCant.setForeground(Color.WHITE);
		etiqFechaI.setForeground(Color.WHITE);
	}
}

//Constructor
	public Nuevo(){
	setLayout(null);
	setTitle("Ingreso de nuevas mercancias");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());
	
	
Datos ventanaD = new Datos();
	for(int z=0;z<=5;z++){
		articulosN[z] = ventanaD.articulosD[z];
		unidadN[z] = ventanaD.unidadD[z];
		cantidadN[z] = ventanaD.cantidadD[z];
		fechaIN[z]= ventanaD.fechaID[z];
		fechaRN[z]= ventanaD.fechaRD[z];
		for(int a=0;a<=4;a++){
			colorN[z][a]= ventanaD.coloresD[z][a];
		}
		Inventarios ventanaI = new Inventarios();
		articulosI[z] = ventanaI.articuloss[z];
		nuev=ventanaI.nuevo;
		if(articulosI[z]!=null){
			articulosN[z] = ventanaI.articuloss[z];
			unidadN[z] = ventanaI.unidads[z];
			cantidadN[z] = ventanaI.cantidads[z];
			fechaIN[z]= ventanaI.fechaIs[z];
			fechaRN[z]= ventanaI.fechaRs[z];
		}
		
	}

//Etiquetas
	etiqArticulo = new JLabel("Articulo");
	etiqArticulo.setBounds(40,40,150,35); //x, y, ancho, alto
	etiqArticulo.setFont(new Font("arial",Font.BOLD,25)); 
	add(etiqArticulo);
	
	etiqColor = new JLabel("Color");
	etiqColor.setBounds(40,160,150,35); //x, y, ancho, alto
	etiqColor.setFont(new Font("arial",Font.BOLD,25)); 
	add(etiqColor);

	etiqMedida = new JLabel("Unidad de medida");
	etiqMedida.setBounds(40,330,220,35); //x, y, ancho, alto
	etiqMedida.setFont(new Font("arial",Font.BOLD,25)); 
	add(etiqMedida);

	etiqCant = new JLabel("Cantidad a ingresar");
	etiqCant.setBounds(40,450,250,35); //x, y, ancho, alto
	etiqCant.setFont(new Font("arial",Font.BOLD,25)); 
	add(etiqCant);

	etiqFechaI = new JLabel("Fecha de ingreso");
	etiqFechaI.setBounds(40,520,220,35); //x, y, ancho, alto
	etiqFechaI.setFont(new Font("arial",Font.BOLD,25)); 
	add(etiqFechaI);

	Inventarios ventanaAnterior = new Inventarios();
	colorVentana = ventanaAnterior.color;
	Color();

//Text Field
	campoArticulo = new JTextField();
	campoArticulo.setBounds(180,40,470,35);
	campoArticulo.setFont(new Font("arial",Font.PLAIN,23)); 
	add(campoArticulo);

	campoCant = new JTextField();
	campoCant.setBounds(320,450,330,35);
	campoCant.setFont(new Font("arial",Font.PLAIN,23)); 
	add(campoCant);

	campoFechaI = new JTextField();
	campoFechaI.setBounds(320,520,330,35);
	campoFechaI.setFont(new Font("arial",Font.PLAIN,23)); 
	add(campoFechaI);

//Check Box
	checkAzul = new JCheckBox("  Azul");
	checkAzul.setBounds(320,110,150,35);
	checkAzul.setFont(new Font("arial",Font.PLAIN,21)); 
	checkAzul.setBackground(new Color(255,255,255)); 
	add(checkAzul);

	checkAmarillo = new JCheckBox("  Amarillo");
	checkAmarillo.setBounds(320,160,150,35);
	checkAmarillo.setFont(new Font("arial",Font.PLAIN,21)); 
	checkAmarillo.setBackground(new Color(255,255,255)); 
	add(checkAmarillo);

	checkRojo = new JCheckBox("  Rojo");
	checkRojo.setBounds(320,210,150,35);
	checkRojo.setFont(new Font("arial",Font.PLAIN,21)); 
	checkRojo.setBackground(new Color(255,255,255)); 
	add(checkRojo);

	checkBlanco = new JCheckBox("  Blanco");
	checkBlanco.setBounds(500,110,150,35);
	checkBlanco.setFont(new Font("arial",Font.PLAIN,21)); 
	checkBlanco.setBackground(new Color(255,255,255)); 
	add(checkBlanco);

	checkNegro = new JCheckBox("  Negro");
	checkNegro.setBounds(500,160,150,35);
	checkNegro.setFont(new Font("arial",Font.PLAIN,21)); 
	checkNegro.setBackground(new Color(255,255,255)); 
	add(checkNegro);

	checkAzul.addChangeListener(this);
	checkAmarillo.addChangeListener(this);
	checkRojo.addChangeListener(this);
	checkBlanco.addChangeListener(this);
	checkNegro.addChangeListener(this);

//Radio Button
	grupoMedidas = new ButtonGroup();

	radioLts = new JRadioButton("  Litros");
	radioLts.setBounds(320,280,150,35);
	radioLts.setFont(new Font("arial",Font.PLAIN,21));
	radioLts.setBackground(new Color(255,255,255)); 	
	add(radioLts);

	radioGrs = new JRadioButton("  Gramos");
	radioGrs.setBounds(320,330,150,35);
	radioGrs.setFont(new Font("arial",Font.PLAIN,21));
	radioGrs.setBackground(new Color(255,255,255));  	
	add(radioGrs);
	
	radioPaq = new JRadioButton("  Paquetes");
	radioPaq.setBounds(320,380,150,35);
	radioPaq.setFont(new Font("arial",Font.PLAIN,21));
	radioPaq.setBackground(new Color(255,255,255)); 	
	add(radioPaq);

	radioBul = new JRadioButton("  Bultos");
	radioBul.setBounds(500,280,150,35);
	radioBul.setFont(new Font("arial",Font.PLAIN,20));
	radioBul.setBackground(new Color(255,255,255)); 	
	add(radioBul);

	radioCub = new JRadioButton("  Cubetas");
	radioCub.setBounds(500,330,150,35);
	radioCub.setFont(new Font("arial",Font.PLAIN,20));
	radioCub.setBackground(new Color(255,255,255)); 	
	add(radioCub);
	
	radioUnid= new JRadioButton("  Unidades");
	radioUnid.setBounds(500,380,150,35);
	radioUnid.setFont(new Font("arial",Font.PLAIN,20));
	radioUnid.setBackground(new Color(255,255,255)); 	
	add(radioUnid);

	radioLts.addChangeListener(this);
	grupoMedidas.add(radioLts); //Agregarlo al objeto grupoMedidas
	radioGrs.addChangeListener(this);
	grupoMedidas.add(radioGrs); //Agregarlo al objeto grupoMedidas
	radioPaq.addChangeListener(this);
	grupoMedidas.add(radioPaq); //Agregarlo al objeto grupoMedidas
	radioBul.addChangeListener(this);
	grupoMedidas.add(radioBul); //Agregarlo al objeto grupoMedidas
	radioCub.addChangeListener(this);
	grupoMedidas.add(radioCub); //Agregarlo al objeto grupoMedidas
	radioUnid.addChangeListener(this);
	grupoMedidas.add(radioUnid); //Agregarlo al objeto grupoMedidas

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
	botonAgregar = new JButton("Agregar");
	botonAgregar.setBounds(410,580,150,45);
	botonAgregar.setForeground(Color.WHITE);
	botonAgregar.setBackground(new Color(255,56,56));
	botonAgregar.setFont(new Font("arial",Font.BOLD,21)); 
	add(botonAgregar);
	botonAgregar.addActionListener(this);

	campoArticulo.addKeyListener(this);
	campoCant.addKeyListener(this);
	campoFechaI.addKeyListener(this);
	} //Fin del Constructor de la clase Ingreso

	public void actionPerformed(ActionEvent accion4){
		if(accion4.getSource() == menuiPrincipal){
			Inventarios ventana = new Inventarios();
			ventana.setBounds(poscx,poscy,700,700); //x, y, ancho, alto
			ventana.setVisible(true);
			ventana.setResizable(false); //Para que no se modifique el tamaño de la ventana
			dispose();
		} //Fin del if
		if(accion4.getSource() == menuiBlanco){
			colorVentana=1;
			Color();
		} //Fin del if
		if(accion4.getSource() == menuiNegro){
			colorVentana=2;
			Color();
		} //Fin del if
		if(accion4.getSource() == menuiOriginal){
			colorVentana=0;
			Color();
		} //Fin del if
		if(accion4.getSource() == botonAgregar){
	
			for(int z=0;z<=5;z++){
				articulos[z] = articulosN[z];
				unidad[z] = unidadN[z];
				cantidad[z] = cantidadN[z];
				fechaI[z]=fechaIN[z];
				fechaR[z]=fechaRN[z];
				for(int a=0;a<=4;a++){
					color[z][a]=colorN[z][a];
				}

				Inventarios ventanaPrin = new Inventarios();
					inven = ventanaPrin.articuloss[z];
				if(inven!=null){	
					articulos[z] = ventanaPrin.articuloss[z];
					unidad[z] = ventanaPrin.unidads[z];
					cantidad[z] = ventanaPrin.cantidads[z];
					fechaI[z] = ventanaPrin.fechaIs[z];
					fechaR[z] = ventanaPrin.fechaRs[z];
					for(int b=0;b<=4;b++){
						color[z][b] = ventanaPrin.colorss[z][b];
					}//Fin del for "b" 
				
					Retiro ventanaR1 = new Retiro();
					cant[z]= ventanaR1.exist[z];
					fechaRet[z]= ventanaR1.fechaRetN[z];
					if(cant[z]!=0){
						cantidad[z] = cant[z];
						fechaR[z]= fechaRet[z];
					}

					Ingreso ventanaI1 = new Ingreso();
					canting[z]= ventanaI1.existi[z];
					fechaIng[z]= ventanaI1.fechaIngN[z];
					if(canting[z]!=0){
						cantidad[z] = canting[z];
						fechaI[z]= fechaIng[z];
					}

				}//Fin del if null
			}
			
			if(!campoArticulo.getText().equals("")&&!campoCant.getText().equals("")&&!campoFechaI.getText().equals("")&&!resMedida.equals("")&&!resColores.equals("")){
				artic = campoArticulo.getText();
				for(int x=0;x<=5;x++){
					if(articulos[x].equals("")){
						articulos[x]  = artic;
						unidad[x] = unite;    
    						int cant = Integer.parseInt(campoCant.getText());
						cantidad[x] = cant;
						fechaI[x] = campoFechaI.getText();
						for(int y=0;y<=4;y++){
							 color[x][y] = colors[y];
						}//Fin del for y
						
						Inventarios ventana = new Inventarios();
						ventana.setBounds(poscx,poscy,700,700); //x, y, ancho, alto
						ventana.setVisible(true);
						ventana.setResizable(false); //Para que no se modifique el tamaño de la ventana
						dispose();
						break;
					}  //Fin del if articulos
				} //Fin del for x
			}
			else{
				JOptionPane.showMessageDialog(this,"Falta llenar algun campo");
			}//Fin del id campoArticulo

			if(nuev>1){
				JOptionPane.showMessageDialog(this,"Ya no se pueden agregar articulos nuevos");
			}
		} //Fin del if
	}//Fin del método actionPerformed
	
	public void stateChanged(ChangeEvent accion4){
		String colores = "";
		
		if(checkAzul.isSelected()==true){
			colores = colores + "\t Azul\n";
			colors[0] = "Azul";
		}
		if(checkAmarillo.isSelected()==true){
			colores = colores + "\t Amarillo\n";
			colors[1] = "Amarillo";
		}
		if(checkRojo.isSelected()==true){
			colores = colores + "\t Rojo\n";
			colors[2] = "Rojo";
		}
		if(checkBlanco.isSelected()==true){
			colores = colores + "\t Blanco\n";
			colors[3] = "Blanco";
		}
		if(checkNegro.isSelected()==true){
			colores = colores + "\t Negro\n";
			colors[4] = "Negro";
		}

		if(radioLts.isSelected()==true){
			resMedida = " Unidad de medida: \n\t Litros\n\n";
			unite="Litros";	
		}
		if(radioGrs.isSelected()==true){
			resMedida = " Unidad de medida: \n\t Gramos\n\n";
			unite="Gramos";	
		}	
		if(radioPaq.isSelected()==true){
			resMedida = " Unidad de medida: \n\t Paquetes\n\n";
			unite="Paquetes";	
		}
		if(radioBul.isSelected()==true){
			resMedida = " Unidad de medida: \n\t Bultos\n\n";
			unite="Bultos";	
		}
		if(radioCub.isSelected()==true){
			resMedida = " Unidad de medida: \n\t Cubetas\n\n";	
			unite="Cubetas";
		}
		if(radioUnid.isSelected()==true){
			resMedida = " Unidad de medida: \n\t Unidades\n\n";
			unite="Unidades";	
		}

		resColores = colores;
	}//Fin del método stateChanged


	public void keyPressed(KeyEvent t){

	}//Fin del "keyPressed"

	public void keyReleased(KeyEvent t){
		if(campoArticulo.isFocusOwner()){
			String cadena = campoArticulo.getText();// En esta variable se guarda el texto a validar
  			int longCadena = cadena.length(); //Regresa la longitud de la cadena
		   
			for (int x=0; x<longCadena; x++){
         			char caracter = cadena.charAt(x);  //Va tomando caracter por caracter  
       				int  caracterCode = (int) caracter; //Casting: "Convierte" a entero un char  
  				if (caracterCode>=65&&caracterCode<=90||caracterCode>=97&&caracterCode<=122||caracterCode==32){
       					cad = cad + caracter;
	 			}else{
					JOptionPane.showMessageDialog(this,"El nombre del articulo debe estar solo escrito en letras");
					campoArticulo.setText(cad);
				}
				if(t.getKeyCode() == KeyEvent.VK_ENTER){
              				artic = cad;
					campoCant.requestFocusInWindow();
  				} 
			}
			artic = cad;
			cad = "";
		}

		if(campoCant.isFocusOwner()){
			String cadena = campoCant.getText();// En esta variable se guarda el texto a validar
  			int longCadena = cadena.length(); //Regresa la longitud de la cadena
		   
			for (int x=0; x<longCadena; x++){
         			char caracter = cadena.charAt(x);  //Va tomando caracter por caracter  
       				int  caracterCode = (int) caracter; //Casting: "Convierte" a entero un char  
  				if (caracterCode>=48&&caracterCode<=57){
					resguardo = cadcant;
       					cadcant = cadcant + caracter;
	 			}else{
					JOptionPane.showMessageDialog(this,"La cantidad solo debe ser escrita en numeros enteros");
					campoCant.setText(cadcant);
				}
				
				try{
				int cnt = Integer.valueOf(cadcant);
				if(cnt>100000){
					JOptionPane.showMessageDialog(this,"Solo se puede ingresar una cantidad menor o igual a 100000 (cien mil)");
					campoCant.setText(resguardo);
					campoFechaI.requestFocusInWindow();	
				}
				if(t.getKeyCode() == KeyEvent.VK_ENTER){
					canti = cadcant;
					campoFechaI.requestFocusInWindow();
  				}
				} catch(NumberFormatException e){
					campoCant.setText(resguardo);
					resguardo = "";
				}
 
			}
			canti = cadcant;
			cadcant = "";
			resguardo = "";
		}
		
		
		if(campoFechaI.isFocusOwner()){
			String cadenaF = campoFechaI.getText();// En esta variable se guarda el texto a validar
			int longCadena = cadenaF.length(); //Regresa la longitud de la cadena
		   
			for (int x=0; x<longCadena; x++){
         			char caracter = cadenaF.charAt(x);  //Va tomando caracter por caracter  
       				int  caracterCode = (int) caracter; //Casting: "Convierte" a entero un char  
  				if (caracterCode>=48&&caracterCode<=57||caracterCode==45){
       					cadf = cadf + caracter;
	 			}else{
					JOptionPane.showMessageDialog(this,"El formato de fecha es: aaaa-mm-dd");
					campoFechaI.setText(cadf);
				}
				if(t.getKeyCode() == KeyEvent.VK_ENTER){
              				fech = cadf;
					if(campoArticulo.getText().equals("")){
						campoArticulo.requestFocusInWindow();
					}
					else if(campoCant.getText().equals("")){
						campoCant.requestFocusInWindow();
					}
					else{
						JOptionPane.showMessageDialog(this,"De click en el boton para agregar el nuevo articulo");
						break;
					}
  				} 
			}
			fech = cadf;
			cadf = "";
		}
	}//Fin del "keyReleased"
	
	public void keyTyped(KeyEvent t){	

	}//Fin del "keyTyped"
} //Fin de la clase Nuevo