package org.stopit.checkup;

import org.stopit.checkup.*;
import lombok.*;
import jakarta.persistence.*;
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
@Entity
@Table(name="t_daily_checkup")
public class CheckupModel extends ModelFrame<Integer> {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private boolean hasSmoked;
	private String comment;
	private StopWithSmokingScale difficultyScale;
	private Date date;

}
