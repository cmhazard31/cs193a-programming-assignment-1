//Michael Hazard <cmhazard@stanford.edu
//Nice Dice: This app will roll dice with the specified
//number of sides, specified number of dice per roll
//and specified number of rolls. It outputs the total
//sum of the rolls, and prints the sequence in which they
//occured. Will not accept non-integer values, or values
//below 2 for die type and 1 for # of dice and rolls.
package stanford.michael_hazard_assignment_1;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;

public class Home extends AppCompatActivity {

/*
Method called upon roll button press.
Gets spanning from TextView, converts to string, parses to in.
Uses Java's random class to simulate specified die roll.
Calls setText helper method to set text field with roll info.
 */

    public void roll(View view) {
        TextView numSides = (TextView) findViewById(R.id.numSides);
        TextView numDice = (TextView) findViewById(R.id.numDice);
        TextView numRolls = (TextView) findViewById(R.id.numRolls);

        int sides = 6;
        int dice = 1;
        int rolls = 1;

        if (numSides.getText().length() != 0) {
            sides = Integer.parseInt(numSides.getText().toString());
            if (!(sides > 1)) {
                setText("Enter a valid number of sides.");
                return;
            }
        } else {
            setText("Enter a valid number of sides.");
            return;
        }

        if (numDice.getText().length() != 0) {
            dice = Integer.parseInt(numDice.getText().toString());
            if (!(dice > 0)) {
                setText("Enter a valid die type.");
                return;
            }
        } else {
            setText("Enter a valid die type.");
            return;
        }

        if (numRolls.getText().length() != 0) {
            rolls = Integer.parseInt(numRolls.getText().toString());
            if (!(rolls > 0)) {
                setText("Enter a valid number of rolls.");
                return;
            }
        } else {
            setText("Enter a valid number of rolls.");
            return;
        }

        Random dieRoll = new Random();

        int totalSum = 0;
        String infoStream = "";

        for (int i = 0; i < rolls; i++) {
            int runningSum = 0;
            for (int j = 0; j < dice; j++) {
                runningSum += dieRoll.nextInt(sides - 1) + 1;
            }
            totalSum += runningSum;
            infoStream += runningSum + ",";
        }
        infoStream = infoStream.substring(0, infoStream.length() - 1);

        String printStr = "The total is: " + totalSum + "\n" + "\n" +
                "The individual rolls were: \n" + infoStream;

        setText(printStr);
    }

    /*
    Sets text of roll info field to the string passed.
     */
    public void setText(String str) {
        TextView info = (TextView) findViewById(R.id.rollInfo);
        info.setText(str);
    }

    /*
    Called by clear button, clears roll info and prints "Cleared"
     */
    public void clearEx(View view) {
        setText("Cleared");
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Home Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://stanford.michael_hazard_assignment_1/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Home Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://stanford.michael_hazard_assignment_1/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
