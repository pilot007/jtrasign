/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AlgConfigDialog.java
 *
 * Created on 12-ene-2009, 20:23:48
 */

package jtraffic;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import jtraffic.algoritmo.ConfigAlgoritmo;
import jtraffic.algoritmo.Dimensiones;

/**
 *
 * @author JuanmaSP
 */
public class AlgConfigDialog extends javax.swing.JDialog {
    ConfigAlgoritmo configuracion;

    /** Creates new form AlgConfigDialog */
    public AlgConfigDialog(java.awt.Frame parent, boolean modal, ConfigAlgoritmo config) {
        super(parent, modal);
        initComponents();

        if(config != null)
            this.configuracion = config;
        else
            config = new ConfigAlgoritmo();

        setResizable(false);
        setTitle("Configuración del algoritmo");

        Iterator<Dimensiones> it = ConfigAlgoritmo.dimensionesPermitidas().iterator();
        while(it.hasNext()){
            cbDimensiones.addItem(it.next());
        }
        cbDimensiones.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                cambiarCampos();
            }
        });

        for(int i=0; i < 3; i++){
            cbReduccionBusq.addItem(reducir(configuracion.dimensionesAlg, i));
        }

        //Cargamos todos los valores en los campos del formulario
        cbDimensiones.setSelectedItem(configuracion.dimensionesAlg);
        tfPesoBorde.setText(Float.toString(configuracion.pesoBorde));
        tfPesoColor.setText(Float.toString(configuracion.pesoColor));
        tfNoNivPiram.setText(Integer.toString(configuracion.niveles_piramide));
        tfDimVentBusq.setText(Integer.toString(configuracion.dimFixedWindow));
        cbReduccionBusq.setSelectedIndex(configuracion.factorReduccionBusq);
        tfUmbralBusq.setText(Double.toString(configuracion.umbralBusq));
    }

    private void salvarYSalir(){
        configuracion.dimensionesAlg = (Dimensiones)cbDimensiones.getSelectedItem();
        configuracion.pesoBorde = Float.parseFloat(tfPesoBorde.getText());
        configuracion.pesoColor = Float.parseFloat(tfPesoColor.getText());
        //configuracion.niveles_piramide = Integer.parseInt(tfNoNivPiram.getText());//Por ahora está desactivado.
        configuracion.dimFixedWindow = Integer.parseInt(tfDimVentBusq.getText());
        configuracion.factorReduccionBusq = cbReduccionBusq.getSelectedIndex();
        configuracion.umbralBusq = Double.parseDouble(tfUmbralBusq.getText());
        System.out.println(configuracion);
        this.dispose();
    }

    private int reduccion(Dimensiones d1, Dimensiones d2){
        if(d1.width != d2.width){
            int res = d1.width / d2.width;
            res = (int)(Math.log10(res) / Math.log10(2));
            return res;
        }
        else return 0;
    }

    private Dimensiones reducir(Dimensiones d1, int n){
        if(n > 0){
            float div = (float) Math.pow(2, n);
            int w = (int)Math.ceil(d1.width / div);
            int h = (int)Math.ceil(d1.height / div);
            Dimensiones res = new Dimensiones(w, h);
            return res;
        }
        else
            return d1;
    }

    private void cambiarCampos(){
        cbReduccionBusq.removeAllItems();
        for(int i=0; i < 3; i++){
            cbReduccionBusq.addItem(reducir((Dimensiones) cbDimensiones.getSelectedItem(), i));
        }
        cbReduccionBusq.setSelectedIndex(configuracion.factorReduccionBusq);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbDimensiones = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        tfNoNivPiram = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfPesoBorde = new javax.swing.JTextField();
        tfPesoColor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfUmbralBusq = new javax.swing.JTextField();
        bAceptar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tfDimVentBusq = new javax.swing.JTextField();
        bCancelar = new javax.swing.JButton();
        cbReduccionBusq = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(jtraffic.JTrafficApp.class).getContext().getResourceMap(AlgConfigDialog.class);
        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        cbDimensiones.setName("cbDimensiones"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        tfNoNivPiram.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfNoNivPiram.setText(resourceMap.getString("tfNoNivPiram.text")); // NOI18N
        tfNoNivPiram.setEnabled(false);
        tfNoNivPiram.setName("tfNoNivPiram"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        tfPesoBorde.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfPesoBorde.setText(resourceMap.getString("tfPesoBorde.text")); // NOI18N
        tfPesoBorde.setName("tfPesoBorde"); // NOI18N

        tfPesoColor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfPesoColor.setText(resourceMap.getString("tfPesoColor.text")); // NOI18N
        tfPesoColor.setName("tfPesoColor"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        tfUmbralBusq.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfUmbralBusq.setText(resourceMap.getString("tfUmbralBusq.text")); // NOI18N
        tfUmbralBusq.setName("tfUmbralBusq"); // NOI18N

        bAceptar.setText(resourceMap.getString("bAceptar.text")); // NOI18N
        bAceptar.setName("bAceptar"); // NOI18N
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        tfDimVentBusq.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfDimVentBusq.setName("tfDimVentBusq"); // NOI18N

        bCancelar.setText(resourceMap.getString("bCancelar.text")); // NOI18N
        bCancelar.setName("bCancelar"); // NOI18N
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        cbReduccionBusq.setName("cbReduccionBusq"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(bCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfDimVentBusq, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(26, 26, 26)
                        .addComponent(tfUmbralBusq, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbReduccionBusq, 0, 77, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbDimensiones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfPesoBorde, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                .addComponent(tfNoNivPiram)
                                .addComponent(tfPesoColor, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbDimensiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfNoNivPiram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfPesoBorde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfPesoColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbReduccionBusq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfUmbralBusq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfDimVentBusq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAceptar)
                    .addComponent(bCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        salvarYSalir();
    }//GEN-LAST:event_bAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JComboBox cbDimensiones;
    private javax.swing.JComboBox cbReduccionBusq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField tfDimVentBusq;
    private javax.swing.JTextField tfNoNivPiram;
    private javax.swing.JTextField tfPesoBorde;
    private javax.swing.JTextField tfPesoColor;
    private javax.swing.JTextField tfUmbralBusq;
    // End of variables declaration//GEN-END:variables

}
