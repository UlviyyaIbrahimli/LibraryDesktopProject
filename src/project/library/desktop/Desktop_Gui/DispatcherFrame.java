package project.library.desktop.Desktop_Gui;

import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;
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
public class DispatcherFrame extends javax.swing.JFrame {

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
    String roleName;

    public DispatcherFrame() {
        initComponents();
    }

    DispatcherFrame(DepartmentService departmentService,
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
            String roleName,
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
        this.roleName = roleName;
        this.login = login;
        initComponents();
        this.setDefaultLookAndFeelDecorated(true);
        this.pack();
        this.setLocationRelativeTo(null);
        userNameTxt.setText("WELCOME,  " + login.getFirstName().toUpperCase() + "  " + login.getLastName().toUpperCase());
        jPanel1.getInputMap().put(KeyStroke.getKeyStroke("Enter"),
                "doNothing");
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
        grant(roleName);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        hrBtn = new javax.swing.JButton();
        bookBtn = new javax.swing.JButton();
        readerBtn = new javax.swing.JButton();
        orderBtn = new javax.swing.JButton();
        adminBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        restoreBtn = new javax.swing.JButton();
        minimizeBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        userNameTxt = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 153));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dispatcher Page");

        hrBtn.setBackground(new java.awt.Color(0, 0, 153));
        hrBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        hrBtn.setForeground(new java.awt.Color(255, 255, 255));
        hrBtn.setText("HUMAN RESURS");
        hrBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));
        hrBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hrBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hrBtnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                hrBtnFocusLost(evt);
            }
        });
        hrBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hrBtnActionPerformed(evt);
            }
        });
        hrBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                hrBtnKeyPressed(evt);
            }
        });

        bookBtn.setBackground(new java.awt.Color(0, 0, 153));
        bookBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bookBtn.setForeground(new java.awt.Color(255, 255, 255));
        bookBtn.setText("BOOK MANAGMENT");
        bookBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));
        bookBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bookBtnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bookBtnFocusLost(evt);
            }
        });
        bookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookBtnActionPerformed(evt);
            }
        });

        readerBtn.setBackground(new java.awt.Color(0, 0, 153));
        readerBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        readerBtn.setForeground(new java.awt.Color(255, 255, 255));
        readerBtn.setText("READER MANAGMENT");
        readerBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));
        readerBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        readerBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                readerBtnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                readerBtnFocusLost(evt);
            }
        });
        readerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readerBtnActionPerformed(evt);
            }
        });

        orderBtn.setBackground(new java.awt.Color(0, 0, 153));
        orderBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        orderBtn.setForeground(new java.awt.Color(255, 255, 255));
        orderBtn.setText("ORDER MANAGMENT");
        orderBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));
        orderBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        orderBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                orderBtnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                orderBtnFocusLost(evt);
            }
        });
        orderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderBtnActionPerformed(evt);
            }
        });

        adminBtn.setBackground(new java.awt.Color(0, 0, 153));
        adminBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        adminBtn.setForeground(new java.awt.Color(255, 255, 255));
        adminBtn.setText("ADMIN");
        adminBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));
        adminBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adminBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adminBtnFocusGained(evt);
            }
        });
        adminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminBtnActionPerformed(evt);
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

        userNameTxt.setEditable(false);
        userNameTxt.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(adminBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    .addComponent(orderBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(readerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bookBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hrBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(140, 140, 140))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(userNameTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hrBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(bookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(readerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(orderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(adminBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hrBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hrBtnActionPerformed
        this.dispose();
        HrFrame1 frame1 = new HrFrame1(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        frame1.setVisible(true);
    }//GEN-LAST:event_hrBtnActionPerformed

    private void bookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookBtnActionPerformed
        this.dispose();
        BookFristFrame bookFristFrame = new BookFristFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        bookFristFrame.setVisible(true);
    }//GEN-LAST:event_bookBtnActionPerformed

    private void readerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readerBtnActionPerformed
        this.dispose();
        ReaderFirstFrame firstFrame = new ReaderFirstFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        firstFrame.setVisible(true);
    }//GEN-LAST:event_readerBtnActionPerformed

    private void orderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderBtnActionPerformed
        this.dispose();
        OrderInfoFrame infoFrame = new OrderInfoFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        infoFrame.setVisible(true);
    }//GEN-LAST:event_orderBtnActionPerformed

    private void adminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminBtnActionPerformed
        this.dispose();
        AdminFrame adminFrame = new AdminFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        adminFrame.setVisible(true);
    }//GEN-LAST:event_adminBtnActionPerformed

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

    private void hrBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hrBtnFocusGained
        hrBtn.setSize(351, 42);
    }//GEN-LAST:event_hrBtnFocusGained

    private void bookBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bookBtnFocusGained

    }//GEN-LAST:event_bookBtnFocusGained

    private void readerBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_readerBtnFocusGained
        readerBtn.setSize(351, 42);
    }//GEN-LAST:event_readerBtnFocusGained

    private void orderBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_orderBtnFocusGained
        orderBtn.setSize(351, 42);
    }//GEN-LAST:event_orderBtnFocusGained

    private void adminBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adminBtnFocusGained
        adminBtn.setSize(351, 42);
    }//GEN-LAST:event_adminBtnFocusGained

    private void hrBtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hrBtnFocusLost
        hrBtn.setSize(346, 39);
    }//GEN-LAST:event_hrBtnFocusLost

    private void bookBtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bookBtnFocusLost
    }//GEN-LAST:event_bookBtnFocusLost

    private void readerBtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_readerBtnFocusLost
        readerBtn.setSize(346, 39);    }//GEN-LAST:event_readerBtnFocusLost

    private void orderBtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_orderBtnFocusLost
        orderBtn.setSize(346, 39);
    }//GEN-LAST:event_orderBtnFocusLost

    private void backBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_backBtnFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_backBtnFocusGained

    private void hrBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hrBtnKeyPressed

    }//GEN-LAST:event_hrBtnKeyPressed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        LoginFrame loginFrame = new LoginFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService);
        loginFrame.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton bookBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JButton hrBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton minimizeBtn;
    private javax.swing.JButton orderBtn;
    private javax.swing.JButton readerBtn;
    private javax.swing.JButton restoreBtn;
    private javax.swing.JTextField userNameTxt;
    // End of variables declaration//GEN-END:variables
  
    
    
    void grant(String roleName) {
        if (roleName.equals("admin")) {
            adminBtn.setVisible(true);
            hrBtn.setVisible(true);
            bookBtn.setVisible(true);
            readerBtn.setVisible(true);
            orderBtn.setVisible(true);
        } else if (roleName.equals("Director")) {
            hrBtn.setVisible(true);
            bookBtn.setVisible(true);
            readerBtn.setVisible(true);
            orderBtn.setVisible(true);
            adminBtn.setVisible(false);
        } else if (roleName.equals("Library Assistant")) {
            bookBtn.setVisible(true);
            readerBtn.setVisible(true);
            hrBtn.setVisible(false);
            orderBtn.setVisible(true);
            adminBtn.setVisible(false);
        } else if (roleName.equals("Deputy")) {
            bookBtn.setVisible(true);
            readerBtn.setVisible(true);
            hrBtn.setVisible(true);
            orderBtn.setVisible(true);
            adminBtn.setVisible(false);
        } else if (roleName.equals("Library Assistant I")) {
            bookBtn.setVisible(true);
            readerBtn.setVisible(true);
            hrBtn.setVisible(false);
            orderBtn.setVisible(false);
            adminBtn.setVisible(false);
        }
    }
}
