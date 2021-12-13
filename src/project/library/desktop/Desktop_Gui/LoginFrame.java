package project.library.desktop.Desktop_Gui;

import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import project.library.desktop.DesktopGui.hr.HrFrame1;
import project.library.desktop.book.BookFristFrame;
import project.library.desktop.model.Login;
import project.library.desktop.order.OrderInfoFrame;
import project.library.desktop.reader.ReaderFirstFrame;
import project.library.desktop.service.AuthorService;
import project.library.desktop.service.BookRoomService;
import project.library.desktop.service.BookService;
import project.library.desktop.service.BranchService;
import project.library.desktop.service.DepartmentService;
import project.library.desktop.service.EducationTypeService;
import project.library.desktop.service.EmployeeService;
import project.library.desktop.service.PositionService;
import project.library.desktop.service.BookShelfService;
import project.library.desktop.service.GiveBackBookService;
import project.library.desktop.service.LanguageService;
import project.library.desktop.service.LoginService;
import project.library.desktop.service.OrderInHomeService;
import project.library.desktop.service.OrderInLibService;
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
public class LoginFrame extends javax.swing.JFrame {
    
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
    
    public LoginFrame() {
        initComponents();
    }
    
    public LoginFrame(DepartmentService departmentService,
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
            RoleService roleService) {
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
        initComponents();
        this.setDefaultLookAndFeelDecorated(true);
        this.setLocationRelativeTo(null);
        this.pack();
        userNameTxt.setFocusable(true);
        InputMap im = (InputMap) UIManager.get("Button.focusInputMap");
        im.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
        im.put(KeyStroke.getKeyStroke("released ENTER"), "released");
        KeyStroke tab = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0);
        KeyStroke ctrlTab = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, KeyEvent.CTRL_DOWN_MASK);
        Set<KeyStroke> keys = new HashSet<>();
        keys.add(tab);
        keys.add(ctrlTab);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().setDefaultFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, keys);
        try {
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.darker().darker());
            UIManager.put("OptionPane.border.background", Color.BLUE.darker().darker());
        } catch (Exception e) {
            e.printStackTrace();
        }
        warningTxt.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userNameTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        logBtn = new javax.swing.JButton();
        passwordTxt = new javax.swing.JPasswordField();
        warningTxt = new javax.swing.JLabel();
        closeBtn = new javax.swing.JButton();
        restoreBtn = new javax.swing.JButton();
        minimizeBtn = new javax.swing.JButton();
        showPas = new javax.swing.JCheckBox();
        clearBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 255), 2, true));

        jLabel5.setBackground(new java.awt.Color(0, 0, 255));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("User Name");

        jLabel2.setBackground(new java.awt.Color(0, 0, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("USER LOGIN");

        userNameTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        userNameTxt.setForeground(new java.awt.Color(0, 0, 153));
        userNameTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userNameTxtFocusGained(evt);
            }
        });
        userNameTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userNameTxtMouseClicked(evt);
            }
        });
        userNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTxtActionPerformed(evt);
            }
        });
        userNameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userNameTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userNameTxtKeyReleased(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 255));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Password");

        logBtn.setBackground(new java.awt.Color(0, 0, 153));
        logBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        logBtn.setForeground(new java.awt.Color(255, 255, 255));
        logBtn.setText("Sign in");
        logBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 255), new java.awt.Color(0, 102, 255), new java.awt.Color(0, 102, 255), new java.awt.Color(0, 102, 255)));
        logBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                logBtnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                logBtnFocusLost(evt);
            }
        });
        logBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logBtnActionPerformed(evt);
            }
        });
        logBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                logBtnKeyPressed(evt);
            }
        });

        passwordTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        passwordTxt.setForeground(new java.awt.Color(0, 0, 153));
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
        passwordTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordTxtKeyReleased(evt);
            }
        });

        warningTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        warningTxt.setForeground(new java.awt.Color(255, 0, 0));

        closeBtn.setBackground(new java.awt.Color(153, 0, 0));
        closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/close.png"))); // NOI18N
        closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        });

        restoreBtn.setBackground(new java.awt.Color(51, 102, 255));
        restoreBtn.setForeground(new java.awt.Color(255, 255, 255));
        restoreBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-restore-window-32.png"))); // NOI18N
        restoreBtn.setBorder(null);
        restoreBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        minimizeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        showPas.setBackground(new java.awt.Color(0, 0, 204));
        showPas.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        showPas.setForeground(new java.awt.Color(255, 255, 255));
        showPas.setText("Show Password");
        showPas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showPas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasActionPerformed(evt);
            }
        });
        showPas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                showPasKeyPressed(evt);
            }
        });

        clearBtn.setBackground(new java.awt.Color(0, 0, 153));
        clearBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 0, 0));
        clearBtn.setText("Clear");
        clearBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 255), new java.awt.Color(0, 102, 255), new java.awt.Color(0, 102, 255), new java.awt.Color(0, 102, 255)));
        clearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                clearBtnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                clearBtnFocusLost(evt);
            }
        });
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        clearBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                clearBtnKeyPressed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(0, 0, 153));
        cancelBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 0, 0));
        cancelBtn.setText("Cancel");
        cancelBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 255), new java.awt.Color(0, 102, 255), new java.awt.Color(0, 102, 255), new java.awt.Color(0, 102, 255)));
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
        cancelBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cancelBtnKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LIBRARY MANAGMEN SYSTEM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(93, 93, 93)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showPas)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(passwordTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(userNameTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(75, 75, 75)
                                    .addComponent(logBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(75, 75, 75)
                                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(warningTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showPas)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(warningTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
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

    private void logBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logBtnActionPerformed
        loginOP();// ancaq enter baglamaq
    }//GEN-LAST:event_logBtnActionPerformed

    private void userNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTxtActionPerformed
        warningTxt.setVisible(false);
    }//GEN-LAST:event_userNameTxtActionPerformed

    private void userNameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameTxtKeyPressed
        warningTxt.setVisible(false);

    }//GEN-LAST:event_userNameTxtKeyPressed

    private void userNameTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameTxtKeyReleased
        warningTxt.setVisible(false);

    }//GEN-LAST:event_userNameTxtKeyReleased

    private void userNameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userNameTxtMouseClicked
        warningTxt.setVisible(false);
        userNameTxt.setText("");

    }//GEN-LAST:event_userNameTxtMouseClicked

    private void passwordTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTxtActionPerformed
        warningTxt.setVisible(false);

    }//GEN-LAST:event_passwordTxtActionPerformed

    private void passwordTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTxtKeyPressed
        warningTxt.setVisible(false);

    }//GEN-LAST:event_passwordTxtKeyPressed

    private void passwordTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTxtKeyReleased
        warningTxt.setVisible(false);

    }//GEN-LAST:event_passwordTxtKeyReleased

    private void passwordTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordTxtMouseClicked
        warningTxt.setVisible(false);
        passwordTxt.setText("");
    }//GEN-LAST:event_passwordTxtMouseClicked

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE, TO CLOSE THE PROGRAM ?");
        if (choose == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_closeBtnActionPerformed

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

    private void minimizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeBtnActionPerformed
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_minimizeBtnActionPerformed

    private void showPasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasActionPerformed
        if (showPas.isSelected()) {
            passwordTxt.setEchoChar((char) 0);
        } else {
            passwordTxt.setEchoChar('*');
        }
    }//GEN-LAST:event_showPasActionPerformed

    private void logBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_logBtnKeyPressed
        loginOP();
    }//GEN-LAST:event_logBtnKeyPressed

    private void closeBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_closeBtnFocusGained
        closeBtn.setSize(40, 28);
    }//GEN-LAST:event_closeBtnFocusGained

    private void closeBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_closeBtnKeyPressed

    }//GEN-LAST:event_closeBtnKeyPressed

    private void restoreBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_restoreBtnKeyPressed

    }//GEN-LAST:event_restoreBtnKeyPressed

    private void minimizeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtnMouseClicked

    }//GEN-LAST:event_minimizeBtnMouseClicked

    private void minimizeBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_minimizeBtnFocusGained
        minimizeBtn.setSize(35, 28);
    }//GEN-LAST:event_minimizeBtnFocusGained

    private void minimizeBtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_minimizeBtnFocusLost
        minimizeBtn.setSize(30, 25);
    }//GEN-LAST:event_minimizeBtnFocusLost

    private void restoreBtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_restoreBtnFocusLost
        restoreBtn.setSize(31, 25);
    }//GEN-LAST:event_restoreBtnFocusLost

    private void restoreBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_restoreBtnFocusGained
        restoreBtn.setSize(35, 28);
    }//GEN-LAST:event_restoreBtnFocusGained

    private void closeBtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_closeBtnFocusLost
        closeBtn.setSize(37, 25);
    }//GEN-LAST:event_closeBtnFocusLost

    private void logBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_logBtnFocusGained
        logBtn.setSize(115, 38);
        logBtn.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_logBtnFocusGained

    private void logBtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_logBtnFocusLost
        logBtn.setSize(110, 33);
        logBtn.setForeground(Color.WHITE);
    }//GEN-LAST:event_logBtnFocusLost

    private void showPasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_showPasKeyPressed
        if (showPas.isSelected()) {
            passwordTxt.setEchoChar((char) 0);
        } else {
            passwordTxt.setEchoChar('*');
        }
    }//GEN-LAST:event_showPasKeyPressed

    private void userNameTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userNameTxtFocusGained

    }//GEN-LAST:event_userNameTxtFocusGained

    private void clearBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clearBtnFocusGained
        clearBtn.setSize(112, 37);
    }//GEN-LAST:event_clearBtnFocusGained

    private void clearBtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clearBtnFocusLost
        clearBtn.setSize(110, 35);
    }//GEN-LAST:event_clearBtnFocusLost

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        userNameTxt.setText("");
        passwordTxt.setText("");
        passwordTxt.setEchoChar('*');
    }//GEN-LAST:event_clearBtnActionPerformed

    private void clearBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clearBtnKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearBtnKeyPressed

    private void cancelBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cancelBtnFocusGained
        cancelBtn.setSize(112, 37);
    }//GEN-LAST:event_cancelBtnFocusGained

    private void cancelBtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cancelBtnFocusLost
        clearBtn.setSize(110, 35);    }//GEN-LAST:event_cancelBtnFocusLost

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void cancelBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelBtnKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelBtnKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logBtn;
    private javax.swing.JButton minimizeBtn;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JButton restoreBtn;
    private javax.swing.JCheckBox showPas;
    private javax.swing.JTextField userNameTxt;
    private javax.swing.JLabel warningTxt;
    // End of variables declaration//GEN-END:variables

    void loginOP() {
        try {
            String userName = userNameTxt.getText();
            String password = passwordTxt.getText();
            String roleName = roleService.getRoleName(userName, password);
            if (roleName != null) {
                if ((userName != null) && (!userName.isEmpty())) {
                    if ((password != null) && (!password.isEmpty())) {
                        Login login = loginService.checkLogin(userName, password, roleName);
                        if (login != null) {
                            userNameTxt.setText("");
                            passwordTxt.setText("");
                            if (roleName.equals("Library Assistant III")) {
                                this.dispose();
                                OrderInfoFrame orderInfoFrame = new OrderInfoFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
                                orderInfoFrame.setVisible(true);
                            } else if (roleName.equals("Library Assistant II")) {
                                this.dispose();
                                BookFristFrame bookFristFrame = new BookFristFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
                                bookFristFrame.setVisible(true);
                            } else if (roleName.equals("Human-resurs")) {
                                this.dispose();
                                HrFrame1 frame1 = new HrFrame1(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
                                frame1.setVisible(true);
                            } else if (roleName.equals("Library Assistant IV")) {
                                this.dispose();
                                ReaderFirstFrame firstFrame = new ReaderFirstFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
                                firstFrame.setVisible(true);
                            } else if (roleName.equals("Library Assistant V")) {
                                this.dispose();
                                OrderInfoFrame orderInfoFrame = new OrderInfoFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
                                orderInfoFrame.setVisible(true);
                            } else if (roleName.equals("Security")) {
                                this.dispose();
                                SecurityFrame securityFrame = new SecurityFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
                                securityFrame.setVisible(true);
                                //.. if to want , be add
                            } else if (roleName.equals("Admin")
                                    || roleName.equals("Director")
                                    || roleName.equals("Library Assistant")
                                    || roleName.equals("Deputy")
                                    || roleName.equals("Library Assistant I")) {
                                this.dispose();
                                DispatcherFrame dispatcherFrame = new DispatcherFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, roleName, login);
                                dispatcherFrame.setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "Your role has not been clarified yet !");
                            }
                        } else {
                            warningTxt.setVisible(true);
                            warningTxt.setText("USERNAME OR PASSWORD IS INVALID");
                            
                        }
                    } else {
                        warningTxt.setVisible(true);
                        warningTxt.setText("PASSWORD IS EMPTY");
                    }
                } else {
                    warningTxt.setVisible(true);
                    warningTxt.setText("USERNAME IS EMPTY");
                }
            } else {
                warningTxt.setVisible(true);
                warningTxt.setText("USERNAME OR PASSWORD IS INVALID");
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
