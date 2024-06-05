package org.stopit.stats;

import org.stopit.stats.*;
import lombok.*;
import jakarta.persistence.*;
import org.restframework.web.core.templates.*;
import org.restframework.web.annotations.markers.*;
import java.util.*;

@CompilationComponent
@EqualsAndHashCode(callSuper=true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="t_stats")
public class Stats extends ModelFrame<Integer> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private double moneySaved;

	private int currentStreak;

	private int longestStreak;

	private int healthLevel;

}
