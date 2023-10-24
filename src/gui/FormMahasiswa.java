package gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//
public class FormMahasiswa extends javax.swing.JFrame {
    int nim;
    String nama;
    String kelas;
    String prodi;
    
    Object[]dataMhs=new Object [4]; 
    
    public FormMahasiswa() {
        initComponents();
        loadTabel();
    }
    
    private void loadTabel(){
       DefaultTableModel model = new DefaultTableModel();
       model.addColumn("nim");
       model.addColumn("nama");
       model.addColumn("kelas");
       model.addColumn("prodi");
       try{
           int no = 1;
           String select = "SELECT * FROM mahasiswa";
           java.sql.Connection conn = (Connection) configDB.koneksi();
           java.sql.Statement stm = conn.createStatement();
           java.sql.ResultSet res = stm.executeQuery(select);
           
           while(res.next()){
               model.addRow(new Object[] {res.getString(1),res.getString(2),res.getString(3),res.getString(4)});
           }
           tblMahasiswa.setModel(model);
       } catch(SQLException e){
           System.out.println("Error : "+e.toString());
       }
   }

    private void insertData() {
         java.sql.Connection connection = (Connection) configDB.koneksi();
        String insertPelanggan = "INSERT INTO mahasiswa"
            + "(nim, nama, kelas, prodi) VALUES"
            + "(?,?,?,?)";
        PreparedStatement statement = null;
        try {
           
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertPelanggan, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, txtNim.getText());
            statement.setString(2, txtNama.getText());
            statement.setString(3, txtKelas.getText());
            statement.setString(4, txtProdi.getText());
            statement.executeUpdate();
            
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Error : "+e.toString());
        }
    }
    private void bersih(){
        txtNim.setText("");
        txtNama.setText("");
        txtKelas.setText("");
        txtProdi.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNim = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtKelas = new javax.swing.JTextField();
        txtProdi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMahasiswa = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();

        setTitle("Joni prianto-Mahasiswa");

        jLabel1.setText("NIM");

        jLabel2.setText("nama");

        jLabel3.setText("kelas");

        jLabel4.setText("prodi");

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        txtKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKelasActionPerformed(evt);
            }
        });

        txtProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdiActionPerformed(evt);
            }
        });

        tblMahasiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMahasiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMahasiswa);
        if (tblMahasiswa.getColumnModel().getColumnCount() > 0) {
            tblMahasiswa.getColumnModel().getColumn(0).setResizable(false);
            tblMahasiswa.getColumnModel().getColumn(1).setResizable(false);
            tblMahasiswa.getColumnModel().getColumn(2).setResizable(false);
            tblMahasiswa.getColumnModel().getColumn(3).setResizable(false);
        }

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNim)
                    .addComponent(txtNama)
                    .addComponent(txtKelas)
                    .addComponent(txtProdi, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void txtKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKelasActionPerformed

    private void txtProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdiActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        insertData();
        loadTabel();
        bersih();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int konf = JOptionPane.showConfirmDialog(this,
                "Yakin menghapus data "+
                        txtNama.getText()+" ?", "Konfirmasi",
                        JOptionPane.YES_NO_OPTION);
        if(konf == 0){
            String nim = txtNim.getText();
            System.out.print("NIM yang dihapus : "+nim);
            String delete = "DELETE FROM mahasiswa WHERE nim ='"+nim+"'";
            try{
               java.sql.Connection conn = (Connection) configDB.koneksi();
               java.sql.PreparedStatement pst =  conn.prepareStatement(delete);
               pst.execute();

            } catch(SQLException e){
               System.out.println("Error : "+e.toString());
            }
            loadTabel();
            bersih();
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        String nim = txtNim.getText();
        String nama = txtNama.getText();
        String kelas = txtKelas.getText();
        String prodi = txtProdi.getText();
        String sql = "";
        if(!nim.isEmpty())
            sql = "select * from mahasiswa where nim='"+nim+"' ";
        else if (!nama.isEmpty())
            sql = "select * from mahasiswa where nama like '%"+nama+"%' ";
        else if (!kelas.isEmpty())
            sql = "select * from mahasiswa where kelas='"+kelas+"' ";
        else if (!prodi.isEmpty())
            sql = "select * from mahasiswa where prodi='"+prodi+"' ";
        else
            sql = "select * from mahasiswa";
       
       DefaultTableModel model = new DefaultTableModel();
       model.addColumn("nim");
       model.addColumn("nama");
       model.addColumn("kelas");
       model.addColumn("prodi");
       
       try{
           java.sql.Connection conn = (Connection) configDB.koneksi();
           java.sql.Statement stm = conn.createStatement();
           java.sql.ResultSet res = stm.executeQuery(sql);
       
           while(res.next()){
               model.addRow(new Object[] {res.getString(1),res.getString(2),res.getString(3),res.getString(4)});
           }
           tblMahasiswa.setModel(model);
        } catch(SQLException e){
           System.out.println("Error : "+e.toString());
       }
    }//GEN-LAST:event_btnCariActionPerformed

    private void tblMahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMahasiswaMouseClicked
        int row = tblMahasiswa.getSelectedRow();
        txtNim.setText(
        tblMahasiswa.getModel().getValueAt(row, 0).toString());
        txtNama.setText(
        tblMahasiswa.getModel().getValueAt(row, 1).toString());
        txtKelas.setText(
        tblMahasiswa.getModel().getValueAt(row, 2).toString());
        txtProdi.setText(
        tblMahasiswa.getModel().getValueAt(row, 3).toString());
    }//GEN-LAST:event_tblMahasiswaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMahasiswa().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMahasiswa;
    private javax.swing.JTextField txtKelas;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNim;
    private javax.swing.JTextField txtProdi;
    // End of variables declaration//GEN-END:variables
}
