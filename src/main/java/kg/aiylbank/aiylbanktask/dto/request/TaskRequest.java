package kg.aiylbank.aiylbanktask.dto.request;

import lombok.Builder;

@Builder
public record TaskRequest(
        String description,
        boolean completed
) {
}
