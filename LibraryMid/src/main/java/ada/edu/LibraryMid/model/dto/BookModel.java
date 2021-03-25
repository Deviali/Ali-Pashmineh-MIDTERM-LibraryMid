package ada.edu.LibraryMid.model.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Data
public class BookModel implements Serializable {
    private String name;
    private String author;
    private String description;
    private String category;
    private Boolean available;
    private Date published_at;

}
