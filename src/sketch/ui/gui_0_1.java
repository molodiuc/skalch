/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * gui_0_1.java
 *
 * Created on Jun 19, 2009, 3:25:47 PM
 */

package sketch.ui;

import sketch.util.DebugOut;
import javax.swing.event.HyperlinkEvent;

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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sourceViewLabel = new javax.swing.JLabel();
        sourceCodePane = new javax.swing.JScrollPane();
        sourceCodeEditor = new javax.swing.JEditorPane();
        monospaceCheckbox = new javax.swing.JCheckBox();
        controlsLabel = new javax.swing.JLabel();
        selectInputsLabel = new javax.swing.JLabel();
        debugPrintoutsLabel = new javax.swing.JLabel();
        viewSelectionsButton = new javax.swing.JButton();
        selectInputPane = new javax.swing.JScrollPane();
        selectInputList = new javax.swing.JList();
        synthCompletionLabel = new javax.swing.JLabel();
        synthCompletionPane = new javax.swing.JScrollPane();
        synthCompletionList = new javax.swing.JList();
        solversButton = new javax.swing.JButton();
        debugOutPane = new javax.swing.JScrollPane();
        debugOutEditor = new javax.swing.JEditorPane();
        stopButton = new javax.swing.JButton();
        acceptButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Skalch GUI");

        sourceViewLabel.setFont(new java.awt.Font("Dialog", 1, 14));
        sourceViewLabel.setText("Source view");

        sourceCodeEditor.setContentType("text/html");
        sourceCodeEditor.setEditable(false);
        sourceCodeEditor.setFont(new java.awt.Font("SansSerif", 0, 14));
        sourceCodeEditor.setText("<html>\n  <head>\n<style>\nbody {\nfont-size: 12pt;\n}\n</style>\n  </head>\n  <body>\n<p><b>Text like the following example should appear when you select inputs and a synthesized completion</b>. You can select an in-progress completion if synthesis is not complete (possibly the search space is too large).</p>\n\n<pre style=\"font-family: serif;\">\nclass RelevantSketchingClass extends DynamicSketch { // this is a long line\n    def fcn1():\n        <span style=\"color: #ff0000;\"><b>4</b></span> + 3\n}\n</pre>\n<pre style=\"font-family: monospace;\">\n\nsome monospace text\n</pre>\n  </body>\n</html>\n");
        sourceCodePane.setViewportView(sourceCodeEditor);

        monospaceCheckbox.setFont(new java.awt.Font("Dialog", 0, 12));
        monospaceCheckbox.setText("monospace");
        monospaceCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monospaceCheckboxActionPerformed(evt);
            }
        });

        controlsLabel.setFont(new java.awt.Font("Dialog", 1, 14));
        controlsLabel.setText("Controls");

        selectInputsLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        selectInputsLabel.setText("Select inputs / tests (use <ctrl> to select multiple)");

        debugPrintoutsLabel.setFont(new java.awt.Font("Dialog", 1, 14));
        debugPrintoutsLabel.setText("Debug printouts (select to highlight source)");

        viewSelectionsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oxygen/sync.png"))); // NOI18N
        viewSelectionsButton.setText("View selections");
        viewSelectionsButton.setEnabled(false);
        viewSelectionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSelectionsButtonActionPerformed(evt);
            }
        });

        selectInputList.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        selectInputList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        selectInputPane.setViewportView(selectInputList);

        synthCompletionLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        synthCompletionLabel.setText("Select synthesized completions");

        synthCompletionList.setFont(new java.awt.Font("Dialog", 0, 12));
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
        debugOutEditor.setFont(new java.awt.Font("SansSerif", 0, 14));
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
                                        .add(synthCompletionLabel)
                                        .add(selectInputsLabel)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                                .add(viewSelectionsButton)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 65, Short.MAX_VALUE)
                                                .add(acceptButton))
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, selectInputPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, synthCompletionPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)))))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, debugPrintoutsLabel))
                        .add(17, 17, 17)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(sourceViewLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 282, Short.MAX_VALUE)
                        .add(monospaceCheckbox))
                    .add(sourceCodePane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(monospaceCheckbox)
                            .add(sourceViewLabel))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(sourceCodePane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(controlsLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(stopButton)
                            .add(solversButton))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(selectInputsLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(selectInputPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
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
                        .add(debugOutPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void monospaceCheckboxActionPerformed(java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_monospaceCheckboxActionPerformed
        // TODO add your handling code here:
        sourceCodeEditor
                .setText("<html>\n  <head>\n<style>\nbody "
                        + "{\nfont-size: 12pt; font-family: monospace;\n}\n</style>\n "
                        + " </head>\n  <body>\n    <p style=\"margin-top: 0\">\n&nbsp;"
                        + "&nbsp;&nbsp;&nbsp;code 1<span style=\"color: #ff0000;\">??"
                        + "</span><br />\n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + "code2\n    </p>\n    <p style=\"color: #666666;\">\n         "
                        + "grey text\n    </p>\n  </body>\n</html>\n");
        DebugOut.print("monospace", monospaceCheckbox.isSelected());
    }// GEN-LAST:event_monospaceCheckboxActionPerformed

    private void viewSelectionsButtonActionPerformed(
            java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_viewSelectionsButtonActionPerformed
        viewSelections();
    }// GEN-LAST:event_viewSelectionsButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_stopButtonActionPerformed
        // TODO add your handling code here:
        DebugOut.print("stop");
    }// GEN-LAST:event_stopButtonActionPerformed

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_acceptButtonActionPerformed
        // TODO add your handling code here:
        DebugOut.print("accept");
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
            sketch.util.DebugOut
                    .print("hyperlink update", evt.getDescription());
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

    // protected abstract void
    // synthCompletionListValueChanged2(javax.swing.event.ListSelectionEvent
    // evt);

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton acceptButton;
    javax.swing.JLabel controlsLabel;
    public javax.swing.JEditorPane debugOutEditor;
    javax.swing.JScrollPane debugOutPane;
    javax.swing.JLabel debugPrintoutsLabel;
    protected javax.swing.JCheckBox monospaceCheckbox;
    public javax.swing.JList selectInputList;
    javax.swing.JScrollPane selectInputPane;
    javax.swing.JLabel selectInputsLabel;
    protected javax.swing.JButton solversButton;
    public javax.swing.JEditorPane sourceCodeEditor;
    javax.swing.JScrollPane sourceCodePane;
    javax.swing.JLabel sourceViewLabel;
    javax.swing.JButton stopButton;
    javax.swing.JLabel synthCompletionLabel;
    public javax.swing.JList synthCompletionList;
    javax.swing.JScrollPane synthCompletionPane;
    protected javax.swing.JButton viewSelectionsButton;
    // End of variables declaration//GEN-END:variables

}
