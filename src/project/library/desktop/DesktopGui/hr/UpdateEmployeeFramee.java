package project.library.desktop.DesktopGui.hr;

import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class UpdateEmployeeFramee extends javax.swing.JFrame {

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
    private Long selectedId;
    private Login login;
    ButtonGroup genderGroup = new ButtonGroup();
    ButtonGroup marritialGroup = new ButtonGroup();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String searchNationality = "";
    String searchCountry = "";
    Employee employee = null;

    public UpdateEmployeeFramee() {
        initComponents();
    }

    UpdateEmployeeFramee(DepartmentService departmentService,
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
            Long selectedId,
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
        this.selectedId = selectedId;
        this.login = login;
        initComponents();
        wLbl.setVisible(false);
        addEduPanel.setVisible(false);
        userTxt.setText("Welcome, " + login.getFirstName() + " " + login.getLastName() + " !");
        try {
            nationalityCombo.setRenderer(new UpdateEmployeeFramee.TwoDecimalRenderer(nationalityCombo.getRenderer()));
            branchCmb.setRenderer(new UpdateEmployeeFramee.TwoDecimalRenderer(branchCmb.getRenderer()));
            countryCombo.setRenderer(new UpdateEmployeeFramee.TwoDecimalRenderer(countryCombo.getRenderer()));
            educationCmb1.setRenderer(new UpdateEmployeeFramee.TwoDecimalRenderer(educationCmb1.getRenderer()));
            educationCmb2.setRenderer(new UpdateEmployeeFramee.TwoDecimalRenderer(educationCmb2.getRenderer()));
            educationCmb3.setRenderer(new UpdateEmployeeFramee.TwoDecimalRenderer(educationCmb3.getRenderer()));
            employee = employeeService.getEmployeeById(selectedId);
            nationalityOld(employee);
            List<EducationType> types = employeeService.eduDegreForEdit(selectedId);
            if (types.size() == 3) {
                showEducationDegreeCombo1(types.get(0));
                showEducationDegreeCombo2(types.get(1));
                showEducationDegreeCombo3(types.get(2));
                addEduPanel.setVisible(true);
            } else if (types.size() == 2) {
                showEducationDegreeCombo1(types.get(0));
                showEducationDegreeCombo2(types.get(1));
                showEducationDegreeCombo3All();
            } else if (types.size() == 1) {
                showEducationDegreeCombo1(types.get(0));
                showEducationDegreeCombo2All();
                showEducationDegreeCombo3All();
            } else if (types.size() == 0) {
                showEducationDegreeCombo1All();
                showEducationDegreeCombo2All();
                showEducationDegreeCombo3All();
            }
            showCountryComboOld(employee);
            showOldDateEmployee(employee);
            showBranchComboOldInfo(employee);
            Item idd = (Item) branchCmb.getSelectedItem();
            showPositionBySelectedBranch(idd.getId(), employee);
            getContentPane().setBackground(Color.BLUE.darker());
            addEduPanel.setVisible(false);
            this.setDefaultLookAndFeelDecorated(true);
            this.pack();
            this.setLocationRelativeTo(null);
            hideInfoFields();
            genderGroup.add(maleRadio);
            genderGroup.add(femaleRadio);
            marritialGroup.add(singleRadio);
            marritialGroup.add(marriedRadio);
            try {
//            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                UIManager.put("OptionPane.background", Color.BLUE.darker().darker());
                UIManager.put("Panel.background", Color.BLUE.darker().darker().darker());
                UIManager.put("OptionPane.messageForeground", Color.BLUE.darker().darker());
            } catch (Exception e) {
                e.printStackTrace();
            }
            jLabel31.setText("UPDATE-->  " + employee.getFirstName().toUpperCase() + " " + employee.getLastName().toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        searchNationalityTxt = new javax.swing.JTextField();
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
        jPanel7 = new javax.swing.JPanel();
        eduPanel1 = new javax.swing.JPanel();
        cCompletionTxt1 = new javax.swing.JLabel();
        universityTxt2 = new javax.swing.JLabel();
        university1Txt = new javax.swing.JTextField();
        graduateTxt2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        diploma1NumberTxt = new javax.swing.JTextField();
        schollComDateCalendar = new com.toedter.calendar.JDateChooser();
        collegeCompDateCalendar = new com.toedter.calendar.JDateChooser();
        uni1GraduteCalendar = new com.toedter.calendar.JDateChooser();
        schoolTxt = new javax.swing.JTextField();
        schoolTxt1 = new javax.swing.JLabel();
        sComletiondateTxt1 = new javax.swing.JLabel();
        educationCmb1 = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        schoolTxt2 = new javax.swing.JLabel();
        collegeDiplomaNumberTxt = new javax.swing.JTextField();
        universityTxt4 = new javax.swing.JLabel();
        collegeTxt = new javax.swing.JTextField();
        eduDegreeInfoTxt = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        wLbl = new javax.swing.JLabel();
        eduPanel2 = new javax.swing.JPanel();
        graduateTxt3 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        certificationTxt = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        educationCmb2 = new javax.swing.JComboBox<>();
        universityTxt5 = new javax.swing.JLabel();
        university2Txt = new javax.swing.JTextField();
        uni2GraduteCalendar = new com.toedter.calendar.JDateChooser();
        diploma2NumberTxt = new javax.swing.JTextField();
        addEduPanel = new javax.swing.JPanel();
        universityTxt3 = new javax.swing.JLabel();
        graduateTxt4 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        university3Txt = new javax.swing.JTextField();
        uni3GraduteCalendar = new com.toedter.calendar.JDateChooser();
        diploma3NumberTxt = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        educationCmb3 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
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
        userTxt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        jLabel31.setText("UPDATE EMPLOYEE");

        per.setBackground(new java.awt.Color(102, 0, 102));
        per.setForeground(new java.awt.Color(0, 0, 153));

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
        identitiTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                identitiTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                identitiTxtKeyReleased(evt);
            }
        });

        imageTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        imageTxt.setForeground(new java.awt.Color(0, 0, 153));

        jLabel2.setBackground(new java.awt.Color(0, 0, 153));
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

        maleRadio.setBackground(new java.awt.Color(0, 0, 255));
        maleRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        maleRadio.setForeground(new java.awt.Color(51, 204, 255));
        maleRadio.setText("Male");
        maleRadio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        maleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioActionPerformed(evt);
            }
        });

        singleRadio.setBackground(new java.awt.Color(0, 0, 255));
        singleRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        singleRadio.setForeground(new java.awt.Color(51, 204, 255));
        singleRadio.setText("Single");
        singleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleRadioActionPerformed(evt);
            }
        });

        marriedRadio.setBackground(new java.awt.Color(0, 0, 255));
        marriedRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        marriedRadio.setForeground(new java.awt.Color(51, 204, 255));
        marriedRadio.setText("Married");
        marriedRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marriedRadioActionPerformed(evt);
            }
        });

        femaleRadio.setBackground(new java.awt.Color(0, 0, 255));
        femaleRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        femaleRadio.setForeground(new java.awt.Color(51, 204, 255));
        femaleRadio.setText("Female");
        femaleRadio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        femaleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioActionPerformed(evt);
            }
        });

        nationalityCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nationalityCombo.setForeground(new java.awt.Color(0, 0, 153));
        nationalityCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        fNameInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        fNameInfoTxt.setForeground(new java.awt.Color(102, 0, 0));
        fNameInfoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fNameInfoTxtActionPerformed(evt);
            }
        });

        lNameInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

        genderInfo.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        genderInfo.setForeground(new java.awt.Color(153, 0, 0));

        mariageInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        mariageInfoTxt.setForeground(new java.awt.Color(153, 0, 0));

        fatherNameInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        fatherNameInfoTxt.setForeground(new java.awt.Color(153, 0, 0));

        dobInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        dobInfoTxt.setForeground(new java.awt.Color(153, 0, 0));

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

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8.setText("*");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setText("*");

        searchNationalityTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        searchNationalityTxt.setForeground(new java.awt.Color(153, 0, 0));
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

        javax.swing.GroupLayout personalPanelLayout = new javax.swing.GroupLayout(personalPanel);
        personalPanel.setLayout(personalPanelLayout);
        personalPanelLayout.setHorizontalGroup(
            personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(personalPanelLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(mariageInfoTxt))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, personalPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(genderInfo))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, personalPanelLayout.createSequentialGroup()
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(personalPanelLayout.createSequentialGroup()
                                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(personalPanelLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lableName, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personalPanelLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(35, 35, 35)))
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fNameInfoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(lNameInfoTxt)
                            .addComponent(fatherNameInfoTxt)
                            .addComponent(identityInfoTxt)
                            .addComponent(dobInfoTxt))))
                .addGap(23, 23, 23)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(identitiTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(firstNameTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                    .addComponent(lastNameTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fatherNameTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(personalPanelLayout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(personalPanelLayout.createSequentialGroup()
                                .addComponent(singleRadio, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                .addGap(71, 71, 71)
                                .addComponent(marriedRadio, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                            .addGroup(personalPanelLayout.createSequentialGroup()
                                .addComponent(femaleRadio, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                .addGap(71, 71, 71)
                                .addComponent(maleRadio, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personalPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dobTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nationalityCombo, 0, 250, Short.MAX_VALUE)
                                .addComponent(searchNationalityTxt)))))
                .addGap(50, 50, 50))
        );
        personalPanelLayout.setVerticalGroup(
            personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalPanelLayout.createSequentialGroup()
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fNameInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, personalPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lableName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNameInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fatherNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fatherNameInfoTxt)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(genderInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(femaleRadio))
                    .addComponent(maleRadio))
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(personalPanelLayout.createSequentialGroup()
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(personalPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(singleRadio)
                                        .addComponent(marriedRadio))))
                            .addGroup(personalPanelLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(mariageInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dobInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dobTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(personalPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(personalPanelLayout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(personalPanelLayout.createSequentialGroup()
                                .addGroup(personalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(identityInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(identitiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addComponent(imageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(searchNationalityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, 0)
                .addComponent(nationalityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        per.addTab("Personal Information", personalPanel);

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
        cardNumberTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cardNumberTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cardNumberTxtKeyReleased(evt);
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
        salaryTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                salaryTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                salaryTxtKeyReleased(evt);
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

        positionInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        positionInfoTxt.setForeground(new java.awt.Color(153, 0, 0));
        positionInfoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionInfoTxtActionPerformed(evt);
            }
        });

        branchInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        branchInfoTxt.setForeground(new java.awt.Color(153, 0, 0));

        salaryInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        salaryInfoTxt.setForeground(new java.awt.Color(153, 0, 0));

        cardNumberInfoTx.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        cardNumberInfoTx.setForeground(new java.awt.Color(153, 0, 0));

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
                    .addGroup(workPanelLayout.createSequentialGroup()
                        .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(branchTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PositionTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(workPanelLayout.createSequentialGroup()
                        .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(workPanelLayout.createSequentialGroup()
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(workPanelLayout.createSequentialGroup()
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addGroup(workPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(noteTax1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(workPanelLayout.createSequentialGroup()
                                        .addComponent(beginToWorkLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel28)))))
                        .addGap(10, 10, 10)
                        .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(beginWorkInfoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(branchInfoTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(positionInfoTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cardNumberInfoTx)
                            .addComponent(salaryInfoTxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(salaryTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                            .addComponent(cardNumberTxt)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, workPanelLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(positionCmb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(branchCmb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(beginToWorkTxtCalendar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(50, 50, 50))
        );
        workPanelLayout.setVerticalGroup(
            workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workPanelLayout.createSequentialGroup()
                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(workPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(branchTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(branchInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(workPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(PositionTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(workPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(positionInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, workPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(branchCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(positionCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(workPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(salaryInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(workPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(salaryTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cardNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cardNumberInfoTx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(workPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(beginToWorkTxtCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(workPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(beginWorkInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(beginToWorkLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(noteTax1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(123, 123, 123))
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

        eduPanel1.setBackground(new java.awt.Color(0, 0, 153));

        cCompletionTxt1.setBackground(new java.awt.Color(0, 0, 153));
        cCompletionTxt1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cCompletionTxt1.setForeground(new java.awt.Color(255, 255, 255));
        cCompletionTxt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cCompletionTxt1.setText("Collage Completion Date");
        cCompletionTxt1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        universityTxt2.setBackground(new java.awt.Color(0, 0, 153));
        universityTxt2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        universityTxt2.setForeground(new java.awt.Color(255, 255, 255));
        universityTxt2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        universityTxt2.setText("College Diploma Number");
        universityTxt2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        university1Txt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        university1Txt.setForeground(new java.awt.Color(0, 0, 153));
        university1Txt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));
        university1Txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                university1TxtActionPerformed(evt);
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

        diploma1NumberTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        diploma1NumberTxt.setForeground(new java.awt.Color(0, 0, 153));
        diploma1NumberTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));

        schollComDateCalendar.setForeground(new java.awt.Color(0, 0, 153));

        collegeCompDateCalendar.setForeground(new java.awt.Color(0, 0, 153));

        uni1GraduteCalendar.setForeground(new java.awt.Color(0, 0, 153));

        schoolTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        schoolTxt.setForeground(new java.awt.Color(0, 0, 153));
        schoolTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));
        schoolTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schoolTxtActionPerformed(evt);
            }
        });

        schoolTxt1.setBackground(new java.awt.Color(0, 0, 153));
        schoolTxt1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        schoolTxt1.setForeground(new java.awt.Color(255, 255, 255));
        schoolTxt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        schoolTxt1.setText("College");
        schoolTxt1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        sComletiondateTxt1.setBackground(new java.awt.Color(0, 0, 153));
        sComletiondateTxt1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        sComletiondateTxt1.setForeground(new java.awt.Color(255, 255, 255));
        sComletiondateTxt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sComletiondateTxt1.setText("School Completion Date");
        sComletiondateTxt1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        educationCmb1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        educationCmb1.setForeground(new java.awt.Color(0, 0, 153));
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

        schoolTxt2.setBackground(new java.awt.Color(0, 0, 153));
        schoolTxt2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        schoolTxt2.setForeground(new java.awt.Color(255, 255, 255));
        schoolTxt2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        schoolTxt2.setText("School");
        schoolTxt2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        collegeDiplomaNumberTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        collegeDiplomaNumberTxt.setForeground(new java.awt.Color(0, 0, 153));
        collegeDiplomaNumberTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));

        universityTxt4.setBackground(new java.awt.Color(0, 0, 153));
        universityTxt4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        universityTxt4.setForeground(new java.awt.Color(255, 255, 255));
        universityTxt4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        universityTxt4.setText("University");
        universityTxt4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        collegeTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        collegeTxt.setForeground(new java.awt.Color(0, 0, 153));
        collegeTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));
        collegeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collegeTxtActionPerformed(evt);
            }
        });

        eduDegreeInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        eduDegreeInfoTxt.setForeground(new java.awt.Color(153, 0, 0));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(204, 0, 0));
        jLabel33.setText("*");

        wLbl.setForeground(new java.awt.Color(204, 204, 255));
        wLbl.setText("Above the lower level");

        javax.swing.GroupLayout eduPanel1Layout = new javax.swing.GroupLayout(eduPanel1);
        eduPanel1.setLayout(eduPanel1Layout);
        eduPanel1Layout.setHorizontalGroup(
            eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eduPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(schoolTxt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sComletiondateTxt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(schoolTxt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cCompletionTxt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(universityTxt2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addComponent(universityTxt4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(graduateTxt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eduPanel1Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(schoolTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                            .addComponent(collegeTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                            .addComponent(collegeDiplomaNumberTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                            .addComponent(university1Txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)))
                    .addComponent(collegeCompDateCalendar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(schollComDateCalendar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uni1GraduteCalendar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(eduPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165)
                        .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(diploma1NumberTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eduPanel1Layout.createSequentialGroup()
                                .addComponent(eduDegreeInfoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                .addGap(32, 32, 32)
                                .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(educationCmb1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(50, 50, 50))
        );
        eduPanel1Layout.setVerticalGroup(
            eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eduPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(schoolTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(schoolTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eduPanel1Layout.createSequentialGroup()
                        .addComponent(schollComDateCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(collegeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(collegeCompDateCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(eduPanel1Layout.createSequentialGroup()
                        .addComponent(sComletiondateTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(schoolTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(cCompletionTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(universityTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(collegeDiplomaNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(universityTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(university1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eduPanel1Layout.createSequentialGroup()
                        .addComponent(graduateTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(eduPanel1Layout.createSequentialGroup()
                        .addComponent(uni1GraduteCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(diploma1NumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(wLbl)
                        .addGap(1, 1, 1)
                        .addGroup(eduPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(educationCmb1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eduDegreeInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(eduPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(eduPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 507, Short.MAX_VALUE)
        );

        per.addTab("Education Information", jPanel7);

        eduPanel2.setBackground(new java.awt.Color(0, 0, 153));

        graduateTxt3.setBackground(new java.awt.Color(0, 0, 153));
        graduateTxt3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        graduateTxt3.setForeground(new java.awt.Color(255, 255, 255));
        graduateTxt3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        graduateTxt3.setText("Graduate Date");
        graduateTxt3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        jLabel20.setBackground(new java.awt.Color(0, 0, 153));
        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Diploma №");
        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        jLabel16.setBackground(new java.awt.Color(0, 0, 153));
        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Certification");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        certificationTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        certificationTxt.setForeground(new java.awt.Color(0, 0, 153));
        certificationTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));

        jLabel30.setBackground(new java.awt.Color(0, 0, 153));
        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Education Degree");
        jLabel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        educationCmb2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        educationCmb2.setForeground(new java.awt.Color(0, 0, 153));
        educationCmb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Degree" }));
        educationCmb2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        educationCmb2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                educationCmb2ItemStateChanged(evt);
            }
        });

        universityTxt5.setBackground(new java.awt.Color(0, 0, 153));
        universityTxt5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        universityTxt5.setForeground(new java.awt.Color(255, 255, 255));
        universityTxt5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        universityTxt5.setText("University");
        universityTxt5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        university2Txt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        university2Txt.setForeground(new java.awt.Color(0, 0, 153));
        university2Txt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));
        university2Txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                university2TxtActionPerformed(evt);
            }
        });

        uni2GraduteCalendar.setForeground(new java.awt.Color(0, 0, 153));

        diploma2NumberTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        diploma2NumberTxt.setForeground(new java.awt.Color(0, 0, 153));
        diploma2NumberTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));
        diploma2NumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diploma2NumberTxtActionPerformed(evt);
            }
        });

        addEduPanel.setBackground(new java.awt.Color(0, 0, 153));

        universityTxt3.setBackground(new java.awt.Color(0, 0, 153));
        universityTxt3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        universityTxt3.setForeground(new java.awt.Color(255, 255, 255));
        universityTxt3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        universityTxt3.setText("University");
        universityTxt3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        graduateTxt4.setBackground(new java.awt.Color(0, 0, 153));
        graduateTxt4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        graduateTxt4.setForeground(new java.awt.Color(255, 255, 255));
        graduateTxt4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        graduateTxt4.setText("Graduate Date");
        graduateTxt4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        jLabel27.setBackground(new java.awt.Color(0, 0, 153));
        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Diploma №");
        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        university3Txt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        university3Txt.setForeground(new java.awt.Color(0, 0, 153));
        university3Txt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));

        uni3GraduteCalendar.setForeground(new java.awt.Color(0, 0, 153));

        diploma3NumberTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        diploma3NumberTxt.setForeground(new java.awt.Color(0, 0, 153));
        diploma3NumberTxt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));
        diploma3NumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diploma3NumberTxtActionPerformed(evt);
            }
        });

        jLabel32.setBackground(new java.awt.Color(0, 0, 153));
        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Education Degree");
        jLabel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        educationCmb3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        educationCmb3.setForeground(new java.awt.Color(0, 0, 153));
        educationCmb3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Degree" }));
        educationCmb3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout addEduPanelLayout = new javax.swing.GroupLayout(addEduPanel);
        addEduPanel.setLayout(addEduPanelLayout);
        addEduPanelLayout.setHorizontalGroup(
            addEduPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addEduPanelLayout.createSequentialGroup()
                .addGroup(addEduPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addEduPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addEduPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(addEduPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(graduateTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(universityTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(207, 207, 207)
                .addGroup(addEduPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(diploma3NumberTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(university3Txt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addEduPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(addEduPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uni3GraduteCalendar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(educationCmb3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50))
        );
        addEduPanelLayout.setVerticalGroup(
            addEduPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addEduPanelLayout.createSequentialGroup()
                .addGroup(addEduPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addEduPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(university3Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(uni3GraduteCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(diploma3NumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(educationCmb3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addEduPanelLayout.createSequentialGroup()
                        .addComponent(universityTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(graduateTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add Education");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout eduPanel2Layout = new javax.swing.GroupLayout(eduPanel2);
        eduPanel2.setLayout(eduPanel2Layout);
        eduPanel2Layout.setHorizontalGroup(
            eduPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eduPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(eduPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eduPanel2Layout.createSequentialGroup()
                        .addGroup(eduPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(eduPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(graduateTxt3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(universityTxt5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(208, 208, 208)
                        .addGroup(eduPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(university2Txt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(certificationTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(diploma2NumberTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eduPanel2Layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addGroup(eduPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(uni2GraduteCalendar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(educationCmb2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(50, 50, 50))
                    .addGroup(eduPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())))
            .addComponent(addEduPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        eduPanel2Layout.setVerticalGroup(
            eduPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eduPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eduPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(universityTxt5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(university2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(eduPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(graduateTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uni2GraduteCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(eduPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eduPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton1))
                    .addGroup(eduPanel2Layout.createSequentialGroup()
                        .addComponent(diploma2NumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(educationCmb2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(certificationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addEduPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );

        per.addTab("Education Information", eduPanel2);

        addressPanel.setBackground(new java.awt.Color(0, 0, 153));

        jLabel38.setBackground(new java.awt.Color(0, 0, 153));
        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Country");
        jLabel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        jLabel39.setBackground(new java.awt.Color(0, 0, 153));
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

        jLabel40.setBackground(new java.awt.Color(0, 0, 153));
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

        jLabel41.setBackground(new java.awt.Color(0, 0, 153));
        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Street");
        jLabel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        houseNumberTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        houseNumberTxt.setForeground(new java.awt.Color(0, 0, 153));

        jLabel42.setBackground(new java.awt.Color(0, 0, 153));
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

        jLabel43.setBackground(new java.awt.Color(0, 0, 153));
        jLabel43.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("House Number");
        jLabel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        jLabel44.setBackground(new java.awt.Color(0, 0, 153));
        jLabel44.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Phone_1");
        jLabel44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        homePhoneTxt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        homePhoneTxt.setForeground(new java.awt.Color(0, 0, 153));
        homePhoneTxt.setBorder(null);
        homePhoneTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homePhoneTxtActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(0, 0, 153));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Home Phone");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        jLabel3.setBackground(new java.awt.Color(0, 0, 153));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Phone _2");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        phone2Txt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        phone2Txt.setForeground(new java.awt.Color(0, 0, 153));
        phone2Txt.setBorder(null);
        phone2Txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone2TxtActionPerformed(evt);
            }
        });

        countryCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        countryCombo.setForeground(new java.awt.Color(255, 255, 255));

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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchCountryTxtKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout addressPanelLayout = new javax.swing.GroupLayout(addressPanel);
        addressPanel.setLayout(addressPanelLayout);
        addressPanelLayout.setHorizontalGroup(
            addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addressPanelLayout.createSequentialGroup()
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchCountryTxt)
                    .addGroup(addressPanelLayout.createSequentialGroup()
                        .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addressPanelLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(50, 50, 50)
                        .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addressPanelLayout.createSequentialGroup()
                                .addComponent(emailInfoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addGap(51, 51, 51)
                                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cityTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                                    .addComponent(phone2Txt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(phone1Txt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(homeNumberTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(streetTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(emailTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(houseNumberTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(homePhoneTxt)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addressPanelLayout.createSequentialGroup()
                                .addGap(326, 326, 326)
                                .addComponent(countryCombo, 0, 270, Short.MAX_VALUE)))))
                .addGap(50, 50, 50))
        );
        addressPanelLayout.setVerticalGroup(
            addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addressPanelLayout.createSequentialGroup()
                .addComponent(searchCountryTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addressPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(countryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streetTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addressPanelLayout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addressPanelLayout.createSequentialGroup()
                        .addGroup(addressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(houseNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(homeNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(phone1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(phone2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(homePhoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        per.addTab("Address Information", addressPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(minimazeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(per)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(restoreBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(minimazeBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(backBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(per, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        saveBtn.setBackground(new java.awt.Color(0, 0, 204));
        saveBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(51, 204, 255));
        saveBtn.setText("Save");
        saveBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 0, 0));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(603, 603, 603)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(jButton4)
                    .addComponent(jButton2))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 49, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addEduPanel.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if (evt.getClickCount() == 2) {
            addEduPanel.setVisible(false);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void diploma3NumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diploma3NumberTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diploma3NumberTxtActionPerformed

    private void diploma2NumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diploma2NumberTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diploma2NumberTxtActionPerformed

    private void university2TxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_university2TxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_university2TxtActionPerformed

    private void collegeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collegeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeTxtActionPerformed

    private void educationCmb1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_educationCmb1ItemStateChanged
        wLbl.setVisible(true);
    }//GEN-LAST:event_educationCmb1ItemStateChanged

    private void schoolTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schoolTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_schoolTxtActionPerformed

    private void university1TxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_university1TxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_university1TxtActionPerformed

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
        if (!branchCmb.getSelectedItem().equals("Select Branch")) {
            if (evt.getStateChange() == 1) {
                showPositionBySelectedBranchCh(id);
            }
        }
        branchInfoTxt.setVisible(false);
    }//GEN-LAST:event_branchCmbItemStateChanged

    private void searchNationalityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchNationalityTxtActionPerformed
        nationalityCombo.setVisible(true);
        if (searchNationalityTxt.getText() != null) {
            String keyword = searchNationalityTxt.getText();
            showNationality(keyword);
        }
    }//GEN-LAST:event_searchNationalityTxtActionPerformed

    private void fNameInfoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fNameInfoTxtActionPerformed

    }//GEN-LAST:event_fNameInfoTxtActionPerformed

    private void femaleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioActionPerformed
        femaleRadio.setText("Female");
        femaleRadio.setActionCommand("Female");
        if (femaleRadio.isSelected()) {
            genderInfo.setVisible(false);
        }
    }//GEN-LAST:event_femaleRadioActionPerformed

    private void marriedRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marriedRadioActionPerformed
        marriedRadio.setText("Male");
        marriedRadio.setActionCommand("Married");
        if (marriedRadio.isSelected()) {
            mariageInfoTxt.setVisible(false);
        }
    }//GEN-LAST:event_marriedRadioActionPerformed

    private void singleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleRadioActionPerformed
        singleRadio.setText("single");
        singleRadio.setActionCommand("single");
        if (singleRadio.isSelected()) {
            mariageInfoTxt.setVisible(false);
        }
    }//GEN-LAST:event_singleRadioActionPerformed

    private void maleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadioActionPerformed
        maleRadio.setText("male");
        maleRadio.setActionCommand("male");
        if (maleRadio.isSelected()) {
            genderInfo.setVisible(false);
        }
    }//GEN-LAST:event_maleRadioActionPerformed

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

    private void firstNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTxtActionPerformed
        firstNameTxt.setForeground(Color.BLUE.darker().darker());
        fNameInfoTxt.setVisible(false);
    }//GEN-LAST:event_firstNameTxtActionPerformed

    private void firstNameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstNameTxtMouseClicked
        firstNameTxt.setForeground(Color.BLUE.darker().darker());
        if (evt.getClickCount() == 2) {
            firstNameTxt.setText("");
        }
        fNameInfoTxt.setVisible(false);
    }//GEN-LAST:event_firstNameTxtMouseClicked

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

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE, TO CLOSE THE PROGRAM ?");
        if (choose == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_closeBtnActionPerformed

    private void minimazeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimazeBtnActionPerformed
        this.setState(ICONIFIED);
    }//GEN-LAST:event_minimazeBtnActionPerformed

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

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        EmployeeFrame employeeFrame = new EmployeeFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        employeeFrame.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (personalPanel.isShowing()) {
            genderGroup.clearSelection();
            marritialGroup.clearSelection();
            firstNameTxt.setText("");
            lastNameTxt.setText("");
            fatherNameTxt.setText("");
            dobTxt.setDate(null);
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
            schoolTxt.setText("");
            schollComDateCalendar.setDate(null);
            collegeCompDateCalendar.setDate(null);
            collegeCompDateCalendar.setDate(null);
            collegeDiplomaNumberTxt.setText("");
            collegeTxt.setText("");
            uni1GraduteCalendar.setDate(null);
            university1Txt.setText("");
            diploma1NumberTxt.setText("");
            educationCmb1.setSelectedIndex(0);

        } else if (eduPanel2.isShowing()) {
            uni2GraduteCalendar.setDate(null);
            university2Txt.setText("");
            diploma3NumberTxt.setText("");
            educationCmb2.setSelectedIndex(0);
            certificationTxt.setText("");
            university3Txt.setText("");
            uni3GraduteCalendar.setDate(null);
            diploma3NumberTxt.setText("");
            educationCmb3.setSelectedIndex(0);
        }
        hideInfoFields();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        String nationality = null;
        String country = null;
        Item educationDegreeItem = null;
        try {
            Date graduate1Uni = df.parse("01/01/000/");
            Date graduation2Uni = df.parse("01/01/000/");
            Date graduation3Uni = df.parse("01/01/000/");
            Date schoolComletionDate = df.parse("01/01/000/");
            Date collegeCompletionDate = df.parse("01/01/000/");
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
                                                    boolean checkIdentity = checkIdentity(identity);
                                                    if (checkIdentity) {
                                                        if (!(nationalityCombo.getSelectedItem().equals("Select Nationality"))) {
                                                            nationality = (String) nationalityCombo.getSelectedItem();
                                                        }
                                                        if (branchCmb.getSelectedIndex() != 0) {
                                                            Item branchItem = (Item) branchCmb.getSelectedItem();
                                                            if (positionCmb.getSelectedIndex() != 0) {
                                                                String salary = salaryTxt.getText();
                                                                if (salary.matches("[0-9]+(\\.[0-9]+)?")) {
                                                                    String cardnumber = cardNumberTxt.getText();
                                                                    if (!(cardnumber.isEmpty()) && cardnumber.length() <= 20) {
                                                                        boolean checkCardNumber = checkCardNumber(cardnumber);
                                                                        if (checkCardNumber) {
                                                                            Item positionItem = (Item) positionCmb.getSelectedItem();
                                                                            Date beginToWorkDate = beginToWorkTxtCalendar.getDate();
                                                                            if (beginToWorkDate != null) {
                                                                                String eMail = emailTxt.getText();
                                                                                if ((!eMail.isEmpty()) && eMail.contains("@") && (!eMail.contains(","))) {
                                                                                    List<EducationType> types = employeeService.eduDegreForEdit(selectedId);
                                                                                    if (!educationCmb1.getSelectedItem().equals("Select Degree")) {
                                                                                        educationDegreeItem = (Item) educationCmb1.getSelectedItem();
                                                                                        if (types.size() == 3) {
                                                                                            for (EducationType type : types) {
                                                                                                boolean del = employeeService.deleteEducationDegree(selectedId, type.getId());
                                                                                            }
                                                                                            if ((!educationCmb2.getSelectedItem().equals("Select Degree")) && (!educationCmb3.getSelectedItem().equals("Select Degree"))) {
                                                                                                Long edu1 = educationDegreeItem.getId();
                                                                                                Item e = (Item) educationCmb2.getSelectedItem();
                                                                                                Long edu2 = e.getId();
                                                                                                Item ee = (Item) educationCmb3.getSelectedItem();
                                                                                                Long edu3 = ee.getId();
                                                                                                Long l[] = {edu1, edu2, edu3};
                                                                                                for (Long long1 : l) {
                                                                                                    boolean add3 = employeeService.addEducationDegree(long1, selectedId);
                                                                                                }
                                                                                            } else if ((!educationCmb2.getSelectedItem().equals("Select Degree")) && (educationCmb3.getSelectedItem().equals("Select Degree"))) {
                                                                                                Long edu1 = educationDegreeItem.getId();
                                                                                                Item e = (Item) educationCmb2.getSelectedItem();
                                                                                                Long edu2 = e.getId();
                                                                                                Long l[] = {edu1, edu2};
                                                                                                for (Long long1 : l) {
                                                                                                    boolean add3 = employeeService.addEducationDegree(long1, selectedId);
                                                                                                }
                                                                                            } else if (educationCmb2.getSelectedItem().equals("Select Degree") && (educationCmb3.getSelectedItem().equals("Select Degree"))) {
                                                                                                employeeService.addEducationDegree(educationDegreeItem.getId(), selectedId);
                                                                                            }
                                                                                        } else if (types.size() == 2) {
                                                                                            for (EducationType type : types) {
                                                                                                boolean del = employeeService.deleteEducationDegree(selectedId, type.getId());
                                                                                            }
                                                                                            if ((!educationCmb2.getSelectedItem().equals("Select Degree")) && (!educationCmb3.getSelectedItem().equals("Select Degree"))) {
                                                                                                Long edu1 = educationDegreeItem.getId();
                                                                                                Item e = (Item) educationCmb2.getSelectedItem();
                                                                                                Long edu2 = e.getId();
                                                                                                Item ee = (Item) educationCmb3.getSelectedItem();
                                                                                                Long edu3 = ee.getId();
                                                                                                Long l[] = {edu1, edu2, edu3};
                                                                                                for (Long long1 : l) {
                                                                                                    boolean add3 = employeeService.addEducationDegree(long1, selectedId);
                                                                                                }
                                                                                            } else if ((!educationCmb2.getSelectedItem().equals("Select Degree")) && (educationCmb3.getSelectedItem().equals("Select Degree"))) {
                                                                                                Long edu1 = educationDegreeItem.getId();
                                                                                                Item e = (Item) educationCmb2.getSelectedItem();
                                                                                                Long edu2 = e.getId();
                                                                                                Long l[] = {edu1, edu2};
                                                                                                for (Long long1 : l) {
                                                                                                    boolean add3 = employeeService.addEducationDegree(long1, selectedId);
                                                                                                }
                                                                                            } else if (educationCmb2.getSelectedItem().equals("Select Degree") && (educationCmb3.getSelectedItem().equals("Select Degree"))) {
                                                                                                employeeService.addEducationDegree(educationDegreeItem.getId(), selectedId);
                                                                                            }
                                                                                        } else if (types.size() == 1) {
                                                                                            boolean u = employeeService.updateEduDegree(selectedId, educationDegreeItem.getId());
                                                                                            if ((!educationCmb2.getSelectedItem().equals("Select Degree")) && (!educationCmb3.getSelectedItem().equals("Select Degree"))) {
                                                                                                Long edu1 = educationDegreeItem.getId();
                                                                                                Item e = (Item) educationCmb2.getSelectedItem();
                                                                                                Long edu2 = e.getId();
                                                                                                Long l[] = {edu1, edu2};
                                                                                                for (Long long1 : l) {
                                                                                                    boolean add3 = employeeService.addEducationDegree(long1, selectedId);
                                                                                                }
                                                                                            } else if ((!educationCmb2.getSelectedItem().equals("Select Degree")) && (educationCmb3.getSelectedItem().equals("Select Degree"))) {
                                                                                                Long edu1 = educationDegreeItem.getId();
                                                                                                Item e = (Item) educationCmb2.getSelectedItem();
                                                                                                Long edu2 = e.getId();//                                                                                           
                                                                                                boolean add3 = employeeService.addEducationDegree(edu2, selectedId);
                                                                                            }
                                                                                        }
                                                                                        String note = noteTxt.getText();
                                                                                        if ((!countryCombo.getSelectedItem().equals("Select Country"))) {
                                                                                            country = (String) countryCombo.getSelectedItem();
                                                                                        } else {
                                                                                            country = null;
                                                                                        }
                                                                                        String city = cityTxt.getText();
                                                                                        String collegeName = collegeTxt.getText();
                                                                                        String street = streetTxt.getText();
                                                                                        String houseNumber = houseNumberTxt.getText();
                                                                                        String homeNumber = homeNumberTxt.getText();
                                                                                        String phone1 = phone1Txt.getText();
                                                                                        String phone2 = phone2Txt.getText();
                                                                                        String homePhone = homePhoneTxt.getText();
                                                                                        String uni1 = university1Txt.getText();
                                                                                        String uni2 = university2Txt.getText();
                                                                                        String uni3 = university3Txt.getText();
                                                                                        String school = schoolTxt.getText();
                                                                                        String certification = certificationTxt.getText();
                                                                                        String diploma1Number = diploma1NumberTxt.getText();
                                                                                        String diploma2Number = diploma2NumberTxt.getText();
                                                                                        String diploma3Number = diploma3NumberTxt.getText();
                                                                                        String collegeDiploma = collegeDiplomaNumberTxt.getText();
                                                                                        if (uni1GraduteCalendar.getDate() != null) {
                                                                                            graduate1Uni = uni1GraduteCalendar.getDate();
                                                                                        } else {
                                                                                            graduate1Uni = df.parse("01/01/0001");
                                                                                        }
                                                                                        if (uni2GraduteCalendar.getDate() != null) {
                                                                                            graduation2Uni = uni2GraduteCalendar.getDate();
                                                                                        } else {
                                                                                            graduation2Uni = df.parse("01/01/0001");
                                                                                        }
                                                                                        if (uni3GraduteCalendar.getDate() != null) {
                                                                                            graduation3Uni = uni3GraduteCalendar.getDate();
                                                                                        } else {
                                                                                            graduation3Uni = df.parse("01/01/0001");
                                                                                        }
                                                                                        if (schollComDateCalendar.getDate() != null) {
                                                                                            schoolComletionDate = schollComDateCalendar.getDate();
                                                                                        } else {
                                                                                            schoolComletionDate = df.parse("01/01/0001");
                                                                                        }
                                                                                        if (collegeCompDateCalendar.getDate() != null) {
                                                                                            collegeCompletionDate = collegeCompDateCalendar.getDate();
                                                                                        } else {
                                                                                            collegeCompletionDate = df.parse("01/01/0001");
                                                                                        }
                                                                                        Employee employee = new Employee();
                                                                                        employee.setFirstName(fName);
                                                                                        employee.setLastName(lName);
                                                                                        employee.setFatherName(fatherName);
                                                                                      
                                                                                        employee.setDiplomaNumber(diploma1Number);
                                                                                      
                                                                                        employee.setGraduateDate(graduation3Uni);
                                                                                      
                                                                                        employee.setCertification(certification);
                                                                                        employee.setHouseNumber(houseNumber);
                                                                                        employee.setDob(dob);
                                                                                        employee.setGender(gender);
                                                                                        employee.setMaritalStatus(martialStatus);
                                                                                        employee.setCardNumber(cardnumber);
                                                                                        employee.setBeginToWork(beginToWorkDate);
                                                                                        employee.setGraduateDate(graduation2Uni);
                                                                                   
                                                                                        employee.setUniversity(uni1);
                                                                                       
                                                                                        
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
                                                                                        branch.setId(branchItem.getId());
                                                                                        employee.setBranc(branch);
                                                                                        employee.setNote(note);
                                                                                        employee.setNationality(nationality);
                                                                                        boolean isAddEmployee = employeeService.updateEmployee(selectedId, employee);
                                                                                        if (isAddEmployee) {
                                                                                            JOptionPane.showMessageDialog(null, fName + " " + lName + " - IS UPDATED SUCCESSFULLY ", "SUCCESS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\LibraryDesktopProject\\src\\project\\library\\desktop\\gui\\icon\\tick.png"));
                                                                                            saveBtn.setEnabled(false);
                                                                                            jButton2.setEnabled(false);
                                                                                            hideInfoFields();
                                                                                        } else {
                                                                                            JOptionPane.showMessageDialog(null, fName + " " + lName + "  IS NOT UPDADED", "FAIL", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\LibraryDesktopProject\\src\\project\\library\\desktop\\gui\\icon\\report.png"));
                                                                                        }
                                                                                    } else {
                                                                                        eduDegreeInfoTxt.setVisible(true);
                                                                                        educationCmb1.setForeground(Color.red);
                                                                                        eduDegreeInfoTxt.setText("Select education degree");
                                                                                    }
                                                                                } else {
                                                                                    emailInfoTxt.setVisible(true);
                                                                                    emailTxt.setForeground(Color.red);
                                                                                    emailInfoTxt.setText("Uncorrect Email");
                                                                                }
                                                                            } else {
                                                                                beginWorkInfoTxt.setVisible(true);
                                                                                beginToWorkTxtCalendar.setForeground(Color.red);
                                                                                beginToWorkTxtCalendar.setFocusable(true);
                                                                                beginWorkInfoTxt.setText("Select Date");
//                                                                                                                                          
                                                                            }
                                                                        } else {
                                                                            cardNumberInfoTx.setVisible(true);
                                                                            cardNumberTxt.setForeground(Color.red);
                                                                            cardNumberInfoTx.setText("Repeated Card Number !");
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
                                                        identityInfoTxt.setVisible(true);
                                                        identitiTxt.setForeground(Color.red);
                                                        identityInfoTxt.setText(" Repeated Identity!");
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

    private void searchNationalityTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchNationalityTxtMouseClicked
        nationalityCombo.setVisible(true);
        if (nationalityCombo != null) {
            String keyword = searchNationalityTxt.getText();
            showNationality(keyword);
        }
        if (evt.getClickCount() == 2) {
            searchNationalityTxt.setText("");
        }
    }//GEN-LAST:event_searchNationalityTxtMouseClicked

    private void searchCountryTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCountryTxtActionPerformed
        String searchCountry = searchCountryTxt.getText();
        countryCombo.setVisible(true);
        if (searchCountry != null) {
            showCounntryForSearch(searchCountry);
        }

    }//GEN-LAST:event_searchCountryTxtActionPerformed

    private void searchCountryTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchCountryTxtMouseClicked
        String searchCountry = searchCountryTxt.getText();
        countryCombo.setVisible(true);
        if (searchCountry != null) {
            showCounntryForSearch(searchCountry);
        }
        if (evt.getClickCount() == 2) {
            searchCountryTxt.setText("");

        }
    }//GEN-LAST:event_searchCountryTxtMouseClicked

    private void searchNationalityTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchNationalityTxtKeyPressed
        nationalityCombo.setVisible(true);
        if (nationalityCombo != null) {
            String keyword = searchNationalityTxt.getText();
            showNationality(keyword);
        }

    }//GEN-LAST:event_searchNationalityTxtKeyPressed

    private void searchNationalityTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchNationalityTxtKeyReleased
        nationalityCombo.setVisible(true);
        if (nationalityCombo != null) {
            String keyword = searchNationalityTxt.getText();
            showNationality(keyword);
        }
    }//GEN-LAST:event_searchNationalityTxtKeyReleased

    private void searchCountryTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchCountryTxtKeyPressed
        String searchCountry = searchCountryTxt.getText();
        countryCombo.setVisible(true);

        if (searchCountry != null) {
            showCounntryForSearch(searchCountry);
        }
    }//GEN-LAST:event_searchCountryTxtKeyPressed

    private void emailTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTxtKeyPressed
        emailTxt.setForeground(Color.BLUE.darker().darker());
        emailInfoTxt.setVisible(false);
    }//GEN-LAST:event_emailTxtKeyPressed

    private void emailTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTxtKeyReleased
        emailTxt.setForeground(Color.BLUE.darker().darker());
        emailInfoTxt.setVisible(false);
    }//GEN-LAST:event_emailTxtKeyReleased

    private void firstNameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstNameTxtKeyPressed
        firstNameTxt.setForeground(Color.BLUE.darker().darker());
        fNameInfoTxt.setVisible(false);
    }//GEN-LAST:event_firstNameTxtKeyPressed

    private void firstNameTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstNameTxtKeyReleased
        firstNameTxt.setForeground(Color.BLUE.darker().darker());
        fNameInfoTxt.setVisible(false);
    }//GEN-LAST:event_firstNameTxtKeyReleased

    private void lastNameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastNameTxtKeyPressed
        lastNameTxt.setForeground(Color.BLUE.darker().darker());
        lNameInfoTxt.setVisible(false);
    }//GEN-LAST:event_lastNameTxtKeyPressed

    private void lastNameTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastNameTxtKeyReleased
        lastNameTxt.setForeground(Color.BLUE.darker().darker());
        lNameInfoTxt.setVisible(false);
    }//GEN-LAST:event_lastNameTxtKeyReleased

    private void fatherNameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fatherNameTxtKeyPressed
        fatherNameTxt.setForeground(Color.BLUE.darker().darker());
        fatherNameInfoTxt.setVisible(false);
    }//GEN-LAST:event_fatherNameTxtKeyPressed

    private void fatherNameTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fatherNameTxtKeyReleased
        fatherNameTxt.setForeground(Color.BLUE.darker().darker());
        fatherNameInfoTxt.setVisible(false);
    }//GEN-LAST:event_fatherNameTxtKeyReleased

    private void identitiTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_identitiTxtKeyPressed
        identitiTxt.setForeground(Color.BLUE.darker().darker());
        identityInfoTxt.setVisible(false);
    }//GEN-LAST:event_identitiTxtKeyPressed

    private void identitiTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_identitiTxtKeyReleased
        identitiTxt.setForeground(Color.BLUE.darker().darker());
        identityInfoTxt.setVisible(false);
    }//GEN-LAST:event_identitiTxtKeyReleased

    private void salaryTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salaryTxtKeyPressed
        salaryTxt.setForeground(Color.BLUE.darker().darker());
        salaryInfoTxt.setVisible(false);
    }//GEN-LAST:event_salaryTxtKeyPressed

    private void salaryTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salaryTxtKeyReleased
        salaryTxt.setForeground(Color.BLUE.darker().darker());
        salaryInfoTxt.setVisible(false);
    }//GEN-LAST:event_salaryTxtKeyReleased

    private void cardNumberTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cardNumberTxtKeyPressed
        cardNumberTxt.setForeground(Color.BLUE.darker().darker());
        cardNumberInfoTx.setVisible(false);
    }//GEN-LAST:event_cardNumberTxtKeyPressed

    private void cardNumberTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cardNumberTxtKeyReleased
        cardNumberTxt.setForeground(Color.BLUE.darker().darker());
        cardNumberInfoTx.setVisible(false);
    }//GEN-LAST:event_cardNumberTxtKeyReleased

    private void educationCmb2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_educationCmb2ItemStateChanged
        if ((educationCmb2.getSelectedIndex() > 0)) {
            addEduPanel.setVisible(true);
        } else {
            addEduPanel.setVisible(false);

        }
    }//GEN-LAST:event_educationCmb2ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PositionTxt1;
    private javax.swing.JPanel addEduPanel;
    private javax.swing.JPanel addressPanel;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel beginToWorkLbl1;
    private com.toedter.calendar.JDateChooser beginToWorkTxtCalendar;
    private javax.swing.JTextField beginWorkInfoTxt;
    private javax.swing.JComboBox<String> branchCmb;
    private javax.swing.JTextField branchInfoTxt;
    private javax.swing.JLabel branchTxt1;
    private javax.swing.JLabel cCompletionTxt1;
    private javax.swing.JTextField cardNumberInfoTx;
    private javax.swing.JTextField cardNumberTxt;
    private javax.swing.JTextField certificationTxt;
    private javax.swing.JTextField cityTxt;
    private javax.swing.JButton closeBtn;
    private com.toedter.calendar.JDateChooser collegeCompDateCalendar;
    private javax.swing.JTextField collegeDiplomaNumberTxt;
    private javax.swing.JTextField collegeTxt;
    private javax.swing.JComboBox<String> countryCombo;
    private javax.swing.JTextField diploma1NumberTxt;
    private javax.swing.JTextField diploma2NumberTxt;
    private javax.swing.JTextField diploma3NumberTxt;
    private javax.swing.JTextField dobInfoTxt;
    private com.toedter.calendar.JDateChooser dobTxt;
    private javax.swing.JTextField eduDegreeInfoTxt;
    private javax.swing.JPanel eduPanel1;
    private javax.swing.JPanel eduPanel2;
    private javax.swing.JComboBox<String> educationCmb1;
    private javax.swing.JComboBox<String> educationCmb2;
    private javax.swing.JComboBox<String> educationCmb3;
    private javax.swing.JTextField emailInfoTxt;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField fNameInfoTxt;
    private javax.swing.JTextField fatherNameInfoTxt;
    private javax.swing.JTextField fatherNameTxt;
    private javax.swing.JRadioButton femaleRadio;
    private javax.swing.JTextField firstNameTxt;
    private javax.swing.JTextField genderInfo;
    private javax.swing.JLabel graduateTxt2;
    private javax.swing.JLabel graduateTxt3;
    private javax.swing.JLabel graduateTxt4;
    private javax.swing.JTextField homeNumberTxt;
    private javax.swing.JTextField homePhoneTxt;
    private javax.swing.JTextField houseNumberTxt;
    private javax.swing.JTextField identitiTxt;
    private javax.swing.JTextField identityInfoTxt;
    private javax.swing.JTextField imageTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
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
    private javax.swing.JLabel sComletiondateTxt1;
    private javax.swing.JTextField salaryInfoTxt;
    private javax.swing.JTextField salaryTxt;
    private javax.swing.JButton saveBtn;
    private com.toedter.calendar.JDateChooser schollComDateCalendar;
    private javax.swing.JTextField schoolTxt;
    private javax.swing.JLabel schoolTxt1;
    private javax.swing.JLabel schoolTxt2;
    private javax.swing.JTextField searchCountryTxt;
    private javax.swing.JTextField searchNationalityTxt;
    private javax.swing.JRadioButton singleRadio;
    private javax.swing.JTextField streetTxt;
    private com.toedter.calendar.JDateChooser uni1GraduteCalendar;
    private com.toedter.calendar.JDateChooser uni2GraduteCalendar;
    private com.toedter.calendar.JDateChooser uni3GraduteCalendar;
    private javax.swing.JTextField university1Txt;
    private javax.swing.JTextField university2Txt;
    private javax.swing.JTextField university3Txt;
    private javax.swing.JLabel universityTxt2;
    private javax.swing.JLabel universityTxt3;
    private javax.swing.JLabel universityTxt4;
    private javax.swing.JLabel universityTxt5;
    private javax.swing.JTextField userTxt;
    private javax.swing.JLabel wLbl;
    private javax.swing.JPanel workPanel;
    // End of variables declaration//GEN-END:variables
 private void showOldDateEmployee(Employee employee) {
        firstNameTxt.setText(employee.getFirstName());
        lastNameTxt.setText(employee.getLastName());
        fatherNameTxt.setText(employee.getFatherName());
        if (employee.getGender() != null) {
            if (employee.getGender().equalsIgnoreCase("male")) {
                maleRadio.setSelected(true);
                femaleRadio.setSelected(false);
            } else if (employee.getGender().equals("female")) {
                femaleRadio.setSelected(true);
                maleRadio.setSelected(false);
            }
        }
        if (employee.getMaritalStatus() != null) {
            if (employee.getMaritalStatus().equalsIgnoreCase("single")) {
                singleRadio.setSelected(true);
                marriedRadio.setSelected(false);
            } else if (employee.getMaritalStatus().equalsIgnoreCase("married")) {
                marriedRadio.setSelected(true);
                singleRadio.setSelected(false);
            }
        }
        identitiTxt.setText(employee.getIndentifyNumber());
        dobTxt.setDate(employee.getDob());
        
       
        university1Txt.setText(employee.getUniversity());

        diploma1NumberTxt.setText(employee.getDiplomaNumber());
     
  
        certificationTxt.setText(employee.getCertification());

   
     
//        if (employee.getGraduateDateU1().toString().equals(String.valueOf("0001-01-01"))) {
//            uni1GraduteCalendar.setDate(null);
//        } else {
//            uni1GraduteCalendar.setDate(employee.getGraduateDateU1());
//        }
//        System.out.println(" gffbgb+ "+employee.getGraduateDateU2());
//                
//        if (employee.getGraduateDateU2().toString().equals(String.valueOf("0001-01-01"))) {
//            uni2GraduteCalendar.setDate(null);
//        } else {
//            uni2GraduteCalendar.setDate(employee.getGraduateDateU2());
//
//        }
//        if (employee.getGraduateDateU3().toString().equals(String.valueOf("0001-01-01"))) {
//            uni3GraduteCalendar.setDate(null);
//        } else {
//            uni3GraduteCalendar.setDate(employee.getGraduateDateU3());
//
//        }
        cityTxt.setText(employee.getCity());
        streetTxt.setText(employee.getStreet());
        homeNumberTxt.setText(employee.getHomeNumber());
        houseNumberTxt.setText(employee.getHomeNumber());
        phone1Txt.setText(employee.getPhone1());
        phone2Txt.setText(employee.getPhone2());
        homePhoneTxt.setText(employee.getHomePhone());
        emailTxt.setText(employee.geteMail());
        noteTxt.setText(employee.getNote());
        salaryTxt.setText(String.valueOf(employee.getSalary()));
        cardNumberTxt.setText(employee.getCardNumber());
        beginToWorkTxtCalendar.setDate(employee.getBeginToWork());

    }

    private void showBranchComboOldInfo(Employee employee) {
        try {
            List<Branch> branchList = branchService.getBranchList();
            DefaultComboBoxModel model = (DefaultComboBoxModel) branchCmb.getModel();
            for (Branch branch : branchList) {
                model.addElement(new Item(branch.getId(), branch.getBranchName()));
            }
            model.setSelectedItem(new Item(employee.getBranc().getId(), employee.getBranc().getBranchName()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void showPositionBySelectedBranchCh(Long id) {
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

    private void showPositionBySelectedBranch(Long id, Employee employee) {
        try {

            List<Position> positionList = positionService.getPositionListByBranchId(id);
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            model.addElement(new Item((long) 0, "Select Position"));
            for (Position position : positionList) {
                model.addElement(new Item(position.getId(), position.getPositionName()));
            }
            model.setSelectedItem((new Item(employee.getPosition().getId(), employee.getPosition().getPositionName())));
            positionCmb.setModel(model);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showEducationDegreeCombo1(EducationType educationTypea) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try {
            List<EducationType> educationTypeList = educationTypeService.getEeducationTypeList();
            model.removeAllElements();
            for (EducationType educationType : educationTypeList) {
                model.addElement(new Item(educationType.getId(), educationType.getDegreeName()));
            }

            model.setSelectedItem(new Item(educationTypea.getId(), educationTypea.getDegreeName()));
            educationCmb1.setModel(model);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void showEducationDegreeCombo1All() {
        try {
            List<EducationType> educationTypeList = educationTypeService.getEeducationTypeList();
            DefaultComboBoxModel model = (DefaultComboBoxModel) educationCmb1.getModel();
            model.removeAllElements();
            model.addElement("Select Degree");
            for (EducationType educationType : educationTypeList) {
                model.addElement(new Item(educationType.getId(), educationType.getDegreeName()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void showEducationDegreeCombo2All() {
        try {
            List<EducationType> educationTypeList = educationTypeService.getEeducationTypeList();
            DefaultComboBoxModel model = (DefaultComboBoxModel) educationCmb2.getModel();
            model.removeAllElements();
            model.addElement("Select Degree");
            for (EducationType educationType : educationTypeList) {
                model.addElement(new Item(educationType.getId(), educationType.getDegreeName()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void showEducationDegreeCombo3All() {
        try {
            List<EducationType> educationTypeList = educationTypeService.getEeducationTypeList();
            DefaultComboBoxModel model = (DefaultComboBoxModel) educationCmb3.getModel();
            model.removeAllElements();
            model.addElement("Select Degree");
            for (EducationType educationType : educationTypeList) {
                model.addElement(new Item(educationType.getId(), educationType.getDegreeName()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void showEducationDegreeCombo2(EducationType educationTypea) {
        try {
            List<EducationType> educationTypeList = educationTypeService.getEeducationTypeList();
            DefaultComboBoxModel model = new DefaultComboBoxModel<>();
            model.removeAllElements();
            model.addElement("Select Degree");
            for (EducationType educationType : educationTypeList) {
                model.addElement(new Item(educationType.getId(), educationType.getDegreeName()));
            }
            model.setSelectedItem(new Item(educationTypea.getId(), educationTypea.getDegreeName()));
            educationCmb2.setModel(model);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void showEducationDegreeCombo3(EducationType educationTypea) {
        try {
            List<EducationType> educationTypeList = educationTypeService.getEeducationTypeList();
            DefaultComboBoxModel model = (DefaultComboBoxModel) educationCmb3.getModel();
            model.removeAllElements();
            model.addElement("Select Degree");
            for (EducationType educationType : educationTypeList) {
                model.addElement(new Item(educationType.getId(), educationType.getDegreeName()));
            }
            model.setSelectedItem(new Item(educationTypea.getId(), educationTypea.getDegreeName()));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

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
        eduDegreeInfoTxt.setVisible(false);

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

    void nationalityOld(Employee employee) {
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
        DefaultComboBoxModel model = (DefaultComboBoxModel) nationalityCombo.getModel();
        if (employee.getNationality() != null) {
            model.setSelectedItem(employee.getNationality());
            for (String nat : nationality) {
                model.addElement(nat);
            }
        } else {
            model.addElement("Select Nationality");
            for (String nat : nationality) {
                model.addElement(nat);
            }
        }
    }

    void showCountryComboOld(Employee employee) {
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

        DefaultComboBoxModel model = (DefaultComboBoxModel) countryCombo.getModel();
        if (employee.getCountry() != null) {
            model.setSelectedItem(employee.getCountry());
            for (String count : countries) {
                model.addElement(count);
            }

        } else {
            model.addElement("Select Country");
            for (String count : countries) {
                model.addElement(count);
            }

        }
    }

    void showCounntryForSearch(String keyword) {
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
                DefaultComboBoxModel model = (DefaultComboBoxModel) countryCombo.getModel();
                model.removeAllElements();
                for (String fil : filterCountry) {
                    model.addElement(fil);
                }

            }
            JTextField textfield = (JTextField) nationalityCombo.getEditor().getEditorComponent();
            textfield.setText(keyword);
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
                c.setBackground(Color.WHITE.darker());
                c = super.getListCellRendererComponent(list, value, index, isSelected,
                        cellHasFocus);
            }
            return c;
        }
    }

    boolean checkCardNumber(String cardNumber) {
        boolean result = true;
        try {
            Employee emp = employeeService.getEmployeeById(selectedId);
            if (!emp.getCardNumber().equals(cardNumber)) {
                List<Employee> employees = employeeService.getEmployeeList(1);
                for (Employee employee : employees) {
                    if (employee.getCardNumber().equals(cardNumber)) {
                        result = false;
                    }
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
            Employee emp = employeeService.getEmployeeById(selectedId);
            if (!emp.getIndentifyNumber().equals(identity)) {
                List<Employee> employees = employeeService.getEmployeeList(1);
                for (Employee employee : employees) {
                    if (employee.getIndentifyNumber().equals(identity)) {
                        result = false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
