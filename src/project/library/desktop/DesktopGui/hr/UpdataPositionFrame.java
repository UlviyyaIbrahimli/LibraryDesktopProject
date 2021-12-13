package project.library.desktop.DesktopGui.hr;

import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import project.library.desktop.Desktop_Gui.Item;
import project.library.desktop.model.Login;
import project.library.desktop.model.employee.Branch;
import project.library.desktop.model.employee.Position;
import project.library.desktop.model.employee.TimeType;
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
public class UpdataPositionFrame extends javax.swing.JFrame {

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
    private Long selecteId;
    private Login login;
    Position position = null;

    public UpdataPositionFrame() {
        initComponents();
    }

    UpdataPositionFrame(DepartmentService departmentService,
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
            this.roleService = roleService;;
            this.selecteId = selectedId;
            this.login = login;
            initComponents();
            this.setDefaultLookAndFeelDecorated(true);
            this.pack();
            this.setLocationRelativeTo(null);
            userTxt.setText("Welcome, " + login.getFirstName() + " " + login.getLastName() + " !");
            this.getContentPane().setBackground(Color.BLUE.darker());
            position = positionService.getPositionById(selecteId);
            jLabel1.setText("UPDATE--> " + position.getPositionName().toUpperCase());
            showOldPositionDate(position);
            showBranchcomboSelected(position);
            showTimeTypeSelectrd(position);
            timeTypeCmb.setRenderer(new UpdataPositionFrame.TwoDecimalRenderer(timeTypeCmb.getRenderer()));
            branchCmb.setRenderer(new UpdataPositionFrame.TwoDecimalRenderer(branchCmb.getRenderer()));
            UIManager.put("OptionPane.background", Color.BLUE.darker().darker());
            UIManager.put("Panel.background", Color.BLUE.darker().darker());
            UIManager.put("OptionPane.messageForeground", Color.BLUE.darker().darker());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        minimizeBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        restoreBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        positionNameTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        positionObligationTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        timeTypeCmb = new javax.swing.JComboBox<>();
        branchCmb = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        clearBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        userTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

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
        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Update Position");

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

        restoreBtn.setBackground(new java.awt.Color(51, 102, 255));
        restoreBtn.setForeground(new java.awt.Color(255, 255, 255));
        restoreBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-restore-window-32.png"))); // NOI18N
        restoreBtn.setBorder(null);
        restoreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreBtnActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 153));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Position Title");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        positionNameTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        positionNameTxt.setForeground(new java.awt.Color(0, 0, 153));
        positionNameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        positionNameTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                positionNameTxtMouseClicked(evt);
            }
        });
        positionNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionNameTxtActionPerformed(evt);
            }
        });
        positionNameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                positionNameTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                positionNameTxtKeyReleased(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 153));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Position obligation");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        positionObligationTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        positionObligationTxt.setForeground(new java.awt.Color(0, 0, 153));
        positionObligationTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        positionObligationTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                positionObligationTxtMouseClicked(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 153));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Time Type");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        timeTypeCmb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        timeTypeCmb.setForeground(new java.awt.Color(0, 0, 153));
        timeTypeCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Time-Type" }));
        timeTypeCmb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        timeTypeCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        branchCmb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        branchCmb.setForeground(new java.awt.Color(0, 0, 153));
        branchCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Branch" }));
        branchCmb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        branchCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel5.setBackground(new java.awt.Color(0, 0, 153));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Branch Name");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));

        clearBtn.setBackground(new java.awt.Color(204, 0, 0));
        clearBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("Clear");
        clearBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0)));
        clearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(0, 0, 204));
        updateBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("Edit");
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 0, 0));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancel");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0)));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        userTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        userTxt.setForeground(new java.awt.Color(0, 0, 153));
        userTxt.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(restoreBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(positionNameTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(positionObligationTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(117, 117, 117)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(branchCmb, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(timeTypeCmb, javax.swing.GroupLayout.Alignment.TRAILING, 0, 257, Short.MAX_VALUE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(170, 170, 170)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)))
                .addGap(0, 0, 0)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(restoreBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(positionNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(positionObligationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeTypeCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(branchCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

    private void minimizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeBtnActionPerformed
        this.setState(ICONIFIED);
    }//GEN-LAST:event_minimizeBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE, TO CLOSE THE PROGRAM ?");
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

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        try {
            String positionTitle = positionNameTxt.getText();
            if ((!positionTitle.isEmpty()) && (positionTitle.matches("[\\p{L}0-9 \\-]+"))) {
                if (positionTitle.length() <= 50) {
                    String positionObligation = positionObligationTxt.getText();
                    if (!(timeTypeCmb.getSelectedItem().equals("Select Time-Type"))) {
                        Item timeItem = (Item) timeTypeCmb.getSelectedItem();
                        if ((!branchCmb.getSelectedItem().equals("Select Branch"))) {
                            Item branchItem = (Item) branchCmb.getSelectedItem();
                            System.out.println("frggvfrrg  "+branchItem.getValue());
                            boolean check = checkPositionNameUnique(positionTitle, branchItem.getId());
                            if (check) {
                                Branch branchP = new Branch();
                                TimeType timeT = new TimeType();
                                branchP.setId(branchItem.getId());
                                timeT.setId(timeItem.getId());
                                Position position = new Position();
                                position.setPositionName(positionTitle);
                                position.setPositionObligation(positionObligation);
                                position.setpTimeType(timeT);
                                position.setBranch(branchP);
                                System.out.println("fv " + branchP.getId());
                                boolean isAddPosition = positionService.updatePosition(selecteId, position);
                                if (isAddPosition) {
                                    JOptionPane.showMessageDialog(null, position.getPositionName().toUpperCase() + " - IS ADDED SUCCESSFULLY ", "SUCCESS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\LibraryDesktopProject\\src\\project\\library\\desktop\\gui\\icon\\tick.png"));
                                } else {
                                    JOptionPane.showMessageDialog(null, "POSITION IS NOT ADDED", "FAIL", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\LibraryDesktopProject\\src\\project\\library\\desktop\\gui\\icon\\report.png"));
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "This position already exists ");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, " Select Branch !");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, " Select Time Type !");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, " Add max 50 Simvol !");
                }
            } else {
                JOptionPane.showMessageDialog(null, " Add Correct Name !");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void positionNameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_positionNameTxtMouseClicked
        positionNameTxt.setForeground(Color.BLUE.darker().darker());
        if (evt.getClickCount() == 2) {
            positionNameTxt.setText("");
        }
    }//GEN-LAST:event_positionNameTxtMouseClicked

    private void positionObligationTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_positionObligationTxtMouseClicked
        if (evt.getClickCount() == 2) {
            positionObligationTxt.setText("");
        }
    }//GEN-LAST:event_positionObligationTxtMouseClicked

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        positionNameTxt.setText("");
        positionObligationTxt.setText("");
        timeTypeCmb.setSelectedItem("Select Time-Type");
        branchCmb.setSelectedItem("Selected Branch");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        PositionFrame positionFrame = new PositionFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        positionFrame.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        PositionFrame positionFrame = new PositionFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        positionFrame.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void positionNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionNameTxtActionPerformed
        positionNameTxt.setForeground(Color.BLUE.darker().darker());

    }//GEN-LAST:event_positionNameTxtActionPerformed

    private void positionNameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_positionNameTxtKeyPressed
        positionNameTxt.setForeground(Color.BLUE.darker().darker());

    }//GEN-LAST:event_positionNameTxtKeyPressed

    private void positionNameTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_positionNameTxtKeyReleased
        positionNameTxt.setForeground(Color.BLUE.darker().darker());

    }//GEN-LAST:event_positionNameTxtKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<String> branchCmb;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton minimizeBtn;
    private javax.swing.JTextField positionNameTxt;
    private javax.swing.JTextField positionObligationTxt;
    private javax.swing.JButton restoreBtn;
    private javax.swing.JComboBox<String> timeTypeCmb;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables

    private void showOldPositionDate(Position position) {
        positionNameTxt.setText(position.getPositionName());
        positionObligationTxt.setText(position.getPositionObligation());
    }

    private void showBranchcomboSelected(Position position) {
        try {
            List<Branch> branchlist = branchService.getBranchList();
            DefaultComboBoxModel model = (DefaultComboBoxModel) branchCmb.getModel();
            for (Branch branch : branchlist) {
                model.addElement(new Item(branch.getId(), branch.getBranchName()));
            }
            model.setSelectedItem(new Item(position.getBranch().getId(), position.getBranch().getBranchName()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showTimeTypeSelectrd(Position position) {
        try {
            List<TimeType> timeTypeList = timeTypeService.timeTypeList();
            DefaultComboBoxModel model = (DefaultComboBoxModel) timeTypeCmb.getModel();
            for (TimeType timeType : timeTypeList) {
                model.addElement(new Item(timeType.getId(), timeType.getTimeTypeName()));
            }
            model.setSelectedItem(new Item(position.getpTimeType().getId(), position.getpTimeType().getTimeTypeName()));
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

    boolean checkPositionNameUnique(String positionName, Long branchId) {
        boolean result = true;
        if (!position.getPositionName().equals(positionName)) {
            try {
                List<Position> pos = positionService.getPositionListByBranchId(branchId);
                for (Position po : pos) {
                    if (po.getPositionName().equals(positionName)) {
                        result = false;
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;

    }
}
