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
import org.types.StatsGetResponse;
import org.utils.TAuthService;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@CompilationComponent
@Data
@AllArgsConstructor
@Service
public class StatsService {
	private final StatsRepository repository;
	private final UserRepo userRepo;

	public StatsGetResponse getAll(String email) {
		User user = this.userRepo.findByEmail(email)
				.orElseThrow(() -> new NotFoundException("Could not find user by email '%s'".formatted(email)));

		Stats stats = user.getStats();

		return new StatsGetResponse(
				stats.getHealthLevel(),
				stats.getCurrentStreak(),
				stats.getLongestStreak(),
				stats.getMoneySaved());
	}

	public boolean removeById(Integer id) {
		if (!this.repository.existsById(id))
			return false;
		this.repository.deleteById(id);
		return true;
	}

	public boolean update(String email, StatsDto stats) {
		User user = this.userRepo.findByEmail(email)
				.orElseThrow(() -> new NotFoundException("Could not find user by email '%s'".formatted(email)));

		var model = user.getStats();

		var longestStreak = 0;
		for (var checkUpsModel : user.getCheckups()) {
			if (!checkUpsModel.isHasSmoked()) longestStreak++;
			else longestStreak = 0;
		}

		var amountOfCheckups = user.getCheckups().size();

		model.setCurrentStreak(stats.getCurrentStreak());
		model.setLongestStreak(Math.max(longestStreak, stats.getCurrentStreak()));
		model.setHealthLevel(stats.getHealthLevel());
		model.setMoneySaved(Math.max(amountOfCheckups * 17.5D, stats.getCurrentStreak() * 17.5D));
		this.repository.save(model);

		return true;
	}
}
