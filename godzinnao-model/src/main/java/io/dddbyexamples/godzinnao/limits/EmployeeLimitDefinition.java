package io.dddbyexamples.godzinnao.limits;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class EmployeeLimitDefinition {

    private Object employeeId;

    private LimitDefined limit;

    private final LimitEvents events;

    void define(EmployeeLimit command) { // domain command
        if (command.getLimit().toHours() > 24) { // invariant
            throw new IllegalArgumentException("Employee daily Limit over 24h" + command.getLimit()); // negative ack
        }
        if (limitAlreadyDefined()) { // invariant
            limit = new LimitDefined(command.getEmployeeId(), command.getLimit());
            events.emit(new LimitRedefined(command.getEmployeeId(), command.getLimit())); // alternative processing
        } else {
            limit = new LimitDefined(command.getEmployeeId(), command.getLimit());
            events.emit(limit); // ack
        }
    }

    private boolean limitAlreadyDefined() {
        return limit != null;
    }
}
