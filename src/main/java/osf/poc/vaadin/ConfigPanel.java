package osf.poc.vaadin;

import com.vaadin.ui.*;
import osf.poc.vaadin.model.JerseyContainer;

/**
 * Panel showing the configuration properties
 */
public class ConfigPanel extends Panel {
    private static final String[] VISIBLE_COLS = new String[] { "name", "value" };
    
    // Layout
    private final VerticalLayout mainLayout = new VerticalLayout();
    
    // Components
    private final Label subTitle = new Label("Config page");
    private final Table propertiesTable = new Table();
    
    // Datasource to map with the table
    private JerseyContainer container = new JerseyContainer();
    
    public ConfigPanel() {
        setSizeFull();
        setContent(mainLayout);
        
        initLayout();
        initPropertiesList();
    }
    
    private void initLayout() {
        mainLayout.setDebugId("MainPanelLayoutId");   // For performance tests
        
        // Title
        subTitle.setStyleName("h2");
        subTitle.setWidth(null);
        mainLayout.addComponent(subTitle);
        
        // Table
        propertiesTable.setWidth("60%");
        propertiesTable.setHeight("500px");
        propertiesTable.setColumnReorderingAllowed(true);
        mainLayout.addComponent(propertiesTable);
        
        mainLayout.setSpacing(true);
        mainLayout.setComponentAlignment(subTitle, Alignment.MIDDLE_CENTER);
        mainLayout.setComponentAlignment(propertiesTable, Alignment.MIDDLE_CENTER);
        
        mainLayout.setSizeFull();
        mainLayout.setExpandRatio(propertiesTable, 1);
    }

    private void initPropertiesList() {    
        propertiesTable.setDebugId("PropTableId");
        propertiesTable.setContainerDataSource(container);
        propertiesTable.setVisibleColumns(VISIBLE_COLS);
        propertiesTable.setSelectable(true);
        propertiesTable.setImmediate(true);
    }
}
