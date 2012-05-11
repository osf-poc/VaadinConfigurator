package osf.poc.vaadin;

import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

/**
 * Handle main menu items
 */
public class MainMenuCommand implements MenuBar.Command {

    private final ConfiguratorApplication application;
    
    public MainMenuCommand(ConfiguratorApplication application) {
        this.application = application;
    }

    @Override
    public void menuSelected(MenuItem selectedItem) {
        if(selectedItem.getText().equals(ConfiguratorApplication.MENU_CONFIG))
            application.setPanel(new ConfigPanel());
        else if(selectedItem.getText().equals(ConfiguratorApplication.MENU_ABOUT))
            application.setPanel(new AboutPanel());
    }
}
