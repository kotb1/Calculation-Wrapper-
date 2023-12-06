package JMock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import Calculaution.CalculationWrapper;
import Calculaution.ICalculation;

public class CalculationTest {

    private CalculationWrapper systemUnderTest;
    private ICalculation mockedDependency;
    private Mockery mockingContext;

    @Before
    public void doBeforeEachTestCase() {
        mockingContext = new Mockery() {
            {
                // setImposteriser(ClassImposteriser.INSTANCE);
            }
        };

        mockedDependency = mockingContext.mock(ICalculation.class);

        systemUnderTest = new CalculationWrapper(mockedDependency);
    }

    @Test
    public void getPrice() throws Exception {
        int[] arr = { -4, 5, -6, 8 };

        mockingContext.checking(new Expectations() {
            {
                exactly(1).of(mockedDependency).findMin(arr);
                will(returnValue(-6));
            }
        });

        int result = systemUnderTest.findMinimum(arr);

        mockingContext.assertIsSatisfied();
        assertEquals(-6 - 10, result);
    }

    @Test
    // (expected = IllegalArgumentException.class)
    public void getPriceDataAccessThrowsRuntimeException() throws Exception {
        mockingContext.checking(new Expectations() {
            {
                allowing(mockedDependency).findMin(null);
                will(throwException(new IllegalArgumentException("arr cannot be of length zero!")));
            }
        });

        int result = systemUnderTest.findMinimum(null);

        mockingContext.assertIsSatisfied();
        assertEquals(Integer.MIN_VALUE, result);
    }

    @Test
    public void testWrapperFindMinimum() throws Exception {
        // arrange
        int[] arr = { -9, 8, 9, -7, -5 };
        int[] arr2 = { 8, -9, 9, -7, -5 };

        mockingContext = new Mockery();
        ICalculation mockedObject = mockingContext.mock(ICalculation.class);
        mockingContext.checking(new Expectations() {
            {
                allowing(mockedObject).findMin(arr);
                will(returnValue(-9));
            }
        });

        CalculationWrapper instance = new CalculationWrapper(mockedObject);

        // act
        int minimum = instance.findMinimum(arr);

        // assert
        mockingContext.assertIsSatisfied();
        assertEquals(-9 - 10, minimum);
    }

    @Test
    public void testWrapperFindMinimum_Exception() throws Exception {
        // arrange
        mockingContext = new Mockery();
        ICalculation mockedObject = mockingContext.mock(ICalculation.class);
        mockingContext.checking(new Expectations() {
            {
                oneOf(mockedObject).findMin(null);
                will(throwException(new IllegalArgumentException("NULL")));
            }
        });

        CalculationWrapper instance = new CalculationWrapper(mockedObject);

        // act
        int minimum = instance.findMinimum(null);

        // assert
        mockingContext.assertIsSatisfied();
        assertEquals(Integer.MIN_VALUE, minimum);
    }

}
