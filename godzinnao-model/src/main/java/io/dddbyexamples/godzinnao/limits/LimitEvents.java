package io.dddbyexamples.godzinnao.limits;

public interface LimitEvents {
    void emit(LimitDefined event);
    void emit(LimitRedefined event);
}
