package io.dddbyexamples.godzinnao.limits;

import lombok.Value;

import java.time.Duration;

@Value
class LimitDefined {
    Object employeeId;
    Duration limit;
}
