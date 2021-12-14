package project.library.desktop.DesktopGui.hr;

import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import project.library.desktop.Desktop_Gui.Item;
import project.library.desktop.Desktop_Gui.LoginFrame;
import project.library.desktop.model.*;
import project.library.desktop.model.employee.Branch;
import project.library.desktop.model.employee.Department;
import project.library.desktop.model.employee.EducationType;
import project.library.desktop.service.*;

/**
 *
 * @ Ulviyye Ibrahimli
 */
public class HrFrame1 extends javax.swing.JFrame {

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
    private  StatusService statusService;
    ButtonGroup buttonGroup = new ButtonGroup();

    public HrFrame1() {
        initComponents();
    }

    public HrFrame1(DepartmentService departmentService,
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
        try {
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.darker().darker());
            userTxt.setText("Welcome, " + login.getFirstName() + " " + login.getLastName() + " !");
            getContentPane().setBackground(Color.BLUE.darker());
            showBanchCombo();
            branchTxt.setText(String.valueOf(Math.round(employeeService.count(3, null))));
            employeeCountForDepTxt.setText(String.valueOf(Math.round(employeeService.count(4, null))));
            dep_count();
            showSalaryCombo();
            ageDepCombo.setVisible(false);
            showSpecificAgeCombo();
            showAgeCombo();
            showDep();
            showEduDegree();
            Float result1 = employeeService.count(4, null);
            employeeCountTxt.setText(String.valueOf(Math.round(result1)));
            departmentComboForBranchCount.setRenderer(new HrFrame1.TwoDecimalRenderer(departmentComboForBranchCount.getRenderer()));
            positionForDepCombo.setRenderer(new HrFrame1.TwoDecimalRenderer(positionForDepCombo.getRenderer()));
            positionForBranchCombo.setRenderer(new HrFrame1.TwoDecimalRenderer(positionForBranchCombo.getRenderer()));
            employeeCountCombo.setRenderer(new HrFrame1.TwoDecimalRenderer(employeeCountCombo.getRenderer()));
            departmentCombo.setRenderer(new HrFrame1.TwoDecimalRenderer(departmentCombo.getRenderer()));
            eduDegreeCombo.setRenderer(new HrFrame1.TwoDecimalRenderer(eduDegreeCombo.getRenderer()));
            ageSpecificCombo.setRenderer(new HrFrame1.TwoDecimalRenderer(ageSpecificCombo.getRenderer()));
            salaryCombo.setRenderer(new HrFrame1.TwoDecimalRenderer(salaryCombo.getRenderer()));
            ageTxt.setText(String.valueOf(Math.round(employeeService.count(10, null))));
            positionTxt.setText(String.valueOf(Math.round(employeeService.count(15, null))));
            positionForDepCombo.setVisible(false);
            positionForBranchCombo.setVisible(false);
            showPositionDep();
            positionForBranchCombo.setVisible(false);
            allPositionRadio.setSelected(true);
            this.setDefaultLookAndFeelDecorated(true);
            this.pack();
            this.setLocationRelativeTo(null);
            showEmployeeCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        restoreBtn = new javax.swing.JButton();
        minimizeBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        departmentBtn = new javax.swing.JButton();
        departmentLbl = new javax.swing.JLabel();
        dep_count = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        departmentComboForBranchCount = new javax.swing.JComboBox<>();
        branchTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        employeeCountCombo = new javax.swing.JComboBox<>();
        employeeCountForDepTxt = new javax.swing.JTextField();
        departmentCombo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        salaryCombo = new javax.swing.JComboBox<>();
        salaryTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ageTxt = new javax.swing.JTextField();
        ageDepCombo = new javax.swing.JComboBox<>();
        ageSpecificCombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        eduDegreeCombo = new javax.swing.JComboBox<>();
        eduTxt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        positionTxt = new javax.swing.JTextField();
        positionForDepCombo = new javax.swing.JComboBox<>();
        positionForBranchCombo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        allPositionRadio = new javax.swing.JRadioButton();
        posForDepRadio = new javax.swing.JRadioButton();
        employeeBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        employeeCountTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        backBtn1 = new javax.swing.JButton();
        userTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 153));
        setUndecorated(true);
        setResizable(false);

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
        minimizeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeBtnActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 51));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Human Resources");

        jButton1.setBackground(new java.awt.Color(153, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/close.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));

        departmentBtn.setBackground(new java.awt.Color(0, 0, 204));
        departmentBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        departmentBtn.setForeground(new java.awt.Color(255, 255, 255));
        departmentBtn.setText("Department");
        departmentBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        departmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentBtnActionPerformed(evt);
            }
        });

        departmentLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        departmentLbl.setForeground(new java.awt.Color(255, 255, 255));
        departmentLbl.setText("Total Number of Departments");

        dep_count.setEditable(false);
        dep_count.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dep_countActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Branch Count");

        departmentComboForBranchCount.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        departmentComboForBranchCount.setForeground(new java.awt.Color(0, 0, 153));
        departmentComboForBranchCount.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                departmentComboForBranchCountItemStateChanged(evt);
            }
        });
        departmentComboForBranchCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboForBranchCountActionPerformed(evt);
            }
        });

        branchTxt.setEditable(false);
        branchTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        branchTxt.setForeground(new java.awt.Color(0, 0, 204));
        branchTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchTxtActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Employee Count");

        employeeCountCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        employeeCountCombo.setForeground(new java.awt.Color(0, 0, 153));
        employeeCountCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Employee Count" }));
        employeeCountCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                employeeCountComboItemStateChanged(evt);
            }
        });
        employeeCountCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeCountComboActionPerformed(evt);
            }
        });

        employeeCountForDepTxt.setEditable(false);
        employeeCountForDepTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        employeeCountForDepTxt.setForeground(new java.awt.Color(0, 0, 204));
        employeeCountForDepTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeCountForDepTxtActionPerformed(evt);
            }
        });

        departmentCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        departmentCombo.setForeground(new java.awt.Color(0, 0, 153));
        departmentCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                departmentComboItemStateChanged(evt);
            }
        });
        departmentCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Avg Salary");

        salaryCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        salaryCombo.setForeground(new java.awt.Color(0, 0, 153));
        salaryCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                salaryComboItemStateChanged(evt);
            }
        });
        salaryCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryComboActionPerformed(evt);
            }
        });

        salaryTxt.setEditable(false);
        salaryTxt.setBackground(new java.awt.Color(255, 255, 255));
        salaryTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        salaryTxt.setForeground(new java.awt.Color(0, 0, 153));
        salaryTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryTxtActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Age");

        ageTxt.setEditable(false);
        ageTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        ageTxt.setForeground(new java.awt.Color(0, 0, 153));
        ageTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageTxtActionPerformed(evt);
            }
        });

        ageDepCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        ageDepCombo.setForeground(new java.awt.Color(0, 0, 153));
        ageDepCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ageDepComboItemStateChanged(evt);
            }
        });
        ageDepCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageDepComboActionPerformed(evt);
            }
        });

        ageSpecificCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        ageSpecificCombo.setForeground(new java.awt.Color(0, 0, 153));
        ageSpecificCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ageSpecificComboItemStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Employee Count for Edu. Degree");

        eduDegreeCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        eduDegreeCombo.setForeground(new java.awt.Color(0, 0, 153));
        eduDegreeCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eduDegreeCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                eduDegreeComboItemStateChanged(evt);
            }
        });

        eduTxt.setEditable(false);
        eduTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        eduTxt.setForeground(new java.awt.Color(0, 0, 204));
        eduTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eduTxtActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 204));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Branch");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 204));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Position");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        positionTxt.setEditable(false);
        positionTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        positionTxt.setForeground(new java.awt.Color(0, 0, 204));
        positionTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionTxtActionPerformed(evt);
            }
        });

        positionForDepCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        positionForDepCombo.setForeground(new java.awt.Color(0, 0, 153));
        positionForDepCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                positionForDepComboItemStateChanged(evt);
            }
        });
        positionForDepCombo.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                positionForDepComboInputMethodTextChanged(evt);
            }
        });
        positionForDepCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionForDepComboActionPerformed(evt);
            }
        });

        positionForBranchCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        positionForBranchCombo.setForeground(new java.awt.Color(0, 0, 153));
        positionForBranchCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                positionForBranchComboItemStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText(" Position Count");

        allPositionRadio.setBackground(new java.awt.Color(0, 0, 204));
        allPositionRadio.setForeground(new java.awt.Color(255, 255, 255));
        allPositionRadio.setText("All");
        allPositionRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allPositionRadioActionPerformed(evt);
            }
        });

        posForDepRadio.setBackground(new java.awt.Color(0, 0, 204));
        posForDepRadio.setForeground(new java.awt.Color(255, 255, 255));
        posForDepRadio.setText("Special");
        posForDepRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posForDepRadioActionPerformed(evt);
            }
        });

        employeeBtn.setBackground(new java.awt.Color(0, 0, 204));
        employeeBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        employeeBtn.setForeground(new java.awt.Color(255, 255, 255));
        employeeBtn.setText("Employee");
        employeeBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        employeeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeBtnActionPerformed(evt);
            }
        });

        employeeCountTxt.setEditable(false);
        employeeCountTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        employeeCountTxt.setForeground(new java.awt.Color(0, 0, 204));
        employeeCountTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeCountTxtActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Employye Count");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(posForDepRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(positionForDepCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(positionForBranchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(31, 31, 31)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(positionTxt)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
                        .addComponent(employeeCountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(departmentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(employeeCountForDepTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(departmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(employeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(departmentLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(allPositionRadio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(departmentComboForBranchCount, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(branchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dep_count, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(150, 150, 150))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(employeeCountCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(270, 270, 270)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(eduDegreeCombo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addComponent(eduTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ageSpecificCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ageDepCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(133, 133, 133))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(135, 135, 135))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(salaryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(salaryTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(departmentLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dep_count, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eduDegreeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eduTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentComboForBranchCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(branchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(allPositionRadio)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(posForDepRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(positionForDepCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(positionForBranchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ageSpecificCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ageDepCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(positionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeCountCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeCountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeCountForDepTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaryTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        backBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-undo-24.png"))); // NOI18N
        backBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void restoreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreBtnActionPerformed
        if (getExtendedState() == NORMAL) {
            setExtendedState(MAXIMIZED_BOTH);
        } else {
            setExtendedState(NORMAL);
            this.pack();
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_restoreBtnActionPerformed

    private void minimizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeBtnActionPerformed
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_minimizeBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int closeChoose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE CLOSE THE PROGRAM ?");
        if (closeChoose == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void employeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeBtnActionPerformed
        this.dispose();
        EmployeeFrame employeeFrame = new EmployeeFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        employeeFrame.setVisible(true);
    }//GEN-LAST:event_employeeBtnActionPerformed

    private void posForDepRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posForDepRadioActionPerformed
        buttonGroup.add(posForDepRadio);
        positionForDepCombo.setVisible(true);
        allPositionRadio.setSelected(false);
        positionTxt.setText("0");
    }//GEN-LAST:event_posForDepRadioActionPerformed

    private void allPositionRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allPositionRadioActionPerformed
        try {
            buttonGroup.add(allPositionRadio);
            if (allPositionRadio.isSelected()) {
                positionTxt.setText(String.valueOf(Math.round(employeeService.count(15, null))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_allPositionRadioActionPerformed

    private void positionForBranchComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_positionForBranchComboItemStateChanged
        try {
            if (!positionForBranchCombo.getSelectedItem().equals("Select Branch")) {
                Item item = (Item) positionForBranchCombo.getSelectedItem();
                Float result = employeeService.count(16, String.valueOf(item.getId()));
                System.out.println("ffvgfgf   "+result);
                if (result != null) {
                    positionTxt.setText(String.valueOf(Math.round(result)));
                } else {
                    positionTxt.setText("0");
                }
            } else {
                if (positionForDepCombo.getSelectedIndex() != 0) {
                    Item item = (Item) positionForDepCombo.getSelectedItem();
                    Float result = employeeService.count(17, String.valueOf(item.getId()));
                    positionTxt.setText(String.valueOf(Math.round(result)));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_positionForBranchComboItemStateChanged

    private void positionForDepComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_positionForDepComboItemStateChanged
        try {
            if (!positionForDepCombo.getSelectedItem().equals("Select Department")) {
                Item item = (Item) positionForDepCombo.getSelectedItem();
                positionForBranchCombo.setVisible(true);
                showBranchForDep(item.getId());
                Float result = employeeService.count(17, String.valueOf(item.getId()));
                Branch branchList = branchService.getBranchById(item.getId());
                if (result != null) {
                    positionTxt.setText(String.valueOf(Math.round(result)));
                } else {
                    positionTxt.setText("0");
                }
            } else {
                positionTxt.setText(String.valueOf(Math.round(employeeService.count(15, null))));
                positionForBranchCombo.setSelectedItem("Select Branch");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_positionForDepComboItemStateChanged

    private void positionTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionTxtActionPerformed

    }//GEN-LAST:event_positionTxtActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        PositionFrame positionFrame = new PositionFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        positionFrame.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        BranchFrame branchFrame = new BranchFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        branchFrame.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void eduDegreeComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_eduDegreeComboItemStateChanged
//        Item item = (Item) eduDegreeCombo.getSelectedItem();
//        try {
//            Float result = employeeService.count(13, String.valueOf(item.getId()));
//            if (result != null) {
//                eduTxt.setText(String.valueOf(Math.round(result)));
//            } else {
//                eduTxt.setText("0");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_eduDegreeComboItemStateChanged

    private void ageSpecificComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ageSpecificComboItemStateChanged
        int index = ageSpecificCombo.getSelectedIndex();
        try {
            if (index == 0) {
                ageTxt.setText(String.valueOf(Math.round(employeeService.count(10, null))));
                ageDepCombo.setVisible(false);

            } else if (index == 1) {
                if (employeeService.count(12, "male") != null) {
                    ageTxt.setText(String.valueOf(Math.round(employeeService.count(12, "male"))));
                } else {
                    ageTxt.setText("0");
                }

            } else if (index == 2) {
                if (employeeService.count(12, "female") != null) {
                    ageTxt.setText(String.valueOf(Math.round(employeeService.count(12, "female"))));
                } else {
                    ageTxt.setText("0");
                }
            } else if (index == 3) {
                ageTxt.setText("");
                ageDepCombo.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ageSpecificComboItemStateChanged

    private void ageDepComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageDepComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageDepComboActionPerformed

    private void ageDepComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ageDepComboItemStateChanged
        Item item = (Item) ageDepCombo.getSelectedItem();
        try {
            Float result = employeeService.count(11, item.getValue());
            if (result != null) {
                ageTxt.setText(String.valueOf(Math.round(result)));
            } else {
                ageTxt.setText("0");
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_ageDepComboItemStateChanged

    private void ageTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageTxtActionPerformed

    private void salaryTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryTxtActionPerformed

    }//GEN-LAST:event_salaryTxtActionPerformed

    private void salaryComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_salaryComboItemStateChanged
        Item item = (Item) salaryCombo.getSelectedItem();
        int index = salaryCombo.getSelectedIndex();
        String selectedItem = item.getValue();
        try {
            if (index == 0) {
                salaryTxt.setText(String.valueOf(employeeService.count(8, null)));
            } else if (index > 0) {
                Float result = employeeService.count(9, selectedItem);
                if (result != null) {
                    salaryTxt.setText(String.valueOf(result));
                } else {
                    salaryTxt.setText("0");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_salaryComboItemStateChanged

    private void departmentComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departmentComboActionPerformed

    private void departmentComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_departmentComboItemStateChanged
        if (departmentCombo.getSelectedIndex() != 0) {
            Item selectedDep = (Item) departmentCombo.getSelectedItem();
            Long selectedId = selectedDep.getId();
            if (evt.getStateChange() == 1) {
                try {
                    Integer empCount = departmentService.employeeCount(selectedId).getEmployeeCount();
                    if (empCount != null) {
                        employeeCountForDepTxt.setText(String.valueOf(empCount));
                    } else {
                        employeeCountForDepTxt.setText("0");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            employeeCountForDepTxt.setText("0");
        }
    }//GEN-LAST:event_departmentComboItemStateChanged

    private void employeeCountForDepTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeCountForDepTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeCountForDepTxtActionPerformed

    private void employeeCountComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeCountComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeCountComboActionPerformed

    private void employeeCountComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_employeeCountComboItemStateChanged
        int selectedIndex = employeeCountCombo.getSelectedIndex();
        try {
            if (selectedIndex == 0) {
                Float result1 = employeeService.count(4, null);
                if (result1 != null) {
                    employeeCountTxt.setText(String.valueOf(Math.round(result1)));
                } else {
                    employeeCountTxt.setText("0");
                }
            } else if (selectedIndex == 1) {
                Float result2 = employeeService.count(5, "male");
                if (result2 != null) {
                    employeeCountTxt.setText(String.valueOf(Math.round(result2)));
                } else {
                    employeeCountTxt.setText("0");
                }
            } else if (selectedIndex == 2) {
                Float result3 = employeeService.count(5, "female");
                if (result3 != null) {
                    employeeCountTxt.setText(String.valueOf(Math.round(result3)));
                } else {
                    employeeCountTxt.setText("0");
                }
            } else if (selectedIndex == 3) {
                Float result4 = employeeService.count(6, "married");
                if (result4 != null) {
                    employeeCountTxt.setText(String.valueOf(Math.round(result4)));
                } else {
                    employeeCountTxt.setText("0");
                }
            } else if (selectedIndex == 4) {
                Float result5 = employeeService.count(6, "single");
                if (result5 != null) {
                    employeeCountTxt.setText(String.valueOf(Math.round(result5)));
                } else {
                    employeeCountTxt.setText("0");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_employeeCountComboItemStateChanged

    private void branchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchTxtActionPerformed
        try {
            branchTxt.setText(String.valueOf(employeeService.count(1, (String) showBanchCombo())));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_branchTxtActionPerformed

    private void departmentComboForBranchCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentComboForBranchCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departmentComboForBranchCountActionPerformed

    private void departmentComboForBranchCountItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_departmentComboForBranchCountItemStateChanged
        try {
            Item item = (Item) departmentComboForBranchCount.getSelectedItem();
            Long selectedId = item.getId();
            String dd = item.getValue();
            if (evt.getStateChange() == 1) {
                if (departmentComboForBranchCount.getSelectedIndex() > 0) {
                    Float result = employeeService.count(2, dd);
                    if (result != null) {
                        branchTxt.setText(String.valueOf(Math.round(result)));
                    } else {
                        branchTxt.setText("0");
                    }
                }
            } else if (departmentComboForBranchCount.getSelectedIndex() == 0) {
                Float result1 = employeeService.count(3, null);
                if (result1 != null) {
                    branchTxt.setText(String.valueOf(Math.round(result1)));
                } else {
                    branchTxt.setText("0");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_departmentComboForBranchCountItemStateChanged

    private void dep_countActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dep_countActionPerformed

    }//GEN-LAST:event_dep_countActionPerformed

    private void departmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentBtnActionPerformed
        this.dispose();
        DepartmentFrame departmentFrame = new DepartmentFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        departmentFrame.setVisible(true);
    }//GEN-LAST:event_departmentBtnActionPerformed

    private void positionForDepComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionForDepComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positionForDepComboActionPerformed

    private void eduTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eduTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eduTxtActionPerformed

    private void salaryComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaryComboActionPerformed

    private void backBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn1ActionPerformed
        this.dispose();
        LoginFrame loginFrame = new LoginFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService,statusService);
        loginFrame.setVisible(true);
    }//GEN-LAST:event_backBtn1ActionPerformed

    private void positionForDepComboInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_positionForDepComboInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_positionForDepComboInputMethodTextChanged

    private void employeeCountTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeCountTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeCountTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ageDepCombo;
    private javax.swing.JComboBox<String> ageSpecificCombo;
    private javax.swing.JTextField ageTxt;
    private javax.swing.JRadioButton allPositionRadio;
    private javax.swing.JButton backBtn1;
    private javax.swing.JTextField branchTxt;
    private javax.swing.JTextField dep_count;
    private javax.swing.JButton departmentBtn;
    private javax.swing.JComboBox<String> departmentCombo;
    private javax.swing.JComboBox<String> departmentComboForBranchCount;
    private javax.swing.JLabel departmentLbl;
    private javax.swing.JComboBox<String> eduDegreeCombo;
    private javax.swing.JTextField eduTxt;
    private javax.swing.JButton employeeBtn;
    private javax.swing.JComboBox<String> employeeCountCombo;
    private javax.swing.JTextField employeeCountForDepTxt;
    private javax.swing.JTextField employeeCountTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton minimizeBtn;
    private javax.swing.JRadioButton posForDepRadio;
    private javax.swing.JComboBox<String> positionForBranchCombo;
    private javax.swing.JComboBox<String> positionForDepCombo;
    private javax.swing.JTextField positionTxt;
    private javax.swing.JButton restoreBtn;
    private javax.swing.JComboBox<String> salaryCombo;
    private javax.swing.JTextField salaryTxt;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables

    private Object showBanchCombo() {
        Object o = null;
        try {
            List<Department> departmentList = departmentService.getDepartmentList();
            DefaultComboBoxModel model = (DefaultComboBoxModel) departmentComboForBranchCount.getModel();
            model.addElement(new Item((long) 0, "Branch Count of All Dep."));
            for (Department department : departmentList) {
                model.addElement(new Item(department.getId(), department.getDepartmentName()));

            }
            o = model.getSelectedItem();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return o;
    }

    private void dep_count() {
        try {
            dep_count.setText(String.valueOf(Math.round(employeeService.count(1, null))));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showEmployeeCount() {
        String[] menu = {"Male Employee Count", "Female Employee Count", "Marriaged Employee Count", "Single Employee Count"};
        DefaultComboBoxModel model = (DefaultComboBoxModel) employeeCountCombo.getModel();
        for (int i = 0; i < menu.length; i++) {
            model.addElement(menu[i]);
        }
    }

    private void showDep() {
        try {
            List<Department> departmentList = departmentService.getDepartmentList();
            DefaultComboBoxModel model = (DefaultComboBoxModel) departmentCombo.getModel();
            model.removeAllElements();
            model.addElement("Select Department");
            for (Department department : departmentList) {
                model.addElement(new Item(department.getId(), department.getDepartmentName()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showSalaryCombo() {
        try {
            List<Department> departmentList = departmentService.getDepartmentList();
            DefaultComboBoxModel model = (DefaultComboBoxModel) salaryCombo.getModel();
            model.addElement(new Item((long) 0, " All Employee avg Salary"));
            for (Department department : departmentList) {
                model.addElement(new Item(department.getId(), department.getDepartmentName()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showAgeCombo() {
        try {
            List<Department> departmentList = departmentService.getDepartmentList();
            DefaultComboBoxModel model = (DefaultComboBoxModel) ageDepCombo.getModel();
            for (Department department : departmentList) {
                model.addElement(new Item(department.getId(), department.getDepartmentName()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showSpecificAgeCombo() {
        try {

            DefaultComboBoxModel model = (DefaultComboBoxModel) ageSpecificCombo.getModel();
            model.addElement(new Item((long) 0, " All  Employee avg ege"));
            model.addElement(new Item((long) 1, " All Male Employee avg ege"));
            model.addElement(new Item((long) 2, "All Female Employee avg age"));
            model.addElement(new Item((long) 3, "Avg Age For Department"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showEduDegree() {
        try {
            List<EducationType> educationTypeList = educationTypeService.getEeducationTypeList();
            DefaultComboBoxModel model = (DefaultComboBoxModel) eduDegreeCombo.getModel();
            for (EducationType educationType : educationTypeList) {
                model.addElement(new Item(educationType.getId(), educationType.getDegreeName()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showPositionDep() {
        try {
            List<Department> departmentList = departmentService.getDepartmentList();
            DefaultComboBoxModel model = (DefaultComboBoxModel) positionForDepCombo.getModel();
            model.addElement("Select Department");
            for (Department department : departmentList) {
                model.addElement(new Item(department.getId(), department.getDepartmentName()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showBranchForDep(Long id) {
        try {
            List<Branch> branchList = branchService.getBranchListForDepartment(id);
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            model.addElement("Select Branch");
            for (Branch branch : branchList) {
                model.addElement(new Item(branch.getId(), branch.getBranchName()));
            }

            positionForBranchCombo.setModel(model);

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
}
