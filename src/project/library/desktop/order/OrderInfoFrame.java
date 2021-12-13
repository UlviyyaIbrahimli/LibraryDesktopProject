package project.library.desktop.order;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import project.library.desktop.Desktop_Gui.LoginFrame;
import project.library.desktop.model.GiveBackBook;
import project.library.desktop.model.Login;
import project.library.desktop.model.OrderInHome;
import project.library.desktop.model.OrderInLib;
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
public class OrderInfoFrame extends javax.swing.JFrame {
    
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
    String searchBook = "";
    
    public OrderInfoFrame() {
    }
    
    public OrderInfoFrame(DepartmentService departmentService, 
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
        buttonGroup.add(fromHomeRadio);
        buttonGroup.add(fromLibraryRadio);
        JTableHeader header = inLibTabele.getTableHeader();
        header.setForeground(Color.BLUE.darker().darker());
        header.setBackground(Color.WHITE);
        header.setForeground(Color.red);
        inLibTabele.setForeground(Color.BLUE.darker().darker());
        inLibTabele.setGridColor(Color.BLUE.brighter());
        inLibTabele.setShowGrid(true);
        inLibTabele.setDefaultEditor(Object.class, null);
        inLibTabele.setRowSelectionAllowed(true);
        inLibTabele.setSelectionForeground(Color.WHITE);
        inLibTabele.setSelectionBackground(Color.BLUE.darker().darker());
        JTableHeader headerG = giveBackBookTable.getTableHeader();
        headerG.setForeground(Color.BLUE.darker().darker());
        headerG.setBackground(Color.WHITE);
        headerG.setForeground(Color.red);
        giveBackBookTable.setForeground(Color.BLUE.darker().darker());
        giveBackBookTable.setGridColor(Color.BLUE.brighter());
        giveBackBookTable.setShowGrid(true);
        giveBackBookTable.setDefaultEditor(Object.class, null);
        giveBackBookTable.setRowSelectionAllowed(true);
        giveBackBookTable.setSelectionForeground(Color.WHITE);
        giveBackBookTable.setSelectionBackground(Color.BLUE.darker().darker());
        JTableHeader headerHome = inHomeTable.getTableHeader();
        headerHome.setForeground(Color.BLUE.darker().darker());
        headerHome.setBackground(Color.WHITE);
        inHomeTable.setForeground(Color.BLUE.darker().darker());
        inHomeTable.setGridColor(Color.BLUE.brighter());
        inHomeTable.setShowGrid(true);
        headerHome.setForeground(Color.red);
        inHomeTable.setDefaultEditor(Object.class, null);
        inHomeTable.setRowSelectionAllowed(true);
        inHomeTable.setSelectionForeground(Color.WHITE);
        inHomeTable.setSelectionBackground(Color.BLUE.darker().darker());
        userTxt.setText("Welcome, " + login.getFirstName() + " " + login.getLastName() + " !");
        try {
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.darker().darker());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (login.getRole().getRoleName().equals("Library Assistant V")) {
            jPanel2.setVisible(false);
            jPanel2.setEnabled(false);
            jPanel3.setVisible(false);
            jPanel3.setEnabled(false);
            forLibraryBtn.setVisible(false);
            jButton6.setVisible(false);
        }
        System.out.println(java.time.LocalDate.now());
        showTableAllOrderDataWithTimeAndSearch(1, null, String.valueOf(java.time.LocalDate.now()), "3000-10-10");
        showTableAllOrderDataWithTimeAndSearchInHome(1, null, String.valueOf(java.time.LocalDate.now()), "3000-10-10");
        showGiveBackBookTableFromLibrary(1, String.valueOf(java.time.LocalDate.now()), "3000-10-10");
        fromLibraryRadio.setSelected(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inLibTabele = new javax.swing.JTable();
        time1 = new com.toedter.calendar.JDateChooser();
        time2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        forLibraryBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inHomeTable = new javax.swing.JTable();
        time3 = new com.toedter.calendar.JDateChooser();
        time4 = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        giveBackBookBtn = new javax.swing.JButton();
        calendarGivebook1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        calendarGive2 = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        fromHomeRadio = new javax.swing.JRadioButton();
        fromLibraryRadio = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        giveBackBookTable = new javax.swing.JTable();
        backBtn1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        restoreBtn1 = new javax.swing.JButton();
        minimizeBtn1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        userTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        inLibTabele.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(inLibTabele);

        time1.setForeground(new java.awt.Color(0, 0, 102));

        time2.setForeground(new java.awt.Color(204, 204, 255));

        jButton1.setText("Search");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-search-24 (4).png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 0, 102));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 255));
        jLabel5.setText("to");

        forLibraryBtn.setBackground(new java.awt.Color(0, 0, 102));
        forLibraryBtn.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        forLibraryBtn.setForeground(new java.awt.Color(255, 255, 255));
        forLibraryBtn.setText("NEW ODER FOR LIBRARY");
        forLibraryBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255)));
        forLibraryBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        forLibraryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forLibraryBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(503, 503, 503)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(forLibraryBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 378, Short.MAX_VALUE)
                        .addComponent(time1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(time2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(time1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(time2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(forLibraryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Order In  Library", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));

        inHomeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(inHomeTable);

        time3.setForeground(new java.awt.Color(0, 0, 102));

        time4.setForeground(new java.awt.Color(0, 0, 102));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-search-24 (4).png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setText("to");

        jButton6.setBackground(new java.awt.Color(0, 0, 102));
        jButton6.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("ORDER FOR HOME ");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 153), new java.awt.Color(0, 0, 204), new java.awt.Color(0, 0, 204), new java.awt.Color(0, 0, 204)));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 999, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(time3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(time4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(time4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Order For Home", jPanel3);

        jPanel4.setBackground(new java.awt.Color(0, 0, 102));

        giveBackBookBtn.setBackground(new java.awt.Color(0, 0, 102));
        giveBackBookBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        giveBackBookBtn.setForeground(new java.awt.Color(255, 255, 255));
        giveBackBookBtn.setText("Give Back Book");
        giveBackBookBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        giveBackBookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        giveBackBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giveBackBookBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("to");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-search-24 (4).png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        fromHomeRadio.setBackground(new java.awt.Color(0, 0, 102));
        fromHomeRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        fromHomeRadio.setForeground(new java.awt.Color(255, 255, 255));
        fromHomeRadio.setText("From Home");
        fromHomeRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromHomeRadioActionPerformed(evt);
            }
        });

        fromLibraryRadio.setBackground(new java.awt.Color(0, 0, 102));
        fromLibraryRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        fromLibraryRadio.setForeground(new java.awt.Color(255, 255, 255));
        fromLibraryRadio.setText("From Library");
        fromLibraryRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromLibraryRadioActionPerformed(evt);
            }
        });

        giveBackBookTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        giveBackBookTable.setForeground(new java.awt.Color(0, 0, 102));
        giveBackBookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(giveBackBookTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(fromLibraryRadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fromHomeRadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(giveBackBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 392, Short.MAX_VALUE)
                        .addComponent(calendarGivebook1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(calendarGive2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(giveBackBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calendarGivebook1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(calendarGive2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fromLibraryRadio)
                .addGap(1, 1, 1)
                .addComponent(fromHomeRadio)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Give Back Book", jPanel4);

        backBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-undo-24_1.png"))); // NOI18N
        backBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn1ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 0, 0));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/close.png"))); // NOI18N
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ORDER INFORMATION");

        userTxt.setEditable(false);
        userTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        userTxt.setForeground(new java.awt.Color(0, 0, 255));
        userTxt.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(minimizeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(minimizeBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(restoreBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn1ActionPerformed
        this.dispose();
        LoginFrame loginFrame = new LoginFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService);
        loginFrame.setVisible(true);
    }//GEN-LAST:event_backBtn1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE, TO CLOSE THE PROGRAM ?");
        if (choose == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

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

    private void forLibraryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forLibraryBtnActionPerformed
        OrderInLibFrame inLib = new OrderInLibFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        inLib.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_forLibraryBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date time11 = time1.getDate();
        Date time22 = time2.getDate();
        if (time11 != null && time22 != null) {
            String ee = df.format(time11);
            String tt = df.format(time22);
            showTableAllOrderDataWithTimeAndSearch(1, null, ee, tt);
        }
        if (time11 != null && time22 == null) {
            String ee = df.format(time11);
            showTableAllOrderDataWithTimeAndSearch(2, null, ee, null);
        }
        if (time22 != null && time11 == null) {
            String tt = df.format(time22);
            showTableAllOrderDataWithTimeAndSearch(3, null, null, tt);
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        OrderInHomeFrame inLib = new OrderInHomeFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        inLib.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date time11 = time3.getDate();
        Date time22 = time4.getDate();
        if (time11 != null && time22 != null) {
            String ee = df.format(time11);
            String tt = df.format(time22);
            showTableAllOrderDataWithTimeAndSearchInHome(1, null, ee, tt);
        }
        if (time11 != null && time22 == null) {
            String ee = df.format(time11);
            showTableAllOrderDataWithTimeAndSearchInHome(2, null, ee, null);
        }
        if (time22 != null && time11 == null) {
            String tt = df.format(time22);
            showTableAllOrderDataWithTimeAndSearchInHome(3, null, null, tt);
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void giveBackBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giveBackBookBtnActionPerformed
        GiveBackBookFrame backBookFrame = new GiveBackBookFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        backBookFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_giveBackBookBtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (fromLibraryRadio.isSelected()) {
            Date time1Give = calendarGivebook1.getDate();
            Date time2Give = calendarGive2.getDate();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            if (time1Give != null && time2Give != null) {
                String time1GiveF = df.format(time1Give);
                String time2GiveF = df.format(time2Give);
                showGiveBackBookTableFromLibrary(1, time1GiveF, time2GiveF);
            } else if (time1Give != null && time2Give == null) {
                String time1GiveF = df.format(time1Give);
                showGiveBackBookTableFromLibrary(2, time1GiveF, null);
            } else if (time1Give == null && time2Give != null) {
                String time2GiveF = df.format(time2Give);
                showGiveBackBookTableFromLibrary(3, null, time2GiveF);
            } else {
                JOptionPane.showMessageDialog(null, "Add Date");
            }
        } else if (fromHomeRadio.isSelected()) {
            Date time1Give = calendarGivebook1.getDate();
            Date time2Give = calendarGive2.getDate();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            if (time1Give != null && time2Give != null) {
                String time1GiveF = df.format(time1Give);
                String time2GiveF = df.format(time2Give);
                showGiveBackBookTableFromHome(1, time1GiveF, time2GiveF);
            } else if (time1Give != null && time2Give == null) {
                String time1GiveF = df.format(time1Give);
                showGiveBackBookTableFromHome(2, time1GiveF, null);
            } else if (time1Give == null && time2Give != null) {
                String time2GiveF = df.format(time2Give);
                showGiveBackBookTableFromHome(3, null, time2GiveF);
            } else {
                JOptionPane.showMessageDialog(null, "Add Date");
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void fromLibraryRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromLibraryRadioActionPerformed
        fromLibraryRadio.setText("From Library");
        fromLibraryRadio.setActionCommand("From Library");
        if (fromLibraryRadio.isSelected()) {
            Date time1Give = calendarGivebook1.getDate();
            Date time2Give = calendarGive2.getDate();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            if (time1Give != null && time2Give != null) {
                String time1GiveF = df.format(time1Give);
                String time2GiveF = df.format(time2Give);
                showGiveBackBookTableFromHome(1, time1GiveF, time2GiveF);
            } else if (time1Give != null && time2Give == null) {
                String time1GiveF = df.format(time1Give);
                showGiveBackBookTableFromHome(2, time1GiveF, null);
            } else if (time1Give == null && time2Give != null) {
                String time2GiveF = df.format(time2Give);
                showGiveBackBookTableFromHome(3, null, time2GiveF);
            } else {
                showGiveBackBookTableFromLibrary(1, String.valueOf(java.time.LocalDate.now()), "3000-10-10");
                
            }
        }
    }//GEN-LAST:event_fromLibraryRadioActionPerformed

    private void fromHomeRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromHomeRadioActionPerformed
        fromHomeRadio.setText("From Home");
        fromHomeRadio.setActionCommand("From Home");
        Date time1Give = calendarGivebook1.getDate();
        Date time2Give = calendarGive2.getDate();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        if (time1Give != null && time2Give != null) {
            String time1GiveF = df.format(time1Give);
            String time2GiveF = df.format(time2Give);
            showGiveBackBookTableFromHome(1, time1GiveF, time2GiveF);
        } else if (time1Give != null && time2Give == null) {
            String time1GiveF = df.format(time1Give);
            showGiveBackBookTableFromHome(2, time1GiveF, null);
        } else if (time1Give == null && time2Give != null) {
            String time2GiveF = df.format(time2Give);
            showGiveBackBookTableFromHome(3, null, time2GiveF);
        } else {
            showGiveBackBookTableFromHome(1, String.valueOf(java.time.LocalDate.now()), "3000-10-10");
        }

    }//GEN-LAST:event_fromHomeRadioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn1;
    private com.toedter.calendar.JDateChooser calendarGive2;
    private com.toedter.calendar.JDateChooser calendarGivebook1;
    private javax.swing.JButton forLibraryBtn;
    private javax.swing.JRadioButton fromHomeRadio;
    private javax.swing.JRadioButton fromLibraryRadio;
    private javax.swing.JButton giveBackBookBtn;
    private javax.swing.JTable giveBackBookTable;
    private javax.swing.JTable inHomeTable;
    private javax.swing.JTable inLibTabele;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton minimizeBtn1;
    private javax.swing.JButton restoreBtn1;
    private com.toedter.calendar.JDateChooser time1;
    private com.toedter.calendar.JDateChooser time2;
    private com.toedter.calendar.JDateChooser time3;
    private com.toedter.calendar.JDateChooser time4;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables

    void showTableAllOrderDataWithTimeAndSearch(int choose, Long id, String time1, String time2) {
        try {
            List<OrderInLib> orderList = new ArrayList<>();
            if (choose == 1) {
                orderList = orderInLibService.getCountForSearch(1, null, time1, time2);
            } else if (choose == 2) {
                orderList = orderInLibService.getCountForSearch(2, null, time1, null);
                
            } else if (choose == 3) {
                orderList = orderInLibService.getCountForSearch(3, null, null, time2);
            }
            
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
                
            };
            model.addColumn("id");
            model.addColumn("№");
            model.addColumn("CN of Employee");
            model.addColumn("Employee FullName");
            model.addColumn("CN of Reader");
            model.addColumn("Reader FullName");
            model.addColumn("Book Isbn");
            model.addColumn("Book Title");
            model.addColumn("Author FullName");
            model.addColumn("Room of Floor");
            model.addColumn("Read Room Number");
            model.addColumn("Table Number");
            model.addColumn("Computer Table");
            model.addColumn("Order Time");
            inLibTabele.setModel(model);
            for (OrderInLib orderInLib : orderList) {
                Object[] object = new Object[]{
                    orderInLib.getId(), orderInLib.getNumber(), orderInLib.getEmployee().getCardNumber(),
                    orderInLib.getEmployee().getFirstName() + "  " + orderInLib.getEmployee().getLastName(),
                    orderInLib.getReader().getCardNumber(), orderInLib.getReader().getFirstName() + "  " + orderInLib.getReader().getLastName(),
                    orderInLib.getBook().getIsbn(), orderInLib.getBook().getTitle(),
                    orderInLib.getAuthor().getFirstName(), orderInLib.getReadRoom().getLibFloor(),
                    orderInLib.getReadRoom().getReadRoomNumber(), orderInLib.getReadTable().getTableNumber(),
                    orderInLib.getReadTable().getWithComputer(), orderInLib.getData_date()
                };
                
                model.addRow(object);
            }
            inLibTabele.getColumnModel().getColumn(0).setMinWidth(0);
            inLibTabele.getColumnModel().getColumn(0).setWidth(0);
            inLibTabele.getColumnModel().getColumn(0).setMaxWidth(0);
            inLibTabele.getColumnModel().getColumn(1).setMaxWidth(40);
            
            model.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void showTableAllOrderDataWithTimeAndSearchInHome(int choose, Long id, String time1, String time2) {
        try {
            List<OrderInHome> orderList = new ArrayList<>();
            if (choose == 1) {
                orderList = orderInHomeService.getCountForSearch(1, null, time1, time2);
            } else if (choose == 2) {
                orderList = orderInHomeService.getCountForSearch(2, null, time1, time2);
            } else if (choose == 3) {
                orderList = orderInHomeService.getCountForSearch(3, null, time1, time2);
            }
            
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
                
            };
            model.addColumn("id");
            model.addColumn("№");
            model.addColumn("CN of Employee");
            model.addColumn("Employee FullName");
            model.addColumn("CN of Reader");
            model.addColumn("Reader FullName");
            model.addColumn("Book Isbn");
            model.addColumn("Book Title");
            model.addColumn("Author FullName");
            model.addColumn("Order Time");
            inHomeTable.setModel(model);
            for (OrderInHome orderInLib : orderList) {
                Object[] object = new Object[]{
                    orderInLib.getId(), orderInLib.getNumber(), orderInLib.getEmployee().getCardNumber(),
                    orderInLib.getEmployee().getFirstName() + "  " + orderInLib.getEmployee().getLastName(),
                    orderInLib.getReader().getCardNumber(), orderInLib.getReader().getFirstName() + "  " + orderInLib.getReader().getLastName(),
                    orderInLib.getBook().getIsbn(), orderInLib.getBook().getTitle(),
                    orderInLib.getAuthor().getFirstName(),
                    orderInLib.getData_date()
                };
                
                model.addRow(object);
            }
            inHomeTable.getColumnModel().getColumn(0).setMinWidth(0);
            inHomeTable.getColumnModel().getColumn(0).setWidth(0);
            inHomeTable.getColumnModel().getColumn(0).setMaxWidth(0);
            inHomeTable.getColumnModel().getColumn(1).setMaxWidth(40);
            
            model.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void showGiveBackBookTableFromLibrary(int choose, String time1, String time2) {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
                
            };
            if (choose == 1) {
                List<GiveBackBook> gives = orderInLibService.getGiveBackBook(1, time1, time2);
                model.addColumn("№");
                model.addColumn("Employee Card Number");
                model.addColumn("Employee Full Name");
                model.addColumn("Reader Card_number");
                model.addColumn("Reader Full Name");
                model.addColumn("Book ISBN");
                model.addColumn("Book's Title");
                model.addColumn("Give Back Time");
                giveBackBookTable.setModel(model);
                for (GiveBackBook give : gives) {
                    Object object[] = new Object[]{
                        give.getNumber(), give.getEmployee().getCardNumber(),
                        give.getEmployee().getFirstName() + " " + give.getEmployee().getLastName(),
                        give.getReader().getCardNumber(), give.getReader().getFirstName() + " " + give.getReader().getLastName(),
                        give.getBook().getIsbn(), give.getBook().getTitle(), give.getData_date()
                    };
                    model.addRow(object);
                }
                
                model.fireTableDataChanged();
                
                giveBackBookTable.getColumnModel().getColumn(0).setMaxWidth(40);
            } else if (choose == 2) {
                List<GiveBackBook> gives = orderInLibService.getGiveBackBook(2, time1, time2);
                model.addColumn("№");
                model.addColumn("Employee Card Number");
                model.addColumn("Employee Full Name");
                model.addColumn("Reader Card_number");
                model.addColumn("Reader Full Name");
                model.addColumn("Book ISBN");
                model.addColumn("Book's Title");
                model.addColumn("Give Back Time");
                giveBackBookTable.setModel(model);
                for (GiveBackBook give : gives) {
                    Object object[] = new Object[]{
                        give.getNumber(), give.getEmployee().getCardNumber(),
                        give.getEmployee().getFirstName() + " " + give.getEmployee().getLastName(),
                        give.getReader().getCardNumber(), give.getReader().getFirstName() + " " + give.getReader().getLastName(),
                        give.getBook().getIsbn(), give.getBook().getTitle(), give.getData_date()
                    };
                    model.addRow(object);
                }
                
                giveBackBookTable.getColumnModel().getColumn(0).setMaxWidth(40);
            } else if (choose == 3) {
                List<GiveBackBook> gives = orderInLibService.getGiveBackBook(3, time1, time2);
                model.addColumn("№");
                model.addColumn("Employee Card Number");
                model.addColumn("Employee Full Name");
                model.addColumn("Reader Card_number");
                model.addColumn("Reader Full Name");
                model.addColumn("Book ISBN");
                model.addColumn("Book's Title");
                model.addColumn("Give Back Time");
                giveBackBookTable.setModel(model);
                for (GiveBackBook give : gives) {
                    Object object[] = new Object[]{
                        give.getNumber(), give.getEmployee().getCardNumber(),
                        give.getEmployee().getFirstName() + " " + give.getEmployee().getLastName(),
                        give.getReader().getCardNumber(), give.getReader().getFirstName() + " " + give.getReader().getLastName(),
                        give.getBook().getIsbn(), give.getBook().getTitle(), give.getData_date()
                    };
                    model.addRow(object);
                }
                ;
                giveBackBookTable.getColumnModel().getColumn(0).setMaxWidth(40);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void showGiveBackBookTableFromHome(int choose, String time1, String time2) {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
                
            };
            if (choose == 1) {
                List<GiveBackBook> gives = orderInHomeService.getGives(1, time1, time2);
                model.addColumn("№");
                model.addColumn("Employee Card Number");
                model.addColumn("Employee Full Name");
                model.addColumn("Reader Card_number");
                model.addColumn("Reader Full Name");
                model.addColumn("Book ISBN");
                model.addColumn("Book's Title");
                model.addColumn("Give Back Time");
                giveBackBookTable.setModel(model);
                for (GiveBackBook give : gives) {
                    Object object[] = new Object[]{
                        give.getNumber(), give.getEmployee().getCardNumber(),
                        give.getEmployee().getFirstName() + " " + give.getEmployee().getLastName(),
                        give.getReader().getCardNumber(), give.getReader().getFirstName() + " " + give.getReader().getLastName(),
                        give.getBook().getIsbn(), give.getBook().getTitle(), give.getData_date()
                    };
                    model.addRow(object);
                }
                
                model.fireTableDataChanged();
                
                giveBackBookTable.getColumnModel().getColumn(0).setMaxWidth(40);
            } else if (choose == 2) {
                List<GiveBackBook> gives = orderInHomeService.getGives(2, time1, time2);
                model.addColumn("№");
                model.addColumn("Employee Card Number");
                model.addColumn("Employee Full Name");
                model.addColumn("Reader Card_number");
                model.addColumn("Reader Full Name");
                model.addColumn("Book ISBN");
                model.addColumn("Book's Title");
                model.addColumn("Give Back Time");
                giveBackBookTable.setModel(model);
                for (GiveBackBook give : gives) {
                    Object object[] = new Object[]{
                        give.getNumber(), give.getEmployee().getCardNumber(),
                        give.getEmployee().getFirstName() + " " + give.getEmployee().getLastName(),
                        give.getReader().getCardNumber(), give.getReader().getFirstName() + " " + give.getReader().getLastName(),
                        give.getBook().getIsbn(), give.getBook().getTitle(), give.getData_date()
                    };
                    model.addRow(object);
                }
                
                giveBackBookTable.getColumnModel().getColumn(0).setMaxWidth(40);
            } else if (choose == 3) {
                List<GiveBackBook> gives = orderInHomeService.getGives(3, time1, time2);
                model.addColumn("№");
                model.addColumn("Employee Card Number");
                model.addColumn("Employee Full Name");
                model.addColumn("Reader Card_number");
                model.addColumn("Reader Full Name");
                model.addColumn("Book ISBN");
                model.addColumn("Book's Title");
                model.addColumn("Give Back Time");
                giveBackBookTable.setModel(model);
                for (GiveBackBook give : gives) {
                    Object object[] = new Object[]{
                        give.getNumber(), give.getEmployee().getCardNumber(),
                        give.getEmployee().getFirstName() + " " + give.getEmployee().getLastName(),
                        give.getReader().getCardNumber(), give.getReader().getFirstName() + " " + give.getReader().getLastName(),
                        give.getBook().getIsbn(), give.getBook().getTitle(), give.getData_date()
                    };
                    model.addRow(object);
                }
                ;
                giveBackBookTable.getColumnModel().getColumn(0).setMaxWidth(40);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
