package tn.esprit.java.DAO;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import tn.esprit.java.Mapper.AutoveicoliMapper;
import tn.esprit.java.PO.AutoveicoloPO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutoveicoliDaoImpl  implements AutoveicoloDao {
    static Logger logger = Logger.getLogger(AutoveicoliDaoImpl.class.getName ());
    public final String dbURL = "jdbc:mysql://localhost:3306/concessionnaire";
    public final String username = "root";
    public final String password = "rootroot";
    public AutoveicoliDaoImpl(){}


    @Override
    public List<AutoveicoloPO> getAutoveicolo() {
        BasicConfigurator.configure();
        List<AutoveicoloPO> autoveicolo =new ArrayList<>()  ;
        try{
            //establish connection
            Connection connection = DriverManager.getConnection(dbURL ,username,password);
            if(connection != null) {
                logger.info ("Connection  established");
            }
            else {
                logger.error ("Connection not established");
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet= statement.executeQuery("select * from autoveicolo ");
            while (resultSet.next()){
                AutoveicoliMapper auto = new AutoveicoliMapper();
                autoveicolo.add(auto.map(resultSet));
            }
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return autoveicolo;

    }

    @Override
    public AutoveicoloPO getAutoByID( int nbr_telaio) {
        BasicConfigurator.configure();
        AutoveicoloPO autoveicolo =new AutoveicoloPO()  ;
        try{
            //establish connection
            Connection connection = DriverManager.getConnection(dbURL ,username,password);
            PreparedStatement statement = connection.prepareStatement("select * from autoveicolo where Nbr_telaio=?");
            statement.setInt(1,nbr_telaio);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                AutoveicoliMapper autoveicoliMapper= new AutoveicoliMapper();
                autoveicolo=autoveicoliMapper.map(resultSet);
            }
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return autoveicolo;
    }

    @Override
    public List<AutoveicoloPO> getbyMarca(String marca) {
        String sqll = "SELECT * from autoveicolo Where marca =?";
        List<AutoveicoloPO> aut =new ArrayList<>();

        try {
            Connection connection= DriverManager.getConnection(dbURL,username,password);
            PreparedStatement preparedStatement = connection.prepareStatement(sqll);
            preparedStatement.setString(1,marca);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                AutoveicoliMapper auto = new AutoveicoliMapper();
                aut.add(auto.map(resultSet));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return aut;
    }

    @Override
    public void insertAutoveicoli(String marca, String modello, int iva, int nbr_door) {
        BasicConfigurator.configure();
        try{
            Connection connection = DriverManager.getConnection(dbURL ,username,password);
            String SQL = "INSERT INTO autoveicolo (Marca,Modello,Iva,Nbr_door) " + "VALUES(?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1,marca);
            statement.setString(2,modello);
            statement.setInt(3,iva);
            statement.setInt(4,nbr_door);
            int rows= statement.executeUpdate();
            if (rows>0 ){
                logger.info ("New autoveicolo was inserted successfully");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateAutoveicoli(String marca, String modello, int iva, int nbr_door) {
        BasicConfigurator.configure();
        String sql="UPDATE autoveicolo SET  Modello =?,Iva =?,Nbr_door=? WHERE Marca=?";
        try{
            //establish connection
            Connection connection = DriverManager.getConnection(dbURL ,username,password);
            if(connection != null) {
                logger.info ("Connection  established");
            }
            else {
                logger.error ("Connection not established");
            }
            Statement statement = connection.createStatement();
            PreparedStatement statement1= connection.prepareStatement(sql);
            statement1.setString(1,modello);
            statement1.setInt(2,iva);
            statement1.setInt(3,nbr_door);
            statement1.setString(4,marca);
            int rows =statement1.executeUpdate();
            logger.info ("Autoveicolo:Marca"+marca+" is updated in the database");
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAutoveicoli(String marca) {
        BasicConfigurator.configure();
        try{
            //establish connection
            Connection connection = DriverManager.getConnection(dbURL ,username,password);
            String sql="DELETE FROM autoveicolo WHERE Marca=?";
            if(connection != null) {

               logger.info ("Connection  established");
            }
            else {
             logger.error ("Connection not established");
            }
            PreparedStatement statement1= connection.prepareStatement(sql);
            statement1.setString(1, marca);
            int rows =statement1.executeUpdate();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }




        System.out.println("Autoveicolo is deleted fron DB");

    }

    @Override
    public List<AutoveicoloPO> findbyIva(int iva) {
        BasicConfigurator.configure();
            //1 defenir le resulat
            List<AutoveicoloPO> autoveicoloPOS = new ArrayList<>();
            //2 implementer la methodes et logic metier
            try {
                Connection connection = DriverManager.getConnection(dbURL, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement("select * from autoveicolo where iva=?");
                preparedStatement.setInt (1,iva);
                ResultSet resultSet = preparedStatement.executeQuery();
                AutoveicoliMapper autoveicoliMapper = new AutoveicoliMapper();
                while (resultSet.next() ){
                    autoveicoloPOS.add(autoveicoliMapper.map(resultSet));
                }
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            ///3 retour
            return autoveicoloPOS;

    }


}
