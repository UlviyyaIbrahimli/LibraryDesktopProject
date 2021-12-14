package project.library.desktop.DesktopGui.hr;

import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import project.library.desktop.model.Login;
import project.library.desktop.model.employee.Branch;
import project.library.desktop.model.employee.EducationType;
import project.library.desktop.model.employee.Employee;
import project.library.desktop.model.employee.Position;
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
public class AddEmployeeFrame extends javax.swing.JFrame {

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
    ButtonGroup genderGroup = new ButtonGroup();
    ButtonGroup marritialGroup = new ButtonGroup();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private boolean but = false;

    public AddEmployeeFrame() {

    }

    AddEmployeeFrame(DepartmentService departmentService,
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
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        marritialGroup.add(singleRadio);
        marritialGroup.add(marriedRadio);
        showBranchCombo();
        showEducationDegreeCombo1();

        this.getContentPane().setBackground(Color.BLUE.darker());

        this.setDefaultLookAndFeelDecorated(true);
        this.pack();
        this.setLocationRelativeTo(null);
        try {
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.darker().darker());
        } catch (Exception e) {
            e.printStackTrace();
        }
        nationalityCombo.setVisible(false);
        countryCombo.setVisible(false);
        nationalityCombo.setRenderer(new AddEmployeeFrame.TwoDecimalRenderer(nationalityCombo.getRenderer()));
        countryCombo.setRenderer(new AddEmployeeFrame.TwoDecimalRenderer(countryCombo.getRenderer()));
        branchCmb.setRenderer(new AddEmployeeFrame.TwoDecimalRenderer(branchCmb.getRenderer()));
        positionCmb.setRenderer(new AddEmployeeFrame.TwoDecimalRenderer(positionCmb.getRenderer()));
        educationCmb1.setRenderer(new AddEmployeeFrame.TwoDecimalRenderer(educationCmb1.getRenderer()));

        hideInfoFields();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        restoreBtn = new javax.swing.JButton();
        minimazeBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        per = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        workPanel = new javax.swing.JPanel();
        branchTxt1 = new javax.swing.JLabel();
        branchCmb = new javax.swing.JComboBox<>();
        PositionTxt1 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        beginToWorkLbl1 = new javax.swing.JLabel();
        noteTax1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        noteTxt = new javax.swing.JTextArea();
        cardNumberTxt = new javax.swing.JTextField();
        salaryTxt = new javax.swing.JTextField();
        beginToWorkTxtCalendar = new com.toedter.calendar.JDateChooser();
        positionCmb = new javax.swing.JComboBox<>();
        positionInfoTxt = new javax.swing.JTextField();
        branchInfoTxt = new javax.swing.JTextField();
        salaryInfoTxt = new javax.swing.JTextField();
        cardNumberInfoTx = new javax.swing.JTextField();
        beginWorkInfoTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        addressPanel = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        cityTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        streetTxt = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        houseNumberTxt = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        phone1Txt = new javax.swing.JTextField();
        homeNumberTxt = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        homePhoneTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        phone2Txt = new javax.swing.JTextField();
        countryCombo = new javax.swing.JComboBox<>();
        emailInfoTxt = new javax.swing.JTextField();
        searchCountryTxt = new javax.swing.JTextField();
        personalPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lastNameTxt = new javax.swing.JTextField();
        identitiTxt = new javax.swing.JTextField();
        imageTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        firstNameTxt = new javax.swing.JTextField();
        fatherNameTxt = new javax.swing.JTextField();
        dobTxt = new com.toedter.calendar.JDateChooser();
        maleRadio = new javax.swing.JRadioButton();
        singleRadio = new javax.swing.JRadioButton();
        marriedRadio = new javax.swing.JRadioButton();
        femaleRadio = new javax.swing.JRadioButton();
        nationalityCombo = new javax.swing.JComboBox<>();
        fNameInfoTxt = new javax.swing.JTextField();
        lNameInfoTxt = new javax.swing.JTextField();
        genderInfo = new javax.swing.JTextField();
        mariageInfoTxt = new javax.swing.JTextField();
        fatherNameInfoTxt = new javax.swing.JTextField();
        dobInfoTxt = new javax.swing.JTextField();
        identityInfoTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lableName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        searchNationalityTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        eduPanel1 = new javax.swing.JPanel();
        universityTxt = new javax.swing.JTextField();
        graduateTxt2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        diplomaNumberTxt = new javax.swing.JTextField();
        uni1GraduteCalendar = new com.toedter.calendar.JDateChooser();
        educationCmb1 = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        universityTxt4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        certificateTxt = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        eduDegreeWarning = new javax.swing.JTextField();
        graudateDateWarning = new javax.swing.JTextField();
        addDiplomaWarning = new javax.swing.JTextField();
        uniWarning = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cancelBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 0, 102));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-undo-24.png"))); // NOI18N
        backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        restoreBtn.setBackground(new java.awt.Color(0, 51, 255));
        restoreBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-restore-window-32.png"))); // NOI18N
        restoreBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        restoreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreBtnActionPerformed(evt);
            }
        });

        minimazeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-minimize-window-48.png"))); // NOI18N
        minimazeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimazeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimazeBtnActionPerformed(evt);
            }
        });

        closeBtn.setBackground(new java.awt.Color(153, 0, 0));
        closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/close.png"))); // NOI18N
        closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("              ADD EMPLOYEE");

        per.setBackground(new java.awt.Color(102, 0, 102));
        per.setForeground(new java.awt.Color(0, 0, 153));

        workPanel.setBackground(new java.awt.Color(0, 0, 153));

        branchTxt1.setBackground(new java.awt.Color(0, 0, 153));
        branchTxt1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        branchTxt1.setForeground(new java.awt.Color(255, 255, 255));
        branchTxt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        branchTxt1.setText("Branch");
        branchTxt1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        branchCmb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        branchCmb.setForeground(new java.awt.Color(0, 0, 153));
        branchCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Branch" }));
        branchCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        branchCmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                branchCmbItemStateChanged(evt);
            }
        });
        branchCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchCmbActionPerformed(evt);
            }
        });

        PositionTxt1.setBackground(new java.awt.Color(0, 0, 153));
        PositionTxt1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        PositionTxt1.setForeground(new java.awt.Color(255, 255, 255));
        PositionTxt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PositionTxt1.setText("Position");
        PositionTxt1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        jLabel36.setBackground(new java.awt.Color(0, 0, 153));
        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Salary");
        jLabel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        jLabel37.setBackground(new java.awt.Color(0, 0, 153));
        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Card Number");
        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        beginToWorkLbl1.setBackground(new java.awt.Color(0, 0, 153));
        beginToWorkLbl1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        beginToWorkLbl1.setForeground(new java.awt.Color(255, 255, 255));
        beginToWorkLbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        beginToWorkLbl1.setText("Begin To Work Date");
        beginToWorkLbl1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        noteTax1.setBackground(new java.awt.Color(0, 0, 153));
        noteTax1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        noteTax1.setForeground(new java.awt.Color(255, 255, 255));
        noteTax1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noteTax1.setText("Note");
        noteTax1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        noteTxt.setColumns(20);
        noteTxt.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        noteTxt.setForeground(new java.awt.Color(0, 0, 153));
        noteTxt.setRows(5);
        jScrollPane2.setViewportView(noteTxt);

        cardNumberTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cardNumberTxt.setForeground(new java.awt.Color(0, 0, 153));
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

        salaryTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        salaryTxt.setForeground(new java.awt.Color(0, 0, 153));
        salaryTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salaryTxtMouseClicked(evt);
            }
        });
        salaryTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryTxtActionPerformed(evt);
            }
        });

        beginToWorkTxtCalendar.setForeground(new java.awt.Color(0, 0, 153));

        positionCmb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        positionCmb.setForeground(new java.awt.Color(0, 0, 153));
        positionCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Position" }));
        positionCmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                positionCmbItemStateChanged(evt);
            }
        });
        positionCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionCmbActionPerformed(evt);
            }
        });

        positionInfoTxt.setEditable(false);
        positionInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        positionInfoTxt.setForeground(new java.awt.Color(153, 0, 0));
        positionInfoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionInfoTxtActionPerformed(evt);
            }
        });

        branchInfoTxt.setEditable(false);
        branchInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        branchInfoTxt.setForeground(new java.awt.Color(153, 0, 0));

        salaryInfoTxt.setEditable(false);
        salaryInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        salaryInfoTxt.setForeground(new java.awt.Color(153, 0, 0));

        cardNumberInfoTx.setEditable(false);
        cardNumberInfoTx.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        cardNumberInfoTx.setForeground(new java.awt.Color(153, 0, 0));

        beginWorkInfoTxt.setEditable(false);
        beginWorkInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        beginWorkInfoTxt.setForeground(new java.awt.Color(153, 0, 0));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("*");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("*");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 0, 0));
        jLabel18.setText("*");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 0, 0));
        jLabel19.setText("*");

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(204, 0, 0));
        jLabel28.setText("*");

        javax.swing.GroupLayout workPanelLayout = new javax.swing.GroupLayout(workPanel);
        workPanel.setLayout(workPanelLayout);
        workPanelLayout.setHorizontalGroup(
            workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, workPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(noteTax1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(workPanelLayout.createSequentialGroup()
                        .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(workPanelLayout.createSequentialGroup()
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(workPanelLayout.createSequentialGroup()
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(workPanelLayout.createSequentialGroup()
                                .addComponent(beginToWorkLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(workPanelLayout.createSequentialGroup()
                                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(branchTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PositionTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cardNumberInfoTx, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(salaryInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(beginWorkInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(positionInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(branchInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(workPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cardNumberTxt)
                            .addComponent(beginToWorkTxtCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                            .addComponent(salaryTxt)))
                    .addGroup(workPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(positionCmb, javax.swing.GroupLayout.Alignment.TRAILING, 0, 240, Short.MAX_VALUE)
                            .addComponent(branchCmb, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(50, 50, 50))
        );
        workPanelLayout.setVerticalGroup(
            workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workPanelLayout.createSequentialGroup()
                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(workPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(branchCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(positionCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(workPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(25, 25, 25)
                                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(beginToWorkLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3))
                            .addGroup(workPanelLayout.createSequentialGroup()
                                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(workPanelLayout.createSequentialGroup()
                                        .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18))
                                        .addGap(25, 25, 25))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, workPanelLayout.createSequentialGroup()
                                        .addComponent(salaryTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cardNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cardNumberInfoTx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(beginToWorkTxtCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(workPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(branchTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(branchInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PositionTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(180, 180, 180))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, workPanelLayout.createSequentialGroup()
                        .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(workPanelLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(positionInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(workPanelLayout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(beginWorkInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(workPanelLayout.createSequentialGroup()
                                        .addComponent(salaryInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(99, 99, 99)))))
                        .addGap(21, 21, 21)))
                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(noteTax1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(workPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(workPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        per.addTab("Work Information", jPanel12);

        addressPanel.setBackground(new java.awt.Color(0, 0, 153));

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Country");
        jLabel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("City");
        jLabel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        cityTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cityTxt.setForeground(new java.awt.Color(0, 0, 153));
        cityTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityTxtActionPerformed(evt);
            }
        });

        emailTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        emailTxt.setForeground(new java.awt.Color(0, 0, 153));
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailTxtKeyReleased(evt);
            }
        });

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Email");
        jLabel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        streetTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        streetTxt.setForeground(new java.awt.Color(0, 0, 153));
        streetTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streetTxtActionPerformed(evt);
            }
        });

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Street");
        jLabel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        houseNumberTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        houseNumberTxt.setForeground(new java.awt.Color(0, 0, 153));

        jLabel42.setBackground(new java.awt.Color(255, 255, 255));
        jLabel42.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Home Number");
        jLabel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        phone1Txt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        phone1Txt.setForeground(new java.awt.Color(0, 0, 153));

        homeNumberTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        homeNumberTxt.setForeground(new java.awt.Color(0, 0, 153));
        homeNumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeNumberTxtActionPerformed(evt);
            }
        });

        jLabel43.setBackground(new java.awt.Color(255, 255, 255));
        jLabel43.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("House Number");
        jLabel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Phone_1");
        jLabel44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        homePhoneTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        homePhoneTxt.setForeground(new java.awt.Color(0, 0, 153));
        homePhoneTxt.setBorder(null);
        homePhoneTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homePhoneTxtActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Home Phone");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Phone _2");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        phone2Txt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        phone2Txt.setForeground(new java.awt.Color(0, 0, 153));
        phone2Txt.setBorder(null);
        phone2Txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone2TxtActionPerformed(evt);
            }
        });

        countryCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        countryCombo.setForeground(new java.awt.Color(0, 0, 102));

        emailInfoTxt.setEditable(false);
        emailInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        emailInfoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailInfoTxtActionPerformed(evt);
            }
        });

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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchCountryTxtKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout addressPanelLayout = new javax.swing.GroupLayout(addressPanel);
        addressPanel.setLayout(addressPanelLayout);
        addressPanelLayout.setHorizontalGroup(
            addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addressPanelLayout.createSequentialGroup()
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addressPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addressPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                        .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(countryCombo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchCountryTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cityTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)))
                    .addGroup(addressPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(emailInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(streetTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(phone2Txt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(phone1Txt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(homeNumberTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(houseNumberTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(homePhoneTxt)
                            .addComponent(emailTxt, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(50, 50, 50))
        );
        addressPanelLayout.setVerticalGroup(
            addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addressPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addressPanelLayout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(addressPanelLayout.createSequentialGroup()
                        .addComponent(searchCountryTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(countryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streetTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(houseNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phone1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phone2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homePhoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        per.addTab("Address Information", addressPanel);

        personalPanel.setBackground(new java.awt.Color(0, 0, 153));

        jLabel9.setBackground(new java.awt.Color(0, 0, 153));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Last Name");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        jLabel17.setBackground(new java.awt.Color(0, 0, 153));
        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Gender");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        jLabel21.setBackground(new java.awt.Color(0, 0, 153));
        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Marriage Status");
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        jLabel22.setBackground(new java.awt.Color(0, 0, 153));
        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Father Name");
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        jLabel22.setMaximumSize(new java.awt.Dimension(72, 21));
        jLabel22.setMinimumSize(new java.awt.Dimension(72, 21));

        jLabel23.setBackground(new java.awt.Color(0, 0, 153));
        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Date of Birthday");
        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        jLabel24.setBackground(new java.awt.Color(0, 0, 153));
        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Identiti");
        jLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255)));

        jLabel25.setBackground(new java.awt.Color(0, 0, 153));
        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Image");
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        jLabel26.setBackground(new java.awt.Color(0, 0, 153));
        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Nationality");
        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lastNameTxtKeyReleased(evt);
            }
        });

        identitiTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        identitiTxt.setForeground(new java.awt.Color(0, 0, 153));
        identitiTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                identitiTxtMouseClicked(evt);
            }
        });
        identitiTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identitiTxtActionPerformed(evt);
            }
        });

        imageTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        imageTxt.setForeground(new java.awt.Color(0, 0, 153));
        imageTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageTxtActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("First Name");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                firstNameTxtKeyReleased(evt);
            }
        });

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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fatherNameTxtKeyReleased(evt);
            }
        });

        dobTxt.setForeground(new java.awt.Color(0, 0, 255));
        dobTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dobTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dobTxtMouseEntered(evt);
            }
        });
        dobTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dobTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dobTxtKeyReleased(evt);
            }
        });

        maleRadio.setBackground(new java.awt.Color(0, 0, 255));
        maleRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        maleRadio.setForeground(new java.awt.Color(255, 255, 255));
        maleRadio.setText("Male");
        maleRadio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        maleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioActionPerformed(evt);
            }
        });

        singleRadio.setBackground(new java.awt.Color(0, 0, 255));
        singleRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        singleRadio.setForeground(new java.awt.Color(255, 255, 255));
        singleRadio.setText("Single");
        singleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleRadioActionPerformed(evt);
            }
        });

        marriedRadio.setBackground(new java.awt.Color(0, 0, 255));
        marriedRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        marriedRadio.setForeground(new java.awt.Color(255, 255, 255));
        marriedRadio.setText("Married");
        marriedRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marriedRadioActionPerformed(evt);
            }
        });

        femaleRadio.setBackground(new java.awt.Color(0, 0, 255));
        femaleRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        femaleRadio.setForeground(new java.awt.Color(255, 255, 255));
        femaleRadio.setText("Female");
        femaleRadio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        femaleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioActionPerformed(evt);
            }
        });

        nationalityCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nationalityCombo.setForeground(new java.awt.Color(0, 0, 102));
        nationalityCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nationalityCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nationalityComboItemStateChanged(evt);
            }
        });

        fNameInfoTxt.setEditable(false);
        fNameInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        fNameInfoTxt.setForeground(new java.awt.Color(102, 0, 0));
        fNameInfoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fNameInfoTxtActionPerformed(evt);
            }
        });

        lNameInfoTxt.setEditable(false);
        lNameInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

        genderInfo.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        genderInfo.setForeground(new java.awt.Color(153, 0, 0));

        mariageInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        mariageInfoTxt.setForeground(new java.awt.Color(153, 0, 0));

        fatherNameInfoTxt.setEditable(false);
        fatherNameInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        fatherNameInfoTxt.setForeground(new java.awt.Color(153, 0, 0));

        dobInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        dobInfoTxt.setForeground(new java.awt.Color(153, 0, 0));

        identityInfoTxt.setEditable(false);
        identityInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        identityInfoTxt.setForeground(new java.awt.Color(153, 0, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("*");

        lableName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lableName.setForeground(new java.awt.Color(204, 0, 0));
        lableName.setText("*");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("*");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("*");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("*");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setText("*");

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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchNationalityTxtKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8.setText("*");

        javax.swing.GroupLayout personalPanelLayout = new javax.swing.GroupLayout(personalPanel);
        personalPanel.setLayout(personalPanelLayout);
        personalPanelLayout.setHorizontalGroup(
            personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalPanelLayout.createSequentialGroup()
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalPanelLayout.createSequentialGroup()
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lableName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(identityInfoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(fatherNameInfoTxt)
                            .addComponent(lNameInfoTxt)
                            .addComponent(fNameInfoTxt)
                            .addComponent(genderInfo)
                            .addComponent(mariageInfoTxt)
                            .addComponent(dobInfoTxt))
                        .addGap(50, 50, 50)
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(identitiTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(imageTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(personalPanelLayout.createSequentialGroup()
                                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(femaleRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(singleRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(70, 70, 70)
                                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(marriedRadio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(maleRadio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(fatherNameTxt)
                            .addComponent(lastNameTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(firstNameTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dobTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(personalPanelLayout.createSequentialGroup()
                        .addGap(469, 469, 469)
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nationalityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchNationalityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50))
        );
        personalPanelLayout.setVerticalGroup(
            personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lableName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fNameInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(firstNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lNameInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalPanelLayout.createSequentialGroup()
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fatherNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fatherNameInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(personalPanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(femaleRadio)
                                    .addComponent(maleRadio)))
                            .addGroup(personalPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(genderInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(personalPanelLayout.createSequentialGroup()
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalPanelLayout.createSequentialGroup()
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(singleRadio)
                            .addComponent(marriedRadio))
                        .addGap(18, 18, 18)
                        .addComponent(dobTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(identitiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(imageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(personalPanelLayout.createSequentialGroup()
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mariageInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dobInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(identityInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personalPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchNationalityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(nationalityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        per.addTab("Personal Information", personalPanel);

        eduPanel1.setBackground(new java.awt.Color(0, 0, 153));

        universityTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        universityTxt.setForeground(new java.awt.Color(0, 0, 153));
        universityTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));
        universityTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                universityTxtActionPerformed(evt);
            }
        });
        universityTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                universityTxtKeyPressed(evt);
            }
        });

        graduateTxt2.setBackground(new java.awt.Color(0, 0, 153));
        graduateTxt2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        graduateTxt2.setForeground(new java.awt.Color(255, 255, 255));
        graduateTxt2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        graduateTxt2.setText("Graduate Date");
        graduateTxt2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        jLabel15.setBackground(new java.awt.Color(0, 0, 153));
        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Diploma №");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        diplomaNumberTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        diplomaNumberTxt.setForeground(new java.awt.Color(0, 0, 153));
        diplomaNumberTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));
        diplomaNumberTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                diplomaNumberTxtKeyPressed(evt);
            }
        });

        uni1GraduteCalendar.setForeground(new java.awt.Color(0, 0, 153));
        uni1GraduteCalendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uni1GraduteCalendarMouseClicked(evt);
            }
        });

        educationCmb1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        educationCmb1.setForeground(new java.awt.Color(0, 0, 102));
        educationCmb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Degree" }));
        educationCmb1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        educationCmb1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                educationCmb1ItemStateChanged(evt);
            }
        });

        jLabel29.setBackground(new java.awt.Color(0, 0, 153));
        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Education Degree");
        jLabel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        universityTxt4.setBackground(new java.awt.Color(0, 0, 153));
        universityTxt4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        universityTxt4.setForeground(new java.awt.Color(255, 255, 255));
        universityTxt4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        universityTxt4.setText("University");
        universityTxt4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        jLabel16.setBackground(new java.awt.Color(0, 0, 153));
        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Certificate");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        certificateTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        certificateTxt.setForeground(new java.awt.Color(0, 0, 153));
        certificateTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));

        add.setBackground(new java.awt.Color(0, 51, 153));
        add.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Add  New Education");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout eduPanel1Layout = new javax.swing.GroupLayout(eduPanel1);
        eduPanel1.setLayout(eduPanel1Layout);
        eduPanel1Layout.setHorizontalGroup(
            eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eduPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eduPanel1Layout.createSequentialGroup()
                        .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(universityTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(graduateTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addDiplomaWarning)
                            .addComponent(uniWarning)
                            .addComponent(graudateDateWarning))
                        .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(eduPanel1Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(universityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eduPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(uni1GraduteCalendar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(diplomaNumberTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eduPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(eduDegreeWarning)
                        .addGap(352, 352, 352)
                        .addComponent(educationCmb1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(eduPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(292, 292, 292)
                        .addComponent(certificateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eduPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(104, 104, 104)
                .addComponent(add)
                .addContainerGap())
        );
        eduPanel1Layout.setVerticalGroup(
            eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eduPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eduPanel1Layout.createSequentialGroup()
                        .addComponent(universityTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(graduateTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addDiplomaWarning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(eduPanel1Layout.createSequentialGroup()
                        .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(universityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uniWarning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uni1GraduteCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(graudateDateWarning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(diplomaNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(educationCmb1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eduDegreeWarning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(73, 73, 73)
                .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(jButton1))
                .addGap(47, 47, 47)
                .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(certificateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 959, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(eduPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(eduPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        per.addTab("Education Information", jPanel7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimazeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(per, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(restoreBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimazeBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(per, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cancelBtn.setBackground(new java.awt.Color(102, 0, 0));
        cancelBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("CANCEL");
        cancelBtn.setToolTipText("");
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        clearBtn.setBackground(new java.awt.Color(102, 0, 0));
        clearBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("CLEAR");
        clearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        saveBtn.setBackground(new java.awt.Color(0, 0, 153));
        saveBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("SAVE");
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        String nationality = null;
        String country = null;
        try {
            String fName = firstNameTxt.getText();
            if (!(fName.isEmpty()) && (fName.matches("[\\p{L}\\s\\.]+"))) {
                if (fName.length() >= 3 && fName.length() <= 50) {
                    String lName = lastNameTxt.getText();
                    if (!(lName.isEmpty()) && (lName.matches("[\\p{L}\\s\\.]+"))) {
                        if (lName.length() >= 3 && lName.length() <= 50) {
                            String fatherName = fatherNameTxt.getText();
                            if (!(fatherName.isEmpty()) && (fatherName.matches("[\\p{L}\\s\\.]+"))) {
                                if (fatherName.length() >= 3 && fatherName.length() <= 50) {
                                    if (maleRadio.isSelected() || femaleRadio.isSelected()) {
                                        String gender = genderGroup.getSelection().getActionCommand();
                                        if (singleRadio.isSelected() || marriedRadio.isSelected()) {
                                            String martialStatus = marritialGroup.getSelection().getActionCommand();
                                            Date dob = dobTxt.getDate();
                                            if (dob != null) {
                                                String identity = identitiTxt.getText();
                                                if (!(identity.isEmpty()) && identity.length() <= 20) {
                                                    boolean checkI = checkIdentity(identity);
                                                    if (checkI) {
                                                        if (nationalityCombo.getSelectedIndex() != -1) {
                                                            nationality = (String) nationalityCombo.getSelectedItem();
                                                        }
                                                        String note = noteTxt.getText();
                                                        if (countryCombo.getSelectedIndex() != -1) {
                                                            country = (String) countryCombo.getSelectedItem();
                                                        }
                                                        String eMail = emailTxt.getText();
                                                        if ((!eMail.equals(" ")) && eMail.contains("@") && (!eMail.contains(",")) || eMail == null) {
                                                            if (educationCmb1.getSelectedIndex() != 0) {
                                                                Item educationDegreeItem = (Item) educationCmb1.getSelectedItem();
                                                                Long edduDegree1 = educationDegreeItem.getId();
                                                                if (branchCmb.getSelectedIndex() != 0) {
                                                                    Item branchItem = (Item) branchCmb.getSelectedItem();
                                                                    if (positionCmb.getSelectedIndex() != 0) {
                                                                        String salary = salaryTxt.getText();
                                                                        if (salary.matches("[0-9]+(\\.[0-9]+)?")) {
                                                                            String cardnumber = cardNumberTxt.getText();
                                                                            if (!(cardnumber.isEmpty()) && cardnumber.length() <= 20) {
                                                                                boolean checkCard = checkCardNumber(cardnumber);
                                                                                if (checkCard) {
                                                                                    Item positionItem = (Item) positionCmb.getSelectedItem();
                                                                                    Date beginToWorkDate = beginToWorkTxtCalendar.getDate();
                                                                                    if (beginToWorkDate != null) {
                                                                                        String city = cityTxt.getText();
                                                                                        String street = streetTxt.getText();
                                                                                        String houseNumber = houseNumberTxt.getText();
                                                                                        String homeNumber = homeNumberTxt.getText();
                                                                                        String phone1 = phone1Txt.getText();
                                                                                        String phone2 = phone2Txt.getText();
                                                                                        String homePhone = homePhoneTxt.getText();
                                                                                        String university = universityTxt.getText();
                                                                                        if (!university.isEmpty() && university.length() < 50) {
                                                                                            Date graduateDate = uni1GraduteCalendar.getDate();
                                                                                            String diploma = diplomaNumberTxt.getText();
                                                                                            if (!diploma.isEmpty()) {
                                                                                                String certificate = certificateTxt.getText();
                                                                                                Employee employee = new Employee();
                                                                                                employee.setFirstName(fName);
                                                                                                employee.setLastName(lName);
                                                                                                employee.setFatherName(fatherName);
                                                                                                employee.setHouseNumber(houseNumber);
                                                                                                employee.setDob(dob);
                                                                                                employee.setGender(gender);
                                                                                                employee.setMaritalStatus(martialStatus);
                                                                                                employee.setCardNumber(cardnumber);
                                                                                                employee.setBeginToWork(beginToWorkDate);
                                                                                                employee.setIndentifyNumber(identity);
                                                                                                employee.setSalary(Float.parseFloat(salary));
                                                                                                employee.setCountry(country);
                                                                                                employee.setCity(city);
                                                                                                employee.setStreet(street);
                                                                                                employee.setHomeNumber(homeNumber);
                                                                                                employee.setPhone1(phone1);
                                                                                                employee.setPhone2(phone2);
                                                                                                employee.setHomePhone(homePhone);
                                                                                                employee.seteMail(eMail);
                                                                                                employee.setMaritalStatus(martialStatus);
                                                                                                Position position = new Position();
                                                                                                position.setId(positionItem.getId());
                                                                                                employee.setPosition(position);
                                                                                                Branch branch = new Branch();
                                                                                                EducationType educationType = new EducationType();
                                                                                                educationType.setId(edduDegree1);
                                                                                                employee.setEducationType(educationType);
                                                                                                branch.setId(branchItem.getId());
                                                                                                employee.setBranc(branch);
                                                                                                employee.setNote(note);
                                                                                                employee.setNationality(nationality);
                                                                                                employee.setUniversity(university);
                                                                                                employee.setGraduateDate(graduateDate);
                                                                                                employee.setDiplomaNumber(diploma);
                                                                                                employee.setCertification(certificate);
                                                                                                employee.setEducationType(educationType);
                                                                                                boolean isAddEmployee = employeeService.addEmployee(employee);
                                                                                                Long empId = employeeService.getCurrentId();

                                                                                                if (but == true) {
                                                                                                    boolean rrr = employeeService.addEmployee(empId, employee);

                                                                                                }
                                                                                                boolean rr = employeeService.addEmployee(empId, employee);
                                                                                                if (isAddEmployee == true && rr == true) {

                                                                                                    JOptionPane.showMessageDialog(null, "Success!");
                                                                                                } else {
                                                                                                    JOptionPane.showMessageDialog(null, fName + " " + lName + "  IS NOT ADDRED", "FAIL", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\LibraryDesktopProject\\src\\project\\library\\desktop\\gui\\icon\\report.png"));
                                                                                                }
                                                                                            } else {
                                                                                                addDiplomaWarning.setVisible(true);
                                                                                                addDiplomaWarning.setText("Add number");
                                                                                            }
                                                                                        } else {
                                                                                            uniWarning.setVisible(true);
                                                                                            uniWarning.setText("max.50 simvol");
                                                                                        }
                                                                                    } else {

                                                                                        beginWorkInfoTxt.setVisible(true);
                                                                                        beginToWorkTxtCalendar.setForeground(Color.red);
                                                                                        beginToWorkTxtCalendar.setFocusable(true);
                                                                                        beginWorkInfoTxt.setText("Select Date");

                                                                                    }
                                                                                } else {
                                                                                    cardNumberInfoTx.setVisible(true);
                                                                                    cardNumberTxt.setForeground(Color.red);
                                                                                    cardNumberInfoTx.setText("Repeated CardNumber");
                                                                                }
                                                                            } else {
                                                                                cardNumberInfoTx.setVisible(true);
                                                                                cardNumberTxt.setForeground(Color.red);
                                                                                cardNumberInfoTx.setText("Max. 20 simvols");
                                                                            }
                                                                        } else {

                                                                            salaryInfoTxt.setVisible(true);
                                                                            salaryTxt.setForeground(Color.red);
                                                                            salaryInfoTxt.setText("Just Number Type");

                                                                        }
                                                                    } else {

                                                                        positionInfoTxt.setVisible(true);
                                                                        positionCmb.setForeground(Color.red);
                                                                        positionInfoTxt.setText("Select position");

                                                                    }
                                                                } else {

                                                                    branchInfoTxt.setVisible(true);
                                                                    branchCmb.setForeground(Color.red);
                                                                    branchInfoTxt.setText("Select branch");

                                                                }
                                                            } else {
                                                                eduDegreeWarning.setVisible(true);
                                                                educationCmb1.setForeground(Color.red);
                                                                eduDegreeWarning.setText("Select education degree");

                                                            }
                                                        } else {
                                                            emailInfoTxt.setVisible(true);
                                                            emailTxt.setForeground(Color.red);
                                                            emailInfoTxt.setText("Uncorrect Email");
//                                                       
                                                        }
                                                    } else {
                                                        identityInfoTxt.setVisible(true);
                                                        identitiTxt.setForeground(Color.red);
                                                        identityInfoTxt.setText("Repeated Identity !");
                                                    }
                                                } else {
                                                    identityInfoTxt.setVisible(true);
                                                    identitiTxt.setForeground(Color.red);
                                                    identityInfoTxt.setText("Uncorrect!");
                                                }
                                            } else {
                                                dobInfoTxt.setVisible(true);
                                                dobInfoTxt.setText("Select date");
                                            }
                                        } else {
                                            mariageInfoTxt.setVisible(true);
                                            mariageInfoTxt.setText("Select marriage status");
                                        }
                                    } else {
                                        genderInfo.setVisible(true);
                                        genderInfo.setText("Select gender!");
                                    }
                                } else {
                                    fatherNameInfoTxt.setVisible(true);
                                    fatherNameTxt.setForeground(Color.red);
                                    fatherNameInfoTxt.setText("Greater than 3, less than 50");
                                }
                            } else {
                                fatherNameInfoTxt.setVisible(true);
                                fatherNameTxt.setForeground(Color.red);
                                fatherNameInfoTxt.setText("Uncorrect!");
                            }
                        } else {
                            lNameInfoTxt.setVisible(true);
                            lastNameTxt.setForeground(Color.red);
                            lNameInfoTxt.setText("Greater than 3, less than 50");
                        }
                    } else {
                        lNameInfoTxt.setVisible(true);
                        lastNameTxt.setForeground(Color.red);
                        lNameInfoTxt.setText("Uncorrect!");
                    }
                } else {
                    fNameInfoTxt.setVisible(true);
                    firstNameTxt.setForeground(Color.red);
                    fNameInfoTxt.setText("Greater than 3, less than 50");
                }
            } else {
                fNameInfoTxt.setVisible(true);
                firstNameTxt.setForeground(Color.red);
                fNameInfoTxt.setText("Uncorrect!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_saveBtnActionPerformed

    private void minimazeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimazeBtnActionPerformed
        this.setState(ICONIFIED);
    }//GEN-LAST:event_minimazeBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        int closeChoose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE, TO CLOSE THE PROGRAM ?");
        if (closeChoose == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_closeBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        if (personalPanel.isShowing()) {
            genderGroup.clearSelection();
            marritialGroup.clearSelection();
            firstNameTxt.setText("");
            lastNameTxt.setText("");
            fatherNameTxt.setText("");
            dobTxt.setDate(null);
            nationalityCombo.setSelectedIndex(0);
            identitiTxt.setText("");
            imageTxt.setText("");
        } else if (workPanel.isShowing()) {
            branchCmb.setSelectedIndex(0);
            positionCmb.setSelectedIndex(0);
            salaryTxt.setText("");
            cardNumberTxt.setText("");
            beginToWorkTxtCalendar.setDate(null);
            noteTxt.setText("");
        } else if (addressPanel.isShowing()) {
            countryCombo.setSelectedIndex(0);
            cityTxt.setText("");
            phone1Txt.setText("");
            phone2Txt.setText("");
            homeNumberTxt.setText("");
            homePhoneTxt.setText("");
            houseNumberTxt.setText("");
            streetTxt.setText("");
            emailTxt.setText("");

        } else if (eduPanel1.isShowing()) {

            uni1GraduteCalendar.setDate(null);
            universityTxt.setText("");
            diplomaNumberTxt.setText("");
            educationCmb1.setSelectedIndex(0);

        }
        hideInfoFields();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        EmployeeFrame employeeFrame = new EmployeeFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        employeeFrame.setVisible(true);

    }//GEN-LAST:event_backBtnActionPerformed

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

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
        EmployeeFrame employeeFrame = new EmployeeFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        employeeFrame.setVisible(true);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void educationCmb1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_educationCmb1ItemStateChanged
        eduDegreeWarning.setVisible(false);

    }//GEN-LAST:event_educationCmb1ItemStateChanged

    private void universityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_universityTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_universityTxtActionPerformed

    private void searchNationalityTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchNationalityTxtKeyReleased
        String nationality = searchNationalityTxt.getText();
        nationalityCombo.setVisible(true);
        if (nationality != null) {
            showNationality(nationality);
        }
    }//GEN-LAST:event_searchNationalityTxtKeyReleased

    private void searchNationalityTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchNationalityTxtKeyPressed
        String nationality = searchNationalityTxt.getText();
        nationalityCombo.setVisible(true);
        if (nationality != null) {
            showNationality(nationality);
        }
    }//GEN-LAST:event_searchNationalityTxtKeyPressed

    private void searchNationalityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchNationalityTxtActionPerformed
        String nationality = searchNationalityTxt.getText();
        nationalityCombo.setVisible(true);
        if (nationality != null) {
            showNationality(nationality);
        }
    }//GEN-LAST:event_searchNationalityTxtActionPerformed

    private void searchNationalityTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchNationalityTxtMouseClicked
        String nationality = searchNationalityTxt.getText();
        nationalityCombo.setVisible(true);
        if (nationality != null) {
            showNationality(nationality);
        }
        if (evt.getClickCount() == 2) {
            searchNationalityTxt.setText("");
        }
    }//GEN-LAST:event_searchNationalityTxtMouseClicked

    private void fNameInfoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fNameInfoTxtActionPerformed

    }//GEN-LAST:event_fNameInfoTxtActionPerformed

    private void nationalityComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nationalityComboItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_nationalityComboItemStateChanged

    private void femaleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioActionPerformed
        femaleRadio.setText("Female");
        femaleRadio.setActionCommand("Female");
        if (femaleRadio.isSelected()) {
            genderInfo.setVisible(false);
        }
    }//GEN-LAST:event_femaleRadioActionPerformed

    private void marriedRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marriedRadioActionPerformed
        marriedRadio.setText("Married");
        marriedRadio.setActionCommand("married");
        if (marriedRadio.isSelected()) {
            mariageInfoTxt.setVisible(false);
        }
    }//GEN-LAST:event_marriedRadioActionPerformed

    private void singleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleRadioActionPerformed
        singleRadio.setText("Single");
        singleRadio.setActionCommand("single");
        if (singleRadio.isSelected()) {
            mariageInfoTxt.setVisible(false);
        }
    }//GEN-LAST:event_singleRadioActionPerformed

    private void maleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadioActionPerformed
        maleRadio.setText("Male");
        maleRadio.setActionCommand("male");
        if (maleRadio.isSelected()) {
            genderInfo.setVisible(false);
        }
    }//GEN-LAST:event_maleRadioActionPerformed

    private void dobTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dobTxtKeyReleased
        dobInfoTxt.setVisible(false);
    }//GEN-LAST:event_dobTxtKeyReleased

    private void dobTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dobTxtKeyPressed
        dobInfoTxt.setVisible(false);
    }//GEN-LAST:event_dobTxtKeyPressed

    private void dobTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dobTxtMouseEntered

    }//GEN-LAST:event_dobTxtMouseEntered

    private void dobTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dobTxtMouseClicked

    }//GEN-LAST:event_dobTxtMouseClicked

    private void fatherNameTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fatherNameTxtKeyReleased
        fatherNameTxt.setForeground(Color.BLUE.darker().darker());
        fatherNameInfoTxt.setVisible(false);
    }//GEN-LAST:event_fatherNameTxtKeyReleased

    private void fatherNameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fatherNameTxtKeyPressed
        fatherNameTxt.setForeground(Color.BLUE.darker().darker());
        fatherNameInfoTxt.setVisible(false);
    }//GEN-LAST:event_fatherNameTxtKeyPressed

    private void fatherNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fatherNameTxtActionPerformed
        fatherNameTxt.setForeground(Color.BLUE.darker().darker());
        fatherNameInfoTxt.setVisible(false);
    }//GEN-LAST:event_fatherNameTxtActionPerformed

    private void fatherNameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fatherNameTxtMouseClicked
        fatherNameTxt.setForeground(Color.BLUE.darker().darker());
        if (evt.getClickCount() == 2) {
            fatherNameTxt.setText("");
        }
        fatherNameInfoTxt.setVisible(false);
    }//GEN-LAST:event_fatherNameTxtMouseClicked

    private void firstNameTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstNameTxtKeyReleased
        fNameInfoTxt.setVisible(false);
        fatherNameTxt.setForeground(Color.BLUE.darker().darker());
    }//GEN-LAST:event_firstNameTxtKeyReleased

    private void firstNameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstNameTxtKeyPressed
        fNameInfoTxt.setVisible(false);
        firstNameTxt.setForeground(Color.BLUE.darker().darker());
    }//GEN-LAST:event_firstNameTxtKeyPressed

    private void firstNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTxtActionPerformed
        firstNameTxt.setForeground(Color.BLUE.darker().darker());
        fNameInfoTxt.setVisible(false);
    }//GEN-LAST:event_firstNameTxtActionPerformed

    private void firstNameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstNameTxtMouseClicked
        fNameInfoTxt.setVisible(false);
        firstNameTxt.setForeground(Color.BLUE.darker().darker());
        if (evt.getClickCount() == 2) {
            firstNameTxt.setText("");
        }
    }//GEN-LAST:event_firstNameTxtMouseClicked

    private void imageTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imageTxtActionPerformed

    private void identitiTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identitiTxtActionPerformed
        identitiTxt.setForeground(Color.BLUE.darker().darker());
        identityInfoTxt.setVisible(false);
    }//GEN-LAST:event_identitiTxtActionPerformed

    private void identitiTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_identitiTxtMouseClicked
        identitiTxt.setForeground(Color.BLUE.darker().darker());
        if (evt.getClickCount() == 2) {
            identitiTxt.setText("");
        }
        identityInfoTxt.setVisible(false);
    }//GEN-LAST:event_identitiTxtMouseClicked

    private void lastNameTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastNameTxtKeyReleased
        lastNameTxt.setForeground(Color.BLUE.darker().darker());
        lNameInfoTxt.setVisible(false);
    }//GEN-LAST:event_lastNameTxtKeyReleased

    private void lastNameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastNameTxtKeyPressed
        lastNameTxt.setForeground(Color.BLUE.darker().darker());
        lNameInfoTxt.setVisible(false);
    }//GEN-LAST:event_lastNameTxtKeyPressed

    private void lastNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTxtActionPerformed
        lastNameTxt.setForeground(Color.BLUE.darker().darker());
        lNameInfoTxt.setVisible(false);
    }//GEN-LAST:event_lastNameTxtActionPerformed

    private void lastNameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastNameTxtMouseClicked
        lastNameTxt.setForeground(Color.BLUE.darker().darker());
        if (evt.getClickCount() == 2) {
            lastNameTxt.setText("");
        }
        lNameInfoTxt.setVisible(false);
    }//GEN-LAST:event_lastNameTxtMouseClicked

    private void searchCountryTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchCountryTxtKeyReleased
        countryCombo.setVisible(true);
        String country = searchCountryTxt.getText();
        if (country != null) {
            showCountryForSearch(country);
        }
    }//GEN-LAST:event_searchCountryTxtKeyReleased

    private void searchCountryTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCountryTxtActionPerformed
        String country = searchCountryTxt.getText();
        countryCombo.setVisible(true);
        if (country != null) {
            showCountryForSearch(country);
        }
    }//GEN-LAST:event_searchCountryTxtActionPerformed

    private void searchCountryTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchCountryTxtMouseClicked
        String country = searchCountryTxt.getText();
        countryCombo.setVisible(true);
        if (country != null) {
            showCountryForSearch(country);
        }
        if (evt.getClickCount() == 2) {
            searchCountryTxt.setText("");
        }
    }//GEN-LAST:event_searchCountryTxtMouseClicked

    private void emailInfoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailInfoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailInfoTxtActionPerformed

    private void phone2TxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phone2TxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phone2TxtActionPerformed

    private void homePhoneTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homePhoneTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homePhoneTxtActionPerformed

    private void homeNumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeNumberTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeNumberTxtActionPerformed

    private void streetTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streetTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streetTxtActionPerformed

    private void emailTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTxtKeyReleased
        emailTxt.setForeground(Color.BLUE.darker().darker());
        emailInfoTxt.setVisible(false);
    }//GEN-LAST:event_emailTxtKeyReleased

    private void emailTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTxtKeyPressed
        emailTxt.setForeground(Color.BLUE.darker().darker());
        emailInfoTxt.setVisible(false);
    }//GEN-LAST:event_emailTxtKeyPressed

    private void emailTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTxtActionPerformed
        emailTxt.setForeground(Color.BLUE.darker().darker());
        emailInfoTxt.setVisible(false);
    }//GEN-LAST:event_emailTxtActionPerformed

    private void emailTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailTxtMouseClicked
        emailTxt.setForeground(Color.BLUE.darker().darker());
        if (evt.getClickCount() == 2) {
            emailTxt.setText("");
        }
        emailInfoTxt.setVisible(false);
    }//GEN-LAST:event_emailTxtMouseClicked

    private void cityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityTxtActionPerformed

    private void positionInfoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionInfoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positionInfoTxtActionPerformed

    private void positionCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionCmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positionCmbActionPerformed

    private void positionCmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_positionCmbItemStateChanged
        positionInfoTxt.setVisible(false);
    }//GEN-LAST:event_positionCmbItemStateChanged

    private void salaryTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryTxtActionPerformed
        salaryTxt.setForeground(Color.BLUE.darker().darker());
        salaryInfoTxt.setVisible(false);
    }//GEN-LAST:event_salaryTxtActionPerformed

    private void salaryTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salaryTxtMouseClicked
        salaryTxt.setForeground(Color.BLUE.darker().darker());
        if (evt.getClickCount() == 2) {
            salaryTxt.setText("");
        }
        salaryInfoTxt.setVisible(false);
    }//GEN-LAST:event_salaryTxtMouseClicked

    private void cardNumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardNumberTxtActionPerformed
        cardNumberTxt.setForeground(Color.BLUE.darker().darker());
        cardNumberInfoTx.setVisible(false);
    }//GEN-LAST:event_cardNumberTxtActionPerformed

    private void cardNumberTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cardNumberTxtMouseClicked
        cardNumberTxt.setForeground(Color.BLUE.darker().darker());
        if (evt.getClickCount() == 2) {
            cardNumberTxt.setText("");
        }
        cardNumberInfoTx.setVisible(false);
    }//GEN-LAST:event_cardNumberTxtMouseClicked

    private void branchCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchCmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_branchCmbActionPerformed

    private void branchCmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_branchCmbItemStateChanged
        Item selected = (Item) branchCmb.getSelectedItem();
        Long id = selected.getId();
        if (branchCmb.getSelectedIndex() != 0) {
            if (evt.getStateChange() == 1) {
                showPositionBySelectedBranch(id);
            }
        }
        branchInfoTxt.setVisible(false);
    }//GEN-LAST:event_branchCmbItemStateChanged

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        but = true;
                try {
            Employee e = new Employee();
            e.setUniversity(universityTxt.getText());
            EducationType et = new EducationType();
            Item educationDegreeItem = (Item) educationCmb1.getSelectedItem();
            Long edduDegree1 = educationDegreeItem.getId();
            if (educationDegreeItem.getValue() != "Select Degree") {
                et.setId(edduDegree1);
                e.setEducationType(et);
                Date graduateD = uni1GraduteCalendar.getDate();
                if (graduateD != null) {
                    e.setGraduateDate(graduateD);
                    Long a = employeeService.getCurrentId();
                    boolean aa = employeeService.addEmployee(a, e);
                    saveBtn.setEnabled(false);
                    clearBtn.setEnabled(false);
                    if (aa == true) {
                        JOptionPane.showMessageDialog(null, "Success");
                    }
                } else {
                    graudateDateWarning.setVerifyInputWhenFocusTarget(true);
                    graudateDateWarning.setText("Add Date");
                }
                hideInfoFields();
            } else {
                eduDegreeWarning.setVisible(true);
                eduDegreeWarning.setText("Add Education Degree");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_addActionPerformed

    private void uni1GraduteCalendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uni1GraduteCalendarMouseClicked
        graudateDateWarning.setVisible(false);
    }//GEN-LAST:event_uni1GraduteCalendarMouseClicked

    private void universityTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_universityTxtKeyPressed
        uniWarning.setVisible(false);
    }//GEN-LAST:event_universityTxtKeyPressed

    private void diplomaNumberTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_diplomaNumberTxtKeyPressed
        addDiplomaWarning.setVisible(false);

    }//GEN-LAST:event_diplomaNumberTxtKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        universityTxt.setText("");
        uni1GraduteCalendar.setDate(null);
        diplomaNumberTxt.setText("");
        educationCmb1.setSelectedIndex(0);
        saveBtnActionPerformed(evt);
        saveBtn.setEnabled(false);
                

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PositionTxt1;
    private javax.swing.JButton add;
    private javax.swing.JTextField addDiplomaWarning;
    private javax.swing.JPanel addressPanel;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel beginToWorkLbl1;
    private com.toedter.calendar.JDateChooser beginToWorkTxtCalendar;
    private javax.swing.JTextField beginWorkInfoTxt;
    private javax.swing.JComboBox<String> branchCmb;
    private javax.swing.JTextField branchInfoTxt;
    private javax.swing.JLabel branchTxt1;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField cardNumberInfoTx;
    private javax.swing.JTextField cardNumberTxt;
    private javax.swing.JTextField certificateTxt;
    private javax.swing.JTextField cityTxt;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JComboBox<String> countryCombo;
    private javax.swing.JTextField diplomaNumberTxt;
    private javax.swing.JTextField dobInfoTxt;
    private com.toedter.calendar.JDateChooser dobTxt;
    private javax.swing.JTextField eduDegreeWarning;
    private javax.swing.JPanel eduPanel1;
    private javax.swing.JComboBox<String> educationCmb1;
    private javax.swing.JTextField emailInfoTxt;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField fNameInfoTxt;
    private javax.swing.JTextField fatherNameInfoTxt;
    private javax.swing.JTextField fatherNameTxt;
    private javax.swing.JRadioButton femaleRadio;
    private javax.swing.JTextField firstNameTxt;
    private javax.swing.JTextField genderInfo;
    private javax.swing.JLabel graduateTxt2;
    private javax.swing.JTextField graudateDateWarning;
    private javax.swing.JTextField homeNumberTxt;
    private javax.swing.JTextField homePhoneTxt;
    private javax.swing.JTextField houseNumberTxt;
    private javax.swing.JTextField identitiTxt;
    private javax.swing.JTextField identityInfoTxt;
    private javax.swing.JTextField imageTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lNameInfoTxt;
    private javax.swing.JLabel lableName;
    private javax.swing.JTextField lastNameTxt;
    private javax.swing.JRadioButton maleRadio;
    private javax.swing.JTextField mariageInfoTxt;
    private javax.swing.JRadioButton marriedRadio;
    private javax.swing.JButton minimazeBtn;
    private javax.swing.JComboBox<String> nationalityCombo;
    private javax.swing.JLabel noteTax1;
    private javax.swing.JTextArea noteTxt;
    private javax.swing.JTabbedPane per;
    private javax.swing.JPanel personalPanel;
    private javax.swing.JTextField phone1Txt;
    private javax.swing.JTextField phone2Txt;
    private javax.swing.JComboBox<String> positionCmb;
    private javax.swing.JTextField positionInfoTxt;
    private javax.swing.JButton restoreBtn;
    private javax.swing.JTextField salaryInfoTxt;
    private javax.swing.JTextField salaryTxt;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField searchCountryTxt;
    private javax.swing.JTextField searchNationalityTxt;
    private javax.swing.JRadioButton singleRadio;
    private javax.swing.JTextField streetTxt;
    private com.toedter.calendar.JDateChooser uni1GraduteCalendar;
    private javax.swing.JTextField uniWarning;
    private javax.swing.JTextField universityTxt;
    private javax.swing.JLabel universityTxt4;
    private javax.swing.JPanel workPanel;
    // End of variables declaration//GEN-END:variables

    private void showBranchCombo() {
        try {
            List<Branch> branchList = branchService.getBranchList();
            DefaultComboBoxModel model = (DefaultComboBoxModel) branchCmb.getModel();
            for (Branch branch : branchList) {
                model.addElement(new Item(branch.getId(), branch.getBranchName()));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showPositionBySelectedBranch(Long id) {
        try {
            List<Position> positionList = positionService.getPositionListByBranchId(id);
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            model.addElement(new Item((long) 0, "Select Position"));
            for (Position position : positionList) {
                model.addElement(new Item(position.getId(), position.getPositionName()));
            }
            positionCmb.setModel(model);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void showEducationDegreeCombo1() {
        try {
            List<EducationType> educationTypeList = educationTypeService.getEeducationTypeList();
            DefaultComboBoxModel model = (DefaultComboBoxModel) educationCmb1.getModel();
            for (EducationType educationType : educationTypeList) {
                model.addElement(new Item(educationType.getId(), educationType.getDegreeName()));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

//    private void showEducationDegreeCombo2() {
//        try {
//            List<EducationType> educationTypeList = educationTypeService.getEeducationTypeList();
//            DefaultComboBoxModel model = (DefaultComboBoxModel) educationCmb2.getModel();
//            for (EducationType educationType : educationTypeList) {
//                model.addElement(new Item(educationType.getId(), educationType.getDegreeName()));
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//    }
//    private void showEducationDegreeCombo3() {
//        try {
//            List<EducationType> educationTypeList = educationTypeService.getEeducationTypeList();
//            DefaultComboBoxModel model = (DefaultComboBoxModel) educationCmb3.getModel();
//            for (EducationType educationType : educationTypeList) {
//                model.addElement(new Item(educationType.getId(), educationType.getDegreeName()));
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//    }
    void hideInfoFields() {
        fNameInfoTxt.setVisible(false);
        lNameInfoTxt.setVisible(false);
        fatherNameInfoTxt.setVisible(false);
        genderInfo.setVisible(false);
        mariageInfoTxt.setVisible(false);
        beginWorkInfoTxt.setVisible(false);
        identityInfoTxt.setVisible(false);
        dobInfoTxt.setVisible(false);
        branchInfoTxt.setVisible(false);
        positionInfoTxt.setVisible(false);
        salaryInfoTxt.setVisible(false);
        cardNumberInfoTx.setVisible(false);
        emailInfoTxt.setVisible(false);
        eduDegreeWarning.setVisible(false);
        addDiplomaWarning.setVisible(false);
        uniWarning.setVisible(false);
        graudateDateWarning.setVisible(false);

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
                c.setBackground(Color.WHITE.darker());
                c = super.getListCellRendererComponent(list, value, index, isSelected,
                        cellHasFocus);
            }
            return c;
        }
    }

    void showCountryForSearch(String keyword) {
        List<String> filterCountry = new ArrayList<>();
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
        for (String count : countries) {
            if (count.toLowerCase().contains(keyword.toLowerCase())) {
                filterCountry.add(count);
            }
            if (filterCountry.size() > 0) {
                model.removeAllElements();
                for (String fil : filterCountry) {
                    model.addElement(fil);
                }

            } else if (filterCountry.size() == 0) {
                for (String country : countries) {
                    model.addElement("Result Not Found");
                    model.addElement(country);
                }

            }
            JTextField textfield = (JTextField) nationalityCombo.getEditor().getEditorComponent();
            textfield.setText(keyword);
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
        JTextField textfield = (JTextField) nationalityCombo.getEditor().getEditorComponent();
        textfield.setText(keyword);
    }

    boolean checkCardNumber(String cardNumber) {
        boolean result = true;
        try {
            List<Employee> employees = employeeService.getEmployeeList(1);
            for (Employee employee : employees) {
                if (employee.getCardNumber().equals(cardNumber)) {
                    result = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

    boolean checkIdentity(String identity) {
        boolean result = true;
        try {
            List<Employee> employees = employeeService.getEmployeeList(1);
            for (Employee employee : employees) {
                if (employee.getIndentifyNumber().equals(identity)) {
                    result = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }
}
