/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author acer
 */
public class Model {
    Connector connector = new Connector(); 
    public int getBanyakData(){
        int jmlData=0;
        try{
            String query = "Select * from transactions"; 
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query); 
            while(resultSet.next()){ 
                jmlData++; 
            }
            connector.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
        return jmlData;
    }
    
    public String[][] readData(){ 
        try{
            int jmlData = 0; 
            String data[][] = new String[getBanyakData()][7];
            String query = "Select * from `transactions`"; 
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            while(resultSet.next()){ 
                data[jmlData][0] = resultSet.getString("id_trans"); 
                data[jmlData][1] = resultSet.getString("nama_barang");
                data[jmlData][2] = resultSet.getString("nama_kasir"); 
                data[jmlData][3] = resultSet.getString("qty");
                data[jmlData][4] = resultSet.getString("price_per_qty");
                data[jmlData][5] = resultSet.getString("discount");
                data[jmlData][6] = resultSet.getString("price_total");
                jmlData++;       
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void tambahData(String id, String namaBarang, String namaKasir, int jml, int harga, int diskon, double total){
        
        try{
            String query = "INSERT INTO transactions VALUES ('"+ id +"','"+ namaBarang +"','"+ namaKasir +"','"+ jml +"','"+ harga +"','"+ diskon +"','"+ total +"')";  
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Data Transaksi Berhasil Ditambahkan!!");
        }catch (SQLException ex){
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,"Id Transaksi Sudah Ada di Database!!");
        }
    }
    
    public void updateData(String id, String namaBarang, String namaKasir, int jml, int harga, int diskon, double total, String pindah){
            
        try {
            String query = "update transactions set id_trans=?, "
                    + "nama_barang=?, nama_kasir=?, qty=?, price_per_qty=?, discount=?, price_total=? where id_trans=?";
            PreparedStatement preparedStmt = connector.koneksi.prepareStatement(query);
            preparedStmt.setString(1, id);
            preparedStmt.setString(2, namaBarang);
            preparedStmt.setString(3, namaKasir);
            preparedStmt.setInt(4, jml);
            preparedStmt.setInt(5, harga);
            preparedStmt.setInt(6, diskon);
            preparedStmt.setDouble(7, total);
            preparedStmt.setString(8, pindah);
            preparedStmt.execute();
            
           if(pindah.compareTo(id)==0)
            JOptionPane.showMessageDialog(null,"Update Data Transaksi Berhasil !!");
            else
                JOptionPane.showMessageDialog(null,"Data Transaksi Tidak Ada!!");
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void deleteData(String id){
        try{
            String query = "DELETE from transactions WHERE id_trans = '"+ id +"'";
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Transaksi berhasil dihapus!");
            
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
}
