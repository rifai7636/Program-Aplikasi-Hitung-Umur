package Latihan2;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class ProgramHitungHelper extends javax.swing.JFrame {

    ArrayList<String> riwayatList = new ArrayList<>();

    public ProgramHitungHelper() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 12));
        jLabel1.setText("PILIH TANGGAL LAHIR");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 12));
        jLabel3.setText("UMUR ANDA");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 12));
        jLabel2.setText("ULTAH BERIKUTNYA");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jButton2.setText("HITUNG");
        jButton2.addActionListener(evt -> jButton2ActionPerformed(evt));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jButton1.setText("RIWAYAT");
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(60)
                .addComponent(jButton1)
                .addGap(100))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        pack();
    }// </editor-fold>                        

    // ==========================
    // Tombol HITUNG
    // ==========================
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Date tanggalLahir = jDateChooser1.getDate();

        if (tanggalLahir == null) {
            JOptionPane.showMessageDialog(this, "Silakan pilih tanggal lahir terlebih dahulu!");
            return;
        }

        LocalDate lahir = tanggalLahir.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate hariIni = LocalDate.now();

        Period umur = Period.between(lahir, hariIni);
        String umurStr = umur.getYears() + " tahun, " + umur.getMonths() + " bulan, " + umur.getDays() + " hari";
        jTextField1.setText(umurStr);

        LocalDate ultahBerikut = lahir.withYear(hariIni.getYear());
        if (!ultahBerikut.isAfter(hariIni)) {
            ultahBerikut = ultahBerikut.plusYears(1);
        }
        jTextField2.setText(String.valueOf(ultahBerikut));

        // Simpan ke riwayat
        String riwayat = "Tanggal Lahir: " + lahir + " | Umur: " + umurStr + " | Ultah Berikutnya: " + ultahBerikut;
        riwayatList.add(riwayat);
    }                                        

    // ==========================
    // Tombol RIWAYAT
    // ==========================
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (riwayatList.isEmpty()) {
            jTextArea1.setText("Belum ada riwayat perhitungan.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (String r : riwayatList) {
                sb.append(r).append("\n");
            }
            jTextArea1.setText(sb.toString());
        }
    }                                        

    // ==========================
    // MAIN PROGRAM
    // ==========================
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new ProgramHitungHelper().setVisible(true);
        });
    }

    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration
}
