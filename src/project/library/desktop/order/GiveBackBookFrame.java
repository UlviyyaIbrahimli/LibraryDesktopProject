package project.library.desktop.order;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import project.library.desktop.Desktop_Gui.Item;
import project.library.desktop.Desktop_Gui.LoginFrame;
import project.library.desktop.model.Book;
import project.library.desktop.model.Login;
import project.library.desktop.model.Reader;
import project.library.desktop.model.employee.Employee;
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
 * Ibrahimli Ulviyye
 */
public class GiveBackBookFrame extends javax.swing.JFrame {

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
    private  StatusService statusService;
    ButtonGroup buttonGroup = new ButtonGroup();
    String searchWord;

    public GiveBackBookFrame() {
        initComponents();
    }

    GiveBackBookFrame(DepartmentService departmentService,
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
        readerCombo.setVisible(false);
        this.setDefaultLookAndFeelDecorated(true);
        this.pack();
        this.setLocationRelativeTo(null);
        inLibRadio.setSelected(true);
        this.getContentPane().setBackground(Color.BLUE.darker().darker().darker());
        try {
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.darker().darker());
        } catch (Exception e) {
            e.printStackTrace();
        }
        employeeCombo.setRenderer(new GiveBackBookFrame.TwoDecimalRenderer(employeeCombo.getRenderer()));
        readerCombo.setRenderer(new GiveBackBookFrame.TwoDecimalRenderer(readerCombo.getRenderer()));
        bookCombo.setRenderer(new GiveBackBookFrame.TwoDecimalRenderer(bookCombo.getRenderer()));
        showEmployeeCombo();
        readerCombo.setVisible(false);
        penaltyTxt.setText("0");
        buttonGroup.add(inLibRadio);
        buttonGroup.add(homeRadio);
        sameReaderBtn.setEnabled(false);
        sameReaderBtn.setForeground(Color.red);
        sameReaderBtn.setBackground(Color.BLUE.darker().darker());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        closeBtn = new javax.swing.JButton();
        restoreBtn1 = new javax.swing.JButton();
        minimizeBtn1 = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        employeeCombo = new javax.swing.JComboBox<>();
        readerTxt = new javax.swing.JTextField();
        readerCombo = new javax.swing.JComboBox<>();
        bookCombo = new javax.swing.JComboBox<>();
        penaltyTxt = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        inLibRadio = new javax.swing.JRadioButton();
        homeRadio = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        sameReaderBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        closeBtn.setBackground(new java.awt.Color(153, 0, 0));
        closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/close.png"))); // NOI18N
        closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        restoreBtn1.setBackground(new java.awt.Color(51, 102, 255));
        restoreBtn1.setForeground(new java.awt.Color(255, 255, 255));
        restoreBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-restore-window-32.png"))); // NOI18N
        restoreBtn1.setBorder(null);
        restoreBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        restoreBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreBtn1ActionPerformed(evt);
            }
        });

        minimizeBtn1.setBackground(new java.awt.Color(51, 102, 255));
        minimizeBtn1.setForeground(new java.awt.Color(153, 0, 0));
        minimizeBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-minimize-window-48.png"))); // NOI18N
        minimizeBtn1.setBorder(null);
        minimizeBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeBtn1ActionPerformed(evt);
            }
        });

        backbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-undo-24.png"))); // NOI18N
        backbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 0, 102));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("GIVE BOOKS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimizeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(minimizeBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(restoreBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setBackground(new java.awt.Color(0, 0, 102));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Employee");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        jLabel2.setBackground(new java.awt.Color(0, 0, 102));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reader");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        jLabel3.setBackground(new java.awt.Color(0, 0, 102));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Book");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        jLabel4.setBackground(new java.awt.Color(0, 0, 102));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Penalty");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        employeeCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        employeeCombo.setForeground(new java.awt.Color(0, 0, 102));
        employeeCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employeeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeComboActionPerformed(evt);
            }
        });

        readerTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        readerTxt.setForeground(new java.awt.Color(0, 0, 102));
        readerTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                readerTxtMouseClicked(evt);
            }
        });
        readerTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readerTxtActionPerformed(evt);
            }
        });
        readerTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                readerTxtKeyPressed(evt);
            }
        });

        readerCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        readerCombo.setForeground(new java.awt.Color(0, 0, 102));
        readerCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        readerCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                readerComboItemStateChanged(evt);
            }
        });

        bookCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bookCombo.setForeground(new java.awt.Color(0, 0, 102));
        bookCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Book" }));
        bookCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        penaltyTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        penaltyTxt.setForeground(new java.awt.Color(0, 0, 102));
        penaltyTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                penaltyTxtMouseClicked(evt);
            }
        });
        penaltyTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penaltyTxtActionPerformed(evt);
            }
        });

        saveBtn.setBackground(new java.awt.Color(0, 0, 102));
        saveBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save");
        saveBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        inLibRadio.setBackground(new java.awt.Color(0, 0, 102));
        inLibRadio.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        inLibRadio.setForeground(new java.awt.Color(255, 255, 255));
        inLibRadio.setText("FROM LIBRARY");
        inLibRadio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inLibRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inLibRadioActionPerformed(evt);
            }
        });

        homeRadio.setBackground(new java.awt.Color(0, 0, 102));
        homeRadio.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        homeRadio.setForeground(new java.awt.Color(255, 255, 255));
        homeRadio.setText("FROM HOME");
        homeRadio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeRadioActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("New");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        sameReaderBtn.setBackground(new java.awt.Color(0, 0, 102));
        sameReaderBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        sameReaderBtn.setForeground(new java.awt.Color(255, 255, 255));
        sameReaderBtn.setText("The Same Reader");
        sameReaderBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        sameReaderBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sameReaderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sameReaderBtnActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 102));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setText("Cancel");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 102));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 0));
        jButton4.setText("Clear");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(301, 301, 301)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bookCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(readerCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(penaltyTxt)
                            .addComponent(readerTxt)
                            .addComponent(employeeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(inLibRadio)
                                .addGap(126, 126, 126)
                                .addComponent(homeRadio))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(sameReaderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(28, 28, 28))
            .addComponent(jSeparator1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inLibRadio)
                    .addComponent(homeRadio))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(employeeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(readerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(readerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(penaltyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sameReaderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employeeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeComboActionPerformed

    private void readerTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readerTxtActionPerformed
        readerCombo.setVisible(true);
        searchWord = readerTxt.getText();
        if (inLibRadio.isSelected()) {
            if (searchWord != null) {
                showReaderComboInLib(searchWord);
            } else {
                showReaderInLib();
            }
        } else if (homeRadio.isSelected()) {
            if (searchWord != null) {
                showReaderComboInHome(searchWord);
            } else {
                showReaderInHome();
            }
        }
    }//GEN-LAST:event_readerTxtActionPerformed

    private void readerTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_readerTxtMouseClicked
        readerCombo.setVisible(true);
        searchWord = readerTxt.getText();
        if (inLibRadio.isSelected()) {
            if (searchWord != null) {
                showReaderComboInLib(searchWord);
            } else {
                showReaderInLib();
            }
        } else if (homeRadio.isSelected()) {
            if (searchWord != null) {
                showReaderComboInHome(searchWord);
            } else {
                showReaderInHome();
            }
        }
        readerCombo.setVisible(true);
        if (evt.getClickCount() == 2) {
            readerTxt.setText("");
        }
    }//GEN-LAST:event_readerTxtMouseClicked

    private void readerTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_readerTxtKeyPressed
        readerCombo.setVisible(true);
        searchWord = readerTxt.getText();
        if (inLibRadio.isSelected()) {
            if (searchWord != null) {
                showReaderComboInLib(searchWord);
            } else {
                showReaderInLib();
            }
        } else if (homeRadio.isSelected()) {
            if (searchWord != null) {
                showReaderComboInHome(searchWord);
            } else {
                showReaderInHome();
            }
        }
    }//GEN-LAST:event_readerTxtKeyPressed

    private void inLibRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inLibRadioActionPerformed
        inLibRadio.setText("FROM LIBRARY");
        inLibRadio.setActionCommand("FROM LIBRARY");
        if (inLibRadio.isSelected()) {
            clear();
            saveBtn.setEnabled(true);

        }
    }//GEN-LAST:event_inLibRadioActionPerformed

    private void homeRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeRadioActionPerformed
        homeRadio.setText("FROM HOME");
        homeRadio.setActionCommand("FROM HOME");
        if (homeRadio.isSelected()) {
            clear();
            saveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_homeRadioActionPerformed

    private void readerComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_readerComboItemStateChanged
        if (readerCombo.getSelectedIndex() != -1) {
            if (!readerCombo.getSelectedItem().equals("Select Reader")) {
                Item readerItem = (Item) readerCombo.getSelectedItem();
                if (inLibRadio.isSelected()) {
                    showBookComboForReaderInLib(readerItem.getId());
                } else if (homeRadio.isSelected()) {
                    showBookComboForReaderInHome(readerItem.getId());
                }
            }
        }
    }//GEN-LAST:event_readerComboItemStateChanged

    private void penaltyTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penaltyTxtActionPerformed

    }//GEN-LAST:event_penaltyTxtActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            boolean isUpdatePenalty = false;
            boolean roomUpdate = true;
            boolean updatePenalty = false;
            if ((!employeeCombo.getSelectedItem().equals("Select Employee"))
                    && (readerCombo.getSelectedIndex() != -1)
                    && (!readerCombo.getSelectedItem().equals("Select Reader"))
                    && (!bookCombo.getSelectedItem().equals("Select Book"))
                    && (bookCombo.getSelectedIndex() != -1)) {
                String penalty = penaltyTxt.getText();
                if (penalty.matches("[0-9]+(\\.[0-9]+)?")) {
                    Item readerItem = (Item) readerCombo.getSelectedItem();
                    Long readerId = readerItem.getId();
                    Item employeeItem = (Item) employeeCombo.getSelectedItem();
                    Long employeeId = employeeItem.getId();
                    Item bookItem = (Item) bookCombo.getSelectedItem();
                    Long bookId = bookItem.getId();
                    if (homeRadio.isSelected()) {
                        boolean addGiveBook = giveBackBookService.addGiveBackBookFromHome(employeeId, readerId, bookId);
                        if (addGiveBook) {
                            Integer bookCount = bookService.getBookCount(bookId);
                            Integer result = bookCount + 1;
                            boolean updateBookCount = bookService.updateBookForBackBook(result, bookId);
                            boolean updateGiveBackFromHome = orderInHomeService.updateOrderActive(readerId, bookId);
                            Float oldPenaltyFromHome = readerService.getPenalty(readerId);
                            if (penalty != null && oldPenaltyFromHome != null) {
                                Float newPenalty = oldPenaltyFromHome + Float.parseFloat(penalty);
                                isUpdatePenalty = readerService.updatePenalty(readerId, newPenalty);
                            }
                            if (updateBookCount && updateGiveBackFromHome && addGiveBook && isUpdatePenalty) {
                                JOptionPane.showMessageDialog(null, "OPERATION IS SUCCESS !", "SUCCESS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/tick.png"));
                                saveBtn.setEnabled(false);
                                this.validate();
                                this.repaint();
                                this.revalidate();//reload
                                saveBtn.setEnabled(false);
                                List<Book> bookList = giveBackBookService.bookInHome(readerId);
                                if (bookList.size() > 0) {
                                    sameReaderBtn.setEnabled(true);
                                    sameReaderBtn.setForeground(Color.WHITE);
                                } else {
                                    JOptionPane.showMessageDialog(null, readerItem.getValue() + " no longer owes books --> \\'for home\\' !");
                                    saveBtn.setEnabled(true);
                                    clear();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "OPERATION IS FAIL !", "Fail", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/report.png"));
                            }
                        }
                    } else if (inLibRadio.isSelected()) {
                        boolean addGiveBook = giveBackBookService.addGiveBackBook(employeeId, readerId, bookId);
                        if (addGiveBook) {
                            Float oldPenalty = readerService.getPenalty(readerId);
                            if (penalty != null && oldPenalty != null) {
                                Float finishPenalty = Float.parseFloat(penalty) + oldPenalty;
                                updatePenalty = readerService.updatePenalty(readerId, finishPenalty);
                            }
                            Integer bookCount = bookService.getBookCount(bookItem.getId());
                            bookCount = bookCount + 1;
                            boolean updatebookCount = bookService.updateBookForBackBook(bookCount, bookId);
                            Long tableIdd = readTableService.tableId(readerId, bookId);
                            Long roomId = orderInLibService.getRoomId(readerId, bookId);
                            boolean updateOrderFromLib = orderInLibService.updateOrderActive(readerId, bookId);
                            boolean updateTable = readTableService.updateStatus(tableIdd);
                            Integer roomFullTable = readTableService.allTable(roomId);
                            Integer roomOrderTable = readTableService.getOrderedTableCount(roomId);
                            if ((roomFullTable - roomOrderTable) == 0) {
                                roomUpdate = readRoomService.updateForGive(roomId);
                            }
                            if (roomUpdate) {
                                if (addGiveBook && updatePenalty && updatebookCount && updateTable && updateOrderFromLib) {
                                    JOptionPane.showMessageDialog(null, " OPERATION IS SUCCESS !", "Success", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/tick.png"));
                                    saveBtn.setEnabled(false);
//                                        this.validate();
//                                        this.repaint();
//                                        this.revalidate();//reload
                                    List<Book> bookList = giveBackBookService.bookInLib(readerId);
                                    if (bookList.size() != 0) {
                                        sameReaderBtn.setForeground(Color.WHITE);
                                        sameReaderBtn.setEnabled(true);
                                    } else {
                                        JOptionPane.showMessageDialog(null, readerItem.getValue() + "  no longer owes books--> \\' for home\\' !");
                                        clear();
                                        saveBtn.setEnabled(true);
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "OPERATION IS FAIL !", "Fail", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/report.png"));
                            }

                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Just Number Type!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Add All Components!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_saveBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        GiveBackBookFrame backBookFrame = new GiveBackBookFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        backBookFrame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE, TO CLOSE THE PROGRAM ?");
        if (choose == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_closeBtnActionPerformed

    private void restoreBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreBtn1ActionPerformed
        if (getExtendedState() == NORMAL) {
            setExtendedState(MAXIMIZED_BOTH);
            setResizable(true);
        } else {
            setExtendedState(NORMAL);
            this.pack();
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_restoreBtn1ActionPerformed

    private void minimizeBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeBtn1ActionPerformed
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_minimizeBtn1ActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        this.dispose();
        OrderInfoFrame infoFrame = new OrderInfoFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        infoFrame.setVisible(true);
    }//GEN-LAST:event_backbtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clear();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void sameReaderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sameReaderBtnActionPerformed
        try {
            saveBtn.setEnabled(true);
            Item readerItem = (Item) readerCombo.getSelectedItem();
            Long readerId = readerItem.getId();
            if (inLibRadio.isSelected()) {
                showBookComboForReaderInLib(readerId);
            } else if (homeRadio.isSelected()) {
                showBookComboForReaderInHome(readerId);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }//GEN-LAST:event_sameReaderBtnActionPerformed

    private void penaltyTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_penaltyTxtMouseClicked
        if (evt.getClickCount() == 2) {
            penaltyTxt.setText("");
        }
    }//GEN-LAST:event_penaltyTxtMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        LoginFrame frame = new LoginFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService,statusService);
        frame.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JComboBox<String> bookCombo;
    private javax.swing.JButton closeBtn;
    private javax.swing.JComboBox<String> employeeCombo;
    private javax.swing.JRadioButton homeRadio;
    private javax.swing.JRadioButton inLibRadio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton minimizeBtn1;
    private javax.swing.JTextField penaltyTxt;
    private javax.swing.JComboBox<String> readerCombo;
    private javax.swing.JTextField readerTxt;
    private javax.swing.JButton restoreBtn1;
    private javax.swing.JButton sameReaderBtn;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables

    void showEmployeeCombo() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) employeeCombo.getModel();
            List<Employee> employeeList = employeeService.getEmployeeList(1);
            model.addElement("Select Employee");
            for (Employee employee : employeeList) {
                model.addElement(new Item(employee.getId(), employee.getFirstName() + " " + employee.getLastName()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void showReaderComboInLib(String searchword) {
        try {
            List<Reader> filteredList = new ArrayList<>();
            List<Reader> readerList = giveBackBookService.inLibReader();
            for (Reader reader : readerList) {
                if (reader.getCardNumber().contains(searchword)
                        || reader.getFirstName().toLowerCase().contains(searchword.toLowerCase())
                        || reader.getLastName().toLowerCase().contains(searchword.toLowerCase())
                        || reader.getFatherName().toLowerCase().contains(searchword.toLowerCase())
                        || reader.getIdentifyNumber().contains(searchword.toLowerCase())
                        || reader.getCardNumber().contains(searchword.toLowerCase())) {
                    filteredList.add(reader);
                }
            }
            if (filteredList.size() > 0) {
                DefaultComboBoxModel model = (DefaultComboBoxModel) readerCombo.getModel();
                model.removeAllElements();
                for (Reader filter : filteredList) {
                    model.addElement(new Item(filter.getId(), "\"" + filter.getCardNumber() + "\" " + filter.getFirstName() + " " + filter.getLastName()));
                }
            } else if (filteredList.size() == 0) {
                showReaderInLib();
            }
            JTextField textfield = (JTextField) readerCombo.getEditor().getEditorComponent();
            textfield.setText(searchword);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void showReaderInLib() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) readerCombo.getModel();
        try {
            List<Reader> readerList = giveBackBookService.inLibReader();
            model.removeAllElements();
            model.addElement("Select Reader");
            for (Reader reader : readerList) {
                model.addElement(new Item(reader.getId(), "\"" + reader.getCardNumber() + "\" " + reader.getFirstName() + " " + reader.getLastName()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void showReaderComboInHome(String searchword) {

        try {
            List<Reader> filteredList = new ArrayList<>();
            List<Reader> readerList = giveBackBookService.inHomeReader();//size
            for (Reader reader : readerList) {
                if (reader.getCardNumber().contains(searchword)
                        || reader.getFirstName().toLowerCase().contains(searchword.toLowerCase())
                        || reader.getLastName().toLowerCase().contains(searchword.toLowerCase())
                        || reader.getFatherName().toLowerCase().contains(searchword.toLowerCase())
                        || reader.getIdentifyNumber().contains(searchword.toLowerCase())
                        || reader.getCardNumber().contains(searchword.toLowerCase())) {
                    filteredList.add(reader);
                }
            }
            if (filteredList.size() > 0) {
                DefaultComboBoxModel model = (DefaultComboBoxModel) readerCombo.getModel();
                model.removeAllElements();
                for (Reader filter : filteredList) {
                    model.addElement(new Item(filter.getId(), "\"" + filter.getCardNumber() + "\" " + filter.getFirstName() + " " + filter.getLastName()));
                }
            } else if (filteredList.size() == 0) {
                showReaderInHome();
            }
            JTextField textfield = (JTextField) readerCombo.getEditor().getEditorComponent();
            textfield.setText(searchword);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void showReaderInHome() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) readerCombo.getModel();
        try {
            List<Reader> readerList = giveBackBookService.inHomeReader();
            model.removeAllElements();
            model.addElement("Select Reader");
            for (Reader reader : readerList) {
                model.addElement(new Item(reader.getId(), "\"" + reader.getCardNumber() + "\" " + reader.getFirstName() + " " + reader.getLastName()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void showBookComboForReaderInLib(Long readerId) {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) bookCombo.getModel();
            List<Book> bookList = giveBackBookService.bookInLib(readerId);
            model.removeAllElements();
            model.addElement("Select Book");
            for (Book book : bookList) {
                model.addElement(new Item(book.getId(), book.getIsbn() + "  \\" + book.getTitle()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void showBookComboForReaderInHome(Long readerId) {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) bookCombo.getModel();
            model.removeAllElements();
            List<Book> bookList = giveBackBookService.bookInHome(readerId);
            model.addElement("Select Book");
            for (Book book : bookList) {
                model.addElement(new Item(book.getId(), book.getIsbn() + "  \\" + book.getTitle()));
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
                    c.setBackground(Color.BLUE.darker().darker());
                    c.setForeground(Color.WHITE.darker());
                } else {
                    c.setBackground(Color.WHITE);
                }
            } else {
                c.setBackground(Color.WHITE.darker().darker());
                c = super.getListCellRendererComponent(list, value, index, isSelected,
                        cellHasFocus);
            }
            return c;
        }
    }

    void clear() {
        employeeCombo.setSelectedIndex(0);
        readerTxt.setText("");
        readerCombo.setVisible(false);
        readerCombo.setSelectedIndex(-1);
        bookCombo.setSelectedItem("Select Book");
        penaltyTxt.setText("0");

    }
}
