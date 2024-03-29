/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author kangaru
 */
public class ModificarVideo extends javax.swing.JInternalFrame {

    /**
     * Creates new form ModificarVideo
     */
    public ModificarVideo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Usuarios = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        Videos = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        Usuarios.setModel(new DefaultListModel<String>());
        Sistema s = prueba.Inicio.sistema;
        Collection<DtUsuario> c = s.ListaUsuarios();
        Iterator<DtUsuario> it = c.iterator();
        while(it.hasNext()){
            DtUsuario v = it.next();
            ((DefaultListModel)Usuarios.getModel()).addElement(v.getNick());
        }
        Usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Usuarios);

        Videos.setModel(new DefaultListModel<String>());
        Videos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VideosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Videos);

        jLabel1.setText("Usuario");

        jLabel2.setText("Videos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
            .addGroup(layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(jLabel1)
                .addGap(100, 100, 100)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsuariosMouseClicked
        DefaultListModel model = (DefaultListModel) Videos.getModel();
        model.removeAllElements();
        Sistema s = prueba.Inicio.sistema;
        Collection<DtVideo> c = s.ListaVideos(Usuarios.getSelectedValue());
        Iterator<DtVideo> it = c.iterator();
        while(it.hasNext()){
            DtVideo v = it.next();
            ((DefaultListModel)Videos.getModel()).addElement(v.getNomVideo());
        }
    }//GEN-LAST:event_UsuariosMouseClicked

    private void VideosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VideosMouseClicked
        this.nick = Usuarios.getSelectedValue();
        this.nomVideo = Videos.getSelectedValue();
        ModificarVideo1 mod = new ModificarVideo1(this.nick,this.nomVideo);
        mod.setVisible(true);
        prueba.Inicio.Panel.add(mod);
        this.dispose();
    }//GEN-LAST:event_VideosMouseClicked

    private String nick;
    private String nomVideo;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> Usuarios;
    private javax.swing.JList<String> Videos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
