package osf.poc.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Main model class representing a configuration property
 */
@XmlRootElement
public class Property {
    
    private String name;
    private String data;
    
    public Property(){
        // Nothing to do
    }
    
    public Property(String name, String value){
        super();
        
        this.name = name;
        this.data = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return data;
    }

    public void setValue(String value) {
        this.data = value;
    }
}
