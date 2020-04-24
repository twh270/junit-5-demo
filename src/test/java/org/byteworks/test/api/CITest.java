package org.byteworks.test.api;

import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

@EnabledIfSystemProperty(named = "env", matches = "ci")
public interface CITest {

}
