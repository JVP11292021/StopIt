package org.utils;

import org.restframework.web.annotations.Template;
import org.restframework.web.core.templates.ClassTypes;
import org.restframework.web.core.templates.ModelFrame;
import org.restframework.web.core.templates.ServiceTemplateUtils;
import org.restframework.web.core.templates.SpringComponents;

import java.util.List;
import java.util.Optional;

@Template(
        templateName = "Service",
        rule = SpringComponents.SERVICE,
        type = ClassTypes.CLASS
)
public interface TAuthService <ID, DTO, Model extends ModelFrame<ID>> {
    ServiceTemplateUtils utils = new ServiceTemplateUtils();
    List<DTO> getAll(String email);

    boolean removeById(ID id);

    boolean update(ID id, DTO entity);

    default Optional<Boolean> remove(Model entity) {
        return Optional.empty();
    }

    default Optional<Model> getById(ID id) {
        return Optional.empty();
    }

    default Optional<Boolean> removeAll() {
        return Optional.empty();
    }

}
