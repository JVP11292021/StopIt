package org.utils;

import org.restframework.web.annotations.Template;
import org.restframework.web.core.templates.ClassTypes;
import org.restframework.web.core.templates.ModelFrame;
import org.restframework.web.core.templates.SpringComponents;
import org.springframework.http.ResponseEntity;

@Template(
        templateName = "Controller",
        rule = SpringComponents.CONTROLLER,
        type = ClassTypes.CLASS
)
public interface TAuthController<ID, DTO, Model extends ModelFrame<ID>>  {

    ResponseEntity<?> getAllEntities(String email);

    ResponseEntity<?> removeEntityById(ID id);

    ResponseEntity<?> updateEntity(ID id, DTO entity);

    default ResponseEntity<?> getById(ID id) {
        return ResponseEntity.noContent().build();
    }

    default ResponseEntity<?> removeEntity(Model entityToRemove) {
        return ResponseEntity.noContent().build();
    }

    default ResponseEntity<?> removeAllEntities() {
        return ResponseEntity.noContent().build();
    }
}
