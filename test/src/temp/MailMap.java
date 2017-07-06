package temp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MailMap extends HashMap<String, Object> {

    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();

	for(String key : this.keySet()) {
	    str.append(key + " : " + this.get(key) + "\n");
	}
	
	
	return str.toString();
    }
}
