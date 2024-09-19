package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.Base.Base_Class;


public class Hook extends Base_Class {
    @Before
    public void setup() {
        initializeDriver();
    }

    @After
    public void cleanup() {
        tearDown();
    }
}
