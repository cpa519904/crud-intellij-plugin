package com.github.mars05.crud.intellij.plugin.action;

import com.github.mars05.crud.intellij.plugin.util.OrmType;
import com.github.mars05.crud.intellij.plugin.util.SelectionContext;
import com.google.common.base.Preconditions;
import com.intellij.ide.util.PackageChooserDialog;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.TextBrowseFolderListener;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiPackage;
import com.intellij.psi.search.GlobalSearchScope;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author xiaoyu
 */
public class CrudDirSelectInfoStep extends ModuleWizardStep {
    private JPanel myMainPanel;
    private JComboBox myFrameComboBox;
    private JCheckBox myControllerCheckBox;
    private JCheckBox myController30CheckBox;
    private JTextField myControllerField;
    private JTextField myController30Field;
    private JCheckBox myServiceCheckBox;
    private JCheckBox myService30CheckBox;
    private JTextField myServiceField;
    private JTextField myService30Field;
    private JCheckBox myDaoCheckBox;
    private JCheckBox myDalCheckBox;
    private JTextField myDaoField;
    private JTextField myDalField;
    private JPanel myMapperField;
    private JButton myControllerChoose;
    private JButton myController30Choose;
    private JButton myServiceChoose;
    private JButton myService30Choose;
    private JButton myDaoChoose;
    private JButton myDalChoose;
    private JCheckBox myModelCheckBox;
    private JCheckBox myModel30CheckBox;
    private JTextField myModelField;
    private JTextField myModel30Field;
    private JButton myModelChoose;
    private JButton myModel30Choose;
    private JPanel myPackagePanel;
    private JLabel myMapperLabel;

    private Project myProject;
    private Module myModule;

    public CrudDirSelectInfoStep(Project project, Module module) {
        myProject = project;
        myModule = module;
        myControllerField.setText(SelectionContext.getControllerPackage());
        myController30Field.setText(SelectionContext.getControllerExtPackage());
        myServiceField.setText(SelectionContext.getServicePackage());
        myService30Field.setText(SelectionContext.getServiceExtPackage());
        myDaoField.setText(SelectionContext.getDaoPackage());
        myDalField.setText(SelectionContext.getDalPackage());
        myModelField.setText(SelectionContext.getModelPackage());
        myModel30Field.setText(SelectionContext.getModelExtPackage());
        ((TextFieldWithBrowseButton) myMapperField).setText(SelectionContext.getMapperDir());

        myControllerCheckBox.addChangeListener(e -> checkBoxSetup(myControllerCheckBox.isSelected()));
        myController30CheckBox.addChangeListener(e -> checkBoxSetup(myController30CheckBox.isSelected()));
        myService30CheckBox.addChangeListener(e -> checkBoxSetup(myService30CheckBox.isSelected()));
        myServiceCheckBox.addChangeListener(e -> checkBoxSetup(myServiceCheckBox.isSelected()));
        myDaoCheckBox.addChangeListener(e -> checkBoxSetup(myDaoCheckBox.isSelected()));
        myDalCheckBox.addChangeListener(e -> checkBoxSetup(myDalCheckBox.isSelected()));
        myModelCheckBox.addChangeListener(e -> checkBoxSetup(myModelCheckBox.isSelected()));
        myModel30CheckBox.addChangeListener(e -> checkBoxSetup(myModel30CheckBox.isSelected()));

        myFrameComboBox.addItemListener(e -> switchFrame());

        myControllerChoose.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageChooserDialog dialog = new PackageChooserDialog("Controller Package Choose", project);
                dialog.selectPackage(myControllerField.getText());
                if (dialog.showAndGet()) {
                    PsiPackage selectedPackage = dialog.getSelectedPackage();
                    myControllerField.setText(selectedPackage.getQualifiedName());
                }
            }
        });

        myController30Choose.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageChooserDialog dialog = new PackageChooserDialog("Controller30 Package Choose", project);
                dialog.selectPackage(myController30Field.getText());
                if (dialog.showAndGet()) {
                    PsiPackage selectedPackage = dialog.getSelectedPackage();
                    myController30Field.setText(selectedPackage.getQualifiedName());
                }
            }
        });
        myServiceChoose.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageChooserDialog dialog = new PackageChooserDialog("Service Package Choose", project);
                dialog.selectPackage(myServiceField.getText());
                if (dialog.showAndGet()) {
                    PsiPackage selectedPackage = dialog.getSelectedPackage();
                    myServiceField.setText(selectedPackage.getQualifiedName());
                }
            }
        });
        myService30Choose.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageChooserDialog dialog = new PackageChooserDialog("Service30 Package Choose", project);
                dialog.selectPackage(myService30Field.getText());
                if (dialog.showAndGet()) {
                    PsiPackage selectedPackage = dialog.getSelectedPackage();
                    myService30Field.setText(selectedPackage.getQualifiedName());
                }
            }
        });
        myDaoChoose.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageChooserDialog dialog = new PackageChooserDialog("Dao Package Choose", project);
                dialog.selectPackage(myDaoField.getText());
                if (dialog.showAndGet()) {
                    PsiPackage selectedPackage = dialog.getSelectedPackage();
                    myDaoField.setText(selectedPackage.getQualifiedName());
                }
            }
        });
        myDalChoose.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageChooserDialog dialog = new PackageChooserDialog("Dal Package Choose", project);
                dialog.selectPackage(myDalField.getText());
                if (dialog.showAndGet()) {
                    PsiPackage selectedPackage = dialog.getSelectedPackage();
                    myDalField.setText(selectedPackage.getQualifiedName());
                }
            }
        });
        myModelChoose.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageChooserDialog dialog = new PackageChooserDialog("Model Package Choose", project);
                dialog.selectPackage(myModelField.getText());
                if (dialog.showAndGet()) {
                    PsiPackage selectedPackage = dialog.getSelectedPackage();
                    myModelField.setText(selectedPackage.getQualifiedName());
                }
            }
        });
        myModel30Choose.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageChooserDialog dialog = new PackageChooserDialog("Model30 Package Choose", project);
                dialog.selectPackage(myModel30Field.getText());
                if (dialog.showAndGet()) {
                    PsiPackage selectedPackage = dialog.getSelectedPackage();
                    myModel30Field.setText(selectedPackage.getQualifiedName());
                }
            }
        });
        switchFrame();
    }

    @Override
    public JComponent getComponent() {
        return myMainPanel;
    }

    @Override
    public boolean validate() throws ConfigurationException {
        if(OrmType.MYBATIS_EXT ==myFrameComboBox.getSelectedIndex()){
            if (!myModel30CheckBox.isSelected() && !myDalCheckBox.isSelected() && !myService30CheckBox.isSelected() && !myController30CheckBox.isSelected()) {
                throw new ConfigurationException("未选择需要生成的文件");
            }
        }else{
            if (!myModelCheckBox.isSelected() && !myDaoCheckBox.isSelected() && !myServiceCheckBox.isSelected() && !myControllerCheckBox.isSelected()) {
                throw new ConfigurationException("未选择需要生成的文件");
            }
        }

        JavaPsiFacade facade = JavaPsiFacade.getInstance(myProject);
        if (OrmType.MYBATIS == myFrameComboBox.getSelectedIndex()) {
            try {
                Preconditions.checkNotNull(facade.findClass("org.apache.ibatis.session.SqlSession", GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(myModule)),
                        "org.apache.ibatis.session.SqlSession 未找到");
                Preconditions.checkNotNull(facade.findClass("org.mybatis.spring.SqlSessionFactoryBean", GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(myModule)),
                        "org.mybatis.spring.SqlSessionFactoryBean 未找到");
                if (myDaoCheckBox.isSelected()) {
                    Preconditions.checkNotNull(facade.findClass("com.github.pagehelper.Page", GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(myModule)),
                            "com.github.pagehelper.Page 未找到");
                }
            } catch (Exception e) {
                throw new ConfigurationException(e.getMessage(), "缺少依赖");
            }
            SelectionContext.setOrmType(OrmType.MYBATIS);
        } else if (OrmType.JPA == myFrameComboBox.getSelectedIndex()) {
            try {
                Preconditions.checkNotNull(facade.findClass("javax.persistence.Table", GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(myModule)),
                        "javax.persistence.Table 未找到");
                Preconditions.checkNotNull(facade.findClass("org.springframework.data.jpa.repository.JpaRepository", GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(myModule)),
                        "org.springframework.data.jpa.repository.JpaRepository 未找到");
                Preconditions.checkNotNull(facade.findClass("org.springframework.data.domain.Page", GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(myModule)),
                        "org.springframework.data.domain.Page 未找到");
            } catch (Exception e) {
                throw new ConfigurationException(e.getMessage(), "缺少依赖");
            }
            SelectionContext.setOrmType(OrmType.JPA);
        }else if(OrmType.MYBATIS_EXT == myFrameComboBox.getSelectedIndex()){
            try {
                Preconditions.checkNotNull(facade.findClass("org.apache.ibatis.session.SqlSession", GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(myModule)),
                        "org.apache.ibatis.session.SqlSession 未找到");
                Preconditions.checkNotNull(facade.findClass("org.mybatis.spring.SqlSessionFactoryBean", GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(myModule)),
                        "org.mybatis.spring.SqlSessionFactoryBean 未找到");
                if (myDaoCheckBox.isSelected()) {
                    Preconditions.checkNotNull(facade.findClass("com.github.pagehelper.Page", GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(myModule)),
                            "com.github.pagehelper.Page 未找到");
                }
            } catch (Exception e) {
                throw new ConfigurationException(e.getMessage(), "缺少依赖");
            }
            SelectionContext.setOrmType(OrmType.MYBATIS_EXT);
        }else if(OrmType.MYBATIS_SAAS == myFrameComboBox.getSelectedIndex()){
            try {
                Preconditions.checkNotNull(facade.findClass("org.apache.ibatis.session.SqlSession", GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(myModule)),
                        "org.apache.ibatis.session.SqlSession 未找到");
                Preconditions.checkNotNull(facade.findClass("org.mybatis.spring.SqlSessionFactoryBean", GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(myModule)),
                        "org.mybatis.spring.SqlSessionFactoryBean 未找到");
                if (myDaoCheckBox.isSelected()) {
                    Preconditions.checkNotNull(facade.findClass("com.github.pagehelper.Page", GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(myModule)),
                            "com.github.pagehelper.Page 未找到");
                }
            } catch (Exception e) {
                throw new ConfigurationException(e.getMessage(), "缺少依赖");
            }
            SelectionContext.setOrmType(OrmType.MYBATIS_SAAS);
        } else {
            try {
                Preconditions.checkNotNull(facade.findClass("com.baomidou.mybatissaas.annotation.TableName", GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(myModule)),
                        "com.baomidou.mybatisplus.annotation.TableName 未找到");
                Preconditions.checkNotNull(facade.findClass("org.apache.ibatis.session.SqlSession", GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(myModule)),
                        "org.apache.ibatis.session.SqlSession 未找到");
                Preconditions.checkNotNull(facade.findClass("org.mybatis.spring.SqlSessionFactoryBean", GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(myModule)),
                        "org.mybatis.spring.SqlSessionFactoryBean 未找到");
                if (myDaoCheckBox.isSelected()) {
                    Preconditions.checkNotNull(facade.findClass("com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor", GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(myModule)),
                            "com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor 未找到");
                }
            } catch (Exception e) {
                throw new ConfigurationException(e.getMessage(), "缺少依赖");
            }
            SelectionContext.setOrmType(OrmType.MYBATIS_PLUS);
        }

        //先清空所有包
        SelectionContext.setControllerPackage(null);
        SelectionContext.setServicePackage(null);
        SelectionContext.setDaoPackage(null);
        SelectionContext.setMapperDir(null);
        SelectionContext.setModelPackage(null);
        SelectionContext.setControllerExtPackage(null);
        SelectionContext.setServiceExtPackage(null);
        SelectionContext.setDalPackage(null);
        SelectionContext.setModelExtPackage(null);
        if (myControllerCheckBox.isSelected()) {
            SelectionContext.setControllerPackage(myControllerField.getText());
        }
        if (myController30CheckBox.isSelected()) {
            SelectionContext.setControllerPackage(myController30Field.getText());
        }
        if (myServiceCheckBox.isSelected()) {
            SelectionContext.setServicePackage(myServiceField.getText());
        }
        if (myService30CheckBox.isSelected()) {
            SelectionContext.setServicePackage(myService30Field.getText());
        }
        if (myDaoCheckBox.isSelected()) {
            SelectionContext.setDaoPackage(myDaoField.getText());
            if (0 == myFrameComboBox.getSelectedIndex()) {
                SelectionContext.setMapperDir(((TextFieldWithBrowseButton) myMapperField).getText());
            }
        }
        if (myDalCheckBox.isSelected()) {
            SelectionContext.setDaoPackage(myDalField.getText());
            if (0 == myFrameComboBox.getSelectedIndex()) {
                SelectionContext.setMapperDir(((TextFieldWithBrowseButton) myMapperField).getText());
            }
        }
        if (myModelCheckBox.isSelected()) {
            SelectionContext.setModelPackage(myModelField.getText());
        }
        if (myModel30CheckBox.isSelected()) {
            SelectionContext.setModelPackage(myModel30Field.getText());
        }
        return super.validate();
    }

    private void switchFrame() {
        if (0 == myFrameComboBox.getSelectedIndex()) {
            myMapperLabel.setVisible(true);
            myMapperField.setVisible(true);
        } else {
            myMapperLabel.setVisible(false);
            myMapperField.setVisible(false);
        }
    }

    private void checkBoxSetup(boolean selected) {
        if (selected) {
            //处理选中
            if (myControllerCheckBox.isSelected()) {
                myModelCheckBox.setSelected(true);
                myDaoCheckBox.setSelected(true);
                myServiceCheckBox.setSelected(true);
            } else if (myServiceCheckBox.isSelected()) {
                myModelCheckBox.setSelected(true);
                myDaoCheckBox.setSelected(true);
            } else if (myDaoCheckBox.isSelected()) {
                myModelCheckBox.setSelected(true);
            }else if (myController30CheckBox.isSelected()) {
                myModel30CheckBox.setSelected(true);
                myDalCheckBox.setSelected(true);
                myService30CheckBox.setSelected(true);
            } else if (myService30CheckBox.isSelected()) {
                myModel30CheckBox.setSelected(true);
                myDalCheckBox.setSelected(true);
            } else if (myDalCheckBox.isSelected()) {
                myModel30CheckBox.setSelected(true);
            }
        } else {
            if (!myModelCheckBox.isSelected()) {
                //处理没选中
                myDaoCheckBox.setSelected(false);
                myServiceCheckBox.setSelected(false);
                myControllerCheckBox.setSelected(false);
            } else if (!myDaoCheckBox.isSelected()) {
                myServiceCheckBox.setSelected(false);
                myControllerCheckBox.setSelected(false);
            } else if (!myServiceCheckBox.isSelected()) {
                myControllerCheckBox.setSelected(false);
            }else if (!myModel30CheckBox.isSelected()) {
                //处理没选中
                myDalCheckBox.setSelected(false);
                myService30CheckBox.setSelected(false);
                myController30CheckBox.setSelected(false);
            } else if (!myDalCheckBox.isSelected()) {
                myService30CheckBox.setSelected(false);
                myController30CheckBox.setSelected(false);
            } else if (!myService30CheckBox.isSelected()) {
                myController30CheckBox.setSelected(false);
            }
        }

    }

    @Override
    public void updateDataModel() {

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        TextFieldWithBrowseButton browseButton = new TextFieldWithBrowseButton();
        browseButton.addBrowseFolderListener(new TextBrowseFolderListener(new FileChooserDescriptor(false, true, false, false, false, false)));
        this.myMapperField = browseButton;
    }
}
