package evan.chen.tutorial.tdd.customcomponentsample

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import kotlinx.android.synthetic.main.number_select.view.*
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class NumberSelectAndroidTest {

    @Test
    fun testAddButtonThenValueShouldAdd() {

        val context = InstrumentationRegistry.getTargetContext()

        val numberSelect = NumberSelect(context)
        numberSelect.setDefaultValue(1)
        numberSelect.addButton.performClick()

        Assert.assertEquals(2, numberSelect.textValue)
    }

    @Test
    fun testMinusButtonThenValueShouldMinus() {

        val context = InstrumentationRegistry.getTargetContext()

        val numberSelect = NumberSelect(context)
        numberSelect.setDefaultValue(2)
        numberSelect.minusButton.performClick()

        Assert.assertEquals(1, numberSelect.textValue)
    }

    @Test
    fun testMinValueLimit() {

        val context = InstrumentationRegistry.getTargetContext()

        val numberSelect = NumberSelect(context)
        numberSelect.setDefaultValue(2)
        numberSelect.setMinValue(2)
        numberSelect.minusButton.performClick()

        Assert.assertEquals(2, numberSelect.textValue)
    }

    @Test
    fun testMaxValueLimit() {

        val context = InstrumentationRegistry.getTargetContext()

        val numberSelect = NumberSelect(context)
        numberSelect.setDefaultValue(2)
        numberSelect.setMaxValue(2)
        numberSelect.addButton.performClick()

        Assert.assertEquals(2, numberSelect.textValue)
    }
}