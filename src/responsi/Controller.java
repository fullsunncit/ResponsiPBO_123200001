/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import responsi.Main.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
/**
 *
 * @author acer
 */
public class Controller {
    Model model;
    View view;
    
    public Controller(View view, Model model) {
        this.model = model;
        this.view = view;

        if(model.getBanyakData() != 0){
            String data[][] = model.readData();
            view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
        } else{
            JOptionPane.showMessageDialog(null, "Data Transaksi Kosong");
        }
    
        //aksi ketika menekan tombol tambah
        view.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                String id = view.getFid().getText();
                String namaBarang = view.getFnamaBarang().getText();
                String namaKasir = view.getFnamaKasir().getText();
                int jml = Integer.parseInt(view.getFjml().getText());
                int harga = Integer.parseInt(view.getFharga().getText());
                int diskon = Integer.parseInt(view.getFdiskon().getText());
                double total = (jml*harga)-(jml*harga*(diskon*0.01));

                if (id.equals("")||namaBarang.equals("")||namaKasir.equals("")||jml==0||harga==0||diskon==0) {
                    JOptionPane.showMessageDialog(view, "Isi Kolom Kosong Terlebih Dahulu !");
                }else{
                    model.tambahData(id,namaBarang,namaKasir,jml,harga,diskon,total);
                    view.dispose();
                    MVC mvc = new MVC();
                    mvc.menu_utama();
                }
            }
        });

        //aksi ketika menekan tombol update
        view.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                String pindah = view.pindah;
                String id = view.getFid().getText();
                String namaBarang = view.getFnamaBarang().getText();
                String namaKasir = view.getFnamaKasir().getText();
                int jml = Integer.parseInt(view.getFjml().getText());
                int harga = Integer.parseInt(view.getFharga().getText());
                int diskon = Integer.parseInt(view.getFdiskon().getText());
                double total = (jml*harga)-(jml*harga*(diskon*0.01));
                if (id.equals("")||namaBarang.equals("")||namaKasir.equals("")||jml==0||harga==0||diskon==0) {
                    JOptionPane.showMessageDialog(view, "Isi Kolom Kosong Terlebih Dahulu !");
                }else {
                    model.updateData(id,namaBarang,namaKasir,jml,harga,diskon,total,pindah);
                    view.dispose();
                    MVC mvc = new MVC();
                    mvc.menu_utama();
                }
            }
        });

        //aksi ketika menekan tombol delete
        view.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                String id = view.getFid().getText();

                if (id.equals("")) {
                    JOptionPane.showMessageDialog(view, "Isi ID Transaksi Yang Akan Dihapus");
                }else {
                    model.deleteData(id);
                    view.dispose();
                    MVC mvc = new MVC();
                    mvc.menu_utama();
                }
            }
        });

        //aksi ketika menekan tombol clear
        view.btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                view.fid.setText("");
                view.fnamaBarang.setText("");
                view.fnamaKasir.setText("");
                view.fjml.setText("");
                view.fharga.setText("");
                view.fdiskon.setText("");
            }
        });  
    }
}
