package org.propig.pico;

import org.junit.Test;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.Parameter;
import org.picocontainer.PicoBuilder;
import org.picocontainer.parameters.ComponentParameter;
import org.picocontainer.parameters.ConstantParameter;

import java.util.*;

public class PicoTest {

    @Test
    public void testCircular(){
        MutablePicoContainer mpc = new PicoBuilder().build();

        mpc.addComponent(List.class, ArrayList.class, Parameter.ZERO);
        mpc.addComponent(Set.class, HashSet.class, new ConstantParameter(33));
        mpc.addComponent(Collection.class, TreeSet.class, new ComponentParameter(List.class));
        List l = mpc.getComponent(List.class);
    }
}
