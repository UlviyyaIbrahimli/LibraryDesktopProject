package project.library.desktop.book;

import java.awt.Color;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import project.library.desktop.model.Author;
import project.library.desktop.model.BookRoom;
import project.library.desktop.model.BookShelf;
import project.library.desktop.model.Login;
import project.library.desktop.model.ReadRoom;
import project.library.desktop.model.ReadTable;
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
 * @Ulviyye Ibrahimli
 */
public class BookItemFrame extends javax.swing.JFrame {

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
    String global = "1";

    public BookItemFrame() {
        initComponents();
    }

    BookItemFrame(DepartmentService departmentService,
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
        userTxt.setText("");
        btnFalse();
        this.setDefaultLookAndFeelDecorated(true);
        this.pack();
        this.setLocationRelativeTo(null);
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setForeground(Color.RED.darker());
        tableHeader.setBackground(Color.WHITE);
        table.setShowGrid(true);
        table.setRowSelectionAllowed(true);
        table.setGridColor(Color.BLUE.darker().darker());
        table.setSelectionBackground(Color.BLUE.darker().darker());
        table.setSelectionForeground(Color.WHITE);
        userTxt.setText("Welcome, " + login.getFirstName() + " " + login.getLastName());
        try {
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.darker().darker());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        authorBtn = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        subjectBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        restoreBtn1 = new javax.swing.JButton();
        minimizeBtn1 = new javax.swing.JButton();
        backBtn1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        userTxt = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        table.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        table.setForeground(new java.awt.Color(0, 0, 102));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table.setGridColor(new java.awt.Color(102, 0, 0));
        table.setSelectionBackground(new java.awt.Color(0, 0, 153));
        jScrollPane1.setViewportView(table);

        addBtn.setBackground(new java.awt.Color(0, 0, 102));
        addBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add");
        addBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255)));
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(0, 0, 102));
        updateBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("Edit");
        updateBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255)));
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(0, 0, 102));
        deleteBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Delete");
        deleteBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255)));
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));

        authorBtn.setBackground(new java.awt.Color(0, 0, 102));
        authorBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        authorBtn.setForeground(new java.awt.Color(255, 255, 255));
        authorBtn.setText("Author");
        authorBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 204)));
        authorBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        authorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorBtnActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 102));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Book Shelf");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255)));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 0, 102));
        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Book Room");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255)));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Read Table");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255)));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Read Room");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 204), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255)));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        subjectBtn.setBackground(new java.awt.Color(0, 0, 102));
        subjectBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        subjectBtn.setForeground(new java.awt.Color(255, 255, 255));
        subjectBtn.setText("Subject");
        subjectBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255)));
        subjectBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subjectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subjectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(authorBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(authorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(subjectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cancelBtn.setBackground(new java.awt.Color(0, 0, 102));
        cancelBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Cancel");
        cancelBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255), new java.awt.Color(0, 0, 255)));
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
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

        jLabel1.setBackground(new java.awt.Color(51, 0, 51));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Book's Items");

        userTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        userTxt.setForeground(new java.awt.Color(0, 0, 255));
        userTxt.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addComponent(jScrollPane1)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(minimizeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(minimizeBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(restoreBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(updateBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        global = "readRoom";
        showReadRoomData();
        btnTrue();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void authorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorBtnActionPerformed
//      authorBtn.getModel().addChangeListener(new ChangeListener() {
//
//    @Override
//    public void stateChanged(ChangeEvent e) {
//        ButtonModel model = (ButtonModel) e.getSource();
//
//        if (model.isRollover()) {
//            authorBtn.setBackground(new Color(0, 59, 0).brighter());
//        } else if (model.isPressed()) {
//            authorBtn.setBackground(Color.BLACK);
//        } else {
//            authorBtn.setBackground(new Color(3, 59, 90));
//        }
//    }
//});// after clinc change color
        global = "author";
        btnTrue();
        showAuthorData();
    }//GEN-LAST:event_authorBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            if (table.getSelectedRowCount() == 1) {
                try {
                    Long selectedId = (Long) table.getValueAt(selectedRow, 0);
                    switch (global) {
                        case "subject":
                            int selectOption = JOptionPane.showConfirmDialog(null, "Are you sure,to delete \"" + subjectService
                                    .getSubjectById(selectedId).getSubjectName().toUpperCase() + "\"");
                            if (selectOption == JOptionPane.YES_OPTION) {
                                boolean isDelete = subjectService.deleteSubject(selectedId);
                                if (isDelete) {
                                    JOptionPane.showMessageDialog(null, "DELETING IS SUCCESS !", "SUCCESS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/tick.png"));
                                    showSubjectDate();
                                    List<Author> authorWhoThissubject = authorService.getSubjectByAuthor(selectedId);
                                    if (authorWhoThissubject.size() > 0) {
                                        int subjectChoose = JOptionPane.showConfirmDialog(null, "Do you want to change subject 's author and book?");
                                        if (subjectChoose == JOptionPane.YES_OPTION) {
                                            DeleteAuthorBySubjectFrame deleteAuthorBySubjectFrame = new DeleteAuthorBySubjectFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, selectedId, login);
                                            deleteAuthorBySubjectFrame.setVisible(true);
                                            this.dispose();
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "DELETING  IS FAIL", "FAIL", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/report.png"));
                                }
                            }
                            break;
                        case "author":
                            String authorfullName = authorService.getAuthorById(selectedId).getFirstName()
                                    + authorService.getAuthorById(selectedId).getLastName();
                            int selectOption1 = JOptionPane.showConfirmDialog(null, "ARE YOU SURE, TO DELETE--> \" " + authorfullName.toUpperCase() + "\"");
                            if (selectOption1 == JOptionPane.YES_OPTION) {
                                boolean isDeleteA = authorService.deleteAuthor(selectedId);
                                if (isDeleteA) {
                                    JOptionPane.showMessageDialog(null, authorfullName + "--> DELETED SUCCESSFULY!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/tick.png"));
                                    showAuthorData();
                                    int ch = JOptionPane.showConfirmDialog(null, "Are you change this authors books?");
                                    if (ch == JOptionPane.YES_OPTION) {
                                        List<Author> books = authorService.booksOfAuthorActiveZero(selectedId);
                                        if (books.size() > 0) {
                                            BooksWithoutAuthorsFrame authors = new BooksWithoutAuthorsFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, selectedId, login);
                                            authors.setVisible(true);
                                            this.dispose();
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "DELETING IS  FAIL !", "FAIL", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/report.png"));
                                }
                            }
                            break;
                        case "bookShelf":
                            int selectOption2 = JOptionPane.showConfirmDialog(null, "Are you delete \"" + bookShelfService.getBookShelfById(selectedId).getShelfNumber() + "\"");
                            if (selectOption2 == JOptionPane.YES_OPTION) {
                                boolean isDeleteS = bookShelfService.deleteBookShelf(selectedId);
                                if (isDeleteS) {
                                    JOptionPane.showMessageDialog(null, bookShelfService.getBookShelfById(selectedId).getShelfNumber() + " DELETED  SUCCESSFULY !", "SUCCESS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/tick.png"));
                                    showBookShelfData();
                                    List<BookShelf> books = bookShelfService.getBookByShelfId(selectedId);
                                    if (books.size() > 0) {
                                        int selectedOption3 = JOptionPane.showConfirmDialog(null, "Do you want to change the books on this shelf ?");
                                        if (selectedOption3 == JOptionPane.YES_OPTION) {
                                            BookWithoutShelfFrame bookWithoutShelfFrame = new BookWithoutShelfFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, selectedId, login);
                                            bookWithoutShelfFrame.setVisible(true);
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "DELETING IS  FAIL !", "FAIL", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/report.png"));
                                }

                            }
                            break;
                        case "bookRoom":
                            String bookRoomNumber = bookRoomService.getBookRoomByid(selectedId).getNumber();
                            int selectionOption4 = JOptionPane.showConfirmDialog(null, "Are you sure  delete  \"" + bookRoomNumber + "\"");
                            if (selectionOption4 == JOptionPane.YES_OPTION) {
                                boolean isDeleteBookRoom = bookRoomService.deleteBookRoom(selectedId);
                                if (isDeleteBookRoom) {
                                    JOptionPane.showMessageDialog(null, bookRoomNumber + " --> DELETED IS SUCCESSFULY !", "SUCCESS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/tick.png"));
                                    showBookRoomData();
                                    List<BookShelf> bookShelfList = bookShelfService.getBookshelfWhichRoomActiveZero();
                                    if (bookShelfList.size() > 0) {
                                        int selectionOption5 = JOptionPane.showConfirmDialog(null, "Are You Change Shelf_Room ?, Which is locate  " + bookRoomNumber + " room");
                                        if (selectionOption5 == JOptionPane.YES_OPTION) {
                                            ShelfWithouRoomFrame roomFrame = new ShelfWithouRoomFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, selectedId, login);
                                            roomFrame.setVisible(true);
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "DELETING IS  FAIL !", "FAIL", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/report.png"));
                                }
                            }
                            break;
                        case "readRoom":
                            String numberOfRoom = readRoomService.getReadRoomById(selectedId).getReadRoomNumber();
                            int selectedOption3 = JOptionPane.showConfirmDialog(null, "Are you sure delete  \"" + numberOfRoom + "\"");
                            if (selectedOption3 == JOptionPane.YES_OPTION) {
                                boolean isDeleteRoom = readRoomService.deleteReadRoom(selectedId);
                                if (isDeleteRoom) {
                                    JOptionPane.showMessageDialog(null, numberOfRoom + "DELETED IS SUCCESSFULY !", "SUCCESS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/tick.png"));
                                    showReadRoomData();
                                    List<ReadTable> getListReadTabele = readTableService.getTableByRoomId(selectedId);
                                    if (getListReadTabele.size() > 0) {
                                        int choose = JOptionPane.showConfirmDialog(null, "Are you change table, which is located \" " + numberOfRoom + "\"");
                                        if (choose == JOptionPane.YES_OPTION) {
                                            ReadTableWithoutRoomFrame readT = new ReadTableWithoutRoomFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, selectedId, login);
                                            readT.setVisible(true);
                                        }
                                    } else {

                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "DELETING IS  FAIL !", "FAIL", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/report.png"));
                                }
                            }
                            break;
                        case "readTable":
                            String tableNumber = readTableService.getReadTableById(selectedId).getTableNumber();
                            int selectionOption5 = JOptionPane.showConfirmDialog(null, "Are you sure delete  " + tableNumber);
                            if (selectionOption5 == JOptionPane.YES_OPTION) {
                                boolean isDeleteTable = readTableService.deleteReadTable(selectedId);
                                if (isDeleteTable) {
                                    JOptionPane.showMessageDialog(null, tableNumber + "-->DELETED IS SUCCESSFULT !", "SUCCESS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/tick.png"));
                                    showTableDate();
                                } else {
                                    JOptionPane.showMessageDialog(null, "DELETING IS  FAIL !", "FAIL", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/report.png"));
                                }
                            }
                            break;
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "SELECT ONLY ONE ROW !");
            }
        } else {
            JOptionPane.showMessageDialog(null, "SELECT ROW !");
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            if (table.getSelectedRowCount() == 1) {
                Long selectedId = (Long) table.getValueAt(selectedRow, 0);
                switch (global) {
                    case "subject":
                        this.dispose();
                        UpdateSubjectFrame updateSubjectFrame = new UpdateSubjectFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, selectedId, login);
                        updateSubjectFrame.setVisible(true);
                        break;
                    case "author":
                        this.dispose();
                        EditAuthorFrame authorFrame = new EditAuthorFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, selectedId, login);
                        authorFrame.setVisible(true);
                        break;
                    case "bookRoom":
                        this.dispose();
                        UpdateBookRoomFrame bookRoomFrame = new UpdateBookRoomFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, selectedId, login);
                        bookRoomFrame.setVisible(true);
                        break;
                    case "bookShelf":
                        this.dispose();
                        UpdateBookShelfFrame bookShelfFrame = new UpdateBookShelfFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, selectedId, login);
                        bookShelfFrame.setVisible(true);
                        break;
                    case "readRoom":
                        this.dispose();
                        UpdataReadRoomFrame updataReadRoomFrame = new UpdataReadRoomFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, selectedId, login);
                        updataReadRoomFrame.setVisible(true);
                        break;
                    case "readTable":
                        this.dispose();
                        UpdateReadTableFrame updateReadTableFrame = new UpdateReadTableFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, selectedId, login);
                        updateReadTableFrame.setVisible(true);
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Select  Only One Row !");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select Row !");
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        switch (global) {
            case "subject":
                this.dispose();
                AddSubjectFrame addSubjectFrame = new AddSubjectFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
                addSubjectFrame.setVisible(true);
                break;
            case "author":
                this.dispose();
                AddAuthorFrame addAuthorFrame = new AddAuthorFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
                addAuthorFrame.setVisible(true);
                break;
            case "bookRoom":
                this.dispose();
                AddBookRoomFrame bookRoomFrame = new AddBookRoomFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
                bookRoomFrame.setVisible(true);
                break;
            case "bookShelf":
                this.dispose();
                AddBookShelfFrame addBookShelfFrame = new AddBookShelfFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
                addBookShelfFrame.setVisible(true);
                break;
            case "readRoom":
                this.dispose();
                AddReadRoomFrame addReadRoomFrame = new AddReadRoomFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
                addReadRoomFrame.setVisible(true);

                break;
            case "readTable":
                this.dispose();
                AddReadTableFrame addReadTableFrame = new AddReadTableFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
                addReadTableFrame.setVisible(true);
                break;
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void subjectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectBtnActionPerformed
        global = "subject";
        showSubjectDate();
        btnTrue();
    }//GEN-LAST:event_subjectBtnActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        global = "bookRoom";
        showBookRoomData();
        btnTrue();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        global = "bookShelf";
        showBookShelfData();
        btnTrue();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        global = "readTable";
        showTableDate();
        btnTrue();
    }//GEN-LAST:event_jButton2ActionPerformed

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

    private void minimizeBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeBtn1ActionPerformed
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_minimizeBtn1ActionPerformed

    private void backBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn1ActionPerformed
        this.dispose();
        BookFristFrame bookFristFrame = new BookFristFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        bookFristFrame.setVisible(true);
    }//GEN-LAST:event_backBtn1ActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
        BookFristFrame bookFristFrame = new BookFristFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        bookFristFrame.setVisible(true);
    }//GEN-LAST:event_cancelBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton authorBtn;
    private javax.swing.JButton backBtn1;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton minimizeBtn1;
    private javax.swing.JButton restoreBtn1;
    private javax.swing.JButton subjectBtn;
    private javax.swing.JTable table;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables

    private void showSubjectDate() {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            List<Subjects> subjectList = subjectService.getSubjectList();
            model.addColumn("Id");
            model.addColumn("№");
            model.addColumn("Subject Name");
            model.addColumn("Subject Info");
            table.setModel(model);
            for (Subjects subjects : subjectList) {
                Object object[] = new Object[]{
                    subjects.getId(), subjects.getNumber(), subjects.getSubjectName(), subjects.getSubjectInfo()

                };
                model.addRow(object);
            }
            model.fireTableDataChanged();
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(1).setMaxWidth(40);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showAuthorData() {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            List<Author> authorList = authorService.getAuthorList();// 2 listag olduqda tekrar ploblemi
            model.addColumn("id");
            model.addColumn("№");
            model.addColumn("Full Name");
            model.addColumn("Gener");
            model.addColumn("Day of birth");
            model.addColumn("Day of Dead");
            model.addColumn("Nationality");
            model.addColumn("Reward");
            model.addColumn("Note");
            model.addColumn("Subject");
            model.addColumn("Books");
            table.setModel(model);
            for (Author author : authorList) {
                Object object[] = new Object[]{
                    author.getId(), author.getNumber(), author.getFirstName() + " " + author.getLastName() + " "
                    + author.getFatherName(), author.getGender(), author.getDob(),
                    author.getDeadDate(), author.getNationality(), author.getReward(), author.getAuthorInfo(), author.getSubjects().getSubjectName(),
                    author.getBook().getTitle()
                };
                model.addRow(object);
            }
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(1).setMaxWidth(40);
            table.getColumnModel().getColumn(3).setMaxWidth(70);
            table.getColumnModel().getColumn(4).setMaxWidth(90);
            table.getColumnModel().getColumn(5).setMaxWidth(90);

            model.fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showBookRoomData() {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            List<BookRoom> bookRoomList = bookRoomService.getBookRoomList();
            model.addColumn("Id");
            model.addColumn("№");
            model.addColumn("Room-Floor");
            model.addColumn("Room-Number");
            table.setModel(model);
            for (BookRoom bookRoom : bookRoomList) {
                Object object[] = new Object[]{
                    bookRoom.getId(),
                    bookRoom.getNumberOrder(),
                    bookRoom.getFloor(),
                    bookRoom.getNumber()
                };
                model.addRow(object);
            }
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(1).setMaxWidth(40);
            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showBookShelfData() {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            List<BookShelf> bookShelfList = bookShelfService.getBookShelf();
            model.addColumn("id");
            model.addColumn("№");
            model.addColumn("Shef-Number");
            model.addColumn("Shelf-Floor");
            model.addColumn("Room-Number");
            model.addColumn("Room-Floor");
            model.addColumn("Potential Capacity");
            model.addColumn("Book-Count");
            model.addColumn("Empity-Capacity");
            table.setModel(model);
            for (BookShelf bookShelf : bookShelfList) {
                Object object[] = new Object[]{
                    bookShelf.getId(), bookShelf.getNumber(), bookShelf.getShelfNumber(), bookShelf.getShelfFloor(),
                    bookShelf.getRoom().getNumber(), bookShelf.getRoom().getFloor(),
                    bookShelf.getPotensialCapacity(),
                    bookShelfService.countBookInShelf(bookShelf.getId(), 1),
                    bookShelf.getEmptyCapacity()
                };
                model.addRow(object);
            }
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(1).setMaxWidth(40);

            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showReadRoomData() {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            List<ReadRoom> readRoomList = readRoomService.getReadRoomList();
            model.addColumn("id");
            model.addColumn("№");
            model.addColumn("Room-Floor");
            model.addColumn("Room-Number");
            model.addColumn("Computer-Count");
            model.addColumn("Table-Count");
            model.addColumn("Chair-Count");
            table.setModel(model);
            for (ReadRoom readRoom : readRoomList) {
                Object object[] = new Object[]{
                    readRoom.getId(), readRoom.getNumber(), readRoom.getLibFloor(), readRoom.getReadRoomNumber(),
                    readRoom.getComputerCount(), readRoomService.getTableByRoomId(readRoom.getId()).getTableCount(), readRoom.getChairCount()
                };
                model.addRow(object);
            }
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(1).setMaxWidth(40);

            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showTableDate() {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            List<ReadTable> getListReadTable = readTableService.getReadTable();
            model.addColumn("ID");
            model.addColumn("№");
            model.addColumn("Table Number");
            model.addColumn(" With Compter");
            model.addColumn("Room Floor");
            model.addColumn("Room Number");
            table.setModel(model);
            for (ReadTable readTable : getListReadTable) {
                Object object[] = new Object[]{
                    readTable.getId(), readTable.getNumber(), readTable.getTableNumber(),
                    readTable.getWithComputer(), readTable.getReadRoom().getLibFloor(),
                    readTable.getReadRoom().getReadRoomNumber()
                };
                model.addRow(object);
            }
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(1).setMaxWidth(40);

            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void showTableByRoomId(Long id) {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            List<ReadTable> getListReadTabele = readTableService.getTableByRoomId(id);
            model.addColumn("ID");
            model.addColumn("№");
            model.addColumn("Table Number");
            model.addColumn(" With Compter");
            model.addColumn("Room Number");
            model.addColumn("Room Floor");
            table.setModel(model);
            for (ReadTable readTable : getListReadTabele) {
                Object object[] = new Object[]{
                    readTable.getId(), readTable.getNumber(), readTable.getTableNumber(),
                    readTable.getWithComputer(), readTable.getReadRoom().getReadRoomNumber(), readTable.getReadRoom().getLibFloor()
                };
                model.addRow(object);
            }
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(1).setMaxWidth(40);

            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void showTableAuthorBySubjectId(Long id) {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            List<Author> authors = authorService.getSubjectByAuthor(id);
            model.addColumn("ID");
            model.addColumn("№");
            model.addColumn("Author FullName");
            model.addColumn("Subject Name");
            table.setModel(model);
            for (Author author : authors) {
                Object object[] = new Object[]{
                    author.getId(), author.getNumber(), author.getFirstName() + " " + author.getLastName() + " " + author.getFatherName(),
                    author.getSubjects().getSubjectName()
                };
                model.addRow(object);
            }
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(1).setMaxWidth(40);

            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    void btnFalse() {
        addBtn.setEnabled(false);
        addBtn.setBackground(Color.WHITE.darkGray);
        addBtn.setForeground(Color.BLUE.darker().darker().darker());
        updateBtn.setEnabled(false);
        updateBtn.setBackground(Color.WHITE.darkGray);
        updateBtn.setForeground(Color.BLUE.darker().darker().darker());
        deleteBtn.setEnabled(false);
        deleteBtn.setBackground(Color.WHITE.darkGray);
        deleteBtn.setForeground(Color.BLUE.darker().darker().darker());
    }

    void btnTrue() {
        addBtn.setEnabled(true);
        addBtn.setBackground(Color.BLUE.darker().darker());
        addBtn.setForeground(Color.WHITE.darker());
        updateBtn.setEnabled(true);
        updateBtn.setBackground(Color.BLUE.darker().darker());
        updateBtn.setForeground(Color.WHITE.darker());
        deleteBtn.setEnabled(true);
        deleteBtn.setBackground(Color.BLUE.darker().darker());
        deleteBtn.setForeground(Color.WHITE.darker());
    }

}
