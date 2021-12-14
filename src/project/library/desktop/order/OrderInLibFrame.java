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
import javax.swing.Timer;
import javax.swing.UIManager;
import project.library.desktop.Desktop_Gui.Item;
import project.library.desktop.model.Book;
import project.library.desktop.model.Login;
import project.library.desktop.model.OrderInLib;
import project.library.desktop.model.ReadRoom;
import project.library.desktop.model.ReadTable;
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
 * @Ulviyye Ibrahimli
 */
public class OrderInLibFrame extends javax.swing.JFrame {

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
    Timer timer;
    ButtonGroup buttonGroup = new ButtonGroup();

    public OrderInLibFrame() {
        initComponents();
    }

    OrderInLibFrame(DepartmentService departmentService,
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
        try {
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.darker().darker());
        } catch (Exception e) {
            e.printStackTrace();
        }        
        employeeNameCombo.setRenderer(new OrderInLibFrame.TwoDecimalRenderer(employeeNameCombo.getRenderer()));
        searchBookCombo.setRenderer(new OrderInLibFrame.TwoDecimalRenderer(searchBookCombo.getRenderer()));
        searchBookCombo.setRenderer(new OrderInLibFrame.TwoDecimalRenderer(searchBookCombo.getRenderer()));
        roomCombo.setRenderer(new OrderInLibFrame.TwoDecimalRenderer(roomCombo.getRenderer()));
        tableCombo.setRenderer(new OrderInLibFrame.TwoDecimalRenderer(tableCombo.getRenderer()));
        this.getContentPane().setBackground(Color.BLUE.darker().darker().darker());
        locatedBtn.setVisible(false);
        infoBtn.setVisible(false);
        showEmployeeCombo((long) 11);//duzeltmek , add position id
        searchBookCombo.setVisible(false);
        readerComboForSearch.setVisible(false);
        showReaderRoom();
        buttonGroup.add(withCompRadio);
        buttonGroup.add(withoutcomRadio);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        orderBtn = new javax.swing.JButton();
        employeeNameCombo = new javax.swing.JComboBox<>();
        bookTxt = new javax.swing.JTextField();
        readerComboForSearch = new javax.swing.JComboBox<>();
        roomCombo = new javax.swing.JComboBox<>();
        tableCombo = new javax.swing.JComboBox<>();
        searchBookCombo = new javax.swing.JComboBox<>();
        readerSearchTxt = new javax.swing.JTextField();
        withCompRadio = new javax.swing.JRadioButton();
        withoutcomRadio = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        withNewBookBtn = new javax.swing.JButton();
        locatedBtn = new javax.swing.JButton();
        infoBtn = new javax.swing.JButton();
        newOrder = new javax.swing.JButton();
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
        jLabel19 = new javax.swing.JLabel();
        startMTxt = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        pullMTxt = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        statusTxt = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 51));
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
        jLabel23.setText("ORDER IN LIBRARY");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimizeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(restoreBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(minimizeBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(restoreBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));

        jLabel1.setBackground(new java.awt.Color(0, 0, 51));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setText("Employee Full Name");

        jLabel2.setBackground(new java.awt.Color(0, 0, 51));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setText("Book Name");

        jLabel3.setBackground(new java.awt.Color(0, 0, 51));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 255));
        jLabel3.setText("Reader Full Name");

        jLabel4.setBackground(new java.awt.Color(0, 0, 51));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 255));
        jLabel4.setText("Room Number");

        jLabel5.setBackground(new java.awt.Color(0, 0, 51));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 255));
        jLabel5.setText("Table Number");

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

        bookTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        bookTxt.setForeground(new java.awt.Color(0, 0, 153));
        bookTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookTxtMouseClicked(evt);
            }
        });
        bookTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookTxtActionPerformed(evt);
            }
        });
        bookTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bookTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bookTxtKeyReleased(evt);
            }
        });

        readerComboForSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        readerComboForSearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                readerComboForSearchItemStateChanged(evt);
            }
        });

        roomCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                roomComboItemStateChanged(evt);
            }
        });

        tableCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tableCombo.setForeground(new java.awt.Color(0, 0, 102));
        tableCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Table" }));

        searchBookCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                searchBookComboItemStateChanged(evt);
            }
        });
        searchBookCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBookComboActionPerformed(evt);
            }
        });

        readerSearchTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        readerSearchTxt.setForeground(new java.awt.Color(0, 0, 153));
        readerSearchTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                readerSearchTxtMouseClicked(evt);
            }
        });
        readerSearchTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readerSearchTxtActionPerformed(evt);
            }
        });
        readerSearchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                readerSearchTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                readerSearchTxtKeyReleased(evt);
            }
        });

        withCompRadio.setBackground(new java.awt.Color(0, 0, 102));
        withCompRadio.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        withCompRadio.setForeground(new java.awt.Color(204, 204, 255));
        withCompRadio.setText("With Computer");
        withCompRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withCompRadioActionPerformed(evt);
            }
        });

        withoutcomRadio.setBackground(new java.awt.Color(0, 0, 102));
        withoutcomRadio.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        withoutcomRadio.setForeground(new java.awt.Color(204, 204, 255));
        withoutcomRadio.setText("Without Computer");
        withoutcomRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withoutcomRadioActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 204, 255));
        jButton2.setText("Clear");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255)));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        withNewBookBtn.setBackground(new java.awt.Color(0, 0, 102));
        withNewBookBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        withNewBookBtn.setForeground(new java.awt.Color(204, 204, 255));
        withNewBookBtn.setText("New Order With The Same Reader");
        withNewBookBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255)));
        withNewBookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        withNewBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withNewBookBtnActionPerformed(evt);
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

        newOrder.setBackground(new java.awt.Color(0, 0, 102));
        newOrder.setForeground(new java.awt.Color(255, 255, 255));
        newOrder.setText("New Order");
        newOrder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        newOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOrderActionPerformed(evt);
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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(newOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(87, 87, 87)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(withNewBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orderBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(infoBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(locatedBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(searchBookCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bookTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(employeeNameCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tableCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(readerComboForSearch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(roomCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(readerSearchTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(withoutcomRadio)
                                        .addGap(77, 77, 77)
                                        .addComponent(withCompRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBookCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(132, 132, 132)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(63, 63, 63)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(locatedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(readerSearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(readerComboForSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(infoBtn)
                        .addGap(38, 38, 38)
                        .addComponent(roomCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(withoutcomRadio)
                            .addComponent(withCompRadio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tableCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(withNewBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 255));
        jLabel6.setText("ISBN");

        isbnTxt.setEditable(false);
        isbnTxt.setBackground(new java.awt.Color(255, 255, 255));
        isbnTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        isbnTxt.setForeground(new java.awt.Color(0, 0, 153));

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
        jLabel11.setText("LIMIT TIME");

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
                        .addComponent(caseTxt))
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
                        .addComponent(isbnTxt))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shelfTxt)
                            .addComponent(roomNumberTxt))))
                .addGap(26, 26, 26))
            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 102));
        jPanel4.setForeground(new java.awt.Color(0, 0, 204));
        jPanel4.setRequestFocusEnabled(false);
        jPanel4.setVerifyInputWhenFocusTarget(false);

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

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 255));
        jLabel19.setText("ACTIVITY");

        startMTxt.setEditable(false);
        startMTxt.setBackground(new java.awt.Color(255, 255, 255));
        startMTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        startMTxt.setForeground(new java.awt.Color(0, 0, 153));
        startMTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startMTxtActionPerformed(evt);
            }
        });

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
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(statusTxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startMTxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cardNumberTxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(penaltyTxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pullMTxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fullNameTxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(identityTxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(activityTxt, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(26, 26, 26))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(fullNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(identityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cardNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(penaltyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(activityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startMTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(pullMTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(statusTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jSeparator1.setBackground(new java.awt.Color(0, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookTxtActionPerformed
        locatedBtn.setVisible(true);
        searcBook = bookTxt.getText();
        if (searcBook != null) {
            showBookComboSearch(searcBook);
            searchBookCombo.setVisible(true);
        } else {
            showBookCombo();
        }


    }//GEN-LAST:event_bookTxtActionPerformed

    private void bookTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookTxtMouseClicked
        locatedBtn.setVisible(true);
        searcBook = bookTxt.getText();
        if (searcBook != null) {
            showBookComboSearch(searcBook);
            searchBookCombo.setVisible(true);
        } else {
            showBookCombo();
        }
        if (evt.getClickCount() == 2) {
            bookTxt.setText("");
        }
    }//GEN-LAST:event_bookTxtMouseClicked

    private void readerSearchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readerSearchTxtActionPerformed
        searchReader = readerSearchTxt.getText();
        infoBtn.setVisible(true);
        if (searchReader != null) {
            readerComboForSearch.setVisible(true);
            searchReader(searchReader);
        } else {
            readers();
        }
    }//GEN-LAST:event_readerSearchTxtActionPerformed

    private void readerSearchTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_readerSearchTxtMouseClicked
        searchReader = readerSearchTxt.getText();
        infoBtn.setVisible(true);
        if (searchReader != null) {
            readerComboForSearch.setVisible(true);
            searchReader(searchReader);
        } else {
            readers();
        }
        if (evt.getClickCount() == 2) {
            readerSearchTxt.setText("");

        }
    }//GEN-LAST:event_readerSearchTxtMouseClicked

    private void withCompRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withCompRadioActionPerformed
        withCompRadio.setText("withComputer");
        withCompRadio.setActionCommand("withComputer");
        if (withCompRadio.isSelected()) {
            if (roomCombo.getSelectedIndex() != 0) {
                Item item = (Item) roomCombo.getSelectedItem();
                Long id = item.getId();
                showRoomTableComboWithComp(id);
            }
        }
    }//GEN-LAST:event_withCompRadioActionPerformed

    private void roomComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_roomComboItemStateChanged
        if (roomCombo.getSelectedIndex() != 0) {
            Item item = (Item) roomCombo.getSelectedItem();
            Long selectRoom = item.getId();
            if (evt.getStateChange() == 1) {
                if (withCompRadio.isSelected()) {
                    showRoomTableComboWithComp(selectRoom);
                }
                if (withoutcomRadio.isSelected()) {
                    showRoomTableComboWithoutComp(selectRoom);
                }
            }
        }
    }//GEN-LAST:event_roomComboItemStateChanged

    private void withoutcomRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withoutcomRadioActionPerformed
        withoutcomRadio.setText("withoutComputer");
        withoutcomRadio.setActionCommand("withoutComputer");
        if (withoutcomRadio.isSelected()) {
            if (roomCombo.getSelectedIndex() > 0) {
                Item item = (Item) roomCombo.getSelectedItem();
                Long id = item.getId();
                showRoomTableComboWithoutComp(id);
            }
        }
    }//GEN-LAST:event_withoutcomRadioActionPerformed

    private void orderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderBtnActionPerformed
        try {
            if (searchBookCombo.isShowing() && readerComboForSearch.isShowing()) {
                if ((!employeeNameCombo.getSelectedItem().equals("Select Employee"))
                        && (!searchBookCombo.getSelectedItem().equals("Search  Fail"))
                        && (!searchBookCombo.getSelectedItem().equals("Select Book From List"))
                        && (!searchBookCombo.getSelectedItem().equals("Select Book"))
                        && (!readerComboForSearch.getSelectedItem().equals("Search  Fail"))
                        && (!readerComboForSearch.getSelectedItem().equals("Select Reader From List"))
                        && (!roomCombo.getSelectedItem().equals("Select Room")
                        && (withCompRadio.isSelected() || withoutcomRadio.isSelected())
                        && (!tableCombo.getSelectedItem().equals("Select Table")))) {
                    Item employeeItem = (Item) employeeNameCombo.getSelectedItem();
                    Long empId = employeeItem.getId();
                    Item itemReader = (Item) readerComboForSearch.getSelectedItem();
                    Long readerId = itemReader.getId();
                    Item bookItem = (Item) searchBookCombo.getSelectedItem();
                    Long bookId = bookItem.getId();
                    Item roomItem = (Item) roomCombo.getSelectedItem();
                    Long roomId = roomItem.getId();
                    Item itemTable = (Item) tableCombo.getSelectedItem();
                    Long tableId = itemTable.getId();
                    Reader reader = readerService.getReaderById(readerId);
                    Book book = bookService.getBookById(bookId);
                    int act = reader.getActivity();
                    Integer bookSum1 = readerService.addActivity(readerId);//fop lib
                    Integer bookSum2 = readerService.getBookCountForHome(readerId);
                    Integer bookSum = bookSum1 + bookSum2;
                    if (bookSum == 50) {// 1 ilde 50 den cox kitab +1 activity
                        act = act + 1;
                        readerService.increaseActivity(readerId, act);
                    }
                    Integer active = orderInLibService.getActive(readerId, bookId);
                    if (active != null && active == 1) {
                        JOptionPane.showMessageDialog(null, "This Order Is Still Active!");
                    } else {
                        if (book.getAllBookCount() != 0) {
                            boolean addOrder = orderInLibService.addOrder(empId, readerId, bookId, roomId, tableId);
                            if (addOrder) {
//                    Float bookLimit=bookService.getTimeLime(bookItem.getId());
//                    Float orderStar=orderInLibService.getTimeLimite(orderInLibService.getOrderId(roomItem.getId(), bookItem.getId()));
//                    Float finishOrder= orderStar-bookLimit;
//                    timer=new Timer(Math.round(finishOrder));

                                boolean updateTable = readTableService.update(tableId);
                                if (updateTable) {
                                    System.out.println("Success");
                                } else {
                                    System.out.println("fail");
                                }
                                Integer all = readTableService.allTable(tableId);
                                Integer full = readTableService.tableWhichSatatus1(tableId);
                                if ((all - full) == 0) {
                                    boolean updateRoom = readRoomService.updateForOrder(roomId);
                                    if (updateRoom) {
                                        System.out.println("Success Room update");

                                    } else {
                                        System.out.println("Fail Room Update");
                                    }
                                }
                                Integer bookDec = book.getAllBookCount() - 1;
                                bookService.updateBookForOrder(book.getId(), bookDec);
                                orderBtn.setEnabled(false);
                                orderBtn.setForeground(Color.red);
                                withNewBookBtn.setEnabled(true);
                                JOptionPane.showMessageDialog(null, "ORDER ADDING!", "Success", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/tick.png"));
                            } else {
                                JOptionPane.showMessageDialog(null, "ORDER IS NO ADD", "Fail", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/report.png"));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Now, This Book Count Is Zero! "
                                    + "Please Wait");
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Order Is Not Completion!");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Order Is Not Completion!");

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_orderBtnActionPerformed

    private void readerComboForSearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_readerComboForSearchItemStateChanged

    }//GEN-LAST:event_readerComboForSearchItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        clear();
        orderBtn.setForeground(Color.WHITE);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void withNewBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withNewBookBtnActionPerformed
        orderBtn.setForeground(Color.WHITE);
        try {
            Item readerId = (Item) readerComboForSearch.getSelectedItem();
            Long id = readerId.getId();
            OrderInLib roomAndTable = orderInLibService.getReaderCurrentRoomAndTable(id);
            roomCombo.setSelectedItem(roomAndTable.getReadRoom().getId());
            roomCombo.setEnabled(false);
            tableCombo.setSelectedItem(roomAndTable.getReadTable().getId());
            tableCombo.setEnabled(false);
            searchBookCombo.setVisible(false);
            withCompRadio.setEnabled(false);
            withoutcomRadio.setEnabled(false);
            readerComboForSearch.setEnabled(false);
            bookTxt.setText("");
            orderBtn.setEnabled(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_withNewBookBtnActionPerformed

    private void locatedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locatedBtnActionPerformed

        jPanel3.setVisible(true);
        bookItem();

    }//GEN-LAST:event_locatedBtnActionPerformed

    private void infoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoBtnActionPerformed
        if (readerComboForSearch.isShowing()) {
            jPanel4.setVisible(true);
            showReaderForOrder();
        }

    }//GEN-LAST:event_infoBtnActionPerformed

    private void searchBookComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_searchBookComboItemStateChanged


    }//GEN-LAST:event_searchBookComboItemStateChanged

    private void bookTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookTxtKeyPressed
        searcBook = bookTxt.getText();
        if (searcBook != null) {
            showBookComboSearch(searcBook);
            searchBookCombo.setVisible(true);
        } else {
            showBookCombo();
        }
    }//GEN-LAST:event_bookTxtKeyPressed

    private void readerSearchTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_readerSearchTxtKeyPressed
        searchReader = readerSearchTxt.getText();
        if (searchReader != null) {
            readerComboForSearch.setVisible(true);
            searchReader(searchReader);
        } else {
            readers();
        }
    }//GEN-LAST:event_readerSearchTxtKeyPressed

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
        this.dispose();
        OrderInfoFrame infoFrame = new OrderInfoFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        infoFrame.setVisible(true);
    }//GEN-LAST:event_backBtn1ActionPerformed

    private void startMTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startMTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startMTxtActionPerformed

    private void readerSearchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_readerSearchTxtKeyReleased
        searchReader = readerSearchTxt.getText();
        infoBtn.setVisible(true);

        if (searchReader != null) {
            readerComboForSearch.setVisible(true);
            searchReader(searchReader);
        } else {
            readers();
        }
    }//GEN-LAST:event_readerSearchTxtKeyReleased

    private void bookTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookTxtKeyReleased
        locatedBtn.setVisible(true);
        searcBook = bookTxt.getText();
        if (searcBook != null) {
            showBookComboSearch(searcBook);
            searchBookCombo.setVisible(true);
        } else {
            showBookCombo();
        }
    }//GEN-LAST:event_bookTxtKeyReleased

    private void searchBookComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBookComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBookComboActionPerformed

    private void newOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOrderActionPerformed
        clear();
        orderBtn.setEnabled(true);
        readerComboForSearch.setEnabled(true);
        roomCombo.setEnabled(true);
        tableCombo.setEnabled(true);
        withCompRadio.setEnabled(true);
        withoutcomRadio.setEnabled(true);
        orderBtn.setForeground(Color.WHITE);
    }//GEN-LAST:event_newOrderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField activityTxt;
    private javax.swing.JButton backBtn1;
    private javax.swing.JTextField bookTxt;
    private javax.swing.JTextField cardNumberTxt;
    private javax.swing.JTextField caseTxt;
    private javax.swing.JTextField countTxt;
    private javax.swing.JComboBox<String> employeeNameCombo;
    private javax.swing.JTextField fullNameTxt;
    private javax.swing.JTextField identityTxt;
    private javax.swing.JButton infoBtn;
    private javax.swing.JTextField isbnTxt;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField languageTxt;
    private javax.swing.JTextField limitTimeTxt;
    private javax.swing.JButton locatedBtn;
    private javax.swing.JButton minimizeBtn1;
    private javax.swing.JButton newOrder;
    private javax.swing.JButton orderBtn;
    private javax.swing.JTextField penaltyTxt;
    private javax.swing.JTextField pullMTxt;
    private javax.swing.JComboBox<String> readerComboForSearch;
    private javax.swing.JTextField readerSearchTxt;
    private javax.swing.JButton restoreBtn1;
    private javax.swing.JComboBox<String> roomCombo;
    private javax.swing.JTextField roomFloorTxt;
    private javax.swing.JTextField roomNumberTxt;
    private javax.swing.JComboBox<String> searchBookCombo;
    private javax.swing.JTextField shelfTxt;
    private javax.swing.JTextField startMTxt;
    private javax.swing.JTextField statusTxt;
    private javax.swing.JComboBox<String> tableCombo;
    private javax.swing.JTextField titleTxt;
    private javax.swing.JRadioButton withCompRadio;
    private javax.swing.JButton withNewBookBtn;
    private javax.swing.JRadioButton withoutcomRadio;
    // End of variables declaration//GEN-END:variables

    private void showEmployeeCombo(Long id) {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) employeeNameCombo.getModel();
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
            DefaultComboBoxModel model = (DefaultComboBoxModel) searchBookCombo.getModel();
            List<Item> filterList = new ArrayList<>();
            List<Book> bookList = bookService.gtBookForOrder();
            for (Book book : bookList) {
                if (book.getTitle().toLowerCase().contains(search.toLowerCase()) || String.valueOf(book.getIsbn()).contains(search)) {
                    filterList.add(new Item(book.getId(), book.getIsbn().toString() + "\\" + book.getTitle() + "\\" + book.getAuthor().getFirstName()));
                }
                if (filterList.size() > 0) {
                    model.removeAllElements();
                    for (Item filter : filterList) {
                        model.addElement(new Item(filter.getId(), filter.getValue()));
                    }
                    JTextField textfield = (JTextField) searchBookCombo.getEditor().getEditorComponent();
                    textfield.setText(search);

                } else if (filterList.size() == 0) {
                    model.removeAllElements();
                    model.setSelectedItem(new Item((long) 0, "Search  Fail"));
                    model.addElement(new Item((long) 1, "Select Book From List"));
                    showBookCombo();
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void showBookCombo() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) searchBookCombo.getModel();
            List<Book> bookList = bookService.gtBookForOrder();
            for (Book book : bookList) {
                model.removeAllElements();
                model.addElement(new Item(book.getId(), book.getIsbn().toString() + " " + book.getTitle() + " " + book.getAuthor().getFirstName()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void searchReader(String search) {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) readerComboForSearch.getModel();
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
                    JTextField textfield = (JTextField) readerComboForSearch.getEditor().getEditorComponent();
                    textfield.setText(search);
                } else {
                    model.removeAllElements();
                    model.setSelectedItem(new Item((long) 0, "Search  Fail"));
                    model.addElement(new Item((long) 1, "Select Reader From List"));
                    readers();
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void readers() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) readerComboForSearch.getModel();
            List<Reader> readerList = readerService.getReaderList();
            for (Reader reader : readerList) {
                model.addElement(new Item(reader.getId(), reader.getCardNumber() + " " + reader.getFirstName() + " " + reader.getLastName()));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void showReaderRoom() {
        try {
            List<ReadRoom> getReaderRoomList = readRoomService.getReaderRoomforOrder();
            DefaultComboBoxModel model = (DefaultComboBoxModel) roomCombo.getModel();
            model.addElement("Select Room");
            for (ReadRoom readRoom : getReaderRoomList) {
                model.addElement(new Item(readRoom.getId(), readRoom.getLibFloor() + ".  Floor \\" + readRoom.getReadRoomNumber() + " Room"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void showRoomTableComboWithComp(Long roomId) {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) tableCombo.getModel();
            model.removeAllElements();
            List<ReadTable> getTablesWithComp = readTableService.getTable(1, roomId);
            if (getTablesWithComp.size() > 0) {
                model.addElement("Select Table");
                for (ReadTable readTable : getTablesWithComp) {
                    model.addElement(new Item(readTable.getId(), readTable.getTableNumber()));
                }
            } else {
                model.removeAllElements();
                model.addElement("The table is impossible for now");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void showRoomTableComboWithoutComp(Long roomId) {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) tableCombo.getModel();
            model.removeAllElements();
            List<ReadTable> getTablesWithoutComp = readTableService.getTable(0, roomId);
            if (getTablesWithoutComp.size() > 0) {
                model.addElement("Select Table");
                for (ReadTable readTable : getTablesWithoutComp) {
                    model.addElement(new Item(readTable.getId(), readTable.getTableNumber()));
                }
            } else {
                model.removeAllElements();
                model.addElement("The table is impossible for now");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void bookItem() {
        try {
            if ((!searchBookCombo.getSelectedItem().equals("Select Book"))
                    && (!searchBookCombo.getSelectedItem().equals("Search  Fail"))
                    && (!searchBookCombo.getSelectedItem().equals("Select Book From List"))) {
                Item item = (Item) searchBookCombo.getSelectedItem();
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
                if (book.getAllBookCount() != 0&& book.getAllBookCount()!=null) {
                    countTxt.setText(String.valueOf(book.getAllBookCount()));
                } else {
                    countTxt.setText("0");
                }
                if (book.getLimitTime() != 0) {
                    limitTimeTxt.setText(String.valueOf(book.getLimitTime()));
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
            if (!readerComboForSearch.getSelectedItem().equals("Select Reader")
                    && (!readerComboForSearch.getSelectedItem().equals("Search  Fail"))
                    && (!readerComboForSearch.getSelectedItem().equals("Select Reader From List"))) {
                Item item = (Item) readerComboForSearch.getSelectedItem();
                Long id = item.getId();
                if (id != null) {
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
            } else {
                JOptionPane.showMessageDialog(null, "Select Reader");
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
        employeeNameCombo.setSelectedIndex(0);
        searchBookCombo.setVisible(false);
        readerComboForSearch.setVisible(false);
        roomCombo.setSelectedIndex(0);
        tableCombo.setSelectedIndex(0);
        bookTxt.setText("");
        readerSearchTxt.setText("");
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
        countTxt.setText("");
        activityTxt.setText("");
        startMTxt.setText("");
        pullMTxt.setText("");
        statusTxt.setText("");
        buttonGroup.clearSelection();
    }
}
