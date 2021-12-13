package project.library.desktop.DesktopGui.hr;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import project.library.desktop.model.Login;
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
public class PositionFrame extends javax.swing.JFrame {

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

    public PositionFrame() {
        initComponents();
    }

    PositionFrame(DepartmentService departmentService,
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
        label.setVisible(false);
        userTxt.setText("Welcome, " + login.getFirstName() + " " + login.getLastName() + " !");
        this.setDefaultLookAndFeelDecorated(true);
        this.pack();
        this.setLocationRelativeTo(null);
        try {
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker().darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker().darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.brighter());
            UIManager.put("OptionPane.border.background", Color.BLUE.darker().darker().darker().darker());
        } catch (Exception e) {
            e.printStackTrace();
        }
        JTableHeader header = positionTable.getTableHeader();
        header.setFont(Font.getFont("Times New Roman"));
        header.setForeground(Color.RED.darker());
        header.setBackground(Color.WHITE.darker().darker());
        positionTable.setGridColor(Color.BLUE.darker());
        positionTable.setRowSelectionAllowed(true);
        positionTable.setSelectionBackground(Color.BLUE.darker().darker());
        positionTable.setSelectionForeground(Color.WHITE);
        positionTable.setShowGrid(true);
        this.getContentPane().setBackground(Color.BLUE.darker());
        positionTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        minimizeBtn = new javax.swing.JButton();
        searchTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        addPositionBtn = new javax.swing.JButton();
        updatePositionBtn = new javax.swing.JButton();
        deletePositionBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        positionTable = new javax.swing.JTable();
        backBtn2 = new javax.swing.JButton();
        searchDepartmentBtn = new javax.swing.JButton();
        restoreBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        userTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 153));
        setUndecorated(true);

        minimizeBtn.setBackground(new java.awt.Color(51, 102, 255));
        minimizeBtn.setForeground(new java.awt.Color(153, 0, 0));
        minimizeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-minimize-window-48.png"))); // NOI18N
        minimizeBtn.setBorder(null);
        minimizeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeBtnActionPerformed(evt);
            }
        });

        searchTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        searchTxt.setForeground(new java.awt.Color(0, 0, 102));
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

        jLabel1.setBackground(new java.awt.Color(0, 0, 153));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Position Managment");

        label.setBackground(new java.awt.Color(153, 204, 255));
        label.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        label.setForeground(new java.awt.Color(204, 0, 0));
        label.setText("Result not found");

        addPositionBtn.setBackground(new java.awt.Color(0, 0, 153));
        addPositionBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        addPositionBtn.setForeground(new java.awt.Color(255, 255, 255));
        addPositionBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-add-property-40.png"))); // NOI18N
        addPositionBtn.setText("Add");
        addPositionBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 255), new java.awt.Color(102, 102, 255), new java.awt.Color(102, 102, 255), new java.awt.Color(102, 102, 255)));
        addPositionBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addPositionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPositionBtnActionPerformed(evt);
            }
        });

        updatePositionBtn.setBackground(new java.awt.Color(0, 0, 153));
        updatePositionBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        updatePositionBtn.setForeground(new java.awt.Color(255, 255, 255));
        updatePositionBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-update-40 - Copy.png"))); // NOI18N
        updatePositionBtn.setText("Edit");
        updatePositionBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 255), new java.awt.Color(102, 102, 255), new java.awt.Color(102, 102, 255), new java.awt.Color(102, 102, 255)));
        updatePositionBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updatePositionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePositionBtnActionPerformed(evt);
            }
        });

        deletePositionBtn.setBackground(new java.awt.Color(0, 0, 153));
        deletePositionBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        deletePositionBtn.setForeground(new java.awt.Color(255, 255, 255));
        deletePositionBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-delete-view-40.png"))); // NOI18N
        deletePositionBtn.setText("Delete");
        deletePositionBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 255), new java.awt.Color(102, 102, 255), new java.awt.Color(102, 102, 255), new java.awt.Color(102, 102, 255)));
        deletePositionBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deletePositionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePositionBtnActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        positionTable.setForeground(new java.awt.Color(0, 0, 153));
        positionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(positionTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
        );

        backBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-undo-24.png"))); // NOI18N
        backBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn2ActionPerformed(evt);
            }
        });

        searchDepartmentBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-search-24 (4).png"))); // NOI18N
        searchDepartmentBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchDepartmentBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchDepartmentBtnMouseClicked(evt);
            }
        });
        searchDepartmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDepartmentBtnActionPerformed(evt);
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

        jButton1.setBackground(new java.awt.Color(153, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        userTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        userTxt.setForeground(new java.awt.Color(0, 0, 153));
        userTxt.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(addPositionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(updatePositionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(deletePositionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(searchDepartmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(backBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(backBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchDepartmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(searchTxt))
                        .addGap(0, 0, 0)
                        .addComponent(label)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addPositionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updatePositionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deletePositionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minimizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeBtnActionPerformed
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_minimizeBtnActionPerformed

    private void searchTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTxtMouseClicked
        String keyword = searchTxt.getText();
        List<Position> positionList = positionTableForSearch(keyword);
        if (positionList.size() > 0) {
            label.setVisible(false);
            updatePositionBtn.setEnabled(true);
            deletePositionBtn.setEnabled(true);
            positionTableForSearch(keyword);
        } else {
            label.setVisible(true);
            updatePositionBtn.setEnabled(false);
            deletePositionBtn.setEnabled(false);
        }
        if (evt.getClickCount() == 2) {
            searchTxt.setText("");
        }
    }//GEN-LAST:event_searchTxtMouseClicked

    private void searchTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTxtMouseEntered
        String keyword = searchTxt.getText();
        List<Position> positionList = positionTableForSearch(keyword);
        if (positionList.size() > 0) {
            label.setVisible(false);
            updatePositionBtn.setEnabled(true);
            deletePositionBtn.setEnabled(true);
            positionTableForSearch(keyword);
        } else {
            label.setVisible(true);
            updatePositionBtn.setEnabled(false);
            deletePositionBtn.setEnabled(false);
        }
    }//GEN-LAST:event_searchTxtMouseEntered

    private void searchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxtActionPerformed
        String keyword = searchTxt.getText();
        List<Position> positionList = positionTableForSearch(keyword);
        if (positionList.size() > 0) {
            label.setVisible(false);
            updatePositionBtn.setEnabled(true);
            deletePositionBtn.setEnabled(true);
            positionTableForSearch(keyword);
        } else {
            label.setVisible(true);
            updatePositionBtn.setEnabled(false);
            deletePositionBtn.setEnabled(false);
        }
    }//GEN-LAST:event_searchTxtActionPerformed

    private void searchTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyPressed
        String keyword = searchTxt.getText();
        List<Position> positionList = positionTableForSearch(keyword);
        if (positionList.size() > 0) {
            label.setVisible(false);
            updatePositionBtn.setEnabled(true);
            deletePositionBtn.setEnabled(true);
            positionTableForSearch(keyword);
        } else {
            label.setVisible(true);
            updatePositionBtn.setEnabled(false);
            deletePositionBtn.setEnabled(false);
        }
    }//GEN-LAST:event_searchTxtKeyPressed

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        String keyword = searchTxt.getText();
        List<Position> positionList = positionTableForSearch(keyword);
        if (positionList.size() > 0) {
            label.setVisible(false);
            updatePositionBtn.setEnabled(true);
            deletePositionBtn.setEnabled(true);
            positionTableForSearch(keyword);
        } else {
            label.setVisible(true);
            updatePositionBtn.setEnabled(false);
            deletePositionBtn.setEnabled(false);
        }
    }//GEN-LAST:event_searchTxtKeyReleased

    private void addPositionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPositionBtnActionPerformed
        this.dispose();
        AddPositionFrame addPositionFrame = new AddPositionFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        addPositionFrame.setVisible(true);

    }//GEN-LAST:event_addPositionBtnActionPerformed

    private void updatePositionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePositionBtnActionPerformed
        int selectedRow = positionTable.getSelectedRow();
        if (selectedRow != -1) {
            Long selectedId = (Long) positionTable.getValueAt(selectedRow, 0);
            if (positionTable.getSelectedRowCount() == 1) {
                this.dispose();
                UpdataPositionFrame updataPositionFrame = new UpdataPositionFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, selectedId, login);
                updataPositionFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, " SELECT ONLY ONE ROW !");
            }
        } else {
            JOptionPane.showMessageDialog(null, " SELECT ROW !");
        }
    }//GEN-LAST:event_updatePositionBtnActionPerformed

    private void deletePositionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePositionBtnActionPerformed
        try {
            int selectedRow = positionTable.getSelectedRow();
            if (selectedRow != -1) {
                Long selectedId = (Long) positionTable.getValueAt(selectedRow, 0);
                Position position = positionService.getPositionById(selectedId);
                if (positionTable.getSelectedRowCount() == 1) {
                    int deleteChoose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE DELETE THIS POSITION ?");
                    if (deleteChoose == JOptionPane.YES_OPTION) {
                        boolean isDeletePosition = positionService.deletePosition(selectedId);
                        if (isDeletePosition) {
                            JOptionPane.showMessageDialog(null, position.getPositionName() + "   IS DELETE SUCCESSFULLY ", "SUCCESS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\LibraryDesktopProject\\src\\project\\library\\desktop\\gui\\icon\\tick.png"));
                            positionTable();
                            List<Employee> employeess = employeeService.getEmployeeWithoutPosition(selectedId);
                            if (employeess.size() > 0) {
//                            this.validate();
//                            this.repaint();
//                            this.revalidate();//refresh
                                int afterDelete = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO CHANGE THE EMPLOYEE OF \\  " + position.getPositionName());
                                List<Employee> employees = employeeService.getEmployeeWithoutPosition(selectedId);
                                    if (afterDelete == JOptionPane.YES_OPTION) {
                                        EmployeeWithoutPositionFrame employeeWithoutPositionFrame = new EmployeeWithoutPositionFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, selectedId, login);
                                        employeeWithoutPositionFrame.setVisible(true);
                                    }                                
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "POSITION IS NOT DELETE", "FAIL", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\LibraryDesktopProject\\src\\project\\library\\desktop\\gui\\icon\\report.png"));
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, " SELECT ONLY ONE ROW !");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_deletePositionBtnActionPerformed

    private void backBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn2ActionPerformed
        this.dispose();
        HrFrame1 frame1 = new HrFrame1(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        frame1.setVisible(true);
    }//GEN-LAST:event_backBtn2ActionPerformed

    private void searchDepartmentBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchDepartmentBtnMouseClicked

    }//GEN-LAST:event_searchDepartmentBtnMouseClicked

    private void searchDepartmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDepartmentBtnActionPerformed
        String keyword = searchTxt.getText();
        List<Position> positionList = positionTableForSearch(keyword);
        if (positionList.size() > 0) {
            label.setVisible(false);
            updatePositionBtn.setEnabled(true);
            deletePositionBtn.setEnabled(true);
            positionTableForSearch(keyword);
        } else {
            label.setVisible(true);
            updatePositionBtn.setEnabled(false);
            deletePositionBtn.setEnabled(false);
        }
    }//GEN-LAST:event_searchDepartmentBtnActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE, TO CLOSE THE PROGRAM?");
        if (choose == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPositionBtn;
    private javax.swing.JButton backBtn2;
    private javax.swing.JButton deletePositionBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JButton minimizeBtn;
    private javax.swing.JTable positionTable;
    private javax.swing.JButton restoreBtn;
    private javax.swing.JButton searchDepartmentBtn;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JButton updatePositionBtn;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables

    void positionTable() {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            List<Position> getPositionList = positionService.getPositionList();
            positionTable.setModel(model);
            model.addColumn("id");
            model.addColumn("№");
            model.addColumn("Position Title");
            model.addColumn("Position Obligation");
            model.addColumn("Time-type");
            model.addColumn("Work Interval");
            model.addColumn("Pause Interval");
            model.addColumn("Branch Name");
            for (Position position : getPositionList) {
                Object object[] = new Object[]{
                    position.getId(), position.getNumber(), position.getPositionName(), position.getPositionObligation(),
                    position.getpTimeType().getTimeTypeName(), position.getpTimeType().getTimeInterval(),
                    position.getpTimeType().getPauseInterval(), position.getBranch().getBranchName()

                };
                model.addRow(object);
            }
            positionTable.getColumnModel().getColumn(0).setMinWidth(0);
            positionTable.getColumnModel().getColumn(0).setWidth(0);
            positionTable.getColumnModel().getColumn(0).setMaxWidth(0);
            positionTable.getColumnModel().getColumn(1).setMaxWidth(40);
            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    List<Position> positionTableForSearch(String keyword) {
        List<Position> getPositionList = new ArrayList<>();
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }

            };
            getPositionList = positionService.searchPosition(keyword);
            positionTable.setModel(model);
            model.addColumn("id");
            model.addColumn("№");
            model.addColumn("Position Title");
            model.addColumn("Position Obligation");
            model.addColumn("Time-type");
            model.addColumn("Time Intervale");
            model.addColumn("Pause Intervale");
            model.addColumn("Branch Name");
            for (Position position : getPositionList) {
                Object object[] = new Object[]{
                    position.getId(), position.getNumber(), position.getPositionName(), position.getPositionObligation(),
                    position.getpTimeType().getTimeTypeName(), position.getpTimeType().getTimeInterval(),
                    position.getpTimeType().getPauseInterval(), position.getBranch().getBranchName()
                };
                model.addRow(object);
            }
            positionTable.getColumnModel().getColumn(0).setMinWidth(0);
            positionTable.getColumnModel().getColumn(0).setWidth(0);
            positionTable.getColumnModel().getColumn(0).setMaxWidth(0);
            positionTable.getColumnModel().getColumn(1).setMaxWidth(40);
            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return getPositionList;

    }
}
