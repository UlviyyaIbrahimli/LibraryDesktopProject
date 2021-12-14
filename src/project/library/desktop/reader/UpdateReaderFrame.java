package project.library.desktop.reader;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Date;
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
import project.library.desktop.model.Login;
import project.library.desktop.model.Reader;
import project.library.desktop.model.Status;
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
 * @ Ulviyye Ibrahimli
 */
public class UpdateReaderFrame extends javax.swing.JFrame {

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
    private  StatusService statusService;
    private Long selectedId;
    private Login login;
    String keyword = "";
    String countrySearch = "";

    public UpdateReaderFrame() {
        initComponents();
    }

    UpdateReaderFrame(DepartmentService departmentService, PositionService positionService, BranchService branchService, EmployeeService employeeService, TimeTypeService timeTypeService, EducationTypeService educationTypeService, BookService bookService, AuthorService authorService, SubjectService subjectService, BookShelfService bookShelfService, BookRoomService bookRoomService, ReadRoomService readRoomService, ReadTableService readTableService, LanguageService languageService, ReaderService readerService, OrderInLibService orderInLibService, OrderInHomeService orderInHomeService, GiveBackBookService giveBackBookService, LoginService loginService, RoleService roleService, Long selectedId, Login login,StatusService statusService) {
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
            this.statusService=statusService;
            this.selectedId = selectedId;
            this.login = login;
            initComponents();
            Reader reader = readerService.getReaderById(selectedId);
            showOldDate(reader);
            activity(reader);
            if (reader.getNationality() != null) {
                nationalityCombo.setVisible(true);
                showOldNationality(reader);
            } else {
                nationalityCombo.setVisible(false);
            }
            if (reader.getCountry() != null) {
                showOldCountry(reader);
                countryCombo.setVisible(true);
            } else {
                countryCombo.setVisible(false);
            }
//            showOldComboStatuse(reader);
            hideWarning();
            this.setDefaultLookAndFeelDecorated(true);
            this.pack();
            this.setLocationRelativeTo(null);
            userNameTxt.setText("Welcome, " + login.getFirstName() + " " + login.getLastName() + " !");
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker().darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker().darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.WHITE);
            nationalityCombo.setRenderer(new UpdateReaderFrame.TwoDecimalRenderer(nationalityCombo.getRenderer()));
            countryCombo.setRenderer(new UpdateReaderFrame.TwoDecimalRenderer(countryCombo.getRenderer()));
            statusCombo.setRenderer(new UpdateReaderFrame.TwoDecimalRenderer(statusCombo.getRenderer()));
              showStatusOldCombo(reader);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        firstNameTxt = new javax.swing.JTextField();
        lastNameTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fatherNameTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        femaleRadio = new javax.swing.JRadioButton();
        maleRadio = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        dobCalendar = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        nationalityCombo = new javax.swing.JComboBox<>();
        searchNationalityTxt = new javax.swing.JTextField();
        lNameWTxt = new javax.swing.JTextField();
        fNameWTxt = new javax.swing.JTextField();
        fatherNameWTxt = new javax.swing.JTextField();
        genderWTxt = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        identityTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        phone1Txt = new javax.swing.JTextField();
        phone2Txt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        homePhoneTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        identityWTxt = new javax.swing.JTextField();
        emailWtxt = new javax.swing.JTextField();
        penaltylbl = new javax.swing.JLabel();
        activity = new javax.swing.JLabel();
        penaltyTxt = new javax.swing.JTextField();
        activityCombo = new javax.swing.JComboBox<>();
        actTxtW = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cityTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        streetTxt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        houseNumberTxt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        homeNumberTxt = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        statusCombo = new javax.swing.JComboBox<>();
        countryCombo = new javax.swing.JComboBox<>();
        searchCountryTxt = new javax.swing.JTextField();
        countryWTxt = new javax.swing.JTextField();
        statusWTxt = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        startMemberCalendar = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        pullMemberCalendar = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        cardNumberTxt = new javax.swing.JTextField();
        startDateWTxt = new javax.swing.JTextField();
        pullDateWTxt = new javax.swing.JTextField();
        cardWTxt = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        additionInfoTxt = new javax.swing.JTextArea();
        saveBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        userTxt = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        restoreBtn1 = new javax.swing.JButton();
        minimizeBtn1 = new javax.swing.JButton();
        backBtn1 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        userNameTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));

        jTabbedPane1.setForeground(new java.awt.Color(153, 0, 0));

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setBackground(new java.awt.Color(0, 0, 51));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("First Name");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        firstNameTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        firstNameTxt.setForeground(new java.awt.Color(0, 0, 51));
        firstNameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        firstNameTxt.setSelectionColor(new java.awt.Color(0, 0, 102));
        firstNameTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                firstNameTxtMouseClicked(evt);
            }
        });
        firstNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameTxtActionPerformed(evt);
            }
        });
        firstNameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                firstNameTxtKeyPressed(evt);
            }
        });

        lastNameTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lastNameTxt.setForeground(new java.awt.Color(0, 0, 51));
        lastNameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        lastNameTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lastNameTxtMouseClicked(evt);
            }
        });
        lastNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTxtActionPerformed(evt);
            }
        });
        lastNameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lastNameTxtKeyPressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 51));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Last Name");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel3.setBackground(new java.awt.Color(0, 0, 51));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Father Name");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        fatherNameTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        fatherNameTxt.setForeground(new java.awt.Color(0, 0, 51));
        fatherNameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        fatherNameTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fatherNameTxtMouseClicked(evt);
            }
        });
        fatherNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fatherNameTxtActionPerformed(evt);
            }
        });
        fatherNameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fatherNameTxtKeyPressed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 51));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gender");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        femaleRadio.setBackground(new java.awt.Color(0, 0, 51));
        femaleRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        femaleRadio.setForeground(new java.awt.Color(255, 255, 255));
        femaleRadio.setText("Female");
        femaleRadio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        femaleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioActionPerformed(evt);
            }
        });

        maleRadio.setBackground(new java.awt.Color(0, 0, 51));
        maleRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        maleRadio.setForeground(new java.awt.Color(255, 255, 255));
        maleRadio.setText("Male");
        maleRadio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        maleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 0, 51));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Day Of Births");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        dobCalendar.setForeground(new java.awt.Color(0, 0, 51));

        jLabel6.setBackground(new java.awt.Color(0, 0, 51));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nationality");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        nationalityCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nationalityCombo.setForeground(new java.awt.Color(0, 0, 51));
        nationalityCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        searchNationalityTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        searchNationalityTxt.setForeground(new java.awt.Color(0, 0, 51));
        searchNationalityTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchNationalityTxtMouseClicked(evt);
            }
        });
        searchNationalityTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchNationalityTxtActionPerformed(evt);
            }
        });
        searchNationalityTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchNationalityTxtKeyPressed(evt);
            }
        });

        lNameWTxt.setEditable(false);
        lNameWTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        lNameWTxt.setForeground(new java.awt.Color(153, 0, 0));

        fNameWTxt.setEditable(false);
        fNameWTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        fNameWTxt.setForeground(new java.awt.Color(153, 0, 0));
        fNameWTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fNameWTxtActionPerformed(evt);
            }
        });

        fatherNameWTxt.setEditable(false);
        fatherNameWTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        fatherNameWTxt.setForeground(new java.awt.Color(153, 0, 0));

        genderWTxt.setEditable(false);
        genderWTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        genderWTxt.setForeground(new java.awt.Color(153, 0, 0));
        genderWTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderWTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(fatherNameWTxt)
                    .addComponent(lNameWTxt)
                    .addComponent(fNameWTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(genderWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(femaleRadio)
                                .addGap(71, 71, 71)
                                .addComponent(maleRadio))
                            .addComponent(searchNationalityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nationalityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dobCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fatherNameTxt)
                            .addComponent(lastNameTxt))))
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fNameWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lNameWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(fatherNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(fatherNameWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(genderWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maleRadio)
                            .addComponent(femaleRadio))
                        .addGap(15, 15, 15)
                        .addComponent(dobCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchNationalityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(nationalityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Personal Data", jPanel3);

        jPanel4.setBackground(new java.awt.Color(0, 0, 51));

        identityTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                identityTxtMouseClicked(evt);
            }
        });
        identityTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identityTxtActionPerformed(evt);
            }
        });
        identityTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                identityTxtKeyPressed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 0, 51));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Identity");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        emailTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emailTxtMouseClicked(evt);
            }
        });
        emailTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTxtActionPerformed(evt);
            }
        });
        emailTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailTxtKeyPressed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(0, 0, 51));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel9.setBackground(new java.awt.Color(0, 0, 51));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Phone1");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        phone1Txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phone1TxtMouseClicked(evt);
            }
        });
        phone1Txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone1TxtActionPerformed(evt);
            }
        });
        phone1Txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phone1TxtKeyPressed(evt);
            }
        });

        phone2Txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phone2TxtMouseClicked(evt);
            }
        });
        phone2Txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone2TxtActionPerformed(evt);
            }
        });
        phone2Txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phone2TxtKeyPressed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(0, 0, 51));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Phone2");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        homePhoneTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homePhoneTxtMouseClicked(evt);
            }
        });
        homePhoneTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homePhoneTxtActionPerformed(evt);
            }
        });
        homePhoneTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                homePhoneTxtKeyPressed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(0, 0, 51));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Home Phone");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        identityWTxt.setForeground(new java.awt.Color(204, 0, 0));

        emailWtxt.setForeground(new java.awt.Color(153, 0, 0));

        penaltylbl.setBackground(new java.awt.Color(0, 0, 51));
        penaltylbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        penaltylbl.setForeground(new java.awt.Color(255, 255, 255));
        penaltylbl.setText("Penalty");
        penaltylbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        activity.setBackground(new java.awt.Color(0, 0, 51));
        activity.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        activity.setForeground(new java.awt.Color(255, 255, 255));
        activity.setText("Activity");
        activity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        penaltyTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        activityCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activityComboActionPerformed(evt);
            }
        });

        actTxtW.setEditable(false);
        actTxtW.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        actTxtW.setForeground(new java.awt.Color(102, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(253, 253, 253)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phone2Txt)
                                    .addComponent(homePhoneTxt)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(activity, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(penaltylbl, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(397, 397, 397)
                                        .addComponent(activityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(253, 253, 253)
                                        .addComponent(penaltyTxt))))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap(22, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(identityWTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                    .addComponent(emailWtxt))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phone1Txt)
                                    .addComponent(identityTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(emailTxt)))
                            .addComponent(actTxtW, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(identityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(identityWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phone1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(emailWtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phone2Txt, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homePhoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(penaltyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(activityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(actTxtW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(penaltylbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(activity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))))
        );

        jTabbedPane1.addTab("Personal Data", jPanel4);

        jPanel5.setBackground(new java.awt.Color(0, 0, 51));

        jLabel12.setBackground(new java.awt.Color(0, 0, 51));
        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Country");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        cityTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cityTxt.setForeground(new java.awt.Color(0, 0, 51));
        cityTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel13.setBackground(new java.awt.Color(0, 0, 51));
        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("City");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        streetTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        streetTxt.setForeground(new java.awt.Color(0, 0, 51));
        streetTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel14.setBackground(new java.awt.Color(0, 0, 51));
        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Street");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        jLabel15.setBackground(new java.awt.Color(0, 0, 51));
        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("House Number");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        houseNumberTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        houseNumberTxt.setForeground(new java.awt.Color(0, 0, 51));
        houseNumberTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel16.setBackground(new java.awt.Color(0, 0, 51));
        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Home Number");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        homeNumberTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        homeNumberTxt.setForeground(new java.awt.Color(0, 0, 51));
        homeNumberTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jLabel23.setBackground(new java.awt.Color(0, 0, 51));
        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Status");
        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        statusCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        statusCombo.setForeground(new java.awt.Color(0, 0, 51));
        statusCombo.setToolTipText("");
        statusCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        statusCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                statusComboItemStateChanged(evt);
            }
        });
        statusCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboActionPerformed(evt);
            }
        });

        countryCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        countryCombo.setForeground(new java.awt.Color(0, 0, 51));
        countryCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        countryCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        countryCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                countryComboItemStateChanged(evt);
            }
        });

        searchCountryTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        searchCountryTxt.setForeground(new java.awt.Color(0, 0, 51));
        searchCountryTxt.setBorder(null);
        searchCountryTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchCountryTxtMouseClicked(evt);
            }
        });
        searchCountryTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCountryTxtActionPerformed(evt);
            }
        });
        searchCountryTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchCountryTxtKeyPressed(evt);
            }
        });

        countryWTxt.setEditable(false);
        countryWTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        countryWTxt.setForeground(new java.awt.Color(153, 0, 0));

        statusWTxt.setEditable(false);
        statusWTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        statusWTxt.setForeground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 389, Short.MAX_VALUE)
                                .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(streetTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(houseNumberTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(homeNumberTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(statusWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(countryWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(searchCountryTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cityTxt, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addComponent(countryCombo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(countryWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchCountryTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(countryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streetTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(houseNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Address", jPanel5);

        jPanel6.setBackground(new java.awt.Color(0, 0, 51));

        jLabel18.setBackground(new java.awt.Color(0, 0, 51));
        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Start Membership");
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        startMemberCalendar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        startMemberCalendar.setForeground(new java.awt.Color(0, 0, 51));
        startMemberCalendar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        startMemberCalendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startMemberCalendarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startMemberCalendarMouseEntered(evt);
            }
        });
        startMemberCalendar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                startMemberCalendarKeyPressed(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(0, 0, 51));
        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Pull Membership");
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        pullMemberCalendar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        pullMemberCalendar.setForeground(new java.awt.Color(0, 0, 51));
        pullMemberCalendar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        pullMemberCalendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pullMemberCalendarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pullMemberCalendarMouseEntered(evt);
            }
        });
        pullMemberCalendar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pullMemberCalendarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pullMemberCalendarKeyReleased(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(0, 0, 51));
        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Card Number");
        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        cardNumberTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cardNumberTxt.setForeground(new java.awt.Color(0, 0, 51));
        cardNumberTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        cardNumberTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cardNumberTxtMouseClicked(evt);
            }
        });
        cardNumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardNumberTxtActionPerformed(evt);
            }
        });
        cardNumberTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cardNumberTxtKeyPressed(evt);
            }
        });

        startDateWTxt.setForeground(new java.awt.Color(153, 0, 0));

        pullDateWTxt.setForeground(new java.awt.Color(153, 0, 0));

        cardWTxt.setForeground(new java.awt.Color(153, 0, 0));

        jLabel21.setBackground(new java.awt.Color(0, 0, 51));
        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Add Information");
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        additionInfoTxt.setColumns(20);
        additionInfoTxt.setFont(new java.awt.Font("Monospaced", 2, 12)); // NOI18N
        additionInfoTxt.setForeground(new java.awt.Color(0, 0, 51));
        additionInfoTxt.setRows(5);
        jScrollPane1.setViewportView(additionInfoTxt);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(111, 111, 111)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(startDateWTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(pullDateWTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(cardWTxt))
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(startMemberCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                        .addComponent(pullMemberCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                        .addComponent(cardNumberTxt, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(30, 30, 30))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(startDateWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(startMemberCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pullMemberCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pullDateWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cardNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cardWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
        );

        jTabbedPane1.addTab("Work Data", jPanel6);

        saveBtn.setBackground(new java.awt.Color(0, 0, 102));
        saveBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save");
        saveBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 204), new java.awt.Color(0, 0, 204), new java.awt.Color(0, 0, 204), new java.awt.Color(0, 0, 255)));
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        clearBtn.setBackground(new java.awt.Color(102, 0, 0));
        clearBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("Clear");
        clearBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 204), new java.awt.Color(0, 0, 204), new java.awt.Color(0, 0, 204), new java.awt.Color(0, 0, 255)));
        clearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(102, 0, 0));
        cancelBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Cancel");
        cancelBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 153), new java.awt.Color(0, 0, 204), new java.awt.Color(0, 0, 204)));
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addComponent(jTabbedPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(cancelBtn)
                    .addComponent(clearBtn))
                .addContainerGap())
        );

        userTxt.setBackground(new java.awt.Color(0, 0, 51));

        jButton3.setBackground(new java.awt.Color(153, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/close.png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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

        jLabel24.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Add Reader");

        userNameTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        userNameTxt.setForeground(new java.awt.Color(0, 0, 255));
        userNameTxt.setEnabled(false);

        javax.swing.GroupLayout userTxtLayout = new javax.swing.GroupLayout(userTxt);
        userTxt.setLayout(userTxtLayout);
        userTxtLayout.setHorizontalGroup(
            userTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userTxtLayout.createSequentialGroup()
                .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(minimizeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn1)
                .addGap(0, 0, 0)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        userTxtLayout.setVerticalGroup(
            userTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userTxtLayout.createSequentialGroup()
                .addGroup(userTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
                    .addGroup(userTxtLayout.createSequentialGroup()
                        .addGroup(userTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(userTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(minimizeBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(userTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(restoreBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstNameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstNameTxtMouseClicked
        fNameWTxt.setVisible(false);
        firstNameTxt.setForeground(Color.BLUE.darker().darker().darker());
        if (evt.getClickCount() == 2) {
            firstNameTxt.setText("");
        }
    }//GEN-LAST:event_firstNameTxtMouseClicked

    private void firstNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTxtActionPerformed
        fNameWTxt.setVisible(false);
        firstNameTxt.setForeground(Color.BLUE.darker().darker().darker());
    }//GEN-LAST:event_firstNameTxtActionPerformed

    private void firstNameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstNameTxtKeyPressed
        fNameWTxt.setVisible(false);
        firstNameTxt.setForeground(Color.BLUE.darker().darker().darker());
    }//GEN-LAST:event_firstNameTxtKeyPressed

    private void lastNameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastNameTxtMouseClicked
        lNameWTxt.setVisible(false);
        lastNameTxt.setForeground(Color.BLUE.darker().darker().darker());
        if (evt.getClickCount() == 2) {
            lastNameTxt.setText("");
        }
    }//GEN-LAST:event_lastNameTxtMouseClicked

    private void lastNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTxtActionPerformed
        lNameWTxt.setVisible(false);
        lastNameTxt.setForeground(Color.BLUE.darker().darker().darker());
    }//GEN-LAST:event_lastNameTxtActionPerformed

    private void lastNameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastNameTxtKeyPressed
        lNameWTxt.setVisible(false);
        lastNameTxt.setForeground(Color.BLUE.darker().darker().darker());
    }//GEN-LAST:event_lastNameTxtKeyPressed

    private void fatherNameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fatherNameTxtMouseClicked
        fatherNameWTxt.setVisible(false);
        fatherNameTxt.setForeground(Color.BLUE.darker().darker().darker());
        if (evt.getClickCount() == 2) {
            fatherNameTxt.setText("");
        }
    }//GEN-LAST:event_fatherNameTxtMouseClicked

    private void fatherNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fatherNameTxtActionPerformed
        fatherNameWTxt.setVisible(false);
        fatherNameTxt.setForeground(Color.BLUE.darker().darker().darker());
    }//GEN-LAST:event_fatherNameTxtActionPerformed

    private void fatherNameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fatherNameTxtKeyPressed
        fatherNameWTxt.setVisible(false);
        fatherNameTxt.setForeground(Color.BLUE.darker().darker().darker());
    }//GEN-LAST:event_fatherNameTxtKeyPressed

    private void femaleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioActionPerformed
        femaleRadio.setText("Female");
        femaleRadio.setActionCommand("female");
        if (femaleRadio.isSelected()) {
            genderWTxt.setVisible(false);
        }
    }//GEN-LAST:event_femaleRadioActionPerformed

    private void maleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadioActionPerformed
        maleRadio.setText("Male");
        maleRadio.setActionCommand("male");
        if (maleRadio.isSelected()) {
            genderWTxt.setVisible(false);
        }
    }//GEN-LAST:event_maleRadioActionPerformed

    private void searchNationalityTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchNationalityTxtMouseClicked
        keyword = searchNationalityTxt.getText();
        showNationality(keyword);
        nationalityCombo.setVisible(true);

        if (evt.getClickCount() == 2) {
            searchNationalityTxt.setText("");
        }
    }//GEN-LAST:event_searchNationalityTxtMouseClicked

    private void searchNationalityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchNationalityTxtActionPerformed
        keyword = searchNationalityTxt.getText();
        nationalityCombo.setVisible(true);
        showNationality(keyword);
    }//GEN-LAST:event_searchNationalityTxtActionPerformed

    private void searchNationalityTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchNationalityTxtKeyPressed
        keyword = searchNationalityTxt.getText();
        nationalityCombo.setVisible(true);

        showNationality(keyword);
    }//GEN-LAST:event_searchNationalityTxtKeyPressed

    private void fNameWTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fNameWTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fNameWTxtActionPerformed

    private void genderWTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderWTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderWTxtActionPerformed

    private void identityTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_identityTxtMouseClicked
        identityWTxt.setVisible(false);
        identityTxt.setForeground(Color.BLUE.darker().darker().darker());
        if (evt.getClickCount() == 2) {
            identityTxt.setText("");
        }
    }//GEN-LAST:event_identityTxtMouseClicked

    private void identityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identityTxtActionPerformed
        identityWTxt.setVisible(false);
        identityTxt.setForeground(Color.BLUE.darker().darker().darker());
    }//GEN-LAST:event_identityTxtActionPerformed

    private void identityTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_identityTxtKeyPressed
        identityWTxt.setVisible(false);
        identityTxt.setForeground(Color.BLUE.darker().darker().darker());
    }//GEN-LAST:event_identityTxtKeyPressed

    private void emailTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailTxtMouseClicked
        emailWtxt.setVisible(false);
        emailTxt.setForeground(Color.BLUE.darker().darker().darker());
        if (evt.getClickCount() == 2) {
            emailTxt.setText("");
        }
    }//GEN-LAST:event_emailTxtMouseClicked

    private void emailTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTxtActionPerformed
        emailWtxt.setVisible(false);
        emailTxt.setForeground(Color.BLUE.darker().darker().darker());
    }//GEN-LAST:event_emailTxtActionPerformed

    private void emailTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTxtKeyPressed
        emailWtxt.setVisible(false);
        emailTxt.setForeground(Color.BLUE.darker().darker().darker());
    }//GEN-LAST:event_emailTxtKeyPressed

    private void phone1TxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phone1TxtMouseClicked
        phone1Txt.setForeground(Color.BLUE.darker().darker().darker());
        if (evt.getClickCount() == 2) {
            phone1Txt.setText("");
        }
    }//GEN-LAST:event_phone1TxtMouseClicked

    private void phone1TxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phone1TxtActionPerformed
        phone1Txt.setForeground(Color.BLUE.darker().darker().darker());
    }//GEN-LAST:event_phone1TxtActionPerformed

    private void phone1TxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phone1TxtKeyPressed
        phone1Txt.setForeground(Color.BLUE.darker().darker().darker());
    }//GEN-LAST:event_phone1TxtKeyPressed

    private void phone2TxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phone2TxtMouseClicked
        phone2Txt.setForeground(Color.BLUE.darker().darker().darker());
        if (evt.getClickCount() == 2) {
            phone2Txt.setText("");
        }
    }//GEN-LAST:event_phone2TxtMouseClicked

    private void phone2TxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phone2TxtActionPerformed
        phone2Txt.setForeground(Color.BLUE.darker().darker().darker());
    }//GEN-LAST:event_phone2TxtActionPerformed

    private void phone2TxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phone2TxtKeyPressed
        phone2Txt.setForeground(Color.BLUE.darker().darker().darker());
    }//GEN-LAST:event_phone2TxtKeyPressed

    private void homePhoneTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homePhoneTxtMouseClicked
        homePhoneTxt.setForeground(Color.BLUE.darker().darker().darker());
        if (evt.getClickCount() == 2) {
            homePhoneTxt.setText("");
        }
    }//GEN-LAST:event_homePhoneTxtMouseClicked

    private void homePhoneTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homePhoneTxtActionPerformed
        homeNumberTxt.setForeground(Color.BLUE.darker().darker().darker());
    }//GEN-LAST:event_homePhoneTxtActionPerformed

    private void homePhoneTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_homePhoneTxtKeyPressed
        homeNumberTxt.setForeground(Color.BLUE.darker().darker().darker());
    }//GEN-LAST:event_homePhoneTxtKeyPressed

    private void statusComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_statusComboItemStateChanged
        statusWTxt.setVisible(false);
    }//GEN-LAST:event_statusComboItemStateChanged

    private void countryComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_countryComboItemStateChanged
        countryWTxt.setVisible(false);
    }//GEN-LAST:event_countryComboItemStateChanged

    private void searchCountryTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchCountryTxtMouseClicked
        countrySearch = searchCountryTxt.getText();
        countryCombo.setVisible(true);
        showCounntryForSearch(countrySearch);
        if (evt.getClickCount() == 2) {
            searchCountryTxt.setText("");
        }
    }//GEN-LAST:event_searchCountryTxtMouseClicked

    private void searchCountryTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCountryTxtActionPerformed
        countrySearch = searchCountryTxt.getText();
        countryCombo.setVisible(true);
        showCounntryForSearch(countrySearch);
    }//GEN-LAST:event_searchCountryTxtActionPerformed

    private void searchCountryTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchCountryTxtKeyPressed
        countrySearch = searchCountryTxt.getText();
        countryCombo.setVisible(true);
        showCounntryForSearch(countrySearch);
    }//GEN-LAST:event_searchCountryTxtKeyPressed

    private void startMemberCalendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startMemberCalendarMouseClicked
        startDateWTxt.setVisible(false);
    }//GEN-LAST:event_startMemberCalendarMouseClicked

    private void startMemberCalendarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startMemberCalendarMouseEntered
        startDateWTxt.setVisible(false);
    }//GEN-LAST:event_startMemberCalendarMouseEntered

    private void startMemberCalendarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_startMemberCalendarKeyPressed
        startDateWTxt.setVisible(false);
    }//GEN-LAST:event_startMemberCalendarKeyPressed

    private void pullMemberCalendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pullMemberCalendarMouseClicked
        pullDateWTxt.setVisible(false);
    }//GEN-LAST:event_pullMemberCalendarMouseClicked

    private void pullMemberCalendarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pullMemberCalendarMouseEntered
        pullDateWTxt.setVisible(false);
    }//GEN-LAST:event_pullMemberCalendarMouseEntered

    private void pullMemberCalendarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pullMemberCalendarKeyPressed
        pullDateWTxt.setVisible(false);
    }//GEN-LAST:event_pullMemberCalendarKeyPressed

    private void pullMemberCalendarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pullMemberCalendarKeyReleased
        pullDateWTxt.setVisible(false);
    }//GEN-LAST:event_pullMemberCalendarKeyReleased

    private void cardNumberTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cardNumberTxtMouseClicked
        cardWTxt.setVisible(false);
        cardNumberTxt.setForeground(Color.BLUE.darker().darker().darker());
        if (evt.getClickCount() == 2) {
            cardNumberTxt.setText("");
        }
    }//GEN-LAST:event_cardNumberTxtMouseClicked

    private void cardNumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardNumberTxtActionPerformed
        cardWTxt.setVisible(false);
        cardNumberTxt.setForeground(Color.BLUE.darker().darker().darker());
    }//GEN-LAST:event_cardNumberTxtActionPerformed

    private void cardNumberTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cardNumberTxtKeyPressed
        cardWTxt.setVisible(false);
        cardNumberTxt.setForeground(Color.BLUE.darker().darker().darker());
    }//GEN-LAST:event_cardNumberTxtKeyPressed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            Reader reader = new Reader();
            String firstName = firstNameTxt.getText();
            if (firstName.matches("[\\p{L}\\s\\.]+") && !firstName.isEmpty()) {
                if (firstName.length() >= 3 && firstName.length() <= 25) {
                    String lastName = lastNameTxt.getText();
                    if (lastName.matches("[\\p{L}\\s\\.]+") && !lastName.isEmpty()) {
                        if (lastName.length() >= 3 && lastName.length() <= 25) {
                            String fatherName = fatherNameTxt.getText();
                            if (fatherName.matches("[\\p{L}\\s\\.]+")) {
                                if (fatherName.length() >= 3 && fatherName.length() <= 25) {
                                    String gender = null;
                                    if (maleRadio.isSelected()) {
                                        gender = "male";
                                    } else if (femaleRadio.isSelected()) {
                                        gender = "female";
                                    }
                                    if (gender != null) {
                                        String nationality = (String) nationalityCombo.getSelectedItem();
                                        reader.setDob(dobCalendar.getDate());
                                        String identity = identityTxt.getText();
                                        if (identity != null && !identity.isEmpty() && !identity.contains(" ")) {
                                            boolean checkIdentity = checkIdentity(identity);
                                            if (checkIdentity) {
                                                String email = emailTxt.getText();
                                                if (email.contains("@")) {
                                                    String phone1 = phone1Txt.getText();
                                                    String phone2 = phone2Txt.getText();
                                                    String homePhone = homePhoneTxt.getText();
                                                    String country = (String) countryCombo.getSelectedItem();
                                                    if (country != null) {
                                                        String city = cityTxt.getText();
                                                        String street = streetTxt.getText();
                                                        String homeNumber = homeNumberTxt.getText();
                                                        String houseNumber = houseNumberTxt.getText();
                                                        if (statusCombo.getSelectedIndex() > 0) {
                                                               Item statusItem = (Item) statusCombo.getSelectedItem(); 
                                                                System.out.println("status  "+statusItem.getId());
                                                            Date startMember = startMemberCalendar.getDate();
                                                            if (startMember != null) {
                                                                Date pullMember = pullMemberCalendar.getDate();
                                                                if (pullMember != null) {
                                                                    String cardNumber = cardNumberTxt.getText();
                                                                    if (cardNumber.length() <= 20) {
                                                                        if (cardNumber.matches("[a-zA-Z0-9]+")) {
                                                                            boolean checkCardNumberr = checkCardNumber(cardNumber);
                                                                            if (checkCardNumberr) {
                                                                                String additionI = additionInfoTxt.getText();
                                                                                String penalty = penaltyTxt.getText();
                                                                                reader.setFirstName(firstName);
                                                                                reader.setLastName(lastName);
                                                                                reader.setFatherName(fatherName);
                                                                                reader.setIdentifyNumber(identity);
                                                                                reader.setNationality(nationality);
                                                                                reader.setCountry(country);
                                                                                reader.setGender(gender);
                                                                                reader.setStreet(street);
                                                                                reader.setHouseNumber(houseNumber);
                                                                                reader.setHomeNumber(homeNumber);
                                                                                reader.setPhone1(phone1);
                                                                                reader.setPhone2(phone2);
                                                                                reader.setCardNumber(cardNumber);
                                                                                reader.setPullMemberDate(pullMember);
                                                                                reader.setStartMemberDate(startMember);
                                                                                reader.setHomePhone(homePhone);
                                                                                reader.seteMail(email);
                                                                                Status status= new Status();
                                                                                status.setId(statusItem.getId());
                                                                                reader.setStatus1(status);
                                                                                reader.setCity(city);
                                                                                reader.setAdditionInfo(additionI);
                                                                                reader.setPenalty(Float.parseFloat(penalty));
                                                                                if ((!activityCombo.getSelectedItem().equals("Select Activity"))) {
                                                                                    String activity = (String) activityCombo.getSelectedItem();
                                                                                    reader.setActivity(Integer.parseInt(activity));
                                                                                    boolean isUpdateRader = readerService.updateReader(reader, selectedId);
                                                                                    if (isUpdateRader) {
                                                                                        JOptionPane.showMessageDialog(null, firstName + " " + lastName + " update successfuly!", "Success", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/tick.png"));
                                                                                        saveBtn.setEnabled(false);
                                                                                    } else {
                                                                                        JOptionPane.showMessageDialog(null, "Update is Fail", "Fail", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/report.png"));
                                                                                        this.setVisible(true);
                                                                                    }
                                                                                } else {
                                                                                    actTxtW.setVisible(true);
                                                                                    actTxtW.setText("Add Activity");
                                                                                }
                                                                            } else {
                                                                                cardWTxt.setVisible(true);
                                                                                cardWTxt.setText("Repeated Identity is not allowed");
                                                                            }
                                                                        } else {
                                                                            cardWTxt.setVisible(true);
                                                                            cardWTxt.setText("Uncorrect Card Number");
                                                                        }
                                                                    } else {
                                                                        cardWTxt.setVisible(true);
                                                                        cardWTxt.setText("Length less than 21");
                                                                    }
                                                                } else {
                                                                    pullDateWTxt.setVisible(true);
                                                                    pullDateWTxt.setText("Add Date");
                                                                }

                                                            } else {
                                                                startDateWTxt.setVisible(true);
                                                                startDateWTxt.setText("Add Date");

                                                            }
                                                        } else {
                                                            statusWTxt.setVisible(true);
                                                            statusWTxt.setText("Select Status");

                                                        }
                                                    } else {

                                                        countryWTxt.setVisible(true);
                                                        countryWTxt.setText("Select Country");

                                                    }

                                                } else {
                                                    emailWtxt.setVisible(true);
                                                    emailWtxt.setText("Uncorrect Email");

                                                }
                                            } else {
                                                identityWTxt.setVisible(true);
                                                identityWTxt.setText("Repeated Identity is not allowed");
                                            }
                                        } else {
                                            identityWTxt.setVisible(true);
                                            identityWTxt.setText("Uncorrect Identity");

                                        }
                                    } else {
                                        genderWTxt.setVisible(true);
                                        genderWTxt.setText("Select Gender");

                                    }
                                } else {
                                    fatherNameWTxt.setVisible(true);
                                    fatherNameWTxt.setText("less than 26,greater than 2");

                                }
                            } else {
                                fatherNameWTxt.setVisible(true);
                                fatherNameWTxt.setText("Uncorrect Name");

                            }
                        } else {
                            lNameWTxt.setVisible(true);
                            lNameWTxt.setText("less than 26,greater than 2");

                        }
                    } else {
                        lNameWTxt.setVisible(true);
                        lNameWTxt.setText("Uncorrect Last Name");

                    }
                } else {
                    fNameWTxt.setVisible(true);
                    fNameWTxt.setText("less than 26,greater  than 2");

                }
            } else {
                fNameWTxt.setVisible(true);
                fNameWTxt.setText("Uncorrect Name");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        clear();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "Are you sure close program ? ");
        if (choose == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            this.setVisible(true);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
        ReaderFirstFrame readerInfoFrame = new ReaderFirstFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login,statusService);
        readerInfoFrame.setVisible(true);
    }//GEN-LAST:event_backBtn1ActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
        ReaderInfoFrame readerInfoFrame = new ReaderInfoFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login,statusService);
        readerInfoFrame.setVisible(true);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void activityComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activityComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_activityComboActionPerformed

    private void statusComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusComboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actTxtW;
    private javax.swing.JLabel activity;
    private javax.swing.JComboBox<String> activityCombo;
    private javax.swing.JTextArea additionInfoTxt;
    private javax.swing.JButton backBtn1;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField cardNumberTxt;
    private javax.swing.JTextField cardWTxt;
    private javax.swing.JTextField cityTxt;
    private javax.swing.JButton clearBtn;
    private javax.swing.JComboBox<String> countryCombo;
    private javax.swing.JTextField countryWTxt;
    private com.toedter.calendar.JDateChooser dobCalendar;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField emailWtxt;
    private javax.swing.JTextField fNameWTxt;
    private javax.swing.JTextField fatherNameTxt;
    private javax.swing.JTextField fatherNameWTxt;
    private javax.swing.JRadioButton femaleRadio;
    private javax.swing.JTextField firstNameTxt;
    private javax.swing.JTextField genderWTxt;
    private javax.swing.JTextField homeNumberTxt;
    private javax.swing.JTextField homePhoneTxt;
    private javax.swing.JTextField houseNumberTxt;
    private javax.swing.JTextField identityTxt;
    private javax.swing.JTextField identityWTxt;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lNameWTxt;
    private javax.swing.JTextField lastNameTxt;
    private javax.swing.JRadioButton maleRadio;
    private javax.swing.JButton minimizeBtn1;
    private javax.swing.JComboBox<String> nationalityCombo;
    private javax.swing.JTextField penaltyTxt;
    private javax.swing.JLabel penaltylbl;
    private javax.swing.JTextField phone1Txt;
    private javax.swing.JTextField phone2Txt;
    private javax.swing.JTextField pullDateWTxt;
    private com.toedter.calendar.JDateChooser pullMemberCalendar;
    private javax.swing.JButton restoreBtn1;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField searchCountryTxt;
    private javax.swing.JTextField searchNationalityTxt;
    private javax.swing.JTextField startDateWTxt;
    private com.toedter.calendar.JDateChooser startMemberCalendar;
    private javax.swing.JComboBox<String> statusCombo;
    private javax.swing.JTextField statusWTxt;
    private javax.swing.JTextField streetTxt;
    private javax.swing.JTextField userNameTxt;
    private javax.swing.JPanel userTxt;
    // End of variables declaration//GEN-END:variables

    private void showOldDate(Reader reader) {
        firstNameTxt.setText(reader.getFirstName());
        lastNameTxt.setText(reader.getLastName());
        fatherNameTxt.setText(reader.getFatherName());
        try {
            identityTxt.setText(reader.getIdentifyNumber());
            Float penalty = readerService.getPenalty(selectedId);
            penaltyTxt.setText(String.valueOf(penalty));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (reader.getGender().equalsIgnoreCase("male")) {
            maleRadio.setSelected(true);
            femaleRadio.setSelected(false);
        } else if (reader.getGender().equalsIgnoreCase("female")) {
            femaleRadio.setSelected(true);
            maleRadio.setSelected(false);
        }
        cardNumberTxt.setText(reader.getCardNumber());
        cityTxt.setText(reader.getCity());
        streetTxt.setText(reader.getStreet());
        homeNumberTxt.setText(reader.getHomeNumber());
        houseNumberTxt.setText(reader.getHouseNumber());
        phone1Txt.setText(reader.getPhone1());
        phone2Txt.setText(reader.getPhone2());
        homePhoneTxt.setText(reader.getHomePhone());
        pullMemberCalendar.setDate(reader.getPullMemberDate());
        startMemberCalendar.setDate(reader.getStartMemberDate());
        dobCalendar.setDate(reader.getDob());
        emailTxt.setText(reader.geteMail());
        additionInfoTxt.setText(reader.getAdditionInfo());

    }

    void activity(Reader reader) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) activityCombo.getModel();
        int[] act = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        model.addElement("Select Activity");
        for (int i : act) {
            model.addElement(String.valueOf(i));
        }
        activityCombo.setSelectedItem(String.valueOf(reader.getActivity()));
    }

//    void showOldComboStatuse(Reader reader) {
//        DefaultComboBoxModel model = (DefaultComboBoxModel) statusCombo.getModel();
//        String[] statuss = {"Pupil", "Student", "Employee", "UnEmployee"};
//        model.removeAllElements();
//        model.addElement("Select Status");
//        for (String status : statuss) {
//            model.addElement(status);
//        }
//        String a = reader.getStatus();
//        if (a != null) {
//            model.setSelectedItem(reader.getStatus());
//        } else {
//            statusCombo.setSelectedIndex(0);
//        }
//    }

    void showNationality(String keyword) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) nationalityCombo.getModel();
        List<String> filterList = new ArrayList<>();
        String nationality[] = {"Afghans", "Albanians", "Algerians", "Americans", "Andorrans",
            "Angolans", "Antiguans and Barbudans", "Argentines", "Arubans", "Australians", "Austrians", "Azerbaijanis",
            "Bahamians", "Bahrainis", "Bangladeshis", "Barbadians", "Basques", "Belarusians", "Belgians", "Belizeans",
            "Beninese", "Bermudians", "Bhutanese", "Bolivians", "Bosniaks", "Bosnians and Herzegovinians", "Botswana",
            "Brazilians", "British", "British Virgin Islanders", "Bruneians", "Bulgarians", "Macedonian Bulgarians",
            "Burkinabés", "Burmese", "Burundians", "Cambodians", "Cameroonians", "Canadians", "Catalans", "Cape Verdeans", "Chadians",
            "Chileans", "Chinese", "Colombians", "Comorians", "Congolese (DRC)", "Congolese (RotC)", "Costa Ricans", "Croats",
            "Cubans", "Cypriots", "Czechs", "Danes", "Greenlanders", "Djiboutians", "Dominicans (Commonwealth)", "Dominicans (Republic)",
            "Dutch", "East Timorese", "Ecuadorians", "Egyptians", "Emiratis", "English", "Equatoguineans", "Eritreans", "Estonians",
            "Ethiopians", "Falkland Islanders", "Faroese", "Fijians", "Finns", "Finnish Swedish", "Filipinos", "French citizens",
            "Gabonese", "Gambians", "Georgians", "Germans", "Baltic Germans", "Ghanaians", "Gibraltarians", "Greeks", "Greek Macedonians",
            "Grenadians", "Guatemalans", "Guianese (French)", "Guineans", "Guinea-Bissau nationals", "Hondurans", "Hong Kongers",
            "Hungarians", "Icelanders", "I-Kiribati", "Indians", "Indonesians", "Iranians", "Iraqis", "Irish", "Israelis",
            "Italians", "Ivoirians", "Jamaicans", "Japanese", "Jordanians", "Kazakhs", "Kenyans", "Koreans", "Kosovars", "Kuwaitis",
            "Kyrgyzs", "Lao", "Latvians", "Libyans", "Liechtensteiners", "Lithuanians", "Luxembourgers", "Macao",
            "Macedonians", "Malagasy", "Malawians", "Malaysians", "Maldivians", "Malians", "Maltese", "Manx", "Marshallese", "Mauritanians",
            "Mauritians", "Mexicans", "Micronesians", "Moldovans", "Monégasque", "Mongolians", "Montenegrins", "Moroccans",
            "Mozambicans", "Namibians", "Nauruans", "Nepalese", "New Zealanders", "Nicaraguans", "Nigeriens", "Nigerians", "Norwegians",
            "Omani", "Pakistanis", "Palauans", "Palestinians", "Panamanians", "Papua New Guineans", "Paraguayans", "Peruvians",
            "Poles", "Portuguese", "Puerto Ricans", "Qatari", "Quebecers", "Réunionnais", "Romanians", "Russians", "Baltic Russians",
            "Rwandans", "Saint Kitts and Nevis", "Saint Lucians", "Salvadorans", "Sammarinese", "Samoans", "São Tomé and Príncipe",
            "Saudis", "Scots", "Senegalese", "Serbs", "Seychellois", "Sierra Leoneans", "Singaporeans", "Slovaks", "Slovenes",
            "Solomon Islanders", "Somalis", "Somalilanders", "Sotho", "South Africans", "Spaniards", "Sri Lankans", "Sudanese",
            "Surinamese", "Swazi", "Swedes", "Swiss", "Syriacs", "Syrians", "Taiwanese", "Tamils", "Tajik", "Tanzanians",
            "Thais", "Tibetans", "Tobagonians", "Togolese", "Tongans", "Trinidadians", "Tunisians", "Turks", "Tuvaluans", "Ugandans",
            "Ukrainians", "Uruguayans", "Uzbeks", "Vanuatuans", "Venezuelans", "Vietnamese", "Vincentians", "Welsh", "Yemenis",
            "Zambians", "Zimbabweans"};
        for (String nat : nationality) {
            if (nat.toLowerCase().contains(keyword.toLowerCase())) {
                filterList.add(nat);
            }
            if (filterList.size() > 0) {
                model.removeAllElements();
                for (String fl : filterList) {
                    model.addElement(fl);
                }
            } else if (filterList.size() == 0) {
                model.addElement("Select Nationality");
                for (String natt : nationality) {
                    model.addElement(natt);
                }
                JTextField textfield = (JTextField) nationalityCombo.getEditor().getEditorComponent();
                textfield.setText(keyword);
            }
        }
    }

    void showCounntryForSearch(String keyword) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) countryCombo.getModel();
        List<String> filterCountry = new ArrayList<>();
        String countries[] = {"Afghanistan", "Albania", "Algeria", "Andorra", "Angola",
            "Anguilla", "Antigua & Barbuda", "Argentina", "Australia", "Austria", "Azerbaijan", "Bahrain",
            "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan",
            "Bolivia", "Bosnia & Herzegovina", "Botswana", "Brazil", "Brunei Darussalam", "Bulgaria", "Botswana",
            "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic",
            "Chad", "Chile", "China", "China - Hong Kong / Macau", "Colombia", "Comoros", "Congo", "Congo, Democratic Republic of (DRC)",
            "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
            "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini", "Ethiopia", "Fiji", "Finland",
            "France", "French Guiana", "Gabon", "Gambia, Republic of The", "Georgia", "Germany", "Ghana", "Great Britain", "Greece",
            "Grenada", "Guadeloupe", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland",
            "India", "Indonesia", "Iran", "Iraq", "Israel and the Occupied Territories", "Italy", "Ivory Coast (Cote d'Ivoire)",
            "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Korea", "Democratic Republic of (North Korea)", "Korea, Republic of (South Korea)", "Kosovo", "Kuwait", "Kyrgyz Republic (Kyrgyzstan)", "Laos", "Latvia", "Lebanon",
            "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives",
            "Mali", "Malta", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Moldova", "Monaco", "Mongolia", "Montserrat",
            "Morocco", "Mozambique", "Myanmar/Burma", "Namibia", "Nepal", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Macedonia",
            "Norway", "Oman", "Pacific Islands", "Pakistan", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines",
            "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis",
            "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "Sao Tome and Principe", "Saudi Arabia", "Senegal",
            "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovak Republic (Slovakia)", "Slovenia", "Solomon Islands",
            "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland",
            "Syria", "Tajikistan", "Tanzania", "Thailand", "Netherlands", "Tunisia", "Turkey", "Turkmenistan", "Turks & Caicos Islands",
            "Uganda", "Ukraine", "United Arab Emirates", "United States of America (USA)", "Uruguay", "Uzbekistan", "Venezuela",
            "Vietnam", "Virgin Islands (UK)", "Virgin Islands (US", "Yemen", "Zambia", "Zimbabwe"};
        for (String count : countries) {
            if (count.toLowerCase().contains(keyword.toLowerCase())) {
                filterCountry.add(count);
            }
            if (filterCountry.size() > 0) {
                model.removeAllElements();
                for (String fil : filterCountry) {
                    model.addElement(fil);
                }
            } else {
                model.removeAllElements();
                for (String country : countries) {
                    model.addElement(country);
                }
            }
            JTextField textfield = (JTextField) nationalityCombo.getEditor().getEditorComponent();
            textfield.setText(keyword);
        }

    }

    void showOldCountry(Reader reader) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) countryCombo.getModel();
        String countries[] = {"Afghanistan", "Albania", "Algeria", "Andorra", "Angola",
            "Anguilla", "Antigua & Barbuda", "Argentina", "Australia", "Austria", "Azerbaijan", "Bahrain",
            "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan",
            "Bolivia", "Bosnia & Herzegovina", "Botswana", "Brazil", "Brunei Darussalam", "Bulgaria", "Botswana",
            "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic",
            "Chad", "Chile", "China", "China - Hong Kong / Macau", "Colombia", "Comoros", "Congo", "Congo, Democratic Republic of (DRC)",
            "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
            "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini", "Ethiopia", "Fiji", "Finland",
            "France", "French Guiana", "Gabon", "Gambia, Republic of The", "Georgia", "Germany", "Ghana", "Great Britain", "Greece",
            "Grenada", "Guadeloupe", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland",
            "India", "Indonesia", "Iran", "Iraq", "Israel and the Occupied Territories", "Italy", "Ivory Coast (Cote d'Ivoire)",
            "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Korea", "Democratic Republic of (North Korea)", "Korea, Republic of (South Korea)", "Kosovo", "Kuwait", "Kyrgyz Republic (Kyrgyzstan)", "Laos", "Latvia", "Lebanon",
            "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives",
            "Mali", "Malta", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Moldova", "Monaco", "Mongolia", "Montserrat",
            "Morocco", "Mozambique", "Myanmar/Burma", "Namibia", "Nepal", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Macedonia",
            "Norway", "Oman", "Pacific Islands", "Pakistan", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines",
            "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis",
            "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "Sao Tome and Principe", "Saudi Arabia", "Senegal",
            "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovak Republic (Slovakia)", "Slovenia", "Solomon Islands",
            "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland",
            "Syria", "Tajikistan", "Tanzania", "Thailand", "Netherlands", "Tunisia", "Turkey", "Turkmenistan", "Turks & Caicos Islands",
            "Uganda", "Ukraine", "United Arab Emirates", "United States of America (USA)", "Uruguay", "Uzbekistan", "Venezuela",
            "Vietnam", "Virgin Islands (UK)", "Virgin Islands (US", "Yemen", "Zambia", "Zimbabwe"};
        for (String country : countries) {
            model.addElement(country);
        }
        model.setSelectedItem(reader.getCountry());
    }

    void showOldNationality(Reader reader) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) nationalityCombo.getModel();
        String nationality[] = {"Afghans", "Albanians", "Algerians", "Americans", "Andorrans",
            "Angolans", "Antiguans and Barbudans", "Argentines", "Arubans", "Australians", "Austrians", "Azerbaijanis",
            "Bahamians", "Bahrainis", "Bangladeshis", "Barbadians", "Basques", "Belarusians", "Belgians", "Belizeans",
            "Beninese", "Bermudians", "Bhutanese", "Bolivians", "Bosniaks", "Bosnians and Herzegovinians", "Botswana",
            "Brazilians", "British", "British Virgin Islanders", "Bruneians", "Bulgarians", "Macedonian Bulgarians",
            "Burkinabés", "Burmese", "Burundians", "Cambodians", "Cameroonians", "Canadians", "Catalans", "Cape Verdeans", "Chadians",
            "Chileans", "Chinese", "Colombians", "Comorians", "Congolese (DRC)", "Congolese (RotC)", "Costa Ricans", "Croats",
            "Cubans", "Cypriots", "Czechs", "Danes", "Greenlanders", "Djiboutians", "Dominicans (Commonwealth)", "Dominicans (Republic)",
            "Dutch", "East Timorese", "Ecuadorians", "Egyptians", "Emiratis", "English", "Equatoguineans", "Eritreans", "Estonians",
            "Ethiopians", "Falkland Islanders", "Faroese", "Fijians", "Finns", "Finnish Swedish", "Filipinos", "French citizens",
            "Gabonese", "Gambians", "Georgians", "Germans", "Baltic Germans", "Ghanaians", "Gibraltarians", "Greeks", "Greek Macedonians",
            "Grenadians", "Guatemalans", "Guianese (French)", "Guineans", "Guinea-Bissau nationals", "Hondurans", "Hong Kongers",
            "Hungarians", "Icelanders", "I-Kiribati", "Indians", "Indonesians", "Iranians", "Iraqis", "Irish", "Israelis",
            "Italians", "Ivoirians", "Jamaicans", "Japanese", "Jordanians", "Kazakhs", "Kenyans", "Koreans", "Kosovars", "Kuwaitis",
            "Kyrgyzs", "Lao", "Latvians", "Libyans", "Liechtensteiners", "Lithuanians", "Luxembourgers", "Macao",
            "Macedonians", "Malagasy", "Malawians", "Malaysians", "Maldivians", "Malians", "Maltese", "Manx", "Marshallese", "Mauritanians",
            "Mauritians", "Mexicans", "Micronesians", "Moldovans", "Monégasque", "Mongolians", "Montenegrins", "Moroccans",
            "Mozambicans", "Namibians", "Nauruans", "Nepalese", "New Zealanders", "Nicaraguans", "Nigeriens", "Nigerians", "Norwegians",
            "Omani", "Pakistanis", "Palauans", "Palestinians", "Panamanians", "Papua New Guineans", "Paraguayans", "Peruvians",
            "Poles", "Portuguese", "Puerto Ricans", "Qatari", "Quebecers", "Réunionnais", "Romanians", "Russians", "Baltic Russians",
            "Rwandans", "Saint Kitts and Nevis", "Saint Lucians", "Salvadorans", "Sammarinese", "Samoans", "São Tomé and Príncipe",
            "Saudis", "Scots", "Senegalese", "Serbs", "Seychellois", "Sierra Leoneans", "Singaporeans", "Slovaks", "Slovenes",
            "Solomon Islanders", "Somalis", "Somalilanders", "Sotho", "South Africans", "Spaniards", "Sri Lankans", "Sudanese",
            "Surinamese", "Swazi", "Swedes", "Swiss", "Syriacs", "Syrians", "Taiwanese", "Tamils", "Tajik", "Tanzanians",
            "Thais", "Tibetans", "Tobagonians", "Togolese", "Tongans", "Trinidadians", "Tunisians", "Turks", "Tuvaluans", "Ugandans",
            "Ukrainians", "Uruguayans", "Uzbeks", "Vanuatuans", "Venezuelans", "Vietnamese", "Vincentians", "Welsh", "Yemenis",
            "Zambians", "Zimbabweans"};
        for (String string : nationality) {
            model.addElement(string);
        }
        model.setSelectedItem(reader.getNationality());
    }

    void hideWarning() {
        fNameWTxt.setVisible(false);
        lNameWTxt.setVisible(false);
        fatherNameWTxt.setVisible(false);
        genderWTxt.setVisible(false);
        identityWTxt.setVisible(false);
        emailWtxt.setVisible(false);
        actTxtW.setVisible(false);
        countryWTxt.setVisible(false);
        statusWTxt.setVisible(false);
        startDateWTxt.setVisible(false);
        pullDateWTxt.setVisible(false);
        cardWTxt.setVisible(false);
    }

    void clear() {
        if (jPanel3.isShowing()) {
            firstNameTxt.setText("");
            fNameWTxt.setVisible(false);
            lastNameTxt.setText("");
            lNameWTxt.setVisible(false);
            fatherNameTxt.setText("");
            fatherNameWTxt.setVisible(false);
            genderWTxt.setVisible(false);
            maleRadio.setSelected(false);
            femaleRadio.setSelected(false);
            nationalityCombo.setVisible(false);
            searchNationalityTxt.setText("");
        } else if (jPanel4.isShowing()) {
            identityTxt.setText("");
            emailTxt.setText("");
            phone1Txt.setText("");
            phone2Txt.setText("");
            homePhoneTxt.setText("");
            identityWTxt.setVisible(false);
            emailWtxt.setVisible(false);

        } else if (jPanel5.isShowing()) {
            countryCombo.setVisible(false);
            searchCountryTxt.setText("");
            cityTxt.setText("");
            streetTxt.setText("");
            houseNumberTxt.setText("");
            homeNumberTxt.setText("");
            statusCombo.setSelectedIndex(0);
            countryWTxt.setVisible(false);
            statusWTxt.setVisible(false);
        } else if (jPanel6.isShowing()) {
            startMemberCalendar.setDate(null);
            pullMemberCalendar.setDate(null);
            cardNumberTxt.setText("");
            additionInfoTxt.setText("");
            startDateWTxt.setVisible(false);
            pullDateWTxt.setVisible(false);
            cardWTxt.setVisible(false);
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

    boolean checkCardNumber(String cardNumber) {
        boolean result = true;
        try {
            Reader reader = readerService.getReaderById(selectedId);
            String oldCard = reader.getCardNumber();
            if (oldCard.equals(cardNumber)) {
                result = true;
            } else {
                List<String> cars = readerService.getCardNumbers();
                for (String card : cars) {
                    if (card.equals(cardNumber)) {
                        result = false;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }

    boolean checkIdentity(String identity) {
        boolean result = true;
        try {
            Reader reader = readerService.getReaderById(selectedId);
            String oldIdentity = reader.getIdentifyNumber();
            if (oldIdentity.equals(identity)) {
                result = true;
            } else {
                List<String> identities = readerService.getIdentity();
                for (String ids : identities) {
                    if (ids.equals(identity)) {
                        result = false;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
      private void showStatusCombo() {
        try {
            List<Status> statusList = statusService.getStatusList();
            DefaultComboBoxModel model = (DefaultComboBoxModel) statusCombo.getModel();
            model.addElement(new Item((long) 0, "Select Status"));
            for (Status status : statusList) {
                model.addElement(new Item(status.getId(), status.getStatus()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
            private void showStatusOldCombo(Reader reader) {
        try {
            List<Status> statusList = statusService.getStatusList();
            DefaultComboBoxModel model = (DefaultComboBoxModel) statusCombo.getModel();
            model.addElement(new Item((long) 0, "Select Status"));
            model.setSelectedItem(reader.getStatus1().getStatus());
            for (Status status : statusList) {
                model.addElement(new Item(status.getId(), status.getStatus()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
