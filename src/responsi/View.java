/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author acer
 */
public class View extends JFrame{
    String pindah;
    JTable tabel;
    DefaultTableModel tableModel; 
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID","NAMA BARANG","NAMA KASIR","QUANTITY","HARGA PER-SATUAN", "DISKON", "HARGA TOTAL"};
    final JTextField fid = new JTextField(10);
    final JTextField fnamaBarang = new JTextField();
    final JTextField fnamaKasir = new JTextField();
    final JTextField fjml = new JTextField();
    final JTextField fharga = new JTextField();
    final JTextField fdiskon = new JTextField();
    
    JLabel lid= new JLabel("ID Barang");
    JLabel lnamaBarang = new JLabel("Nama Barang");
    JLabel lnamaKasir = new JLabel("Nama Kasir");
    JLabel ljml = new JLabel("Jumlah Barang");
    JLabel lharga = new JLabel("Harga Per-satuan");
    JLabel ldiskon = new JLabel("Diskon (dalam %)");
    JButton btnTambah = new JButton("Tambah");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnClear = new JButton("Clear");
    
    public View(){
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        setLayout(null);
        setSize(970,520);
        setVisible(true);
        setResizable(false);
        setTitle("MENU TRANS DB");
        setDefaultCloseOperation(3);
  
        add(scrollPane);
        add(lid);
        add(fid);
        add(lnamaBarang);
        add(fnamaBarang);
        add(lnamaKasir);
        add(fnamaKasir);
        add(ljml);
        add(fjml);
        add(lharga);
        add(fharga);
        add(ldiskon);
        add(fdiskon);
        add(btnTambah);
        add(btnUpdate);
        add(btnDelete);
        add(btnClear);


        scrollPane.setBounds(20, 35, 700, 345);
        
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        lid.setBounds(750, 35, 120, 20);
        fid.setBounds(750, 60, 170, 20);
        lnamaBarang.setBounds(750, 90, 120, 20);
        fnamaBarang.setBounds(750, 115, 170, 20);
        lnamaKasir.setBounds(750, 145, 120, 20);
        fnamaKasir.setBounds(750, 170, 170, 20);
        ljml.setBounds(750, 200, 120, 20);
        fjml.setBounds(750, 225, 170, 20);
        lharga.setBounds(750, 255, 120, 20);
        fharga.setBounds(750, 280, 170, 20);
        ldiskon.setBounds(750, 310, 120, 20);
        fdiskon.setBounds(750, 335, 170, 20);
        btnTambah.setBounds(750, 400, 80, 20);
        btnUpdate.setBounds(750, 430, 80, 20);
        btnDelete.setBounds(850, 400, 80, 20);
        btnClear.setBounds(850, 430, 80, 20);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
        
        tabel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                JTable target = (JTable)me.getSource();
                int baris = target.getSelectedRow(); // select a row
                pindah =tabel.getValueAt(baris, 0).toString();
                fid.setText(tabel.getValueAt(baris, 0).toString());
                fnamaBarang.setText(tabel.getValueAt(baris, 1).toString());
                fnamaKasir.setText( tabel.getValueAt(baris, 2).toString());
                fjml.setText(tabel.getValueAt(baris, 3).toString());
                fharga.setText(tabel.getValueAt(baris, 4).toString());
                fdiskon.setText(tabel.getValueAt(baris, 5).toString());          
            }
        });       
    }
    public JTextField getFid() {
        return fid;
    }

    public JTextField getFnamaBarang() {
        return fnamaBarang;
    }

    public JTextField getFnamaKasir() {
        return fnamaKasir;
    }

    public JTextField getFjml() {
        return fjml;
    }
    
    public JTextField getFharga() {
        return fharga;
    }
    
    public JTextField getFdiskon() {
        return fdiskon;
    }
}
