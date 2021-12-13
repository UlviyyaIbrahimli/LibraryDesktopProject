package project.library.desktop.DesktopGui.hr;

import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import project.library.desktop.model.Login;
import project.library.desktop.model.employee.Employee;
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
public class EmployeeFrame extends javax.swing.JFrame {

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

    public EmployeeFrame() {
        initComponents();
    }

    EmployeeFrame(DepartmentService departmentService,
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
        this.setDefaultLookAndFeelDecorated(true);
        this.pack();
        this.setLocationRelativeTo(null);
        try {
//            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.darker().darker());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setExtendedState(MAXIMIZED_BOTH);
        listName.setRenderer(new EmployeeFrame.TwoDecimalRenderer(listName.getRenderer()));
        showEmployeeAllInfo();
        listName.setVisible(false);
        label.setVisible(false);
        getContentPane().setBackground(Color.BLUE.darker());
        jPanel1.setBackground(Color.BLUE.darker());
        JTableHeader tableHeader = employeeInfoTable.getTableHeader();
        tableHeader.setBackground(Color.BLUE.darker().darker());
        tableHeader.setForeground(Color.BLUE.brighter().brighter());
        employeeInfoTable.setGridColor(Color.BLUE.darker().brighter());
        employeeInfoTable.setRowSelectionAllowed(true);
        employeeInfoTable.setSelectionBackground(Color.BLUE.darker().darker());
        employeeInfoTable.setSelectionForeground(Color.WHITE);
        employeeInfoTable.setShowGrid(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        addEmployeeBtn = new javax.swing.JButton();
        restoreBtn = new javax.swing.JButton();
        minimizeBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        listBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        listName = new javax.swing.JComboBox<>();
        searchBtn = new javax.swing.JButton();
        searchTxt = new javax.swing.JTextField();
        label = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeInfoTable = new javax.swing.JTable();

        addEmployeeBtn.setBackground(new java.awt.Color(0, 0, 204));
        addEmployeeBtn.setForeground(new java.awt.Color(51, 204, 255));
        addEmployeeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-add-user-male-40.png"))); // NOI18N
        addEmployeeBtn.setText("Add Employee");
        addEmployeeBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        addEmployeeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addEmployeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeBtnActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 0, 255));
        setUndecorated(true);

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

        jLabel1.setBackground(new java.awt.Color(0, 0, 153));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EMPLOYEE MANAGMENT");

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-undo-24.png"))); // NOI18N
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setForeground(new java.awt.Color(153, 51, 255));

        listBtn.setBackground(new java.awt.Color(0, 0, 153));
        listBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        listBtn.setForeground(new java.awt.Color(255, 255, 255));
        listBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-list-40.png"))); // NOI18N
        listBtn.setText("List");
        listBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 153, 255), new java.awt.Color(102, 153, 255), new java.awt.Color(102, 153, 255), new java.awt.Color(102, 153, 255)));
        listBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listBtnMouseClicked(evt);
            }
        });
        listBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBtnActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(0, 0, 153));
        updateBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-change-user-40.png"))); // NOI18N
        updateBtn.setText("Edit");
        updateBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 153, 255), new java.awt.Color(102, 153, 255), new java.awt.Color(102, 153, 255), new java.awt.Color(102, 153, 255)));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(0, 0, 153));
        deleteBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-delete-user-male-40.png"))); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 153, 255), new java.awt.Color(102, 153, 255), new java.awt.Color(102, 153, 255), new java.awt.Color(102, 153, 255)));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        listName.setForeground(new java.awt.Color(0, 0, 153));
        listName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select List", "Addess and Contact", "Education Info", "Specific Info", "All Info" }));
        listName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listNameItemStateChanged(evt);
            }
        });
        listName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listNameActionPerformed(evt);
            }
        });

        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-search-24 (4).png"))); // NOI18N
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        searchTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        searchTxt.setForeground(new java.awt.Color(0, 0, 204));
        searchTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchTxtMouseEntered(evt);
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

        label.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        label.setForeground(new java.awt.Color(153, 0, 0));
        label.setText("Result not Found");

        addBtn.setBackground(new java.awt.Color(0, 0, 153));
        addBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-add-user-male-40.png"))); // NOI18N
        addBtn.setText("Add");
        addBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 153, 255), new java.awt.Color(102, 153, 255), new java.awt.Color(102, 153, 255), new java.awt.Color(102, 153, 255)));
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(listName, 0, 136, Short.MAX_VALUE)
                    .addComponent(listBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(366, 366, 366)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(listBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        employeeInfoTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        employeeInfoTable.setForeground(new java.awt.Color(0, 0, 153));
        employeeInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(employeeInfoTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(minimizeBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minimizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeBtnActionPerformed
        this.setState(ICONIFIED);
    }//GEN-LAST:event_minimizeBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addEmployeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeBtnActionPerformed

    }//GEN-LAST:event_addEmployeeBtnActionPerformed

    private void listNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listNameActionPerformed
        String selected = (String) listName.getSelectedItem();
        System.out.println(selected);
        if (selected.equalsIgnoreCase("Addess and Contact")) {
            showEmployeeAddressAndContact();

        } else if (selected.equalsIgnoreCase("Education Info")) {
            showEmployeeEducationInfo();

        } else if (selected.equalsIgnoreCase("Specific Info")) {
            showEmployeePrivateInfo();

        } else if (selected.equalsIgnoreCase("All Info")) {
            setExtendedState(MAXIMIZED_BOTH);
            showEmployeeAllInfo();
        }
    }//GEN-LAST:event_listNameActionPerformed

    private void listBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBtnActionPerformed
        listName.setVisible(true);

    }//GEN-LAST:event_listBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        int selectedRow = employeeInfoTable.getSelectedRow();
        if (selectedRow != -1) {
            if (employeeInfoTable.getSelectedRowCount() != 1) {
                JOptionPane.showMessageDialog(null, "Please select just one employee");
            } else {
                dispose();
                Long selectedId = (Long) employeeInfoTable.getValueAt(selectedRow, 0);
                UpdateEmployeeFramee updateEmployeeFrame = new UpdateEmployeeFramee(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, selectedId, login);
                updateEmployeeFrame.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select employee");
        }


    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed

        int selectedRow = employeeInfoTable.getSelectedRow();
        if (selectedRow != -1) {
            if (employeeInfoTable.getSelectedRowCount() > 1) {
                JOptionPane.showMessageDialog(null, " SELECT ONLY ONE ROW!");
            } else {
                try {
                    Long selectedId = (Long) employeeInfoTable.getValueAt(selectedRow, 0);
                    String fullName = (employeeService.getEmployeeById(selectedId).getFirstName() + " " + employeeService.getEmployeeById(selectedId).getLastName()).toUpperCase();
                    int selectionOption = JOptionPane.showConfirmDialog(null, "ARE YOU SURE, TO DELETE--> " + fullName);
                    if (selectionOption == JOptionPane.YES_OPTION) {
                        boolean isDeleteEmployee = employeeService.deleteEmployee(selectedId);
                        if (isDeleteEmployee) {
                            JOptionPane.showMessageDialog(null, fullName + "  - IS DELETE SUCCESSFULLY ", "SUCCESS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\LibraryDesktopProject\\src\\project\\library\\desktop\\gui\\icon\\tick.png"));
                            showEmployeeAllInfo();
                        } else {
                            JOptionPane.showMessageDialog(null, fullName + " - IS NOT DELETED", "FAIL", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\LibraryDesktopProject\\src\\project\\library\\desktop\\gui\\icon\\report.png"));
                        }
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "SELECT ROW !");

        }
    }//GEN-LAST:event_deleteBtnActionPerformed

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
        HrFrame1 hrFrame1 = new HrFrame1(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        hrFrame1.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String keyword = searchTxt.getText();
        List<Employee> employeeList = showSearchResult(keyword);
        if (employeeList.size() > 0) {
            showSearchResult(keyword);
            addBtn.setVisible(true);
            updateBtn.setVisible(true);
            listBtn.setVisible(true);
        } else {
            addBtn.setVisible(false);
            updateBtn.setVisible(false);
            listBtn.setVisible(false);
            label.setVisible(false);
        }

    }//GEN-LAST:event_searchBtnActionPerformed

    private void searchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxtActionPerformed
        String keyword = searchTxt.getText();
        List<Employee> employeeList = showSearchResult(keyword);
        if (employeeList.size() > 0) {
            showSearchResult(keyword);
            addBtn.setVisible(true);
            updateBtn.setVisible(true);
            listBtn.setVisible(true);
            deleteBtn.setVisible(true);
            label.setVisible(false);

        } else {
            updateBtn.setVisible(false);
            listBtn.setVisible(false);
            deleteBtn.setVisible(false);
            label.setVisible(true);
        }
    }//GEN-LAST:event_searchTxtActionPerformed

    private void listNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listNameItemStateChanged
        searchTxt.setVisible(false);
        searchBtn.setVisible(false);
        label.setVisible(false);
        String selected = (String) listName.getSelectedItem();
        System.out.println(selected);
        if (selected.equalsIgnoreCase("Addess and Contact")) {
            showEmployeeAddressAndContact();

        } else if (selected.equalsIgnoreCase("Education Info")) {
            showEmployeeEducationInfo();

        } else if (selected.equalsIgnoreCase("Specific Info")) {
            showEmployeePrivateInfo();

        } else if (selected.equalsIgnoreCase("All Info")) {
            setExtendedState(MAXIMIZED_BOTH);
            searchTxt.setVisible(true);
            searchBtn.setVisible(true);
            label.setVisible(true);
            showEmployeeAllInfo();
        }
    }//GEN-LAST:event_listNameItemStateChanged

    private void listBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listBtnMouseClicked

    }//GEN-LAST:event_listBtnMouseClicked

    private void searchTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTxtMouseClicked
        String keyword = searchTxt.getText();
        List<Employee> employeeList = showSearchResult(keyword);
        if (employeeList.size() > 0) {
            showSearchResult(keyword);
            addBtn.setVisible(true);
            updateBtn.setVisible(true);
            listBtn.setVisible(true);
            deleteBtn.setVisible(true);
            label.setVisible(false);

        } else {
            updateBtn.setVisible(false);
            listBtn.setVisible(false);
            deleteBtn.setVisible(false);
            label.setVisible(true);
        }
        if (evt.getClickCount() == 2) {
            searchTxt.setText("");
        }
    }//GEN-LAST:event_searchTxtMouseClicked

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        this.dispose();
        AddEmployeeFrame addEmployeeFrame = new AddEmployeeFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        addEmployeeFrame.setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed

    private void searchTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyPressed
        String keyword = searchTxt.getText();
        List<Employee> employeeList = showSearchResult(keyword);
        if (employeeList.size() > 0) {
            showSearchResult(keyword);
            addBtn.setVisible(true);
            updateBtn.setVisible(true);
            listBtn.setVisible(true);
            deleteBtn.setVisible(true);
            label.setVisible(false);

        } else {
            updateBtn.setVisible(false);
            listBtn.setVisible(false);
            deleteBtn.setVisible(false);
            label.setVisible(true);
        }
    }//GEN-LAST:event_searchTxtKeyPressed

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        String keyword = searchTxt.getText();
        List<Employee> employeeList = showSearchResult(keyword);
        if (employeeList.size() > 0) {
            showSearchResult(keyword);
            addBtn.setVisible(true);
            updateBtn.setVisible(true);
            listBtn.setVisible(true);
            deleteBtn.setVisible(true);
            label.setVisible(false);

        } else {
            updateBtn.setVisible(false);
            listBtn.setVisible(false);
            deleteBtn.setVisible(false);
            label.setVisible(true);
        }
    }//GEN-LAST:event_searchTxtKeyReleased

    private void searchTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTxtMouseEntered
        String keyword = searchTxt.getText();
        List<Employee> employeeList = showSearchResult(keyword);
        if (employeeList.size() > 0) {
            showSearchResult(keyword);
            addBtn.setVisible(true);
            updateBtn.setVisible(true);
            listBtn.setVisible(true);
            deleteBtn.setVisible(true);
            label.setVisible(false);

        } else {
            updateBtn.setVisible(false);
            listBtn.setVisible(false);
            deleteBtn.setVisible(false);
            label.setVisible(true);
        }
    }//GEN-LAST:event_searchTxtMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton addEmployeeBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTable employeeInfoTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JButton listBtn;
    private javax.swing.JComboBox<String> listName;
    private javax.swing.JButton minimizeBtn;
    private javax.swing.JButton restoreBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables

    private void showEmployeeAllInfo() {
        try {
            List<Employee> employeeList = employeeService.getEmployeeList(1);
            DefaultTableModel model = new DefaultTableModel();
            employeeInfoTable.setModel(model);
            model.addColumn("Id");
            model.addColumn("№");
            model.addColumn("First Name");
            model.addColumn("Last Name");
            model.addColumn("Father Name");
            model.addColumn("Gender");
            model.addColumn("Nationality");
            model.addColumn("Date of Birthday");
            model.addColumn("Identiti");
            model.addColumn("Marital Status");
            model.addColumn("Phone_1");
            model.addColumn("Phone_2");
            model.addColumn("Home_Phone");
            model.addColumn("Country");
            model.addColumn("City");
            model.addColumn("Street");
            model.addColumn("House_Number");
            model.addColumn("Home_Number");
            model.addColumn("Email");
            model.addColumn("Education Type"); 
            model.addColumn("University");
            model.addColumn("Graduation Date");
            model.addColumn("Diploma_number"); 
            model.addColumn("Certification Name");
            model.addColumn("Position");
            model.addColumn("Branch Name");
            model.addColumn("Card Number");
            model.addColumn("Begin To Work");
            model.addColumn("Salary");
            model.addColumn("Note");

            for (Employee employee : employeeList) {
                Object object[] = new Object[]{
                    employee.getId(), employee.getNumber(), employee.getFirstName(), employee.getLastName(), employee.getFatherName(),
                    employee.getGender(), employee.getNationality(), employee.getDob(), employee.getIndentifyNumber(),
                    employee.getMaritalStatus(), employee.getPhone1(), employee.getPhone2(), employee.getHomePhone(),
                    employee.getCountry(), employee.getCity(), employee.getStreet(), employee.getHouseNumber(),
                    employee.getHomeNumber(), employee.geteMail(), employee.getEducationType().getDegreeName(),
                    employee.getUniversity(), employee.getGraduateDate(),
                    employee.getDiplomaNumber(),
                    employee.getCertification(), employee.getPosition().getPositionName(),
                    employee.getBranc().getBranchName(),
                    employee.getCardNumber(), employee.getBeginToWork(), employee.getSalary(), employee.getNote()
                };
                model.addRow(object);
            }
            model.fireTableDataChanged();
            employeeInfoTable.getColumnModel().getColumn(0).setMinWidth(0);
            employeeInfoTable.getColumnModel().getColumn(0).setWidth(0);
            employeeInfoTable.getColumnModel().getColumn(0).setMaxWidth(0);
            employeeInfoTable.getColumnModel().getColumn(1).setMaxWidth(40);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void showEmployeeAddressAndContact() {
        try {
            List<Employee> employeeList = employeeService.getEmployeeList(4);
            DefaultTableModel model = new DefaultTableModel();
            employeeInfoTable.setModel(model);
            model.addColumn("Id");
            model.addColumn("№");
            model.addColumn("First Name");
            model.addColumn("Last Name");
            model.addColumn("Father Name");
            model.addColumn("Phone_1");
            model.addColumn("Phone_2");
            model.addColumn("Home_Phone");
            model.addColumn("Country");
            model.addColumn("City");
            model.addColumn("Street");
            model.addColumn("House_Number");
            model.addColumn("Home_Number");
            model.addColumn("Email");
            model.addColumn("Position");
            model.addColumn("Branch Name");
            model.addColumn("Address in Work");
            model.addColumn("Work Phone");
            for (Employee employee : employeeList) {
                Object object[] = new Object[]{
                    employee.getId(), employee.getNumber(), employee.getFirstName(), employee.getLastName(), employee.getFatherName(),
                    employee.getPhone1(), employee.getPhone2(), employee.getHomePhone(),
                    employee.getCountry(), employee.getCity(), employee.getStreet(), employee.getHouseNumber(), employee.geteMail(),
                    employee.getHomeNumber(), employee.geteMail(),
                    employee.getPosition().getPositionName(),
                    employee.getBranc().getBranchName(), employee.getBranc().getAddress(), employee.getBranc().getPhone()
                };
                model.addRow(object);
            }
            model.fireTableDataChanged();
            employeeInfoTable.getColumnModel().getColumn(0).setMinWidth(0);
            employeeInfoTable.getColumnModel().getColumn(0).setWidth(0);
            employeeInfoTable.getColumnModel().getColumn(0).setMaxWidth(0);
            employeeInfoTable.getColumnModel().getColumn(1).setMaxWidth(40);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void showEmployeeEducationInfo() {
        try {
            List<Employee> employeeList = employeeService.getEmployeeList(3);
            DefaultTableModel model = new DefaultTableModel();
            employeeInfoTable.setModel(model);
            model.addColumn("Id");
            model.addColumn("№");
            model.addColumn("First Name");
            model.addColumn("Last Name");
            model.addColumn("Father Name");
            model.addColumn("Education Type");
             model.addColumn("University");
            model.addColumn("Diploma_number");
            model.addColumn("Graduation Date");
            model.addColumn("Certification Name");
            for (Employee employee : employeeList) {
                Object object[] = new Object[]{
                    employee.getId(), employee.getNumber(), employee.getFirstName(), employee.getLastName(), employee.getFatherName(),
                    employee.getEducationType().getDegreeName(),
                    employee.getUniversity(), employee.getGraduateDate(),
                    employee.getDiplomaNumber(),
                    employee.getDiplomaNumber(), employee.getCertification(),};
                model.addRow(object);
            }
            model.fireTableDataChanged();
            employeeInfoTable.getColumnModel().getColumn(0).setMinWidth(0);
            employeeInfoTable.getColumnModel().getColumn(0).setWidth(0);
            employeeInfoTable.getColumnModel().getColumn(0).setMaxWidth(0);
            employeeInfoTable.getColumnModel().getColumn(1).setMaxWidth(40);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showEmployeePrivateInfo() {
        try {
            List<Employee> employeeList = employeeService.getEmployeeList(2);
            DefaultTableModel model = new DefaultTableModel();
            employeeInfoTable.setModel(model);
            model.addColumn("Id");
            model.addColumn("№");
            model.addColumn("First Name");
            model.addColumn("Last Name");
            model.addColumn("Father Name");
            model.addColumn("Gender");
            model.addColumn("Nationality");
            model.addColumn("Date of Birthday");
            model.addColumn("Identiti");
            model.addColumn("Marital Status");
            model.addColumn("Card Number");

            for (Employee employee : employeeList) {
                Object object[] = new Object[]{
                    employee.getId(), employee.getNumber(), employee.getFirstName(), employee.getLastName(), employee.getFatherName(),
                    employee.getGender(), employee.getNationality(), employee.getDob(), employee.getIndentifyNumber(),
                    employee.getMaritalStatus(),
                    employee.getCardNumber(),};
                model.addRow(object);
            }
            model.fireTableDataChanged();
            employeeInfoTable.getColumnModel().getColumn(0).setMinWidth(0);
            employeeInfoTable.getColumnModel().getColumn(0).setWidth(0);
            employeeInfoTable.getColumnModel().getColumn(0).setMaxWidth(0);
            employeeInfoTable.getColumnModel().getColumn(1).setMaxWidth(40);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    List<Employee> showSearchResult(String keyword) {
        List<Employee> employeeList = null;
        try {
            employeeList = employeeService.searchEmployee(keyword);
            DefaultTableModel model = new DefaultTableModel();
            employeeInfoTable.setModel(model);
            model.addColumn("Id");
            model.addColumn("№");
            model.addColumn("First Name");
            model.addColumn("Last Name");
            model.addColumn("Father Name");
            model.addColumn("Gender");
            model.addColumn("Nationality");
            model.addColumn("Date of Birthday");
            model.addColumn("Identiti");
            model.addColumn("Marital Status");
            model.addColumn("Phone_1");
            model.addColumn("Phone_2");
            model.addColumn("Home_Phone");
            model.addColumn("Country");
            model.addColumn("City");
            model.addColumn("Street");
            model.addColumn("House_Number");
            model.addColumn("Home_Number");
            model.addColumn("Email");
            model.addColumn("Education Type");
            model.addColumn("School Number");
            model.addColumn("School Completion Date");
            model.addColumn("College Name");
            model.addColumn("College Diploma Number");
            model.addColumn("College Completion Date");
            model.addColumn("University_1");
            model.addColumn("Graduation Date of University_1");
            model.addColumn("Diploma_number_1");
            model.addColumn("University_2");
            model.addColumn("Graduation Date of University_2");
            model.addColumn("Diploma_number_2");
            model.addColumn("Certification Name");
            model.addColumn("Position");
            model.addColumn("Branch Name");
            model.addColumn("Card Number");
            model.addColumn("Begin To Work");
            model.addColumn("Salary");
            model.addColumn("Note");
            for (Employee employee : employeeList) {
                Object object[] = new Object[]{
                    employee.getId(), employee.getNumber(), employee.getFirstName(), employee.getLastName(), employee.getFatherName(),
                    employee.getGender(), employee.getNationality(), employee.getDob(), employee.getIndentifyNumber(),
                    employee.getMaritalStatus(), employee.getPhone1(), employee.getPhone2(), employee.getHomePhone(),
                    employee.getCountry(), employee.getCity(), employee.getStreet(), employee.getHouseNumber(),
                    employee.getHomeNumber(), employee.geteMail(), employee.getEducationType().getDegreeName(), 
                    employee.getUniversity(), employee.getGraduateDate(),
                    employee.getDiplomaNumber(),
                    employee.getCertification(), employee.getPosition().getPositionName(),
                    employee.getBranc().getBranchName(),
                    employee.getCardNumber(), employee.getBeginToWork(), employee.getSalary(), employee.getNote()
                };
                model.addRow(object);
            }
            model.fireTableDataChanged();
            employeeInfoTable.getColumnModel().getColumn(0).setMinWidth(0);
            employeeInfoTable.getColumnModel().getColumn(0).setWidth(0);
            employeeInfoTable.getColumnModel().getColumn(0).setMaxWidth(0);
            employeeInfoTable.getColumnModel().getColumn(1).setMaxWidth(40);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employeeList;

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
