package project.library.desktop.Desktop_Gui;

import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
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
import project.library.desktop.service.SubjectService;
import project.library.desktop.service.TimeTypeService;
/**
 *
 * @Ulviyye Ibrahimli
 */
public class UpdateLoginFrame extends javax.swing.JFrame {

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
    private Long selectedId;
    private Login login;

    public UpdateLoginFrame() {

    }

    UpdateLoginFrame(DepartmentService departmentService,
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
            Long selectedId,
            Login login) {
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
        this.selectedId = selectedId;
        this.login = login;
        initComponents();
        this.setDefaultLookAndFeelDecorated(true);
        this.pack();
        this.setLocationRelativeTo(null);
        try {
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker().darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.brighter());
            UIManager.put("OptionPane.border.background", Color.BLUE.darker().darker().darker());
        } catch (Exception e) {
            e.printStackTrace();
        }
        roleCombo.setRenderer(new UpdateLoginFrame.TwoDecimalRenderer(roleCombo.getRenderer()));
        try {
            Login loginn = loginService.getLoginById(selectedId);
            showLoginOldData(loginn);
            showOldRoleName(loginn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        userNameTxtLbl = new javax.swing.JLabel();
        userNameTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JTextField();
        passWordTxtLbl = new javax.swing.JLabel();
        roleLbl = new javax.swing.JLabel();
        roleCombo = new javax.swing.JComboBox<>();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lNameTxt = new javax.swing.JTextField();
        fNameTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        clearBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        restoreBtn = new javax.swing.JButton();
        minimizeBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        userNameTxtLbl.setBackground(new java.awt.Color(0, 102, 102));
        userNameTxtLbl.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        userNameTxtLbl.setForeground(new java.awt.Color(255, 255, 255));
        userNameTxtLbl.setText("UserName");
        userNameTxtLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        userNameTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        userNameTxt.setForeground(new java.awt.Color(0, 102, 102));
        userNameTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userNameTxtMouseClicked(evt);
            }
        });

        passwordTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        passwordTxt.setForeground(new java.awt.Color(0, 102, 102));
        passwordTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordTxtMouseClicked(evt);
            }
        });
        passwordTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTxtActionPerformed(evt);
            }
        });

        passWordTxtLbl.setBackground(new java.awt.Color(0, 102, 102));
        passWordTxtLbl.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        passWordTxtLbl.setForeground(new java.awt.Color(255, 255, 255));
        passWordTxtLbl.setText("Password");
        passWordTxtLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        roleLbl.setBackground(new java.awt.Color(0, 102, 102));
        roleLbl.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        roleLbl.setForeground(new java.awt.Color(255, 255, 255));
        roleLbl.setText("Role");
        roleLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        roleCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        roleCombo.setForeground(new java.awt.Color(0, 102, 102));
        roleCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Role" }));
        roleCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        saveBtn.setBackground(new java.awt.Color(0, 102, 102));
        saveBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save");
        saveBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                saveBtnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                saveBtnFocusLost(evt);
            }
        });
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(0, 102, 102));
        cancelBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(204, 0, 0));
        cancelBtn.setText("Cancel");
        cancelBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cancelBtnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cancelBtnFocusLost(evt);
            }
        });
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 153));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Update Login ");

        lNameTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lNameTxt.setForeground(new java.awt.Color(0, 102, 102));
        lNameTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lNameTxtMouseClicked(evt);
            }
        });

        fNameTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        fNameTxt.setForeground(new java.awt.Color(0, 102, 102));
        fNameTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fNameTxtMouseClicked(evt);
            }
        });
        fNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fNameTxtActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 51, 51));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("First Name");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jLabel4.setBackground(new java.awt.Color(0, 51, 51));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Last Name");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        clearBtn.setBackground(new java.awt.Color(0, 102, 102));
        clearBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 0, 0));
        clearBtn.setText("Clear");
        clearBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0)));
        clearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                clearBtnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                clearBtnFocusLost(evt);
            }
        });
        clearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearBtnMouseClicked(evt);
            }
        });
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

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
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(passWordTxtLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userNameTxtLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lNameTxt)
                                    .addComponent(fNameTxt)
                                    .addComponent(userNameTxt)
                                    .addComponent(passwordTxt)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(207, 207, 207)
                                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(246, 246, 246)
                                .addComponent(roleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameTxtLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passWordTxtLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userNameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userNameTxtMouseClicked
        if (evt.getClickCount() == 2) {
            userNameTxt.setText("");
        }
    }//GEN-LAST:event_userNameTxtMouseClicked

    private void passwordTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordTxtMouseClicked
        if (evt.getClickCount() == 2) {
            passwordTxt.setText("");
        }
    }//GEN-LAST:event_passwordTxtMouseClicked

    private void passwordTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTxtActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            /*                      ALTER TABLE login
                    ADD CONSTRAINT uniq UNIQUE(user_name, password); // composite candidade key 
             */

            String userName = userNameTxt.getText();
            if ((!userName.isEmpty()) && (userName.matches("[\\p{L}\\s\\.]+"))) {
                if (userName.length() < 51) {
                    String password = passwordTxt.getText();
                    if ((!password.isEmpty()) && (!password.equals(" "))) {
                        if (password.length() > 5 && password.length() < 50) {
                            String firstName = fNameTxt.getText();
                            String lastName = lNameTxt.getText();
                            if (!roleCombo.getSelectedItem().equals("Select Role")) {
                                Item roleItem = (Item) roleCombo.getSelectedItem();
                                Long roleId = roleItem.getId();
                                Login login = new Login();
                                login.setUserName(userName);
                                login.setPassword(password);
                                login.setFirstName(firstName);
                                login.setLastName(lastName);
                                Role role = new Role();
                                role.setId(roleId);
                                login.setRole(role);
                                boolean isAddLogin = loginService.updateLogin(selectedId, login);
                                if (isAddLogin) {
                                    JOptionPane.showMessageDialog(null, "Success");
                                    saveBtn.setEnabled(false);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Fail!");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Select Role");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Length Max. 50 , Min. length 5 simbol ");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Uncorrect Password");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Length Max 50 simvol");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Uncorrect User-Name");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void lNameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lNameTxtMouseClicked
        if (evt.getClickCount() == 2) {
            lNameTxt.setText("");
        }
    }//GEN-LAST:event_lNameTxtMouseClicked

    private void fNameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fNameTxtMouseClicked
        if (evt.getClickCount() == 2) {
            fNameTxt.setText("");
        }
    }//GEN-LAST:event_fNameTxtMouseClicked

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
        AdminFrame adminFrame = new AdminFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        adminFrame.setVisible(true);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        fNameTxt.setText("");
        lNameTxt.setText("");
        userNameTxt.setText("");
        passwordTxt.setText("");
        roleCombo.setSelectedItem("Select Role");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void clearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseClicked

    }//GEN-LAST:event_clearBtnMouseClicked

    private void fNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fNameTxtActionPerformed

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

    private void closeBtnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_closeBtnKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_closeBtnKeyReleased

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

    private void clearBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clearBtnFocusGained
        clearBtn.setSize(85, 25);
    }//GEN-LAST:event_clearBtnFocusGained

    private void clearBtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clearBtnFocusLost
        clearBtn.setSize(85, 25);

    }//GEN-LAST:event_clearBtnFocusLost

    private void saveBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_saveBtnFocusGained
        saveBtn.setSize(85, 25);
    }//GEN-LAST:event_saveBtnFocusGained

    private void saveBtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_saveBtnFocusLost
        saveBtn.setSize(80, 20);

    }//GEN-LAST:event_saveBtnFocusLost

    private void cancelBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cancelBtnFocusGained
        cancelBtn.setSize(85, 25);
    }//GEN-LAST:event_cancelBtnFocusGained

    private void cancelBtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cancelBtnFocusLost
        cancelBtn.setSize(80, 20);

    }//GEN-LAST:event_cancelBtnFocusLost

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        AdminFrame adminFrame = new AdminFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        adminFrame.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JTextField fNameTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lNameTxt;
    private javax.swing.JButton minimizeBtn;
    private javax.swing.JLabel passWordTxtLbl;
    private javax.swing.JTextField passwordTxt;
    private javax.swing.JButton restoreBtn;
    private javax.swing.JComboBox<String> roleCombo;
    private javax.swing.JLabel roleLbl;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField userNameTxt;
    private javax.swing.JLabel userNameTxtLbl;
    // End of variables declaration//GEN-END:variables

    void showLoginOldData(Login login) {
        userNameTxt.setText(login.getUserName());
        passwordTxt.setText(login.getPassword());
        fNameTxt.setText(login.getFirstName());
        lNameTxt.setText(login.getLastName());
    }

    void showOldRoleName(Login login) {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) roleCombo.getModel();
            List<Role> roles = roleService.getRoles();
            for (Role role1 : roles) {
                model.addElement(new Item(role1.getId(), role1.getRoleName()));
            }
            model.setSelectedItem(new Item(login.getRole().getId(), login.getRole().getRoleName()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    class TwoDecimalRenderer extends DefaultListCellRenderer {

        private ListCellRenderer defaultRenderer;

        public TwoDecimalRenderer(ListCellRenderer defaultRenderer) {
            this.defaultRenderer = defaultRenderer;
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            Component c = defaultRenderer.getListCellRendererComponent(list, value,
                    index, isSelected, cellHasFocus);
            if (c instanceof JLabel) {
                if (isSelected) {
                    c.setBackground(Color.BLUE.GREEN.darker().darker().darker().darker());
                    c.setForeground(Color.WHITE);
                } else {
                    c.setBackground(Color.WHITE);
                }
            } else {
                c.setBackground(Color.WHITE);
                c = super.getListCellRendererComponent(list, value, index, isSelected,
                        cellHasFocus);
            }
            return c;
        }
    }
}
