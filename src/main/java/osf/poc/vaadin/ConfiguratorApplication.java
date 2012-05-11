package osf.poc.vaadin;

import com.vaadin.Application;
import com.vaadin.ui.*;

/**
 * Main class for the Vaadin configuration application
 */
public class ConfiguratorApplication extends Application {
    public static final String MENU_CONFIG = "Configuration";
    public static final String MENU_ABOUT = "About";

    // Page components
    private final Label title = new Label("Configuration application using Vaadin/Jersey");
    private final MenuBar menuBar = new MenuBar();
    Panel currentPanel = new ConfigPanel();
    
    // Page layouts
    private VerticalLayout mainLayout = new VerticalLayout();
    
    @Override
    public void init() {
        initLayout();
    }

    private void initLayout() {
        final Window main = new Window("Vaadin Jersey Configurator", mainLayout);
        //main.setName("vaadin-jersey-configurator");
        main.setDebugId("WindowId");            // For performance tests
        mainLayout.setDebugId("AppLayoutId");   // For performance tests
        setMainWindow(main);
        
        // Title
        title.setStyleName("h1");
        title.setWidth(null);
        mainLayout.addComponent(title);
        
        // Menu
        MainMenuCommand command = new MainMenuCommand(this);
        menuBar.addItem(MENU_CONFIG, command);
        menuBar.addItem(MENU_ABOUT, command);
        mainLayout.addComponent(menuBar);
        
        // Panel
        mainLayout.addComponent(currentPanel);
        
        // Layout properties
        mainLayout.setSpacing(true);
        mainLayout.setComponentAlignment(title, Alignment.MIDDLE_CENTER);
        mainLayout.setComponentAlignment(menuBar, Alignment.MIDDLE_CENTER);
    }
    
    void setPanel(Panel newPanel) {
        mainLayout.replaceComponent(currentPanel, newPanel);
        currentPanel = newPanel;
    }
}