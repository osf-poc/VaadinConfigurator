package osf.poc.vaadin.model;

import com.vaadin.data.util.BeanItem;
import osf.poc.model.Property;

public class PropertyItem extends BeanItem<Property> {
    public PropertyItem(Property property){
        super(property);
    }
}