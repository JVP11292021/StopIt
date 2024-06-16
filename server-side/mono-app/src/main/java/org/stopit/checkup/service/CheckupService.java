package org.stopit.checkup.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.stopit.auth.user.User;
import org.stopit.auth.user.UserRepo;
import org.stopit.checkup.*;
import org.stopit.checkup.repository.*;
import lombok.*;
import org.springframework.stereotype.Service;
import org.restframework.web.core.templates.*;
import org.restframework.web.annotations.markers.*;
import org.utils.TAuthService;

import java.security.Principal;
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
	public int insert(CheckupDto checkupdto, Principal connectedUser) {
		var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

		var model = CheckupModel.builder()
				.comment(checkupdto.getComment())
				.difficultyScale(checkupdto.getDifficultyScale())
				.hasSmoked(checkupdto.isHasSmoked())
				.date(checkupdto.getDate())
				.build();

		user.getCheckups().add(model);
		this.userRepo.save(user);

		return 1;
	}
	@Override
	public List<CheckupDto> getAll() {
		 return this.repository.findAll()
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
	public boolean update(Integer id, CheckupModel checkupmodel) throws IllegalArgumentException {
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
