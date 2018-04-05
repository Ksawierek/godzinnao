package io.dddbyexamples.godzinnao.limits;

import lombok.Value;

import java.time.Duration;

@Value
public class LimitRedefined {
    Object employeeId;
    Duration limit;
}
