package com.letmeask.api.dtos;

import java.util.UUID;

public record UserResponseDTO(UUID id, String name, String email, String imageUrl, java.time.LocalDateTime createdAt) {
}
