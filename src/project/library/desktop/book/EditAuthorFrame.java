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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import project.library.desktop.Desktop_Gui.Item;
import project.library.desktop.model.*;

import project.library.desktop.service.*;

/**
 *
 * @ Ulviyye Ibrahimli
 */
public class EditAuthorFrame extends javax.swing.JFrame {

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
    DefaultListModel<Item> models;
    DefaultListModel<Item> model;
    String keyword = "";
    ButtonGroup buttonGroup = new ButtonGroup();
    boolean addCheck = true;
    boolean deleteCheck = true;
    boolean addCheck2 = true;
    boolean deleteCheck2 = true;

    public EditAuthorFrame() {
        initComponents();
    }

    EditAuthorFrame(DepartmentService departmentService,
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
            this.selectedId = selectedId;
            this.login = login;
            initComponents();
            this.setDefaultLookAndFeelDecorated(true);
            this.pack();
            this.setLocationRelativeTo(null);
            userTxt.setText("Welcome, " + login.getFirstName() + " " + login.getLastName() + " !");
            buttonGroup.add(maleRadio);
            buttonGroup.add(femaleRadio);
            bookCombo.setRenderer(new EditAuthorFrame.TwoDecimalRenderer(bookCombo.getRenderer()));
            subjectCombo.setRenderer(new EditAuthorFrame.TwoDecimalRenderer(subjectCombo.getRenderer()));
            this.getContentPane().setBackground(Color.BLUE.darker().darker());
            nationalityCombo.setRenderer(new EditAuthorFrame.TwoDecimalRenderer(nationalityCombo.getRenderer()));
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.darker().darker());
            model = new DefaultListModel<>();
            models = new DefaultListModel<>();
            Author author = authorService.getAuthorById(selectedId);
            jLabel1.setText("UPDATE --> " + author.getFirstName().toUpperCase() + " " + author.getLastName().toUpperCase());
            lists();
            bookCombo(selectedId);
            subjectCombo(selectedId);
            showSubjectList();
            showOldData(author);
            showNationalityOld(author);
            hideInfoTxt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backBtn1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        clearBtn = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
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
        bookInfotxt = new javax.swing.JTextField();
        bookCombo = new javax.swing.JComboBox<>();
        deleteBookBtn = new javax.swing.JButton();
        addBookBtn = new javax.swing.JButton();
        subjectCombo = new javax.swing.JComboBox<>();
        addSubjectBtn = new javax.swing.JButton();
        deleteSubjectBtn = new javax.swing.JButton();
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
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        restoreBtn1 = new javax.swing.JButton();
        minimizeBtn1 = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        userTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 102));
        setUndecorated(true);

        backBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-undo-24.png"))); // NOI18N
        backBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Update Author");

        clearBtn.setBackground(new java.awt.Color(0, 0, 102));
        clearBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 0, 0));
        clearBtn.setText("Clear");
        clearBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255)));
        clearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        jTabbedPane1.setForeground(new java.awt.Color(153, 0, 0));

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

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
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        noteTxt.setColumns(20);
        noteTxt.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        noteTxt.setForeground(new java.awt.Color(0, 0, 102));
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
        rewardTxt.setForeground(new java.awt.Color(0, 0, 102));
        rewardTxt.setRows(5);
        jScrollPane2.setViewportView(rewardTxt);

        jLabel12.setBackground(new java.awt.Color(0, 0, 102));
        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Books");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        listBook.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        listBook.setForeground(new java.awt.Color(0, 0, 102));
        listBook.setSelectionBackground(new java.awt.Color(0, 0, 102));
        listBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listBookMouseClicked(evt);
            }
        });
        listBook.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listBookValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(listBook);

        listSubject.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 102)));
        listSubject.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        listSubject.setForeground(new java.awt.Color(0, 0, 102));
        listSubject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listSubject.setSelectionBackground(new java.awt.Color(0, 0, 102));
        listSubject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listSubjectMouseClicked(evt);
            }
        });
        listSubject.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listSubjectValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(listSubject);

        subjectInfoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectInfoTxtActionPerformed(evt);
            }
        });

        bookCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bookCombo.setForeground(new java.awt.Color(0, 0, 102));
        bookCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookComboActionPerformed(evt);
            }
        });

        deleteBookBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deleteBookBtn.setForeground(new java.awt.Color(0, 0, 102));
        deleteBookBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/book (2).png"))); // NOI18N
        deleteBookBtn.setText("-");
        deleteBookBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        deleteBookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBookBtnActionPerformed(evt);
            }
        });

        addBookBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addBookBtn.setForeground(new java.awt.Color(0, 0, 102));
        addBookBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/add (1).png"))); // NOI18N
        addBookBtn.setText("+");
        addBookBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        addBookBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookBtnActionPerformed(evt);
            }
        });

        subjectCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        subjectCombo.setForeground(new java.awt.Color(0, 0, 102));

        addSubjectBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addSubjectBtn.setForeground(new java.awt.Color(0, 0, 102));
        addSubjectBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/add (1).png"))); // NOI18N
        addSubjectBtn.setText("+");
        addSubjectBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        addSubjectBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addSubjectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSubjectBtnActionPerformed(evt);
            }
        });

        deleteSubjectBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deleteSubjectBtn.setForeground(new java.awt.Color(0, 0, 102));
        deleteSubjectBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/book (2).png"))); // NOI18N
        deleteSubjectBtn.setText("-");
        deleteSubjectBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        deleteSubjectBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteSubjectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSubjectBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subjectInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookInfotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(addSubjectBtn)
                                .addGap(0, 0, 0)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(deleteSubjectBtn)
                                        .addGap(125, 125, 125))
                                    .addComponent(subjectCombo, 0, 219, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(addBookBtn)
                                .addGap(0, 0, 0)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(deleteBookBtn)
                                        .addGap(125, 125, 125))
                                    .addComponent(bookCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookInfotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addBookBtn)
                                    .addComponent(bookCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addComponent(deleteBookBtn))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addSubjectBtn)
                            .addComponent(subjectCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(deleteSubjectBtn))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(subjectInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );

        jTabbedPane1.addTab("Page 2", jPanel3);

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(0, 0, 102));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("First Name");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        firstNameTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        firstNameTxt.setForeground(new java.awt.Color(0, 0, 102));
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
        lastNameTxt.setForeground(new java.awt.Color(0, 0, 102));
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

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Last Name");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        fatherNameTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        fatherNameTxt.setForeground(new java.awt.Color(0, 0, 102));
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

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Father Name");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Gender");
        jLabel5.setToolTipText("");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        maleRadio.setBackground(new java.awt.Color(0, 0, 102));
        maleRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        maleRadio.setForeground(new java.awt.Color(255, 255, 255));
        maleRadio.setText("Male");
        maleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioActionPerformed(evt);
            }
        });

        femaleRadio.setBackground(new java.awt.Color(0, 0, 102));
        femaleRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        femaleRadio.setForeground(new java.awt.Color(255, 255, 255));
        femaleRadio.setText("Female");
        femaleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Day of Birth");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        dobCalendar.setForeground(new java.awt.Color(0, 0, 102));

        deadCalendar.setBackground(new java.awt.Color(255, 255, 255));
        deadCalendar.setForeground(new java.awt.Color(0, 0, 102));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Day of Dead");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Nationality");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        searchNationalityTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        searchNationalityTxt.setForeground(new java.awt.Color(0, 0, 204));
        searchNationalityTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchNationalityTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchNationalityTxtMouseEntered(evt);
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

        nationalityCombo.setBackground(new java.awt.Color(204, 204, 255));
        nationalityCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nationalityCombo.setForeground(new java.awt.Color(0, 0, 102));

        lnameInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lnameInfoTxt.setForeground(new java.awt.Color(51, 0, 51));

        fatherNameInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        fatherNameInfoTxt.setForeground(new java.awt.Color(51, 0, 51));

        genderInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        genderInfoTxt.setForeground(new java.awt.Color(51, 0, 51));

        fnameInfoTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        fnameInfoTxt.setForeground(new java.awt.Color(51, 0, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fnameInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lnameInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fatherNameInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genderInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameTxt)
                            .addComponent(lastNameTxt)
                            .addComponent(fatherNameTxt)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(499, 499, 499)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(maleRadio)
                                .addGap(94, 94, 94)
                                .addComponent(femaleRadio))
                            .addComponent(searchNationalityTxt)
                            .addComponent(nationalityCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dobCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deadCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(54, 54, 54))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fnameInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lnameInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fatherNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fatherNameInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(femaleRadio)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genderInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maleRadio))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(dobCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deadCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(searchNationalityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(nationalityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Page 1", jPanel2);

        jButton3.setBackground(new java.awt.Color(0, 0, 102));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setText("Cancel");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255)));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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

        saveBtn.setBackground(new java.awt.Color(0, 0, 102));
        saveBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save");
        saveBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255), new java.awt.Color(102, 204, 255)));
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        userTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        userTxt.setForeground(new java.awt.Color(0, 0, 255));
        userTxt.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(minimizeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restoreBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimizeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn1ActionPerformed
        this.dispose();
        BookItemFrame bookItemFrame = new BookItemFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        bookItemFrame.setVisible(true);
    }//GEN-LAST:event_backBtn1ActionPerformed

    private void firstNameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstNameTxtMouseClicked
        fnameInfoTxt.setVisible(false);
        firstNameTxt.setForeground(Color.BLUE.darker());
    }//GEN-LAST:event_firstNameTxtMouseClicked

    private void firstNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTxtActionPerformed
        fnameInfoTxt.setVisible(false);
        firstNameTxt.setForeground(Color.BLUE.darker());
    }//GEN-LAST:event_firstNameTxtActionPerformed

    private void firstNameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstNameTxtKeyPressed
        fnameInfoTxt.setVisible(false);
        firstNameTxt.setForeground(Color.BLUE.darker());
    }//GEN-LAST:event_firstNameTxtKeyPressed

    private void lastNameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastNameTxtMouseClicked
        lnameInfoTxt.setVisible(false);
        lastNameTxt.setForeground(Color.BLUE.darker());
    }//GEN-LAST:event_lastNameTxtMouseClicked

    private void lastNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTxtActionPerformed
        lnameInfoTxt.setVisible(false);
        lastNameTxt.setForeground(Color.BLUE.darker());
    }//GEN-LAST:event_lastNameTxtActionPerformed

    private void lastNameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastNameTxtKeyPressed
        lnameInfoTxt.setVisible(false);
        lastNameTxt.setForeground(Color.BLUE.darker());
    }//GEN-LAST:event_lastNameTxtKeyPressed

    private void fatherNameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fatherNameTxtMouseClicked
        fatherNameInfoTxt.setVisible(false);
        fatherNameTxt.setForeground(Color.BLUE.darker());
    }//GEN-LAST:event_fatherNameTxtMouseClicked

    private void fatherNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fatherNameTxtActionPerformed
        fatherNameInfoTxt.setVisible(false);
        fatherNameTxt.setForeground(Color.BLUE.darker());
    }//GEN-LAST:event_fatherNameTxtActionPerformed

    private void fatherNameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fatherNameTxtKeyPressed
        fatherNameInfoTxt.setVisible(false);
        fatherNameTxt.setForeground(Color.BLUE.darker());
    }//GEN-LAST:event_fatherNameTxtKeyPressed

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

    private void searchNationalityTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchNationalityTxtMouseClicked
        keyword = searchNationalityTxt.getText();
        showNationality(keyword);
        nationalityCombo.setVisible(true);
    }//GEN-LAST:event_searchNationalityTxtMouseClicked

    private void searchNationalityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchNationalityTxtActionPerformed
        keyword = searchNationalityTxt.getText();
        showNationality(keyword);
        nationalityCombo.setVisible(true);
    }//GEN-LAST:event_searchNationalityTxtActionPerformed

    private void searchNationalityTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchNationalityTxtKeyPressed
        keyword = searchNationalityTxt.getText();
        showNationality(keyword);
        nationalityCombo.setVisible(true);
    }//GEN-LAST:event_searchNationalityTxtKeyPressed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            String gender = "";
            String nationality = "";
            String fName = firstNameTxt.getText();
            if ((fName.trim().length() >= 3) && (fName.trim().length() <= 50) && (!fName.isEmpty())) {
                if (fName.matches("[\\p{L}\\s\\.]+")) {
                    String lName = lastNameTxt.getText();
                    if ((lName.length() >= 3) && (lName.trim().length() <= 50) && (!lName.isEmpty())) {
                        if (lName.matches("[\\p{L}\\s\\.]+")) {
                            String fatherName = fatherNameTxt.getText();
                            if ((fatherName.trim().length() >= 3) && (fatherName.trim().length() <= 50) && (!fatherName.isEmpty())) {
                                if (fatherName.matches("[\\p{L}\\s\\.]+")) {
                                    if (femaleRadio.isSelected()) {
                                        gender = "Female";
                                    } else if (maleRadio.isSelected()) {
                                        gender = "Male";
                                        if (!nationalityCombo.getSelectedItem().equals("Select Nationality")) {
                                            nationality = (String) nationalityCombo.getSelectedItem();
                                        } else {
                                            nationality = null;
                                        }
                                        Date dob = dobCalendar.getDate();
                                        Date daedDate = deadCalendar.getDate();
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
                                        List<Author> subjects = authorService.subjectofAuthor(selectedId);
                                        boolean con = false;
                                        for (Author subject : subjects) {
                                            if (subject.getSubjects().getId() != null) {
                                                con = true;
                                            }
                                        }
                                        if (con) {
                                            List< Author> sub = authorService.getSubjectByAuthor(selectedId);
                                            boolean isUpdateAuthor = authorService.updateAuthor(selectedId, author);
                                            if (addCheck == true && deleteCheck == true && addCheck2 == true && deleteCheck2 == true && isUpdateAuthor == true) {
                                                JOptionPane.showMessageDialog(null, fName.toUpperCase() + " " + lName.toUpperCase() + " - IS UPDATE SUCCESSFULLY ", "SUCCESS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\LibraryDesktopProject\\src\\project\\library\\desktop\\gui\\icon\\tick.png"));
                                            } else {
                                                JOptionPane.showMessageDialog(null, fName.toUpperCase() + " " + lName.toUpperCase() + "  IS NOT ADDRED", "FAIL", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\LibraryDesktopProject\\src\\project\\library\\desktop\\gui\\icon\\report.png"));
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Add Subject");
                                        }
                                    } else {
                                        genderInfoTxt.setVisible(true);
                                        genderInfoTxt.setText("Select  Gender");
                                    }
                                } else {
                                    lnameInfoTxt.setVisible(true);
                                    lnameInfoTxt.setText("Uncorrect Last Name");
                                    lastNameTxt.setForeground(Color.red);
                                }
                            } else {
                                fatherNameInfoTxt.setVisible(true);
                                fatherNameInfoTxt.setText("Greater than 3, less than 50");
                                fatherNameTxt.setForeground(Color.red);
                            }
                        } else {
                            fatherNameInfoTxt.setVisible(true);
                            fatherNameInfoTxt.setText("Uncorrect Last Name");
                            fatherNameTxt.setForeground(Color.red);
                        }
                    } else {
                        lnameInfoTxt.setVisible(true);
                        lnameInfoTxt.setText("Greater than 3 less than 50");
                        lastNameTxt.setForeground(Color.red);
                    }

                } else {
                    fnameInfoTxt.setVisible(true);
                    fnameInfoTxt.setText("Uncorrect  name");
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int closeChoose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE, TO CLOSE THE PROGRAM?");
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

    private void listBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listBookMouseClicked


    }//GEN-LAST:event_listBookMouseClicked

    private void listBookValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listBookValueChanged
        List<Item> getSelected = listBook.getSelectedValuesList();
        String result = "";

        for (Item item : getSelected) {
            result += item.toString() + "\n";
        }


    }//GEN-LAST:event_listBookValueChanged

    private void listSubjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSubjectMouseClicked

    }//GEN-LAST:event_listSubjectMouseClicked

    private void listSubjectValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listSubjectValueChanged
        List<Item> subjects = listSubject.getSelectedValuesList();
        String result = "";
        for (Item subject : subjects) {
            result += subject.getValue() + "\n";
        }

    }//GEN-LAST:event_listSubjectValueChanged

    private void deleteBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookBtnActionPerformed
        if (bookCombo.getSelectedIndex() > 0) {
            Item id = (Item) bookCombo.getSelectedItem();
            try {
                boolean isDeleteBook = authorService.deleteBookOfAuthor(selectedId, id.getId());
                if (isDeleteBook) {
                    deleteCheck = true;
                    bookComboAfterAdd(selectedId);
                } else {
                    deleteCheck = false;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            bookInfotxt.setText("Select Book!");
        }
    }//GEN-LAST:event_deleteBookBtnActionPerformed

    private void addBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookBtnActionPerformed
        try {
            if (listBook.getSelectedIndex() > 0) {
                List<Item> books = listBook.getSelectedValuesList();
                for (Item book : books) {
                    boolean check = checkBooks(book.getId());
                    if (check) {
                        boolean isAddBook = authorService.addAuthorBook(selectedId, book.getId());
                        if (isAddBook) {
                            addCheck = true;
                            bookComboAfterAdd(selectedId);
                            System.out.println("Book Added");
                        } else {
                            addCheck = false;
                            System.out.println("Book do not added!");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "THIS BOOK HAS BEEN ADDED !");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_addBookBtnActionPerformed

    private void addSubjectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSubjectBtnActionPerformed
        try {
            if (listSubject.getSelectedIndex() > 0) {
                List<Item> subjects = listSubject.getSelectedValuesList();
                for (Item subject : subjects) {
                    boolean check = checkSubject(subject.getId());
                    if (check) {
                        boolean isAddSubject = authorService.addListSubject(selectedId, subject.getId());
                        if (isAddSubject) {
                            System.out.println("subject added");
                            subjectComboAfterAdd(selectedId);
                            addCheck2 = true;
                        } else {
                            addCheck2 = false;
                            System.out.println("Subject do not added! ");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "THIS SUBJECT HAS BEEN ADDED !");
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_addSubjectBtnActionPerformed

    private void deleteSubjectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSubjectBtnActionPerformed
        try {
            if (subjectCombo.getSelectedIndex() > 0) {
                Item id = (Item) subjectCombo.getSelectedItem();
                boolean isDeleteBook = authorService.deleteSubject(selectedId, id.getId());
                if (isDeleteBook) {
                    deleteCheck2 = true;
                    subjectComboAfterAdd(selectedId);
                } else {
                    deleteCheck2 = false;
                }
            } else {
                subjectInfoTxt.setText("Select Subject!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteSubjectBtnActionPerformed

    private void subjectInfoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectInfoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectInfoTxtActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        BookItemFrame bookItemFrame = new BookItemFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        bookItemFrame.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        if (jPanel2.isShowing()) {
            fatherNameInfoTxt.setVisible(false);
            fnameInfoTxt.setVisible(false);
            lnameInfoTxt.setVisible(false);
            genderInfoTxt.setVisible(false);
            firstNameTxt.setText("");
            lastNameTxt.setText("");
            fatherNameTxt.setText("");
            maleRadio.setSelected(false);
            femaleRadio.setSelected(false);
            nationalityCombo.setSelectedIndex(-1);
            searchNationalityTxt.setText("");
            dobCalendar.setDate(null);
        } else if (jPanel3.isShowing()) {
            bookInfotxt.setVisible(false);
            subjectInfoTxt.setVisible(false);
            rewardTxt.setText("");
            noteTxt.setText("");
        }
    }//GEN-LAST:event_clearBtnActionPerformed

    private void bookComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookComboActionPerformed

    private void searchNationalityTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchNationalityTxtKeyReleased
        keyword = searchNationalityTxt.getText();
        showNationality(keyword);
        nationalityCombo.setVisible(true);
    }//GEN-LAST:event_searchNationalityTxtKeyReleased

    private void searchNationalityTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchNationalityTxtMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_searchNationalityTxtMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBookBtn;
    private javax.swing.JButton addSubjectBtn;
    private javax.swing.JButton backBtn1;
    private javax.swing.JComboBox<String> bookCombo;
    private javax.swing.JTextField bookInfotxt;
    private javax.swing.JButton clearBtn;
    private com.toedter.calendar.JDateChooser deadCalendar;
    private javax.swing.JButton deleteBookBtn;
    private javax.swing.JButton deleteSubjectBtn;
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
    private javax.swing.JButton minimizeBtn1;
    private javax.swing.JComboBox<String> nationalityCombo;
    private javax.swing.JTextArea noteTxt;
    private javax.swing.JButton restoreBtn1;
    private javax.swing.JTextArea rewardTxt;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField searchNationalityTxt;
    private javax.swing.JComboBox<String> subjectCombo;
    private javax.swing.JTextField subjectInfoTxt;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables

    void showNationalityOld(Author author) {
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
        if (author.getNationality() != null) {
            model.setSelectedItem(author.getNationality());
            for (String nat : nationality) {
                model.addElement(nat);
            }
        } else {
            model.addElement("Select Nationality");
            for (String string : nationality) {
                model.addElement(string);
            }
        }

    }

    void showNationality(String keyword) {
        List<String> filterList = new ArrayList<>();
        String nationalities[] = {"Afghans", "Albanians", "Algerians", "Americans", "Andorrans",
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
        for (String count : nationalities) {
            if (count.toLowerCase().contains(keyword.toLowerCase())) {
                filterList.add(count);
            }
            if (filterList.size() > 0) {
                DefaultComboBoxModel model = (DefaultComboBoxModel) nationalityCombo.getModel();
                model.removeAllElements();
                for (String fil : filterList) {
                    model.addElement(fil);
                }

            }
            JTextField textfield = (JTextField) nationalityCombo.getEditor().getEditorComponent();
            textfield.setText(keyword);
        }
    }

    private List<Subjects> showSubjectList() {
        List<Subjects> subjectList = new ArrayList<>();
        try {
            subjectList = subjectService.getSubjectList();
            models.addElement(new Item((long) 0, "All Subjects Lists"));
            for (Subjects s : subjectList) {
                models.addElement(new Item(s.getId(), s.getSubjectName()));
            }
            listSubject.setModel(models);
            listSubject.setBackground(Color.WHITE);
            listSubject.setForeground(Color.BLUE.darker().darker());
            listSubject.setSelectedIndex(0);
            listSubject.setSelectionBackground(Color.BLUE.darker().darker());
            listSubject.setSelectionForeground(Color.WHITE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return subjectList;

    }

    void lists() {
        try {
            List<Book> booklist = bookService.getBookWhichNotAuthor();
            model.addElement(new Item((long) 0, "All Books Lists"));
            for (Book book : booklist) {
                model.addElement(new Item(book.getId(), book.getIsbn() + "\\" + book.getTitle()));
            }
            listBook.setModel(model);
            listBook.setBackground(Color.WHITE);
            listBook.setForeground(Color.BLUE.darker().darker());
            listBook.setSelectedIndex(0);
            listBook.setSelectionBackground(Color.BLUE.darker().darker());
            listBook.setSelectionForeground(Color.WHITE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void hideInfoTxt() {
        fnameInfoTxt.setVisible(false);
        lnameInfoTxt.setVisible(false);
        fatherNameInfoTxt.setVisible(false);
        genderInfoTxt.setVisible(false);
        bookInfotxt.setVisible(false);
        subjectInfoTxt.setVisible(false);
    }

    void showOldData(Author author) {
        firstNameTxt.setText(author.getFirstName());
        lastNameTxt.setText(author.getLastName());
        fatherNameTxt.setText(author.getFatherName());
        if (author.getGender().equalsIgnoreCase("male")) {
            maleRadio.setSelected(true);
        } else if (author.getGender().equalsIgnoreCase("female")) {
            femaleRadio.setSelected(true);
        }
        dobCalendar.setDate(author.getDob());
        deadCalendar.setDate(author.getDeadDate());
        rewardTxt.setText(author.getReward());
        noteTxt.setText(author.getAuthorInfo());

    }

    List<Author> bookCombo(Long authorId) {
        List<Author> books = new ArrayList<>();
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) bookCombo.getModel();
            books = authorService.booksOfAuthor(authorId);
            model.addElement("Author Books old list");
            for (Author book : books) {
                model.addElement(new Item(book.getBook().getId(), book.getBook().getIsbn() + "\\" + book.getBook().getTitle()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return books;
    }

    List<Author> bookComboAfterAdd(Long authorId) {
        List<Author> books = new ArrayList<>();
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) bookCombo.getModel();
            books = authorService.booksOfAuthor(authorId);
            model.removeAllElements();
            model.addElement("Author's Books list");
            for (Author book : books) {
                model.addElement(new Item(book.getBook().getId(), book.getBook().getIsbn() + "\\" + book.getBook().getTitle()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return books;
    }

    void subjectCombo(Long authorId) {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) subjectCombo.getModel();
            List<Author> subjects = authorService.subjectofAuthor(authorId);
            model.addElement("Subjects of Author");
            for (Author subject : subjects) {
                model.addElement(new Item(subject.getSubjects().getId(), subject.getSubjects().getSubjectName()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void subjectComboAfterAdd(Long authorId) {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) subjectCombo.getModel();
            List<Author> subjects = authorService.subjectofAuthor(authorId);
            model.removeAllElements();
            model.addElement("Subjects of Author");
            for (Author subject : subjects) {
                model.addElement(new Item(subject.getSubjects().getId(), subject.getSubjects().getSubjectName()));
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
                    c.setBackground(Color.BLUE.darker().darker());
                    c.setForeground(Color.WHITE);
                } else {
                    c.setBackground(Color.WHITE);
                }
            } else {
                c.setBackground(Color.WHITE);
                c = super.getListCellRendererComponent(list, value, index, isSelected,
                        cellHasFocus);
            }
            return c;
        }
    }

    boolean checkBooks(Long id) {
        boolean result = true;
        try {
            List<Long> books = authorService.getBookId(selectedId);
            for (Long book : books) {
                System.out.println("bgb  " + book);
                if (book == id) {
                    result = false;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    boolean checkSubject(Long id) {
        boolean result = true;
        try {
            List<Author> long1 = authorService.subjectofAuthor(selectedId);
            for (Author l : long1) {
                if (l.getSubjects().getId() == id) {
                    result = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
}
