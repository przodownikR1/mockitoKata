package pl.java.scalatech.simple;

import static org.assertj.core.api.StrictAssertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;
import static org.mockito.Mockito.inOrder;
import org.junit.Test;
import org.mockito.InOrder;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class SimpleTest {

	@Test
	public void shouldMockList() {
		//given
		List<String> mockedList = mock(List.class);
		//when
		// using mock object
		mockedList.add("one");
		mockedList.clear();
		//then
		// verification
		verify(mockedList).add("one");
		verify(mockedList).clear();
		//show list invocations
		log.info("+++ {}",mockingDetails(mockedList).printInvocations());


	}
	@Test
	public void shouldStubList(){
		LinkedList<String> mockedList = mock(LinkedList.class);

		//stubbing
		when(mockedList.get(0)).thenReturn("first");
		when(mockedList.get(1)).thenThrow(new RuntimeException());

		//following prints "first"
		log.info("+++ {}",mockedList.get(0));

		//following throws runtime exception

		assertThatThrownBy(()->mockedList.get(1)).isInstanceOf(RuntimeException.class);



		//following prints "null" because get(999) was not stubbed
		log.info("+++ {}",mockedList.get(999));

		//Although it is possible to verify a stubbed invocation, usually it's just redundant
		//If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
		//If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
		verify(mockedList).get(0);


		//mockingDetails(mockedList).getStubbing();
	}
	@Test
	public void testArgumentMatcher() {

		//mock creation
		List<String> mockedList = mock(List.class);

		//stubbing using built-in anyInt() and anyString() argument matcher
		when(mockedList.get(anyInt())).thenReturn("element");
		when(mockedList.contains(anyString())).thenReturn(true);

		//following prints "element" and "foo"
		System.out.println(mockedList.get(999));
		System.out.println(mockedList.contains("foo"));

		//you can also verify using an argument matcher
		verify(mockedList).get(999);
		verify(mockedList).get(anyInt());
	}


	@Test
	public void shouldVerifyInvocationTimes(){
	//mock creation
		List<String> mockedList = mock(List.class);
		//using mock
		mockedList.add("once");

		mockedList.add("twice");
		mockedList.add("twice");

		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");

		//following two verifications work exactly the same - times(1) is used by default
		verify(mockedList).add("once");
		verify(mockedList, times(1)).add("once");

		//exact number of invocations verification
		verify(mockedList, times(2)).add("twice");
		verify(mockedList, times(3)).add("three times");

		//verification using never(). never() is an alias to times(0)
		verify(mockedList, never()).add("never happened");

		//verification using atLeast()/atMost()
		verify(mockedList, atLeastOnce()).add("three times");
		verify(mockedList, atLeast(2)).add("twice");
		verify(mockedList, atMost(5)).add("three times");

	}
	@Test
	public void shouldThrowing(){
		List<String> mockedList = mock(List.class);
		doThrow(new RuntimeException()).when(mockedList).clear();

		//following throws RuntimeException:
		assertThatThrownBy(()->mockedList.clear()).isInstanceOf(RuntimeException.class);

	}

	@Test
	public void shouldVerificationInOrder(){
		List<String> singleMock = mock(List.class);
	//using a single mock
		singleMock.add("was added first");
		singleMock.add("was added second");

		//create an inOrder verifier for a single mock
		InOrder inOrder = inOrder(singleMock);

		//following will make sure that add is first called with "was added first, then with "was added second"
		inOrder.verify(singleMock).add("was added first");
		inOrder.verify(singleMock).add("was added second");

		// B. Multiple mocks that must be used in a particular order
		List firstMock = mock(List.class);
		List secondMock = mock(List.class);

		//using mocks
		firstMock.add("was called first");
		secondMock.add("was called second");

		//create inOrder object passing any mocks that need to be verified in order
		inOrder = inOrder(firstMock, secondMock);

		//following will make sure that firstMock was called before secondMock
		inOrder.verify(firstMock).add("was called first");
		inOrder.verify(secondMock).add("was called second");


	}
	@Test
	public void shouldNeverHappendBehave(){
		List<String> mockedOne = mock(List.class);
		List<String> mockedTwo = mock(List.class);
		List<String> mockedThree = mock(List.class);
		//using mocks - only mockOne is interacted
		mockedOne.add("one");

		//ordinary verification
		verify(mockedOne).add("one");

		//verify that method was never called on a mock
		verify(mockedOne, never()).add("two");

		//verify that other mocks were not interacted
		verifyZeroInteractions(mockedTwo, mockedThree);
	}
}
