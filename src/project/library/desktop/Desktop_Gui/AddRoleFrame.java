package project.library.desktop.Desktop_Gui;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import project.library.desktop.model.Login;
import project.library.desktop.model.Role;
import project.library.desktop.service.AuthorService;
import project.library.desktop.service.BookRoomService;
import project.library.desktop.service.BookService;
import project.library.desktop.service.BookShelfService;
import project.library.desktop.service.BranchService;
import project.library.desktop.service.DepartmentService;
import project.library.desktop.service.EducationTypeService;
import project.library.desktop.service.EmployeeService;
import project.library.desktop.service.GiveBackBookService;
import project.library.desktop.service.LanguageService;
import project.library.desktop.service.LoginService;
import project.library.desktop.service.OrderInHomeService;
import project.library.desktop.service.OrderInLibService;
import project.library.desktop.service.PositionService;
import project.library.desktop.service.ReadRoomService;
import project.library.desktop.service.ReadTableService;
import project.library.desktop.service.ReaderService;
import project.library.desktop.service.RoleService;
import project.library.desktop.service.StatusService;
import project.library.desktop.service.SubjectService;
import project.library.desktop.service.TimeTypeService;

/**
 *
 * @Ulviyye Ibrahimli
 */
public class AddRoleFrame extends javax.swing.JFrame {

    private DepartmentService departmentService;
    private PositionService positionService;
    private BranchService branchService;
    private EmployeeService employeeService;
    private TimeTypeService timeTypeService;
    private EducationTypeService educationTypeService;
    private BookService bookService;
    private AuthorService authorService;
    private SubjectService subjectService;
    private BookShelfService bookShelfService;
    private BookRoomService bookRoomService;
    private ReadRoomService readRoomService;
    private ReadTableService readTableService;
    private LanguageService languageService;
    private ReaderService readerService;
    private OrderInLibService orderInLibService;
    private OrderInHomeService orderInHomeService;
    private GiveBackBookService giveBackBookService;
    private LoginService loginService;
    private RoleService roleService;
    private Login login;
    private StatusService statusService;

    public AddRoleFrame() {
        initComponents();
    }

    AddRoleFrame(DepartmentService departmentService,
            PositionService positionService,
            BranchService branchService,
            EmployeeService employeeService,
            TimeTypeService timeTypeService,
            EducationTypeService educationTypeService,
            BookService bookService,
            AuthorService authorService,
            SubjectService subjectService,
            BookShelfService bookShelfService,
            BookRoomService bookRoomService,
            ReadRoomService readRoomService,
            ReadTableService readTableService,
            LanguageService languageService,
            ReaderService readerService,
            OrderInLibService orderInLibService,
            OrderInHomeService orderInHomeService,
            GiveBackBookService giveBackBookService,
            LoginService loginService,
            RoleService roleService,
            Login login,
            StatusService statusService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
        this.branchService = branchService;
        this.positionService = positionService;
        this.timeTypeService = timeTypeService;
        this.educationTypeService = educationTypeService;
        this.bookService = bookService;
        this.authorService = authorService;
        this.subjectService = subjectService;
        this.bookShelfService = bookShelfService;
        this.bookRoomService = bookRoomService;
        this.readRoomService = readRoomService;
        this.readTableService = readTableService;
        this.languageService = languageService;
        this.readerService = readerService;
        this.orderInLibService = orderInLibService;
        this.orderInHomeService = orderInHomeService;
        this.giveBackBookService = giveBackBookService;
        this.loginService = loginService;
        this.roleService = roleService;
        this.login = login;
        this.statusService=statusService;
        initComponents();
        this.setDefaultLookAndFeelDecorated(true);
        this.pack();
        this.setLocationRelativeTo(null);
        try {
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker().darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker().darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.brighter());
            UIManager.put("OptionPane.border.background", Color.BLUE.darker().darker().darker().darker());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        roleNameTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTxt = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        closeBtn = new javax.swing.JButton();
        restoreBtn = new javax.swing.JButton();
        minimizeBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setBackground(new java.awt.Color(0, 51, 51));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Role");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        roleNameTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        roleNameTxt.setForeground(new java.awt.Color(0, 102, 102));

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Description");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        descriptionTxt.setColumns(20);
        descriptionTxt.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        descriptionTxt.setForeground(new java.awt.Color(0, 102, 102));
        descriptionTxt.setRows(5);
        jScrollPane1.setViewportView(descriptionTxt);

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Clear");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jButton1FocusLost(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Save");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jButton2FocusLost(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cancelbtn.setBackground(new java.awt.Color(0, 102, 102));
        cancelbtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cancelbtn.setForeground(new java.awt.Color(255, 0, 0));
        cancelbtn.setText("Cancel");
        cancelbtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        cancelbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelbtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cancelbtnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cancelbtnFocusLost(evt);
            }
        });
        cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbtnActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 0, 153));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Add Role");

        closeBtn.setBackground(new java.awt.Color(153, 0, 0));
        closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/close.png"))); // NOI18N
        closeBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                closeBtnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                closeBtnFocusLost(evt);
            }
        });
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });
        closeBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                closeBtnKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                closeBtnKeyReleased(evt);
            }
        });

        restoreBtn.setBackground(new java.awt.Color(51, 102, 255));
        restoreBtn.setForeground(new java.awt.Color(255, 255, 255));
        restoreBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-restore-window-32.png"))); // NOI18N
        restoreBtn.setBorder(null);
        restoreBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                restoreBtnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                restoreBtnFocusLost(evt);
            }
        });
        restoreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreBtnActionPerformed(evt);
            }
        });
        restoreBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                restoreBtnKeyPressed(evt);
            }
        });

        minimizeBtn.setBackground(new java.awt.Color(51, 102, 255));
        minimizeBtn.setForeground(new java.awt.Color(153, 0, 0));
        minimizeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-minimize-window-48.png"))); // NOI18N
        minimizeBtn.setBorder(null);
        minimizeBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                minimizeBtnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                minimizeBtnFocusLost(evt);
            }
        });
        minimizeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeBtnMouseClicked(evt);
            }
        });
        minimizeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeBtnActionPerformed(evt);
            }
        });

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-undo-24.png"))); // NOI18N
        backBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                backBtnFocusGained(evt);
            }
        });
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(176, 176, 176)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roleNameTxt)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192)
                        .addComponent(cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roleNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String roleName = roleNameTxt.getText();
            String desc = descriptionTxt.getText();
            Role role = new Role();
            role.setRoleName(roleName);
            role.setDescription(desc);
            boolean isAddRole = roleService.addRole(role);
            if (isAddRole) {
                JOptionPane.showMessageDialog(null, "Role Added");
                jButton2.setEnabled(false);
                jButton1.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Fail!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        roleNameTxt.setText("");
        descriptionTxt.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed
        this.dispose();
        AdminFrame adminFrame = new AdminFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login,statusService);
        adminFrame.setVisible(true);
    }//GEN-LAST:event_cancelbtnActionPerformed

    private void closeBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_closeBtnFocusGained
        closeBtn.setSize(40, 28);
    }//GEN-LAST:event_closeBtnFocusGained

    private void closeBtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_closeBtnFocusLost
        closeBtn.setSize(37, 25);
    }//GEN-LAST:event_closeBtnFocusLost

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE, TO CLOSE THE PROGRAM ?");
        if (choose == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_closeBtnActionPerformed

    private void closeBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_closeBtnKeyPressed

    }//GEN-LAST:event_closeBtnKeyPressed

    private void restoreBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_restoreBtnFocusGained
        restoreBtn.setSize(35, 28);
    }//GEN-LAST:event_restoreBtnFocusGained

    private void restoreBtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_restoreBtnFocusLost
        restoreBtn.setSize(31, 25);
    }//GEN-LAST:event_restoreBtnFocusLost

    private void restoreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreBtnActionPerformed
        if (getExtendedState() == NORMAL) {
            setExtendedState(MAXIMIZED_BOTH);
            setResizable(true);
        } else {
            setExtendedState(NORMAL);
            this.pack();
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_restoreBtnActionPerformed

    private void restoreBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_restoreBtnKeyPressed

    }//GEN-LAST:event_restoreBtnKeyPressed

    private void minimizeBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_minimizeBtnFocusGained
        minimizeBtn.setSize(35, 28);
    }//GEN-LAST:event_minimizeBtnFocusGained

    private void minimizeBtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_minimizeBtnFocusLost
        minimizeBtn.setSize(30, 25);
    }//GEN-LAST:event_minimizeBtnFocusLost

    private void minimizeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtnMouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_minimizeBtnMouseClicked

    private void minimizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeBtnActionPerformed
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_minimizeBtnActionPerformed

    private void backBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_backBtnFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_backBtnFocusGained

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        roleNameTxt.setText("");
        descriptionTxt.setText("");
    }//GEN-LAST:event_jButton1KeyPressed

    private void closeBtnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_closeBtnKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_closeBtnKeyReleased

    private void jButton1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton1FocusGained
        jButton1.setSize(85, 25);
    }//GEN-LAST:event_jButton1FocusGained

    private void jButton1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton1FocusLost
        jButton1.setSize(80, 20);

    }//GEN-LAST:event_jButton1FocusLost

    private void jButton2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton2FocusGained
        jButton2.setSize(85, 25);
    }//GEN-LAST:event_jButton2FocusGained

    private void jButton2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton2FocusLost
        jButton2.setSize(85, 25);

    }//GEN-LAST:event_jButton2FocusLost

    private void cancelbtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cancelbtnFocusGained
        cancelbtn.setSize(85, 25);
    }//GEN-LAST:event_cancelbtnFocusGained

    private void cancelbtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cancelbtnFocusLost
        cancelbtn.setSize(80, 20);

    }//GEN-LAST:event_cancelbtnFocusLost

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        AdminFrame adminFrame = new AdminFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login,statusService);
        adminFrame.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton cancelbtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JTextArea descriptionTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton minimizeBtn;
    private javax.swing.JButton restoreBtn;
    private javax.swing.JTextField roleNameTxt;
    // End of variables declaration//GEN-END:variables
}
