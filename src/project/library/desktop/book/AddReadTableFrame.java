package project.library.desktop.book;

import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import project.library.desktop.Desktop_Gui.Item;
import project.library.desktop.model.Login;
import project.library.desktop.model.ReadRoom;
import project.library.desktop.model.ReadTable;
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
public class AddReadTableFrame extends javax.swing.JFrame {

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
    ButtonGroup buttonGroup = new ButtonGroup();
    boolean a = true;

    public AddReadTableFrame() {
        initComponents();
    }

    AddReadTableFrame(DepartmentService departmentService,
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
            userTxt.setText("Welcome, " + login.getFirstName() + " " + login.getLastName() + " !");
            buttonGroup.add(yesRadio);
            buttonGroup.add(noRadio);
            roomNumbercombo.setRenderer(new AddReadTableFrame.TwoDecimalRenderer(roomNumbercombo.getRenderer()));
            roomFloorCombo.setRenderer(new AddReadTableFrame.TwoDecimalRenderer(roomFloorCombo.getRenderer()));

            this.setDefaultLookAndFeelDecorated(true);
            this.pack();
            this.setLocationRelativeTo(null);
            hideWarningLbl();
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.darker().darker());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        readTableNumberTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        yesRadio = new javax.swing.JRadioButton();
        noRadio = new javax.swing.JRadioButton();
        saveBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        roomNumbercombo = new javax.swing.JComboBox<>();
        roomFloorCombo = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        restoreBtn1 = new javax.swing.JButton();
        minimizeBtn1 = new javax.swing.JButton();
        backBtn1 = new javax.swing.JButton();
        floorWLbl = new javax.swing.JLabel();
        radioWLbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        clearBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        numberWLbl = new javax.swing.JLabel();
        roomWLbl = new javax.swing.JLabel();
        userTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 102));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Read Table Number");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        readTableNumberTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        readTableNumberTxt.setForeground(new java.awt.Color(0, 0, 102));
        readTableNumberTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                readTableNumberTxtMouseClicked(evt);
            }
        });
        readTableNumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readTableNumberTxtActionPerformed(evt);
            }
        });
        readTableNumberTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                readTableNumberTxtKeyPressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 102));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("With Computer");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        yesRadio.setBackground(new java.awt.Color(0, 0, 102));
        yesRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        yesRadio.setForeground(new java.awt.Color(204, 204, 255));
        yesRadio.setText("Yes");
        yesRadio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        yesRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesRadioActionPerformed(evt);
            }
        });

        noRadio.setBackground(new java.awt.Color(0, 0, 102));
        noRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        noRadio.setForeground(new java.awt.Color(204, 204, 255));
        noRadio.setText("No");
        noRadio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        noRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noRadioActionPerformed(evt);
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

        jLabel3.setBackground(new java.awt.Color(0, 0, 102));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Floor");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        jLabel4.setBackground(new java.awt.Color(0, 0, 102));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Room Number");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));

        roomNumbercombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        roomNumbercombo.setForeground(new java.awt.Color(0, 0, 102));
        roomNumbercombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select room number", "Before Select Floor " }));
        roomNumbercombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                roomNumbercomboItemStateChanged(evt);
            }
        });
        roomNumbercombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNumbercomboActionPerformed(evt);
            }
        });

        roomFloorCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        roomFloorCombo.setForeground(new java.awt.Color(0, 0, 102));
        roomFloorCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selected Floor", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        roomFloorCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        roomFloorCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                roomFloorComboItemStateChanged(evt);
            }
        });
        roomFloorCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomFloorComboActionPerformed(evt);
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

        floorWLbl.setBackground(new java.awt.Color(0, 0, 102));
        floorWLbl.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        floorWLbl.setForeground(new java.awt.Color(204, 0, 0));
        floorWLbl.setText("Select Floor");

        radioWLbl.setBackground(new java.awt.Color(0, 0, 102));
        radioWLbl.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        radioWLbl.setForeground(new java.awt.Color(204, 0, 0));
        radioWLbl.setText("Select Yes or No");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Add Table for Reader");

        clearBtn.setBackground(new java.awt.Color(0, 0, 102));
        clearBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 0, 0));
        clearBtn.setText("Clear");
        clearBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
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
        cancelBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        numberWLbl.setBackground(new java.awt.Color(255, 255, 255));
        numberWLbl.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        numberWLbl.setForeground(new java.awt.Color(153, 0, 0));
        numberWLbl.setText("Uncorrect Number");

        roomWLbl.setBackground(new java.awt.Color(255, 255, 255));
        roomWLbl.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        roomWLbl.setForeground(new java.awt.Color(204, 0, 0));
        roomWLbl.setText("Select Room Number");

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
                .addGap(72, 72, 72)
                .addComponent(minimizeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(floorWLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioWLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberWLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomWLbl))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(readTableNumberTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(roomFloorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(yesRadio)
                                        .addGap(150, 150, 150)
                                        .addComponent(noRadio))
                                    .addComponent(roomNumbercombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(198, 198, 198)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(minimizeBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(restoreBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(readTableNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(numberWLbl)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomFloorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(floorWLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomNumbercombo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomWLbl))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioWLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(noRadio)
                            .addComponent(yesRadio))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(saveBtn)
                    .addComponent(clearBtn))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            boolean flag = true;
            boolean isAddReadTable = false;
            ReadTable readTable = new ReadTable();
            String readTableNumber = readTableNumberTxt.getText();
            if ((readTableNumber.matches("[a-zA-Z0-9 \\-\\№\\.]+")) && (!readTableNumber.isEmpty())) {
                readTable.setTableNumber(readTableNumber);
                if (roomFloorCombo.getSelectedIndex() > 0) {
                    String floor = (String) roomFloorCombo.getSelectedItem();
                    if (!roomNumbercombo.getSelectedItem().equals("Select room number") && (!roomNumbercombo.getSelectedItem().equals("There is no read-room on this floor"))) {
                        Item roomNumber = (Item) roomNumbercombo.getSelectedItem();
                        boolean check = chekTableUnique(readTableNumber, roomNumber.getId());
                        if (check) {
                            if (yesRadio.isSelected() || noRadio.isSelected()) {
                                String withComputer = buttonGroup.getSelection().getActionCommand();
                                if (withComputer.equalsIgnoreCase("yes")) {
                                    readTable.setWithComputer(1);
                                } else if (withComputer.equalsIgnoreCase("no")) {
                                    readTable.setWithComputer(0);
                                }
                                ReadRoom readRoom = new ReadRoom();
                                readRoom.setLibFloor(Integer.parseInt(floor));
                                readRoom.setId(roomNumber.getId());
                                readTable.setReadRoom(readRoom);
                                isAddReadTable = readTableService.addReadTable(readTable);
                                if (isAddReadTable) {
                                    JOptionPane.showMessageDialog(null, readTableNumber.toUpperCase() + " IS ADDED SUCCESSFULY!", "SUCCES", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/tick.png"));
                                    saveBtn.setEnabled(false);
                                    clearBtn.setEnabled(false);
                                    a = false;
                                } else {
                                    JOptionPane.showMessageDialog(null, "ADDING IS FAIL", "FAIL", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/report.png"));
                                    this.setVisible(true);
                                    a = false;
                                }
                            } else {
                                radioWLbl.setVisible(true);
                                radioWLbl.setText("Select Yes or No");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "THIS NUMBER HAS BEEN USED !");
                        }
                    } else {
                        roomWLbl.setVisible(true);
                        roomWLbl.setText("Select Room");
                    }
                } else {
                    floorWLbl.setVisible(true);
                    floorWLbl.setText("Select Floor");

                }
            } else {
                numberWLbl.setText("Uncorrect Number");
                numberWLbl.setVisible(true);
                System.out.println("nusfdcgvb");
                readTableNumberTxt.setForeground(Color.red);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_saveBtnActionPerformed

    private void yesRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesRadioActionPerformed
        yesRadio.setText("yes");
        yesRadio.setActionCommand("yes");
        radioWLbl.setVisible(false);
    }//GEN-LAST:event_yesRadioActionPerformed

    private void noRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noRadioActionPerformed
        noRadio.setText("no");
        noRadio.setActionCommand("no");
        radioWLbl.setVisible(false);

    }//GEN-LAST:event_noRadioActionPerformed

    private void roomNumbercomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNumbercomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNumbercomboActionPerformed

    private void roomFloorComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_roomFloorComboItemStateChanged
        String floor = (String) roomFloorCombo.getSelectedItem();
        if (evt.getStateChange() == 1) {
            if (roomFloorCombo.getSelectedIndex() > 0) {
                showRoomNumberCombo(floor);
            }
        }
        floorWLbl.setVisible(false);
    }//GEN-LAST:event_roomFloorComboItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE, TO CLOSE THE PROGRAM?");
        if (choose == JOptionPane.YES_OPTION) {
            System.exit(0);
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

    private void readTableNumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readTableNumberTxtActionPerformed
        numberWLbl.setVisible(false);
        readTableNumberTxt.setForeground(Color.MAGENTA.darker().darker().darker().darker());
    }//GEN-LAST:event_readTableNumberTxtActionPerformed

    private void readTableNumberTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_readTableNumberTxtMouseClicked
        if (evt.getClickCount() == 2) {
            readTableNumberTxt.setText("");
        }
        numberWLbl.setVisible(false);
        readTableNumberTxt.setForeground(Color.MAGENTA.darker().darker().darker().darker());
    }//GEN-LAST:event_readTableNumberTxtMouseClicked

    private void readTableNumberTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_readTableNumberTxtKeyPressed
        numberWLbl.setVisible(false);
        readTableNumberTxt.setForeground(Color.MAGENTA.darker().darker().darker().darker());
    }//GEN-LAST:event_readTableNumberTxtKeyPressed

    private void roomNumbercomboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_roomNumbercomboItemStateChanged
        roomWLbl.setVisible(false);
    }//GEN-LAST:event_roomNumbercomboItemStateChanged

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        readTableNumberTxt.setText("");
        roomFloorCombo.setSelectedIndex(0);
        showRoomNumberCombo(String.valueOf(0));
        yesRadio.setSelected(false);
        noRadio.setSelected(false);
        hideWarningLbl();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
        BookItemFrame bookItemFrame = new BookItemFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        bookItemFrame.setVisible(true);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void roomFloorComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomFloorComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomFloorComboActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn1;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel floorWLbl;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton minimizeBtn1;
    private javax.swing.JRadioButton noRadio;
    private javax.swing.JLabel numberWLbl;
    private javax.swing.JLabel radioWLbl;
    private javax.swing.JTextField readTableNumberTxt;
    private javax.swing.JButton restoreBtn1;
    private javax.swing.JComboBox<String> roomFloorCombo;
    private javax.swing.JComboBox<String> roomNumbercombo;
    private javax.swing.JLabel roomWLbl;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField userTxt;
    private javax.swing.JRadioButton yesRadio;
    // End of variables declaration//GEN-END:variables

    private void showRoomNumberCombo(String floor) {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) roomNumbercombo.getModel();
            List<ReadRoom> readRoomnumberList = readRoomService.getReadRoomByRoomFloor(Integer.parseInt(floor));
            if (readRoomnumberList.size() > 0) {
                model.removeAllElements();
                for (ReadRoom readRoom : readRoomnumberList) {
                    model.addElement(new Item(readRoom.getId(), readRoom.getReadRoomNumber()));
                }
            } else {
                model.removeAllElements();
                model.addElement("There is no read-room on this floor");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void hideWarningLbl() {
        radioWLbl.setVisible(false);
        roomWLbl.setVisible(false);
        numberWLbl.setVisible(false);
        floorWLbl.setVisible(false);
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

    boolean chekTableUnique(String number, Long roomId) {
        boolean result = true;
        try {
            List<ReadTable> tables = readTableService.getTableByRoomId(roomId);
            for (ReadTable table : tables) {
                if (table.getTableNumber().equals(number)) {
                    result = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
