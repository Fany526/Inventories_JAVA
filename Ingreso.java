// Programa en Java de la clase "Ingreso"
// Proyecto Final de Programación Avanzada
// Ventana Ingresar mercancía de algún articulo disponible

import javax.swing.*; //Se necesita para diseño de ventanas
import javax.swing.event.*; //Se necesita para eventos de Check box y Radio button
import java.awt.event.*; //Se necesita para disparar eventos
import java.awt.*; //Se necesita para darle formato a la letra de los componentes

public class Ingreso extends JFrame implements ActionListener, ItemListener, MouseListener, FocusListener, KeyListener{
	final int poscx = 800;
	final int poscy = 250;
	private JMenuBar menubar;
	private JMenu menuOpcs, menuApariencia;
	private JMenuItem menuiPrincipal, menuiBlanco, menuiNegro, menuiOriginal;
	private JLabel etiqArticulo, etiqCant, etiqFechaI, etiqueta;
	private JLabel etiqInstruc, etiqInstruc1, etiqInstruc2;
	private JTextField campoCant, campoFechaI;
	private JComboBox <String> comboArticulos;
	private JButton botonIngresar;
	
	public int colorVentana, foco = 0, existencia, cantidadIni;
	public String ingreso, cad = "", cantidad="",resArtic="",cadf ="",fech,resguardo = "";
	public boolean canti = false, fechi = false;
	public static String articulosI[] = new String[6];
	public static int cantidadI[] = new int[6];
	public static String fechaII[] = new String[6];

	public static int existi[] = new int[6];
	public static String fechaIngN[] = new String[6];

public void Color(){
	if(colorVentana==0){
		getContentPane().setBackground(new Color(76,228,255));
		etiqArticulo.setForeground(Color.BLACK);  
		etiqCant.setForeground(Color.BLACK); 
		etiqFechaI.setForeground(Color.BLACK);
		etiqInstruc.setForeground(Color.BLACK); 
		etiqInstruc1.setForeground(Color.BLACK); 
		etiqInstruc2.setForeground(Color.BLACK);   
	}
	if(colorVentana==1){
		getContentPane().setBackground(Color.WHITE);
		etiqArticulo.setForeground(Color.BLACK); 
		etiqCant.setForeground(Color.BLACK); 
		etiqFechaI.setForeground(Color.BLACK); 
		etiqInstruc.setForeground(Color.BLACK); 
		etiqInstruc1.setForeground(Color.BLACK); 
		etiqInstruc2.setForeground(Color.BLACK); 
	}
	if(colorVentana==2){
		getContentPane().setBackground(Color.BLACK);
		etiqArticulo.setForeground(Color.WHITE);
		etiqCant.setForeground(Color.WHITE);
		etiqFechaI.setForeground(Color.WHITE);
		etiqInstruc.setForeground(Color.WHITE);
		etiqInstruc1.setForeground(Color.WHITE);
		etiqInstruc2.setForeground(Color.WHITE); 
	}
}

//Constructor
	public Ingreso(){
	setLayout(null);
	setTitle("Ingreso de mercancias");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setIconImage(new ImageIcon(getClass().getResource("Logo.png")).getImage());

Inventarios ventanaI = new Inventarios();
	for(int z=0;z<=5;z++){
		articulosI[z] = ventanaI.articuloss[z];
		cantidadI[z] = ventanaI.cantidads[z];
		fechaII[z] = ventanaI.fechaRs[z];
	
		if(articulosI[z]==null){
			Datos ventanaD1 = new Datos();
			articulosI[z] = ventanaD1.articulosD[z];
			cantidadI[z] = ventanaD1.cantidadD[z];
			fechaII[z] = ventanaD1.fechaRD[z];
		}//Fin del if null

		if(existi[z]!=0){
			cantidadI[z] = existi[z];
		}
	}//Fin del for "z"

//Etiquetas
	etiqArticulo = new JLabel("Articulo");
	etiqArticulo.setBounds(40,80,150,35); //x, y, ancho, alto
	etiqArticulo.setFont(new Font("arial",Font.BOLD,25)); 
	add(etiqArticulo);

	etiqCant = new JLabel("Cantidad a ingresar");
	etiqCant.setBounds(40,190,250,35); //x, y, ancho, alto
	etiqCant.setFont(new Font("arial",Font.BOLD,25)); 
	add(etiqCant);

	etiqFechaI = new JLabel("Fecha de ingreso");
	etiqFechaI.setBounds(40,300,220,35); //x, y, ancho, alto
	etiqFechaI.setFont(new Font("arial",Font.BOLD,25)); 
	add(etiqFechaI);

	etiqueta = new JLabel("");
	etiqueta.setBounds(410,440,220,35); //x, y, ancho, alto
	etiqueta.setFont(new Font("arial",Font.BOLD,25)); 
	add(etiqueta);

	etiqInstruc = new JLabel("Instrucciones");
	etiqInstruc.setBounds(40,400,250,35); //x, y, ancho, alto
	etiqInstruc.setFont(new Font("arial",Font.ITALIC,25)); 
	add(etiqInstruc);

	etiqInstruc1 = new JLabel("Click en el boton derecho del mouse");
	etiqInstruc1.setBounds(40,440,450,35); //x, y, ancho, alto
	etiqInstruc1.setFont(new Font("arial",Font.PLAIN,25)); 
	add(etiqInstruc1);
	
	etiqInstruc2 = new JLabel("o en el boton para ingresar");
	etiqInstruc2.setBounds(40,480,350,35); //x, y, ancho, alto
	etiqInstruc2.setFont(new Font("arial",Font.PLAIN,25)); 
	add(etiqInstruc2);

	Inventarios ventanaAnterior = new Inventarios();
	colorVentana = ventanaAnterior.color;
	Color();

//Text Field
	campoCant = new JTextField();
	campoCant.setBounds(320,190,330,35);
	campoCant.setFont(new Font("arial",Font.PLAIN,23)); 
	add(campoCant);

	campoFechaI = new JTextField();
	campoFechaI.setBounds(320,300,330,35);
	campoFechaI.setFont(new Font("arial",Font.PLAIN,23)); 
	add(campoFechaI);

//Combo Box
	comboArticulos = new JComboBox<String>();
	comboArticulos.setBounds(320,90,330,35);
	comboArticulos.setFont(new Font("arial",Font.PLAIN,21));
	comboArticulos.setEditable(true); 
	comboArticulos.setSelectedItem(" Elige un articulo");
	add(comboArticulos);

	comboArticulos.addItem(" Elige un articulo");
	for(int i=0;i<=5;i++){
		if(!articulosI[i].equals("")){
			comboArticulos.addItem(articulosI[i]);
		}
	}
	comboArticulos.addItemListener(this);

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
	botonIngresar = new JButton("Ingresar");
	botonIngresar.setBounds(410,540,150,45);
	botonIngresar.setForeground(Color.WHITE);
	botonIngresar.setBackground(new Color(255,56,56));
	botonIngresar.setFont(new Font("arial",Font.BOLD,21)); 
	add(botonIngresar);
	
	addMouseListener(this);
	botonIngresar.addActionListener(this);

	campoCant.addFocusListener(this);
	campoFechaI.addFocusListener(this);
	setFocusable(true);
	campoCant.addKeyListener(this);
	campoFechaI.addKeyListener(this);
	} //Fin del Constructor de la clase Ingreso

	public void actionPerformed(ActionEvent accion5){
		if(accion5.getSource() == menuiPrincipal){
			Inventarios ventana = new Inventarios();
			ventana.setBounds(poscx,poscy,700,700); //x, y, ancho, alto
			ventana.setVisible(true);
			ventana.setResizable(false); //Para que no se modifique el tamaño de la ventana
			dispose();
		} //Fin del if
		if(accion5.getSource() == menuiBlanco){
			colorVentana=1;
			Color();
		} //Fin del if
		if(accion5.getSource() == menuiNegro){
			colorVentana=2;
			Color();
		} //Fin del if
		if(accion5.getSource() == menuiOriginal){
			colorVentana=0;
			Color();
		} //Fin del if
		if(accion5.getSource() == botonIngresar){
			try{
			if(!campoCant.getText().equals("")&&!campoFechaI.getText().equals("")&&!resArtic.equals("")){
				ingreso = campoCant.getText();
				int cantIngreso = Integer.valueOf(ingreso);
				for(int z=0;z<=5;z++){
					if(resArtic.equals(articulosI[z])){
						fechaIngN[z]=campoFechaI.getText();
						cantidadIni = cantidadI[z];
						existencia = cantidadIni + cantIngreso;
						existi[z] = existencia;
						Inventarios ventana = new Inventarios();
						ventana.setBounds(poscx,poscy,700,700); //x, y, ancho, alto
						ventana.setVisible(true);
						ventana.setResizable(false); //Para que no se modifique el tamaño de la ventana
						dispose();	
					}
				}
			}else{
				JOptionPane.showMessageDialog(etiqueta,"Falta llenar algun campo");
			}
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(etiqueta,"La cantidad es demasiado grande, prueba con menor a diez mil millones (10 ceros)");
				campoCant.requestFocusInWindow();
			}
		} //Fin del if
	}//Fin del método actionPerformed
	
	public void itemStateChanged(ItemEvent accion5){
		String selecArtic = comboArticulos.getSelectedItem().toString();
		
		if(!selecArtic.equals(" Elige un articulo")){
			resArtic = selecArtic;
		}else{
			JOptionPane.showMessageDialog(etiqueta,"Falta seleccionar un articulo");
		}
	}//Fin del método stateChanged

	public void mouseEntered(MouseEvent accion){

	}//Fin del "mouseEntered"

	public void mouseExited(MouseEvent accion){

	}//Fin del "mouseExited"
	
	public void mousePressed(MouseEvent accion){
		int valorBoton = accion.getModifiersEx();

		if(valorBoton == 4096){		
			try{
			int opcion;
			if(!campoCant.getText().equals("")&&!campoFechaI.getText().equals("")&&!resArtic.equals("")){
				ingreso = campoCant.getText();
				int cantIngreso = Integer.valueOf(ingreso);
				for(int z=0;z<=5;z++){
					if(resArtic.equals(articulosI[z])){
						fechaIngN[z]=campoFechaI.getText();
						cantidadIni = cantidadI[z];
						existencia = cantidadIni + cantIngreso;
						existi[z] = existencia;
						Inventarios ventana = new Inventarios();
						ventana.setBounds(poscx,poscy,700,700); //x, y, ancho, alto
						ventana.setVisible(true);
						ventana.setResizable(false); //Para que no se modifique el tamaño de la ventana
						dispose();	
					}
				}
			}else{
				JOptionPane.showMessageDialog(etiqueta,"Falta llenar algun campo");
			}
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(etiqueta,"La cantidad es demasiado grande, prueba con menor a diez mil millones (10 ceros)");
				campoCant.requestFocusInWindow();
			}
		}
	}//Fin del "mousePressed"

	public void mouseReleased(MouseEvent accion){

	}//Fin del "mouseReleased"

	public void mouseClicked(MouseEvent accion){

	}////Fin del "mouseClicked"

	public void focusGained(FocusEvent f){
		String cadenaC = campoCant.getText();
		String cadenaFI = campoFechaI.getText();
		if(campoCant.isFocusOwner()&&foco==0&&cadenaC.equals("")){
			canti = true;
			foco=1;
		}
		if(campoFechaI.isFocusOwner()&&foco==0&&cadenaFI.equals("")){
			fechi = true;
			foco=2;
		}

	}//Fin del "focusGained"

	public void focusLost(FocusEvent f){
		String cadenaC = campoCant.getText();
		String cadenaFI = campoFechaI.getText();
	
		while(cadenaC.equals("")&&canti==true&&foco==1){
			canti = false;
			JOptionPane.showMessageDialog(etiqueta,"Olvidaste ingresar una cantidad");
			campoCant.requestFocusInWindow();
			foco=0;
			break;	
		}

		while(cadenaFI.equals("")&&fechi==true&&foco==2){
			fechi = false;
			JOptionPane.showMessageDialog(etiqueta,"Olvidaste ingresar una fecha");
			campoFechaI.requestFocusInWindow();
			foco=0;		
			break;
		}
	}//Fin del "focusLost"

	public void keyPressed(KeyEvent t){

	}//Fin del "keyPressed"

	public void keyReleased(KeyEvent t){
		if(campoCant.isFocusOwner()){
			String cadena = campoCant.getText();// En esta variable se guarda el texto a validar
  			int longCadena = cadena.length(); //Regresa la longitud de la cadena
		   
			for (int x=0; x<longCadena; x++){
         			char caracter = cadena.charAt(x);  //Va tomando caracter por caracter  
       				int  caracterCode = (int) caracter; //Casting: "Convierte" a entero un char  
  				if (caracterCode>=48&&caracterCode<=57){ 
					resguardo = cad;
       					cad = cad + caracter;
	 			}else{
					JOptionPane.showMessageDialog(etiqueta,"La cantidad solo debe ser escrita en numeros enteros");
					campoCant.setText(cad);
				}
				
				
				try{
				int cnt = Integer.valueOf(cad);
				if(cnt>100000){
					JOptionPane.showMessageDialog(this,"Solo se puede ingresar una cantidad menor o igual a 100000 (cien mil)");
					campoCant.setText(resguardo);
					campoFechaI.requestFocusInWindow();	
				}
				if(t.getKeyCode() == KeyEvent.VK_ENTER){
					ingreso = campoCant.getText();
					campoFechaI.requestFocusInWindow();
					break;
  				}
				} catch(NumberFormatException e){
					campoCant.setText(resguardo);
					resguardo = "";
				}
 
			}
			cantidad = cad;
			cad = "";
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
					JOptionPane.showMessageDialog(etiqueta,"El formato de fecha es: aaaa-mm-dd");
					campoFechaI.setText(cadf);
				}
				if(t.getKeyCode() == KeyEvent.VK_ENTER){
              				fech = cadf;
					if(campoCant.getText().equals("")){
						campoFechaI.requestFocusInWindow();
					}
					else if(campoCant.getText().equals("")){
						campoCant.requestFocusInWindow();
					}				
					else{
						JOptionPane.showMessageDialog(etiqueta,"De click en el boton ingresar o en el boton izquierdo del mouse");
					}
  				} 
			}
			fech = cadf;
			cadf = "";
		}
		
		
	}//Fin del "keyReleased"
	
	public void keyTyped(KeyEvent t){	

	}//Fin del "keyTyped"


} //Fin de la clase Ingreso
