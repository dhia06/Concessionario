package tn.esprit.java.DAO;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import tn.esprit.java.Mapper.ConcessionarioMapper;
import tn.esprit.java.PO.ConcessionarioPO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConcessionarioImp implements ConcessionarioDao {
    static Logger logger = Logger.getLogger(ConcessionarioImp.class.getName ());
    public final String dbURL = "jdbc:mysql://localhost:3306/concessionnaire";
    public final String username = "root";
    public final String password = "rootroot";
    public ConcessionarioImp(){}
    @Override
    public List<ConcessionarioPO> getConcessionario() {
        BasicConfigurator.configure();
        List<ConcessionarioPO> Concessionar =new ArrayList<>()  ;
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
            ResultSet resultSet= statement.executeQuery("select * from concessionnaire ");

            ConcessionarioMapper concessionarioMapper= new ConcessionarioMapper();

            while (resultSet.next()){

                Concessionar.add(concessionarioMapper.map(resultSet));
            }
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return Concessionar;

    }

    @Override
    public List<ConcessionarioPO> getConcessionario(String nome) {
        List<ConcessionarioPO> Concessionar =new ArrayList<>()  ;
        try{
            //establish connection
            Connection connection = DriverManager.getConnection(dbURL ,username,password);
            PreparedStatement statement = connection.prepareStatement("select * from concessionnaire where nome=?");
            statement.setString(1,nome);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                ConcessionarioMapper concessionarioMapper= new ConcessionarioMapper();
                Concessionar.add(concessionarioMapper.map(resultSet));
            }
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return Concessionar;

    }

    @Override
    public void insertConcessionario(int iva,String nome, String citta, String indirizzo) {
        BasicConfigurator.configure();
        try{
            Connection connection = DriverManager.getConnection(dbURL ,username,password);
            String SQL = "INSERT INTO concessionnaire (iva,nome,citta,indirizzo) " + "VALUES(?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1,iva);
            statement.setString(2,nome);
            statement.setString(3,citta);

            statement.setString(4,indirizzo);
           // statement.setString(4, veicolilist);
            int rows= statement.executeUpdate();
            if (rows>0 ){
                logger.info (" New Concessionario was inserted successfully");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateConcessionario( String citta, String indirizzo,String nome) {
        BasicConfigurator.configure();
        String sql="UPDATE concessionnaire SET  citta =?,indirizzo=? WHERE nome=?";
        try{
            //establish connection
            Connection connection = DriverManager.getConnection(dbURL ,username,password);
            if(connection != null) {
               logger.info ("Connection established");
            }
            else {
               logger.error ("Connection not established");
            }
            Statement statement = connection.createStatement();
            PreparedStatement statement1= connection.prepareStatement(sql);
            statement1.setString(1,citta);
            statement1.setString(2,indirizzo);
          //  statement1.setString(3, String.valueOf(veicolilist));
            statement1.setString(3,nome);
            int rows =statement1.executeUpdate();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
 logger.info ("Concessionario/a: is updated in the database");

    }

    @Override
    public void deleteConcessionario(String nome) {
        BasicConfigurator.configure();
        try{
            //establish connection
            Connection connection = DriverManager.getConnection(dbURL ,username,password);
            String sql="DELETE FROM concessionnaire WHERE nome=?";
            if(connection != null) {
                logger.info ("Connection  established");
            }
            else {
                logger.error ("Connection not established");
            }
            PreparedStatement statement1= connection.prepareStatement(sql);
            statement1.setString(1, nome);

            int rows =statement1.executeUpdate();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
     logger.info ("Concessionnario/a is deleted fron DB");

    }

    @Override
    public ConcessionarioPO getConcessionarioById(int iva) {
        ConcessionarioPO conc = new ConcessionarioPO();
        try{
            //establish connection
            Connection connection = DriverManager.getConnection(dbURL ,username,password);
            PreparedStatement statement = connection.prepareStatement("select * from concessionnaire where Iva=?");
            statement.setInt(1,iva);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                ConcessionarioMapper concessionarioMapper= new ConcessionarioMapper();
                conc = concessionarioMapper.map(resultSet);
            }
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return conc;


    }

    @Override
    public void deleteConsByid(int iva) {
        BasicConfigurator.configure();
        try{
            //establish connection
            Connection connection = DriverManager.getConnection(dbURL ,username,password);
            String sql="DELETE FROM concessionnaire WHERE Iva=?";
            if(connection != null) {
                logger.info ("Connection  established");
            }
            else {
             logger.error ("Connection not established");
            }
            PreparedStatement statement1= connection.prepareStatement(sql);
            statement1.setInt(1, iva);

            int rows =statement1.executeUpdate();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Concessionnario/a is deleted fron DB");

    }

    @Override
    public void updateByid(String nome, String citta, String indirizzo) {
        String sql="UPDATE concessionnaire SET  nome =?,citta=?,indirizzo=? WHERE Iva=?";
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
            statement1.setString(1,nome);
            statement1.setString(2,citta);
            statement1.setString(3,indirizzo);
            int rows =statement1.executeUpdate();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info ("Concessionario/a:  is updated in the database");


    }
}
