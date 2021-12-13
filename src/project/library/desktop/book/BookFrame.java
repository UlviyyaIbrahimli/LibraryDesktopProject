package project.library.desktop.book;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
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
import project.library.desktop.model.Book;
import project.library.desktop.model.Login;
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
public class BookFrame extends javax.swing.JFrame {

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
    String keyword = "";

    public BookFrame() {
        initComponents();
    }

    BookFrame(DepartmentService departmentService,
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
        listCustomCombo.setRenderer(new BookFrame.TwoDecimalRenderer(listCustomCombo.getRenderer()));
        label.setVisible(false);
        this.setDefaultLookAndFeelDecorated(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLUE.darker().darker());
        showBookInfoTable();
        listCustomCombo.setVisible(false);
        bookTable.setShowGrid(true);
        bookTable.setDefaultEditor(Object.class, null);
        bookTable.setRowSelectionAllowed(true);
        bookTable.setGridColor(Color.BLUE.darker().darker());
        bookTable.setSelectionBackground(Color.BLUE.darker().darker());
        bookTable.setSelectionForeground(Color.WHITE);
        bookTable.setShowGrid(true);
        JTableHeader tableHeader = bookTable.getTableHeader();
        tableHeader.setForeground(Color.RED.darker());
        tableHeader.setBackground(Color.WHITE);
        userTxt.setText("Welcome, " + login.getFirstName() + " " + login.getLastName() + " !");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        listCustomCombo = new javax.swing.JComboBox<>();
        searchDepartmentBtn = new javax.swing.JButton();
        searchTxt = new javax.swing.JTextField();
        label = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        restoreBtn1 = new javax.swing.JButton();
        minimizeBtn1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        backBtn1 = new javax.swing.JButton();
        userTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 102));
        setUndecorated(true);

        bookTable.setBackground(new java.awt.Color(204, 204, 255));
        bookTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bookTable.setForeground(new java.awt.Color(0, 0, 51));
        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        bookTable.setGridColor(new java.awt.Color(51, 0, 51));
        bookTable.setSelectionBackground(new java.awt.Color(51, 0, 51));
        jScrollPane1.setViewportView(bookTable);

        addBtn.setBackground(new java.awt.Color(0, 0, 102));
        addBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/add (1).png"))); // NOI18N
        addBtn.setText("Add");
        addBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(0, 0, 102));
        updateBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-update-40 - Copy.png"))); // NOI18N
        updateBtn.setText("Edit");
        updateBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(0, 0, 102));
        deleteBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-delete-view-40_1.png"))); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 102));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Custom Show");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        listCustomCombo.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        listCustomCombo.setForeground(new java.awt.Color(0, 0, 102));
        listCustomCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Book's Info", "Book's Located Info", "Book's All Info", " " }));
        listCustomCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        listCustomCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listCustomCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listCustomComboItemStateChanged(evt);
            }
        });
        listCustomCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listCustomComboActionPerformed(evt);
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

        searchTxt.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        searchTxt.setForeground(new java.awt.Color(51, 0, 51));
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

        label.setBackground(new java.awt.Color(153, 204, 255));
        label.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        label.setForeground(new java.awt.Color(204, 0, 0));
        label.setText("Result not found :(");

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

        jLabel1.setBackground(new java.awt.Color(0, 0, 102));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Books");

        backBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/library/desktop/gui/icon/icons8-undo-24.png"))); // NOI18N
        backBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn1ActionPerformed(evt);
            }
        });

        userTxt.setEditable(false);
        userTxt.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        userTxt.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(minimizeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restoreBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addComponent(addBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(listCustomCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(searchDepartmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(minimizeBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(restoreBtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listCustomCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(155, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchDepartmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label)
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        this.dispose();
        AddBookFrame addBookFrame = new AddBookFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, login);
        addBookFrame.setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        int selectredRow = bookTable.getSelectedRow();
        if (selectredRow != -1) {
            if (bookTable.getSelectedRowCount() == 1) {
                Long selectedId = (Long) bookTable.getValueAt(selectredRow, 0);
                this.dispose();
                UpdateBookFrame bookUpdate = new UpdateBookFrame(departmentService, positionService, branchService, employeeService, timeTypeService, educationTypeService, bookService, authorService, subjectService, bookShelfService, bookRoomService, readRoomService, readTableService, languageService, readerService, orderInLibService, orderInHomeService, giveBackBookService, loginService, roleService, selectedId, login);
                bookUpdate.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "SELECT ONLY ONE ROW!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "SELECT ROW!");
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        try {
            int selectedRow = bookTable.getSelectedRow();
            if (selectedRow != -1) {
                if (bookTable.getSelectedRowCount() == 1) {
                    Long selectedId = (Long) bookTable.getValueAt(selectedRow, 0);
                    Book book = bookService.getBookById(selectedId);
                    int selectionOption = JOptionPane.showConfirmDialog(null, "ARE YOU SURE DELETE --> " + book.getTitle().toUpperCase() + " ? ");
                    if (selectionOption==JOptionPane.YES_OPTION) {
                        boolean isDeleteBook = bookService.deleteBook(selectedId);
                        if (isDeleteBook) {
                            JOptionPane.showMessageDialog(null, " DELETING IS SUCCESSFUL!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/tick.png"));
                            showBookInfoTable();
                            Book bs = bookService.getBookById(selectedId);
                            Integer emp = bs.getBookShelf().getEmptyCapacity();
                            Long shelfId = bs.getBookShelf().getId();
                            boolean updateBookShelfEmp = bookShelfService.updateEmpity(shelfId, emp + 1);
                            if (updateBookShelfEmp) {
                                System.out.println("update emptyCapacity!");
                            } else {
                                System.out.println("update Empty_Capacity Fail !");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "DELETING IS FAIL", "FAIL", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\user\\Desktop\\java/report.png"));

                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "SELECT ONLY ONE ROW!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "SELECT ROW!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void listCustomComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listCustomComboItemStateChanged
        searchTxt.setText("");
        if (listCustomCombo.getSelectedIndex() == 0) {
            showBookInfoTable();
        } else if (listCustomCombo.getSelectedIndex() == 1) {
            showBookLocatedTable();
        } else if (listCustomCombo.getSelectedIndex() == 2) {
            showBookDataTable();
        }
    }//GEN-LAST:event_listCustomComboItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        listCustomCombo.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void searchDepartmentBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchDepartmentBtnMouseClicked
        String keyword = searchTxt.getText();
        List<Book> bookList = showBookDataForSearch(keyword);
        System.out.println(bookList.size() == 0);
        if (bookList.size() == 0) {
            label.setVisible(true);
            updateBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
        } else {
            label.setVisible(false);
            showBookDataForSearch(keyword);
        }
        if (evt.getClickCount() == 2) {
            searchTxt.setText("");
        }
    }//GEN-LAST:event_searchDepartmentBtnMouseClicked

    private void searchDepartmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDepartmentBtnActionPerformed
        String keyword = searchTxt.getText();
        List<Book> bookList = showBookDataForSearch(keyword);
        System.out.println(bookList.size() == 0);
        if (bookList.size() == 0) {
            label.setVisible(true);
            updateBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
        } else {
            label.setVisible(false);
            showBookDataForSearch(keyword);
        }
    }//GEN-LAST:event_searchDepartmentBtnActionPerformed

    private void searchTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTxtMouseClicked
        String keyword = searchTxt.getText();
        List<Book> bookList = showBookDataForSearch(keyword);
        System.out.println(bookList.size() == 0);
        if (bookList.size() == 0) {
            label.setVisible(true);
            updateBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
        } else {
            label.setVisible(false);
            showBookDataForSearch(keyword);
            updateBtn.setEnabled(true);
            deleteBtn.setEnabled(true);
        }
        if (evt.getClickCount() == 2) {
            searchTxt.setText("");
        }
    }//GEN-LAST:event_searchTxtMouseClicked

    private void searchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxtActionPerformed
        String keyword = searchTxt.getText();
        List<Book> brabchList = showBookDataForSearch(keyword);
        System.out.println(brabchList.size() == 0);
        if (brabchList.size() == 0) {
            label.setVisible(true);
            updateBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
        } else {
            label.setVisible(false);
            showBookDataForSearch(keyword);
            updateBtn.setEnabled(true);
            deleteBtn.setEnabled(true);
        }
    }//GEN-LAST:event_searchTxtActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "ARE YOU SURE, TO CLOSE THE PROGRAM ? ");
        if (choose == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            this.setVisible(true);
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

    private void listCustomComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listCustomComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listCustomComboActionPerformed

    private void searchTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyPressed
        String keyword = searchTxt.getText();
        List<Book> bookList = showBookDataForSearch(keyword);
        System.out.println(bookList.size() == 0);
        if (bookList.size() == 0) {
            label.setVisible(true);
            updateBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
        } else {
            label.setVisible(false);
            showBookDataForSearch(keyword);
            updateBtn.setEnabled(true);
            deleteBtn.setEnabled(true);
        }

    }//GEN-LAST:event_searchTxtKeyPressed

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        String keyword = searchTxt.getText();
        List<Book> brabchList = showBookDataForSearch(keyword);
        System.out.println(brabchList.size() == 0);
        if (brabchList.size() == 0) {
            label.setVisible(true);
            updateBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
        } else {
            label.setVisible(false);
            showBookDataForSearch(keyword);
            updateBtn.setEnabled(true);
            deleteBtn.setEnabled(true);
        }
    }//GEN-LAST:event_searchTxtKeyReleased

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        if (evt.getClickCount() == 2) {
            listCustomCombo.setVisible(false);
        }
    }//GEN-LAST:event_jButton4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn1;
    private javax.swing.JTable bookTable;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JComboBox<String> listCustomCombo;
    private javax.swing.JButton minimizeBtn1;
    private javax.swing.JButton restoreBtn1;
    private javax.swing.JButton searchDepartmentBtn;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables

    private void showBookDataTable() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            List<Book> bookList = bookService.allBookList(1);
            model.addColumn("Id");
            model.addColumn("№");
            model.addColumn("Title");
            model.addColumn("ISBN");
            model.addColumn("Page");
            model.addColumn("Publidher");
            model.addColumn("Edition");
            model.addColumn("Subject");
            model.addColumn("Abstract");
            model.addColumn("Book Star");
            model.addColumn("Language");
            model.addColumn("Release Date");
            model.addColumn("Author Full Name");
            model.addColumn("Book Case");
            model.addColumn("Room Floor");
            model.addColumn("Room Number");
            model.addColumn("Shelf Number");
            model.addColumn("All Book Count");
            model.addColumn("Limit Time");
            model.addColumn("Limit Day");
            bookTable.setModel(model);
            for (Book book : bookList) {
                Object object[] = new Object[]{
                    book.getId(), book.getNumber(), book.getTitle(), book.getIsbn(), book.getPage(),
                    book.getPublisher(), book.getEdition(), book.getSubjects().getSubjectName(),
                    book.getbAbstract(), book.getStar(), book.getLanguage().getBookLanguage(),
                    book.getReleaseDate(), book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName(),
                    book.getbCase().getCaseName(), book.getBookRoom().getFloor(), book.getBookRoom().getNumber(),
                    book.getBookShelf().getShelfNumber(), book.getAllBookCount(), book.getLimitTime(), book.getLimitDay()
                };
                model.addRow(object);
            }

            bookTable.getColumnModel().getColumn(0).setMinWidth(0);
            bookTable.getColumnModel().getColumn(0).setWidth(0);
            bookTable.getColumnModel().getColumn(0).setMaxWidth(0);
            model.fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    void showBookInfoTable() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            List<Book> bookList = bookService.allBookList(2);
            model.addColumn("Id");
            model.addColumn("№");
            model.addColumn("Title");
            model.addColumn("ISBN");
            model.addColumn("Page");
            model.addColumn("Publidher");
            model.addColumn("Edition");
            model.addColumn("Abstract");
            model.addColumn("Book Star");
            model.addColumn("Language");
            model.addColumn("Release Date");
            model.addColumn("Author Full Name");
            bookTable.setModel(model);
            for (Book book : bookList) {
                Object object[] = new Object[]{
                    book.getId(), book.getNumber(), book.getTitle(), book.getIsbn(), book.getPage(),
                    book.getPublisher(), book.getEdition(),
                    book.getbAbstract(), book.getStar(), book.getLanguage().getBookLanguage(),
                    book.getReleaseDate(), book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName()
                };
                model.addRow(object);
            }
            bookTable.getColumnModel().getColumn(0).setMinWidth(0);
            bookTable.getColumnModel().getColumn(0).setWidth(0);
            bookTable.getColumnModel().getColumn(0).setMaxWidth(0);
            model.fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    void showBookLocatedTable() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            List<Book> bookList = bookService.allBookList(3);
            model.addColumn("Id");
            model.addColumn("№");
            model.addColumn("ISBN");
            model.addColumn("Title");
            model.addColumn("Page");
            model.addColumn("Publidher");
            model.addColumn("Edition");
            model.addColumn("Subjects");
            model.addColumn("Book Room Floor");
            model.addColumn("Book Room Number");
            model.addColumn("Book Shelf Number");
            bookTable.setModel(model);
            for (Book book : bookList) {
                Object object[] = new Object[]{
                    book.getId(), book.getNumber(), book.getIsbn(), book.getTitle(), book.getPage(),
                    book.getPublisher(), book.getEdition(), book.getSubjects().getSubjectName(),
                    book.getBookRoom().getFloor(), book.getBookRoom().getNumber(), book.getBookShelf().getShelfNumber()
                };
                model.addRow(object);
            }

            bookTable.getColumnModel().getColumn(0).setMinWidth(0);
            bookTable.getColumnModel().getColumn(0).setWidth(0);
            bookTable.getColumnModel().getColumn(0).setMaxWidth(0);
            model.fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private List<Book> showBookDataForSearch(String keyword) {
        List<Book> bookList = new ArrayList<>();
        try {
            DefaultTableModel model = new DefaultTableModel();
            bookList = bookService.searchBook(keyword);
            model.addColumn("Id");
            model.addColumn("№");
            model.addColumn("Title");
            model.addColumn("ISBN");
            model.addColumn("Page");
            model.addColumn("Publidher");
            model.addColumn("Edition");
            model.addColumn("Subject");
            model.addColumn("Abstract");
            model.addColumn("Book Star");
            model.addColumn("Language");
            model.addColumn("Release Date");
            model.addColumn("Author Full Name");
            model.addColumn("Book Case");
            model.addColumn("Room Floor");
            model.addColumn("Room Number");
            model.addColumn("Shelf Number");
            model.addColumn("All Book Count");
            model.addColumn("Limit Time");
            model.addColumn("Limit Day");
            bookTable.setModel(model);
            for (Book book : bookList) {
                Object object[] = new Object[]{
                    book.getId(), book.getNumber(), book.getTitle(), book.getIsbn(), book.getPage(),
                    book.getPublisher(), book.getEdition(), book.getSubjects().getSubjectName(),
                    book.getbAbstract(), book.getStar(), book.getLanguage().getBookLanguage(),
                    book.getReleaseDate(), book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName() + " " + book.getAuthor().getFatherName(),
                    book.getbCase().getCaseName(), book.getBookRoom().getFloor(), book.getBookRoom().getNumber(),
                    book.getBookShelf().getShelfNumber(), book.getAllBookCount(), book.getLimitTime(), book.getLimitDay()
                };
                model.addRow(object);
            }

            bookTable.getColumnModel().getColumn(0).setMinWidth(0);
            bookTable.getColumnModel().getColumn(0).setWidth(0);
            bookTable.getColumnModel().getColumn(0).setMaxWidth(0);
            bookTable.getColumnModel().getColumn(1).setMaxWidth(40);
            model.fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bookList;

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
}
