package org.stopit.checkup;

import org.stopit.checkup.*;
import lombok.*;
import org.restframework.web.core.templates.*;
import org.restframework.web.annotations.markers.*;
import org.types.StopWithSmokingScale;

import java.util.*;

@CompilationComponent
@EqualsAndHashCode(callSuper=true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CheckupDto extends DtoFrame {
	private boolean hasSmoked;
	private String comment;
	private StopWithSmokingScale difficultyScale;
	private Date date;
}
