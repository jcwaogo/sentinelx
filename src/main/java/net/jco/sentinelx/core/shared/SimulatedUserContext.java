package net.jco.sentinelx.core.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimulatedUserContext {
    private String username;
    private List<String> roles;
    private String traceId;
    private LocalDateTime setAt;
}
