package org.stopit.stats.service;

import org.stopit.stats.*;
import org.stopit.stats.repository.*;
import lombok.*;
import org.springframework.stereotype.Service;
import org.restframework.web.core.templates.*;
import org.restframework.web.annotations.markers.*;
import java.util.*;

@CompilationComponent
@Data
@AllArgsConstructor
@Service
public class StatsService implements TServiceCRUD<Integer, StatsDto, Stats> {
	private final StatsRepository repository;
	@Override
	public int insert(StatsDto statsdto) {
		 return 0;
	}
	@Override
	public List<StatsDto> getAll() {
		 return null;
	}
	@Override
	public boolean removeById(Integer id) {
		 return false;
	}
	@Override
	public boolean update(Integer id, Stats stats) {
		 return false;
	}
}
