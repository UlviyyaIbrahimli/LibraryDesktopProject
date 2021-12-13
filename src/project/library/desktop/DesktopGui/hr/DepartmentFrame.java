package project.library.desktop.DesktopGui.hr;

import java.awt.Color;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.*;
import javax.swing.table.*;
import project.library.desktop.model.Login;
import project.library.desktop.model.employee.Branch;
import project.library.desktop.model.employee.Department;
import project.library.desktop.service.*;

/**
 *
 * @ Ulviyye Ibrahimli
 */
public class DepartmentFrame extends javax.swing.JFrame {

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

    public DepartmentFrame() {
        initComponents();
    }

    DepartmentFrame(DepartmentService departmentService,
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
        userNameTxt.setText("Welcome, " + login.getFirstName() + " " + login.getLastName() + " !");
        JTableHeader tableHeader = departmentTable.getTableHeader();
        tableHeader.setBackground(Color.black);
        tableHeader.setForeground(Color.RED.darker());
        InputMap im = (InputMap) UIManager.get("Button.focusInputMap");
        im.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
        im.put(KeyStroke.getKeyStroke("released ENTER"), "released");
        KeyStroke tab = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0);
        KeyStroke ctrlTab = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, KeyEvent.CTRL_DOWN_MASK);
        Set<KeyStroke> keys = new HashSet<>();
        keys.add(tab);
        keys.add(ctrlTab);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().setDefaultFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, keys);
        try {
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.darker().darker());
        } catch (Exception e) {
            e.printStackTrace();
        }
        tableHeader.setFont(Font.getFont("Times New Roman"));
        jPanel1.setBackground(Color.BLUE.darker().darker());
        departmentTable.setGridColor(Color.BLUE.darker().darker());
        departmentTable.setRowSelectionAllowed(true);
        departmentTable.setShowGrid(true);
        showDepartmentInfo();
        label.setVisible(false);
        departmentTable.setGridColor(Color.BLUE.darker());
        departmentTable.setSelectionBackground(Color.BLUE.darker().darker());
        departmentTable.setSelectionForeground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        departmentTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        addDepartmentBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteDepartmentBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        restoreBtn = new javax.swing.JButton();
        searchTxt = new javax.swing.JTextField();
        minimizeBtn = new javax.swing.JButton();
        searchDepartmentBtn = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        userNameTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 51));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 51), new java.awt.Color(0, 0, 51), new java.awt.Color(0, 0, 51), new java.awt.Color(0, 0, 51)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        departmentTable.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 102), new java.awt.Color(0, 0, 102)));
        departmentTable.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        departmentTable.setForeground(new java.awt.Color(0, 0, 153));
        departmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        departmentTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        departmentTable.setGridColor(new java.awt.Color(0, 0, 51));
        departmentTable.setSelectionBackground(new java.awt.Color(0, 0, 255));
        jScrollPane1.setViewportView(departmentTable);

        jLabel1.setBackground(new java.awt.Color(0, 0, 153));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Department  Managment");

        addDepartmentBtn.setBackground(new java.awt.Color(0, 0, 153));
        addDepartmentBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        addDepartmentBtn.setForeground(new java.awt.Color(255, 255, 255));
        addDepartmentBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-add-property-40.png"))); // NOI18N
        addDepartmentBtn.setText("Add");
        addDepartmentBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 255), new java.awt.Color(51, 51, 255), new java.awt.Color(51, 51, 255), new java.awt.Color(51, 51, 255)));
        addDepartmentBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addDepartmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDepartmentBtnActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(0, 0, 153));
        updateBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-update-40.png"))); // NOI18N
        updateBtn.setText("Edit");
        updateBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 255), new java.awt.Color(51, 51, 255), new java.awt.Color(51, 51, 255), new java.awt.Color(51, 51, 255)));
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteDepartmentBtn.setBackground(new java.awt.Color(0, 0, 153));
        deleteDepartmentBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        deleteDepartmentBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteDepartmentBtn.setText("Delete");
        deleteDepartmentBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 255), new java.awt.Color(51, 51, 255), new java.awt.Color(102, 102, 255), new java.awt.Color(51, 51, 255)));
        deleteDepartmentBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteDepartmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDepartmentBtnActionPerformed(evt);
            }
        });

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-undo-24 - Copy.png"))); // NOI18N
        backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/close.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        searchTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        searchTxt.setForeground(new java.awt.Color(0, 0, 153));
        searchTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchTxtMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchTxtMousePressed(evt);
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

        searchDepartmentBtn.setForeground(new java.awt.Color(0, 0, 102));
        searchDepartmentBtn.setBorder(null);
        searchDepartmentBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchDepartmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDepartmentBtnActionPerformed(evt);
            }
        });

        label.setBackground(new java.awt.Color(102, 153, 255));
        label.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        label.setForeground(new java.awt.Color(255, 0, 0));
        label.setText("Result not found");

        userNameTxt.setEditable(false);
        userNameTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        userNameTxt.setForeground(new java.awt.Color(0, 0, 153));
        userNameTxt.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn)
                .addGap(0, 0, 0)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addDepartmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(deleteDepartmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(searchDepartmentBtn))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userNameTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchDepartmentBtn)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addDepartmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteDepartmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(label)))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE, TO CLOSE THE PROGRMAM ?");
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

    private void addDepartmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDepartmentBtnActionPerformed
        this.dispose();
        AddDepartmentFrame addDepartmentFrame = new AddDepartmentFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        addDepartmentFrame.setVisible(true);
        this.validate();
        this.repaint();
        this.revalidate();//reload
    }//GEN-LAST:event_addDepartmentBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        int selectedRow = departmentTable.getSelectedRow();
        if (selectedRow != -1) {
            if (departmentTable.getSelectedRowCount() == 1) {
                Long selectedId = (Long) departmentTable.getValueAt(selectedRow, 0);
                this.dispose();
                UpdateDepartmentFrame departmentFrame = new UpdateDepartmentFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, selectedId, login);
                departmentFrame.setVisible(true);
                this.validate();
                this.repaint();
                this.revalidate();//reload
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "SELECT ONLY ONE ROW !");
            }
        } else {
            JOptionPane.showMessageDialog(null, "SELECT  ROW !");
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteDepartmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDepartmentBtnActionPerformed
        int selectedRow = departmentTable.getSelectedRow();
        if (selectedRow != -1) {
            if (departmentTable.getSelectedRowCount() == 1) {
                try {
                    Long selectedId = (Long) departmentTable.getValueAt(selectedRow, 0);
                    Department dep = departmentService.getDepartmentById(selectedId);
                    boolean isDelete = departmentService.deleteDepartment(selectedId);
                    int selectionOption = JOptionPane.showConfirmDialog(null, "ARE YOU SURE, TO DELETE-->" + dep.getDepartmentName().toUpperCase() + " ?");
                    if (selectionOption == JOptionPane.YES_OPTION) {
                        if (isDelete) {
                            JOptionPane.showMessageDialog(null, dep.getDepartmentName().toUpperCase() + " -  IS DELETE SUCCESSFULY", "SUCCESS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\LibraryDesktopProject\\src\\project\\library\\desktop\\gui\\icon\\tick.png"));
                            showDepartmentInfo();
                            this.validate();
                            this.repaint();
                            this.revalidate();//reload
                            List<Branch> branchs = branchService.showBranchForDeleteDep(selectedId);
                            if (branchs.size() > 0) {
                                int choose = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO CHANGE BRANCHES OF-->  " + dep.getDepartmentName().toUpperCase() + " INFORMATION?");
                                if (choose == JOptionPane.YES_OPTION) {
                                    this.dispose();
                                    BranchWithoutDepartmentFrame branchWithoutDepartmentFrame = new BranchWithoutDepartmentFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, selectedId, login);
                                    branchWithoutDepartmentFrame.setVisible(true);
                                    this.validate();
                                    this.repaint();
                                    this.revalidate();//reload
                                    showDepartmentInfo();
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "DEPARTMENT IS NOT DELETE", "FAIL", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\LibraryDesktopProject\\src\\project\\library\\desktop\\gui\\icon\\report.png"));
                        }
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
    }//GEN-LAST:event_deleteDepartmentBtnActionPerformed

    private void searchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxtActionPerformed
        String keyword = searchTxt.getText();
        List<Department> departmentList = searchTable(keyword);
        if (departmentList.size() == 0) {
            label.setVisible(true);
            updateBtn.setEnabled(false);
            deleteDepartmentBtn.setEnabled(false);
        } else {
            label.setVisible(false);
            searchTable(keyword);
            updateBtn.setEnabled(true);
            deleteDepartmentBtn.setEnabled(true);
        }


    }//GEN-LAST:event_searchTxtActionPerformed

    private void searchTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTxtMouseClicked
        String keyword = searchTxt.getText();
        List<Department> departmentList = searchTable(keyword);
        if (departmentList.size() == 0) {
            label.setVisible(true);
            updateBtn.setEnabled(false);
            deleteDepartmentBtn.setEnabled(false);
        } else {
            label.setVisible(false);
            searchTable(keyword);
            updateBtn.setEnabled(true);
            deleteDepartmentBtn.setEnabled(true);
        }
        if (evt.getClickCount() == 2) {
            searchTxt.setText("");
        }
    }//GEN-LAST:event_searchTxtMouseClicked

    private void searchTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyPressed
        String keyword = searchTxt.getText();
        List<Department> departmentList = searchTable(keyword);
        if (departmentList.size() == 0) {
            label.setVisible(true);
            updateBtn.setEnabled(false);
            deleteDepartmentBtn.setEnabled(false);
        } else {
            updateBtn.setEnabled(true);
            deleteDepartmentBtn.setEnabled(true);
            label.setVisible(false);
            searchTable(keyword);
        }
    }//GEN-LAST:event_searchTxtKeyPressed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        HrFrame1 hrFrame1 = new HrFrame1(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        hrFrame1.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void searchDepartmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDepartmentBtnActionPerformed
        String keyword = searchTxt.getText();
        List<Department> departmentList = searchTable(keyword);
        if (departmentList.size() == 0) {
            label.setVisible(true);
            updateBtn.setEnabled(false);
            deleteDepartmentBtn.setEnabled(false);
        } else {
            updateBtn.setEnabled(true);
            deleteDepartmentBtn.setEnabled(true);
            label.setVisible(false);
            searchTable(keyword);
        }
    }//GEN-LAST:event_searchDepartmentBtnActionPerformed

    private void searchTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTxtMouseEntered
        String keyword = searchTxt.getText();
        List<Department> departmentList = searchTable(keyword);
        if (departmentList.size() == 0) {
            label.setVisible(true);
            updateBtn.setEnabled(false);
            deleteDepartmentBtn.setEnabled(false);
        } else {
            updateBtn.setEnabled(true);
            deleteDepartmentBtn.setEnabled(true);
            label.setVisible(false);
            searchTable(keyword);
        }
    }//GEN-LAST:event_searchTxtMouseEntered

    private void searchTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTxtMousePressed
        String keyword = searchTxt.getText();
        List<Department> departmentList = searchTable(keyword);
        if (departmentList.size() == 0) {
            label.setVisible(true);
            updateBtn.setEnabled(false);
            deleteDepartmentBtn.setEnabled(false);
        } else {
            updateBtn.setEnabled(true);
            deleteDepartmentBtn.setEnabled(true);
            label.setVisible(false);
            searchTable(keyword);
        }
    }//GEN-LAST:event_searchTxtMousePressed

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        String keyword = searchTxt.getText();
        List<Department> departmentList = searchTable(keyword);
        if (departmentList.size() == 0) {
            label.setVisible(true);
            updateBtn.setEnabled(false);
            deleteDepartmentBtn.setEnabled(false);
        } else {
            label.setVisible(false);
            searchTable(keyword);
            updateBtn.setEnabled(true);
            deleteDepartmentBtn.setEnabled(true);
        }
    }//GEN-LAST:event_searchTxtKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDepartmentBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton deleteDepartmentBtn;
    private javax.swing.JTable departmentTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JButton minimizeBtn;
    private javax.swing.JButton restoreBtn;
    private javax.swing.JButton searchDepartmentBtn;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextField userNameTxt;
    // End of variables declaration//GEN-END:variables

    private void showDepartmentInfo() {
        try {
            List<Department> departmentList = departmentService.getDepartmentList();
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            departmentTable.setModel(model);
            model.addColumn("Id");
            model.addColumn("№");
            model.addColumn("Department Title");
            model.addColumn("Branch Count");
            model.addColumn("Employee Count");
            model.addColumn("Assets");
            model.addColumn("Department Oblication");
            model.addColumn("Address");
            model.addColumn("FoundDate");
            for (Department department : departmentList) {
                Object object[] = new Object[]{
                    department.getId(), department.getNumber(), department.getDepartmentName(),
                    departmentService.branchCount(department.getId()).getBranchCount(), departmentService.employeeCount(department.getId()).getEmployeeCount(),
                    department.getAssets(), department.getObligation(),
                    department.getAddress(), department.getFoundate()
                };
                model.addRow(object);
            }
            departmentTable.getColumnModel().getColumn(0).setMinWidth(0);
            departmentTable.getColumnModel().getColumn(0).setWidth(0);
            departmentTable.getColumnModel().getColumn(0).setMaxWidth(0);
            departmentTable.getColumnModel().getColumn(1).setMaxWidth(30);
            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private List<Department> searchTable(String keyword) {
        List<Department> departmentList = new ArrayList<>();
        try {
            departmentList = departmentService.searchDepartment(keyword);
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            departmentTable.setModel(model);
            model.addColumn("Id");
            model.addColumn("№");
            model.addColumn("Department Title");
            model.addColumn("Branch Count");
            model.addColumn("Employee Count");
            model.addColumn("Assets");
            model.addColumn("Department Oblication");
            model.addColumn("Address");
            model.addColumn("FoundDate");

            for (Department department : departmentList) {
                Object object[] = new Object[]{
                    department.getId(), department.getNumber(), department.getDepartmentName(),
                    departmentService.branchCount(department.getId()).getBranchCount(), departmentService.employeeCount(department.getId()).getEmployeeCount(),
                    department.getAssets(), department.getObligation(),
                    department.getAddress(), department.getFoundate()
                };
                model.addRow(object);
            }
            departmentTable.getColumnModel().getColumn(0).setMinWidth(0);
            departmentTable.getColumnModel().getColumn(0).setWidth(0);
            departmentTable.getColumnModel().getColumn(0).setMaxWidth(0);
            departmentTable.getColumnModel().getColumn(1).setMaxWidth(30);
            model.fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return departmentList;
    }
}
