package org.stopit.stats;

import org.stopit.stats.*;
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
public class StatsDto extends DtoFrame {
	private double moneySaved;

	private int currentStreak;

	private int longestStreak;

	private int healthLevel;

}
