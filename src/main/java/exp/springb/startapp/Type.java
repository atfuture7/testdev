package exp.springb.startapp;

import lombok.Data;
import java.util.List;
import org.springframework.data.annotation.Id;

@Data
public class Type {
	
	@Id private String id;
	
	private String type;
	private String description;
	private List<Page> lstPage;
	
	public Type() {}
	public Type( String str1, String str2, List<Page> lst) {
		this.type=str1;
		this.description=str2;
		this.lstPage=lst;
	}
}

