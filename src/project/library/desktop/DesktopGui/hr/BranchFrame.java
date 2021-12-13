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
import project.library.desktop.model.employee.Branch;
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
 * @Ibrahimli Ulviyye
 */
public class BranchFrame extends javax.swing.JFrame {

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

    public BranchFrame() {
        initComponents();
    }

    BranchFrame(DepartmentService departmentService,
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
        userTxt.setText("Welcome, " + login.getFirstName() + " " + login.getLastName() + " !");
        label.setVisible(false);
        this.setDefaultLookAndFeelDecorated(true);
        this.pack();
        this.setLocationRelativeTo(null);
        try {
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.darker().darker());
            UIManager.put("OptionPane.border.background", Color.BLUE.darker().darker());
        } catch (Exception e) {
            e.printStackTrace();
        }
        showBranchData();
        JTableHeader header = branchTable.getTableHeader();
        header.setFont(Font.getFont("Times New Roman"));
        header.setForeground(Color.RED.darker());
        header.setBackground(Color.WHITE.darker().darker().darker());
        branchTable.setGridColor(Color.BLUE.darker());
        branchTable.setRowSelectionAllowed(true);
        branchTable.setSelectionBackground(Color.BLUE.darker());
        branchTable.setSelectionForeground(Color.WHITE);
        branchTable.setShowGrid(true);
        this.getContentPane().setBackground(Color.BLUE.darker());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        restoreBtn = new javax.swing.JButton();
        minimizeBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        addDepartmentBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteDepartmentBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        branchTable = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        searchDepartmentBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        searchTxt = new javax.swing.JTextField();
        label = new javax.swing.JLabel();
        userTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Branch Managment");

        addDepartmentBtn.setBackground(new java.awt.Color(0, 0, 153));
        addDepartmentBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        addDepartmentBtn.setForeground(new java.awt.Color(255, 255, 255));
        addDepartmentBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-add-property-40.png"))); // NOI18N
        addDepartmentBtn.setText("Add");
        addDepartmentBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 255), new java.awt.Color(102, 102, 255), new java.awt.Color(102, 102, 255), new java.awt.Color(102, 102, 255)));
        addDepartmentBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addDepartmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDepartmentBtnActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(0, 0, 153));
        updateBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-update-40 - Copy.png"))); // NOI18N
        updateBtn.setText("Edit");
        updateBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 255), new java.awt.Color(102, 102, 255), new java.awt.Color(102, 102, 255), new java.awt.Color(102, 102, 255)));
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteDepartmentBtn.setBackground(new java.awt.Color(0, 0, 153));
        deleteDepartmentBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        deleteDepartmentBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteDepartmentBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-delete-view-40.png"))); // NOI18N
        deleteDepartmentBtn.setText("Delete");
        deleteDepartmentBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 255), new java.awt.Color(102, 102, 255), new java.awt.Color(102, 102, 255), new java.awt.Color(102, 102, 255)));
        deleteDepartmentBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteDepartmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDepartmentBtnActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        branchTable.setForeground(new java.awt.Color(0, 0, 153));
        branchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(branchTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
        );

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-undo-24.png"))); // NOI18N
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
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

        jButton1.setBackground(new java.awt.Color(153, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        label.setBackground(new java.awt.Color(153, 204, 255));
        label.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        label.setForeground(new java.awt.Color(204, 0, 0));
        label.setText("Result not found");

        userTxt.setEditable(false);
        userTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        userTxt.setForeground(new java.awt.Color(0, 0, 153));
        userTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addDepartmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(deleteDepartmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(searchDepartmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addDepartmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteDepartmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchDepartmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(label)))
                .addGap(9, 9, 9)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        AddBranchFrame addBranchFrame = new AddBranchFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        addBranchFrame.setVisible(true);
    }//GEN-LAST:event_addDepartmentBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        int selectredRow = branchTable.getSelectedRow();
        if (selectredRow != -1) {
            if (branchTable.getSelectedRowCount() == 1) {
                Long selectedId = (Long) branchTable.getValueAt(selectredRow, 0);
                this.dispose();
                UpdateBranchFrame updateBranchFrame = new UpdateBranchFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, selectedId, login);
                updateBranchFrame.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "SELECT ONLY ONE ROW !");
            }
        } else {
            JOptionPane.showMessageDialog(null, "SELECT ROW !");
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteDepartmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDepartmentBtnActionPerformed
        int selectedRow = branchTable.getSelectedRow();
        if (selectedRow != -1) {
            if (branchTable.getSelectedRowCount() == 1) {
                try {
                    Long selectedId = (Long) branchTable.getValueAt(selectedRow, 0);
                    Branch branch = branchService.getBranchById(selectedId);
                    int selectionOption = JOptionPane.showConfirmDialog(null, "ARE YOU SURE DELETE --> " + branch.getBranchName().toUpperCase() + " ? ");
                    if (selectionOption == JOptionPane.YES_OPTION) {
                        boolean isDeleteBranch = branchService.deleteBranc(selectedId);
                        if (isDeleteBranch) {
                            JOptionPane.showMessageDialog(null, branch.getBranchName() + " DELETE !", "SUCCES", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\LibraryDesktopProject\\src\\project\\library\\desktop\\gui\\icon\\tick.png"));
                            showBranchData();
                            this.validate();
                            this.repaint();
                            this.revalidate();//reload
                            List<Position> positions = positionService.getPositionListByBranchId(selectedId);
                            if (positions.size() > 0) {
                                int choose = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO CHANGE THE DUTIES OF  " + branch.getBranchName().toUpperCase());
                                if (choose == JOptionPane.YES_OPTION) {
                                    PositionWithoutBranchFrame positionWithoutBranchFrame = new PositionWithoutBranchFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, selectedId, login);
                                    positionWithoutBranchFrame.setVisible(true);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "DELETE IS FAIL", "FAIL", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\LibraryDesktopProject\\src\\project\\library\\desktop\\gui\\icon\\report.png"));
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE, TO CLOSE THE PROGRAM ?");
        if (choose == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchDepartmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDepartmentBtnActionPerformed
        String keyword = searchTxt.getText();
        List<Branch> brabchList = showBranchDataForSearch(keyword);
        if (brabchList.size() == 0) {
            label.setVisible(true);
            updateBtn.setEnabled(false);
            deleteDepartmentBtn.setEnabled(false);
        } else {
            label.setVisible(false);
            showBranchDataForSearch(keyword);
        }

    }//GEN-LAST:event_searchDepartmentBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        HrFrame1 frame1 = new HrFrame1(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        frame1.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void searchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxtActionPerformed
        String keyword = searchTxt.getText();
        List<Branch> brabchList = showBranchDataForSearch(keyword);
        if (brabchList.size() == 0) {
            label.setVisible(true);
            updateBtn.setEnabled(false);
            deleteDepartmentBtn.setEnabled(false);
        } else {
            updateBtn.setEnabled(true);
            deleteDepartmentBtn.setEnabled(true);
            label.setVisible(false);
            showBranchDataForSearch(keyword);
        }
    }//GEN-LAST:event_searchTxtActionPerformed

    private void searchTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTxtMouseClicked
        String keyword = searchTxt.getText();
        List<Branch> brabchList = showBranchDataForSearch(keyword);
        System.out.println(brabchList.size() == 0);
        if (brabchList.size() == 0) {
            label.setVisible(true);
            updateBtn.setEnabled(false);
            deleteDepartmentBtn.setEnabled(false);
        } else {
            updateBtn.setEnabled(true);
            deleteDepartmentBtn.setEnabled(true);
            label.setVisible(false);
            showBranchDataForSearch(keyword);
        }
        if (evt.getClickCount() == 2) {
            searchTxt.setText("");
        }
    }//GEN-LAST:event_searchTxtMouseClicked

    private void searchDepartmentBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchDepartmentBtnMouseClicked
        String keyword = searchTxt.getText();
        List<Branch> brabchList = showBranchDataForSearch(keyword);
        System.out.println(brabchList.size() == 0);
        if (brabchList.size() == 0) {
            label.setVisible(true);
            updateBtn.setEnabled(false);
            deleteDepartmentBtn.setEnabled(false);
        } else {
            label.setVisible(false);
            showBranchDataForSearch(keyword);
        }
        if (evt.getClickCount() == 2) {
            searchTxt.setText("");
        }
    }//GEN-LAST:event_searchDepartmentBtnMouseClicked

    private void searchTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyPressed
        String keyword = searchTxt.getText();
        List<Branch> brabchList = showBranchDataForSearch(keyword);
        System.out.println(brabchList.size() == 0);
        if (brabchList.size() == 0) {
            label.setVisible(true);
            updateBtn.setEnabled(false);
            deleteDepartmentBtn.setEnabled(false);
        } else {
            updateBtn.setEnabled(true);
            deleteDepartmentBtn.setEnabled(true);
            label.setVisible(false);
            showBranchDataForSearch(keyword);
        }
    }//GEN-LAST:event_searchTxtKeyPressed

    private void searchTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTxtMouseEntered
        String keyword = searchTxt.getText();
        List<Branch> brabchList = showBranchDataForSearch(keyword);
        System.out.println(brabchList.size() == 0);
        if (brabchList.size() == 0) {
            label.setVisible(true);
            updateBtn.setEnabled(false);
            deleteDepartmentBtn.setEnabled(false);
        } else {
            label.setVisible(false);
            showBranchDataForSearch(keyword);
        }
    }//GEN-LAST:event_searchTxtMouseEntered

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        String keyword = searchTxt.getText();
        List<Branch> brabchList = showBranchDataForSearch(keyword);
        if (brabchList.size() == 0) {
            label.setVisible(true);
            updateBtn.setEnabled(false);
            deleteDepartmentBtn.setEnabled(false);
        } else {
            updateBtn.setEnabled(true);
            deleteDepartmentBtn.setEnabled(true);
            label.setVisible(false);
            showBranchDataForSearch(keyword);
        }
    }//GEN-LAST:event_searchTxtKeyReleased

    private void userTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDepartmentBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JTable branchTable;
    private javax.swing.JButton deleteDepartmentBtn;
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
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables

    private void showBranchData() {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            List<Branch> branchList = branchService.getBranchList();
            branchTable.setModel(model);
            model.addColumn("Id");
            model.addColumn("№");
            model.addColumn("Branch Title");
            model.addColumn("Employee Count");
            model.addColumn("Assets");
            model.addColumn("Foundation Date");
            model.addColumn("Address");
            model.addColumn("Phone");
            model.addColumn("E_Mail");
            model.addColumn("Department Title");
            for (Branch branch : branchList) {
                Object object[] = new Object[]{
                    branch.getId(), branch.getNumber(), branch.getBranchName(), branchService.countEmployee(branch.getBranchName()).getEmployeeCount(),
                    branch.getAssets(), branch.getFoundate(),
                    branch.getAddress(), branch.getPhone(), branch.geteMail(), branch.getDepartment().getDepartmentName()
                };
                model.addRow(object);
            }
            branchTable.getColumnModel().getColumn(0).setMinWidth(0);
            branchTable.getColumnModel().getColumn(0).setWidth(0);
            branchTable.getColumnModel().getColumn(0).setMaxWidth(0);
            branchTable.getColumnModel().getColumn(1).setMaxWidth(30);
            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private List<Branch> showBranchDataForSearch(String keyword) {
        List<Branch> branchList = new ArrayList<>();
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            branchList = branchService.searchBranch(keyword);
            branchTable.setModel(model);
            model.addColumn("Id");
            model.addColumn("№");
            model.addColumn("Branch Title");
            model.addColumn("Employee Count");
            model.addColumn("Assets");
            model.addColumn("Foundation Date");
            model.addColumn("Address");
            model.addColumn("Phone");
            model.addColumn("E_Mail");
            model.addColumn("Department Title");
            for (Branch branch : branchList) {
                Object object[] = new Object[]{
                    branch.getId(), branch.getNumber(), branch.getBranchName(), branchService.countEmployee(branch.getBranchName()).getEmployeeCount(),
                    branch.getAssets(), branch.getFoundate(),
                    branch.getAddress(), branch.getPhone(), branch.geteMail(), branch.getDepartment().getDepartmentName()
                };
                model.addRow(object);
            }
            branchTable.getColumnModel().getColumn(0).setMinWidth(0);
            branchTable.getColumnModel().getColumn(0).setWidth(0);
            branchTable.getColumnModel().getColumn(0).setMaxWidth(0);
            branchTable.getColumnModel().getColumn(1).setMaxWidth(30);
            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return branchList;
    }

}
