package io.dddbyexamples.godzinnao.limits;

import lombok.Value;

import java.time.Duration;

@Value
class EmployeeLimit {
    Object employeeId;
    Duration limit;
}
