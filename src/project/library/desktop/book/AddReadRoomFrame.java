package project.library.desktop.book;

import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import project.library.desktop.model.Login;
import project.library.desktop.model.ReadRoom;
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
import static sun.security.jgss.GSSUtil.login;

public class AddReadRoomFrame extends JFrame {

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

    public AddReadRoomFrame() {
        initComponents();
    }

    AddReadRoomFrame(DepartmentService departmentService,
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
        try {
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
            userTxt.setText("Wlecome, " + login.getFirstName() + " " + login.getLastName() + " !");;
            floorCombo.setRenderer(new AddReadRoomFrame.TwoDecimalRenderer(floorCombo.getRenderer()));
            this.setDefaultLookAndFeelDecorated(true);
            this.pack();
            this.setLocationRelativeTo(null);
            hideWarningLbl();
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.darker().darker().darker());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        roomNumberTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        computerTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        chairCountTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        floorCombo = new javax.swing.JComboBox<>();
        saveBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        restoreBtn1 = new javax.swing.JButton();
        minimizeBtn1 = new javax.swing.JButton();
        backBtn1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        clearBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        roomNumberWLbl = new javax.swing.JLabel();
        floorwLbl = new javax.swing.JLabel();
        chairCountWLbl = new javax.swing.JLabel();
        compCountLbl = new javax.swing.JLabel();
        userTxt = new javax.swing.JTextField();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 102));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Room Number");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        roomNumberTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        roomNumberTxt.setForeground(new java.awt.Color(0, 0, 102));
        roomNumberTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomNumberTxtMouseClicked(evt);
            }
        });
        roomNumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNumberTxtActionPerformed(evt);
            }
        });
        roomNumberTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                roomNumberTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                roomNumberTxtKeyReleased(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 102));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Floor");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        computerTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        computerTxt.setForeground(new java.awt.Color(0, 0, 102));
        computerTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                computerTxtMouseClicked(evt);
            }
        });
        computerTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computerTxtActionPerformed(evt);
            }
        });
        computerTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                computerTxtKeyPressed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 102));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Computer Count");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        chairCountTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        chairCountTxt.setForeground(new java.awt.Color(0, 0, 102));
        chairCountTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chairCountTxtMouseClicked(evt);
            }
        });
        chairCountTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chairCountTxtActionPerformed(evt);
            }
        });
        chairCountTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                chairCountTxtKeyPressed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 102));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Chair Count");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        floorCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        floorCombo.setForeground(new java.awt.Color(0, 0, 102));
        floorCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Library Floor", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        floorCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                floorComboItemStateChanged(evt);
            }
        });
        floorCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floorComboActionPerformed(evt);
            }
        });

        saveBtn.setBackground(new java.awt.Color(0, 0, 102));
        saveBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save");
        saveBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/close.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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

        backBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-undo-24.png"))); // NOI18N
        backBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Add  Read Room");

        clearBtn.setBackground(new java.awt.Color(0, 0, 102));
        clearBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 0, 0));
        clearBtn.setText("Clear");
        clearBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        clearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(0, 0, 102));
        cancelBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 0, 0));
        cancelBtn.setText("Cancel");
        cancelBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        roomNumberWLbl.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        roomNumberWLbl.setForeground(new java.awt.Color(255, 0, 0));
        roomNumberWLbl.setText("Uncorrect Number");

        floorwLbl.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        floorwLbl.setForeground(new java.awt.Color(255, 0, 0));
        floorwLbl.setText("Select Floor");

        chairCountWLbl.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        chairCountWLbl.setForeground(new java.awt.Color(255, 0, 0));
        chairCountWLbl.setText("Numbeer Type");

        compCountLbl.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        compCountLbl.setForeground(new java.awt.Color(255, 0, 0));
        compCountLbl.setText("Numbeer Type");

        userTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        userTxt.setForeground(new java.awt.Color(0, 0, 255));
        userTxt.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(minimizeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(235, 235, 235)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(224, 224, 224)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(compCountLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(68, 68, 68)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(chairCountWLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(floorwLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roomNumberWLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chairCountTxt)
                            .addComponent(computerTxt)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(floorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(roomNumberTxt))))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(minimizeBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(restoreBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(roomNumberWLbl)
                            .addComponent(roomNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(floorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(floorwLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(computerTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(compCountLbl)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chairCountWLbl)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chairCountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
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

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            boolean isAddReadRoom = false;
            String readRoomNumber = roomNumberTxt.getText();
            if ((readRoomNumber.matches("[a-zA-Z0-9 ]+")) && (!readRoomNumber.isEmpty())) {
                if (floorCombo.getSelectedIndex() > 0) {// + one or more , * zero or more in regex
                    String floor = (String) floorCombo.getSelectedItem();
                    boolean check = checkReadRoomNumberUnique(readRoomNumber, Integer.parseInt(floor));
                    if (check) {
                        String computerCount = computerTxt.getText();
                        if (computerCount.matches("[0-9]+") && (!computerCount.isEmpty())) {
                            String chairCount = chairCountTxt.getText();
                            if (chairCount.matches("[0-9]+") && (!chairCount.isEmpty())) {
                                ReadRoom readRoom = new ReadRoom();
                                readRoom.setLibFloor(Integer.parseInt(floor));
                                readRoom.setReadRoomNumber(readRoomNumber);
                                readRoom.setChairCount(Integer.parseInt(chairCount));
                                readRoom.setComputerCount(Integer.parseInt(computerCount));
                                readRoom.setReadRoomNumber(readRoomNumber);
                                isAddReadRoom = readRoomService.addReadRoom(readRoom);
                                if (isAddReadRoom) {
                                    JOptionPane.showMessageDialog(null, "ADDING IS SUCCESS!", "Success", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/tick.png"));
                                    saveBtn.setEnabled(false);
                                    clearBtn.setEnabled(false);
                                } else {
                                    JOptionPane.showMessageDialog(null, "ADDING IS FAIL", "Fail", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/report.png"));
                                    this.setVisible(true);
                                }
                            } else {
                                chairCountWLbl.setVisible(true);
                                chairCountTxt.setForeground(Color.red);
                            }
                        } else {
                            compCountLbl.setVisible(true);
                            computerTxt.setForeground(Color.red);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "THIS NUMBER HAS BEEN USED !");
                    }
                } else {
                    floorwLbl.setVisible(true);
                }
            } else {
                roomNumberWLbl.setVisible(true);
                roomNumberTxt.setForeground(Color.red);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_saveBtnActionPerformed

    private void floorComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_floorComboItemStateChanged
        floorwLbl.setVisible(false);
    }//GEN-LAST:event_floorComboItemStateChanged

    private void floorComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_floorComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_floorComboActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE, TO CLOSE THE PROGRAM ?");
        if (choose == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            this.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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

    private void backBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn1ActionPerformed
        this.dispose();
        BookItemFrame bookItemFrame = new BookItemFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        bookItemFrame.setVisible(true);
    }//GEN-LAST:event_backBtn1ActionPerformed

    private void roomNumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNumberTxtActionPerformed
        roomNumberTxt.setForeground(Color.BLUE.darker().darker());
        roomNumberWLbl.setVisible(false);
    }//GEN-LAST:event_roomNumberTxtActionPerformed

    private void roomNumberTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomNumberTxtMouseClicked
        roomNumberTxt.setForeground(Color.BLUE.darker().darker());
        roomNumberWLbl.setVisible(false);
        if (evt.getClickCount() == 2) {
            roomNumberTxt.setText("");
        }
    }//GEN-LAST:event_roomNumberTxtMouseClicked

    private void roomNumberTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roomNumberTxtKeyPressed
        roomNumberTxt.setForeground(Color.BLUE.darker().darker());
        roomNumberWLbl.setVisible(false);
    }//GEN-LAST:event_roomNumberTxtKeyPressed

    private void computerTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computerTxtActionPerformed
        compCountLbl.setVisible(false);
        computerTxt.setForeground(Color.BLUE.darker().darker());

    }//GEN-LAST:event_computerTxtActionPerformed

    private void computerTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_computerTxtMouseClicked
        compCountLbl.setVisible(false);
        computerTxt.setForeground(Color.MAGENTA.darker().darker().darker());
        if (evt.getClickCount() == 2) {
            computerTxt.setText("");
        }
    }//GEN-LAST:event_computerTxtMouseClicked

    private void computerTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_computerTxtKeyPressed
        compCountLbl.setVisible(false);
        computerTxt.setForeground(Color.BLUE.darker().darker());
    }//GEN-LAST:event_computerTxtKeyPressed

    private void chairCountTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chairCountTxtActionPerformed
        chairCountWLbl.setVisible(false);
        chairCountTxt.setForeground(Color.BLUE.darker().darker());
    }//GEN-LAST:event_chairCountTxtActionPerformed

    private void chairCountTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chairCountTxtMouseClicked
        chairCountWLbl.setVisible(false);
        chairCountTxt.setForeground(Color.BLUE.darker().darker());
        if (evt.getClickCount() == 2) {
            chairCountTxt.setText("");
        }
    }//GEN-LAST:event_chairCountTxtMouseClicked

    private void chairCountTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chairCountTxtKeyPressed
        chairCountWLbl.setVisible(false);
        chairCountTxt.setForeground(Color.BLUE.darker().darker());
    }//GEN-LAST:event_chairCountTxtKeyPressed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        hideWarningLbl();
        roomNumberTxt.setText("");
        floorCombo.setSelectedIndex(0);
        computerTxt.setText("");
        chairCountTxt.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void roomNumberTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roomNumberTxtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNumberTxtKeyReleased

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
        BookItemFrame bookItemFrame = new BookItemFrame(departmentService,
                positionService, branchService,
                employeeService, timeTypeService,
                educationTypeService, bookService,
                authorService, subjectService,
                bookShelfService, bookRoomService,
                readRoomService, readTableService,
                languageService, readerService,
                orderInLibService, orderInHomeService,
                giveBackBookService, loginService,
                roleService, login);
        bookItemFrame.setVisible(true);
    }//GEN-LAST:event_cancelBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn1;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField chairCountTxt;
    private javax.swing.JLabel chairCountWLbl;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel compCountLbl;
    private javax.swing.JTextField computerTxt;
    private javax.swing.JComboBox<String> floorCombo;
    private javax.swing.JLabel floorwLbl;
    private javax.swing.JButton jButton2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton minimizeBtn1;
    private javax.swing.JButton restoreBtn1;
    private javax.swing.JTextField roomNumberTxt;
    private javax.swing.JLabel roomNumberWLbl;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables

    void hideWarningLbl() {
        roomNumberWLbl.setVisible(false);
        floorwLbl.setVisible(false);
        compCountLbl.setVisible(false);
        chairCountWLbl.setVisible(false);
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

    boolean checkReadRoomNumberUnique(String number, int floor) {
        boolean result = true;
        try {
            List<ReadRoom> rooms = readRoomService.getReadRoomByRoomFloor(floor);
            for (ReadRoom room : rooms) {
                if (room.getReadRoomNumber().equals(number)) {
                    result = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
