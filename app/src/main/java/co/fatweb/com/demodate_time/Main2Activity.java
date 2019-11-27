package co.fatweb.com.demodate_time;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Main2Activity extends AppCompatActivity {
    Button btn_add;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int seconds;
    TextView txt_datetime;

    String str_date,str_date1;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt_datetime = findViewById(R.id.txt_datetime);

        btn_add = findViewById(R.id.btn_Add);
     btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final View dialogView = View.inflate(Main2Activity.this, R.layout.date_time_picker, null);
                final AlertDialog alertDialog = new AlertDialog.Builder(Main2Activity.this).create();

                dialogView.findViewById(R.id.date_time_set).setOnClickListener(new View.OnClickListener() {
                    int year;
                    int month;
                    int day;
                    int hour;
                    int minute;
                    int seconds;

                    @Override
                    public void onClick(View view) {

                       /* DatePicker datePicker = (DatePicker) dialogView.findViewById(R.id.datePickerExample);
                        TimePicker timePicker = (TimePicker) dialogView.findViewById(R.id.timePickerExample);
*/


                        Calendar currCalendar = Calendar.getInstance();

                        // Set the timezone which you want to display time.
                        currCalendar.setTimeZone(TimeZone.getTimeZone("Asia/Hong_Kong"));

                        year = currCalendar.get(Calendar.YEAR);
                        month = currCalendar.get(Calendar.MONTH);
                        day = currCalendar.get(Calendar.DAY_OF_MONTH);
                        hour = currCalendar.get(Calendar.HOUR_OF_DAY);
                        minute = currCalendar.get(Calendar.MINUTE);
                        seconds = currCalendar.get(Calendar.SECOND);

                        showUserSelectDateTime();

                        // Get date picker object.
                        DatePicker datePicker = (DatePicker) dialogView.findViewById(R.id.datePickerExample);
                        datePicker.init(year - 1, month + 1, day + 5, new DatePicker.OnDateChangedListener() {
                            @Override
                            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                                Main2Activity.this.year = year;
                                Main2Activity.this.month = month;
                                Main2Activity.this.day = day;
                                str_date = year + "-" + (month + 1) + "-" + day;
                                showUserSelectDateTime();
                            }
                        });
                        TimePicker timePicker = (TimePicker) dialogView.findViewById(R.id.timePickerExample);
                        timePicker.setHour(this.hour);
                        timePicker.setMinute(this.minute);

                        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                            @Override
                            public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
                                Main2Activity.this.hour = hour;
                                Main2Activity.this.minute = minute;

                                showUserSelectDateTime();
                            }
                        });

                    }

                   /* Show user selected date time in bottom text vew area. */
                    private void showUserSelectDateTime() {
                        // Get TextView object which is used to show user pick date and time.
                        TextView textView = (TextView) dialogView.findViewById(R.id.textViewShowDateTime);

                        StringBuffer strBuffer = new StringBuffer();
                        strBuffer.append(this.year);
                        strBuffer.append("-");
                        strBuffer.append(this.month + 1);
                        strBuffer.append("-");
                        strBuffer.append(this.day);
                        strBuffer.append(" ");
                        strBuffer.append(this.hour);
                        strBuffer.append(":");
                        strBuffer.append(this.minute);
                        strBuffer.append(":");
                        strBuffer.append(this.seconds);

                        textView.setText(strBuffer.toString());
                        str_date1 = textView.getText().toString();
                        Toast.makeText(Main2Activity.this, "asas" + str_date1, Toast.LENGTH_SHORT).show();
                      /* textView.setTextColor(Color.BLUE);
                        textView.setGravity(Gravity.CENTER);
                        textView.setTextSize(10);*/
                      alertDialog.dismiss();

                    }
                });

                alertDialog.setView(dialogView);
                alertDialog.show();

            }
        });
     try {
         Log.d("DATW", str_date1);
     }
     catch (Exception e){}
      //  txt_datetime.setText(str_date);

    }
}


