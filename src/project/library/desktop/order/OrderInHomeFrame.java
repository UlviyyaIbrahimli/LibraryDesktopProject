package project.library.desktop.order;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
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
import project.library.desktop.model.Book;
import project.library.desktop.model.Login;
import project.library.desktop.model.OrderInLib;
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
import project.library.desktop.service.SubjectService;
import project.library.desktop.service.TimeTypeService;
/**
 * 
 * @ Ulviyye Ibrahimli
 */
public class OrderInHomeFrame extends javax.swing.JFrame {

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

    String searcBook;
    String searchReader;

    public OrderInHomeFrame() {
        initComponents();
    }

    OrderInHomeFrame(DepartmentService departmentService,
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
        this.getContentPane().setBackground(Color.BLUE.darker().darker().darker());
        try {
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker().darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker().darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.darker().darker());
        } catch (Exception e) {
            e.printStackTrace();
        }
        employeeNameComboForHome.setRenderer(new OrderInHomeFrame.TwoDecimalRenderer(employeeNameComboForHome.getRenderer()));
        searchBookComboForHome.setRenderer(new OrderInHomeFrame.TwoDecimalRenderer(searchBookComboForHome.getRenderer()));
        readerComboForSearchForHome.setRenderer(new OrderInHomeFrame.TwoDecimalRenderer(readerComboForSearchForHome.getRenderer()));
        showEmployeeCombo((long) 11);
        searchBookComboForHome.setVisible(false);
        readerComboForSearchForHome.setVisible(false);
        withNewBookBtn.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        minimizeBtn1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        restoreBtn1 = new javax.swing.JButton();
        backBtn1 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        isbnTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        titleTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        languageTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        caseTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        countTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        limitTimeTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        roomFloorTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        roomNumberTxt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        shelfTxt = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        fullNameTxt = new javax.swing.JTextField();
        identityTxt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cardNumberTxt = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        penaltyTxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        activityTxt = new javax.swing.JTextField();
        startMTxt = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        pullMTxt = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        statusTxt = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        orderBtn = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        employeeNameComboForHome = new javax.swing.JComboBox<>();
        bookTxtForHome = new javax.swing.JTextField();
        withNewBookBtn = new javax.swing.JButton();
        readerComboForSearchForHome = new javax.swing.JComboBox<>();
        locatedBtn = new javax.swing.JButton();
        infoBtn = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        searchBookComboForHome = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        readerSearchTxtForHome = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        newOrder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        minimizeBtn1.setBackground(new java.awt.Color(51, 102, 255));
        minimizeBtn1.setForeground(new java.awt.Color(153, 0, 0));
        minimizeBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-minimize-window-48.png"))); // NOI18N
        minimizeBtn1.setBorder(null);
        minimizeBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeBtn1ActionPerformed(evt);
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

        backBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-undo-24.png"))); // NOI18N
        backBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn1ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 204, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("ORDER FOR HOME");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimizeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(minimizeBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(restoreBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 255));
        jLabel6.setText("ISBN");

        isbnTxt.setEditable(false);
        isbnTxt.setBackground(new java.awt.Color(255, 255, 255));
        isbnTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        isbnTxt.setForeground(new java.awt.Color(0, 0, 153));
        isbnTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isbnTxtActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 255));
        jLabel7.setText("TITLE");

        titleTxt.setEditable(false);
        titleTxt.setBackground(new java.awt.Color(255, 255, 255));
        titleTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        titleTxt.setForeground(new java.awt.Color(0, 0, 153));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 255));
        jLabel8.setText("LANGUAGE");

        languageTxt.setEditable(false);
        languageTxt.setBackground(new java.awt.Color(255, 255, 255));
        languageTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        languageTxt.setForeground(new java.awt.Color(0, 0, 153));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 255));
        jLabel9.setText("CASE");

        caseTxt.setEditable(false);
        caseTxt.setBackground(new java.awt.Color(255, 255, 255));
        caseTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        caseTxt.setForeground(new java.awt.Color(0, 0, 153));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 255));
        jLabel10.setText("COUNT");

        countTxt.setEditable(false);
        countTxt.setBackground(new java.awt.Color(255, 255, 255));
        countTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        countTxt.setForeground(new java.awt.Color(0, 0, 153));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 255));
        jLabel11.setText("LIMIT DAY");

        limitTimeTxt.setEditable(false);
        limitTimeTxt.setBackground(new java.awt.Color(255, 255, 255));
        limitTimeTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        limitTimeTxt.setForeground(new java.awt.Color(0, 0, 153));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 255));
        jLabel12.setText("ROOM FLOOR");

        roomFloorTxt.setEditable(false);
        roomFloorTxt.setBackground(new java.awt.Color(255, 255, 255));
        roomFloorTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        roomFloorTxt.setForeground(new java.awt.Color(0, 0, 153));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 255));
        jLabel13.setText("ROOM NUMBER");

        roomNumberTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        roomNumberTxt.setForeground(new java.awt.Color(0, 0, 153));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 255));
        jLabel14.setText("SHELF NUMBER");

        shelfTxt.setEditable(false);
        shelfTxt.setBackground(new java.awt.Color(255, 255, 255));
        shelfTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        shelfTxt.setForeground(new java.awt.Color(0, 0, 153));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("BOOK'S INFORMATION");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(shelfTxt))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(roomNumberTxt))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(roomFloorTxt))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(limitTimeTxt))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(countTxt))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(caseTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(languageTxt))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(titleTxt))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(isbnTxt)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel24)
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(isbnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(titleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(languageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(caseTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(countTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(limitTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(roomFloorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(roomNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(shelfTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 102));
        jPanel4.setForeground(new java.awt.Color(0, 0, 204));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 255));
        jLabel15.setText("READER FULL NAME");

        fullNameTxt.setEditable(false);
        fullNameTxt.setBackground(new java.awt.Color(255, 255, 255));
        fullNameTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        fullNameTxt.setForeground(new java.awt.Color(0, 0, 153));

        identityTxt.setEditable(false);
        identityTxt.setBackground(new java.awt.Color(255, 255, 255));
        identityTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        identityTxt.setForeground(new java.awt.Color(0, 0, 153));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 255));
        jLabel16.setText("IDENTITY");

        cardNumberTxt.setEditable(false);
        cardNumberTxt.setBackground(new java.awt.Color(255, 255, 255));
        cardNumberTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        cardNumberTxt.setForeground(new java.awt.Color(0, 0, 153));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 255));
        jLabel17.setText("CARD NUMBER");

        penaltyTxt.setEditable(false);
        penaltyTxt.setBackground(new java.awt.Color(255, 255, 255));
        penaltyTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        penaltyTxt.setForeground(new java.awt.Color(0, 0, 153));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 255));
        jLabel18.setText("PENALTY");

        activityTxt.setEditable(false);
        activityTxt.setBackground(new java.awt.Color(255, 255, 255));
        activityTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        activityTxt.setForeground(new java.awt.Color(0, 0, 153));
        activityTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activityTxtActionPerformed(evt);
            }
        });

        startMTxt.setEditable(false);
        startMTxt.setBackground(new java.awt.Color(255, 255, 255));
        startMTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        startMTxt.setForeground(new java.awt.Color(0, 0, 153));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 255));
        jLabel19.setText("ACTIVITY");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 255));
        jLabel20.setText("STAR MEMBER DATE");

        pullMTxt.setEditable(false);
        pullMTxt.setBackground(new java.awt.Color(255, 255, 255));
        pullMTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        pullMTxt.setForeground(new java.awt.Color(0, 0, 153));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 204, 255));
        jLabel21.setText("PULL MEMBER DATE");

        statusTxt.setEditable(false);
        statusTxt.setBackground(new java.awt.Color(255, 255, 255));
        statusTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        statusTxt.setForeground(new java.awt.Color(0, 0, 153));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 204, 255));
        jLabel22.setText("STATUS");

        jLabel25.setBackground(new java.awt.Color(0, 0, 102));
        jLabel25.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("READER'S INFORMATION");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                        .addGap(225, 225, 225))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fullNameTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pullMTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cardNumberTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(identityTxt)
                            .addComponent(penaltyTxt)
                            .addComponent(activityTxt)
                            .addComponent(startMTxt)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132)
                        .addComponent(statusTxt)))
                .addContainerGap())
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel25)
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(fullNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(identityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cardNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(penaltyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(activityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startMTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(pullMTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator1.setBackground(new java.awt.Color(0, 0, 51));

        jPanel5.setBackground(new java.awt.Color(0, 0, 102));

        orderBtn.setBackground(new java.awt.Color(0, 0, 102));
        orderBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        orderBtn.setForeground(new java.awt.Color(204, 204, 255));
        orderBtn.setText("Order");
        orderBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255)));
        orderBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        orderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderBtnActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 102));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Clear");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255)));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        employeeNameComboForHome.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        employeeNameComboForHome.setForeground(new java.awt.Color(0, 0, 153));
        employeeNameComboForHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeNameComboForHomeActionPerformed(evt);
            }
        });

        bookTxtForHome.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        bookTxtForHome.setForeground(new java.awt.Color(0, 0, 51));
        bookTxtForHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookTxtForHomeMouseClicked(evt);
            }
        });
        bookTxtForHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookTxtForHomeActionPerformed(evt);
            }
        });
        bookTxtForHome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bookTxtForHomeKeyPressed(evt);
            }
        });

        withNewBookBtn.setBackground(new java.awt.Color(0, 0, 102));
        withNewBookBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        withNewBookBtn.setForeground(new java.awt.Color(204, 204, 255));
        withNewBookBtn.setText("New Order With New Book");
        withNewBookBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255)));
        withNewBookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        withNewBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withNewBookBtnActionPerformed(evt);
            }
        });

        readerComboForSearchForHome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        readerComboForSearchForHome.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                readerComboForSearchForHomeItemStateChanged(evt);
            }
        });

        locatedBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/bookshelf.png"))); // NOI18N
        locatedBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        locatedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locatedBtnActionPerformed(evt);
            }
        });

        infoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/reading.png"))); // NOI18N
        infoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        infoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoBtnActionPerformed(evt);
            }
        });

        jLabel26.setBackground(new java.awt.Color(0, 0, 51));
        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 204, 255));
        jLabel26.setText("Employee Full Name");

        searchBookComboForHome.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                searchBookComboForHomeItemStateChanged(evt);
            }
        });

        jLabel27.setBackground(new java.awt.Color(0, 0, 51));
        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 204, 255));
        jLabel27.setText("Book Name");

        readerSearchTxtForHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                readerSearchTxtForHomeMouseClicked(evt);
            }
        });
        readerSearchTxtForHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readerSearchTxtForHomeActionPerformed(evt);
            }
        });
        readerSearchTxtForHome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                readerSearchTxtForHomeKeyPressed(evt);
            }
        });

        jLabel28.setBackground(new java.awt.Color(0, 0, 51));
        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(204, 204, 255));
        jLabel28.setText("Reader Full Name");

        newOrder.setBackground(new java.awt.Color(0, 0, 102));
        newOrder.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        newOrder.setForeground(new java.awt.Color(255, 255, 255));
        newOrder.setText("New Order");
        newOrder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        newOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(readerComboForSearchForHome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(readerSearchTxtForHome)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(employeeNameComboForHome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bookTxtForHome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchBookComboForHome, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(locatedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(infoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(withNewBookBtn))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(newOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(92, 92, 92)
                        .addComponent(orderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeNameComboForHome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bookTxtForHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(searchBookComboForHome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)))
                .addComponent(locatedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(readerSearchTxtForHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(readerComboForSearchForHome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(infoBtn)
                .addGap(86, 86, 86)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(withNewBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minimizeBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeBtn1ActionPerformed
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_minimizeBtn1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "Are You Sure, Close Program?");
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

    private void backBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn1ActionPerformed
        OrderInfoFrame frame = new OrderInfoFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtn1ActionPerformed

    private void orderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderBtnActionPerformed
        try {
            if (searchBookComboForHome.isShowing() && readerComboForSearchForHome.isShowing()) {
                if ((!employeeNameComboForHome.getSelectedItem().equals("Select Employee"))
                        && (!searchBookComboForHome.getSelectedItem().equals("Search  Fail"))
                        && (!searchBookComboForHome.getSelectedItem().equals("Select Book From List"))
                        && (!searchBookComboForHome.getSelectedItem().equals("Select Book"))
                        && (!readerComboForSearchForHome.getSelectedItem().equals("Search  Fail"))
                        && (!readerComboForSearchForHome.getSelectedItem().equals("Select Reader From List"))) {
                    Item itemEmp = (Item) employeeNameComboForHome.getSelectedItem();
                    Long empId = itemEmp.getId();
                    Item itemBook = (Item) searchBookComboForHome.getSelectedItem();
                    Long bookId = itemBook.getId();
                    Item itemReader = (Item) readerComboForSearchForHome.getSelectedItem();
                    Long readerId = itemReader.getId();
                    Book book = bookService.getBookById(bookId);
                    Reader reader = readerService.getReaderById(readerId);
                    Integer getOrderActivity = orderInHomeService.getOrderActive(readerId, bookId);
                    if (getOrderActivity != null && getOrderActivity == 1) {
                        JOptionPane.showMessageDialog(null, "This Order Is Still Active!");
                    } else {
                        if (book.getAllBookCount() > 0) {
                            boolean isOderInHome = orderInHomeService.addOrderInHome(empId, readerId, bookId);
                            if (isOderInHome) {
                                JOptionPane.showMessageDialog(null, "ORDER iS SUCCESS!", "Success", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\LibraryDesktopProject\\src\\project\\library\\desktop\\gui\\icon\\tick.png"));
                                Integer bookDec = book.getAllBookCount() - 1;
                                boolean updateBook = bookService.updateBookForOrder(bookId, bookDec);
                                if (updateBook) {
                                    System.out.println("Update Book success!");
                                } else {
                                    System.out.println("Update Book Error!");
                                }
                                int act = reader.getActivity();
                                Integer bookSum1 = readerService.addActivity(readerId);
                                Integer bookSum2 = readerService.getBookCountForHome(readerId);
                                Integer bookSum = bookSum1 + bookSum2;
                                if (bookSum == 50) {// 1 ilde 50 den cox kitab +1 activity
                                    act = act + 1;
                                    readerService.increaseActivity(readerId, act);
                                }
                                orderBtn.setEnabled(false);
                                orderBtn.setForeground(Color.red);
                                withNewBookBtn.setEnabled(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "ORDER IS FAIL!", "Fail", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\LibraryDesktopProject\\src\\project\\library\\desktop\\gui\\icon\\report.png"));

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Now, This Book Count Is Zero! "
                                    + "Please Wait");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ORDER NOT COMPLETED");
                }
            } else {
                JOptionPane.showMessageDialog(null, "ORDER NOT COMPLETED");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_orderBtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clear();
        orderBtn.setForeground(Color.WHITE);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void bookTxtForHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookTxtForHomeMouseClicked
        locatedBtn.setVisible(true);
        searcBook = bookTxtForHome.getText();
        if (searcBook != null) {
            showBookComboSearch(searcBook);
            searchBookComboForHome.setVisible(true);
        } else {
            showBookCombo();
        }
        if (evt.getClickCount() == 2) {
            bookTxtForHome.setText("");
        }
    }//GEN-LAST:event_bookTxtForHomeMouseClicked

    private void bookTxtForHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookTxtForHomeActionPerformed
        locatedBtn.setVisible(true);
        searcBook = bookTxtForHome.getText();
        if (searcBook != null) {
            showBookComboSearch(searcBook);
            searchBookComboForHome.setVisible(true);
        } else {
            showBookCombo();
        }
    }//GEN-LAST:event_bookTxtForHomeActionPerformed

    private void bookTxtForHomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookTxtForHomeKeyPressed
        searcBook = bookTxtForHome.getText();
        if (searcBook != null) {
            showBookComboSearch(searcBook);
            searchBookComboForHome.setVisible(true);
        } else {
            showBookCombo();
        }
    }//GEN-LAST:event_bookTxtForHomeKeyPressed

    private void withNewBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withNewBookBtnActionPerformed
        searchBookComboForHome.setVisible(false);
        bookTxtForHome.setText("");
        orderBtn.setEnabled(true);
        readerComboForSearchForHome.setEnabled(false);
        orderBtn.setForeground(Color.WHITE);

    }//GEN-LAST:event_withNewBookBtnActionPerformed

    private void readerComboForSearchForHomeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_readerComboForSearchForHomeItemStateChanged

        try {
//            if (readerComboForSearchForHome.getSelectedIndex() >= 0) {
//                infoBtn.setVisible(true);
//                Item item = (Item) readerComboForSearchForHome.getSelectedItem();
//                Long id = item.getId();
//                Float penalty = readerService.getPenalty(6, String.valueOf(id));
//                readerPenaltyTxt.setVisible(true);
//                if (penalty != null) {
//                    readerPenaltyTxt.setText(String.valueOf(penalty));
//                }
//            } else {
//                readerPenaltyTxt.setText("0");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_readerComboForSearchForHomeItemStateChanged

    private void locatedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locatedBtnActionPerformed
        jPanel3.setVisible(true);
        bookItem();

    }//GEN-LAST:event_locatedBtnActionPerformed

    private void infoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoBtnActionPerformed
        jPanel4.setVisible(true);
        showReaderForOrder();
    }//GEN-LAST:event_infoBtnActionPerformed

    private void searchBookComboForHomeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_searchBookComboForHomeItemStateChanged
        locatedBtn.setVisible(true);
    }//GEN-LAST:event_searchBookComboForHomeItemStateChanged

    private void readerSearchTxtForHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_readerSearchTxtForHomeMouseClicked
        searchReader = readerSearchTxtForHome.getText();
        if (searchReader != null) {
            readerComboForSearchForHome.setVisible(true);
            searchReader(searchReader);
        } else {
            readers();
        }
        if (evt.getClickCount() == 2) {
            readerSearchTxtForHome.setText("");

        }
    }//GEN-LAST:event_readerSearchTxtForHomeMouseClicked

    private void readerSearchTxtForHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readerSearchTxtForHomeActionPerformed
        searchReader = readerSearchTxtForHome.getText();
        if (searchReader != null) {
            readerComboForSearchForHome.setVisible(true);
            searchReader(searchReader);
        } else {
            readers();
        }
    }//GEN-LAST:event_readerSearchTxtForHomeActionPerformed

    private void readerSearchTxtForHomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_readerSearchTxtForHomeKeyPressed
        searchReader = readerSearchTxtForHome.getText();
        if (searchReader != null) {
            readerComboForSearchForHome.setVisible(true);
            searchReader(searchReader);
        } else {
            readers();
        }
    }//GEN-LAST:event_readerSearchTxtForHomeKeyPressed

    private void isbnTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isbnTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isbnTxtActionPerformed

    private void employeeNameComboForHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeNameComboForHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeNameComboForHomeActionPerformed

    private void activityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activityTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_activityTxtActionPerformed

    private void newOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOrderActionPerformed
        clear();
        orderBtn.setEnabled(true);
        withNewBookBtn.setEnabled(true);
        readerComboForSearchForHome.setEnabled(true);
        orderBtn.setForeground(Color.WHITE);
    }//GEN-LAST:event_newOrderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField activityTxt;
    private javax.swing.JButton backBtn1;
    private javax.swing.JTextField bookTxtForHome;
    private javax.swing.JTextField cardNumberTxt;
    private javax.swing.JTextField caseTxt;
    private javax.swing.JTextField countTxt;
    private javax.swing.JComboBox<String> employeeNameComboForHome;
    private javax.swing.JTextField fullNameTxt;
    private javax.swing.JTextField identityTxt;
    private javax.swing.JButton infoBtn;
    private javax.swing.JTextField isbnTxt;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField languageTxt;
    private javax.swing.JTextField limitTimeTxt;
    private javax.swing.JButton locatedBtn;
    private javax.swing.JButton minimizeBtn1;
    private javax.swing.JButton newOrder;
    private javax.swing.JButton orderBtn;
    private javax.swing.JTextField penaltyTxt;
    private javax.swing.JTextField pullMTxt;
    private javax.swing.JComboBox<String> readerComboForSearchForHome;
    private javax.swing.JTextField readerSearchTxtForHome;
    private javax.swing.JButton restoreBtn1;
    private javax.swing.JTextField roomFloorTxt;
    private javax.swing.JTextField roomNumberTxt;
    private javax.swing.JComboBox<String> searchBookComboForHome;
    private javax.swing.JTextField shelfTxt;
    private javax.swing.JTextField startMTxt;
    private javax.swing.JTextField statusTxt;
    private javax.swing.JTextField titleTxt;
    private javax.swing.JButton withNewBookBtn;
    // End of variables declaration//GEN-END:variables
 private void showEmployeeCombo(Long id) {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) employeeNameComboForHome.getModel();
            List<Employee> employeeList = employeeService.getEmployeeList(1);
            model.addElement("Select Employee");
            for (Employee employee : employeeList) {
                model.addElement(new Item(employee.getId(), employee.getFirstName() + " " + employee.getLastName()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void showBookComboSearch(String search) {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) searchBookComboForHome.getModel();
            List<Item> filterList = new ArrayList<>();
            List<Book> bookList = bookService.gtBookForOrder();
            for (Book book : bookList) {
                if (book.getTitle().toLowerCase().contains(search.toLowerCase()) || String.valueOf(book.getIsbn()).contains(search)) {
                    filterList.add(new Item(book.getId(), book.getIsbn().toString() + " " + book.getTitle() + " " + book.getAuthor().getFirstName()));
                }
                if (filterList.size() > 0) {
                    model.removeAllElements();
                    for (Item filter : filterList) {
                        model.addElement(new Item(filter.getId(), filter.getValue()));
                    }

                } else if (filterList.size() == 0) {
                    model.removeAllElements();
                    model.setSelectedItem("Search  Fail");
                    model.addElement("Select Book From List");
                    showBookCombo();
                }
                JTextField textfield = (JTextField) searchBookComboForHome.getEditor().getEditorComponent();
                textfield.setText(search);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void showBookCombo() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) searchBookComboForHome.getModel();
            List<Book> bookList = bookService.gtBookForOrder();
            for (Book book : bookList) {
                model.addElement(new Item(book.getId(), book.getIsbn().toString() + " " + book.getTitle() + " " + book.getAuthor().getFirstName()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void searchReader(String search) {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) readerComboForSearchForHome.getModel();
            List<Item> filterList = new ArrayList<>();
            List<Reader> readerList = readerService.getReaderList();
            for (Reader reader : readerList) {
                if (reader.getFatherName() != null) {
                    if (reader.getFirstName().toLowerCase().contains(search.toLowerCase())
                            || reader.getFatherName().toLowerCase().contains(search.toLowerCase())
                            || reader.getLastName().toLowerCase().contains(search.toLowerCase())
                            || reader.getCardNumber().toLowerCase().contains(search.toLowerCase())
                            || reader.getIdentifyNumber().toLowerCase().contains(search.toLowerCase())) {
                        filterList.add(new Item(reader.getId(), reader.getCardNumber() + " " + reader.getFirstName() + " " + reader.getLastName()));
                    }
                } else {
                    if (reader.getFirstName().toLowerCase().contains(search.toLowerCase())
                            || reader.getLastName().toLowerCase().contains(search.toLowerCase())
                            || reader.getCardNumber().toLowerCase().contains(search.toLowerCase())
                            || reader.getIdentifyNumber().toLowerCase().contains(search.toLowerCase())) {
                        filterList.add(new Item(reader.getId(), reader.getCardNumber() + " " + reader.getFirstName() + " " + reader.getLastName()));
                    }
                }
                if (filterList.size() > 0) {
                    model.removeAllElements();
                    for (Item item : filterList) {
                        model.addElement(new Item(item.getId(), item.getValue()));
                    }

                } else {
                    model.removeAllElements();
                    model.setSelectedItem("Search  Fail");
                    model.addElement("Select Reader From List");
                    readers();
                }
            }
            JTextField textfield = (JTextField) readerComboForSearchForHome.getEditor().getEditorComponent();
            textfield.setText(search);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void readers() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) readerComboForSearchForHome.getModel();
            List<Reader> readerList = readerService.getReaderList();
            for (Reader reader : readerList) {
                model.addElement(new Item(reader.getId(), reader.getCardNumber() + " " + reader.getFirstName() + " " + reader.getLastName()));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void bookItem() {
        try {
            if ((!searchBookComboForHome.getSelectedItem().equals("Search  Fail")) && (!searchBookComboForHome.getSelectedItem().equals("Select Book From List")) && (!searchBookComboForHome.getSelectedItem().equals("Select Book"))) {
                Item item = (Item) searchBookComboForHome.getSelectedItem();
                Long id = item.getId();
                Book book = bookService.getBookForOrder(id);
                isbnTxt.setText(String.valueOf(book.getIsbn()));
                titleTxt.setText(book.getTitle());
                if (book.getLanguage() != null) {
                    languageTxt.setText(book.getLanguage().getBookLanguage());
                } else {
                    languageTxt.setText("unknow");
                }
                if (book.getbCase() != null) {
                    caseTxt.setText(book.getbCase().getCaseName());
                } else {
                    caseTxt.setText("unknow");
                }
                if (book.getAllBookCount() != null) {
                    countTxt.setText(String.valueOf(book.getAllBookCount()));
                } else {
                    countTxt.setText("0");
                }
                if (book.getLimitDay() != null) {
                    limitTimeTxt.setText(String.valueOf(book.getLimitDay()));
                } else {
                    limitTimeTxt.setText("0");
                }
                if (book.getBookRoom().getFloor() != null) {
                    roomFloorTxt.setText(String.valueOf(book.getBookRoom().getFloor()));
                } else {
                    roomFloorTxt.setText("unknow");
                }
                if (book.getBookRoom().getNumber() != null) {
                    roomNumberTxt.setText(book.getBookRoom().getNumber());
                } else {
                    roomNumberTxt.setText("unknow");
                }
                if (book.getBookShelf().getShelfNumber() != null) {
                    shelfTxt.setText(book.getBookShelf().getShelfNumber());
                } else {
                    shelfTxt.setText("unknow");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Select Book!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void showReaderForOrder() {
        try {
            if ((!readerComboForSearchForHome.getSelectedItem().equals("Search  Fail"))
                    && (!readerComboForSearchForHome.getSelectedItem().equals("Select Reader From List"))
                    && (!readerComboForSearchForHome.getSelectedItem().equals("Select Reader"))) {
                Item item = (Item) readerComboForSearchForHome.getSelectedItem();
                Long id = item.getId();
                Reader reader = readerService.getReaderForOrder(id);
                if (reader.getFatherName() != null) {
                    fullNameTxt.setText(reader.getFirstName() + " " + reader.getLastName() + " " + reader.getFatherName());
                } else {
                    fullNameTxt.setText(reader.getFirstName() + " " + reader.getLastName());
                }
                identityTxt.setText(reader.getIdentifyNumber());
                cardNumberTxt.setText(reader.getCardNumber());
                if (reader.getPenalty() != null) {
                    penaltyTxt.setText(String.valueOf(reader.getPenalty()));
                } else {
                    penaltyTxt.setText("0");
                }
                if (reader.getActivity() != null) {
                    activityTxt.setText(String.valueOf(reader.getActivity()));
                } else {
                    activityTxt.setText("0");
                }
                if (reader.getStatus() != null) {
                    statusTxt.setText(reader.getStatus());
                } else {
                    statusTxt.setText("unknow");
                }
                startMTxt.setText(String.valueOf(reader.getStartMemberDate()));
                pullMTxt.setText(String.valueOf(reader.getPullMemberDate()));
            } else {
                JOptionPane.showMessageDialog(null, "Select Reader!");
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
                    c.setBackground(Color.BLUE.darker().darker().darker());
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
        withNewBookBtn.setEnabled(false);
        employeeNameComboForHome.setSelectedIndex(0);
        searchBookComboForHome.setSelectedIndex(-1);
        readerComboForSearchForHome.setSelectedIndex(-1);
        bookTxtForHome.setText("");
        readerSearchTxtForHome.setText("");
        isbnTxt.setText("");
        titleTxt.setText("");
        languageTxt.setText("");
        caseTxt.setText("");
        limitTimeTxt.setText("");
        roomFloorTxt.setText("");
        roomNumberTxt.setText("");
        shelfTxt.setText("");
        fullNameTxt.setText("");
        identityTxt.setText("");
        cardNumberTxt.setText("");
        penaltyTxt.setText("");
        activityTxt.setText("");
        startMTxt.setText("");
        pullMTxt.setText("");
        statusTxt.setText("");
    }
}
