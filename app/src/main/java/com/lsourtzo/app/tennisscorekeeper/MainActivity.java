package com.lsourtzo.app.tennisscorekeeper;


import android.content.res.Resources;
import android.graphics.Color;
import android.icu.text.DateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;


import static android.R.attr.id;
import static com.lsourtzo.app.tennisscorekeeper.R.id.practicecheckbox;
import static com.lsourtzo.app.tennisscorekeeper.R.id.radiogroupcourt;
import static com.lsourtzo.app.tennisscorekeeper.R.id.radiogroupgames;
import static com.lsourtzo.app.tennisscorekeeper.R.id.radiogroupsets;
import static com.lsourtzo.app.tennisscorekeeper.R.id.score10;
import static com.lsourtzo.app.tennisscorekeeper.R.id.score11;
import static com.lsourtzo.app.tennisscorekeeper.R.id.score12;
import static com.lsourtzo.app.tennisscorekeeper.R.id.score13;
import static com.lsourtzo.app.tennisscorekeeper.R.id.score14;
import static com.lsourtzo.app.tennisscorekeeper.R.id.score15;
import static com.lsourtzo.app.tennisscorekeeper.R.id.score16;
import static com.lsourtzo.app.tennisscorekeeper.R.id.score20;
import static com.lsourtzo.app.tennisscorekeeper.R.id.score21;
import static com.lsourtzo.app.tennisscorekeeper.R.id.score22;
import static com.lsourtzo.app.tennisscorekeeper.R.id.score23;
import static com.lsourtzo.app.tennisscorekeeper.R.id.score24;
import static com.lsourtzo.app.tennisscorekeeper.R.id.score25;
import static com.lsourtzo.app.tennisscorekeeper.R.id.score26;
import static com.lsourtzo.app.tennisscorekeeper.R.id.windowplayer1;
import static com.lsourtzo.app.tennisscorekeeper.R.id.windowplayer2;
import static java.lang.Boolean.TRUE;

public class MainActivity extends AppCompatActivity {

    // Variables ------------------------------------------------------------------------------------------------------------------------


    // Save var
    static final String PlayerName1S = "PlayerName1";
    static final String PlayerName2S = "PlayerName2";
    static final String WinningGamesS = "WinningGames";
    static final String practicegamepointsS = "practicegamepoints";
    static final String WinningSetsS = "WinningSets";
    static final String NetPointsForGameS = "NetPointsForGame";
    static final String courttypeS = "courttype";
    static final String PracticeModeS = "PracticeMode";
    static final String firstWindowsS = "firstWindows";
    static final String UndoS = "UndoStatus";

    // Backable variables
    static final String Tie_BreakeS = "Tie_Breake";
    static final String DueceS = "Duece";
    static final String GameS = "GameNumber";
    static final String SetNumberS = "SetNumber";
    static final String FaultCounterS = "FaultCounter";
    static final String ServicePlayerS = "ServicePlayer";
    static final String PointNumberS = "PointNumber";

    // Backup - Undo variables
    static final String Tie_BreakeBS = "Tie_BreakeB";
    static final String DueceBS = "DueceB";
    static final String GameBS = "GameNumberB";
    static final String SetNumberBS = "SetNumberB";
    static final String FaultCounterBS = "FaultCounterB";
    static final String ServicePlayerBS = "ServicePlayerB";
    static final String PointNumberBS = "PointNumberB";

    // Declare var
    public String PlayerName1;
    public String PlayerName2;
    public int WinningSets = 3;
    public int NetPointsForGame = 2;
    public int WinningGames = 6;
    public int practicegamepoints = 7;
    public int courttype = 2;
    public boolean firstWindows = true;
    public boolean PracticeMode = false;
    public boolean UndoStatus = false;
    public boolean checkNetPointsForGame = false;
    // Backable variables
    public boolean Tie_Breake = false;
    public boolean Duece = false;
    public int GameNumber = 1;
    public int SetNumber = 1;
    public int FaultCounter = 0;
    public int ServicePlayer = 1;
    public int PointNumber = 1;

    // Backup - Undo variables
    public boolean Tie_BreakeB = false;
    public boolean DueceB = false;
    public int GameNumberB = 1;
    public int SetNumberB = 1;
    public int FaultCounterB = 0;
    public int ServicePlayerB = 1;
    public int PointNumberB = 1;

    // Backable variables
    public int StatsTableSize = 6; // 0. aces 1.winners 2. Double Fault 3. Breaks 4-5.max cont points
    public int[] Score1 = new int[7];// 0. score 1. sets 2-6. games
    public int[] Score2 = new int[7];
    public int[] Stats1 = new int[StatsTableSize];
    public int[] Stats2 = new int[StatsTableSize];

    // Backup - Undo variables
    public int[] Score1B = new int[7];// 0. score 1. sets 2-6. games
    public int[] Score2B = new int[7];
    public int[] Stats1B = new int[StatsTableSize];
    public int[] Stats2B = new int[StatsTableSize];

    public static String[] CourtType = new String[]{"#2da016", "#e88d23", "#0353b6"};
    public static String[] CourtTypeName = new String[]{"Grass", "Clay", "Hard"};

    // Methods -------------------------------------------------------------------------------------------------------------------------

    // OnCreate -------------------------------------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        winVis(R.id.popupwindow1);
        winVis(R.id.popupwindow);


    }

    // Variable Saving Methods -------------------------------------------------------------------------------------------------------------------------

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Save custom values into the bundle
        savedInstanceState.putString(PlayerName1S, PlayerName1);
        savedInstanceState.putString(PlayerName2S, PlayerName2);
        savedInstanceState.putInt(WinningSetsS, WinningSets);
        savedInstanceState.putInt(NetPointsForGameS, NetPointsForGame);
        savedInstanceState.putInt(WinningGamesS, WinningGames);
        savedInstanceState.putInt(practicegamepointsS, practicegamepoints);
        savedInstanceState.putInt(courttypeS, courttype);
        savedInstanceState.putBoolean(firstWindowsS, firstWindows);
        savedInstanceState.putBoolean(PracticeModeS, PracticeMode);
        savedInstanceState.putBoolean(UndoS, UndoStatus);
        // Backable variables
        savedInstanceState.putBoolean(Tie_BreakeS, Tie_Breake);
        savedInstanceState.putBoolean(DueceS, Duece);
        savedInstanceState.putInt(GameS, GameNumber);
        savedInstanceState.putInt(SetNumberS, SetNumber);
        savedInstanceState.putInt(FaultCounterS, FaultCounter);
        savedInstanceState.putInt(ServicePlayerS, ServicePlayer);
        savedInstanceState.putInt(PointNumberS, PointNumber);
        savedInstanceState.putIntArray("Score1S", Score1);
        savedInstanceState.putIntArray("Score2S", Score2);
        savedInstanceState.putIntArray("Stats1S", Stats1);
        savedInstanceState.putIntArray("Stats2S", Stats2);
        // Backup - Undo variables
        savedInstanceState.putBoolean(Tie_BreakeBS, Tie_BreakeB);
        savedInstanceState.putBoolean(DueceBS, DueceB);
        savedInstanceState.putInt(GameBS, GameNumberB);
        savedInstanceState.putInt(SetNumberBS, SetNumberB);
        savedInstanceState.putInt(FaultCounterBS, FaultCounterB);
        savedInstanceState.putInt(ServicePlayerBS, ServicePlayerB);
        savedInstanceState.putInt(PointNumberBS, PointNumberB);
        savedInstanceState.putIntArray("Score1SB", Score1B);
        savedInstanceState.putIntArray("Score2SB", Score2B);
        savedInstanceState.putIntArray("Stats1SB", Stats1B);
        savedInstanceState.putIntArray("Stats2SB", Stats2B);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);

        DisplayMethod();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        // Restore state members from saved instance
        PlayerName1 = savedInstanceState.getString(PlayerName1S);
        PlayerName2 = savedInstanceState.getString(PlayerName2S);
        WinningSets = savedInstanceState.getInt(WinningSetsS);
        NetPointsForGame = savedInstanceState.getInt(NetPointsForGameS);
        WinningGames = savedInstanceState.getInt(WinningGamesS);
        practicegamepoints = savedInstanceState.getInt(practicegamepointsS);
        courttype = savedInstanceState.getInt(courttypeS);
        firstWindows = savedInstanceState.getBoolean(firstWindowsS);
        PracticeMode = savedInstanceState.getBoolean(PracticeModeS);
        UndoStatus = savedInstanceState.getBoolean(UndoS);
        // Backable variables
        Tie_Breake = savedInstanceState.getBoolean(Tie_BreakeS);
        Duece = savedInstanceState.getBoolean(DueceS);
        GameNumber = savedInstanceState.getInt(GameS);
        SetNumber = savedInstanceState.getInt(SetNumberS);
        FaultCounter = savedInstanceState.getInt(FaultCounterS);
        ServicePlayer = savedInstanceState.getInt(ServicePlayerS);
        PointNumber = savedInstanceState.getInt(PointNumberS);
        Score1 = savedInstanceState.getIntArray("Score1S");
        Score2 = savedInstanceState.getIntArray("Score2S");
        Stats1 = savedInstanceState.getIntArray("Stats1S");
        Stats2 = savedInstanceState.getIntArray("Stats2S");
        // Backup - Undo variables
        Tie_BreakeB = savedInstanceState.getBoolean(Tie_BreakeBS);
        DueceB = savedInstanceState.getBoolean(DueceBS);
        GameNumberB = savedInstanceState.getInt(GameBS);
        SetNumberB = savedInstanceState.getInt(SetNumberBS);
        FaultCounterB = savedInstanceState.getInt(FaultCounterBS);
        ServicePlayerB = savedInstanceState.getInt(ServicePlayerBS);
        PointNumberB = savedInstanceState.getInt(PointNumberBS);
        Score1B = savedInstanceState.getIntArray("Score1SB");
        Score2B = savedInstanceState.getIntArray("Score2SB");
        Stats1B = savedInstanceState.getIntArray("Stats1SB");
        Stats2B = savedInstanceState.getIntArray("Stats2SB");

        if (!firstWindows) {
            winInv(R.id.popupwindow1);
            winInv(R.id.popupwindow);
            changetext(PlayerName1, R.id.name11);
            changetext(PlayerName1, R.id.name12);
            changetext(PlayerName2, R.id.name21);
            changetext(PlayerName2, R.id.name22);
            setcourt(CourtType[courttype]);
        } else {
            winVis(R.id.popupwindow1);
            winVis(R.id.popupwindow);
        }

        DisplayMethod();

    }

    // Buttons Methods -------------------------------------------------------------------------------------------------------------------------

    //Startup Window OK Button --------------------------------------

    public void StartingApp(View v) {
        EnableAllButton();
        RadioGroup courtradioGroup = (RadioGroup) findViewById(radiogroupcourt);
        switch (courtradioGroup.getCheckedRadioButtonId()) {
            case R.id.grashcourt:
                courttype = 0;
                break;
            case R.id.claycourt:
                courttype = 1;
                break;
            case R.id.hardcourt:
                courttype = 2;
                break;
        }
        setcourt(CourtType[courttype]);

        RadioGroup sets = (RadioGroup) findViewById(radiogroupsets);
        switch (sets.getCheckedRadioButtonId()) {
            case R.id.radiogroupsets1:
                WinningSets = 1;
                break;
            case R.id.radiogroupsets2:
                WinningSets = 2;
                break;
            case R.id.radiogroupsets3:
                WinningSets = 3;
                break;
        }

        RadioGroup games = (RadioGroup) findViewById(radiogroupgames);
        switch (games.getCheckedRadioButtonId()) {
            case R.id.radiogroupgames3:
                WinningGames = 3;
                break;
            case R.id.radiogroupgames4:
                WinningGames = 4;
                break;
            case R.id.radiogroupgames5:
                WinningGames = 5;
                break;
            case R.id.radiogroupgames6:
                WinningGames = 6;
                break;
        }

        EditText PM_PointToWinGame = (EditText) findViewById(R.id.tiebreakewinningpoints);
        practicegamepoints = Integer.parseInt(PM_PointToWinGame.getText().toString());

        CheckBox checkPractice = (CheckBox) findViewById(R.id.practicecheckbox);
        PracticeMode = Boolean.valueOf(checkPractice.isChecked());

        CheckBox NetPoints = (CheckBox) findViewById(R.id.netpointsforgame);
        checkNetPointsForGame = Boolean.valueOf(NetPoints.isChecked());

        if (checkNetPointsForGame)
        {NetPointsForGame=1;}
        else
        {NetPointsForGame=2;}

        resetall();

        //Startup window disable ...
        winInv(R.id.popupwindow1);
        winInv(R.id.popupwindow);
        firstWindows = false;

        //Set the names to players
        EditText pn1 = (EditText) findViewById(windowplayer1);
        PlayerName1 = pn1.getText().toString();
        changetext(PlayerName1, R.id.name11);
        changetext(PlayerName1, R.id.name12);
        EditText pn2 = (EditText) findViewById(windowplayer2);
        PlayerName2 = pn2.getText().toString();
        changetext(PlayerName2, R.id.name21);
        changetext(PlayerName2, R.id.name22);

        DisplayMethod();

    }


    // ONCancel  ----------------------------------------------------
    public void CancelRestart(View v) {
        winInv(R.id.popupwindow1);
        winInv(R.id.popupwindow);
        EnableAllButton();
    }

    // Button Listener ----------------------------------------------------
    public void buttonOnClick(View view) {
        switch (view.getId()) {
            case R.id.point1:
                UndoBackup();
                Score1[0] = Score1[0] + 1;
                Checkmaxp1();
                setparam();
                break;
            case R.id.point2:
                UndoBackup();
                Score2[0] = Score2[0] + 1;
                Checkmaxp2();
                setparam();
                break;
            case R.id.winner1:
                UndoBackup();
                Checkmaxp1();
                Score1[0] = Score1[0] + 1;
                Stats1[1] = Stats1[1] + 1;
                setparam();
                break;
            case R.id.winner2:
                UndoBackup();
                Checkmaxp2();
                Score2[0] = Score2[0] + 1;
                Stats2[1] = Stats2[1] + 1;
                setparam();
                break;
            case R.id.ace:
                UndoBackup();
                if (ServicePlayer == 1) {
                    Score1[0] = Score1[0] + 1;
                    Stats1[0] = Stats1[0] + 1;
                    Checkmaxp1();
                } else {
                    Score2[0] = Score2[0] + 1;
                    Stats2[0] = Stats2[0] + 1;
                    Checkmaxp2();
                }
                setparam();
                break;
            case R.id.fault:
                UndoBackup();
                if (FaultCounter == 0) {
                    FaultCounter = FaultCounter + 1;
                } else {
                    if (ServicePlayer == 2) {
                        Score1[0] = Score1[0] + 1;
                        Checkmaxp1();
                        Stats2[2] = Stats2[2] + 1;
                    } else {
                        Score2[0] = Score2[0] + 1;
                        Checkmaxp2();
                        Stats1[2] = Stats1[2] + 1;
                    }
                    setparam();
                }
                break;
            case R.id.undo:
                // Code for button undo click
                UndoRestore();
                break;
            case R.id.stats:
            case R.id.stats2:
                // Code for button stat click
                winVis(R.id.popupwindow1b);
                winVis(R.id.popupwindowStats);
                fillStats();
                DisableAllButton();
                break;

            // ON Restart ----------------------------------------------------
            case R.id.restartb:
                butVis(R.id.bcancel);
                winVis(R.id.popupwindow1);
                winVis(R.id.popupwindow);
                DisableAllButton();
                break;

            // ON Restart After Winning-------------------------------------------------
            case R.id.restartb2:
                butInv(R.id.bcancel);
                winInv(R.id.popupwindowFinal);
                winVis(R.id.popupwindow1);
                winVis(R.id.popupwindow);
                DisableAllButton();
                break;

            // ON Stats Close  -------------------------------------------------
            case R.id.statsclosebutton:
                winInv(R.id.popupwindow1b);
                winInv(R.id.popupwindowStats);
                EnableAllButton();
                break;
        }

        // check if winning game
        CheckGame();


        // display score1
        DisplayMethod();
    }


    // Other Methods ---------------------------------------------------------------------------------------------------------------------

    // Every point startup

    public void setparam(){
        FaultCounter = 0;
        PointNumber = PointNumber + 1;

    }

    // check Game ===============================================================================
    public void CheckGame() {
        if (PracticeMode == false) {
            if (!Tie_Breake) {
                if ((Score1[0] == -1) || ((Score1[0] == 4) && (Score2[0] <= 2) && (Score2[0] >= 0))) {
                    Score1[SetNumber + 1] = Score1[SetNumber + 1] + 1;
                    CheckBreak(1);
                    GameOver();
                }

                if ((Score2[0] == -1) || ((Score2[0] == 4) && (Score1[0] <= 2) && (Score1[0] >= 0))) {
                    Score2[SetNumber + 1] = Score2[SetNumber + 1] + 1;
                    CheckBreak(2);
                    GameOver();
                }

                if (Score1[0] == 4) {
                    if (Score2[0] == 3) {
                        Score1[0] = -2;
                    }
                    if (Score2[0] == -2) {
                        Score1[0] = 3;
                        Score2[0] = 3;
                    }
                }
                if (Score2[0] == 4) {
                    if (Score1[0] == 3) {
                        Score2[0] = -2;
                    }
                    if (Score1[0] == -2) {
                        Score2[0] = 3;
                        Score1[0] = 3;
                    }
                }
                if ((Score1[0] == 3) && (Score2[0] == 3)) {
                    Duece = true;
                } else {
                    Duece = false;
                }
            } else {   // on TieBreake calculation point

                if ((Score1[0] >= 7) && (Score1[0] - Score2[0] >= 2)) {
                    Score1[SetNumber + 1] = Score1[SetNumber + 1] + 1;
                    CheckBreak(1);
                    GameOver();
                }
                if ((Score2[0] >= 7) && (Score2[0] - Score1[0] >= 2)) {
                    Score2[SetNumber + 1] = Score2[SetNumber + 1] + 1;
                    CheckBreak(2);
                    GameOver();
                }
                // Service status
                if (((Score1[0] + Score2[0]) % 2) == 1) {
                    if (ServicePlayer == 1) {
                        ServicePlayer = 2;
                    } else {
                        ServicePlayer = 1;
                    }
                }

            }
        } else { // on Practice Mode calculation point
            if ((Score1[0] >= practicegamepoints) && (Score1[0] - Score2[0] >= NetPointsForGame)) {
                Score1[SetNumber + 1] = Score1[SetNumber + 1] + 1;
                CheckBreak(1);
                GameOver();
            }
            if ((Score2[0] >= practicegamepoints) && (Score2[0] - Score1[0] >= NetPointsForGame)) {
                Score2[SetNumber + 1] = Score2[SetNumber + 1] + 1;
                CheckBreak(2);
                GameOver();
            }
            }
        }



        // If Game Is Over ===============================================================================

    public void GameOver() {
        Score1[0] = 0;
        Score2[0] = 0;
        GameNumber = GameNumber + 1;
        PointNumber = 1;
        if (GameNumber % 2 == 0) {
            ServicePlayer = 2;
        } else {
            ServicePlayer = 1;
        }
        CheckSet();
    }

    // check Set ===============================================================================

    public void CheckSet() {

        if ((((Score1[SetNumber + 1] == WinningGames) && Score2[SetNumber + 1] <= WinningGames - 2)) || (Score1[SetNumber + 1] == WinningGames + 1)) {
            SetNumber = SetNumber + 1;
            Score1[1] = Score1[1] + 1;
        }
        if ((((Score2[SetNumber + 1] == WinningGames) && Score1[SetNumber + 1] <= WinningGames - 2)) || (Score2[SetNumber + 1] == WinningGames + 1)) {
            SetNumber = SetNumber + 1;
            Score2[1] = Score2[1] + 1;
        }

        if ((Score1[SetNumber + 1] == WinningGames) && Score2[SetNumber + 1] == WinningGames) {
            Tie_Breake = true;
        } else {
            Tie_Breake = false;
        }

        CheckMatch();
    }

    // check Match ===============================================================================

    public void CheckMatch() {

        if (Score1[1] == WinningSets) {
            winVis(R.id.popupwindow1);
            winVis(R.id.popupwindowFinal);
            changetext(String.valueOf(PlayerName1 + " Winning the Match"), R.id.WinnerNameText);
            DisableAllButton();
        }
        if (Score2[1] == WinningSets) {
            winVis(R.id.popupwindow1);
            winVis(R.id.popupwindowFinal);
            changetext(String.valueOf(PlayerName2 + " Winning the Match"), R.id.WinnerNameText);
            DisableAllButton();
        }

    }

    // check Break ===============================================================================

    public void CheckBreak(int val) {

        if ((val == 1) && (ServicePlayer == 2)) {
            Stats1[3] = Stats1[3] + 1;
        }
        if ((val == 2) && (ServicePlayer == 1)) {
            Stats2[3] = Stats2[3] + 1;
        }
    }

    // check max points ===============================================================================

    public void Checkmaxp1() {
        Stats1[4] = Stats1[4] + 1;
        Stats2[4] = 0;
        if (Stats1[4] > Stats1[5]) {
            Stats1[5] = Stats1[5] + 1;
        }
    }

    public void Checkmaxp2() {
        Stats2[4] = Stats2[4] + 1;
        Stats1[4] = 0;
        if (Stats2[4] > Stats2[5]) {
            Stats2[5] = Stats2[5] + 1;
        }
    }

    //Fill Stats Method -----------------------------------------------------

    public void fillStats() {
        changetext(PlayerName1, R.id.StatsName1);
        changetext(PlayerName2, R.id.StatsName2);
        changetext(String.valueOf("Court Type : " + CourtTypeName[courttype]), R.id.StatsCourtType);
        changetext(String.valueOf(Score1[1]), R.id.StatsSets1);
        changetext(String.valueOf(Score2[1]), R.id.StatsSets2);

        if (WinningSets == 2) {
            changetext(String.valueOf(Score1[2] + " - " + Score2[2]), R.id.StatsGame1);
            changetext(String.valueOf(Score1[3] + " - " + Score2[3]), R.id.StatsGame2);
            changetext(String.valueOf(Score1[4] + " - " + Score2[4]), R.id.StatsGame3);
            txtVis(R.id.StatsGame2);
            txtVis(R.id.StatsTitleGame2);
            txtVis(R.id.StatsGame3);
            txtVis(R.id.StatsTitleGame3);
            txtGon(R.id.StatsGame4);
            txtGon(R.id.StatsTitleGame4);
            txtGon(R.id.StatsGame5);
            txtGon(R.id.StatsTitleGame5);
        } else if (WinningSets == 3) {
            changetext(String.valueOf(Score1[2] + " - " + Score2[2]), R.id.StatsGame1);
            changetext(String.valueOf(Score1[3] + " - " + Score2[3]), R.id.StatsGame2);
            changetext(String.valueOf(Score1[4] + " - " + Score2[4]), R.id.StatsGame3);
            changetext(String.valueOf(Score1[5] + " - " + Score2[5]), R.id.StatsGame4);
            changetext(String.valueOf(Score1[6] + " - " + Score2[6]), R.id.StatsGame5);
            txtVis(R.id.StatsGame2);
            txtVis(R.id.StatsTitleGame2);
            txtVis(R.id.StatsGame3);
            txtVis(R.id.StatsTitleGame3);
            txtVis(R.id.StatsGame4);
            txtVis(R.id.StatsTitleGame4);
            txtVis(R.id.StatsGame5);
            txtVis(R.id.StatsTitleGame5);
        } else {
            changetext(String.valueOf(Score1[2] + " - " + Score2[2]), R.id.StatsGame1);
            txtGon(R.id.StatsGame2);
            txtGon(R.id.StatsTitleGame2);
            txtGon(R.id.StatsGame3);
            txtGon(R.id.StatsTitleGame3);
            txtGon(R.id.StatsGame4);
            txtGon(R.id.StatsTitleGame4);
            txtGon(R.id.StatsGame5);
            txtGon(R.id.StatsTitleGame5);
        }

        changetext(String.valueOf(Stats1[0]), R.id.StatsAces1);
        changetext(String.valueOf(Stats2[0]), R.id.StatsAces2);
        changetext(String.valueOf(Stats1[1]), R.id.StatsWin1);
        changetext(String.valueOf(Stats2[1]), R.id.StatsWin2);
        changetext(String.valueOf(Stats1[2]), R.id.StatsDF1);
        changetext(String.valueOf(Stats2[2]), R.id.StatsDF2);
        changetext(String.valueOf(Stats1[3]), R.id.StatsBr1);
        changetext(String.valueOf(Stats2[3]), R.id.StatsBr2);
        changetext(String.valueOf(Stats1[5]), R.id.StatsCp1);
        changetext(String.valueOf(Stats2[5]), R.id.StatsCp2);
        //set scrollview on top
        ScrollView sv = (ScrollView) findViewById(R.id.statsScrollView);
        sv.scrollTo(0, 0);
    }


    //Display Method -----------------------------------------------------

    public void DisplayMethod() {
        changetext(DisplayedScoreMethod(Score1[0]), score10);
        changetext(DisplayedScoreMethod(Score2[0]), score20);
        changetext(String.valueOf(Score1[1]), score16);
        changetext(String.valueOf(Score1[2]), score11);
        changetext(String.valueOf(Score1[3]), score12);
        changetext(String.valueOf(Score1[4]), score13);
        changetext(String.valueOf(Score1[5]), score14);
        changetext(String.valueOf(Score1[6]), score15);
        changetext(String.valueOf(Score2[1]), score26);
        changetext(String.valueOf(Score2[2]), score21);
        changetext(String.valueOf(Score2[3]), score22);
        changetext(String.valueOf(Score2[4]), score23);
        changetext(String.valueOf(Score2[5]), score24);
        changetext(String.valueOf(Score2[6]), score25);
        if (ServicePlayer == 1) {
            imgVis(R.id.ball1);
            imgInv(R.id.ball2);
        } else {
            imgVis(R.id.ball2);
            imgInv(R.id.ball1);
        }


        if ((Duece)&&(!Tie_Breake)) {
            changetext(getString(R.string.duece),R.id.tiebrake_Duece);
        } else if ((!Duece)&&(Tie_Breake)) {
            changetext(getString(R.string.tiebrake),R.id.tiebrake_Duece);
        }
         else {
            changetext(" ",R.id.tiebrake_Duece);
        }


        changetext(String.valueOf("Game " + GameNumber), R.id.gamenumber);
        checkServiceIcon();
    }

    // Display Score
    public String DisplayedScoreMethod(int val) {
        String temp = "0";
        if ((!Tie_Breake)&&(!PracticeMode)) {
            switch (val) {
                case -2:
                    temp = "ADV";
                    break;
                case 0:
                    temp = "0";
                    break;
                case 1:
                    temp = "15";
                    break;
                case 2:
                    temp = "30";
                    break;
                case 3:
                    temp = "40";
                    break;
            }
        } else {
            temp = String.valueOf(val);
        }
        return temp;
    }

    // reset parameters

    public void resetall() {
        int i;
        for (i = 0; i <= 6; i = i + 1) {
            Score1[i] = 0;
            Score2[i] = 0;
            Score1B[i] = 0;
            Score2B[i] = 0;
        }
        for (i = 0; i <= StatsTableSize-1; i = i + 1) {
            Stats1[i] = 0;
            Stats2[i] = 0;
            Stats1B[i] = 0;
            Stats2B[i] = 0;
        }
        UndoStatus = false;
        UndoButtonStatus(UndoStatus);
        Duece = false;
        Tie_Breake = false;
        GameNumber = 1;
        SetNumber = 1;
        FaultCounter = 0;
        ServicePlayer = 1;
        PointNumber = 1;
    }

    // Backup parameters

    public void UndoBackup() {
        int i;
        for (i = 0; i <= 6; i = i + 1) {
            Score1B[i] = Score1[i];
            Score2B[i] = Score2[i];
        }
        for (i = 0; i <= StatsTableSize-1; i = i + 1) {
            Stats1B[i] = Stats1[i];
            Stats2B[i] = Stats2[i];
        }
        UndoStatus = true;
        UndoButtonStatus(UndoStatus);
        DueceB = Duece;
        Tie_BreakeB = Tie_Breake;
        GameNumberB = GameNumber;
        SetNumberB = SetNumber;
        FaultCounterB = FaultCounter;
        ServicePlayerB = ServicePlayer;
        PointNumberB = PointNumber;
    }

    // Restore parameters

    public void UndoRestore() {
        int i;
        for (i = 0; i <= 6; i = i + 1) {
            Score1[i] = Score1B[i];
            Score2[i] = Score2B[i];
        }
        for (i = 0; i <= StatsTableSize-1; i = i + 1) {
            Stats1[i] = Stats1B[i];
            Stats2[i] = Stats2B[i];
        }
        UndoStatus = false;
        UndoButtonStatus(UndoStatus);
        Duece = DueceB;
        Tie_Breake = Tie_BreakeB;
        GameNumber = GameNumberB;
        SetNumber = SetNumberB;
        FaultCounter = FaultCounterB;
        ServicePlayer = ServicePlayerB;
        PointNumber = PointNumberB;
    }

    // Check Service Icon ============================================================================

    public void checkServiceIcon() {
        if (!Tie_Breake) {
            if ((GameNumber % 4 == 1) || (GameNumber % 4 == 2)) { //player 1 Right and player 2 Left
                if (PointNumber % 2 == 1) {
                    showIcon(3);
                } else {
                    showIcon(1);
                }
            } else //player 2 Right and player 1 Left
            {
                if (PointNumber % 2 == 1) {
                    showIcon(2);
                } else {
                    showIcon(4);
                }

            }
        } else {
            //player 1 Right and player 2 Left
            if (((GameNumber % 4 == 1) || (GameNumber % 4 == 2)) && (PointNumber % 12 <= 6) && (PointNumber % 12 != 0)) {
                if (PointNumber % 2 == 1) {
                    showIcon(3);
                } else {
                    showIcon(1);
                }
            }//player 1 Right and player 2 Left
            else if (((GameNumber % 4 == 0) || (GameNumber % 4 == 3)) && ((PointNumber % 12 > 6) || (PointNumber % 12 == 0))) {
                if (PointNumber % 2 == 1) {
                    showIcon(3);
                } else {
                    showIcon(1);
                }
            } else {
                if (PointNumber % 2 == 1) {
                    showIcon(2);
                } else {
                    showIcon(4);
                }

            }

        }

    }

    // Service Icon Show ... ---------------------------------------------

    public void showIcon(int val) {
        goneAllIcon();
        if (val == 1) {
            if (ServicePlayer == 1) {
                imgVis(R.id.ser_p1_11);
                imgVis(R.id.wait_p2_22);
            } else {
                imgVis(R.id.ser_p2_22);
                imgVis(R.id.wait_p1_11);
            }
        } else if (val == 2) {
            if (ServicePlayer == 1) {
                imgVis(R.id.ser_p1_12);
                imgVis(R.id.wait_p2_21);
            } else {
                imgVis(R.id.ser_p2_21);
                imgVis(R.id.wait_p1_12);
            }
        } else if (val == 3) {
            if (ServicePlayer == 1) {
                imgVis(R.id.ser_p1_21);
                imgVis(R.id.wait_p2_12);
            } else {
                imgVis(R.id.ser_p2_12);
                imgVis(R.id.wait_p1_21);
            }
        } else {
            if (ServicePlayer == 1) {
                imgVis(R.id.ser_p1_22);
                imgVis(R.id.wait_p2_11);
            } else {
                imgVis(R.id.ser_p2_11);
                imgVis(R.id.wait_p1_22);
            }
        }
    }

    public void goneAllIcon() {
        imgGone(R.id.ser_p1_11);
        imgGone(R.id.ser_p1_12);
        imgGone(R.id.ser_p1_21);
        imgGone(R.id.ser_p1_22);
        imgGone(R.id.wait_p1_11);
        imgGone(R.id.wait_p1_12);
        imgGone(R.id.wait_p1_21);
        imgGone(R.id.wait_p1_22);
        imgGone(R.id.ser_p2_11);
        imgGone(R.id.ser_p2_12);
        imgGone(R.id.ser_p2_21);
        imgGone(R.id.ser_p2_22);
        imgGone(R.id.wait_p2_11);
        imgGone(R.id.wait_p2_12);
        imgGone(R.id.wait_p2_21);
        imgGone(R.id.wait_p2_22);
    }

    // set button UNDO enabled - disabled

    public void UndoButtonStatus(boolean val) {
        Button btn = (Button) findViewById(R.id.undo);
        btn.setEnabled(val);
    }

    // set button enabled - disabled

    public void butEn(int val) {
        Button btn = (Button) findViewById(val);
        btn.setEnabled(true);
    }

    public void butDis(int val) {
        Button btn = (Button) findViewById(val);
        btn.setEnabled(false);
    }

    // All button enabled

    public void EnableAllButton() {
        butEn(R.id.point1);
        butEn(R.id.point2);
        butEn(R.id.winner1);
        butEn(R.id.winner2);
        butEn(R.id.ace);
        butEn(R.id.fault);
        butEn(R.id.restartb);
        butEn(R.id.stats);
    }

    public void DisableAllButton() {
        butDis(R.id.point1);
        butDis(R.id.point2);
        butDis(R.id.winner1);
        butDis(R.id.winner2);
        butDis(R.id.ace);
        butDis(R.id.fault);
        butDis(R.id.restartb);
        butDis(R.id.stats);
    }

    // Set court void ... ------------------------------------------------
    public void setcourt(String val) {
        RelativeLayout court = (RelativeLayout) findViewById(R.id.activity_main);
        court.setBackgroundColor(Color.parseColor(val));
    }

    // Set Window Visible - Invisible... --------------------------------
    public void winInv(int val) {
        LinearLayout popup = (LinearLayout) findViewById(val);
        popup.setVisibility(View.INVISIBLE);
    }

    public void winVis(int val) {
        LinearLayout popup = (LinearLayout) findViewById(val);
        popup.setVisibility(View.VISIBLE);
    }

   // Set a Button Visible - Gone ----------------------------------------
    public void butVis(int val) {
        Button btn = (Button) findViewById(val);
        btn.setVisibility(Button.VISIBLE);
    }

    public void butInv(int val) {
        Button btn = (Button) findViewById(val);
        btn.setVisibility(Button.GONE);
    }

    // Set a Images Visible - Invisible - Gone ... ----------------------------------------
    public void imgVis(int val) {
        ImageView img = (ImageView) findViewById(val);
        img.setVisibility(ImageView.VISIBLE);
    }

    public void imgInv(int val) {
        ImageView img = (ImageView) findViewById(val);
        img.setVisibility(ImageView.INVISIBLE);
    }

    public void imgGone(int val) {
        ImageView img = (ImageView) findViewById(val);
        img.setVisibility(ImageView.GONE);
    }

    // Set a Text Visible - Invisible ... ----------------------------------------
    public void txtVis(int val) {
        TextView txt = (TextView) findViewById(val);
        txt.setVisibility(TextView.VISIBLE);
    }

    public void txtInv(int val) {
        TextView txt = (TextView) findViewById(val);
        txt.setVisibility(TextView.INVISIBLE);
    }

    public void txtGon(int val) {
        TextView txt = (TextView) findViewById(val);
        txt.setVisibility(TextView.GONE);
    }

    // Text changer ----------------------------------------------------
    public void changetext(String what, int where) {
        TextView newtext = (TextView) findViewById(where);
        newtext.setText(String.valueOf(what));
    }

}
