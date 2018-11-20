import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PostfixTest {
		
	@Test
	void testEvaluate() {
		Postfix postfix = new Postfix();
		assertEquals(5, Postfix.evaluate("12*3+"));
		assertEquals(7, Postfix.evaluate("123*+"));
		assertEquals(-78, Postfix.evaluate("12+34^-"));
		assertEquals(-11, Postfix.evaluate("12^34*-"));
		assertEquals(-1011, Postfix.evaluate("123*+45^-6+"));
		assertEquals(9, Postfix.evaluate("12+3*456-^+"));
		assertEquals(98, Postfix.evaluate("12+34/+5+678+*+"));
	}
	

}
