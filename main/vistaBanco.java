
package main;

import java.time.LocalDateTime;
import java.awt.Dimension;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class vistaBanco extends javax.swing.JFrame {
    
    //variables funcionalidad
    private vistaCliente vistaClientes;
    private vistaMesas vistaMesa; //hacer que reciba el conjunto mesas para ir actualizandolas 
    private vistaFacturas vistaFactura;
    private vistaProducto nuevoProducto;
    public mesa mAsignada;
    private vistaBanco principal = this;
    private conjuntoProductos menuPlatos; 
    private conjuntoProductos menuBebidas; 
    private modeloTablaProducto modeloProducto;
    private recibo facturaDif = new recibo("");
    private ArrayList <JButton> botonesEntradas; 
    private ArrayList <JButton> botonesBebidas; 
    private conjuntoMeseros meseros;
    private conjuntoFacturas facturasDelDia;
    private String tipoServicio;
    private String cantidadSeleccionada = "1";
    private boolean Pagado = false; 
    DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");
    //Fin variables funcionalidad
    
    public vistaBanco() {
        initValores();
        cargarPlatos();
        cargarMeseros();
        initComponents();
        initBotonesMenu();
        cargarBotones();
    }
    
    private void cargarBotones(){
        botonesEntradas = new ArrayList<>();
        botonesBebidas = new ArrayList<>();
        botonesEntradas.add(entrada1);
        botonesEntradas.add(entrada2);
        botonesEntradas.add(entrada3);
        botonesEntradas.add(entrada4);
        botonesEntradas.add(entrada5);
        botonesEntradas.add(entrada6);
        botonesEntradas.add(entrada7);
        botonesEntradas.add(entrada8);
        botonesEntradas.add(entrada9);
        botonesEntradas.add(entrada10);
        botonesEntradas.add(entrada11);
        botonesEntradas.add(entrada12);
        botonesEntradas.add(entrada13);
        botonesEntradas.add(entrada14);
        botonesEntradas.add(entrada15);
        botonesBebidas.add(bebida1);
        botonesBebidas.add(bebida2);
        botonesBebidas.add(bebida3);
        botonesBebidas.add(bebida4);
        botonesBebidas.add(bebida5);
        botonesBebidas.add(bebida6);
        botonesBebidas.add(bebida7);
        botonesBebidas.add(bebida8);
        botonesBebidas.add(bebida9);
        botonesBebidas.add(bebida10);
        botonesBebidas.add(bebida11);
        botonesBebidas.add(bebida12);
        botonesBebidas.add(bebida13);
        botonesBebidas.add(bebida14);
        botonesBebidas.add(bebida15);
    }
    private void cargarPlatos(){
        producto Plato1 = new producto("78612A","Casado con Bistec", 3550);
        producto Plato2 = new producto("987948B","Casado con Chuleta", 3450);
        producto Plato3 = new producto("545104C","Casado con Pescad0", 3750);
        producto Plato4 = new producto("897043D","Chifrijo", 3000);
        producto Plato5 = new producto("123104E","Gallo Pinto", 2700);
        producto Plato6 = new producto("203654F","Olla de Carne", 4750);
        producto Plato7 = new producto("356846G","Tamal", 1300);
        producto Plato8 = new producto("407934H","Tortilla Alinnada", 1000);
        producto Plato9 = new producto("689404I","Vigoron", 3000);
        menuPlatos.Agregar(Plato1);
        menuPlatos.Agregar(Plato2);
        menuPlatos.Agregar(Plato3);
        menuPlatos.Agregar(Plato4);
        menuPlatos.Agregar(Plato5);
        menuPlatos.Agregar(Plato6);
        menuPlatos.Agregar(Plato7);
        menuPlatos.Agregar(Plato8);
        menuPlatos.Agregar(Plato9);
        producto Bebida1 = new producto("123006A","Fresco de Cas", 1000);
        producto Bebida2 = new producto("208574B","Fresco de Chan", 800);
        producto Bebida3 = new producto("358504C","Crema con Helados", 1200);
        producto Bebida4 = new producto("450848D","Fresco de Frutas", 1200);
        producto Bebida5 = new producto("548908E","Fresco de Guanabana", 100);
        producto Bebida6 = new producto("689703F","Horchata", 800);
        producto Bebida7 = new producto("798096G","Fresco de Maracuya", 1000);
        producto Bebida8 = new producto("890467H","Fresco de Mora", 1000);
        producto Bebida9 = new producto("936502I","Fresco de Tamarindo", 1000);
        menuBebidas.Agregar(Bebida1);
        menuBebidas.Agregar(Bebida2);
        menuBebidas.Agregar(Bebida3);
        menuBebidas.Agregar(Bebida4);
        menuBebidas.Agregar(Bebida5);
        menuBebidas.Agregar(Bebida6);
        menuBebidas.Agregar(Bebida7);
        menuBebidas.Agregar(Bebida8);
        menuBebidas.Agregar(Bebida9); 
    }
    
    private void limpiar(){
        mAsignada.limpiar();
        facturaDif = new recibo(tipoServicio);
        txtMesa.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtNombre.setText("");
        txtMesero.setText("");
        txtSubT.setText("");
        txtTotal.setText("");
        txtIVA.setText("");
        if("Comer Aqui".equals(tipoServicio)){
            modeloProducto.reasignar(mAsignada.miFactura().platos()); //revisar esto en un futuro
        }else{
            modeloProducto.reasignar(facturaDif.platos());
        }
        modeloProducto.fireTableDataChanged();
    }
    
    public void agregarBebida(producto bebida){
        menuBebidas.Agregar(bebida);
        for(int i = 0; i < botonesBebidas.size(); i++){
            if(!botonesBebidas.get(i).isVisible()){
                botonesBebidas.get(i).setText(menuBebidas.Recuperar(i).getNombre());
                botonesBebidas.get(i).setVisible(true);
                break;
            }
        }
    }
    public void agregarPlatillo(producto plato){
        menuPlatos.Agregar(plato);
        for(int i = 0; i < botonesEntradas.size(); i++){
            if(!botonesEntradas.get(i).isVisible()){
                botonesEntradas.get(i).setText(menuPlatos.Recuperar(i).getNombre());
                botonesEntradas.get(i).setVisible(true);
                break;
            }
        }
    }
    
        
    private void ingresarPlatillo(int i){
        cantidadSeleccionada = txtCantidad.getText();
        producto plato = menuPlatos.Recuperar(i); 
        boolean validacion = validarDuplicado(plato);
        if(validacion == false){
            plato.ajustarCantidad(Integer.parseInt(cantidadSeleccionada));
            if("Comer Aqui".equals(tipoServicio)){
               mAsignada.miFactura().agregarPlatillo(plato);
           }else{
               facturaDif.agregarPlatillo(plato);
           }
        }
        calcular();
        modeloProducto.fireTableDataChanged();
    }
    private void ingresarBebida(int i){
        cantidadSeleccionada = txtCantidad.getText();
        producto bebida = menuBebidas.Recuperar(i); 
        boolean validacion = validarDuplicado(bebida);
        if(validacion == false){
           bebida.ajustarCantidad(Integer.parseInt(cantidadSeleccionada));
           if("Comer Aqui".equals(tipoServicio)){
               mAsignada.miFactura().agregarPlatillo(bebida);
           }else{
               facturaDif.agregarPlatillo(bebida);
           }
        }
        calcular();
        modeloProducto.fireTableDataChanged();
    }
    
    private boolean validarDuplicado(producto product){
        boolean validacion = false;
        if("Comer Aqui".equals(tipoServicio)){
               for(int x = 0; x < mAsignada.miFactura().platos().NProductos(); x++){
            if(product.getNombre().equals(mAsignada.miFactura().platos().Recuperar(x).getNombre())){
                mAsignada.miFactura().platos().Recuperar(x).asignarCantidad(Integer.parseInt(cantidadSeleccionada));
                validacion =true;
                break;
                }
            }
         }else{
                for(int x = 0; x < facturaDif.platos().NProductos(); x++){
            if(product.getNombre().equals(facturaDif.platos().Recuperar(x).getNombre())){
                facturaDif.platos().Recuperar(x).asignarCantidad(Integer.parseInt(cantidadSeleccionada));
                validacion =true;
                break;
                }
            }
           }
        
        return validacion;
    }
    
    public void calcular(){
        if("Comer Aqui".equals(tipoServicio)){
            mAsignada.miFactura().obtenerTotal();
            txtSubT.setText(String.valueOf(mAsignada.miFactura().getSTotal()));
            txtIVA.setText(String.valueOf(mAsignada.miFactura().getIVA()));
             if(!"Comer Aqui".equals(tipoServicio)){
                mAsignada.miFactura().aplicarDescuento();
            }
            txtTotal.setText(String.valueOf(mAsignada.miFactura().getTotal()));
        }else{
            facturaDif.obtenerTotal();
            txtSubT.setText(String.valueOf( facturaDif.getSTotal()));
            txtIVA.setText(String.valueOf( facturaDif.getIVA()));
             if(!"Comer Aqui".equals(tipoServicio)){
                 facturaDif.aplicarDescuento();
            }
            txtTotal.setText(String.valueOf( facturaDif.getTotal()));
        }
        
    }
    
    public void cargarMesa(mesa Mesa){
        mAsignada = Mesa;
        txtMesa.setText(Integer.toString(mAsignada.numero()));
        txtNombre.setText(mAsignada.cAsignado());
        txtMesero.setText(mAsignada.mAsignado());
        Pagado = false;
        calcular();
        btnAsignarMesero.setVisible(true);
        agregarCliente.setVisible(true);
        modeloProducto.reasignar(mAsignada.miFactura().platos());
        modeloProducto.fireTableDataChanged();
    }
    
        public void cargarCliente(cliente Comensal){
        if("Comer Aqui".equals(tipoServicio)){
        mAsignada.asignarCliente(Comensal);
        txtNombre.setText(mAsignada.cAsignado());
        }else{
             facturaDif.agregarCliente(Comensal.nombre());
        if("Express".equals(tipoServicio)){
            txtDireccion.setText(Comensal.dir());
            txtTelefono.setText(Comensal.tel());
        }
        txtNombre.setText(Comensal.nombre());
        }
    }
        private void cargarMeseros(){
        mesero mesero1 = new mesero("Jeff Vargas");
        mesero mesero2 = new mesero("Caleb Sanchez");
        mesero mesero3 = new mesero("Andres Fernandez");
        mesero mesero4 = new mesero("Alejandro Alfaro");
        mesero mesero5 = new mesero("Diego Alpizar");
        mesero mesero6 = new mesero("Horacio Gomez");
        meseros.agregar(mesero1);
        meseros.agregar(mesero2);
        meseros.agregar(mesero3);
        meseros.agregar(mesero4);
        meseros.agregar(mesero5);
        meseros.agregar(mesero6); 
    }
        
      private void initBotonesMenu(){
        
    bebida10.setVisible(false);
    bebida11.setVisible(false);
    bebida12.setVisible(false);
    bebida13.setVisible(false);
    bebida14.setVisible(false);
    bebida15.setVisible(false);
    
    entrada10.setVisible(false);
    entrada11.setVisible(false);
    entrada12.setVisible(false);
    entrada13.setVisible(false);
    entrada14.setVisible(false);
    entrada15.setVisible(false);
      
    }
    
    private void initValores(){
        mAsignada = new mesa(0, 0);
        vistaMesa = new vistaMesas(principal);
        tipoServicio = "Comer Aqui";
        menuPlatos = new conjuntoProductos();
        menuBebidas = new conjuntoProductos();
        modeloProducto = new modeloTablaProducto(mAsignada.miFactura().platos());
        meseros = new conjuntoMeseros();
        facturasDelDia = new conjuntoFacturas(); 
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMantenimiento = new javax.swing.JPanel();
        tituloMantenimiento = new javax.swing.JLabel();
        btnAgregarMesero = new javax.swing.JButton();
        btnAgregarProducto = new javax.swing.JButton();
        btnGenerar = new javax.swing.JButton();
        panelTitulo1 = new javax.swing.JPanel();
        tituloTitulo = new javax.swing.JLabel();
        imagenIcono = new javax.swing.JLabel();
        btnComerAqui = new javax.swing.JButton();
        btnExpress = new javax.swing.JButton();
        btnParaLlevar = new javax.swing.JButton();
        panelInformacion = new javax.swing.JPanel();
        agregarCliente = new javax.swing.JButton();
        btnAsignarMesero = new javax.swing.JButton();
        btnAsignarMesa = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        txtMesa = new javax.swing.JTextField();
        tituloMesa = new javax.swing.JLabel();
        labelMesero = new javax.swing.JLabel();
        txtMesero = new javax.swing.JTextField();
        panelFactura = new javax.swing.JPanel();
        scrollTabla = new javax.swing.JScrollPane();
        tablaFactura = new javax.swing.JTable();
        tituloFactura = new javax.swing.JLabel();
        panelTotal = new javax.swing.JPanel();
        tituloTotal = new javax.swing.JLabel();
        tituloIva = new javax.swing.JLabel();
        tituloSubT = new javax.swing.JLabel();
        txtSubT = new javax.swing.JTextField();
        txtIVA = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fechaLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelTel = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        labelDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        tituloNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        scrollPaneMenu2 = new javax.swing.JScrollPane();
        panelMenu2 = new javax.swing.JPanel();
        bebida1 = new javax.swing.JButton();
        bebida2 = new javax.swing.JButton();
        bebida3 = new javax.swing.JButton();
        bebida4 = new javax.swing.JButton();
        bebida5 = new javax.swing.JButton();
        bebida6 = new javax.swing.JButton();
        bebida7 = new javax.swing.JButton();
        bebida8 = new javax.swing.JButton();
        bebida9 = new javax.swing.JButton();
        bebida10 = new javax.swing.JButton();
        bebida11 = new javax.swing.JButton();
        bebida12 = new javax.swing.JButton();
        bebida13 = new javax.swing.JButton();
        bebida14 = new javax.swing.JButton();
        bebida15 = new javax.swing.JButton();
        labelBebidas = new javax.swing.JLabel();
        scrollPaneMenu1 = new javax.swing.JScrollPane();
        panelMenu1 = new javax.swing.JPanel();
        entrada1 = new javax.swing.JButton();
        entrada2 = new javax.swing.JButton();
        entrada3 = new javax.swing.JButton();
        entrada4 = new javax.swing.JButton();
        entrada5 = new javax.swing.JButton();
        entrada6 = new javax.swing.JButton();
        entrada7 = new javax.swing.JButton();
        entrada8 = new javax.swing.JButton();
        entrada9 = new javax.swing.JButton();
        entrada10 = new javax.swing.JButton();
        entrada11 = new javax.swing.JButton();
        entrada12 = new javax.swing.JButton();
        entrada13 = new javax.swing.JButton();
        entrada14 = new javax.swing.JButton();
        entrada15 = new javax.swing.JButton();
        labelComidas = new javax.swing.JLabel();
        panelSeleccion = new javax.swing.JPanel();
        btnComidas = new javax.swing.JButton();
        btnBebidas = new javax.swing.JButton();
        tituloCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA_DE_VENTAS");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setPreferredSize(new Dimension(1138, 869));
        setSize(1108, 819);
        getContentPane().setLayout(null);

        panelMantenimiento.setBackground(new java.awt.Color(255, 204, 204));
        panelMantenimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelMantenimiento.setLayout(null);

        tituloMantenimiento.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tituloMantenimiento.setText("Mantenimiento de Datos");
        panelMantenimiento.add(tituloMantenimiento);
        tituloMantenimiento.setBounds(100, 40, 230, 22);

        btnAgregarMesero.setBackground(new java.awt.Color(255, 153, 153));
        btnAgregarMesero.setText("Agregar Meseros");
        btnAgregarMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMeseroActionPerformed(evt);
            }
        });
        panelMantenimiento.add(btnAgregarMesero);
        btnAgregarMesero.setBounds(410, 10, 160, 80);

        btnAgregarProducto.setBackground(new java.awt.Color(255, 153, 153));
        btnAgregarProducto.setText("Agregar Nuevo Producto al menu");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        panelMantenimiento.add(btnAgregarProducto);
        btnAgregarProducto.setBounds(600, 10, 250, 80);

        btnGenerar.setBackground(new java.awt.Color(255, 153, 153));
        btnGenerar.setText("Generar Informes del dia");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        panelMantenimiento.add(btnGenerar);
        btnGenerar.setBounds(880, 10, 180, 80);
        // hacer en otra ventana, que reciba por parametro  un conjuntoFacturas

        getContentPane().add(panelMantenimiento);
        panelMantenimiento.setBounds(10, 710, 1090, 100);

        panelTitulo1.setBackground(new java.awt.Color(255, 204, 204));
        panelTitulo1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTitulo1.setLayout(null);

        tituloTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tituloTitulo.setText("RESTAURANTE EL RESTAURANTE");
        panelTitulo1.add(tituloTitulo);
        tituloTitulo.setBounds(130, 40, 410, 20);

        imagenIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Restaurant-icon.png"))); // NOI18N
        panelTitulo1.add(imagenIcono);
        imagenIcono.setBounds(30, 10, 80, 80);

        btnComerAqui.setBackground(new java.awt.Color(204, 255, 0));
        btnComerAqui.setText("Comer Aqui");
        btnComerAqui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComerAquiActionPerformed(evt);
            }
        });
        panelTitulo1.add(btnComerAqui);
        btnComerAqui.setBounds(570, 20, 140, 60);

        btnExpress.setBackground(new java.awt.Color(0, 153, 255));
        btnExpress.setText("Express");
        btnExpress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpressActionPerformed(evt);
            }
        });
        panelTitulo1.add(btnExpress);
        btnExpress.setBounds(740, 20, 140, 60);

        btnParaLlevar.setBackground(new java.awt.Color(51, 153, 255));
        btnParaLlevar.setText("Para llevar");
        btnParaLlevar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParaLlevarActionPerformed(evt);
            }
        });
        panelTitulo1.add(btnParaLlevar);
        btnParaLlevar.setBounds(910, 20, 150, 60);

        getContentPane().add(panelTitulo1);
        panelTitulo1.setBounds(10, 10, 1090, 100);

        panelInformacion.setBackground(new java.awt.Color(255, 204, 204));
        panelInformacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelInformacion.setLayout(null);

        agregarCliente.setBackground(new java.awt.Color(255, 153, 153));
        agregarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        agregarCliente.setText("Asignar cliente");
        agregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarClienteActionPerformed(evt);
            }
        });
        panelInformacion.add(agregarCliente);
        agregarCliente.setBounds(10, 400, 140, 70);
        agregarCliente.setVisible(false);

        btnAsignarMesero.setBackground(new java.awt.Color(255, 153, 153));
        btnAsignarMesero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAsignarMesero.setText("Asignar Mesero");
        btnAsignarMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarMeseroActionPerformed(evt);
            }
        });
        panelInformacion.add(btnAsignarMesero);
        btnAsignarMesero.setBounds(10, 300, 140, 70);
        btnAsignarMesero.setVisible(false);

        btnAsignarMesa.setBackground(new java.awt.Color(255, 153, 153));
        btnAsignarMesa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAsignarMesa.setText("Buscar Mesas");
        btnAsignarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarMesaActionPerformed(evt);
            }
        });
        panelInformacion.add(btnAsignarMesa);
        btnAsignarMesa.setBounds(10, 10, 140, 40);

        btnPagar.setBackground(new java.awt.Color(255, 153, 153));
        btnPagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPagar.setText("Pagar/Cancelar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        panelInformacion.add(btnPagar);
        btnPagar.setBounds(10, 500, 140, 70);

        txtMesa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMesaActionPerformed(evt);
            }
        });
        panelInformacion.add(txtMesa);
        txtMesa.setBounds(40, 90, 80, 22);
        txtMesa.setEditable(false);
        txtMesa.setText("");

        tituloMesa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tituloMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloMesa.setText("Mesa");
        panelInformacion.add(tituloMesa);
        tituloMesa.setBounds(60, 60, 40, 20);

        labelMesero.setText("Mesero");
        panelInformacion.add(labelMesero);
        labelMesero.setBounds(60, 120, 50, 16);

        txtMesero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelInformacion.add(txtMesero);
        txtMesero.setBounds(20, 140, 120, 22);
        txtMesero.setEditable(false);
        txtMesero.setText("");

        getContentPane().add(panelInformacion);
        panelInformacion.setBounds(10, 110, 160, 600);

        panelFactura.setBackground(new java.awt.Color(255, 204, 204));
        panelFactura.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelFactura.setLayout(null);

        tablaFactura.setBackground(new java.awt.Color(240, 240, 240));
        tablaFactura.setModel(modeloProducto);
        scrollTabla.setViewportView(tablaFactura);

        panelFactura.add(scrollTabla);
        scrollTabla.setBounds(20, 90, 410, 370);

        tituloFactura.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tituloFactura.setText("FACTURA");
        panelFactura.add(tituloFactura);
        tituloFactura.setBounds(20, 10, 190, 29);

        panelTotal.setBackground(new java.awt.Color(255, 204, 204));
        panelTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTotal.setLayout(null);

        tituloTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tituloTotal.setText("TOTAL:");
        panelTotal.add(tituloTotal);
        tituloTotal.setBounds(20, 70, 70, 20);

        tituloIva.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tituloIva.setText("I.V.A:");
        panelTotal.add(tituloIva);
        tituloIva.setBounds(35, 40, 50, 20);

        tituloSubT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tituloSubT.setText("SubTotal:");
        panelTotal.add(tituloSubT);
        tituloSubT.setBounds(10, 10, 90, 22);

        txtSubT.setBackground(new java.awt.Color(240, 240, 240));
        txtSubT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubTActionPerformed(evt);
            }
        });
        panelTotal.add(txtSubT);
        txtSubT.setBounds(100, 10, 90, 22);
        txtSubT.setEditable(false);

        txtIVA.setBackground(new java.awt.Color(240, 240, 240));
        txtIVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIVAActionPerformed(evt);
            }
        });
        panelTotal.add(txtIVA);
        txtIVA.setBounds(100, 40, 90, 22);
        txtIVA.setEditable(false);

        txtTotal.setBackground(new java.awt.Color(240, 240, 240));
        panelTotal.add(txtTotal);
        txtTotal.setBounds(100, 70, 90, 22);
        txtTotal.setEditable(false);

        panelFactura.add(panelTotal);
        panelTotal.setBounds(190, 460, 220, 100);

        jLabel3.setText("Codigo: #017263HIRER");
        panelFactura.add(jLabel3);
        jLabel3.setBounds(300, 40, 140, 20);
        panelFactura.add(fechaLabel);
        fechaLabel.setBounds(330, 26, 110, 10);
        fechaLabel.setText(dtf5.format(LocalDateTime.now()));

        jLabel5.setText("Cajera: Melanie Gamboa");
        panelFactura.add(jLabel5);
        jLabel5.setBounds(290, 60, 150, 20);

        labelTel.setText("Telefono:");
        panelFactura.add(labelTel);
        labelTel.setBounds(20, 470, 60, 20);
        labelTel.setVisible(false);
        panelFactura.add(txtTelefono);
        txtTelefono.setBounds(80, 470, 100, 22);
        txtTelefono.setVisible(false);
        txtTelefono.setEditable(false);

        labelDireccion.setText("Direccion:");
        panelFactura.add(labelDireccion);
        labelDireccion.setBounds(20, 500, 70, 16);
        labelDireccion.setVisible(false);

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        panelFactura.add(txtDireccion);
        txtDireccion.setBounds(20, 520, 150, 70);
        txtDireccion.setVisible(false);
        txtDireccion.setEditable(false);

        tituloNombre.setText("Nombre del cliente");
        panelFactura.add(tituloNombre);
        tituloNombre.setBounds(20, 40, 110, 16);

        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        panelFactura.add(txtNombre);
        txtNombre.setBounds(20, 60, 140, 22);
        txtNombre.setEditable(false);
        txtNombre.setText("");

        getContentPane().add(panelFactura);
        panelFactura.setBounds(170, 110, 450, 600);

        panelMenu2.setBackground(new java.awt.Color(255, 204, 204));
        panelMenu2.setPreferredSize(new java.awt.Dimension(378, 668));
        panelMenu2.setLayout(null);

        bebida1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bebidas/Cas.png"))); // NOI18N
        bebida1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bebida1ActionPerformed(evt);
            }
        });
        panelMenu2.add(bebida1);
        bebida1.setBounds(40, 40, 120, 100);

        bebida2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bebidas/Chan.jpg"))); // NOI18N
        bebida2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bebida2ActionPerformed(evt);
            }
        });
        panelMenu2.add(bebida2);
        bebida2.setBounds(170, 40, 120, 100);

        bebida3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bebidas/Crema.png"))); // NOI18N
        bebida3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bebida3ActionPerformed(evt);
            }
        });
        panelMenu2.add(bebida3);
        bebida3.setBounds(300, 40, 120, 100);

        bebida4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bebidas/Frutas.jpg"))); // NOI18N
        bebida4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bebida4ActionPerformed(evt);
            }
        });
        panelMenu2.add(bebida4);
        bebida4.setBounds(40, 150, 120, 100);

        bebida5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bebidas/Guanabana.jpg"))); // NOI18N
        bebida5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bebida5ActionPerformed(evt);
            }
        });
        panelMenu2.add(bebida5);
        bebida5.setBounds(170, 150, 120, 100);

        bebida6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bebidas/Horchata.jpg"))); // NOI18N
        bebida6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bebida6ActionPerformed(evt);
            }
        });
        panelMenu2.add(bebida6);
        bebida6.setBounds(300, 150, 120, 100);

        bebida7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bebidas/Maracuya.jpg"))); // NOI18N
        bebida7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bebida7ActionPerformed(evt);
            }
        });
        panelMenu2.add(bebida7);
        bebida7.setBounds(40, 260, 120, 110);

        bebida8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bebidas/Mora.jpg"))); // NOI18N
        bebida8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bebida8ActionPerformed(evt);
            }
        });
        panelMenu2.add(bebida8);
        bebida8.setBounds(170, 260, 120, 110);

        bebida9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bebidas/Tamarindo.jpg"))); // NOI18N
        bebida9.setToolTipText("");
        bebida9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bebida9ActionPerformed(evt);
            }
        });
        panelMenu2.add(bebida9);
        bebida9.setBounds(300, 260, 120, 110);

        bebida10.setText("jButton10");
        bebida10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bebida10ActionPerformed(evt);
            }
        });
        panelMenu2.add(bebida10);
        bebida10.setBounds(40, 380, 120, 110);

        bebida11.setText("jButton11");
        bebida11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bebida11ActionPerformed(evt);
            }
        });
        panelMenu2.add(bebida11);
        bebida11.setBounds(170, 380, 120, 110);

        bebida12.setText("jButton12");
        bebida12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bebida12ActionPerformed(evt);
            }
        });
        panelMenu2.add(bebida12);
        bebida12.setBounds(300, 380, 120, 110);

        bebida13.setText("jButton13");
        bebida13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bebida13ActionPerformed(evt);
            }
        });
        panelMenu2.add(bebida13);
        bebida13.setBounds(40, 500, 120, 110);

        bebida14.setText("jButton14");
        bebida14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bebida14ActionPerformed(evt);
            }
        });
        panelMenu2.add(bebida14);
        bebida14.setBounds(170, 500, 120, 110);

        bebida15.setText("jButton15");
        bebida15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bebida15ActionPerformed(evt);
            }
        });
        panelMenu2.add(bebida15);
        bebida15.setBounds(300, 500, 120, 110);

        labelBebidas.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        labelBebidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBebidas.setText("Bebidas");
        panelMenu2.add(labelBebidas);
        labelBebidas.setBounds(180, 10, 110, 22);

        scrollPaneMenu2.setViewportView(panelMenu2);

        getContentPane().add(scrollPaneMenu2);
        scrollPaneMenu2.setBounds(620, 110, 480, 480);
        scrollPaneMenu2.setVisible(false);

        scrollPaneMenu1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneMenu1.setToolTipText("");

        panelMenu1.setBackground(new java.awt.Color(255, 204, 204));
        panelMenu1.setPreferredSize(new java.awt.Dimension(378, 668));
        panelMenu1.setLayout(null);

        entrada1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Comidas/Casado Bistec Encebollado.png"))); // NOI18N
        entrada1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada1ActionPerformed(evt);
            }
        });
        panelMenu1.add(entrada1);
        entrada1.setBounds(40, 40, 120, 100);

        entrada2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Comidas/Casado con Chuleta.jpg"))); // NOI18N
        entrada2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada2ActionPerformed(evt);
            }
        });
        panelMenu1.add(entrada2);
        entrada2.setBounds(170, 40, 120, 100);

        entrada3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Comidas/Casado con Pescado.jpg"))); // NOI18N
        entrada3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada3ActionPerformed(evt);
            }
        });
        panelMenu1.add(entrada3);
        entrada3.setBounds(300, 40, 120, 100);

        entrada4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Comidas/Chifrijo.jpg"))); // NOI18N
        entrada4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada4ActionPerformed(evt);
            }
        });
        panelMenu1.add(entrada4);
        entrada4.setBounds(40, 150, 120, 100);

        entrada5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Comidas/Gallo Pinto.png"))); // NOI18N
        entrada5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada5ActionPerformed(evt);
            }
        });
        panelMenu1.add(entrada5);
        entrada5.setBounds(170, 150, 120, 100);

        entrada6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Comidas/Olla de Carne.jpg"))); // NOI18N
        entrada6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada6ActionPerformed(evt);
            }
        });
        panelMenu1.add(entrada6);
        entrada6.setBounds(300, 150, 120, 100);

        entrada7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Comidas/Tamales.jpg"))); // NOI18N
        entrada7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada7ActionPerformed(evt);
            }
        });
        panelMenu1.add(entrada7);
        entrada7.setBounds(40, 260, 120, 110);

        entrada8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Comidas/Tortila Aliñada.jpeg"))); // NOI18N
        entrada8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada8ActionPerformed(evt);
            }
        });
        panelMenu1.add(entrada8);
        entrada8.setBounds(170, 260, 120, 110);

        entrada9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Comidas/Vigoron.png"))); // NOI18N
        entrada9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada9ActionPerformed(evt);
            }
        });
        panelMenu1.add(entrada9);
        entrada9.setBounds(300, 260, 120, 110);

        entrada10.setText("jButton10");
        entrada10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada10ActionPerformed(evt);
            }
        });
        panelMenu1.add(entrada10);
        entrada10.setBounds(40, 380, 120, 110);

        entrada11.setText("jButton11");
        entrada11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada11ActionPerformed(evt);
            }
        });
        panelMenu1.add(entrada11);
        entrada11.setBounds(170, 380, 120, 110);

        entrada12.setText("jButton12");
        entrada12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada12ActionPerformed(evt);
            }
        });
        panelMenu1.add(entrada12);
        entrada12.setBounds(300, 380, 120, 110);

        entrada13.setText("jButton13");
        entrada13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada13ActionPerformed(evt);
            }
        });
        panelMenu1.add(entrada13);
        entrada13.setBounds(40, 500, 120, 110);

        entrada14.setText("jButton14");
        entrada14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada14ActionPerformed(evt);
            }
        });
        panelMenu1.add(entrada14);
        entrada14.setBounds(170, 500, 120, 110);

        entrada15.setText("jButton15");
        entrada15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada15ActionPerformed(evt);
            }
        });
        panelMenu1.add(entrada15);
        entrada15.setBounds(300, 500, 120, 110);

        labelComidas.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        labelComidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelComidas.setText("Comidas");
        panelMenu1.add(labelComidas);
        labelComidas.setBounds(180, 10, 110, 22);

        scrollPaneMenu1.setViewportView(panelMenu1);

        getContentPane().add(scrollPaneMenu1);
        scrollPaneMenu1.setBounds(620, 110, 480, 480);

        panelSeleccion.setBackground(new java.awt.Color(255, 204, 204));
        panelSeleccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelSeleccion.setLayout(null);

        btnComidas.setBackground(new java.awt.Color(255, 153, 153));
        btnComidas.setText("Comidas");
        btnComidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComidasActionPerformed(evt);
            }
        });
        panelSeleccion.add(btnComidas);
        btnComidas.setBounds(30, 20, 110, 80);

        btnBebidas.setBackground(new java.awt.Color(255, 153, 153));
        btnBebidas.setText("Bebidas");
        btnBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebidasActionPerformed(evt);
            }
        });
        panelSeleccion.add(btnBebidas);
        btnBebidas.setBounds(160, 20, 120, 80);

        tituloCantidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tituloCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloCantidad.setText("Cantidad por seleccion:");
        panelSeleccion.add(tituloCantidad);
        tituloCantidad.setBounds(290, 30, 170, 17);

        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidad.setText(cantidadSeleccionada);
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        panelSeleccion.add(txtCantidad);
        txtCantidad.setBounds(340, 60, 69, 22);

        getContentPane().add(panelSeleccion);
        panelSeleccion.setBounds(620, 590, 480, 120);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entrada4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrada4ActionPerformed
        ingresarPlatillo(3);
    }//GEN-LAST:event_entrada4ActionPerformed

    private void bebida4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida4ActionPerformed
        ingresarBebida(3);
    }//GEN-LAST:event_bebida4ActionPerformed

    private void bebida12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida12ActionPerformed
        ingresarBebida(11);
    }//GEN-LAST:event_bebida12ActionPerformed

    private void bebida3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida3ActionPerformed
        ingresarBebida(2);
    }//GEN-LAST:event_bebida3ActionPerformed

    private void btnComidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComidasActionPerformed
        scrollPaneMenu1.setVisible(true);
        scrollPaneMenu2.setVisible(false);
    }//GEN-LAST:event_btnComidasActionPerformed

    private void txtIVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIVAActionPerformed
       ingresarBebida(0);
    }//GEN-LAST:event_txtIVAActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void agregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarClienteActionPerformed
      if("Comer Aqui".equals(tipoServicio)){
        if("".equals(mAsignada.cargarCliente().nombre())){
          vistaClientes = new vistaCliente(tipoServicio, principal);
          vistaClientes.setVisible(true);  
        }else{
         JOptionPane.showMessageDialog(null, "Ya esta mesa tiene un cliente asignado");
        }
      }else{
          if("".equals(txtNombre.getText())){
          vistaClientes = new vistaCliente(tipoServicio, principal);
          vistaClientes.setVisible(true);  
        }else{
         JOptionPane.showMessageDialog(null, "Ya esta mesa tiene un cliente asignado");
        }
      }
    }//GEN-LAST:event_agregarClienteActionPerformed

    private void txtMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesaActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
 
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnAsignarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarMesaActionPerformed
        vistaMesa.actualizarMesa(mAsignada);
        vistaMesa.setVisible(true);
    }//GEN-LAST:event_btnAsignarMesaActionPerformed

    private void btnBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebidasActionPerformed
        scrollPaneMenu1.setVisible(false);
        scrollPaneMenu2.setVisible(true);
    }//GEN-LAST:event_btnBebidasActionPerformed

    private void btnAgregarMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMeseroActionPerformed
        String nameMesero = JOptionPane.showInputDialog("Digite el nombre del mesero: ");
        mesero newMesero = new mesero(nameMesero);
        meseros.agregar(newMesero);
        JOptionPane.showMessageDialog(null, "Se ha agregago un mesero al sistema");
    }//GEN-LAST:event_btnAgregarMeseroActionPerformed

    private void btnAsignarMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarMeseroActionPerformed
         if("".equals(mAsignada.cargarMesero().nombre())){
            mesero meseroAux;
            meseroAux = meseros.escoger();
            if(meseroAux != null){
                mAsignada.asignarMesero(meseroAux);
                txtMesero.setText(meseroAux.nombre());
            }else{
                JOptionPane.showMessageDialog(null, "No hay meseros disponibles");
            }
        }else{
                JOptionPane.showMessageDialog(null, "Ya esta mesa tiene un mesero asignado");
        }
    }//GEN-LAST:event_btnAsignarMeseroActionPerformed

    private void txtSubTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubTActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void btnExpressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpressActionPerformed
        tipoServicio = "Express";
         Pagado = false;
        facturaDif = new recibo("Express");
        modeloProducto.reasignar(facturaDif.platos());
        tituloMesa.setVisible(false);
        labelMesero.setVisible(false);
        txtMesa.setVisible(false);
        txtMesero.setVisible(false);
        btnAsignarMesero.setVisible(false);
        btnAsignarMesa.setVisible(false);
        labelDireccion.setVisible(true);
        labelTel.setVisible(true);
        txtTelefono.setVisible(true);
        txtDireccion.setVisible(true);
         btnComerAqui.setBackground(new java.awt.Color(0, 153, 255));
        btnExpress.setBackground(new java.awt.Color(204, 255, 0));
        btnParaLlevar.setBackground(new java.awt.Color(0, 153, 255));
         agregarCliente.setVisible(true);
        limpiar();
    }//GEN-LAST:event_btnExpressActionPerformed

    private void btnComerAquiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComerAquiActionPerformed
        tipoServicio = "Comer Aqui";
         Pagado = false;
        modeloProducto.reasignar(mAsignada.miFactura().platos());
        tituloMesa.setVisible(true);
        labelMesero.setVisible(true);
        txtMesa.setVisible(true);
        txtMesero.setVisible(true);
        btnAsignarMesero.setVisible(true);
        btnAsignarMesa.setVisible(true);
        labelDireccion.setVisible(false);
        labelTel.setVisible(false);
        txtTelefono.setVisible(false);
        txtDireccion.setVisible(false);
        btnComerAqui.setBackground(new java.awt.Color(204, 255, 0));
        btnExpress.setBackground(new java.awt.Color(0, 153, 255));
        btnParaLlevar.setBackground(new java.awt.Color(0, 153, 255));
        btnAsignarMesero.setVisible(false);
        agregarCliente.setVisible(false);
        limpiar();
    }//GEN-LAST:event_btnComerAquiActionPerformed

    private void btnParaLlevarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParaLlevarActionPerformed
        tipoServicio = "Para llevar";
         Pagado = false;
        facturaDif = new recibo("Para llevar");
        modeloProducto.reasignar(facturaDif.platos());
        tituloMesa.setVisible(false);
        labelMesero.setVisible(false);
        txtMesa.setVisible(false);
        txtMesero.setVisible(false);
        btnAsignarMesero.setVisible(false);
        btnAsignarMesa.setVisible(false);
        labelDireccion.setVisible(false);
        labelTel.setVisible(false);
        txtTelefono.setVisible(false);
        txtDireccion.setVisible(false);
        btnComerAqui.setBackground(new java.awt.Color(0, 153, 255));
        btnExpress.setBackground(new java.awt.Color(0, 153, 255));
        btnParaLlevar.setBackground(new java.awt.Color(204, 255, 0));
        agregarCliente.setVisible(true);
        limpiar();
    }//GEN-LAST:event_btnParaLlevarActionPerformed

    private void entrada1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrada1ActionPerformed
        ingresarPlatillo(0);
    }//GEN-LAST:event_entrada1ActionPerformed

    private void entrada2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrada2ActionPerformed
          ingresarPlatillo(1);
    }//GEN-LAST:event_entrada2ActionPerformed

    private void entrada3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrada3ActionPerformed
        ingresarPlatillo(2);
    }//GEN-LAST:event_entrada3ActionPerformed

    private void entrada5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrada5ActionPerformed
          ingresarPlatillo(4);
    }//GEN-LAST:event_entrada5ActionPerformed

    private void entrada6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrada6ActionPerformed
         ingresarPlatillo(5);
    }//GEN-LAST:event_entrada6ActionPerformed

    private void entrada7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrada7ActionPerformed
         ingresarPlatillo(6);
    }//GEN-LAST:event_entrada7ActionPerformed

    private void entrada8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrada8ActionPerformed
         ingresarPlatillo(7);
    }//GEN-LAST:event_entrada8ActionPerformed

    private void entrada9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrada9ActionPerformed
         ingresarPlatillo(8);
    }//GEN-LAST:event_entrada9ActionPerformed

    private void entrada10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrada10ActionPerformed
         ingresarPlatillo(9);
    }//GEN-LAST:event_entrada10ActionPerformed

    private void entrada11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrada11ActionPerformed
         ingresarPlatillo(10);
    }//GEN-LAST:event_entrada11ActionPerformed

    private void entrada12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrada12ActionPerformed
        ingresarPlatillo(11);
    }//GEN-LAST:event_entrada12ActionPerformed

    private void entrada13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrada13ActionPerformed
         ingresarPlatillo(12);
    }//GEN-LAST:event_entrada13ActionPerformed

    private void entrada14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrada14ActionPerformed
         ingresarPlatillo(13);
    }//GEN-LAST:event_entrada14ActionPerformed

    private void entrada15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrada15ActionPerformed
        ingresarPlatillo(14);
    }//GEN-LAST:event_entrada15ActionPerformed

    private void bebida1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida1ActionPerformed
       ingresarBebida(0);
    }//GEN-LAST:event_bebida1ActionPerformed

    private void bebida2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida2ActionPerformed
       ingresarBebida(1);
    }//GEN-LAST:event_bebida2ActionPerformed

    private void bebida5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida5ActionPerformed
       ingresarBebida(4);
    }//GEN-LAST:event_bebida5ActionPerformed

    private void bebida6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida6ActionPerformed
        ingresarBebida(5);
    }//GEN-LAST:event_bebida6ActionPerformed

    private void bebida7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida7ActionPerformed
        ingresarBebida(6);
    }//GEN-LAST:event_bebida7ActionPerformed

    private void bebida8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida8ActionPerformed
        ingresarBebida(7);
    }//GEN-LAST:event_bebida8ActionPerformed

    private void bebida9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida9ActionPerformed
        ingresarBebida(8);
    }//GEN-LAST:event_bebida9ActionPerformed

    private void bebida10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida10ActionPerformed
        ingresarBebida(9);
    }//GEN-LAST:event_bebida10ActionPerformed

    private void bebida11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida11ActionPerformed
        ingresarBebida(10);
    }//GEN-LAST:event_bebida11ActionPerformed

    private void bebida13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida13ActionPerformed
        ingresarBebida(12);
    }//GEN-LAST:event_bebida13ActionPerformed

    private void bebida14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida14ActionPerformed
        ingresarBebida(13);
    }//GEN-LAST:event_bebida14ActionPerformed

    private void bebida15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bebida15ActionPerformed
        ingresarBebida(14);
    }//GEN-LAST:event_bebida15ActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
       vistaFactura = new vistaFacturas(facturasDelDia);
       vistaFactura.setVisible(true);
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
            if(Pagado == false)    {  
                    if("Comer Aqui".equals(tipoServicio)){
                        if(!txtMesa.getText().equals("")){
                            facturasDelDia.Agregar(mAsignada.miFactura());
                            Pagado = true;
                            meseros.desocupar(mAsignada.mAsignado());
                             limpiar();
                            vistaMesa.actualizarMesa(mAsignada);
                            JOptionPane.showMessageDialog(null, "Muchas gracias por preferirnos!, abriendo caja...");
                         }else{
                            JOptionPane.showMessageDialog(null, "No se ha seleccionado una mesa");
                        }
                    }else{
                         facturasDelDia.Agregar(facturaDif);
                            Pagado = true;
                            limpiar();
                            vistaMesa.actualizarMesa(mAsignada);
                         JOptionPane.showMessageDialog(null, "Muchas gracias por preferirnos, Se aplico un descuento, abriendo caja...");
                }
            }else{
                    JOptionPane.showMessageDialog(null, "Ya se genero la factura de esta mesa");
            }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        nuevoProducto = new vistaProducto(principal);
        nuevoProducto.setVisible(true);
    }//GEN-LAST:event_btnAgregarProductoActionPerformed
   
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vistaBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
    }

    public void init() {
        setVisible(true);
    }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarCliente;
    private javax.swing.JButton bebida1;
    private javax.swing.JButton bebida10;
    private javax.swing.JButton bebida11;
    private javax.swing.JButton bebida12;
    private javax.swing.JButton bebida13;
    private javax.swing.JButton bebida14;
    private javax.swing.JButton bebida15;
    private javax.swing.JButton bebida2;
    private javax.swing.JButton bebida3;
    private javax.swing.JButton bebida4;
    private javax.swing.JButton bebida5;
    private javax.swing.JButton bebida6;
    private javax.swing.JButton bebida7;
    private javax.swing.JButton bebida8;
    private javax.swing.JButton bebida9;
    private javax.swing.JButton btnAgregarMesero;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnAsignarMesa;
    private javax.swing.JButton btnAsignarMesero;
    private javax.swing.JButton btnBebidas;
    private javax.swing.JButton btnComerAqui;
    private javax.swing.JButton btnComidas;
    private javax.swing.JButton btnExpress;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnParaLlevar;
    private javax.swing.JButton entrada1;
    private javax.swing.JButton entrada10;
    private javax.swing.JButton entrada11;
    private javax.swing.JButton entrada12;
    private javax.swing.JButton entrada13;
    private javax.swing.JButton entrada14;
    private javax.swing.JButton entrada15;
    private javax.swing.JButton entrada2;
    private javax.swing.JButton entrada3;
    private javax.swing.JButton entrada4;
    private javax.swing.JButton entrada5;
    private javax.swing.JButton entrada6;
    private javax.swing.JButton entrada7;
    private javax.swing.JButton entrada8;
    private javax.swing.JButton entrada9;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JLabel imagenIcono;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelBebidas;
    private javax.swing.JLabel labelComidas;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelMesero;
    private javax.swing.JLabel labelTel;
    private javax.swing.JPanel panelFactura;
    private javax.swing.JPanel panelInformacion;
    private javax.swing.JPanel panelMantenimiento;
    private javax.swing.JPanel panelMenu1;
    private javax.swing.JPanel panelMenu2;
    private javax.swing.JPanel panelSeleccion;
    private javax.swing.JPanel panelTitulo1;
    private javax.swing.JPanel panelTotal;
    private javax.swing.JScrollPane scrollPaneMenu1;
    private javax.swing.JScrollPane scrollPaneMenu2;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tablaFactura;
    private javax.swing.JLabel tituloCantidad;
    private javax.swing.JLabel tituloFactura;
    private javax.swing.JLabel tituloIva;
    private javax.swing.JLabel tituloMantenimiento;
    private javax.swing.JLabel tituloMesa;
    private javax.swing.JLabel tituloNombre;
    private javax.swing.JLabel tituloSubT;
    private javax.swing.JLabel tituloTitulo;
    private javax.swing.JLabel tituloTotal;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtMesa;
    private javax.swing.JTextField txtMesero;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSubT;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
