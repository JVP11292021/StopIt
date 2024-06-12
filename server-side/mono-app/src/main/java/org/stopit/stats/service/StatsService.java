package org.stopit.stats.service;

import org.stopit.push.PushDto;
import org.stopit.stats.*;
import org.stopit.stats.repository.*;
import lombok.*;
import org.springframework.stereotype.Service;
import org.restframework.web.core.templates.*;
import org.restframework.web.annotations.markers.*;
import java.util.*;
import java.util.stream.Collectors;

@CompilationComponent
@Data
@AllArgsConstructor
@Service
public class StatsService implements TServiceCRUD<Integer, StatsDto, Stats> {
	private final StatsRepository repository;
	@Override
	public int insert(StatsDto statsdto) {
		var model = Stats.builder()
				.healthLevel(statsdto.getHealthLevel())
				.moneySaved(statsdto.getMoneySaved())
				.currentStreak(statsdto.getCurrentStreak())
				.longestStreak(statsdto.getLongestStreak())
				.build();

		this.repository.save(model);
		return 1;
	}
	@Override
	public List<StatsDto> getAll() {
		return this.repository.findAll()
				.stream()
				.map(stats -> StatsDto.builder()
						.healthLevel(stats.getHealthLevel())
						.currentStreak(stats.getCurrentStreak())
						.longestStreak(stats.getLongestStreak())
						.moneySaved(stats.getMoneySaved())
						.build())
				.collect(Collectors.toList());
	}
	@Override
	public boolean removeById(Integer id) {
		if (!this.repository.existsById(id))
			return false;
		this.repository.deleteById(id);
		return true;
	}
	@Override
	public boolean update(Integer id, Stats stats) {
		if (!this.repository.existsById(id))
			return false;
		var model = this.repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Could not find the push model by id '%d'".formatted(id)));
		model.setCurrentStreak(stats.getCurrentStreak());
		model.setLongestStreak(Math.max(stats.getCurrentStreak(), stats.getLongestStreak()));
		model.setHealthLevel(stats.getHealthLevel());
		model.setMoneySaved(stats.getMoneySaved());
		this.repository.save(model);

		return true;
	}
}
