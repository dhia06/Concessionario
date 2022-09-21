package tn.esprit.java.DAO;
import com.mysql.cj.jdbc.Blob;
import tn.esprit.java.Mapper.AutocarriMapper;
import tn.esprit.java.PO.AutocarriPO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AutocarriDaoImpl implements AutocarriDao {

   public final String dbURL = "jdbc:mysql://localhost:3306/concessionnaire";
   public final String username = "root";
    public final String password = "rootroot";
    public AutocarriDaoImpl(){}


    //Get ALL Autocarri
@Override
    public List<AutocarriPO> getAutocarri() {
        List<AutocarriPO> autocarri = new ArrayList<>();

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
        ResultSet resultSet= statement.executeQuery("select * from autocarri ");
        AutocarriMapper autocarriMapper= new AutocarriMapper();
        while (resultSet.next()){
            autocarri.add(autocarriMapper.map(resultSet));
        }
        connection.close();

    }catch (Exception e){
        e.printStackTrace();
    }
    return autocarri;
    }


    //Get Autocarri by Marca
    @Override
    public List<AutocarriPO> finfByMArca(String marca) {
        List<AutocarriPO> autocarri =new ArrayList<>()  ;
        try{
            //establish connection
            Connection connection = DriverManager.getConnection(dbURL ,username,password);
            PreparedStatement statement = connection.prepareStatement("select * from autocarri where Marca=?");
            statement.setString(1,marca);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("*Get Autocarri by Marca*");

            while (resultSet.next() ){
                AutocarriMapper autocarriMapper= new AutocarriMapper();
                autocarri.add(autocarriMapper.map(resultSet));


            }
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return autocarri;

    }

    @Override
    public List<AutocarriPO> findByIva(int iva) {
        //1 defenir le resulat
        List<AutocarriPO> list = new ArrayList<>();
        //2 implementer la methodes et logic metier
        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from autocarri where Iva=?");
            preparedStatement.setInt(1,iva);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next() ){
                AutocarriMapper autocarriMapper= new AutocarriMapper();
                list.add(autocarriMapper.map(resultSet));


            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(list);
        ///3 retour
        return list;
    }

    //Insert New Autocarri
    @Override
    public void insertAutocarri(int nbr_telaio,String marca, String modello, int iva, int max_capacity, Blob image) {

        try{
            InputStream im = new FileInputStream ("C:\\Users\\mohsassi\\IdeaProjects\\Concessionnaire\\pic\\1.jpg");

            Connection connection = DriverManager.getConnection(dbURL ,username,password);
            String SQL = "INSERT INTO autocarri (Nbr_telaio,Marca,Modello,Iva,Max_capacity,image) " + "VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt (1,nbr_telaio);
            statement.setString(2,marca);
            statement.setString(3,modello);
            statement.setInt(4,iva);
            statement.setInt(5,max_capacity);
            statement.setBlob (6,image);

            int rows= statement.executeUpdate();
            if (rows>0 || marca.length()<0 || modello.length()<0 || iva<0 ){
                System.out.println(" New autocarri was inserted successfully");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public AutocarriPO findAutoByid(int nbr_telaio) {

        AutocarriPO autocarri = null;
        try{
            //establish connection
            Connection connection = DriverManager.getConnection(dbURL ,username,password);
            PreparedStatement statement = connection.prepareStatement("select * from autocarri where Nbr_telaio=?");
            statement.setInt(1,nbr_telaio);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("*Get Autocarri by ID*");


            while (resultSet.next()){
                AutocarriMapper autocarriMapper= new AutocarriMapper();
                autocarri = autocarriMapper.map(resultSet);
            }
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return autocarri;

    }
    //UPDATE AUTOCARRI
    @Override
    public void updateAutocarri(String marca,String modello,int iva ,int max_capacity) {

        String sql="UPDATE autocarri SET  Modello =?,Iva =?,Max_capacity=? WHERE Marca=?";
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
            statement1.setInt(3,max_capacity);
            statement1.setString(4,marca);
         int rows =statement1.executeUpdate();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("Autocarri:Marca is updated in the database");
    }
    //DELETE AUTOCAR
    @Override
    public void deleteAutocarri(String marca) {
        try{
            //establish connection
            Connection connection = DriverManager.getConnection(dbURL ,username,password);
            String sql="DELETE FROM autocarri WHERE Marca=?";
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




        System.out.println("Autocarri is deleted fron DB");

    }

}
