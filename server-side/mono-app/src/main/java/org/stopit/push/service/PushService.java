package org.stopit.push.service;

import org.stopit.checkup.CheckupDto;
import org.stopit.push.*;
import org.stopit.push.repository.*;
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
public class PushService implements TServiceCRUD<Integer, PushDto, Push> {
	private final PushRepository repository;
	@Override
	public int insert(PushDto pushdto) {
		var model = Push.builder()
				.text(pushdto.getText())
				.pushMsgInterval(pushdto.getPushMsgInterval())
				.build();
		this.repository.save(model);
		return 1;
	}
	@Override
	public List<PushDto> getAll() {
		return this.repository.findAll()
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
	public boolean update(Integer id, Push push) {
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
