package osf.poc.vaadin.model;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.vaadin.data.Container.Filterable;
import com.vaadin.data.Property;
import com.vaadin.data.util.AbstractInMemoryContainer;
import com.vaadin.data.util.filter.UnsupportedFilterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.ws.rs.core.MediaType;

/**
 * Container data model for mapping tables with configuration properties
 * using Jersey REST API
 */
public class JerseyContainer extends AbstractInMemoryContainer<Integer, String, PropertyItem> implements Filterable {
    private List<PropertyItem> items = new ArrayList<PropertyItem>();
    
    public JerseyContainer(){
        ClientConfig config = new DefaultClientConfig(); 
        Client client = Client.create(config);
        WebResource service = client.resource("http://localhost:8080/JerseyRest-1.0-SNAPSHOT/");
        
        List<osf.poc.model.Property> properties = 
                service.path("configurations").path("properties").accept(MediaType.APPLICATION_XML).get(new GenericType<List<osf.poc.model.Property>>(){});
        
        List<Integer> ids = new ArrayList<Integer>();
        
        for(int i = 0; i < properties.size(); ++i){
            items.add(new PropertyItem(properties.get(i)));
            ids.add(i);
        }
        
        setAllItemIds(ids);
    }

    
    
    @Override
    protected PropertyItem getUnfilteredItem(Object itemId) {
        return items.get((Integer) itemId);
    }

    @Override
    public Collection<?> getContainerPropertyIds() {
        return Arrays.asList("name", "value");
    }

    @Override
    public Property getContainerProperty(Object itemId, Object propertyId) {
        return getUnfilteredItem(itemId).getItemProperty(propertyId);
    }

    @Override
    public Class<?> getType(Object propertyId) {
        return String.class;
    }

    @Override
    public void addContainerFilter(Filter filter) throws UnsupportedFilterException {
        addFilter(filter);
    }

    @Override
    public void removeContainerFilter(Filter filter) {
        removeFilter(filter);
    }

    @Override
    public void removeAllContainerFilters() {
        removeAllFilters();
    }
}
