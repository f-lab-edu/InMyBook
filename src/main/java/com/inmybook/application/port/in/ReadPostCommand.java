package com.inmybook.application.port.in;

import jakarta.validation.constraints.NotNull;

public record ReadPostCommand(
	@NotNull
	String uuid
) {
}
