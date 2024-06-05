package org.stopit.push;

import org.stopit.push.*;
import lombok.*;
import org.restframework.web.core.templates.*;
import org.restframework.web.annotations.markers.*;
import java.util.*;

@CompilationComponent
@EqualsAndHashCode(callSuper=true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PushDto extends DtoFrame {
	private Date pushMsgInterval;

	private String text;

}
