package com.inmybook.application.port.in;

import jakarta.validation.constraints.NotNull;

public record ReadPostInput(
	@NotNull
	String uuid
) {
}
