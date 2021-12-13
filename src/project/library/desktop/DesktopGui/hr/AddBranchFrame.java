package project.library.desktop.DesktopGui.hr;

import java.awt.*;
import java.util.List;
import java.util.Date;
import javax.swing.*;
import project.library.desktop.Desktop_Gui.Item;
import project.library.desktop.model.Login;
import project.library.desktop.model.employee.*;
import project.library.desktop.service.*;

/**
 *
 * @Ulviyye Ibrahimli
 */
public class AddBranchFrame extends javax.swing.JFrame {

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

    public AddBranchFrame() {
        initComponents();
    }

    AddBranchFrame(DepartmentService departmentService,
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
        this.login = login;
        initComponents();
        showDepartmentCombo();
        this.getContentPane().setBackground(Color.BLUE.darker().darker());
        this.setDefaultLookAndFeelDecorated(true);
        this.pack();
        this.setLocationRelativeTo(null);
        userTxt.setText("Welcome, " + login.getFirstName() + " " + login.getLastName() + " !");
        departmentCmb.setRenderer(new AddBranchFrame.TwoDecimalRenderer(departmentCmb.getRenderer()));
        try {
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.darker().darker());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinField1 = new com.toedter.components.JSpinField();
        jPanel4 = new javax.swing.JPanel();
        minimizeBtn2 = new javax.swing.JButton();
        restoreBtn2 = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        branchtitleTxt = new javax.swing.JTextField();
        phoneBrTxt = new javax.swing.JTextField();
        emailBrTxt = new javax.swing.JTextField();
        assetsBrTxt = new javax.swing.JTextField();
        addressBrTxt = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        departmentCmb = new javax.swing.JComboBox<>();
        fondationCalendar = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        userTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel4.setBackground(new java.awt.Color(0, 0, 153));
        jPanel4.setForeground(new java.awt.Color(0, 0, 102));

        minimizeBtn2.setBackground(new java.awt.Color(51, 102, 255));
        minimizeBtn2.setForeground(new java.awt.Color(153, 0, 0));
        minimizeBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-minimize-window-48.png"))); // NOI18N
        minimizeBtn2.setBorder(null);
        minimizeBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeBtn2ActionPerformed(evt);
            }
        });

        restoreBtn2.setBackground(new java.awt.Color(51, 102, 255));
        restoreBtn2.setForeground(new java.awt.Color(255, 255, 255));
        restoreBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-restore-window-32.png"))); // NOI18N
        restoreBtn2.setBorder(null);
        restoreBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreBtn2ActionPerformed(evt);
            }
        });

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-undo-24.png"))); // NOI18N
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 0, 0));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/close.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel30.setBackground(new java.awt.Color(0, 0, 153));
        jLabel30.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("ADD BRANCH ");

        jPanel6.setBackground(new java.awt.Color(0, 0, 153));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Branch  Name");
        jLabel22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Phone");
        jLabel23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Email");
        jLabel25.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Assets");
        jLabel26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Address");
        jLabel27.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Foundation Date");
        jLabel28.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));

        branchtitleTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        branchtitleTxt.setForeground(new java.awt.Color(0, 0, 153));
        branchtitleTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                branchtitleTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                branchtitleTxtMouseEntered(evt);
            }
        });
        branchtitleTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchtitleTxtActionPerformed(evt);
            }
        });
        branchtitleTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                branchtitleTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                branchtitleTxtKeyReleased(evt);
            }
        });

        phoneBrTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        phoneBrTxt.setForeground(new java.awt.Color(0, 0, 153));
        phoneBrTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phoneBrTxtMouseClicked(evt);
            }
        });
        phoneBrTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneBrTxtActionPerformed(evt);
            }
        });

        emailBrTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        emailBrTxt.setForeground(new java.awt.Color(0, 0, 153));
        emailBrTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emailBrTxtMouseClicked(evt);
            }
        });
        emailBrTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailBrTxtActionPerformed(evt);
            }
        });
        emailBrTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailBrTxtKeyPressed(evt);
            }
        });

        assetsBrTxt.setForeground(new java.awt.Color(0, 0, 153));
        assetsBrTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                assetsBrTxtMouseClicked(evt);
            }
        });
        assetsBrTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assetsBrTxtActionPerformed(evt);
            }
        });
        assetsBrTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                assetsBrTxtKeyPressed(evt);
            }
        });

        addressBrTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        addressBrTxt.setForeground(new java.awt.Color(0, 0, 102));
        addressBrTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addressBrTxtMouseClicked(evt);
            }
        });
        addressBrTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressBrTxtActionPerformed(evt);
            }
        });

        saveBtn.setBackground(new java.awt.Color(0, 0, 204));
        saveBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("SAVE");
        saveBtn.setBorder(null);
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Department");
        jLabel29.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));

        departmentCmb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        departmentCmb.setForeground(new java.awt.Color(0, 0, 51));
        departmentCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Department" }));
        departmentCmb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        departmentCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        departmentCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentCmbActionPerformed(evt);
            }
        });

        fondationCalendar.setForeground(new java.awt.Color(0, 0, 153));

        jButton1.setBackground(new java.awt.Color(153, 0, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CANCEL");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        clearBtn.setBackground(new java.awt.Color(102, 0, 0));
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("CLEAR");
        clearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(assetsBrTxt))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(277, 277, 277)
                        .addComponent(departmentCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(addressBrTxt))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(277, 277, 277)
                                .addComponent(fondationCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(195, 195, 195)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneBrTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailBrTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(branchtitleTxt, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(44, 44, 44))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(branchtitleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneBrTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailBrTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(assetsBrTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressBrTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fondationCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departmentCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        userTxt.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(minimizeBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restoreBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimizeBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            Branch branch = new Branch();
            String branchName = branchtitleTxt.getText();
            Date foundate = fondationCalendar.getDate();
            String email = emailBrTxt.getText();
            String phone = phoneBrTxt.getText();
            String assets = assetsBrTxt.getText();
            String address = addressBrTxt.getText();
            branch.setPhone(phone);
            branch.setAddress(address);
            if (!(branchName.isEmpty())) {
                if (branchName.length() <= 25) {
                    if (branchName.matches("[\\p{L}0-9\\s\\-\\_]+")) {
                        branch.setBranchName(branchName);
                        if (email.contains("@") && (!email.contains(",")) && (!(email.contains(" ")))) {
                            branch.seteMail(email);
                            if (assets.matches("[0-9]+(\\.[0-9]+)?")) {
                                branch.setAssets(Float.parseFloat(assets));
                                if (!(foundate == null)) {
                                    branch.setFoundate(foundate);
                                    if (departmentCmb.getSelectedIndex() > 0) {
                                        Item departmentItem = (Item) departmentCmb.getSelectedItem();
                                        boolean check = chekBranchNameUnique(branchName, departmentItem.getId());
                                        if (check) {
                                            Department department = new Department();
                                            department.setId(departmentItem.getId());
                                            branch.setDepartment(department);
                                            boolean isAddDepartment = branchService.addBranch(branch);
                                            if (isAddDepartment) {
                                                JOptionPane.showMessageDialog(null, "BRANCH IS ADDED SUCCESSFULLY ", "SUCCESS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\LibraryDesktopProject\\src\\project\\library\\desktop\\gui\\icon\\tick.png"));
                                                saveBtn.setEnabled(false);
                                                clearBtn.setEnabled(false);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "BRANCH IS NOT ADDED", "FAIL", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\LibraryDesktopProject\\src\\project\\library\\desktop\\gui\\icon\\report.png"));
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "This branch already exists");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "SELECT DEPARTMENT !");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "ADD DATE !");
                                }
                            } else {
                                assetsBrTxt.setForeground(Color.red);
                                JOptionPane.showMessageDialog(null, "ADD ONLY NUMBER TYPE !");

                            }
                        } else {
                            emailBrTxt.setForeground(Color.red);
                            JOptionPane.showMessageDialog(null, "UNCORRECT EMAIL ADDRESS !");
                        }
                    } else {
                        branchtitleTxt.setForeground(Color.red);
                        JOptionPane.showMessageDialog(null, " ADD CORRECT BRANCH NAME !");

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ADD MAX. 25 SIMBOL !");
                }
            } else {
                JOptionPane.showMessageDialog(null, " ADD BRANCH NAME !");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_saveBtnActionPerformed

    private void departmentCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentCmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departmentCmbActionPerformed

    private void branchtitleTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_branchtitleTxtMouseClicked
        branchtitleTxt.setForeground(Color.BLUE.darker().darker().darker());

        if (evt.getClickCount() == 2) {
            branchtitleTxt.setText("");
        }
    }//GEN-LAST:event_branchtitleTxtMouseClicked

    private void phoneBrTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phoneBrTxtMouseClicked
        if (evt.getClickCount() == 2) {
            phoneBrTxt.setText("");
        }
    }//GEN-LAST:event_phoneBrTxtMouseClicked

    private void emailBrTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailBrTxtMouseClicked
        emailBrTxt.setForeground(Color.BLUE.darker());
        if (evt.getClickCount() == 2) {
            emailBrTxt.setText("");
        }
    }//GEN-LAST:event_emailBrTxtMouseClicked

    private void assetsBrTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assetsBrTxtMouseClicked
        assetsBrTxt.setForeground(Color.BLUE.darker());
        if (evt.getClickCount() == 2) {
            assetsBrTxt.setText("");
        }
    }//GEN-LAST:event_assetsBrTxtMouseClicked

    private void assetsBrTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assetsBrTxtActionPerformed
        assetsBrTxt.setForeground(Color.BLUE.darker().darker());
    }//GEN-LAST:event_assetsBrTxtActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        branchtitleTxt.setText("");
        fondationCalendar.setDate(null);
        addressBrTxt.setText("");
        assetsBrTxt.setText("");
        phoneBrTxt.setText("");
        emailBrTxt.setText("");
        departmentCmb.setSelectedIndex(0);


    }//GEN-LAST:event_clearBtnActionPerformed

    private void emailBrTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailBrTxtActionPerformed
        emailBrTxt.setForeground(Color.BLUE.darker().darker().darker());
    }//GEN-LAST:event_emailBrTxtActionPerformed

    private void addressBrTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressBrTxtActionPerformed

    }//GEN-LAST:event_addressBrTxtActionPerformed

    private void addressBrTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addressBrTxtMouseClicked
        if (evt.getClickCount() == 2) {
            addressBrTxt.setText("");
        }
    }//GEN-LAST:event_addressBrTxtMouseClicked

    private void restoreBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreBtn2ActionPerformed
        if (getExtendedState() == NORMAL) {
            setExtendedState(MAXIMIZED_BOTH);
            setResizable(true);
        } else {
            setExtendedState(NORMAL);
            this.pack();
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_restoreBtn2ActionPerformed

    private void minimizeBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeBtn2ActionPerformed
        this.setState(ICONIFIED);
    }//GEN-LAST:event_minimizeBtn2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE, TO CLOSE THE PROGRAM ?");
        if (choose == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        BranchFrame branchFrame = new BranchFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        branchFrame.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setVisible(false);
        this.dispose();
        BranchFrame branchFrame = new BranchFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        branchFrame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void branchtitleTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchtitleTxtActionPerformed
        branchtitleTxt.setForeground(Color.BLUE.darker().darker().darker());
    }//GEN-LAST:event_branchtitleTxtActionPerformed

    private void branchtitleTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_branchtitleTxtKeyPressed
        branchtitleTxt.setForeground(Color.BLUE.darker().darker().darker());
    }//GEN-LAST:event_branchtitleTxtKeyPressed

    private void branchtitleTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_branchtitleTxtMouseEntered
        branchtitleTxt.setForeground(Color.BLUE.darker().darker().darker());

    }//GEN-LAST:event_branchtitleTxtMouseEntered

    private void emailBrTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailBrTxtKeyPressed
        emailBrTxt.setForeground(Color.BLUE.darker().darker().darker());

    }//GEN-LAST:event_emailBrTxtKeyPressed

    private void assetsBrTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_assetsBrTxtKeyPressed
        assetsBrTxt.setForeground(Color.BLUE.darker().darker().darker());

    }//GEN-LAST:event_assetsBrTxtKeyPressed

    private void phoneBrTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneBrTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneBrTxtActionPerformed

    private void branchtitleTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_branchtitleTxtKeyReleased
        branchtitleTxt.setForeground(Color.BLUE.darker().darker().darker());

    }//GEN-LAST:event_branchtitleTxtKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressBrTxt;
    private javax.swing.JTextField assetsBrTxt;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField branchtitleTxt;
    private javax.swing.JButton clearBtn;
    private javax.swing.JComboBox<String> departmentCmb;
    private javax.swing.JTextField emailBrTxt;
    private com.toedter.calendar.JDateChooser fondationCalendar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private com.toedter.components.JSpinField jSpinField1;
    private javax.swing.JButton minimizeBtn2;
    private javax.swing.JTextField phoneBrTxt;
    private javax.swing.JButton restoreBtn2;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables

    private void showDepartmentCombo() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) departmentCmb.getModel();
            List<Department> departmentList = departmentService.getDepartmentList();
            for (Department department : departmentList) {
                model.addElement(new Item(department.getId(), department.getDepartmentName()));
            }
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
                    c.setBackground(Color.BLUE.darker());
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

    boolean chekBranchNameUnique(String branchName, Long depId) {
        boolean result = true;
        try {
            List<Branch> br = branchService.getBranchListForDepartment(depId);
            for (Branch branch : br) {
                if (branch.getBranchName().equals(branchName)) {
                    result = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
}
