package com.example.calander;

//public class EthiopianDateActivity {
//}
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicInteger;

public class AppDateActivity extends AppCompatActivity {

    private int tewsakDay, wenber1, Abeqtie, Lelit, Werih, Mealt, Metqie, year, month, date, MebajaHamer, BMT, dayToAdd;
    private String Ilet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get Fields
        EditText etYear = findViewById(R.id.etYear);
        EditText etMonth = findViewById(R.id.etMonth);
        EditText etDay = findViewById(R.id.etDay);
        EditText wenber = findViewById(R.id.edwenber);
        EditText ab = findViewById(R.id.AB);
        EditText mt = findViewById(R.id.MT);
        EditText mh = findViewById(R.id.MH);
        EditText mr = findViewById(R.id.MR);
        EditText ms = findViewById(R.id.MS);
        EditText wengel = findViewById(R.id.Wengel);
        EditText sep1 = findViewById(R.id.sepOne);
        EditText bmt = findViewById(R.id.BMT);
        EditText nn = findViewById(R.id.NN);
        EditText ay = findViewById(R.id.AY);
        EditText dz = findViewById(R.id.DZ);
        EditText hn = findViewById(R.id.HN);
        EditText st = findViewById(R.id.ST);
        EditText ta = findViewById(R.id.TA);
        EditText rc = findViewById(R.id.RC);
        EditText it = findViewById(R.id.IT);
        EditText ps = findViewById(R.id.PS);
        EditText hw = findViewById(R.id.HW);
        EditText dt = findViewById(R.id.DT);
        EditText tir = findViewById(R.id.Tir);
        EditText sep17 = findViewById(R.id.Mesq);
        EditText meg = findViewById(R.id.Meg);
        EditText lelit = findViewById(R.id.lelit);
        EditText werih = findViewById(R.id.werih);
        EditText mealt = findViewById(R.id.mealt);
        EditText ilet = findViewById(R.id.Ilet);
         year = month = date = 0;

        // Add Days Button Click
        Button btnAddDays = findViewById(R.id.btnAddDays);
        btnAddDays.setOnClickListener(v -> {

            String yearString = etYear.getText().toString();
            String monthString = etMonth.getText().toString();
            String dayString = etDay.getText().toString();

            // Check if the input fields are empty
            if (yearString.isEmpty() || monthString.isEmpty() || dayString.isEmpty()) {
                Toast.makeText(this, "እባክዎን አስፈላጊ ስለሆኑ ሁሉንም ቦታዎች በተገቢው ሁኔታ ይሙሏቸው!", Toast.LENGTH_SHORT).show();
            } else {
                // Parse the input values from EditText as integers
                year = Integer.parseInt(etYear.getText().toString());
                month = Integer.parseInt(etMonth.getText().toString());
                date = Integer.parseInt(etDay.getText().toString());

                int MeteneRabit, fotTewsak, mn, dte, yr, dtoAdd;
                String sep = "", Mtday="";
                if (year < 0 || month > 13 || month < 1 || date > 30 || date < 1) {
                    Toast.makeText(this, "እባክዎን አስፈላጊ ስለሆኑ ሁሉንም ቦታዎች በተገቢው ሁኔታ ይሙሏቸው!", Toast.LENGTH_SHORT).show();
                } else {

                    // Perform calculations
                    wenber1 = calculateWenber(year);
                    Abeqtie = 11 * wenber1 % 30;
                    Metqie = (Abeqtie == 0) ? 30 : (19 * wenber1 % 30);

                    wenber.setText(String.valueOf(wenber1));
                    ab.setText(String.valueOf(Abeqtie));
                    mt.setText(String.valueOf(Metqie));
                    
                    MeteneRabit = (year + 5500) / 4;
                    String leapYearName = getLeapYearName((year + 5500) % 4);
                    int toSep = (MeteneRabit + year + 5500) % 7;
                    sep = getWeekday(0, 1, toSep); // get September 1 Day
                    sep1.setText("መስከረም 1 : "+String.valueOf(Metqie) + sep);
                    fotTewsak = toSep + Metqie;
                    fotTewsak %= 7;
                    Mtday = getWeek(fotTewsak - 1); // get BealeMetqie Date and Day
                   // sep = getWeekday(fotTewsak); // get BealeMetqie Date and Day
                    int forNenewe = Metqie + fotTewsak;
                    if(Metqie >= 15){
                        BMT = (30 + Metqie)%30;
                        if(BMT==0){
                            BMT = 30; //set Beale Metqie 30 if it is on 30 sep
                        }
                        bmt.setText("ቀኑ፡ መስከረም / " + String.valueOf(BMT) +"/ " + year +". ዕለቱ: " + Mtday + " = ተውሳኩ => " + tewsakDay);
                      //  bmt.setText("September : " + String.valueOf(Metqie) + " / " + year + ". on " + Mtday);//set Beale Metqie with a day and date
                    }else{
                        BMT = Metqie%30;
                        bmt.setText("ቀኑ፡ ጥቅምት : "+String.valueOf(BMT) +"/ " + year + ". ዕለቱ " + Mtday + " = ተውሳኩ => " + tewsakDay);
                    }
                    int MebajaHamer = (Metqie + tewsakDay) % 30;
                    if(MebajaHamer == 0 ){
                        MebajaHamer = 30;
                    }

                    Lelit = Abeqtie + (month/2) + date;
                    Werih = Lelit + 4;
                    Mealt = date;
                    Ilet = getWeekday(year, month, date);
                    mh.setText(String.valueOf(MebajaHamer));
                    mr.setText(String.valueOf(MeteneRabit));
                    ms.setText(String.valueOf(fotTewsak));
                    wengel.setText(leapYearName);
                    sep1.setText(sep);
                    tir.setText(getDay(21, 5, toSep));
                    sep17.setText(getDay(17, 1,toSep));
                    meg.setText(getDay(29, 6, toSep));

                    // atswamat
                    if(Metqie > 14) {
                        mn=05;
                        if((Metqie + fotTewsak)>30){
                            mn = 06;
                        }
                        nn.setText(addEthiopianDays(year,mn,MebajaHamer,0) + ": ሰኞ");
                        ay.setText(addEthiopianDays(year,mn,MebajaHamer,14) + ": ሰኞ");
                        dz.setText(addEthiopianDays(year,mn,MebajaHamer,41) + ": እሑድ");
                        hn.setText(addEthiopianDays(year,mn,MebajaHamer,62) + ": እሑድ");
                        st.setText(addEthiopianDays(year,mn,MebajaHamer,67) + ": ዓርብ");
                        ta.setText(addEthiopianDays(year,mn,MebajaHamer,69) + ": እሑድ");
                        rc.setText(addEthiopianDays(year,mn,MebajaHamer,93) + ": ረቡዕ");
                        it.setText(addEthiopianDays(year,mn,MebajaHamer,108) + ": ኀሙስ");
                        ps.setText(addEthiopianDays(year,mn,MebajaHamer,118) + ": እሑድ");
                        hw.setText(addEthiopianDays(year,mn,MebajaHamer,119) + ": ሰኞ");
                        dt.setText(addEthiopianDays(year,mn,MebajaHamer,121) + ": ረቡዕ");

                    }else{
                        mn = 06;
                        nn.setText(addEthiopianDays(year,mn,MebajaHamer,0) + ": ሰኞ");
                        ay.setText(addEthiopianDays(year,mn,MebajaHamer,14) + ": ሰኞ");
                        dz.setText(addEthiopianDays(year,mn,MebajaHamer,41) + ": እሑድ");
                        hn.setText(addEthiopianDays(year,mn,MebajaHamer,62) + ": እሑድ");
                        st.setText(addEthiopianDays(year,mn,MebajaHamer,67) + ": ዓርብ");
                        ta.setText(addEthiopianDays(year,mn,MebajaHamer,69) + ": እሑድ");
                        rc.setText(addEthiopianDays(year,mn,MebajaHamer,93) + ": ረቡዕ");
                        it.setText(addEthiopianDays(year,mn,MebajaHamer,108) + ": ኀሙስ");
                        ps.setText(addEthiopianDays(year,mn,MebajaHamer,118) + ": እሑድ");
                        hw.setText(addEthiopianDays(year,mn,MebajaHamer,119) + ": ሰኞ");
                        dt.setText(addEthiopianDays(year,mn,MebajaHamer,121) + ": ረቡዕ");
                    }
                    lelit.setText(String.valueOf(Lelit));
                    werih.setText(String.valueOf(Werih));
                    mealt.setText(String.valueOf(Mealt));
                    ilet.setText(Ilet);
                }
            }
        });

        Button btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener(v -> {
            // Clear all the input fields
            etYear.setText("");
            etMonth.setText("");
            etDay.setText("");
            wenber.setText("");
            ab.setText("");
            mt.setText("");
            mh.setText("");
            mr.setText("");
            ms.setText("");
            wengel.setText("");
            sep1.setText("");
            bmt.setText("");
            nn.setText("");
            ay.setText("");
            dz.setText("");
            hn.setText("");
            st.setText("");
            ta.setText("");
            rc.setText("");
            it.setText("");
            ps.setText("");
            hw.setText("");
            dt.setText("");
            tir.setText("");
            sep17.setText("");
            meg.setText("");
        });
    }

    // Function to calculate Wenber value
    private int calculateWenber(int year) {
        int c = (year + 5500) % 532;
        if (c == 0) return 18;
        c %= 76;
        if (c == 0) return 18;
        c %= 19;
        return (c == 0) ? 18 : c - 1;
    }

    private String getWeek(int z) {
        switch (z) {
            case 1: tewsakDay = 5; return "ማግሰኞ";
            case 2: tewsakDay = 4; return "ረቡዕ";
            case 3: tewsakDay = 3; return "ኀሙስ";
            case 4: tewsakDay = 2; return "ዓርብ";
            case 5: tewsakDay = 8; return "ቀዳሚት ሰንበት";
            case 6: tewsakDay = 7; return "ሰንበተ ክርስትያን ቅድስት";
            case 0: tewsakDay = 6; return "ሰኞ";
            default: return "የተሳሳተ";
        }
    }
    // Function to calculate the weekday for Meskerem 1
    private String getWeekday(int date, int month, int sep1) {
        int z = (date + 2*(month-1) + sep1) % 7;
        switch (z) {
            case 1: return "ማግሰኞ";
            case 2: return "ረቡዕ";
            case 3: return "ኀሙስ";
            case 4: return "ዓርብ";
            case 5: return "ቀዳሚት ሰንበት"; // sep 17
            case 6: return "ሰንበተ ክርስትያን ቅድስት"; //
            case 0: return "ሰኞ";
            default: return "የተሳሳተ";
        }
    }
    //getDay
    private String getDay(int date, int month, int sep1) {
        int z = ((date - 1) + 2*(month-1) + sep1) % 7;
        switch (z) {
            case 1: return "ማግሰኞ";
            case 2: return "ረቡዕ";
            case 3: return "ኀሙስ";
            case 4: return "ዓርብ";
            case 5: return "ቀዳሚት ሰንበት"; // sep 17
            case 6: return "ሰንበተ ክርስትያን ቅድስት"; //
            case 0: return "ሰኞ";
            default: return "የተሳሳተ";
        }
    }

    // Function to map leap year result to names
    private String getLeapYearName(int leapYear) {
        switch (leapYear) {
            case 0: return "ዮሐንስ";
            case 1: return "ማቴዎስ";
            case 2: return "ማርቆስ";
            case 3: return "ሉቃስ";
            default: return "የተሳሳተ";
        }
    }

    // Function to add days to an Ethiopian calendar date
    public String addEthiopianDays ( int year, int month, int day, int daysToAdd){
        // Step 1: Calculate the total days passed in the Ethiopian year from the input date
        int totalDays = calculateTotalDays(year, month, day);

        // Step 2: Add the number of days to the total days.
        totalDays += daysToAdd;

        // Handle overflow (Pagume, the 13th month, has 5 or 6 days depending on leap year)
        int daysInYear = isLeapYear(year) ? 366 : 365;  // Ethiopian leap year check
        if (totalDays > daysInYear) {
            totalDays -= daysInYear;  // Loop over to the next year
            year++;
        } else if (totalDays <= 0) {
            year--;
            totalDays += daysInYear;  // Loop to the previous year
        }

        // Step 3: Convert 'day of the year' back to Ethiopian month and day.
        return convertDaysToEthiopianDate(totalDays, year);
    }

    // Calculate the total number of days passed since the start of the Ethiopian year
    private int calculateTotalDays ( int year, int month, int day){
        // Convert the date to "day of the year"
        int daysInPreviousMonths = (month - 1) * 30;  // Each month has 30 days
        int totalDays = daysInPreviousMonths + day;

        // Handle overflow if the month is beyond the 12th month
        if (month > 12) {
            totalDays += 5;  // Pagume month, add 5 days for non-leap years
            if (isLeapYear(year)) totalDays++; // Add 1 extra day for leap year
        }

        return totalDays;
    }

    // Function to convert total days into a valid Ethiopian date (Month/Day/Year)
    private String convertDaysToEthiopianDate ( int totalDays, int year){
        int newMonth = (totalDays - 1) / 30 + 1; // Ethiopian month (1-12)
        int newDay = (totalDays - 1) % 30 + 1;   // Day of the month (1-30)

        // If the day is beyond the 30th, it must be in Pagume
        if (newMonth > 12) {
            newMonth = 13;  // Set to Pagume (13th month)
            newDay = totalDays - 360; // Calculate the days in Pagume (1-5 or 1-6)
        }

        return newDay + "/" + newMonth + "/" + year;
    }

    // Leap year check for Ethiopian calendar
    private boolean isLeapYear ( int year){
        return (year + 5500) % 4 == 3;  // Ethiopian leap year logic
    }
}
