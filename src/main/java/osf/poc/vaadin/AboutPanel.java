package osf.poc.vaadin;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 * Panel to show about
 */
public class AboutPanel extends Panel {
    
    // Layout
    private final VerticalLayout mainLayout = new VerticalLayout();
    
    // Components
    private final Label subTitle = new Label("About");
    private final Label desc = new Label("<p>Application test to configure properties of an applicatoin through REST services</p>" +
                                         "<p>Use the Jersey API.</p>", Label.CONTENT_XHTML);
    
    public AboutPanel() {
        setSizeFull();
        setContent(mainLayout);
        
        subTitle.setStyleName("h2");
        subTitle.setWidth(null);
        
        desc.setWidth("50%");
        
        mainLayout.setDebugId("AboutPanelLayoutId");   // For performance tests
        mainLayout.addComponent(subTitle);
        mainLayout.addComponent(desc);
        
        mainLayout.setComponentAlignment(subTitle, Alignment.MIDDLE_CENTER);
        mainLayout.setComponentAlignment(desc, Alignment.MIDDLE_CENTER);
    }
}
