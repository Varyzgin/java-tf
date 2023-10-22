package edu.hw2.task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WhoIsCallingTest {
    @Test
    @DisplayName("Класс, вызвавший функию")
    void calledClass() {
        // given
        CallingInfo info = WhoIsCalling.callingInfo();

        // required answer
        String className = "jdk.internal.reflect.DirectMethodHandleAccessor";

        assertThat(className).isEqualTo(info.className());
    }
    @Test
    @DisplayName("Метод, вызвавший функию")
    void calledMethod() {
        // given
        CallingInfo info = WhoIsCalling.callingInfo();

        // required answer
        String methodName = "invoke";

        assertThat(methodName).isEqualTo(info.methodName());
    }
}
