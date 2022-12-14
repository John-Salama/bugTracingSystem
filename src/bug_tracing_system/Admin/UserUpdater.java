/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bug_tracing_system.Admin;

import bug_tracing_system.DataBase;
import bug_tracing_system.Users;
import bug_tracing_system.Data;
import static bug_tracing_system.EditAccounts.CheckUsername;
import static bug_tracing_system.EditAccounts.Update;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author haidy
 */
public final class UserUpdater extends javax.swing.JFrame implements Data {
    ArrayList<Users> arrLst = new ArrayList<>();
    static int xPress = 0;
    static int yPress = 0;
    private String name;
    private String noOfBugs;
    private String role;
    private String password;
    private String userName;
    private String userId;
    static Users myUser;
    String[] row;
    Object[] lines;

    /**
     * Creates new form update
     * @param currentUser
     */
    public UserUpdater(Users currentUser) {
        try {
            myUser = currentUser;
            initComponents();
            DefaultTableModel model;
            model = (DefaultTableModel) usersTable.getModel();
            model.setRowCount(0);
            getData();
            for (int i = 0; i < arrLst.size(); i++) {
                Users user = arrLst.get(i);
                String Data[] = {Integer.toString(user.getID()), user.getUsername(), user.getPassword(), user.getRole(), Integer.toString(user.getNoOfBugs()), user.getName()}; //data added in table
                model.addRow(Data);
            }
            arrLst = new ArrayList<>();
            Timer t = new Timer(2000, (ActionEvent ae) -> {
                try {
                    model.setRowCount(0);
                    getData();
                    for (int i = 0; i < arrLst.size(); i++) {
                        Users user = arrLst.get(i);
                        String Data[] = {Integer.toString(user.getID()), user.getUsername(), user.getPassword(), user.getRole(), Integer.toString(user.getNoOfBugs()), user.getName()}; //data added in table
                        model.addRow(Data);
                    }
                    arrLst = new ArrayList<>();
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(UserUpdater.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            t.start();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void getData() throws SQLException, ClassNotFoundException
    {      
        DataBase db = new DataBase();           
            String sql = "SELECT * FROM accounts as a, roles as r WHERE a.UserId = r.AccountsUserId";
            ResultSet rs = db.selectQuery(sql);
            while(rs.next())
            {
               Users user = new Users(rs.getInt("UserId"), rs.getString("Username"), rs.getString("Password"),rs.getString("RoleName"),  rs.getInt("NoOfBugs"), rs.getString("FName") + rs.getString("LName"));
               arrLst.add(user);
            } 
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
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        usernameText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        passwordText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        noOfBugsText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        userIdText = new javax.swing.JTextField();
        roleList = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 51));
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(33, 63, 86));

        jLabel5.setFont(new java.awt.Font("MV Boli", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("update user");

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserId", "Username", "Password", "role", "NoOfBugs", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(usersTable);

        backBtn.setBackground(new java.awt.Color(204, 204, 204));
        backBtn.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        backBtn.setForeground(new java.awt.Color(33, 63, 86));
        backBtn.setText("Back");
        backBtn.setBorderPainted(false);
        backBtn.setFocusPainted(false);
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backBtnMouseExited(evt);
            }
        });
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(204, 204, 204));
        updateBtn.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(33, 63, 86));
        updateBtn.setText("update");
        updateBtn.setBorderPainted(false);
        updateBtn.setFocusPainted(false);
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        usernameText.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        usernameText.setForeground(new java.awt.Color(204, 204, 204));
        usernameText.setText("Username");
        usernameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameTextFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("UserId");

        passwordText.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        passwordText.setForeground(new java.awt.Color(204, 204, 204));
        passwordText.setText("Password");
        passwordText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordTextFocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");

        jLabel3.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username");

        noOfBugsText.setEditable(false);
        noOfBugsText.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        noOfBugsText.setForeground(new java.awt.Color(204, 204, 204));
        noOfBugsText.setText("NoOfBugs");
        noOfBugsText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                noOfBugsTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                noOfBugsTextFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("role");

        nameText.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        nameText.setForeground(new java.awt.Color(204, 204, 204));
        nameText.setText("Name");
        nameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameTextFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NoOfBugs");

        jLabel7.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Name");

        userIdText.setEditable(false);
        userIdText.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        userIdText.setForeground(new java.awt.Color(204, 204, 204));
        userIdText.setText("UserId");
        userIdText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userIdTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userIdTextFocusLost(evt);
            }
        });

        roleList.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        roleList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "ProjectManger", "Tester", "Developer" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(usernameText, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                                    .addComponent(passwordText, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                                    .addComponent(noOfBugsText, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                                    .addComponent(nameText, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                                    .addComponent(roleList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(userIdText))))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userIdText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(roleList, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(noOfBugsText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseEntered
        backBtn.setBackground(new Color(0, 102, 102));
    }//GEN-LAST:event_backBtnMouseEntered

    private void backBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseExited
        backBtn.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_backBtnMouseExited

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void usersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersTableMouseClicked
        getUser();
        setUserData();
    }//GEN-LAST:event_usersTableMouseClicked

    private void getUser() {
        DefaultTableModel model;
        model = (DefaultTableModel) usersTable.getModel();
        int index = usersTable.getSelectedRow();
        userId = model.getValueAt(index, 0).toString();
        userName = model.getValueAt(index, 1).toString();
        password = model.getValueAt(index, 2).toString();
        role = model.getValueAt(index, 3).toString();
        noOfBugs = model.getValueAt(index, 4).toString();
        name = model.getValueAt(index, 5).toString(); 
    }
    private void setUserData() {
        userIdText.setText(userId);
        usernameText.setText(userName);
        usernameText.setForeground(new Color(0, 0, 0));
        passwordText.setText(password);
        passwordText.setForeground(new Color(0, 0, 0));
        switch (role) {
            case "Admin":
                roleList.setSelectedIndex(0);
                break;
            case "ProjectManger":
                roleList.setSelectedIndex(1);
                break;
            case "Tester":
                roleList.setSelectedIndex(2);
                break;
            case "Developer":
                roleList.setSelectedIndex(3);
        }
        noOfBugsText.setText(noOfBugs);
        nameText.setText(name);
        nameText.setForeground(new Color(0, 0, 0));
    }


    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        try {
            updateUser();
        } catch (HeadlessException | NumberFormatException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void updateUser() throws HeadlessException, NumberFormatException, SQLException, ClassNotFoundException {
        if ("UserId".equals(userIdText.getText())) {
            JOptionPane.showMessageDialog(null, "You must select a user", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (CheckUsername(usernameText.getText())) {
                JOptionPane.showMessageDialog(null, "this username is used", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                Users user = new Users(Integer.parseInt(userIdText.getText()), usernameText.getText(), passwordText.getText(),roleList.getSelectedItem().toString(),  Integer.parseInt(noOfBugsText.getText()), nameText.getText());
                Update(user);
                JOptionPane.showMessageDialog(null, "User updated", "UPDATE!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void userIdTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userIdTextFocusGained
        if (userIdText.getText().trim().equals("UserId")) {
            userIdText.setText("");
            userIdText.setForeground(Color.black);
        }
    }//GEN-LAST:event_userIdTextFocusGained

    private void userIdTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userIdTextFocusLost
        if (userIdText.getText().trim().equals("")
                || userIdText.getText().trim().equals("UserId")) {
            userIdText.setText("UserId");
            userIdText.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_userIdTextFocusLost

    private void usernameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameTextFocusLost
        if (usernameText.getText().trim().equals("")
                || usernameText.getText().trim().equals("Username")) {
            usernameText.setText("Username");
            usernameText.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_usernameTextFocusLost

    private void usernameTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameTextFocusGained
        if (usernameText.getText().trim().equals("Username")) {
            usernameText.setText("");
            usernameText.setForeground(Color.black);
        }
    }//GEN-LAST:event_usernameTextFocusGained

    private void passwordTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordTextFocusGained
        if (passwordText.getText().trim().equals("Password")) {
            passwordText.setText("");
            passwordText.setForeground(Color.black);
        }
    }//GEN-LAST:event_passwordTextFocusGained

    private void passwordTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordTextFocusLost
        if (passwordText.getText().trim().equals("")
                || passwordText.getText().trim().equals("Password")) {
            passwordText.setText("Password");
            passwordText.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_passwordTextFocusLost

    private void noOfBugsTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_noOfBugsTextFocusGained
        if (noOfBugsText.getText().trim().equals("NoOfBugs")) {
            noOfBugsText.setText("");
            noOfBugsText.setForeground(Color.black);
        }
    }//GEN-LAST:event_noOfBugsTextFocusGained

    private void noOfBugsTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_noOfBugsTextFocusLost
        if (noOfBugsText.getText().trim().equals("")
                || noOfBugsText.getText().trim().equals("NoOfBugs")) {
            noOfBugsText.setText("NoOfBugs");
            noOfBugsText.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_noOfBugsTextFocusLost

    private void nameTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameTextFocusGained
        if (nameText.getText().trim().equals("Name")) {
            nameText.setText("");
            nameText.setForeground(Color.black);
        }
    }//GEN-LAST:event_nameTextFocusGained

    private void nameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameTextFocusLost
        if (nameText.getText().trim().equals("")
                || nameText.getText().trim().equals("Name")) {
            nameText.setText("Name");
            nameText.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_nameTextFocusLost

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xPress = evt.getX();
        yPress = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        setLocation(evt.getXOnScreen() - xPress, evt.getYOnScreen() - yPress);
    }//GEN-LAST:event_formMouseDragged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserUpdater.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new UserUpdater(myUser).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextField nameText;
    public javax.swing.JTextField noOfBugsText;
    public javax.swing.JTextField passwordText;
    private javax.swing.JComboBox<String> roleList;
    private javax.swing.JButton updateBtn;
    public javax.swing.JTextField userIdText;
    public javax.swing.JTextField usernameText;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
