/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.curiousworkmanship.frames;

import citbyui.cit260.curiousworkmanship.enums.Actor;
import citbyui.cit260.curiousworkmanship.model.ActorOld;
import citbyui.cit260.curiousworkmanship.model.Location;
import citbyui.cit260.curiousworkmanship.model.Scene;
import curiousworkmanship.CuriousWorkmanship;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jacksonrkj
 */
public class GameMenuFrame extends javax.swing.JFrame {
    private int selectedRow = 0;
    private int selectedColumn = 2;
    private LocationFrame locationFrame = null;
    /**
     * Creates new form GameMenuFrame
     */
    public GameMenuFrame() {
        initComponents();
        MapTableModel mapTableModel = new MapTableModel();
        
        Location[][] locations = CuriousWorkmanship.getCurrentGame().getMap().getLocations();
        Object[][] data = this.getTableData(locations);
        Object[] columns = this.getColumnData(locations[0].length);
        mapTableModel.setDataVector(data, columns);
        this.getJtMap().setModel(mapTableModel);
     


        for (int i = 0; i < locations.length; i++) {
            Location[] row = locations[i];
            for (int j = 0; j < row.length; j++) {
                Location location = locations[i][j];
                Scene scene = location.getScene();
                Object value = null;
                if (scene != null) {
                    ImageIcon icon = scene.getIcon();
                    if (icon != null) {
                        // resize image to size of cell
                        int rowHeight = this.jtMap.getRowHeight();
                        int columnWidth = this.jtMap.getColumnModel().getColumn(j).getWidth();
                        ImageIcon iconImage =  GameMenuFrame.resize(icon, columnWidth, rowHeight); 
                        value = iconImage;
                    }               
                }
                mapTableModel.setValueAt(value, i, j);
            }
        }
    }

    private Object[][] getTableData(Location[][] locations) {

        Object[][] data = new Object[locations.length][locations[0].length];

        for (int i = 0; i < locations.length; i++) {
            Location[] row = locations[i];
            for (int j = 0; j < row.length; j++) {
                Location location = locations[i][j];
                Scene scene = location.getScene();
                Object value;
                if (scene == null) {
                    value = "??";
                } else if (scene.getIcon() != null) {
                    
                    value = scene.getIcon();
                } else {
                    value = scene.getMapSymbol();
                }

                data[i][j] = value;

            }
        }
        return data;
    }

    private Object[] getColumnData(int columnCount) {
        Object[] columnHeaderData = new Object[columnCount];
        for (int i = 0; i < columnHeaderData.length; i++) {
            Object object = columnHeaderData[i];
        }
        return columnHeaderData;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbInventory = new javax.swing.JButton();
        jbQuit = new javax.swing.JButton();
        jbViewLocation = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMap = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        setPreferredSize(new java.awt.Dimension(956, 728));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Curious Workmanship Game");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(281, 281, 281))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jbInventory.setText("Inventory");
        jbInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInventoryActionPerformed(evt);
            }
        });

        jbQuit.setText("Quit");
        jbQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbQuitActionPerformed(evt);
            }
        });

        jbViewLocation.setText("View Location");
        jbViewLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbViewLocationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbViewLocation))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jbInventory))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jbQuit)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jbInventory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbViewLocation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbQuit)
                .addGap(116, 116, 116))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jtMap.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtMap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"
            }
        ));
        jtMap.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jtMap.setCellSelectionEnabled(true);
        jtMap.setGridColor(new java.awt.Color(0, 0, 0));
        jtMap.setMaximumSize(new java.awt.Dimension(1500, 620));
        jtMap.setMinimumSize(new java.awt.Dimension(1500, 620));
        jtMap.setPreferredSize(new java.awt.Dimension(1500, 620));
        jtMap.setRowHeight(30);
        jtMap.setShowGrid(false);
        jtMap.getTableHeader().setResizingAllowed(false);
        jtMap.getTableHeader().setReorderingAllowed(false);
        jtMap.setUpdateSelectionOnSort(false);
        jtMap.setVerifyInputWhenFocusTarget(false);
        jtMap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtMapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtMap);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInventoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbInventoryActionPerformed

    private void jbQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbQuitActionPerformed
        CuriousWorkmanship.getMainMenuFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbQuitActionPerformed

    private void jbViewLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbViewLocationActionPerformed
        this.handleViewLocation();
    }//GEN-LAST:event_jbViewLocationActionPerformed

    private void jtMapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMapMouseClicked
        this.selectedRow = this.jtMap.getSelectedRow();
        this.selectedColumn = this.jtMap.getSelectedColumn();
        int numberClicks = evt.getClickCount();       
    }//GEN-LAST:event_jtMapMouseClicked

    private void handleViewLocation() {
        if (this.locationFrame == null) {
            this.locationFrame = new LocationFrame(this);
        }
        Location[][] locations = CuriousWorkmanship.getCurrentGame().getMap().getLocations();
        Location location = locations[this.selectedRow][this.selectedColumn];
        Scene scene = location.getScene();
        Dimension imageSize = this.locationFrame.getJlImage().getPreferredSize();
        ImageIcon resizedImage = GameMenuFrame.resize(scene.getIcon(), imageSize.width, imageSize.height);
        this.locationFrame.getJlImage().setIcon(resizedImage);
        this.locationFrame.getJtaDescription().setText(scene.getDescription());
        
        
        ArrayList<Actor> actors = location.getActors();
        ArrayList<String> actorNames = new ArrayList();
        for (Actor actor : actors) {
            actorNames.add(actor.toString()); 
        }

        this.locationFrame.getJlActors().setListData(actorNames.toArray());
        this.locationFrame.setVisible(true);
        this.setVisible(false);
    }
    
    public JTable getJtMap() {
        return jtMap;
    }

    public void setJtMap(JTable jtMap) {
        this.jtMap = jtMap;
    }


    private class CellRenderer extends DefaultTableCellRenderer {

        /*
         * @see TableCellRenderer#getTableCellRendererComponent(JTable, Object, boolean, boolean, int, int)
         */
        public Component getTableCellRendererComponent(JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row, int column) {
            if (value == null) {
                return this;
            }

            if (value instanceof ImageIcon) {
                this.setIcon((ImageIcon) value);
            } else if (value instanceof String) {
                this.setText((String) value);
            } else {
                this.setText("??");
            }

            return this;
        }

    }

    private class MapTableModel extends DefaultTableModel {

        public Class getColumnClass(int columnIndex) {
            Vector rows = this.getDataVector();
            int rowCount = this.getRowCount();
            for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {

                Vector row = (Vector) rows.elementAt(rowIndex);
                if (row.elementAt(columnIndex) != null) {
                    return getValueAt(rowIndex, columnIndex).getClass();
                }
            }
            return String.class;
        }

    }



    public static ImageIcon resize(ImageIcon icon, int width, int height) {
        
        if (icon == null)
            return null;
        
        Image image = icon.getImage();
        
        double imageWidth = image.getWidth(null);
        double imageHeight = image.getHeight(null);
        
        double ratio = imageHeight / imageWidth;
        
        if (imageWidth < width  || imageHeight < height) {
            width = (int) imageWidth;
            height = (int) imageHeight;
        }
             
        else if (imageWidth > imageHeight) {
                height = (int) (width * ratio);
        } 
        else {
                width = (int) (height / ratio);
        }
          
        Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);  
        ImageIcon resizedIcon = new ImageIcon(newimg);    
          
        
        return resizedIcon;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbInventory;
    private javax.swing.JButton jbQuit;
    private javax.swing.JButton jbViewLocation;
    private javax.swing.JTable jtMap;
    // End of variables declaration//GEN-END:variables
}
