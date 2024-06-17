package org.stopit.stats;

import org.stopit.stats.*;
import lombok.*;
import org.restframework.web.core.templates.*;
import org.restframework.web.annotations.markers.*;
import org.types.HealthScale;

import java.util.*;

@CompilationComponent
@EqualsAndHashCode(callSuper=true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatsDto extends DtoFrame {
	private int currentStreak;
	private HealthScale healthLevel;
}
