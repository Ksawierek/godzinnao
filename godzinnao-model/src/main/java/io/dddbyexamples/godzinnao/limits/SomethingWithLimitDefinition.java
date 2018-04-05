package io.dddbyexamples.godzinnao.limits;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class SomethingWithLimitDefinition {

    private final LimitEvents events;

    void define(EmployeeLimit command) {
        events.emit(new LimitDefined());
    }
}
