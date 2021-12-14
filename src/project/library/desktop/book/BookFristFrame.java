package project.library.desktop.book;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import project.library.desktop.Desktop_Gui.Item;
import project.library.desktop.Desktop_Gui.LoginFrame;
import project.library.desktop.model.BookRoom;
import project.library.desktop.model.Language;
import project.library.desktop.model.Login;
import project.library.desktop.model.ReadRoom;
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
import project.library.desktop.service.StatusService;
import project.library.desktop.service.SubjectService;
import project.library.desktop.service.TimeTypeService;

/**
 *
 * @ Ulviyye Ibrahimli
 */
public class BookFristFrame extends javax.swing.JFrame {

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
    private StatusService statusService;
    String a;
    ButtonGroup buttonGroup = new ButtonGroup();
    ButtonGroup buttonGroupWith = new ButtonGroup();

    public BookFristFrame() {
        initComponents();
    }

    public BookFristFrame(DepartmentService departmentService,
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
            this.setDefaultLookAndFeelDecorated(true);
            this.pack();
            this.setLocationRelativeTo(null);
            buttonGroupWith.add(withoutComRadio);
            buttonGroupWith.add(withCompRadio);
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.darker().darker());
            showSubjectComboForBookCount();
            showLanguageCombo();
            userTxt.setText("Welcome, " + login.getFirstName() + " " + login.getLastName() + " !");
            languageCombo.setRenderer(new BookFristFrame.TwoDecimalRenderer(languageCombo.getRenderer()));
            subjectComboForBookCount.setRenderer(new BookFristFrame.TwoDecimalRenderer(subjectComboForBookCount.getRenderer()));
            libFloorForshelCmb.setRenderer(new BookFristFrame.TwoDecimalRenderer(libFloorForshelCmb.getRenderer()));
            roomNumberForShelfCmb.setRenderer(new BookFristFrame.TwoDecimalRenderer(roomNumberForShelfCmb.getRenderer()));
            floorForReadRoomCountCmb.setRenderer(new BookFristFrame.TwoDecimalRenderer(floorForReadRoomCountCmb.getRenderer()));
            libFloorForReadRoomCombo.setRenderer(new BookFristFrame.TwoDecimalRenderer(libFloorForReadRoomCombo.getRenderer()));
            libFloorCombo1.setRenderer(new BookFristFrame.TwoDecimalRenderer(libFloorCombo1.getRenderer()));
            roomNumberCombo1.setRenderer(new BookFristFrame.TwoDecimalRenderer(roomNumberCombo1.getRenderer()));
            libFloorCombo.setRenderer(new BookFristFrame.TwoDecimalRenderer(libFloorCombo.getRenderer()));
            roomNumberCombo.setRenderer(new BookFristFrame.TwoDecimalRenderer(roomNumberCombo.getRenderer()));
            roomNumberCombo1.setVisible(false);
            roomNumberForShelfCmb.setVisible(false);
            roomNumberForComputerCmb.setVisible(false);
            withCompRadio.setVisible(false);
            withoutComRadio.setVisible(false);
            Float allBooks = bookService.getCount(32, null);
            allBookTxt.setText(String.valueOf(Math.round(allBooks)));
            Float result = bookService.getCount(1, null);
            bookCount.setText("No repeated --" + String.valueOf(Math.round(result)));
            Float authorCount = bookService.getCount(3, null);
            if (authorCount != null) {
                authorCountTxt.setText(String.valueOf(Math.round(authorCount)));
            } else {
                authorCountTxt.setText("0");
            }
            Float languageCount = bookService.getCount(5, null);
            if (languageCount != null) {
                languageCountTxt.setText(String.valueOf(Math.round(languageCount)));
            } else {
                languageCountTxt.setText("0");
            }
            Float shelfCount = bookService.getCount(9, null);
            shelfCountTxt.setText(String.valueOf(Math.round(shelfCount)));
            Float roomCount = bookService.getCount(10, null);
            roomCountTxt.setText(String.valueOf(Math.round(roomCount)));
            Float readRoomCount = bookService.getCount(11, null);
            readRoomCountTxt.setText(String.valueOf(Math.round(readRoomCount)));
            Float readTableCount = bookService.getCount(12, null);
            readTableCountTxt.setText(String.valueOf(Math.round(readTableCount)));
            Float chairSum = bookService.getCount(13, null);
            chairCountSumTxt.setText("All chair " + String.valueOf(Math.round(chairSum)));
            computerCountTxt.setText(String.valueOf(Math.round(bookService.getCount(24, null))));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        subjectComboForBookCount = new javax.swing.JComboBox<>();
        bookCount = new javax.swing.JTextField();
        seachTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        authorCountTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        languageCombo = new javax.swing.JComboBox<>();
        bookCountForLanguageTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        languageCountTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        newCheckbox = new javax.swing.JCheckBox();
        oldCheckBox = new javax.swing.JCheckBox();
        bookCountForBookCaseTxt = new javax.swing.JTextField();
        newRadio = new javax.swing.JRadioButton();
        oldRadio = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        shelfCountTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        roomCountTxt = new javax.swing.JTextField();
        readRoomCountTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        readTableCountTxt = new javax.swing.JTextField();
        chairCountSumTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        libFloorCombo = new javax.swing.JComboBox<>();
        roomNumberCombo = new javax.swing.JComboBox<>();
        roomNumberCombo1 = new javax.swing.JComboBox<>();
        libFloorCombo1 = new javax.swing.JComboBox<>();
        libFloorForReadRoomCombo = new javax.swing.JComboBox<>();
        floorForReadRoomCountCmb = new javax.swing.JComboBox<>();
        libFloorForshelCmb = new javax.swing.JComboBox<>();
        roomNumberForShelfCmb = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        computerCountForFloorCmb = new javax.swing.JComboBox<>();
        roomNumberForComputerCmb = new javax.swing.JComboBox<>();
        computerCountTxt = new javax.swing.JTextField();
        withCompRadio = new javax.swing.JRadioButton();
        withoutComRadio = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        allBookTxt = new javax.swing.JTextField();
        restoreBtn1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        minimizeBtn1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        userTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Book Info");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Book Item Info");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 102));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("All Book Count  For Subject");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        subjectComboForBookCount.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        subjectComboForBookCount.setForeground(new java.awt.Color(0, 0, 102));
        subjectComboForBookCount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subjectComboForBookCount.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                subjectComboForBookCountItemStateChanged(evt);
            }
        });
        subjectComboForBookCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectComboForBookCountActionPerformed(evt);
            }
        });

        bookCount.setEditable(false);
        bookCount.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        bookCount.setForeground(new java.awt.Color(204, 0, 0));
        bookCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bookCount.setSelectionColor(new java.awt.Color(0, 0, 102));
        bookCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookCountActionPerformed(evt);
            }
        });

        seachTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        seachTxt.setForeground(new java.awt.Color(0, 0, 102));
        seachTxt.setAlignmentX(1.0F);
        seachTxt.setAlignmentY(1.0F);
        seachTxt.setBorder(null);
        seachTxt.setSelectionColor(new java.awt.Color(0, 0, 102));
        seachTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seachTxtMouseClicked(evt);
            }
        });
        seachTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seachTxtActionPerformed(evt);
            }
        });
        seachTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                seachTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                seachTxtKeyReleased(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 102));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("All Author Count");

        authorCountTxt.setEditable(false);
        authorCountTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        authorCountTxt.setForeground(new java.awt.Color(204, 0, 0));
        authorCountTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        authorCountTxt.setSelectionColor(new java.awt.Color(0, 0, 102));
        authorCountTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorCountTxtActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 102));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Book Count For Language");

        languageCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        languageCombo.setForeground(new java.awt.Color(0, 0, 102));
        languageCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Language" }));
        languageCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        languageCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                languageComboItemStateChanged(evt);
            }
        });

        bookCountForLanguageTxt.setEditable(false);
        bookCountForLanguageTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        bookCountForLanguageTxt.setForeground(new java.awt.Color(204, 0, 0));
        bookCountForLanguageTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bookCountForLanguageTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookCountForLanguageTxtActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 0, 102));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Language Count");

        languageCountTxt.setEditable(false);
        languageCountTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        languageCountTxt.setForeground(new java.awt.Color(204, 0, 0));
        languageCountTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        languageCountTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languageCountTxtActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 0, 102));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Book Count For Case");

        newCheckbox.setBackground(new java.awt.Color(0, 0, 102));
        newCheckbox.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        newCheckbox.setForeground(new java.awt.Color(255, 255, 255));
        newCheckbox.setText("New");
        newCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCheckboxActionPerformed(evt);
            }
        });

        oldCheckBox.setBackground(new java.awt.Color(0, 0, 102));
        oldCheckBox.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        oldCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        oldCheckBox.setText("Old");
        oldCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldCheckBoxActionPerformed(evt);
            }
        });

        bookCountForBookCaseTxt.setEditable(false);
        bookCountForBookCaseTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        bookCountForBookCaseTxt.setForeground(new java.awt.Color(204, 0, 0));
        bookCountForBookCaseTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bookCountForBookCaseTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookCountForBookCaseTxtActionPerformed(evt);
            }
        });

        newRadio.setBackground(new java.awt.Color(0, 0, 102));
        newRadio.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        newRadio.setForeground(new java.awt.Color(255, 255, 255));
        newRadio.setText("New");
        newRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRadioActionPerformed(evt);
            }
        });

        oldRadio.setBackground(new java.awt.Color(0, 0, 102));
        oldRadio.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        oldRadio.setForeground(new java.awt.Color(255, 255, 255));
        oldRadio.setText("Old");
        oldRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldRadioActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 0, 102));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Book shelf");

        shelfCountTxt.setEditable(false);
        shelfCountTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        shelfCountTxt.setForeground(new java.awt.Color(204, 0, 0));
        shelfCountTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setBackground(new java.awt.Color(0, 0, 102));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Room Count");

        roomCountTxt.setEditable(false);
        roomCountTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        roomCountTxt.setForeground(new java.awt.Color(204, 0, 0));
        roomCountTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        readRoomCountTxt.setEditable(false);
        readRoomCountTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        readRoomCountTxt.setForeground(new java.awt.Color(204, 0, 0));
        readRoomCountTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        readRoomCountTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readRoomCountTxtActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(0, 0, 102));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Read Room");

        jLabel10.setBackground(new java.awt.Color(0, 0, 102));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Read Table");

        readTableCountTxt.setEditable(false);
        readTableCountTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        readTableCountTxt.setForeground(new java.awt.Color(204, 0, 0));
        readTableCountTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        chairCountSumTxt.setEditable(false);
        chairCountSumTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        chairCountSumTxt.setForeground(new java.awt.Color(204, 0, 0));
        chairCountSumTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel11.setBackground(new java.awt.Color(0, 0, 102));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Chair Sum");

        libFloorCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        libFloorCombo.setForeground(new java.awt.Color(0, 0, 102));
        libFloorCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Floor", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", " " }));
        libFloorCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        libFloorCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                libFloorComboItemStateChanged(evt);
            }
        });

        roomNumberCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        roomNumberCombo.setForeground(new java.awt.Color(0, 0, 102));
        roomNumberCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room Number" }));
        roomNumberCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        roomNumberCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                roomNumberComboItemStateChanged(evt);
            }
        });
        roomNumberCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNumberComboActionPerformed(evt);
            }
        });

        roomNumberCombo1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        roomNumberCombo1.setForeground(new java.awt.Color(0, 0, 102));
        roomNumberCombo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room Number" }));
        roomNumberCombo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        roomNumberCombo1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                roomNumberCombo1ItemStateChanged(evt);
            }
        });

        libFloorCombo1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        libFloorCombo1.setForeground(new java.awt.Color(0, 0, 102));
        libFloorCombo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Floor", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        libFloorCombo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        libFloorCombo1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                libFloorCombo1ItemStateChanged(evt);
            }
        });
        libFloorCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libFloorCombo1ActionPerformed(evt);
            }
        });

        libFloorForReadRoomCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        libFloorForReadRoomCombo.setForeground(new java.awt.Color(0, 0, 102));
        libFloorForReadRoomCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Floor", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        libFloorForReadRoomCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        libFloorForReadRoomCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                libFloorForReadRoomComboItemStateChanged(evt);
            }
        });

        floorForReadRoomCountCmb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        floorForReadRoomCountCmb.setForeground(new java.awt.Color(0, 0, 102));
        floorForReadRoomCountCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Floor", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        floorForReadRoomCountCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        floorForReadRoomCountCmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                floorForReadRoomCountCmbItemStateChanged(evt);
            }
        });

        libFloorForshelCmb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        libFloorForshelCmb.setForeground(new java.awt.Color(0, 0, 102));
        libFloorForshelCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Floor", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        libFloorForshelCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        libFloorForshelCmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                libFloorForshelCmbItemStateChanged(evt);
            }
        });
        libFloorForshelCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libFloorForshelCmbActionPerformed(evt);
            }
        });

        roomNumberForShelfCmb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        roomNumberForShelfCmb.setForeground(new java.awt.Color(0, 0, 102));
        roomNumberForShelfCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room Number" }));
        roomNumberForShelfCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        roomNumberForShelfCmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                roomNumberForShelfCmbItemStateChanged(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(0, 0, 102));
        jLabel12.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Computer Count for reader");

        computerCountForFloorCmb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        computerCountForFloorCmb.setForeground(new java.awt.Color(0, 0, 102));
        computerCountForFloorCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Floor", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        computerCountForFloorCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        computerCountForFloorCmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                computerCountForFloorCmbItemStateChanged(evt);
            }
        });

        roomNumberForComputerCmb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        roomNumberForComputerCmb.setForeground(new java.awt.Color(0, 0, 102));
        roomNumberForComputerCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room Number" }));
        roomNumberForComputerCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        roomNumberForComputerCmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                roomNumberForComputerCmbItemStateChanged(evt);
            }
        });
        roomNumberForComputerCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNumberForComputerCmbActionPerformed(evt);
            }
        });

        computerCountTxt.setEditable(false);
        computerCountTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        computerCountTxt.setForeground(new java.awt.Color(204, 0, 0));
        computerCountTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        withCompRadio.setBackground(new java.awt.Color(0, 0, 102));
        withCompRadio.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        withCompRadio.setForeground(new java.awt.Color(255, 255, 255));
        withCompRadio.setText("With Comp");
        withCompRadio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        withCompRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withCompRadioActionPerformed(evt);
            }
        });

        withoutComRadio.setBackground(new java.awt.Color(0, 0, 102));
        withoutComRadio.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        withoutComRadio.setForeground(new java.awt.Color(255, 255, 255));
        withoutComRadio.setText("Without Comp");
        withoutComRadio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        withoutComRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withoutComRadioActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(0, 0, 102));
        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("All books");

        allBookTxt.setEditable(false);
        allBookTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        allBookTxt.setForeground(new java.awt.Color(204, 0, 0));
        allBookTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        allBookTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allBookTxtActionPerformed(evt);
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

        jButton3.setBackground(new java.awt.Color(153, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/close.png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        minimizeBtn1.setBackground(new java.awt.Color(51, 102, 255));
        minimizeBtn1.setForeground(new java.awt.Color(153, 0, 0));
        minimizeBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-minimize-window-48.png"))); // NOI18N
        minimizeBtn1.setBorder(null);
        minimizeBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizeBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeBtn1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Book's Information");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-undo-24.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
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
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(minimizeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(118, 118, 118))
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(oldRadio)))
                        .addGap(110, 110, 110))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(newRadio)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(62, 62, 62))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(allBookTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bookCountForLanguageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(languageCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(authorCountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(languageCountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(seachTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(subjectComboForBookCount, javax.swing.GroupLayout.Alignment.TRAILING, 0, 159, Short.MAX_VALUE)
                                            .addComponent(bookCount, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(newCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(57, 57, 57)
                                            .addComponent(oldCheckBox))
                                        .addComponent(bookCountForBookCaseTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(8, 8, 8)))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(12, 12, 12))
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roomCountTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(roomNumberCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(libFloorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roomNumberForShelfCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(floorForReadRoomCountCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roomNumberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(libFloorForshelCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(computerCountForFloorCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roomNumberForComputerCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(libFloorForReadRoomCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(libFloorCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(withoutComRadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(withCompRadio)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(readRoomCountTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(computerCountTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(shelfCountTxt)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(readTableCountTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chairCountSumTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(restoreBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(minimizeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabel14)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(libFloorForshelCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(shelfCountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(roomNumberForShelfCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(seachTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(subjectComboForBookCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bookCount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(libFloorForReadRoomCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(readRoomCountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(authorCountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roomCountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(floorForReadRoomCountCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(languageCountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(languageCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(oldRadio)
                                        .addComponent(newRadio))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addComponent(bookCountForLanguageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(newCheckbox)
                                            .addComponent(oldCheckBox)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(1, 1, 1))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(libFloorCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(roomNumberCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(withoutComRadio)
                                                    .addComponent(withCompRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(readTableCountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(11, 11, 11))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(35, 35, 35)
                                .addComponent(libFloorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(roomNumberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(chairCountSumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bookCountForBookCaseTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(computerCountForFloorCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(allBookTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addComponent(roomNumberForComputerCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(computerCountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );

        languageCombo.getAccessibleContext().setAccessibleName("");

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
        LoginFrame loginFrame = new LoginFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService,statusService);
        loginFrame.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void minimizeBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeBtn1ActionPerformed
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_minimizeBtn1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE, TO CLOSE THE PROGRAM ?");
        if (choose == JOptionPane.YES_OPTION) {
            System.exit(0);
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

    private void allBookTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allBookTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_allBookTxtActionPerformed

    private void withoutComRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withoutComRadioActionPerformed
        try {
            if (libFloorCombo1.getSelectedIndex() == 0 && roomNumberCombo1.getSelectedIndex() == 0) {
                if (libFloorCombo1.getSelectedIndex() == 0 && roomNumberCombo1.getSelectedIndex() == 0) {
                    Float rr = bookService.getCount(34, null);
                    readTableCountTxt.setText(String.valueOf(Math.round(rr)));
                }
            }
            if (libFloorCombo1.getSelectedIndex() > 0) {
                String floor = (String) libFloorCombo1.getSelectedItem();
                if (withoutComRadio.isSelected()) {
                    Float withCompTable = bookService.getCount(29, Long.parseLong(floor));
                    if (withCompTable != null) {
                        readTableCountTxt.setText(String.valueOf(Math.round(withCompTable)));
                    } else {
                        readTableCountTxt.setText("0");
                    }
                }
                if (roomNumberCombo1.getSelectedIndex() > 0) {
                    Item itemId = (Item) roomNumberCombo1.getSelectedItem();
                    Long id = itemId.getId();
                    Float withComputerForRoom = bookService.getCount(31, id);
                    if (withComputerForRoom != null) {
                        readTableCountTxt.setText(String.valueOf(Math.round(withComputerForRoom)));
                    } else {
                        readTableCountTxt.setText("0");
                    }
                }
            } else if (libFloorCombo1.getSelectedIndex() == 0) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_withoutComRadioActionPerformed

    private void withCompRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withCompRadioActionPerformed
        try {
            if (libFloorCombo1.getSelectedIndex() == 0 && roomNumberCombo1.getSelectedIndex() == 0) {
                Float rr = bookService.getCount(33, null);
                readTableCountTxt.setText(String.valueOf(Math.round(rr)));
            }

            if (libFloorCombo1.getSelectedIndex() > 0) {
                String floor = (String) libFloorCombo1.getSelectedItem();
                if (withCompRadio.isSelected()) {
                    Float withCompTable = bookService.getCount(28, Long.parseLong(floor));
                    if (withCompTable != null) {
                        readTableCountTxt.setText(String.valueOf(Math.round(withCompTable)));
                    } else {
                        readTableCountTxt.setText("0");
                    }
                }
                if (roomNumberCombo1.getSelectedIndex() > 0) {
                    Item itemId = (Item) roomNumberCombo1.getSelectedItem();
                    Long id = itemId.getId();
                    Float withComputerForRoom = bookService.getCount(30, id);
                    if (withComputerForRoom != null) {
                        readTableCountTxt.setText(String.valueOf(Math.round(withComputerForRoom)));
                    } else {
                        readTableCountTxt.setText("0");
                    }
                }
            } else if (libFloorCombo1.getSelectedIndex() == 0) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_withCompRadioActionPerformed

    private void roomNumberForComputerCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNumberForComputerCmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNumberForComputerCmbActionPerformed

    private void roomNumberForComputerCmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_roomNumberForComputerCmbItemStateChanged
        try {
            Item itemRoomNumber = (Item) roomNumberForComputerCmb.getSelectedItem();
            Long id = itemRoomNumber.getId();
            Float result = bookService.getCount(23, id);
            if (roomNumberForComputerCmb.getSelectedIndex() > 0) {
                if (evt.getStateChange() == 1) {
                    if (result != null) {
                        computerCountTxt.setText(String.valueOf(Math.round(result)));
                    } else {
                        computerCountTxt.setText("0");
                    }
                }
            } else {
                String floor = (String) computerCountForFloorCmb.getSelectedItem();
                if (computerCountForFloorCmb.getSelectedIndex() > 0) {
                    showRoomnumberForComputer(Integer.parseInt(floor));
                    Float computerCount = bookService.getCount(22, Long.parseLong(floor));
                    if (computerCount != null) {
                        roomNumberForComputerCmb.setVisible(true);
                        computerCountTxt.setText(String.valueOf(Math.round(computerCount)));
                    } else {
                        roomNumberForComputerCmb.setVisible(false);
                        computerCountTxt.setText("0");
                    }
                } else if (computerCountForFloorCmb.getSelectedIndex() == 0) {
                    roomNumberForComputerCmb.setSelectedIndex(0);
                    computerCountTxt.setText(String.valueOf(Math.round(bookService.getCount(24, null))));
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }//GEN-LAST:event_roomNumberForComputerCmbItemStateChanged

    private void computerCountForFloorCmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_computerCountForFloorCmbItemStateChanged
        roomNumberForComputerCmb.setVisible(true);
        try {
            String floor = (String) computerCountForFloorCmb.getSelectedItem();
            if (evt.getStateChange() == 1) {
                if (computerCountForFloorCmb.getSelectedIndex() > 0) {
                    showRoomnumberForComputer(Integer.parseInt(floor));
                    Float computerCount = bookService.getCount(22, Long.parseLong(floor));
                    if (computerCount != null) {
                        roomNumberForComputerCmb.setVisible(true);
                        computerCountTxt.setText(String.valueOf(Math.round(computerCount)));
                    } else {
                        roomNumberForComputerCmb.setVisible(false);
                        computerCountTxt.setText("0");
                    }
                } else if (computerCountForFloorCmb.getSelectedIndex() == 0) {

                    roomNumberForComputerCmb.setVisible(false);
                    computerCountTxt.setText(String.valueOf(Math.round(bookService.getCount(24, null))));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_computerCountForFloorCmbItemStateChanged

    private void roomNumberForShelfCmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_roomNumberForShelfCmbItemStateChanged
        try {
            String RoomNumber = (String) libFloorForshelCmb.getSelectedItem();
            if (roomNumberForShelfCmb.getSelectedIndex() > 0) {
                Item bookShelfItem = (Item) roomNumberForShelfCmb.getSelectedItem();
                Long id = bookShelfItem.getId();
                Float shelfCount = bookService.getCount(19, id);
                if (evt.getStateChange() == 1) {
                    if (shelfCount != null) {
                        shelfCountTxt.setText(String.valueOf(Math.round(shelfCount)));
                    } else {
                        shelfCountTxt.setText("0");
                    }
                }
            } else {
                if (libFloorForshelCmb.getSelectedIndex() > 0) {
                    String floor = (String) libFloorForshelCmb.getSelectedItem();
                    showRoomnumberForShelf(Integer.parseInt(floor));
                    Float shelfCountt = bookService.getCount(18, Long.parseLong(floor));
                    if (evt.getStateChange() == 1) {
                        if (shelfCountt != null) {
                            roomNumberForShelfCmb.setVisible(true);
                            shelfCountTxt.setText(String.valueOf(Math.round(shelfCountt)));
                        } else {
                            roomNumberForShelfCmb.setVisible(false);
                            shelfCountTxt.setText("0");
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_roomNumberForShelfCmbItemStateChanged

    private void libFloorForshelCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libFloorForshelCmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_libFloorForshelCmbActionPerformed

    private void libFloorForshelCmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_libFloorForshelCmbItemStateChanged
        try {
            if (!libFloorForshelCmb.getSelectedItem().equals("Select Floor")) {
                String floor = (String) libFloorForshelCmb.getSelectedItem();
                showRoomnumberForShelf(Integer.parseInt(floor));
                Float shelfCount = bookService.getCount(18, Long.parseLong(floor));
                if (evt.getStateChange() == 1) {
                    if (shelfCount != null) {
                        roomNumberForShelfCmb.setVisible(true);
                        shelfCountTxt.setText(String.valueOf(Math.round(shelfCount)));
                    } else {
                        roomNumberForShelfCmb.setVisible(false);
                        shelfCountTxt.setText("0");
                    }
                }
            } else {
                Float shelfCount = bookService.getCount(9, null);
                shelfCountTxt.setText(String.valueOf(Math.round(shelfCount)));
                shelfCountTxt.setText(String.valueOf(Math.round(shelfCount)));

                roomNumberForShelfCmb.setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_libFloorForshelCmbItemStateChanged

    private void floorForReadRoomCountCmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_floorForReadRoomCountCmbItemStateChanged
        try {
            if (!floorForReadRoomCountCmb.getSelectedItem().equals("Select Floor")) {
                String floor = (String) floorForReadRoomCountCmb.getSelectedItem();
                Float readRoomCount = bookService.getCount(17, Long.parseLong(floor));
                if (floorForReadRoomCountCmb.getSelectedIndex() > 0) {
                    if (evt.getStateChange() == 1) {
                        if (readRoomCount != null) {
                            roomCountTxt.setText(String.valueOf(Math.round(readRoomCount)));
                        } else {
                            roomCountTxt.setText("0");
                        }
                    }
                }
            } else {
                Float roomCount = bookService.getCount(10, null);
                roomCountTxt.setText(String.valueOf(Math.round(roomCount)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_floorForReadRoomCountCmbItemStateChanged

    private void libFloorForReadRoomComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_libFloorForReadRoomComboItemStateChanged
        try {
            if (libFloorForReadRoomCombo.getSelectedIndex() > 0) {
                String floor = (String) libFloorForReadRoomCombo.getSelectedItem();
                Float roomCount = bookService.getCount(16, Long.parseLong(floor));
                if (evt.getStateChange() == 1) {
                    if (roomCount != null) {
                        readRoomCountTxt.setText(String.valueOf(Math.round(roomCount)));
                    } else {
                        readRoomCountTxt.setText("0");
                    }
                }
            } else {
                Float readRoomCount = bookService.getCount(11, null);
                readRoomCountTxt.setText(String.valueOf(Math.round(readRoomCount)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_libFloorForReadRoomComboItemStateChanged

    private void libFloorCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libFloorCombo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_libFloorCombo1ActionPerformed

    private void libFloorCombo1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_libFloorCombo1ItemStateChanged
        try {
            String floor = (String) libFloorCombo1.getSelectedItem();
            if (evt.getStateChange() == 1) {
                if (!libFloorCombo1.getSelectedItem().equals("Select Floor")) {
                    Float readTableCount = bookService.getCount(21, Long.parseLong(floor));
                    if (readTableCount != null) {
                        roomNumberCombo1.setVisible(true);
                        withCompRadio.setVisible(true);
                        withoutComRadio.setVisible(true);
                        readTableCountTxt.setText(String.valueOf(Math.round(readTableCount)));
                        showRoomnumberForFloorForReadTable(Integer.parseInt(floor));

                    } else {
                        readTableCountTxt.setText("0");
                        roomNumberCombo1.setVisible(false);
                        withCompRadio.setVisible(false);
                        withoutComRadio.setVisible(false);
                    }

                } else if (libFloorCombo1.getSelectedIndex() == 0) {
                    roomNumberCombo1.setVisible(false);
                    Float readTableCount = bookService.getCount(12, null);
                    readTableCountTxt.setText(String.valueOf(Math.round(readTableCount)));
                    buttonGroupWith.clearSelection();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_libFloorCombo1ItemStateChanged

    private void roomNumberCombo1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_roomNumberCombo1ItemStateChanged
        try {
            Item roomItem = (Item) roomNumberCombo1.getSelectedItem();
            Long id = roomItem.getId();
            if (roomNumberCombo1.getSelectedIndex() > 0) {
                Float tableSumForRoom = bookService.getCount(15, id);
                if (tableSumForRoom != null) {
                    withCompRadio.setVisible(true);
                    withoutComRadio.setVisible(true);
                    readTableCountTxt.setText(String.valueOf(Math.round(tableSumForRoom)));
                } else {
                    readTableCountTxt.setText("0");
                    withCompRadio.setVisible(false);
                    withoutComRadio.setVisible(false);
                }
            } else if (roomNumberCombo1.getSelectedIndex() == 0) {
                String floor = (String) libFloorCombo1.getSelectedItem();
                if (evt.getStateChange() == 1) {
                    if (libFloorCombo1.getSelectedIndex() > 0) {
                        Float readTableCount = bookService.getCount(21, Long.parseLong(floor));
                        if (readTableCount != null) {
                            roomNumberCombo1.setVisible(true);
                            withCompRadio.setVisible(true);
                            withoutComRadio.setVisible(true);
                            readTableCountTxt.setText(String.valueOf(Math.round(readTableCount)));
                            showRoomnumberForFloorForReadTable(Integer.parseInt(floor));

                        } else {
                            readTableCountTxt.setText("0");
                            roomNumberCombo1.setVisible(false);
                            withCompRadio.setVisible(false);
                            withoutComRadio.setVisible(false);
                        }
                    } else if (libFloorCombo1.getSelectedIndex() == 0) {
                        roomNumberCombo1.setSelectedIndex(0);
                        Float readTableCount = bookService.getCount(12, null);
                        readTableCountTxt.setText(String.valueOf(Math.round(readTableCount)));
                        buttonGroupWith.clearSelection();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_roomNumberCombo1ItemStateChanged

    private void roomNumberComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNumberComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNumberComboActionPerformed

    private void roomNumberComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_roomNumberComboItemStateChanged
        try {
            Item itemRoomNumber = (Item) roomNumberCombo.getSelectedItem();
            Long id = itemRoomNumber.getId();
            if (roomNumberCombo.getSelectedIndex() > 0) {
                if (evt.getStateChange() == 1) {
                    try {
                        Float chairSum = bookService.getCount(14, id);
                        chairCountSumTxt.setText(String.valueOf(Math.round(chairSum)));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            } else {
                String floor = (String) libFloorCombo.getSelectedItem();
                Float chairCount = bookService.getCount(20, Long.parseLong(floor));
                if (libFloorCombo.getSelectedIndex() > 0) {
                    showRoomnumberForFloor(Integer.parseInt(floor));
                    if (evt.getStateChange() == 1) {
                        if (chairCount != null) {
                            roomNumberCombo.setVisible(true);
                            chairCountSumTxt.setText(String.valueOf(Math.round(chairCount)));
                        } else {
                            chairCountSumTxt.setText("0");
                            roomNumberCombo.setVisible(false);
                        }
                    }
                } else {
                    Float chairSum = bookService.getCount(13, null);
                    chairCountSumTxt.setText("All chair " + String.valueOf(Math.round(chairSum)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_roomNumberComboItemStateChanged

    private void libFloorComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_libFloorComboItemStateChanged
        try {
            if (!libFloorCombo.getSelectedItem().equals("Select Floor")) {
                String floor = (String) libFloorCombo.getSelectedItem();
                Float chairCount = bookService.getCount(20, Long.parseLong(floor));
                showRoomnumberForFloor(Integer.parseInt(floor));
                if (evt.getStateChange() == 1) {
                    if (chairCount != null) {
                        roomNumberCombo.setVisible(true);
                        chairCountSumTxt.setText(String.valueOf(Math.round(chairCount)));
                    } else {
                        chairCountSumTxt.setText("0");
                        roomNumberCombo.setVisible(false);
                    }
                }
            } else {
                roomNumberCombo.setVisible(false);
                Float chairSum = bookService.getCount(13, null);
                chairCountSumTxt.setText("All chair " + String.valueOf(Math.round(chairSum)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_libFloorComboItemStateChanged

    private void readRoomCountTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readRoomCountTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_readRoomCountTxtActionPerformed

    private void oldRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldRadioActionPerformed
        try {
            oldRadio.setText("Old");
            oldRadio.setActionCommand("Old");
            buttonGroup.add(oldRadio);
            if (languageCombo.getSelectedIndex() > 0) {
                Item languageItem = (Item) languageCombo.getSelectedItem();
                Long id = languageItem.getId();
                Float bookcountForLanguageAndOld = bookService.getCount(7, id);
                if (oldRadio.isSelected() && newRadio.isSelected() == false) {
                    if (bookcountForLanguageAndOld != null) {
                        bookCountForLanguageTxt.setText(String.valueOf(Math.round(bookcountForLanguageAndOld)));
                    } else {
                        bookCountForLanguageTxt.setText("0");
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(BookFristFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_oldRadioActionPerformed

    private void newRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newRadioActionPerformed
        try {
            newRadio.setText("New");
            newRadio.setActionCommand("New");
            buttonGroup.add(newRadio);
            if (languageCombo.getSelectedIndex() > 0) {
                Item languageItem = (Item) languageCombo.getSelectedItem();
                Long id = languageItem.getId();
                Float bookcountForLanguageAndOld = bookService.getCount(7, id);
                Float bookcountForLanguageAndNew = bookService.getCount(8, id);
                if (newRadio.isSelected()) {
                    if (bookcountForLanguageAndNew != null) {
                        bookCountForLanguageTxt.setText(String.valueOf(Math.round(bookcountForLanguageAndNew)));
                    } else {
                        bookCountForLanguageTxt.setText("0");
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(BookFristFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_newRadioActionPerformed

    private void bookCountForBookCaseTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookCountForBookCaseTxtActionPerformed
        try {
            if (newCheckbox.isSelected() && oldCheckBox.isSelected()) {
                bookCountForBookCaseTxt.setText(String.valueOf(Math.round(bookService.getCount(1, null))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bookCountForBookCaseTxtActionPerformed

    private void oldCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldCheckBoxActionPerformed
        try {
            if ((oldCheckBox.isSelected()) && (newCheckbox.isSelected() == false)) {
                Long id = new Long(2);
                Float bookCountForCase = bookService.getCount(6, id);
                if (bookCountForCase != null) {
                    bookCountForBookCaseTxt.setText(String.valueOf(Math.round(bookCountForCase)));
                } else {
                    bookCountForBookCaseTxt.setText("0");
                }
            } else if (newCheckbox.isSelected() && (oldCheckBox.isSelected() == false)) {
                Long id = new Long(1);
                Float bookCountForCase = bookService.getCount(6, id);
                if (bookCountForCase != null) {
                    bookCountForBookCaseTxt.setText(String.valueOf(Math.round(bookCountForCase)));

                } else {
                    bookCountForBookCaseTxt.setText("0");
                }
            }
            if (newCheckbox.isSelected() && oldCheckBox.isSelected()) {
                bookCountForBookCaseTxt.setText(String.valueOf(Math.round(bookService.getCount(1, null))));
            } else if (newCheckbox.isSelected() == false && oldCheckBox.isSelected() == false) {
                bookCountForBookCaseTxt.setText("0");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_oldCheckBoxActionPerformed

    private void newCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCheckboxActionPerformed
        try {
            if ((newCheckbox.isSelected()) && (oldCheckBox.isSelected() == false)) {
                Long id = new Long(1);
                Float bookCountForCase = bookService.getCount(6, id);
                if (bookCountForCase != null) {
                    bookCountForBookCaseTxt.setText(String.valueOf(Math.round(bookCountForCase)));

                } else {
                    bookCountForBookCaseTxt.setText("0");
                }
            } else if ((newCheckbox.isSelected() == false) && (oldCheckBox.isSelected())) {
                Long id = new Long(2);
                Float bookCountForCase = bookService.getCount(6, id);
                if (bookCountForCase != null) {
                    bookCountForBookCaseTxt.setText(String.valueOf(Math.round(bookCountForCase)));
                } else {
                    bookCountForBookCaseTxt.setText("0");
                }
            } else if (newCheckbox.isSelected() && oldCheckBox.isSelected()) {
                bookCountForBookCaseTxt.setText(String.valueOf(Math.round(bookService.getCount(1, null))));
            } else if (newCheckbox.isSelected() == false && oldCheckBox.isSelected() == false) {
                bookCountForBookCaseTxt.setText("0");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_newCheckboxActionPerformed

    private void languageCountTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageCountTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_languageCountTxtActionPerformed

    private void languageComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_languageComboItemStateChanged
        if (languageCombo.getSelectedIndex() > 0) {
            Item languageItem = (Item) languageCombo.getSelectedItem();
            Long id = languageItem.getId();
            if (evt.getStateChange() == 1) {
                buttonGroup.clearSelection();
                try {
                    Float bookCountForLanguage = bookService.getCount(4, id);
                    if (bookCountForLanguage != null) {
                        bookCountForLanguageTxt.setText(String.valueOf(Math.round(bookCountForLanguage)));
                    } else {
                        bookCountForLanguageTxt.setText("0");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (languageCombo.getSelectedIndex() == 0) {
            newRadio.setSelected(false);
            oldRadio.setSelected(false);
            bookCountForLanguageTxt.setText("0");
        }
    }//GEN-LAST:event_languageComboItemStateChanged

    private void authorCountTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorCountTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_authorCountTxtActionPerformed

    private void seachTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seachTxtKeyReleased
        a = seachTxt.getText();
        comboFilter(a);
    }//GEN-LAST:event_seachTxtKeyReleased

    private void seachTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seachTxtKeyPressed
        a = seachTxt.getText();
        comboFilter(a);
    }//GEN-LAST:event_seachTxtKeyPressed

    private void seachTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seachTxtActionPerformed
        a = seachTxt.getText();
        comboFilter(a);
    }//GEN-LAST:event_seachTxtActionPerformed

    private void seachTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seachTxtMouseClicked
        a = seachTxt.getText();
        comboFilter(a);
        if (evt.getClickCount() == 2) {
            seachTxt.setText("");
        }
    }//GEN-LAST:event_seachTxtMouseClicked

    private void bookCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookCountActionPerformed

    private void subjectComboForBookCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectComboForBookCountActionPerformed

    }//GEN-LAST:event_subjectComboForBookCountActionPerformed

    private void subjectComboForBookCountItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_subjectComboForBookCountItemStateChanged
        if (evt.getStateChange() == 1) {
            if (!subjectComboForBookCount.getSelectedItem().equals("Select Subject")) {
                Item itemBookSubject = (Item) subjectComboForBookCount.getSelectedItem();
                Long id = itemBookSubject.getId();
                try {
                    Float resulBook = bookService.getCount(2, id);
                    if (resulBook != null) {
                        bookCount.setText(String.valueOf(Math.round(resulBook)));
                    } else {
                        bookCount.setText("0");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                bookCount.setText("0");
            }
        }
    }//GEN-LAST:event_subjectComboForBookCountItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        BookItemFrame bookInfoFrame = new BookItemFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        bookInfoFrame.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        BookFrame bookFrame = new BookFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        bookFrame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bookCountForLanguageTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookCountForLanguageTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookCountForLanguageTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField allBookTxt;
    private javax.swing.JTextField authorCountTxt;
    private javax.swing.JTextField bookCount;
    private javax.swing.JTextField bookCountForBookCaseTxt;
    private javax.swing.JTextField bookCountForLanguageTxt;
    private javax.swing.JTextField chairCountSumTxt;
    private javax.swing.JComboBox<String> computerCountForFloorCmb;
    private javax.swing.JTextField computerCountTxt;
    private javax.swing.JComboBox<String> floorForReadRoomCountCmb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> languageCombo;
    private javax.swing.JTextField languageCountTxt;
    private javax.swing.JComboBox<String> libFloorCombo;
    private javax.swing.JComboBox<String> libFloorCombo1;
    private javax.swing.JComboBox<String> libFloorForReadRoomCombo;
    private javax.swing.JComboBox<String> libFloorForshelCmb;
    private javax.swing.JButton minimizeBtn1;
    private javax.swing.JCheckBox newCheckbox;
    private javax.swing.JRadioButton newRadio;
    private javax.swing.JCheckBox oldCheckBox;
    private javax.swing.JRadioButton oldRadio;
    private javax.swing.JTextField readRoomCountTxt;
    private javax.swing.JTextField readTableCountTxt;
    private javax.swing.JButton restoreBtn1;
    private javax.swing.JTextField roomCountTxt;
    private javax.swing.JComboBox<String> roomNumberCombo;
    private javax.swing.JComboBox<String> roomNumberCombo1;
    private javax.swing.JComboBox<String> roomNumberForComputerCmb;
    private javax.swing.JComboBox<String> roomNumberForShelfCmb;
    private javax.swing.JTextField seachTxt;
    private javax.swing.JTextField shelfCountTxt;
    private javax.swing.JComboBox<String> subjectComboForBookCount;
    private javax.swing.JTextField userTxt;
    private javax.swing.JRadioButton withCompRadio;
    private javax.swing.JRadioButton withoutComRadio;
    // End of variables declaration//GEN-END:variables

//    private void showSubjectCombo() {
//
//        try {
//            DefaultComboBoxModel model = (DefaultComboBoxModel) subjectComboForBookCount.getModel();
//            List<Subjects> getSubjectList = subjectService.getSubjectList();
//            for (Subjects subjects : getSubjectList) {
//
//                model.addElement(new Item(subjects.getId(), subjects.getSubjectName()));
//
//            }
//            model.setSelectedItem("");
////            model.addElement(new Item((long) 0, " All Employee avg Salary"));
//            AutoCompleteDecorator.decorate(subjectComboForBookCount, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }// herflere gore 
    public void comboFilter(String enteredText) {
        try {
            if (!subjectComboForBookCount.isPopupVisible()) {
                subjectComboForBookCount.showPopup();
            }
            DefaultComboBoxModel model = (DefaultComboBoxModel) subjectComboForBookCount.getModel();
            List<Item> filterArray = new ArrayList<>();
            List<Subjects> getSubjectList = subjectService.getSubjectList();
            for (Subjects subjects : getSubjectList) {
                if (subjects.getSubjectName().toLowerCase().contains(enteredText.toLowerCase())) {
                    filterArray.add(new Item(subjects.getId(), subjects.getSubjectName()));
                }
                if (filterArray.size() > 0) {
                    model.removeAllElements();
                    for (Item item : filterArray) {
                        model.addElement(new Item(item.getId(), item.getValue()));
                    }
                    JTextField textfield = (JTextField) subjectComboForBookCount.getEditor().getEditorComponent();
                    textfield.setText(enteredText);

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showSubjectComboForBookCount() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) subjectComboForBookCount.getModel();
            List<Subjects> getSubjectList = subjectService.getSubjectList();
            model.removeAllElements();
            model.addElement("Select Subject");
            for (Subjects subjects : getSubjectList) {
                model.addElement(new Item(subjects.getId(), subjects.getSubjectName()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showLanguageCombo() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) languageCombo.getModel();
            List<Language> getLanguageList = languageService.getLanguageList();
            for (Language language : getLanguageList) {

                model.addElement(new Item(language.getId(), language.getBookLanguage()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showRoomnumberForFloor(int floor) {
        try {
            DefaultComboBoxModel model = new DefaultComboBoxModel<>();
            List<ReadRoom> getRoomNumber = readRoomService.getReadRoomByRoomFloor(floor);
            model.addElement(new Item((long) 0, "Select Room Number"));
            for (ReadRoom readRoom : getRoomNumber) {
                model.addElement(new Item(readRoom.getId(), readRoom.getReadRoomNumber()));
            }
            roomNumberCombo.setModel(model);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showRoomnumberForFloorForReadTable(int floor) {
        try {
            DefaultComboBoxModel model = new DefaultComboBoxModel<>();
            List<ReadRoom> getRoomNumber = readRoomService.getReadRoomByRoomFloor(floor);
            model.addElement(new Item((long) 0, "Select Room Number"));
            for (ReadRoom readRoom : getRoomNumber) {
                model.addElement(new Item(readRoom.getId(), readRoom.getReadRoomNumber()));
            }
            roomNumberCombo1.setModel(model);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showRoomnumberForShelf(int floor) {
        try {
            DefaultComboBoxModel model = new DefaultComboBoxModel<>();
            List<BookRoom> getRoomNumber = bookRoomService.getRoomNumburForFloor(floor);
            model.addElement(new Item((long) 0, "Select Room Number"));
            for (BookRoom bookRoom : getRoomNumber) {

                model.addElement(new Item(bookRoom.getId(), bookRoom.getNumber()));
            }
            roomNumberForShelfCmb.setModel(model);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showRoomnumberForComputer(int floor) {
        try {
            DefaultComboBoxModel model = new DefaultComboBoxModel<>();
            List<ReadRoom> getRoomNumber = readRoomService.getReadRoomByRoomFloor(floor);
            model.addElement(new Item((long) 0, "Select Room Number"));
            for (ReadRoom readRoom : getRoomNumber) {

                model.addElement(new Item(readRoom.getId(), readRoom.getReadRoomNumber()));
            }
            roomNumberForComputerCmb.setModel(model);
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
