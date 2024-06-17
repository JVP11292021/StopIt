package org.stopit.stats.service;

import lombok.extern.slf4j.Slf4j;
import org.exception.NotFoundException;
import org.stopit.auth.user.User;
import org.stopit.auth.user.UserRepo;
import org.stopit.stats.*;
import org.stopit.stats.repository.*;
import lombok.*;
import org.springframework.stereotype.Service;
import org.restframework.web.annotations.markers.*;
import org.utils.TAuthService;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@CompilationComponent
@Data
@AllArgsConstructor
@Service
public class StatsService implements TAuthService<Integer, StatsDto, Stats> {
	private final StatsRepository repository;
	private final UserRepo userRepo;

	@Override
	public List<StatsDto> getAll(String email) {
		User user = this.userRepo.findByEmail(email)
				.orElseThrow(() -> new NotFoundException("Could not find user by email '%s'".formatted(email)));

		return user.getStats()
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
