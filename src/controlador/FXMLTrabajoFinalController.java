/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLcontrolador.java to edit this template
 */
package controlador;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import help.Help;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import modelo.Alumno;
import modelo.Conexion;
import modelo.Tutores;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * FXML controlador class
 *
 * @author ivanm
 */
public class FXMLTrabajoFinalController implements Initializable {

    @FXML
    private Pane sb_Iconos;
    @FXML
    private Label lCodigoEmpresa;
    @FXML
    private TextField tfCodigoEmpresa;
    @FXML
    private TextField tfCIF;
    @FXML
    private Label lCIF;
    @FXML
    private Label lNombre;
    @FXML
    private TextField tfNombre;
    @FXML
    private Label lDireccion;
    @FXML
    private Label lCP;
    @FXML
    private Label lLocalidad;
    @FXML
    private TextField tfDireccion;
    @FXML
    private TextField tfCP;
    @FXML
    private TextField tfLocalidad;
    @FXML
    private Label lJornada;
    @FXML
    private Label lModalidad;
    @FXML
    private Label lMail;
    @FXML
    private TextField tfMail;
    @FXML
    private Label lEmpresa;
    @FXML
    private Pane pPersonas;
    @FXML
    private TextField tfNombreRL;
    @FXML
    private Label lNombreRL;
    @FXML
    private Label lApellidosRL;
    @FXML
    private TextField tfApellidosRL;
    @FXML
    private Label lNombreTL;
    @FXML
    private Label lApellidosTL;
    @FXML
    private TextField tfNombreTL;
    @FXML
    private TextField tfApellidosTL;
    @FXML
    private Label lTLF;
    @FXML
    private TextField tfTLF;
    @FXML
    private Label lPersonas;
    @FXML
    private Button bInsertar;
    @FXML
    private Button bModificar;

    @FXML
    private Pane pF_GestE;
    @FXML
    private Pane pF_DAT;
    @FXML
    private Pane pF_Asig;

    @FXML
    private Button bd_Empresa;

    @FXML
    private Button bd_Asignacion;
    @FXML
    private Button bd_Inicio;
    @FXML
    private Pane pF_Inicio;
    @FXML
    private Button bAyuda;
    @FXML
    private Button bd_DAT;
    @FXML
    private Button bd_Almacenamiento;
    @FXML
    private Button bEliminar;
    @FXML
    private Pane pBaseDatos;
    @FXML
    private TableView<ObservableList> tEmpresa;
    @FXML
    private Label lReflejoBD;
    @FXML
    private Button bDAT;
    @FXML
    private Button bXML;
    @FXML
    private Pane pTregistrada;
    @FXML
    private Label lTregistrada;
    @FXML
    private Button bConfirmar;
    @FXML
    private Label lEleccionA;
    @FXML
    private Label lEleccionE;
    @FXML
    private Label lEleccionT;
    @FXML
    private Pane pAsignacion;
    private ObservableList<Object> empresas;
    @FXML
    private Pane pF_Almacenamiento;
    @FXML
    private ComboBox<String> cbJornada;
    @FXML
    private ComboBox<String> cbModalidad;
    @FXML
    private ComboBox<String> cbEleccionA;
    @FXML
    private ComboBox<String> cbEleccionE;
    @FXML
    private ComboBox<String> cbEleccionT;
    @FXML
    private Label lDNIRL;
    @FXML
    private TextField tfDNIRL;
    @FXML
    private Label lDNITL;
    @FXML
    private TextField tfDNITL;
    @FXML
    private Label lbAlumno;
    @FXML
    private Label lbTutor;
    @FXML
    private Label lbConfirmar;
    /**
     * Initializes the controlador class.
     */
    
    Conexion cbd = new Conexion();
    @FXML
    private TableView<?> tEmpresa2;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbJornada.setItems(FXCollections.observableArrayList(
            "Partida", "Continua"));
        cbModalidad.setItems(FXCollections.observableArrayList(
            "Presencial", "Semipresencial", "Distancia"));
        cbJornada.getSelectionModel().selectFirst();
        cbModalidad.getSelectionModel().selectFirst();
        lbTutor.setVisible(false);
        lbAlumno.setVisible(false);
        lbConfirmar.setVisible(false);

        // Fotos botones
        Image img1 = new Image("controlador/DATaTabla.png");
        ImageView foto1 = new ImageView(img1);
        bDAT.setGraphic(foto1);
        
        Image img2 = new Image("controlador/XMLaTabla.png");
        ImageView foto2 = new ImageView(img2);
        bXML.setGraphic(foto2);
        // Generar tablas
        try {
            vaciaTablas();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLTrabajoFinalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        datosAlumnos();
        datosEmpresa();
        datosTutores();

        buildData("EMPRESAS", tEmpresa);
        buildData("EMPRESAS", tEmpresa2);



    }
    @FXML
    private void ventanaAyuda(ActionEvent e) throws IOException {
        Help h = new Help();
        h.setVisible(true);
    }
    @FXML
    private void agregarEmpresa(ActionEvent event) {
        try {
                    Connection conexion = cbd.conectar();
                    try {
                        PreparedStatement ps = conexion.prepareStatement
                                ("INSERT INTO EMPRESAS " +
                                        "(CIF, Nombre, Direccion, CP, Localidad, Jornada, Modalidad" +
                                        ",Mail, DNI_RL, Nombre_RL, Apellidos_RL, DNI_TL" +
                                        ", Nombre_TL, Apellidos_TL, Tlfn_TL) " +
                                        "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                        setStatement(ps);
                       
                        if (ps.executeUpdate() == 1) {
                            
                            datosEmpresa();
                            Dialog<String> dialog = new Dialog<>();
                            dialog.setTitle("INSERTAR EMPRESA");
                            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                            dialog.setContentText("Empresa insertada con éxito");
                            dialog.getDialogPane().getButtonTypes().add(type);
                            dialog.showAndWait();
                            addRow("EMPRESAS", tEmpresa);
                            addRow("EMPRESAS", tEmpresa2);
                            
                         
                            setDefaultTFs();
                        } else {
                            Dialog<String> dialog = new Dialog<>();
                            dialog.setTitle("INSERTAR EMPRESA");
                            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                            dialog.setContentText("No se ha podido insertar la empresa");
                            dialog.getDialogPane().getButtonTypes().add(type);
                            dialog.showAndWait();
                        }
                        addRow("EMPRESAS", tEmpresa);
                        addRow("EMPRESAS", tEmpresa2);
                        ps.close();
                    } catch (Exception ee) {
                        Dialog<String> dialog = new Dialog<>();
                            dialog.setTitle("INSERTAR EMPRESA");
                            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                            dialog.setContentText("No se ha podido insertar la empresa");
                            dialog.getDialogPane().getButtonTypes().add(type);
                            dialog.showAndWait();
                    }
                    conexion.close();

                } catch (SQLException xx) {
                    xx.printStackTrace();
                }
    }
    
    @FXML
    private void modificarEmpresa(ActionEvent event) {
        try {
                Connection conexion = cbd.conectar();
                try {
                    PreparedStatement ps = conexion.prepareStatement
                            ("UPDATE empresas SET CIF = ?, Nombre = ?, Direccion = ?, CP = ?, Localidad = ?, Jornada = ?," +
                                    "Modalidad = ?, Mail = ?, DNI_RL = ?, Nombre_RL = ?, Apellidos_RL = ?, DNI_TL = ?," +
                                    "Nombre_TL = ?, Apellidos_TL = ?, Tlfn_TL = ? WHERE Cod_Empresas = ?");

                    setStatement(ps);
                    ps.setString(16, tfCodigoEmpresa.getText());
                    //System.out.println(ps);

                    if (ps.executeUpdate() == 1) {
                        Dialog<String> dialog = new Dialog<>();
                        dialog.setTitle("MODIFICAR EMPRESA");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("Empresa modificada con éxito");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                        addRow("EMPRESAS", tEmpresa);
                        addRow("EMPRESAS", tEmpresa2);
                        datosEmpresa();
                        setDefaultTFs();
                    } else {
                        Dialog<String> dialog = new Dialog<>();
                        dialog.setTitle("MODIFICAR EMPRESA");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("No se ha podido modificar la empresa");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    addRow("EMPRESAS", tEmpresa);
                    addRow("EMPRESAS", tEmpresa2);
                    ps.close();
                } catch (Exception ee) {
                    Dialog<String> dialog = new Dialog<>();
                        dialog.setTitle("MODIFICAR EMPRESA");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("No se ha podido modificar la empresa");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                }
                conexion.close();

            } catch (SQLException xx) {
                xx.printStackTrace();
            }
    }

    @FXML
    private void borrarEmpresa(ActionEvent event) {
        try {
                Connection conexion = cbd.conectar();
                try {
                    PreparedStatement ps = conexion.prepareStatement
                            ("DELETE FROM empresas WHERE Cod_Empresas = ?");
                    ps.setString(1, tfCodigoEmpresa.getText());

                    if (ps.executeUpdate() == 1) {
                        Dialog<String> dialog = new Dialog<>();
                        dialog.setTitle("ELIMINAR EMPRESA");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("Empresa eliminada con éxito");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                        addRow("EMPRESAS", tEmpresa);
                        addRow("EMPRESAS", tEmpresa2);
                        datosEmpresa();
                        setDefaultTFs();
                    } else {
                        Dialog<String> dialog = new Dialog<>();
                        dialog.setTitle("ELIMINAR EMPRESA");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("No se ha podido eliminar la empresa");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    addRow("EMPRESAS", tEmpresa);
                    addRow("EMPRESAS", tEmpresa2);
                    ps.close();
                } catch (Exception ee) {
                    Dialog<String> dialog = new Dialog<>();
                        dialog.setTitle("ELIMINAR EMPRESA");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("No se ha podido eliminar la empresa");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                }
                conexion.close();

            } catch (SQLException xx) {
                xx.printStackTrace();
            }
    }
    
    private void controllerInsert(ActionEvent event) {
        try {
                    Connection conexion = cbd.conectar();
                    try {
                        PreparedStatement ps = conexion.prepareStatement
                                ("INSERT INTO EMPRESAS " +
                                        "(CIF, Nombre, Direccion, CP, Localidad, Jornada, Modalidad" +
                                        ",Mail, DNI_RL, Nombre_RL, Apellidos_RL, DNI_TL" +
                                        ", Nombre_TL, Apellidos_TL, Tlfn_TL) " +
                                        "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                        setStatement(ps);
                       
                        if (ps.executeUpdate() == 1) {
                            
                            datosEmpresa();
                            Dialog<String> dialog = new Dialog<>();
                            dialog.setTitle("INSERTAR EMPRESA");
                            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                            dialog.setContentText("Empresa insertada con éxito");
                            dialog.getDialogPane().getButtonTypes().add(type);
                            dialog.showAndWait();
                            addRow("EMPRESAS", tEmpresa);
                            addRow("EMPRESAS", tEmpresa2);
                         
                            setDefaultTFs();
                        } else {
                            Dialog<String> dialog = new Dialog<>();
                            dialog.setTitle("INSERTAR EMPRESA");
                            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                            dialog.setContentText("No se ha podido insertar la empresa");
                            dialog.getDialogPane().getButtonTypes().add(type);
                            dialog.showAndWait();
                        }
                        addRow("EMPRESAS", tEmpresa);
                        addRow("EMPRESAS", tEmpresa2);
                        ps.close();
                    } catch (Exception ee) {
                        Dialog<String> dialog = new Dialog<>();
                            dialog.setTitle("INSERTAR EMPRESA");
                            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                            dialog.setContentText("No se ha podido insertar la empresa");
                            dialog.getDialogPane().getButtonTypes().add(type);
                            dialog.showAndWait();
                    }
                    conexion.close();

                } catch (SQLException xx) {
                    xx.printStackTrace();
                }

        
    }


    public void setDefaultTFs() {
        Object currentCode = null;
        try {
            Statement s = cbd.conectar().createStatement();
            ResultSet rs = s.executeQuery("SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES " +
                    "WHERE TABLE_SCHEMA = 'bdgestionfct' AND   TABLE_NAME   = 'empresas'");
            if (rs.next()) {
                currentCode = rs.getObject("AUTO_INCREMENT");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        tfCodigoEmpresa.setText(currentCode.toString());
        tfCIF.setText("");
        tfNombre.setText("");
        tfDireccion.setText("");
        tfCP.setText("");
        tfLocalidad.setText("");
        cbJornada.getSelectionModel().selectFirst();
        cbModalidad.getSelectionModel().selectFirst();
        tfMail.setText("");
        tfDNIRL.setText("");
        tfNombreRL.setText("");
        tfApellidosRL.setText("");
        tfDNITL.setText("");
        tfNombreTL.setText("");
        tfApellidosTL.setText("");
        tfTLF.setText("");
    }
    
    private void setStatement(PreparedStatement ps) throws SQLException {
        ps.setString(1, tfCIF.getText());
        ps.setString(2, tfNombre.getText());
        ps.setString(3,tfDireccion.getText());
        ps.setString(4, tfCP.getText());
        ps.setString(5, tfLocalidad.getText());
        ps.setShort(6, (short) (cbJornada.getItems().indexOf(cbJornada.getValue()) + 1));
        ps.setShort(7, (short) (cbModalidad.getItems().indexOf(cbModalidad.getValue()) + 1));
        ps.setString(8, tfMail.getText());
        ps.setString(9, tfDNIRL.getText());
        ps.setString(10, tfNombreRL.getText());
        ps.setString(11, tfApellidosRL.getText());
        ps.setString(12, tfDNITL.getText());
        ps.setString(13, tfNombreTL.getText());
        ps.setString(14, tfApellidosTL.getText());
        ps.setString(15, tfTLF.getText());
    }
    
    public void addRow(String nomTabla, TableView tabla){
         ObservableList<ObservableList> data;
          Connection c ;
          data = FXCollections.observableArrayList();
          try{
            c = cbd.conectar();
   
            String SQL = "SELECT * from " + nomTabla;
            ResultSet rs = c.createStatement().executeQuery(SQL);
          
            while(rs.next()){

                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){

                    row.add(rs.getString(i));
                }
                //System.out.println("Row [1] added "+row );
                data.add(row);

            }


            tabla.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
     }
    
    public void buildData(String nomTabla, TableView tabla){
        
          ObservableList<ObservableList> data;
          Connection c ;
          data = FXCollections.observableArrayList();
          try{
            c = cbd.conectar();
   
            String SQL = "SELECT * from " + nomTabla;
            ResultSet rs = c.createStatement().executeQuery(SQL);
 
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){

                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                tabla.getColumns().addAll(col); 
                if(i==0){
                    col.setVisible(false);
                }

            }

          
            while(rs.next()){

                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){

                    row.add(rs.getString(i));
                }
                //System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            tabla.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
    }

    @FXML
    private void seleccionar(MouseEvent event) {
        ObservableList<String> data;
                Object value = null;
                data = tEmpresa.getSelectionModel().getSelectedItem();
                value = data.get(0);
                //System.out.println(value);
                
                try {
                    Statement s = cbd.conectar().createStatement();
                    ResultSet rs = s.executeQuery("select * from empresas where Cod_Empresas = " + value);
                    if (rs.next()) {

                        tfCodigoEmpresa.setText(rs.getObject(1).toString());
                        tfCIF.setText(rs.getObject(2).toString());
                        tfNombre.setText(rs.getObject(3).toString());
                        tfDireccion.setText(rs.getObject(4).toString());
                        tfCP.setText(rs.getObject(5).toString());
                        tfLocalidad.setText(rs.getObject(6).toString());
                        cbJornada.getSelectionModel().select(rs.getObject(7).toString());
                        cbModalidad.getSelectionModel().select(rs.getObject(8).toString());
                        tfMail.setText(rs.getObject(9).toString());
                        tfDNIRL.setText(rs.getObject(10).toString());
                        tfNombreRL.setText(rs.getObject(11).toString());
                        tfApellidosRL.setText(rs.getObject(12).toString());
                        tfDNITL.setText(rs.getObject(13).toString());
                        tfNombreTL.setText(rs.getObject(14).toString());
                        tfApellidosTL.setText(rs.getObject(15).toString());
                        tfTLF.setText(rs.getObject(16).toString());
                    }


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
    }
    @FXML
    private void cambiarPestanas(ActionEvent event){
        if(event.getSource() == bd_Empresa){
            pF_GestE.setVisible(true);
            pF_Asig.setVisible(false);
            pF_DAT.setVisible(false);
            pF_Almacenamiento.setVisible(false);
            pF_Inicio.setVisible(false);

        } else if (event.getSource() == bd_DAT) {
            pF_DAT.setVisible(true);;
            pF_Asig.setVisible(false);
            pF_GestE.setVisible(false);
            pF_Almacenamiento.setVisible(false);
            pF_Inicio.setVisible(false);

        } else if (event.getSource() == bd_Asignacion) {
            pF_Asig.setVisible(true);;
            pF_DAT.setVisible(false);
            pF_GestE.setVisible(false);
            pF_Almacenamiento.setVisible(false);
            pF_Inicio.setVisible(false);

        } else if (event.getSource() == bd_Almacenamiento) {
            pF_Almacenamiento.setVisible(true);
            pF_Asig.setVisible(false);
            pF_DAT.setVisible(false);
            pF_GestE.setVisible(false);
            pF_Inicio.setVisible(false);

        }else if(event.getSource() == bd_Inicio){
            pF_Inicio.setVisible(true);
            pF_Asig.setVisible(false);
            pF_DAT.setVisible(false);
            pF_GestE.setVisible(false);
            pF_Almacenamiento.setVisible(false);

        }
    }
    private void vaciaTablas() throws SQLException{
        Connection conex = cbd.conectar();
        Statement stmt = conex.createStatement();
        stmt.executeUpdate("DELETE FROM ALUMNOS");
        stmt.executeUpdate("DELETE FROM TUTORES_P");
        stmt.close();
        conex.close();
    }
    
    public void datosAlumnos() {
        try {
            Statement s = cbd.conectar().createStatement();
            ResultSet rs = s.executeQuery("select * from alumnos");

            String auxApellido;
            String auxNombre;
            while (rs.next()) {
                byte[] dataApellido = rs.getBytes("Apellidos");
                auxApellido = new String(dataApellido, StandardCharsets.UTF_8);
                byte[] dataNombre = rs.getBytes("Nombre");
                auxNombre = new String(dataNombre, StandardCharsets.UTF_8);
                cbEleccionA.getItems().add(auxApellido + ", " + auxNombre);
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void datosEmpresa() {
        cbEleccionE.getItems().clear();
        try {
            Statement s = cbd.conectar().createStatement();
            ResultSet rs = s.executeQuery("select * from empresas");

            String auxNombre;
            while (rs.next()) {
                byte[] dataNombre = rs.getBytes("Nombre");
                auxNombre = new String(dataNombre, StandardCharsets.UTF_8);
                cbEleccionE.getItems().add(auxNombre);
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void datosTutores() {
        try {
            Statement s = cbd.conectar().createStatement();
            ResultSet rs = s.executeQuery("select * from tutores_p");

            String auxNombre;
            while (rs.next()) {
                byte[] dataNombre = rs.getBytes("Nombre");
                auxNombre = new String(dataNombre, StandardCharsets.UTF_8);
                cbEleccionT.getItems().add(auxNombre);
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
    
    

    @FXML
    private void agregarDAT(ActionEvent event)  throws ClassNotFoundException, SQLException {
        bDAT.setDisable(true);
        lbAlumno.setVisible(true);
        String mensaje2 = "Información del fichero ahora registrada en la tabla Alumnos";
        
                            
        lbAlumno.setText(mensaje2);

        lbAlumno.setWrapText(true);
        lbAlumno.setMaxWidth(2000);
        lbAlumno.setTextAlignment(TextAlignment.CENTER);
        
        leerfichero();
        
        Connection conexion = cbd.conectar();

        PreparedStatement actualiza = conexion.prepareStatement("INSERT INTO ALUMNOS(DNI, Nombre, Apellidos, Fecha_Nac) VALUES( ?, ?, ?, ?) ");


        for (Alumno alumno:listAlumnos) {
            actualiza.setString(1, alumno.getDni());
            actualiza.setString(2, alumno.getNombre());
            actualiza.setString(3, alumno.getApellidos());

            String fecha = DateTimeFormatter.ofPattern("yyyy,MM,dd").format(LocalDate.parse(alumno.getFechanacimiento(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            actualiza.setString(4, fecha);
            actualiza.executeUpdate();

        }
        actualiza.close();
        conexion.close();
        
        datosAlumnos();
    
    }
    
    ArrayList<Alumno> listAlumnos = new ArrayList<>();
    
    public void leerfichero() {
        // Se declaran las variables de método para guardar lo leído
        //Cod_alumno
        int cod;
        String dni;
        String nombre;
        String apellidos;
        String fechanacimiento;


        // Se genera el objeto en memoria para trasegar con el fichero
        File fich = new File("src/controlador/alumnos2cfs.dat");
        // Se crea el amarre para la "manguera base" que permita leer del fichero
        FileInputStream fis = null;
        // Se crea el amarre pensando en aplicar métodos específicos [readXXX()]
        DataInputStream dis = null;
        try {
            // Se crea la "manguera base" para grabar datos en el fichero
            fis = new FileInputStream(fich);
            // Se crea el envoltorio que aplique a la "manguera base" métodos como readXXX()
            dis = new DataInputStream(fis);
            // Extraemos datos del fichero hasta llegar al final del mismo



            while (dis.available() > 0) {
                cod = dis.readInt();
                dni = dis.readUTF();
                nombre = dis.readUTF();
                apellidos = dis.readUTF();
                fechanacimiento = dis.readUTF();

                Alumno alumnos = new Alumno(cod,dni,nombre,apellidos,fechanacimiento);
                listAlumnos.add(alumnos);

            }

        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
            System.out.println(" ");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
                System.out.println(" ");
            }
        }

    }
    
    ArrayList<Tutores> listTutores = new ArrayList<>();

    @FXML
    private void agregarXML(ActionEvent event) throws SQLException{
        lecturaXML();
        bXML.setDisable(true);
        lbTutor.setVisible(true);
        
        
        String mensaje1 = "Información del fichero ahora registrada en la tabla Tutores";
                            
        lbTutor.setText(mensaje1);

        lbTutor.setWrapText(true);
        lbTutor.setMaxWidth(2000);
        lbTutor.setTextAlignment(TextAlignment.CENTER);
        
        Connection conexion = cbd.conectar();
        PreparedStatement actualiza = conexion.prepareStatement("INSERT INTO Tutores_P(Nombre, Mail, Tlfn) VALUES( ?, ?, ? ) ");


        for (Tutores tutor : listTutores) {
            actualiza.setString(1, tutor.getNombreCompleto());
            actualiza.setString(2, tutor.getCorreoElectronico());
            actualiza.setString(3, tutor.getTelefono());

            actualiza.executeUpdate();

        }
        actualiza.close();
        conexion.close();
        
        datosTutores();
    }
    
    private void lecturaXML() {
        //Creamos una referencia (fichXML) de tipo File al cargar el fichero XML existente
        File fichXML = new File("src/controlador/tutoresdoc.xml");
        {

            //Parsea el fichero y lo convierte de fichero a documento XML recorrible
            DocumentBuilderFactory factoriaDoc = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructDoc = null;
            try {
                constructDoc = factoriaDoc.newDocumentBuilder();
            } catch (ParserConfigurationException ex) {
                ex.printStackTrace();
            }
            Document docDOM = null;
            try {
                docDOM = constructDoc.parse(fichXML);
            } catch (SAXException | IOException ex) {
                ex.printStackTrace();
            }

            //Elimina nodos vacíos y combina adyacentes en caso de que los hubiera
            docDOM.getDocumentElement().normalize();
            //Localizamos e imprimimos cuál es el elemento raíz

            Element raiz = docDOM.getDocumentElement();

            //Vuelca a una lista los nodos que cuelgan del nodo raíz
            NodeList alumDam = docDOM.getElementsByTagName("tutordoc");
            for (int cont = 0; cont < alumDam.getLength(); cont++) {
                //Se recorre la lista con nodos y se extrae en nodo el que indica cont
                Node nodo = (Node) alumDam.item(cont);
                //Para saber qué nodo está procesando, imprime el nombre

                //Comprueba si se encuentra ante un elemento
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    //Castea el nodo de tipo Node a uno de tipo Element
                    Element element = (Element) nodo;
                    
                    String cod = element.getElementsByTagName("codtut").item(0).getTextContent();
                    String Nombrecompleto = element.getElementsByTagName("nomap").item(0).getTextContent();
                    String CorreoElectronico = element.getElementsByTagName("correo").item(0).getTextContent();
                    String Telefono = element.getElementsByTagName("telefono").item(0).getTextContent();

                    Tutores tutores = new Tutores(Integer.parseInt(cod), Nombrecompleto, CorreoElectronico, Telefono);
                    listTutores.add(tutores);
                }
            }

        }
    }

    @FXML
    private void bConfirmar(ActionEvent event) {
        try {
                    Connection conexion = cbd.conectar();

                    String alumno = cbEleccionA.getSelectionModel().getSelectedItem();
                    String[] apellidoAux = alumno.split(",");
                    String codAlumno = null;
                    String empresa = cbEleccionE.getSelectionModel().getSelectedItem();
                    String codEmpresa = null;
                    String tutor = cbEleccionT.getSelectionModel().getSelectedItem();
                    String codTutor = null;

                    try {
                        Statement s = conexion.createStatement();
                        ResultSet rsCodAlumno = s.executeQuery("SELECT Cod_Alumno from alumnos where Apellidos = '" + apellidoAux[0] + "'");
                        while(rsCodAlumno.next()){
                            codAlumno = rsCodAlumno.getString(1);
                        }

                        ResultSet rsCodEmpresa = s.executeQuery("SELECT Cod_Empresas from empresas where Nombre = '" + empresa + "'");
                        while(rsCodEmpresa.next()){
                            codEmpresa = rsCodEmpresa.getString(1);
                        }
                        ResultSet rsCodTutor = s.executeQuery("SELECT Cod_Tutor from tutores_p where Nombre = '" + tutor + "'");
                        while(rsCodTutor.next()){
                            codTutor = rsCodTutor.getString(1);
                        }

                        PreparedStatement ps = conexion.prepareStatement
                                ("INSERT INTO asignacion (Cod_Alumno, Cod_Tutor, Cod_Empresas, Fecha_Asignacion) VALUES (?, ?, ?, ?)");
                        String auxTime = String.valueOf(new Timestamp(System.currentTimeMillis()));
                        auxTime = auxTime.substring(0, auxTime.length()-4);
                        ps.setString(1, codAlumno);
                        ps.setString(2, codTutor);
                        ps.setString(3, codEmpresa);
                        ps.setString(4, auxTime);
                        //System.out.println(ps);

                        if (ps.executeUpdate() == 1) {
                            ResultSet rsTutorLaboral = s.executeQuery("SELECT Nombre_TL, Apellidos_TL from " +
                                    "empresas where Nombre = '" + empresa + "'");
                            String nombreTL = null;
                            String apellidoTL = null;
                            while (rsTutorLaboral.next()) {
                                nombreTL = rsTutorLaboral.getString(1);
                                apellidoTL = rsTutorLaboral.getString(2);
                            }

                            String mensaje = "El alumno " + alumno + " queda asignado a la empresa "
                                    + empresa + " supervisado por el tutor docente " + tutor +
                                    " y por el tutor laboral " + nombreTL + " " + apellidoTL;
                            
                            lbConfirmar.setText(mensaje);
                
                            lbConfirmar.setWrapText(true);
                            lbConfirmar.setMaxWidth(2000);
                            lbConfirmar.setTextAlignment(TextAlignment.CENTER);
                            lbConfirmar.setVisible(true);
                        } else {
                            //JOptionPane.showMessageDialog(viewAsignacion, ("No se ha podido registrar la asignación"));
                        }

                        ps.close();
                    } catch (Exception ee) {
                        System.out.println(ee.getClass());
                    }

                    conexion.close();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
    }

    @FXML
    private void cambiarPestanas(MouseEvent event) {
    }

    
    
}
