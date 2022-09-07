package com.calculator2.calculator2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author HP
 */
public class Calculator2Test {
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator2.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator2.add("1"));
	}

	@Test
	public void testTwoNumbers(){
		assertEquals(3, Calculator2.add("1,2"));
	}

	@Test
    public void testUnknownNumbers(){
    	assertEquals(15, Calculator2.add("1,2,3,4,5"));
    }

    @Test
    public void testNewLine(){
    	assertEquals(6, Calculator2.add("1\n2,3"));
    }

    @Test
    public void testNegativeNumver(){
    	try {
			Calculator2.add("-1,2");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -1");
		}

		try {
			Calculator2.add("2,-4,3,-5");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -4,-5");
		}
    }

    @Test
    public void testOverThousand(){
    	assertEquals(2, Calculator2.add("1000,2"));
    }

    @Test
    public void testOtherDelimiter(){
    	assertEquals(3, Calculator2.add("//;\n1;2"));
    }
}