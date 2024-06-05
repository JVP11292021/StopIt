package org.types;

import java.util.Date;

import static java.util.Objects.requireNonNull;

public record ErrorResponse(Date time, String message, Throwable stacktrace) {
    public ErrorResponse {
        requireNonNull(time);
        requireNonNull(message);
    }
}
