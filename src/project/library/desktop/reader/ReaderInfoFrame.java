package project.library.desktop.reader;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import project.library.desktop.Desktop_Gui.Item;
import project.library.desktop.model.Login;
import project.library.desktop.model.Reader;
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
public class ReaderInfoFrame extends javax.swing.JFrame {

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
    private ReaderService readService;
    private OrderInLibService orderInLibService;
    private OrderInHomeService orderInHomeService;
    private GiveBackBookService giveBackBookService;
    private LoginService loginService;
    private RoleService roleService;
    private Login login;
    ButtonGroup buttonGroup = new ButtonGroup();
    ButtonGroup buttonGroupGender = new ButtonGroup();
    String keyword = "";
    String getPenalty = "";

    public ReaderInfoFrame() {
        initComponents();
    }

    ReaderInfoFrame(DepartmentService departmentService,
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
            this.readService = readerService;
            this.orderInLibService = orderInLibService;
            this.orderInHomeService = orderInHomeService;
            this.giveBackBookService = giveBackBookService;
            this.loginService = loginService;
            this.roleService = roleService;
            this.login = login;
            initComponents();
            buttonGroupGender.add(allRadio);
            buttonGroupGender.add(maleRadio);
            buttonGroupGender.add(femaleRadio);
            userTxt.setText("Welcome, " + login.getFirstName() + " " + login.getLastName() + " !");
            this.setDefaultLookAndFeelDecorated(true);
            this.pack();
            this.setLocationRelativeTo(null);

            JTableHeader header = table.getTableHeader();
            header.setFont(Font.getFont("Times New Roman"));
            header.setForeground(Color.red);
            header.setBackground(Color.WHITE);
            table.setGridColor(Color.BLUE.darker().brighter());
            table.setRowSelectionAllowed(true);
            table.setSelectionBackground(Color.BLUE.darker().darker());
            table.setSelectionForeground(Color.WHITE);
            table.setShowGrid(true);
            buttonGroup.add(egualRadio);
            buttonGroup.add(smallerThanRadio);
            buttonGroup.add(greaterThanRadio);
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.darker().darker().darker());
            activityCombo.setRenderer(new ReaderInfoFrame.TwoDecimalRenderer(activityCombo.getRenderer()));
            statusCombo.setRenderer(new ReaderInfoFrame.TwoDecimalRenderer(statusCombo.getRenderer()));
            nationalityCombo.setRenderer(new ReaderInfoFrame.TwoDecimalRenderer(nationalityCombo.getRenderer()));
            showStatusCombo();
            nationalityCombo.setVisible(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        restoreBtn2 = new javax.swing.JButton();
        minimizeBtn2 = new javax.swing.JButton();
        backBtn2 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        femaleRadio = new javax.swing.JRadioButton();
        maleRadio = new javax.swing.JRadioButton();
        allRadio = new javax.swing.JRadioButton();
        statusCombo = new javax.swing.JComboBox<>();
        activityCombo = new javax.swing.JComboBox<>();
        tablePanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        penalityTxt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        nationalityCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        countForPenaltyTxt = new javax.swing.JTextField();
        greaterThanRadio = new javax.swing.JRadioButton();
        smallerThanRadio = new javax.swing.JRadioButton();
        egualRadio = new javax.swing.JRadioButton();
        addPenaltyTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        startDateCalendar = new com.toedter.calendar.JDateChooser();
        dateBtn = new javax.swing.JButton();
        searchNationalityTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        time2 = new com.toedter.calendar.JDateChooser();
        jSeparator5 = new javax.swing.JSeparator();
        searchTxt = new javax.swing.JTextField();
        readerCombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        userTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jButton4.setBackground(new java.awt.Color(153, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/close.png"))); // NOI18N
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        restoreBtn2.setBackground(new java.awt.Color(51, 102, 255));
        restoreBtn2.setForeground(new java.awt.Color(255, 255, 255));
        restoreBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-restore-window-32.png"))); // NOI18N
        restoreBtn2.setBorder(null);
        restoreBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        restoreBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreBtn2ActionPerformed(evt);
            }
        });

        minimizeBtn2.setBackground(new java.awt.Color(51, 102, 255));
        minimizeBtn2.setForeground(new java.awt.Color(153, 0, 0));
        minimizeBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-minimize-window-48.png"))); // NOI18N
        minimizeBtn2.setBorder(null);
        minimizeBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeBtn2ActionPerformed(evt);
            }
        });

        backBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-undo-24.png"))); // NOI18N
        backBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn2ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Reader's Info");

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setBackground(new java.awt.Color(0, 0, 51));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reader Count Selected");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        femaleRadio.setBackground(new java.awt.Color(0, 0, 51));
        femaleRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        femaleRadio.setForeground(new java.awt.Color(255, 255, 255));
        femaleRadio.setText("Female");
        femaleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioActionPerformed(evt);
            }
        });

        maleRadio.setBackground(new java.awt.Color(0, 0, 51));
        maleRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        maleRadio.setForeground(new java.awt.Color(255, 255, 255));
        maleRadio.setText("Male");
        maleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioActionPerformed(evt);
            }
        });

        allRadio.setBackground(new java.awt.Color(0, 0, 51));
        allRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        allRadio.setForeground(new java.awt.Color(255, 255, 255));
        allRadio.setText("All");
        allRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allRadioActionPerformed(evt);
            }
        });

        statusCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                statusComboItemStateChanged(evt);
            }
        });

        activityCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Activity", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        activityCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                activityComboItemStateChanged(evt);
            }
        });
        activityCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activityComboActionPerformed(evt);
            }
        });

        tablePanel.setBackground(new java.awt.Color(0, 0, 102));

        jLabel5.setBackground(new java.awt.Color(0, 0, 51));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Penality");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        penalityTxt.setEditable(false);
        penalityTxt.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        penalityTxt.setForeground(new java.awt.Color(0, 0, 51));
        penalityTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Penalty");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        table.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        table.setForeground(new java.awt.Color(0, 0, 153));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tablePanelLayout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(218, 218, 218)
                        .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(penalityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tablePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(penalityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tablePanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1))
        );

        jLabel2.setBackground(new java.awt.Color(0, 0, 51));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reader Count For Nationality");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        nationalityCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        nationalityCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nationalityComboItemStateChanged(evt);
            }
        });
        nationalityCombo.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                nationalityComboAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        nationalityCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nationalityComboActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 51));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Reader Count For Penality");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        countForPenaltyTxt.setEditable(false);
        countForPenaltyTxt.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        countForPenaltyTxt.setForeground(new java.awt.Color(204, 0, 0));
        countForPenaltyTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        countForPenaltyTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        greaterThanRadio.setBackground(new java.awt.Color(0, 0, 51));
        greaterThanRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        greaterThanRadio.setForeground(new java.awt.Color(255, 255, 255));
        greaterThanRadio.setText(">");
        greaterThanRadio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        greaterThanRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greaterThanRadioActionPerformed(evt);
            }
        });

        smallerThanRadio.setBackground(new java.awt.Color(0, 0, 51));
        smallerThanRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        smallerThanRadio.setForeground(new java.awt.Color(255, 255, 255));
        smallerThanRadio.setText("<");
        smallerThanRadio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        smallerThanRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smallerThanRadioActionPerformed(evt);
            }
        });

        egualRadio.setBackground(new java.awt.Color(0, 0, 51));
        egualRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        egualRadio.setForeground(new java.awt.Color(255, 255, 255));
        egualRadio.setText("=");
        egualRadio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        egualRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                egualRadioActionPerformed(evt);
            }
        });

        addPenaltyTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addPenaltyTxtMouseClicked(evt);
            }
        });
        addPenaltyTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPenaltyTxtActionPerformed(evt);
            }
        });
        addPenaltyTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addPenaltyTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                addPenaltyTxtKeyReleased(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 51));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Reader  Start Date");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        startDateCalendar.setBackground(new java.awt.Color(255, 255, 255));
        startDateCalendar.setForeground(new java.awt.Color(0, 0, 102));
        startDateCalendar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        startDateCalendar.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                startDateCalendarAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        startDateCalendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startDateCalendarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startDateCalendarMouseEntered(evt);
            }
        });
        startDateCalendar.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                startDateCalendarInputMethodTextChanged(evt);
            }
        });
        startDateCalendar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                startDateCalendarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                startDateCalendarKeyReleased(evt);
            }
        });

        dateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-search-24 (4).png"))); // NOI18N
        dateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateBtnActionPerformed(evt);
            }
        });

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

        jLabel6.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("to");

        searchTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTxtMouseClicked(evt);
            }
        });
        searchTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTxtActionPerformed(evt);
            }
        });
        searchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTxtKeyReleased(evt);
            }
        });

        readerCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        readerCombo.setForeground(new java.awt.Color(0, 0, 153));
        readerCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                readerComboItemStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Reader's Books");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator1)
                        .addComponent(jSeparator6)
                        .addComponent(jSeparator2)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(femaleRadio)
                                .addComponent(maleRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(allRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nationalityCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(searchNationalityTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(startDateCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(time2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(dateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(greaterThanRadio)
                                    .addGap(45, 45, 45)
                                    .addComponent(smallerThanRadio)
                                    .addGap(30, 30, 30)
                                    .addComponent(egualRadio))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(addPenaltyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addComponent(countForPenaltyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(activityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator5)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(readerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(femaleRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maleRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(allRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(activityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchNationalityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(nationalityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addPenaltyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countForPenaltyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(egualRadio)
                            .addComponent(greaterThanRadio)
                            .addComponent(smallerThanRadio))
                        .addGap(9, 9, 9)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(startDateCalendar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                            .addComponent(time2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(readerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        userTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        userTxt.setForeground(new java.awt.Color(0, 0, 255));
        userTxt.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(minimizeBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(minimizeBtn2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(restoreBtn2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void femaleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioActionPerformed
        allRadio.setSelected(false);
        countForPenaltyTxt.setText("0");
        maleRadio.setSelected(false);
        statusCombo.setSelectedIndex(0);
        activityCombo.setSelectedIndex(0);
        nationalityCombo.setVisible(false);
        searchNationalityTxt.setText("");
        addPenaltyTxt.setText("");
        buttonGroup.clearSelection();
        startDateCalendar.setDate(null);
        time2.setDate(null);
        searchTxt.setText("");
        readerCombo.setVisible(false);
        try {
            femaleRadio.setText("Female");
            femaleRadio.setActionCommand("Female");
            if (femaleRadio.isSelected()) {
                tablePanel.setVisible(true);
                table.setVisible(true);
                showTable("female", 7);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_femaleRadioActionPerformed

    private void maleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadioActionPerformed
        allRadio.setSelected(false);
        femaleRadio.setSelected(false);
        statusCombo.setSelectedIndex(0);
        countForPenaltyTxt.setText("0");
        activityCombo.setSelectedIndex(0);
        nationalityCombo.setVisible(false);
        searchNationalityTxt.setText("");
        addPenaltyTxt.setText("");
        buttonGroup.clearSelection();
        startDateCalendar.setDate(null);
        time2.setDate(null);
        searchTxt.setText("");
        readerCombo.setVisible(false);
        try {
            maleRadio.setText("Male");
            maleRadio.setActionCommand("Male");
            if (maleRadio.isSelected()) {
            }
            tablePanel.setVisible(true);
            table.setVisible(true);
            showTable("male", 7);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_maleRadioActionPerformed

    private void allRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allRadioActionPerformed
        maleRadio.setSelected(false);
        femaleRadio.setSelected(false);
        statusCombo.setSelectedIndex(0);
        activityCombo.setSelectedIndex(0);
        nationalityCombo.setVisible(false);
        searchNationalityTxt.setText("");
        addPenaltyTxt.setText("");
        buttonGroup.clearSelection();
        startDateCalendar.setDate(null);
        time2.setDate(null);
        searchTxt.setText("");
        readerCombo.setVisible(false);
        countForPenaltyTxt.setText("0");
        try {
            allRadio.setText("All");
            allRadio.setActionCommand("All");
            if (allRadio.isSelected()) {
                maleRadio.setSelected(false);
                femaleRadio.setSelected(false);
                tablePanel.setVisible(true);
                table.setVisible(true);
                showTable(null, 8);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_allRadioActionPerformed

    private void statusComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_statusComboItemStateChanged
        buttonGroupGender.clearSelection();
        activityCombo.setSelectedIndex(0);
        nationalityCombo.setVisible(false);
        searchNationalityTxt.setText("");
        addPenaltyTxt.setText("");
        buttonGroup.clearSelection();
        startDateCalendar.setDate(null);
        time2.setDate(null);
        searchTxt.setText("");
        readerCombo.setVisible(false);
        countForPenaltyTxt.setText("0");
        try {
            if (!statusCombo.getSelectedItem().equals("Select Status")) {
                String status = (String) statusCombo.getSelectedItem();
                Integer result = readService.getCount(3, status);
                if (result != null) {
                    tablePanel.setVisible(true);
                    table.setVisible(true);
                    showTable(status, 2);
                } else {
                    tablePanel.setVisible(true);
                    table.setVisible(false);
                }

            } else {
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }


    }//GEN-LAST:event_statusComboItemStateChanged

    private void activityComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_activityComboItemStateChanged
        buttonGroupGender.clearSelection();
        statusCombo.setSelectedIndex(0);
        nationalityCombo.setVisible(false);
        searchNationalityTxt.setText("");
        addPenaltyTxt.setText("");
        buttonGroup.clearSelection();
        startDateCalendar.setDate(null);
        time2.setDate(null);
        searchTxt.setText("");
        readerCombo.setVisible(false);
        countForPenaltyTxt.setText("0");

        String activity = (String) activityCombo.getSelectedItem();
        if (activityCombo.getSelectedIndex() != 0) {
            try {
                Integer result = readService.getCount(4, activity);
                table.setVisible(true);
                if (activityCombo.getSelectedIndex() != 0) {
                    if (result != null) {
                        tablePanel.setVisible(true);
                        table.setVisible(true);
                        showTable(activity, 1);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_activityComboItemStateChanged

    private void nationalityComboAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_nationalityComboAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_nationalityComboAncestorAdded

    private void nationalityComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nationalityComboActionPerformed

    }//GEN-LAST:event_nationalityComboActionPerformed

    private void nationalityComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nationalityComboItemStateChanged
        buttonGroupGender.clearSelection();
        statusCombo.setSelectedIndex(0);
        activityCombo.setSelectedIndex(0);
        addPenaltyTxt.setText("");
        buttonGroup.clearSelection();
        startDateCalendar.setDate(null);
        time2.setDate(null);
        searchTxt.setText("");
        readerCombo.setVisible(false);
        if (nationalityCombo.getSelectedIndex() != -1) {
            try {
                String nationality = (String) nationalityCombo.getSelectedItem();
                showNationalityTable(nationality);
                 } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_nationalityComboItemStateChanged

    private void greaterThanRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greaterThanRadioActionPerformed
        egualRadio.setSelected(false);
        smallerThanRadio.setSelected(false);
        countForPenaltyTxt.setText("");
        statusCombo.setSelectedIndex(0);
        activityCombo.setSelectedIndex(0);
        nationalityCombo.setVisible(false);
        searchNationalityTxt.setText("");
        startDateCalendar.setDate(null);
        buttonGroupGender.clearSelection();
        time2.setDate(null);
        searchTxt.setText("");
        readerCombo.setVisible(false);
        if (addPenaltyTxt.getText().matches("[0-9]+(\\.[0-9]+)?")) {
            getPenalty = addPenaltyTxt.getText();
            greaterThanRadio.setText(">");
            greaterThanRadio.setActionCommand(">");
            if (greaterThanRadio.isSelected()) {
                try {
                    Integer result = readService.getCount(9, getPenalty);
                    if (result != null) {
                        countForPenaltyTxt.setText(String.valueOf(result));
                        tablePanel.setVisible(true);
                        table.setVisible(true);
                        showTable(getPenalty, 5);
                    } else {
                        countForPenaltyTxt.setText("0");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ONLY NUMBER TYPE!");
        }
    }//GEN-LAST:event_greaterThanRadioActionPerformed

    private void smallerThanRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smallerThanRadioActionPerformed
        egualRadio.setSelected(false);
        greaterThanRadio.setSelected(false);
        countForPenaltyTxt.setText("");
        statusCombo.setSelectedIndex(0);
        activityCombo.setSelectedIndex(0);
        nationalityCombo.setVisible(false);
        searchNationalityTxt.setText("");
        startDateCalendar.setDate(null);
        time2.setDate(null);
        searchTxt.setText("");
        readerCombo.setVisible(false);
        if (addPenaltyTxt.getText().matches("[0-9]+(\\.[0-9]+)?")) {
            getPenalty = addPenaltyTxt.getText();
            if (smallerThanRadio.isSelected()) {
                try {
                    Integer result = readService.getCount(8, getPenalty);
                    if (result != null) {
                        countForPenaltyTxt.setText(String.valueOf(result));
                        tablePanel.setVisible(true);
                        table.setVisible(true);
                        showTable(getPenalty, 6);
                    } else {
                        countForPenaltyTxt.setText("0");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ONLY NUMBER TYPE!");
        }
    }//GEN-LAST:event_smallerThanRadioActionPerformed

    private void egualRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_egualRadioActionPerformed

        buttonGroupGender.clearSelection();
        smallerThanRadio.setSelected(false);
        greaterThanRadio.setSelected(false);
        countForPenaltyTxt.setText("");
        statusCombo.setSelectedIndex(0);
        activityCombo.setSelectedIndex(0);
        nationalityCombo.setVisible(false);
        searchNationalityTxt.setText("");
        startDateCalendar.setDate(null);
        time2.setDate(null);
        searchTxt.setText("");
        readerCombo.setVisible(false);
        if (addPenaltyTxt.getText().matches("[0-9]+(\\.[0-9]+)?")) {
            getPenalty = addPenaltyTxt.getText();
            if (egualRadio.isSelected()) {
                try {
                    Integer result = readService.getCount(7, getPenalty);
                    if (result != null) {
                        countForPenaltyTxt.setText(String.valueOf(result));
                        tablePanel.setVisible(true);
                        table.setVisible(true);
                        showTable(getPenalty, 4);
                    } else {
                        countForPenaltyTxt.setText("0");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ONLY NUMBER TYPE!");
        }
    }//GEN-LAST:event_egualRadioActionPerformed

    private void addPenaltyTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPenaltyTxtActionPerformed
        buttonGroup.clearSelection();
        countForPenaltyTxt.setText("");
        buttonGroupGender.clearSelection();
        statusCombo.setSelectedIndex(0);
        activityCombo.setSelectedIndex(0);
        nationalityCombo.setVisible(false);
        searchNationalityTxt.setText("");
        startDateCalendar.setDate(null);
        time2.setDate(null);
        searchTxt.setText("");
        readerCombo.setVisible(false);
    }//GEN-LAST:event_addPenaltyTxtActionPerformed

    private void addPenaltyTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addPenaltyTxtKeyPressed
        countForPenaltyTxt.setText("");
        buttonGroup.clearSelection();
        buttonGroupGender.clearSelection();
        statusCombo.setSelectedIndex(0);
        activityCombo.setSelectedIndex(0);
        nationalityCombo.setVisible(false);
        searchNationalityTxt.setText("");
        startDateCalendar.setDate(null);
        time2.setDate(null);
        searchTxt.setText("");
        readerCombo.setVisible(false);
    }//GEN-LAST:event_addPenaltyTxtKeyPressed

    private void addPenaltyTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPenaltyTxtMouseClicked
        buttonGroup.clearSelection();
        countForPenaltyTxt.setText("");
        buttonGroupGender.clearSelection();
        statusCombo.setSelectedIndex(0);
        activityCombo.setSelectedIndex(0);
        nationalityCombo.setVisible(false);
        searchNationalityTxt.setText("");
        startDateCalendar.setDate(null);
        time2.setDate(null);
        searchTxt.setText("");
        readerCombo.setVisible(false);
    }//GEN-LAST:event_addPenaltyTxtMouseClicked

    private void startDateCalendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startDateCalendarMouseClicked

    }//GEN-LAST:event_startDateCalendarMouseClicked

    private void startDateCalendarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_startDateCalendarKeyPressed


    }//GEN-LAST:event_startDateCalendarKeyPressed

    private void startDateCalendarAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_startDateCalendarAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_startDateCalendarAncestorAdded

    private void startDateCalendarInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_startDateCalendarInputMethodTextChanged
        try {
            Date date = startDateCalendar.getDate();
            Date time2Date = time2.getDate();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            showTableForDate(df.format(date), df.format(time2Date));
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }//GEN-LAST:event_startDateCalendarInputMethodTextChanged

    private void startDateCalendarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_startDateCalendarKeyReleased

    }//GEN-LAST:event_startDateCalendarKeyReleased

    private void dateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateBtnActionPerformed
        statusCombo.setSelectedIndex(0);
        activityCombo.setSelectedIndex(0);
        nationalityCombo.setVisible(false);
        searchNationalityTxt.setText("");
        addPenaltyTxt.setText("");
        countForPenaltyTxt.setText("0");
        buttonGroup.clearSelection();
        searchTxt.setText("");
        buttonGroupGender.clearSelection();
        readerCombo.setVisible(false);
        try {
            Date date = startDateCalendar.getDate();
            Date time2Date = time2.getDate();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            if (date != null && time2Date != null) {
                showTableForDate(df.format(date), df.format(time2Date));
            } else if (date != null && time2Date == null) {
                showTableForDate(df.format(date), null);
            } else if (date == null && time2Date != null) {
                showTableForDate(null, df.format(time2Date));
            } else if (date == null && time2Date == null) {
                JOptionPane.showMessageDialog(null, "Add Date");
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }//GEN-LAST:event_dateBtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "Are you sure close program ? ");
        if (choose == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            this.setVisible(true);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void restoreBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreBtn2ActionPerformed
        if (getExtendedState() == NORMAL) {
            setExtendedState(MAXIMIZED_BOTH);
            setResizable(true);

        } else {
            setExtendedState(NORMAL);
            this.pack();
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_restoreBtn2ActionPerformed

    private void minimizeBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeBtn2ActionPerformed
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_minimizeBtn2ActionPerformed

    private void backBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn2ActionPerformed
        this.dispose();
        ReaderFirstFrame firstFrame = new ReaderFirstFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        firstFrame.setVisible(true);
    }//GEN-LAST:event_backBtn2ActionPerformed

    private void searchNationalityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchNationalityTxtActionPerformed
        keyword = searchNationalityTxt.getText();
        nationalityCombo.setVisible(true);
        showNationality(keyword);
        buttonGroupGender.clearSelection();
        statusCombo.setSelectedIndex(0);
        activityCombo.setSelectedIndex(0);
        addPenaltyTxt.setText("");
        buttonGroup.clearSelection();
        startDateCalendar.setDate(null);
        time2.setDate(null);
        searchTxt.setText("");
        readerCombo.setVisible(false);

    }//GEN-LAST:event_searchNationalityTxtActionPerformed

    private void searchNationalityTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchNationalityTxtKeyPressed
        keyword = searchNationalityTxt.getText();
        nationalityCombo.setVisible(true);
        showNationality(keyword);
        buttonGroupGender.clearSelection();
        statusCombo.setSelectedIndex(0);
        activityCombo.setSelectedIndex(0);
        addPenaltyTxt.setText("");
        buttonGroup.clearSelection();
        startDateCalendar.setDate(null);
        time2.setDate(null);
        searchTxt.setText("");
        readerCombo.setVisible(false);

    }//GEN-LAST:event_searchNationalityTxtKeyPressed

    private void searchNationalityTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchNationalityTxtMouseClicked
        keyword = searchNationalityTxt.getText();
        nationalityCombo.setVisible(true);
        showNationality(keyword);
        buttonGroupGender.clearSelection();
        statusCombo.setSelectedIndex(0);
        activityCombo.setSelectedIndex(0);
        addPenaltyTxt.setText("");
        buttonGroup.clearSelection();
        startDateCalendar.setDate(null);
        time2.setDate(null);
        searchTxt.setText("");
        readerCombo.setVisible(false);
        if (evt.getClickCount() == 2) {
            searchNationalityTxt.setText("");
        }
    }//GEN-LAST:event_searchNationalityTxtMouseClicked

    private void startDateCalendarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startDateCalendarMouseEntered

    }//GEN-LAST:event_startDateCalendarMouseEntered

    private void searchNationalityTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchNationalityTxtKeyReleased
        keyword = searchNationalityTxt.getText();
        nationalityCombo.setVisible(true);
        showNationality(keyword);
        buttonGroupGender.clearSelection();
        statusCombo.setSelectedIndex(0);
        activityCombo.setSelectedIndex(0);
        addPenaltyTxt.setText("");
        buttonGroup.clearSelection();
        startDateCalendar.setDate(null);
        time2.setDate(null);
        searchTxt.setText("");
        readerCombo.setVisible(false);

    }//GEN-LAST:event_searchNationalityTxtKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        getPenalty();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxtActionPerformed
        String searchReader = searchTxt.getText();
        showReaderCombo(searchReader);
        readerCombo.setVisible(true);
        statusCombo.setSelectedIndex(0);
        activityCombo.setSelectedIndex(0);
        nationalityCombo.setVisible(false);
        searchNationalityTxt.setText("");
        addPenaltyTxt.setText("");
        buttonGroup.clearSelection();
        startDateCalendar.setDate(null);
        time2.setDate(null);
        buttonGroupGender.clearSelection();
        countForPenaltyTxt.setText("0");
    }//GEN-LAST:event_searchTxtActionPerformed

    private void readerComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_readerComboItemStateChanged
        statusCombo.setSelectedIndex(0);
        activityCombo.setSelectedIndex(0);
        nationalityCombo.setVisible(false);
        searchNationalityTxt.setText("");
        addPenaltyTxt.setText("");
        buttonGroup.clearSelection();
        startDateCalendar.setDate(null);
        time2.setDate(null);
        buttonGroupGender.clearSelection();
        countForPenaltyTxt.setText("0");
        if ((readerCombo.getSelectedIndex() != -1) && (!readerCombo.getSelectedItem().equals("Select Reader"))) {
            Item readerItem = (Item) readerCombo.getSelectedItem();
            Long readerId = readerItem.getId();
            showBookTable(readerId);
        } else {
            ((DefaultTableModel) table.getModel()).setRowCount(0);// delete table rows

        }
    }//GEN-LAST:event_readerComboItemStateChanged

    private void activityComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activityComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_activityComboActionPerformed

    private void searchTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyPressed
        String searchReader = searchTxt.getText();
        showReaderCombo(searchReader);
        readerCombo.setVisible(true);
        statusCombo.setSelectedIndex(0);
        activityCombo.setSelectedIndex(0);
        nationalityCombo.setVisible(false);
        searchNationalityTxt.setText("");
        addPenaltyTxt.setText("");
        buttonGroup.clearSelection();
        startDateCalendar.setDate(null);
        time2.setDate(null);
        buttonGroupGender.clearSelection();
        countForPenaltyTxt.setText("0");
    }//GEN-LAST:event_searchTxtKeyPressed

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        String searchReader = searchTxt.getText();
        showReaderCombo(searchReader);
        readerCombo.setVisible(true);
        statusCombo.setSelectedIndex(0);
        activityCombo.setSelectedIndex(0);
        nationalityCombo.setVisible(false);
        searchNationalityTxt.setText("");
        addPenaltyTxt.setText("");
        buttonGroup.clearSelection();
        startDateCalendar.setDate(null);
        time2.setDate(null);
        buttonGroupGender.clearSelection();
        countForPenaltyTxt.setText("0");
    }//GEN-LAST:event_searchTxtKeyReleased

    private void searchTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTxtMouseClicked
        String searchReader = searchTxt.getText();
        showReaderCombo(searchReader);
        readerCombo.setVisible(true);
        statusCombo.setSelectedIndex(0);
        activityCombo.setSelectedIndex(0);
        nationalityCombo.setVisible(false);
        searchNationalityTxt.setText("");
        addPenaltyTxt.setText("");
        buttonGroup.clearSelection();
        startDateCalendar.setDate(null);
        time2.setDate(null);
        buttonGroupGender.clearSelection();
        countForPenaltyTxt.setText("0");
    }//GEN-LAST:event_searchTxtMouseClicked

    private void addPenaltyTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addPenaltyTxtKeyReleased
        buttonGroup.clearSelection();
        countForPenaltyTxt.setText("");
        buttonGroupGender.clearSelection();
        statusCombo.setSelectedIndex(0);
        activityCombo.setSelectedIndex(0);
        nationalityCombo.setVisible(false);
        searchNationalityTxt.setText("");
        startDateCalendar.setDate(null);
        time2.setDate(null);
        searchTxt.setText("");
        readerCombo.setVisible(false);
    }//GEN-LAST:event_addPenaltyTxtKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> activityCombo;
    private javax.swing.JTextField addPenaltyTxt;
    private javax.swing.JRadioButton allRadio;
    private javax.swing.JButton backBtn2;
    private javax.swing.JTextField countForPenaltyTxt;
    private javax.swing.JButton dateBtn;
    private javax.swing.JRadioButton egualRadio;
    private javax.swing.JRadioButton femaleRadio;
    private javax.swing.JRadioButton greaterThanRadio;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JRadioButton maleRadio;
    private javax.swing.JButton minimizeBtn2;
    private javax.swing.JComboBox<String> nationalityCombo;
    private javax.swing.JTextField penalityTxt;
    private javax.swing.JComboBox<String> readerCombo;
    private javax.swing.JButton restoreBtn2;
    private javax.swing.JTextField searchNationalityTxt;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JRadioButton smallerThanRadio;
    private com.toedter.calendar.JDateChooser startDateCalendar;
    private javax.swing.JComboBox<String> statusCombo;
    private javax.swing.JTable table;
    private javax.swing.JPanel tablePanel;
    private com.toedter.calendar.JDateChooser time2;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables

    private void showStatusCombo() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) statusCombo.getModel();
        String[] statuss = {"Pupil", "Student", "Employee", "UnEmployee"};
        model.addElement("Select Status");
        for (String status : statuss) {
            model.addElement(status);
        }
    }

    void showTable(String sql, int choose) {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            if (choose == 1) {
                model.addColumn("id");
                model.addColumn("№");
                model.addColumn("Full Name");
                model.addColumn("Activity");
                model.addColumn("Status");
                table.setModel(model);
                List<Reader> readerList = readService.getReaderForActive(1, sql);
                for (Reader reader : readerList) {
                    Object object[] = new Object[]{
                        reader.getId(), reader.getNumber() + " " + reader.getFirstName(), reader.getLastName(), reader.getActivity(), reader.getStatus()
                    };
                    model.addRow(object);
                }
            } else if (choose == 2) {
                model.addColumn("id");
                model.addColumn("№");
                model.addColumn("Full Name");
                model.addColumn("Status");
                model.addColumn("Activity");
                table.setModel(model);
                List<Reader> readerList = readService.getReaderForActive(2, sql);
                for (Reader reader : readerList) {
                    Object object[] = new Object[]{
                        reader.getId(), reader.getNumber(), reader.getFirstName() + " " + reader.getLastName(), reader.getStatus(), reader.getActivity()
                    };
                    model.addRow(object);
                    table.getColumnModel().getColumn(0).setMinWidth(0);
                    table.getColumnModel().getColumn(0).setWidth(0);
                    table.getColumnModel().getColumn(0).setMaxWidth(0);
                    table.getColumnModel().getColumn(1).setMaxWidth(30);
                }
            } else if (choose == 3) {

                model.addColumn("id");
                model.addColumn("№");
                model.addColumn("First Name");
                model.addColumn("Last Name");
                model.addColumn("Nationality");
                table.setModel(model);
                List<Reader> readerListForNationality = readService.getReaderForActive(3, sql);
                for (Reader reader : readerListForNationality) {
                    Object object[] = new Object[]{
                        reader.getId(), reader.getNumber(), reader.getFirstName(), reader.getLastName(), reader.getNationality()
                    };
                    model.addRow(object);
                }
                table.getColumnModel().getColumn(0).setMinWidth(0);
                table.getColumnModel().getColumn(0).setWidth(0);
                table.getColumnModel().getColumn(0).setMaxWidth(0);
                table.getColumnModel().getColumn(1).setMaxWidth(30);

                model.fireTableDataChanged();
            } else if (choose == 4) {
                model.addColumn("id");
                model.addColumn("№");
                model.addColumn("First Name");
                model.addColumn("Last Name");
                model.addColumn("Penality");
                table.setModel(model);
                List<Reader> readerListForNationality = readService.getReaderForActive(4, sql);
                for (Reader reader : readerListForNationality) {
                    Object object[] = new Object[]{
                        reader.getId(), reader.getNumber(), reader.getFirstName(), reader.getLastName(), reader.getPenalty()
                    };
                    model.addRow(object);
                }
                table.getColumnModel().getColumn(0).setMinWidth(0);
                table.getColumnModel().getColumn(0).setWidth(0);
                table.getColumnModel().getColumn(0).setMaxWidth(0);
                table.getColumnModel().getColumn(1).setMaxWidth(30);
                model.fireTableDataChanged();
            } else if (choose == 5) {
                model.addColumn("id");
                model.addColumn("№");
                model.addColumn("First Name");
                model.addColumn("Last Name");
                model.addColumn("Penality");
                table.setModel(model);
                List<Reader> readerListForNationality = readService.getReaderForActive(5, sql);
                for (Reader reader : readerListForNationality) {
                    Object object[] = new Object[]{
                        reader.getId(), reader.getNumber(), reader.getFirstName(), reader.getLastName(), reader.getPenalty()
                    };
                    model.addRow(object);
                }
                table.getColumnModel().getColumn(0).setMinWidth(0);
                table.getColumnModel().getColumn(0).setWidth(0);
                table.getColumnModel().getColumn(0).setMaxWidth(0);
                table.getColumnModel().getColumn(1).setMaxWidth(30);
                model.fireTableDataChanged();
            } else if (choose == 6) {

                model.addColumn("id");
                model.addColumn("№");
                model.addColumn("First Name");
                model.addColumn("Last Name");
                model.addColumn("Penality");
                table.setModel(model);
                List<Reader> readerListForNationality = readService.getReaderForActive(6, sql);
                for (Reader reader : readerListForNationality) {
                    Object object[] = new Object[]{
                        reader.getId(), reader.getNumber(), reader.getFirstName(), reader.getLastName(), reader.getPenalty()
                    };
                    model.addRow(object);
                }
                table.getColumnModel().getColumn(0).setMinWidth(0);
                table.getColumnModel().getColumn(0).setWidth(0);
                table.getColumnModel().getColumn(0).setMaxWidth(0);
                table.getColumnModel().getColumn(1).setMaxWidth(30);
                model.fireTableDataChanged();
            } else if (choose == 7) {

                model.addColumn("id");
                model.addColumn("№");
                model.addColumn("First Name");
                model.addColumn("Last Name");
                model.addColumn("Gender");
                table.setModel(model);
                table.getColumnModel().getColumn(0).setMaxWidth(0);
                table.getColumnModel().getColumn(0).setWidth(0);
                table.getColumnModel().getColumn(0).setMinWidth(0);
                table.getColumnModel().getColumn(1).setWidth(30);
                List<Reader> readerListForNationality = readService.getReaderForActive(8, sql);
                for (Reader reader : readerListForNationality) {
                    Object object[] = new Object[]{
                        reader.getId(), reader.getNumber(), reader.getFirstName(), reader.getLastName(), reader.getGender()
                    };
                    model.addRow(object);
                }
                table.getColumnModel().getColumn(0).setMinWidth(0);
                table.getColumnModel().getColumn(0).setWidth(0);
                table.getColumnModel().getColumn(0).setMaxWidth(0);
                table.getColumnModel().getColumn(1).setMaxWidth(30);
                model.fireTableDataChanged();
            } else if (choose == 8) {

                model.addColumn("id");
                model.addColumn("№");
                model.addColumn("First Name");
                model.addColumn("Last Name");
                model.addColumn("Gender");
                table.setModel(model);
                List<Reader> readerListForNationality = readService.getReaderForActive(9, null);
                for (Reader reader : readerListForNationality) {
                    Object object[] = new Object[]{
                        reader.getId(), reader.getNumber(), reader.getFirstName(), reader.getLastName(), reader.getGender()
                    };
                    table.getColumnModel().getColumn(0).setMinWidth(0);
                    table.getColumnModel().getColumn(0).setWidth(0);
                    table.getColumnModel().getColumn(0).setMaxWidth(0);
                    table.getColumnModel().getColumn(1).setMaxWidth(30);
                    model.addRow(object);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void showTableForActivityAndStatus(String choose1, String choose2) {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }

            };
            model.addColumn("№");
            model.addColumn("First Name");
            model.addColumn("Last Name");
            model.addColumn("Status");
            model.addColumn("Activity");
            table.setModel(model);
            List<Reader> readerList = readService.getActivityAndStatus(choose1, choose2);
            for (Reader reader : readerList) {
                Object object[] = new Object[]{
                    reader.getNumber(), reader.getFirstName(), reader.getLastName(), reader.getStatus(), reader.getActivity()
                };
                table.getColumnModel().getColumn(0).setMinWidth(0);
                table.getColumnModel().getColumn(0).setWidth(0);
                table.getColumnModel().getColumn(0).setMaxWidth(0);
                table.getColumnModel().getColumn(1).setMaxWidth(30);
                model.addRow(object);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void showTableForRealation(int choose, String gender, String status, String activity) {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            if (choose == 1) {
                model.addColumn("№");
                model.addColumn("First Name");
                model.addColumn("Last Name");
                model.addColumn("Status");
                model.addColumn("activity");
                table.setModel(model);
                List<Reader> readerListForNationality = readService.getReaderRelation(1, gender, status, activity, null);
                for (Reader reader : readerListForNationality) {
                    Object object[] = new Object[]{
                        reader.getNumber(), reader.getFirstName(), reader.getLastName(), reader.getGender(), reader.getStatus(),
                        reader.getActivity()
                    };
                    model.addRow(object);
                    table.getColumnModel().getColumn(0).setMinWidth(0);
                    table.getColumnModel().getColumn(0).setWidth(0);
                    table.getColumnModel().getColumn(0).setMaxWidth(0);
                    table.getColumnModel().getColumn(1).setMaxWidth(30);
                }
                model.fireTableDataChanged();
            } else if (choose == 2) {
                model.addColumn("№");
                model.addColumn("First Name");
                model.addColumn("Last Name");
                model.addColumn("activity");
                table.setModel(model);
                List<Reader> readerListForNationality = readService.getReaderRelation(2, gender, null, activity, null);
                for (Reader reader : readerListForNationality) {
                    Object object[] = new Object[]{
                        reader.getNumber(), reader.getFirstName(), reader.getLastName(), reader.getGender(),
                        reader.getActivity()
                    };
                    table.getColumnModel().getColumn(0).setMinWidth(0);
                    table.getColumnModel().getColumn(0).setWidth(0);
                    table.getColumnModel().getColumn(0).setMaxWidth(0);
                    table.getColumnModel().getColumn(1).setMaxWidth(30);
                    model.addRow(object);
                }
                model.fireTableDataChanged();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void getPenalty() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            try {
                Long selectedId = (Long) table.getValueAt(selectedRow, 0);
                Float result = readService.getPenalty(1, String.valueOf(selectedId));
                penalityTxt.setText(String.valueOf(result));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "If You Want To See Penalty, Please Select Row!");
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
        }
        if (filterList.size() > 0) {
            model.removeAllElements();
            for (String fl : filterList) {
                model.addElement(fl);
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

    void showTableForDate(String time1, String time2) {
        try {
            List<Reader> readers = readService.getrReaderInfoByDate(time1, time2);
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            model.addColumn("id");
            model.addColumn("№");
            model.addColumn("Card_number");
            model.addColumn("Full Name");
            model.addColumn("Gender");
            model.addColumn("Start MemberDate");
            model.addColumn("Pull Member Date");
            model.addColumn("Activity");
            model.addColumn("Status");
            table.setModel(model);
            for (Reader reader : readers) {
                Object object[] = new Object[]{
                    reader.getId(), reader.getNumber(), reader.getCardNumber(), reader.getFirstName() + " " + reader.getLastName(), reader.getGender(), reader.getStartMemberDate(),
                    reader.getPullMemberDate(), reader.getActivity(), reader.getStatus()
                };
                model.addRow(object);
            }
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(1).setWidth(30);
            model.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    void showTableFor3Item(String par1, String par2, String par3) {
        try {
            List<Reader> readers = readService.getPActSthGrForTable(par1, par2, par3);
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            model.addColumn("id");
            model.addColumn("№");
            model.addColumn("Full Name");
            model.addColumn("Gender");
            model.addColumn("Identity");
            model.addColumn("Card Number");
            model.addColumn("Activity");
            model.addColumn("Status");
            model.addColumn("Penalty");
            table.setModel(model);
            for (Reader reader : readers) {
                Object object[] = new Object[]{
                    reader.getId(), reader.getNumber(), reader.getFirstName() + " " + reader.getLastName(), reader.getGender(),
                    reader.getIdentifyNumber(), reader.getCardNumber(),
                    reader.getActivity(), reader.getStatus(), reader.getPenalty()
                };
                model.addRow(object);
            }
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(1).setWidth(30);
            model.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    void showActAndStatusTable(String c, String d) {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            model.addColumn("id");
            model.addColumn("№");
            model.addColumn("First Name");
            model.addColumn("Last Name");
            model.addColumn("Gender");
            table.setModel(model);
            List<Reader> readerListForNationality = readService.getActivityAndStatus(c, d);
            for (Reader reader : readerListForNationality) {
                Object object[] = new Object[]{
                    reader.getId(), reader.getNumber(), reader.getFirstName(), reader.getLastName(), reader.getGender()
                };
                model.addRow(object);
            }
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(1).setWidth(30);
            model.fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void showNationalityTable(String nationality) {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            model.addColumn("id");
            model.addColumn("№");
            model.addColumn("Card Number");
            model.addColumn("Full Name");
            model.addColumn("Gender");
            model.addColumn("Nationality");
            model.addColumn("Status");
            model.addColumn("Activity");
            table.setModel(model);
            List<Reader> readerListForNationality = readService.getReaderByNationality(nationality);
            for (Reader reader : readerListForNationality) {
                Object object[] = new Object[]{
                    reader.getId(), reader.getNumber(), reader.getCardNumber(), reader.getFirstName() + " " + reader.getLastName(), reader.getGender(),
                    reader.getNationality(), reader.getStatus(), reader.getActivity()
                };
                model.addRow(object);
            }
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(1).setWidth(30);
            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void showReaderCombo(String searchReader) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) readerCombo.getModel();
        try {
            List<Reader> filteredList = new ArrayList<>();
            List<Reader> reader = readService.getReaderList();
            for (Reader reader1 : reader) {
                if (reader1.getFirstName().contains(searchReader)
                        || reader1.getLastName().contains(searchReader)
                        || reader1.getCardNumber().contains(searchReader)) {
                    filteredList.add(reader1);
                }
            }
            if (filteredList.size() > 0) {
                model.removeAllElements();
                for (Reader reader2 : filteredList) {
                    model.addElement(new Item(reader2.getId(), reader2.getFirstName() + " " + reader2.getLastName()));
                }
            } else {
                model.removeAllElements();
                model.addElement("Select Reader");
                for (Reader reader1 : reader) {
                    model.addElement(new Item(reader1.getId(), reader1.getFirstName() + " " + reader1.getLastName()));
                }
            }
            JTextField textfield = (JTextField) readerCombo.getEditor().getEditorComponent();
            textfield.setText(searchReader);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void showBookTable(Long readerId) {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            model.addColumn("id");
            model.addColumn("№");
            model.addColumn("ISBN");
            model.addColumn("TITLE");
            table.setModel(model);
            List<Reader> books = readService.readerBooksById(readerId);
            for (Reader reader : books) {
                Object object[] = new Object[]{
                    reader.getBook().getId(), reader.getNumber(), reader.getBook().getIsbn(), reader.getBook().getTitle()
                };
                model.addRow(object);
            }
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(1).setWidth(30);
            model.fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
