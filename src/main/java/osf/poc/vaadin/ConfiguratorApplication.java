package osf.poc.vaadin;

import com.vaadin.Application;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.*;
import osf.poc.vaadin.model.PropertiesContainer;

public class ConfiguratorApplication extends Application {
    private static String[] visibleCols = new String[] { "name", "value" };

    private Table contactList = new Table();
    private HorizontalLayout bottomLeftCorner = new HorizontalLayout();
    private PropertiesContainer container = new PropertiesContainer();
    
    @Override
    public void init() {
        initLayout();
        initPropertiesList();
    }

    private void initLayout() {
        VerticalLayout left = new VerticalLayout();
        setMainWindow(new Window("Vaadin Configurator", left));
        
        left.setSizeFull();
        left.addComponent(contactList);
        contactList.setSizeFull();
        contactList.setColumnReorderingAllowed(true);
        left.setExpandRatio(contactList, 1);
        left.addComponent(bottomLeftCorner);
    }

    private void initPropertiesList() {        
        contactList.setContainerDataSource(container);
        contactList.setVisibleColumns(visibleCols);
        contactList.setSelectable(true);
        contactList.setImmediate(true);
    }
}