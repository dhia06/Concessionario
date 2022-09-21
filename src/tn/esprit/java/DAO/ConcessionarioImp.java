package tn.esprit.java.DAO;

import tn.esprit.java.Mapper.AutocarriMapper;
import tn.esprit.java.Mapper.ConcessionarioMapper;
import tn.esprit.java.PO.AutocarriPO;
import tn.esprit.java.PO.ConcessionarioPO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConcessionarioImp implements ConcessionarioDao {
    public final String dbURL = "jdbc:mysql://localhost:3306/concessionnaire";
    public final String username = "root";
    public final String password = "rootroot";
    public ConcessionarioImp(){}
    @Override
    public List<ConcessionarioPO> getConcessionario() {
        List<ConcessionarioPO> Concessionar =new ArrayList<>()  ;
        try{
            //establish connection
            Connection connection = DriverManager.getConnection(dbURL ,username,password);
            if(connection != null) {
                System.out.println("Connection  established");
            }
            else {
                System.out.println("Connection not established");
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
            System.out.println("*Get Concessionnaire by Nome*");

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
                System.out.println(" New Concessionario was inserted successfully");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateConcessionario( String citta, String indirizzo,String nome) {
        String sql="UPDATE concessionnaire SET  citta =?,indirizzo=? WHERE nome=?";
        try{
            //establish connection
            Connection connection = DriverManager.getConnection(dbURL ,username,password);
            if(connection != null) {
                System.out.println("Connection established");
            }
            else {
                System.out.println("Connection not established");
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
        System.out.println("Concessionario/a: is updated in the database");

    }

    @Override
    public void deleteConcessionario(String nome) {
        try{
            //establish connection
            Connection connection = DriverManager.getConnection(dbURL ,username,password);
            String sql="DELETE FROM concessionnaire WHERE nome=?";
            if(connection != null) {
                System.out.println("Connection  established");
            }
            else {
                System.out.println("Connection not established");
            }
            PreparedStatement statement1= connection.prepareStatement(sql);
            statement1.setString(1, nome);

            int rows =statement1.executeUpdate();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Concessionnario/a is deleted fron DB");

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
            System.out.println("*Get Autocarri by ID*");
            System.out.println("iva "+iva);
           // System.out.println("nome"+ conc.getNome());

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

        try{
            //establish connection
            Connection connection = DriverManager.getConnection(dbURL ,username,password);
            String sql="DELETE FROM concessionnaire WHERE Iva=?";
            if(connection != null) {
                System.out.println("Connection  established");
            }
            else {
                System.out.println("Connection not established");
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
                System.out.println("Connection  established");
            }
            else {
                System.out.println("Connection not established");
            }
            Statement statement = connection.createStatement();
            PreparedStatement statement1= connection.prepareStatement(sql);
            statement1.setString(1,nome);
            statement1.setString(2,citta);
            statement1.setString(3,indirizzo);
           // statement1.setString(4, String.valueOf(veicolist));
            int rows =statement1.executeUpdate();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Concessionario/a:  is updated in the database");


    }
}
