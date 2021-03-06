// Copyright 2015 Google Inc. All Rights Reserved.

package org.robolectric.shadows;

import android.os.Build;
import android.text.format.DateUtils;
import libcore.icu.DateIntervalFormat;
import android.icu.util.TimeZone;
import android.icu.util.ULocale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.TestRunners;
import org.robolectric.annotation.Config;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

@RunWith(TestRunners.MultiApiWithDefaults.class)
@Config(sdk = {
    Build.VERSION_CODES.M })
public class ShadowDateIntervalFormatTest {

  @Test
  public void testDateInterval_FormatDateRange() {

    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, 2013);
    calendar.set(Calendar.MONTH, Calendar.JANUARY);
    calendar.set(Calendar.DAY_OF_MONTH, 20);

    long timeInMillis = calendar.getTimeInMillis();
    String actual = DateIntervalFormat.formatDateRange(ULocale.getDefault(), TimeZone.getDefault(), timeInMillis, timeInMillis, DateUtils.FORMAT_NUMERIC_DATE);

    assertEquals("1/20/2013", actual);
  }
}
