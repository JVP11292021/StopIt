package org.stopit.push.service;

import org.exception.NotFoundException;
import org.stopit.auth.user.User;
import org.stopit.auth.user.UserRepo;
import org.stopit.push.*;
import org.stopit.push.repository.*;
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
public class PushService implements TAuthService<Integer, PushDto, Push> {
	private final PushRepository repository;
	private final UserRepo userRepo;

	@Override
	public List<PushDto> getAll(String email) {
		User user = this.userRepo.findByEmail(email)
				.orElseThrow(() -> new NotFoundException("Could not find user by email '%s'".formatted(email)));

		return user.getPushNotifications()
				.stream()
				.map(push -> PushDto.builder()
						.text(push.getText())
						.pushMsgInterval(push.getPushMsgInterval())
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
	public boolean update(Integer id, PushDto push) {
		if (!this.repository.existsById(id))
			return false;
		var model = this.repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Could not find the push model by id '%d'".formatted(id)));
		model.setText(push.getText());
		model.setPushMsgInterval(push.getPushMsgInterval());
		this.repository.save(model);

		return true;
	}
}
