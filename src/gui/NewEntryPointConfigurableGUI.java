package gui;

import com.intellij.openapi.project.Project;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import config.ExecutableState;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * GUI for the {@link NewEntryPointConfigurable}
 */
class NewEntryPointConfigurableGUI {
    private JPanel rootPanel;
    private JTextField exeNameTextField;
    private JCheckBox notShowDialogCheckBox;
    private JPanel showConfirmationDialogSetting;
    private JPanel outputPathSetting;
    private JPanel exeNameSetting;
    private JTextField runtimeOutputDirectoryTextField;
    private ExecutableState mConfig;

    void createUI(Project project) {
        mConfig = ExecutableState.getInstance(project);
        exeNameTextField.setText(Objects.requireNonNull(mConfig).getExecutableName());
        runtimeOutputDirectoryTextField.setText(mConfig.getRuntimeOutputDirectory());
        notShowDialogCheckBox.setSelected(mConfig.isNoOverWriteConfirmDialog());
    }

    JPanel getRootPanel() {
        return rootPanel;
    }

    boolean isModified() {
        boolean modified;
        modified = !exeNameTextField.getText().equals(mConfig.getExecutableName());
        modified |= !runtimeOutputDirectoryTextField.getText().equals(mConfig.getRuntimeOutputDirectory());
        modified |= !notShowDialogCheckBox.isSelected() == mConfig.isNoOverWriteConfirmDialog();
        return modified;
    }

    void apply() {
        mConfig.setExecutableName(exeNameTextField.getText());
        mConfig.setRuntimeOutputDirectory(runtimeOutputDirectoryTextField.getText());
        mConfig.setNoOverWriteConfirmDialog(notShowDialogCheckBox.isSelected());
    }

    void reset() {
        exeNameTextField.setText(mConfig.getExecutableName());
        runtimeOutputDirectoryTextField.setText(mConfig.getRuntimeOutputDirectory());
        notShowDialogCheckBox.setSelected(mConfig.isNoOverWriteConfirmDialog());
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.setRequestFocusEnabled(true);
        final Spacer spacer1 = new Spacer();
        rootPanel.add(spacer1, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        showConfirmationDialogSetting = new JPanel();
        showConfirmationDialogSetting.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.add(showConfirmationDialogSetting, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        notShowDialogCheckBox = new JCheckBox();
        notShowDialogCheckBox.setText("Do not show confirmation dialog when same executable name already exists.");
        showConfirmationDialogSetting.add(notShowDialogCheckBox, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        showConfirmationDialogSetting.add(spacer2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        outputPathSetting = new JPanel();
        outputPathSetting.setLayout(new GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.add(outputPathSetting, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Runtime output directory");
        outputPathSetting.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        runtimeOutputDirectoryTextField = new JTextField();
        outputPathSetting.add(runtimeOutputDirectoryTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("%PROJECT_DIR% will be replaced with project root directory.");
        outputPathSetting.add(label2, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("%FILE_DIR% will be replaced with source file's parent directory.");
        outputPathSetting.add(label3, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Default path will be used when not specified.");
        outputPathSetting.add(label4, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        exeNameSetting = new JPanel();
        exeNameSetting.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.add(exeNameSetting, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Executable name");
        exeNameSetting.add(label5, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(80, 16), null, 0, false));
        exeNameTextField = new JTextField();
        exeNameTextField.setAutoscrolls(true);
        exeNameTextField.setEditable(true);
        exeNameTextField.setEnabled(true);
        exeNameTextField.setHorizontalAlignment(10);
        exeNameSetting.add(exeNameTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("%FILENAME% will be replaced to actual filename without extension.");
        label6.setVerticalAlignment(0);
        exeNameSetting.add(label6, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        label5.setLabelFor(exeNameTextField);
    }

    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }
}
