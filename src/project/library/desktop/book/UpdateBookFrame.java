package project.library.desktop.book;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import project.library.desktop.Desktop_Gui.Item;
import project.library.desktop.model.Author;
import project.library.desktop.model.Book;
import project.library.desktop.model.BookCase;
import project.library.desktop.model.BookRoom;
import project.library.desktop.model.BookShelf;
import project.library.desktop.model.Language;
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

/**
 *
 * @ Ulviyye Ibrahimli
 */
public class UpdateBookFrame extends javax.swing.JFrame {

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
    DefaultListModel<Item> modelSubject;
    DefaultListModel<Item> modelAuthor;
    DefaultListModel<Item> modelOdSubject;
    DefaultListModel<Item> modelOldAuthor;
    String subjectSearch = "";
    String authorSearch = "";
    boolean isAddSubject = true;
    boolean isAddAuthor = true;
    boolean isDeleteAuthor = true;
    boolean isDeleteSubject = true;
    Long mf = null;
    Book oldBook = null;

    public UpdateBookFrame() {
        initComponents();
    }

    UpdateBookFrame(DepartmentService departmentService,
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
            modelSubject = new DefaultListModel<>();
            modelAuthor = new DefaultListModel<>();
            modelOdSubject = new DefaultListModel<>();
            modelOldAuthor = new DefaultListModel<>();
            this.setDefaultLookAndFeelDecorated(true);
            this.pack();
            this.setLocationRelativeTo(null);
            languageCombo.setRenderer(new UpdateBookFrame.TwoDecimalRenderer(languageCombo.getRenderer()));
            roomNumberCombo.setRenderer(new UpdateBookFrame.TwoDecimalRenderer(roomNumberCombo.getRenderer()));
            shelfNumberCombo.setRenderer(new UpdateBookFrame.TwoDecimalRenderer(shelfNumberCombo.getRenderer()));
            bookStarCombo.setRenderer(new UpdateBookFrame.TwoDecimalRenderer(bookStarCombo.getRenderer()));
            modelSubject = new DefaultListModel<>();
            modelAuthor = new DefaultListModel<>();
            minutesLable.setVisible(true);
            hideWarning();
            subjectAllList();
            authorAllList();
            userTxt.setText("Welcome, " + login.getFirstName() + " " + login.getLastName() + " !");
            oldBook = bookService.getBookById(selectedId);
            mf = oldBook.getBookShelf().getId();
            System.out.println("df " + mf);
            jLabel1.setText("UPDATE -->" + oldBook.getTitle().toUpperCase());
            oldSubject(selectedId);
            oldAuthor(selectedId);
            showOldDate(oldBook);
            languageCombo(oldBook);
            roomNumberCombo(oldBook);
            starCombo(oldBook);
            Item itemRoom = (Item) roomNumberCombo.getSelectedItem();
            Long roomId = itemRoom.getId();
            oldShelfNumber(roomId, oldBook);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        editionTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        limitTimeTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        limitDayTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        bookStarCombo = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        newRadio = new javax.swing.JRadioButton();
        oldRadio = new javax.swing.JRadioButton();
        limitTWTxt = new javax.swing.JTextField();
        limitDWTxt = new javax.swing.JTextField();
        bookStarWTxt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        minutesLable = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        abstractTxt = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        roomNumberCombo = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        shelfNumberCombo = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        subjectTxt = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        listSubject = new javax.swing.JList<>();
        jLabel19 = new javax.swing.JLabel();
        authorTxt = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        listAuthor = new javax.swing.JList<>();
        labelRoom = new javax.swing.JLabel();
        labelShelf = new javax.swing.JLabel();
        addSubjectBtn = new javax.swing.JButton();
        deleteSubjectBookBtn = new javax.swing.JButton();
        addAuthorBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        oldSubjectList = new javax.swing.JList<>();
        deleteAuthortBookBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        oldAuthorList = new javax.swing.JList<>();
        subjectWTxt = new javax.swing.JTextField();
        authorWtxt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        isbnTxt = new javax.swing.JTextField();
        titleTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        publisherTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pageTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        releaseDateCalendar = new com.toedter.calendar.JDateChooser();
        languageCombo = new javax.swing.JComboBox<>();
        isbnWTxt = new javax.swing.JTextField();
        titleWTxt = new javax.swing.JTextField();
        pageWTxt = new javax.swing.JTextField();
        languageWTxt = new javax.swing.JTextField();
        allCountBookTxt = new javax.swing.JTextField();
        allCountWTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        restoreBtn = new javax.swing.JButton();
        minimizeBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        userTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));

        editionTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        editionTxt.setForeground(new java.awt.Color(0, 0, 102));
        editionTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editionTxtMouseClicked(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(0, 0, 102));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Edition");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        jLabel9.setBackground(new java.awt.Color(0, 0, 102));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Book_Star");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        limitTimeTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        limitTimeTxt.setForeground(new java.awt.Color(0, 0, 102));
        limitTimeTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limitTimeTxtMouseClicked(evt);
            }
        });
        limitTimeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limitTimeTxtActionPerformed(evt);
            }
        });
        limitTimeTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                limitTimeTxtKeyPressed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(0, 0, 102));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Limit Time");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        limitDayTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        limitDayTxt.setForeground(new java.awt.Color(0, 0, 102));
        limitDayTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limitDayTxtMouseClicked(evt);
            }
        });
        limitDayTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limitDayTxtActionPerformed(evt);
            }
        });
        limitDayTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                limitDayTxtKeyPressed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(0, 0, 102));
        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Limit Day");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        bookStarCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bookStarCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bookStarCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bookStarComboItemStateChanged(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(0, 0, 102));
        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Case");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        newRadio.setBackground(new java.awt.Color(0, 0, 102));
        newRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        newRadio.setForeground(new java.awt.Color(204, 204, 255));
        newRadio.setText("New");
        newRadio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRadioActionPerformed(evt);
            }
        });

        oldRadio.setBackground(new java.awt.Color(0, 0, 102));
        oldRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        oldRadio.setForeground(new java.awt.Color(204, 204, 255));
        oldRadio.setText("Old");
        oldRadio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        oldRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldRadioActionPerformed(evt);
            }
        });

        limitTWTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        limitTWTxt.setForeground(new java.awt.Color(102, 0, 0));
        limitTWTxt.setEnabled(false);

        limitDWTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        limitDWTxt.setForeground(new java.awt.Color(102, 0, 0));
        limitDWTxt.setEnabled(false);

        bookStarWTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        bookStarWTxt.setForeground(new java.awt.Color(102, 0, 0));
        bookStarWTxt.setEnabled(false);

        jLabel14.setBackground(new java.awt.Color(0, 0, 102));
        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Abstract");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        minutesLable.setBackground(new java.awt.Color(51, 0, 51));
        minutesLable.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        minutesLable.setForeground(new java.awt.Color(204, 204, 255));
        minutesLable.setText("Add  Minutes");

        abstractTxt.setColumns(20);
        abstractTxt.setForeground(new java.awt.Color(0, 0, 102));
        abstractTxt.setRows(5);
        jScrollPane3.setViewportView(abstractTxt);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(minutesLable, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(limitTWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookStarWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(limitDWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(newRadio)
                        .addGap(56, 56, 56)
                        .addComponent(oldRadio)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bookStarCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                                .addComponent(limitDayTxt, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(limitTimeTxt)
                                .addComponent(editionTxt, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(23, 23, 23))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookStarWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(limitTWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookStarCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(limitTimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minutesLable)))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limitDWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limitDayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newRadio)
                    .addComponent(oldRadio))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );

        jTabbedPane1.addTab("Page 2", jPanel3);

        jPanel4.setBackground(new java.awt.Color(0, 0, 102));

        jLabel13.setBackground(new java.awt.Color(0, 0, 102));
        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Room Number");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        roomNumberCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        roomNumberCombo.setForeground(new java.awt.Color(0, 0, 102));
        roomNumberCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Room Number" }));
        roomNumberCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        roomNumberCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                roomNumberComboItemStateChanged(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(0, 0, 102));
        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Shelf Number");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        shelfNumberCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        shelfNumberCombo.setForeground(new java.awt.Color(0, 0, 102));
        shelfNumberCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Shelf Number" }));
        shelfNumberCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                shelfNumberComboItemStateChanged(evt);
            }
        });
        shelfNumberCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shelfNumberComboActionPerformed(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(0, 0, 102));
        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Subject");
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        subjectTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        subjectTxt.setForeground(new java.awt.Color(0, 0, 102));
        subjectTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subjectTxtMouseClicked(evt);
            }
        });
        subjectTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectTxtActionPerformed(evt);
            }
        });
        subjectTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                subjectTxtKeyPressed(evt);
            }
        });

        listSubject.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        listSubject.setForeground(new java.awt.Color(0, 0, 102));
        listSubject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listSubject.setSelectionBackground(new java.awt.Color(0, 0, 102));
        listSubject.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listSubjectValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(listSubject);

        jLabel19.setBackground(new java.awt.Color(0, 0, 102));
        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Author FullName");
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        authorTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        authorTxt.setForeground(new java.awt.Color(0, 0, 102));
        authorTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                authorTxtMouseClicked(evt);
            }
        });
        authorTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorTxtActionPerformed(evt);
            }
        });
        authorTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                authorTxtKeyPressed(evt);
            }
        });

        listAuthor.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        listAuthor.setForeground(new java.awt.Color(0, 0, 102));
        listAuthor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listAuthor.setSelectionBackground(new java.awt.Color(0, 0, 102));
        listAuthor.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listAuthorValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(listAuthor);

        labelRoom.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        labelRoom.setForeground(new java.awt.Color(204, 0, 0));
        labelRoom.setText("Select  Room");

        labelShelf.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        labelShelf.setForeground(new java.awt.Color(204, 0, 0));
        labelShelf.setText("Select Shelf");

        addSubjectBtn.setForeground(new java.awt.Color(0, 0, 102));
        addSubjectBtn.setText("+");
        addSubjectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSubjectBtnActionPerformed(evt);
            }
        });

        deleteSubjectBookBtn.setForeground(new java.awt.Color(102, 0, 0));
        deleteSubjectBookBtn.setText("-");
        deleteSubjectBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSubjectBookBtnActionPerformed(evt);
            }
        });

        addAuthorBtn.setForeground(new java.awt.Color(0, 0, 102));
        addAuthorBtn.setText("+");
        addAuthorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAuthorBtnActionPerformed(evt);
            }
        });

        oldSubjectList.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        oldSubjectList.setForeground(new java.awt.Color(102, 0, 0));
        oldSubjectList.setSelectionBackground(new java.awt.Color(102, 0, 0));
        jScrollPane1.setViewportView(oldSubjectList);

        deleteAuthortBookBtn.setForeground(new java.awt.Color(204, 0, 0));
        deleteAuthortBookBtn.setText("-");
        deleteAuthortBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAuthortBookBtnActionPerformed(evt);
            }
        });

        oldAuthorList.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        oldAuthorList.setForeground(new java.awt.Color(102, 0, 0));
        oldAuthorList.setSelectionBackground(new java.awt.Color(102, 0, 0));
        jScrollPane2.setViewportView(oldAuthorList);

        subjectWTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        subjectWTxt.setForeground(new java.awt.Color(102, 0, 0));
        subjectWTxt.setEnabled(false);
        subjectWTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectWTxtActionPerformed(evt);
            }
        });

        authorWtxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        authorWtxt.setForeground(new java.awt.Color(102, 0, 0));
        authorWtxt.setEnabled(false);
        authorWtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorWtxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(labelShelf, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(authorWtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(subjectWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(deleteAuthortBookBtn)
                            .addComponent(deleteSubjectBookBtn))
                        .addGap(4, 4, 4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(labelRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(shelfNumberCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addSubjectBtn)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(authorTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addComponent(addAuthorBtn)
                    .addComponent(roomNumberCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(subjectTxt))
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roomNumberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shelfNumberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelShelf)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(subjectTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addSubjectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteSubjectBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(subjectWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(authorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addAuthorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteAuthortBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(authorWtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Page 3", jPanel4);

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        jLabel2.setBackground(new java.awt.Color(0, 0, 102));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ISBN");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        isbnTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        isbnTxt.setForeground(new java.awt.Color(0, 0, 102));
        isbnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                isbnTxtMouseClicked(evt);
            }
        });
        isbnTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isbnTxtActionPerformed(evt);
            }
        });
        isbnTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                isbnTxtKeyPressed(evt);
            }
        });

        titleTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        titleTxt.setForeground(new java.awt.Color(0, 0, 102));
        titleTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                titleTxtMouseClicked(evt);
            }
        });
        titleTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleTxtActionPerformed(evt);
            }
        });
        titleTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                titleTxtKeyPressed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 102));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Title");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        publisherTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        publisherTxt.setForeground(new java.awt.Color(0, 0, 102));
        publisherTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                publisherTxtMouseClicked(evt);
            }
        });
        publisherTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publisherTxtActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 102));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Publisher");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        jLabel5.setBackground(new java.awt.Color(0, 0, 102));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Page");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        pageTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        pageTxt.setForeground(new java.awt.Color(0, 0, 102));
        pageTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pageTxtMouseClicked(evt);
            }
        });
        pageTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pageTxtActionPerformed(evt);
            }
        });
        pageTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pageTxtKeyPressed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 0, 102));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Language");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        jLabel7.setBackground(new java.awt.Color(0, 0, 102));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Release Date");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        releaseDateCalendar.setForeground(new java.awt.Color(51, 0, 51));
        releaseDateCalendar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        languageCombo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        languageCombo.setForeground(new java.awt.Color(0, 0, 102));
        languageCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Language" }));
        languageCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        languageCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                languageComboItemStateChanged(evt);
            }
        });
        languageCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languageComboActionPerformed(evt);
            }
        });

        isbnWTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        isbnWTxt.setForeground(new java.awt.Color(102, 0, 0));
        isbnWTxt.setEnabled(false);

        titleWTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        titleWTxt.setForeground(new java.awt.Color(102, 0, 0));
        titleWTxt.setEnabled(false);

        pageWTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        pageWTxt.setForeground(new java.awt.Color(102, 0, 0));
        pageWTxt.setEnabled(false);

        languageWTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        languageWTxt.setForeground(new java.awt.Color(102, 0, 0));
        languageWTxt.setEnabled(false);

        allCountBookTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        allCountBookTxt.setForeground(new java.awt.Color(0, 0, 102));
        allCountBookTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allCountBookTxtMouseClicked(evt);
            }
        });
        allCountBookTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allCountBookTxtActionPerformed(evt);
            }
        });
        allCountBookTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                allCountBookTxtKeyPressed(evt);
            }
        });

        allCountWTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        allCountWTxt.setForeground(new java.awt.Color(102, 0, 0));
        allCountWTxt.setEnabled(false);
        allCountWTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allCountWTxtActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(0, 0, 102));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("All Count");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(424, 424, 424)
                        .addComponent(releaseDateCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(languageCombo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(27, 27, 27)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(pageWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(84, 84, 84)
                                            .addComponent(pageTxt))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(allCountWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(languageWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(titleWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(isbnWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(77, 77, 77)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(allCountBookTxt)
                                                .addComponent(titleTxt)
                                                .addComponent(isbnTxt, javax.swing.GroupLayout.Alignment.TRAILING)))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(245, 245, 245)
                                    .addComponent(publisherTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(50, 50, 50))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isbnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isbnWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(publisherTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pageWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(languageWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(languageCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(releaseDateCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(allCountWTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(allCountBookTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Page 1", jPanel2);

        jLabel1.setBackground(new java.awt.Color(51, 0, 51));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Update  Book");

        saveBtn.setBackground(new java.awt.Color(0, 0, 102));
        saveBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save");
        saveBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        restoreBtn.setBackground(new java.awt.Color(51, 102, 255));
        restoreBtn.setForeground(new java.awt.Color(255, 255, 255));
        restoreBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-restore-window-32.png"))); // NOI18N
        restoreBtn.setBorder(null);
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
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Clear");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 102));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 0, 0));
        jButton3.setText("Cancel");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
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
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 817, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(255, 255, 255)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restoreBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void isbnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_isbnTxtMouseClicked
        isbnTxt.setForeground(Color.BLUE.darker().darker());
        isbnWTxt.setVisible(false);
        if (evt.getClickCount() == 2) {
            isbnTxt.setText("");
        }
    }//GEN-LAST:event_isbnTxtMouseClicked

    private void isbnTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isbnTxtActionPerformed
        isbnTxt.setForeground(Color.BLUE.darker().darker());
        isbnWTxt.setVisible(false);
    }//GEN-LAST:event_isbnTxtActionPerformed

    private void isbnTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_isbnTxtKeyPressed
        isbnTxt.setForeground(Color.BLUE.darker().darker());
        isbnWTxt.setVisible(false);
    }//GEN-LAST:event_isbnTxtKeyPressed

    private void titleTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleTxtMouseClicked
        titleTxt.setForeground(Color.BLUE.darker().darker());
        titleWTxt.setVisible(false);
        if (evt.getClickCount() == 2) {
            titleTxt.setText("");
        }
    }//GEN-LAST:event_titleTxtMouseClicked

    private void titleTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleTxtActionPerformed
        titleTxt.setForeground(Color.BLUE.darker().darker());
        titleWTxt.setVisible(false);
    }//GEN-LAST:event_titleTxtActionPerformed

    private void titleTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_titleTxtKeyPressed
        titleTxt.setForeground(Color.BLUE.darker().darker());
        titleWTxt.setVisible(false);
    }//GEN-LAST:event_titleTxtKeyPressed

    private void publisherTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_publisherTxtMouseClicked
        if (evt.getClickCount() == 2) {
            publisherTxt.setText("");
        }
    }//GEN-LAST:event_publisherTxtMouseClicked

    private void publisherTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publisherTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_publisherTxtActionPerformed

    private void pageTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pageTxtMouseClicked
        pageTxt.setForeground(Color.BLUE.darker().darker());
        pageWTxt.setVisible(false);
        if (evt.getClickCount() == 2) {
            pageTxt.setText("");
        }
    }//GEN-LAST:event_pageTxtMouseClicked

    private void pageTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pageTxtActionPerformed
        pageTxt.setForeground(Color.BLUE.darker().darker());
        pageWTxt.setVisible(false);
    }//GEN-LAST:event_pageTxtActionPerformed

    private void pageTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pageTxtKeyPressed
        pageTxt.setForeground(Color.BLUE.darker().darker());
        pageWTxt.setVisible(false);
    }//GEN-LAST:event_pageTxtKeyPressed

    private void languageComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_languageComboItemStateChanged
        languageWTxt.setVisible(false);
    }//GEN-LAST:event_languageComboItemStateChanged

    private void languageComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_languageComboActionPerformed

    private void editionTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editionTxtMouseClicked
        if (evt.getClickCount() == 2) {
            editionTxt.setText("");
        }
    }//GEN-LAST:event_editionTxtMouseClicked

    private void limitTimeTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limitTimeTxtMouseClicked
        limitTimeTxt.setForeground(Color.BLUE.darker().darker());
        limitTWTxt.setVisible(false);
        if (evt.getClickCount() == 2) {
            limitTWTxt.setVisible(false);
        }
    }//GEN-LAST:event_limitTimeTxtMouseClicked

    private void limitTimeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limitTimeTxtActionPerformed
        limitTimeTxt.setForeground(Color.BLUE.darker().darker());
        limitTWTxt.setVisible(false);
    }//GEN-LAST:event_limitTimeTxtActionPerformed

    private void limitTimeTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_limitTimeTxtKeyPressed
        limitTimeTxt.setForeground(Color.BLUE.darker().darker());
        limitTWTxt.setVisible(false);
    }//GEN-LAST:event_limitTimeTxtKeyPressed

    private void limitDayTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limitDayTxtMouseClicked
        limitDayTxt.setForeground(Color.BLUE.darker().darker());
        limitDWTxt.setVisible(false);
    }//GEN-LAST:event_limitDayTxtMouseClicked

    private void limitDayTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limitDayTxtActionPerformed
        limitDayTxt.setForeground(Color.BLUE.darker().darker());
        limitDWTxt.setVisible(false);
    }//GEN-LAST:event_limitDayTxtActionPerformed

    private void limitDayTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_limitDayTxtKeyPressed
        limitDayTxt.setForeground(Color.BLUE.darker().darker());
        limitDWTxt.setVisible(false);
    }//GEN-LAST:event_limitDayTxtKeyPressed

    private void bookStarComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bookStarComboItemStateChanged
        bookStarWTxt.setVisible(false);
    }//GEN-LAST:event_bookStarComboItemStateChanged

    private void newRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newRadioActionPerformed
        newRadio.setText("2");
        newRadio.setActionCommand("2");
    }//GEN-LAST:event_newRadioActionPerformed

    private void oldRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldRadioActionPerformed
        oldRadio.setText("1");
        oldRadio.setActionCommand("1");
    }//GEN-LAST:event_oldRadioActionPerformed

    private void allCountWTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allCountWTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_allCountWTxtActionPerformed

    private void allCountBookTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allCountBookTxtMouseClicked
        allCountBookTxt.setForeground(Color.BLUE.darker().darker());
        allCountWTxt.setVisible(false);
        if (evt.getClickCount() == 2) {
            allCountBookTxt.setText("");
        }
    }//GEN-LAST:event_allCountBookTxtMouseClicked

    private void allCountBookTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allCountBookTxtActionPerformed
        allCountBookTxt.setForeground(Color.BLUE.darker().darker());
        allCountWTxt.setVisible(false);
    }//GEN-LAST:event_allCountBookTxtActionPerformed

    private void allCountBookTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_allCountBookTxtKeyPressed
        allCountBookTxt.setForeground(Color.BLUE.darker().darker());
        allCountWTxt.setVisible(false);
    }//GEN-LAST:event_allCountBookTxtKeyPressed

    private void roomNumberComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_roomNumberComboItemStateChanged
        labelRoom.setVisible(false);
        Item roomItem = (Item) roomNumberCombo.getSelectedItem();
        Long selectedIdd = roomItem.getId();
        if (evt.getStateChange() == 1) {
            shelfNumber(selectedIdd);

        }
    }//GEN-LAST:event_roomNumberComboItemStateChanged

    private void shelfNumberComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_shelfNumberComboItemStateChanged
        labelShelf.setVisible(false);
    }//GEN-LAST:event_shelfNumberComboItemStateChanged

    private void shelfNumberComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shelfNumberComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shelfNumberComboActionPerformed

    private void subjectTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subjectTxtMouseClicked
        subjectSearch = subjectTxt.getText();
//        showSubjectList(subjectSearch);
        if (evt.getClickCount() == 2) {
            subjectTxt.setText("");
        }
    }//GEN-LAST:event_subjectTxtMouseClicked

    private void subjectTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectTxtActionPerformed

        subjectSearch = subjectTxt.getText();
//        showSubjectList(subjectSearch);
    }//GEN-LAST:event_subjectTxtActionPerformed

    private void subjectTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subjectTxtKeyPressed
        subjectSearch = subjectTxt.getText();
//        showSubjectList(subjectSearch);
    }//GEN-LAST:event_subjectTxtKeyPressed

    private void listSubjectValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listSubjectValueChanged

    }//GEN-LAST:event_listSubjectValueChanged

    private void authorTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_authorTxtMouseClicked
        authorSearch = authorTxt.getText();
//        showAuthorList(authorSearch);
        if (evt.getClickCount() == 2) {
            authorTxt.setText("");
        }
    }//GEN-LAST:event_authorTxtMouseClicked

    private void authorTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorTxtActionPerformed
        authorSearch = authorTxt.getText();
//        showAuthorList(authorSearch);
    }//GEN-LAST:event_authorTxtActionPerformed

    private void authorTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_authorTxtKeyPressed
        authorSearch = authorTxt.getText();
//        showAuthorList(authorSearch);
    }//GEN-LAST:event_authorTxtKeyPressed

    private void listAuthorValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listAuthorValueChanged

    }//GEN-LAST:event_listAuthorValueChanged

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            Book book = new Book();
            boolean isAddBook = false;
            String bookStar = null;
            String isbn = isbnTxt.getText();
            if (isbn.matches("[0-9]+") && (!isbn.isEmpty())) {
                boolean check = checkIsbn(Long.parseLong(isbn));
                if (check) {
                    String title = titleTxt.getText();
                    if (title.length() <= 25 && !title.isEmpty() && !title.matches("[\\p{L}\\s0-9]+\\+\\-\\*\\/\\-\\_\\&\\^\\%\\$\\#\\@\\!\\~\\>\\<\\.\\,")) {
                        String page = pageTxt.getText();
                        if (page.matches("[0-9]+") && !page.isEmpty()) {
                            String publisher = publisherTxt.getText();
                            String edition = editionTxt.getText();
                            if (!languageCombo.getSelectedItem().equals("Select Language")) {
                                Item languageItem = (Item) languageCombo.getSelectedItem();
                                Language language = new Language();
                                language.setId(languageItem.getId());
                                Date releaseDate = releaseDateCalendar.getDate();
                                book.setReleaseDate(releaseDate);
                                if (!bookStarCombo.getSelectedItem().equals("Select Star")) {
                                    bookStar = String.valueOf(bookStarCombo.getSelectedItem());
                                    String limitTime = limitTimeTxt.getText();
                                    if (limitTime.matches("[0-9]+") && !limitTime.isEmpty()) {
                                        String limitDay = limitDayTxt.getText();
                                        if (limitDay.matches("[0-9]+")) {
                                            String bookAbstract = abstractTxt.getText();
                                            String allCountBooks = allCountBookTxt.getText();
                                            if (allCountBooks.matches("[0-9]+")) {
                                                Long bookCases = null;
                                                if (newRadio.isSelected()) {
                                                    bookCases = new Long(2);
                                                } else if (oldRadio.isSelected()) {
                                                    bookCases = new Long(1);
                                                } else if (!oldRadio.isSelected() && !newRadio.isSelected()) {
                                                    bookCases = new Long(2);
                                                }
                                                if (!roomNumberCombo.getSelectedItem().equals("Select Room Number")) {
                                                    Item roomNumber = (Item) roomNumberCombo.getSelectedItem();
                                                    if (!shelfNumberCombo.getSelectedItem().equals("Select Shelf Number") && (!shelfNumberCombo.getSelectedItem().equals("Thise is no shelf on the room!"))) {
                                                        Item shelfnumber = (Item) shelfNumberCombo.getSelectedItem();
                                                        BookShelf bss = bookShelfService.getBookShelfById(shelfnumber.getId());
                                                        Integer empCap = bss.getEmptyCapacity();
                                                        if (empCap > 0) {
                                                            book.setbAbstract(bookAbstract);
                                                            book.setTitle(title);
                                                            book.setIsbn(Long.parseLong(isbn));
                                                            book.setPage(Integer.parseInt(page));
                                                            book.setPublisher(publisher);
                                                            book.setStar(Float.parseFloat(bookStar));
                                                            book.setEdition(edition);
                                                            book.setLimitDay(Integer.parseInt(limitDay));
                                                            book.setLimitTime(Integer.parseInt(limitTime));
                                                            book.setAllBookCount(Integer.parseInt(allCountBooks));
                                                            BookCase bookCase = new BookCase();
                                                            bookCase.setId(bookCases);
                                                            book.setbCase(bookCase);
                                                            book.setLanguage(language);
                                                            BookRoom bookRoom = new BookRoom();
                                                            BookShelf bookShelf = new BookShelf();
                                                            bookRoom.setId(roomNumber.getId());
                                                            bookShelf.setId(shelfnumber.getId());
                                                            book.setBookRoom(bookRoom);
                                                            book.setBookShelf(bookShelf);
                                                            boolean subC = false;
                                                            List<Book> sub = bookService.getSubjectByBookId(selectedId);
                                                            for (Book book1 : sub) {
                                                                if (book1.getSubjects().getId() != null) {
                                                                    subC = true;
                                                                }
                                                            }
                                                            if (subC) {
                                                                boolean autC = false;
                                                                List<Book> aut = bookService.getAuthorByBookId(selectedId);
                                                                for (Book book1 : aut) {
                                                                    if (book1.getAuthor().getId() != null) {
                                                                        autC = true;
                                                                    }
                                                                }
                                                                if (autC) {
                                                                    isAddBook = bookService.updateBook(book, selectedId);
                                                                    if (isAddBook = true && (isDeleteSubject = true) && (isAddSubject = true) && (isDeleteAuthor = true) && (isAddAuthor = true)) {
                                                                        JOptionPane.showMessageDialog(null, "BOOK IS UPDATED SUCCESSFULLY ", "SUCCESS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\LibraryDesktopProject\\src\\project\\library\\desktop\\gui\\icon\\tick.png"));
                                                                        if (!String.valueOf(mf).equals(String.valueOf(shelfnumber.getId()))) {
                                                                            BookShelf bs = bookShelfService.getBookShelfById(shelfnumber.getId());
                                                                            if (!String.valueOf(shelfnumber.getId()).equals(String.valueOf(oldBook.getBookShelf().getId()))) {
                                                                                if (bs.getEmptyCapacity() != null) {
                                                                                    Integer finisEmp = bs.getEmptyCapacity() - 1;
                                                                                    boolean emp = bookShelfService.updateEmpity(shelfnumber.getId(), finisEmp);
                                                                                    Integer oldEmp = oldBook.getBookShelf().getEmptyCapacity() + 1;
                                                                                    boolean oldemp = bookShelfService.updateEmpity(oldBook.getBookShelf().getId(), oldEmp);
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        JOptionPane.showMessageDialog(null, "BOOK IS NOT UPDATE", "FAIL", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\LibraryDesktopProject\\src\\project\\library\\desktop\\gui\\icon\\report.png"));
                                                                    }
                                                                } else {
                                                                    JOptionPane.showMessageDialog(null, "Add Author !");
                                                                }
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "Add Subject !");
                                                            }
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "This Shelf is Full !");
                                                        }
                                                    } else {

                                                        labelShelf.setVisible(true);

                                                    }
                                                } else {

                                                    labelRoom.setVisible(true);
                                                }
                                            } else {
                                                allCountWTxt.setText("Only Number Type");
                                                allCountWTxt.setVisible(true);
                                                allCountBookTxt.setForeground(Color.red);

                                            }
                                        } else {
                                            limitDWTxt.setText("Only Number Type");
                                            limitDWTxt.setVisible(true);
                                            limitDayTxt.setForeground(Color.red);
                                        }
                                    } else {
                                        limitTWTxt.setText("Only Number Type");
                                        limitTWTxt.setVisible(true);
                                        limitTimeTxt.setForeground(Color.red);
                                    }
                                } else {
                                    bookStarWTxt.setVisible(true);
                                    bookStarWTxt.setText("Add Star");
                                }
                            } else {
                                languageWTxt.setVisible(true);
                                languageWTxt.setText("Select Language");

                            }
                        } else {
                            pageWTxt.setVisible(true);
                            pageWTxt.setText("Only Number Type");
                            pageTxt.setForeground(Color.red);
                        }
                    } else {
                        titleTxt.setForeground(Color.red);
                        titleWTxt.setVisible(true);
                        titleWTxt.setText("UnCorrect Title");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Repeated ISBN");
                }
            } else {
                isbnWTxt.setText("Only Number Type");
                isbnTxt.setForeground(Color.red);
                isbnWTxt.setVisible(true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE, TO CLOSE THE PROGRAM?");
        if (choose == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
        BookFrame bookFrame = new BookFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        bookFrame.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jPanel3.isShowing()) {
            editionTxt.setText("");
            bookStarCombo.setSelectedIndex(0);
            limitTimeTxt.setText("");
            //            limitDayTxt.setText("");
            limitTWTxt.setVisible(false);
            limitDWTxt.setVisible(false);
            newRadio.setSelected(false);
            oldRadio.setSelected(false);
            bookStarWTxt.setVisible(false);
            bookStarWTxt.setVisible(false);
            abstractTxt.setText("");
        } else if (jPanel2.isShowing()) {
            isbnTxt.setText("");
            titleTxt.setText("");
            publisherTxt.setText("");
            pageTxt.setText("");
            languageCombo.setSelectedIndex(0);
            languageWTxt.setVisible(false);
            releaseDateCalendar.setDate(null);
            isbnWTxt.setVisible(false);
            titleWTxt.setVisible(false);
            pageWTxt.setVisible(false);
        } else if (jPanel4.isShowing()) {
            roomNumberCombo.setSelectedIndex(0);
            shelfNumberCombo.setSelectedIndex(0);
            subjectTxt.setText("");
            labelRoom.setVisible(false);
            labelShelf.setVisible(false);
            listSubject.setSelectedIndex(0);
            authorTxt.setText("");
            listAuthor.setSelectedIndex(0);
            allCountBookTxt.setText("");
            allCountWTxt.setVisible(false);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        BookFrame bookFrame = new BookFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        bookFrame.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void addSubjectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSubjectBtnActionPerformed
        try {
            if (listSubject.getSelectedIndex() > 0) {
                List<Item> ids = listSubject.getSelectedValuesList();
                for (Item id : ids) {
                    boolean check = checkSubjectUnique(id.getId());
                    if (check) {
                        boolean isAddBook = bookService.addSubjects(selectedId, id.getId());
                        if (isAddBook) {
                            subjectWTxt.setVisible(true);
                            subjectWTxt.setText(id.getValue() + " add successfuly");
                            isAddSubject = true;
                            oldSubjectAfterChange(selectedId);
                        } else {
                            subjectWTxt.setVisible(true);
                            subjectWTxt.setText(id.getValue() + " adding is fail");
                            isAddSubject = false;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "This Subject Has Been Added !");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Select  Subject");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_addSubjectBtnActionPerformed

    private void deleteSubjectBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSubjectBookBtnActionPerformed
        List<Item> subjects = oldSubjectList.getSelectedValuesList();
        try {
            if (oldSubjectList.getSelectedIndex() > 0) {
                for (Item subject : subjects) {
                    boolean isDeleteSubject = bookService.updateSubjectbyBookId(selectedId, subject.getId());
                    if (isDeleteSubject) {
                        subjectWTxt.setVisible(true);
                        subjectWTxt.setText(subject.getValue() + " deleted successfuly");
                        isDeleteSubject = true;
                        oldSubjectAfterChange(selectedId);
                    } else {
                        subjectWTxt.setVisible(true);
                        subjectWTxt.setText(subject.getValue() + " deleted fail");
                        isDeleteSubject = false;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Select Subject!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_deleteSubjectBookBtnActionPerformed

    private void addAuthorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAuthorBtnActionPerformed
        try {
            if (listAuthor.getSelectedIndex() > 0) {
                List<Item> auhors = listAuthor.getSelectedValuesList();
                try {
                    if (listAuthor.getSelectedIndex() != -1) {
                        for (Item auhor : auhors) {
                            boolean check = checkAuthorUnique(auhor.getId());
                            if (check) {
                                boolean isDeleteAuthor = bookService.addAuthors(selectedId, auhor.getId());
                                if (isDeleteAuthor) {
                                    authorWtxt.setVisible(true);
                                    authorWtxt.setText(auhor.getValue() + " add successfuly ");
                                    isAddAuthor = true;
                                    oldAuthorAfterChange(selectedId);
                                } else {
                                    authorWtxt.setVisible(true);
                                    authorWtxt.setText(auhor.getValue() + "add fail ");
                                    isAddAuthor = false;
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "This Author Has Been Added !");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, " Select Authror");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, " Select New Author");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_addAuthorBtnActionPerformed

    private void deleteAuthortBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAuthortBookBtnActionPerformed
        List<Item> subjects = oldAuthorList.getSelectedValuesList();
        try {
            if (oldAuthorList.getSelectedIndex() > 0) {
                for (Item a : subjects) {
                    boolean isDeleteSubject = bookService.updateAuthorbyBookId(selectedId, a.getId());
                    if (isDeleteSubject) {
                        authorWtxt.setVisible(true);
                        authorWtxt.setText(a.getValue() + " delete successfuly ");
                        isDeleteAuthor = true;
                        oldAuthorAfterChange(selectedId);
                    } else {
                        authorWtxt.setVisible(true);
                        authorWtxt.setText(a.getValue() + " delete fail ");
                        isDeleteAuthor = false;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please, Select Subject");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_deleteAuthortBookBtnActionPerformed

    private void authorWtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorWtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_authorWtxtActionPerformed

    private void subjectWTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectWTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectWTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea abstractTxt;
    private javax.swing.JButton addAuthorBtn;
    private javax.swing.JButton addSubjectBtn;
    private javax.swing.JTextField allCountBookTxt;
    private javax.swing.JTextField allCountWTxt;
    private javax.swing.JTextField authorTxt;
    private javax.swing.JTextField authorWtxt;
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<String> bookStarCombo;
    private javax.swing.JTextField bookStarWTxt;
    private javax.swing.JButton deleteAuthortBookBtn;
    private javax.swing.JButton deleteSubjectBookBtn;
    private javax.swing.JTextField editionTxt;
    private javax.swing.JTextField isbnTxt;
    private javax.swing.JTextField isbnWTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelRoom;
    private javax.swing.JLabel labelShelf;
    private javax.swing.JComboBox<String> languageCombo;
    private javax.swing.JTextField languageWTxt;
    private javax.swing.JTextField limitDWTxt;
    private javax.swing.JTextField limitDayTxt;
    private javax.swing.JTextField limitTWTxt;
    private javax.swing.JTextField limitTimeTxt;
    private javax.swing.JList<Item> listAuthor;
    private javax.swing.JList<Item> listSubject;
    private javax.swing.JButton minimizeBtn;
    private javax.swing.JLabel minutesLable;
    private javax.swing.JRadioButton newRadio;
    private javax.swing.JList<Item> oldAuthorList;
    private javax.swing.JRadioButton oldRadio;
    private javax.swing.JList<Item> oldSubjectList;
    private javax.swing.JTextField pageTxt;
    private javax.swing.JTextField pageWTxt;
    private javax.swing.JTextField publisherTxt;
    private com.toedter.calendar.JDateChooser releaseDateCalendar;
    private javax.swing.JButton restoreBtn;
    private javax.swing.JComboBox<String> roomNumberCombo;
    private javax.swing.JButton saveBtn;
    private javax.swing.JComboBox<String> shelfNumberCombo;
    private javax.swing.JTextField subjectTxt;
    private javax.swing.JTextField subjectWTxt;
    private javax.swing.JTextField titleTxt;
    private javax.swing.JTextField titleWTxt;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables

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

    void showOldDate(Book book) {
        isbnTxt.setText(String.valueOf(book.getIsbn()));
        titleTxt.setText(book.getTitle());
        publisherTxt.setText(book.getPublisher());
        pageTxt.setText(String.valueOf(book.getPage()));
        releaseDateCalendar.setDate(book.getReleaseDate());
        editionTxt.setText(book.getEdition());
        limitTimeTxt.setText(String.valueOf(book.getLimitTime()));
        limitDayTxt.setText(String.valueOf(book.getLimitDay()));
        abstractTxt.setText(book.getbAbstract());
        allCountBookTxt.setText(String.valueOf(book.getAllBookCount()));
        if (book.getbCase().getId() == 2) {
            newRadio.setSelected(true);
        } else if (book.getbCase().getId() == 1) {
            oldRadio.setSelected(true);
        }

    }

    void languageCombo(Book book) {
        try {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            List<Language> getLanguageList = languageService.getLanguageList();
            model.addElement("Select Language");
            for (Language language : getLanguageList) {
                model.addElement(new Item(language.getId(), language.getBookLanguage()));
            }
            languageCombo.setModel(model);
            model.setSelectedItem(new Item(book.getLanguage().getId(), book.getLanguage().getBookLanguage()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    void starCombo(Book book) {
        try {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            String[] stars = {"1", "1.5", "2", "2.5", "3", "3.5", "4", "4.5", "5"};
            model.addElement("Select Star");
            for (String star : stars) {
                model.addElement(star);
            }
            bookStarCombo.setModel(model);
            if (book.getStar() != null) {
                model.setSelectedItem(book.getStar());
            } else {
                model.addElement("0");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void roomNumberCombo(Book book) {
        try {
            DefaultComboBoxModel model = new DefaultComboBoxModel<>();
            model.addElement("Select Room Number");
            List<BookRoom> bookRoomList = bookRoomService.getBookRoomList();
            for (BookRoom bookRoom : bookRoomList) {
                model.addElement(new Item(bookRoom.getId(), bookRoom.getNumber()));
            }
            roomNumberCombo.setModel(model);
            model.setSelectedItem(new Item(book.getBookRoom().getId(), book.getBookRoom().getNumber()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void oldSubject(Long id) {
        try {
            List<Book> subjectList = bookService.getSubjectByBookId(id);
            modelOdSubject.addElement(new Item((long) 0, "Old Subject"));
            for (Book book1 : subjectList) {
                modelOdSubject.addElement(new Item(book1.getSubjects().getId(), book1.getSubjects().getSubjectName()));
            }
            oldSubjectList.setModel(modelOdSubject);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void oldSubjectAfterChange(Long id) {
        try {
            List<Book> subjectList = bookService.getSubjectByBookId(id);
            modelOdSubject.removeAllElements();
            modelOdSubject.addElement(new Item((long) 0, oldBook.getTitle() + "'s" + " Subjects"));
            for (Book book1 : subjectList) {
                modelOdSubject.addElement(new Item(book1.getSubjects().getId(), book1.getSubjects().getSubjectName()));
            }
            oldSubjectList.setModel(modelOdSubject);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void oldAuthor(Long id) {
        try {
            List<Book> authorList = bookService.getAuthorByBookId(id);
            modelOldAuthor.addElement(new Item((long) 0, "Old Author Name"));
            for (Book book1 : authorList) {
                modelOldAuthor.addElement(new Item(book1.getAuthor().getId(), book1.getAuthor().getFirstName() + " " + book1.getAuthor().getLastName() + " " + book1.getAuthor().getFatherName()));
            }
            oldAuthorList.setModel(modelOldAuthor);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    void oldAuthorAfterChange(Long id) {
        try {
            List<Book> authorList = bookService.getAuthorByBookId(id);
            modelOldAuthor.removeAllElements();
            modelOldAuthor.addElement(new Item((long) 0, oldBook.getTitle() + "'s " + " Authors"));
            for (Book book1 : authorList) {
                modelOldAuthor.addElement(new Item(book1.getAuthor().getId(), book1.getAuthor().getFirstName() + " " + book1.getAuthor().getLastName() + " " + book1.getAuthor().getFatherName()));
            }
            oldAuthorList.setModel(modelOldAuthor);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    void subjectAllList() {
        try {
            List<Subjects> subjects = subjectService.getSubjectList();
            modelSubject.addElement(new Item((long) 0, "All Subjects"));
            for (Subjects subject : subjects) {
                modelSubject.addElement(new Item(subject.getId(), subject.getSubjectName()));
            }
            listSubject.setModel(modelSubject);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    void authorAllList() {
        try {
            List<Author> authors = authorService.getAuthorList();
            modelAuthor.addElement(new Item((long) 0, "All Author"));
            for (Author author : authors) {
                modelAuthor.addElement(new Item(author.getId(), author.getFirstName() + " " + author.getLastName() + " " + author.getFatherName()));
            }
            listAuthor.setModel(modelAuthor);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    void oldShelfNumber(Long id, Book book) {
        try {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            List<BookShelf> getBookShelfByRoom = bookShelfService.getBookShelfByRoomId(id);
            if (getBookShelfByRoom.size() > 0) {
                model.removeAllElements();
                model.addElement("Select Shelf");
                for (BookShelf bookShelf : getBookShelfByRoom) {
                    model.addElement(new Item(bookShelf.getId(), bookShelf.getShelfNumber()));
                }
            } else {
                model.removeAllElements();
                model.addElement("Thise is no shelf on the room!");
            }
            model.setSelectedItem(new Item(book.getBookShelf().getId(), book.getBookShelf().getShelfNumber()));
            shelfNumberCombo.setModel(model);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void shelfNumber(Long id) {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) shelfNumberCombo.getModel();
            List<BookShelf> getBookShelfByRoom = bookShelfService.getBookShelfByRoomId(id);
            if (getBookShelfByRoom.size() > 0) {
                model.removeAllElements();
                for (BookShelf bookShelf : getBookShelfByRoom) {
                    model.addElement(new Item(bookShelf.getId(), bookShelf.getShelfNumber()));
                }
            } else {
                model.removeAllElements();
                model.addElement("Thise is no shelf on the room!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void hideWarning() {

        limitTWTxt.setVisible(false);
        limitDWTxt.setVisible(false);
        newRadio.setSelected(false);
        oldRadio.setSelected(false);
        bookStarWTxt.setVisible(false);
        subjectWTxt.setVisible(false);
        releaseDateCalendar.setDate(null);
        isbnWTxt.setVisible(false);
        titleWTxt.setVisible(false);
        languageWTxt.setVisible(false);
        pageWTxt.setVisible(false);
        labelRoom.setVisible(false);
        bookStarWTxt.setVisible(false);
        labelShelf.setVisible(false);
        authorWtxt.setVisible(false);
        allCountWTxt.setVisible(false);

    }

    boolean checkIsbn(Long isbn) {
        boolean result = true;
        try {
            Book book = bookService.getBookById(selectedId);
            if (!String.valueOf(book.getIsbn()).equals(String.valueOf(isbn))) {
                List<Book> books = bookService.allBookList(1);
                for (Book book1 : books) {
                    if (String.valueOf(book.getIsbn()).equals(String.valueOf(isbn))) {
                        result = false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    boolean checkSubjectUnique(Long id) {
        boolean result = true;
        try {
            List<Book> subjects = bookService.getSubjectByBookId(selectedId);
            for (Book subject : subjects) {
                if (String.valueOf(subject.getSubjects().getId()).equals(String.valueOf(id))) {
                    result = false;
                }
            }
            System.out.println("tt  " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    boolean checkAuthorUnique(Long id) {
        boolean result = true;
        try {
            List<Book> authors = bookService.getAuthorByBookId(selectedId);
            for (Book author : authors) {
                if (String.valueOf(author.getAuthor().getId()).equals(String.valueOf(id))) {
                    result = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
