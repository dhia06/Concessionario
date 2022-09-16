package tn.esprit.java.DAO;
import tn.esprit.java.Mapper.AutocarriMapper;
import tn.esprit.java.Mapper.AutoveicoliMapper;
import tn.esprit.java.MapperBo.AutoveicoliMapperBo;
import tn.esprit.java.PO.AutocarriPO;
import tn.esprit.java.PO.AutoveicoloPO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutoveicoliDaoImpl  implements AutoveicoloDao {
    public final String dbURL = "jdbc:mysql://localhost:3306/concessionnaire";
    public final String username = "root";
    public final String password = "rootroot";
    public AutoveicoliDaoImpl(){}


    @Override
    public List<AutoveicoloPO> getAutoveicolo() {
        List<AutoveicoloPO> autoveicolo =new ArrayList<>()  ;

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
        AutoveicoloPO autoveicolo =new AutoveicoloPO()  ;
        try{
            //establish connection
            Connection connection = DriverManager.getConnection(dbURL ,username,password);
            PreparedStatement statement = connection.prepareStatement("select * from autoveicolo where Nbr_telaio=?");
            statement.setInt(1,nbr_telaio);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("*Get Autoveicoli by ID*");

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
            System.out.println("*Get Autoveiocoli by Marca*");

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
                System.out.println(" New autoveicolo was inserted successfully");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateAutoveicoli(String marca, String modello, int iva, int nbr_door) {
        String sql="UPDATE autoveicolo SET  Modello =?,Iva =?,Nbr_door=? WHERE Marca=?";
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
            statement1.setString(1,modello);
            statement1.setInt(2,iva);
            statement1.setInt(3,nbr_door);
            statement1.setString(4,marca);
            int rows =statement1.executeUpdate();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("Autoveicolo:Marca is updated in the database");







    }

    @Override
    public void deleteAutoveicoli(String marca) {
        try{
            //establish connection
            Connection connection = DriverManager.getConnection(dbURL ,username,password);
            String sql="DELETE FROM autoveicolo WHERE Marca=?";
            if(connection != null) {
                System.out.println("Connection  established");
            }
            else {
                System.out.println("Connection not established");
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

            //1 defenir le resulat
            List<AutoveicoloPO> autoveicoloPOS = new ArrayList<>();
            //2 implementer la methodes et logic metier
            try {
                Connection connection = DriverManager.getConnection(dbURL, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement("select * from autoveicolo where iva=?");
                preparedStatement.setLong(1,iva);
                ResultSet resultSet = preparedStatement.executeQuery();
                AutoveicoliMapper autoveicoliMapper = new AutoveicoliMapper();
                while (resultSet.next() ){

                   autoveicoloPOS.add(autoveicoliMapper.map(resultSet));


                }
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(autoveicoloPOS);
            ///3 retour
            return autoveicoloPOS;

    }


}
