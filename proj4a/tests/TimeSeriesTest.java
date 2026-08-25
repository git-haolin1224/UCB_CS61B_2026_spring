import main.TimeSeries;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

/** Unit Tests for the TimeSeries class.
 *  @author Josh Hug
 */
public class TimeSeriesTest {
    @Test
    public void testFromSpec() {
        TimeSeries catPopulation = new TimeSeries();
        catPopulation.put(1991, 0.0);
        catPopulation.put(1992, 100.0);
        catPopulation.put(1994, 200.0);

        TimeSeries dogPopulation = new TimeSeries();
        dogPopulation.put(1994, 400.0);
        dogPopulation.put(1995, 500.0);

        TimeSeries totalPopulation = catPopulation.plus(dogPopulation);
        // expected: 1991: 0,
        //           1992: 100
        //           1994: 600
        //           1995: 500

        List<Integer> expectedYears = new ArrayList<>();
        expectedYears.add(1991);
        expectedYears.add(1992);
        expectedYears.add(1994);
        expectedYears.add(1995);

        assertThat(totalPopulation.years()).isEqualTo(expectedYears);

        List<Double> expectedTotal = new ArrayList<>();
        expectedTotal.add(0.0);
        expectedTotal.add(100.0);
        expectedTotal.add(600.0);
        expectedTotal.add(500.0);

        for (int i = 0; i < expectedTotal.size(); i += 1) {
            assertThat(totalPopulation.data().get(i)).isWithin(1E-10).of(expectedTotal.get(i));
        }
    }

    @Test
    public void testEmptyBasic() {
        TimeSeries catPopulation = new TimeSeries();
        TimeSeries dogPopulation = new TimeSeries();

        assertThat(catPopulation.years()).isEmpty();
        assertThat(catPopulation.data()).isEmpty();

        TimeSeries totalPopulation = catPopulation.plus(dogPopulation);

        assertThat(totalPopulation.years()).isEmpty();
        assertThat(totalPopulation.data()).isEmpty();
    }

    @Test

    public void testTimeSeriesConstructor2(){
        TimeSeries catPopulation = new TimeSeries();
        TimeSeries dogPopulation = new TimeSeries();

        catPopulation.put(1991, 0.0);
        catPopulation.put(1992, 100.0);
        catPopulation.put(1994, 200.0);

        List<Integer> expectedYear = new ArrayList<>();
        expectedYear.add(1992);

        List<Double> expectedPopulation = new ArrayList<>();
        expectedPopulation.add(100.0);

        TimeSeries expectedCatYearLimit = new TimeSeries(catPopulation, 1992, 1993);

        assertThat(expectedCatYearLimit.years()).isEqualTo(expectedYear);
        for(int i = 0; i < expectedPopulation.size(); i++) {
            assertThat(expectedCatYearLimit.data().get(i)).isWithin(1E-10).of(expectedPopulation.get(i));
        }
    }


    @Test

    public void testDividByException(){
        TimeSeries catPopulation = new TimeSeries();
        TimeSeries dogPopulation = new TimeSeries();

        catPopulation.put(2001, 100.0);
        catPopulation.put(2000, 10000.0);
        catPopulation.put(1997, 500.0);
        catPopulation.put(2023, 2000.0);

        dogPopulation.put(1997, 1000.0);
        dogPopulation.put(2000, 3000.0);
        dogPopulation.put(2023, 1000.0);

        assertThrows(
                IllegalArgumentException.class,
                () -> catPopulation.dividedBy(dogPopulation)
        );

    }

    @Test

    public void testDividByNormal(){
        TimeSeries catPopulation = new TimeSeries();
        TimeSeries dogPopulation = new TimeSeries();

        catPopulation.put(2001, 100.0);
        catPopulation.put(2000, 10000.0);
        catPopulation.put(1997, 500.0);
        catPopulation.put(2023, 2000.0);

        dogPopulation.put(1997, 1000.0);
        dogPopulation.put(2000, 3000.0);
        dogPopulation.put(2023, 1000.0);

        ArrayList<Integer> expectedYears = new ArrayList<>();
        expectedYears.add(1997);
        expectedYears.add(2000);
        expectedYears.add(2023);

        ArrayList<Double> expectedData = new ArrayList<>();
        expectedData.add(2.0);
        expectedData.add(0.30);
        expectedData.add(0.50);

        TimeSeries divisionResult = dogPopulation.dividedBy(catPopulation);

        assertThat(divisionResult.years()).isEqualTo(expectedYears);
        for(int i = 0; i < expectedData.size(); i++) {
            assertThat(divisionResult.data().get(i)).isWithin(1E-10).of(expectedData.get(i));
        }
    }
} 