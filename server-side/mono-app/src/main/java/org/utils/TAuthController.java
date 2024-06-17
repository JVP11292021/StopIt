package org.utils;

import org.restframework.web.annotations.Template;
import org.restframework.web.core.templates.ClassTypes;
import org.restframework.web.core.templates.ModelFrame;
import org.restframework.web.core.templates.SpringComponents;
import org.springframework.http.ResponseEntity;

import java.security.Principal;

@Template(
        templateName = "Controller",
        rule = SpringComponents.CONTROLLER,
        type = ClassTypes.CLASS
)
public interface TAuthController<ID, DTO, Model extends ModelFrame<ID>>  {

    ResponseEntity<?> getAllEntities();

    ResponseEntity<?> removeEntityById(ID id);

    ResponseEntity<?> updateEntity(ID id, Model entity);

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
