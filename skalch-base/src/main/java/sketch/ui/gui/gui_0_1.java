/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * @code standards ignore file
 */
/*
 * gui_0_1.java
 *
 * Created on Jun 19, 2009, 3:25:47 PM
 */
package sketch.ui.gui;

import java.net.URL;

import javax.swing.event.HyperlinkEvent;

import sketch.util.DebugOut;

/**
 * Generated GUI frame using Netbeans. Please only edit in Netbeans to avoid
 * desynchronizing generated segments, and (only for this file) don't use the
 * Eclipse formatter.
 * @author gatoatigrado (nicholas tung) [email: ntung at ntung]
 * @license This file is licensed under BSD license, available at
 *          http://creativecommons.org/licenses/BSD/. While not required, if you
 *          make changes, please consider contributing back!
 */
@SuppressWarnings("all")
public abstract class gui_0_1 extends javax.swing.JFrame {
    private static final long serialVersionUID = -6929286664850956931L;

    /** Creates new form gui_0_1 */
    public gui_0_1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sourceViewLabel = new javax.swing.JLabel();
        sourceCodePane = new javax.swing.JScrollPane();
        sourceCodeEditor = new javax.swing.JEditorPane();
        controlsLabel = new javax.swing.JLabel();
        selectInputsLabel = new javax.swing.JLabel();
        debugPrintoutsLabel = new javax.swing.JLabel();
        viewSelectionsButton = new javax.swing.JButton();
        synthCompletionLabel = new javax.swing.JLabel();
        synthCompletionPane = new javax.swing.JScrollPane();
        synthCompletionList = new javax.swing.JList();
        solversButton = new javax.swing.JButton();
        debugOutPane = new javax.swing.JScrollPane();
        debugOutEditor = new javax.swing.JEditorPane();
        stopButton = new javax.swing.JButton();
        acceptButton = new javax.swing.JButton();
        contextSpinBox = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        statsPane = new javax.swing.JScrollPane();
        statsEditor = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Skalch GUI");

        sourceViewLabel.setFont(new java.awt.Font("Dialog", 1, 14));
        sourceViewLabel.setText("Source view");

        sourceCodeEditor.setContentType("text/html");
        sourceCodeEditor.setEditable(false);
        sourceCodeEditor.setFont(new java.awt.Font("SansSerif", 0, 14));
        sourceCodeEditor.setText("<html>\n  <head>\n<style>\nbody {\nfont-size: 12pt;\n}\n</style>\n  </head>\n  <body>\n<p><b>Text like the following example should appear when you select inputs and a synthesized completion</b>. You can select an in-progress completion if synthesis is not complete (possibly the search space is too large).</p>\n\n<pre style=\"font-family: serif;\">\nclass RelevantSketchingClass extends DynamicSketch { // this is a long line\n    def fcn1():\n        <span style=\"color: #ff0000;\"><b>4</b></span> + 3\n}\n</pre>\n<pre style=\"font-family: monospace;\">\n\nsome monospace text\n</pre>\n  </body>\n</html>\n");
        sourceCodePane.setViewportView(sourceCodeEditor);

        controlsLabel.setFont(new java.awt.Font("Dialog", 1, 14));
        controlsLabel.setText("Controls");

        selectInputsLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        selectInputsLabel.setText("Current statistics and warnings");

        debugPrintoutsLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        debugPrintoutsLabel.setText("Debug output for selected completion");

        viewSelectionsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oxygen/sync.png"))); // NOI18N
        viewSelectionsButton.setText("View selections");
        viewSelectionsButton.setEnabled(false);
        viewSelectionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSelectionsButtonActionPerformed(evt);
            }
        });

        synthCompletionLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        synthCompletionLabel.setText("Select synthesized completions");

        synthCompletionList.setFont(new java.awt.Font("Dialog", 0, 12));
        synthCompletionList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                synthCompletionListMouseClicked(evt);
            }
        });
        synthCompletionList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                synthCompletionListValueChanged(evt);
            }
        });
        synthCompletionPane.setViewportView(synthCompletionList);

        solversButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oxygen/office-chart-ring.png"))); // NOI18N
        solversButton.setText("solvers...");
        solversButton.setEnabled(false);
        solversButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solversButtonActionPerformed(evt);
            }
        });

        debugOutEditor.setContentType("text/html");
        debugOutEditor.setEditable(false);
        debugOutEditor.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        debugOutEditor.setText("<html>\n  <head>\n<style>\nbody {\nfont-size: 12pt;\n}\nul {\nmargin-left: 20pt;\n}\n</style>\n  </head>\n  <body>\n<p><b>Text like the following example should appear when you select inputs and a synthesized completion</b>. You can select an in-progress completion if synthesis is not complete (possibly the search space is too large).</p>\n<ul>\n<li>[<a href=\"line:4\">line 4</a>] - !! set to 2, selecting expression \"q.next\" for a complete line of \"g(q.next.getValue())\"</li>\n<li>[line 12] - ?? set to 13</li>\n</ul>\n  </body>\n</html>\n");
        debugOutEditor.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                debugOutEditorHyperlinkUpdate(evt);
            }
        });
        debugOutPane.setViewportView(debugOutEditor);

        stopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oxygen/process-stop.png"))); // NOI18N
        stopButton.setText("stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        acceptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oxygen/dialog-ok-apply.png"))); // NOI18N
        acceptButton.setText("Accept");
        acceptButton.setEnabled(false);
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        contextSpinBox.setFont(contextSpinBox.getFont().deriveFont(contextSpinBox.getFont().getStyle() & ~java.awt.Font.BOLD));
        contextSpinBox.setModel(new javax.swing.SpinnerNumberModel(3, 0, 3600, 1));
        contextSpinBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                contextSpinBoxStateChanged(evt);
            }
        });

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() & ~java.awt.Font.BOLD));
        jLabel1.setText("context:");

        statsEditor.setContentType("text/html");
        statsEditor.setEditable(false);
        statsEditor.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        statsEditor.setText("<html>\n  <head>\n<style>\nbody {\nfont-size: 12pt;\n}\nul {\nmargin-left: 20pt;\n}\n</style>\n  </head>\n  <body>\n<p><b>Text like the following example should appear when you select inputs and a synthesized completion</b>. You can select an in-progress completion if synthesis is not complete (possibly the search space is too large).</p>\n<ul>\n<li>[<a href=\"line:4\">line 4</a>] - !! set to 2, selecting expression \"q.next\" for a complete line of \"g(q.next.getValue())\"</li>\n<li>[line 12] - ?? set to 13</li>\n</ul>\n  </body>\n</html>\n");
        statsPane.setViewportView(statsEditor);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(controlsLabel)
                    .add(layout.createSequentialGroup()
                        .add(stopButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(solversButton))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, debugOutPane, 0, 0, Short.MAX_VALUE)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                    .add(12, 12, 12)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(statsPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                                        .add(synthCompletionLabel)
                                        .add(layout.createSequentialGroup()
                                            .add(viewSelectionsButton)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 68, Short.MAX_VALUE)
                                            .add(acceptButton))
                                        .add(synthCompletionPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                                        .add(selectInputsLabel))))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, debugPrintoutsLabel))
                        .add(17, 17, 17)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(sourceViewLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 277, Short.MAX_VALUE)
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(contextSpinBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(sourceCodePane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(4, 4, 4)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(sourceViewLabel)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(contextSpinBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jLabel1)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(sourceCodePane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(controlsLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(stopButton)
                            .add(solversButton))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(selectInputsLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(statsPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 131, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(synthCompletionLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(synthCompletionPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(12, 12, 12)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(viewSelectionsButton)
                            .add(acceptButton))
                        .add(18, 18, 18)
                        .add(debugPrintoutsLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(debugOutPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void synthCompletionListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_synthCompletionListMouseClicked
        if (evt.getClickCount() == 2 && viewSelectionsButton.isEnabled()) {
            viewSelections();
        }
    }//GEN-LAST:event_synthCompletionListMouseClicked

    private void contextSpinBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_contextSpinBoxStateChanged
        // TODO add your handling code here:
        changeDisplayedContext((Integer)contextSpinBox.getValue());
    }//GEN-LAST:event_contextSpinBoxStateChanged

    private void viewSelectionsButtonActionPerformed(
            java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_viewSelectionsButtonActionPerformed
        viewSelections();
    }// GEN-LAST:event_viewSelectionsButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_stopButtonActionPerformed
        stopSolver();
    }// GEN-LAST:event_stopButtonActionPerformed

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_acceptButtonActionPerformed
        // TODO add your handling code here:
        acceptSolution();
    }// GEN-LAST:event_acceptButtonActionPerformed

    private void solversButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_solversButtonActionPerformed
        // TODO add your handling code here:
        DebugOut.print("solvers button");
    }// GEN-LAST:event_solversButtonActionPerformed

    private void debugOutEditorHyperlinkUpdate(
            javax.swing.event.HyperlinkEvent evt)
    {// GEN-FIRST:event_debugOutEditorHyperlinkUpdate
        // TODO add your handling code here:
        if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            hyperlinkClicked(evt.getDescription());
        }
    }// GEN-LAST:event_debugOutEditorHyperlinkUpdate

    /** can't change private -> protected abstract with netbeans */
    private void synthCompletionListValueChanged(
            javax.swing.event.ListSelectionEvent evt)
    {// GEN-FIRST:event_synthCompletionListValueChanged
        synthCompletionSelectionChanged(evt);
    }// GEN-LAST:event_synthCompletionListValueChanged

    protected abstract void viewSelections();

    protected abstract void synthCompletionSelectionChanged(
            javax.swing.event.ListSelectionEvent evt);

    protected abstract void hyperlinkClicked(String linkurl);

    protected abstract void stopSolver();

    protected abstract void acceptSolution();

    protected abstract void changeDisplayedContext(int nlines);

    // protected abstract void
    // synthCompletionListValueChanged2(javax.swing.event.ListSelectionEvent
    // evt);
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton acceptButton;
    javax.swing.JSpinner contextSpinBox;
    javax.swing.JLabel controlsLabel;
    public javax.swing.JEditorPane debugOutEditor;
    javax.swing.JScrollPane debugOutPane;
    javax.swing.JLabel debugPrintoutsLabel;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel selectInputsLabel;
    protected javax.swing.JButton solversButton;
    public javax.swing.JEditorPane sourceCodeEditor;
    javax.swing.JScrollPane sourceCodePane;
    javax.swing.JLabel sourceViewLabel;
    public javax.swing.JEditorPane statsEditor;
    protected javax.swing.JScrollPane statsPane;
    protected javax.swing.JButton stopButton;
    javax.swing.JLabel synthCompletionLabel;
    public javax.swing.JList synthCompletionList;
    javax.swing.JScrollPane synthCompletionPane;
    protected javax.swing.JButton viewSelectionsButton;
    // End of variables declaration//GEN-END:variables
}
