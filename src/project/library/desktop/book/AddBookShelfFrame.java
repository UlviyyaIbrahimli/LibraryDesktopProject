package project.library.desktop.book;

import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import project.library.desktop.Desktop_Gui.Item;
import project.library.desktop.model.BookRoom;
import project.library.desktop.model.BookShelf;
import project.library.desktop.model.Login;
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
 * @ Ulviyye Ibrahimli
 */
public class AddBookShelfFrame extends javax.swing.JFrame {

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

    public AddBookShelfFrame() {
        initComponents();
    }

    AddBookShelfFrame(DepartmentService departmentService,
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
        this.setDefaultLookAndFeelDecorated(true);
        this.pack();
        this.setLocationRelativeTo(null);
        userTxt.setText("Welcome, " + login.getFirstName() + " " + login.getLastName() + " !");
        UIManager.put("OptionPane.background", Color.BLUE.darker().darker().darker());
        UIManager.put("Panel.background", Color.BLUE.darker().darker().darker());
        UIManager.put("OptionPane.messageForeground", Color.BLUE.darker().darker().darker());
        roomFloorCombo.setRenderer(new AddBookShelfFrame.TwoDecimalRenderer(roomFloorCombo.getRenderer()));
        roomNumberCombo.setRenderer(new AddBookShelfFrame.TwoDecimalRenderer(roomNumberCombo.getRenderer()));
        hideWarning();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        shelfNumberTxt = new javax.swing.JTextField();
        shelfFloorTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        roomFloorCombo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        roomNumberCombo = new javax.swing.JComboBox<>();
        saveBtn = new javax.swing.JButton();
        roomNumberCmbLbl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        potensialCapacityTxt = new javax.swing.JTextField();
        capacityWarningLbl = new javax.swing.JLabel();
        backBtn1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        minimizeBtn1 = new javax.swing.JButton();
        restoreBtn1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        shelfWarningLbl = new javax.swing.JLabel();
        shelfFloorWarninLbl = new javax.swing.JLabel();
        floorCmbWarningLbl = new javax.swing.JLabel();
        userTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 102));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Shelf Number");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        shelfNumberTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        shelfNumberTxt.setForeground(new java.awt.Color(0, 0, 102));
        shelfNumberTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shelfNumberTxtMouseClicked(evt);
            }
        });
        shelfNumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shelfNumberTxtActionPerformed(evt);
            }
        });
        shelfNumberTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                shelfNumberTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                shelfNumberTxtKeyReleased(evt);
            }
        });

        shelfFloorTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        shelfFloorTxt.setForeground(new java.awt.Color(0, 0, 102));
        shelfFloorTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shelfFloorTxtMouseClicked(evt);
            }
        });
        shelfFloorTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shelfFloorTxtActionPerformed(evt);
            }
        });
        shelfFloorTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                shelfFloorTxtKeyPressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 102));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Shelf Floor");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        jLabel3.setBackground(new java.awt.Color(0, 0, 102));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Room Floor");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        roomFloorCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        roomFloorCombo.setForeground(new java.awt.Color(0, 0, 102));
        roomFloorCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room Floor", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        roomFloorCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        roomFloorCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                roomFloorComboItemStateChanged(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 102));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Room number");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        roomNumberCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        roomNumberCombo.setForeground(new java.awt.Color(0, 0, 102));
        roomNumberCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room Number" }));
        roomNumberCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        roomNumberCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                roomNumberComboItemStateChanged(evt);
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

        roomNumberCmbLbl.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        roomNumberCmbLbl.setForeground(new java.awt.Color(255, 0, 0));
        roomNumberCmbLbl.setText("Select Room Number");

        jLabel6.setBackground(new java.awt.Color(0, 0, 102));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Potensial Capacity");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        potensialCapacityTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        potensialCapacityTxt.setForeground(new java.awt.Color(0, 0, 102));
        potensialCapacityTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                potensialCapacityTxtMouseClicked(evt);
            }
        });
        potensialCapacityTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                potensialCapacityTxtActionPerformed(evt);
            }
        });
        potensialCapacityTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                potensialCapacityTxtKeyPressed(evt);
            }
        });

        capacityWarningLbl.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        capacityWarningLbl.setForeground(new java.awt.Color(255, 0, 0));
        capacityWarningLbl.setText("Just Number Type");

        backBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-undo-24.png"))); // NOI18N
        backBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Add  Shelf of Book");

        minimizeBtn1.setBackground(new java.awt.Color(51, 102, 255));
        minimizeBtn1.setForeground(new java.awt.Color(153, 0, 0));
        minimizeBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-minimize-window-48.png"))); // NOI18N
        minimizeBtn1.setBorder(null);
        minimizeBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeBtn1ActionPerformed(evt);
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

        jButton2.setBackground(new java.awt.Color(153, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/close.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        clearBtn.setBackground(new java.awt.Color(0, 0, 102));
        clearBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 0, 0));
        clearBtn.setText("Clear");
        clearBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        clearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 102));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setText("Cancel");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        shelfWarningLbl.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        shelfWarningLbl.setForeground(new java.awt.Color(255, 0, 0));
        shelfWarningLbl.setText("Uncorrect Number");

        shelfFloorWarninLbl.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        shelfFloorWarninLbl.setForeground(new java.awt.Color(255, 0, 0));
        shelfFloorWarninLbl.setText("Just Number Type");

        floorCmbWarningLbl.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        floorCmbWarningLbl.setForeground(new java.awt.Color(255, 0, 0));
        floorCmbWarningLbl.setText("Select Floor");

        userTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        userTxt.setForeground(new java.awt.Color(0, 0, 204));
        userTxt.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(minimizeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(roomNumberCmbLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(floorCmbWarningLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(252, 252, 252)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(roomNumberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roomFloorCombo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(shelfWarningLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                    .addComponent(shelfFloorWarninLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(capacityWarningLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(shelfNumberTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(potensialCapacityTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(shelfFloorTxt, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(257, 257, 257)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(minimizeBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(restoreBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shelfNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shelfWarningLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shelfFloorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shelfFloorWarninLbl))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(potensialCapacityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(capacityWarningLbl)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(floorCmbWarningLbl)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(roomFloorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(roomNumberCmbLbl))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(roomNumberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearBtn)
                    .addComponent(jButton3)
                    .addComponent(saveBtn))
                .addGap(34, 34, 34))
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

    private void roomFloorComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_roomFloorComboItemStateChanged
        String selectedFloor = (String) roomFloorCombo.getSelectedItem();
        if (evt.getStateChange() == 1) {
            if (roomFloorCombo.getSelectedIndex() > 0) {
                showRoomNumberCombo(Integer.parseInt(selectedFloor));
            } else {
                ((DefaultComboBoxModel) roomNumberCombo.getModel()).removeAllElements();
                ((DefaultComboBoxModel) roomNumberCombo.getModel()).addElement("Select Room Number");

            }
        }
        floorCmbWarningLbl.setVisible(false);
    }//GEN-LAST:event_roomFloorComboItemStateChanged

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            String shelfNumber = shelfNumberTxt.getText();
            if (shelfNumber.matches("[a-zA-Z0-9\\s]+") && (!shelfNumber.isEmpty())) {
                String shelfFloor = shelfFloorTxt.getText();
                if (shelfFloor.matches("[0-9]+") && (!shelfFloor.isEmpty())) {
                    String potentialCapacity = potensialCapacityTxt.getText();
                    if (potentialCapacity.matches("[0-9]+") && (!potentialCapacity.isEmpty())) {
                        if (roomFloorCombo.getSelectedIndex() > 0) {
                            String roomFloor = (String) roomFloorCombo.getSelectedItem();
                            if ((!roomNumberCombo.getSelectedItem().equals("Select Room Number")) && (!roomNumberCombo.getSelectedItem().equals("There is no book-room on this floor"))) {
                                Item roomNumber = (Item) roomNumberCombo.getSelectedItem();
                                boolean check = checkBookShelfUnique(shelfNumber, roomNumber.getId());
                                if (check) {
                                    BookShelf bookShelf = new BookShelf();
                                    bookShelf.setShelfFloor(Integer.parseInt(shelfFloor));
                                    bookShelf.setShelfNumber(shelfNumber);
                                    BookRoom bookRoom = new BookRoom();
                                    bookRoom.setFloor(Integer.parseInt(roomFloor));
                                    bookRoom.setId(roomNumber.getId());
                                    bookShelf.setRoom(bookRoom);
                                    bookShelf.setPotensialCapacity(Integer.valueOf(potentialCapacity));
                                    boolean isAddBookShelf = bookShelfService.addBookShelf(bookShelf);
                                    if (isAddBookShelf) {
                                        JOptionPane.showMessageDialog(null, " ADDING IS SUCCESS!", "SUCCES", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/tick.png"));
                                        saveBtn.setEnabled(false);
                                        clearBtn.setEnabled(false);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "ADDING IS FAIL", "FAIL", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/report.png"));
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "THIS NUMBER HAS BEEN USED !");
                                }
                            } else {
                                roomNumberCmbLbl.setVisible(true);
                            }
                        } else {
                            floorCmbWarningLbl.setVisible(true);
                        }
                    } else {
                        capacityWarningLbl.setVisible(true);
                        potensialCapacityTxt.setForeground(Color.red);
                    }
                } else {
                    shelfFloorWarninLbl.setVisible(true);
                    shelfFloorTxt.setForeground(Color.red);
                }
            } else {
                shelfWarningLbl.setVisible(true);
                shelfNumberTxt.setForeground(Color.red);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void shelfFloorTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shelfFloorTxtMouseClicked
        shelfFloorTxt.setForeground(Color.BLUE.darker().darker().darker());
        shelfFloorWarninLbl.setVisible(false);
        if (evt.getClickCount() == 2) {
            shelfFloorTxt.setText("");
        }
    }//GEN-LAST:event_shelfFloorTxtMouseClicked

    private void potensialCapacityTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_potensialCapacityTxtMouseClicked
        potensialCapacityTxt.setForeground(Color.BLUE.darker().darker().darker());
        capacityWarningLbl.setVisible(false);
        if (evt.getClickCount() == 2) {
            potensialCapacityTxt.setText("");
        }
    }//GEN-LAST:event_potensialCapacityTxtMouseClicked

    private void backBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn1ActionPerformed
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
    }//GEN-LAST:event_backBtn1ActionPerformed

    private void minimizeBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeBtn1ActionPerformed
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_minimizeBtn1ActionPerformed

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE, TO CLOSE THE PROGRAM ?");
        if (choose == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        BookItemFrame bookItemFrame = new BookItemFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        bookItemFrame.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        shelfNumberTxt.setText("");
        shelfFloorTxt.setText("");
        potensialCapacityTxt.setText("");
        roomFloorCombo.setSelectedIndex(0);
        roomNumberCombo.setSelectedIndex(0);
        shelfWarningLbl.setVisible(false);
        shelfFloorWarninLbl.setVisible(false);
        capacityWarningLbl.setVisible(false);
        floorCmbWarningLbl.setVisible(false);
        roomNumberCmbLbl.setVisible(false);
    }//GEN-LAST:event_clearBtnActionPerformed

    private void shelfNumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shelfNumberTxtActionPerformed
        shelfNumberTxt.setForeground(Color.BLUE.darker().darker().darker());
        shelfFloorWarninLbl.setVisible(false);
    }//GEN-LAST:event_shelfNumberTxtActionPerformed

    private void shelfFloorTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shelfFloorTxtActionPerformed
        shelfFloorTxt.setForeground(Color.BLUE.darker().darker().darker());
        shelfFloorWarninLbl.setVisible(false);
    }//GEN-LAST:event_shelfFloorTxtActionPerformed

    private void shelfFloorTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_shelfFloorTxtKeyPressed
        shelfFloorTxt.setForeground(Color.BLUE.darker().darker().darker());
        shelfFloorWarninLbl.setVisible(false);
    }//GEN-LAST:event_shelfFloorTxtKeyPressed

    private void potensialCapacityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_potensialCapacityTxtActionPerformed
        potensialCapacityTxt.setForeground(Color.BLUE.darker().darker().darker());
        capacityWarningLbl.setVisible(false);

    }//GEN-LAST:event_potensialCapacityTxtActionPerformed

    private void potensialCapacityTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_potensialCapacityTxtKeyPressed
        potensialCapacityTxt.setForeground(Color.BLUE.darker().darker().darker());
        capacityWarningLbl.setVisible(false);
    }//GEN-LAST:event_potensialCapacityTxtKeyPressed

    private void roomNumberComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_roomNumberComboItemStateChanged
        roomNumberCmbLbl.setVisible(false);
    }//GEN-LAST:event_roomNumberComboItemStateChanged

    private void shelfNumberTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_shelfNumberTxtKeyPressed
       shelfNumberTxt.setForeground(Color.BLUE.darker().darker().darker());
        shelfFloorWarninLbl.setVisible(false);

    }//GEN-LAST:event_shelfNumberTxtKeyPressed

    private void shelfNumberTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_shelfNumberTxtKeyReleased
         shelfNumberTxt.setForeground(Color.BLUE.darker().darker().darker());
        shelfFloorWarninLbl.setVisible(false);

    }//GEN-LAST:event_shelfNumberTxtKeyReleased

    private void shelfNumberTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shelfNumberTxtMouseClicked
        shelfNumberTxt.setForeground(Color.BLUE.darker().darker().darker());
        shelfFloorWarninLbl.setVisible(false);

    }//GEN-LAST:event_shelfNumberTxtMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn1;
    private javax.swing.JLabel capacityWarningLbl;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel floorCmbWarningLbl;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton minimizeBtn1;
    private javax.swing.JTextField potensialCapacityTxt;
    private javax.swing.JButton restoreBtn1;
    private javax.swing.JComboBox<String> roomFloorCombo;
    private javax.swing.JLabel roomNumberCmbLbl;
    private javax.swing.JComboBox<String> roomNumberCombo;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField shelfFloorTxt;
    private javax.swing.JLabel shelfFloorWarninLbl;
    private javax.swing.JTextField shelfNumberTxt;
    private javax.swing.JLabel shelfWarningLbl;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables

    private void showRoomNumberCombo(Integer floor) {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) roomNumberCombo.getModel();
            List<BookRoom> getRoomNumberList = bookRoomService.getRoomNumburForFloor(floor);
            model.removeAllElements();
            if (getRoomNumberList.size() > 0) {
                model.addElement("Select Room Number");
                for (BookRoom bookRoom : getRoomNumberList) {
                    model.addElement(new Item(bookRoom.getId(), bookRoom.getNumber()));
                }
            } else {
                model.addElement("There is no book-room on this floor");
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

    void hideWarning() {
        floorCmbWarningLbl.setVisible(false);
        shelfFloorWarninLbl.setVisible(false);
        capacityWarningLbl.setVisible(false);
        roomNumberCmbLbl.setVisible(false);
        shelfWarningLbl.setVisible(false);
    }

    boolean checkBookShelfUnique(String number, Long roomId) {
        boolean result = true;
        try {
            List<BookShelf> shelfs = bookShelfService.getBookShelfByRoomId(roomId);
            for (BookShelf shelf : shelfs) {
                if (shelf.getShelfNumber().equals(number)) {
                    result = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
}
