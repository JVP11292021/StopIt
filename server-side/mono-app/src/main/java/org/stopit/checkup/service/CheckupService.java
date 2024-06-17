package org.stopit.checkup.service;

import org.exception.NotFoundException;
import org.stopit.auth.user.User;
import org.stopit.auth.user.UserRepo;
import org.stopit.checkup.*;
import org.stopit.checkup.repository.*;
import lombok.*;
import org.springframework.stereotype.Service;
import org.restframework.web.annotations.markers.*;
import org.utils.TAuthService;

import java.util.*;
import java.util.stream.Collectors;

@CompilationComponent
@Data
@AllArgsConstructor
@Service
public class CheckupService implements TAuthService<Integer, CheckupDto, CheckupModel> {
	private final CheckupRepository repository;
	private final UserRepo userRepo;

	@Override
	public List<CheckupDto> getAll(String email) {
		User user = this.userRepo.findByEmail(email)
				.orElseThrow(() -> new NotFoundException("Could not find user by email '%s'".formatted(email)));

		return user.getCheckups()
				 .stream()
				 .map(checkupModel -> CheckupDto.builder()
						 .comment(checkupModel.getComment())
						 .difficultyScale(checkupModel.getDifficultyScale())
						 .hasSmoked(checkupModel.isHasSmoked())
						 .date(checkupModel.getDate())
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
	public boolean update(Integer id, CheckupDto checkupmodel) throws IllegalArgumentException {
		if (!this.repository.existsById(id))
			return false;
		var model = this.repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Could not find the checkup model by id '%d'".formatted(id)));
		model.setComment(checkupmodel.getComment());
		model.setHasSmoked(checkupmodel.isHasSmoked());
		model.setDifficultyScale(checkupmodel.getDifficultyScale());
		model.setDate(checkupmodel.getDate());
		this.repository.save(model);

		return true;
	}
}
