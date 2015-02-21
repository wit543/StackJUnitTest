package ku.util;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
public class StackTest {
	Stack<String> stack;
	@Test
	public void testIsEmpty(){
		stack = new Stack<String>(10);
		assertTrue(stack.isEmpty());
		stack.push("one");
		assertFalse(stack.isEmpty());
	}
	@Test
	public void testIsFull(){
		stack = new Stack<String>(1);
		assertFalse(stack.isFull());
		stack.push("one");
		assertTrue(stack.isFull());
	}
	@Test
	public void testNormalCapacity(){
		stack = new Stack<String>(1);
		assertSame(1, stack.capacity());
		stack = new Stack<String>(0);
		assertSame(0,stack.capacity());
	}
	@Test
	public void testNegativeCapacity(){
		stack = new Stack<String>(-10);
		assertSame(0, stack.capacity());
	}
	@Test
	public void testEmptyPeak(){
		stack = new Stack<String>(0);
		assertNull(stack.peek());
	}
	@Test
	public void testNormalPeak(){
		stack = new Stack<String>(3);
		stack.push("one");
		stack.push("two");
		stack.push("three");
		assertSame("three",stack.peek());
		assertSame("three",stack.peek());
		assertSame("three",stack.peek());
	}
	@Test(timeout =100,expected=java.util.EmptyStackException.class)
	public void testEmptyPop(){
		stack = new Stack<String>(0);
		assertSame("",stack.pop());
	}
	@Test
	public void testNormalPop(){
		stack = new Stack<String>(3);
		stack.push("one");
		stack.push("two");
		stack.push("three");
		assertSame("three",stack.pop());
		assertSame("two", stack.pop());
		assertSame("one",stack.pop());
	}
	@Test(timeout =100,expected=java.util.EmptyStackException.class)
	public void testNormalPlusEmptyPop(){
		stack = new Stack<String>(3);
		stack.push("one");
		stack.push("two");
		stack.push("three");
		assertSame("three",stack.pop());
		assertSame("two", stack.pop());
		assertSame("one",stack.pop());
		assertSame("",stack.pop());
	}
	@Test
	public void testNormalPush(){
		stack = new Stack<String>(3);
		stack.push("one");
		stack.push("two");
		stack.push("three");
	}
	@Test
	public void testEmptyPush(){
		stack = new Stack<String>(0);
		stack.push("one");
	}
	@Test(timeout=100,expected=java.lang.IllegalArgumentException.class)
	public void testNullPush(){
		stack = new Stack(1);
		stack.push(null);
	}
	//depend on how you write your code.
	
//	@Test(timeout=100,expected=java.lang.IllegalArgumentException.class)
//	public void testNullPushAndFull(){
//		stack = new Stack(0);
//		stack.push(null);
//	}
	
	@Test
	public void testSize(){
		stack = new Stack<String>(5);
		assertSame(0,stack.size());
		stack.push("one");
		assertSame(1,stack.size());
		stack.push("one");
		assertSame(2,stack.size());
		stack.push("one");
		assertSame(3,stack.size());
		stack.push("one");
		assertSame(4,stack.size());
		stack.push("one");
		assertSame(5,stack.size());
	}
	@Test
	public void testAll(){
		stack = new Stack<String>(3);
		assertTrue(stack.isEmpty());
		assertFalse(stack.isFull());
		assertSame(0,stack.size());
		stack.push("one");
		assertFalse(stack.isEmpty());
		assertFalse(stack.isFull());
		assertSame(1,stack.size());
		assertSame("one", stack.peek());
		stack.push("two");
		assertFalse(stack.isEmpty());
		assertFalse(stack.isFull());
		assertSame(2,stack.size());
		assertSame("two", stack.peek());
		stack.push("three");
		assertFalse(stack.isEmpty());
		assertTrue(stack.isFull());
		assertSame(3,stack.size());
		assertSame("three", stack.peek());
		assertSame("three",stack.pop());
		assertSame(2,stack.size());
		assertSame("two",stack.peek());
		assertSame("two",stack.pop());
		assertSame("one",stack.pop());
		assertTrue(stack.isEmpty());
		assertFalse(stack.isFull());
		assertSame(0,stack.size());
		
	}
	public static void main(String[] args) {
		Class<?> testclass = Stack.class;
		Result result = org.junit.runner.JUnitCore.runClasses( testclass );
	}
}
