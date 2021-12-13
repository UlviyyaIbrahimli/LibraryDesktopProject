package project.library.desktop.book;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import project.library.desktop.Desktop_Gui.Item;
import project.library.desktop.model.Author;
import project.library.desktop.model.Book;
import project.library.desktop.model.Login;
import project.library.desktop.model.Subjects;
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

public class AddAuthorFrame extends JFrame {

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
    DefaultListModel<Item> models;
    DefaultListModel<Item> model;
    String keyword = "";
    ButtonGroup buttonGroup = new ButtonGroup();

    public AddAuthorFrame() {
        initComponents();
    }

    AddAuthorFrame(DepartmentService departmentService,
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
            this.setDefaultLookAndFeelDecorated(true);
            this.pack();
            this.setLocationRelativeTo(null);
            buttonGroup.add(maleRadio);
            buttonGroup.add(femaleRadio);
            userTxt.setText("Welcome, " + login.getFirstName() + " " + login.getLastName() + " !");
            nationalityCombo.setRenderer(new AddAuthorFrame.TwoDecimalRenderer(nationalityCombo.getRenderer()));
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.darker().darker());
            models = new DefaultListModel<>();
            showSubjectList();
            model = new DefaultListModel<>();
            showList();
            nationalityCombo.setVisible(false);
            hideInfoTxt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        firstNameTxt = new javax.swing.JTextField();
        lastNameTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fatherNameTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        maleRadio = new javax.swing.JRadioButton();
        femaleRadio = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        dobCalendar = new com.toedter.calendar.JDateChooser();
        deadCalendar = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        searchNationalityTxt = new javax.swing.JTextField();
        nationalityCombo = new javax.swing.JComboBox<>();
        lnameInfoTxt = new javax.swing.JTextField();
        fatherNameInfoTxt = new javax.swing.JTextField();
        genderInfoTxt = new javax.swing.JTextField();
        fnameInfoTxt = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        noteTxt = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rewardTxt = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listBook = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        listSubject = new javax.swing.JList<>();
        subjectInfoTxt = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        restoreBtn = new javax.swing.JButton();
        minimizeBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        restoreBtn1 = new javax.swing.JButton();
        minimizeBtn1 = new javax.swing.JButton();
        backBtn1 = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        userTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setForeground(new java.awt.Color(51, 0, 51));

        jLabel1.setBackground(new java.awt.Color(0, 0, 102));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Author");

        jTabbedPane1.setForeground(new java.awt.Color(153, 0, 0));

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        jLabel2.setBackground(new java.awt.Color(0, 0, 102));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("First Name");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        firstNameTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        firstNameTxt.setForeground(new java.awt.Color(0, 0, 153));
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
        lastNameTxt.setForeground(new java.awt.Color(0, 0, 153));
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

        jLabel3.setBackground(new java.awt.Color(0, 0, 102));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Last Name");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        fatherNameTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        fatherNameTxt.setForeground(new java.awt.Color(0, 0, 153));
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

        jLabel4.setBackground(new java.awt.Color(0, 0, 102));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Father Name");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        jLabel5.setBackground(new java.awt.Color(0, 0, 102));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Gender");
        jLabel5.setToolTipText("");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        maleRadio.setBackground(new java.awt.Color(0, 0, 102));
        maleRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        maleRadio.setForeground(new java.awt.Color(204, 204, 255));
        maleRadio.setText("Male");
        maleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioActionPerformed(evt);
            }
        });

        femaleRadio.setBackground(new java.awt.Color(0, 0, 102));
        femaleRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        femaleRadio.setForeground(new java.awt.Color(204, 204, 255));
        femaleRadio.setText("Female");
        femaleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 0, 102));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Day of Birth");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        dobCalendar.setForeground(new java.awt.Color(51, 0, 51));

        deadCalendar.setBackground(new java.awt.Color(255, 255, 255));
        deadCalendar.setForeground(new java.awt.Color(51, 0, 51));

        jLabel7.setBackground(new java.awt.Color(0, 0, 102));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Day of Dead");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        jLabel8.setBackground(new java.awt.Color(0, 0, 102));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Nationality");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        searchNationalityTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        searchNationalityTxt.setForeground(new java.awt.Color(0, 0, 153));
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

        nationalityCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nationalityCombo.setForeground(new java.awt.Color(0, 0, 102));

        lnameInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        lnameInfoTxt.setForeground(new java.awt.Color(153, 0, 0));

        fatherNameInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        fatherNameInfoTxt.setForeground(new java.awt.Color(153, 0, 0));

        genderInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        genderInfoTxt.setForeground(new java.awt.Color(153, 0, 0));

        fnameInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        fnameInfoTxt.setForeground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fatherNameInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(fatherNameTxt))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fnameInfoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(lnameInfoTxt)
                                    .addComponent(genderInfoTxt))
                                .addGap(79, 79, 79)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lastNameTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                                    .addComponent(firstNameTxt, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(maleRadio)
                                    .addGap(140, 140, 140)
                                    .addComponent(femaleRadio))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(deadCalendar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(searchNationalityTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nationalityCombo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dobCalendar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(62, 62, 62))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fnameInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lnameInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(firstNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fatherNameInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fatherNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genderInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maleRadio)
                            .addComponent(femaleRadio))))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(dobCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(deadCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(searchNationalityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(nationalityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Page 1", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));
        jPanel3.setForeground(new java.awt.Color(51, 0, 51));

        jLabel9.setBackground(new java.awt.Color(0, 0, 102));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Reward");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        jLabel10.setBackground(new java.awt.Color(0, 0, 102));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Note");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        noteTxt.setColumns(20);
        noteTxt.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        noteTxt.setForeground(new java.awt.Color(0, 0, 153));
        noteTxt.setRows(5);
        jScrollPane1.setViewportView(noteTxt);

        jLabel11.setBackground(new java.awt.Color(0, 0, 102));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Subjects");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        rewardTxt.setColumns(20);
        rewardTxt.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        rewardTxt.setForeground(new java.awt.Color(0, 0, 153));
        rewardTxt.setRows(5);
        jScrollPane2.setViewportView(rewardTxt);

        jLabel12.setBackground(new java.awt.Color(0, 0, 102));
        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Books");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        listBook.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        listBook.setForeground(new java.awt.Color(0, 0, 153));
        listBook.setAlignmentX(1.0F);
        listBook.setAlignmentY(1.0F);
        listBook.setSelectionBackground(new java.awt.Color(0, 0, 102));
        jScrollPane4.setViewportView(listBook);

        listSubject.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102)));
        listSubject.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        listSubject.setForeground(new java.awt.Color(0, 0, 153));
        listSubject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listSubject.setSelectionBackground(new java.awt.Color(0, 0, 102));
        jScrollPane5.setViewportView(listSubject);

        subjectInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        subjectInfoTxt.setForeground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(subjectInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subjectInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Page 2", jPanel3);

        saveBtn.setBackground(new java.awt.Color(0, 0, 102));
        saveBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save");
        saveBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        restoreBtn.setBackground(new java.awt.Color(51, 102, 255));
        restoreBtn.setForeground(new java.awt.Color(255, 255, 255));
        restoreBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-restore-window-32.png"))); // NOI18N
        restoreBtn.setBorder(null);
        restoreBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        restoreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreBtnActionPerformed(evt);
            }
        });

        minimizeBtn.setBackground(new java.awt.Color(51, 102, 255));
        minimizeBtn.setForeground(new java.awt.Color(153, 0, 0));
        minimizeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-minimize-window-48.png"))); // NOI18N
        minimizeBtn.setBorder(null);
        minimizeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeBtnActionPerformed(evt);
            }
        });

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-undo-24.png"))); // NOI18N
        backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
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

        clearBtn.setBackground(new java.awt.Color(0, 0, 102));
        clearBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(204, 0, 0));
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
                .addGap(77, 77, 77)
                .addComponent(minimizeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(351, 351, 351)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(264, 264, 264)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(124, 124, 124)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 526, Short.MAX_VALUE)
                    .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(165, 165, 165)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(minimizeBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(restoreBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(254, 254, 254)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(minimizeBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(restoreBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addContainerGap(266, Short.MAX_VALUE)))
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
            String nationality = null;
            boolean isAddBook = false;
            boolean isAddSubject = false;
            String fName = firstNameTxt.getText();
            if ((fName.trim().length() >= 3) && (fName.trim().length() <= 50) && (!fName.isEmpty())) {
                if (fName.matches("[\\p{L}\\s\\.]+")) {
                    String lName = lastNameTxt.getText();
                    if ((lName.length() >= 3) && (lName.trim().length() <= 50) && (!lName.isEmpty())) {
                        if (lName.matches("[\\p{L}\\s\\.]+")) {
                            String fatherName = fatherNameTxt.getText();
                            if ((fatherName.trim().length() >= 3) && (fatherName.trim().length() <= 50) && (!fatherName.isEmpty())) {
                                if (fatherName.matches("[\\p{L}\\s\\.]+")) {
                                    String gender = null;
                                    if (femaleRadio.isSelected() || maleRadio.isSelected()) {
                                        gender = buttonGroup.getSelection().getActionCommand();
                                        Date dob = dobCalendar.getDate();
                                        Date daedDate = deadCalendar.getDate();
                                        if (nationalityCombo.getSelectedIndex() != -1 &&(!nationalityCombo.getSelectedItem().equals("Select Nationlity"))) {
                                            nationality = (String) nationalityCombo.getSelectedItem();
                                        } else {
                                            nationality = null;
                                        }
                                        String reward = rewardTxt.getText();
                                        String note = noteTxt.getText();
                                        Author author = new Author();
                                        author.setFirstName(fName);
                                        author.setLastName(lName);
                                        author.setFatherName(fatherName);
                                        author.setDob(dob);
                                        author.setDeadDate(daedDate);
                                        author.setReward(reward);
                                        author.setAuthorInfo(note);
                                        author.setGender(gender);
                                        author.setNationality(nationality);
                                        List<Item> subjectList = listSubject.getSelectedValuesList();
                                        if (subjectList.size() > 0) {
                                            boolean isAddAuthor = authorService.addAuthor(author);
                                            Long currentId = authorService.addbookId(author);
                                            for (Item s : subjectList) {
                                                isAddSubject = authorService.addListSubject(currentId, s.getId());
                                            }
                                            List< Item> itmBooks = listBook.getSelectedValuesList();
                                            if (itmBooks.size() > 0) {
                                                for (Item it : itmBooks) {
                                                    isAddBook = authorService.addAuthorBooks(it.getId(), currentId);
                                                }
                                            } 
                                            if (itmBooks.size() > 0) {
                                                if (isAddSubject = true && isAddAuthor == true && isAddBook == true) {
                                                    JOptionPane.showMessageDialog(null, fName.toUpperCase() + " " + lName.toUpperCase() + " IS ADDED SUCCESSFULY!", "SUCCES", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/tick.png"));
                                                    saveBtn.setEnabled(false);
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "ADDING IS FAIL", "FAIL", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/report.png"));
                                                }
                                            } else if (itmBooks.size() == 0) {
                                                if (isAddSubject = true && isAddAuthor == true) {
                                                    JOptionPane.showMessageDialog(null, fName.toUpperCase() + " " + lName.toUpperCase() + " IS ADDED SUCCESSFULY!", "SUCCES", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/tick.png"));
                                                }
                                                saveBtn.setEnabled(false);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "ADDING IS FAIL", "FAIL", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/report.png"));
                                            }
                                        } else {
                                            subjectInfoTxt.setVisible(true);
                                            subjectInfoTxt.setText("Select Subject!");
                                        }                                    
                                    } else {
                                        genderInfoTxt.setVisible(true);
                                        genderInfoTxt.setText("Select Gender");
                                    }
                                } else {
                                    fatherNameInfoTxt.setVisible(true);
                                    fatherNameInfoTxt.setText("Uncorrect Father Name");
                                    fatherNameInfoTxt.setForeground(Color.red);
                                }
                            } else {
                                fatherNameInfoTxt.setVisible(true);
                                fatherNameInfoTxt.setText("Greater than 3, less than 50");
                                fatherNameTxt.setForeground(Color.red);
                            }
                        } else {
                            lnameInfoTxt.setVisible(true);
                            lnameInfoTxt.setText("Uncorrect Last Name");
                            lnameInfoTxt.setForeground(Color.red);
                        }
                    } else {
                        lnameInfoTxt.setVisible(true);
                        lnameInfoTxt.setText("Greater than 3, less than 50");
                        lastNameTxt.setForeground(Color.red);
                    }

                } else {
                    fnameInfoTxt.setVisible(true);
                    fnameInfoTxt.setText("Uncorrect name");
                    fnameInfoTxt.setForeground(Color.red);

                }
            } else {
                fnameInfoTxt.setVisible(true);
                fnameInfoTxt.setText("Greater than 3, less than 50");
                firstNameTxt.setForeground(Color.red);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void maleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadioActionPerformed
        maleRadio.setText("Male");
        maleRadio.setActionCommand("Male");
        genderInfoTxt.setVisible(false);
    }//GEN-LAST:event_maleRadioActionPerformed

    private void femaleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioActionPerformed
        femaleRadio.setText("Female");
        femaleRadio.setActionCommand("Female");
        genderInfoTxt.setVisible(false);

    }//GEN-LAST:event_femaleRadioActionPerformed

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

    private void minimizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeBtnActionPerformed
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_minimizeBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();

    }//GEN-LAST:event_backBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int closeChoose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE,  TO CLOSE THE PROGRAM ?");
        if (closeChoose == JOptionPane.YES_OPTION) {
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

    private void fatherNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fatherNameTxtActionPerformed
        fatherNameInfoTxt.setVisible(false);
        fatherNameTxt.setForeground(Color.BLUE.darker().darker());
    }//GEN-LAST:event_fatherNameTxtActionPerformed

    private void lastNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTxtActionPerformed
        lnameInfoTxt.setVisible(false);
        lastNameTxt.setForeground(Color.BLUE.darker().darker());
    }//GEN-LAST:event_lastNameTxtActionPerformed

    private void searchNationalityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchNationalityTxtActionPerformed
        keyword = searchNationalityTxt.getText();
        showNationality(keyword);
        nationalityCombo.setVisible(true);
    }//GEN-LAST:event_searchNationalityTxtActionPerformed

    private void searchNationalityTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchNationalityTxtMouseClicked
        keyword = searchNationalityTxt.getText();
        showNationality(keyword);
        nationalityCombo.setVisible(true);
    }//GEN-LAST:event_searchNationalityTxtMouseClicked

    private void searchNationalityTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchNationalityTxtKeyPressed
        keyword = searchNationalityTxt.getText();
        showNationality(keyword);
        nationalityCombo.setVisible(true);
    }//GEN-LAST:event_searchNationalityTxtKeyPressed

    private void firstNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTxtActionPerformed
        fnameInfoTxt.setVisible(false);
        firstNameTxt.setForeground(Color.BLUE.darker().darker());
    }//GEN-LAST:event_firstNameTxtActionPerformed

    private void firstNameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstNameTxtMouseClicked
        fnameInfoTxt.setVisible(false);
        firstNameTxt.setForeground(Color.BLUE.darker().darker());
    }//GEN-LAST:event_firstNameTxtMouseClicked

    private void firstNameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstNameTxtKeyPressed
        fnameInfoTxt.setVisible(false);
        firstNameTxt.setForeground(Color.BLUE.darker().darker());
    }//GEN-LAST:event_firstNameTxtKeyPressed

    private void lastNameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastNameTxtMouseClicked
        lnameInfoTxt.setVisible(false);
        lastNameTxt.setForeground(Color.BLUE.darker().darker());
    }//GEN-LAST:event_lastNameTxtMouseClicked

    private void lastNameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastNameTxtKeyPressed
        lnameInfoTxt.setVisible(false);
        lastNameTxt.setForeground(Color.BLUE.darker().darker());
    }//GEN-LAST:event_lastNameTxtKeyPressed

    private void fatherNameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fatherNameTxtMouseClicked
        fatherNameInfoTxt.setVisible(false);
        fatherNameTxt.setForeground(Color.BLUE.darker().darker());
    }//GEN-LAST:event_fatherNameTxtMouseClicked

    private void fatherNameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fatherNameTxtKeyPressed
        fatherNameInfoTxt.setVisible(false);
        fatherNameTxt.setForeground(Color.BLUE.darker().darker());
    }//GEN-LAST:event_fatherNameTxtKeyPressed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        if (jPanel2.isShowing()) {
            firstNameTxt.setText("");
            fnameInfoTxt.setVisible(false);
            lastNameTxt.setText("");
            lnameInfoTxt.setVisible(false);
            fatherNameTxt.setText("");
            fatherNameInfoTxt.setVisible(false);
            nationalityCombo.setVisible(false);
            searchNationalityTxt.setText("");
        } else if (jPanel3.isShowing()) {
            rewardTxt.setText("");
            noteTxt.setText("");
            subjectInfoTxt.setVisible(false);
            listSubject.setSelectedIndex(-1);
            listBook.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_clearBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        BookItemFrame bookItemFrame = new BookItemFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        bookItemFrame.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton backBtn1;
    private javax.swing.JButton clearBtn;
    private com.toedter.calendar.JDateChooser deadCalendar;
    private com.toedter.calendar.JDateChooser dobCalendar;
    private javax.swing.JTextField fatherNameInfoTxt;
    private javax.swing.JTextField fatherNameTxt;
    private javax.swing.JRadioButton femaleRadio;
    private javax.swing.JTextField firstNameTxt;
    private javax.swing.JTextField fnameInfoTxt;
    private javax.swing.JTextField genderInfoTxt;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lastNameTxt;
    private javax.swing.JList<Item> listBook;
    private javax.swing.JList<Item> listSubject;
    private javax.swing.JTextField lnameInfoTxt;
    private javax.swing.JRadioButton maleRadio;
    private javax.swing.JButton minimizeBtn;
    private javax.swing.JButton minimizeBtn1;
    private javax.swing.JComboBox<String> nationalityCombo;
    private javax.swing.JTextArea noteTxt;
    private javax.swing.JButton restoreBtn;
    private javax.swing.JButton restoreBtn1;
    private javax.swing.JTextArea rewardTxt;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField searchNationalityTxt;
    private javax.swing.JTextField subjectInfoTxt;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables

    private void showSubjectList() {
        try {
            List<Subjects> subjectList = subjectService.getSubjectList();
            for (Subjects s : subjectList) {
                models.addElement(new Item(s.getId(), s.getSubjectName()));
            }
            listSubject.setModel(models);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void showList() {
        try {
            List<Book> booklist = bookService.getBookWhichNotAuthor();
            for (Book book : booklist) {
                model.addElement(new Item(book.getId(), book.getIsbn() + "\\    " + book.getTitle()));
            }
            listBook.setModel(model);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

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
            }
        }
    }

    void hideInfoTxt() {
        fnameInfoTxt.setVisible(false);
        lnameInfoTxt.setVisible(false);
        fatherNameInfoTxt.setVisible(false);
        genderInfoTxt.setVisible(false);
        subjectInfoTxt.setVisible(false);
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
                c.setBackground(Color.WHITE.darker());
                c = super.getListCellRendererComponent(list, value, index, isSelected,
                        cellHasFocus);
            }
            return c;
        }
    }
}
