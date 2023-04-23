package org.joska.model.todo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponse {
    private Long userId;
    private Long id;
    private String title;
    private Boolean completed;
}
